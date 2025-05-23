package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import android.support.annotation.NonNull;
import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Arrays;

/* loaded from: classes16.dex */
public class PoiBean {
    public final AdInfo adInfo;
    public final LatLng latLng;
    public final Poi[] poiArray;

    public PoiBean(LatLng latLng, AdInfo adInfo, Poi[] poiArr) {
        this.latLng = latLng;
        this.poiArray = poiArr;
        this.adInfo = adInfo;
    }

    @NonNull
    public String toString() {
        return "PoiBean{latLng=" + this.latLng + ", poiList=" + Arrays.toString(this.poiArray) + ", adInfo=" + this.adInfo + '}';
    }
}
