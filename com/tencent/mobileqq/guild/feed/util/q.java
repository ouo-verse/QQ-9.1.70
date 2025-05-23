package com.tencent.mobileqq.guild.feed.util;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\u00020\b2\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/q;", "", "", "", "items", "", "batchSize", "columnName", "Lcom/tencent/mobileqq/guild/feed/util/q$a;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f223921a = new q();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0014\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n0\t\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R%\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/q$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "paramArrays", "conditions", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.util.q$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class BatchQueryParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<String[]> paramArrays;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<String> conditions;

        public BatchQueryParams(@NotNull List<String[]> paramArrays, @NotNull List<String> conditions) {
            Intrinsics.checkNotNullParameter(paramArrays, "paramArrays");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            this.paramArrays = paramArrays;
            this.conditions = conditions;
        }

        @NotNull
        public final List<String> a() {
            return this.conditions;
        }

        @NotNull
        public final List<String[]> b() {
            return this.paramArrays;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BatchQueryParams)) {
                return false;
            }
            BatchQueryParams batchQueryParams = (BatchQueryParams) other;
            if (Intrinsics.areEqual(this.paramArrays, batchQueryParams.paramArrays) && Intrinsics.areEqual(this.conditions, batchQueryParams.conditions)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.paramArrays.hashCode() * 31) + this.conditions.hashCode();
        }

        @NotNull
        public String toString() {
            return "BatchQueryParams(paramArrays=" + this.paramArrays + ", conditions=" + this.conditions + ")";
        }
    }

    q() {
    }

    @NotNull
    public final BatchQueryParams a(@Nullable List<String> items, int batchSize, @Nullable String columnName) {
        boolean z16;
        List emptyList;
        List emptyList2;
        List<String> list = items;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return new BatchQueryParams(emptyList, emptyList2);
        }
        ArrayList<String[]> arrayList = new ArrayList();
        int size = items.size();
        int i3 = 0;
        while (i3 < size) {
            int i16 = i3 + batchSize;
            Object[] array = items.subList(i3, (int) Math.min(i16, size)).toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            arrayList.add(array);
            i3 = i16;
        }
        ArrayList arrayList2 = new ArrayList();
        for (String[] strArr : arrayList) {
            StringBuilder sb5 = new StringBuilder();
            int length = strArr.length;
            for (int i17 = 0; i17 < length; i17++) {
                if (i17 > 0) {
                    sb5.append(" OR ");
                }
                sb5.append(columnName);
                sb5.append(" = ?");
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "condition.toString()");
            arrayList2.add(sb6);
        }
        return new BatchQueryParams(arrayList, arrayList2);
    }
}
