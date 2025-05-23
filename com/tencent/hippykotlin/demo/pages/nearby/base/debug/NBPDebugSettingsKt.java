package com.tencent.hippykotlin.demo.pages.nearby.base.debug;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import n25.k;

/* loaded from: classes31.dex */
public final class NBPDebugSettingsKt {
    public static final NBPSsoLocation toNBPSsoLocation(k kVar) {
        NBPLatLng nBPLatLng;
        if (kVar.C != null) {
            double d16 = 1000000;
            nBPLatLng = new NBPLatLng(r0.f418079d / d16, r0.f418080e / d16);
        } else {
            nBPLatLng = null;
        }
        NBPSsoLocation nBPSsoLocation = new NBPSsoLocation();
        nBPSsoLocation.lat02 = nBPLatLng != null ? nBPLatLng.latitude : 0.0d;
        nBPSsoLocation.lon02 = nBPLatLng != null ? nBPLatLng.longitude : 0.0d;
        nBPSsoLocation.name = kVar.f418087e;
        nBPSsoLocation.address = kVar.f418090i;
        nBPSsoLocation.city = kVar.I;
        nBPSsoLocation.province = kVar.H;
        nBPSsoLocation.nation = kVar.G;
        nBPSsoLocation.district = kVar.M;
        return nBPSsoLocation;
    }
}
