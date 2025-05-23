package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildGlobalAuthInfo implements Serializable {
    long serialVersionUID = 1;
    public ArrayList<GProGuildGlobalAuthInfoAuthControlSwitchInfoEntry> authControlSwitchInfoList = new ArrayList<>();

    public ArrayList<GProGuildGlobalAuthInfoAuthControlSwitchInfoEntry> getAuthControlSwitchInfoList() {
        return this.authControlSwitchInfoList;
    }

    public String toString() {
        return "GProGuildGlobalAuthInfo{authControlSwitchInfoList=" + this.authControlSwitchInfoList + ",}";
    }
}
