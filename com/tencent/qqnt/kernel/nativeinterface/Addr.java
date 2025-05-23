package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Addr {
    public int innerPort;
    public int ipType;
    public int outPort;
    public String outIp = "";
    public String innerIp = "";

    public String getInnerIp() {
        return this.innerIp;
    }

    public int getInnerPort() {
        return this.innerPort;
    }

    public int getIpType() {
        return this.ipType;
    }

    public String getOutIp() {
        return this.outIp;
    }

    public int getOutPort() {
        return this.outPort;
    }
}
