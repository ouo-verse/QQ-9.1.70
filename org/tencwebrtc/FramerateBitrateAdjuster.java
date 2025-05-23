package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
class FramerateBitrateAdjuster extends BaseBitrateAdjuster {
    private static final int INITIAL_FPS = 30;

    @Override // org.tencwebrtc.BaseBitrateAdjuster, org.tencwebrtc.BitrateAdjuster
    public int getCodecConfigFramerate() {
        return 30;
    }

    @Override // org.tencwebrtc.BaseBitrateAdjuster, org.tencwebrtc.BitrateAdjuster
    public void setTargets(int i3, int i16) {
        if (this.targetFps == 0) {
            i16 = 30;
        }
        super.setTargets(i3, i16);
        this.targetBitrateBps = (this.targetBitrateBps * 30) / this.targetFps;
    }
}
