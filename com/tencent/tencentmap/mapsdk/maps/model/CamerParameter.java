package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Point;
import java.util.List;

/* loaded from: classes26.dex */
public final class CamerParameter {
    public static int NEWCAMER_POSITION = 6;
    public static int NEWLATLNG = 7;
    public static int NEWLATLNG_BOUNDS = 9;
    public static int NEWLATLNG_BOUNDS_DIMENSION = 10;
    public static int NEWLATLNG_BOUNDS_RECT = 11;
    public static int NEWLATLNG_ZOOM = 8;
    public static int NEW_ELEMENTS_BOUNDS_RECT = 13;
    public static int ROTATETO = 12;
    public static int SCROLLBY = 2;
    public static int ZOOMBY = 4;
    public static int ZOOMBY_POINT = 5;
    public static int ZOOMIN = 0;
    public static int ZOOMOUT = 1;
    public static int ZOOMTO = 3;
    public List<IOverlay> elements;
    public int iCamerType = -1;
    public float scrollBy_xPixel = 0.0f;
    public float scrollBy_yPixel = 0.0f;
    public float zoomTo_zoom = 0.0f;
    public float zoomBy_amount = 0.0f;
    public float zoomBy_Point_amount = 0.0f;
    public Point zoomBy_Point_focus = null;
    public CameraPosition newCameraPosition_cameraPosition = null;
    public LatLng newLatLng_latLng = null;
    public LatLng newLatLngZoom_latLng = null;
    public float newLatLngZoom_zoom = 0.0f;
    public LatLngBounds newLatLngBounds_bounds = null;
    public int newLatLngBounds_padding = 0;
    public LatLngBounds newLatLngBounds_dimension_bounds = null;
    public int newLatLngBounds_dimension_width = 0;
    public int newLatLngBounds_dimension_height = 0;
    public int newLatLngBounds_dimension_padding = 0;
    public int newLatLngBoundsRects_padLeft = 0;
    public int newLatLngBoundsRects_padRight = 0;
    public int newLatLngBoundsRects_padTop = 0;
    public int newLatLngBoundsRects_padBom = 0;
    public float rotateto_rotate = 0.0f;
    public float rotateto_skew = 0.0f;

    public final String toString() {
        return "CamerParameter{iCamerType=" + this.iCamerType + ", scrollBy_xPixel=" + this.scrollBy_xPixel + ", scrollBy_yPixel=" + this.scrollBy_yPixel + ", zoomTo_zoom=" + this.zoomTo_zoom + ", zoomBy_amount=" + this.zoomBy_amount + ", zoomBy_Point_amount=" + this.zoomBy_Point_amount + ", zoomBy_Point_focus=" + this.zoomBy_Point_focus + ", newCameraPosition_cameraPosition=" + this.newCameraPosition_cameraPosition + ", newLatLng_latLng=" + this.newLatLng_latLng + ", newLatLngZoom_latLng=" + this.newLatLngZoom_latLng + ", newLatLngZoom_zoom=" + this.newLatLngZoom_zoom + ", newLatLngBounds_bounds=" + this.newLatLngBounds_bounds + ", newLatLngBounds_padding=" + this.newLatLngBounds_padding + ", newLatLngBounds_dimension_bounds=" + this.newLatLngBounds_dimension_bounds + ", newLatLngBounds_dimension_width=" + this.newLatLngBounds_dimension_width + ", newLatLngBounds_dimension_height=" + this.newLatLngBounds_dimension_height + ", newLatLngBounds_dimension_padding=" + this.newLatLngBounds_dimension_padding + ", newLatLngBoundsRects_padLeft=" + this.newLatLngBoundsRects_padLeft + ", newLatLngBoundsRects_padRight=" + this.newLatLngBoundsRects_padRight + ", newLatLngBoundsRects_padTop=" + this.newLatLngBoundsRects_padTop + ", newLatLngBoundsRects_padBom=" + this.newLatLngBoundsRects_padBom + ", rotateto_rotate=" + this.rotateto_rotate + ", rotateto_skew=" + this.rotateto_skew + ", elements=" + this.elements + '}';
    }
}
