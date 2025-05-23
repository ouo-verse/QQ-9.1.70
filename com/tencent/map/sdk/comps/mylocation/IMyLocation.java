package com.tencent.map.sdk.comps.mylocation;

import android.location.Location;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface IMyLocation {
    Location getMyLocation();

    boolean isMyLocationEnabled();

    void setLocationSource(LocationSource locationSource);

    void setMyLocationClickListener(TencentMap.OnMyLocationClickListener onMyLocationClickListener);

    void setMyLocationEnabled(boolean z16);

    void setMyLocationStyle(MyLocationStyle myLocationStyle);

    void setOnMyLocationChangeListener(TencentMap.OnMyLocationChangeListener onMyLocationChangeListener);
}
