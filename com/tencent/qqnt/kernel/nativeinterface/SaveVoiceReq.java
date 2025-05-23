package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SaveVoiceReq {
    public AIVoiceChatType chatType = AIVoiceChatType.values()[0];
    public String choosedVoiceId = "";
    public long groupCode;

    public AIVoiceChatType getChatType() {
        return this.chatType;
    }

    public String getChoosedVoiceId() {
        return this.choosedVoiceId;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String toString() {
        return "SaveVoiceReq{groupCode=" + this.groupCode + ",chatType=" + this.chatType + ",choosedVoiceId=" + this.choosedVoiceId + ",}";
    }
}
