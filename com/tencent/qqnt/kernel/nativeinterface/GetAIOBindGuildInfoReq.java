package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetAIOBindGuildInfoReq {
    public String cookies = "";
    public long groupCode;

    public String getCookies() {
        return this.cookies;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String toString() {
        return "GetAIOBindGuildInfoReq{groupCode=" + this.groupCode + ",cookies=" + this.cookies + ",}";
    }
}
