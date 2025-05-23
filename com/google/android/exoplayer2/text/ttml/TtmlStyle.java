package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes2.dex */
final class TtmlStyle {
    public static final int FONT_SIZE_UNIT_EM = 2;
    public static final int FONT_SIZE_UNIT_PERCENT = 3;
    public static final int FONT_SIZE_UNIT_PIXEL = 1;
    private static final int OFF = 0;
    private static final int ON = 1;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_BOLD_ITALIC = 3;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int UNSPECIFIED = -1;
    private int backgroundColor;
    private int fontColor;
    private String fontFamily;
    private float fontSize;
    private boolean hasBackgroundColor;
    private boolean hasFontColor;

    /* renamed from: id, reason: collision with root package name */
    private String f32953id;
    private TtmlStyle inheritableStyle;
    private Layout.Alignment textAlign;
    private int linethrough = -1;
    private int underline = -1;
    private int bold = -1;
    private int italic = -1;
    private int fontSizeUnit = -1;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface FontSizeUnit {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface StyleFlags {
    }

    public TtmlStyle chain(TtmlStyle ttmlStyle) {
        return inherit(ttmlStyle, true);
    }

    public int getBackgroundColor() {
        if (this.hasBackgroundColor) {
            return this.backgroundColor;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int getFontColor() {
        if (this.hasFontColor) {
            return this.fontColor;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String getFontFamily() {
        return this.fontFamily;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public int getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    public String getId() {
        return this.f32953id;
    }

    public int getStyle() {
        int i3;
        int i16 = this.bold;
        if (i16 == -1 && this.italic == -1) {
            return -1;
        }
        int i17 = 0;
        if (i16 == 1) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (this.italic == 1) {
            i17 = 2;
        }
        return i3 | i17;
    }

    public Layout.Alignment getTextAlign() {
        return this.textAlign;
    }

    public boolean hasBackgroundColor() {
        return this.hasBackgroundColor;
    }

    public boolean hasFontColor() {
        return this.hasFontColor;
    }

    public TtmlStyle inherit(TtmlStyle ttmlStyle) {
        return inherit(ttmlStyle, false);
    }

    public boolean isLinethrough() {
        if (this.linethrough == 1) {
            return true;
        }
        return false;
    }

    public boolean isUnderline() {
        if (this.underline == 1) {
            return true;
        }
        return false;
    }

    public TtmlStyle setBackgroundColor(int i3) {
        this.backgroundColor = i3;
        this.hasBackgroundColor = true;
        return this;
    }

    public TtmlStyle setBold(boolean z16) {
        boolean z17;
        if (this.inheritableStyle == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        Assertions.checkState(z17);
        this.bold = z16 ? 1 : 0;
        return this;
    }

    public TtmlStyle setFontColor(int i3) {
        boolean z16;
        if (this.inheritableStyle == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        this.fontColor = i3;
        this.hasFontColor = true;
        return this;
    }

    public TtmlStyle setFontFamily(String str) {
        boolean z16;
        if (this.inheritableStyle == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        this.fontFamily = str;
        return this;
    }

    public TtmlStyle setFontSize(float f16) {
        this.fontSize = f16;
        return this;
    }

    public TtmlStyle setFontSizeUnit(int i3) {
        this.fontSizeUnit = i3;
        return this;
    }

    public TtmlStyle setId(String str) {
        this.f32953id = str;
        return this;
    }

    public TtmlStyle setItalic(boolean z16) {
        boolean z17;
        if (this.inheritableStyle == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        Assertions.checkState(z17);
        this.italic = z16 ? 1 : 0;
        return this;
    }

    public TtmlStyle setLinethrough(boolean z16) {
        boolean z17;
        if (this.inheritableStyle == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        Assertions.checkState(z17);
        this.linethrough = z16 ? 1 : 0;
        return this;
    }

    public TtmlStyle setTextAlign(Layout.Alignment alignment) {
        this.textAlign = alignment;
        return this;
    }

    public TtmlStyle setUnderline(boolean z16) {
        boolean z17;
        if (this.inheritableStyle == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        Assertions.checkState(z17);
        this.underline = z16 ? 1 : 0;
        return this;
    }

    private TtmlStyle inherit(TtmlStyle ttmlStyle, boolean z16) {
        if (ttmlStyle != null) {
            if (!this.hasFontColor && ttmlStyle.hasFontColor) {
                setFontColor(ttmlStyle.fontColor);
            }
            if (this.bold == -1) {
                this.bold = ttmlStyle.bold;
            }
            if (this.italic == -1) {
                this.italic = ttmlStyle.italic;
            }
            if (this.fontFamily == null) {
                this.fontFamily = ttmlStyle.fontFamily;
            }
            if (this.linethrough == -1) {
                this.linethrough = ttmlStyle.linethrough;
            }
            if (this.underline == -1) {
                this.underline = ttmlStyle.underline;
            }
            if (this.textAlign == null) {
                this.textAlign = ttmlStyle.textAlign;
            }
            if (this.fontSizeUnit == -1) {
                this.fontSizeUnit = ttmlStyle.fontSizeUnit;
                this.fontSize = ttmlStyle.fontSize;
            }
            if (z16 && !this.hasBackgroundColor && ttmlStyle.hasBackgroundColor) {
                setBackgroundColor(ttmlStyle.backgroundColor);
            }
        }
        return this;
    }
}
