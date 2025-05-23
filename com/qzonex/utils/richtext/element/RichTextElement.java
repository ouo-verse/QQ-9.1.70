package com.qzonex.utils.richtext.element;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class RichTextElement implements Comparable<RichTextElement>, SmartParcelable {
    public static final int RICH_TEXT_ELEMENT_AT = 5;
    public static final int RICH_TEXT_ELEMENT_COLOR = 8;
    public static final int RICH_TEXT_ELEMENT_COMMENT = 7;
    public static final int RICH_TEXT_ELEMENT_CONTENT = 4;
    public static final int RICH_TEXT_ELEMENT_CUSTOM_URL = 6;
    public static final int RICH_TEXT_ELEMENT_HIGHLIGHT = 9;
    public static final int RICH_TEXT_ELEMENT_LOCAL_SMILEY = 2;
    public static final int RICH_TEXT_ELEMENT_NET_SMILEY = 3;
    public static final int RICH_TEXT_ELEMENT_NICK_NAME = 1;

    @NeedParcel
    public int endPosition;
    public int offset;

    @NeedParcel
    public int startPosition;

    @NeedParcel
    protected int type;

    public RichTextElement() {
    }

    public int getType() {
        return this.type;
    }

    public int replace(StringBuilder sb5, int i3) {
        return 0;
    }

    public RichTextElement(int i3) {
        this.type = i3;
    }

    @Override // java.lang.Comparable
    public int compareTo(RichTextElement richTextElement) {
        if (richTextElement == null) {
            return 1;
        }
        return this.startPosition - richTextElement.startPosition;
    }
}
