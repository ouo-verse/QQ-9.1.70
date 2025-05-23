package com.android.volley;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f31331a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f31332b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final Map<String, String> f31333c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final List<e> f31334d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f31335e;

    /* renamed from: f, reason: collision with root package name */
    public final long f31336f;

    @Deprecated
    public g(int i3, byte[] bArr, @Nullable Map<String, String> map, boolean z16, long j3) {
        this(i3, bArr, map, a(map), z16, j3);
    }

    @Nullable
    private static List<e> a(@Nullable Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new e(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    @Nullable
    private static Map<String, String> b(@Nullable List<e> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (e eVar : list) {
            treeMap.put(eVar.a(), eVar.b());
        }
        return treeMap;
    }

    public g(int i3, byte[] bArr, boolean z16, long j3, @Nullable List<e> list) {
        this(i3, bArr, b(list), list, z16, j3);
    }

    @Deprecated
    public g(byte[] bArr, @Nullable Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    g(int i3, byte[] bArr, @Nullable Map<String, String> map, @Nullable List<e> list, boolean z16, long j3) {
        this.f31331a = i3;
        this.f31332b = bArr;
        this.f31333c = map;
        if (list == null) {
            this.f31334d = null;
        } else {
            this.f31334d = Collections.unmodifiableList(list);
        }
        this.f31335e = z16;
        this.f31336f = j3;
    }
}
