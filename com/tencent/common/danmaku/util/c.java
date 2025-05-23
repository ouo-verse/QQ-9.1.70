package com.tencent.common.danmaku.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f99807a;

    /* renamed from: b, reason: collision with root package name */
    private static final Date f99808b;

    /* renamed from: c, reason: collision with root package name */
    private static final StringBuilder f99809c;

    /* renamed from: d, reason: collision with root package name */
    private static final Formatter f99810d;

    /* renamed from: e, reason: collision with root package name */
    private static float f99811e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10434);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f99807a = new SimpleDateFormat("yy\u5e74M\u6708d\u65e5 hh:mm:ss");
        f99808b = new Date();
        StringBuilder sb5 = new StringBuilder();
        f99809c = sb5;
        f99810d = new Formatter(sb5, Locale.getDefault());
        f99811e = -1.0f;
    }

    public static int a(com.tencent.common.danmaku.data.a aVar, com.tencent.common.danmaku.data.a aVar2) {
        int u16;
        int C;
        int w3;
        int J;
        if (aVar == aVar2) {
            return 0;
        }
        if (aVar == null) {
            return -1;
        }
        if (aVar2 == null) {
            return 1;
        }
        if (aVar.equals(aVar2)) {
            return 0;
        }
        long H = aVar.H() - aVar2.H();
        if (H > 0) {
            return 1;
        }
        if (H < 0 || (u16 = aVar.u() - aVar2.u()) > 0) {
            return -1;
        }
        if (u16 < 0 || (C = aVar.C() - aVar2.C()) > 0) {
            return 1;
        }
        if (C < 0 || (w3 = aVar.w() - aVar2.w()) > 0) {
            return -1;
        }
        if (w3 < 0) {
            return 1;
        }
        long s16 = aVar.s() - aVar2.s();
        if (s16 > 0) {
            return -1;
        }
        if (s16 < 0 || (J = aVar.J() - aVar2.J()) > 0) {
            return 1;
        }
        if (J < 0) {
            return -1;
        }
        return J;
    }

    public static int b(float f16) {
        if (f99811e < 0.0f) {
            f99811e = com.tencent.common.danmaku.a.b().a().e().getDisplayMetrics().density;
        }
        return (int) ((f16 * f99811e) + 0.5f);
    }

    public static int c(float f16) {
        float f17 = ((int) f16) + 0.5f;
        if (f16 < f17) {
            return (int) (f17 - 0.5d);
        }
        return (int) (f17 + 0.5f);
    }

    public static boolean d() {
        return true;
    }

    public static int e(com.tencent.common.danmaku.data.a aVar, com.tencent.common.danmaku.data.a aVar2, long j3) {
        boolean z16;
        float f16;
        if (aVar.Q(j3) || aVar2.Q(j3) || !aVar.S() || !aVar2.S()) {
            return -1;
        }
        e.a("getCollision");
        long q16 = aVar2.q();
        float i3 = aVar.i(q16);
        float h16 = aVar2.h(q16);
        long p16 = aVar.p();
        float i16 = aVar.i(p16);
        float h17 = aVar2.h(p16);
        e.d();
        long o16 = aVar.o();
        float f17 = -(aVar2.G() - aVar.G());
        float f18 = -aVar.G();
        boolean z17 = true;
        if (h16 <= i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (h17 > i16) {
            z17 = false;
        }
        float f19 = h16 - i3;
        if (z16) {
            float abs = Math.abs(f19);
            if (f17 <= 0.0f) {
                return (int) (abs / f18);
            }
            f16 = (((float) o16) * f17) + abs;
        } else {
            if (!z17) {
                return 0;
            }
            f16 = (((float) o16) * f17) - f19;
        }
        return (int) (f16 / f18);
    }
}
