package com.tencent.kuikly.core.module;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0002\u001a\u00020\u0000*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"", "b", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class n {
    public static final Object a(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        return obj;
    }

    public static final Object b(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (!(obj instanceof List)) {
            return obj;
        }
        Object[] array = ((Collection) obj).toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
