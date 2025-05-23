package com.tencent.mobileqq.qqvideoedit.editor.background.border;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u000f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/a;", "", "", "color", "width", "a", "", "toString", "hashCode", "other", "", "equals", "I", "b", "()I", "c", "<init>", "(II)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqvideoedit.editor.background.border.a, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class BorderStyle {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int color;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    public BorderStyle(int i3, int i16) {
        this.color = i3;
        this.width = i16;
    }

    @NotNull
    public final BorderStyle a(int color, int width) {
        return new BorderStyle(color, width);
    }

    /* renamed from: b, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* renamed from: c, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BorderStyle)) {
            return false;
        }
        BorderStyle borderStyle = (BorderStyle) other;
        if (this.color == borderStyle.color && this.width == borderStyle.width) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.color * 31) + this.width;
    }

    @NotNull
    public String toString() {
        return "BorderStyle(color=" + this.color + ", width=" + this.width + ")";
    }
}
