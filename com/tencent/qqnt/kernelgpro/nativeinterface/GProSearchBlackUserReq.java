package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSearchBlackUserReq {
    public byte[] buf;
    public long guildId;
    public String keyword;
    public int num;
    public long pos;
    public int scene;
    public int serviceType;
    public String traceId;
    public int userType;

    public GProSearchBlackUserReq() {
        this.keyword = "";
        this.traceId = "";
        this.buf = new byte[0];
    }

    public byte[] getBuf() {
        return this.buf;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public int getNum() {
        return this.num;
    }

    public long getPos() {
        return this.pos;
    }

    public int getScene() {
        return this.scene;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setBuf(byte[] bArr) {
        this.buf = bArr;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public void setNum(int i3) {
        this.num = i3;
    }

    public void setPos(long j3) {
        this.pos = j3;
    }

    public void setScene(int i3) {
        this.scene = i3;
    }

    public void setServiceType(int i3) {
        this.serviceType = i3;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setUserType(int i3) {
        this.userType = i3;
    }

    public String toString() {
        return "GProSearchBlackUserReq{guildId=" + this.guildId + ",keyword=" + this.keyword + ",num=" + this.num + ",pos=" + this.pos + ",traceId=" + this.traceId + ",buf=" + this.buf + ",scene=" + this.scene + ",userType=" + this.userType + ",serviceType=" + this.serviceType + ",}";
    }

    public GProSearchBlackUserReq(long j3, String str, int i3, long j16, String str2, byte[] bArr, int i16, int i17, int i18) {
        this.guildId = j3;
        this.keyword = str;
        this.num = i3;
        this.pos = j16;
        this.traceId = str2;
        this.buf = bArr;
        this.scene = i16;
        this.userType = i17;
        this.serviceType = i18;
    }
}
