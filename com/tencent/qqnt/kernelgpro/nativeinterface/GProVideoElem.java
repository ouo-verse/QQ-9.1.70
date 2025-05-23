package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProVideoElem implements Serializable {
    long serialVersionUID = 1;
    public GProStVideo video = new GProStVideo();

    public GProStVideo getVideo() {
        return this.video;
    }

    public String toString() {
        return "GProVideoElem{video=" + this.video + ",}";
    }
}
