package com.tencent.mobileqq.qqlive.trtc.engine;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public TRTCCloud f273306a;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference<Context> f273307b;

    /* renamed from: c, reason: collision with root package name */
    public String f273308c;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273308c = "";
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d("TRTCEngineContext", 1, "destroy TRTCEngineContext");
        this.f273306a = null;
        this.f273307b = null;
        this.f273308c = "";
    }

    public Context b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        WeakReference<Context> weakReference = this.f273307b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
