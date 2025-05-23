package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AVGroupAudioMemberModel {
    public int AVState;
    public int invitedTimestamp;
    public boolean isInvited;
    public boolean isMicOff;
    public boolean isMicOffBySelf;
    public int terminalType;
    public String uid;

    public AVGroupAudioMemberModel() {
        this.uid = "";
    }

    public int getAVState() {
        return this.AVState;
    }

    public int getInvitedTimestamp() {
        return this.invitedTimestamp;
    }

    public boolean getIsInvited() {
        return this.isInvited;
    }

    public boolean getIsMicOff() {
        return this.isMicOff;
    }

    public boolean getIsMicOffBySelf() {
        return this.isMicOffBySelf;
    }

    public int getTerminalType() {
        return this.terminalType;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "AVGroupAudioMemberModel{isInvited=" + this.isInvited + ",invitedTimestamp=" + this.invitedTimestamp + ",uid=" + this.uid + ",AVState=" + this.AVState + ",terminalType=" + this.terminalType + ",isMicOff=" + this.isMicOff + ",isMicOffBySelf=" + this.isMicOffBySelf + ",}";
    }

    public AVGroupAudioMemberModel(boolean z16, int i3, String str, int i16, int i17, boolean z17, boolean z18) {
        this.isInvited = z16;
        this.invitedTimestamp = i3;
        this.uid = str;
        this.AVState = i16;
        this.terminalType = i17;
        this.isMicOff = z17;
        this.isMicOffBySelf = z18;
    }
}
