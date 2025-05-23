package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes27.dex */
public class A48DB {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f381717a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile Pattern[] f381718b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10683);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = LwgsO.f381923o;
        int[] iArr2 = LwgsO.f381925p;
        int[] iArr3 = LwgsO.f381927q;
        int[] iArr4 = LwgsO.f381929r;
        int[] iArr5 = LwgsO.f381931s;
        int[] iArr6 = LwgsO.f381933t;
        int[] iArr7 = LwgsO.f381935u;
        int[] iArr8 = LwgsO.f381937v;
        int[] iArr9 = LwgsO.f381941x;
        int[] iArr10 = LwgsO.E;
        int[] iArr11 = LwgsO.F;
        int[] iArr12 = LwgsO.G;
        int[] iArr13 = LwgsO.H;
        int[] iArr14 = LwgsO.I;
        f381717a = new String[]{LwgsO.a(iArr), LwgsO.a(iArr2), LwgsO.a(iArr3), LwgsO.a(iArr4), LwgsO.a(iArr5), LwgsO.a(iArr6), LwgsO.a(iArr7), LwgsO.a(iArr8), LwgsO.a(LwgsO.f381939w), LwgsO.a(iArr9), LwgsO.a(LwgsO.f381943y), LwgsO.a(LwgsO.f381945z), LwgsO.a(LwgsO.A), LwgsO.a(LwgsO.B), LwgsO.a(LwgsO.C), LwgsO.a(LwgsO.D), LwgsO.a(iArr10), LwgsO.a(iArr11), LwgsO.a(iArr12), LwgsO.a(iArr13), LwgsO.a(iArr14)};
        LwgsO.a(iArr);
        LwgsO.a(iArr2);
        LwgsO.a(iArr3);
        LwgsO.a(iArr4);
        LwgsO.a(iArr5);
        LwgsO.a(iArr6);
        LwgsO.a(iArr7);
        LwgsO.a(iArr8);
        LwgsO.a(iArr9);
        LwgsO.a(iArr10);
        LwgsO.a(iArr11);
        LwgsO.a(iArr12);
        LwgsO.a(iArr13);
        LwgsO.a(iArr14);
        f381718b = null;
    }

    public static synchronized Pattern[] a() {
        synchronized (A48DB.class) {
            if (f381718b != null) {
                return f381718b;
            }
            String[] strArr = f381717a;
            f381718b = new Pattern[strArr.length];
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < f381718b.length; i3++) {
                try {
                    arrayList.add(Pattern.compile(strArr[i3]));
                } catch (Throwable unused) {
                }
            }
            f381718b = (Pattern[]) arrayList.toArray(new Pattern[0]);
            return f381718b;
        }
    }
}
