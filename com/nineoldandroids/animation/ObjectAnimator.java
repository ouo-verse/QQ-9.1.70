package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.c8.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ObjectAnimator extends ValueAnimator {
    private static final boolean DBG = false;
    private static final Map<String, Property> PROXY_PROPERTIES;
    private Property mProperty;
    private String mPropertyName;
    private Object mTarget;

    static {
        HashMap hashMap = new HashMap();
        PROXY_PROPERTIES = hashMap;
        hashMap.put(c.f123400v, PreHoneycombCompat.ALPHA);
        hashMap.put("pivotX", PreHoneycombCompat.PIVOT_X);
        hashMap.put("pivotY", PreHoneycombCompat.PIVOT_Y);
        hashMap.put("translationX", PreHoneycombCompat.TRANSLATION_X);
        hashMap.put("translationY", PreHoneycombCompat.TRANSLATION_Y);
        hashMap.put(BasicAnimation.KeyPath.ROTATION, PreHoneycombCompat.ROTATION);
        hashMap.put(BasicAnimation.KeyPath.ROTATION_X, PreHoneycombCompat.ROTATION_X);
        hashMap.put(BasicAnimation.KeyPath.ROTATION_Y, PreHoneycombCompat.ROTATION_Y);
        hashMap.put(BasicAnimation.KeyPath.SCALE_X, PreHoneycombCompat.SCALE_X);
        hashMap.put(BasicAnimation.KeyPath.SCALE_Y, PreHoneycombCompat.SCALE_Y);
        hashMap.put("scrollX", PreHoneycombCompat.SCROLL_X);
        hashMap.put("scrollY", PreHoneycombCompat.SCROLL_Y);
        hashMap.put(HippyTKDListViewAdapter.X, PreHoneycombCompat.X);
        hashMap.put("y", PreHoneycombCompat.Y);
    }

    public ObjectAnimator() {
    }

    public static ObjectAnimator ofFloat(Object obj, String str, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setFloatValues(fArr);
        return objectAnimator;
    }

    public static ObjectAnimator ofInt(Object obj, String str, int... iArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setIntValues(iArr);
        return objectAnimator;
    }

    public static ObjectAnimator ofObject(Object obj, String str, TypeEvaluator typeEvaluator, Object... objArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setObjectValues(objArr);
        objectAnimator.setEvaluator(typeEvaluator);
        return objectAnimator;
    }

    public static ObjectAnimator ofPropertyValuesHolder(Object obj, PropertyValuesHolder... propertyValuesHolderArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.mTarget = obj;
        objectAnimator.setValues(propertyValuesHolderArr);
        return objectAnimator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.nineoldandroids.animation.ValueAnimator
    public void animateValue(float f16) {
        super.animateValue(f16);
        int length = this.mValues.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.mValues[i3].setAnimatedValue(this.mTarget);
        }
    }

    public String getPropertyName() {
        return this.mPropertyName;
    }

    public Object getTarget() {
        return this.mTarget;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.nineoldandroids.animation.ValueAnimator
    public void initAnimation() {
        if (!this.mInitialized) {
            if (this.mProperty == null && AnimatorProxy.NEEDS_PROXY && (this.mTarget instanceof View)) {
                Map<String, Property> map = PROXY_PROPERTIES;
                if (map.containsKey(this.mPropertyName)) {
                    setProperty(map.get(this.mPropertyName));
                }
            }
            int length = this.mValues.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.mValues[i3].setupSetterAndGetter(this.mTarget);
            }
            super.initAnimation();
        }
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public void setFloatValues(float... fArr) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr != null && propertyValuesHolderArr.length != 0) {
            super.setFloatValues(fArr);
            return;
        }
        Property property = this.mProperty;
        if (property != null) {
            setValues(PropertyValuesHolder.ofFloat((Property<?, Float>) property, fArr));
        } else {
            setValues(PropertyValuesHolder.ofFloat(this.mPropertyName, fArr));
        }
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public void setIntValues(int... iArr) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr != null && propertyValuesHolderArr.length != 0) {
            super.setIntValues(iArr);
            return;
        }
        Property property = this.mProperty;
        if (property != null) {
            setValues(PropertyValuesHolder.ofInt((Property<?, Integer>) property, iArr));
        } else {
            setValues(PropertyValuesHolder.ofInt(this.mPropertyName, iArr));
        }
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public void setObjectValues(Object... objArr) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr != null && propertyValuesHolderArr.length != 0) {
            super.setObjectValues(objArr);
            return;
        }
        Property property = this.mProperty;
        if (property != null) {
            setValues(PropertyValuesHolder.ofObject(property, (TypeEvaluator) null, objArr));
        } else {
            setValues(PropertyValuesHolder.ofObject(this.mPropertyName, (TypeEvaluator) null, objArr));
        }
    }

    public void setProperty(Property property) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr != null) {
            PropertyValuesHolder propertyValuesHolder = propertyValuesHolderArr[0];
            String propertyName = propertyValuesHolder.getPropertyName();
            propertyValuesHolder.setProperty(property);
            this.mValuesMap.remove(propertyName);
            this.mValuesMap.put(this.mPropertyName, propertyValuesHolder);
        }
        if (this.mProperty != null) {
            this.mPropertyName = property.getName();
        }
        this.mProperty = property;
        this.mInitialized = false;
    }

    public void setPropertyName(String str) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr != null) {
            PropertyValuesHolder propertyValuesHolder = propertyValuesHolderArr[0];
            String propertyName = propertyValuesHolder.getPropertyName();
            propertyValuesHolder.setPropertyName(str);
            this.mValuesMap.remove(propertyName);
            this.mValuesMap.put(str, propertyValuesHolder);
        }
        this.mPropertyName = str;
        this.mInitialized = false;
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setTarget(Object obj) {
        Object obj2 = this.mTarget;
        if (obj2 != obj) {
            this.mTarget = obj;
            if (obj2 != null && obj != null && obj2.getClass() == obj.getClass()) {
                return;
            }
            this.mInitialized = false;
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setupEndValues() {
        initAnimation();
        int length = this.mValues.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.mValues[i3].setupEndValue(this.mTarget);
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setupStartValues() {
        initAnimation();
        int length = this.mValues.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.mValues[i3].setupStartValue(this.mTarget);
        }
    }

    @Override // com.nineoldandroids.animation.ValueAnimator, com.nineoldandroids.animation.Animator
    public void start() {
        super.start();
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.mTarget;
        if (this.mValues != null) {
            for (int i3 = 0; i3 < this.mValues.length; i3++) {
                str = String.valueOf(str) + "\n    " + this.mValues[i3].toString();
            }
        }
        return str;
    }

    ObjectAnimator(Object obj, String str) {
        this.mTarget = obj;
        setPropertyName(str);
    }

    @Override // com.nineoldandroids.animation.ValueAnimator, com.nineoldandroids.animation.Animator
    /* renamed from: clone */
    public ObjectAnimator m71clone() {
        return (ObjectAnimator) super.m71clone();
    }

    @Override // com.nineoldandroids.animation.ValueAnimator, com.nineoldandroids.animation.Animator
    public ObjectAnimator setDuration(long j3) {
        super.setDuration(j3);
        return this;
    }

    public static <T> ObjectAnimator ofFloat(T t16, Property<T, Float> property, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t16, property);
        objectAnimator.setFloatValues(fArr);
        return objectAnimator;
    }

    public static <T> ObjectAnimator ofInt(T t16, Property<T, Integer> property, int... iArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t16, property);
        objectAnimator.setIntValues(iArr);
        return objectAnimator;
    }

    public static <T, V> ObjectAnimator ofObject(T t16, Property<T, V> property, TypeEvaluator<V> typeEvaluator, V... vArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t16, property);
        objectAnimator.setObjectValues(vArr);
        objectAnimator.setEvaluator(typeEvaluator);
        return objectAnimator;
    }

    <T> ObjectAnimator(T t16, Property<T, ?> property) {
        this.mTarget = t16;
        setProperty(property);
    }
}
