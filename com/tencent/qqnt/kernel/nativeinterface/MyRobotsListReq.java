package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MyRobotsListReq {
    public boolean isLocal;
    public int pageNum;
    public byte[] pagingCookie = new byte[0];
    public String dataVersion = "";

    public String getDataVersion() {
        return this.dataVersion;
    }

    public boolean getIsLocal() {
        return this.isLocal;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public byte[] getPagingCookie() {
        return this.pagingCookie;
    }
}
