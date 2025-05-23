package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FetchGroupEssenceListReq {
    public long groupCode;
    public int pageLimit;
    public int pageStart;

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getPageLimit() {
        return this.pageLimit;
    }

    public int getPageStart() {
        return this.pageStart;
    }

    public String toString() {
        return "FetchGroupEssenceListReq{groupCode=" + this.groupCode + ",pageStart=" + this.pageStart + ",pageLimit=" + this.pageLimit + ",}";
    }
}
