package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DestroyGroupReq {
    public long groupCode;
    public boolean needDeleteLocalMsg;

    public long getGroupCode() {
        return this.groupCode;
    }

    public boolean getNeedDeleteLocalMsg() {
        return this.needDeleteLocalMsg;
    }

    public String toString() {
        return "DestroyGroupReq{groupCode=" + this.groupCode + ",needDeleteLocalMsg=" + this.needDeleteLocalMsg + ",}";
    }
}
