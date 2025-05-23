package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GameMsgBoxConfig {
    public long appId;
    public String appName;
    public int authPromptType;
    public int notificationType;

    public GameMsgBoxConfig() {
        this.appName = "";
    }

    public long getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public int getAuthPromptType() {
        return this.authPromptType;
    }

    public int getNotificationType() {
        return this.notificationType;
    }

    public String toString() {
        return "GameMsgBoxConfig{appId=" + this.appId + ",appName=" + this.appName + ",notificationType=" + this.notificationType + ",authPromptType=" + this.authPromptType + ",}";
    }

    public GameMsgBoxConfig(long j3, String str, int i3, int i16) {
        this.appId = j3;
        this.appName = str;
        this.notificationType = i3;
        this.authPromptType = i16;
    }
}
