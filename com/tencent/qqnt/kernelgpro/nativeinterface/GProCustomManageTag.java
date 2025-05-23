package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProCustomManageTag implements Serializable {
    public int color;
    public long roleId;
    long serialVersionUID = 1;
    public String tagName = "";
    public int wordColor;

    public int getColor() {
        return this.color;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public String getTagName() {
        return this.tagName;
    }

    public int getWordColor() {
        return this.wordColor;
    }

    public String toString() {
        return "GProCustomManageTag{tagName=" + this.tagName + ",color=" + this.color + ",roleId=" + this.roleId + ",wordColor=" + this.wordColor + ",}";
    }
}
