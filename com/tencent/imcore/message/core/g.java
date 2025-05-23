package com.tencent.imcore.message.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

/* compiled from: P */
/* loaded from: classes7.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final WeakHashMap<Lock, Void> f116591a;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final g f116592a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40830);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f116592a = new g();
            }
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116591a = new WeakHashMap<>();
        }
    }

    public static g b() {
        return a.f116592a;
    }

    public void a(StringBuilder sb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sb5);
            return;
        }
        synchronized (this.f116591a) {
            Iterator<Lock> it = this.f116591a.keySet().iterator();
            while (it.hasNext()) {
                try {
                    String obj = it.next().toString();
                    if (!obj.contains("[Unlocked]")) {
                        sb5.append("\n");
                        sb5.append(obj);
                        sb5.append("\n");
                    }
                } catch (Throwable th5) {
                    QLog.e("LockManager", 1, "dump: ", th5);
                }
            }
        }
    }

    public void c(Lock lock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) lock);
            return;
        }
        synchronized (this.f116591a) {
            if (!this.f116591a.containsKey(lock)) {
                this.f116591a.put(lock, null);
            }
        }
    }
}
