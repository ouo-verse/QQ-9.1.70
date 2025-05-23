package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
class BaseBitrateAdjuster implements BitrateAdjuster {
    protected int targetBitrateBps;
    protected int targetFps;

    @Override // org.tencwebrtc.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return this.targetBitrateBps;
    }

    @Override // org.tencwebrtc.BitrateAdjuster
    public int getCodecConfigFramerate() {
        return this.targetFps;
    }

    @Override // org.tencwebrtc.BitrateAdjuster
    public void setTargets(int i3, int i16) {
        this.targetBitrateBps = i3;
        this.targetFps = i16;
    }

    @Override // org.tencwebrtc.BitrateAdjuster
    public void reportEncodedFrame(int i3) {
    }
}
