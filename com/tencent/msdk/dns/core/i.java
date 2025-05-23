package com.tencent.msdk.dns.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.msdk.dns.core.i.a;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface i<LookupExtra extends a> {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: a, reason: collision with root package name */
        public static final a f336268a;

        /* compiled from: P */
        /* renamed from: com.tencent.msdk.dns.core.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        class C9215a implements a {
            static IPatchRedirector $redirector_;

            C9215a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(16341), (Class<?>) a.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                f336268a = new C9215a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {

        /* compiled from: P */
        /* loaded from: classes21.dex */
        public interface a {
            boolean a();

            boolean b();

            boolean c();

            boolean d();

            boolean e();
        }

        a a();

        String[] b();

        boolean c();

        void d();

        void e();

        c f();

        i g();

        void h();

        b i();
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface c {
        boolean a();

        boolean e();
    }

    f a();

    b a(n<LookupExtra> nVar);

    d b(o<LookupExtra> oVar);

    d c(o<LookupExtra> oVar);
}
