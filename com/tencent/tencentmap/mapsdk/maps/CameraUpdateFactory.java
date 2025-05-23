package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.Point;
import com.tencent.tencentmap.mapsdk.maps.model.CamerParameter;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class CameraUpdateFactory {
    CameraUpdateFactory() {
    }

    private static LatLng getSymmetricPoint(LatLng latLng, LatLng latLng2) {
        return new LatLng((latLng.latitude * 2.0d) - latLng2.latitude, (latLng.longitude * 2.0d) - latLng2.longitude);
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.NEWCAMER_POSITION;
        camerParameter.newCameraPosition_cameraPosition = cameraPosition;
        return new CameraUpdate(camerParameter);
    }

    static CameraUpdate newElementBoundsRect(List<IOverlay> list, int i3, int i16, int i17, int i18) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.NEW_ELEMENTS_BOUNDS_RECT;
        camerParameter.elements = list;
        camerParameter.newLatLngBoundsRects_padLeft = i3;
        camerParameter.newLatLngBoundsRects_padRight = i16;
        camerParameter.newLatLngBoundsRects_padTop = i17;
        camerParameter.newLatLngBoundsRects_padBom = i18;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.NEWLATLNG;
        camerParameter.newLatLng_latLng = latLng;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i3) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.NEWLATLNG_BOUNDS;
        camerParameter.newLatLngBounds_bounds = latLngBounds;
        camerParameter.newLatLngBounds_padding = i3;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i3, int i16, int i17, int i18) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.NEWLATLNG_BOUNDS_RECT;
        camerParameter.newLatLngBounds_dimension_bounds = latLngBounds;
        camerParameter.newLatLngBoundsRects_padLeft = i3;
        camerParameter.newLatLngBoundsRects_padRight = i16;
        camerParameter.newLatLngBoundsRects_padTop = i17;
        camerParameter.newLatLngBoundsRects_padBom = i18;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newLatLngBoundsWithMapCenter(LatLngBounds latLngBounds, LatLng latLng, int i3) {
        if (latLngBounds == null) {
            return null;
        }
        LatLng latLng2 = latLngBounds.northeast;
        LatLng symmetricPoint = getSymmetricPoint(latLng, latLng2);
        LatLng latLng3 = latLngBounds.southwest;
        LatLng symmetricPoint2 = getSymmetricPoint(latLng, latLng3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(latLng2);
        arrayList.add(symmetricPoint);
        arrayList.add(latLng3);
        arrayList.add(symmetricPoint2);
        return newLatLngBounds(new LatLngBounds.Builder().include(arrayList).build(), i3);
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f16) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.NEWLATLNG_ZOOM;
        camerParameter.newLatLngZoom_latLng = latLng;
        camerParameter.newLatLngZoom_zoom = f16;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate rotateTo(float f16, float f17) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.ROTATETO;
        camerParameter.rotateto_rotate = f16;
        camerParameter.rotateto_skew = f17;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate scrollBy(float f16, float f17) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.SCROLLBY;
        camerParameter.scrollBy_xPixel = f16;
        camerParameter.scrollBy_yPixel = f17;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate zoomBy(float f16) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.ZOOMBY;
        camerParameter.zoomBy_amount = f16;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate zoomIn() {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.ZOOMIN;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate zoomOut() {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.ZOOMOUT;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate zoomTo(float f16) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.ZOOMTO;
        camerParameter.zoomTo_zoom = f16;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate zoomBy(float f16, Point point) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.ZOOMBY_POINT;
        camerParameter.zoomBy_Point_amount = f16;
        camerParameter.zoomBy_Point_focus = point;
        return new CameraUpdate(camerParameter);
    }
}
