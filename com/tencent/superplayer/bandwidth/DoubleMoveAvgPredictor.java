package com.tencent.superplayer.bandwidth;

/* loaded from: classes26.dex */
public class DoubleMoveAvgPredictor extends AbstractPredictor {
    private final MoveAvgPredictor firstMoveAvg;
    private final int maxSize;
    private final MoveAvgPredictor secondMoveAvg;

    public DoubleMoveAvgPredictor(int i3) {
        this.maxSize = i3;
        this.firstMoveAvg = new MoveAvgPredictor(i3);
        this.secondMoveAvg = new MoveAvgPredictor(i3);
    }

    @Override // com.tencent.superplayer.bandwidth.AbstractPredictor
    public void onIdle() {
        super.onIdle();
        this.firstMoveAvg.onIdle();
        this.secondMoveAvg.onIdle();
    }

    @Override // com.tencent.superplayer.bandwidth.AbstractPredictor
    public long onSample(long j3) {
        this.firstMoveAvg.sample(j3);
        long j16 = this.firstMoveAvg.currentPredition;
        this.secondMoveAvg.sample(j16);
        long j17 = (2 * j16) - this.secondMoveAvg.currentPredition;
        return ((float) j17) + ((2.0f / (Math.max(this.firstMoveAvg.getSampleSize(), 2) - 1)) * ((float) (j16 - r0)));
    }

    @Override // com.tencent.superplayer.bandwidth.AbstractPredictor
    public void reset() {
        super.reset();
        this.firstMoveAvg.reset();
        this.secondMoveAvg.reset();
    }

    public String toString() {
        return "DoubleMoveAvgPredictor(" + this.maxSize + ')';
    }
}
