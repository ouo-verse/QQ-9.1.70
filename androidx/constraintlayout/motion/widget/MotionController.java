package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class MotionController {
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private KeyTrigger[] mKeyTriggers;
    private CurveFit[] mSpline;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    View mView;
    private int mCurveFitType = -1;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int MAX_DIMENSION = 4;
    private float[] mValuesBuff = new float[4];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<Key> mKeyList = new ArrayList<>();
    private int mPathMotionArc = Key.UNSET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MotionController(View view) {
        setView(view);
    }

    private float getAdjustedPosition(float f16, float[] fArr) {
        float f17 = 0.0f;
        float f18 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f19 = this.mStaggerScale;
            if (f19 != 1.0d) {
                float f26 = this.mStaggerOffset;
                if (f16 < f26) {
                    f16 = 0.0f;
                }
                if (f16 > f26 && f16 < 1.0d) {
                    f16 = (f16 - f26) * f19;
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        float f27 = Float.NaN;
        while (it.hasNext()) {
            MotionPaths next = it.next();
            Easing easing2 = next.mKeyFrameEasing;
            if (easing2 != null) {
                float f28 = next.time;
                if (f28 < f16) {
                    easing = easing2;
                    f17 = f28;
                } else if (Float.isNaN(f27)) {
                    f27 = next.time;
                }
            }
        }
        if (easing != null) {
            if (!Float.isNaN(f27)) {
                f18 = f27;
            }
            float f29 = f18 - f17;
            double d16 = (f16 - f17) / f29;
            f16 = (((float) easing.get(d16)) * f29) + f17;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d16);
            }
        }
        return f16;
    }

    private float getPreCycleDistance() {
        float[] fArr = new float[2];
        float f16 = 1.0f / 99;
        double d16 = 0.0d;
        double d17 = 0.0d;
        int i3 = 0;
        float f17 = 0.0f;
        while (i3 < 100) {
            float f18 = i3 * f16;
            double d18 = f18;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f19 = Float.NaN;
            float f26 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                float f27 = f16;
                if (easing2 != null) {
                    float f28 = next.time;
                    if (f28 < f18) {
                        f26 = f28;
                        easing = easing2;
                    } else if (Float.isNaN(f19)) {
                        f19 = next.time;
                    }
                }
                f16 = f27;
            }
            float f29 = f16;
            if (easing != null) {
                if (Float.isNaN(f19)) {
                    f19 = 1.0f;
                }
                d18 = (((float) easing.get((f18 - f26) / r16)) * (f19 - f26)) + f26;
            }
            this.mSpline[0].getPos(d18, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i3 > 0) {
                f17 = (float) (f17 + Math.hypot(d17 - fArr[1], d16 - fArr[0]));
            }
            d16 = fArr[0];
            d17 = fArr[1];
            i3++;
            f16 = f29;
        }
        return f17;
    }

    private void insertKey(MotionPaths motionPaths) {
        if (Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
            Log.e(TAG, " KeyPath positon \"" + motionPaths.position + "\" outside of range");
        }
        this.mMotionPaths.add((-r0) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    void buildBounds(float[] fArr, int i3) {
        float f16 = 1.0f / (i3 - 1);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            hashMap4.get("translationY");
        }
        for (int i16 = 0; i16 < i3; i16++) {
            float f17 = i16 * f16;
            float f18 = this.mStaggerScale;
            float f19 = 0.0f;
            if (f18 != 1.0f) {
                float f26 = this.mStaggerOffset;
                if (f17 < f26) {
                    f17 = 0.0f;
                }
                if (f17 > f26 && f17 < 1.0d) {
                    f17 = (f17 - f26) * f18;
                }
            }
            double d16 = f17;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f27 = Float.NaN;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    float f28 = next.time;
                    if (f28 < f17) {
                        easing = easing2;
                        f19 = f28;
                    } else if (Float.isNaN(f27)) {
                        f27 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f27)) {
                    f27 = 1.0f;
                }
                d16 = (((float) easing.get((f17 - f19) / r12)) * (f27 - f19)) + f19;
            }
            this.mSpline[0].getPos(d16, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d16, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i16 * 2);
        }
    }

    int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                iArr[i3] = it.next().mMode;
                i3++;
            }
        }
        int i16 = 0;
        for (double d16 : timePoints) {
            this.mSpline[0].getPos(d16, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i16);
            i16 += 2;
        }
        return i16 / 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int buildKeyFrames(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                iArr[i3] = it.next().mMode;
                i3++;
            }
        }
        int i16 = 0;
        for (double d16 : timePoints) {
            this.mSpline[0].getPos(d16, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i16);
            i16 += 2;
        }
        return i16 / 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buildPath(float[] fArr, int i3) {
        SplineSet splineSet;
        SplineSet splineSet2;
        KeyCycleOscillator keyCycleOscillator;
        int i16 = i3;
        float f16 = 1.0f;
        float f17 = 1.0f / (i16 - 1);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator2 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 == null) {
            keyCycleOscillator = null;
        } else {
            keyCycleOscillator = hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            keyCycleOscillator2 = hashMap4.get("translationY");
        }
        int i17 = 0;
        while (i17 < i16) {
            float f18 = i17 * f17;
            float f19 = this.mStaggerScale;
            if (f19 != f16) {
                float f26 = this.mStaggerOffset;
                if (f18 < f26) {
                    f18 = 0.0f;
                }
                if (f18 > f26 && f18 < 1.0d) {
                    f18 = (f18 - f26) * f19;
                }
            }
            double d16 = f18;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f27 = Float.NaN;
            float f28 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    float f29 = next.time;
                    if (f29 < f18) {
                        f28 = f29;
                        easing = easing2;
                    } else if (Float.isNaN(f27)) {
                        f27 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f27)) {
                    f27 = 1.0f;
                }
                d16 = (((float) easing.get((f18 - f28) / r17)) * (f27 - f28)) + f28;
            }
            this.mSpline[0].getPos(d16, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d16, dArr);
                }
            }
            int i18 = i17 * 2;
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i18);
            if (keyCycleOscillator != null) {
                fArr[i18] = fArr[i18] + keyCycleOscillator.get(f18);
            } else if (splineSet != null) {
                fArr[i18] = fArr[i18] + splineSet.get(f18);
            }
            if (keyCycleOscillator2 != null) {
                int i19 = i18 + 1;
                fArr[i19] = fArr[i19] + keyCycleOscillator2.get(f18);
            } else if (splineSet2 != null) {
                int i26 = i18 + 1;
                fArr[i26] = fArr[i26] + splineSet2.get(f18);
            }
            i17++;
            i16 = i3;
            f16 = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buildRect(float f16, float[] fArr, int i3) {
        this.mSpline[0].getPos(getAdjustedPosition(f16, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buildRectangles(float[] fArr, int i3) {
        float f16 = 1.0f / (i3 - 1);
        for (int i16 = 0; i16 < i3; i16++) {
            this.mSpline[0].getPos(getAdjustedPosition(i16 * f16, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i16 * 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAttributeValues(String str, float[] fArr, int i3) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i16 = 0; i16 < fArr.length; i16++) {
            fArr[i16] = splineSet.get(i16 / (fArr.length - 1));
        }
        return fArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getDpDt(float f16, float f17, float f18, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f16, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i3 = 0;
        if (curveFitArr != null) {
            double d16 = adjustedPosition;
            curveFitArr[0].getSlope(d16, this.mInterpolateVelocity);
            this.mSpline[0].getPos(d16, this.mInterpolateData);
            float f19 = this.mVelocity[0];
            while (true) {
                dArr = this.mInterpolateVelocity;
                if (i3 >= dArr.length) {
                    break;
                }
                dArr[i3] = dArr[i3] * f19;
                i3++;
            }
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr2 = this.mInterpolateData;
                if (dArr2.length > 0) {
                    curveFit.getPos(d16, dArr2);
                    this.mArcSpline.getSlope(d16, this.mInterpolateVelocity);
                    this.mStartMotionPath.setDpDt(f17, f18, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                    return;
                }
                return;
            }
            this.mStartMotionPath.setDpDt(f17, f18, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        MotionPaths motionPaths = this.mEndMotionPath;
        float f26 = motionPaths.f26463x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f27 = f26 - motionPaths2.f26463x;
        float f28 = motionPaths.f26464y - motionPaths2.f26464y;
        float f29 = (motionPaths.width - motionPaths2.width) + f27;
        float f36 = (motionPaths.height - motionPaths2.height) + f28;
        fArr[0] = (f27 * (1.0f - f17)) + (f29 * f17);
        fArr[1] = (f28 * (1.0f - f18)) + (f36 * f18);
    }

    public int getDrawPath() {
        int i3 = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            i3 = Math.max(i3, it.next().mDrawPath);
        }
        return Math.max(i3, this.mEndMotionPath.mDrawPath);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFinalX() {
        return this.mEndMotionPath.f26463x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFinalY() {
        return this.mEndMotionPath.f26464y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MotionPaths getKeyFrame(int i3) {
        return this.mMotionPaths.get(i3);
    }

    public int getKeyFrameInfo(int i3, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<Key> it = this.mKeyList.iterator();
        int i16 = 0;
        int i17 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            int i18 = next.mType;
            if (i18 == i3 || i3 != -1) {
                iArr[i17] = 0;
                int i19 = i17 + 1;
                iArr[i19] = i18;
                int i26 = i19 + 1;
                iArr[i26] = next.mFramePosition;
                this.mSpline[0].getPos(r8 / 100.0f, this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                int i27 = i26 + 1;
                iArr[i27] = Float.floatToIntBits(fArr[0]);
                int i28 = i27 + 1;
                iArr[i28] = Float.floatToIntBits(fArr[1]);
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    int i29 = i28 + 1;
                    iArr[i29] = keyPosition.mPositionType;
                    int i36 = i29 + 1;
                    iArr[i36] = Float.floatToIntBits(keyPosition.mPercentX);
                    i28 = i36 + 1;
                    iArr[i28] = Float.floatToIntBits(keyPosition.mPercentY);
                }
                int i37 = i28 + 1;
                iArr[i17] = i37 - i17;
                i16++;
                i17 = i37;
            }
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getKeyFrameParameter(int i3, float f16, float f17) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f18 = motionPaths.f26463x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f19 = motionPaths2.f26463x;
        float f26 = f18 - f19;
        float f27 = motionPaths.f26464y;
        float f28 = motionPaths2.f26464y;
        float f29 = f27 - f28;
        float f36 = f19 + (motionPaths2.width / 2.0f);
        float f37 = f28 + (motionPaths2.height / 2.0f);
        float hypot = (float) Math.hypot(f26, f29);
        if (hypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f38 = f16 - f36;
        float f39 = f17 - f37;
        if (((float) Math.hypot(f38, f39)) == 0.0f) {
            return 0.0f;
        }
        float f46 = (f38 * f26) + (f39 * f29);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return 0.0f;
                            }
                            return f39 / f29;
                        }
                        return f38 / f29;
                    }
                    return f39 / f26;
                }
                return f38 / f26;
            }
            return (float) Math.sqrt((hypot * hypot) - (f46 * f46));
        }
        return f46 / hypot;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyPositionBase getPositionKeyframe(int i3, int i16, float f16, float f17) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f18 = motionPaths.f26463x;
        rectF.left = f18;
        float f19 = motionPaths.f26464y;
        rectF.top = f19;
        rectF.right = f18 + motionPaths.width;
        rectF.bottom = f19 + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f26 = motionPaths2.f26463x;
        rectF2.left = f26;
        float f27 = motionPaths2.f26464y;
        rectF2.top = f27;
        rectF2.right = f26 + motionPaths2.width;
        rectF2.bottom = f27 + motionPaths2.height;
        Iterator<Key> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            Key next = it.next();
            if (next instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) next;
                if (keyPositionBase.intersects(i3, i16, rectF, rectF2, f16, f17)) {
                    return keyPositionBase;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getPostLayoutDvDp(float f16, int i3, int i16, float f17, float f18, float[] fArr) {
        SplineSet splineSet;
        SplineSet splineSet2;
        SplineSet splineSet3;
        SplineSet splineSet4;
        SplineSet splineSet5;
        KeyCycleOscillator keyCycleOscillator;
        KeyCycleOscillator keyCycleOscillator2;
        KeyCycleOscillator keyCycleOscillator3;
        KeyCycleOscillator keyCycleOscillator4;
        float adjustedPosition = getAdjustedPosition(f16, this.mVelocity);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator5 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
        if (hashMap3 == null) {
            splineSet3 = null;
        } else {
            splineSet3 = hashMap3.get(BasicAnimation.KeyPath.ROTATION);
        }
        HashMap<String, SplineSet> hashMap4 = this.mAttributesMap;
        if (hashMap4 == null) {
            splineSet4 = null;
        } else {
            splineSet4 = hashMap4.get(BasicAnimation.KeyPath.SCALE_X);
        }
        HashMap<String, SplineSet> hashMap5 = this.mAttributesMap;
        if (hashMap5 == null) {
            splineSet5 = null;
        } else {
            splineSet5 = hashMap5.get(BasicAnimation.KeyPath.SCALE_Y);
        }
        HashMap<String, KeyCycleOscillator> hashMap6 = this.mCycleMap;
        if (hashMap6 == null) {
            keyCycleOscillator = null;
        } else {
            keyCycleOscillator = hashMap6.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap7 = this.mCycleMap;
        if (hashMap7 == null) {
            keyCycleOscillator2 = null;
        } else {
            keyCycleOscillator2 = hashMap7.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap8 = this.mCycleMap;
        if (hashMap8 == null) {
            keyCycleOscillator3 = null;
        } else {
            keyCycleOscillator3 = hashMap8.get(BasicAnimation.KeyPath.ROTATION);
        }
        HashMap<String, KeyCycleOscillator> hashMap9 = this.mCycleMap;
        if (hashMap9 == null) {
            keyCycleOscillator4 = null;
        } else {
            keyCycleOscillator4 = hashMap9.get(BasicAnimation.KeyPath.SCALE_X);
        }
        HashMap<String, KeyCycleOscillator> hashMap10 = this.mCycleMap;
        if (hashMap10 != null) {
            keyCycleOscillator5 = hashMap10.get(BasicAnimation.KeyPath.SCALE_Y);
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d16 = adjustedPosition;
                curveFit.getPos(d16, dArr);
                this.mArcSpline.getSlope(d16, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f17, f18, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f17, f18, i3, i16, fArr);
            return;
        }
        int i17 = 0;
        if (this.mSpline != null) {
            double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
            this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
            float f19 = this.mVelocity[0];
            while (true) {
                double[] dArr2 = this.mInterpolateVelocity;
                if (i17 < dArr2.length) {
                    dArr2[i17] = dArr2[i17] * f19;
                    i17++;
                } else {
                    this.mStartMotionPath.setDpDt(f17, f18, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                    velocityMatrix.applyTransform(f17, f18, i3, i16, fArr);
                    return;
                }
            }
        } else {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f26 = motionPaths.f26463x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f27 = f26 - motionPaths2.f26463x;
            KeyCycleOscillator keyCycleOscillator6 = keyCycleOscillator5;
            float f28 = motionPaths.f26464y - motionPaths2.f26464y;
            KeyCycleOscillator keyCycleOscillator7 = keyCycleOscillator4;
            float f29 = (motionPaths.width - motionPaths2.width) + f27;
            float f36 = (motionPaths.height - motionPaths2.height) + f28;
            fArr[0] = (f27 * (1.0f - f17)) + (f29 * f17);
            fArr[1] = (f28 * (1.0f - f18)) + (f36 * f18);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator7, keyCycleOscillator6, adjustedPosition);
            velocityMatrix.applyTransform(f17, f18, i3, i16, fArr);
        }
    }

    float getStartX() {
        return this.mStartMotionPath.f26463x;
    }

    float getStartY() {
        return this.mStartMotionPath.f26464y;
    }

    public int getkeyFramePositions(int[] iArr, float[] fArr) {
        Iterator<Key> it = this.mKeyList.iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            iArr[i3] = (next.mType * 1000) + next.mFramePosition;
            this.mSpline[0].getPos(r6 / 100.0f, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i16);
            i16 += 2;
            i3++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean interpolate(View view, float f16, long j3, KeyCache keyCache) {
        TimeCycleSplineSet.PathRotate pathRotate;
        boolean z16;
        double d16;
        float adjustedPosition = getAdjustedPosition(f16, null);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            Iterator<SplineSet> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(view, adjustedPosition);
            }
        }
        HashMap<String, TimeCycleSplineSet> hashMap2 = this.mTimeCycleAttributesMap;
        if (hashMap2 != null) {
            pathRotate = null;
            boolean z17 = false;
            for (TimeCycleSplineSet timeCycleSplineSet : hashMap2.values()) {
                if (timeCycleSplineSet instanceof TimeCycleSplineSet.PathRotate) {
                    pathRotate = (TimeCycleSplineSet.PathRotate) timeCycleSplineSet;
                } else {
                    z17 |= timeCycleSplineSet.setProperty(view, adjustedPosition, j3, keyCache);
                }
            }
            z16 = z17;
        } else {
            pathRotate = null;
            z16 = false;
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d17 = adjustedPosition;
            curveFitArr[0].getPos(d17, this.mInterpolateData);
            this.mSpline[0].getSlope(d17, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d17, dArr);
                    this.mArcSpline.getSlope(d17, this.mInterpolateVelocity);
                }
            }
            this.mStartMotionPath.setView(view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
            HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
            if (hashMap3 != null) {
                for (SplineSet splineSet : hashMap3.values()) {
                    if (splineSet instanceof SplineSet.PathRotate) {
                        double[] dArr2 = this.mInterpolateVelocity;
                        ((SplineSet.PathRotate) splineSet).setPathRotate(view, adjustedPosition, dArr2[0], dArr2[1]);
                    }
                }
            }
            if (pathRotate != null) {
                double[] dArr3 = this.mInterpolateVelocity;
                d16 = d17;
                z16 = pathRotate.setPathRotate(view, keyCache, adjustedPosition, j3, dArr3[0], dArr3[1]) | z16;
            } else {
                d16 = d17;
            }
            int i3 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i3 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i3].getPos(d16, this.mValuesBuff);
                this.mStartMotionPath.attributes.get(this.mAttributeNames[i3 - 1]).setInterpolatedValue(view, this.mValuesBuff);
                i3++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (adjustedPosition <= 0.0f) {
                    view.setVisibility(motionConstrainedPoint.visibility);
                } else if (adjustedPosition >= 1.0f) {
                    view.setVisibility(this.mEndPoint.visibility);
                } else if (this.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                    view.setVisibility(0);
                }
            }
            if (this.mKeyTriggers != null) {
                int i16 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                    if (i16 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i16].conditionallyFire(adjustedPosition, view);
                    i16++;
                }
            }
        } else {
            MotionPaths motionPaths = this.mStartMotionPath;
            float f17 = motionPaths.f26463x;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float f18 = f17 + ((motionPaths2.f26463x - f17) * adjustedPosition);
            float f19 = motionPaths.f26464y;
            float f26 = f19 + ((motionPaths2.f26464y - f19) * adjustedPosition);
            float f27 = motionPaths.width;
            float f28 = motionPaths2.width;
            float f29 = motionPaths.height;
            float f36 = motionPaths2.height;
            float f37 = f18 + 0.5f;
            int i17 = (int) f37;
            float f38 = f26 + 0.5f;
            int i18 = (int) f38;
            int i19 = (int) (f37 + ((f28 - f27) * adjustedPosition) + f27);
            int i26 = (int) (f38 + ((f36 - f29) * adjustedPosition) + f29);
            int i27 = i19 - i17;
            int i28 = i26 - i18;
            if (f28 != f27 || f36 != f29) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i27, 1073741824), View.MeasureSpec.makeMeasureSpec(i28, 1073741824));
            }
            view.layout(i17, i18, i19, i26);
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            for (KeyCycleOscillator keyCycleOscillator : hashMap4.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                    double[] dArr4 = this.mInterpolateVelocity;
                    ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(view, adjustedPosition, dArr4[0], dArr4[1]);
                } else {
                    keyCycleOscillator.setProperty(view, adjustedPosition);
                }
            }
        }
        return z16;
    }

    String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f16, float f17, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f18 = motionPaths.f26463x;
        rectF.left = f18;
        float f19 = motionPaths.f26464y;
        rectF.top = f19;
        rectF.right = f18 + motionPaths.width;
        rectF.bottom = f19 + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f26 = motionPaths2.f26463x;
        rectF2.left = f26;
        float f27 = motionPaths2.f26464y;
        rectF2.top = f27;
        rectF2.right = f26 + motionPaths2.width;
        rectF2.bottom = f27 + motionPaths2.height;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f16, f17, strArr, fArr);
    }

    public void setDrawPath(int i3) {
        this.mStartMotionPath.mDrawPath = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEndState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.time = 1.0f;
        motionPaths.position = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
        this.mEndPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setPathMotionArc(int i3) {
        this.mPathMotionArc = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStartCurrentState(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStartState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        readView(motionPaths);
        this.mStartMotionPath.setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(parameters);
        this.mMotionStagger = parameters.motion.mMotionStagger;
        this.mStartPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    public void setup(int i3, int i16, float f16, long j3) {
        ArrayList arrayList;
        String[] strArr;
        boolean z16;
        int i17;
        TimeCycleSplineSet makeSpline;
        ConstraintAttribute constraintAttribute;
        int i18;
        SplineSet makeSpline2;
        ConstraintAttribute constraintAttribute2;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int i19 = this.mPathMotionArc;
        if (i19 != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = i19;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<Key> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            Iterator<Key> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                Key next = it.next();
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    insertKey(new MotionPaths(i3, i16, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i26 = keyPosition.mCurveFit;
                    if (i26 != Key.UNSET) {
                        this.mCurveFitType = i26;
                    }
                } else if (next instanceof KeyCycle) {
                    next.getAttributeNames(hashSet3);
                } else if (next instanceof KeyTimeCycle) {
                    next.getAttributeNames(hashSet);
                } else if (next instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) next);
                } else {
                    next.setInterpolation(hashMap);
                    next.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        int i27 = 0;
        if (arrayList != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        char c16 = 1;
        if (!hashSet2.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            Iterator<String> it5 = hashSet2.iterator();
            while (it5.hasNext()) {
                String next2 = it5.next();
                if (next2.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str = next2.split(",")[1];
                    Iterator<Key> it6 = this.mKeyList.iterator();
                    while (it6.hasNext()) {
                        Key next3 = it6.next();
                        HashMap<String, ConstraintAttribute> hashMap2 = next3.mCustomConstraints;
                        if (hashMap2 != null && (constraintAttribute2 = hashMap2.get(str)) != null) {
                            sparseArray.append(next3.mFramePosition, constraintAttribute2);
                        }
                    }
                    makeSpline2 = SplineSet.makeCustomSpline(next2, sparseArray);
                } else {
                    makeSpline2 = SplineSet.makeSpline(next2);
                }
                if (makeSpline2 != null) {
                    makeSpline2.setType(next2);
                    this.mAttributesMap.put(next2, makeSpline2);
                }
            }
            ArrayList<Key> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                Iterator<Key> it7 = arrayList3.iterator();
                while (it7.hasNext()) {
                    Key next4 = it7.next();
                    if (next4 instanceof KeyAttributes) {
                        next4.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str2 : this.mAttributesMap.keySet()) {
                if (hashMap.containsKey(str2)) {
                    i18 = hashMap.get(str2).intValue();
                } else {
                    i18 = 0;
                }
                this.mAttributesMap.get(str2).setup(i18);
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator<String> it8 = hashSet.iterator();
            while (it8.hasNext()) {
                String next5 = it8.next();
                if (!this.mTimeCycleAttributesMap.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str3 = next5.split(",")[1];
                        Iterator<Key> it9 = this.mKeyList.iterator();
                        while (it9.hasNext()) {
                            Key next6 = it9.next();
                            HashMap<String, ConstraintAttribute> hashMap3 = next6.mCustomConstraints;
                            if (hashMap3 != null && (constraintAttribute = hashMap3.get(str3)) != null) {
                                sparseArray2.append(next6.mFramePosition, constraintAttribute);
                            }
                        }
                        makeSpline = TimeCycleSplineSet.makeCustomSpline(next5, sparseArray2);
                    } else {
                        makeSpline = TimeCycleSplineSet.makeSpline(next5, j3);
                    }
                    if (makeSpline != null) {
                        makeSpline.setType(next5);
                        this.mTimeCycleAttributesMap.put(next5, makeSpline);
                    }
                }
            }
            ArrayList<Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                Iterator<Key> it10 = arrayList4.iterator();
                while (it10.hasNext()) {
                    Key next7 = it10.next();
                    if (next7 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) next7).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str4 : this.mTimeCycleAttributesMap.keySet()) {
                if (hashMap.containsKey(str4)) {
                    i17 = hashMap.get(str4).intValue();
                } else {
                    i17 = 0;
                }
                this.mTimeCycleAttributesMap.get(str4).setup(i17);
            }
        }
        int i28 = 2;
        int size = this.mMotionPaths.size() + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[size];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it11 = this.mMotionPaths.iterator();
        int i29 = 1;
        while (it11.hasNext()) {
            motionPathsArr[i29] = it11.next();
            i29++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str5 : this.mEndMotionPath.attributes.keySet()) {
            if (this.mStartMotionPath.attributes.containsKey(str5)) {
                if (!hashSet2.contains("CUSTOM," + str5)) {
                    hashSet4.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpCount = new int[strArr2.length];
        int i36 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i36 >= strArr.length) {
                break;
            }
            String str6 = strArr[i36];
            this.mAttributeInterpCount[i36] = 0;
            int i37 = 0;
            while (true) {
                if (i37 >= size) {
                    break;
                }
                if (motionPathsArr[i37].attributes.containsKey(str6)) {
                    int[] iArr = this.mAttributeInterpCount;
                    iArr[i36] = iArr[i36] + motionPathsArr[i37].attributes.get(str6).noOfInterpValues();
                    break;
                }
                i37++;
            }
            i36++;
        }
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
            z16 = true;
        } else {
            z16 = false;
        }
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i38 = 1; i38 < size; i38++) {
            motionPathsArr[i38].different(motionPathsArr[i38 - 1], zArr, this.mAttributeNames, z16);
        }
        int i39 = 0;
        for (int i46 = 1; i46 < length; i46++) {
            if (zArr[i46]) {
                i39++;
            }
        }
        int[] iArr2 = new int[i39];
        this.mInterpolateVariables = iArr2;
        this.mInterpolateData = new double[iArr2.length];
        this.mInterpolateVelocity = new double[iArr2.length];
        int i47 = 0;
        for (int i48 = 1; i48 < length; i48++) {
            if (zArr[i48]) {
                this.mInterpolateVariables[i47] = i48;
                i47++;
            }
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, this.mInterpolateVariables.length);
        double[] dArr2 = new double[size];
        for (int i49 = 0; i49 < size; i49++) {
            motionPathsArr[i49].fillStandard(dArr[i49], this.mInterpolateVariables);
            dArr2[i49] = motionPathsArr[i49].time;
        }
        int i56 = 0;
        while (true) {
            int[] iArr3 = this.mInterpolateVariables;
            if (i56 >= iArr3.length) {
                break;
            }
            if (iArr3[i56] < MotionPaths.names.length) {
                String str7 = MotionPaths.names[this.mInterpolateVariables[i56]] + " [";
                for (int i57 = 0; i57 < size; i57++) {
                    str7 = str7 + dArr[i57][i56];
                }
            }
            i56++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i58 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i58 >= strArr3.length) {
                break;
            }
            String str8 = strArr3[i58];
            int i59 = i27;
            int i65 = i59;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i59 < size) {
                if (motionPathsArr[i59].hasCustomData(str8)) {
                    if (dArr4 == null) {
                        dArr3 = new double[size];
                        int[] iArr4 = new int[i28];
                        iArr4[c16] = motionPathsArr[i59].getCustomDataCount(str8);
                        iArr4[i27] = size;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr4);
                    }
                    MotionPaths motionPaths = motionPathsArr[i59];
                    dArr3[i65] = motionPaths.time;
                    motionPaths.getCustomData(str8, dArr4[i65], 0);
                    i65++;
                }
                i59++;
                i28 = 2;
                i27 = 0;
                c16 = 1;
            }
            i58++;
            this.mSpline[i58] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i65), (double[][]) Arrays.copyOf(dArr4, i65));
            i28 = 2;
            i27 = 0;
            c16 = 1;
        }
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
            int[] iArr5 = new int[size];
            double[] dArr5 = new double[size];
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 2);
            for (int i66 = 0; i66 < size; i66++) {
                iArr5[i66] = motionPathsArr[i66].mPathMotionArc;
                dArr5[i66] = r8.time;
                double[] dArr7 = dArr6[i66];
                dArr7[0] = r8.f26463x;
                dArr7[1] = r8.f26464y;
            }
            this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator<String> it12 = hashSet3.iterator();
            float f17 = Float.NaN;
            while (it12.hasNext()) {
                String next8 = it12.next();
                KeyCycleOscillator makeSpline3 = KeyCycleOscillator.makeSpline(next8);
                if (makeSpline3 != null) {
                    if (makeSpline3.variesByPath() && Float.isNaN(f17)) {
                        f17 = getPreCycleDistance();
                    }
                    makeSpline3.setType(next8);
                    this.mCycleMap.put(next8, makeSpline3);
                }
            }
            Iterator<Key> it13 = this.mKeyList.iterator();
            while (it13.hasNext()) {
                Key next9 = it13.next();
                if (next9 instanceof KeyCycle) {
                    ((KeyCycle) next9).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<KeyCycleOscillator> it14 = this.mCycleMap.values().iterator();
            while (it14.hasNext()) {
                it14.next().setup(f17);
            }
        }
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f26463x + " y: " + this.mStartMotionPath.f26464y + " end: x: " + this.mEndMotionPath.f26463x + " y: " + this.mEndMotionPath.f26464y;
    }
}
