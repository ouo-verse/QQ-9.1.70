package com.tencent.kuikly.core.nvi.serialization.json;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\fH\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0010H\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/kuikly/core/nvi/serialization/json/c;", "", "", "jsonStr", "c", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "jsonObject", "e", "Lcom/tencent/kuikly/core/nvi/serialization/json/b;", "jsonArray", "d", "K", "V", "", "b", "()Ljava/util/Map;", "E", "", "a", "()Ljava/util/List;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f117421a = new c();

    c() {
    }

    public final <E> List<E> a() {
        return new ArrayList();
    }

    public final <K, V> Map<K, V> b() {
        return new LinkedHashMap();
    }

    public final Object c(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        return new f(jsonStr).d();
    }

    public final String d(b jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        return d.a(jsonArray);
    }

    public final String e(e jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        return d.b(jsonObject);
    }
}
