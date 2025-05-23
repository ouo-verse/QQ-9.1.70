package com.tencent.tencentmap.mapsdk.maps;

import android.location.Location;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface LocationSource {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnLocationChangedListener {
        void onLocationChanged(Location location);
    }

    void activate(OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
