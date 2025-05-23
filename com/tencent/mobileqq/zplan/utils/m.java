package com.tencent.mobileqq.zplan.utils;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a8\u0006\u0004"}, d2 = {"T", "", "Lorg/json/JSONArray;", "a", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class m {
    public static final <T> JSONArray a(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        JSONArray jSONArray = new JSONArray();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next());
        }
        return jSONArray;
    }
}
