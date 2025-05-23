package com.nineoldandroids.animation;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AnimatorInflater {
    private static final int AnimatorSet_ordering = 0;
    private static final int Animator_duration = 1;
    private static final int Animator_interpolator = 0;
    private static final int Animator_repeatCount = 3;
    private static final int Animator_repeatMode = 4;
    private static final int Animator_startOffset = 2;
    private static final int Animator_valueFrom = 5;
    private static final int Animator_valueTo = 6;
    private static final int Animator_valueType = 7;
    private static final int PropertyAnimator_propertyName = 0;
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int[] AnimatorSet = {R.attr.ordering};
    private static final int[] PropertyAnimator = {R.attr.propertyName};
    private static final int[] Animator = {R.attr.interpolator, R.attr.duration, R.attr.startOffset, R.attr.repeatCount, R.attr.repeatMode, R.attr.valueFrom, R.attr.valueTo, R.attr.valueType};

    private static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0);
    }

    public static Animator loadAnimator(Context context, int i3) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                xmlResourceParser = context.getResources().getAnimation(i3);
                return createAnimatorFromXml(context, xmlResourceParser);
            } catch (IOException e16) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i3));
                notFoundException.initCause(e16);
                throw notFoundException;
            } catch (XmlPullParserException e17) {
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

    private static ObjectAnimator loadObjectAnimator(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, attributeSet, objectAnimator);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, PropertyAnimator);
        objectAnimator.setPropertyName(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        return objectAnimator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
    
        if (r10.hasNext() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
    
        r9[r6] = (com.nineoldandroids.animation.Animator) r10.next();
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        if (r13 != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        r12.playTogether(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        r12.playSequentially(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0099, code lost:
    
        if (r4 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        if (r12 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
    
        if (r2 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        r9 = new com.nineoldandroids.animation.Animator[r2.size()];
        r10 = r2.iterator();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i3) throws XmlPullParserException, IOException {
        TypedArray typedArray;
        int depth = xmlPullParser.getDepth();
        TypedArray typedArray2 = null;
        ArrayList arrayList = null;
        Animator animator = null;
        while (true) {
            int next = xmlPullParser.next();
            int i16 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        animator = loadObjectAnimator(context, attributeSet);
                    } else if (name.equals("animator")) {
                        animator = loadAnimator(context, attributeSet, null);
                    } else if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        try {
                            typedArray = context.obtainStyledAttributes(attributeSet, AnimatorSet);
                        } catch (Exception e16) {
                            e = e16;
                            typedArray = null;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        try {
                            try {
                                TypedValue typedValue = new TypedValue();
                                typedArray.getValue(0, typedValue);
                                if (typedValue.type == 16) {
                                    i16 = typedValue.data;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                typedArray2 = typedArray;
                                if (typedArray2 != null) {
                                    typedArray2.recycle();
                                }
                                throw th;
                            }
                        } catch (Exception e17) {
                            e = e17;
                            e.printStackTrace();
                        }
                        typedArray.recycle();
                        createAnimatorFromXml(context, xmlPullParser, attributeSet, animatorSet2, i16);
                        animator = animatorSet2;
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(animator);
                    }
                }
            }
        }
    }

    private static ValueAnimator loadAnimator(Context context, AttributeSet attributeSet, ValueAnimator valueAnimator) throws Resources.NotFoundException {
        int i3;
        int i16;
        int i17;
        int i18;
        float f16;
        float f17;
        float f18;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Animator);
        long j3 = obtainStyledAttributes.getInt(1, 0);
        long j16 = obtainStyledAttributes.getInt(2, 0);
        int i19 = obtainStyledAttributes.getInt(7, 0);
        ValueAnimator valueAnimator2 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        boolean z16 = i19 == 0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(5);
        boolean z17 = peekValue != null;
        int i26 = z17 ? peekValue.type : 0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(6);
        boolean z18 = peekValue2 != null;
        int i27 = z18 ? peekValue2.type : 0;
        if ((z17 && i26 >= 28 && i26 <= 31) || (z18 && i27 >= 28 && i27 <= 31)) {
            valueAnimator2.setEvaluator(new ArgbEvaluator());
            z16 = false;
        }
        if (!z16) {
            i3 = 0;
            if (z17) {
                if (i26 == 5) {
                    i17 = (int) obtainStyledAttributes.getDimension(5, 0.0f);
                } else if (i26 >= 28 && i26 <= 31) {
                    i17 = obtainStyledAttributes.getColor(5, 0);
                } else {
                    i17 = obtainStyledAttributes.getInt(5, 0);
                }
                if (z18) {
                    if (i27 == 5) {
                        i18 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
                    } else if (i27 >= 28 && i27 <= 31) {
                        i18 = obtainStyledAttributes.getColor(6, 0);
                    } else {
                        i18 = obtainStyledAttributes.getInt(6, 0);
                    }
                    valueAnimator2.setIntValues(i17, i18);
                } else {
                    valueAnimator2.setIntValues(i17);
                }
            } else if (z18) {
                if (i27 == 5) {
                    i16 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
                } else if (i27 >= 28 && i27 <= 31) {
                    i16 = obtainStyledAttributes.getColor(6, 0);
                } else {
                    i16 = obtainStyledAttributes.getInt(6, 0);
                }
                valueAnimator2.setIntValues(i16);
            }
        } else if (z17) {
            if (i26 == 5) {
                f17 = obtainStyledAttributes.getDimension(5, 0.0f);
            } else {
                f17 = obtainStyledAttributes.getFloat(5, 0.0f);
            }
            if (z18) {
                if (i27 == 5) {
                    f18 = obtainStyledAttributes.getDimension(6, 0.0f);
                } else {
                    f18 = obtainStyledAttributes.getFloat(6, 0.0f);
                }
                i3 = 0;
                valueAnimator2.setFloatValues(f17, f18);
            } else {
                i3 = 0;
                valueAnimator2.setFloatValues(f17);
            }
        } else {
            i3 = 0;
            if (i27 == 5) {
                f16 = obtainStyledAttributes.getDimension(6, 0.0f);
            } else {
                f16 = obtainStyledAttributes.getFloat(6, 0.0f);
            }
            valueAnimator2.setFloatValues(f16);
        }
        valueAnimator2.setDuration(j3);
        valueAnimator2.setStartDelay(j16);
        if (obtainStyledAttributes.hasValue(3)) {
            valueAnimator2.setRepeatCount(obtainStyledAttributes.getInt(3, i3));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            valueAnimator2.setRepeatMode(obtainStyledAttributes.getInt(4, 1));
        }
        int resourceId = obtainStyledAttributes.getResourceId(i3, i3);
        if (resourceId > 0) {
            valueAnimator2.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
        return valueAnimator2;
    }
}
