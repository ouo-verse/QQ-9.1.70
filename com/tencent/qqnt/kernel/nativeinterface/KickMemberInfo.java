package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class KickMemberInfo {
    public int optFlag;
    public int optOperate;
    public String optMemberUid = "";
    public String optBytesMsg = "";

    public String getOptBytesMsg() {
        return this.optBytesMsg;
    }

    public int getOptFlag() {
        return this.optFlag;
    }

    public String getOptMemberUid() {
        return this.optMemberUid;
    }

    public int getOptOperate() {
        return this.optOperate;
    }

    public String toString() {
        return "KickMemberInfo{optOperate=" + this.optOperate + ",optMemberUid=" + this.optMemberUid + ",optFlag=" + this.optFlag + ",optBytesMsg=" + this.optBytesMsg + ",}";
    }
}
