package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ServerAddress {

    /* renamed from: ip, reason: collision with root package name */
    public String f359217ip;
    public int port;

    public ServerAddress() {
        this.f359217ip = "";
    }

    public String getIp() {
        return this.f359217ip;
    }

    public int getPort() {
        return this.port;
    }

    public String toString() {
        return "ServerAddress{ip=" + this.f359217ip + ",port=" + this.port + ",}";
    }

    public ServerAddress(String str, int i3) {
        this.f359217ip = str;
        this.port = i3;
    }
}
