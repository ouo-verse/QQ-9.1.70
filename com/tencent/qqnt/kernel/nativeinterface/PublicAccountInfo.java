package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PublicAccountInfo {
    public ArrayList<PublicAccountProfile> profiles;
    public PublicAccountSetting setting;

    public ArrayList<PublicAccountProfile> getProfiles() {
        return this.profiles;
    }

    public PublicAccountSetting getSetting() {
        return this.setting;
    }

    public String toString() {
        return "PublicAccountInfo{setting=" + this.setting + ",profiles=" + this.profiles + ",}";
    }
}
