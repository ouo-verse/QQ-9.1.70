package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSearchTopicReq {
    public String keyWord = "";
    public byte[] cookie = new byte[0];

    public byte[] getCookie() {
        return this.cookie;
    }

    public String getKeyWord() {
        return this.keyWord;
    }

    public String toString() {
        return "GProSearchTopicReq{keyWord=" + this.keyWord + ",cookie=" + this.cookie + ",}";
    }
}
