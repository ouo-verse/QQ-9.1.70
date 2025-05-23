package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ActiveExtGroupReq {
    public ArrayList<ActiveGroupInfo> rptMsgGroupInfo = new ArrayList<>();
    public long uin;

    public ArrayList<ActiveGroupInfo> getRptMsgGroupInfo() {
        return this.rptMsgGroupInfo;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "ActiveExtGroupReq{uin=" + this.uin + ",rptMsgGroupInfo=" + this.rptMsgGroupInfo + ",}";
    }
}
