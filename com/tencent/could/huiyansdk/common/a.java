package com.tencent.could.huiyansdk.common;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<Activity> f100032a;

    /* renamed from: b, reason: collision with root package name */
    public String f100033b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f100034c;

    /* renamed from: d, reason: collision with root package name */
    public String f100035d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f100036e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f100037f;

    /* compiled from: P */
    /* renamed from: com.tencent.could.huiyansdk.common.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1019a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final a f100038a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21634);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100038a = new a();
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f100034c = false;
        this.f100036e = false;
        this.f100037f = false;
    }
}
