package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRiskMemberListReq {
    public byte[] buf;
    public String cookie;
    public long guildId;
    public String traceId;

    public GProRiskMemberListReq() {
        this.cookie = "";
        this.traceId = "";
        this.buf = new byte[0];
    }

    public byte[] getBuf() {
        return this.buf;
    }

    public String getCookie() {
        return this.cookie;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setBuf(byte[] bArr) {
        this.buf = bArr;
    }

    public void setCookie(String str) {
        this.cookie = str;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public String toString() {
        return "GProRiskMemberListReq{guildId=" + this.guildId + ",cookie=" + this.cookie + ",traceId=" + this.traceId + ",buf=" + this.buf + ",}";
    }

    public GProRiskMemberListReq(long j3, String str, String str2, byte[] bArr) {
        this.guildId = j3;
        this.cookie = str;
        this.traceId = str2;
        this.buf = bArr;
    }
}
