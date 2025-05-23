package com.qzonex.utils.richtext.element;

import com.tencent.component.annotation.NeedParcel;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ColorElement extends RichTextElement {

    @NeedParcel
    public int color;

    @NeedParcel
    public boolean isBold;

    @NeedParcel
    public String text;

    @NeedParcel
    public boolean useDefaultFont;

    @NeedParcel
    public boolean useLinkTextColor;

    @NeedParcel
    public boolean useSuperFont;

    public ColorElement() {
        this(8);
    }

    @Override // com.qzonex.utils.richtext.element.RichTextElement
    public int replace(StringBuilder sb5, int i3) {
        int i16 = this.startPosition - i3;
        this.startPosition = i16;
        int i17 = this.endPosition - i3;
        this.endPosition = i17;
        if (i16 < 0) {
            return 0;
        }
        sb5.replace(i16, i17, this.text);
        this.endPosition = this.startPosition + this.text.length();
        return this.offset;
    }

    public String toString() {
        return "ColorElement [text=" + this.text + ", color=" + this.color + ", startPosition=" + this.startPosition + ", endPosition=" + this.endPosition + "]";
    }

    public ColorElement(int i3) {
        super(i3);
        this.useDefaultFont = false;
        this.useSuperFont = true;
        this.useLinkTextColor = false;
        this.isBold = false;
    }
}
