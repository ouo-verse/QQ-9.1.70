package com.tencent.luggage.wxa.b8;

import java.util.Formatter;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static final String a(int i3) {
        StringBuilder sb5 = new StringBuilder();
        int i16 = i3 / 1000;
        sb5.setLength(0);
        String formatter = new Formatter(sb5, Locale.getDefault()).format("%02d:%02d:%02d", Integer.valueOf(i16 / 3600), Integer.valueOf((i16 / 60) % 60), Integer.valueOf(i16 % 60)).toString();
        Intrinsics.checkNotNullExpressionValue(formatter, "formatter.format(\"%02d:%\u2026utes, seconds).toString()");
        return formatter;
    }

    public static final long a(String str) {
        int lastIndexOf$default;
        List emptyList;
        int lastIndexOf$default2;
        String valueOf = String.valueOf(str);
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) valueOf, ".", 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) valueOf, ".", 0, false, 6, (Object) null);
            valueOf = valueOf.substring(0, lastIndexOf$default2);
            Intrinsics.checkNotNullExpressionValue(valueOf, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        List<String> split = new Regex(":").split(valueOf, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length == 3) {
            return ((Long.parseLong(strArr[0]) * 3600) + (Long.parseLong(strArr[1]) * 60) + Long.parseLong(strArr[2])) * 1000;
        }
        throw new IllegalArgumentException(("Can't parse time string: " + valueOf).toString());
    }
}
