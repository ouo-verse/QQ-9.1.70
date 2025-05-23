package com.tencent.luggage.wxa.rc;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.tencent.luggage.wxa.rc.p;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xn.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.xn.c implements p {

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f139460j = {com.tencent.luggage.wxa.xn.c.a(com.tencent.luggage.wxa.rc.a.f139452x, "AppBrandKVData"), "DROP TABLE IF EXISTS AppBrandStorageKVData;"};

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.xn.b f139461g;

    /* renamed from: h, reason: collision with root package name */
    public Function1 f139462h;

    /* renamed from: i, reason: collision with root package name */
    public Function2 f139463i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.rc.a f139464a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f139465b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f139466c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f139467d;

        public a(com.tencent.luggage.wxa.rc.a aVar, String str, int i3, int i16) {
            this.f139464a = aVar;
            this.f139465b = str;
            this.f139466c = i3;
            this.f139467d = i16;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p.a invoke() {
            if (b.super.b(this.f139464a)) {
                b.this.e(this.f139465b, this.f139466c);
                b.this.a(this.f139466c, this.f139465b, this.f139467d);
                return p.a.NONE;
            }
            return p.a.UNKNOWN;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.rc.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6682b implements Function1 {
        public C6682b() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String invoke(String str) {
            com.tencent.luggage.wxa.rc.a aVar = new com.tencent.luggage.wxa.rc.a();
            aVar.f138294b = str;
            if (!b.super.b(aVar, new String[0])) {
                return null;
            }
            return aVar.f138296d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Function2 {
        public c() {
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(String str, String str2) {
            com.tencent.luggage.wxa.rc.a aVar = new com.tencent.luggage.wxa.rc.a();
            aVar.f138294b = str;
            aVar.f138296d = str2;
            b.super.b(aVar);
            return null;
        }
    }

    public b(com.tencent.luggage.wxa.xn.b bVar) {
        super(bVar, com.tencent.luggage.wxa.rc.a.f139452x, "AppBrandKVData", null);
        this.f139462h = new C6682b();
        this.f139463i = new c();
        this.f139461g = bVar;
    }

    public final String c(int i3, String str, String str2) {
        return v.a(i3, str, str2);
    }

    public final int d(int i3, String str) {
        com.tencent.luggage.wxa.rc.a aVar = new com.tencent.luggage.wxa.rc.a();
        aVar.f138294b = c(i3, str, "@@@TOTAL@DATA@SIZE@@@");
        if (!super.b(aVar, new String[0])) {
            return 0;
        }
        return w0.a(aVar.f138296d, 0);
    }

    public final void e() {
        a.C6921a c6921a = com.tencent.luggage.wxa.rc.a.f139452x;
        com.tencent.luggage.wxa.xn.b bVar = this.f139461g;
        String d16 = d();
        for (String str : com.tencent.luggage.wxa.xn.c.a(c6921a, d(), bVar)) {
            if (!bVar.a(d16, str)) {
                com.tencent.luggage.wxa.tn.w.b("AppBrandKVStorage", "updateColumnSQLs table failed %s, sql %s", d16, str);
            }
        }
    }

    public final void f(String str, int i3) {
        v.b(str, i3, this.f139462h, this.f139463i);
    }

    public int[] h(String str) {
        return v.a(str, this.f139462h, this.f139463i);
    }

    public final int i(String str) {
        Cursor a16 = this.f139461g.a("AppBrandKVData", new String[]{"size"}, "key = ?", new String[]{str}, null, null, null, 2);
        if (a16.moveToFirst()) {
            int i3 = a16.getInt(0);
            a16.close();
            return i3;
        }
        a16.close();
        return 0;
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public List b(int i3, String str, List list) {
        return new ArrayList();
    }

    public final boolean c(int i3, String str, int i16) {
        return d(i3, str) + i16 >= c(i3, str);
    }

    public final void f(String str) {
        com.tencent.luggage.wxa.rc.a aVar = new com.tencent.luggage.wxa.rc.a();
        aVar.f138294b = str;
        super.a(aVar, new String[0]);
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public p.a b(int i3, String str, String str2) {
        if (!w0.c(str) && !w0.c(str2)) {
            String a16 = v.a(i3, str, str2, "__");
            int a17 = a(i3, str, -i(a16));
            f(a16);
            if (a17 <= 0) {
                f(str, i3);
            }
            return p.a.NONE;
        }
        return p.a.MISSING_PARAMS;
    }

    public final int c(int i3, String str) {
        return v.a(i3, str);
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public Object[] a(int i3, String str, String str2) {
        if (w0.c(str) || w0.c(str2)) {
            return new Object[]{p.a.MISSING_PARAMS};
        }
        com.tencent.luggage.wxa.rc.a aVar = new com.tencent.luggage.wxa.rc.a();
        aVar.f138294b = v.a(i3, str, str2, "__");
        try {
            return super.b(aVar, new String[0]) ? new Object[]{p.a.NONE, aVar.f138296d, aVar.f138298f} : v.f139570c;
        } catch (SQLiteException e16) {
            if (w0.d(e16.getMessage()).contains("no such table")) {
                com.tencent.luggage.wxa.tn.w.b("AppBrandKVStorage", "get storageId[%d] appId[%s] key[%s], no such table, return RET_GET_NO_SUCH_KEY", Integer.valueOf(i3), str, str2);
                return v.f139570c;
            }
            if (e16.getClass().getName().endsWith("CursorWindowAllocationException")) {
                return new Object[]{p.a.MEMORY_ISSUE};
            }
            throw e16;
        }
    }

    public final void e(String str, int i3) {
        v.a(str, i3, this.f139462h, this.f139463i);
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public void b(int i3, String str) {
        String str2;
        if (i3 == 0) {
            str2 = str + "__";
        } else {
            str2 = i3 + "__" + str + "__";
        }
        f(str, i3);
        this.f139461g.a("AppBrandKVData", String.format("%s like ? escape ? OR %s=?", "key", "key"), new String[]{str2.replace("_", "\\_") + "%", "\\", c(i3, str, "@@@TOTAL@DATA@SIZE@@@")});
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public p.a a(int i3, String str, String str2, String str3, String str4) {
        return a(i3, str, str2, str3, str4, v.a(str2, str3));
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public p.a a(int i3, String str, List list) {
        return p.a.UNKNOWN;
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public int b(String str) {
        int i3 = 0;
        for (int i16 : h(str)) {
            i3 += d(i16, str);
        }
        return i3;
    }

    public p.a a(int i3, String str, String str2, String str3, String str4, int i16) {
        if (!w0.c(str) && !w0.c(str2)) {
            String a16 = v.a(i3, str, str2, "__");
            int i17 = i16 - i(a16);
            if (c(i3, str, i17)) {
                return p.a.QUOTA_REACHED;
            }
            com.tencent.luggage.wxa.rc.a aVar = new com.tencent.luggage.wxa.rc.a();
            aVar.f138294b = a16;
            aVar.f138296d = str3;
            aVar.f138298f = str4;
            aVar.f138300h = i16;
            a aVar2 = new a(aVar, str, i3, i17);
            try {
                return (p.a) aVar2.invoke();
            } catch (SQLiteException e16) {
                if (w0.d(e16.getMessage()).contains("no such table")) {
                    com.tencent.luggage.wxa.tn.w.b("AppBrandKVStorage", "set storageId[%d] appId[%s] key[%s], get exception[%s] try create table", Integer.valueOf(i3), str, str2, e16);
                    try {
                        e();
                        return (p.a) aVar2.invoke();
                    } catch (SQLiteException e17) {
                        String format = String.format(Locale.ENGLISH, "set storageId[%d] appId[%s] key[%s], get exception[%s] after retry", Integer.valueOf(i3), str, str2, e16);
                        com.tencent.luggage.wxa.tn.w.b("AppBrandKVStorage", format);
                        throw new SQLiteException(format, e17);
                    }
                }
                throw e16;
            }
        }
        return p.a.MISSING_PARAMS;
    }

    public final void b(int i3, String str, int i16) {
        com.tencent.luggage.wxa.rc.a aVar = new com.tencent.luggage.wxa.rc.a();
        aVar.f138294b = c(i3, str, "@@@TOTAL@DATA@SIZE@@@");
        aVar.f138296d = i16 + "";
        super.b(aVar);
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public Object[] a(int i3, String str) {
        String str2;
        if (i3 == 0) {
            str2 = str + "__";
        } else {
            str2 = i3 + "__" + str + "__";
        }
        Cursor a16 = this.f139461g.a("AppBrandKVData", new String[]{"key"}, "key like ? escape ?", new String[]{str2.replace("_", "\\_") + "%", "\\"}, null, null, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a16.moveToNext()) {
            arrayList.add(a16.getString(0).replace(str2, ""));
        }
        a16.close();
        return new Object[]{arrayList, Integer.valueOf(d(i3, str)), Integer.valueOf(c(i3, str))};
    }

    public final int a(int i3, String str, int i16) {
        int max = Math.max(0, d(i3, str) + i16);
        b(i3, str, max);
        return max;
    }
}
