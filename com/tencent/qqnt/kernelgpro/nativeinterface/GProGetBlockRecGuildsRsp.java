package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetBlockRecGuildsRsp implements Serializable {
    public GProGetRecommendV2Rsp banner;
    public byte[] cookies;
    public boolean isEnd;

    /* renamed from: msg, reason: collision with root package name */
    public String f359290msg;
    public ArrayList<GProBlockInfo> recBlockInfo;
    long serialVersionUID;
    public String traceId;

    public GProGetBlockRecGuildsRsp() {
        this.serialVersionUID = 1L;
        this.traceId = "";
        this.recBlockInfo = new ArrayList<>();
        this.f359290msg = "";
        this.cookies = new byte[0];
        this.banner = new GProGetRecommendV2Rsp();
    }

    public GProGetRecommendV2Rsp getBanner() {
        return this.banner;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public String getMsg() {
        return this.f359290msg;
    }

    public ArrayList<GProBlockInfo> getRecBlockInfo() {
        return this.recBlockInfo;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProGetBlockRecGuildsRsp{traceId=" + this.traceId + ",recBlockInfo=" + this.recBlockInfo + ",msg=" + this.f359290msg + ",isEnd=" + this.isEnd + ",cookies=" + this.cookies + ",banner=" + this.banner + ",}";
    }

    public GProGetBlockRecGuildsRsp(String str, ArrayList<GProBlockInfo> arrayList, String str2, boolean z16, byte[] bArr, GProGetRecommendV2Rsp gProGetRecommendV2Rsp) {
        this.serialVersionUID = 1L;
        this.traceId = "";
        this.recBlockInfo = new ArrayList<>();
        this.f359290msg = "";
        this.cookies = new byte[0];
        new GProGetRecommendV2Rsp();
        this.traceId = str;
        this.recBlockInfo = arrayList;
        this.f359290msg = str2;
        this.isEnd = z16;
        this.cookies = bArr;
        this.banner = gProGetRecommendV2Rsp;
    }
}
