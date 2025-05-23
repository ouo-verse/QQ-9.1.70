package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AppSetting {
    public boolean colorUser;
    public boolean debugVersion;
    public boolean grayVersion;
    public boolean publicVersion;

    public AppSetting() {
    }

    public boolean getColorUser() {
        return this.colorUser;
    }

    public boolean getDebugVersion() {
        return this.debugVersion;
    }

    public boolean getGrayVersion() {
        return this.grayVersion;
    }

    public boolean getPublicVersion() {
        return this.publicVersion;
    }

    public String toString() {
        return "AppSetting{colorUser=" + this.colorUser + ",debugVersion=" + this.debugVersion + ",publicVersion=" + this.publicVersion + ",grayVersion=" + this.grayVersion + ",}";
    }

    public AppSetting(boolean z16, boolean z17, boolean z18, boolean z19) {
        this.colorUser = z16;
        this.debugVersion = z17;
        this.publicVersion = z18;
        this.grayVersion = z19;
    }
}
