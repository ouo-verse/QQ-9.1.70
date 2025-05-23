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
public abstract class p extends com.tencent.luggage.wxa.xn.a {

    /* renamed from: f, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.b f138534f;

    /* renamed from: g, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138535g;

    /* renamed from: h, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138536h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138537i;

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f138538j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f138539k;

    /* renamed from: l, reason: collision with root package name */
    public static final int f138540l;

    /* renamed from: m, reason: collision with root package name */
    public static final int f138541m;

    /* renamed from: n, reason: collision with root package name */
    public static final a.C6921a f138542n;

    /* renamed from: o, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.zn.c f138543o;

    /* renamed from: b, reason: collision with root package name */
    public String f138544b;

    /* renamed from: d, reason: collision with root package name */
    public long f138546d;

    /* renamed from: c, reason: collision with root package name */
    public boolean f138545c = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f138547e = true;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("WxaUsageHistory");
        f138534f = bVar;
        f138535g = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138536h = new com.tencent.luggage.wxa.ao.a("appId", HippyControllerProps.STRING, bVar.a(), "");
        f138537i = new com.tencent.luggage.wxa.ao.a("updateTime", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138538j = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandUseHistoryIndex ON WxaUsageHistory(updateTime)"};
        f138539k = 93028124;
        f138540l = -295931082;
        f138541m = 108705909;
        f138542n = a(p.class);
        f138543o = new com.tencent.luggage.wxa.zn.c();
    }

    public static a.C6921a a(Class cls) {
        a.C6921a c6921a = new a.C6921a();
        c6921a.f145158a = new Field[2];
        c6921a.f145160c = new String[3];
        StringBuilder sb5 = new StringBuilder();
        c6921a.f145160c[0] = "appId";
        c6921a.f145161d.put("appId", "TEXT PRIMARY KEY ");
        sb5.append(" appId TEXT PRIMARY KEY ");
        sb5.append(", ");
        c6921a.f145159b = "appId";
        c6921a.f145160c[1] = "updateTime";
        c6921a.f145161d.put("updateTime", "LONG");
        sb5.append(" updateTime LONG");
        c6921a.f145160c[2] = "rowid";
        c6921a.f145162e = sb5.toString();
        if (c6921a.f145159b == null) {
            c6921a.f145159b = "rowid";
        }
        return c6921a;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public com.tencent.luggage.wxa.zn.c c() {
        return f138543o;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public Object d() {
        return this.f138544b;
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
            if (f138539k == hashCode) {
                try {
                    this.f138544b = cursor.getString(i3);
                    this.f138545c = true;
                } catch (Throwable th5) {
                    w.a("MicroMsg.SDK.BaseWxaUsageHistory", th5, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138540l == hashCode) {
                try {
                    this.f138546d = cursor.getLong(i3);
                } catch (Throwable th6) {
                    w.a("MicroMsg.SDK.BaseWxaUsageHistory", th6, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138541m == hashCode) {
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
        if (this.f138545c) {
            contentValues.put("appId", this.f138544b);
        }
        if (this.f138547e) {
            contentValues.put("updateTime", Long.valueOf(this.f138546d));
        }
        long j3 = this.f145157a;
        if (j3 > 0) {
            contentValues.put("rowid", Long.valueOf(j3));
        }
        return contentValues;
    }
}
