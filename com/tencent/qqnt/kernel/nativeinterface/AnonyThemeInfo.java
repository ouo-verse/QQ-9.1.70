package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AnonyThemeInfo {
    public String themeDesc;
    public int themeFlag;
    public String themeIconUrl;
    public int themeId;
    public String themeName;

    public AnonyThemeInfo() {
        this.themeName = "";
        this.themeDesc = "";
        this.themeIconUrl = "";
    }

    public String getThemeDesc() {
        return this.themeDesc;
    }

    public int getThemeFlag() {
        return this.themeFlag;
    }

    public String getThemeIconUrl() {
        return this.themeIconUrl;
    }

    public int getThemeId() {
        return this.themeId;
    }

    public String getThemeName() {
        return this.themeName;
    }

    public String toString() {
        return "AnonyThemeInfo{themeId=" + this.themeId + ",themeName=" + this.themeName + ",themeDesc=" + this.themeDesc + ",themeIconUrl=" + this.themeIconUrl + ",themeFlag=" + this.themeFlag + ",}";
    }

    public AnonyThemeInfo(int i3, String str, String str2, String str3, int i16) {
        this.themeId = i3;
        this.themeName = str;
        this.themeDesc = str2;
        this.themeIconUrl = str3;
        this.themeFlag = i16;
    }
}
