package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProTotalLike implements Serializable {
    public boolean isClicked;
    public int likeCount;
    long serialVersionUID = 1;

    public boolean getIsClicked() {
        return this.isClicked;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public String toString() {
        return "GProTotalLike{likeCount=" + this.likeCount + ",isClicked=" + this.isClicked + ",}";
    }
}
