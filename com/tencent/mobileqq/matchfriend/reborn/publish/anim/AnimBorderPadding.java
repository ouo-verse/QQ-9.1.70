package com.tencent.mobileqq.matchfriend.reborn.publish.anim;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "top", "b", "left", "c", "right", "bottom", "<init>", "(IIII)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.publish.anim.a, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class AnimBorderPadding {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int top;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int left;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int right;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int bottom;

    public AnimBorderPadding() {
        this(0, 0, 0, 0, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getBottom() {
        return this.bottom;
    }

    /* renamed from: b, reason: from getter */
    public final int getLeft() {
        return this.left;
    }

    /* renamed from: c, reason: from getter */
    public final int getRight() {
        return this.right;
    }

    /* renamed from: d, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    public int hashCode() {
        return (((((this.top * 31) + this.left) * 31) + this.right) * 31) + this.bottom;
    }

    public String toString() {
        return "AnimBorderPadding(top=" + this.top + ", left=" + this.left + ", right=" + this.right + ", bottom=" + this.bottom + ")";
    }

    public AnimBorderPadding(int i3, int i16, int i17, int i18) {
        this.top = i3;
        this.left = i16;
        this.right = i17;
        this.bottom = i18;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimBorderPadding)) {
            return false;
        }
        AnimBorderPadding animBorderPadding = (AnimBorderPadding) other;
        return this.top == animBorderPadding.top && this.left == animBorderPadding.left && this.right == animBorderPadding.right && this.bottom == animBorderPadding.bottom;
    }

    public /* synthetic */ AnimBorderPadding(int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) != 0 ? 0 : i18);
    }
}
