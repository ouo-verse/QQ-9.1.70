package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 3;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", HippyTKDListViewAdapter.X, "y", "width", "height", "pathRotate"};
    LinkedHashMap<String, ConstraintAttribute> attributes;
    float height;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;

    /* renamed from: x, reason: collision with root package name */
    float f26463x;

    /* renamed from: y, reason: collision with root package name */
    float f26464y;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f16, float f17) {
        if (!Float.isNaN(f16) && !Float.isNaN(f17)) {
            if (Math.abs(f16 - f17) > 1.0E-6f) {
                return true;
            }
            return false;
        }
        if (Float.isNaN(f16) != Float.isNaN(f17)) {
            return true;
        }
        return false;
    }

    private static final float xRotate(float f16, float f17, float f18, float f19, float f26, float f27) {
        return (((f26 - f18) * f17) - ((f27 - f19) * f16)) + f18;
    }

    private static final float yRotate(float f16, float f17, float f18, float f19, float f26, float f27) {
        return ((f26 - f18) * f16) + ((f27 - f19) * f17) + f19;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mProgress = constraint.propertySet.mProgress;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z16) {
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        zArr[1] = zArr[1] | diff(this.f26463x, motionPaths.f26463x) | z16;
        zArr[2] = z16 | diff(this.f26464y, motionPaths.f26464y) | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.f26463x, this.f26464y, this.width, this.height, this.mPathRotate};
        int i3 = 0;
        for (int i16 : iArr) {
            if (i16 < 6) {
                dArr[i3] = fArr[r4];
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i3) {
        float f16 = this.width;
        float f17 = this.height;
        for (int i16 = 0; i16 < iArr.length; i16++) {
            float f18 = (float) dArr[i16];
            int i17 = iArr[i16];
            if (i17 != 3) {
                if (i17 == 4) {
                    f17 = f18;
                }
            } else {
                f16 = f18;
            }
        }
        fArr[i3] = f16;
        fArr[i3 + 1] = f17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getCenter(int[] iArr, double[] dArr, float[] fArr, int i3) {
        float f16 = this.f26463x;
        float f17 = this.f26464y;
        float f18 = this.width;
        float f19 = this.height;
        for (int i16 = 0; i16 < iArr.length; i16++) {
            float f26 = (float) dArr[i16];
            int i17 = iArr[i16];
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 3) {
                        if (i17 == 4) {
                            f19 = f26;
                        }
                    } else {
                        f18 = f26;
                    }
                } else {
                    f17 = f26;
                }
            } else {
                f16 = f26;
            }
        }
        fArr[i3] = f16 + (f18 / 2.0f) + 0.0f;
        fArr[i3 + 1] = f17 + (f19 / 2.0f) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCustomData(String str, double[] dArr, int i3) {
        ConstraintAttribute constraintAttribute = this.attributes.get(str);
        if (constraintAttribute.noOfInterpValues() == 1) {
            dArr[i3] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int noOfInterpValues = constraintAttribute.noOfInterpValues();
        constraintAttribute.getValuesToInterpolate(new float[noOfInterpValues]);
        int i16 = 0;
        while (i16 < noOfInterpValues) {
            dArr[i3] = r1[i16];
            i16++;
            i3++;
        }
        return noOfInterpValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCustomDataCount(String str) {
        return this.attributes.get(str).noOfInterpValues();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i3) {
        float f16 = this.f26463x;
        float f17 = this.f26464y;
        float f18 = this.width;
        float f19 = this.height;
        for (int i16 = 0; i16 < iArr.length; i16++) {
            float f26 = (float) dArr[i16];
            int i17 = iArr[i16];
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 3) {
                        if (i17 == 4) {
                            f19 = f26;
                        }
                    } else {
                        f18 = f26;
                    }
                } else {
                    f17 = f26;
                }
            } else {
                f16 = f26;
            }
        }
        float f27 = f18 + f16;
        float f28 = f19 + f17;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i18 = i3 + 1;
        fArr[i3] = f16 + 0.0f;
        int i19 = i18 + 1;
        fArr[i18] = f17 + 0.0f;
        int i26 = i19 + 1;
        fArr[i19] = f27 + 0.0f;
        int i27 = i26 + 1;
        fArr[i26] = f17 + 0.0f;
        int i28 = i27 + 1;
        fArr[i27] = f27 + 0.0f;
        int i29 = i28 + 1;
        fArr[i28] = f28 + 0.0f;
        fArr[i29] = f16 + 0.0f;
        fArr[i29 + 1] = f28 + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasCustomData(String str) {
        return this.attributes.containsKey(str);
    }

    void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26 = keyPosition.mFramePosition / 100.0f;
        this.time = f26;
        this.mDrawPath = keyPosition.mDrawPath;
        if (Float.isNaN(keyPosition.mPercentWidth)) {
            f16 = f26;
        } else {
            f16 = keyPosition.mPercentWidth;
        }
        if (Float.isNaN(keyPosition.mPercentHeight)) {
            f17 = f26;
        } else {
            f17 = keyPosition.mPercentHeight;
        }
        float f27 = motionPaths2.width;
        float f28 = motionPaths.width;
        float f29 = motionPaths2.height;
        float f36 = motionPaths.height;
        this.position = this.time;
        float f37 = motionPaths.f26463x;
        float f38 = motionPaths.f26464y;
        float f39 = (motionPaths2.f26463x + (f27 / 2.0f)) - ((f28 / 2.0f) + f37);
        float f46 = (motionPaths2.f26464y + (f29 / 2.0f)) - (f38 + (f36 / 2.0f));
        float f47 = ((f27 - f28) * f16) / 2.0f;
        this.f26463x = (int) ((f37 + (f39 * f26)) - f47);
        float f48 = ((f29 - f36) * f17) / 2.0f;
        this.f26464y = (int) ((f38 + (f46 * f26)) - f48);
        this.width = (int) (f28 + r9);
        this.height = (int) (f36 + r12);
        if (Float.isNaN(keyPosition.mPercentX)) {
            f18 = f26;
        } else {
            f18 = keyPosition.mPercentX;
        }
        float f49 = 0.0f;
        if (Float.isNaN(keyPosition.mAltPercentY)) {
            f19 = 0.0f;
        } else {
            f19 = keyPosition.mAltPercentY;
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f26 = keyPosition.mPercentY;
        }
        if (!Float.isNaN(keyPosition.mAltPercentX)) {
            f49 = keyPosition.mAltPercentX;
        }
        this.mMode = 2;
        this.f26463x = (int) (((motionPaths.f26463x + (f18 * f39)) + (f49 * f46)) - f47);
        this.f26464y = (int) (((motionPaths.f26464y + (f39 * f19)) + (f46 * f26)) - f48);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f16;
        float f17;
        float f18;
        float f19 = keyPosition.mFramePosition / 100.0f;
        this.time = f19;
        this.mDrawPath = keyPosition.mDrawPath;
        if (Float.isNaN(keyPosition.mPercentWidth)) {
            f16 = f19;
        } else {
            f16 = keyPosition.mPercentWidth;
        }
        if (Float.isNaN(keyPosition.mPercentHeight)) {
            f17 = f19;
        } else {
            f17 = keyPosition.mPercentHeight;
        }
        float f26 = motionPaths2.width - motionPaths.width;
        float f27 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            f19 = keyPosition.mPercentX;
        }
        float f28 = motionPaths.f26463x;
        float f29 = motionPaths.width;
        float f36 = motionPaths.f26464y;
        float f37 = motionPaths.height;
        float f38 = (motionPaths2.f26463x + (motionPaths2.width / 2.0f)) - ((f29 / 2.0f) + f28);
        float f39 = (motionPaths2.f26464y + (motionPaths2.height / 2.0f)) - ((f37 / 2.0f) + f36);
        float f46 = f38 * f19;
        float f47 = (f26 * f16) / 2.0f;
        this.f26463x = (int) ((f28 + f46) - f47);
        float f48 = f19 * f39;
        float f49 = (f27 * f17) / 2.0f;
        this.f26464y = (int) ((f36 + f48) - f49);
        this.width = (int) (f29 + r7);
        this.height = (int) (f37 + r8);
        if (Float.isNaN(keyPosition.mPercentY)) {
            f18 = 0.0f;
        } else {
            f18 = keyPosition.mPercentY;
        }
        this.mMode = 1;
        float f56 = (int) ((motionPaths.f26463x + f46) - f47);
        float f57 = (int) ((motionPaths.f26464y + f48) - f49);
        this.f26463x = f56 + ((-f39) * f18);
        this.f26464y = f57 + (f38 * f18);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    void initScreen(int i3, int i16, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f16;
        float f17;
        float f18 = keyPosition.mFramePosition / 100.0f;
        this.time = f18;
        this.mDrawPath = keyPosition.mDrawPath;
        if (Float.isNaN(keyPosition.mPercentWidth)) {
            f16 = f18;
        } else {
            f16 = keyPosition.mPercentWidth;
        }
        if (Float.isNaN(keyPosition.mPercentHeight)) {
            f17 = f18;
        } else {
            f17 = keyPosition.mPercentHeight;
        }
        float f19 = motionPaths2.width;
        float f26 = motionPaths.width;
        float f27 = motionPaths2.height;
        float f28 = motionPaths.height;
        this.position = this.time;
        float f29 = motionPaths.f26463x;
        float f36 = motionPaths.f26464y;
        float f37 = motionPaths2.f26463x + (f19 / 2.0f);
        float f38 = motionPaths2.f26464y + (f27 / 2.0f);
        float f39 = (f19 - f26) * f16;
        this.f26463x = (int) ((f29 + ((f37 - ((f26 / 2.0f) + f29)) * f18)) - (f39 / 2.0f));
        float f46 = (f27 - f28) * f17;
        this.f26464y = (int) ((f36 + ((f38 - (f36 + (f28 / 2.0f))) * f18)) - (f46 / 2.0f));
        this.width = (int) (f26 + f39);
        this.height = (int) (f28 + f46);
        this.mMode = 3;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            this.f26463x = (int) (keyPosition.mPercentX * ((int) (i3 - this.width)));
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            this.f26464y = (int) (keyPosition.mPercentY * ((int) (i16 - this.height)));
        }
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBounds(float f16, float f17, float f18, float f19) {
        this.f26463x = f16;
        this.f26464y = f17;
        this.width = f18;
        this.height = f19;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDpDt(float f16, float f17, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f26 = 0.0f;
        float f27 = 0.0f;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f28 = (float) dArr[i3];
            double d16 = dArr2[i3];
            int i16 = iArr[i3];
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 == 4) {
                            f27 = f28;
                        }
                    } else {
                        f19 = f28;
                    }
                } else {
                    f26 = f28;
                }
            } else {
                f18 = f28;
            }
        }
        float f29 = f18 - ((0.0f * f19) / 2.0f);
        float f36 = f26 - ((0.0f * f27) / 2.0f);
        fArr[0] = (f29 * (1.0f - f16)) + (((f19 * 1.0f) + f29) * f16) + 0.0f;
        fArr[1] = (f36 * (1.0f - f17)) + (((f27 * 1.0f) + f36) * f17) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setView(View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        boolean z16;
        float f16;
        float f17;
        boolean z17;
        float f18 = this.f26463x;
        float f19 = this.f26464y;
        float f26 = this.width;
        float f27 = this.height;
        boolean z18 = true;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i3 = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i3];
            this.mTempDelta = new double[i3];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i16 = 0; i16 < iArr.length; i16++) {
            double[] dArr4 = this.mTempValue;
            int i17 = iArr[i16];
            dArr4[i17] = dArr[i16];
            this.mTempDelta[i17] = dArr2[i16];
        }
        int i18 = 0;
        float f28 = Float.NaN;
        float f29 = 0.0f;
        float f36 = 0.0f;
        float f37 = 0.0f;
        float f38 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i18 >= dArr5.length) {
                break;
            }
            double d16 = 0.0d;
            if (Double.isNaN(dArr5[i18]) && (dArr3 == null || dArr3[i18] == 0.0d)) {
                f17 = f18;
                z17 = z18;
            } else {
                if (dArr3 != null) {
                    d16 = dArr3[i18];
                }
                if (!Double.isNaN(this.mTempValue[i18])) {
                    d16 = this.mTempValue[i18] + d16;
                }
                f16 = (float) d16;
                f17 = f18;
                float f39 = (float) this.mTempDelta[i18];
                z17 = true;
                if (i18 != 1) {
                    if (i18 != 2) {
                        if (i18 != 3) {
                            if (i18 != 4) {
                                if (i18 == 5) {
                                    f28 = f16;
                                }
                            } else {
                                f38 = f39;
                                f27 = f16;
                            }
                        } else {
                            f36 = f39;
                            f26 = f16;
                        }
                    } else {
                        f37 = f39;
                        f19 = f16;
                    }
                } else {
                    f29 = f39;
                    i18++;
                    z18 = z17;
                    f18 = f16;
                }
            }
            f16 = f17;
            i18++;
            z18 = z17;
            f18 = f16;
        }
        float f46 = f18;
        boolean z19 = z18;
        if (Float.isNaN(f28)) {
            if (!Float.isNaN(Float.NaN)) {
                view.setRotation(Float.NaN);
            }
        } else {
            float f47 = Float.NaN;
            if (Float.isNaN(Float.NaN)) {
                f47 = 0.0f;
            }
            view.setRotation((float) (f47 + f28 + Math.toDegrees(Math.atan2(f37 + (f38 / 2.0f), f29 + (f36 / 2.0f)))));
        }
        float f48 = f46 + 0.5f;
        int i19 = (int) f48;
        float f49 = f19 + 0.5f;
        int i26 = (int) f49;
        int i27 = (int) (f48 + f26);
        int i28 = (int) (f49 + f27);
        int i29 = i27 - i19;
        int i36 = i28 - i26;
        if (i29 == view.getMeasuredWidth() && i36 == view.getMeasuredHeight()) {
            z16 = false;
        } else {
            z16 = z19;
        }
        if (z16) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i29, 1073741824), View.MeasureSpec.makeMeasureSpec(i36, 1073741824));
        }
        view.layout(i19, i26, i27, i28);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public MotionPaths(int i3, int i16, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        int i17 = keyPosition.mPositionType;
        if (i17 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
        } else if (i17 != 2) {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i3, i16, keyPosition, motionPaths, motionPaths2);
        }
    }
}
