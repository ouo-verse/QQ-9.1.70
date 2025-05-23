package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BatchUploadBusinessConfig {
    public int agentType;
    public int appType;
    public C2CUserInfo c2cUserInfo = new C2CUserInfo();
    public GroupUserInfo groupUserInfo = new GroupUserInfo();
    public int sceneType;

    public int getAgentType() {
        return this.agentType;
    }

    public int getAppType() {
        return this.appType;
    }

    public C2CUserInfo getC2cUserInfo() {
        return this.c2cUserInfo;
    }

    public GroupUserInfo getGroupUserInfo() {
        return this.groupUserInfo;
    }

    public int getSceneType() {
        return this.sceneType;
    }
}
