package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RcvJoinVerifyMsgRsp {
    public long groupCode;
    public ArrayList<Long> rptOkUin = new ArrayList<>();

    public long getGroupCode() {
        return this.groupCode;
    }

    public ArrayList<Long> getRptOkUin() {
        return this.rptOkUin;
    }

    public String toString() {
        return "RcvJoinVerifyMsgRsp{groupCode=" + this.groupCode + ",rptOkUin=" + this.rptOkUin + ",}";
    }
}
