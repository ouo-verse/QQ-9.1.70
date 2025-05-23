package com.tencent.could.huiyansdk.permission;

import android.app.Activity;
import android.app.Dialog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Dialog f100265a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.could.huiyansdk.permission.a f100266b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference<Activity> f100267c;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final c f100268a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12190);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100268a = new c();
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        WeakReference<Activity> weakReference;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f100265a != null && (weakReference = this.f100267c) != null && weakReference.get() != null && !this.f100267c.get().isFinishing()) {
            this.f100265a.cancel();
            this.f100265a = null;
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (this.f100266b != null) {
            this.f100266b = null;
        }
    }
}
