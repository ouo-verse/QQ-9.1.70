package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ViewPropertyAnimatorPreHC extends ViewPropertyAnimator {
    private static final int ALPHA = 512;
    private static final int NONE = 0;
    private static final int ROTATION = 16;
    private static final int ROTATION_X = 32;
    private static final int ROTATION_Y = 64;
    private static final int SCALE_X = 4;
    private static final int SCALE_Y = 8;
    private static final int TRANSFORM_MASK = 511;
    private static final int TRANSLATION_X = 1;
    private static final int TRANSLATION_Y = 2;
    private static final int X = 128;
    private static final int Y = 256;
    private long mDuration;
    private Interpolator mInterpolator;
    private final AnimatorProxy mProxy;
    private final WeakReference<View> mView;
    private boolean mDurationSet = false;
    private long mStartDelay = 0;
    private boolean mStartDelaySet = false;
    private boolean mInterpolatorSet = false;
    private Animator.AnimatorListener mListener = null;
    private AnimatorEventListener mAnimatorEventListener = new AnimatorEventListener(this, null);
    ArrayList<NameValuesHolder> mPendingAnimations = new ArrayList<>();
    private Runnable mAnimationStarter = new Runnable() { // from class: com.nineoldandroids.view.ViewPropertyAnimatorPreHC.1
        @Override // java.lang.Runnable
        public void run() {
            ViewPropertyAnimatorPreHC.this.startAnimation();
        }
    };
    private HashMap<Animator, PropertyBundle> mAnimatorMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class AnimatorEventListener implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        AnimatorEventListener() {
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationCancel(animator);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationEnd(animator);
            }
            ViewPropertyAnimatorPreHC.this.mAnimatorMap.remove(animator);
            if (ViewPropertyAnimatorPreHC.this.mAnimatorMap.isEmpty()) {
                ViewPropertyAnimatorPreHC.this.mListener = null;
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationRepeat(animator);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationStart(animator);
            }
        }

        @Override // com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            PropertyBundle propertyBundle = (PropertyBundle) ViewPropertyAnimatorPreHC.this.mAnimatorMap.get(valueAnimator);
            if ((propertyBundle.mPropertyMask & 511) != 0 && (view = (View) ViewPropertyAnimatorPreHC.this.mView.get()) != null) {
                view.invalidate();
            }
            ArrayList<NameValuesHolder> arrayList = propertyBundle.mNameValuesHolder;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    NameValuesHolder nameValuesHolder = arrayList.get(i3);
                    ViewPropertyAnimatorPreHC.this.setValue(nameValuesHolder.mNameConstant, nameValuesHolder.mFromValue + (nameValuesHolder.mDeltaValue * animatedFraction));
                }
            }
            View view2 = (View) ViewPropertyAnimatorPreHC.this.mView.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }

        /* synthetic */ AnimatorEventListener(ViewPropertyAnimatorPreHC viewPropertyAnimatorPreHC, AnimatorEventListener animatorEventListener) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class NameValuesHolder {
        float mDeltaValue;
        float mFromValue;
        int mNameConstant;

        NameValuesHolder(int i3, float f16, float f17) {
            this.mNameConstant = i3;
            this.mFromValue = f16;
            this.mDeltaValue = f17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class PropertyBundle {
        ArrayList<NameValuesHolder> mNameValuesHolder;
        int mPropertyMask;

        PropertyBundle(int i3, ArrayList<NameValuesHolder> arrayList) {
            this.mPropertyMask = i3;
            this.mNameValuesHolder = arrayList;
        }

        boolean cancel(int i3) {
            ArrayList<NameValuesHolder> arrayList;
            if ((this.mPropertyMask & i3) != 0 && (arrayList = this.mNameValuesHolder) != null) {
                int size = arrayList.size();
                for (int i16 = 0; i16 < size; i16++) {
                    if (this.mNameValuesHolder.get(i16).mNameConstant == i3) {
                        this.mNameValuesHolder.remove(i16);
                        this.mPropertyMask = (~i3) & this.mPropertyMask;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewPropertyAnimatorPreHC(View view) {
        this.mView = new WeakReference<>(view);
        this.mProxy = AnimatorProxy.wrap(view);
    }

    private void animateProperty(int i3, float f16) {
        float value = getValue(i3);
        animatePropertyBy(i3, value, f16 - value);
    }

    private void animatePropertyBy(int i3, float f16) {
        animatePropertyBy(i3, getValue(i3), f16);
    }

    private float getValue(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 8) {
                        if (i3 != 16) {
                            if (i3 != 32) {
                                if (i3 != 64) {
                                    if (i3 != 128) {
                                        if (i3 != 256) {
                                            if (i3 != 512) {
                                                return 0.0f;
                                            }
                                            return this.mProxy.getAlpha();
                                        }
                                        return this.mProxy.getY();
                                    }
                                    return this.mProxy.getX();
                                }
                                return this.mProxy.getRotationY();
                            }
                            return this.mProxy.getRotationX();
                        }
                        return this.mProxy.getRotation();
                    }
                    return this.mProxy.getScaleY();
                }
                return this.mProxy.getScaleX();
            }
            return this.mProxy.getTranslationY();
        }
        return this.mProxy.getTranslationX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i3, float f16) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 8) {
                        if (i3 != 16) {
                            if (i3 != 32) {
                                if (i3 != 64) {
                                    if (i3 != 128) {
                                        if (i3 != 256) {
                                            if (i3 == 512) {
                                                this.mProxy.setAlpha(f16);
                                                return;
                                            }
                                            return;
                                        }
                                        this.mProxy.setY(f16);
                                        return;
                                    }
                                    this.mProxy.setX(f16);
                                    return;
                                }
                                this.mProxy.setRotationY(f16);
                                return;
                            }
                            this.mProxy.setRotationX(f16);
                            return;
                        }
                        this.mProxy.setRotation(f16);
                        return;
                    }
                    this.mProxy.setScaleY(f16);
                    return;
                }
                this.mProxy.setScaleX(f16);
                return;
            }
            this.mProxy.setTranslationY(f16);
            return;
        }
        this.mProxy.setTranslationX(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimation() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        ArrayList arrayList = (ArrayList) this.mPendingAnimations.clone();
        this.mPendingAnimations.clear();
        int size = arrayList.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            i3 |= ((NameValuesHolder) arrayList.get(i16)).mNameConstant;
        }
        this.mAnimatorMap.put(ofFloat, new PropertyBundle(i3, arrayList));
        ofFloat.addUpdateListener(this.mAnimatorEventListener);
        ofFloat.addListener(this.mAnimatorEventListener);
        if (this.mStartDelaySet) {
            ofFloat.setStartDelay(this.mStartDelay);
        }
        if (this.mDurationSet) {
            ofFloat.setDuration(this.mDuration);
        }
        if (this.mInterpolatorSet) {
            ofFloat.setInterpolator(this.mInterpolator);
        }
        ofFloat.start();
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator alpha(float f16) {
        animateProperty(512, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator alphaBy(float f16) {
        animatePropertyBy(512, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public void cancel() {
        if (this.mAnimatorMap.size() > 0) {
            Iterator it = ((HashMap) this.mAnimatorMap.clone()).keySet().iterator();
            while (it.hasNext()) {
                ((Animator) it.next()).cancel();
            }
        }
        this.mPendingAnimations.clear();
        View view = this.mView.get();
        if (view != null) {
            view.removeCallbacks(this.mAnimationStarter);
        }
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public long getDuration() {
        if (this.mDurationSet) {
            return this.mDuration;
        }
        return new ValueAnimator().getDuration();
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public long getStartDelay() {
        if (this.mStartDelaySet) {
            return this.mStartDelay;
        }
        return 0L;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotation(float f16) {
        animateProperty(16, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationBy(float f16) {
        animatePropertyBy(16, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationX(float f16) {
        animateProperty(32, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationXBy(float f16) {
        animatePropertyBy(32, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationY(float f16) {
        animateProperty(64, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationYBy(float f16) {
        animatePropertyBy(64, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleX(float f16) {
        animateProperty(4, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleXBy(float f16) {
        animatePropertyBy(4, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleY(float f16) {
        animateProperty(8, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleYBy(float f16) {
        animatePropertyBy(8, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setDuration(long j3) {
        if (j3 >= 0) {
            this.mDurationSet = true;
            this.mDuration = j3;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j3);
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        this.mInterpolatorSet = true;
        this.mInterpolator = interpolator;
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setListener(Animator.AnimatorListener animatorListener) {
        this.mListener = animatorListener;
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setStartDelay(long j3) {
        if (j3 >= 0) {
            this.mStartDelaySet = true;
            this.mStartDelay = j3;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j3);
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public void start() {
        startAnimation();
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationX(float f16) {
        animateProperty(1, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationXBy(float f16) {
        animatePropertyBy(1, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationY(float f16) {
        animateProperty(2, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationYBy(float f16) {
        animatePropertyBy(2, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator x(float f16) {
        animateProperty(128, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator xBy(float f16) {
        animatePropertyBy(128, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator y(float f16) {
        animateProperty(256, f16);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator yBy(float f16) {
        animatePropertyBy(256, f16);
        return this;
    }

    private void animatePropertyBy(int i3, float f16, float f17) {
        Animator animator;
        if (this.mAnimatorMap.size() > 0) {
            Iterator<Animator> it = this.mAnimatorMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    animator = null;
                    break;
                }
                Animator next = it.next();
                PropertyBundle propertyBundle = this.mAnimatorMap.get(next);
                if (propertyBundle.cancel(i3) && propertyBundle.mPropertyMask == 0) {
                    animator = next;
                    break;
                }
            }
            if (animator != null) {
                animator.cancel();
            }
        }
        this.mPendingAnimations.add(new NameValuesHolder(i3, f16, f17));
        View view = this.mView.get();
        if (view != null) {
            view.removeCallbacks(this.mAnimationStarter);
            view.post(this.mAnimationStarter);
        }
    }
}
