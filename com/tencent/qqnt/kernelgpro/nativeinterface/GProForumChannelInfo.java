package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProForumChannelInfo implements Serializable {
    public int hotIndex;
    public int postSortMode;
    long serialVersionUID = 1;
    public String hotIcon = "";

    public String getHotIcon() {
        return this.hotIcon;
    }

    public int getHotIndex() {
        return this.hotIndex;
    }

    public int getPostSortMode() {
        return this.postSortMode;
    }

    public String toString() {
        return "GProForumChannelInfo{postSortMode=" + this.postSortMode + ",hotIndex=" + this.hotIndex + ",hotIcon=" + this.hotIcon + ",}";
    }
}
