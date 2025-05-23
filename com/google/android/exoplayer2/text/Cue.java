package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Cue {
    public static final int ANCHOR_TYPE_END = 2;
    public static final int ANCHOR_TYPE_MIDDLE = 1;
    public static final int ANCHOR_TYPE_START = 0;
    public static final float DIMEN_UNSET = Float.MIN_VALUE;
    public static final int LINE_TYPE_FRACTION = 0;
    public static final int LINE_TYPE_NUMBER = 1;
    public static final int TYPE_UNSET = Integer.MIN_VALUE;
    public final Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final int positionAnchor;
    public final float size;
    public final CharSequence text;
    public final Layout.Alignment textAlignment;
    public final int windowColor;
    public final boolean windowColorSet;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface AnchorType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface LineType {
    }

    public Cue(Bitmap bitmap, float f16, int i3, float f17, int i16, float f18, float f19) {
        this(null, null, bitmap, f17, 0, i16, f16, i3, f18, f19, false, -16777216);
    }

    public Cue(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f16, int i3, int i16, float f17, int i17, float f18) {
        this(charSequence, alignment, f16, i3, i16, f17, i17, f18, false, -16777216);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f16, int i3, int i16, float f17, int i17, float f18, boolean z16, int i18) {
        this(charSequence, alignment, null, f16, i3, i16, f17, i17, f18, Float.MIN_VALUE, z16, i18);
    }

    Cue(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f16, int i3, int i16, float f17, int i17, float f18, float f19, boolean z16, int i18) {
        this.text = charSequence;
        this.textAlignment = alignment;
        this.bitmap = bitmap;
        this.line = f16;
        this.lineType = i3;
        this.lineAnchor = i16;
        this.position = f17;
        this.positionAnchor = i17;
        this.size = f18;
        this.bitmapHeight = f19;
        this.windowColorSet = z16;
        this.windowColor = i18;
    }
}
