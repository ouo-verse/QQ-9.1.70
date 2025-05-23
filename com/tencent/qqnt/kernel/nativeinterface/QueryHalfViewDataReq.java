package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class QueryHalfViewDataReq {
    public boolean getLocalData;
    public int optId;
    public String uid = "";
    public String filterData = "";
    public byte[] pagingCookie = new byte[0];

    public String getFilterData() {
        return this.filterData;
    }

    public boolean getGetLocalData() {
        return this.getLocalData;
    }

    public int getOptId() {
        return this.optId;
    }

    public byte[] getPagingCookie() {
        return this.pagingCookie;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "QueryHalfViewDataReq{uid=" + this.uid + ",optId=" + this.optId + ",filterData=" + this.filterData + ",getLocalData=" + this.getLocalData + ",pagingCookie=" + this.pagingCookie + ",}";
    }
}
