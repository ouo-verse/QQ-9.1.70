package af4;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Laf4/c;", "", "other", "", "c", "", "toString", "hashCode", "", "", "equals", "d", "I", h.F, "()I", "adId", "", "Laf4/d;", "e", "Ljava/util/List;", "i", "()Ljava/util/List;", "items", "<init>", "(ILjava/util/List;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: af4.c, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class OperationData implements Comparable<OperationData> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int adId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<OperationItem> items;

    public OperationData() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull OperationData other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i3 = this.adId - other.adId;
        if (i3 > 0) {
            return 1;
        }
        if (i3 < 0) {
            return -1;
        }
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperationData)) {
            return false;
        }
        OperationData operationData = (OperationData) other;
        if (this.adId == operationData.adId && Intrinsics.areEqual(this.items, operationData.items)) {
            return true;
        }
        return false;
    }

    /* renamed from: h, reason: from getter */
    public final int getAdId() {
        return this.adId;
    }

    public int hashCode() {
        return (this.adId * 31) + this.items.hashCode();
    }

    @NotNull
    public final List<OperationItem> i() {
        return this.items;
    }

    @NotNull
    public String toString() {
        return "OperationData(adId=" + this.adId + ", items=" + this.items + ")";
    }

    public OperationData(int i3, @NotNull List<OperationItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.adId = i3;
        this.items = items;
    }

    public /* synthetic */ OperationData(int i3, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? new ArrayList() : list);
    }
}
