package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.regex.Pattern;

/* loaded from: classes26.dex */
public final class Perseus {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f375662a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile Pattern[] f375663b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62702);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = Cswitch.f375811o;
        int[] iArr2 = Cswitch.f375813p;
        int[] iArr3 = Cswitch.f375815q;
        int[] iArr4 = Cswitch.f375817r;
        int[] iArr5 = Cswitch.f375819s;
        int[] iArr6 = Cswitch.f375821t;
        int[] iArr7 = Cswitch.f375823u;
        int[] iArr8 = Cswitch.f375825v;
        int[] iArr9 = Cswitch.f375829x;
        int[] iArr10 = Cswitch.E;
        int[] iArr11 = Cswitch.F;
        int[] iArr12 = Cswitch.G;
        int[] iArr13 = Cswitch.H;
        int[] iArr14 = Cswitch.I;
        f375662a = new String[]{Cswitch.a(iArr), Cswitch.a(iArr2), Cswitch.a(iArr3), Cswitch.a(iArr4), Cswitch.a(iArr5), Cswitch.a(iArr6), Cswitch.a(iArr7), Cswitch.a(iArr8), Cswitch.a(Cswitch.f375827w), Cswitch.a(iArr9), Cswitch.a(Cswitch.f375831y), Cswitch.a(Cswitch.f375833z), Cswitch.a(Cswitch.A), Cswitch.a(Cswitch.B), Cswitch.a(Cswitch.C), Cswitch.a(Cswitch.D), Cswitch.a(iArr10), Cswitch.a(iArr11), Cswitch.a(iArr12), Cswitch.a(iArr13), Cswitch.a(iArr14)};
        Cswitch.a(iArr);
        Cswitch.a(iArr2);
        Cswitch.a(iArr3);
        Cswitch.a(iArr4);
        Cswitch.a(iArr5);
        Cswitch.a(iArr6);
        Cswitch.a(iArr7);
        Cswitch.a(iArr8);
        Cswitch.a(iArr9);
        Cswitch.a(iArr10);
        Cswitch.a(iArr11);
        Cswitch.a(iArr12);
        Cswitch.a(iArr13);
        Cswitch.a(iArr14);
        f375663b = null;
    }
}
