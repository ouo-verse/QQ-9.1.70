package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private final double[] mTime;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent = new double[91];
        boolean linear;
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        Arc(int i3, double d16, double d17, double d18, double d19, double d26, double d27) {
            int i16;
            double d28;
            double d29;
            this.linear = false;
            this.mVertical = i3 == 1;
            this.mTime1 = d16;
            this.mTime2 = d17;
            this.mOneOverDeltaTime = 1.0d / (d17 - d16);
            if (3 == i3) {
                this.linear = true;
            }
            double d36 = d26 - d18;
            double d37 = d27 - d19;
            if (!this.linear && Math.abs(d36) >= 0.001d && Math.abs(d37) >= 0.001d) {
                this.mLut = new double[101];
                boolean z16 = this.mVertical;
                if (z16) {
                    i16 = -1;
                } else {
                    i16 = 1;
                }
                this.mEllipseA = d36 * i16;
                this.mEllipseB = d37 * (z16 ? 1 : -1);
                if (z16) {
                    d28 = d26;
                } else {
                    d28 = d18;
                }
                this.mEllipseCenterX = d28;
                if (z16) {
                    d29 = d19;
                } else {
                    d29 = d27;
                }
                this.mEllipseCenterY = d29;
                buildTable(d18, d19, d26, d27);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.linear = true;
            this.mX1 = d18;
            this.mX2 = d26;
            this.mY1 = d19;
            this.mY2 = d27;
            double hypot = Math.hypot(d37, d36);
            this.mArcDistance = hypot;
            this.mArcVelocity = hypot * this.mOneOverDeltaTime;
            double d38 = this.mTime2;
            double d39 = this.mTime1;
            this.mEllipseCenterX = d36 / (d38 - d39);
            this.mEllipseCenterY = d37 / (d38 - d39);
        }

        private void buildTable(double d16, double d17, double d18, double d19) {
            double d26;
            double d27 = d18 - d16;
            double d28 = d17 - d19;
            int i3 = 0;
            double d29 = 0.0d;
            double d36 = 0.0d;
            double d37 = 0.0d;
            while (true) {
                if (i3 >= ourPercent.length) {
                    break;
                }
                double d38 = d29;
                double radians = Math.toRadians((i3 * 90.0d) / (r15.length - 1));
                double sin = Math.sin(radians) * d27;
                double cos = Math.cos(radians) * d28;
                if (i3 > 0) {
                    d26 = Math.hypot(sin - d36, cos - d37) + d38;
                    ourPercent[i3] = d26;
                } else {
                    d26 = d38;
                }
                i3++;
                d37 = cos;
                d29 = d26;
                d36 = sin;
            }
            double d39 = d29;
            this.mArcDistance = d39;
            int i16 = 0;
            while (true) {
                double[] dArr = ourPercent;
                if (i16 >= dArr.length) {
                    break;
                }
                dArr[i16] = dArr[i16] / d39;
                i16++;
            }
            int i17 = 0;
            while (true) {
                if (i17 < this.mLut.length) {
                    double length = i17 / (r1.length - 1);
                    int binarySearch = Arrays.binarySearch(ourPercent, length);
                    if (binarySearch >= 0) {
                        this.mLut[i17] = binarySearch / (ourPercent.length - 1);
                    } else if (binarySearch == -1) {
                        this.mLut[i17] = 0.0d;
                    } else {
                        int i18 = -binarySearch;
                        int i19 = i18 - 2;
                        double[] dArr2 = ourPercent;
                        double d46 = dArr2[i19];
                        this.mLut[i17] = (i19 + ((length - d46) / (dArr2[i18 - 1] - d46))) / (dArr2.length - 1);
                    }
                    i17++;
                } else {
                    return;
                }
            }
        }

        double getDX() {
            double d16 = this.mEllipseA * this.mTmpCosAngle;
            double hypot = this.mArcVelocity / Math.hypot(d16, (-this.mEllipseB) * this.mTmpSinAngle);
            if (this.mVertical) {
                d16 = -d16;
            }
            return d16 * hypot;
        }

        double getDY() {
            double d16 = this.mEllipseA * this.mTmpCosAngle;
            double d17 = (-this.mEllipseB) * this.mTmpSinAngle;
            double hypot = this.mArcVelocity / Math.hypot(d16, d17);
            if (this.mVertical) {
                return (-d17) * hypot;
            }
            return d17 * hypot;
        }

        public double getLinearDX(double d16) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d16) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d16) {
            double d17 = (d16 - this.mTime1) * this.mOneOverDeltaTime;
            double d18 = this.mX1;
            return d18 + (d17 * (this.mX2 - d18));
        }

        public double getLinearY(double d16) {
            double d17 = (d16 - this.mTime1) * this.mOneOverDeltaTime;
            double d18 = this.mY1;
            return d18 + (d17 * (this.mY2 - d18));
        }

        double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        double lookup(double d16) {
            if (d16 <= 0.0d) {
                return 0.0d;
            }
            if (d16 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d16 * (dArr.length - 1);
            int i3 = (int) length;
            double d17 = length - i3;
            double d18 = dArr[i3];
            return d18 + (d17 * (dArr[i3 + 1] - d18));
        }

        void setPoint(double d16) {
            double d17;
            if (this.mVertical) {
                d17 = this.mTime2 - d16;
            } else {
                d17 = d16 - this.mTime1;
            }
            double lookup = lookup(d17 * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(lookup);
            this.mTmpCosAngle = Math.cos(lookup);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r5 == 1) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i3 = 0;
        int i16 = 1;
        int i17 = 1;
        while (true) {
            Arc[] arcArr = this.mArcs;
            if (i3 < arcArr.length) {
                int i18 = iArr[i3];
                if (i18 != 0) {
                    if (i18 != 1) {
                        if (i18 != 2) {
                            if (i18 == 3) {
                            }
                        }
                        i16 = 2;
                        i17 = i16;
                    }
                    i16 = 1;
                    i17 = i16;
                } else {
                    i17 = 3;
                }
                double d16 = dArr[i3];
                int i19 = i3 + 1;
                double d17 = dArr[i19];
                double[] dArr3 = dArr2[i3];
                double d18 = dArr3[0];
                double d19 = dArr3[1];
                double[] dArr4 = dArr2[i19];
                arcArr[i3] = new Arc(i17, d16, d17, d18, d19, dArr4[0], dArr4[1]);
                i3 = i19;
            } else {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d16, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        double d17 = arcArr[0].mTime1;
        if (d16 < d17) {
            d16 = d17;
        }
        if (d16 > arcArr[arcArr.length - 1].mTime2) {
            d16 = arcArr[arcArr.length - 1].mTime2;
        }
        int i3 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i3 >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i3];
            if (d16 <= arc.mTime2) {
                if (arc.linear) {
                    dArr[0] = arc.getLinearX(d16);
                    dArr[1] = this.mArcs[i3].getLinearY(d16);
                    return;
                } else {
                    arc.setPoint(d16);
                    dArr[0] = this.mArcs[i3].getX();
                    dArr[1] = this.mArcs[i3].getY();
                    return;
                }
            }
            i3++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d16, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        double d17 = arcArr[0].mTime1;
        if (d16 < d17) {
            d16 = d17;
        } else if (d16 > arcArr[arcArr.length - 1].mTime2) {
            d16 = arcArr[arcArr.length - 1].mTime2;
        }
        int i3 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i3 >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i3];
            if (d16 <= arc.mTime2) {
                if (arc.linear) {
                    dArr[0] = arc.getLinearDX(d16);
                    dArr[1] = this.mArcs[i3].getLinearDY(d16);
                    return;
                } else {
                    arc.setPoint(d16);
                    dArr[0] = this.mArcs[i3].getDX();
                    dArr[1] = this.mArcs[i3].getDY();
                    return;
                }
            }
            i3++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d16, float[] fArr) {
        Arc[] arcArr = this.mArcs;
        double d17 = arcArr[0].mTime1;
        if (d16 < d17) {
            d16 = d17;
        } else if (d16 > arcArr[arcArr.length - 1].mTime2) {
            d16 = arcArr[arcArr.length - 1].mTime2;
        }
        int i3 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i3 >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i3];
            if (d16 <= arc.mTime2) {
                if (arc.linear) {
                    fArr[0] = (float) arc.getLinearX(d16);
                    fArr[1] = (float) this.mArcs[i3].getLinearY(d16);
                    return;
                } else {
                    arc.setPoint(d16);
                    fArr[0] = (float) this.mArcs[i3].getX();
                    fArr[1] = (float) this.mArcs[i3].getY();
                    return;
                }
            }
            i3++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d16, int i3) {
        Arc[] arcArr = this.mArcs;
        int i16 = 0;
        double d17 = arcArr[0].mTime1;
        if (d16 < d17) {
            d16 = d17;
        }
        if (d16 > arcArr[arcArr.length - 1].mTime2) {
            d16 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i16 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i16];
            if (d16 <= arc.mTime2) {
                if (arc.linear) {
                    if (i3 == 0) {
                        return arc.getLinearDX(d16);
                    }
                    return arc.getLinearDY(d16);
                }
                arc.setPoint(d16);
                if (i3 == 0) {
                    return this.mArcs[i16].getDX();
                }
                return this.mArcs[i16].getDY();
            }
            i16++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d16, int i3) {
        Arc[] arcArr = this.mArcs;
        int i16 = 0;
        double d17 = arcArr[0].mTime1;
        if (d16 < d17) {
            d16 = d17;
        } else if (d16 > arcArr[arcArr.length - 1].mTime2) {
            d16 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i16 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i16];
            if (d16 <= arc.mTime2) {
                if (arc.linear) {
                    if (i3 == 0) {
                        return arc.getLinearX(d16);
                    }
                    return arc.getLinearY(d16);
                }
                arc.setPoint(d16);
                if (i3 == 0) {
                    return this.mArcs[i16].getX();
                }
                return this.mArcs[i16].getY();
            }
            i16++;
        }
    }
}
