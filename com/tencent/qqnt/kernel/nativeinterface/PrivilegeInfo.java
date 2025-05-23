package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PrivilegeInfo {
    public String deluxeIconPath;
    public String deluxeIconUrl;
    public int flag;
    public String iconPath;
    public String iconUrl;
    public int isBig;
    public String jumpUrl;
    public int level;
    public int type;

    public PrivilegeInfo() {
        this.jumpUrl = "";
        this.iconUrl = "";
        this.iconPath = "";
        this.deluxeIconUrl = "";
        this.deluxeIconPath = "";
    }

    public String getDeluxeIconPath() {
        return this.deluxeIconPath;
    }

    public String getDeluxeIconUrl() {
        return this.deluxeIconUrl;
    }

    public int getFlag() {
        return this.flag;
    }

    public String getIconPath() {
        return this.iconPath;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getIsBig() {
        return this.isBig;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getLevel() {
        return this.level;
    }

    public int getType() {
        return this.type;
    }

    public PrivilegeInfo(String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, int i18) {
        this.jumpUrl = str;
        this.iconUrl = str2;
        this.iconPath = str3;
        this.deluxeIconUrl = str4;
        this.deluxeIconPath = str5;
        this.isBig = i3;
        this.type = i16;
        this.level = i17;
        this.flag = i18;
    }
}
