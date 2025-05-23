package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetSubGroupInfoRsp {
    public boolean isMasterGroup;
    public SubGroupSimpleInfo masterGroup = new SubGroupSimpleInfo();
    public ArrayList<SubGroupSimpleInfo> subGroups = new ArrayList<>();

    public boolean getIsMasterGroup() {
        return this.isMasterGroup;
    }

    public SubGroupSimpleInfo getMasterGroup() {
        return this.masterGroup;
    }

    public ArrayList<SubGroupSimpleInfo> getSubGroups() {
        return this.subGroups;
    }

    public String toString() {
        return "GetSubGroupInfoRsp{masterGroup=" + this.masterGroup + ",subGroups=" + this.subGroups + ",isMasterGroup=" + this.isMasterGroup + ",}";
    }
}
