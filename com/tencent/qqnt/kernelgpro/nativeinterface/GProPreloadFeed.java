package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProPreloadFeed {
    public long createTime;
    public byte[] data = new byte[0];
    public int type;

    public long getCreateTime() {
        return this.createTime;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProPreloadFeed{type=" + this.type + ",data=" + this.data + ",createTime=" + this.createTime + ",}";
    }
}
