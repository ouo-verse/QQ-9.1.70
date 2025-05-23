package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.c8.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", HippyTKDListViewAdapter.X, "y", "width", "height", "pathRotate"};
    private float height;
    private Easing mKeyFrameEasing;
    private float position;
    int visibility;
    private float width;

    /* renamed from: x, reason: collision with root package name */
    private float f26460x;

    /* renamed from: y, reason: collision with root package name */
    private float f26461y;
    private float alpha = 1.0f;
    int mVisibilityMode = 0;
    private boolean applyElevation = false;
    private float elevation = 0.0f;
    private float rotation = 0.0f;
    private float rotationX = 0.0f;
    public float rotationY = 0.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float translationX = 0.0f;
    private float translationY = 0.0f;
    private float translationZ = 0.0f;
    private int mDrawPath = 0;
    private float mPathRotate = Float.NaN;
    private float mProgress = Float.NaN;
    LinkedHashMap<String, ConstraintAttribute> attributes = new LinkedHashMap<>();
    int mMode = 0;
    double[] mTempValue = new double[18];
    double[] mTempDelta = new double[18];

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

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0023. Please report as an issue. */
    public void addValues(HashMap<String, SplineSet> hashMap, int i3) {
        for (String str : hashMap.keySet()) {
            SplineSet splineSet = hashMap.get(str);
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
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c16 = '\b';
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c16 = '\t';
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals(BasicAnimation.KeyPath.ROTATION)) {
                        c16 = '\n';
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c16 = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c16 = '\f';
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals(c.f123400v)) {
                        c16 = '\r';
                        break;
                    }
                    break;
            }
            float f16 = 1.0f;
            float f17 = 0.0f;
            switch (c16) {
                case 0:
                    if (!Float.isNaN(this.rotationX)) {
                        f17 = this.rotationX;
                    }
                    splineSet.setPoint(i3, f17);
                    break;
                case 1:
                    if (!Float.isNaN(this.rotationY)) {
                        f17 = this.rotationY;
                    }
                    splineSet.setPoint(i3, f17);
                    break;
                case 2:
                    if (!Float.isNaN(this.translationX)) {
                        f17 = this.translationX;
                    }
                    splineSet.setPoint(i3, f17);
                    break;
                case 3:
                    if (!Float.isNaN(this.translationY)) {
                        f17 = this.translationY;
                    }
                    splineSet.setPoint(i3, f17);
                    break;
                case 4:
                    if (!Float.isNaN(this.translationZ)) {
                        f17 = this.translationZ;
                    }
                    splineSet.setPoint(i3, f17);
                    break;
                case 5:
                    if (!Float.isNaN(this.mProgress)) {
                        f17 = this.mProgress;
                    }
                    splineSet.setPoint(i3, f17);
                    break;
                case 6:
                    if (!Float.isNaN(this.scaleX)) {
                        f16 = this.scaleX;
                    }
                    splineSet.setPoint(i3, f16);
                    break;
                case 7:
                    if (!Float.isNaN(this.scaleY)) {
                        f16 = this.scaleY;
                    }
                    splineSet.setPoint(i3, f16);
                    break;
                case '\b':
                    if (!Float.isNaN(this.mPivotX)) {
                        f17 = this.mPivotX;
                    }
                    splineSet.setPoint(i3, f17);
                    break;
                case '\t':
                    if (!Float.isNaN(this.mPivotY)) {
                        f17 = this.mPivotY;
                    }
                    splineSet.setPoint(i3, f17);
                    break;
                case '\n':
                    if (!Float.isNaN(this.rotation)) {
                        f17 = this.rotation;
                    }
                    splineSet.setPoint(i3, f17);
                    break;
                case 11:
                    if (!Float.isNaN(this.elevation)) {
                        f17 = this.elevation;
                    }
                    splineSet.setPoint(i3, f17);
                    break;
                case '\f':
                    if (!Float.isNaN(this.mPathRotate)) {
                        f17 = this.mPathRotate;
                    }
                    splineSet.setPoint(i3, f17);
                    break;
                case '\r':
                    if (!Float.isNaN(this.alpha)) {
                        f16 = this.alpha;
                    }
                    splineSet.setPoint(i3, f16);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.attributes.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = this.attributes.get(str2);
                            if (splineSet instanceof SplineSet.CustomSet) {
                                ((SplineSet.CustomSet) splineSet).setPoint(i3, constraintAttribute);
                                break;
                            } else {
                                Log.e("MotionPaths", str + " splineSet not a CustomSet frame = " + i3 + ", value" + constraintAttribute.getValueToInterpolate() + splineSet);
                                break;
                            }
                        } else {
                            Log.e("MotionPaths", "UNKNOWN customName " + str2);
                            break;
                        }
                    } else {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                        break;
                    }
            }
        }
    }

    public void applyParameters(View view) {
        this.visibility = view.getVisibility();
        this.alpha = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.applyElevation = false;
        this.elevation = view.getElevation();
        this.rotation = view.getRotation();
        this.rotationX = view.getRotationX();
        this.rotationY = view.getRotationY();
        this.scaleX = view.getScaleX();
        this.scaleY = view.getScaleY();
        this.mPivotX = view.getPivotX();
        this.mPivotY = view.getPivotY();
        this.translationX = view.getTranslationX();
        this.translationY = view.getTranslationY();
        this.translationZ = view.getTranslationZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void different(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (diff(this.alpha, motionConstrainedPoint.alpha)) {
            hashSet.add(c.f123400v);
        }
        if (diff(this.elevation, motionConstrainedPoint.elevation)) {
            hashSet.add("elevation");
        }
        int i3 = this.visibility;
        int i16 = motionConstrainedPoint.visibility;
        if (i3 != i16 && this.mVisibilityMode == 0 && (i3 == 0 || i16 == 0)) {
            hashSet.add(c.f123400v);
        }
        if (diff(this.rotation, motionConstrainedPoint.rotation)) {
            hashSet.add(BasicAnimation.KeyPath.ROTATION);
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(motionConstrainedPoint.mPathRotate)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mProgress) || !Float.isNaN(motionConstrainedPoint.mProgress)) {
            hashSet.add("progress");
        }
        if (diff(this.rotationX, motionConstrainedPoint.rotationX)) {
            hashSet.add(BasicAnimation.KeyPath.ROTATION_X);
        }
        if (diff(this.rotationY, motionConstrainedPoint.rotationY)) {
            hashSet.add(BasicAnimation.KeyPath.ROTATION_Y);
        }
        if (diff(this.mPivotX, motionConstrainedPoint.mPivotX)) {
            hashSet.add("transformPivotX");
        }
        if (diff(this.mPivotY, motionConstrainedPoint.mPivotY)) {
            hashSet.add("transformPivotY");
        }
        if (diff(this.scaleX, motionConstrainedPoint.scaleX)) {
            hashSet.add(BasicAnimation.KeyPath.SCALE_X);
        }
        if (diff(this.scaleY, motionConstrainedPoint.scaleY)) {
            hashSet.add(BasicAnimation.KeyPath.SCALE_Y);
        }
        if (diff(this.translationX, motionConstrainedPoint.translationX)) {
            hashSet.add("translationX");
        }
        if (diff(this.translationY, motionConstrainedPoint.translationY)) {
            hashSet.add("translationY");
        }
        if (diff(this.translationZ, motionConstrainedPoint.translationZ)) {
            hashSet.add("translationZ");
        }
    }

    void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.f26460x, this.f26461y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
        int i3 = 0;
        for (int i16 : iArr) {
            if (i16 < 18) {
                dArr[i3] = fArr[r4];
                i3++;
            }
        }
    }

    int getCustomData(String str, double[] dArr, int i3) {
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

    int getCustomDataCount(String str) {
        return this.attributes.get(str).noOfInterpValues();
    }

    boolean hasCustomData(String str) {
        return this.attributes.containsKey(str);
    }

    void setBounds(float f16, float f17, float f18, float f19) {
        this.f26460x = f16;
        this.f26461y = f17;
        this.width = f18;
        this.height = f19;
    }

    public void setState(View view) {
        setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        applyParameters(view);
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.position, motionConstrainedPoint.position);
    }

    public void setState(ConstraintWidget constraintWidget, ConstraintSet constraintSet, int i3) {
        setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        applyParameters(constraintSet.getParameters(i3));
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        ConstraintSet.PropertySet propertySet = constraint.propertySet;
        int i3 = propertySet.mVisibilityMode;
        this.mVisibilityMode = i3;
        int i16 = propertySet.visibility;
        this.visibility = i16;
        this.alpha = (i16 == 0 || i3 != 0) ? propertySet.alpha : 0.0f;
        ConstraintSet.Transform transform = constraint.transform;
        this.applyElevation = transform.applyElevation;
        this.elevation = transform.elevation;
        this.rotation = transform.rotation;
        this.rotationX = transform.rotationX;
        this.rotationY = transform.rotationY;
        this.scaleX = transform.scaleX;
        this.scaleY = transform.scaleY;
        this.mPivotX = transform.transformPivotX;
        this.mPivotY = transform.transformPivotY;
        this.translationX = transform.translationX;
        this.translationY = transform.translationY;
        this.translationZ = transform.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
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

    void different(MotionConstrainedPoint motionConstrainedPoint, boolean[] zArr, String[] strArr) {
        zArr[0] = zArr[0] | diff(this.position, motionConstrainedPoint.position);
        zArr[1] = zArr[1] | diff(this.f26460x, motionConstrainedPoint.f26460x);
        zArr[2] = zArr[2] | diff(this.f26461y, motionConstrainedPoint.f26461y);
        zArr[3] = zArr[3] | diff(this.width, motionConstrainedPoint.width);
        zArr[4] = diff(this.height, motionConstrainedPoint.height) | zArr[4];
    }
}
