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
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int count;
    protected CurveFit mCurveFit;
    private String mType;
    protected int[] mTimePoints = new int[10];
    protected float[] mValues = new float[10];

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class AlphaSet extends SplineSet {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
            view.setAlpha(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class CustomSet extends SplineSet {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setPoint(int i3, float f16) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
            this.mCurveFit.getPos(f16, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mTempValues);
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setup(int i3) {
            int size = this.mConstraintAttributeList.size();
            int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[noOfInterpValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, noOfInterpValues);
            for (int i16 = 0; i16 < size; i16++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i16);
                ConstraintAttribute valueAt = this.mConstraintAttributeList.valueAt(i16);
                dArr[i16] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i17 = 0;
                while (true) {
                    if (i17 < this.mTempValues.length) {
                        dArr2[i16][i17] = r6[i17];
                        i17++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(i3, dArr, dArr2);
        }

        public void setPoint(int i3, ConstraintAttribute constraintAttribute) {
            this.mConstraintAttributeList.append(i3, constraintAttribute);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ElevationSet extends SplineSet {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
            view.setElevation(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class PivotXset extends SplineSet {
        PivotXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
            view.setPivotX(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class PivotYset extends SplineSet {
        PivotYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
            view.setPivotY(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ProgressSet extends SplineSet {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f16));
                return;
            }
            if (this.mNoMethod) {
                return;
            }
            try {
                method = view.getClass().getMethod(HippyQQPagView.FunctionName.SET_PROGRESS, Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.mNoMethod = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(get(f16)));
                } catch (IllegalAccessException e16) {
                    Log.e(SplineSet.TAG, "unable to setProgress", e16);
                } catch (InvocationTargetException e17) {
                    Log.e(SplineSet.TAG, "unable to setProgress", e17);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class RotationSet extends SplineSet {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
            view.setRotation(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class RotationXset extends SplineSet {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
            view.setRotationX(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class RotationYset extends SplineSet {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
            view.setRotationY(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ScaleXset extends SplineSet {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
            view.setScaleX(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ScaleYset extends SplineSet {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
            view.setScaleY(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class Sort {
        Sort() {
        }

        static void doubleQuickSort(int[] iArr, float[] fArr, int i3, int i16) {
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

        private static int partition(int[] iArr, float[] fArr, int i3, int i16) {
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

        private static void swap(int[] iArr, float[] fArr, int i3, int i16) {
            int i17 = iArr[i3];
            iArr[i3] = iArr[i16];
            iArr[i16] = i17;
            float f16 = fArr[i3];
            fArr[i3] = fArr[i16];
            fArr[i16] = f16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class TranslationXset extends SplineSet {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
            view.setTranslationX(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class TranslationYset extends SplineSet {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
            view.setTranslationY(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class TranslationZset extends SplineSet {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
            view.setTranslationZ(get(f16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SplineSet makeSpline(String str) {
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
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c16 = '\b';
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c16 = '\t';
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c16 = '\n';
                    break;
                }
                break;
            case -40300674:
                if (str.equals(BasicAnimation.KeyPath.ROTATION)) {
                    c16 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c16 = '\f';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c16 = '\r';
                    break;
                }
                break;
            case 92909918:
                if (str.equals(c.f123400v)) {
                    c16 = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c16 = 15;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return new RotationXset();
            case 1:
                return new RotationYset();
            case 2:
                return new TranslationXset();
            case 3:
                return new TranslationYset();
            case 4:
                return new TranslationZset();
            case 5:
                return new ProgressSet();
            case 6:
                return new ScaleXset();
            case 7:
                return new ScaleYset();
            case '\b':
                return new AlphaSet();
            case '\t':
                return new PivotXset();
            case '\n':
                return new PivotYset();
            case 11:
                return new RotationSet();
            case '\f':
                return new ElevationSet();
            case '\r':
                return new PathRotate();
            case 14:
                return new AlphaSet();
            case 15:
                return new AlphaSet();
            default:
                return null;
        }
    }

    public float get(float f16) {
        return (float) this.mCurveFit.getPos(f16, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f16) {
        return (float) this.mCurveFit.getSlope(f16, 0);
    }

    public void setPoint(int i3, float f16) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.count + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i16 = this.count;
        iArr2[i16] = i3;
        this.mValues[i16] = f16;
        this.count = i16 + 1;
    }

    public abstract void setProperty(View view, float f16);

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i3) {
        int i16 = this.count;
        if (i16 == 0) {
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i16 - 1);
        int i17 = 1;
        for (int i18 = 1; i18 < this.count; i18++) {
            int[] iArr = this.mTimePoints;
            if (iArr[i18 - 1] != iArr[i18]) {
                i17++;
            }
        }
        double[] dArr = new double[i17];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i17, 1);
        int i19 = 0;
        for (int i26 = 0; i26 < this.count; i26++) {
            if (i26 > 0) {
                int[] iArr2 = this.mTimePoints;
                if (iArr2[i26] == iArr2[i26 - 1]) {
                }
            }
            dArr[i19] = this.mTimePoints[i26] * 0.01d;
            dArr2[i19][0] = this.mValues[i26];
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class PathRotate extends SplineSet {
        PathRotate() {
        }

        public void setPathRotate(View view, float f16, double d16, double d17) {
            view.setRotation(get(f16) + ((float) Math.toDegrees(Math.atan2(d17, d16))));
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f16) {
        }
    }
}
