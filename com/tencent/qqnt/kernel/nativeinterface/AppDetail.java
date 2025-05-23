package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AppDetail implements Serializable {
    public long addTs;
    public int added;
    public boolean removable;
    public int type;
    long serialVersionUID = 1;
    public String appId = "";
    public String name = "";
    public String icon = "";
    public String desc = "";
    public AppCommonAction action = new AppCommonAction();
    public String adId = "";

    public AppCommonAction getAction() {
        return this.action;
    }

    public String getAdId() {
        return this.adId;
    }

    public long getAddTs() {
        return this.addTs;
    }

    public int getAdded() {
        return this.added;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public boolean getRemovable() {
        return this.removable;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "AppDetail{appId=" + this.appId + ",name=" + this.name + ",icon=" + this.icon + ",type=" + this.type + ",removable=" + this.removable + ",desc=" + this.desc + ",added=" + this.added + ",addTs=" + this.addTs + ",action=" + this.action + ",adId=" + this.adId + ",}";
    }
}
