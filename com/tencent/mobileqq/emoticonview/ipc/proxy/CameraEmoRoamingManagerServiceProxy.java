package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes12.dex */
public class CameraEmoRoamingManagerServiceProxy extends AbsEmoRuntimeServiceProxy<ICameraEmoRoamingManagerService> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CameraEmoRoamingManagerServiceProxy";

    public CameraEmoRoamingManagerServiceProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, ICameraEmoRoamingManagerService.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public boolean getIsNeedShowGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do getIsNeedShowGuide.");
            }
            return ((ICameraEmoRoamingManagerService) this.manager).getIsNeedShowGuide();
        }
        return false;
    }

    public boolean isShowCameraEmoInApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do showCameraEmoInApp.");
            }
            return ((ICameraEmoRoamingManagerService) this.manager).isShowCameraEmoInApp();
        }
        return false;
    }

    public void setIsNeedShowGuide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do IsNeedShowGuide: " + z16);
            }
            ((ICameraEmoRoamingManagerService) this.manager).setIsNeedShowGuide(z16);
        }
    }

    public void syncRoaming() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do syncRoaming.");
            }
            ((ICameraEmoRoamingManagerService) this.manager).syncRoaming();
        }
    }
}
