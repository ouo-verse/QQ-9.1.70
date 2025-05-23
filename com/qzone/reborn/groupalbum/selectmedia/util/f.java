package com.qzone.reborn.groupalbum.selectmedia.util;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\f\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u0010\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/util/f;", "", "T", "Ljava/lang/Class;", "key", "a", "(Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/lang/Class;", "getKey", "()Ljava/lang/Class;", "b", "Ljava/lang/Object;", "value", "", "c", "Ljava/util/Map;", "map", "<init>", "(Ljava/lang/Class;Ljava/lang/Object;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Class<?> key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Object value;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Map<Class<?>, Object> map;

    public f(Class<?> key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.key = key;
        this.value = value;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(key, value);
        this.map = linkedHashMap;
    }

    public final <T> T a(Class<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t16 = (T) this.map.get(key);
        if (t16 == null) {
            return null;
        }
        return t16;
    }
}
