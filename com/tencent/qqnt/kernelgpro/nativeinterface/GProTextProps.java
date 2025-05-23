package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProTextProps implements Serializable {
    public int fontWeight;
    public boolean italic;
    long serialVersionUID = 1;
    public boolean underline;

    public int getFontWeight() {
        return this.fontWeight;
    }

    public boolean getItalic() {
        return this.italic;
    }

    public boolean getUnderline() {
        return this.underline;
    }

    public String toString() {
        return "GProTextProps{fontWeight=" + this.fontWeight + ",italic=" + this.italic + ",underline=" + this.underline + ",}";
    }
}
