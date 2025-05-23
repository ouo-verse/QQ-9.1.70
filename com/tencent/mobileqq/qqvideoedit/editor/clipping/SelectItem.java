package com.tencent.mobileqq.qqvideoedit.editor.clipping;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/b;", "T", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "id", "b", "I", "getType", "()I", "type", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/c;", "c", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/c;", "getTimeRange", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/c;", "timeRange", "d", "Ljava/lang/Object;", "getExtra", "()Ljava/lang/Object;", "extra", "<init>", "(Ljava/lang/String;ILcom/tencent/mobileqq/qqvideoedit/editor/clipping/c;Ljava/lang/Object;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqvideoedit.editor.clipping.b, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class SelectItem<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TimelineTimeRange timeRange;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final T extra;

    public SelectItem(@NotNull String id5, int i3, @NotNull TimelineTimeRange timeRange, T t16) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(timeRange, "timeRange");
        this.id = id5;
        this.type = i3;
        this.timeRange = timeRange;
        this.extra = t16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectItem)) {
            return false;
        }
        SelectItem selectItem = (SelectItem) other;
        if (Intrinsics.areEqual(this.id, selectItem.id) && this.type == selectItem.type && Intrinsics.areEqual(this.timeRange, selectItem.timeRange) && Intrinsics.areEqual(this.extra, selectItem.extra)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.id.hashCode() * 31) + this.type) * 31) + this.timeRange.hashCode()) * 31;
        T t16 = this.extra;
        if (t16 == null) {
            hashCode = 0;
        } else {
            hashCode = t16.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "SelectItem(id=" + this.id + ", type=" + this.type + ", timeRange=" + this.timeRange + ", extra=" + this.extra + ")";
    }
}
