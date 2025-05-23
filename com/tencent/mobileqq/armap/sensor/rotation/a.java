package com.tencent.mobileqq.armap.sensor.rotation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.startup.step.InitSkin;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Random f199789a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.armap.sensor.rotation.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C7425a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final float[] f199790a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70886);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f199790a = new float[8192];
            for (int i3 = 0; i3 < 8192; i3++) {
                f199790a[i3] = (float) Math.cos(((i3 + 0.5f) / 8192.0f) * 6.2831855f);
            }
            for (int i16 = 0; i16 < 360; i16 += 90) {
                f199790a[((int) (22.755556f * i16)) & InitSkin.DRAWABLE_COUNT] = (float) Math.cos(r2 * 0.017453292f);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final float[] f199791a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70887);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f199791a = new float[8192];
            for (int i3 = 0; i3 < 8192; i3++) {
                f199791a[i3] = (float) Math.sin(((i3 + 0.5f) / 8192.0f) * 6.2831855f);
            }
            for (int i16 = 0; i16 < 360; i16 += 90) {
                f199791a[((int) (22.755556f * i16)) & InitSkin.DRAWABLE_COUNT] = (float) Math.sin(r2 * 0.017453292f);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70888);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f199789a = new Random();
        }
    }

    public static final float a(float f16) {
        return C7425a.f199790a[((int) (f16 * 1303.7972f)) & InitSkin.DRAWABLE_COUNT];
    }

    public static final float b(float f16) {
        return b.f199791a[((int) (f16 * 1303.7972f)) & InitSkin.DRAWABLE_COUNT];
    }
}
