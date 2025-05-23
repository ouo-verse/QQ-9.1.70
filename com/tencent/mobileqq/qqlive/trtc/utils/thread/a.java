package com.tencent.mobileqq.qqlive.trtc.utils.thread;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Object f273384a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f273385b;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273384a = null;
            this.f273385b = false;
        }
    }

    public synchronized Object a(@NonNull long j3) throws ExecutionException, InterruptedException, TimeoutException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }
        if (!this.f273385b) {
            wait(j3);
        }
        return this.f273384a;
    }

    public synchronized void b(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, obj);
        } else {
            if (this.f273385b) {
                return;
            }
            this.f273384a = obj;
            this.f273385b = true;
            notifyAll();
        }
    }
}
