package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendModeInfo implements Serializable {
    public boolean isPK;
    public int modeId;
    public String modeName;
    public int playerNum;
    long serialVersionUID;

    public GProRecommendModeInfo() {
        this.serialVersionUID = 1L;
        this.modeName = "";
    }

    public boolean getIsPK() {
        return this.isPK;
    }

    public int getModeId() {
        return this.modeId;
    }

    public String getModeName() {
        return this.modeName;
    }

    public int getPlayerNum() {
        return this.playerNum;
    }

    public String toString() {
        return "GProRecommendModeInfo{modeId=" + this.modeId + ",modeName=" + this.modeName + ",isPK=" + this.isPK + ",playerNum=" + this.playerNum + ",}";
    }

    public GProRecommendModeInfo(int i3, String str, boolean z16, int i16) {
        this.serialVersionUID = 1L;
        this.modeId = i3;
        this.modeName = str;
        this.isPK = z16;
        this.playerNum = i16;
    }
}
