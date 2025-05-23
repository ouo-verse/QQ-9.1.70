package com.tencent.gamematrix.gmcg.webrtc;

/* compiled from: P */
/* loaded from: classes6.dex */
public class BaseBitrateAdjuster implements BitrateAdjuster {
    protected int targetBitrateBps;
    protected int targetFps;

    @Override // com.tencent.gamematrix.gmcg.webrtc.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return this.targetBitrateBps;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.BitrateAdjuster
    public int getCodecConfigFramerate() {
        return this.targetFps;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.BitrateAdjuster
    public void setTargets(int i3, int i16) {
        this.targetBitrateBps = i3;
        this.targetFps = i16;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.BitrateAdjuster
    public void reportEncodedFrame(int i3) {
    }
}
