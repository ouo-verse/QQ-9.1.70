package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRobotStateInfo implements Serializable {
    public long botTrtcId;
    public boolean noLoopInfo;
    public int playState;
    long serialVersionUID = 1;
    public String playText = "";

    public long getBotTrtcId() {
        return this.botTrtcId;
    }

    public boolean getNoLoopInfo() {
        return this.noLoopInfo;
    }

    public int getPlayState() {
        return this.playState;
    }

    public String getPlayText() {
        return this.playText;
    }

    public String toString() {
        return "GProRobotStateInfo{playState=" + this.playState + ",playText=" + this.playText + ",noLoopInfo=" + this.noLoopInfo + ",botTrtcId=" + this.botTrtcId + ",}";
    }
}
