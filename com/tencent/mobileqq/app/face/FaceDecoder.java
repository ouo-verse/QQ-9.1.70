package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.HeadRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FaceDecoder implements IFaceDecoder {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FaceDecoder";
    FaceDecoderBase mDecoder;

    public FaceDecoder(Context context, AppInterface appInterface) {
        this(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) appInterface);
    }

    private byte getFaceShapeType(int i3) {
        if (i3 == 115) {
            return (byte) 4;
        }
        return (byte) 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void requestDownloadFace(AppInterface appInterface, FaceInfo faceInfo) {
        if (appInterface != null && faceInfo != null) {
            ThreadManagerV2.post(new Runnable(faceInfo) { // from class: com.tencent.mobileqq.app.face.FaceDecoder.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ FaceInfo val$faceInfo;

                {
                    this.val$faceInfo = faceInfo;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AppInterface.this, (Object) faceInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) AppInterface.this.getRuntimeService(IQQAvatarHandlerService.class, "");
                    if (iQQAvatarHandlerService == null) {
                        QLog.e(FaceDecoder.TAG, 1, "requestDownloadFace avatarHandlerService is null");
                        return;
                    }
                    FaceInfo faceInfo2 = this.val$faceInfo;
                    int i3 = faceInfo2.headType;
                    if (i3 == 1) {
                        QLog.e(FaceDecoder.TAG, 4, "requestDownloadFace faceInfo = " + this.val$faceInfo + ", isEnableOutbound? " + this.val$faceInfo.isEnableZplanOutbound() + ",, staticZplanFaceFlag? " + ((int) this.val$faceInfo.staticZplanFaceFlag) + ",, dynamicZplanFaceFlag? " + ((int) this.val$faceInfo.dynamicZplanFaceFlag));
                        if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn() && this.val$faceInfo.isEnableZplanOutbound()) {
                            iQQAvatarHandlerService.getCustomHead(this.val$faceInfo);
                            return;
                        } else {
                            FaceInfo faceInfo3 = this.val$faceInfo;
                            iQQAvatarHandlerService.getCustomHead(faceInfo3.uin, faceInfo3.headLevel, faceInfo3.faceFileType);
                            return;
                        }
                    }
                    if (i3 != 101 && i3 != 115) {
                        if (i3 == 11) {
                            iQQAvatarHandlerService.getMobileQQHead(faceInfo2.uin, faceInfo2.faceFileType);
                            return;
                        }
                        if (i3 == 4) {
                            iQQAvatarHandlerService.getTroopHead(faceInfo2.uin, faceInfo2.faceFileType);
                            return;
                        }
                        if (i3 == 32) {
                            iQQAvatarHandlerService.getStrangerHead(faceInfo2.uin, faceInfo2.idType, faceInfo2.headLevel, faceInfo2.faceFileType);
                            return;
                        } else if (i3 == 16) {
                            iQQAvatarHandlerService.getQCallHead(faceInfo2.uin, faceInfo2.idType, faceInfo2.headLevel, faceInfo2.faceFileType);
                            return;
                        } else {
                            if (i3 == 116) {
                                iQQAvatarHandlerService.getApolloHead(faceInfo2.uin, faceInfo2.headLevel, faceInfo2.faceFileType, faceInfo2.sizeType);
                                return;
                            }
                            return;
                        }
                    }
                    iQQAvatarHandlerService.getCustomHead(faceInfo2.uin, faceInfo2.headLevel, faceInfo2.faceFileType);
                }
            }, 10, null, true);
        }
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public void cancelPendingRequests() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mDecoder.cancelPendingRequests();
        }
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public void destory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            this.mDecoder.destory();
        }
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public Bitmap getBitmapFromCache(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) ? getBitmapFromCache(i3, str, i16, (byte) 3) : (Bitmap) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public Bitmap getBitmapFromCacheFrom(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Bitmap) iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
        }
        return getBitmapFromCache(i3, str);
    }

    public Drawable getFaceDrawableByBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Drawable) iPatchRedirector.redirect((short) 28, (Object) this, (Object) bitmap);
        }
        return this.mDecoder.getFaceDrawableByBitmap(bitmap);
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public boolean isPausing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.mDecoder.isPausing();
    }

    public boolean ismUserJustTouchDown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.mDecoder.ismUserJustTouchDown();
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.mDecoder.pause();
        }
    }

    public boolean preloadFacesWithFaceInfo(ArrayList<HeadRequest> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) arrayList)).booleanValue();
        }
        return this.mDecoder.preloadFacesWithFaceInfo(arrayList);
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public void refreshFaceWithTimeStamp(int i3, String str, int i16, long j3, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i17));
        } else {
            this.mDecoder.refreshFaceWithTimeStamp(i3, str, i16, j3, i17);
        }
    }

    public boolean requestDecodeApolloFace(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        return this.mDecoder.requestDecodeFace(str, 200, z16, 116, z17, (byte) 1, 3, i3, false);
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public boolean requestDecodeFace(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.mDecoder.requestDecodeFace(str, 200, false, i3, z16, (byte) 0, getFaceShapeType(i3)) : ((Boolean) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
    }

    public boolean requestDecodeFaceWithFaceInfo(String str, int i3, boolean z16, int i16, boolean z17, byte b16, int i17, QQHeadInfo qQHeadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Boolean.valueOf(z17), Byte.valueOf(b16), Integer.valueOf(i17), qQHeadInfo)).booleanValue();
        }
        return this.mDecoder.requestDecodeFaceWithFaceInfo(str, i3, z16, i16, z17, b16, i17, qQHeadInfo);
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public boolean requestDecodeQCallFace(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        return this.mDecoder.requestDecodeFace(str, i3, z16, 16, z17, (byte) 1, 3);
    }

    public boolean requestDecodeQCallSquareFace(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        return this.mDecoder.requestDecodeFace(str, i3, z16, 16, z17, (byte) 1, 1);
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public boolean requestDecodeStrangeFace(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        return this.mDecoder.requestDecodeFace(str, i3, z16, 32, z17, (byte) 1, 3);
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public boolean requestDecodeStrangeSquareFace(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        return this.mDecoder.requestDecodeFace(str, i3, z16, 32, z17, (byte) 1, 1);
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            this.mDecoder.resume();
        }
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public void setAppRuntime(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) appInterface);
        } else {
            this.mDecoder.setAppRuntime(appInterface);
        }
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public void setDecodeTaskCompletionListener(DecodeTaskCompletionListener decodeTaskCompletionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) decodeTaskCompletionListener);
        } else {
            this.mDecoder.setDecodeTaskCompletionListener(decodeTaskCompletionListener);
        }
    }

    public void setStatDecodeTime(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else {
            this.mDecoder.setStatDecodeTime(z16);
        }
    }

    public void setUserTouchDown(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            this.mDecoder.setUserTouchDown(z16);
        }
    }

    public FaceDecoder(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
            return;
        }
        if (FaceConstant.NEARBY_MODULAR_MODULE_ID.equals(appInterface.getModuleId())) {
            this.mDecoder = new k(appInterface);
        } else if (AvatarOptimiseConfigUtil.b()) {
            this.mDecoder = new ProAvatarFaceDecoderImpl();
        } else {
            this.mDecoder = new FaceDecoderImpl(appInterface);
        }
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public Bitmap getBitmapFromCache(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Bitmap) iPatchRedirector.redirect((short) 17, (Object) this, i3, (Object) str);
        }
        if (i3 == 32) {
            return null;
        }
        byte faceShapeType = getFaceShapeType(i3);
        if (i3 == 101 || i3 == 1001) {
            faceShapeType = 3;
        }
        return this.mDecoder.getBitmapFromCache(i3, str, 0, faceShapeType, 0);
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public Bitmap getBitmapFromCache(int i3, String str, int i16, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? this.mDecoder.getBitmapFromCache(i3, str, i16, b16, 0) : (Bitmap) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Byte.valueOf(b16));
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public boolean requestDecodeFace(String str, int i3, boolean z16, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.mDecoder.requestDecodeFace(str, 200, false, i3, z16, b16, getFaceShapeType(i3)) : ((Boolean) iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Byte.valueOf(b16))).booleanValue();
    }

    @Override // com.tencent.mobileqq.app.face.IFaceDecoder
    public boolean requestDecodeFace(String str, int i3, boolean z16, int i16, boolean z17, byte b16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? this.mDecoder.requestDecodeFace(str, i3, z16, i16, z17, b16, i17) : ((Boolean) iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Boolean.valueOf(z17), Byte.valueOf(b16), Integer.valueOf(i17))).booleanValue();
    }
}
