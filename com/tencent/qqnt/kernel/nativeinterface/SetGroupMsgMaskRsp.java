package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SetGroupMsgMaskRsp {
    public ArrayList<GroupMsgMaskRspInfo> rptMsgRspGroupInfo = new ArrayList<>();

    public ArrayList<GroupMsgMaskRspInfo> getRptMsgRspGroupInfo() {
        return this.rptMsgRspGroupInfo;
    }

    public String toString() {
        return "SetGroupMsgMaskRsp{rptMsgRspGroupInfo=" + this.rptMsgRspGroupInfo + ",}";
    }
}
