package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.api.IQQAvatarDecoderApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.avatar.api.IQQNearbyAvatarHandlerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NearByFaceDrawable extends FaceDrawable {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Q.qqhead.NearByFaceDrawable";
    AppInterface mAppIntf;
    FaceObserver mFaceObserver;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends FaceObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NearByFaceDrawable.this);
            }
        }

        @Override // com.tencent.mobileqq.app.face.FaceObserver
        public void onUpdateStrangerHead(boolean z16, FaceInfo faceInfo) {
            FaceInfo faceInfo2;
            AppInterface appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), faceInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(NearByFaceDrawable.TAG, 2, "onUpdateStrangerHead.faceInfo=" + faceInfo + ", isSuccess=" + z16);
            }
            NearByFaceDrawable nearByFaceDrawable = NearByFaceDrawable.this;
            if (!((FaceDrawable) nearByFaceDrawable).mCancelled && (faceInfo2 = nearByFaceDrawable.mFaceInfo) != null && faceInfo != null && faceInfo.idType == faceInfo2.idType && faceInfo2.uin.equals(faceInfo.uin)) {
                NearByFaceDrawable nearByFaceDrawable2 = NearByFaceDrawable.this;
                FaceObserver faceObserver = nearByFaceDrawable2.mFaceObserver;
                if (faceObserver != null && (appInterface = nearByFaceDrawable2.mAppIntf) != null) {
                    appInterface.removeObserver(faceObserver);
                }
                if (z16) {
                    Bitmap bitmapFromCache = NearByFaceDrawable.this.getBitmapFromCache();
                    if (bitmapFromCache != null) {
                        NearByFaceDrawable nearByFaceDrawable3 = NearByFaceDrawable.this;
                        nearByFaceDrawable3.onDecodeTaskCompleted(nearByFaceDrawable3.mFaceInfo, bitmapFromCache);
                        return;
                    } else {
                        NearByFaceDrawable.this.requestDecode();
                        return;
                    }
                }
                NearByFaceDrawable nearByFaceDrawable4 = NearByFaceDrawable.this;
                nearByFaceDrawable4.onDecodeTaskCompleted(nearByFaceDrawable4.mFaceInfo, null);
            }
        }
    }

    public NearByFaceDrawable(AppInterface appInterface, int i3, int i16, String str, byte b16, int i17, boolean z16, Drawable drawable, Drawable drawable2, FaceDrawable.OnLoadingStateChangeListener onLoadingStateChangeListener, boolean z17) {
        super(appInterface, i3, i16, str, b16, i17, 100, z16, drawable, drawable2, onLoadingStateChangeListener, z17, false, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appInterface, Integer.valueOf(i3), Integer.valueOf(i16), str, Byte.valueOf(b16), Integer.valueOf(i17), Boolean.valueOf(z16), drawable, drawable2, onLoadingStateChangeListener, Boolean.valueOf(z17));
        } else {
            this.mFaceObserver = null;
            this.mAppIntf = appInterface;
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable, com.tencent.mobileqq.util.AsynLoadDrawable
    public void cancel() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        FaceObserver faceObserver = this.mFaceObserver;
        if (faceObserver != null && (appInterface = this.mAppIntf) != null) {
            appInterface.removeObserver(faceObserver);
            this.mFaceObserver = null;
        }
        this.mAppIntf = null;
        super.cancel();
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    protected Bitmap getBitmapFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        FaceInfo faceInfo = this.mFaceInfo;
        if (faceInfo == null) {
            return null;
        }
        return ((IQQAvatarManagerService) this.mAppIntf.getRuntimeService(IQQAvatarManagerService.class, ProcessConstant.NEARBY)).getFaceFromCache(FaceInfo.getFaceBmpCacheKey(faceInfo.headType, faceInfo.uin, faceInfo.idType, faceInfo.shape, faceInfo.sizeType));
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    protected void onNeedDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onNeedDownload.faceInfo=" + this.mFaceInfo);
        }
        Bitmap bitmapFromCache = getBitmapFromCache();
        if (bitmapFromCache != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "onNeedDownload.faceInfo=" + this.mFaceInfo + ",bitmap is already in cache...");
            }
            onDecodeTaskCompleted(this.mFaceInfo, bitmapFromCache);
            return;
        }
        if (this.mFaceObserver == null) {
            a aVar = new a();
            this.mFaceObserver = aVar;
            this.mAppIntf.addObserver(aVar);
        }
        ((IQQNearbyAvatarHandlerService) this.mAppIntf.getRuntimeService(IQQNearbyAvatarHandlerService.class, ProcessConstant.NEARBY)).getStrangerFaceInfo(this.mFaceInfo);
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    protected boolean requestDecode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "requestDecode.faceInfo=" + this.mFaceInfo);
        }
        if (this.mFaceInfo == null) {
            return false;
        }
        ((IQQAvatarDecoderApi) QRoute.api(IQQAvatarDecoderApi.class)).executeTask(this.mAppIntf, this.mFaceInfo, this);
        return true;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    protected void setApp(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
        } else {
            this.mAppIntf = appInterface;
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable
    protected Bitmap getBitmapFromCache(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? getBitmapFromCache() : (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this, z16);
    }
}
