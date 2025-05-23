package com.tencent.mapsdk.internal;

import android.util.Pair;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface ce extends Comparable<ce> {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum a {
        IDLE,
        WILL_ADD,
        WILL_UPDATE,
        WILL_REMOVE,
        PREPARING,
        ADD,
        SHOWING,
        REMOVE
    }

    String a();

    String a(boolean z16);

    void a(BitmapDescriptor bitmapDescriptor, boolean z16);

    boolean a(int i3, int i16);

    boolean a(a aVar);

    BitmapDescriptor b(boolean z16);

    LatLng b();

    int c();

    gg d();

    Pair<Integer, Integer> e();

    Pair<Float, Float> f();

    a g();
}
