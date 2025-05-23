package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupMemberHonorReq {
    public ArrayList<Long> groupCode = new ArrayList<>();

    public ArrayList<Long> getGroupCode() {
        return this.groupCode;
    }

    public String toString() {
        return "GroupMemberHonorReq{groupCode=" + this.groupCode + ",}";
    }
}
