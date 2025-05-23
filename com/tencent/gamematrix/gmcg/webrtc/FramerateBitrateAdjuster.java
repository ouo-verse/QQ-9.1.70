package com.tencent.gamematrix.gmcg.webrtc;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FramerateBitrateAdjuster extends BaseBitrateAdjuster {
    private static final int INITIAL_FPS = 30;

    @Override // com.tencent.gamematrix.gmcg.webrtc.BaseBitrateAdjuster, com.tencent.gamematrix.gmcg.webrtc.BitrateAdjuster
    public int getCodecConfigFramerate() {
        return 30;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.BaseBitrateAdjuster, com.tencent.gamematrix.gmcg.webrtc.BitrateAdjuster
    public void setTargets(int i3, int i16) {
        if (this.targetFps == 0) {
            i16 = 30;
        }
        super.setTargets(i3, i16);
        this.targetBitrateBps = (this.targetBitrateBps * 30) / this.targetFps;
    }
}
