package com.tencent.state.square.media;

import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/media/SpeedController;", "", "()V", "ONE_MILLION", "", "fixedFrameDurationUsec", "loopReset", "", "prevMonoUsec", "prevPresentUsec", "preRender", "", "pausedTimeUsec", "presentationTimeUsec", "reset", "setFixedPlaybackRate", "fps", "", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SpeedController {
    private static final String TAG = "Square_SpeedControlUtil";
    private long fixedFrameDurationUsec;
    private long prevMonoUsec;
    private long prevPresentUsec;
    private final long ONE_MILLION = 1000000;
    private boolean loopReset = true;

    public final void preRender(long pausedTimeUsec, long presentationTimeUsec) {
        long j3 = this.prevMonoUsec;
        long j16 = 0;
        if (j3 == 0) {
            this.prevMonoUsec = System.nanoTime() / 1000;
            this.prevPresentUsec = presentationTimeUsec;
            return;
        }
        if (this.loopReset) {
            this.prevPresentUsec = presentationTimeUsec - (this.ONE_MILLION / 30);
            this.loopReset = false;
        }
        long j17 = this.fixedFrameDurationUsec;
        if (j17 == 0) {
            j17 = presentationTimeUsec - this.prevPresentUsec;
        }
        if (j17 >= 0) {
            long j18 = this.ONE_MILLION;
            j16 = j17 > ((long) 10) * j18 ? j18 * 5 : j17;
        }
        long j19 = j3 + pausedTimeUsec;
        this.prevMonoUsec = j19;
        long j26 = j19 + j16;
        long nanoTime = System.nanoTime();
        long j27 = 1000;
        while (true) {
            long j28 = nanoTime / j27;
            if (j28 < j26 - 100) {
                long j29 = j26 - j28;
                if (j29 > 500000) {
                    j29 = 500000;
                }
                try {
                    Thread.sleep(j29 / j27, ((int) (j29 % j27)) * 1000);
                } catch (InterruptedException e16) {
                    SquareBaseKt.getSquareLog().e(TAG, "e=" + e16, e16);
                }
                nanoTime = System.nanoTime();
            } else {
                this.prevMonoUsec += j16;
                this.prevPresentUsec += j16;
                return;
            }
        }
    }

    public final void reset() {
        this.prevPresentUsec = 0L;
        this.prevMonoUsec = 0L;
    }

    public final void setFixedPlaybackRate(int fps) {
        if (fps <= 0) {
            return;
        }
        this.fixedFrameDurationUsec = this.ONE_MILLION / fps;
    }
}
