package com.tencent.qzonehub.api.impl;

import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qzonehub.api.ISosoUtils;
import cooperation.qzone.LbsDataV2;

/* compiled from: P */
/* loaded from: classes34.dex */
public class SosoUtilsImpl implements ISosoUtils {
    @Override // com.tencent.qzonehub.api.ISosoUtils
    public LbsDataV2.GpsInfo convertFromSoso(SosoLocation sosoLocation) {
        if (sosoLocation == null) {
            return null;
        }
        LbsDataV2.GpsInfo gpsInfo = new LbsDataV2.GpsInfo();
        gpsInfo.accuracy = (int) sosoLocation.accuracy;
        gpsInfo.alt = (int) sosoLocation.altitude;
        double d16 = sosoLocation.mLon84;
        if (d16 == 0.0d && sosoLocation.mLat84 == 0.0d) {
            gpsInfo.gpsType = 1;
            gpsInfo.lat = (int) (sosoLocation.mLat02 * 1000000.0d);
            gpsInfo.lon = (int) (sosoLocation.mLon02 * 1000000.0d);
        } else {
            gpsInfo.gpsType = 0;
            gpsInfo.lat = (int) (sosoLocation.mLat84 * 1000000.0d);
            gpsInfo.lon = (int) (d16 * 1000000.0d);
        }
        return gpsInfo;
    }
}
