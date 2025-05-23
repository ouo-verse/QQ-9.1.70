package com.tencent.biz.qqcircle.picload.avatar;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.avatarinfo.QQHeadUrl;
import com.tencent.biz.qcircleshadow.handler.QCircleHandler;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.libra.thread.LibraThreadExecutor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.IQCircleResDrawableApi;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qcircle.tempapi.avatar.IAvatarListener;
import com.tencent.mobileqq.qcircle.tempapi.avatar.QCircleAvatarInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import org.jf.dexlib2.analysis.RegisterType;
import uq3.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleAvatarLoader {
    private static final int AVATAR_QUALITY_100 = 100;
    private static final int AVATAR_QUALITY_140 = 140;
    private static final int AVATAR_QUALITY_40 = 40;
    private static final int AVATAR_QUALITY_640 = 640;
    private static final String AVATAR_QUALITY_KEY = "&s=";
    private static final String TAG = "QCircleAvatarLoader";
    private static final long TIME_STAMP = 86400000;
    private static volatile QCircleAvatarLoader sInstance;
    private final IQCircleResDrawableApi mCircleResDrawableApi;
    private EntityManager mEm;
    private ThreadPoolExecutor mLoadExecutor;
    private ThreadPoolExecutor mPreloadExecutor;
    private ConcurrentHashMap<String, String> mRequestIngMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, QCircleAvatarInfo> mResultInfoMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, QCircleAvatarCheckTask> mCheckTask = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, ConcurrentHashMap<Integer, AvatarOption>> mTogetherOptions = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class QCircleAvatarCheckTask implements Runnable {
        private EntityManager mEm;
        private QCirclePicStateListener mListener;
        private AvatarOption mOption;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes4.dex */
        public class a implements IAvatarListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AvatarOption f91588a;

            a(AvatarOption avatarOption) {
                this.f91588a = avatarOption;
            }

            @Override // com.tencent.mobileqq.qcircle.tempapi.avatar.IAvatarListener
            public void onAvatarBack(boolean z16, int i3, QCircleAvatarInfo qCircleAvatarInfo) {
                if (z16) {
                    QCircleAvatarCheckTask.this.updateToDataBase(qCircleAvatarInfo);
                    QCircleAvatarCheckTask.this.loadPicByPicLoad(this.f91588a, qCircleAvatarInfo);
                    if (QCircleAvatarLoader.this.mTogetherOptions.containsKey(this.f91588a.getUin())) {
                        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) QCircleAvatarLoader.this.mTogetherOptions.get(this.f91588a.getUin());
                        Iterator it = concurrentHashMap.keySet().iterator();
                        while (it.hasNext()) {
                            QCircleAvatarCheckTask.this.loadPicByPicLoad((AvatarOption) concurrentHashMap.remove((Integer) it.next()), qCircleAvatarInfo);
                        }
                    }
                } else {
                    QLog.d(QCircleAvatarLoader.TAG, 1, "seq = " + QCircleAvatarCheckTask.this.mOption.getSeq() + "  from server failed, retCode:" + i3);
                    QCircleAvatarCheckTask.this.callFailed(this.f91588a.getUin(), this.f91588a);
                }
                QCircleAvatarLoader.this.mRequestIngMap.remove(this.f91588a.getUin());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes4.dex */
        public class b extends QCirclePicStateListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QCircleAvatarInfo f91590d;

            b(QCircleAvatarInfo qCircleAvatarInfo) {
                this.f91590d = qCircleAvatarInfo;
            }

            @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
            public void onStateChange(LoadState loadState, Option option) {
                super.onStateChange(loadState, option);
                if (loadState == LoadState.STATE_SUCCESS) {
                    QCircleAvatarCheckTask.this.callSuccess(this.f91590d.getUin(), option);
                } else if (loadState == LoadState.STATE_DECODE_FAILED || loadState == LoadState.STATE_DOWNLOAD_FAILED) {
                    QCircleAvatarCheckTask.this.callFailed(this.f91590d.getUin(), option);
                }
                if (QCircleAvatarCheckTask.this.mListener != null) {
                    QCircleAvatarCheckTask.this.mListener.onStateChange(loadState, option);
                }
            }
        }

        public QCircleAvatarCheckTask(AvatarOption avatarOption, EntityManager entityManager, QCirclePicStateListener qCirclePicStateListener) {
            this.mOption = avatarOption;
            this.mEm = entityManager;
            this.mListener = qCirclePicStateListener;
        }

        private void addToTogether(AvatarOption avatarOption) {
            if (QCircleAvatarLoader.this.mTogetherOptions.get(avatarOption.getUin()) != null) {
                ((ConcurrentHashMap) QCircleAvatarLoader.this.mTogetherOptions.get(avatarOption.getUin())).put(Integer.valueOf(avatarOption.hashCode()), avatarOption);
                return;
            }
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put(Integer.valueOf(avatarOption.hashCode()), avatarOption);
            QCircleAvatarLoader.this.mTogetherOptions.put(avatarOption.getUin(), concurrentHashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void callFailed(String str, Option option) {
            if (QCircleAvatarLoader.this.mTogetherOptions.containsKey(str)) {
                ((ConcurrentHashMap) QCircleAvatarLoader.this.mTogetherOptions.get(str)).clear();
            }
            QCircleAvatarLoader.this.mCheckTask.remove(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void callSuccess(String str, Option option) {
            QCircleAvatarLoader.this.mCheckTask.remove(str);
        }

        private long computeTimeSpan(QCircleAvatarInfo qCircleAvatarInfo) {
            long j3;
            if (qCircleAvatarInfo == null) {
                return System.currentTimeMillis();
            }
            String timestamp = qCircleAvatarInfo.getTimestamp();
            if (!TextUtils.isEmpty(timestamp)) {
                j3 = Long.parseLong(timestamp);
            } else {
                j3 = 0;
            }
            return System.currentTimeMillis() - j3;
        }

        private IAvatarListener createListener(AvatarOption avatarOption) {
            return new a(avatarOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void loadPicByPicLoad(AvatarOption avatarOption, QCircleAvatarInfo qCircleAvatarInfo) {
            if (qCircleAvatarInfo != null && avatarOption != null) {
                if (c.i6()) {
                    updateUrl(avatarOption, qCircleAvatarInfo);
                }
                avatarOption.setUrl(qCircleAvatarInfo.getDownLoadUrl());
                if (avatarOption.getUrlListener() != null) {
                    avatarOption.getUrlListener().onAvatarUrl(qCircleAvatarInfo.getDownLoadUrl());
                }
                QCircleFeedPicLoader.g().loadImage(avatarOption, new b(qCircleAvatarInfo));
            }
        }

        private QCircleAvatarInfo queryInfoFromDataBase(AvatarOption avatarOption) {
            QCircleAvatarInfo qCircleAvatarInfo;
            if (avatarOption == null) {
                return null;
            }
            synchronized (this.mEm) {
                try {
                    try {
                        qCircleAvatarInfo = (QCircleAvatarInfo) DBMethodProxy.find(this.mEm, (Class<? extends Entity>) QCircleAvatarInfo.class, avatarOption.getUin());
                    } catch (Exception unused) {
                        return null;
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            return qCircleAvatarInfo;
        }

        private void requestServer(AvatarOption avatarOption) {
            if (avatarOption == null) {
                return;
            }
            if (QCircleAvatarLoader.this.mRequestIngMap.containsKey(avatarOption.getUin())) {
                addToTogether(avatarOption);
                QLog.d(QCircleAvatarLoader.TAG, 1, "seq = " + this.mOption.getSeq() + "  on requesting return ");
                return;
            }
            QCircleAvatarLoader.this.mRequestIngMap.put(avatarOption.getUin(), avatarOption.getUin());
            QCircleHandler qCircleHandler = QCircleHandler.getQCircleHandler();
            if (qCircleHandler != null) {
                ToServiceMsg createToServiceMsg = qCircleHandler.createToServiceMsg(FaceConstant.AvatarHandlerCmd.CMD_GETQQHEAD_NEW);
                QQHeadUrl.QQHeadUrlReq qQHeadUrlReq = new QQHeadUrl.QQHeadUrlReq();
                qQHeadUrlReq.srcUsrType.set(1);
                qQHeadUrlReq.srcUin.set(QCircleCommonUtil.getCurrentAccountLongUin());
                qQHeadUrlReq.dstUsrType.set(1);
                QQHeadUrl.ReqUsrInfo reqUsrInfo = new QQHeadUrl.ReqUsrInfo();
                try {
                    reqUsrInfo.dstUin.set(Long.parseLong(avatarOption.getUin()));
                } catch (Exception unused) {
                }
                reqUsrInfo.timestamp.set(0);
                qQHeadUrlReq.dstUsrInfos.add(reqUsrInfo);
                createToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
                createToServiceMsg.extraData.putInt("dstUsrType", 1);
                createToServiceMsg.extraData.putString("dstUin", avatarOption.getUin());
                createToServiceMsg.extraData.putBoolean("qcircle", true);
                createToServiceMsg.putWupBuffer(qQHeadUrlReq.toByteArray());
                qCircleHandler.registerAvatarListener(avatarOption.getUin(), createListener(avatarOption));
                qCircleHandler.sendPbReq(createToServiceMsg);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateToDataBase(QCircleAvatarInfo qCircleAvatarInfo) {
            if (qCircleAvatarInfo == null) {
                return;
            }
            synchronized (this.mEm) {
                qCircleAvatarInfo.setStatus(1000);
                this.mEm.persistOrReplace(qCircleAvatarInfo);
            }
        }

        private void updateUrl(AvatarOption avatarOption, QCircleAvatarInfo qCircleAvatarInfo) {
            int max = Math.max(avatarOption.getRequestWidth(), avatarOption.getRequestHeight());
            int i3 = 140;
            if (max > 140 && (qCircleAvatarInfo.dwFaceFlag & RegisterType.UNINIT_REF) == 16) {
                i3 = 640;
            } else if (max <= 100 || (qCircleAvatarInfo.dwFaceFlag & 8) != 8) {
                i3 = 40;
                if (max > 40 && (qCircleAvatarInfo.dwFaceFlag & 4) == 4) {
                    i3 = 100;
                }
            }
            qCircleAvatarInfo.setDownLoadUrl(qCircleAvatarInfo.mDownLoadUrl.replaceAll("(&s=[^&]*)", QCircleAvatarLoader.AVATAR_QUALITY_KEY + i3));
        }

        @Override // java.lang.Runnable
        public void run() {
            long parseLong;
            QCircleAvatarInfo qCircleAvatarInfo = (QCircleAvatarInfo) QCircleAvatarLoader.this.mResultInfoMap.get(this.mOption.getUin());
            if (qCircleAvatarInfo == null) {
                qCircleAvatarInfo = queryInfoFromDataBase(this.mOption);
            }
            if (qCircleAvatarInfo == null) {
                requestServer(this.mOption);
                return;
            }
            if (computeTimeSpan(qCircleAvatarInfo) < 86400000 && !TextUtils.isEmpty(qCircleAvatarInfo.getDownLoadUrl())) {
                loadPicByPicLoad(this.mOption, qCircleAvatarInfo);
                return;
            }
            AvatarOption avatarOption = this.mOption;
            if (TextUtils.isEmpty(qCircleAvatarInfo.getTimestamp())) {
                parseLong = 0;
            } else {
                parseLong = Long.parseLong(qCircleAvatarInfo.getTimestamp());
            }
            avatarOption.setTimeStamp(parseLong);
            requestServer(this.mOption);
        }
    }

    QCircleAvatarLoader() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int i3 = (availableProcessors * 2) + 1;
        this.mPreloadExecutor = LibraThreadExecutor.createPool(availableProcessors, i3);
        this.mLoadExecutor = LibraThreadExecutor.createPool(availableProcessors, i3);
        this.mCircleResDrawableApi = (IQCircleResDrawableApi) QRoute.api(IQCircleResDrawableApi.class);
        initEm();
    }

    private boolean checkDoubleLoad(AvatarOption avatarOption) {
        ImageView targetView;
        if (avatarOption == null) {
            targetView = null;
        } else {
            targetView = avatarOption.getTargetView();
        }
        if (targetView == null) {
            return false;
        }
        String uin = avatarOption.getUin();
        Object tag = targetView.getTag(R.id.qcircle_avatar_tag_id);
        if (tag instanceof String) {
            if (((String) tag).equals(uin)) {
                return true;
            }
            targetView.setTag(R.id.qcircle_avatar_tag_id, uin);
            return false;
        }
        targetView.setTag(R.id.qcircle_avatar_tag_id, uin);
        return false;
    }

    private void checkDownLoad(AvatarOption avatarOption, QCirclePicStateListener qCirclePicStateListener) {
        QCircleAvatarCheckTask qCircleAvatarCheckTask = new QCircleAvatarCheckTask(avatarOption, this.mEm, qCirclePicStateListener);
        this.mCheckTask.put(avatarOption.getUin(), qCircleAvatarCheckTask);
        if (avatarOption.isFromPreload()) {
            this.mPreloadExecutor.execute(qCircleAvatarCheckTask);
        } else {
            this.mLoadExecutor.execute(qCircleAvatarCheckTask);
        }
    }

    public static QCircleAvatarLoader g() {
        if (sInstance == null) {
            synchronized (QCircleAvatarLoader.class) {
                if (sInstance == null) {
                    sInstance = new QCircleAvatarLoader();
                }
            }
        }
        return sInstance;
    }

    private EntityManager initEm() {
        try {
            EntityManager entityManager = QCircleHostStubUtil.getEntityManager();
            this.mEm = entityManager;
            return entityManager;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getmEm " + e16);
            return null;
        }
    }

    public void loadAvatar(AvatarOption avatarOption) {
        loadAvatar(avatarOption, null);
    }

    public void release() {
        this.mRequestIngMap.clear();
        this.mResultInfoMap.clear();
        this.mCheckTask.clear();
        this.mTogetherOptions.clear();
        this.mPreloadExecutor.getQueue().clear();
        this.mLoadExecutor.getQueue().clear();
        if (QCircleHandler.getQCircleHandler() != null) {
            QCircleHandler.getQCircleHandler().clearAvatarListener();
        }
    }

    public void loadAvatar(AvatarOption avatarOption, QCirclePicStateListener qCirclePicStateListener) {
        if (avatarOption == null) {
            return;
        }
        if (!TextUtils.isEmpty(avatarOption.getUrl())) {
            QCircleFeedPicLoader.g().loadImage(avatarOption, qCirclePicStateListener);
            return;
        }
        if (checkDoubleLoad(avatarOption)) {
            return;
        }
        ImageView targetView = avatarOption.getTargetView();
        if (targetView != null) {
            targetView.setImageDrawable(this.mCircleResDrawableApi.getDrawable(R.drawable.f160830com));
        }
        avatarOption.mStartTime = Long.valueOf(System.currentTimeMillis());
        avatarOption.setPicType(3);
        if (avatarOption.isFromPreload()) {
            if (this.mCheckTask.containsKey(avatarOption.getUin())) {
                QLog.d(TAG, 1, "seq = " + avatarOption.getSeq() + "  load return, has check already");
                return;
            }
            return;
        }
        checkDownLoad(avatarOption, qCirclePicStateListener);
    }
}
