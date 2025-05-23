package com.tencent.luggage.wxa.q9;

import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.luggage.wxa.hn.z0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xn.a;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.io.IOException;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class n extends com.tencent.luggage.wxa.xn.a {

    /* renamed from: f, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.b f138502f;

    /* renamed from: g, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138503g;

    /* renamed from: h, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138504h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138505i;

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f138506j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f138507k;

    /* renamed from: l, reason: collision with root package name */
    public static final int f138508l;

    /* renamed from: m, reason: collision with root package name */
    public static final int f138509m;

    /* renamed from: n, reason: collision with root package name */
    public static final a.C6921a f138510n;

    /* renamed from: o, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.zn.c f138511o;

    /* renamed from: b, reason: collision with root package name */
    public String f138512b;

    /* renamed from: d, reason: collision with root package name */
    public z0 f138514d;

    /* renamed from: c, reason: collision with root package name */
    public boolean f138513c = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f138515e = true;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("WxaJsApiPluginInfo");
        f138502f = bVar;
        f138503g = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138504h = new com.tencent.luggage.wxa.ao.a("appId", HippyControllerProps.STRING, bVar.a(), "");
        f138505i = new com.tencent.luggage.wxa.ao.a("permissionProtoBlob", "proto", bVar.a(), "com.tencent.mm.protocal.protobuf.CheckJsApiInfo");
        f138506j = new String[0];
        f138507k = 93028124;
        f138508l = -141251434;
        f138509m = 108705909;
        f138510n = a(n.class);
        f138511o = new com.tencent.luggage.wxa.zn.c();
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
        c6921a.f145160c[1] = "permissionProtoBlob";
        c6921a.f145161d.put("permissionProtoBlob", "BLOB");
        sb5.append(" permissionProtoBlob BLOB");
        c6921a.f145160c[2] = "rowid";
        c6921a.f145162e = sb5.toString();
        if (c6921a.f145159b == null) {
            c6921a.f145159b = "rowid";
        }
        return c6921a;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public com.tencent.luggage.wxa.zn.c c() {
        return f138511o;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public Object d() {
        return this.f138512b;
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
            if (f138507k == hashCode) {
                try {
                    this.f138512b = cursor.getString(i3);
                    this.f138513c = true;
                } catch (Throwable th5) {
                    w.a("MicroMsg.SDK.BaseWxaJsApiPluginInfo", th5, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138508l == hashCode) {
                try {
                    byte[] blob = cursor.getBlob(i3);
                    if (blob != null && blob.length > 0) {
                        this.f138514d = (z0) new z0().a(blob);
                    }
                } catch (Throwable th6) {
                    w.a("MicroMsg.SDK.BaseWxaJsApiPluginInfo", th6, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138509m == hashCode) {
                this.f145157a = cursor.getLong(i3);
            }
        }
    }

    public final void e() {
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public ContentValues a() {
        z0 z0Var;
        e();
        ContentValues contentValues = new ContentValues();
        if (this.f138513c) {
            contentValues.put("appId", this.f138512b);
        }
        if (this.f138515e && (z0Var = this.f138514d) != null) {
            try {
                contentValues.put("permissionProtoBlob", z0Var.b());
            } catch (IOException e16) {
                w.b("MicroMsg.SDK.BaseWxaJsApiPluginInfo", e16.getMessage());
            }
        }
        long j3 = this.f145157a;
        if (j3 > 0) {
            contentValues.put("rowid", Long.valueOf(j3));
        }
        return contentValues;
    }
}
