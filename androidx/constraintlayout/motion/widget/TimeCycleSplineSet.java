package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.luggage.wxa.c8.c;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = 6.2831855f;
    private int count;
    long last_time;
    protected CurveFit mCurveFit;
    private String mType;
    protected int mWaveShape = 0;
    protected int[] mTimePoints = new int[10];
    protected float[][] mValues = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);
    private float[] mCache = new float[3];
    protected boolean mContinue = false;
    float last_cycle = Float.NaN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class AlphaSet extends TimeCycleSplineSet {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f16, long j3, KeyCache keyCache) {
            view.setAlpha(get(f16, j3, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setPoint(int i3, float f16, float f17, int i16, float f18) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f16, long j3, KeyCache keyCache) {
            boolean z16;
            this.mCurveFit.getPos(f16, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f17 = fArr[fArr.length - 2];
            float f18 = fArr[fArr.length - 1];
            long j16 = j3 - this.last_time;
            if (Float.isNaN(this.last_cycle)) {
                float floatValue = keyCache.getFloatValue(view, this.mAttributeName, 0);
                this.last_cycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.last_cycle = 0.0f;
                }
            }
            float f19 = (float) ((this.last_cycle + ((j16 * 1.0E-9d) * f17)) % 1.0d);
            this.last_cycle = f19;
            this.last_time = j3;
            float calcWave = calcWave(f19);
            this.mContinue = false;
            int i3 = 0;
            while (true) {
                float[] fArr2 = this.mCache;
                if (i3 >= fArr2.length) {
                    break;
                }
                boolean z17 = this.mContinue;
                float f26 = this.mTempValues[i3];
                if (f26 != 0.0d) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.mContinue = z17 | z16;
                fArr2[i3] = (f26 * calcWave) + f18;
                i3++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mCache);
            if (f17 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setup(int i3) {
            int size = this.mConstraintAttributeList.size();
            int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            int i16 = noOfInterpValues + 2;
            this.mTempValues = new float[i16];
            this.mCache = new float[noOfInterpValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i16);
            for (int i17 = 0; i17 < size; i17++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i17);
                ConstraintAttribute valueAt = this.mConstraintAttributeList.valueAt(i17);
                float[] valueAt2 = this.mWaveProperties.valueAt(i17);
                dArr[i17] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i18 = 0;
                while (true) {
                    if (i18 < this.mTempValues.length) {
                        dArr2[i17][i18] = r8[i18];
                        i18++;
                    }
                }
                double[] dArr3 = dArr2[i17];
                dArr3[noOfInterpValues] = valueAt2[0];
                dArr3[noOfInterpValues + 1] = valueAt2[1];
            }
            this.mCurveFit = CurveFit.get(i3, dArr, dArr2);
        }

        public void setPoint(int i3, ConstraintAttribute constraintAttribute, float f16, int i16, float f17) {
            this.mConstraintAttributeList.append(i3, constraintAttribute);
            this.mWaveProperties.append(i3, new float[]{f16, f17});
            this.mWaveShape = Math.max(this.mWaveShape, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ElevationSet extends TimeCycleSplineSet {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f16, long j3, KeyCache keyCache) {
            view.setElevation(get(f16, j3, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class PathRotate extends TimeCycleSplineSet {
        PathRotate() {
        }

        public boolean setPathRotate(View view, KeyCache keyCache, float f16, long j3, double d16, double d17) {
            view.setRotation(get(f16, j3, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d17, d16))));
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f16, long j3, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ProgressSet extends TimeCycleSplineSet {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f16, long j3, KeyCache keyCache) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f16, j3, view, keyCache));
            } else {
                if (this.mNoMethod) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod(HippyQQPagView.FunctionName.SET_PROGRESS, Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                    method = null;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(get(f16, j3, view, keyCache)));
                    } catch (IllegalAccessException e16) {
                        Log.e(TimeCycleSplineSet.TAG, "unable to setProgress", e16);
                    } catch (InvocationTargetException e17) {
                        Log.e(TimeCycleSplineSet.TAG, "unable to setProgress", e17);
                    }
                }
            }
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class RotationSet extends TimeCycleSplineSet {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f16, long j3, KeyCache keyCache) {
            view.setRotation(get(f16, j3, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class RotationXset extends TimeCycleSplineSet {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f16, long j3, KeyCache keyCache) {
            view.setRotationX(get(f16, j3, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class RotationYset extends TimeCycleSplineSet {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f16, long j3, KeyCache keyCache) {
            view.setRotationY(get(f16, j3, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ScaleXset extends TimeCycleSplineSet {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f16, long j3, KeyCache keyCache) {
            view.setScaleX(get(f16, j3, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ScaleYset extends TimeCycleSplineSet {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f16, long j3, KeyCache keyCache) {
            view.setScaleY(get(f16, j3, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Sort {
        Sort() {
        }

        static void doubleQuickSort(int[] iArr, float[][] fArr, int i3, int i16) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i16;
            iArr2[1] = i3;
            int i17 = 2;
            while (i17 > 0) {
                int i18 = i17 - 1;
                int i19 = iArr2[i18];
                i17 = i18 - 1;
                int i26 = iArr2[i17];
                if (i19 < i26) {
                    int partition = partition(iArr, fArr, i19, i26);
                    int i27 = i17 + 1;
                    iArr2[i17] = partition - 1;
                    int i28 = i27 + 1;
                    iArr2[i27] = i19;
                    int i29 = i28 + 1;
                    iArr2[i28] = i26;
                    i17 = i29 + 1;
                    iArr2[i29] = partition + 1;
                }
            }
        }

        private static int partition(int[] iArr, float[][] fArr, int i3, int i16) {
            int i17 = iArr[i16];
            int i18 = i3;
            while (i3 < i16) {
                if (iArr[i3] <= i17) {
                    swap(iArr, fArr, i18, i3);
                    i18++;
                }
                i3++;
            }
            swap(iArr, fArr, i18, i16);
            return i18;
        }

        private static void swap(int[] iArr, float[][] fArr, int i3, int i16) {
            int i17 = iArr[i3];
            iArr[i3] = iArr[i16];
            iArr[i16] = i17;
            float[] fArr2 = fArr[i3];
            fArr[i3] = fArr[i16];
            fArr[i16] = fArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class TranslationXset extends TimeCycleSplineSet {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f16, long j3, KeyCache keyCache) {
            view.setTranslationX(get(f16, j3, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class TranslationYset extends TimeCycleSplineSet {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f16, long j3, KeyCache keyCache) {
            view.setTranslationY(get(f16, j3, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class TranslationZset extends TimeCycleSplineSet {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f16, long j3, KeyCache keyCache) {
            view.setTranslationZ(get(f16, j3, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TimeCycleSplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:39:0x00a8. Please report as an issue. */
    public static TimeCycleSplineSet makeSpline(String str, long j3) {
        TimeCycleSplineSet rotationXset;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals(BasicAnimation.KeyPath.ROTATION_X)) {
                    c16 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals(BasicAnimation.KeyPath.ROTATION_Y)) {
                    c16 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c16 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c16 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c16 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c16 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals(BasicAnimation.KeyPath.SCALE_X)) {
                    c16 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals(BasicAnimation.KeyPath.SCALE_Y)) {
                    c16 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(BasicAnimation.KeyPath.ROTATION)) {
                    c16 = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c16 = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c16 = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals(c.f123400v)) {
                    c16 = 11;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                rotationXset = new RotationXset();
                rotationXset.setStartTime(j3);
                return rotationXset;
            case 1:
                rotationXset = new RotationYset();
                rotationXset.setStartTime(j3);
                return rotationXset;
            case 2:
                rotationXset = new TranslationXset();
                rotationXset.setStartTime(j3);
                return rotationXset;
            case 3:
                rotationXset = new TranslationYset();
                rotationXset.setStartTime(j3);
                return rotationXset;
            case 4:
                rotationXset = new TranslationZset();
                rotationXset.setStartTime(j3);
                return rotationXset;
            case 5:
                rotationXset = new ProgressSet();
                rotationXset.setStartTime(j3);
                return rotationXset;
            case 6:
                rotationXset = new ScaleXset();
                rotationXset.setStartTime(j3);
                return rotationXset;
            case 7:
                rotationXset = new ScaleYset();
                rotationXset.setStartTime(j3);
                return rotationXset;
            case '\b':
                rotationXset = new RotationSet();
                rotationXset.setStartTime(j3);
                return rotationXset;
            case '\t':
                rotationXset = new ElevationSet();
                rotationXset.setStartTime(j3);
                return rotationXset;
            case '\n':
                rotationXset = new PathRotate();
                rotationXset.setStartTime(j3);
                return rotationXset;
            case 11:
                rotationXset = new AlphaSet();
                rotationXset.setStartTime(j3);
                return rotationXset;
            default:
                return null;
        }
    }

    protected float calcWave(float f16) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f16 * VAL_2PI);
            case 2:
                abs = Math.abs(f16);
                break;
            case 3:
                return (((f16 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f16 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f16 * VAL_2PI);
            case 6:
                float abs2 = 1.0f - Math.abs(((f16 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f16 * VAL_2PI);
        }
        return 1.0f - abs;
    }

    public float get(float f16, long j3, View view, KeyCache keyCache) {
        boolean z16;
        this.mCurveFit.getPos(f16, this.mCache);
        float[] fArr = this.mCache;
        float f17 = fArr[1];
        if (f17 == 0.0f) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            float floatValue = keyCache.getFloatValue(view, this.mType, 0);
            this.last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        float f18 = (float) ((this.last_cycle + (((j3 - this.last_time) * 1.0E-9d) * f17)) % 1.0d);
        this.last_cycle = f18;
        keyCache.setFloatValue(view, this.mType, 0, f18);
        this.last_time = j3;
        float f19 = this.mCache[0];
        float calcWave = (calcWave(this.last_cycle) * f19) + this.mCache[2];
        if (f19 == 0.0f && f17 == 0.0f) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.mContinue = z16;
        return calcWave;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i3, float f16, float f17, int i16, float f18) {
        int[] iArr = this.mTimePoints;
        int i17 = this.count;
        iArr[i17] = i3;
        float[] fArr = this.mValues[i17];
        fArr[0] = f16;
        fArr[1] = f17;
        fArr[2] = f18;
        this.mWaveShape = Math.max(this.mWaveShape, i16);
        this.count++;
    }

    public abstract boolean setProperty(View view, float f16, long j3, KeyCache keyCache);

    protected void setStartTime(long j3) {
        this.last_time = j3;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i3) {
        int i16 = this.count;
        if (i16 == 0) {
            Log.e(TAG, "Error no points added to " + this.mType);
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i16 - 1);
        int i17 = 1;
        int i18 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i17 >= iArr.length) {
                break;
            }
            if (iArr[i17] != iArr[i17 - 1]) {
                i18++;
            }
            i17++;
        }
        if (i18 == 0) {
            i18 = 1;
        }
        double[] dArr = new double[i18];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i18, 3);
        int i19 = 0;
        for (int i26 = 0; i26 < this.count; i26++) {
            if (i26 > 0) {
                int[] iArr2 = this.mTimePoints;
                if (iArr2[i26] == iArr2[i26 - 1]) {
                }
            }
            dArr[i19] = this.mTimePoints[i26] * 0.01d;
            double[] dArr3 = dArr2[i19];
            float[] fArr = this.mValues[i26];
            dArr3[0] = fArr[0];
            dArr3[1] = fArr[1];
            dArr3[2] = fArr[2];
            i19++;
        }
        this.mCurveFit = CurveFit.get(i3, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i3 = 0; i3 < this.count; i3++) {
            str = str + "[" + this.mTimePoints[i3] + " , " + decimalFormat.format(this.mValues[i3]) + "] ";
        }
        return str;
    }
}
