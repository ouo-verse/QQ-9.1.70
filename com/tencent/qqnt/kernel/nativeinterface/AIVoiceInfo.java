package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AIVoiceInfo {
    public long groupCode;
    public String voiceTimbreID = "";
    public String text = "";

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getText() {
        return this.text;
    }

    public String getVoiceTimbreID() {
        return this.voiceTimbreID;
    }

    public String toString() {
        return "AIVoiceInfo{groupCode=" + this.groupCode + ",voiceTimbreID=" + this.voiceTimbreID + ",text=" + this.text + ",}";
    }
}
