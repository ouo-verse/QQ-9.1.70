package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProUserAVInfo implements Serializable {
    public int userAVState;
    public boolean userInSpeakQueue;
    public boolean userIsHandUp;
    long serialVersionUID = 1;
    public GProUserDevState userDevState = new GProUserDevState();
    public GProSpeakTimeCtl speakTimeCtl = new GProSpeakTimeCtl();

    public GProSpeakTimeCtl getSpeakTimeCtl() {
        return this.speakTimeCtl;
    }

    public int getUserAVState() {
        return this.userAVState;
    }

    public GProUserDevState getUserDevState() {
        return this.userDevState;
    }

    public boolean getUserInSpeakQueue() {
        return this.userInSpeakQueue;
    }

    public boolean getUserIsHandUp() {
        return this.userIsHandUp;
    }

    public void setSpeakTimeCtl(GProSpeakTimeCtl gProSpeakTimeCtl) {
        this.speakTimeCtl = gProSpeakTimeCtl;
    }

    public void setUserAVState(int i3) {
        this.userAVState = i3;
    }

    public void setUserDevState(GProUserDevState gProUserDevState) {
        this.userDevState = gProUserDevState;
    }

    public void setUserInSpeakQueue(boolean z16) {
        this.userInSpeakQueue = z16;
    }

    public void setUserIsHandUp(boolean z16) {
        this.userIsHandUp = z16;
    }

    public String toString() {
        return "GProUserAVInfo{userAVState=" + this.userAVState + ",userDevState=" + this.userDevState + ",userIsHandUp=" + this.userIsHandUp + ",userInSpeakQueue=" + this.userInSpeakQueue + ",speakTimeCtl=" + this.speakTimeCtl + ",}";
    }
}
