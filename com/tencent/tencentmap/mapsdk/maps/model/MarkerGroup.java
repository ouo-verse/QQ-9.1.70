package com.tencent.tencentmap.mapsdk.maps.model;

import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface MarkerGroup {
    void addMarker(Marker marker);

    void addMarkerById(String str);

    void addMarkerList(List<Marker> list);

    void clear();

    boolean containMarker(Marker marker);

    boolean containMarkerById(String str);

    Marker findMarkerById(String str);

    String getId();

    List<String> getMarkerIdList();

    List<Marker> getMarkerList();

    boolean removeMarker(Marker marker);

    boolean removeMarkerById(String str);

    void setMarkerGroupOnTapMapBubblesHidden(boolean z16);

    void setMarkerGroupOnTapMapInfoWindowHidden(boolean z16);

    boolean setMarkerOnTapMapBubblesHidden(Marker marker, boolean z16);

    boolean setOnTapMapBubblesHiddenById(String str, boolean z16);

    boolean updateMarkerOptionById(String str, MarkerOptions markerOptions);
}
