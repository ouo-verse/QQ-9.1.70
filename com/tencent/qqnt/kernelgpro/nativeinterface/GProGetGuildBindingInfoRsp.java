package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetGuildBindingInfoRsp {
    public ArrayList<GProBriefAppInfo> boundApps = new ArrayList<>();
    public ArrayList<GProBriefAppInfo> bindableApps = new ArrayList<>();

    public ArrayList<GProBriefAppInfo> getBindableApps() {
        return this.bindableApps;
    }

    public ArrayList<GProBriefAppInfo> getBoundApps() {
        return this.boundApps;
    }

    public String toString() {
        return "GProGetGuildBindingInfoRsp{boundApps=" + this.boundApps + ",bindableApps=" + this.bindableApps + ",}";
    }
}
