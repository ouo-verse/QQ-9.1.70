package androidx.constraintlayout.motion.utils;

import android.util.Log;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String LINEAR_NAME = "linear";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String STANDARD_NAME = "standard";
    String str = "identity";
    static Easing sDefault = new Easing();
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE_NAME = "decelerate";
    public static String[] NAMED_EASING = {"standard", ACCELERATE_NAME, DECELERATE_NAME, "linear"};

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals(ACCELERATE_NAME)) {
                    c16 = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals(DECELERATE_NAME)) {
                    c16 = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return new CubicEasing(ACCELERATE);
            case 1:
                return new CubicEasing(DECELERATE);
            case 2:
                return new CubicEasing(LINEAR);
            case 3:
                return new CubicEasing(STANDARD);
            default:
                Log.e("ConstraintSet", "transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double getDiff(double d16) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;

        /* renamed from: x1, reason: collision with root package name */
        double f26456x1;

        /* renamed from: x2, reason: collision with root package name */
        double f26457x2;

        /* renamed from: y1, reason: collision with root package name */
        double f26458y1;

        /* renamed from: y2, reason: collision with root package name */
        double f26459y2;

        CubicEasing(String str) {
            this.str = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f26456x1 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i3 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i3);
            this.f26458y1 = Double.parseDouble(str.substring(i3, indexOf3).trim());
            int i16 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i16);
            this.f26457x2 = Double.parseDouble(str.substring(i16, indexOf4).trim());
            int i17 = indexOf4 + 1;
            this.f26459y2 = Double.parseDouble(str.substring(i17, str.indexOf(41, i17)).trim());
        }

        private double getDiffX(double d16) {
            double d17 = 1.0d - d16;
            double d18 = this.f26456x1;
            double d19 = this.f26457x2;
            return (d17 * 3.0d * d17 * d18) + (d17 * 6.0d * d16 * (d19 - d18)) + (3.0d * d16 * d16 * (1.0d - d19));
        }

        private double getDiffY(double d16) {
            double d17 = 1.0d - d16;
            double d18 = this.f26458y1;
            double d19 = this.f26459y2;
            return (d17 * 3.0d * d17 * d18) + (d17 * 6.0d * d16 * (d19 - d18)) + (3.0d * d16 * d16 * (1.0d - d19));
        }

        private double getX(double d16) {
            double d17 = 1.0d - d16;
            double d18 = 3.0d * d17;
            return (this.f26456x1 * d17 * d18 * d16) + (this.f26457x2 * d18 * d16 * d16) + (d16 * d16 * d16);
        }

        private double getY(double d16) {
            double d17 = 1.0d - d16;
            double d18 = 3.0d * d17;
            return (this.f26458y1 * d17 * d18 * d16) + (this.f26459y2 * d18 * d16 * d16) + (d16 * d16 * d16);
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double get(double d16) {
            if (d16 <= 0.0d) {
                return 0.0d;
            }
            if (d16 >= 1.0d) {
                return 1.0d;
            }
            double d17 = 0.5d;
            double d18 = 0.5d;
            while (d17 > error) {
                d17 *= 0.5d;
                if (getX(d18) < d16) {
                    d18 += d17;
                } else {
                    d18 -= d17;
                }
            }
            double d19 = d18 - d17;
            double x16 = getX(d19);
            double d26 = d18 + d17;
            double x17 = getX(d26);
            double y16 = getY(d19);
            return (((getY(d26) - y16) * (d16 - x16)) / (x17 - x16)) + y16;
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double getDiff(double d16) {
            double d17 = 0.5d;
            double d18 = 0.5d;
            while (d17 > d_error) {
                d17 *= 0.5d;
                if (getX(d18) < d16) {
                    d18 += d17;
                } else {
                    d18 -= d17;
                }
            }
            double d19 = d18 - d17;
            double x16 = getX(d19);
            double d26 = d18 + d17;
            return (getY(d26) - getY(d19)) / (getX(d26) - x16);
        }

        void setup(double d16, double d17, double d18, double d19) {
            this.f26456x1 = d16;
            this.f26458y1 = d17;
            this.f26457x2 = d18;
            this.f26459y2 = d19;
        }

        public CubicEasing(double d16, double d17, double d18, double d19) {
            setup(d16, d17, d18, d19);
        }
    }

    public double get(double d16) {
        return d16;
    }
}
