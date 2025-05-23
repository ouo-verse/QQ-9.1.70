package com.tencent.aelight.camera.ae.report;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001`\u00052\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000\u00a8\u0006\u0007"}, d2 = {"", "", "", "oriParam", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "aelight_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d {
    public static final HashMap<String, String> a(Map<String, ? extends Object> oriParam) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(oriParam, "oriParam");
        HashMap<String, String> hashMap = new HashMap<>();
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(oriParam.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = oriParam.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        hashMap.putAll(linkedHashMap);
        return hashMap;
    }
}
