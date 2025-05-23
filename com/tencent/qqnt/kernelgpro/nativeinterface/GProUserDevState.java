package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProUserDevState implements Serializable {
    public int cameraState;
    public String currentRoomId;
    public int micState;
    public int networkQuality;
    public int screenState;
    long serialVersionUID;
    public int sysMicBusy;

    public GProUserDevState() {
        this.serialVersionUID = 1L;
        this.currentRoomId = "";
    }

    public int getCameraState() {
        return this.cameraState;
    }

    public String getCurrentRoomId() {
        return this.currentRoomId;
    }

    public int getMicState() {
        return this.micState;
    }

    public int getNetworkQuality() {
        return this.networkQuality;
    }

    public int getScreenState() {
        return this.screenState;
    }

    public int getSysMicBusy() {
        return this.sysMicBusy;
    }

    public void setCameraState(int i3) {
        this.cameraState = i3;
    }

    public void setCurrentRoomId(String str) {
        this.currentRoomId = str;
    }

    public void setMicState(int i3) {
        this.micState = i3;
    }

    public void setNetworkQuality(int i3) {
        this.networkQuality = i3;
    }

    public void setScreenState(int i3) {
        this.screenState = i3;
    }

    public void setSysMicBusy(int i3) {
        this.sysMicBusy = i3;
    }

    public String toString() {
        return "GProUserDevState{micState=" + this.micState + ",cameraState=" + this.cameraState + ",screenState=" + this.screenState + ",networkQuality=" + this.networkQuality + ",sysMicBusy=" + this.sysMicBusy + ",currentRoomId=" + this.currentRoomId + ",}";
    }

    public GProUserDevState(int i3, int i16, int i17, int i18, int i19, String str) {
        this.serialVersionUID = 1L;
        this.micState = i3;
        this.cameraState = i16;
        this.screenState = i17;
        this.networkQuality = i18;
        this.sysMicBusy = i19;
        this.currentRoomId = str;
    }
}
