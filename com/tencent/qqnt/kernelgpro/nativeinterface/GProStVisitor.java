package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStVisitor implements Serializable {
    public int recomCount;
    public int viewCount;
    long serialVersionUID = 1;
    public byte[] busiData = new byte[0];
    public String viewDesc = "";

    public byte[] getBusiData() {
        return this.busiData;
    }

    public int getRecomCount() {
        return this.recomCount;
    }

    public int getViewCount() {
        return this.viewCount;
    }

    public String getViewDesc() {
        return this.viewDesc;
    }

    public String toString() {
        return "GProStVisitor{viewCount=" + this.viewCount + ",busiData=" + this.busiData + ",recomCount=" + this.recomCount + ",viewDesc=" + this.viewDesc + ",}";
    }
}
