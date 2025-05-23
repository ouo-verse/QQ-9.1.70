package com.tencent.luggage.wxa.e5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f124541a = new f();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f124542a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinkedList f124543b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function1 function1, LinkedList linkedList) {
            super(1);
            this.f124542a = function1;
            this.f124543b = linkedList;
        }

        public final void a(Object e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            Object invoke = this.f124542a.invoke(e16);
            if (invoke != null) {
                this.f124543b.add(invoke);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return Unit.INSTANCE;
        }
    }

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

    public static final Map b(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        HashMap hashMap = new HashMap(jSONObject.length());
        Iterator keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
        while (keys.hasNext()) {
            String it = (String) keys.next();
            Object obj = jSONObject.get(it);
            if (obj instanceof JSONObject) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                hashMap.put(it, b((JSONObject) obj));
            } else {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                hashMap.put(it, obj);
            }
        }
        return hashMap;
    }

    public static final void a(JSONArray jSONArray, Function1 block) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            block.invoke(jSONArray.get(i3));
        }
    }

    public final List b(JSONArray jSONArray, Function1 transform) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedList linkedList = new LinkedList();
        a(jSONArray, new a(transform, linkedList));
        return linkedList;
    }
}
