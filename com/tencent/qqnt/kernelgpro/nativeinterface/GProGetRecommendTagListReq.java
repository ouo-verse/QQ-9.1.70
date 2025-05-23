package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetRecommendTagListReq {
    public int businessType;
    public byte[] cookies;
    public String groupId;
    public GProBottomTabSourceInfo source;
    public String type;

    public GProGetRecommendTagListReq() {
        this.groupId = "";
        this.type = "";
        this.source = new GProBottomTabSourceInfo();
        this.cookies = new byte[0];
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public String getType() {
        return this.type;
    }

    public void setBusinessType(int i3) {
        this.businessType = i3;
    }

    public void setCookies(byte[] bArr) {
        this.cookies = bArr;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setSource(GProBottomTabSourceInfo gProBottomTabSourceInfo) {
        this.source = gProBottomTabSourceInfo;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "GProGetRecommendTagListReq{businessType=" + this.businessType + ",groupId=" + this.groupId + ",type=" + this.type + ",source=" + this.source + ",cookies=" + this.cookies + ",}";
    }

    public GProGetRecommendTagListReq(int i3, String str, String str2, GProBottomTabSourceInfo gProBottomTabSourceInfo, byte[] bArr) {
        this.groupId = "";
        this.type = "";
        new GProBottomTabSourceInfo();
        this.businessType = i3;
        this.groupId = str;
        this.type = str2;
        this.source = gProBottomTabSourceInfo;
        this.cookies = bArr;
    }
}
