package com.qzonex.utils.richtext.element;

import com.tencent.component.annotation.NeedParcel;

/* compiled from: P */
/* loaded from: classes37.dex */
public class CustomUrlElement extends RichTextElement {

    @NeedParcel
    public String post;

    @NeedParcel
    public String text;

    @NeedParcel
    public String url;

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
        return "CustomUrlElement [url=" + this.url + ", text=" + this.text + ", post=" + this.post + ", startPosition=" + this.startPosition + ", endPosition=" + this.endPosition + "]";
    }

    public CustomUrlElement() {
        super(6);
    }
}
