package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.annotation.AnimatorRes;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class AnimatorInflaterCompat {
    private static final boolean DBG_ANIMATOR_INFLATER = false;
    private static final int MAX_NUM_POINTS = 100;
    private static final String TAG = "AnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_COLOR = 3;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_PATH = 2;
    private static final int VALUE_TYPE_UNDEFINED = 4;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {
        private PathParser.PathDataNode[] mNodeArray;

        PathDataEvaluator() {
        }

        PathDataEvaluator(PathParser.PathDataNode[] pathDataNodeArr) {
            this.mNodeArray = pathDataNodeArr;
        }

        @Override // android.animation.TypeEvaluator
        public PathParser.PathDataNode[] evaluate(float f16, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            if (PathParser.canMorph(pathDataNodeArr, pathDataNodeArr2)) {
                if (!PathParser.canMorph(this.mNodeArray, pathDataNodeArr)) {
                    this.mNodeArray = PathParser.deepCopyNodes(pathDataNodeArr);
                }
                for (int i3 = 0; i3 < pathDataNodeArr.length; i3++) {
                    this.mNodeArray[i3].interpolatePathDataNode(pathDataNodeArr[i3], pathDataNodeArr2[i3], f16);
                }
                return this.mNodeArray;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    AnimatorInflaterCompat() {
    }

    private static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f16) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f16);
    }

    private static Keyframe createNewKeyframe(Keyframe keyframe, float f16) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f16);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f16);
        }
        return Keyframe.ofObject(f16);
    }

    private static void distributeKeyframes(Keyframe[] keyframeArr, float f16, int i3, int i16) {
        float f17 = f16 / ((i16 - i3) + 2);
        while (i3 <= i16) {
            keyframeArr[i3].setFraction(keyframeArr[i3 - 1].getFraction() + f17);
            i3++;
        }
    }

    private static void dumpKeyframes(Object[] objArr, String str) {
        Object valueOf;
        if (objArr != null && objArr.length != 0) {
            Log.d(TAG, str);
            int length = objArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                Keyframe keyframe = (Keyframe) objArr[i3];
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Keyframe ");
                sb5.append(i3);
                sb5.append(": fraction ");
                Object obj = "null";
                if (keyframe.getFraction() < 0.0f) {
                    valueOf = "null";
                } else {
                    valueOf = Float.valueOf(keyframe.getFraction());
                }
                sb5.append(valueOf);
                sb5.append(", , value : ");
                if (keyframe.hasValue()) {
                    obj = keyframe.getValue();
                }
                sb5.append(obj);
                Log.d(TAG, sb5.toString());
            }
        }
    }

    private static PropertyValuesHolder getPVH(TypedArray typedArray, int i3, int i16, int i17, String str) {
        boolean z16;
        int i18;
        boolean z17;
        int i19;
        boolean z18;
        ArgbEvaluator argbEvaluator;
        int i26;
        int i27;
        int i28;
        float f16;
        PropertyValuesHolder ofFloat;
        float f17;
        float f18;
        PropertyValuesHolder ofObject;
        TypedValue peekValue = typedArray.peekValue(i16);
        if (peekValue != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i18 = peekValue.type;
        } else {
            i18 = 0;
        }
        TypedValue peekValue2 = typedArray.peekValue(i17);
        if (peekValue2 != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            i19 = peekValue2.type;
        } else {
            i19 = 0;
        }
        if (i3 == 4) {
            if ((z16 && isColorType(i18)) || (z17 && isColorType(i19))) {
                i3 = 3;
            } else {
                i3 = 0;
            }
        }
        if (i3 == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        PropertyValuesHolder propertyValuesHolder = null;
        if (i3 == 2) {
            String string = typedArray.getString(i16);
            String string2 = typedArray.getString(i17);
            PathParser.PathDataNode[] createNodesFromPathData = PathParser.createNodesFromPathData(string);
            PathParser.PathDataNode[] createNodesFromPathData2 = PathParser.createNodesFromPathData(string2);
            if (createNodesFromPathData == null && createNodesFromPathData2 == null) {
                return null;
            }
            if (createNodesFromPathData != null) {
                PathDataEvaluator pathDataEvaluator = new PathDataEvaluator();
                if (createNodesFromPathData2 != null) {
                    if (PathParser.canMorph(createNodesFromPathData, createNodesFromPathData2)) {
                        ofObject = PropertyValuesHolder.ofObject(str, pathDataEvaluator, createNodesFromPathData, createNodesFromPathData2);
                    } else {
                        throw new InflateException(" Can't morph from " + string + " to " + string2);
                    }
                } else {
                    ofObject = PropertyValuesHolder.ofObject(str, pathDataEvaluator, createNodesFromPathData);
                }
                return ofObject;
            }
            if (createNodesFromPathData2 == null) {
                return null;
            }
            return PropertyValuesHolder.ofObject(str, new PathDataEvaluator(), createNodesFromPathData2);
        }
        if (i3 == 3) {
            argbEvaluator = ArgbEvaluator.getInstance();
        } else {
            argbEvaluator = null;
        }
        if (z18) {
            if (z16) {
                if (i18 == 5) {
                    f17 = typedArray.getDimension(i16, 0.0f);
                } else {
                    f17 = typedArray.getFloat(i16, 0.0f);
                }
                if (z17) {
                    if (i19 == 5) {
                        f18 = typedArray.getDimension(i17, 0.0f);
                    } else {
                        f18 = typedArray.getFloat(i17, 0.0f);
                    }
                    ofFloat = PropertyValuesHolder.ofFloat(str, f17, f18);
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, f17);
                }
            } else {
                if (i19 == 5) {
                    f16 = typedArray.getDimension(i17, 0.0f);
                } else {
                    f16 = typedArray.getFloat(i17, 0.0f);
                }
                ofFloat = PropertyValuesHolder.ofFloat(str, f16);
            }
            propertyValuesHolder = ofFloat;
        } else if (z16) {
            if (i18 == 5) {
                i27 = (int) typedArray.getDimension(i16, 0.0f);
            } else if (isColorType(i18)) {
                i27 = typedArray.getColor(i16, 0);
            } else {
                i27 = typedArray.getInt(i16, 0);
            }
            if (z17) {
                if (i19 == 5) {
                    i28 = (int) typedArray.getDimension(i17, 0.0f);
                } else if (isColorType(i19)) {
                    i28 = typedArray.getColor(i17, 0);
                } else {
                    i28 = typedArray.getInt(i17, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i27, i28);
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i27);
            }
        } else if (z17) {
            if (i19 == 5) {
                i26 = (int) typedArray.getDimension(i17, 0.0f);
            } else if (isColorType(i19)) {
                i26 = typedArray.getColor(i17, 0);
            } else {
                i26 = typedArray.getInt(i17, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i26);
        }
        if (propertyValuesHolder != null && argbEvaluator != null) {
            propertyValuesHolder.setEvaluator(argbEvaluator);
            return propertyValuesHolder;
        }
        return propertyValuesHolder;
    }

    private static int inferValueTypeFromValues(TypedArray typedArray, int i3, int i16) {
        boolean z16;
        int i17;
        int i18;
        TypedValue peekValue = typedArray.peekValue(i3);
        boolean z17 = true;
        if (peekValue != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i17 = peekValue.type;
        } else {
            i17 = 0;
        }
        TypedValue peekValue2 = typedArray.peekValue(i16);
        if (peekValue2 == null) {
            z17 = false;
        }
        if (z17) {
            i18 = peekValue2.type;
        } else {
            i18 = 0;
        }
        if ((!z16 || !isColorType(i17)) && (!z17 || !isColorType(i18))) {
            return 0;
        }
        return 3;
    }

    private static int inferValueTypeOfKeyframe(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        boolean z16;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_KEYFRAME);
        int i3 = 0;
        TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        if (peekNamedValue != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && isColorType(peekNamedValue.type)) {
            i3 = 3;
        }
        obtainAttributes.recycle();
        return i3;
    }

    private static boolean isColorType(int i3) {
        if (i3 >= 28 && i3 <= 31) {
            return true;
        }
        return false;
    }

    public static Animator loadAnimator(Context context, @AnimatorRes int i3) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i3);
        }
        return loadAnimator(context, context.getResources(), context.getTheme(), i3);
    }

    private static Keyframe loadKeyframe(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i3, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean z16;
        Keyframe ofInt;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_KEYFRAME);
        float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        if (peekNamedValue != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 == 4) {
            if (z16 && isColorType(peekNamedValue.type)) {
                i3 = 3;
            } else {
                i3 = 0;
            }
        }
        if (z16) {
            if (i3 != 0) {
                if (i3 != 1 && i3 != 3) {
                    ofInt = null;
                } else {
                    ofInt = Keyframe.ofInt(namedFloat, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "value", 0, 0));
                }
            } else {
                ofInt = Keyframe.ofFloat(namedFloat, TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "value", 0, 0.0f));
            }
        } else if (i3 == 0) {
            ofInt = Keyframe.ofFloat(namedFloat);
        } else {
            ofInt = Keyframe.ofInt(namedFloat);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 1, 0);
        if (namedResourceId > 0) {
            ofInt.setInterpolator(AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        }
        obtainAttributes.recycle();
        return ofInt;
    }

    private static ObjectAnimator loadObjectAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f16, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, resources, theme, attributeSet, objectAnimator, f16, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder loadPvh(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i3) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolder = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (i3 == 4) {
                    i3 = inferValueTypeOfKeyframe(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe loadKeyframe = loadKeyframe(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i3, xmlPullParser);
                if (loadKeyframe != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(loadKeyframe);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), createNewKeyframe(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, createNewKeyframe(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i16 = 0; i16 < size; i16++) {
                Keyframe keyframe3 = keyframeArr[i16];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i16 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i17 = size - 1;
                        if (i16 == i17) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i18 = i16;
                            for (int i19 = i16 + 1; i19 < i17 && keyframeArr[i19].getFraction() < 0.0f; i19++) {
                                i18 = i19;
                            }
                            distributeKeyframes(keyframeArr, keyframeArr[i18 + 1].getFraction() - keyframeArr[i16 - 1].getFraction(), i16, i18);
                        }
                    }
                }
            }
            propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i3 == 3) {
                propertyValuesHolder.setEvaluator(ArgbEvaluator.getInstance());
            }
        }
        return propertyValuesHolder;
    }

    private static PropertyValuesHolder[] loadValues(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i3;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
                    String namedString = TypedArrayUtils.getNamedString(obtainAttributes, xmlPullParser, "propertyName", 3);
                    int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder loadPvh = loadPvh(context, resources, theme, xmlPullParser, namedString, namedInt);
                    if (loadPvh == null) {
                        loadPvh = getPVH(obtainAttributes, namedInt, 0, 1, namedString);
                    }
                    if (loadPvh != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(loadPvh);
                    }
                    obtainAttributes.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i3 = 0; i3 < size; i3++) {
                propertyValuesHolderArr[i3] = (PropertyValuesHolder) arrayList.get(i3);
            }
        }
        return propertyValuesHolderArr;
    }

    private static void parseAnimatorFromTypeArray(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f16, XmlPullParser xmlPullParser) {
        long namedInt = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "duration", 1, 300);
        long namedInt2 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "startOffset", 2, 0);
        int namedInt3 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "valueType", 7, 4);
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "valueFrom") && TypedArrayUtils.hasAttribute(xmlPullParser, "valueTo")) {
            if (namedInt3 == 4) {
                namedInt3 = inferValueTypeFromValues(typedArray, 5, 6);
            }
            PropertyValuesHolder pvh = getPVH(typedArray, namedInt3, 5, 6, "");
            if (pvh != null) {
                valueAnimator.setValues(pvh);
            }
        }
        valueAnimator.setDuration(namedInt);
        valueAnimator.setStartDelay(namedInt2);
        valueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            setupObjectAnimator(valueAnimator, typedArray2, namedInt3, f16, xmlPullParser);
        }
    }

    private static void setupObjectAnimator(ValueAnimator valueAnimator, TypedArray typedArray, int i3, float f16, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 1);
        if (namedString != null) {
            String namedString2 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyXName", 2);
            String namedString3 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyYName", 3);
            if (i3 != 2) {
            }
            if (namedString2 == null && namedString3 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            setupPathMotion(PathParser.createPathFromPathData(namedString), objectAnimator, f16 * 0.5f, namedString2, namedString3);
            return;
        }
        objectAnimator.setPropertyName(TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void setupPathMotion(Path path, ObjectAnimator objectAnimator, float f16, String str, String str2) {
        PropertyValuesHolder propertyValuesHolder;
        PropertyValuesHolder propertyValuesHolder2;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        float f17 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float f18 = 0.0f;
        do {
            f18 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f18));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f18 / f16)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f19 = f18 / (min - 1);
        int i3 = 0;
        int i16 = 0;
        while (true) {
            propertyValuesHolder = null;
            if (i3 >= min) {
                break;
            }
            pathMeasure2.getPosTan(f17 - ((Float) arrayList.get(i16)).floatValue(), fArr3, null);
            fArr[i3] = fArr3[0];
            fArr2[i3] = fArr3[1];
            f17 += f19;
            int i17 = i16 + 1;
            if (i17 < arrayList.size() && f17 > ((Float) arrayList.get(i17)).floatValue()) {
                pathMeasure2.nextContour();
                i16 = i17;
            }
            i3++;
        }
        if (str != null) {
            propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str, fArr);
        } else {
            propertyValuesHolder2 = null;
        }
        if (str2 != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str2, fArr2);
        }
        if (propertyValuesHolder2 == null) {
            objectAnimator.setValues(propertyValuesHolder);
        } else if (propertyValuesHolder == null) {
            objectAnimator.setValues(propertyValuesHolder2);
        } else {
            objectAnimator.setValues(propertyValuesHolder2, propertyValuesHolder);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x00f5, code lost:
    
        if (r2.hasNext() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x00f7, code lost:
    
        r1[r14] = (android.animation.Animator) r2.next();
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0103, code lost:
    
        if (r24 != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0105, code lost:
    
        r23.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0109, code lost:
    
        r23.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x010c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x00e3, code lost:
    
        if (r23 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00e5, code lost:
    
        if (r13 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00e7, code lost:
    
        r1 = new android.animation.Animator[r13.size()];
        r2 = r13.iterator();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i3, float f16) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        ValueAnimator valueAnimator = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            int i16 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        valueAnimator = loadObjectAnimator(context, resources, theme, attributeSet, f16, xmlPullParser);
                    } else if (name.equals("animator")) {
                        valueAnimator = loadAnimator(context, resources, theme, attributeSet, null, f16, xmlPullParser);
                    } else {
                        if (name.equals("set")) {
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATOR_SET);
                            createAnimatorFromXml(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "ordering", 0, 0), f16);
                            obtainAttributes.recycle();
                            valueAnimator = animatorSet2;
                        } else if (name.equals("propertyValuesHolder")) {
                            PropertyValuesHolder[] loadValues = loadValues(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                            if (loadValues != null && (valueAnimator instanceof ValueAnimator)) {
                                valueAnimator.setValues(loadValues);
                            }
                            i16 = 1;
                        } else {
                            throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                        }
                        if (animatorSet != null && i16 == 0) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(valueAnimator);
                        }
                    }
                    if (animatorSet != null) {
                        if (arrayList == null) {
                        }
                        arrayList.add(valueAnimator);
                    }
                }
            }
        }
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, @AnimatorRes int i3) throws Resources.NotFoundException {
        return loadAnimator(context, resources, theme, i3, 1.0f);
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, @AnimatorRes int i3, float f16) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i3);
                    return createAnimatorFromXml(context, resources, theme, xmlResourceParser, f16);
                } catch (XmlPullParserException e16) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i3));
                    notFoundException.initCause(e16);
                    throw notFoundException;
                }
            } catch (IOException e17) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i3));
                notFoundException2.initCause(e17);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private static ValueAnimator loadAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f16, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATOR);
        TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        parseAnimatorFromTypeArray(valueAnimator, obtainAttributes, obtainAttributes2, f16, xmlPullParser);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            valueAnimator.setInterpolator(AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        }
        obtainAttributes.recycle();
        if (obtainAttributes2 != null) {
            obtainAttributes2.recycle();
        }
        return valueAnimator;
    }
}
