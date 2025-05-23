package com.tencent.luggage.wxa.q9;

import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xn.a;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class m extends com.tencent.luggage.wxa.xn.a {

    /* renamed from: f, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.b f138488f;

    /* renamed from: g, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138489g;

    /* renamed from: h, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138490h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138491i;

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f138492j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f138493k;

    /* renamed from: l, reason: collision with root package name */
    public static final int f138494l;

    /* renamed from: m, reason: collision with root package name */
    public static final int f138495m;

    /* renamed from: n, reason: collision with root package name */
    public static final a.C6921a f138496n;

    /* renamed from: o, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.zn.c f138497o;

    /* renamed from: b, reason: collision with root package name */
    public String f138498b;

    /* renamed from: d, reason: collision with root package name */
    public int f138500d;

    /* renamed from: c, reason: collision with root package name */
    public boolean f138499c = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f138501e = true;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("WxaCollectionTableV2");
        f138488f = bVar;
        f138489g = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138490h = new com.tencent.luggage.wxa.ao.a("userName", HippyControllerProps.STRING, bVar.a(), "");
        f138491i = new com.tencent.luggage.wxa.ao.a("versionType", PoiListCacheRecord.WEIGHT_TYPE, bVar.a(), "");
        f138492j = new String[0];
        f138493k = -266666762;
        f138494l = 689108018;
        f138495m = 108705909;
        f138496n = a(m.class);
        f138497o = new com.tencent.luggage.wxa.zn.c();
    }

    public static a.C6921a a(Class cls) {
        a.C6921a c6921a = new a.C6921a();
        c6921a.f145158a = new Field[2];
        c6921a.f145160c = new String[3];
        StringBuilder sb5 = new StringBuilder();
        c6921a.f145160c[0] = "userName";
        c6921a.f145161d.put("userName", "TEXT");
        sb5.append(" userName TEXT");
        sb5.append(", ");
        c6921a.f145160c[1] = "versionType";
        c6921a.f145161d.put("versionType", "INTEGER");
        sb5.append(" versionType INTEGER");
        c6921a.f145160c[2] = "rowid";
        c6921a.f145162e = sb5.toString();
        if (c6921a.f145159b == null) {
            c6921a.f145159b = "rowid";
        }
        return c6921a;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public com.tencent.luggage.wxa.zn.c c() {
        return f138497o;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public Object d() {
        return Long.valueOf(this.f145157a);
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public void a(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames == null) {
            return;
        }
        int length = columnNames.length;
        for (int i3 = 0; i3 < length; i3++) {
            int hashCode = columnNames[i3].hashCode();
            if (f138493k == hashCode) {
                try {
                    this.f138498b = cursor.getString(i3);
                } catch (Throwable th5) {
                    w.a("MicroMsg.SDK.BaseWxaCollectionTableV2", th5, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138494l == hashCode) {
                try {
                    this.f138500d = cursor.getInt(i3);
                } catch (Throwable th6) {
                    w.a("MicroMsg.SDK.BaseWxaCollectionTableV2", th6, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138495m == hashCode) {
                this.f145157a = cursor.getLong(i3);
            }
        }
    }

    public final void e() {
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public ContentValues a() {
        e();
        ContentValues contentValues = new ContentValues();
        if (this.f138499c) {
            contentValues.put("userName", this.f138498b);
        }
        if (this.f138501e) {
            contentValues.put("versionType", Integer.valueOf(this.f138500d));
        }
        long j3 = this.f145157a;
        if (j3 > 0) {
            contentValues.put("rowid", Long.valueOf(j3));
        }
        return contentValues;
    }
}
