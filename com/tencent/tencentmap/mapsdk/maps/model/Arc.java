package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Colorable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Visible;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Widthable;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface Arc extends Colorable, Levelable, Removable, Strokeable, Visible, Widthable, IOverlay {
    LatLng getCenter();

    double getLength();

    double getRadius();
}
