package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProChannelTopInfo implements Serializable {
    public boolean isTop;
    long serialVersionUID = 1;

    public boolean getIsTop() {
        return this.isTop;
    }

    public String toString() {
        return "GProChannelTopInfo{isTop=" + this.isTop + ",}";
    }
}
