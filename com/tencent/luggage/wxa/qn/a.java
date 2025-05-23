package com.tencent.luggage.wxa.qn;

import java.util.Iterator;
import kotlin.collections.CollectionsKt__IteratorsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f138948a = new a();

    public static final JSONObject a(JSONObject jSONObject) {
        Iterator withIndex;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String[] strArr = new String[jSONObject.length()];
        Iterator keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
        withIndex = CollectionsKt__IteratorsKt.withIndex(keys);
        while (withIndex.hasNext()) {
            IndexedValue indexedValue = (IndexedValue) withIndex.next();
            strArr[indexedValue.getIndex()] = (String) indexedValue.component2();
        }
        return new JSONObject(jSONObject, strArr);
    }

    public static final String a(JSONObject jsonObject, String key) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(key, "key");
        Object opt = jsonObject.opt(key);
        return (opt == null || Intrinsics.areEqual(JSONObject.NULL, opt)) ? "" : opt.toString();
    }

    public static final void a(JSONArray jSONArray, Function1 block) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            block.invoke(jSONArray.get(i3));
        }
    }
}
