package com.google.android.exoplayer2.text;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class CaptionStyleCompat {
    public static final CaptionStyleCompat DEFAULT = new CaptionStyleCompat(-1, -16777216, 0, 0, -1, null);
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int USE_TRACK_COLOR_SETTINGS = 1;
    public final int backgroundColor;
    public final int edgeColor;
    public final int edgeType;
    public final int foregroundColor;
    public final Typeface typeface;
    public final int windowColor;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface EdgeType {
    }

    public CaptionStyleCompat(int i3, int i16, int i17, int i18, int i19, Typeface typeface) {
        this.foregroundColor = i3;
        this.backgroundColor = i16;
        this.windowColor = i17;
        this.edgeType = i18;
        this.edgeColor = i19;
        this.typeface = typeface;
    }

    @TargetApi(19)
    public static CaptionStyleCompat createFromCaptionStyle(CaptioningManager.CaptionStyle captionStyle) {
        if (Util.SDK_INT >= 21) {
            return createFromCaptionStyleV21(captionStyle);
        }
        return createFromCaptionStyleV19(captionStyle);
    }

    @TargetApi(19)
    private static CaptionStyleCompat createFromCaptionStyleV19(CaptioningManager.CaptionStyle captionStyle) {
        return new CaptionStyleCompat(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @TargetApi(21)
    private static CaptionStyleCompat createFromCaptionStyleV21(CaptioningManager.CaptionStyle captionStyle) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        if (captionStyle.hasForegroundColor()) {
            i3 = captionStyle.foregroundColor;
        } else {
            i3 = DEFAULT.foregroundColor;
        }
        int i26 = i3;
        if (captionStyle.hasBackgroundColor()) {
            i16 = captionStyle.backgroundColor;
        } else {
            i16 = DEFAULT.backgroundColor;
        }
        int i27 = i16;
        if (captionStyle.hasWindowColor()) {
            i17 = captionStyle.windowColor;
        } else {
            i17 = DEFAULT.windowColor;
        }
        int i28 = i17;
        if (captionStyle.hasEdgeType()) {
            i18 = captionStyle.edgeType;
        } else {
            i18 = DEFAULT.edgeType;
        }
        int i29 = i18;
        if (captionStyle.hasEdgeColor()) {
            i19 = captionStyle.edgeColor;
        } else {
            i19 = DEFAULT.edgeColor;
        }
        return new CaptionStyleCompat(i26, i27, i28, i29, i19, captionStyle.getTypeface());
    }
}
