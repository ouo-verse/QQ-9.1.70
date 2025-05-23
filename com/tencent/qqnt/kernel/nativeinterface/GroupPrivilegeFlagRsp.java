package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

/* loaded from: classes24.dex */
public final class GroupPrivilegeFlagRsp {
    public HashMap<Long, Integer> groupInfoMap = new HashMap<>();

    public HashMap<Long, Integer> getGroupInfoMap() {
        return this.groupInfoMap;
    }

    public String toString() {
        return "GroupPrivilegeFlagRsp{groupInfoMap=" + this.groupInfoMap + ",}";
    }
}
