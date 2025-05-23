package com.tencent.mobileqq.ocr.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ocr.api.IOCRHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OCRHandlerImpl implements IOCRHandler {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "OCRHandlerImpl";
    private AppRuntime mApp;
    private OCRHandler mOcrHandler;

    public OCRHandlerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private OCRHandler getOcrHandler() {
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof AppInterface) {
            return (OCRHandler) ((AppInterface) appRuntime).getBusinessHandler(OCRHandler.class.getName());
        }
        QLog.e(TAG, 1, "[onCreate] error, not run in AppInterface!");
        return null;
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCRHandler
    public void batchTranslate(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3);
            return;
        }
        OCRHandler oCRHandler = this.mOcrHandler;
        if (oCRHandler != null) {
            oCRHandler.batchTranslate(str, str2, str3);
        }
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCRHandler
    public String getClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCRHandler
    public boolean getUSING_TEST_SERVERT() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return OCRHandler.f254680h;
    }

    @Override // com.tencent.mobileqq.app.IBusinessHandler
    public void notifyUI(ToServiceMsg toServiceMsg, int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, toServiceMsg, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        OCRHandler oCRHandler = this.mOcrHandler;
        if (oCRHandler != null) {
            oCRHandler.notifyUI(toServiceMsg, i3, z16, obj);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
            this.mOcrHandler = getOcrHandler();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.IBusinessHandler
    public void send(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg);
            return;
        }
        OCRHandler oCRHandler = this.mOcrHandler;
        if (oCRHandler != null) {
            oCRHandler.send(toServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.app.IBusinessHandler
    public void sendPbReq(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) toServiceMsg);
            return;
        }
        OCRHandler oCRHandler = this.mOcrHandler;
        if (oCRHandler != null) {
            oCRHandler.sendPbReq(toServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCRHandler
    public void setUSING_TEST_SERVERT(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            OCRHandler.f254680h = z16;
        }
    }

    @Override // com.tencent.mobileqq.app.IBusinessHandler
    public void notifyUI(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        OCRHandler oCRHandler = this.mOcrHandler;
        if (oCRHandler != null) {
            oCRHandler.notifyUI(i3, z16, obj);
        }
    }

    @Override // com.tencent.mobileqq.app.IBusinessHandler
    public void notifyUI(int i3, boolean z16, Object obj, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj, Boolean.valueOf(z17));
            return;
        }
        OCRHandler oCRHandler = this.mOcrHandler;
        if (oCRHandler != null) {
            oCRHandler.notifyUI(i3, z16, obj, z17);
        }
    }
}
