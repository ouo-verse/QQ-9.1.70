package com.tencent.luggage.wxa.q9;

import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.luggage.wxa.hn.i6;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xn.a;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.io.IOException;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f extends com.tencent.luggage.wxa.xn.a {

    /* renamed from: f, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.b f138345f;

    /* renamed from: g, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138346g;

    /* renamed from: h, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138347h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138348i;

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f138349j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f138350k;

    /* renamed from: l, reason: collision with root package name */
    public static final int f138351l;

    /* renamed from: m, reason: collision with root package name */
    public static final int f138352m;

    /* renamed from: n, reason: collision with root package name */
    public static final a.C6921a f138353n;

    /* renamed from: o, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.zn.c f138354o;

    /* renamed from: b, reason: collision with root package name */
    public String f138355b;

    /* renamed from: d, reason: collision with root package name */
    public i6 f138357d;

    /* renamed from: c, reason: collision with root package name */
    public boolean f138356c = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f138358e = true;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("LaunchWxaAppPBTable");
        f138345f = bVar;
        f138346g = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138347h = new com.tencent.luggage.wxa.ao.a("appId", HippyControllerProps.STRING, bVar.a(), "");
        f138348i = new com.tencent.luggage.wxa.ao.a("launchPB", "proto", bVar.a(), "com.tencent.mm.protocal.protobuf.LaunchWxaAppResponse");
        f138349j = new String[0];
        f138350k = 93028124;
        f138351l = -1407251227;
        f138352m = 108705909;
        f138353n = a(f.class);
        f138354o = new com.tencent.luggage.wxa.zn.c();
    }

    public static a.C6921a a(Class cls) {
        a.C6921a c6921a = new a.C6921a();
        c6921a.f145158a = new Field[2];
        c6921a.f145160c = new String[3];
        StringBuilder sb5 = new StringBuilder();
        c6921a.f145160c[0] = "appId";
        c6921a.f145161d.put("appId", "TEXT");
        sb5.append(" appId TEXT");
        sb5.append(", ");
        c6921a.f145160c[1] = "launchPB";
        c6921a.f145161d.put("launchPB", "BLOB");
        sb5.append(" launchPB BLOB");
        c6921a.f145160c[2] = "rowid";
        c6921a.f145162e = sb5.toString();
        if (c6921a.f145159b == null) {
            c6921a.f145159b = "rowid";
        }
        return c6921a;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public com.tencent.luggage.wxa.zn.c c() {
        return f138354o;
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
            if (f138350k == hashCode) {
                try {
                    this.f138355b = cursor.getString(i3);
                } catch (Throwable th5) {
                    w.a("MicroMsg.SDK.BaseLaunchWxaAppPBTable", th5, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138351l == hashCode) {
                try {
                    byte[] blob = cursor.getBlob(i3);
                    if (blob != null && blob.length > 0) {
                        this.f138357d = (i6) new i6().a(blob);
                    }
                } catch (Throwable th6) {
                    w.a("MicroMsg.SDK.BaseLaunchWxaAppPBTable", th6, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138352m == hashCode) {
                this.f145157a = cursor.getLong(i3);
            }
        }
    }

    public final void e() {
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public ContentValues a() {
        i6 i6Var;
        e();
        ContentValues contentValues = new ContentValues();
        if (this.f138356c) {
            contentValues.put("appId", this.f138355b);
        }
        if (this.f138358e && (i6Var = this.f138357d) != null) {
            try {
                contentValues.put("launchPB", i6Var.b());
            } catch (IOException e16) {
                w.b("MicroMsg.SDK.BaseLaunchWxaAppPBTable", e16.getMessage());
            }
        }
        long j3 = this.f145157a;
        if (j3 > 0) {
            contentValues.put("rowid", Long.valueOf(j3));
        }
        return contentValues;
    }
}
