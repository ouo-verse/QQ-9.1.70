package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetCapsuleAppRsp {
    public ArrayList<AppDetail> appList = new ArrayList<>();
    public boolean disableCapsule;
    public boolean disableCapsuleSwitch;
    public int disabled;
    public long expireTime;
    public int groupDisabled;
    public int versionFlag;

    public ArrayList<AppDetail> getAppList() {
        return this.appList;
    }

    public boolean getDisableCapsule() {
        return this.disableCapsule;
    }

    public boolean getDisableCapsuleSwitch() {
        return this.disableCapsuleSwitch;
    }

    public int getDisabled() {
        return this.disabled;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public int getGroupDisabled() {
        return this.groupDisabled;
    }

    public int getVersionFlag() {
        return this.versionFlag;
    }

    public String toString() {
        return "GetCapsuleAppRsp{appList=" + this.appList + ",disableCapsule=" + this.disableCapsule + ",expireTime=" + this.expireTime + ",disableCapsuleSwitch=" + this.disableCapsuleSwitch + ",groupDisabled=" + this.groupDisabled + ",disabled=" + this.disabled + ",versionFlag=" + this.versionFlag + ",}";
    }
}
