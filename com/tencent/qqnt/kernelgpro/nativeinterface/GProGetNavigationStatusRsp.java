package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetNavigationStatusRsp {
    public int auditStatus;
    public int enableSetting;
    public int existNavigation;
    public int limit;

    public GProGetNavigationStatusRsp() {
    }

    public int getAuditStatus() {
        return this.auditStatus;
    }

    public int getEnableSetting() {
        return this.enableSetting;
    }

    public int getExistNavigation() {
        return this.existNavigation;
    }

    public int getLimit() {
        return this.limit;
    }

    public String toString() {
        return "GProGetNavigationStatusRsp{enableSetting=" + this.enableSetting + ",existNavigation=" + this.existNavigation + ",auditStatus=" + this.auditStatus + ",limit=" + this.limit + ",}";
    }

    public GProGetNavigationStatusRsp(int i3, int i16, int i17) {
        this.enableSetting = i3;
        this.existNavigation = i16;
        this.auditStatus = i17;
    }
}
