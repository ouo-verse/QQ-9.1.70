package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStDoReplyRsp {
    public GProStCommonExt extInfo = new GProStCommonExt();
    public GProStReply reply = new GProStReply();
    public byte[] busiRspData = new byte[0];

    public byte[] getBusiRspData() {
        return this.busiRspData;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public GProStReply getReply() {
        return this.reply;
    }

    public String toString() {
        return "GProStDoReplyRsp{extInfo=" + this.extInfo + ",reply=" + this.reply + ",busiRspData=" + this.busiRspData + ",}";
    }
}
