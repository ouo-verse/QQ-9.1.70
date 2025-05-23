package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ReplyAbsElement {
    public ReplyAbsFaceElement faceElem;
    public ReplyAbsPicElement picElem;
    public int replyAbsElemType;
    public String textElemContent;

    public ReplyAbsElement() {
    }

    public ReplyAbsFaceElement getFaceElem() {
        return this.faceElem;
    }

    public ReplyAbsPicElement getPicElem() {
        return this.picElem;
    }

    public int getReplyAbsElemType() {
        return this.replyAbsElemType;
    }

    public String getTextElemContent() {
        return this.textElemContent;
    }

    public String toString() {
        return "ReplyAbsElement{replyAbsElemType=" + this.replyAbsElemType + ",textElemContent=" + this.textElemContent + ",faceElem=" + this.faceElem + ",picElem=" + this.picElem + ",}";
    }

    public ReplyAbsElement(int i3, String str, ReplyAbsFaceElement replyAbsFaceElement, ReplyAbsPicElement replyAbsPicElement) {
        this.replyAbsElemType = i3;
        this.textElemContent = str;
        this.faceElem = replyAbsFaceElement;
        this.picElem = replyAbsPicElement;
    }
}
