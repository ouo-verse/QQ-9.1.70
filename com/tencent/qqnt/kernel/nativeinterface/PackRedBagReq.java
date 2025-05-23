package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PackRedBagReq {
    public int busType;
    public int channel;
    public String name;
    public int qrcodeFlag;
    public int recvType;
    public long recvUin;
    public long totalAmount;
    public long totalNum;
    public String wishing;

    public PackRedBagReq() {
        this.wishing = "";
        this.name = "";
    }

    public int getBusType() {
        return this.busType;
    }

    public int getChannel() {
        return this.channel;
    }

    public String getName() {
        return this.name;
    }

    public int getQrcodeFlag() {
        return this.qrcodeFlag;
    }

    public int getRecvType() {
        return this.recvType;
    }

    public long getRecvUin() {
        return this.recvUin;
    }

    public long getTotalAmount() {
        return this.totalAmount;
    }

    public long getTotalNum() {
        return this.totalNum;
    }

    public String getWishing() {
        return this.wishing;
    }

    public String toString() {
        return "PackRedBagReq{totalNum=" + this.totalNum + ",totalAmount=" + this.totalAmount + ",recvUin=" + this.recvUin + ",recvType=" + this.recvType + ",wishing=" + this.wishing + ",channel=" + this.channel + ",busType=" + this.busType + ",name=" + this.name + ",qrcodeFlag=" + this.qrcodeFlag + ",}";
    }

    public PackRedBagReq(long j3, long j16, long j17, int i3, String str, int i16, int i17, String str2, int i18) {
        this.totalNum = j3;
        this.totalAmount = j16;
        this.recvUin = j17;
        this.recvType = i3;
        this.wishing = str;
        this.channel = i16;
        this.busType = i17;
        this.name = str2;
        this.qrcodeFlag = i18;
    }
}
