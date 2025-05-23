package com.tencent.mobileqq.zplan.utils;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a3\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"T", "", "Lkotlin/Function1;", "", "predicate", "", "a", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Integer;", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class z {
    public static final <T> Integer a(List<? extends T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterator<? extends T> it = list.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (predicate.invoke(it.next()).booleanValue()) {
                break;
            }
            i3++;
        }
        if (i3 == -1) {
            return null;
        }
        return Integer.valueOf(i3);
    }
}
