package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupTagRecordFilter {
    public int badNum;
    public int fromUid;
    public int goodNum;
    public int groupCode;
    public int setTime;
    public int tagId;
    public int tagLen;
    public int tagValue;

    public int getBadNum() {
        return this.badNum;
    }

    public int getFromUid() {
        return this.fromUid;
    }

    public int getGoodNum() {
        return this.goodNum;
    }

    public int getGroupCode() {
        return this.groupCode;
    }

    public int getSetTime() {
        return this.setTime;
    }

    public int getTagId() {
        return this.tagId;
    }

    public int getTagLen() {
        return this.tagLen;
    }

    public int getTagValue() {
        return this.tagValue;
    }

    public String toString() {
        return "GroupTagRecordFilter{fromUid=" + this.fromUid + ",groupCode=" + this.groupCode + ",tagId=" + this.tagId + ",setTime=" + this.setTime + ",goodNum=" + this.goodNum + ",badNum=" + this.badNum + ",tagLen=" + this.tagLen + ",tagValue=" + this.tagValue + ",}";
    }
}
