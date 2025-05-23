package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Core {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f382656a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile Pattern[] f382657b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11346);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = Ccontinue.f383290o;
        int[] iArr2 = Ccontinue.f383292p;
        int[] iArr3 = Ccontinue.f383294q;
        int[] iArr4 = Ccontinue.f383296r;
        int[] iArr5 = Ccontinue.f383298s;
        int[] iArr6 = Ccontinue.f383300t;
        int[] iArr7 = Ccontinue.f383302u;
        int[] iArr8 = Ccontinue.f383304v;
        int[] iArr9 = Ccontinue.f383308x;
        int[] iArr10 = Ccontinue.E;
        int[] iArr11 = Ccontinue.F;
        int[] iArr12 = Ccontinue.G;
        int[] iArr13 = Ccontinue.H;
        int[] iArr14 = Ccontinue.I;
        f382656a = new String[]{Ccontinue.a(iArr), Ccontinue.a(iArr2), Ccontinue.a(iArr3), Ccontinue.a(iArr4), Ccontinue.a(iArr5), Ccontinue.a(iArr6), Ccontinue.a(iArr7), Ccontinue.a(iArr8), Ccontinue.a(Ccontinue.f383306w), Ccontinue.a(iArr9), Ccontinue.a(Ccontinue.f383310y), Ccontinue.a(Ccontinue.f383312z), Ccontinue.a(Ccontinue.A), Ccontinue.a(Ccontinue.B), Ccontinue.a(Ccontinue.C), Ccontinue.a(Ccontinue.D), Ccontinue.a(iArr10), Ccontinue.a(iArr11), Ccontinue.a(iArr12), Ccontinue.a(iArr13), Ccontinue.a(iArr14)};
        Ccontinue.a(iArr);
        Ccontinue.a(iArr2);
        Ccontinue.a(iArr3);
        Ccontinue.a(iArr4);
        Ccontinue.a(iArr5);
        Ccontinue.a(iArr6);
        Ccontinue.a(iArr7);
        Ccontinue.a(iArr8);
        Ccontinue.a(iArr9);
        Ccontinue.a(iArr10);
        Ccontinue.a(iArr11);
        Ccontinue.a(iArr12);
        Ccontinue.a(iArr13);
        Ccontinue.a(iArr14);
        f382657b = null;
    }

    public static synchronized Pattern[] a() {
        synchronized (Core.class) {
            if (f382657b != null) {
                return f382657b;
            }
            String[] strArr = f382656a;
            f382657b = new Pattern[strArr.length];
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < f382657b.length; i3++) {
                try {
                    arrayList.add(Pattern.compile(strArr[i3]));
                } catch (Throwable unused) {
                }
            }
            f382657b = (Pattern[]) arrayList.toArray(new Pattern[0]);
            return f382657b;
        }
    }
}
