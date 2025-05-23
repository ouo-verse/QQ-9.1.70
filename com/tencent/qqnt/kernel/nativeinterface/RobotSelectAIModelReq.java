package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotSelectAIModelReq {
    public long botAppId;
    public long botUin;
    public long c2cUin;
    public int chatType;
    public String callbackData = "";
    public String botUid = "";
    public AIModelClickAction action = AIModelClickAction.values()[0];
    public AIModelCallbackType callBackType = AIModelCallbackType.values()[0];

    public AIModelClickAction getAction() {
        return this.action;
    }

    public long getBotAppId() {
        return this.botAppId;
    }

    public String getBotUid() {
        return this.botUid;
    }

    public long getBotUin() {
        return this.botUin;
    }

    public long getC2cUin() {
        return this.c2cUin;
    }

    public AIModelCallbackType getCallBackType() {
        return this.callBackType;
    }

    public String getCallbackData() {
        return this.callbackData;
    }

    public int getChatType() {
        return this.chatType;
    }

    public String toString() {
        return "RobotSelectAIModelReq{botAppId=" + this.botAppId + ",botUin=" + this.botUin + ",callbackData=" + this.callbackData + ",c2cUin=" + this.c2cUin + ",chatType=" + this.chatType + ",botUid=" + this.botUid + ",action=" + this.action + ",callBackType=" + this.callBackType + ",}";
    }
}
