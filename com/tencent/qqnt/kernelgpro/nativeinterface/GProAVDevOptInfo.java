package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProAVDevOptInfo implements Serializable {
    public int cameraOpt;
    public int micOpt;
    public int screenOpt;
    long serialVersionUID = 1;

    public GProAVDevOptInfo() {
    }

    public int getCameraOpt() {
        return this.cameraOpt;
    }

    public int getMicOpt() {
        return this.micOpt;
    }

    public int getScreenOpt() {
        return this.screenOpt;
    }

    public void setCameraOpt(int i3) {
        this.cameraOpt = i3;
    }

    public void setMicOpt(int i3) {
        this.micOpt = i3;
    }

    public void setScreenOpt(int i3) {
        this.screenOpt = i3;
    }

    public String toString() {
        return "GProAVDevOptInfo{micOpt=" + this.micOpt + ",cameraOpt=" + this.cameraOpt + ",screenOpt=" + this.screenOpt + ",}";
    }

    public GProAVDevOptInfo(int i3, int i16, int i17) {
        this.micOpt = i3;
        this.cameraOpt = i16;
        this.screenOpt = i17;
    }
}
