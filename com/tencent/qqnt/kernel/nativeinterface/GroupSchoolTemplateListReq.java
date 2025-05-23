package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSchoolTemplateListReq {
    public int page;
    public int pageSize;
    public int type;

    public GroupSchoolTemplateListReq() {
    }

    public int getPage() {
        return this.page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GroupSchoolTemplateListReq{page=" + this.page + ",pageSize=" + this.pageSize + ",type=" + this.type + ",}";
    }

    public GroupSchoolTemplateListReq(int i3, int i16, int i17) {
        this.page = i3;
        this.pageSize = i16;
        this.type = i17;
    }
}
