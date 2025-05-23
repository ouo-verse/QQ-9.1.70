package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class NearbyProCommonExtInfo {
    public NearbyProClientInfo clientInfo;
    public NearbyProBytesEntry mapBytesInfo;
    public NearbyProEntry mapInfo;
    public byte[] sig;
    public long tinyId;

    public NearbyProCommonExtInfo() {
        this.clientInfo = new NearbyProClientInfo();
        this.sig = new byte[0];
        this.mapInfo = new NearbyProEntry();
        this.mapBytesInfo = new NearbyProBytesEntry();
    }

    public NearbyProClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public NearbyProBytesEntry getMapBytesInfo() {
        return this.mapBytesInfo;
    }

    public NearbyProEntry getMapInfo() {
        return this.mapInfo;
    }

    public byte[] getSig() {
        return this.sig;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "NearbyProCommonExtInfo{tinyId=" + this.tinyId + ",clientInfo=" + this.clientInfo + ",sig=" + this.sig + ",mapInfo=" + this.mapInfo + ",mapBytesInfo=" + this.mapBytesInfo + ",}";
    }

    public NearbyProCommonExtInfo(long j3, NearbyProClientInfo nearbyProClientInfo, byte[] bArr, NearbyProEntry nearbyProEntry, NearbyProBytesEntry nearbyProBytesEntry) {
        this.clientInfo = new NearbyProClientInfo();
        this.sig = new byte[0];
        this.mapInfo = new NearbyProEntry();
        new NearbyProBytesEntry();
        this.tinyId = j3;
        this.clientInfo = nearbyProClientInfo;
        this.sig = bArr;
        this.mapInfo = nearbyProEntry;
        this.mapBytesInfo = nearbyProBytesEntry;
    }
}
