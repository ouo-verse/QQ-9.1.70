package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGray implements Serializable {
    public int movePostSection;
    long serialVersionUID = 1;

    public int getMovePostSection() {
        return this.movePostSection;
    }

    public void setMovePostSection(int i3) {
        this.movePostSection = i3;
    }

    public String toString() {
        return "GProGray{movePostSection=" + this.movePostSection + ",}";
    }
}
