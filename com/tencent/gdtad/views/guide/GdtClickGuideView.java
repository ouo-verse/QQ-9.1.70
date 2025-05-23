package com.tencent.gdtad.views.guide;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtClickGuideView extends FrameLayout {
    private static final float BASE_CONTAINER_LENGHT = 400.0f;
    private static final float BASE_ICON_LENGTH = 160.0f;
    private static final float BASE_ICON_X_FROM = 192.0f;
    private static final float BASE_ICON_X_TO = 162.0f;
    private static final float BASE_ICON_Y_FROM = 192.0f;
    private static final float BASE_ICON_Y_TO = 162.0f;
    private static final String TAG = "GdtGuideView";
    private Runnable animationRunnable;
    private Runnable backgroundRippleAnimationRunnable;
    private ImageView backgroundRippleImageView;
    private Runnable foregroundRippleAnimationRunnable;
    private ImageView foregroundRippleImageView;
    private ImageView iconImageView;
    private Runnable iconTranslateAnimationRunnable;
    private boolean initialized;
    private boolean isIconAlphaAnimationDisplayed;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class RippleAnimationRunnable implements Runnable {
        private long durationMillis;
        private View view;

        RippleAnimationRunnable(View view, long j3) {
            this.view = view;
            this.durationMillis = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.view;
            if (view == null) {
                GdtLog.e(GdtClickGuideView.TAG, "[RippleAnimationRunnable] error, view is null");
                return;
            }
            view.setVisibility(0);
            GdtClickGuideView.startRippleScaleAnimation(this.view, this.durationMillis);
            GdtClickGuideView.startRippleAlphaAnimation(this.view, this.durationMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f109623d;

        a(View view) {
            this.f109623d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator != null) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Float) {
                    float floatValue = ((Float) Float.class.cast(animatedValue)).floatValue();
                    View view = this.f109623d;
                    if (view != null) {
                        view.setAlpha(floatValue);
                        return;
                    }
                }
            }
            GdtLog.e(GdtClickGuideView.TAG, "[startIconAlphaAnimation] error");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f109625d;

        b(View view) {
            this.f109625d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator != null) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Float) {
                    this.f109625d.setAlpha(((Float) Float.class.cast(animatedValue)).floatValue());
                    return;
                }
            }
            GdtLog.e(GdtClickGuideView.TAG, "[startRippleAlphaAnimation] error");
        }
    }

    public GdtClickGuideView(Context context) {
        super(context);
        this.initialized = false;
        this.isIconAlphaAnimationDisplayed = false;
        init();
    }

    private void init() {
        ImageView imageView = new ImageView(getContext());
        this.backgroundRippleImageView = imageView;
        imageView.setImageResource(R.drawable.jrn);
        this.backgroundRippleImageView.setVisibility(8);
        addView(this.backgroundRippleImageView, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView2 = new ImageView(getContext());
        this.foregroundRippleImageView = imageView2;
        imageView2.setImageResource(R.drawable.jrn);
        this.foregroundRippleImageView.setVisibility(8);
        addView(this.foregroundRippleImageView, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView3 = new ImageView(getContext());
        this.iconImageView = imageView3;
        imageView3.setImageResource(R.drawable.jrm);
        this.iconImageView.setVisibility(8);
        addView(this.iconImageView);
    }

    private boolean resetLayoutParams(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            float f16 = i3;
            int round = Math.round(0.4f * f16);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(round, round);
            float f17 = f16 * 0.48f;
            layoutParams.leftMargin = Math.round(f17);
            layoutParams.topMargin = Math.round(f17);
            this.iconImageView.setLayoutParams(layoutParams);
            GdtLog.i(TAG, String.format("[resetIconLayoutParams] containerWidth:%d containerHeight:%d iconLength:%d left:%d top:%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(round), Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin)));
            return true;
        }
        GdtLog.e(TAG, "[resetLayoutParams] error");
        return false;
    }

    private void startIconAlphaAnimation(View view, long j3) {
        if (view == null) {
            GdtLog.e(TAG, "[startIconAlphaAnimation] error, view is null");
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(j3);
        ofFloat.addUpdateListener(new a(view));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startIconTranslateAnimation(View view, long j3) {
        if (view == null) {
            GdtLog.e(TAG, "[startIconTranslateAnimation] error, view is null");
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -0.1875f, 1, 0.0f, 1, -0.1875f);
        translateAnimation.setDuration(j3);
        translateAnimation.setRepeatMode(2);
        translateAnimation.setRepeatCount(3);
        view.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startRippleAlphaAnimation(View view, long j3) {
        if (view == null) {
            GdtLog.e(TAG, "[startRippleAlphaAnimation] error, view is null");
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(j3);
        ofFloat.addUpdateListener(new b(view));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startRippleScaleAnimation(View view, long j3) {
        if (view == null) {
            GdtLog.e(TAG, "[startRippleScaleAnimation] error, view is null");
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(j3);
        scaleAnimation.setFillAfter(true);
        view.startAnimation(scaleAnimation);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        GdtLog.i(TAG, "[onLayout] width:" + getWidth() + " height:" + getHeight());
        if (!this.initialized) {
            this.initialized = resetLayoutParams(getWidth(), getHeight());
        }
    }

    public void start() {
        long j3;
        stop();
        GdtLog.i(TAG, "[start]");
        this.iconImageView.setVisibility(0);
        if (!this.isIconAlphaAnimationDisplayed) {
            this.isIconAlphaAnimationDisplayed = true;
            GdtLog.i(TAG, "[start] iconAlphaAnimation");
            j3 = 280;
            startIconAlphaAnimation(this.iconImageView, 280L);
        } else {
            j3 = 0;
        }
        if (this.iconTranslateAnimationRunnable == null) {
            this.iconTranslateAnimationRunnable = new Runnable() { // from class: com.tencent.gdtad.views.guide.GdtClickGuideView.1
                @Override // java.lang.Runnable
                public void run() {
                    GdtClickGuideView.startIconTranslateAnimation(GdtClickGuideView.this.iconImageView, 200L);
                }
            };
        }
        long j16 = j3 + 720;
        postDelayed(this.iconTranslateAnimationRunnable, j16);
        long j17 = 200 + j16;
        long j18 = j16 + 600;
        if (this.backgroundRippleAnimationRunnable == null) {
            this.backgroundRippleAnimationRunnable = new RippleAnimationRunnable(this.backgroundRippleImageView, 1200L);
        }
        postDelayed(this.backgroundRippleAnimationRunnable, j17);
        if (this.foregroundRippleAnimationRunnable == null) {
            this.foregroundRippleAnimationRunnable = new RippleAnimationRunnable(this.foregroundRippleImageView, 1200L);
        }
        postDelayed(this.foregroundRippleAnimationRunnable, j18);
        Runnable runnable = new Runnable() { // from class: com.tencent.gdtad.views.guide.GdtClickGuideView.2
            @Override // java.lang.Runnable
            public void run() {
                GdtClickGuideView.this.start();
            }
        };
        this.animationRunnable = runnable;
        postDelayed(runnable, j18 + 1200);
    }

    public void stop() {
        GdtLog.i(TAG, "[stop]");
        this.iconImageView.setVisibility(8);
        this.iconImageView.clearAnimation();
        removeCallbacks(this.iconTranslateAnimationRunnable);
        this.foregroundRippleImageView.setVisibility(8);
        this.foregroundRippleImageView.clearAnimation();
        removeCallbacks(this.foregroundRippleAnimationRunnable);
        this.backgroundRippleImageView.setVisibility(8);
        this.backgroundRippleImageView.clearAnimation();
        removeCallbacks(this.backgroundRippleAnimationRunnable);
        removeCallbacks(this.animationRunnable);
    }

    public GdtClickGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.initialized = false;
        this.isIconAlphaAnimationDisplayed = false;
        init();
    }

    public GdtClickGuideView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.initialized = false;
        this.isIconAlphaAnimationDisplayed = false;
        init();
    }

    public GdtClickGuideView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.initialized = false;
        this.isIconAlphaAnimationDisplayed = false;
        init();
    }
}
