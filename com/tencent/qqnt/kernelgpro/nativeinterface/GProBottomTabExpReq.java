package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProBottomTabExpReq {
    public int businessType;
    public GProBottomTabSourceInfo source;

    public GProBottomTabExpReq() {
        this.source = new GProBottomTabSourceInfo();
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public void setBusinessType(int i3) {
        this.businessType = i3;
    }

    public void setSource(GProBottomTabSourceInfo gProBottomTabSourceInfo) {
        this.source = gProBottomTabSourceInfo;
    }

    public String toString() {
        return "GProBottomTabExpReq{businessType=" + this.businessType + ",source=" + this.source + ",}";
    }

    public GProBottomTabExpReq(int i3, GProBottomTabSourceInfo gProBottomTabSourceInfo) {
        new GProBottomTabSourceInfo();
        this.businessType = i3;
        this.source = gProBottomTabSourceInfo;
    }
}
