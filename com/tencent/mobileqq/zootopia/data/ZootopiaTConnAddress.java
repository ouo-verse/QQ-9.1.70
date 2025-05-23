package com.tencent.mobileqq.zootopia.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zootopia/data/ZootopiaTConnAddress;", "Ljava/io/Serializable;", "ip", "", "port", "", "type", "(Ljava/lang/String;II)V", "getIp", "()Ljava/lang/String;", "getPort", "()I", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class ZootopiaTConnAddress implements Serializable {
    private final String ip;
    private final int port;
    private final int type;

    public ZootopiaTConnAddress(String ip5, int i3, int i16) {
        Intrinsics.checkNotNullParameter(ip5, "ip");
        this.ip = ip5;
        this.port = i3;
        this.type = i16;
    }

    /* renamed from: component1, reason: from getter */
    public final String getIp() {
        return this.ip;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    /* renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final ZootopiaTConnAddress copy(String ip5, int port, int type) {
        Intrinsics.checkNotNullParameter(ip5, "ip");
        return new ZootopiaTConnAddress(ip5, port, type);
    }

    public final String getIp() {
        return this.ip;
    }

    public final int getPort() {
        return this.port;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.ip.hashCode() * 31) + this.port) * 31) + this.type;
    }

    public String toString() {
        return "ZootopiaTConnAddress(ip=" + this.ip + ", port=" + this.port + ", type=" + this.type + ")";
    }

    public static /* synthetic */ ZootopiaTConnAddress copy$default(ZootopiaTConnAddress zootopiaTConnAddress, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            str = zootopiaTConnAddress.ip;
        }
        if ((i17 & 2) != 0) {
            i3 = zootopiaTConnAddress.port;
        }
        if ((i17 & 4) != 0) {
            i16 = zootopiaTConnAddress.type;
        }
        return zootopiaTConnAddress.copy(str, i3, i16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaTConnAddress)) {
            return false;
        }
        ZootopiaTConnAddress zootopiaTConnAddress = (ZootopiaTConnAddress) other;
        return Intrinsics.areEqual(this.ip, zootopiaTConnAddress.ip) && this.port == zootopiaTConnAddress.port && this.type == zootopiaTConnAddress.type;
    }
}
