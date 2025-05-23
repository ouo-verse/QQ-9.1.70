package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSearchBlackUserRsp {
    public byte[] buf;
    public long guildId;
    public String keyword;
    public ArrayList<GProBlackUserInfo> memberList;
    public long nextPos;
    public String traceId;

    public GProSearchBlackUserRsp() {
        this.memberList = new ArrayList<>();
        this.traceId = "";
        this.buf = new byte[0];
        this.keyword = "";
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

    public ArrayList<GProBlackUserInfo> getMemberList() {
        return this.memberList;
    }

    public long getNextPos() {
        return this.nextPos;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProSearchBlackUserRsp{guildId=" + this.guildId + ",memberList=" + this.memberList + ",nextPos=" + this.nextPos + ",traceId=" + this.traceId + ",buf=" + this.buf + ",keyword=" + this.keyword + ",}";
    }

    public GProSearchBlackUserRsp(long j3, ArrayList<GProBlackUserInfo> arrayList, long j16, String str, byte[] bArr, String str2) {
        new ArrayList();
        this.guildId = j3;
        this.memberList = arrayList;
        this.nextPos = j16;
        this.traceId = str;
        this.buf = bArr;
        this.keyword = str2;
    }
}
