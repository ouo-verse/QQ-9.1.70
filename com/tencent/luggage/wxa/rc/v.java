package com.tencent.luggage.wxa.rc;

import com.tencent.luggage.wxa.rc.p;
import com.tencent.luggage.wxa.tn.w0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f139568a = new v();

    /* renamed from: b, reason: collision with root package name */
    public static final int f139569b = a.CACHE.b();

    /* renamed from: c, reason: collision with root package name */
    public static final Object[] f139570c = {p.a.NO_SUCH_KEY};

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        APP(0),
        GAME(0),
        OPEN_DATA(1),
        SINGLE_PAGE(2),
        CACHE(3);


        /* renamed from: a, reason: collision with root package name */
        public final int f139577a;

        a(int i3) {
            this.f139577a = i3;
        }

        public final int b() {
            return this.f139577a;
        }
    }

    public static final boolean a(int i3) {
        return i3 < 0 || i3 > f139569b;
    }

    public static final String b(String appId, String key) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(key, "key");
        return a(0, appId, key, "++");
    }

    public static final String a(int i3, String appId, String key, String separator) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(separator, "separator");
        StringBuilder sb5 = new StringBuilder();
        if (i3 > 0) {
            sb5.append(i3);
            sb5.append(separator);
        }
        sb5.append(appId);
        sb5.append(separator);
        sb5.append(key);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    public static final void b(String appId, int i3, Function1 getter, Function2 setter) {
        List mutableList;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(getter, "getter");
        Intrinsics.checkNotNullParameter(setter, "setter");
        mutableList = ArraysKt___ArraysKt.toMutableList(a(appId, getter, setter));
        mutableList.remove(Integer.valueOf(i3));
        String b16 = b(appId, "@@@TOTAL@STORAGE@ID@@@");
        String jSONArray = new JSONArray((Collection) mutableList).toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONArray(list).toString()");
        setter.invoke(b16, jSONArray);
    }

    public static final int a(String str, String str2) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        if (str2 == null) {
            str2 = "";
        }
        return length + str2.length();
    }

    public static final String a(int i3, String appId, String key) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(key, "key");
        return a(i3, appId, key, "++");
    }

    public static final int[] a(String appId, Function1 getter, Function2 setter) {
        int[] intArray;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(getter, "getter");
        Intrinsics.checkNotNullParameter(setter, "setter");
        String b16 = b(appId, "@@@TOTAL@STORAGE@ID@@@");
        if (w0.c(b16)) {
            return new int[]{0};
        }
        String str = (String) getter.invoke(b16);
        if (w0.c(str)) {
            return new int[]{0};
        }
        JSONArray jSONArray = new JSONArray(str);
        if (jSONArray.length() <= 0) {
            return new int[]{0};
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(Integer.valueOf(jSONArray.getInt(i3)));
        }
        if (!arrayList.contains(0)) {
            arrayList.add(0);
        }
        intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        return intArray;
    }

    public static final void a(String appId, int i3, Function1 getter, Function2 setter) {
        boolean contains;
        List asList;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(getter, "getter");
        Intrinsics.checkNotNullParameter(setter, "setter");
        int[] a16 = a(appId, getter, setter);
        contains = ArraysKt___ArraysKt.contains(a16, i3);
        if (contains) {
            return;
        }
        asList = ArraysKt___ArraysJvmKt.asList(a16);
        JSONArray jSONArray = new JSONArray((Collection) asList);
        jSONArray.put(i3);
        String b16 = b(appId, "@@@TOTAL@STORAGE@ID@@@");
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "json.toString()");
        setter.invoke(b16, jSONArray2);
    }

    public static final int a(int i3, String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (Intrinsics.areEqual("wxGlobal", appId)) {
            return com.tencent.luggage.wxa.fd.h.b().f125741h;
        }
        if (i3 != 0 && i3 != 2) {
            return com.tencent.luggage.wxa.fd.u.b(appId);
        }
        return com.tencent.luggage.wxa.fd.u.a(appId);
    }
}
