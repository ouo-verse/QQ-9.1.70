package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSyncMessage {
    public byte[] data = new byte[0];
    public long timestampMS;

    public byte[] getData() {
        return this.data;
    }

    public long getTimestampMS() {
        return this.timestampMS;
    }

    public String toString() {
        return "GProSyncMessage{data=" + this.data + ",timestampMS=" + this.timestampMS + ",}";
    }
}
