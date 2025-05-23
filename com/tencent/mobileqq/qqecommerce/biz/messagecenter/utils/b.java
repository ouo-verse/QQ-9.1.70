package com.tencent.mobileqq.qqecommerce.biz.messagecenter.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a$\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a8\u0006\u0005"}, d2 = {"T", "", "other", "", "a", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b {
    public static final <T> boolean a(List<? extends T> list, List<? extends T> other) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (list.size() != other.size()) {
            return false;
        }
        int i3 = 0;
        for (T t16 : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (!Intrinsics.areEqual(t16, other.get(i3))) {
                return false;
            }
            i3 = i16;
        }
        return true;
    }
}
