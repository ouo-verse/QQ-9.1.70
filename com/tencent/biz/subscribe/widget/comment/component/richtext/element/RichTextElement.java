package com.tencent.biz.subscribe.widget.comment.component.richtext.element;

import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class RichTextElement implements Comparable<RichTextElement>, Parcelable {

    /* renamed from: d, reason: collision with root package name */
    protected int f96471d;

    /* renamed from: e, reason: collision with root package name */
    public int f96472e;

    /* renamed from: f, reason: collision with root package name */
    public int f96473f;

    public RichTextElement(int i3) {
        this.f96471d = i3;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(RichTextElement richTextElement) {
        if (richTextElement == null) {
            return 1;
        }
        return this.f96472e - richTextElement.f96472e;
    }
}
