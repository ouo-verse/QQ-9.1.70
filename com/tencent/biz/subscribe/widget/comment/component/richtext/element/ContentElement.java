package com.tencent.biz.subscribe.widget.comment.component.richtext.element;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ContentElement extends RichTextElement {
    public static final Parcelable.Creator<ContentElement> CREATOR = new a();

    /* renamed from: h, reason: collision with root package name */
    public String f96470h;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements Parcelable.Creator<ContentElement> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContentElement createFromParcel(Parcel parcel) {
            return new ContentElement();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ContentElement[] newArray(int i3) {
            return new ContentElement[i3];
        }
    }

    public ContentElement() {
        super(4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ContentElement [content=" + this.f96470h + ", startPosition=" + this.f96472e + ", endPosition=" + this.f96473f + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
    }
}
