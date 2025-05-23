package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProUserGuideMsg {
    public GProUserGuideBubble bubble;
    public int scene;

    public GProUserGuideMsg() {
        this.bubble = new GProUserGuideBubble();
    }

    public GProUserGuideBubble getBubble() {
        return this.bubble;
    }

    public int getScene() {
        return this.scene;
    }

    public String toString() {
        return "GProUserGuideMsg{scene=" + this.scene + ",bubble=" + this.bubble + ",}";
    }

    public GProUserGuideMsg(int i3, GProUserGuideBubble gProUserGuideBubble) {
        new GProUserGuideBubble();
        this.scene = i3;
        this.bubble = gProUserGuideBubble;
    }
}
