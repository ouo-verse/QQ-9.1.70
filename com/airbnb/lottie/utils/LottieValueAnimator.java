package com.airbnb.lottie.utils;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.tencent.mapsdk.internal.by;

/* compiled from: P */
/* loaded from: classes.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {

    @Nullable
    private LottieComposition composition;
    private float speed = 1.0f;
    private boolean speedReversedForRepeatMode = false;
    private long lastFrameTimeNs = 0;
    private float frame = 0.0f;
    private int repeatCount = 0;
    private float minFrame = -2.14748365E9f;
    private float maxFrame = 2.14748365E9f;

    @VisibleForTesting
    protected boolean running = false;

    private float getFrameDurationNs() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.getFrameRate()) / Math.abs(this.speed);
    }

    private boolean isReversed() {
        if (getSpeed() < 0.0f) {
            return true;
        }
        return false;
    }

    private void verifyFrame() {
        if (this.composition == null) {
            return;
        }
        float f16 = this.frame;
        if (f16 >= this.minFrame && f16 <= this.maxFrame) {
        } else {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame)));
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        notifyCancel();
        removeFrameCallback();
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2.14748365E9f;
        this.maxFrame = 2.14748365E9f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j3) {
        float minFrame;
        float maxFrame;
        postFrameCallback();
        if (this.composition != null && isRunning()) {
            L.beginSection("LottieValueAnimator#doFrame");
            long j16 = this.lastFrameTimeNs;
            long j17 = 0;
            if (j16 != 0) {
                j17 = j3 - j16;
            }
            float frameDurationNs = ((float) j17) / getFrameDurationNs();
            float f16 = this.frame;
            if (isReversed()) {
                frameDurationNs = -frameDurationNs;
            }
            float f17 = f16 + frameDurationNs;
            this.frame = f17;
            boolean z16 = !MiscUtils.contains(f17, getMinFrame(), getMaxFrame());
            this.frame = MiscUtils.clamp(this.frame, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = j3;
            notifyUpdate();
            if (z16) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    if (this.speed < 0.0f) {
                        maxFrame = getMinFrame();
                    } else {
                        maxFrame = getMaxFrame();
                    }
                    this.frame = maxFrame;
                    removeFrameCallback();
                    notifyEnd(isReversed());
                } else {
                    notifyRepeat();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
                        reverseAnimationSpeed();
                    } else {
                        if (isReversed()) {
                            minFrame = getMaxFrame();
                        } else {
                            minFrame = getMinFrame();
                        }
                        this.frame = minFrame;
                    }
                    this.lastFrameTimeNs = j3;
                }
            }
            verifyFrame();
            L.endSection("LottieValueAnimator#doFrame");
        }
    }

    @MainThread
    public void endAnimation() {
        removeFrameCallback();
        notifyEnd(isReversed());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = by.f147964a)
    public float getAnimatedFraction() {
        float minFrame;
        float maxFrame;
        float minFrame2;
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            minFrame = getMaxFrame() - this.frame;
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        } else {
            minFrame = this.frame - getMinFrame();
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        }
        return minFrame / (maxFrame - minFrame2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float getAnimatedValueAbsolute() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.frame - lottieComposition.getStartFrame()) / (this.composition.getEndFrame() - this.composition.getStartFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return r0.getDuration();
    }

    public float getFrame() {
        return this.frame;
    }

    public float getMaxFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f16 = this.maxFrame;
        if (f16 == 2.14748365E9f) {
            return lottieComposition.getEndFrame();
        }
        return f16;
    }

    public float getMinFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f16 = this.minFrame;
        if (f16 == -2.14748365E9f) {
            return lottieComposition.getStartFrame();
        }
        return f16;
    }

    public float getSpeed() {
        return this.speed;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.running;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.utils.BaseLottieAnimator
    public void notifyCancel() {
        super.notifyCancel();
        notifyEnd(isReversed());
    }

    @MainThread
    public void pauseAnimation() {
        removeFrameCallback();
    }

    @MainThread
    public void playAnimation() {
        float minFrame;
        this.running = true;
        notifyStart(isReversed());
        if (isReversed()) {
            minFrame = getMaxFrame();
        } else {
            minFrame = getMinFrame();
        }
        setFrame((int) minFrame);
        this.lastFrameTimeNs = 0L;
        this.repeatCount = 0;
        postFrameCallback();
    }

    protected void postFrameCallback() {
        if (isRunning()) {
            removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void removeFrameCallback() {
        removeFrameCallback(true);
    }

    @MainThread
    public void resumeAnimation() {
        this.running = true;
        postFrameCallback();
        this.lastFrameTimeNs = 0L;
        if (isReversed() && getFrame() == getMinFrame()) {
            this.frame = getMaxFrame();
        } else if (!isReversed() && getFrame() == getMaxFrame()) {
            this.frame = getMinFrame();
        }
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setComposition(LottieComposition lottieComposition) {
        boolean z16;
        if (this.composition == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.composition = lottieComposition;
        if (z16) {
            setMinAndMaxFrames(Math.max(this.minFrame, lottieComposition.getStartFrame()), Math.min(this.maxFrame, lottieComposition.getEndFrame()));
        } else {
            setMinAndMaxFrames((int) lottieComposition.getStartFrame(), (int) lottieComposition.getEndFrame());
        }
        float f16 = this.frame;
        this.frame = 0.0f;
        setFrame((int) f16);
        notifyUpdate();
    }

    public void setFrame(float f16) {
        if (this.frame == f16) {
            return;
        }
        this.frame = MiscUtils.clamp(f16, getMinFrame(), getMaxFrame());
        this.lastFrameTimeNs = 0L;
        notifyUpdate();
    }

    public void setMaxFrame(float f16) {
        setMinAndMaxFrames(this.minFrame, f16);
    }

    public void setMinAndMaxFrames(float f16, float f17) {
        float startFrame;
        float endFrame;
        if (f16 <= f17) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                startFrame = -3.4028235E38f;
            } else {
                startFrame = lottieComposition.getStartFrame();
            }
            LottieComposition lottieComposition2 = this.composition;
            if (lottieComposition2 == null) {
                endFrame = Float.MAX_VALUE;
            } else {
                endFrame = lottieComposition2.getEndFrame();
            }
            float clamp = MiscUtils.clamp(f16, startFrame, endFrame);
            float clamp2 = MiscUtils.clamp(f17, startFrame, endFrame);
            if (clamp != this.minFrame || clamp2 != this.maxFrame) {
                this.minFrame = clamp;
                this.maxFrame = clamp2;
                setFrame((int) MiscUtils.clamp(this.frame, clamp, clamp2));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f16), Float.valueOf(f17)));
    }

    public void setMinFrame(int i3) {
        setMinAndMaxFrames(i3, (int) this.maxFrame);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i3) {
        super.setRepeatMode(i3);
        if (i3 != 2 && this.speedReversedForRepeatMode) {
            this.speedReversedForRepeatMode = false;
            reverseAnimationSpeed();
        }
    }

    public void setSpeed(float f16) {
        this.speed = f16;
    }

    @MainThread
    protected void removeFrameCallback(boolean z16) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z16) {
            this.running = false;
        }
    }
}
