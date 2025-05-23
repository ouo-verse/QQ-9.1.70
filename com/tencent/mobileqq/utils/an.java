package com.tencent.mobileqq.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0007"}, d2 = {"", "", com.tencent.luggage.wxa.c8.c.E, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "a", "qq_audio_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class an {
    @NotNull
    public static final ArrayList<Byte> a(@NotNull int[] iArr, int i3) {
        List slice;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        slice = ArraysKt___ArraysKt.slice(iArr, new IntRange(0, i3));
        List list = slice;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) ((Number) it.next()).intValue()));
        }
        return new ArrayList<>(arrayList);
    }
}
