package com.etrump.mixlayout;

import com.etrump.mixlayout.api.IETSegment;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ETSegment implements IETSegment {
    public static final int ET_SEGMENT_TYPE_EMOJI = 1;
    public static final int ET_SEGMENT_TYPE_IMAGE = 2;
    public static final int ET_SEGMENT_TYPE_TEXT = 0;
    public int codePoint = -1;
    public int lineNum;
    public int textLength;
    public int textOffset;
    public int textSize;
    public int type;

    /* renamed from: x, reason: collision with root package name */
    public int f32603x;

    /* renamed from: y, reason: collision with root package name */
    public int f32604y;

    @Override // com.etrump.mixlayout.api.IETSegment
    public int getCodePoint() {
        return this.codePoint;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public int getLineNum() {
        return this.lineNum;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public int getTextLength() {
        return this.textLength;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public int getTextOffset() {
        return this.textOffset;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public int getTextSize() {
        return this.textSize;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public int getType() {
        return this.type;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public int getX() {
        return this.f32603x;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public int getY() {
        return this.f32604y;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public void setCodePoint(int i3) {
        this.codePoint = i3;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public void setLineNum(int i3) {
        this.lineNum = i3;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public void setTextLength(int i3) {
        this.textLength = i3;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public void setTextOffset(int i3) {
        this.textOffset = i3;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public void setTextSize(int i3) {
        this.textSize = i3;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public void setType(int i3) {
        this.type = i3;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public void setX(int i3) {
        this.f32603x = i3;
    }

    @Override // com.etrump.mixlayout.api.IETSegment
    public void setY(int i3) {
        this.f32604y = i3;
    }
}
