package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OidbRspInfo {
    public String errMsg;
    public byte[] respData;
    public int result;
    public String tips;

    public OidbRspInfo() {
        this.errMsg = "";
        this.tips = "";
        this.respData = new byte[0];
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public byte[] getRespData() {
        return this.respData;
    }

    public int getResult() {
        return this.result;
    }

    public String getTips() {
        return this.tips;
    }

    public String toString() {
        return "OidbRspInfo{result=" + this.result + ",errMsg=" + this.errMsg + ",tips=" + this.tips + ",respData=" + this.respData + ",}";
    }

    public OidbRspInfo(int i3, String str, String str2, byte[] bArr) {
        this.result = i3;
        this.errMsg = str;
        this.tips = str2;
        this.respData = bArr;
    }
}
