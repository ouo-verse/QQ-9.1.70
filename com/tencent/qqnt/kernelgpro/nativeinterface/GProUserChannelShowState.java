package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProUserChannelShowState implements Serializable {
    long serialVersionUID = 1;
    public String stateIcon = "";
    public String stateInfo = "";

    public String getStateIcon() {
        return this.stateIcon;
    }

    public String getStateInfo() {
        return this.stateInfo;
    }

    public String toString() {
        return "GProUserChannelShowState{stateIcon=" + this.stateIcon + ",stateInfo=" + this.stateInfo + ",}";
    }
}
