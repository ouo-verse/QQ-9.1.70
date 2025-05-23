package com.qzonex.utils.richtext.element;

import com.tencent.component.annotation.NeedParcel;

/* compiled from: P */
/* loaded from: classes37.dex */
public class SmileyElement extends RichTextElement {

    @NeedParcel
    public int height;

    @NeedParcel
    public String smileyCode;

    @NeedParcel
    public int smileyIndex;

    @NeedParcel
    public String smileyUrl;

    @NeedParcel
    public int width;

    public SmileyElement(int i3) {
        super(i3);
        this.width = -1;
        this.height = -1;
    }

    public String toString() {
        return "SmileyElement [smileyCode=" + this.smileyCode + ", smileyIndex=" + this.smileyIndex + ", startPosition=" + this.startPosition + ", endPosition=" + this.endPosition + "]";
    }

    public SmileyElement() {
        this(2);
    }
}
