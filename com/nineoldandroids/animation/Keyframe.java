package com.nineoldandroids.animation;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class Keyframe implements Cloneable {
    float mFraction;
    Class mValueType;
    private Interpolator mInterpolator = null;
    boolean mHasValue = false;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class FloatKeyframe extends Keyframe {
        float mValue;

        FloatKeyframe(float f16, float f17) {
            this.mFraction = f16;
            this.mValue = f17;
            this.mValueType = Float.TYPE;
            this.mHasValue = true;
        }

        public float getFloatValue() {
            return this.mValue;
        }

        @Override // com.nineoldandroids.animation.Keyframe
        public Object getValue() {
            return Float.valueOf(this.mValue);
        }

        @Override // com.nineoldandroids.animation.Keyframe
        public void setValue(Object obj) {
            if (obj != null && obj.getClass() == Float.class) {
                this.mValue = ((Float) obj).floatValue();
                this.mHasValue = true;
            }
        }

        @Override // com.nineoldandroids.animation.Keyframe
        /* renamed from: clone */
        public FloatKeyframe m73clone() {
            FloatKeyframe floatKeyframe = new FloatKeyframe(getFraction(), this.mValue);
            floatKeyframe.setInterpolator(getInterpolator());
            return floatKeyframe;
        }

        FloatKeyframe(float f16) {
            this.mFraction = f16;
            this.mValueType = Float.TYPE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class IntKeyframe extends Keyframe {
        int mValue;

        IntKeyframe(float f16, int i3) {
            this.mFraction = f16;
            this.mValue = i3;
            this.mValueType = Integer.TYPE;
            this.mHasValue = true;
        }

        public int getIntValue() {
            return this.mValue;
        }

        @Override // com.nineoldandroids.animation.Keyframe
        public Object getValue() {
            return Integer.valueOf(this.mValue);
        }

        @Override // com.nineoldandroids.animation.Keyframe
        public void setValue(Object obj) {
            if (obj != null && obj.getClass() == Integer.class) {
                this.mValue = ((Integer) obj).intValue();
                this.mHasValue = true;
            }
        }

        @Override // com.nineoldandroids.animation.Keyframe
        /* renamed from: clone */
        public IntKeyframe m73clone() {
            IntKeyframe intKeyframe = new IntKeyframe(getFraction(), this.mValue);
            intKeyframe.setInterpolator(getInterpolator());
            return intKeyframe;
        }

        IntKeyframe(float f16) {
            this.mFraction = f16;
            this.mValueType = Integer.TYPE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class ObjectKeyframe extends Keyframe {
        Object mValue;

        ObjectKeyframe(float f16, Object obj) {
            boolean z16;
            Class<?> cls;
            this.mFraction = f16;
            this.mValue = obj;
            if (obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mHasValue = z16;
            if (z16) {
                cls = obj.getClass();
            } else {
                cls = Object.class;
            }
            this.mValueType = cls;
        }

        @Override // com.nineoldandroids.animation.Keyframe
        public Object getValue() {
            return this.mValue;
        }

        @Override // com.nineoldandroids.animation.Keyframe
        public void setValue(Object obj) {
            boolean z16;
            this.mValue = obj;
            if (obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mHasValue = z16;
        }

        @Override // com.nineoldandroids.animation.Keyframe
        /* renamed from: clone */
        public ObjectKeyframe m73clone() {
            ObjectKeyframe objectKeyframe = new ObjectKeyframe(getFraction(), this.mValue);
            objectKeyframe.setInterpolator(getInterpolator());
            return objectKeyframe;
        }
    }

    public static Keyframe ofFloat(float f16, float f17) {
        return new FloatKeyframe(f16, f17);
    }

    public static Keyframe ofInt(float f16, int i3) {
        return new IntKeyframe(f16, i3);
    }

    public static Keyframe ofObject(float f16, Object obj) {
        return new ObjectKeyframe(f16, obj);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract Keyframe m73clone();

    public float getFraction() {
        return this.mFraction;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public Class getType() {
        return this.mValueType;
    }

    public abstract Object getValue();

    public boolean hasValue() {
        return this.mHasValue;
    }

    public void setFraction(float f16) {
        this.mFraction = f16;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public abstract void setValue(Object obj);

    public static Keyframe ofFloat(float f16) {
        return new FloatKeyframe(f16);
    }

    public static Keyframe ofInt(float f16) {
        return new IntKeyframe(f16);
    }

    public static Keyframe ofObject(float f16) {
        return new ObjectKeyframe(f16, null);
    }
}
