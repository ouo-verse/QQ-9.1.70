package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MiniAppGetGroupInfoRsp {
    public ArrayList<MiniAppGroupInfoRsp> groupInfoRspList = new ArrayList<>();

    public ArrayList<MiniAppGroupInfoRsp> getGroupInfoRspList() {
        return this.groupInfoRspList;
    }

    public String toString() {
        return "MiniAppGetGroupInfoRsp{groupInfoRspList=" + this.groupInfoRspList + ",}";
    }
}
