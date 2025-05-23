package com.airbnb.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class DocumentData {
    public float baselineShift;

    @ColorInt
    public int color;
    public String fontName;
    public Justification justification;
    public float lineHeight;
    public float size;

    @ColorInt
    public int strokeColor;
    public boolean strokeOverFill;
    public float strokeWidth;
    public String text;
    public int tracking;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f16, Justification justification, int i3, float f17, float f18, @ColorInt int i16, @ColorInt int i17, float f19, boolean z16) {
        set(str, str2, f16, justification, i3, f17, f18, i16, i17, f19, z16);
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.size)) * 31) + this.justification.ordinal()) * 31) + this.tracking;
        long floatToRawIntBits = Float.floatToRawIntBits(this.lineHeight);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.color;
    }

    public void set(String str, String str2, float f16, Justification justification, int i3, float f17, float f18, @ColorInt int i16, @ColorInt int i17, float f19, boolean z16) {
        this.text = str;
        this.fontName = str2;
        this.size = f16;
        this.justification = justification;
        this.tracking = i3;
        this.lineHeight = f17;
        this.baselineShift = f18;
        this.color = i16;
        this.strokeColor = i17;
        this.strokeWidth = f19;
        this.strokeOverFill = z16;
    }

    public DocumentData() {
    }
}
