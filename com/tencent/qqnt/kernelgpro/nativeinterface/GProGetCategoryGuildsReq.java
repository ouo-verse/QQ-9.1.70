package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGetCategoryGuildsReq implements Serializable {
    public int businessType;
    public int categoryId;
    public byte[] cookies;
    public String name;
    long serialVersionUID;
    public GProBottomTabSourceInfo source;

    public GProGetCategoryGuildsReq() {
        this.serialVersionUID = 1L;
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
        this.name = "";
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public String getName() {
        return this.name;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public void setBusinessType(int i3) {
        this.businessType = i3;
    }

    public void setCategoryId(int i3) {
        this.categoryId = i3;
    }

    public void setCookies(byte[] bArr) {
        this.cookies = bArr;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSource(GProBottomTabSourceInfo gProBottomTabSourceInfo) {
        this.source = gProBottomTabSourceInfo;
    }

    public String toString() {
        return "GProGetCategoryGuildsReq{businessType=" + this.businessType + ",cookies=" + this.cookies + ",source=" + this.source + ",name=" + this.name + ",categoryId=" + this.categoryId + ",}";
    }

    public GProGetCategoryGuildsReq(int i3, byte[] bArr, GProBottomTabSourceInfo gProBottomTabSourceInfo, String str, int i16) {
        this.serialVersionUID = 1L;
        this.cookies = new byte[0];
        new GProBottomTabSourceInfo();
        this.businessType = i3;
        this.cookies = bArr;
        this.source = gProBottomTabSourceInfo;
        this.name = str;
        this.categoryId = i16;
    }
}
