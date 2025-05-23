package com.tencent.gdtad.views.shake;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.R;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtShakeIconView extends ImageView {
    private static final String TAG = "GdtShakeIconView";
    private AnimationSet mAnimationSet;
    private int mCompleteCount;
    private int mRepeatIntervalMillis;
    private Runnable mStartRunnable;
    private int mTotalRepeatCount;
    private WeakReference<OnAnimationListener> mWeakListener;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface OnAnimationListener {
        void onAnimationEnd();

        void onAnimationRepeat(int i3);

        void onAnimationStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            OnAnimationListener onAnimationListener;
            GdtLog.i(GdtShakeIconView.TAG, "[onAnimationEnd]");
            if (GdtShakeIconView.access$104(GdtShakeIconView.this) > GdtShakeIconView.this.mTotalRepeatCount) {
                GdtShakeIconView.this.mCompleteCount = 0;
                if (GdtShakeIconView.this.mWeakListener != null) {
                    onAnimationListener = (OnAnimationListener) GdtShakeIconView.this.mWeakListener.get();
                } else {
                    onAnimationListener = null;
                }
                if (onAnimationListener != null) {
                    onAnimationListener.onAnimationEnd();
                    return;
                }
                return;
            }
            GdtShakeIconView gdtShakeIconView = GdtShakeIconView.this;
            gdtShakeIconView.postDelayed(gdtShakeIconView.mStartRunnable, GdtShakeIconView.this.mRepeatIntervalMillis);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            GdtLog.i(GdtShakeIconView.TAG, "[onAnimationRepeat]");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            OnAnimationListener onAnimationListener;
            GdtLog.i(GdtShakeIconView.TAG, "[onAnimationStart]");
            if (GdtShakeIconView.this.mWeakListener != null) {
                onAnimationListener = (OnAnimationListener) GdtShakeIconView.this.mWeakListener.get();
            } else {
                onAnimationListener = null;
            }
            if (onAnimationListener == null) {
                return;
            }
            if (GdtShakeIconView.this.mCompleteCount == 0) {
                onAnimationListener.onAnimationStart();
            } else {
                onAnimationListener.onAnimationRepeat(GdtShakeIconView.this.mCompleteCount);
            }
        }
    }

    public GdtShakeIconView(Context context) {
        this(context, null);
    }

    static /* synthetic */ int access$104(GdtShakeIconView gdtShakeIconView) {
        int i3 = gdtShakeIconView.mCompleteCount + 1;
        gdtShakeIconView.mCompleteCount = i3;
        return i3;
    }

    @NonNull
    private static AnimationSet createShakeAnimation() {
        AnimationSet animationSet = new AnimationSet(true);
        RotateAnimation createStepAnimation = createStepAnimation(10.0f, 167L);
        animationSet.addAnimation(createStepAnimation);
        int duration = (int) (0 + createStepAnimation.getDuration());
        RotateAnimation createStepAnimation2 = createStepAnimation(-20.0f, 167L);
        long j3 = duration;
        createStepAnimation2.setStartOffset(j3);
        animationSet.addAnimation(createStepAnimation2);
        int duration2 = (int) (j3 + createStepAnimation2.getDuration());
        RotateAnimation createStepAnimation3 = createStepAnimation(20.0f, 167L);
        long j16 = duration2;
        createStepAnimation3.setStartOffset(j16);
        animationSet.addAnimation(createStepAnimation3);
        int duration3 = (int) (j16 + createStepAnimation3.getDuration());
        RotateAnimation createStepAnimation4 = createStepAnimation(-20.0f, 167L);
        long j17 = duration3;
        createStepAnimation4.setStartOffset(j17);
        animationSet.addAnimation(createStepAnimation4);
        int duration4 = (int) (j17 + createStepAnimation4.getDuration());
        RotateAnimation createStepAnimation5 = createStepAnimation(10.0f, 167L);
        createStepAnimation5.setStartOffset(duration4);
        animationSet.addAnimation(createStepAnimation5);
        return animationSet;
    }

    private static RotateAnimation createStepAnimation(float f16, long j3) {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, f16, 1, 1.0f, 1, 0.667f);
        if (j3 >= 0) {
            rotateAnimation.setDuration(j3);
        }
        return rotateAnimation;
    }

    private void init() {
        AnimationSet createShakeAnimation = createShakeAnimation();
        this.mAnimationSet = createShakeAnimation;
        createShakeAnimation.setAnimationListener(new a());
        this.mStartRunnable = new Runnable() { // from class: com.tencent.gdtad.views.shake.GdtShakeIconView.2
            @Override // java.lang.Runnable
            public void run() {
                if (GdtShakeIconView.this.mAnimationSet == null) {
                    GdtLog.e(GdtShakeIconView.TAG, "[mStartRunnable] mAnimationSet has been recycled");
                } else {
                    GdtShakeIconView gdtShakeIconView = GdtShakeIconView.this;
                    gdtShakeIconView.startAnimation(gdtShakeIconView.mAnimationSet);
                }
            }
        };
    }

    public void resetImageResource() {
        GdtLog.i(TAG, "[resetImageResource]");
        setImageDrawable(null);
    }

    public void setImageResource() {
        GdtLog.i(TAG, "[setImageResource]");
        try {
            setImageResource(R.drawable.jry);
        } catch (OutOfMemoryError e16) {
            GdtLog.e(TAG, "[setImageResource] error:" + e16);
        }
    }

    public void setOnAnimationListener(WeakReference<OnAnimationListener> weakReference) {
        this.mWeakListener = weakReference;
    }

    public void startAnimation(int i3, int i16) {
        if (i3 >= 0 && i16 >= 0) {
            stop();
            this.mTotalRepeatCount = i3;
            this.mRepeatIntervalMillis = i16;
            AnimationSet animationSet = this.mAnimationSet;
            if (animationSet != null) {
                startAnimation(animationSet);
                return;
            }
            return;
        }
        GdtLog.e(TAG, "[startAnimation] error");
    }

    public void stop() {
        clearAnimation();
        removeCallbacks(this.mStartRunnable);
        AnimationSet animationSet = this.mAnimationSet;
        if (animationSet != null) {
            animationSet.cancel();
            this.mAnimationSet.reset();
        }
        this.mCompleteCount = 0;
    }

    public GdtShakeIconView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
