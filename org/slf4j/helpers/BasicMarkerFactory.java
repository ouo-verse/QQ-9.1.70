package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.IMarkerFactory;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BasicMarkerFactory implements IMarkerFactory {
    private final ConcurrentMap<String, Marker> markerMap = new ConcurrentHashMap();

    @Override // org.slf4j.IMarkerFactory
    public boolean detachMarker(String str) {
        if (str == null || this.markerMap.remove(str) == null) {
            return false;
        }
        return true;
    }

    @Override // org.slf4j.IMarkerFactory
    public boolean exists(String str) {
        if (str == null) {
            return false;
        }
        return this.markerMap.containsKey(str);
    }

    @Override // org.slf4j.IMarkerFactory
    public Marker getDetachedMarker(String str) {
        return new BasicMarker(str);
    }

    @Override // org.slf4j.IMarkerFactory
    public Marker getMarker(String str) {
        if (str != null) {
            Marker marker = this.markerMap.get(str);
            if (marker == null) {
                BasicMarker basicMarker = new BasicMarker(str);
                Marker putIfAbsent = this.markerMap.putIfAbsent(str, basicMarker);
                if (putIfAbsent != null) {
                    return putIfAbsent;
                }
                return basicMarker;
            }
            return marker;
        }
        throw new IllegalArgumentException("Marker name cannot be null");
    }
}
