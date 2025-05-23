package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRiskMemberListRsp {
    public byte[] buf;
    public String cookie;
    public ArrayList<GProRiskMemberGroupInfo> groupList;
    public boolean isEnd;
    public String subTitle;
    public String title;
    public long totalNum;
    public String traceId;

    public GProRiskMemberListRsp() {
        this.groupList = new ArrayList<>();
        this.cookie = "";
        this.traceId = "";
        this.buf = new byte[0];
        this.title = "";
        this.subTitle = "";
    }

    public byte[] getBuf() {
        return this.buf;
    }

    public String getCookie() {
        return this.cookie;
    }

    public ArrayList<GProRiskMemberGroupInfo> getGroupList() {
        return this.groupList;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public long getTotalNum() {
        return this.totalNum;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProRiskMemberListRsp{groupList=" + this.groupList + ",cookie=" + this.cookie + ",traceId=" + this.traceId + ",buf=" + this.buf + ",isEnd=" + this.isEnd + ",title=" + this.title + ",subTitle=" + this.subTitle + ",totalNum=" + this.totalNum + ",}";
    }

    public GProRiskMemberListRsp(ArrayList<GProRiskMemberGroupInfo> arrayList, String str, String str2, byte[] bArr, boolean z16, String str3, String str4, long j3) {
        new ArrayList();
        this.groupList = arrayList;
        this.cookie = str;
        this.traceId = str2;
        this.buf = bArr;
        this.isEnd = z16;
        this.title = str3;
        this.subTitle = str4;
        this.totalNum = j3;
    }
}
