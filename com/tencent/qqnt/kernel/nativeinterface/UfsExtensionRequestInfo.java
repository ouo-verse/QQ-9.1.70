package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsExtensionRequestInfo {
    public int adcode;
    public int keyWordSrc;
    public float latitude;
    public float longitude;
    public int radius;
    public boolean studyMode;
    public byte[] action = new byte[0];
    public byte[] city = new byte[0];
    public byte[] region = new byte[0];
    public ArrayList<Long> pubaccLocalResultList = new ArrayList<>();
    public byte[] traceId = new byte[0];
    public String lbs = "";

    public byte[] getAction() {
        return this.action;
    }

    public int getAdcode() {
        return this.adcode;
    }

    public byte[] getCity() {
        return this.city;
    }

    public int getKeyWordSrc() {
        return this.keyWordSrc;
    }

    public float getLatitude() {
        return this.latitude;
    }

    public String getLbs() {
        return this.lbs;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public ArrayList<Long> getPubaccLocalResultList() {
        return this.pubaccLocalResultList;
    }

    public int getRadius() {
        return this.radius;
    }

    public byte[] getRegion() {
        return this.region;
    }

    public boolean getStudyMode() {
        return this.studyMode;
    }

    public byte[] getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "UfsExtensionRequestInfo{action=" + this.action + ",latitude=" + this.latitude + ",longitude=" + this.longitude + ",radius=" + this.radius + ",city=" + this.city + ",region=" + this.region + ",keyWordSrc=" + this.keyWordSrc + ",pubaccLocalResultList=" + this.pubaccLocalResultList + ",adcode=" + this.adcode + ",traceId=" + this.traceId + ",lbs=" + this.lbs + ",studyMode=" + this.studyMode + ",}";
    }
}
