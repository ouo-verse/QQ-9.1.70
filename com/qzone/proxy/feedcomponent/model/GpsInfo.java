package com.qzone.proxy.feedcomponent.model;

import LBS_V2_PROTOCOL.GPS_V2;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GpsInfo implements SmartParcelable {

    @NeedParcel
    public int altitude;

    @NeedParcel
    public int gpsType;

    @NeedParcel
    public int latitude;

    @NeedParcel
    public int longtitude;

    public GpsInfo() {
    }

    public String toString() {
        return "lat: " + this.latitude + ",lon: " + this.longtitude + ",alt: " + this.altitude + ",gpsType: " + this.gpsType + " ";
    }

    public GpsInfo(int i3, int i16, int i17, int i18) {
        this.latitude = i3;
        this.longtitude = i16;
        this.altitude = i17;
        this.gpsType = i18;
    }

    public static GpsInfo fromGPSV2(GPS_V2 gps_v2) {
        if (gps_v2 == null) {
            return null;
        }
        return new GpsInfo(gps_v2.iLat, gps_v2.iLon, gps_v2.iAlt, gps_v2.eType);
    }
}
