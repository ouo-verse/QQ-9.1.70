package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetRtmpPushUrlRsp {
    public int expireTs;
    public int result;
    public String rmtpUrl = "";
    public String serverPart = "";
    public String streamParam = "";

    public int getExpireTs() {
        return this.expireTs;
    }

    public int getResult() {
        return this.result;
    }

    public String getRmtpUrl() {
        return this.rmtpUrl;
    }

    public String getServerPart() {
        return this.serverPart;
    }

    public String getStreamParam() {
        return this.streamParam;
    }

    public String toString() {
        return "GProGetRtmpPushUrlRsp{result=" + this.result + ",rmtpUrl=" + this.rmtpUrl + ",serverPart=" + this.serverPart + ",streamParam=" + this.streamParam + ",expireTs=" + this.expireTs + ",}";
    }
}
