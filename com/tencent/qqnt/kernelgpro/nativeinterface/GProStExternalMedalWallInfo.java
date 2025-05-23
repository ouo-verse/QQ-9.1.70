package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStExternalMedalWallInfo {
    public ArrayList<GProStMedalInfo> medalInfos = new ArrayList<>();
    public String medalWallJumpUrl = "";
    public boolean needRedPoint;
    public boolean needShowEntrance;

    public ArrayList<GProStMedalInfo> getMedalInfos() {
        return this.medalInfos;
    }

    public String getMedalWallJumpUrl() {
        return this.medalWallJumpUrl;
    }

    public boolean getNeedRedPoint() {
        return this.needRedPoint;
    }

    public boolean getNeedShowEntrance() {
        return this.needShowEntrance;
    }

    public String toString() {
        return "GProStExternalMedalWallInfo{needRedPoint=" + this.needRedPoint + ",medalInfos=" + this.medalInfos + ",medalWallJumpUrl=" + this.medalWallJumpUrl + ",needShowEntrance=" + this.needShowEntrance + ",}";
    }
}
