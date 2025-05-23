package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStLightInteractInfo {
    public int count;
    public GProStUser user = new GProStUser();
    public GProStRelationInfo relation = new GProStRelationInfo();
    public byte[] busiData = new byte[0];

    public byte[] getBusiData() {
        return this.busiData;
    }

    public int getCount() {
        return this.count;
    }

    public GProStRelationInfo getRelation() {
        return this.relation;
    }

    public GProStUser getUser() {
        return this.user;
    }

    public String toString() {
        return "GProStLightInteractInfo{user=" + this.user + ",relation=" + this.relation + ",count=" + this.count + ",busiData=" + this.busiData + ",}";
    }
}
