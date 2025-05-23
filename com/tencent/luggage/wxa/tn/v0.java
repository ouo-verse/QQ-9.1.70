package com.tencent.luggage.wxa.tn;

import android.net.Uri;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    public static final v0 f141726a = new v0();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f141727b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends LinkedHashMap {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f141728a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i3) {
            super(i3);
            this.f141728a = i3;
        }

        public /* bridge */ Set a() {
            return super.entrySet();
        }

        public /* bridge */ Set b() {
            return super.keySet();
        }

        public /* bridge */ int c() {
            return super.size();
        }

        public /* bridge */ Collection d() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set entrySet() {
            return a();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set keySet() {
            return b();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            if (size() > this.f141728a) {
                return true;
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection values() {
            return d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f141729a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke() {
            return v0.a(v0.f141726a, 0, 1, null);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) b.f141729a);
        f141727b = lazy;
    }

    public final Map a() {
        return (Map) f141727b.getValue();
    }

    public final void a(Uri uri, String path) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(path, "path");
        if (path.length() > 0) {
            synchronized (a()) {
                Map a16 = f141726a.a();
                String g16 = new com.tencent.luggage.wxa.cp.v(path).g();
                Intrinsics.checkNotNullExpressionValue(g16, "VFSFile(path).absolutePath");
                String uri2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
                a16.put(g16, uri2);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public static /* synthetic */ Map a(v0 v0Var, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 16;
        }
        return v0Var.a(i3);
    }

    public final Map a(int i3) {
        return new a(i3);
    }
}
