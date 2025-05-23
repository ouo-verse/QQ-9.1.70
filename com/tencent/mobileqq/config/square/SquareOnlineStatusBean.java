package com.tencent.mobileqq.config.square;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/config/square/SquareOnlineStatusBean;", "Lcom/tencent/freesia/IConfigData;", "", "id", "", "a", "Lcom/tencent/mobileqq/config/square/b;", "b", "", "toString", "", "hashCode", "", "other", "equals", "", "squareStatus", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "d", "Lkotlin/Lazy;", "()Ljava/util/Map;", "statusMap", "<init>", "(Ljava/util/List;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class SquareOnlineStatusBean implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy statusMap;

    @SerializedName("square_status")
    @NotNull
    private final List<SquareOnlineStatusItem> squareStatus;

    public SquareOnlineStatusBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final Map<Long, SquareOnlineStatusItem> d() {
        return (Map) this.statusMap.getValue();
    }

    public final boolean a(long id5) {
        return d().containsKey(Long.valueOf(id5));
    }

    @Nullable
    public final SquareOnlineStatusItem b(long id5) {
        return d().get(Long.valueOf(id5));
    }

    @NotNull
    public final List<SquareOnlineStatusItem> c() {
        return this.squareStatus;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof SquareOnlineStatusBean) && Intrinsics.areEqual(this.squareStatus, ((SquareOnlineStatusBean) other).squareStatus)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.squareStatus.hashCode();
    }

    @NotNull
    public String toString() {
        return "SquareOnlineStatusBean(squareStatus=" + this.squareStatus + ")";
    }

    public SquareOnlineStatusBean(@NotNull List<SquareOnlineStatusItem> squareStatus) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(squareStatus, "squareStatus");
        this.squareStatus = squareStatus;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<Long, ? extends SquareOnlineStatusItem>>() { // from class: com.tencent.mobileqq.config.square.SquareOnlineStatusBean$statusMap$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<Long, ? extends SquareOnlineStatusItem> invoke() {
                int collectionSizeOrDefault;
                int mapCapacity;
                int coerceAtLeast;
                List<SquareOnlineStatusItem> c16 = SquareOnlineStatusBean.this.c();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (Object obj : c16) {
                    linkedHashMap.put(Long.valueOf(((SquareOnlineStatusItem) obj).getId()), obj);
                }
                return linkedHashMap;
            }
        });
        this.statusMap = lazy;
    }

    public /* synthetic */ SquareOnlineStatusBean(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
