package com.google.android.exoplayer2.text.ttml;

/* compiled from: P */
/* loaded from: classes2.dex */
final class TtmlRegion {

    /* renamed from: id, reason: collision with root package name */
    public final String f32952id;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final float width;

    public TtmlRegion(String str) {
        this(str, Float.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public TtmlRegion(String str, float f16, float f17, int i3, int i16, float f18) {
        this.f32952id = str;
        this.position = f16;
        this.line = f17;
        this.lineType = i3;
        this.lineAnchor = i16;
        this.width = f18;
    }
}
