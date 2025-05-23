package com.tencent.mobileqq.zplan.avatar.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager;
import com.tencent.mobileqq.zplan.meme.api.IMemeHelper;
import com.tencent.mobileqq.zplan.servlet.m;
import com.tencent.mobileqq.zplan.utils.ah;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.meme.model.MemeResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes35.dex */
public class ZPlanAvatarFileManagerImpl implements IZPlanAvatarFileManager {
    private static final String TAG = "[zplan]ZPlanAvatarFileManagerImpl";
    private static final String VIDEO_DIR_PATH = "/video/";
    private boolean mUseZPlanApngAvatar;
    private ConcurrentHashMap<Integer, List<String>> mActionFramesMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, String> mActionVideoMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, String> mActionCoverMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, String> mActionApngMap = new ConcurrentHashMap<>();
    private Lock mLock = new ReentrantLock();
    private m mUserAppearanceChgObserver = new a();

    /* loaded from: classes35.dex */
    class a extends m {
        a() {
        }

        @Override // com.tencent.mobileqq.zplan.servlet.m
        public void a(boolean z16, List<String> list) {
            QQAppInterface l3;
            super.a(z16, list);
            QLog.i(ZPlanAvatarFileManagerImpl.TAG, 1, "onUserAppearanceChg, success:" + z16 + ", uinList:" + list);
            if (!z16 || list.isEmpty() || (l3 = bb.f335811a.l()) == null || !list.contains(l3.getCurrentUin())) {
                return;
            }
            QLog.i(ZPlanAvatarFileManagerImpl.TAG, 1, "user appearance changed, do reset.");
            ZPlanAvatarFileManagerImpl.this.reset();
        }
    }

