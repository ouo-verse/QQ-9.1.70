package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarDecoderApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FaceDrawableImpl extends FaceDrawable {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Q.qqhead.FaceDrawableImpl";
    InternalDiscussionObserver mDisObserver;
    InternalFriendListObserver mFriendListObserver;
    InternalGroupObserver mGroupObserver;
    WeakReference<AppInterface> weakApp;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface DisFaceObserver {
        void onUpdateDiscussionFaceIcon(boolean z16, boolean z17, String str);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface FaceObserver {
        void onUpdateApolloHead(boolean z16, String str, int i3);

        void onUpdateCustomHead(boolean z16, String str, FaceInfo faceInfo);

        void onUpdateMobileQQHead(boolean z16, String str);

        void onUpdateQCallHead(boolean z16, String str, int i3, boolean z17);

        void onUpdateStrangerHead(boolean z16, String str, int i3, boolean z17);

        void onUpdateTroopHead(boolean z16, String str);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class InternalDiscussionObserver implements DisFaceObserver {
        static IPatchRedirector $redirector_;
        public String discussionUin;

        InternalDiscussionObserver(FaceDrawable faceDrawable) {
            FaceInfo faceInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaceDrawableImpl.this, (Object) faceDrawable);
            } else if (faceDrawable != null && (faceInfo = faceDrawable.mFaceInfo) != null) {
                this.discussionUin = faceInfo.uin;
            }
        }

        @Override // com.tencent.mobileqq.app.face.FaceDrawableImpl.DisFaceObserver
        public void onUpdateDiscussionFaceIcon(boolean z16, boolean z17, String str) {
            int i3;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
                return;
            }
            if (com.tencent.mobileqq.avatar.utils.c.p(str)) {
                str2 = com.tencent.mobileqq.avatar.utils.c.g(str);
                i3 = 1001;
            } else {
                i3 = 101;
                str2 = str;
            }
            if (z17) {
                FaceDrawableImpl faceDrawableImpl = FaceDrawableImpl.this;
                faceDrawableImpl.onUpdateHead(z16, i3, str2, faceDrawableImpl.mDisObserver);
            } else {
                FaceDrawableImpl.this.onUpdateHead(z16, i3, str2, null);
            }
            if (QLog.isColorLevel()) {
                QLog.i(FaceDrawableImpl.TAG, 2, "====faceDrawableImpl onUpdateDiscussionFaceIcon === isSuccess: " + z16 + ", isComplete: " + z17 + ",disUin: " + str + ",type: " + i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class InternalFriendListObserver implements FaceObserver {
        static IPatchRedirector $redirector_;
        public WeakReference<FaceDrawable> faceDrawableWeakReference;
        public String uin;

        InternalFriendListObserver(FaceDrawable faceDrawable) {
            FaceInfo faceInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaceDrawableImpl.this, (Object) faceDrawable);
                return;
            }
            this.faceDrawableWeakReference = new WeakReference<>(faceDrawable);
            if (faceDrawable != null && (faceInfo = faceDrawable.mFaceInfo) != null) {
                this.uin = faceInfo.uin;
            }
        }

        @Override // com.tencent.mobileqq.app.face.FaceDrawableImpl.FaceObserver
        public void onUpdateApolloHead(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
            } else {
                FaceDrawableImpl faceDrawableImpl = FaceDrawableImpl.this;
                faceDrawableImpl.onUpdateHead(z16, 116, str, faceDrawableImpl.mFriendListObserver);
            }
        }

        @Override // com.tencent.mobileqq.app.face.FaceDrawableImpl.FaceObserver
        public void onUpdateCustomHead(boolean z16, String str, FaceInfo faceInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, faceInfo);
            } else {
                FaceDrawableImpl faceDrawableImpl = FaceDrawableImpl.this;
                faceDrawableImpl.onUpdateHead(z16, 1, str, faceInfo, faceDrawableImpl.mFriendListObserver);
            }
        }

        @Override // com.tencent.mobileqq.app.face.FaceDrawableImpl.FaceObserver
        public void onUpdateMobileQQHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else {
                FaceDrawableImpl faceDrawableImpl = FaceDrawableImpl.this;
                faceDrawableImpl.onUpdateHead(z16, 11, str, faceDrawableImpl.mFriendListObserver);
            }
        }

        @Override // com.tencent.mobileqq.app.face.FaceDrawableImpl.FaceObserver
        public void onUpdateQCallHead(boolean z16, String str, int i3, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Boolean.valueOf(z17));
                return;
            }
            FaceDrawableImpl faceDrawableImpl = FaceDrawableImpl.this;
            FaceInfo faceInfo = faceDrawableImpl.mFaceInfo;
            if (faceInfo != null && i3 == faceInfo.idType) {
                faceDrawableImpl.onUpdateHead(z16, 16, str, faceDrawableImpl.mFriendListObserver);
            }
        }

        @Override // com.tencent.mobileqq.app.face.FaceDrawableImpl.FaceObserver
        public void onUpdateStrangerHead(boolean z16, String str, int i3, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Boolean.valueOf(z17));
            } else {
                FaceDrawableImpl faceDrawableImpl = FaceDrawableImpl.this;
                faceDrawableImpl.onUpdateHead(z16, 32, str, faceDrawableImpl.mFriendListObserver);
            }
        }

        @Override // com.tencent.mobileqq.app.face.FaceDrawableImpl.FaceObserver
        public void onUpdateTroopHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str);
            } else {
                FaceDrawableImpl faceDrawableImpl = FaceDrawableImpl.this;
                faceDrawableImpl.onUpdateHead(z16, 4, str, faceDrawableImpl.mFriendListObserver);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class InternalGroupObserver implements NewTroopFaceObserver {
        static IPatchRedirector $redirector_;
        public String discussionUin;

        InternalGroupObserver(FaceDrawable faceDrawable) {
            FaceInfo faceInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaceDrawableImpl.this, (Object) faceDrawable);
            } else if (faceDrawable != null && (faceInfo = faceDrawable.mFaceInfo) != null) {
                this.discussionUin = faceInfo.uin;
            }
        }

        @Override // com.tencent.mobileqq.app.face.FaceDrawableImpl.NewTroopFaceObserver
        public void onUpdateGroupFaceIcon(boolean z16, boolean z17, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
                return;
            }
            if (z17) {
                FaceDrawableImpl faceDrawableImpl = FaceDrawableImpl.this;
                faceDrawableImpl.onUpdateHead(z16, 113, str, faceDrawableImpl.mGroupObserver);
            } else {
                FaceDrawableImpl.this.onUpdateHead(z16, 113, str, null);
            }
            if (QLog.isColorLevel()) {
                QLog.i(FaceDrawableImpl.TAG, 2, "====faceDrawableImpl onUpdateGroupFaceIcon === isSuccess: " + z16 + ", isComplete: " + z17 + ",disUin: " + str + ",type: 113");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface NewTroopFaceObserver {
        void onUpdateGroupFaceIcon(boolean z16, boolean z17, String str);
    }

    public FaceDrawableImpl(AppInterface appInterface, int i3, int i16, String str, byte b16, int i17, int i18, boolean z16, Drawable drawable, Drawable drawable2, FaceDrawable.OnLoadingStateChangeListener onLoadingStateChangeListener, boolean z17) {
        super(appInterface, i3, i16, str, b16, i17, i18, z16, drawable, drawable2, onLoadingStateChangeListener, z17, false, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.weakApp = new WeakReference<>(appInterface);
        } else {
            iPatchRedirector.redirect((short) 1, this, appInterface, Integer.valueOf(i3), Integer.valueOf(i16), str, Byte.valueOf(b16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), drawable, drawable2, onLoadingStateChangeListener, Boolean.valueOf(z17));
        }
    }

    private Bitmap getBitmapFromCacheInner(boolean z16) {
        FaceInfo faceInfo = this.mFaceInfo;
        if (faceInfo == null) {
            return null;
        }
        String str = faceInfo.uin;
        if (faceInfo.headType == 1001) {
            str = com.tencent.mobileqq.avatar.utils.c.k(str);
        }
        String str2 = str;
        AppInterface appInterface = this.weakApp.get();
        if (appInterface == null) {
            return null;
        }
        IQQAvatarDataService iQQAvatarDataService = (IQQAvatarDataService) appInterface.getRuntimeService(IQQAvatarDataService.class, "");
        FaceInfo faceInfo2 = this.mFaceInfo;
        Bitmap bitmapFromCache = iQQAvatarDataService.getBitmapFromCache(iQQAvatarDataService.getFaceBitmapCacheKey(faceInfo2.headType, str2, (byte) faceInfo2.shape, faceInfo2.idType, faceInfo2.sizeType, z16, faceInfo2));
        if (bitmapFromCache != null && this.mFaceInfo.headType == 1001) {
            ((IDiscussionHandlerService) appInterface.getRuntimeService(IDiscussionHandlerService.class, "")).checkPstnIconInfoAndUpdate(this.mFaceInfo.uin);
        }
        return bitmapFromCache;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable, com.tencent.mobileqq.util.AsynLoadDrawable
    public void cancel() {
        IQQAvatarManagerService iQQAvatarManagerService;
        IQQAvatarManagerService iQQAvatarManagerService2;
        IQQAvatarManagerService iQQAvatarManagerService3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        AppInterface appInterface = this.weakApp.get();
        if (!((FaceDrawable) this).mCancelled && appInterface != null) {
            if (this.mFriendListObserver != null && (iQQAvatarManagerService3 = (IQQAvatarManagerService) appInterface.getRuntimeService(IQQAvatarManagerService.class, "")) != null) {
                iQQAvatarManagerService3.removeObserver(this.mFriendListObserver);
            }
            if (this.mDisObserver != null && (iQQAvatarManagerService2 = (IQQAvatarManagerService) appInterface.getRuntimeService(IQQAvatarManagerService.class, "")) != null) {
                iQQAvatarManagerService2.removeObserver(this.mDisObserver);
            }
            if (this.mGroupObserver != null && (iQQAvatarManagerService = (IQQAvatarManagerService) appInterface.getRuntimeService(IQQAvatarManagerService.class, "")) != null) {
                iQQAvatarManagerService.removeObserver(this.mGroupObserver);
            }
            this.weakApp = null;
        }
        super.cancel();
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    protected Bitmap getBitmapFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? getBitmapFromCacheInner(false) : (Bitmap) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    protected void onNeedDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.mFriendListObserver == null) {
            this.mFriendListObserver = new InternalFriendListObserver(this);
        }
        AppInterface appInterface = this.weakApp.get();
        if (appInterface == null) {
            QLog.e(TAG, 1, "onNeedDownload appInterface is null");
            return;
        }
        IQQAvatarManagerService iQQAvatarManagerService = (IQQAvatarManagerService) appInterface.getRuntimeService(IQQAvatarManagerService.class, "");
        if (iQQAvatarManagerService != null) {
            iQQAvatarManagerService.addObserver(this.mFriendListObserver);
        }
        int i3 = this.mFaceInfo.headType;
        if (i3 == 1 || i3 == 11 || i3 == 4 || i3 == 32 || i3 == 16 || i3 == 116 || i3 == 1001) {
            IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) appInterface.getRuntimeService(IQQAvatarHandlerService.class, "");
            FaceInfo faceInfo = this.mFaceInfo;
            int i16 = faceInfo.headType;
            if (i16 == 1) {
                iQQAvatarHandlerService.getCustomHead(faceInfo);
                return;
            }
            if (i16 == 11) {
                iQQAvatarHandlerService.getMobileQQHead(faceInfo.uin, faceInfo.faceFileType);
                return;
            }
            if (i16 == 4) {
                iQQAvatarHandlerService.getTroopHead(faceInfo.uin, faceInfo.faceFileType);
                return;
            }
            if (i16 == 32) {
                iQQAvatarHandlerService.getStrangerHead(faceInfo.uin, faceInfo.idType, faceInfo.headLevel, faceInfo.faceFileType);
                return;
            }
            if (i16 == 16) {
                iQQAvatarHandlerService.getQCallHead(faceInfo.uin, faceInfo.idType, faceInfo.headLevel, faceInfo.faceFileType);
                return;
            }
            if (i16 == 116) {
                iQQAvatarHandlerService.getApolloHead(faceInfo.uin, faceInfo.headLevel, faceInfo.faceFileType, faceInfo.sizeType);
            } else if (i16 == 101) {
                ((IDiscussionHandlerService) appInterface.getRuntimeService(IDiscussionHandlerService.class, "")).updateDiscussionIcon(this.mFaceInfo.uin, true);
            } else if (i16 == 1001) {
                ((IDiscussionHandlerService) appInterface.getRuntimeService(IDiscussionHandlerService.class, "")).updateDiscussionIcon(com.tencent.mobileqq.avatar.utils.c.k(this.mFaceInfo.uin), true);
            }
        }
    }

    public void onUpdateHead(boolean z16, int i3, String str, Object obj) {
        FaceInfo faceInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, obj);
            return;
        }
        System.currentTimeMillis();
        if (((FaceDrawable) this).mCancelled || (faceInfo = this.mFaceInfo) == null || i3 != faceInfo.headType || !faceInfo.uin.equals(str)) {
            return;
        }
        if (obj != null) {
            AppInterface appInterface = this.weakApp.get();
            if (appInterface == null) {
                QLog.e(TAG, 1, "onUpdateHead app is null");
                return;
            } else {
                IQQAvatarManagerService iQQAvatarManagerService = (IQQAvatarManagerService) appInterface.getRuntimeService(IQQAvatarManagerService.class, "");
                if (iQQAvatarManagerService != null) {
                    iQQAvatarManagerService.removeObserver(obj);
                }
            }
        }
        if (z16) {
            Bitmap bitmapFromCache = getBitmapFromCache();
            if (bitmapFromCache != null) {
                onDecodeTaskCompleted(this.mFaceInfo, bitmapFromCache);
            } else {
                requestDecode();
            }
        } else {
            onDecodeTaskCompleted(this.mFaceInfo, null);
        }
        System.currentTimeMillis();
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    protected boolean requestDecode() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.mFaceInfo == null || (appInterface = this.weakApp.get()) == null) {
            return false;
        }
        int i3 = this.mFaceInfo.headType;
        if (i3 == 101 || i3 == 1001) {
            this.mDisObserver = new InternalDiscussionObserver(this);
            IQQAvatarManagerService iQQAvatarManagerService = (IQQAvatarManagerService) appInterface.getRuntimeService(IQQAvatarManagerService.class, "");
            if (iQQAvatarManagerService != null) {
                iQQAvatarManagerService.addObserver(this.mDisObserver);
            }
        }
        int i16 = this.mFaceInfo.headType;
        if ((i16 == 4 || i16 == 113) && !((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(this.mFaceInfo.uin)) {
            this.mGroupObserver = new InternalGroupObserver(this);
            IQQAvatarManagerService iQQAvatarManagerService2 = (IQQAvatarManagerService) appInterface.getRuntimeService(IQQAvatarManagerService.class, "");
            if (iQQAvatarManagerService2 != null) {
                iQQAvatarManagerService2.addObserver(this.mGroupObserver);
            }
        }
        ((IQQAvatarDecoderApi) QRoute.api(IQQAvatarDecoderApi.class)).executeTask(appInterface, this.mFaceInfo, this);
        return true;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    protected void setApp(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInterface);
        } else {
            this.weakApp = new WeakReference<>(appInterface);
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    protected Bitmap getBitmapFromCache(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? getBitmapFromCacheInner(z16) : (Bitmap) iPatchRedirector.redirect((short) 8, (Object) this, z16);
    }

    public FaceDrawableImpl(AppInterface appInterface, int i3, int i16, String str, byte b16, int i17, int i18, boolean z16, Drawable drawable, Drawable drawable2, FaceDrawable.OnLoadingStateChangeListener onLoadingStateChangeListener, boolean z17, boolean z18, int i19) {
        super(appInterface, i3, i16, str, b16, i17, i18, z16, drawable, drawable2, onLoadingStateChangeListener, z17, z18, i19);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.weakApp = new WeakReference<>(appInterface);
        } else {
            iPatchRedirector.redirect((short) 2, this, appInterface, Integer.valueOf(i3), Integer.valueOf(i16), str, Byte.valueOf(b16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), drawable, drawable2, onLoadingStateChangeListener, Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i19));
        }
    }

    public void onUpdateHead(boolean z16, int i3, String str, @Nullable FaceInfo faceInfo, Object obj) {
        FaceInfo faceInfo2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, faceInfo, obj);
            return;
        }
        if (((FaceDrawable) this).mCancelled || (faceInfo2 = this.mFaceInfo) == null || i3 != faceInfo2.headType || !faceInfo2.uin.equals(str)) {
            return;
        }
        if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn() && faceInfo != null) {
            if (this.mFaceInfo.isEnableZplanOutbound() != faceInfo.isEnableZplanOutbound()) {
                QLog.e(TAG, 1, "onUpdateHead enable outbound not same");
                return;
            }
            if (com.tencent.mobileqq.avatar.utils.c.q() && faceInfo.sizeType != this.mFaceInfo.sizeType) {
                QLog.e(TAG, 1, "onUpdateHead sizeType not same." + faceInfo.sizeType + ", " + this.mFaceInfo.sizeType);
                return;
            }
        }
        if (obj != null) {
            AppInterface appInterface = this.weakApp.get();
            if (appInterface == null) {
                return;
            }
            IQQAvatarManagerService iQQAvatarManagerService = (IQQAvatarManagerService) appInterface.getRuntimeService(IQQAvatarManagerService.class, "");
            if (iQQAvatarManagerService != null) {
                iQQAvatarManagerService.removeObserver(obj);
            }
        }
        if (z16) {
            Bitmap bitmapFromCache = getBitmapFromCache();
            if (bitmapFromCache != null) {
                onDecodeTaskCompleted(this.mFaceInfo, bitmapFromCache);
            } else {
                requestDecode();
            }
        } else {
            onDecodeTaskCompleted(this.mFaceInfo, null);
        }
        System.currentTimeMillis();
    }
}
