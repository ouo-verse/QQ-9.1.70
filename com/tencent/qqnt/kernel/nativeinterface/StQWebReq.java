package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StQWebReq {
    public long Seq;
    public String qua = "";
    public String deviceInfo = "";
    public byte[] busiBuff = new byte[0];
    public String traceid = "";

    public byte[] getBusiBuff() {
        return this.busiBuff;
    }

    public String getDeviceInfo() {
        return this.deviceInfo;
    }

    public String getQua() {
        return this.qua;
    }

    public long getSeq() {
        return this.Seq;
    }

    public String getTraceid() {
        return this.traceid;
    }
}
