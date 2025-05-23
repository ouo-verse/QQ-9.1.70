package com.etrump.mixlayout.api;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IETSegment {
    public static final int ET_SEGMENT_TYPE_EMOJI = 1;
    public static final int ET_SEGMENT_TYPE_IMAGE = 2;
    public static final int ET_SEGMENT_TYPE_TEXT = 0;

    int getCodePoint();

    int getLineNum();

    int getTextLength();

    int getTextOffset();

    int getTextSize();

    int getType();

    int getX();

    int getY();

    void setCodePoint(int i3);

    void setLineNum(int i3);

    void setTextLength(int i3);

    void setTextOffset(int i3);

    void setTextSize(int i3);

    void setType(int i3);

    void setX(int i3);

    void setY(int i3);
}
