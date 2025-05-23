package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class EdgeEffect {
    static IPatchRedirector $redirector_ = null;
    private static final float EPSILON = 0.001f;
    private static final float HELD_EDGE_ALPHA = 0.7f;
    private static final float HELD_EDGE_SCALE_Y = 0.5f;
    private static final float HELD_GLOW_ALPHA = 0.5f;
    private static final float HELD_GLOW_SCALE_Y = 0.5f;
    private static final float MAX_ALPHA = 0.8f;
    private static final float MAX_GLOW_HEIGHT = 4.0f;
    private static final int MIN_VELOCITY = 100;
    private static final int MIN_WIDTH = 300;
    private static final int PULL_DECAY_TIME = 1000;
    private static final float PULL_DISTANCE_ALPHA_GLOW_FACTOR = 1.1f;
    private static final int PULL_DISTANCE_EDGE_FACTOR = 7;
    private static final int PULL_DISTANCE_GLOW_FACTOR = 7;
    private static final float PULL_EDGE_BEGIN = 0.6f;
    private static final float PULL_GLOW_BEGIN = 1.0f;
    private static final int PULL_TIME = 167;
    private static final int RECEDE_TIME = 1000;
    private static final int STATE_ABSORB = 2;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PULL = 1;
    private static final int STATE_PULL_DECAY = 4;
    private static final int STATE_RECEDE = 3;
    private static final String TAG = "EdgeEffect";
    private static final int VELOCITY_EDGE_FACTOR = 8;
    private static final int VELOCITY_GLOW_FACTOR = 16;
    private float mDuration;
    private Drawable mEdge;
    private float mEdgeAlpha;
    private float mEdgeAlphaFinish;
    private float mEdgeAlphaStart;
    private float mEdgeScaleY;
    private float mEdgeScaleYFinish;
    private float mEdgeScaleYStart;
    private Drawable mGlow;
    private float mGlowAlpha;
    private float mGlowAlphaFinish;
    private float mGlowAlphaStart;
    private float mGlowScaleY;
    private float mGlowScaleYFinish;
    private float mGlowScaleYStart;
    private int mHeight;
    private final Interpolator mInterpolator;
    private final int mMinWidth;
    private float mPullDistance;
    private long mStartTime;
    private int mState;
    private int mWidth;

    public EdgeEffect(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mState = 0;
        Resources resources = context.getResources();
        this.mEdge = resources.getDrawable(R.drawable.d3q);
        this.mGlow = resources.getDrawable(R.drawable.d3r);
        this.mMinWidth = (int) ((resources.getDisplayMetrics().density * 300.0f) + 0.5f);
        this.mInterpolator = new DecelerateInterpolator();
    }

    private void update() {
        float f16;
        float min = Math.min(((float) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime)) / this.mDuration, 1.0f);
        float interpolation = this.mInterpolator.getInterpolation(min);
        float f17 = this.mEdgeAlphaStart;
        this.mEdgeAlpha = f17 + ((this.mEdgeAlphaFinish - f17) * interpolation);
        float f18 = this.mEdgeScaleYStart;
        float f19 = this.mEdgeScaleYFinish;
        this.mEdgeScaleY = ((f19 - f18) * interpolation) + f18;
        float f26 = this.mGlowAlphaStart;
        this.mGlowAlpha = f26 + ((this.mGlowAlphaFinish - f26) * interpolation);
        float f27 = this.mGlowScaleYStart;
        float f28 = this.mGlowScaleYFinish;
        this.mGlowScaleY = f27 + ((f28 - f27) * interpolation);
        if (min >= 0.999f) {
            int i3 = this.mState;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            if (f28 != 0.0f) {
                                f16 = 1.0f / (f28 * f28);
                            } else {
                                f16 = Float.MAX_VALUE;
                            }
                            this.mEdgeScaleY = f18 + ((f19 - f18) * interpolation * f16);
                            this.mState = 3;
                            return;
                        }
                        return;
                    }
                    this.mState = 0;
                    return;
                }
                this.mState = 3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                this.mDuration = 1000.0f;
                this.mEdgeAlphaStart = this.mEdgeAlpha;
                this.mEdgeScaleYStart = this.mEdgeScaleY;
                this.mGlowAlphaStart = this.mGlowAlpha;
                this.mGlowScaleYStart = this.mGlowScaleY;
                this.mEdgeAlphaFinish = 0.0f;
                this.mEdgeScaleYFinish = 0.0f;
                this.mGlowAlphaFinish = 0.0f;
                this.mGlowScaleYFinish = 0.0f;
                return;
            }
            this.mState = 4;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 1000.0f;
            this.mEdgeAlphaStart = this.mEdgeAlpha;
            this.mEdgeScaleYStart = this.mEdgeScaleY;
            this.mGlowAlphaStart = this.mGlowAlpha;
            this.mGlowScaleYStart = this.mGlowScaleY;
            this.mEdgeAlphaFinish = 0.0f;
            this.mEdgeScaleYFinish = 0.0f;
            this.mGlowAlphaFinish = 0.0f;
            this.mGlowScaleYFinish = 0.0f;
        }
    }

    public boolean draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas)).booleanValue();
        }
        update();
        int intrinsicHeight = this.mEdge.getIntrinsicHeight();
        this.mEdge.getIntrinsicWidth();
        int intrinsicHeight2 = this.mGlow.getIntrinsicHeight();
        int intrinsicWidth = this.mGlow.getIntrinsicWidth();
        this.mGlow.setAlpha((int) (Math.max(0.0f, Math.min(this.mGlowAlpha, 1.0f)) * 255.0f));
        float f16 = intrinsicHeight2;
        int min = (int) Math.min((((this.mGlowScaleY * f16) * f16) / intrinsicWidth) * PULL_EDGE_BEGIN, f16 * 4.0f);
        int i3 = this.mWidth;
        int i16 = this.mMinWidth;
        if (i3 < i16) {
            int i17 = (i3 - i16) / 2;
            this.mGlow.setBounds(i17, 0, i3 - i17, min);
        } else {
            this.mGlow.setBounds(0, 0, i3, min);
        }
        this.mGlow.draw(canvas);
        this.mEdge.setAlpha((int) (Math.max(0.0f, Math.min(this.mEdgeAlpha, 1.0f)) * 255.0f));
        int i18 = (int) (intrinsicHeight * this.mEdgeScaleY);
        int i19 = this.mWidth;
        int i26 = this.mMinWidth;
        if (i19 < i26) {
            int i27 = (i19 - i26) / 2;
            this.mEdge.setBounds(i27, 0, i19 - i27, i18);
        } else {
            this.mEdge.setBounds(0, 0, i19, i18);
        }
        this.mEdge.draw(canvas);
        if (this.mState == 0) {
            return false;
        }
        return true;
    }

    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mState = 0;
        }
    }

    public boolean isFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.mState == 0) {
            return true;
        }
        return false;
    }

    public void onAbsorb(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        this.mState = 2;
        int max = Math.max(100, Math.abs(i3));
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mDuration = (max * 0.03f) + 0.1f;
        this.mEdgeAlphaStart = 0.0f;
        this.mEdgeScaleYStart = 0.0f;
        this.mEdgeScaleY = 0.0f;
        this.mGlowAlphaStart = 0.5f;
        this.mGlowScaleYStart = 0.0f;
        this.mEdgeAlphaFinish = Math.max(0, Math.min(r0, 1));
        this.mEdgeScaleYFinish = Math.max(0.5f, Math.min(max * 8, 1.0f));
        this.mGlowScaleYFinish = Math.min(((max / 100) * max * 1.5E-4f) + 0.025f, 1.75f);
        this.mGlowAlphaFinish = Math.max(this.mGlowAlphaStart, Math.min(max * 16 * 1.0E-5f, 0.8f));
    }

    public void onPull(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i3 = this.mState;
        if (i3 == 4 && ((float) (currentAnimationTimeMillis - this.mStartTime)) < this.mDuration) {
            return;
        }
        if (i3 != 1) {
            this.mGlowScaleY = 1.0f;
        }
        this.mState = 1;
        this.mStartTime = currentAnimationTimeMillis;
        this.mDuration = 167.0f;
        float f17 = this.mPullDistance + f16;
        this.mPullDistance = f17;
        float abs = Math.abs(f17);
        float max = Math.max(PULL_EDGE_BEGIN, Math.min(abs, 0.8f));
        this.mEdgeAlphaStart = max;
        this.mEdgeAlpha = max;
        float max2 = Math.max(0.5f, Math.min(abs * 7.0f, 1.0f));
        this.mEdgeScaleYStart = max2;
        this.mEdgeScaleY = max2;
        float min = Math.min(0.8f, this.mGlowAlpha + (Math.abs(f16) * 1.1f));
        this.mGlowAlphaStart = min;
        this.mGlowAlpha = min;
        float abs2 = Math.abs(f16);
        if (f16 > 0.0f && this.mPullDistance < 0.0f) {
            abs2 = -abs2;
        }
        if (this.mPullDistance == 0.0f) {
            this.mGlowScaleY = 0.0f;
        }
        float min2 = Math.min(4.0f, Math.max(0.0f, this.mGlowScaleY + (abs2 * 7.0f)));
        this.mGlowScaleYStart = min2;
        this.mGlowScaleY = min2;
        this.mEdgeAlphaFinish = this.mEdgeAlpha;
        this.mEdgeScaleYFinish = this.mEdgeScaleY;
        this.mGlowAlphaFinish = this.mGlowAlpha;
        this.mGlowScaleYFinish = min2;
    }

    public void onRelease() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.mPullDistance = 0.0f;
        int i3 = this.mState;
        if (i3 != 1 && i3 != 4) {
            return;
        }
        this.mState = 3;
        this.mEdgeAlphaStart = this.mEdgeAlpha;
        this.mEdgeScaleYStart = this.mEdgeScaleY;
        this.mGlowAlphaStart = this.mGlowAlpha;
        this.mGlowScaleYStart = this.mGlowScaleY;
        this.mEdgeAlphaFinish = 0.0f;
        this.mEdgeScaleYFinish = 0.0f;
        this.mGlowAlphaFinish = 0.0f;
        this.mGlowScaleYFinish = 0.0f;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mDuration = 1000.0f;
    }

    public void setEdgeDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
        } else {
            this.mEdge = drawable;
            this.mGlow = drawable;
        }
    }

    public void setSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mWidth = i3;
            this.mHeight = i16;
        }
    }
}
