package com.tencent.tencentmap.mapsdk.maps.model;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Accessible;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Anchorable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collisionable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Draggable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Rotatable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Scalable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Visible;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface Marker extends Accessible, Alphable, Anchorable, Animationable, Clickable, Collisionable, Draggable, Levelable, Removable, Rotatable, Scalable, Tagable<Object>, Visible, IOverlay {
    MarkerCollisionRelationUnit addCollisionUnit(MarkerOptions markerOptions);

    int getHeight(Context context);

    MarkerOptions getOptions();

    LatLng getPosition();

    String getSnippet();

    String getTitle();

    int getWidth(Context context);

    void hideInfoWindow();

    boolean isFastLoad();

    boolean isInfoWindowEnable();

    boolean isInfoWindowShown();

    void refreshInfoWindow();

    void removeCollisionUnit(MarkerCollisionRelationUnit markerCollisionRelationUnit);

    void setFastLoad(boolean z16);

    void setFixingPoint(int i3, int i16);

    void setFixingPointEnable(boolean z16);

    void setIcon(BitmapDescriptor bitmapDescriptor);

    void setIconLooper(BitmapDescriptor bitmapDescriptor, boolean z16, int i3);

    void setInfoWindowAnchor(float f16, float f17);

    void setInfoWindowEnable(boolean z16);

    void setInfoWindowOffset(int i3, int i16);

    void setOnTop();

    void setPosition(LatLng latLng);

    void setSnippet(String str);

    void setTitle(String str);

    void showInfoWindow();
}
