package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AddrIpv6 {
    public int innerPort;
    public int ipType;
    public int ipv6Port;
    public String ipv6 = "";
    public String innerIpv6 = "";

    public String getInnerIpv6() {
        return this.innerIpv6;
    }

    public int getInnerPort() {
        return this.innerPort;
    }

    public int getIpType() {
        return this.ipType;
    }

    public String getIpv6() {
        return this.ipv6;
    }

    public int getIpv6Port() {
        return this.ipv6Port;
    }
}
