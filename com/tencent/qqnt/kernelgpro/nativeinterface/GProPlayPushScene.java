package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProPlayPushScene implements Serializable {
    long serialVersionUID = 1;
    public boolean volume;

    public GProPlayPushScene() {
    }

    public boolean getVolume() {
        return this.volume;
    }

    public String toString() {
        return "GProPlayPushScene{volume=" + this.volume + ",}";
    }

    public GProPlayPushScene(boolean z16) {
        this.volume = z16;
    }
}
