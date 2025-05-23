package com.tencent.gamematrix.gmcg.webrtc;

/* compiled from: P */
/* loaded from: classes6.dex */
public class DynamicBitrateAdjuster extends BaseBitrateAdjuster {
    private static final double BITRATE_ADJUSTMENT_MAX_SCALE = 4.0d;
    private static final double BITRATE_ADJUSTMENT_SEC = 3.0d;
    private static final int BITRATE_ADJUSTMENT_STEPS = 20;
    private static final double BITS_PER_BYTE = 8.0d;
    private int bitrateAdjustmentScaleExp;
    private double deviationBytes;
    private double timeSinceLastAdjustmentMs;

    private double getBitrateAdjustmentScale() {
        return Math.pow(BITRATE_ADJUSTMENT_MAX_SCALE, this.bitrateAdjustmentScaleExp / 20.0d);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.BaseBitrateAdjuster, com.tencent.gamematrix.gmcg.webrtc.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return (int) (this.targetBitrateBps * getBitrateAdjustmentScale());
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.BaseBitrateAdjuster, com.tencent.gamematrix.gmcg.webrtc.BitrateAdjuster
    public void reportEncodedFrame(int i3) {
        int i16 = this.targetFps;
        if (i16 == 0) {
            return;
        }
        int i17 = this.targetBitrateBps;
        double d16 = this.deviationBytes + (i3 - ((i17 / BITS_PER_BYTE) / i16));
        this.deviationBytes = d16;
        this.timeSinceLastAdjustmentMs += 1000.0d / i16;
        double d17 = i17 / BITS_PER_BYTE;
        double d18 = 3.0d * d17;
        double min = Math.min(d16, d18);
        this.deviationBytes = min;
        double max = Math.max(min, -d18);
        this.deviationBytes = max;
        if (this.timeSinceLastAdjustmentMs <= 3000.0d) {
            return;
        }
        if (max > d17) {
            int i18 = this.bitrateAdjustmentScaleExp - ((int) ((max / d17) + 0.5d));
            this.bitrateAdjustmentScaleExp = i18;
            this.bitrateAdjustmentScaleExp = Math.max(i18, -20);
            this.deviationBytes = d17;
        } else {
            double d19 = -d17;
            if (max < d19) {
                int i19 = this.bitrateAdjustmentScaleExp + ((int) (((-max) / d17) + 0.5d));
                this.bitrateAdjustmentScaleExp = i19;
                this.bitrateAdjustmentScaleExp = Math.min(i19, 20);
                this.deviationBytes = d19;
            }
        }
        this.timeSinceLastAdjustmentMs = 0.0d;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.BaseBitrateAdjuster, com.tencent.gamematrix.gmcg.webrtc.BitrateAdjuster
    public void setTargets(int i3, int i16) {
        int i17 = this.targetBitrateBps;
        if (i17 > 0 && i3 < i17) {
            this.deviationBytes = (this.deviationBytes * i3) / i17;
        }
        super.setTargets(i3, i16);
    }
}
