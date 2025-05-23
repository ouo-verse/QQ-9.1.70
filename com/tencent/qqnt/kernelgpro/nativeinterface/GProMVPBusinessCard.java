package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPBusinessCard implements Serializable {
    public boolean hasCard;
    long serialVersionUID = 1;

    public boolean getHasCard() {
        return this.hasCard;
    }

    public String toString() {
        return "GProMVPBusinessCard{hasCard=" + this.hasCard + ",}";
    }
}
