package com.tencent.component.animation.rebound;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BouncyConversion {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final double mBounciness;
    private final double mBouncyFriction;
    private final double mBouncyTension;
    private final double mSpeed;

    public BouncyConversion(double d16, double d17) {
        this.mSpeed = d16;
        this.mBounciness = d17;
        double project_normal = project_normal(normalize(d17 / 1.7d, 0.0d, 20.0d), 0.0d, 0.8d);
        double project_normal2 = project_normal(normalize(d16 / 1.7d, 0.0d, 20.0d), 0.5d, 200.0d);
        this.mBouncyTension = project_normal2;
        this.mBouncyFriction = quadratic_out_interpolation(project_normal, b3_nobounce(project_normal2), 0.01d);
    }

    private double b3_friction1(double d16) {
        return ((Math.pow(d16, 3.0d) * 7.0E-4d) - (Math.pow(d16, 2.0d) * 0.031d)) + (d16 * 0.64d) + 1.28d;
    }

    private double b3_friction2(double d16) {
        return ((Math.pow(d16, 3.0d) * 4.4E-5d) - (Math.pow(d16, 2.0d) * 0.006d)) + (d16 * 0.36d) + 2.0d;
    }

    private double b3_friction3(double d16) {
        return ((Math.pow(d16, 3.0d) * 4.5E-7d) - (Math.pow(d16, 2.0d) * 3.32E-4d)) + (d16 * 0.1078d) + 5.84d;
    }

    private double b3_nobounce(double d16) {
        if (d16 <= 18.0d) {
            return b3_friction1(d16);
        }
        if (d16 > 18.0d && d16 <= 44.0d) {
            return b3_friction2(d16);
        }
        if (d16 > 44.0d) {
            return b3_friction3(d16);
        }
        return 0.0d;
    }

    private double linear_interpolation(double d16, double d17, double d18) {
        return (d18 * d16) + ((1.0d - d16) * d17);
    }

    private double normalize(double d16, double d17, double d18) {
        return (d16 - d17) / (d18 - d17);
    }

    private double project_normal(double d16, double d17, double d18) {
        return d17 + (d16 * (d18 - d17));
    }

    private double quadratic_out_interpolation(double d16, double d17, double d18) {
        return linear_interpolation((2.0d * d16) - (d16 * d16), d17, d18);
    }

    public double getBounciness() {
        return this.mBounciness;
    }

    public double getBouncyFriction() {
        return this.mBouncyFriction;
    }

    public double getBouncyTension() {
        return this.mBouncyTension;
    }

    public double getSpeed() {
        return this.mSpeed;
    }
}
