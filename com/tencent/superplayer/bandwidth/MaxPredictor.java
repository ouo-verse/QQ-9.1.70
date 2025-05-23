package com.tencent.superplayer.bandwidth;

/* loaded from: classes26.dex */
public class MaxPredictor extends AbstractPredictor {
    @Override // com.tencent.superplayer.bandwidth.AbstractPredictor
    long onSample(long j3) {
        return Math.max(j3, this.currentPredition);
    }
}
