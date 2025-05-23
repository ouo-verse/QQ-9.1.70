package org.slf4j;

import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticMarkerBinder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MarkerFactory {
    static IMarkerFactory MARKER_FACTORY;

    static {
        try {
            MARKER_FACTORY = bwCompatibleGetMarkerFactoryFromBinder();
        } catch (Exception e16) {
            Util.report("Unexpected failure while binding MarkerFactory", e16);
        } catch (NoClassDefFoundError unused) {
            MARKER_FACTORY = new BasicMarkerFactory();
        }
    }

    MarkerFactory() {
    }

    private static IMarkerFactory bwCompatibleGetMarkerFactoryFromBinder() throws NoClassDefFoundError {
        try {
            return StaticMarkerBinder.getSingleton().getMarkerFactory();
        } catch (NoSuchMethodError unused) {
            return StaticMarkerBinder.SINGLETON.getMarkerFactory();
        }
    }

    public static Marker getDetachedMarker(String str) {
        return MARKER_FACTORY.getDetachedMarker(str);
    }

    public static IMarkerFactory getIMarkerFactory() {
        return MARKER_FACTORY;
    }

    public static Marker getMarker(String str) {
        return MARKER_FACTORY.getMarker(str);
    }
}
