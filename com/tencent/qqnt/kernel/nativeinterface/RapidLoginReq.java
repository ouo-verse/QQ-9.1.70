package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RapidLoginReq {
    public long destAppid;
    public long destSubAppid;
    public long uin;
    public String scheme = "";
    public String bundleId = "";
    public String publicKey = "";

    public String getBundleId() {
        return this.bundleId;
    }

    public long getDestAppid() {
        return this.destAppid;
    }

    public long getDestSubAppid() {
        return this.destSubAppid;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getScheme() {
        return this.scheme;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "RapidLoginReq{uin=" + this.uin + ",destAppid=" + this.destAppid + ",destSubAppid=" + this.destSubAppid + ",scheme=" + this.scheme + ",bundleId=" + this.bundleId + ",publicKey=" + this.publicKey + ",}";
    }
}
