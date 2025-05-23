package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.util.HeadRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FaceDecoderImpl extends FaceDecoderBase implements DecodeCompletionListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Q.qqhead.FaceDecoderImpl";
    private WeakReference<AppInterface> mAppRef;
    private MyAvatarObserver mAvatarObserver;
    private MyDiscussionObserver mDiscussObserver;
    private MyTroopHeaderObserver mTroopHeaderObserver;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class MyAvatarObserver extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;
        private final WeakReference<FaceDecoderImpl> mOutRef;

        public MyAvatarObserver(FaceDecoderImpl faceDecoderImpl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) faceDecoderImpl);
            } else {
                this.mOutRef = new WeakReference<>(faceDecoderImpl);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateApolloHead(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
            } else {
                if (this.mOutRef.get() == null) {
                    return;
                }
                this.mOutRef.get().onUpdateHead(z16, 116, str, 200, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else {
                if (this.mOutRef.get() == null) {
                    return;
                }
                this.mOutRef.get().onUpdateHead(z16, 1, str, 0, 0);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateMobileQQHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
            } else {
                if (this.mOutRef.get() == null) {
                    return;
                }
                this.mOutRef.get().onUpdateHead(z16, 11, str, 0, 0);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateQCallHead(boolean z16, String str, int i3, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Boolean.valueOf(z17));
            } else {
                if (this.mOutRef.get() == null) {
                    return;
                }
                this.mOutRef.get().onUpdateHead(z16, 16, str, i3, 0);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateStrangerHead(boolean z16, String str, int i3, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Boolean.valueOf(z17));
            } else {
                if (this.mOutRef.get() == null) {
                    return;
                }
                this.mOutRef.get().onUpdateHead(z16, 32, str, i3, 0);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateTroopHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str);
            } else {
                if (this.mOutRef.get() == null) {
                    return;
                }
                this.mOutRef.get().onUpdateHead(z16, 4, str, 0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class MyDiscussionObserver extends com.tencent.mobileqq.avatar.observer.b {
        static IPatchRedirector $redirector_;
        private final WeakReference<FaceDecoderImpl> mOutRef;

        public MyDiscussionObserver(FaceDecoderImpl faceDecoderImpl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) faceDecoderImpl);
            } else {
                this.mOutRef = new WeakReference<>(faceDecoderImpl);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.b
        protected void onUpdateDiscussionFaceIcon(boolean z16, boolean z17, String str) {
            int i3;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
                return;
            }
            if (this.mOutRef.get() == null) {
                return;
            }
            FaceDecoderImpl faceDecoderImpl = this.mOutRef.get();
            if (faceDecoderImpl.getApp() == null) {
                return;
            }
            if (faceDecoderImpl.mDecodeTaskCompletionListener != null) {
                if (com.tencent.mobileqq.avatar.utils.c.p(str)) {
                    i3 = 1001;
                    str2 = com.tencent.mobileqq.avatar.utils.c.g(str);
                } else {
                    i3 = 101;
                    str2 = str;
                }
                int i16 = i3;
                Bitmap bitmapFromCache = faceDecoderImpl.getBitmapFromCache(i16, str, 0, (byte) 3, 0);
                if (z16 && bitmapFromCache != null) {
                    if (str2 == null) {
                        QLog.e(FaceDecoderImpl.TAG, 1, "onUpdateDiscussionFaceIcon discussionUin is null");
                        str2 = "";
                    }
                    faceDecoderImpl.mDecodeTaskCompletionListener.onDecodeTaskCompleted(faceDecoderImpl.iRunningRequests + faceDecoderImpl.mReadyRequests.size(), i16, str2, bitmapFromCache);
                    if (QLog.isDevelopLevel()) {
                        QLog.i(FaceDecoderImpl.TAG, 2, "====faceDecoderImpl onUpdateDiscussionFaceIcon === isSuccess: " + z16 + ", isComplete: " + z17 + ",disUin: " + str2 + ",type: " + i16 + ",style: -1");
                    }
                }
            }
            if (!faceDecoderImpl.mPause && !faceDecoderImpl.mReadyRequests.isEmpty() && faceDecoderImpl.iRunningRequests < faceDecoderImpl.maxDecodingTask) {
                faceDecoderImpl.runNextTask();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class MyTroopHeaderObserver extends com.tencent.mobileqq.troop.api.observer.a {
        static IPatchRedirector $redirector_;
        private final WeakReference<FaceDecoderImpl> mOutRef;

        public MyTroopHeaderObserver(FaceDecoderImpl faceDecoderImpl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) faceDecoderImpl);
            } else {
                this.mOutRef = new WeakReference<>(faceDecoderImpl);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.a
        protected void onUpdateNewTroopFaceIcon(boolean z16, boolean z17, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
                return;
            }
            if (this.mOutRef.get() == null) {
                return;
            }
            FaceDecoderImpl faceDecoderImpl = this.mOutRef.get();
            if (faceDecoderImpl.getApp() == null) {
                return;
            }
            if (faceDecoderImpl.mDecodeTaskCompletionListener != null) {
                Bitmap bitmapFromCache = faceDecoderImpl.getBitmapFromCache(113, str, 0, (byte) 3, 0);
                if (z16 && bitmapFromCache != null) {
                    faceDecoderImpl.mDecodeTaskCompletionListener.onDecodeTaskCompleted(faceDecoderImpl.iRunningRequests + faceDecoderImpl.mReadyRequests.size(), 113, str, bitmapFromCache);
                    if (QLog.isDevelopLevel()) {
                        QLog.i(FaceDecoderImpl.TAG, 2, "====faceDecoderImpl onUpdateNewTroopFaceIcon === isSuccess: " + z16 + ", isComplete: " + z17 + ",disUin: " + str + ",type: 113,style: -1");
                    }
                }
            }
            if (!faceDecoderImpl.mPause && !faceDecoderImpl.mReadyRequests.isEmpty() && faceDecoderImpl.iRunningRequests < faceDecoderImpl.maxDecodingTask) {
                faceDecoderImpl.runNextTask();
            }
        }
    }

    public FaceDecoderImpl(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.maxDecodingTask = 4;
            this.mAppRef = new WeakReference<>(appInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppInterface getApp() {
        WeakReference<AppInterface> weakReference = this.mAppRef;
        if (weakReference != null && weakReference.get() != null) {
            return this.mAppRef.get();
        }
        QLog.e(TAG, 1, "app is null");
        return null;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public void destory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AppInterface app = getApp();
        MyDiscussionObserver myDiscussionObserver = this.mDiscussObserver;
        MyAvatarObserver myAvatarObserver = this.mAvatarObserver;
        MyTroopHeaderObserver myTroopHeaderObserver = this.mTroopHeaderObserver;
        WeakReference<AppInterface> weakReference = this.mAppRef;
        if (weakReference != null) {
            weakReference.clear();
            this.mAppRef = null;
        }
        this.mDiscussObserver = null;
        this.mTroopHeaderObserver = null;
        this.mAvatarObserver = null;
        if (app != null) {
            if (myDiscussionObserver != null) {
                app.removeObserver(myDiscussionObserver);
            }
            if (myAvatarObserver != null) {
                app.removeObserver(myAvatarObserver);
            }
            if (myTroopHeaderObserver != null) {
                app.removeObserver(myTroopHeaderObserver);
            }
        }
        super.destory();
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public Bitmap getBitmapFromCache(int i3, String str, int i16, byte b16, int i17) {
        String str2;
        int i18 = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        byte b17 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Byte.valueOf(b16), Integer.valueOf(i17));
        }
        AppInterface app = getApp();
        if (app == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 2, "getBitmapFromCache, mApp is null");
                return null;
            }
            return null;
        }
        if (i18 == 1001 && str != null && !com.tencent.mobileqq.avatar.utils.c.p(str)) {
            str2 = com.tencent.mobileqq.avatar.utils.c.k(str);
        } else {
            str2 = str;
        }
        if (i18 == 4 && !((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(str)) {
            i18 = 113;
        }
        if (i18 != 113) {
            b17 = b16;
        }
        byte a16 = com.tencent.mobileqq.avatar.utils.c.a(b17);
        IQQAvatarDataService iQQAvatarDataService = (IQQAvatarDataService) app.getRuntimeService(IQQAvatarDataService.class, "");
        Bitmap bitmapFromCache = iQQAvatarDataService.getBitmapFromCache(iQQAvatarDataService.getFaceBitmapCacheKey(i18, str2, a16, i16, i17, true));
        if (bitmapFromCache != null && i18 == 1001) {
            ((IDiscussionHandlerService) app.getRuntimeService(IDiscussionHandlerService.class, "")).checkPstnIconInfoAndUpdate(str);
            if (this.mDiscussObserver == null) {
                MyDiscussionObserver myDiscussionObserver = new MyDiscussionObserver(this);
                this.mDiscussObserver = myDiscussionObserver;
                app.addObserver(myDiscussionObserver);
            }
        }
        return bitmapFromCache;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public FaceDrawable getFaceDrawableByBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return null;
        }
        return (FaceDrawable) iPatchRedirector.redirect((short) 10, (Object) this, (Object) bitmap);
    }

    @Override // com.tencent.mobileqq.app.face.DecodeCompletionListener
    public void onDecodeTaskCompleted(FaceInfo faceInfo, Bitmap bitmap) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) faceInfo, (Object) bitmap);
            return;
        }
        if (faceInfo != null && getApp() != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 2, "onDecodeTaskCompleted, faceInfo=" + faceInfo.toString());
            }
            this.iRunningRequests--;
            if (!this.mReadyRequests.isEmpty() && !this.mPause) {
                runNextTask();
            }
            FaceInfo remove = this.mInProgress.remove(faceInfo.getFaceKey());
            if (remove != null) {
                int i16 = FaceInfo.TIME_REQ_END;
                if (bitmap != null) {
                    i3 = FaceInfo.RESULT_SUC;
                } else {
                    i3 = FaceInfo.RESULT_FAIL;
                }
                remove.markTime(i16, i3);
            }
            DecodeTaskCompletionListener decodeTaskCompletionListener = this.mDecodeTaskCompletionListener;
            if (decodeTaskCompletionListener != null && bitmap != null) {
                decodeTaskCompletionListener.onDecodeTaskCompleted(this.iRunningRequests + this.mReadyRequests.size(), faceInfo.headType, faceInfo.uin, bitmap);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.face.DecodeCompletionListener
    public void onDecodeTaskCompletedNeedDownload(FaceInfo faceInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) faceInfo);
            return;
        }
        if (faceInfo != null && getApp() != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 2, "onDecodeTaskCompletedNeedDownload, faceInfo=" + faceInfo);
            }
            AppInterface app = getApp();
            if (app == null) {
                QLog.e(TAG, 1, "onDecodeTaskCompletedNeedDownload app is null");
                return;
            }
            this.iRunningRequests--;
            FaceInfo faceInfo2 = this.mInProgress.get(faceInfo.getFaceKey());
            if (faceInfo2 == null) {
                QLog.e(TAG, 1, "onDecodeTaskCompletedNeedDownload info is null");
            }
            if (faceInfo2 != null) {
                if (this.mAvatarObserver == null) {
                    MyAvatarObserver myAvatarObserver = new MyAvatarObserver(this);
                    this.mAvatarObserver = myAvatarObserver;
                    app.addObserver(myAvatarObserver);
                }
                FaceDecoder.requestDownloadFace(app, faceInfo2);
            }
            if (!this.mPause && !this.mReadyRequests.isEmpty() && this.iRunningRequests < this.maxDecodingTask) {
                runNextTask();
                return;
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onDecodeTaskCompletedNeedDownload faceInfo == null? ");
        if (faceInfo == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.e(TAG, 1, sb5.toString());
    }

    protected void onUpdateHead(boolean z16, int i3, String str, int i16, int i17) {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (getApp() == null) {
            return;
        }
        String faceKey = FaceInfo.getFaceKey(i3, str, i16, i17);
        if (z16 && !this.mPause) {
            Bitmap bitmapFromCache = getBitmapFromCache(i3, str, i16, (byte) 3, i17);
            if (bitmapFromCache != null) {
                FaceInfo remove = this.mInProgress.remove(faceKey);
                if (remove != null) {
                    remove.markTime(FaceInfo.TIME_REQ_END, FaceInfo.RESULT_SUC);
                }
                DecodeTaskCompletionListener decodeTaskCompletionListener = this.mDecodeTaskCompletionListener;
                if (decodeTaskCompletionListener != null) {
                    decodeTaskCompletionListener.onDecodeTaskCompleted(this.iRunningRequests + this.mReadyRequests.size(), i3, str, bitmapFromCache);
                    return;
                }
                return;
            }
            FaceInfo faceInfo = this.mInProgress.get(faceKey);
            if (faceInfo != null) {
                enqueueDecode(faceInfo);
                return;
            }
            FaceInfo remove2 = this.mRefreshMap.remove(faceKey);
            if (remove2 != null) {
                remove2.markTime(FaceInfo.TIME_BEGINE);
                this.mInProgress.put(faceKey, remove2);
                enqueueDecode(remove2);
                return;
            }
            return;
        }
        FaceInfo remove3 = this.mInProgress.remove(faceKey);
        if (remove3 != null) {
            int i19 = FaceInfo.TIME_REQ_END;
            if (!z16) {
                i18 = FaceInfo.RESULT_FAIL;
            } else {
                i18 = FaceInfo.RESULT_PAUSE;
            }
            remove3.markTime(i19, i18);
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public boolean preloadFacesWithFaceInfo(ArrayList<HeadRequest> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) arrayList)).booleanValue();
        }
        return false;
    }

    public void refreshApolloFaceWithTimeStamp(String str, int i3, long j3) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (!TextUtils.isEmpty(str) && j3 > 0) {
            AppInterface app = getApp();
            if (app == null) {
                QLog.e(TAG, 1, "refreshApolloFaceWithTimeStamp app is null");
                return;
            }
            Pair<Boolean, Setting> qQHeadSetting = ((IQQAvatarDataService) app.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(116, str, 200);
            if (qQHeadSetting != null && (obj = qQHeadSetting.second) != null) {
                long j16 = ((Setting) obj).headImgTimestamp;
                if (j16 != j3) {
                    IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) app.getRuntimeService(IQQAvatarHandlerService.class, "");
                    if (iQQAvatarHandlerService != null) {
                        iQQAvatarHandlerService.getApolloHead(str, (byte) 1, (byte) 0, i3);
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("Q.qqhead.qaif", 2, "refreshApolloFaceWithTimeStamp id=" + str + ", sizeType =" + i3 + ", timestamp=" + j3 + ",headImgTimestamp=" + j16);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public void refreshFaceWithTimeStamp(int i3, String str, int i16, long j3, int i17) {
        byte b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i17));
            return;
        }
        if (!TextUtils.isEmpty(str) && j3 > 0) {
            AppInterface app = getApp();
            if (app == null) {
                QLog.e(TAG, 1, "refreshFaceWithTimeStamp app is null");
                return;
            }
            if (i3 == 32 && i16 != 200 && i16 != 200 && i16 != 204) {
                return;
            }
            if (i3 == 32) {
                b16 = 1;
            } else {
                b16 = 0;
            }
            FaceInfo faceInfo = new FaceInfo(i3, str, false, b16, 3, false, i16, false, i17);
            String faceKey = FaceInfo.getFaceKey(i3, str, i16, i17);
            if (this.mRefreshMap.get(faceKey) == null) {
                this.mRefreshMap.put(faceKey, faceInfo);
            }
            if (this.mAvatarObserver == null) {
                MyAvatarObserver myAvatarObserver = new MyAvatarObserver(this);
                this.mAvatarObserver = myAvatarObserver;
                app.addObserver(myAvatarObserver);
            }
            if (i3 == 32) {
                refreshStrangerFaceWithTimeStamp(str, i16, j3);
            } else if (i3 == 16) {
                refreshQCallFaceWithTimeStamp(str, i16, j3);
            } else if (i3 == 116) {
                refreshApolloFaceWithTimeStamp(str, i17, j3);
            }
        }
    }

    public void refreshQCallFaceWithTimeStamp(String str, int i3, long j3) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (!TextUtils.isEmpty(str) && j3 > 0) {
            if (i3 != 200 && i3 != 204 && i3 != 202) {
                return;
            }
            AppInterface app = getApp();
            if (app == null) {
                QLog.e(TAG, 1, "refreshQCallFaceWithTimeStamp app is null");
                return;
            }
            Pair<Boolean, Setting> qQHeadSetting = ((IQQAvatarDataService) app.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(16, str, i3);
            if (qQHeadSetting != null && (obj = qQHeadSetting.second) != null) {
                long j16 = ((Setting) obj).headImgTimestamp;
                if (j16 != j3) {
                    IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) app.getRuntimeService(IQQAvatarHandlerService.class, "");
                    if (iQQAvatarHandlerService != null) {
                        iQQAvatarHandlerService.getStrangerHead(str, i3, (byte) 1, (byte) 0);
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("Q.qqhead.qaif", 2, "refreshQCallFaceWithTimeStamp id=" + str + ", idtype =" + i3 + ", timestamp=" + j3 + ",headImgTimestamp=" + j16);
                    }
                }
            }
        }
    }

    public void refreshStrangerFaceWithTimeStamp(String str, int i3, long j3) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (!TextUtils.isEmpty(str) && j3 > 0) {
            if (i3 != 200 && i3 != 204 && i3 != 202) {
                return;
            }
            AppInterface app = getApp();
            if (app == null) {
                QLog.e(TAG, 1, "refreshStrangerFaceWithTimeStamp app is null");
                return;
            }
            Pair<Boolean, Setting> qQHeadSetting = ((IQQAvatarDataService) app.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(32, str, i3);
            if (qQHeadSetting != null && (obj = qQHeadSetting.second) != null) {
                long j16 = ((Setting) obj).headImgTimestamp;
                if (j16 != j3) {
                    IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) app.getRuntimeService(IQQAvatarHandlerService.class, "");
                    if (iQQAvatarHandlerService != null) {
                        iQQAvatarHandlerService.getStrangerHead(str, i3, (byte) 1, (byte) 0);
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("Q.qqhead.qaif", 2, "refreshStrangerFaceWithTimeStamp id=" + str + ", idtype =" + i3 + ", timestamp=" + j3 + ",headImgTimestamp=" + j16);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public boolean requestDecodeFace(String str, int i3, boolean z16, int i16, boolean z17, byte b16, int i17, int i18, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        byte b17 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Boolean.valueOf(z17), Byte.valueOf(b16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z18))).booleanValue();
        }
        if (str != null && str.length() >= 5) {
            if (i17 == 0) {
                if (i16 != 101) {
                }
            } else {
                b17 = (byte) i17;
            }
            byte a16 = com.tencent.mobileqq.avatar.utils.c.a(b17);
            String faceKey = FaceInfo.getFaceKey(i16, str, i3, i18);
            FaceInfo faceInfo = this.mInProgress.get(faceKey);
            if (faceInfo != null && !faceInfo.isTimeOut(FaceInfo.TIME_BEGINE, MiniBoxNoticeInfo.MIN_5)) {
                if (faceInfo.appendToTail && !z17) {
                    faceInfo.appendToTail = false;
                }
                faceInfo.shape = a16;
                return true;
            }
            FaceInfo faceInfo2 = new FaceInfo(i16, str, z17, b16, (int) a16, false, i3, z18, i18);
            faceInfo2.markTime(FaceInfo.TIME_BEGINE);
            this.mInProgress.put(faceKey, faceInfo2);
            enqueueDecode(faceInfo2);
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "requestDecodeFace fail. type=" + i16 + ", uin=" + str);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public boolean requestDecodeFaceWithFaceInfo(String str, int i3, boolean z16, int i16, boolean z17, byte b16, int i17, QQHeadInfo qQHeadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Boolean.valueOf(z17), Byte.valueOf(b16), Integer.valueOf(i17), qQHeadInfo)).booleanValue();
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    protected void runNextTask() {
        FaceInfo faceInfo;
        Throwable th5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.mReadyRequests.isEmpty()) {
            QLog.i(TAG, 2, " runNextTask, mReadyRequests is empty");
            return;
        }
        try {
            faceInfo = this.mReadyRequests.removeFirst();
        } catch (Throwable th6) {
            faceInfo = null;
            th5 = th6;
        }
        try {
            AppInterface app = getApp();
            if (app != null) {
                int i3 = faceInfo.headType;
                if ((i3 == 101 || i3 == 1001) && this.mDiscussObserver == null) {
                    MyDiscussionObserver myDiscussionObserver = new MyDiscussionObserver(this);
                    this.mDiscussObserver = myDiscussionObserver;
                    app.addObserver(myDiscussionObserver);
                }
                int i16 = faceInfo.headType;
                if ((i16 == 4 || i16 == 113) && !((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(faceInfo.uin)) {
                    if (this.mTroopHeaderObserver == null) {
                        this.mTroopHeaderObserver = new MyTroopHeaderObserver(this);
                    }
                    app.addObserver(this.mTroopHeaderObserver);
                }
            } else {
                QLog.e(TAG, 1, "runNextTask app is null");
            }
            this.iRunningRequests++;
            FaceDecodeTask.execute(FaceDecodeTask.getFaceDecodeTask(app, faceInfo, this));
        } catch (Throwable th7) {
            th5 = th7;
            if (faceInfo != null) {
                this.iRunningRequests--;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 2, "runNextTask exception and info is " + faceInfo, th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public void setAppRuntime(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appInterface);
        } else if (getApp() != appInterface) {
            destory();
            this.mAppRef = new WeakReference<>(appInterface);
        }
    }
}
