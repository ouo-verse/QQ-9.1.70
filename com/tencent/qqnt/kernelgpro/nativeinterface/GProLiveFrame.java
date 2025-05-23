package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProLiveFrame implements Serializable {
    public Integer codecType;
    public String definition;
    public Integer level;
    long serialVersionUID = 1;
    public ArrayList<GProPlayAddress> address = new ArrayList<>();

    public ArrayList<GProPlayAddress> getAddress() {
        return this.address;
    }

    public Integer getCodecType() {
        return this.codecType;
    }

    public String getDefinition() {
        return this.definition;
    }

    public Integer getLevel() {
        return this.level;
    }

    public String toString() {
        return "GProLiveFrame{level=" + this.level + ",address=" + this.address + ",definition=" + this.definition + ",codecType=" + this.codecType + ",}";
    }
}
