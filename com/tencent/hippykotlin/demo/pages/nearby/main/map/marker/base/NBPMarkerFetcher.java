package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import java.util.ArrayList;

/* loaded from: classes31.dex */
public final class NBPMarkerFetcher {
    public String limitFrequencyTimeoutRef;
    public ArrayList<NBPLatLng> didFetchPositions = new ArrayList<>();
    public double validDistance = 1500.0d;
    public final int limitFrequencyTime = 500;
}
