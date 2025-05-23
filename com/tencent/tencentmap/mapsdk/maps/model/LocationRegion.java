package com.tencent.tencentmap.mapsdk.maps.model;

import android.location.Location;

/* compiled from: P */
/* loaded from: classes26.dex */
public class LocationRegion {
    public RegionName regionName;
    public Location target;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface LocationRegionChangedListener {
        void onLocationRegionChanged(LocationRegion locationRegion, LocationRegion locationRegion2);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum RegionName {
        EARTH,
        TAIWAN_OF_CHINA,
        INLAND_WITHOUT_SAR_OF_CHINA,
        OUT_OF_CHINA
    }
}
