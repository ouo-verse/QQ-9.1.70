package com.tencent.component.animation.rebound;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SpringConfig {
    public static SpringConfig defaultConfig = fromOrigamiTensionAndFriction(40.0d, 7.0d);
    public double friction;
    public double tension;

    public SpringConfig(double d16, double d17) {
        this.tension = d16;
        this.friction = d17;
    }

    public static SpringConfig fromBouncinessAndSpeed(double d16, double d17) {
        BouncyConversion bouncyConversion = new BouncyConversion(d17, d16);
        return fromOrigamiTensionAndFriction(bouncyConversion.getBouncyTension(), bouncyConversion.getBouncyFriction());
    }

    public static SpringConfig fromOrigamiTensionAndFriction(double d16, double d17) {
        return new SpringConfig(OrigamiValueConverter.tensionFromOrigamiValue(d16), OrigamiValueConverter.frictionFromOrigamiValue(d17));
    }
}
