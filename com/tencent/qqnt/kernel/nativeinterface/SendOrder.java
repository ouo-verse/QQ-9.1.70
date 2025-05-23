package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SendOrder {
    public int busType;
    public int channel;
    public int createTime;
    public int invalidTime;
    public String luckyName;
    public String luckyUid;
    public long luckyUin;
    public long recvAmount;
    public long recvNum;
    public int recvType;
    public String sendName;
    public long sendUin;
    public int state;
    public long totalAmount;
    public long totalNum;
    public String uid;
    public String wishing;

    public SendOrder() {
        this.sendName = "";
        this.wishing = "";
    }

    public int getBusType() {
        return this.busType;
    }

    public int getChannel() {
        return this.channel;
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public int getInvalidTime() {
        return this.invalidTime;
    }

    public String getLuckyName() {
        return this.luckyName;
    }

    public String getLuckyUid() {
        return this.luckyUid;
    }

    public long getLuckyUin() {
        return this.luckyUin;
    }

    public long getRecvAmount() {
        return this.recvAmount;
    }

    public long getRecvNum() {
        return this.recvNum;
    }

    public int getRecvType() {
        return this.recvType;
    }

    public String getSendName() {
        return this.sendName;
    }

    public long getSendUin() {
        return this.sendUin;
    }

    public int getState() {
        return this.state;
    }

    public long getTotalAmount() {
        return this.totalAmount;
    }

    public long getTotalNum() {
        return this.totalNum;
    }

    public String getUid() {
        return this.uid;
    }

    public String getWishing() {
        return this.wishing;
    }

    public String toString() {
        return "SendOrder{sendUin=" + this.sendUin + ",sendName=" + this.sendName + ",wishing=" + this.wishing + ",totalNum=" + this.totalNum + ",totalAmount=" + this.totalAmount + ",channel=" + this.channel + ",busType=" + this.busType + ",recvType=" + this.recvType + ",createTime=" + this.createTime + ",invalidTime=" + this.invalidTime + ",state=" + this.state + ",recvNum=" + this.recvNum + ",recvAmount=" + this.recvAmount + ",luckyUin=" + this.luckyUin + ",uid=" + this.uid + ",luckyUid=" + this.luckyUid + ",luckyName=" + this.luckyName + ",}";
    }

    public SendOrder(long j3, String str, String str2, long j16, long j17, int i3, int i16, int i17, int i18, int i19, int i26, long j18, long j19, long j26, String str3, String str4, String str5) {
        this.sendUin = j3;
        this.sendName = str;
        this.wishing = str2;
        this.totalNum = j16;
        this.totalAmount = j17;
        this.channel = i3;
        this.busType = i16;
        this.recvType = i17;
        this.createTime = i18;
        this.invalidTime = i19;
        this.state = i26;
        this.recvNum = j18;
        this.recvAmount = j19;
        this.luckyUin = j26;
        this.uid = str3;
        this.luckyUid = str4;
        this.luckyName = str5;
    }
}
