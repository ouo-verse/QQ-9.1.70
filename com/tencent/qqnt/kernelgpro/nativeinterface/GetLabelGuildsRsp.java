package com.tencent.qqnt.kernelgpro.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetLabelGuildsRsp {
    public GProLabelInfo labelInfo;

    public GetLabelGuildsRsp() {
        this.labelInfo = new GProLabelInfo();
    }

    public GProLabelInfo getLabelInfo() {
        return this.labelInfo;
    }

    public String toString() {
        return "GetLabelGuildsRsp{labelInfo=" + this.labelInfo + ",}";
    }

    public GetLabelGuildsRsp(GProLabelInfo gProLabelInfo) {
        new GProLabelInfo();
        this.labelInfo = gProLabelInfo;
    }
}
