package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetGroupInviteNoAuthLimitRsp {
    public ArrayList<GroupInviteNoAuthLimitInfo> infos = new ArrayList<>();

    public ArrayList<GroupInviteNoAuthLimitInfo> getInfos() {
        return this.infos;
    }

    public String toString() {
        return "GetGroupInviteNoAuthLimitRsp{infos=" + this.infos + ",}";
    }
}
