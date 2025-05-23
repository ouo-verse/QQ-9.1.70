package com.tencent.mobileqq.data;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DraftSummaryInfo implements DraftSummaryInfoInterface {
    private String atInfoStr;
    private String summary;
    private long time;
    private int type;
    private String uin;

    @Override // com.tencent.mobileqq.data.DraftSummaryInfoInterface
    public String getSummary() {
        return this.summary;
    }

    @Override // com.tencent.mobileqq.data.DraftSummaryInfoInterface
    public long getTime() {
        return this.time / 1000;
    }

    public void setAtInfoStr(String str) {
        this.atInfoStr = str;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setTime(long j3) {
        this.time = j3;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public void setUin(String str) {
        this.uin = str;
    }
}
