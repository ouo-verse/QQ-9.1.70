package com.tencent.luggage.wxa.mc;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.mc.e0;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.reflect.KMutableProperty0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d0 implements o {

    /* renamed from: a, reason: collision with root package name */
    public static final d0 f134272a = new d0();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f134273b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f134274a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Uri invoke() {
            return Uri.parse("content://" + com.tencent.luggage.wxa.o7.a.f136193a + "/AppBrandWxaPkgManifestRecordWithDesc");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final m f134275a = new m();

        public m() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it + "=?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class n extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final n f134276a = new n();

        public n() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(String str) {
            return str + "=?";
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f134274a);
        f134273b = lazy;
    }

    @Override // com.tencent.luggage.wxa.mc.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i0 a(String str, int i3, int i16, String... columns) {
        Intrinsics.checkNotNullParameter(columns, "columns");
        return a(str, i16, (String[]) Arrays.copyOf(columns, columns.length));
    }

    @Override // com.tencent.luggage.wxa.mc.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i0 a(String str, int i3, String... columns) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(columns, "columns");
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] strArr = columns.length == 0 ? null : (String[]) Arrays.copyOf(columns, columns.length);
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(new String[]{"appId", "debugType"}, " AND ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, m.f134275a, 30, (Object) null);
        Cursor query = ContactsMonitor.query(com.tencent.luggage.wxa.tn.z.c().getContentResolver(), a(), strArr, joinToString$default, new String[]{str, String.valueOf(i3)}, "rowid desc");
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    i0 i0Var = new i0();
                    i0Var.a(query);
                    i0Var.f138305b = str;
                    i0Var.f138319p = i3;
                    CloseableKt.closeFinally(query, null);
                    return i0Var;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(query, null);
            } finally {
            }
        }
        return null;
    }

    public final Uri a() {
        return (Uri) f134273b.getValue();
    }

    public static final void a(i0 i0Var, ContentValues values) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(i0Var, "<this>");
        Intrinsics.checkNotNullParameter(values, "values");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("appId", new MutablePropertyReference0Impl(i0Var) { // from class: com.tencent.luggage.wxa.mc.d0.d
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((i0) this.receiver).f138305b;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((i0) this.receiver).f138305b = (String) obj;
            }
        }), TuplesKt.to("version", new MutablePropertyReference0Impl(i0Var) { // from class: com.tencent.luggage.wxa.mc.d0.e
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return Integer.valueOf(((i0) this.receiver).f138307d);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((i0) this.receiver).f138307d = ((Number) obj).intValue();
            }
        }), TuplesKt.to("versionMd5", new MutablePropertyReference0Impl(i0Var) { // from class: com.tencent.luggage.wxa.mc.d0.f
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((i0) this.receiver).f138309f;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((i0) this.receiver).f138309f = (String) obj;
            }
        }), TuplesKt.to("NewMd5", new MutablePropertyReference0Impl(i0Var) { // from class: com.tencent.luggage.wxa.mc.d0.g
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((i0) this.receiver).f138311h;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((i0) this.receiver).f138311h = (String) obj;
            }
        }), TuplesKt.to("pkgPath", new MutablePropertyReference0Impl(i0Var) { // from class: com.tencent.luggage.wxa.mc.d0.h
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((i0) this.receiver).f138315l;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((i0) this.receiver).f138315l = (String) obj;
            }
        }), TuplesKt.to(WadlProxyConsts.CREATE_TIME, new MutablePropertyReference0Impl(i0Var) { // from class: com.tencent.luggage.wxa.mc.d0.i
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return Long.valueOf(((i0) this.receiver).f138317n);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((i0) this.receiver).f138317n = ((Number) obj).longValue();
            }
        }), TuplesKt.to("debugType", new MutablePropertyReference0Impl(i0Var) { // from class: com.tencent.luggage.wxa.mc.d0.j
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return Integer.valueOf(((i0) this.receiver).f138319p);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((i0) this.receiver).f138319p = ((Number) obj).intValue();
            }
        }), TuplesKt.to("downloadURL", new MutablePropertyReference0Impl(i0Var) { // from class: com.tencent.luggage.wxa.mc.d0.k
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((i0) this.receiver).f138321r;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((i0) this.receiver).f138321r = (String) obj;
            }
        }), TuplesKt.to("startTime", new MutablePropertyReference0Impl(i0Var) { // from class: com.tencent.luggage.wxa.mc.d0.l
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return Long.valueOf(((i0) this.receiver).f138323t);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((i0) this.receiver).f138323t = ((Number) obj).longValue();
            }
        }), TuplesKt.to("endTime", new MutablePropertyReference0Impl(i0Var) { // from class: com.tencent.luggage.wxa.mc.d0.b
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return Long.valueOf(((i0) this.receiver).f138325v);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((i0) this.receiver).f138325v = ((Number) obj).longValue();
            }
        }), TuplesKt.to("versionDesc", new MutablePropertyReference0Impl(i0Var) { // from class: com.tencent.luggage.wxa.mc.d0.c
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((i0) this.receiver).Z;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((i0) this.receiver).Z = (String) obj;
            }
        }));
        Set<String> keySet = values.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "values.keySet()");
        for (String str : keySet) {
            Object obj = values.get(str);
            if (obj != null) {
                Intrinsics.checkNotNullExpressionValue(obj, "values[key] ?: return@forEach");
                KMutableProperty0 kMutableProperty0 = (KMutableProperty0) mapOf.get(str);
                if (kMutableProperty0 != null) {
                    Class<?> cls = obj.getClass();
                    if (Intrinsics.areEqual(cls, Float.TYPE) ? true : Intrinsics.areEqual(cls, Float.class)) {
                        Intrinsics.checkNotNull(kMutableProperty0, "null cannot be cast to non-null type kotlin.reflect.KMutableProperty0<kotlin.Float>");
                        kMutableProperty0.set((Float) obj);
                    } else if (Intrinsics.areEqual(cls, Integer.TYPE) ? true : Intrinsics.areEqual(cls, Integer.class)) {
                        Intrinsics.checkNotNull(kMutableProperty0, "null cannot be cast to non-null type kotlin.reflect.KMutableProperty0<kotlin.Int>");
                        kMutableProperty0.set((Integer) obj);
                    } else if (Intrinsics.areEqual(cls, String.class)) {
                        Intrinsics.checkNotNull(kMutableProperty0, "null cannot be cast to non-null type kotlin.reflect.KMutableProperty0<kotlin.String>");
                        kMutableProperty0.set((String) obj);
                    } else if (Intrinsics.areEqual(cls, Long.TYPE) ? true : Intrinsics.areEqual(cls, Long.class)) {
                        Intrinsics.checkNotNull(kMutableProperty0, "null cannot be cast to non-null type kotlin.reflect.KMutableProperty0<kotlin.Long>");
                        kMutableProperty0.set((Long) obj);
                    } else if (Intrinsics.areEqual(cls, Boolean.TYPE) ? true : Intrinsics.areEqual(cls, Boolean.class)) {
                        Intrinsics.checkNotNull(kMutableProperty0, "null cannot be cast to non-null type kotlin.reflect.KMutableProperty0<kotlin.Boolean>");
                        kMutableProperty0.set((Boolean) obj);
                    } else if (Intrinsics.areEqual(cls, byte[].class)) {
                        Intrinsics.checkNotNull(kMutableProperty0, "null cannot be cast to non-null type kotlin.reflect.KMutableProperty0<kotlin.ByteArray>");
                        kMutableProperty0.set((byte[]) obj);
                    }
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.mc.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i0 a(String str, int i3, String str2, String... columns) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(columns, "columns");
        if (!(str == null || str.length() == 0)) {
            if (!(str2 == null || str2.length() == 0)) {
                String[] strArr = columns.length == 0 ? null : (String[]) Arrays.copyOf(columns, columns.length);
                String[] KEYS = i0.f134313b0;
                Intrinsics.checkNotNullExpressionValue(KEYS, "KEYS");
                joinToString$default = ArraysKt___ArraysKt.joinToString$default(KEYS, " AND ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, n.f134276a, 30, (Object) null);
                Cursor query = ContactsMonitor.query(com.tencent.luggage.wxa.tn.z.c().getContentResolver(), a(), strArr, joinToString$default, new String[]{str, String.valueOf(i3), str2}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            i0 i0Var = new i0();
                            i0Var.a(query);
                            i0Var.f138305b = str;
                            i0Var.f138319p = i3;
                            i0Var.Z = str2;
                            CloseableKt.closeFinally(query, null);
                            return i0Var;
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(query, null);
                    } finally {
                    }
                }
                return null;
            }
        }
        com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgIndexedWithDescResolver", "select_keyBy_appId_versionType_versionDesc, invalid appId:" + str + " versionDesc:" + str2);
        return null;
    }

    public boolean b(i0 record) {
        Intrinsics.checkNotNullParameter(record, "record");
        e0.a aVar = e0.f134280i;
        if (aVar.a(record)) {
            return com.tencent.luggage.wxa.tn.z.c().getContentResolver().update(a(), record.a(), null, null) > 0;
        }
        com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgIndexedWithDescResolver", "update(" + e0.a.a(aVar, record, false, 1, null) + ") invalid record");
        return false;
    }

    public boolean a(i0 record) {
        Intrinsics.checkNotNullParameter(record, "record");
        e0.a aVar = e0.f134280i;
        if (aVar.a(record)) {
            return com.tencent.luggage.wxa.tn.z.c().getContentResolver().insert(a(), record.a()) != null;
        }
        com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgIndexedWithDescResolver", "insertOrUpdate(" + e0.a.a(aVar, record, false, 1, null) + ") invalid record");
        return false;
    }
}
