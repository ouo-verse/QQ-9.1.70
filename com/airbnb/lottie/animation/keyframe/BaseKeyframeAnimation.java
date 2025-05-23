package com.airbnb.lottie.animation.keyframe;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.tencent.mapsdk.internal.by;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class BaseKeyframeAnimation<K, A> {
    private final KeyframesWrapper<K> keyframesWrapper;

    @Nullable
    protected LottieValueCallback<A> valueCallback;
    final List<AnimationListener> listeners = new ArrayList(1);
    private boolean isDiscrete = false;
    protected float progress = 0.0f;

    @Nullable
    private A cachedGetValue = null;
    private float cachedStartDelayProgress = -1.0f;
    private float cachedEndProgress = -1.0f;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface AnimationListener {
        void onValueChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class EmptyKeyframeWrapper<T> implements KeyframesWrapper<T> {
        EmptyKeyframeWrapper() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public Keyframe<T> getCurrentKeyframe() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f16) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f16) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface KeyframesWrapper<T> {
        Keyframe<T> getCurrentKeyframe();

        @FloatRange(from = 0.0d, to = by.f147964a)
        float getEndProgress();

        @FloatRange(from = 0.0d, to = by.f147964a)
        float getStartDelayProgress();

        boolean isCachedValueEnabled(float f16);

        boolean isEmpty();

        boolean isValueChanged(float f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class KeyframesWrapperImpl<T> implements KeyframesWrapper<T> {
        private Keyframe<T> cachedCurrentKeyframe = null;
        private float cachedInterpolatedProgress = -1.0f;

        @NonNull
        private Keyframe<T> currentKeyframe = findKeyframe(0.0f);
        private final List<? extends Keyframe<T>> keyframes;

        KeyframesWrapperImpl(List<? extends Keyframe<T>> list) {
            this.keyframes = list;
        }

        private Keyframe<T> findKeyframe(float f16) {
            List<? extends Keyframe<T>> list = this.keyframes;
            Keyframe<T> keyframe = list.get(list.size() - 1);
            if (f16 >= keyframe.getStartProgress()) {
                return keyframe;
            }
            for (int size = this.keyframes.size() - 2; size >= 1; size--) {
                Keyframe<T> keyframe2 = this.keyframes.get(size);
                if (this.currentKeyframe != keyframe2 && keyframe2.containsProgress(f16)) {
                    return keyframe2;
                }
            }
            return this.keyframes.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        @NonNull
        public Keyframe<T> getCurrentKeyframe() {
            return this.currentKeyframe;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            return this.keyframes.get(r0.size() - 1).getEndProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return this.keyframes.get(0).getStartProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f16) {
            Keyframe<T> keyframe = this.cachedCurrentKeyframe;
            Keyframe<T> keyframe2 = this.currentKeyframe;
            if (keyframe == keyframe2 && this.cachedInterpolatedProgress == f16) {
                return true;
            }
            this.cachedCurrentKeyframe = keyframe2;
            this.cachedInterpolatedProgress = f16;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f16) {
            if (this.currentKeyframe.containsProgress(f16)) {
                return !this.currentKeyframe.isStatic();
            }
            this.currentKeyframe = findKeyframe(f16);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class SingleKeyframeWrapper<T> implements KeyframesWrapper<T> {
        private float cachedInterpolatedProgress = -1.0f;

        @NonNull
        private final Keyframe<T> keyframe;

        SingleKeyframeWrapper(List<? extends Keyframe<T>> list) {
            this.keyframe = list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public Keyframe<T> getCurrentKeyframe() {
            return this.keyframe;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            return this.keyframe.getEndProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return this.keyframe.getStartProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f16) {
            if (this.cachedInterpolatedProgress == f16) {
                return true;
            }
            this.cachedInterpolatedProgress = f16;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f16) {
            return !this.keyframe.isStatic();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        this.keyframesWrapper = wrap(list);
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    private float getStartDelayProgress() {
        if (this.cachedStartDelayProgress == -1.0f) {
            this.cachedStartDelayProgress = this.keyframesWrapper.getStartDelayProgress();
        }
        return this.cachedStartDelayProgress;
    }

    private static <T> KeyframesWrapper<T> wrap(List<? extends Keyframe<T>> list) {
        if (list.isEmpty()) {
            return new EmptyKeyframeWrapper();
        }
        if (list.size() == 1) {
            return new SingleKeyframeWrapper(list);
        }
        return new KeyframesWrapperImpl(list);
    }

    public void addUpdateListener(AnimationListener animationListener) {
        this.listeners.add(animationListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Keyframe<K> getCurrentKeyframe() {
        L.beginSection("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe<K> currentKeyframe = this.keyframesWrapper.getCurrentKeyframe();
        L.endSection("BaseKeyframeAnimation#getCurrentKeyframe");
        return currentKeyframe;
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    float getEndProgress() {
        if (this.cachedEndProgress == -1.0f) {
            this.cachedEndProgress = this.keyframesWrapper.getEndProgress();
        }
        return this.cachedEndProgress;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getInterpolatedCurrentKeyframeProgress() {
        Keyframe<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe != null && !currentKeyframe.isStatic()) {
            return currentKeyframe.interpolator.getInterpolation(getLinearCurrentKeyframeProgress());
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getLinearCurrentKeyframeProgress() {
        if (this.isDiscrete) {
            return 0.0f;
        }
        Keyframe<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return (this.progress - currentKeyframe.getStartProgress()) / (currentKeyframe.getEndProgress() - currentKeyframe.getStartProgress());
    }

    public float getProgress() {
        return this.progress;
    }

    public A getValue() {
        A value;
        float linearCurrentKeyframeProgress = getLinearCurrentKeyframeProgress();
        if (this.valueCallback == null && this.keyframesWrapper.isCachedValueEnabled(linearCurrentKeyframeProgress)) {
            return this.cachedGetValue;
        }
        Keyframe<K> currentKeyframe = getCurrentKeyframe();
        Interpolator interpolator = currentKeyframe.xInterpolator;
        if (interpolator != null && currentKeyframe.yInterpolator != null) {
            value = getValue(currentKeyframe, linearCurrentKeyframeProgress, interpolator.getInterpolation(linearCurrentKeyframeProgress), currentKeyframe.yInterpolator.getInterpolation(linearCurrentKeyframeProgress));
        } else {
            value = getValue(currentKeyframe, getInterpolatedCurrentKeyframeProgress());
        }
        this.cachedGetValue = value;
        return value;
    }

    abstract A getValue(Keyframe<K> keyframe, float f16);

    public void notifyListeners() {
        for (int i3 = 0; i3 < this.listeners.size(); i3++) {
            this.listeners.get(i3).onValueChanged();
        }
    }

    public void setIsDiscrete() {
        this.isDiscrete = true;
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        if (this.keyframesWrapper.isEmpty()) {
            return;
        }
        if (f16 < getStartDelayProgress()) {
            f16 = getStartDelayProgress();
        } else if (f16 > getEndProgress()) {
            f16 = getEndProgress();
        }
        if (f16 == this.progress) {
            return;
        }
        this.progress = f16;
        if (this.keyframesWrapper.isValueChanged(f16)) {
            notifyListeners();
        }
    }

    public void setValueCallback(@Nullable LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.valueCallback;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation(null);
        }
        this.valueCallback = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }

    protected A getValue(Keyframe<K> keyframe, float f16, float f17, float f18) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }
}
