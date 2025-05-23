package org.apache.commons.lang.time;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StopWatch {
    private static final int STATE_RUNNING = 1;
    private static final int STATE_SPLIT = 11;
    private static final int STATE_STOPPED = 2;
    private static final int STATE_SUSPENDED = 3;
    private static final int STATE_UNSPLIT = 10;
    private static final int STATE_UNSTARTED = 0;
    private int runningState = 0;
    private int splitState = 10;
    private long startTime = -1;
    private long stopTime = -1;

    public long getSplitTime() {
        if (this.splitState == 11) {
            return this.stopTime - this.startTime;
        }
        throw new IllegalStateException("Stopwatch must be split to get the split time. ");
    }

    public long getStartTime() {
        if (this.runningState != 0) {
            return this.startTime;
        }
        throw new IllegalStateException("Stopwatch has not been started");
    }

    public long getTime() {
        long j3;
        long j16;
        int i3 = this.runningState;
        if (i3 != 2 && i3 != 3) {
            if (i3 == 0) {
                return 0L;
            }
            if (i3 == 1) {
                j3 = System.currentTimeMillis();
                j16 = this.startTime;
            } else {
                throw new RuntimeException("Illegal running state has occured. ");
            }
        } else {
            j3 = this.stopTime;
            j16 = this.startTime;
        }
        return j3 - j16;
    }

    public void reset() {
        this.runningState = 0;
        this.splitState = 10;
        this.startTime = -1L;
        this.stopTime = -1L;
    }

    public void resume() {
        if (this.runningState == 3) {
            this.startTime += System.currentTimeMillis() - this.stopTime;
            this.stopTime = -1L;
            this.runningState = 1;
            return;
        }
        throw new IllegalStateException("Stopwatch must be suspended to resume. ");
    }

    public void split() {
        if (this.runningState == 1) {
            this.stopTime = System.currentTimeMillis();
            this.splitState = 11;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void start() {
        int i3 = this.runningState;
        if (i3 != 2) {
            if (i3 == 0) {
                this.stopTime = -1L;
                this.startTime = System.currentTimeMillis();
                this.runningState = 1;
                return;
            }
            throw new IllegalStateException("Stopwatch already started. ");
        }
        throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
    }

    public void stop() {
        int i3 = this.runningState;
        if (i3 != 1 && i3 != 3) {
            throw new IllegalStateException("Stopwatch is not running. ");
        }
        if (i3 == 1) {
            this.stopTime = System.currentTimeMillis();
        }
        this.runningState = 2;
    }

    public void suspend() {
        if (this.runningState == 1) {
            this.stopTime = System.currentTimeMillis();
            this.runningState = 3;
            return;
        }
        throw new IllegalStateException("Stopwatch must be running to suspend. ");
    }

    public String toSplitString() {
        return DurationFormatUtils.formatDurationHMS(getSplitTime());
    }

    public String toString() {
        return DurationFormatUtils.formatDurationHMS(getTime());
    }

    public void unsplit() {
        if (this.splitState == 11) {
            this.stopTime = -1L;
            this.splitState = 10;
            return;
        }
        throw new IllegalStateException("Stopwatch has not been split. ");
    }
}
