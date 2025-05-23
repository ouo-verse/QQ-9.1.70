package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ArkMsgConfigInfo {
    public ArkMsgBaseInfo baseInfo = new ArkMsgBaseInfo();
    public ArkMsgConfig config = new ArkMsgConfig();
    public ArrayList<String> jumpList = new ArrayList<>();
    public ArrayList<String> resourceList = new ArrayList<>();
    public int state;

    public ArkMsgBaseInfo getBaseInfo() {
        return this.baseInfo;
    }

    public ArkMsgConfig getConfig() {
        return this.config;
    }

    public ArrayList<String> getJumpList() {
        return this.jumpList;
    }

    public ArrayList<String> getResourceList() {
        return this.resourceList;
    }

    public int getState() {
        return this.state;
    }

    public String toString() {
        return "ArkMsgConfigInfo{baseInfo=" + this.baseInfo + ",state=" + this.state + ",config=" + this.config + ",jumpList=" + this.jumpList + ",resourceList=" + this.resourceList + ",}";
    }
}
