package com.qzonex.utils.richtext.element;

import com.tencent.component.annotation.NeedParcel;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ContentElement extends RichTextElement {

    @NeedParcel
    public String content;

    public String toString() {
        return "ContentElement [content=" + this.content + ", startPosition=" + this.startPosition + ", endPosition=" + this.endPosition + "]";
    }

    public ContentElement() {
        super(4);
    }
}
