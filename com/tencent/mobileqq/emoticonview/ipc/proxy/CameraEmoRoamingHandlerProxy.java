package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

/* loaded from: classes12.dex */
public class CameraEmoRoamingHandlerProxy extends AbsHandlerProxy<CameraEmoRoamingHandler> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CameraEmoRoamingHandlerProxy";

    public CameraEmoRoamingHandlerProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, CameraEmoRoamingHandler.f194459e);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void notifyUI(int i3, boolean z16, Serializable serializable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), serializable);
            return;
        }
        if (this.businessHandler != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "notifyUI suc\uff1a" + z16);
            }
            ((CameraEmoRoamingHandler) this.businessHandler).notifyUI(i3, z16, serializable);
        }
    }
}
