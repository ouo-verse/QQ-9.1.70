package com.tencent.qqmini.sdk.core.generated;

import com.tencent.qqmini.map.MapViewJsPlugin;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes23.dex */
public final class MapJsPluginScope {
    public static final Map EVENT_HANDLERS;

    static {
        HashMap hashMap = new HashMap();
        EVENT_HANDLERS = hashMap;
        hashMap.put("insertMap", MapViewJsPlugin.class);
        hashMap.put("updateMap", MapViewJsPlugin.class);
        hashMap.put("removeMap", MapViewJsPlugin.class);
        hashMap.put("addMapLines", MapViewJsPlugin.class);
        hashMap.put("addMapPolygons", MapViewJsPlugin.class);
        hashMap.put("addMapCircles", MapViewJsPlugin.class);
        hashMap.put("getMapCenterLocation", MapViewJsPlugin.class);
        hashMap.put("moveToMapLocation", MapViewJsPlugin.class);
        hashMap.put("translateMapMarker", MapViewJsPlugin.class);
        hashMap.put("includeMapPoints", MapViewJsPlugin.class);
        hashMap.put("getMapScale", MapViewJsPlugin.class);
        hashMap.put("getMapRegion", MapViewJsPlugin.class);
        hashMap.put("addMapMarkers", MapViewJsPlugin.class);
        hashMap.put("removeMapMarkers", MapViewJsPlugin.class);
        hashMap.put("addMapControls", MapViewJsPlugin.class);
        hashMap.put("getMapRotate", MapViewJsPlugin.class);
        hashMap.put("getMapSkew", MapViewJsPlugin.class);
    }
}