    public ZPlanAvatarFileManagerImpl() {
        AppInterface c16 = bb.f335811a.c();
        if (c16 != null) {
            c16.addObserver(this.mUserAppearanceChgObserver);
        }
        this.mUseZPlanApngAvatar = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableZPlanApngAvatar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> tryGetFrameFilesFromDisk(String str) {
        File[] listFiles;
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2.getAbsolutePath());
                }
            }
            if (arrayList.size() > 0) {
                QLog.i(TAG, 2, "tryGetFrameFilesFormDisk fileList: " + arrayList.size());
                return arrayList;
            }
        }
        QLog.e(TAG, 1, "tryGetFrameFilesFormDisk files is null");
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager
    public void getAllFrameFiles(int i3, String str, int i16, int i17, IZPlanAvatarFileManager.a aVar) {
        List<String> list = this.mActionFramesMap.get(Integer.valueOf(i3));
        if (list != null && list.size() > 0) {
            QLog.i(TAG, 1, "getAllFrameFiles from mActionFramesMap, filePathList: " + list.size());
            aVar.a(true, list, i3);
            return;
        }
        MODE mode = MODE.GIF;
        if (this.mUseZPlanApngAvatar) {
            mode = MODE.APNG;
        }
        int B2 = ZPlanFeatureSwitch.f369852a.B2();
        MemeZPlanAction memeZPlanAction = new MemeZPlanAction(i3, -1, B2, B2, mode, str);
        memeZPlanAction.getConfig().E(true);
        memeZPlanAction.getConfig().y(ah.f335763c);
        ((IMemeHelper) QRoute.api(IMemeHelper.class)).recordAction(memeZPlanAction, new b(i3, aVar));
        QLog.i(TAG, 2, "getAllFrameFiles MemeHelper#recordAction, portraitId:" + i3);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager
    public String getApngFilePath(int i3) {
        String str = this.mActionApngMap.get(Integer.valueOf(i3));
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        QLog.e(TAG, 1, "getApngFilePath portraitId:" + i3 + "apngPath is null");
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager
    public void getSingleFrameFile(int i3, String str, IZPlanAvatarFileManager.a aVar) {
        int B2 = ZPlanFeatureSwitch.f369852a.B2();
        getSingleFrameFile(i3, str, B2, B2, aVar);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager
    public String getVideoFilePath(int i3) {
        String str = this.mActionVideoMap.get(Integer.valueOf(i3));
        if (str != null) {
            return str;
        }
        QLog.e(TAG, 1, "getVideoFilePath portraitId:" + i3 + "videopath is null");
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager
    public void putAction2ApngFilePath(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "putAction2ApngFilePath error, filePath is null.");
            return;
        }
        this.mLock.lock();
        try {
            this.mActionApngMap.put(Integer.valueOf(i3), str);
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager
    public void putAction2VideoFilePath(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "putAction2VideoFilePath error, filePath null.");
            return;
        }
        this.mLock.lock();
        try {
            this.mActionVideoMap.put(Integer.valueOf(i3), str);
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager
    public void recordDynamicAvatar(int i3, String str, int i16, int i17, com.tencent.zplan.meme.a aVar) {
        MemeZPlanAction memeZPlanAction;
        if (this.mUseZPlanApngAvatar) {
            memeZPlanAction = new MemeZPlanAction(i3, -1, i16, i17, MODE.APNG, str);
            memeZPlanAction.getConfig().E(true);
        } else {
            memeZPlanAction = new MemeZPlanAction(i3, -1, i16, i17, MODE.GIF, str);
        }
        memeZPlanAction.getConfig().y(ah.f335763c);
        memeZPlanAction.getConfig().M(false);
        ((IMemeHelper) QRoute.api(IMemeHelper.class)).recordAction(memeZPlanAction, aVar);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager
    public void recordStaticAvatar(int i3, String str, int i16, int i17, com.tencent.zplan.meme.a aVar) {
        IMemeHelper iMemeHelper = (IMemeHelper) QRoute.api(IMemeHelper.class);
        MemeZPlanAction memeZPlanAction = new MemeZPlanAction(i3, -1, i16, i17, MODE.FRAME, str);
        memeZPlanAction.getConfig().y(ah.f335763c);
        memeZPlanAction.getConfig().C(BusinessConfig.FrameType.JPG);
        memeZPlanAction.setFrameTime(iMemeHelper.adapterToBrickFrameInterval(ZPlanFeatureSwitch.f369852a.u2()));
        iMemeHelper.recordAction(memeZPlanAction, aVar);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager
    public void reset() {
        this.mLock.lock();
        try {
            QLog.i(TAG, 1, "reset!");
            if (this.mActionVideoMap.size() != 0) {
                QLog.i(TAG, 2, "delVideo start.");
                this.mActionVideoMap.clear();
            }
            if (this.mActionCoverMap.size() != 0) {
                QLog.i(TAG, 2, "delCover start.");
                this.mActionCoverMap.clear();
            }
            if (this.mActionFramesMap.size() != 0) {
                QLog.i(TAG, 2, "delFrames start.");
                this.mActionFramesMap.clear();
            }
            if (this.mActionApngMap.size() != 0) {
                QLog.i(TAG, 2, "delApng start.");
                this.mActionApngMap.clear();
            }
            this.mLock.unlock();
            AppInterface c16 = bb.f335811a.c();
            if (c16 != null) {
                c16.removeObserver(this.mUserAppearanceChgObserver);
            }
            QLog.w(TAG, 1, "avatar reset done.");
        } catch (Throwable th5) {
            this.mLock.unlock();
            throw th5;
        }
    }

    public void getSingleFrameFile(int i3, String str, int i16, int i17, IZPlanAvatarFileManager.a aVar) {
        String str2 = this.mActionCoverMap.get(Integer.valueOf(i3));
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (file.isFile() && file.exists()) {
                arrayList.add(str2);
                if (aVar != null) {
                    aVar.a(true, arrayList, i3);
                }
                QLog.i(TAG, 1, "getSingleFrameFile from mActionCoverMap, filePathList: " + arrayList.size());
                return;
            }
        }
        IMemeHelper iMemeHelper = (IMemeHelper) QRoute.api(IMemeHelper.class);
        MemeZPlanAction memeZPlanAction = new MemeZPlanAction(i3, -1, i16, i17, MODE.FRAME, str);
        memeZPlanAction.getConfig().C(BusinessConfig.FrameType.JPG);
        memeZPlanAction.getConfig().y(ah.f335763c);
        memeZPlanAction.setFrameTime(iMemeHelper.adapterToBrickFrameInterval(ZPlanFeatureSwitch.f369852a.u2()));
        iMemeHelper.recordAction(memeZPlanAction, new c(i3, arrayList, aVar));
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager
    public void putAction2FrameFilePath(int i3, List<String> list) {
        if (list != null && list.size() != 0) {
            this.mLock.lock();
            try {
                this.mActionFramesMap.put(Integer.valueOf(i3), list);
                return;
            } finally {
                this.mLock.unlock();
            }
        }
        QLog.e(TAG, 1, "putAction2FrameFilePath error, filrPathList null.");
    }

    /* loaded from: classes35.dex */
    class b implements com.tencent.zplan.meme.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f331517d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IZPlanAvatarFileManager.a f331518e;

        b(int i3, IZPlanAvatarFileManager.a aVar) {
            this.f331517d = i3;
            this.f331518e = aVar;
        }

        @Override // com.tencent.zplan.meme.a
        public void l9(boolean z16, MemeResult memeResult) {
            List<String> list;
            String recordKey = memeResult.getRecordKey();
            MODE mode = memeResult.getAction().getMode();
            String recordPath = memeResult.getRecordPath();
            String v3 = Meme.f385754h.v(recordKey, mode);
            if (z16) {
                list = memeResult.f();
                if (list != null && list.size() > 0) {
                    QLog.i(ZPlanAvatarFileManagerImpl.TAG, 1, "getAllFrameFiles onRecordDone success, filePathList: " + list.size());
                }
            } else {
                list = null;
            }
            if (list == null || list.size() == 0) {
                list = ZPlanAvatarFileManagerImpl.this.tryGetFrameFilesFromDisk(v3);
            }
            if (list != null && list.size() > 0) {
                ZPlanAvatarFileManagerImpl.this.putAction2FrameFilePath(this.f331517d, list);
                if (mode == MODE.APNG && TextUtils.isEmpty(recordPath)) {
                    ZPlanAvatarFileManagerImpl.this.putAction2ApngFilePath(this.f331517d, recordPath);
                } else {
                    ZPlanAvatarFileManagerImpl.this.putAction2VideoFilePath(this.f331517d, v3 + ZPlanAvatarFileManagerImpl.VIDEO_DIR_PATH);
                }
                this.f331518e.a(true, list, this.f331517d);
                return;
            }
            this.f331518e.a(false, null, this.f331517d);
            QLog.e(ZPlanAvatarFileManagerImpl.TAG, 1, "getAllFrameFiles onRecordDone success:" + z16 + ", but failed to find frameFiles");
        }

        @Override // com.tencent.zplan.meme.a
        public void d3(MemeAction memeAction, float f16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class c implements com.tencent.zplan.meme.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f331520d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f331521e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IZPlanAvatarFileManager.a f331522f;

        c(int i3, List list, IZPlanAvatarFileManager.a aVar) {
            this.f331520d = i3;
            this.f331521e = list;
            this.f331522f = aVar;
        }

        @Override // com.tencent.zplan.meme.a
        public void l9(boolean z16, MemeResult memeResult) {
            String recordPath = memeResult.getRecordPath();
            if (z16 && !TextUtils.isEmpty(recordPath)) {
                ZPlanAvatarFileManagerImpl.this.mLock.lock();
                try {
                    ZPlanAvatarFileManagerImpl.this.mActionCoverMap.put(Integer.valueOf(this.f331520d), recordPath);
                    ZPlanAvatarFileManagerImpl.this.mLock.unlock();
                    this.f331521e.add(recordPath);
                    IZPlanAvatarFileManager.a aVar = this.f331522f;
                    if (aVar != null) {
                        aVar.a(true, this.f331521e, this.f331520d);
                    }
                    QLog.i(ZPlanAvatarFileManagerImpl.TAG, 1, "getSingleFrameFile from MemeHelper success, filePathList: " + this.f331521e.size());
                    return;
                } catch (Throwable th5) {
                    ZPlanAvatarFileManagerImpl.this.mLock.unlock();
                    throw th5;
                }
            }
            IZPlanAvatarFileManager.a aVar2 = this.f331522f;
            if (aVar2 != null) {
                aVar2.a(false, null, this.f331520d);
            }
            QLog.e(ZPlanAvatarFileManagerImpl.TAG, 1, "getSingleFrameFile from MemeHelper fail");
        }

        @Override // com.tencent.zplan.meme.a
        public void d3(MemeAction memeAction, float f16) {
        }
    }
}
