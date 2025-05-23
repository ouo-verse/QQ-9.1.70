package org.libpag;

/* loaded from: classes29.dex */
public class PAGSolidLayer extends PAGLayer {
    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    public PAGSolidLayer(long j3) {
        super(j3);
    }

    private static native void nativeInit();

    public native void setSolidColor(int i3);

    public native int solidColor();
}
