package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStDoCommentRsp {
    public GProStCommonExt extInfo = new GProStCommonExt();
    public GProStComment comment = new GProStComment();
    public byte[] busiRspData = new byte[0];

    public byte[] getBusiRspData() {
        return this.busiRspData;
    }

    public GProStComment getComment() {
        return this.comment;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public String toString() {
        return "GProStDoCommentRsp{extInfo=" + this.extInfo + ",comment=" + this.comment + ",busiRspData=" + this.busiRspData + ",}";
    }
}
