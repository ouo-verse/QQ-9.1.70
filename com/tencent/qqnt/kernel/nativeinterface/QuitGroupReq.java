package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class QuitGroupReq {
    public long groupCode;
    public boolean needDeleteLocalMsg;

    public long getGroupCode() {
        return this.groupCode;
    }

    public boolean getNeedDeleteLocalMsg() {
        return this.needDeleteLocalMsg;
    }

    public String toString() {
        return "QuitGroupReq{groupCode=" + this.groupCode + ",needDeleteLocalMsg=" + this.needDeleteLocalMsg + ",}";
    }
}
