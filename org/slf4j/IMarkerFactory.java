package org.slf4j;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface IMarkerFactory {
    boolean detachMarker(String str);

    boolean exists(String str);

    Marker getDetachedMarker(String str);

    Marker getMarker(String str);
}
