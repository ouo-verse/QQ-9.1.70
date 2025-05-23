package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGetBlockRecGuildsReq implements Serializable {
    public String busiInfo;
    public int businessType;
    public byte[] cookies;
    long serialVersionUID;
    public GProBottomTabSourceInfo source;
    public GProTopRecommendInfo topRecommend;

    public GProGetBlockRecGuildsReq() {
        this.serialVersionUID = 1L;
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
        this.topRecommend = new GProTopRecommendInfo();
        this.busiInfo = "";
    }

    public String getBusiInfo() {
        return this.busiInfo;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public GProTopRecommendInfo getTopRecommend() {
        return this.topRecommend;
    }

    public void setBusiInfo(String str) {
        this.busiInfo = str;
    }

    public void setBusinessType(int i3) {
        this.businessType = i3;
    }

    public void setCookies(byte[] bArr) {
        this.cookies = bArr;
    }

    public void setSource(GProBottomTabSourceInfo gProBottomTabSourceInfo) {
        this.source = gProBottomTabSourceInfo;
    }

    public void setTopRecommend(GProTopRecommendInfo gProTopRecommendInfo) {
        this.topRecommend = gProTopRecommendInfo;
    }

    public String toString() {
        return "GProGetBlockRecGuildsReq{businessType=" + this.businessType + ",cookies=" + this.cookies + ",source=" + this.source + ",topRecommend=" + this.topRecommend + ",busiInfo=" + this.busiInfo + ",}";
    }

    public GProGetBlockRecGuildsReq(int i3, byte[] bArr, GProBottomTabSourceInfo gProBottomTabSourceInfo, GProTopRecommendInfo gProTopRecommendInfo, String str) {
        this.serialVersionUID = 1L;
        this.cookies = new byte[0];
        this.source = new GProBottomTabSourceInfo();
        new GProTopRecommendInfo();
        this.businessType = i3;
        this.cookies = bArr;
        this.source = gProBottomTabSourceInfo;
        this.topRecommend = gProTopRecommendInfo;
        this.busiInfo = str;
    }
}
