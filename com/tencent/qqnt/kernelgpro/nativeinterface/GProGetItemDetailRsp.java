package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetItemDetailRsp {
    public byte[] cookies;
    public boolean isEnd;
    public ArrayList<GProRecommendItem> items;

    /* renamed from: msg, reason: collision with root package name */
    public String f359292msg;
    public int nextTs;
    public String requestId;

    public GProGetItemDetailRsp() {
        this.requestId = "";
        this.items = new ArrayList<>();
        this.f359292msg = "";
        this.cookies = new byte[0];
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<GProRecommendItem> getItems() {
        return this.items;
    }

    public String getMsg() {
        return this.f359292msg;
    }

    public int getNextTs() {
        return this.nextTs;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String toString() {
        return "GProGetItemDetailRsp{requestId=" + this.requestId + ",items=" + this.items + ",msg=" + this.f359292msg + ",isEnd=" + this.isEnd + ",cookies=" + this.cookies + ",nextTs=" + this.nextTs + ",}";
    }

    public GProGetItemDetailRsp(String str, ArrayList<GProRecommendItem> arrayList, String str2, boolean z16, byte[] bArr, int i3) {
        this.requestId = "";
        new ArrayList();
        this.requestId = str;
        this.items = arrayList;
        this.f359292msg = str2;
        this.isEnd = z16;
        this.cookies = bArr;
        this.nextTs = i3;
    }
}
