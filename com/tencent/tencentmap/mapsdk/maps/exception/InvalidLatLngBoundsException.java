package com.tencent.tencentmap.mapsdk.maps.exception;

/* compiled from: P */
/* loaded from: classes26.dex */
public class InvalidLatLngBoundsException extends RuntimeException {
    public InvalidLatLngBoundsException(int i3) {
        super("Cannot create a LatLngBounds from " + i3 + " items");
    }
}
