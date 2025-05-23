package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes31.dex */
public final class ColorPick {
    public static final ColorPick INSTANCE = new ColorPick();
    public static final List<Long> colorList;

    static {
        List<Long> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Long[]{16745279L, 16747585L, 16749891L, 16751941L, 16754246L, 16756552L, 16758602L, 16760908L, 16763214L, 16765263L});
        colorList = listOf;
    }

    public final long getColor(int i3, int i16) {
        List chunked;
        Object last;
        Object first;
        Object first2;
        Object last2;
        Object first3;
        if (i3 == 0) {
            first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) colorList);
            return ((Number) first3).longValue();
        }
        int i17 = i16 - 1;
        if (i3 == i17) {
            last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) colorList);
            return ((Number) last2).longValue();
        }
        if (i3 >= i16) {
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) colorList);
            return ((Number) first2).longValue();
        }
        List<Long> list = colorList;
        int size = i3 % list.size();
        if (i16 > list.size()) {
            i17 = list.size() - 1;
        }
        int size2 = list.size();
        if (i17 == 0) {
            i17 = list.size();
        }
        chunked = CollectionsKt___CollectionsKt.chunked(list, size2 / i17);
        if (size < chunked.size()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) chunked.get(size));
            return ((Number) first).longValue();
        }
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
        return ((Number) last).longValue();
    }
}
