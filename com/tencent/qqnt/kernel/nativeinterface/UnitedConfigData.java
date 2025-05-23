package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UnitedConfigData {
    public int code;
    public String content;
    public String group;
    public Boolean isCdn;
    public boolean isSwitchOn;
    public String resourcePath;

    public UnitedConfigData() {
        this.group = "";
        this.content = "";
    }

    public int getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public String getGroup() {
        return this.group;
    }

    public Boolean getIsCdn() {
        return this.isCdn;
    }

    public boolean getIsSwitchOn() {
        return this.isSwitchOn;
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public String toString() {
        return "UnitedConfigData{group=" + this.group + ",content=" + this.content + ",isSwitchOn=" + this.isSwitchOn + ",code=" + this.code + ",isCdn=" + this.isCdn + ",resourcePath=" + this.resourcePath + ",}";
    }

    public UnitedConfigData(String str, String str2, boolean z16, int i3, Boolean bool, String str3) {
        this.group = str;
        this.content = str2;
        this.isSwitchOn = z16;
        this.code = i3;
        this.isCdn = bool;
        this.resourcePath = str3;
    }
}
