package com.nineoldandroids.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.animation.Animator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ValueAnimator extends Animator {
    static final int ANIMATION_FRAME = 1;
    static final int ANIMATION_START = 0;
    private static final long DEFAULT_FRAME_DELAY = 10;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    static final int RUNNING = 1;
    static final int SEEKED = 2;
    static final int STOPPED = 0;
    private long mDelayStartTime;
    long mStartTime;
    PropertyValuesHolder[] mValues;
    HashMap<String, PropertyValuesHolder> mValuesMap;
    private static ThreadLocal<AnimationHandler> sAnimationHandler = new ThreadLocal<>();
    private static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() { // from class: com.nineoldandroids.animation.ValueAnimator.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() { // from class: com.nineoldandroids.animation.ValueAnimator.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims = new ThreadLocal<ArrayList<ValueAnimator>>() { // from class: com.nineoldandroids.animation.ValueAnimator.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims = new ThreadLocal<ArrayList<ValueAnimator>>() { // from class: com.nineoldandroids.animation.ValueAnimator.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims = new ThreadLocal<ArrayList<ValueAnimator>>() { // from class: com.nineoldandroids.animation.ValueAnimator.5
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final Interpolator sDefaultInterpolator = new AccelerateDecelerateInterpolator();
    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    private static long sFrameDelay = 10;
    long mSeekTime = -1;
    private boolean mPlayingBackwards = false;
    private int mCurrentIteration = 0;
    private float mCurrentFraction = 0.0f;
    private boolean mStartedDelay = false;
    int mPlayingState = 0;
    private boolean mRunning = false;
    private boolean mStarted = false;
    boolean mInitialized = false;
    private long mDuration = 300;
    private long mStartDelay = 0;
    private int mRepeatCount = 0;
    private int mRepeatMode = 1;
    private Interpolator mInterpolator = sDefaultInterpolator;
    private ArrayList<AnimatorUpdateListener> mUpdateListeners = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class AnimationHandler extends Handler {
        AnimationHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z16;
            boolean z17;
            ArrayList arrayList = (ArrayList) ValueAnimator.sAnimations.get();
            ArrayList arrayList2 = (ArrayList) ValueAnimator.sDelayedAnims.get();
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1) {
                    z17 = true;
                } else {
                    return;
                }
            } else {
                ArrayList arrayList3 = (ArrayList) ValueAnimator.sPendingAnimations.get();
                if (arrayList.size() <= 0 && arrayList2.size() <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i16 = 0; i16 < size; i16++) {
                        ValueAnimator valueAnimator = (ValueAnimator) arrayList4.get(i16);
                        if (valueAnimator.mStartDelay == 0) {
                            valueAnimator.startAnimation();
                        } else {
                            arrayList2.add(valueAnimator);
                        }
                    }
                }
                z17 = z16;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) ValueAnimator.sReadyAnims.get();
            ArrayList arrayList6 = (ArrayList) ValueAnimator.sEndingAnims.get();
            int size2 = arrayList2.size();
            for (int i17 = 0; i17 < size2; i17++) {
                ValueAnimator valueAnimator2 = (ValueAnimator) arrayList2.get(i17);
                if (valueAnimator2.delayedAnimationFrame(currentAnimationTimeMillis)) {
                    arrayList5.add(valueAnimator2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i18 = 0; i18 < size3; i18++) {
                    ValueAnimator valueAnimator3 = (ValueAnimator) arrayList5.get(i18);
                    valueAnimator3.startAnimation();
                    valueAnimator3.mRunning = true;
                    arrayList2.remove(valueAnimator3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i19 = 0;
            while (i19 < size4) {
                ValueAnimator valueAnimator4 = (ValueAnimator) arrayList.get(i19);
                if (valueAnimator4.animationFrame(currentAnimationTimeMillis)) {
                    arrayList6.add(valueAnimator4);
                }
                if (arrayList.size() == size4) {
                    i19++;
                } else {
                    size4--;
                    arrayList6.remove(valueAnimator4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i26 = 0; i26 < arrayList6.size(); i26++) {
                    ((ValueAnimator) arrayList6.get(i26)).endAnimation();
                }
                arrayList6.clear();
            }
            if (z17) {
                if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                    sendEmptyMessageDelayed(1, Math.max(0L, ValueAnimator.sFrameDelay - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
                }
            }
        }

        /* synthetic */ AnimationHandler(AnimationHandler animationHandler) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimator valueAnimator);
    }

    public static void clearAllAnimations() {
        sAnimations.get().clear();
        sPendingAnimations.get().clear();
        sDelayedAnims.get().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean delayedAnimationFrame(long j3) {
        if (!this.mStartedDelay) {
            this.mStartedDelay = true;
            this.mDelayStartTime = j3;
            return false;
        }
        long j16 = j3 - this.mDelayStartTime;
        long j17 = this.mStartDelay;
        if (j16 > j17) {
            this.mStartTime = j3 - (j16 - j17);
            this.mPlayingState = 1;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endAnimation() {
        ArrayList<Animator.AnimatorListener> arrayList;
        sAnimations.get().remove(this);
        sPendingAnimations.get().remove(this);
        sDelayedAnims.get().remove(this);
        this.mPlayingState = 0;
        if (this.mRunning && (arrayList = this.mListeners) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((Animator.AnimatorListener) arrayList2.get(i3)).onAnimationEnd(this);
            }
        }
        this.mRunning = false;
        this.mStarted = false;
    }

    public static int getCurrentAnimationsCount() {
        return sAnimations.get().size();
    }

    public static long getFrameDelay() {
        return sFrameDelay;
    }

    public static ValueAnimator ofFloat(float... fArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(fArr);
        return valueAnimator;
    }

    public static ValueAnimator ofInt(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        return valueAnimator;
    }

    public static ValueAnimator ofObject(TypeEvaluator typeEvaluator, Object... objArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setObjectValues(objArr);
        valueAnimator.setEvaluator(typeEvaluator);
        return valueAnimator;
    }

    public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder... propertyValuesHolderArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(propertyValuesHolderArr);
        return valueAnimator;
    }

    public static void setFrameDelay(long j3) {
        sFrameDelay = j3;
    }

    private void start(boolean z16) {
        if (Looper.myLooper() != null) {
            this.mPlayingBackwards = z16;
            this.mCurrentIteration = 0;
            this.mPlayingState = 0;
            this.mStarted = true;
            this.mStartedDelay = false;
            sPendingAnimations.get().add(this);
            if (this.mStartDelay == 0) {
                setCurrentPlayTime(getCurrentPlayTime());
                this.mPlayingState = 0;
                this.mRunning = true;
                ArrayList<Animator.AnimatorListener> arrayList = this.mListeners;
                if (arrayList != null) {
                    ArrayList arrayList2 = (ArrayList) arrayList.clone();
                    int size = arrayList2.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((Animator.AnimatorListener) arrayList2.get(i3)).onAnimationStart(this);
                    }
                }
            }
            AnimationHandler animationHandler = sAnimationHandler.get();
            if (animationHandler == null) {
                animationHandler = new AnimationHandler(null);
                sAnimationHandler.set(animationHandler);
            }
            animationHandler.sendEmptyMessage(0);
            return;
        }
        throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimation() {
        ArrayList<Animator.AnimatorListener> arrayList;
        initAnimation();
        sAnimations.get().add(this);
        if (this.mStartDelay > 0 && (arrayList = this.mListeners) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((Animator.AnimatorListener) arrayList2.get(i3)).onAnimationStart(this);
            }
        }
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        if (this.mUpdateListeners == null) {
            this.mUpdateListeners = new ArrayList<>();
        }
        this.mUpdateListeners.add(animatorUpdateListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void animateValue(float f16) {
        float interpolation = this.mInterpolator.getInterpolation(f16);
        this.mCurrentFraction = interpolation;
        int length = this.mValues.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.mValues[i3].calculateValue(interpolation);
        }
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i16 = 0; i16 < size; i16++) {
                this.mUpdateListeners.get(i16).onAnimationUpdate(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean animationFrame(long j3) {
        float f16;
        boolean z16 = true;
        if (this.mPlayingState == 0) {
            this.mPlayingState = 1;
            long j16 = this.mSeekTime;
            if (j16 < 0) {
                this.mStartTime = j3;
            } else {
                this.mStartTime = j3 - j16;
                this.mSeekTime = -1L;
            }
        }
        int i3 = this.mPlayingState;
        if (i3 != 1 && i3 != 2) {
            return false;
        }
        long j17 = this.mDuration;
        if (j17 > 0) {
            f16 = ((float) (j3 - this.mStartTime)) / ((float) j17);
        } else {
            f16 = 1.0f;
        }
        if (f16 >= 1.0f) {
            int i16 = this.mCurrentIteration;
            int i17 = this.mRepeatCount;
            if (i16 >= i17 && i17 != -1) {
                f16 = Math.min(f16, 1.0f);
                if (this.mPlayingBackwards) {
                    f16 = 1.0f - f16;
                }
                animateValue(f16);
                return z16;
            }
            ArrayList<Animator.AnimatorListener> arrayList = this.mListeners;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i18 = 0; i18 < size; i18++) {
                    this.mListeners.get(i18).onAnimationRepeat(this);
                }
            }
            if (this.mRepeatMode == 2) {
                this.mPlayingBackwards = !this.mPlayingBackwards;
            }
            this.mCurrentIteration += (int) f16;
            f16 %= 1.0f;
            this.mStartTime += this.mDuration;
        }
        z16 = false;
        if (this.mPlayingBackwards) {
        }
        animateValue(f16);
        return z16;
    }

    @Override // com.nineoldandroids.animation.Animator
    public void cancel() {
        ArrayList<Animator.AnimatorListener> arrayList;
        if (this.mPlayingState != 0 || sPendingAnimations.get().contains(this) || sDelayedAnims.get().contains(this)) {
            if (this.mRunning && (arrayList = this.mListeners) != null) {
                Iterator it = ((ArrayList) arrayList.clone()).iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
                }
            }
            endAnimation();
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void end() {
        if (!sAnimations.get().contains(this) && !sPendingAnimations.get().contains(this)) {
            this.mStartedDelay = false;
            startAnimation();
        } else if (!this.mInitialized) {
            initAnimation();
        }
        int i3 = this.mRepeatCount;
        if (i3 > 0 && (i3 & 1) == 1) {
            animateValue(0.0f);
        } else {
            animateValue(1.0f);
        }
        endAnimation();
    }

    public float getAnimatedFraction() {
        return this.mCurrentFraction;
    }

    public Object getAnimatedValue() {
        PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length <= 0) {
            return null;
        }
        return propertyValuesHolderArr[0].getAnimatedValue();
    }

    public long getCurrentPlayTime() {
        if (this.mInitialized && this.mPlayingState != 0) {
            return AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
        }
        return 0L;
    }

    @Override // com.nineoldandroids.animation.Animator
    public long getDuration() {
        return this.mDuration;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    @Override // com.nineoldandroids.animation.Animator
    public long getStartDelay() {
        return this.mStartDelay;
    }

    public PropertyValuesHolder[] getValues() {
        return this.mValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initAnimation() {
        if (!this.mInitialized) {
            int length = this.mValues.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.mValues[i3].init();
            }
            this.mInitialized = true;
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public boolean isRunning() {
        if (this.mPlayingState == 1 || this.mRunning) {
            return true;
        }
        return false;
    }

    @Override // com.nineoldandroids.animation.Animator
    public boolean isStarted() {
        return this.mStarted;
    }

    public void removeAllUpdateListeners() {
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        this.mUpdateListeners = null;
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorUpdateListener);
        if (this.mUpdateListeners.size() == 0) {
            this.mUpdateListeners = null;
        }
    }

    public void reverse() {
        this.mPlayingBackwards = !this.mPlayingBackwards;
        if (this.mPlayingState == 1) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = currentAnimationTimeMillis - (this.mDuration - (currentAnimationTimeMillis - this.mStartTime));
            return;
        }
        start(true);
    }

    public void setCurrentPlayTime(long j3) {
        initAnimation();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.mPlayingState != 1) {
            this.mSeekTime = j3;
            this.mPlayingState = 2;
        }
        this.mStartTime = currentAnimationTimeMillis - j3;
        animationFrame(currentAnimationTimeMillis);
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        PropertyValuesHolder[] propertyValuesHolderArr;
        if (typeEvaluator != null && (propertyValuesHolderArr = this.mValues) != null && propertyValuesHolderArr.length > 0) {
            propertyValuesHolderArr[0].setEvaluator(typeEvaluator);
        }
    }

    public void setFloatValues(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
            if (propertyValuesHolderArr != null && propertyValuesHolderArr.length != 0) {
                propertyValuesHolderArr[0].setFloatValues(fArr);
            } else {
                setValues(PropertyValuesHolder.ofFloat("", fArr));
            }
            this.mInitialized = false;
        }
    }

    public void setIntValues(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
            if (propertyValuesHolderArr != null && propertyValuesHolderArr.length != 0) {
                propertyValuesHolderArr[0].setIntValues(iArr);
            } else {
                setValues(PropertyValuesHolder.ofInt("", iArr));
            }
            this.mInitialized = false;
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setInterpolator(Interpolator interpolator) {
        if (interpolator != null) {
            this.mInterpolator = interpolator;
        } else {
            this.mInterpolator = new LinearInterpolator();
        }
    }

    public void setObjectValues(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
            if (propertyValuesHolderArr != null && propertyValuesHolderArr.length != 0) {
                propertyValuesHolderArr[0].setObjectValues(objArr);
            } else {
                setValues(PropertyValuesHolder.ofObject("", (TypeEvaluator) null, objArr));
            }
            this.mInitialized = false;
        }
    }

    public void setRepeatCount(int i3) {
        this.mRepeatCount = i3;
    }

    public void setRepeatMode(int i3) {
        this.mRepeatMode = i3;
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setStartDelay(long j3) {
        this.mStartDelay = j3;
    }

    public void setValues(PropertyValuesHolder... propertyValuesHolderArr) {
        int length = propertyValuesHolderArr.length;
        this.mValues = propertyValuesHolderArr;
        this.mValuesMap = new HashMap<>(length);
        for (PropertyValuesHolder propertyValuesHolder : propertyValuesHolderArr) {
            this.mValuesMap.put(propertyValuesHolder.getPropertyName(), propertyValuesHolder);
        }
        this.mInitialized = false;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.mValues != null) {
            for (int i3 = 0; i3 < this.mValues.length; i3++) {
                str = String.valueOf(str) + "\n    " + this.mValues[i3].toString();
            }
        }
        return str;
    }

    @Override // com.nineoldandroids.animation.Animator
    /* renamed from: clone */
    public ValueAnimator m71clone() {
        ValueAnimator valueAnimator = (ValueAnimator) super.m71clone();
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            valueAnimator.mUpdateListeners = new ArrayList<>();
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                valueAnimator.mUpdateListeners.add(arrayList.get(i3));
            }
        }
        valueAnimator.mSeekTime = -1L;
        valueAnimator.mPlayingBackwards = false;
        valueAnimator.mCurrentIteration = 0;
        valueAnimator.mInitialized = false;
        valueAnimator.mPlayingState = 0;
        valueAnimator.mStartedDelay = false;
        PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr != null) {
            int length = propertyValuesHolderArr.length;
            valueAnimator.mValues = new PropertyValuesHolder[length];
            valueAnimator.mValuesMap = new HashMap<>(length);
            for (int i16 = 0; i16 < length; i16++) {
                PropertyValuesHolder m75clone = propertyValuesHolderArr[i16].m75clone();
                valueAnimator.mValues[i16] = m75clone;
                valueAnimator.mValuesMap.put(m75clone.getPropertyName(), m75clone);
            }
        }
        return valueAnimator;
    }

    @Override // com.nineoldandroids.animation.Animator
    public ValueAnimator setDuration(long j3) {
        if (j3 >= 0) {
            this.mDuration = j3;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j3);
    }

    public Object getAnimatedValue(String str) {
        PropertyValuesHolder propertyValuesHolder = this.mValuesMap.get(str);
        if (propertyValuesHolder != null) {
            return propertyValuesHolder.getAnimatedValue();
        }
        return null;
    }

    @Override // com.nineoldandroids.animation.Animator
    public void start() {
        start(false);
    }
}
