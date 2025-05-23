package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.avatar.api.IQQDynamicAvatarService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes11.dex */
public class j extends FaceDecodeTask {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    AppInterface f195596a;

    public j(AppInterface appInterface, FaceInfo faceInfo, DecodeCompletionListener decodeCompletionListener) {
        super(appInterface, faceInfo, decodeCompletionListener);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appInterface, faceInfo, decodeCompletionListener);
        } else {
            this.f195596a = appInterface;
        }
    }

    private boolean a(IQQAvatarManagerService iQQAvatarManagerService) {
        if (this.needDownload) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap file not exist.. needDownload.faceInfo=" + this.faceInfo);
            }
            FaceInfo faceInfo = this.faceInfo;
            if (faceInfo.mHeadInfo != null) {
                iQQAvatarManagerService.downloadFace(faceInfo);
            }
            return true;
        }
        String str = "stranger_" + Integer.toString(this.faceInfo.idType) + "_" + this.faceInfo.uin;
        Setting faceSetting = iQQAvatarManagerService.getFaceSetting(str);
        if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap key=" + str + ",faceinfo=" + this.faceInfo + ",setting=" + faceSetting);
        }
        if (faceSetting != null) {
            FaceInfo faceInfo2 = this.faceInfo;
            QQHeadInfo qQHeadInfo = faceInfo2.mHeadInfo;
            if (qQHeadInfo != null) {
                if (qQHeadInfo.dwTimestamp > faceSetting.headImgTimestamp) {
                    this.needDownload = true;
                    iQQAvatarManagerService.downloadFace(faceInfo2);
                    return true;
                }
                if (faceInfo2.isDynamicMode) {
                    IQQDynamicAvatarService iQQDynamicAvatarService = (IQQDynamicAvatarService) this.f195596a.getRuntimeService(IQQDynamicAvatarService.class, ProcessConstant.NEARBY);
                    FaceInfo faceInfo3 = this.faceInfo;
                    if (iQQDynamicAvatarService.isNeed2UpdateSettingInfo(faceInfo3, faceSetting, faceInfo3.headType)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "NearbyFaceDecodeTask isNeed2UpdateSettingInfo.");
                        }
                        this.needDownload = true;
                        iQQAvatarManagerService.downloadFace(this.faceInfo);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            if (Math.abs(System.currentTimeMillis() - faceSetting.updateTimestamp) > 86400000) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap need to checkupdate.faceInfo=" + this.faceInfo);
                }
                this.faceInfo.faceFileType = (byte) 1;
                ((FaceHandler) this.f195596a.getBusinessHandler(FaceConstant.Nearby.NEAR_BY_FACE_HANDLER)).G2(this.faceInfo);
                return false;
            }
            return false;
        }
        this.needDownload = true;
        if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap setting is null. faceInfo=" + this.faceInfo);
        }
        FaceInfo faceInfo4 = this.faceInfo;
        if (faceInfo4.mHeadInfo != null) {
            iQQAvatarManagerService.downloadFace(faceInfo4);
        }
        return true;
    }

    private void b(IQQAvatarManagerService iQQAvatarManagerService, j.a aVar) {
        Bitmap bitmap = aVar.f306778a;
        if (bitmap != null) {
            int i3 = this.faceInfo.shape;
            if (i3 != 1) {
                if (i3 != 3) {
                    aVar.f306778a = BaseImageUtil.getRoundFaceBitmap(bitmap, 50, 50);
                } else {
                    aVar.f306778a = BaseImageUtil.getCircleFaceBitmap(bitmap, 50, 50);
                }
            }
            this.bitmap = aVar.f306778a;
            iQQAvatarManagerService.putFaceToCache(this.faceInfo.getFaceBmpCacheKey(), aVar.f306778a, (byte) 1);
        }
        if (this.bitmap == null) {
            QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap fail. uin=" + this.faceInfo.uin);
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecodeTask
    protected void doDecodeBitmap() {
        StringBuilder sb5;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap bengin.faceInfo=" + this.faceInfo);
        }
        this.faceInfo.markTime(FaceInfo.TIME_BEGIN_DECODE);
        try {
            try {
                try {
                    IQQAvatarManagerService iQQAvatarManagerService = (IQQAvatarManagerService) this.f195596a.getRuntimeService(IQQAvatarManagerService.class, ProcessConstant.NEARBY);
                    int i3 = 0;
                    if (!iQQAvatarManagerService.isFaceFileExist(this.faceInfo)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.needDownload = z16;
                    if (a(iQQAvatarManagerService)) {
                        this.faceInfo.markTime(FaceInfo.TIME_END_DECODE);
                        try {
                            FaceDecodeTask.sPendingResultList.add(this);
                            Handler handler = FaceDecodeTask.handler;
                            if (handler != null) {
                                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.uin, e16);
                                return;
                            }
                            return;
                        }
                    }
                    j.a aVar = new j.a();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = FaceConstant.HeadConfig.FACE_BITMAP_CONFIG;
                    do {
                        com.tencent.mobileqq.util.j.e(iQQAvatarManagerService.getFacePath(this.faceInfo), options, aVar);
                        if (aVar.f306779b == 1) {
                            ImageCacheHelper.f98636a.e();
                        }
                        i3++;
                        if (i3 >= 2) {
                            break;
                        }
                    } while (aVar.f306779b == 1);
                    if (QLog.isColorLevel() || aVar.f306779b != 0) {
                        QLog.i("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap decode bitmap.faceInfo=" + this.faceInfo + ",result=" + aVar.f306779b + ", bmp=" + aVar.f306778a);
                    }
                    b(iQQAvatarManagerService, aVar);
                    this.faceInfo.markTime(FaceInfo.TIME_END_DECODE);
                    try {
                        FaceDecodeTask.sPendingResultList.add(this);
                        Handler handler2 = FaceDecodeTask.handler;
                        if (handler2 != null) {
                            handler2.sendMessageAtFrontOfQueue(handler2.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
                        }
                    } catch (Exception e17) {
                        e = e17;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("doDecodeBitmap sendMessage exception. uin=");
                            sb5.append(this.faceInfo.uin);
                            QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, sb5.toString(), e);
                        }
                    }
                } catch (Throwable th5) {
                    QLog.e("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap exception. uin=" + this.faceInfo.uin, th5);
                    this.faceInfo.markTime(FaceInfo.TIME_END_DECODE);
                    try {
                        FaceDecodeTask.sPendingResultList.add(this);
                        Handler handler3 = FaceDecodeTask.handler;
                        if (handler3 != null) {
                            handler3.sendMessageAtFrontOfQueue(handler3.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
                        }
                    } catch (Exception e18) {
                        e = e18;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("doDecodeBitmap sendMessage exception. uin=");
                            sb5.append(this.faceInfo.uin);
                            QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, sb5.toString(), e);
                        }
                    }
                }
            } catch (OutOfMemoryError e19) {
                QLog.e("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap OutOfMemoryError. uin=" + this.faceInfo.uin, e19);
                this.faceInfo.markTime(FaceInfo.TIME_END_DECODE);
                try {
                    FaceDecodeTask.sPendingResultList.add(this);
                    Handler handler4 = FaceDecodeTask.handler;
                    if (handler4 != null) {
                        handler4.sendMessageAtFrontOfQueue(handler4.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
                    }
                } catch (Exception e26) {
                    e = e26;
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                        sb5.append("doDecodeBitmap sendMessage exception. uin=");
                        sb5.append(this.faceInfo.uin);
                        QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, sb5.toString(), e);
                    }
                }
            }
        } catch (Throwable th6) {
            this.faceInfo.markTime(FaceInfo.TIME_END_DECODE);
            try {
                FaceDecodeTask.sPendingResultList.add(this);
                Handler handler5 = FaceDecodeTask.handler;
                if (handler5 != null) {
                    handler5.sendMessageAtFrontOfQueue(handler5.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
                }
            } catch (Exception e27) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.uin, e27);
                }
            }
            throw th6;
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecodeTask
    protected boolean isExpired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f195596a == null) {
            return true;
        }
        return false;
    }
}
