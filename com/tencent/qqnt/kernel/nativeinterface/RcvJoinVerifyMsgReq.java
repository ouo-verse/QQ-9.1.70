package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RcvJoinVerifyMsgReq {
    public int authority;
    public long groupCode;
    public int operate;
    public ArrayList<Long> rptAdminUin = new ArrayList<>();

    public int getAuthority() {
        return this.authority;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getOperate() {
        return this.operate;
    }

    public ArrayList<Long> getRptAdminUin() {
        return this.rptAdminUin;
    }

    public String toString() {
        return "RcvJoinVerifyMsgReq{groupCode=" + this.groupCode + ",rptAdminUin=" + this.rptAdminUin + ",authority=" + this.authority + ",operate=" + this.operate + ",}";
    }
}
