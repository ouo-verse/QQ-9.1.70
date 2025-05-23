package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PullSysEmojisRsp {
    public BasePanelResult normalPanelResult = new BasePanelResult();
    public BasePanelResult superPanelResult = new BasePanelResult();
    public BasePanelResult redHeartPanelResult = new BasePanelResult();
    public BasePanelResult otherPanelResult = new BasePanelResult();

    public BasePanelResult getNormalPanelResult() {
        return this.normalPanelResult;
    }

    public BasePanelResult getOtherPanelResult() {
        return this.otherPanelResult;
    }

    public BasePanelResult getRedHeartPanelResult() {
        return this.redHeartPanelResult;
    }

    public BasePanelResult getSuperPanelResult() {
        return this.superPanelResult;
    }

    public String toString() {
        return "PullSysEmojisRsp{normalPanelResult=" + this.normalPanelResult + ",superPanelResult=" + this.superPanelResult + ",redHeartPanelResult=" + this.redHeartPanelResult + ",otherPanelResult=" + this.otherPanelResult + ",}";
    }
}
