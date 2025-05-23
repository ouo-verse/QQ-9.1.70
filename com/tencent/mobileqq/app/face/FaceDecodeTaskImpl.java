package com.tencent.mobileqq.app.face;

import android.os.Handler;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarCompatibleService;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQDynamicAvatarService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FaceDecodeTaskImpl extends FaceDecodeTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Q.qqhead.FaceDecodeTaskImpl";
    private final WeakReference<AppInterface> mAppRef;

    public FaceDecodeTaskImpl(AppInterface appInterface, FaceInfo faceInfo, DecodeCompletionListener decodeCompletionListener) {
        super(appInterface, faceInfo, decodeCompletionListener);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appInterface, faceInfo, decodeCompletionListener);
        } else {
            this.mAppRef = new WeakReference<>(appInterface);
        }
    }

    private AppInterface getApp() {
        WeakReference<AppInterface> weakReference = this.mAppRef;
        if (weakReference != null && weakReference.get() != null) {
            return this.mAppRef.get();
        }
        QLog.e(TAG, 1, "AppInterface = null");
        return null;
    }

    private boolean updateUserTypeFaceInfo(Setting setting) {
        if (this.faceInfo.isUserHeadType()) {
            if (setting != null) {
                this.faceInfo.updateZplanAvatarInfoFromSetting(setting);
                if (this.faceInfo.headType != 1) {
                    return true;
                }
                return false;
            }
            QLog.i(TAG, 2, "updateUserTypeFaceInfo setting is null");
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecodeTask
    protected void doDecodeBitmap() {
        StringBuilder sb5;
        Setting setting;
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.faceInfo.markTime(FaceInfo.TIME_BEGIN_DECODE);
        try {
            try {
                try {
                    if (getApp() == null) {
                        this.faceInfo.markTime(FaceInfo.TIME_END_DECODE);
                        try {
                            Handler handler = FaceDecodeTask.handler;
                            if (handler != null) {
                                handler.sendMessage(handler.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(TAG, 1, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.uin, e16);
                            return;
                        }
                    }
                    if (isFaceNotNeedDecode()) {
                        this.faceInfo.markTime(FaceInfo.TIME_END_DECODE);
                        try {
                            Handler handler2 = FaceDecodeTask.handler;
                            if (handler2 != null) {
                                handler2.sendMessage(handler2.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
                                return;
                            }
                            return;
                        } catch (Exception e17) {
                            QLog.e(TAG, 1, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.uin, e17);
                            return;
                        }
                    }
                    if (this.faceInfo.headType != 101) {
                        IQQAvatarDataService iQQAvatarDataService = (IQQAvatarDataService) getApp().getRuntimeService(IQQAvatarDataService.class, "");
                        FaceInfo faceInfo = this.faceInfo;
                        Pair<Boolean, Setting> qQHeadSetting = iQQAvatarDataService.getQQHeadSetting(faceInfo.headType, faceInfo.uin, faceInfo.idType);
                        if (qQHeadSetting != null) {
                            setting = (Setting) qQHeadSetting.second;
                        } else {
                            setting = null;
                        }
                        updateUserTypeFaceInfo(setting);
                        if (qQHeadSetting != null && ((Boolean) qQHeadSetting.first).booleanValue()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            this.faceInfo.faceFileType = (byte) 1;
                            FaceDecoder.requestDownloadFace(getApp(), this.faceInfo);
                        } else {
                            FaceInfo faceInfo2 = this.faceInfo;
                            if (faceInfo2.isDynamicMode && qQHeadSetting != null && ((i3 = faceInfo2.headType) == 1 || i3 == 32)) {
                                IQQDynamicAvatarService iQQDynamicAvatarService = (IQQDynamicAvatarService) getApp().getRuntimeService(IQQDynamicAvatarService.class, "");
                                FaceInfo faceInfo3 = this.faceInfo;
                                if (iQQDynamicAvatarService.isNeed2UpdateSettingInfo(faceInfo3, (Setting) qQHeadSetting.second, faceInfo3.headType)) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i(TAG, 2, "FaceDecodeTaskImpl isNeed2UpdateSettingInfo.");
                                    }
                                    this.faceInfo.faceFileType = (byte) 1;
                                    FaceDecoder.requestDownloadFace(getApp(), this.faceInfo);
                                }
                            }
                        }
                    }
                    IQQAvatarCompatibleService iQQAvatarCompatibleService = (IQQAvatarCompatibleService) getApp().getRuntimeService(IQQAvatarCompatibleService.class, "");
                    FaceInfo faceInfo4 = this.faceInfo;
                    int i16 = faceInfo4.headType;
                    String str = faceInfo4.uin;
                    byte b16 = (byte) faceInfo4.shape;
                    int i17 = faceInfo4.sizeType;
                    byte priority = faceInfo4.getPriority();
                    FaceInfo faceInfo5 = this.faceInfo;
                    this.bitmap = iQQAvatarCompatibleService.getFaceBitmap(i16, str, b16, i17, false, priority, faceInfo5.idType, faceInfo5);
                    if (QLog.isColorLevel() && this.bitmap == null) {
                        QLog.d(TAG, 2, "doDecodeBitmap fail. uin=" + this.faceInfo.uin);
                    }
                    this.faceInfo.markTime(FaceInfo.TIME_END_DECODE);
                    try {
                        Handler handler3 = FaceDecodeTask.handler;
                        if (handler3 != null) {
                            handler3.sendMessage(handler3.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
                        }
                    } catch (Exception e18) {
                        e = e18;
                        sb5 = new StringBuilder();
                        sb5.append("doDecodeBitmap sendMessage exception. uin=");
                        sb5.append(this.faceInfo.uin);
                        QLog.e(TAG, 1, sb5.toString(), e);
                    }
                } catch (OutOfMemoryError e19) {
                    QLog.e(TAG, 1, "doDecodeBitmap OutOfMemoryError. uin=" + this.faceInfo.uin, e19);
                    this.faceInfo.markTime(FaceInfo.TIME_END_DECODE);
                    try {
                        Handler handler4 = FaceDecodeTask.handler;
                        if (handler4 != null) {
                            handler4.sendMessage(handler4.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
                        }
                    } catch (Exception e26) {
                        e = e26;
                        sb5 = new StringBuilder();
                        sb5.append("doDecodeBitmap sendMessage exception. uin=");
                        sb5.append(this.faceInfo.uin);
                        QLog.e(TAG, 1, sb5.toString(), e);
                    }
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "doDecodeBitmap exception. uin=" + this.faceInfo.uin, th5);
                this.faceInfo.markTime(FaceInfo.TIME_END_DECODE);
                try {
                    Handler handler5 = FaceDecodeTask.handler;
                    if (handler5 != null) {
                        handler5.sendMessage(handler5.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
                    }
                } catch (Exception e27) {
                    e = e27;
                    sb5 = new StringBuilder();
                    sb5.append("doDecodeBitmap sendMessage exception. uin=");
                    sb5.append(this.faceInfo.uin);
                    QLog.e(TAG, 1, sb5.toString(), e);
                }
            }
        } catch (Throwable th6) {
            this.faceInfo.markTime(FaceInfo.TIME_END_DECODE);
            try {
                Handler handler6 = FaceDecodeTask.handler;
                if (handler6 != null) {
                    handler6.sendMessage(handler6.obtainMessage(FaceDecodeTask.EVENT_TASK_COMPLETED, this));
                }
            } catch (Exception e28) {
                QLog.e(TAG, 1, "doDecodeBitmap sendMessage exception. uin=" + this.faceInfo.uin, e28);
            }
            throw th6;
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecodeTask
    protected boolean isExpired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (getApp() == null) {
            return true;
        }
        return false;
    }

    public boolean isFaceNotNeedDecode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (getApp() == null) {
            QLog.e(TAG, 1, "isFaceNotNeedDecode getApp null");
            return true;
        }
        int i3 = this.faceInfo.headType;
        if (i3 != 101 && i3 != 1001) {
            if ((i3 == 4 || i3 == 113) && !((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(this.faceInfo.uin)) {
                this.bitmap = ((ITroopHandlerService) getApp().getRuntimeService(ITroopHandlerService.class, "")).getGroupFaceIcon(this.faceInfo.uin, false);
                this.needDownload = false;
                return true;
            }
            IQQAvatarDataService iQQAvatarDataService = (IQQAvatarDataService) getApp().getRuntimeService(IQQAvatarDataService.class, "");
            FaceInfo faceInfo = this.faceInfo;
            Setting setting = (Setting) iQQAvatarDataService.getQQHeadSetting(faceInfo.headType, faceInfo.uin, faceInfo.idType).second;
            if (setting == null) {
                this.needDownload = true;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "doDecodeBitmap, needdown-settingNull, faceInfo=" + this.faceInfo.toString());
                }
                return true;
            }
            updateUserTypeFaceInfo(setting);
            boolean z16 = !iQQAvatarDataService.isFaceFileExist(this.faceInfo);
            this.needDownload = z16;
            if (!z16) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "doDecodeBitmap, needdown-fileNotExit, faceInfo=" + this.faceInfo.toString());
            }
            return true;
        }
        IDiscussionHandlerService iDiscussionHandlerService = (IDiscussionHandlerService) getApp().getRuntimeService(IDiscussionHandlerService.class, "");
        FaceInfo faceInfo2 = this.faceInfo;
        if (faceInfo2.headType == 1001) {
            this.bitmap = iDiscussionHandlerService.getDiscussionFaceIcon(com.tencent.mobileqq.avatar.utils.c.k(faceInfo2.uin), false);
        } else {
            this.bitmap = iDiscussionHandlerService.getDiscussionFaceIcon(faceInfo2.uin, false);
        }
        this.needDownload = false;
        return true;
    }
}
