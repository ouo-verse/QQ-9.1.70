package com.tencent.gamematrix.gmcg.sdk.service;

import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceStateInfo;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGQueryDeviceStateResp {
    public int leftTime;

    /* renamed from: msg, reason: collision with root package name */
    public String f107900msg;
    public int querygap;
    public int ret;
    public int state;

    public boolean isDeviceActive() {
        int i3 = this.state;
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6) {
            return true;
        }
        return false;
    }

    public boolean isDeviceNewAllocatedAndAlive() {
        int i3 = this.state;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public GmCgDeviceStateInfo toGmCgDeviceState() {
        GmCgDeviceStateInfo gmCgDeviceStateInfo = new GmCgDeviceStateInfo();
        gmCgDeviceStateInfo.pCurState = this.state;
        gmCgDeviceStateInfo.pLeftTimeOfKeepAlive = this.leftTime;
        gmCgDeviceStateInfo.pQueryGap = this.querygap;
        return gmCgDeviceStateInfo;
    }
}
