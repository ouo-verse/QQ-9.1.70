package com.tencent.mobileqq.tinyid.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tinyid.ITinyIDHandler;
import com.tencent.mobileqq.tinyid.impl.TinyIDHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TinyIDHandlerImpl implements ITinyIDHandler {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TinyIDHandlerImpl";
    private AppRuntime mApp;
    private TinyIDHandler mTinyIDHandler;

    public TinyIDHandlerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private TinyIDHandler getTinyIDHandler() {
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof AppInterface)) {
            QLog.e(TAG, 1, "[onCreate] error, not run in AppInterface!");
            return null;
        }
        return (TinyIDHandler) ((AppInterface) appRuntime).getBusinessHandler(TinyIDHandler.class.getName());
    }

    @Override // com.tencent.mobileqq.tinyid.ITinyIDHandler
    public String getClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
            this.mTinyIDHandler = getTinyIDHandler();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tinyid.ITinyIDHandler
    public void removeListener(String str, TinyIDHandler.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        TinyIDHandler tinyIDHandler = this.mTinyIDHandler;
        if (tinyIDHandler != null) {
            tinyIDHandler.H2(str, aVar);
        }
    }

    @Override // com.tencent.mobileqq.tinyid.ITinyIDHandler
    public void reqGetTinyID(TinyIDHandler.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        TinyIDHandler tinyIDHandler = this.mTinyIDHandler;
        if (tinyIDHandler != null) {
            tinyIDHandler.I2(aVar);
        }
    }
}
