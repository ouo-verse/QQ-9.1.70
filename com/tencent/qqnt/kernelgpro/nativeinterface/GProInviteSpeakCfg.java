package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProInviteSpeakCfg implements Serializable {
    public int inviteSpeakState;
    long serialVersionUID = 1;

    public GProInviteSpeakCfg() {
    }

    public int getInviteSpeakState() {
        return this.inviteSpeakState;
    }

    public void setInviteSpeakState(int i3) {
        this.inviteSpeakState = i3;
    }

    public String toString() {
        return "GProInviteSpeakCfg{inviteSpeakState=" + this.inviteSpeakState + ",}";
    }

    public GProInviteSpeakCfg(int i3) {
        this.inviteSpeakState = i3;
    }
}
