package com.tencent.ecommerce.base.ktx;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a>\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a8\u0006\n"}, d2 = {"KEY", "VALUE", "", "", "size", "Lkotlin/Function1;", "", "", "eachChunkedString", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class g {
    public static final <KEY, VALUE> void a(Map<KEY, ? extends VALUE> map, int i3, Function1<? super String, Unit> function1) {
        List list;
        List chunked;
        String joinToString$default;
        list = MapsKt___MapsKt.toList(map);
        chunked = CollectionsKt___CollectionsKt.chunked(list, i3);
        Iterator it = chunked.iterator();
        while (it.hasNext()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default((List) it.next(), ",", null, null, 0, null, null, 62, null);
            function1.invoke(joinToString$default);
        }
    }
}
