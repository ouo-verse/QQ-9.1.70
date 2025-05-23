package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SendMsgRspTransSvrInfoAttr {
    public int rspCode;
    public int rspErrType;
    public TransSvrInfo transSvrInfo;

    public SendMsgRspTransSvrInfoAttr() {
    }

    public int getRspCode() {
        return this.rspCode;
    }

    public int getRspErrType() {
        return this.rspErrType;
    }

    public TransSvrInfo getTransSvrInfo() {
        return this.transSvrInfo;
    }

    public String toString() {
        return "SendMsgRspTransSvrInfoAttr{rspCode=" + this.rspCode + ",rspErrType=" + this.rspErrType + ",transSvrInfo=" + this.transSvrInfo + ",}";
    }

    public SendMsgRspTransSvrInfoAttr(int i3, int i16, TransSvrInfo transSvrInfo) {
        this.rspCode = i3;
        this.rspErrType = i16;
        this.transSvrInfo = transSvrInfo;
    }
}
