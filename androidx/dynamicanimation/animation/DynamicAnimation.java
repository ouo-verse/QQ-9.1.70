package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    private static final float UNSET = Float.MAX_VALUE;
    private final ArrayList<OnAnimationEndListener> mEndListeners;
    private long mLastFrameTime;
    float mMaxValue;
    float mMinValue;
    private float mMinVisibleChange;
    final FloatPropertyCompat mProperty;
    boolean mRunning;
    boolean mStartValueIsSet;
    final Object mTarget;
    private final ArrayList<OnAnimationUpdateListener> mUpdateListeners;
    float mValue;
    float mVelocity;
    public static final ViewProperty TRANSLATION_X = new ViewProperty("translationX") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.1
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f16) {
            view.setTranslationX(f16);
        }
    };
    public static final ViewProperty TRANSLATION_Y = new ViewProperty("translationY") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.2
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f16) {
            view.setTranslationY(f16);
        }
    };
    public static final ViewProperty TRANSLATION_Z = new ViewProperty("translationZ") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.3
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return ViewCompat.getTranslationZ(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f16) {
            ViewCompat.setTranslationZ(view, f16);
        }
    };
    public static final ViewProperty SCALE_X = new ViewProperty(BasicAnimation.KeyPath.SCALE_X) { // from class: androidx.dynamicanimation.animation.DynamicAnimation.4
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getScaleX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f16) {
            view.setScaleX(f16);
        }
    };
    public static final ViewProperty SCALE_Y = new ViewProperty(BasicAnimation.KeyPath.SCALE_Y) { // from class: androidx.dynamicanimation.animation.DynamicAnimation.5
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getScaleY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f16) {
            view.setScaleY(f16);
        }
    };
    public static final ViewProperty ROTATION = new ViewProperty(BasicAnimation.KeyPath.ROTATION) { // from class: androidx.dynamicanimation.animation.DynamicAnimation.6
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getRotation();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f16) {
            view.setRotation(f16);
        }
    };
    public static final ViewProperty ROTATION_X = new ViewProperty(BasicAnimation.KeyPath.ROTATION_X) { // from class: androidx.dynamicanimation.animation.DynamicAnimation.7
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getRotationX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f16) {
            view.setRotationX(f16);
        }
    };
    public static final ViewProperty ROTATION_Y = new ViewProperty(BasicAnimation.KeyPath.ROTATION_Y) { // from class: androidx.dynamicanimation.animation.DynamicAnimation.8
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getRotationY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f16) {
            view.setRotationY(f16);
        }
    };
    public static final ViewProperty X = new ViewProperty(HippyTKDListViewAdapter.X) { // from class: androidx.dynamicanimation.animation.DynamicAnimation.9
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f16) {
            view.setX(f16);
        }
    };
    public static final ViewProperty Y = new ViewProperty("y") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.10
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f16) {
            view.setY(f16);
        }
    };
    public static final ViewProperty Z = new ViewProperty(QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW) { // from class: androidx.dynamicanimation.animation.DynamicAnimation.11
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return ViewCompat.getZ(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f16) {
            ViewCompat.setZ(view, f16);
        }
    };
    public static final ViewProperty ALPHA = new ViewProperty(com.tencent.luggage.wxa.c8.c.f123400v) { // from class: androidx.dynamicanimation.animation.DynamicAnimation.12
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getAlpha();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f16) {
            view.setAlpha(f16);
        }
    };
    public static final ViewProperty SCROLL_X = new ViewProperty("scrollX") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.13
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getScrollX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f16) {
            view.setScrollX((int) f16);
        }
    };
    public static final ViewProperty SCROLL_Y = new ViewProperty("scrollY") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.14
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getScrollY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f16) {
            view.setScrollY((int) f16);
        }
    };

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class MassState {
        float mValue;
        float mVelocity;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z16, float f16, float f17);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f16, float f17);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        ViewProperty(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DynamicAnimation(final FloatValueHolder floatValueHolder) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = null;
        this.mProperty = new FloatPropertyCompat("FloatValueHolder") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.15
            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(Object obj) {
                return floatValueHolder.getValue();
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(Object obj, float f16) {
                floatValueHolder.setValue(f16);
            }
        };
        this.mMinVisibleChange = 1.0f;
    }

    private void endAnimationInternal(boolean z16) {
        this.mRunning = false;
        AnimationHandler.getInstance().removeCallback(this);
        this.mLastFrameTime = 0L;
        this.mStartValueIsSet = false;
        for (int i3 = 0; i3 < this.mEndListeners.size(); i3++) {
            if (this.mEndListeners.get(i3) != null) {
                this.mEndListeners.get(i3).onAnimationEnd(this, z16, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mEndListeners);
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    private static <T> void removeEntry(ArrayList<T> arrayList, T t16) {
        int indexOf = arrayList.indexOf(t16);
        if (indexOf >= 0) {
            arrayList.set(indexOf, null);
        }
    }

    private static <T> void removeNullEntries(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void startAnimationInternal() {
        if (!this.mRunning) {
            this.mRunning = true;
            if (!this.mStartValueIsSet) {
                this.mValue = getPropertyValue();
            }
            float f16 = this.mValue;
            if (f16 <= this.mMaxValue && f16 >= this.mMinValue) {
                AnimationHandler.getInstance().addAnimationFrameCallback(this, 0L);
                return;
            }
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
    }

    public T addEndListener(OnAnimationEndListener onAnimationEndListener) {
        if (!this.mEndListeners.contains(onAnimationEndListener)) {
            this.mEndListeners.add(onAnimationEndListener);
        }
        return this;
    }

    public T addUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (!isRunning()) {
            if (!this.mUpdateListeners.contains(onAnimationUpdateListener)) {
                this.mUpdateListeners.add(onAnimationUpdateListener);
            }
            return this;
        }
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void cancel() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.mRunning) {
                endAnimationInternal(true);
                return;
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean doAnimationFrame(long j3) {
        long j16 = this.mLastFrameTime;
        if (j16 == 0) {
            this.mLastFrameTime = j3;
            setPropertyValue(this.mValue);
            return false;
        }
        this.mLastFrameTime = j3;
        boolean updateValueAndVelocity = updateValueAndVelocity(j3 - j16);
        float min = Math.min(this.mValue, this.mMaxValue);
        this.mValue = min;
        float max = Math.max(min, this.mMinValue);
        this.mValue = max;
        setPropertyValue(max);
        if (updateValueAndVelocity) {
            endAnimationInternal(false);
        }
        return updateValueAndVelocity;
    }

    abstract float getAcceleration(float f16, float f17);

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    abstract boolean isAtEquilibrium(float f16, float f17);

    public boolean isRunning() {
        return this.mRunning;
    }

    public void removeEndListener(OnAnimationEndListener onAnimationEndListener) {
        removeEntry(this.mEndListeners, onAnimationEndListener);
    }

    public void removeUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        removeEntry(this.mUpdateListeners, onAnimationUpdateListener);
    }

    public T setMaxValue(float f16) {
        this.mMaxValue = f16;
        return this;
    }

    public T setMinValue(float f16) {
        this.mMinValue = f16;
        return this;
    }

    public T setMinimumVisibleChange(@FloatRange(from = 0.0d, fromInclusive = false) float f16) {
        if (f16 > 0.0f) {
            this.mMinVisibleChange = f16;
            setValueThreshold(f16 * 0.75f);
            return this;
        }
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    void setPropertyValue(float f16) {
        this.mProperty.setValue(this.mTarget, f16);
        for (int i3 = 0; i3 < this.mUpdateListeners.size(); i3++) {
            if (this.mUpdateListeners.get(i3) != null) {
                this.mUpdateListeners.get(i3).onAnimationUpdate(this, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mUpdateListeners);
    }

    public T setStartValue(float f16) {
        this.mValue = f16;
        this.mStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float f16) {
        this.mVelocity = f16;
        return this;
    }

    abstract void setValueThreshold(float f16);

    public void start() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.mRunning) {
                startAnimationInternal();
                return;
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    abstract boolean updateValueAndVelocity(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K> DynamicAnimation(K k3, FloatPropertyCompat<K> floatPropertyCompat) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = k3;
        this.mProperty = floatPropertyCompat;
        if (floatPropertyCompat != ROTATION && floatPropertyCompat != ROTATION_X && floatPropertyCompat != ROTATION_Y) {
            if (floatPropertyCompat == ALPHA) {
                this.mMinVisibleChange = 0.00390625f;
                return;
            } else if (floatPropertyCompat != SCALE_X && floatPropertyCompat != SCALE_Y) {
                this.mMinVisibleChange = 1.0f;
                return;
            } else {
                this.mMinVisibleChange = 0.00390625f;
                return;
            }
        }
        this.mMinVisibleChange = 0.1f;
    }
}
