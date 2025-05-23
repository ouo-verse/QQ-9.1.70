package org.libpag;

import java.nio.ByteBuffer;

/* loaded from: classes29.dex */
public class PAGComposition extends PAGLayer {
    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    public PAGComposition(long j3) {
        super(j3);
    }

    public static native PAGComposition Make(int i3, int i16);

    private static native void nativeInit();

    public native void addLayer(PAGLayer pAGLayer);

    public native void addLayerAt(PAGLayer pAGLayer, int i3);

    public native ByteBuffer audioBytes();

    public native PAGMarker[] audioMarkers();

    public native long audioStartTime();

    public native boolean contains(PAGLayer pAGLayer);

    public native PAGLayer getLayerAt(int i3);

    public native int getLayerIndex(PAGLayer pAGLayer);

    public native PAGLayer[] getLayersByName(String str);

    public native PAGLayer[] getLayersUnderPoint(float f16, float f17);

    public native int height();

    public native int numChildren();

    public native void removeAllLayers();

    public native PAGLayer removeLayer(PAGLayer pAGLayer);

    public native PAGLayer removeLayerAt(int i3);

    public native void setContentSize(int i3, int i16);

    public native void setLayerIndex(PAGLayer pAGLayer, int i3);

    public native void swapLayer(PAGLayer pAGLayer, PAGLayer pAGLayer2);

    public native void swapLayerAt(int i3, int i16);

    public native int width();
}
