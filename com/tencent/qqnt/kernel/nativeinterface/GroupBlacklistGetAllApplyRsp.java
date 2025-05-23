package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupBlacklistGetAllApplyRsp {
    public long groupCode;
    public ArrayList<GroupBlacklistGetAllApplyItem> items = new ArrayList<>();
    public long nextStart;

    public long getGroupCode() {
        return this.groupCode;
    }

    public ArrayList<GroupBlacklistGetAllApplyItem> getItems() {
        return this.items;
    }

    public long getNextStart() {
        return this.nextStart;
    }

    public String toString() {
        return "GroupBlacklistGetAllApplyRsp{groupCode=" + this.groupCode + ",items=" + this.items + ",nextStart=" + this.nextStart + ",}";
    }
}
