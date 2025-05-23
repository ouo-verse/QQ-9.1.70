package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MiniAppGetGroupInfoReq {
    public int appID;
    public ArrayList<MiniAppGroupInfoReq> groupInfoReqList = new ArrayList<>();

    public int getAppID() {
        return this.appID;
    }

    public ArrayList<MiniAppGroupInfoReq> getGroupInfoReqList() {
        return this.groupInfoReqList;
    }

    public String toString() {
        return "MiniAppGetGroupInfoReq{groupInfoReqList=" + this.groupInfoReqList + ",appID=" + this.appID + ",}";
    }
}
