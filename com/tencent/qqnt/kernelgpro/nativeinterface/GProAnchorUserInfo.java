package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAnchorUserInfo {
    public String businessUid;
    public Long explicitId;
    public String head;

    /* renamed from: id, reason: collision with root package name */
    public Long f359280id;
    public Integer initialClientType;
    public String name;
    public Long tinyId;

    public String getBusinessUid() {
        return this.businessUid;
    }

    public Long getExplicitId() {
        return this.explicitId;
    }

    public String getHead() {
        return this.head;
    }

    public Long getId() {
        return this.f359280id;
    }

    public Integer getInitialClientType() {
        return this.initialClientType;
    }

    public String getName() {
        return this.name;
    }

    public Long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProAnchorUserInfo{id=" + this.f359280id + ",explicitId=" + this.explicitId + ",name=" + this.name + ",head=" + this.head + ",initialClientType=" + this.initialClientType + ",businessUid=" + this.businessUid + ",tinyId=" + this.tinyId + ",}";
    }
}
