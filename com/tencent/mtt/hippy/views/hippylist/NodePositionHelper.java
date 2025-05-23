package com.tencent.mtt.hippy.views.hippylist;

/* loaded from: classes20.dex */
public class NodePositionHelper {
    private int nodeOffset = 0;

    public void decreaseOffset() {
        this.nodeOffset--;
    }

    public int getNodeOffset() {
        return this.nodeOffset;
    }

    public int getRenderNodePosition(int i3) {
        return i3 - this.nodeOffset;
    }

    public void increaseOffset() {
        this.nodeOffset++;
    }
}
