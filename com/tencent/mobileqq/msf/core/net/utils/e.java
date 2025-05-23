package com.tencent.mobileqq.msf.core.net.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f249513a = "RandomUtils";

    /* renamed from: b, reason: collision with root package name */
    private static final Random f249514b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17214);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f249514b = new Random(System.currentTimeMillis());
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a() {
        return f249514b.nextBoolean();
    }

    public static double b() {
        return a(0.0d, Double.MAX_VALUE);
    }

    public static float c() {
        return a(0.0f, Float.MAX_VALUE);
    }

    public static int d() {
        return a(0, Integer.MAX_VALUE);
    }

    public static long e() {
        return a(0L, Long.MAX_VALUE);
    }

    public static byte[] a(int i3) {
        byte[] bArr = new byte[i3];
        f249514b.nextBytes(bArr);
        return bArr;
    }

    public static int a(int i3, int i16) {
        return i3 == i16 ? i3 : i3 + f249514b.nextInt(i16 - i3);
    }

    public static long a(long j3, long j16) {
        return j3 == j16 ? j3 : (long) a(j3, j16);
    }

    public static double a(double d16, double d17) {
        return d16 == d17 ? d16 : d16 + ((d17 - d16) * f249514b.nextDouble());
    }

    public static float a(float f16, float f17) {
        return f16 == f17 ? f16 : f16 + ((f17 - f16) * f249514b.nextFloat());
    }
}
