package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProImageProps implements Serializable {
    public boolean isInline;
    long serialVersionUID = 1;
    public float widthPercent;

    public boolean getIsInline() {
        return this.isInline;
    }

    public float getWidthPercent() {
        return this.widthPercent;
    }

    public String toString() {
        return "GProImageProps{widthPercent=" + this.widthPercent + ",isInline=" + this.isInline + ",}";
    }
}
