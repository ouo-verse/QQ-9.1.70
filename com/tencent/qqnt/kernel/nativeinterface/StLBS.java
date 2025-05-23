package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StLBS {
    public StGPS gps = new StGPS();
    public String location = "";
    public String lbsId = "";
    public String address = "";

    public String getAddress() {
        return this.address;
    }

    public StGPS getGps() {
        return this.gps;
    }

    public String getLbsId() {
        return this.lbsId;
    }

    public String getLocation() {
        return this.location;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setGps(StGPS stGPS) {
        this.gps = stGPS;
    }

    public void setLbsId(String str) {
        this.lbsId = str;
    }

    public void setLocation(String str) {
        this.location = str;
    }
}
