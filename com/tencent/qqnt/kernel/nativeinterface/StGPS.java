package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class StGPS {
    public long alt;
    public long eType;
    public long lat;
    public long lon;

    public StGPS() {
    }

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

    public void setAlt(long j3) {
        this.alt = j3;
    }

    public void setEType(long j3) {
        this.eType = j3;
    }

    public void setLat(long j3) {
        this.lat = j3;
    }

    public void setLon(long j3) {
        this.lon = j3;
    }

    public StGPS(long j3, long j16, long j17, long j18) {
        this.lat = j3;
        this.lon = j16;
        this.eType = j17;
        this.alt = j18;
    }
}
