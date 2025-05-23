package com.nineoldandroids.animation;

/* compiled from: P */
/* loaded from: classes2.dex */
public class TimeAnimator extends ValueAnimator {
    private TimeListener mListener;
    private long mPreviousTime = -1;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface TimeListener {
        void onTimeUpdate(TimeAnimator timeAnimator, long j3, long j16);
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    boolean animationFrame(long j3) {
        long j16 = 0;
        if (this.mPlayingState == 0) {
            this.mPlayingState = 1;
            long j17 = this.mSeekTime;
            if (j17 < 0) {
                this.mStartTime = j3;
            } else {
                this.mStartTime = j3 - j17;
                this.mSeekTime = -1L;
            }
        }
        TimeListener timeListener = this.mListener;
        if (timeListener != null) {
            long j18 = j3 - this.mStartTime;
            long j19 = this.mPreviousTime;
            if (j19 >= 0) {
                j16 = j3 - j19;
            }
            this.mPreviousTime = j3;
            timeListener.onTimeUpdate(this, j18, j16);
            return false;
        }
        return false;
    }

    public void setTimeListener(TimeListener timeListener) {
        this.mListener = timeListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.nineoldandroids.animation.ValueAnimator
    public void initAnimation() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.nineoldandroids.animation.ValueAnimator
    public void animateValue(float f16) {
    }
}
