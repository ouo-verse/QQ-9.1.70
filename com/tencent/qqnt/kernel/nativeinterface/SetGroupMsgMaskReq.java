package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SetGroupMsgMaskReq {
    public ArrayList<GroupMsgMaskReqInfo> rptMsgReqGroupInfo = new ArrayList<>();

    public ArrayList<GroupMsgMaskReqInfo> getRptMsgReqGroupInfo() {
        return this.rptMsgReqGroupInfo;
    }

    public String toString() {
        return "SetGroupMsgMaskReq{rptMsgReqGroupInfo=" + this.rptMsgReqGroupInfo + ",}";
    }
}
