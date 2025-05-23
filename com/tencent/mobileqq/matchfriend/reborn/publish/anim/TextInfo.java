package com.tencent.mobileqq.matchfriend.reborn.publish.anim;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/o;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "textHeight", "c", "textWidth", "", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "textContent", "<init>", "(IILjava/lang/CharSequence;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.publish.anim.o, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class TextInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int textHeight;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int textWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final CharSequence textContent;

    public TextInfo() {
        this(0, 0, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final CharSequence getTextContent() {
        return this.textContent;
    }

    /* renamed from: b, reason: from getter */
    public final int getTextHeight() {
        return this.textHeight;
    }

    /* renamed from: c, reason: from getter */
    public final int getTextWidth() {
        return this.textWidth;
    }

    public int hashCode() {
        int i3 = ((this.textHeight * 31) + this.textWidth) * 31;
        CharSequence charSequence = this.textContent;
        return i3 + (charSequence == null ? 0 : charSequence.hashCode());
    }

    public String toString() {
        return "TextInfo(textHeight=" + this.textHeight + ", textWidth=" + this.textWidth + ", textContent=" + ((Object) this.textContent) + ")";
    }

    public TextInfo(int i3, int i16, CharSequence charSequence) {
        this.textHeight = i3;
        this.textWidth = i16;
        this.textContent = charSequence;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextInfo)) {
            return false;
        }
        TextInfo textInfo = (TextInfo) other;
        return this.textHeight == textInfo.textHeight && this.textWidth == textInfo.textWidth && Intrinsics.areEqual(this.textContent, textInfo.textContent);
    }

    public /* synthetic */ TextInfo(int i3, int i16, CharSequence charSequence, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0 : i16, (i17 & 4) != 0 ? null : charSequence);
    }
}
