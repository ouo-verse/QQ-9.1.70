package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetCategoryGuildsRsp implements Serializable {
    public byte[] cookies;
    public boolean isEnd;
    public ArrayList<GProRecommendItem> items;

    /* renamed from: msg, reason: collision with root package name */
    public String f359291msg;
    long serialVersionUID;
    public String traceId;

    public GProGetCategoryGuildsRsp() {
        this.serialVersionUID = 1L;
        this.traceId = "";
        this.items = new ArrayList<>();
        this.f359291msg = "";
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
        return this.f359291msg;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProGetCategoryGuildsRsp{traceId=" + this.traceId + ",items=" + this.items + ",msg=" + this.f359291msg + ",isEnd=" + this.isEnd + ",cookies=" + this.cookies + ",}";
    }

    public GProGetCategoryGuildsRsp(String str, ArrayList<GProRecommendItem> arrayList, String str2, boolean z16, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.traceId = "";
        new ArrayList();
        this.traceId = str;
        this.items = arrayList;
        this.f359291msg = str2;
        this.isEnd = z16;
        this.cookies = bArr;
    }
}
