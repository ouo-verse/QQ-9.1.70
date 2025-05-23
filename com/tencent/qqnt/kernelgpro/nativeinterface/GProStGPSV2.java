package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStGPSV2 implements Serializable {
    public long alt;
    public long eType;
    public long lat;
    public long lon;
    long serialVersionUID = 1;

    public long getAlt() {
        return this.alt;
    }

    public long getEType() {
        return this.eType;
    }

    public long getLat() {
        return this.lat;
    }

    public long getLon() {
        return this.lon;
    }

    public String toString() {
        return "GProStGPSV2{lat=" + this.lat + ",lon=" + this.lon + ",eType=" + this.eType + ",alt=" + this.alt + ",}";
    }
}
