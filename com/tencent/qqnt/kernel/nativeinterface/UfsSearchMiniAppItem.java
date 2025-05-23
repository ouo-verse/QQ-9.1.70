package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsSearchMiniAppItem {
    public int miniappType;
    public int showMask;
    public String cover = "";
    public String name = "";
    public String desc = "";
    public ArrayList<UfsLabel> labels = new ArrayList<>();
    public String jumpUrl = "";
    public String classification = "";
    public String appid = "";
    public String miniIconUrl = "";

    public String getAppid() {
        return this.appid;
    }

    public String getClassification() {
        return this.classification;
    }

    public String getCover() {
        return this.cover;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public ArrayList<UfsLabel> getLabels() {
        return this.labels;
    }

    public String getMiniIconUrl() {
        return this.miniIconUrl;
    }

    public int getMiniappType() {
        return this.miniappType;
    }

    public String getName() {
        return this.name;
    }

    public int getShowMask() {
        return this.showMask;
    }

    public String toString() {
        return "UfsSearchMiniAppItem{cover=" + this.cover + ",name=" + this.name + ",desc=" + this.desc + ",labels=" + this.labels + ",jumpUrl=" + this.jumpUrl + ",classification=" + this.classification + ",appid=" + this.appid + ",showMask=" + this.showMask + ",miniappType=" + this.miniappType + ",miniIconUrl=" + this.miniIconUrl + ",}";
    }
}
