package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ReplyAbsFaceElement {
    public int faceIndex;
    public String faceText;
    public int faceType;

    public ReplyAbsFaceElement() {
    }

    public int getFaceIndex() {
        return this.faceIndex;
    }

    public String getFaceText() {
        return this.faceText;
    }

    public int getFaceType() {
        return this.faceType;
    }

    public String toString() {
        return "ReplyAbsFaceElement{faceIndex=" + this.faceIndex + ",faceText=" + this.faceText + ",faceType=" + this.faceType + ",}";
    }

    public ReplyAbsFaceElement(int i3, String str, int i16) {
        this.faceIndex = i3;
        this.faceText = str;
        this.faceType = i16;
    }
}
