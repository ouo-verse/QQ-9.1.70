package org.libpag;

/* loaded from: classes29.dex */
public class PAGTextLayer extends PAGLayer {
    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    public PAGTextLayer(long j3) {
        super(j3);
    }

    private static native void nativeInit();

    private native void setFont(String str, String str2);

    public native int fillColor();

    public native PAGFont font();

    public native float fontSize();

    public native void reset();

    public native void setFillColor(int i3);

    public void setFont(PAGFont pAGFont) {
        setFont(pAGFont.fontFamily, pAGFont.fontStyle);
    }

    public native void setFontSize(float f16);

    public native void setStrokeColor(int i3);

    public native void setText(String str);

    public native int strokeColor();

    public native String text();
}
