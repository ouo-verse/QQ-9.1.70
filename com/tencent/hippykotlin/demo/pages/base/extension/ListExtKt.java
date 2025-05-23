package com.tencent.hippykotlin.demo.pages.base.extension;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ListExtKt {
    public static final <T> int findIndex(List<? extends T> list, Function1<? super T, Boolean> function1) {
        T t16;
        int indexOf;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t16 = null;
                break;
            }
            t16 = it.next();
            if (function1.invoke(t16).booleanValue()) {
                break;
            }
        }
        indexOf = CollectionsKt___CollectionsKt.indexOf((List) ((List<? extends Object>) list), (Object) t16);
        return indexOf;
    }

    public static final String join(List list) {
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                return next + "," + it.next();
            }
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
            return (String) next;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }
}
