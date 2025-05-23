package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupTagRecordRsp {
    public long groupCode;
    public ArrayList<GroupTagRecord> tagRecords = new ArrayList<>();

    public long getGroupCode() {
        return this.groupCode;
    }

    public ArrayList<GroupTagRecord> getTagRecords() {
        return this.tagRecords;
    }

    public String toString() {
        return "GroupTagRecordRsp{groupCode=" + this.groupCode + ",tagRecords=" + this.tagRecords + ",}";
    }
}
