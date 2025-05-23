package com.tencent.qimei.aa;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f342889a;

    /* renamed from: b, reason: collision with root package name */
    public Context f342890b;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final b f342891a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18595);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f342891a = new b();
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
        } else {
            if (a() == null) {
                return;
            }
            this.f342889a.edit().putBoolean(str, z16).apply();
        }
    }

    public final SharedPreferences a() {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f342889a == null) {
            synchronized (this) {
                if (this.f342889a == null && (context = this.f342890b) != null) {
                    this.f342889a = context.getSharedPreferences("qm_global_sp", 0);
                }
            }
        }
        return this.f342889a;
    }
}
