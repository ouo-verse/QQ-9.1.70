package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetVoiceReq {
    public AIVoiceChatType chatType = AIVoiceChatType.values()[0];
    public long groupCode;

    public AIVoiceChatType getChatType() {
        return this.chatType;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String toString() {
        return "GetVoiceReq{groupCode=" + this.groupCode + ",chatType=" + this.chatType + ",}";
    }
}
