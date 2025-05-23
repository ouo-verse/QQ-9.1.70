package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class HalfScreenPullNoticeReq {
    public ArrayList<String> appidList = new ArrayList<>();
    public int groupClass;
    public long groupCode;
    public int miniappProtect;
    public int mode;

    public ArrayList<String> getAppidList() {
        return this.appidList;
    }

    public int getGroupClass() {
        return this.groupClass;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getMiniappProtect() {
        return this.miniappProtect;
    }

    public int getMode() {
        return this.mode;
    }

    public String toString() {
        return "HalfScreenPullNoticeReq{groupCode=" + this.groupCode + ",appidList=" + this.appidList + ",groupClass=" + this.groupClass + ",miniappProtect=" + this.miniappProtect + ",mode=" + this.mode + ",}";
    }
}
