package com.tencent.mobileqq.splashad;

import com.tencent.gdtad.splash.IGdtSplashAPI;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<Integer, b> f288789a;

    /* renamed from: b, reason: collision with root package name */
    private static p f288790b;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class a implements b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.splashad.p.b
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(1316012);
            }
        }

        @Override // com.tencent.mobileqq.splashad.p.b
        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else if (z16) {
                ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(1316014);
            }
        }

        @Override // com.tencent.mobileqq.splashad.p.b
        public void c(boolean z16) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            IGdtSplashAPI iGdtSplashAPI = (IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class);
            if (z16) {
                i3 = 1316013;
            } else {
                i3 = 1316016;
            }
            iGdtSplashAPI.reportForAnalysis(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    interface b {
        void a(boolean z16);

        void b(boolean z16);

        void c(boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75174);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f288789a = new HashMap<>();
            f288790b = null;
        }
    }

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            f288789a.put(2, new a());
        }
    }

    public static p b() {
        if (f288790b == null) {
            synchronized (p.class) {
                if (f288790b == null) {
                    f288790b = new p();
                }
            }
        }
        return f288790b;
    }

    public b a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        return f288789a.get(Integer.valueOf(i3));
    }
}
