package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProDeleteFeedRsp {
    public GProFDLStCommonExt extInfo;

    public GProDeleteFeedRsp() {
        this.extInfo = new GProFDLStCommonExt();
    }

    public GProFDLStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public String toString() {
        return "GProDeleteFeedRsp{extInfo=" + this.extInfo + ",}";
    }

    public GProDeleteFeedRsp(GProFDLStCommonExt gProFDLStCommonExt) {
        new GProFDLStCommonExt();
        this.extInfo = gProFDLStCommonExt;
    }
}
