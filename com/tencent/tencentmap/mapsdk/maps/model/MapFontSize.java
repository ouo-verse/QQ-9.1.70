package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public enum MapFontSize {
    tiny(0, 4),
    small(1, 3),
    normal(2, 0),
    large(3, 1),
    huge(4, 2);

    private int engineCode;
    private int fontSize;

    MapFontSize(int i3, int i16) {
        this.fontSize = i3;
        this.engineCode = i16;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final int getValue() {
        return this.engineCode;
    }
}
