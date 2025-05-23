package com.tencent.luggage.wxa.mc;

import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e0 extends com.tencent.luggage.wxa.jk.b implements o {

    /* renamed from: i, reason: collision with root package name */
    public static final a f134280i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f134281j;

    /* renamed from: h, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xn.b f134282h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(i0 i0Var) {
            if (i0Var == null) {
                return false;
            }
            String str = i0Var.f138305b;
            if (str == null || str.length() == 0) {
                return false;
            }
            String str2 = i0Var.Z;
            return !(str2 == null || str2.length() == 0);
        }

        public static /* synthetic */ String a(a aVar, i0 i0Var, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            return aVar.a(i0Var, z16);
        }

        public final String a(i0 i0Var, boolean z16) {
            ArrayList arrayListOf;
            String joinToString$default;
            if (i0Var == null) {
                return "(null)";
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("appId:" + i0Var.f138305b, "versionType:" + i0Var.f138319p, "versionDesc:" + i0Var.Z);
            if (z16) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("filePath:");
                String str = i0Var.f138315l;
                if (str == null) {
                    str = "";
                }
                sb5.append(str);
                arrayListOf.add(sb5.toString());
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayListOf, ", ", "(", ")", 0, null, null, 56, null);
            return joinToString$default;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f134283a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(String str) {
            return str + "=?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f134284a = new c();

        public c() {
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
    public static final class d extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final d f134285a = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(String str) {
            return str + "=?";
        }
    }

    static {
        String a16 = com.tencent.luggage.wxa.xn.c.a(i0.f134314c0, "AppBrandWxaPkgManifestRecordWithDesc");
        Intrinsics.checkNotNullExpressionValue(a16, "getCreateSQLs(WxaPkgMani\u2026ithDescRecord.TABLE_NAME)");
        f134281j = new String[]{a16};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(com.tencent.luggage.wxa.xn.b db5) {
        super(db5, i0.f134314c0, "AppBrandWxaPkgManifestRecordWithDesc", i0.f134312a0);
        Intrinsics.checkNotNullParameter(db5, "db");
        this.f134282h = db5;
        db5.a("AppBrandWxaPkgManifestRecordForDevPlugin", "DROP TABLE IF EXISTS AppBrandWxaPkgManifestRecordForDevPlugin");
    }

    @Override // com.tencent.luggage.wxa.mc.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i0 a(String str, int i3, int i16, String... columns) {
        Intrinsics.checkNotNullParameter(columns, "columns");
        return a(str, i16, (String[]) Arrays.copyOf(columns, columns.length));
    }

    public boolean c(i0 record) {
        boolean b16;
        Intrinsics.checkNotNullParameter(record, "record");
        a aVar = f134280i;
        if (!aVar.a(record)) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgIndexedWithDescStorage", "update(" + a.a(aVar, record, false, 1, null) + ") invalid record");
            return false;
        }
        synchronized (this) {
            String[] strArr = i0.f134313b0;
            b16 = super.b((com.tencent.luggage.wxa.xn.a) record, true, (String[]) Arrays.copyOf(strArr, strArr.length));
            if (b16 && com.tencent.luggage.wxa.cp.x.d(record.f138315l)) {
                ((l) com.tencent.luggage.wxa.eo.g.a(l.class)).a(record.f138315l);
            }
        }
        return b16;
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
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(new String[]{"appId", "debugType"}, " AND ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, c.f134284a, 30, (Object) null);
        String[] strArr2 = {str, String.valueOf(i3)};
        try {
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgIndexedWithDescStorage", "select_keyBy_appId_debugType(appId:" + str + ", versionType:" + i3 + "), exception:" + e16);
        }
        synchronized (this) {
            Cursor a16 = this.f134282h.a(SQLiteQueryBuilder.buildQueryString(false, d(), strArr, joinToString$default, null, null, "rowid desc", "1"), strArr2, 2);
            if (a16 != null) {
                try {
                    if (a16.moveToFirst()) {
                        i0 i0Var = new i0();
                        i0Var.a(a16);
                        i0Var.f138305b = str;
                        i0Var.f138319p = i3;
                        CloseableKt.closeFinally(a16, null);
                        return i0Var;
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(a16, null);
                } finally {
                }
            }
            return null;
        }
    }

    public boolean a(i0 i0Var) {
        String joinToString$default;
        boolean z16;
        if (!f134280i.a(i0Var)) {
            return false;
        }
        Intrinsics.checkNotNull(i0Var);
        String[] KEYS = i0.f134313b0;
        Intrinsics.checkNotNullExpressionValue(KEYS, "KEYS");
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(KEYS, " AND ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, b.f134283a, 30, (Object) null);
        String[] strArr = {i0Var.f138305b, String.valueOf(i0Var.f138319p), i0Var.Z};
        try {
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgIndexedWithDescStorage", "hasManifestRecord(" + a.a(f134280i, i0Var, false, 1, null) + "), exception:" + e16);
        }
        synchronized (this) {
            Cursor a16 = this.f134282h.a("select count(*) from " + d() + " where " + joinToString$default, strArr, 2);
            if (a16 == null) {
                return false;
            }
            try {
                if (a16.moveToFirst()) {
                    if (a16.getInt(0) > 0) {
                        z16 = true;
                        CloseableKt.closeFinally(a16, null);
                        return z16;
                    }
                }
                z16 = false;
                CloseableKt.closeFinally(a16, null);
                return z16;
            } finally {
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
                joinToString$default = ArraysKt___ArraysKt.joinToString$default(KEYS, " AND ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, d.f134285a, 30, (Object) null);
                String[] strArr2 = {str, String.valueOf(i3), str2};
                try {
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgIndexedWithDescStorage", "select_keyBy_appId_versionType_versionDesc(appId:" + str + ", versionType:" + i3 + ", versionDesc:" + str2 + "), exception=" + e16);
                }
                synchronized (this) {
                    Cursor a16 = this.f134282h.a(SQLiteQueryBuilder.buildQueryString(false, d(), strArr, joinToString$default, null, null, null, null), strArr2, 2);
                    if (a16 != null) {
                        try {
                            if (a16.moveToFirst()) {
                                i0 i0Var = new i0();
                                i0Var.a(a16);
                                i0Var.f138305b = str;
                                i0Var.f138319p = i3;
                                i0Var.Z = str2;
                                CloseableKt.closeFinally(a16, null);
                                return i0Var;
                            }
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(a16, null);
                        } finally {
                        }
                    }
                    return null;
                }
            }
        }
        com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgIndexedWithDescStorage", "select_keyBy_appId_versionType_versionDesc, invalid appId:" + str + " versionDesc:" + str2);
        return null;
    }

    public boolean b(i0 record) {
        boolean a16;
        Intrinsics.checkNotNullParameter(record, "record");
        a aVar = f134280i;
        if (!aVar.a(record)) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgIndexedWithDescStorage", "insertOrUpdate(" + a.a(aVar, record, false, 1, null) + ") invalid record");
            return false;
        }
        synchronized (this) {
            try {
                com.tencent.luggage.wxa.jk.c cVar = com.tencent.luggage.wxa.jk.c.f131189a;
                com.tencent.luggage.wxa.xn.b bVar = this.f134282h;
                long b16 = bVar.b(Thread.currentThread().getId());
                if (a(record)) {
                    String[] strArr = i0.f134313b0;
                    a16 = super.b((com.tencent.luggage.wxa.xn.a) record, true, (String[]) Arrays.copyOf(strArr, strArr.length));
                    if (a16 && com.tencent.luggage.wxa.cp.x.d(record.f138315l)) {
                        ((l) com.tencent.luggage.wxa.eo.g.a(l.class)).a(record.f138315l);
                    }
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPkgIndexedWithDescStorage", "updateNotify appid:" + record.f138305b + ",newMd5:" + record.f138311h + ", versionDesc:" + record.Z + ", update ret:" + a16);
                } else {
                    a16 = super.a((com.tencent.luggage.wxa.xn.a) record, true);
                    if (a16 && com.tencent.luggage.wxa.cp.x.d(record.f138315l)) {
                        ((l) com.tencent.luggage.wxa.eo.g.a(l.class)).a(record.f138315l);
                    }
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPkgIndexedWithDescStorage", "insertNotify appid:" + record.f138305b + ",newMd5:" + record.f138311h + ", versionDesc:" + record.Z + ", insert ret:" + a16);
                }
                Unit unit = Unit.INSTANCE;
                bVar.a(b16);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPkgIndexedWithDescStorage", "insertOrUpdate(" + a.a(f134280i, record, false, 1, null) + "), exception:" + e16);
                Unit unit2 = Unit.INSTANCE;
                return false;
            }
        }
        return a16;
    }
}
