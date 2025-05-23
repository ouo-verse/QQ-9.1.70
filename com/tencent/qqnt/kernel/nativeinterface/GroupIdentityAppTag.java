package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupIdentityAppTag implements Serializable {
    public int appType;
    public int level;
    public boolean status;
    long serialVersionUID = 1;
    public String appTagId = "";
    public String name = "";
    public String icon = "";
    public String miniIcon = "";

    public String getAppTagId() {
        return this.appTagId;
    }

    public int getAppType() {
        return this.appType;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getLevel() {
        return this.level;
    }

    public String getMiniIcon() {
        return this.miniIcon;
    }

    public String getName() {
        return this.name;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String toString() {
        return "GroupIdentityAppTag{appTagId=" + this.appTagId + ",name=" + this.name + ",icon=" + this.icon + ",status=" + this.status + ",level=" + this.level + ",miniIcon=" + this.miniIcon + ",appType=" + this.appType + ",}";
    }
}
