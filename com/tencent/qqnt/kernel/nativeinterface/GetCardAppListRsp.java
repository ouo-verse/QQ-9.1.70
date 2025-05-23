package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetCardAppListRsp {
    public long groupId;
    public ArrayList<GroupAppInfo> infos = new ArrayList<>();
    public GroupAppExtraInfo extraInfo = new GroupAppExtraInfo();

    public GroupAppExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public ArrayList<GroupAppInfo> getInfos() {
        return this.infos;
    }

    public String toString() {
        return "GetCardAppListRsp{groupId=" + this.groupId + ",infos=" + this.infos + ",extraInfo=" + this.extraInfo + ",}";
    }
}
