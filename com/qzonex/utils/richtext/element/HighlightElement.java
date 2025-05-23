package com.qzonex.utils.richtext.element;

import com.tencent.component.annotation.NeedParcel;

/* compiled from: P */
/* loaded from: classes37.dex */
public class HighlightElement extends RichTextElement {

    @NeedParcel
    public String text;

    public HighlightElement() {
        this(9);
    }

    public String toString() {
        return "HighlightElement [text=" + this.text + ", startPosition=" + this.startPosition + ", endPosition=" + this.endPosition + "]";
    }

    public HighlightElement(int i3) {
        super(9);
    }
}
