package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TempChatServiceAssistantSession {
    public long appId;
    public int appType;
    public String appTypeName;

    public TempChatServiceAssistantSession() {
        this.appTypeName = "";
    }

    public long getAppId() {
        return this.appId;
    }

    public int getAppType() {
        return this.appType;
    }

    public String getAppTypeName() {
        return this.appTypeName;
    }

    public String toString() {
        return "TempChatServiceAssistantSession{appType=" + this.appType + ",appId=" + this.appId + ",appTypeName=" + this.appTypeName + ",}";
    }

    public TempChatServiceAssistantSession(int i3, long j3, String str) {
        this.appType = i3;
        this.appId = j3;
        this.appTypeName = str;
    }
}
