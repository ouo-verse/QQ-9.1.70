package com.tencent.mobileqq.armap.sensor.rotation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static float a(float f16, float f17) {
        return (float) Math.asin(f16 / (f17 * 2.0f));
    }

    public static float b(float f16, float f17) {
        return (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, f16 / (f17 * 2.0f))));
    }

    public static float c(Vector3 vector3, Vector3 vector32) {
        float f16 = vector3.f199786x;
        float f17 = vector32.f199786x;
        float f18 = (f16 - f17) * (f16 - f17);
        float f19 = vector3.f199787y;
        float f26 = vector32.f199787y;
        float f27 = vector3.f199788z;
        float f28 = vector32.f199788z;
        return (float) Math.sqrt(f18 + ((f19 - f26) * (f19 - f26)) + ((f27 - f28) * (f27 - f28)));
    }

    public static float d(float f16, float f17, float f18) {
        float f19 = f16 + f17;
        return (float) (((f16 * f17) * f18) / Math.sqrt((((f19 + f18) * ((f16 - f17) + f18)) * (f19 - f18)) * ((f17 + f18) - f16)));
    }

    public static float e(double d16) {
        return (float) (d16 - (Math.floor(d16 / 360.0d) * 360.0d));
    }
}
