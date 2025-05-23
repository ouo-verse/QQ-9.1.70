package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetFeedsByIndexReq {
    public int count;
    public int indexType;
    public GProIndexFeedParam indexParam = new GProIndexFeedParam();
    public byte[] cookie = new byte[0];

    public byte[] getCookie() {
        return this.cookie;
    }

    public int getCount() {
        return this.count;
    }

    public GProIndexFeedParam getIndexParam() {
        return this.indexParam;
    }

    public int getIndexType() {
        return this.indexType;
    }

    public String toString() {
        return "GProGetFeedsByIndexReq{indexType=" + this.indexType + ",indexParam=" + this.indexParam + ",cookie=" + this.cookie + ",count=" + this.count + ",}";
    }
}
