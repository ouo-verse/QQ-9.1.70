package com.qzonex.utils.richtext.element;

import com.tencent.component.annotation.NeedParcel;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AtElement extends RichTextElement {

    @NeedParcel
    public String nickName;

    @NeedParcel
    public String uin;

    @NeedParcel
    public int who;

    @Override // com.qzonex.utils.richtext.element.RichTextElement
    public int replace(StringBuilder sb5, int i3) {
        int i16 = this.startPosition - i3;
        this.startPosition = i16;
        int i17 = this.endPosition - i3;
        this.endPosition = i17;
        if (i16 < 0) {
            return 0;
        }
        sb5.replace(i16, i17, this.nickName);
        this.endPosition = this.startPosition + this.nickName.length();
        return this.offset;
    }

    public String toString() {
        return "AtElement [who=" + this.who + ", uin=" + this.uin + ", nickName=" + this.nickName + ", startPosition=" + this.startPosition + ", endPosition=" + this.endPosition + "]";
    }

    public AtElement() {
        super(5);
    }
}
