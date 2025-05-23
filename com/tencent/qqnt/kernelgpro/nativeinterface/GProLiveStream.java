package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProLiveStream implements Serializable {
    public String name;
    public Integer rawLevel;
    long serialVersionUID = 1;
    public ArrayList<GProLiveFrame> frames = new ArrayList<>();

    public ArrayList<GProLiveFrame> getFrames() {
        return this.frames;
    }

    public String getName() {
        return this.name;
    }

    public Integer getRawLevel() {
        return this.rawLevel;
    }

    public String toString() {
        return "GProLiveStream{frames=" + this.frames + ",name=" + this.name + ",rawLevel=" + this.rawLevel + ",}";
    }
}
