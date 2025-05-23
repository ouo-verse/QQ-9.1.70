package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/n;", "", "", "start", "end", "a", "", "toString", "hashCode", "other", "", "equals", "I", "c", "()I", "b", "<init>", "(II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.n, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class SelectionInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int start;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int end;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SelectionInfo() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    @NotNull
    public final SelectionInfo a(int start, int end) {
        return new SelectionInfo(start, end);
    }

    /* renamed from: b, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    /* renamed from: c, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectionInfo)) {
            return false;
        }
        SelectionInfo selectionInfo = (SelectionInfo) other;
        if (this.start == selectionInfo.start && this.end == selectionInfo.end) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.start * 31) + this.end;
    }

    @NotNull
    public String toString() {
        return "SelectionInfo(start=" + this.start + ", end=" + this.end + ")";
    }

    public SelectionInfo(int i3, int i16) {
        this.start = i3;
        this.end = i16;
    }

    public /* synthetic */ SelectionInfo(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? -1 : i3, (i17 & 2) != 0 ? -1 : i16);
    }
}
