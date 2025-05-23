package androidx.constraintlayout.motion.widget;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Oscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.luggage.wxa.c8.c;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    protected ConstraintAttribute mCustom;
    private CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class AlphaSet extends KeyCycleOscillator {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f16) {
            view.setAlpha(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class CustomSet extends KeyCycleOscillator {
        float[] value = new float[1];

        CustomSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f16) {
            this.value[0] = get(f16);
            this.mCustom.setInterpolatedValue(view, this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        float[] mOffset;
        float mPathLength;
        float[] mPeriod;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;
        Oscillator mOscillator = new Oscillator();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();

        CycleOscillator(int i3, int i16, int i17) {
            this.mWaveShape = i3;
            this.mVariesBy = i16;
            this.mOscillator.setType(i3);
            this.mValues = new float[i17];
            this.mPosition = new double[i17];
            this.mPeriod = new float[i17];
            this.mOffset = new float[i17];
            this.mScale = new float[i17];
        }

        private ConstraintAttribute get(String str, ConstraintAttribute.AttributeType attributeType) {
            if (this.mCustomConstraints.containsKey(str)) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str);
                if (constraintAttribute.getType() != attributeType) {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                }
                return constraintAttribute;
            }
            ConstraintAttribute constraintAttribute2 = new ConstraintAttribute(str, attributeType);
            this.mCustomConstraints.put(str, constraintAttribute2);
            return constraintAttribute2;
        }

        public double getSlope(float f16) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                double d16 = f16;
                curveFit.getSlope(d16, this.mSplineSlopeCache);
                this.mCurveFit.getPos(d16, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineSlopeCache;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
            }
            double d17 = f16;
            double value = this.mOscillator.getValue(d17);
            double slope = this.mOscillator.getSlope(d17);
            double[] dArr2 = this.mSplineSlopeCache;
            return dArr2[0] + (value * dArr2[1]) + (slope * this.mSplineValueCache[1]);
        }

        public double getValues(float f16) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                curveFit.getPos(f16, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineValueCache;
                dArr[0] = this.mOffset[0];
                dArr[1] = this.mValues[0];
            }
            return this.mSplineValueCache[0] + (this.mOscillator.getValue(f16) * this.mSplineValueCache[1]);
        }

        public void setPoint(int i3, int i16, float f16, float f17, float f18) {
            this.mPosition[i3] = i16 / 100.0d;
            this.mPeriod[i3] = f16;
            this.mOffset[i3] = f17;
            this.mValues[i3] = f18;
        }

        public void setup(float f16) {
            this.mPathLength = f16;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.mPosition.length, 2);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[fArr.length + 1];
            this.mSplineSlopeCache = new double[fArr.length + 1];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i3 = 0; i3 < dArr.length; i3++) {
                dArr[i3][0] = this.mOffset[i3];
                int i16 = 0;
                while (true) {
                    if (i16 < this.mValues.length) {
                        dArr[i16][1] = r4[i16];
                        i16++;
                    }
                }
                this.mOscillator.addPoint(this.mPosition[i3], this.mPeriod[i3]);
            }
            this.mOscillator.normalize();
            double[] dArr3 = this.mPosition;
            if (dArr3.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr3, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ElevationSet extends KeyCycleOscillator {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f16) {
            view.setElevation(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class IntDoubleSort {
        IntDoubleSort() {
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

        static void sort(int[] iArr, float[] fArr, int i3, int i16) {
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
    private static class IntFloatFloatSort {
        IntFloatFloatSort() {
        }

        private static int partition(int[] iArr, float[] fArr, float[] fArr2, int i3, int i16) {
            int i17 = iArr[i16];
            int i18 = i3;
            while (i3 < i16) {
                if (iArr[i3] <= i17) {
                    swap(iArr, fArr, fArr2, i18, i3);
                    i18++;
                }
                i3++;
            }
            swap(iArr, fArr, fArr2, i18, i16);
            return i18;
        }

        static void sort(int[] iArr, float[] fArr, float[] fArr2, int i3, int i16) {
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
                    int partition = partition(iArr, fArr, fArr2, i19, i26);
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

        private static void swap(int[] iArr, float[] fArr, float[] fArr2, int i3, int i16) {
            int i17 = iArr[i3];
            iArr[i3] = iArr[i16];
            iArr[i16] = i17;
            float f16 = fArr[i3];
            fArr[i3] = fArr[i16];
            fArr[i16] = f16;
            float f17 = fArr2[i3];
            fArr2[i3] = fArr2[i16];
            fArr2[i16] = f17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ProgressSet extends KeyCycleOscillator {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
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
                    Log.e(KeyCycleOscillator.TAG, "unable to setProgress", e16);
                } catch (InvocationTargetException e17) {
                    Log.e(KeyCycleOscillator.TAG, "unable to setProgress", e17);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class RotationSet extends KeyCycleOscillator {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f16) {
            view.setRotation(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class RotationXset extends KeyCycleOscillator {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f16) {
            view.setRotationX(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class RotationYset extends KeyCycleOscillator {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f16) {
            view.setRotationY(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ScaleXset extends KeyCycleOscillator {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f16) {
            view.setScaleX(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ScaleYset extends KeyCycleOscillator {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f16) {
            view.setScaleY(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class TranslationXset extends KeyCycleOscillator {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f16) {
            view.setTranslationX(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class TranslationYset extends KeyCycleOscillator {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f16) {
            view.setTranslationY(get(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class TranslationZset extends KeyCycleOscillator {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f16) {
            view.setTranslationZ(get(f16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class WavePoint {
        float mOffset;
        float mPeriod;
        int mPosition;
        float mValue;

        public WavePoint(int i3, float f16, float f17, float f18) {
            this.mPosition = i3;
            this.mValue = f18;
            this.mOffset = f17;
            this.mPeriod = f16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KeyCycleOscillator makeSpline(String str) {
        if (str.startsWith("CUSTOM")) {
            return new CustomSet();
        }
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
            case -40300674:
                if (str.equals(BasicAnimation.KeyPath.ROTATION)) {
                    c16 = '\t';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c16 = '\n';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c16 = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals(c.f123400v)) {
                    c16 = '\f';
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c16 = '\r';
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
                return new RotationSet();
            case '\n':
                return new ElevationSet();
            case 11:
                return new PathRotateSet();
            case '\f':
                return new AlphaSet();
            case '\r':
                return new AlphaSet();
            default:
                return null;
        }
    }

    public float get(float f16) {
        return (float) this.mCycleOscillator.getValues(f16);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f16) {
        return (float) this.mCycleOscillator.getSlope(f16);
    }

    public void setPoint(int i3, int i16, int i17, float f16, float f17, float f18, ConstraintAttribute constraintAttribute) {
        this.mWavePoints.add(new WavePoint(i3, f16, f17, f18));
        if (i17 != -1) {
            this.mVariesBy = i17;
        }
        this.mWaveShape = i16;
        this.mCustom = constraintAttribute;
    }

    public abstract void setProperty(View view, float f16);

    public void setType(String str) {
        this.mType = str;
    }

    @TargetApi(19)
    public void setup(float f16) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.motion.widget.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
            }
        });
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 2);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mVariesBy, size);
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            WavePoint next = it.next();
            float f17 = next.mPeriod;
            dArr[i3] = f17 * 0.01d;
            double[] dArr3 = dArr2[i3];
            float f18 = next.mValue;
            dArr3[0] = f18;
            float f19 = next.mOffset;
            dArr3[1] = f19;
            this.mCycleOscillator.setPoint(i3, next.mPosition, f17, f19, f18);
            i3++;
        }
        this.mCycleOscillator.setup(f16);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        while (it.hasNext()) {
            str = str + "[" + it.next().mPosition + " , " + decimalFormat.format(r3.mValue) + "] ";
        }
        return str;
    }

    public boolean variesByPath() {
        if (this.mVariesBy == 1) {
            return true;
        }
        return false;
    }

    public void setPoint(int i3, int i16, int i17, float f16, float f17, float f18) {
        this.mWavePoints.add(new WavePoint(i3, f16, f17, f18));
        if (i17 != -1) {
            this.mVariesBy = i17;
        }
        this.mWaveShape = i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class PathRotateSet extends KeyCycleOscillator {
        PathRotateSet() {
        }

        public void setPathRotate(View view, float f16, double d16, double d17) {
            view.setRotation(get(f16) + ((float) Math.toDegrees(Math.atan2(d17, d16))));
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f16) {
        }
    }
}
