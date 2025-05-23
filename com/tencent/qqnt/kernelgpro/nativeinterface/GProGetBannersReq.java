package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetBannersReq {
    public int getNum;
    public int serviceType;

    public GProGetBannersReq() {
    }

    public int getGetNum() {
        return this.getNum;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public void setGetNum(int i3) {
        this.getNum = i3;
    }

    public void setServiceType(int i3) {
        this.serviceType = i3;
    }

    public String toString() {
        return "GProGetBannersReq{serviceType=" + this.serviceType + ",getNum=" + this.getNum + ",}";
    }

    public GProGetBannersReq(int i3, int i16) {
        this.serviceType = i3;
        this.getNum = i16;
    }
}
