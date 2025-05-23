package com.tencent.tfd.sdk.wxa;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Scorpius {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Centaurus<Sculptor> f375679a;

    /* renamed from: b, reason: collision with root package name */
    public static final Centaurus<Sculptor> f375680b;

    /* renamed from: c, reason: collision with root package name */
    public static long f375681c;

    /* renamed from: d, reason: collision with root package name */
    public static Context f375682d;

    /* renamed from: e, reason: collision with root package name */
    public static final Cdo f375683e;

    /* renamed from: f, reason: collision with root package name */
    public static final Cif f375684f;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Scorpius$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cdo implements Foxnut {
        static IPatchRedirector $redirector_;

        public Cdo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.tfd.sdk.wxa.Foxnut
        public final void a(String str, int i3, int i16, Betelnut betelnut) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), betelnut);
                return;
            }
            if (i16 != 2 && i16 != 3) {
                if (betelnut != null) {
                    j3 = Math.abs(betelnut.f375430a - Scorpius.f375681c);
                } else {
                    j3 = 1000;
                }
                Scorpius.f375681c = System.currentTimeMillis();
                if (j3 < 1000) {
                    return;
                }
                Centaurus<Sculptor> centaurus = Scorpius.f375679a;
                synchronized (centaurus) {
                    centaurus.a(new Sculptor(str, i16, betelnut));
                }
                return;
            }
            Centaurus<Sculptor> centaurus2 = Scorpius.f375680b;
            synchronized (centaurus2) {
                centaurus2.a(new Sculptor(str, i16, betelnut));
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Scorpius$if, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cif implements Celse {
        static IPatchRedirector $redirector_;

        public Cif() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.tfd.sdk.wxa.Celse
        public final void onActivityPaused(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
                return;
            }
            Bilberry a16 = Bilberry.a();
            activity.getApplicationContext();
            a16.a(activity.getClass().getName());
        }

        @Override // com.tencent.tfd.sdk.wxa.Celse
        public final void onActivityResumed(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
                return;
            }
            Bilberry a16 = Bilberry.a();
            Centaurus<Sculptor> centaurus = Scorpius.f375679a;
            a16.a(activity.getClass().getName(), 997, Scorpius.f375683e);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62719);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f375679a = new Centaurus<>(3);
        f375680b = new Centaurus<>(3);
        f375681c = 0L;
        f375683e = new Cdo();
        f375684f = new Cif();
    }
}
