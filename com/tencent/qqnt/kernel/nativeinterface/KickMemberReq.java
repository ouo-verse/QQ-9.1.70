package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class KickMemberReq {
    public long groupCode;
    public int kickFlag;
    public ArrayList<KickMemberInfo> kickList = new ArrayList<>();
    public ArrayList<String> kickListUids = new ArrayList<>();
    public String kickMsg = "";

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getKickFlag() {
        return this.kickFlag;
    }

    public ArrayList<KickMemberInfo> getKickList() {
        return this.kickList;
    }

    public ArrayList<String> getKickListUids() {
        return this.kickListUids;
    }

    public String getKickMsg() {
        return this.kickMsg;
    }

    public String toString() {
        return "KickMemberReq{groupCode=" + this.groupCode + ",kickList=" + this.kickList + ",kickListUids=" + this.kickListUids + ",kickFlag=" + this.kickFlag + ",kickMsg=" + this.kickMsg + ",}";
    }
}
