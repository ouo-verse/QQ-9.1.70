package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ResultWithGroupItem {
    public GroupItem groupItem;
    public GroupFileCommonResult result;

    public ResultWithGroupItem() {
        this.result = new GroupFileCommonResult();
        this.groupItem = new GroupItem();
    }

    public GroupItem getGroupItem() {
        return this.groupItem;
    }

    public GroupFileCommonResult getResult() {
        return this.result;
    }

    public ResultWithGroupItem(GroupFileCommonResult groupFileCommonResult, GroupItem groupItem) {
        this.result = new GroupFileCommonResult();
        new GroupItem();
        this.result = groupFileCommonResult;
        this.groupItem = groupItem;
    }
}
