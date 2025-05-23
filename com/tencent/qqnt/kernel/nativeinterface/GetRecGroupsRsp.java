package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetRecGroupsRsp {
    public boolean isEnd;
    public ArrayList<GroupSquareGroupInfoItem> groupList = new ArrayList<>();
    public String cookies = "";

    public String getCookies() {
        return this.cookies;
    }

    public ArrayList<GroupSquareGroupInfoItem> getGroupList() {
        return this.groupList;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public String toString() {
        return "GetRecGroupsRsp{groupList=" + this.groupList + ",cookies=" + this.cookies + ",isEnd=" + this.isEnd + ",}";
    }
}
