package com.tencent.mobileqq.auto.engine.lib;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ASInject {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ASInject";
    private static ASInject sInstance;
    private IASEngineDelegate mASEngineDelegate;
    private IBackEventListener mBackEventListener;
    private IToastDelegate mToastDelegate;

    ASInject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized ASInject g() {
        ASInject aSInject;
        synchronized (ASInject.class) {
            if (sInstance == null) {
                sInstance = new ASInject();
            }
            aSInject = sInstance;
        }
        return aSInject;
    }

    public IASEngineDelegate getAsEngineDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (IASEngineDelegate) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mASEngineDelegate;
    }

    public IBackEventListener getOnBackEventListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IBackEventListener) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mBackEventListener;
    }

    public IToastDelegate getToastDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IToastDelegate) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mToastDelegate;
    }

    public void setAsEngineDelegate(IASEngineDelegate iASEngineDelegate) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iASEngineDelegate);
            return;
        }
        this.mASEngineDelegate = iASEngineDelegate;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setAsEngineDelegate:");
        if (this.mASEngineDelegate == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(hashCode());
        QLog.d(TAG, 1, sb5.toString());
    }

    public ASInject setBackEventListener(IBackEventListener iBackEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ASInject) iPatchRedirector.redirect((short) 5, (Object) this, (Object) iBackEventListener);
        }
        this.mBackEventListener = iBackEventListener;
        return this;
    }

    public ASInject setToastDelegate(IToastDelegate iToastDelegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ASInject) iPatchRedirector.redirect((short) 3, (Object) this, (Object) iToastDelegate);
        }
        if (this.mToastDelegate != null) {
            return this;
        }
        this.mToastDelegate = iToastDelegate;
        return this;
    }
}
