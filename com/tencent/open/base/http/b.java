package com.tencent.open.base.http;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.component.cache.database.a;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends com.tencent.open.component.cache.database.a {

    /* renamed from: g, reason: collision with root package name */
    public static final a.InterfaceC9275a<b> f341010g = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f341011a;

    /* renamed from: b, reason: collision with root package name */
    public String f341012b;

    /* renamed from: c, reason: collision with root package name */
    public long f341013c;

    /* renamed from: d, reason: collision with root package name */
    public long f341014d;

    /* renamed from: e, reason: collision with root package name */
    public String f341015e;

    /* renamed from: f, reason: collision with root package name */
    public String f341016f;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements a.InterfaceC9275a<b> {
        a() {
        }

        @Override // com.tencent.open.component.cache.database.a.InterfaceC9275a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromCursor(Cursor cursor) {
            try {
                String string = cursor.getString(cursor.getColumnIndexOrThrow("urlKey"));
                String string2 = cursor.getString(cursor.getColumnIndexOrThrow("ETag"));
                long j3 = cursor.getLong(cursor.getColumnIndexOrThrow("lastModify"));
                long j16 = cursor.getLong(cursor.getColumnIndexOrThrow("cacheTime"));
                byte[] blob = cursor.getBlob(cursor.getColumnIndexOrThrow("response"));
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                String readString = obtain.readString();
                OaidMonitor.parcelRecycle(obtain);
                return new b(string, string2, j3, j16, readString);
            } catch (Exception e16) {
                QLog.e("HttpCacheData", 1, "createFromCursor fail. ", e16);
                return null;
            }
        }

        @Override // com.tencent.open.component.cache.database.a.InterfaceC9275a
        public String sortOrder() {
            return null;
        }

        @Override // com.tencent.open.component.cache.database.a.InterfaceC9275a
        public a.b[] structure() {
            return new a.b[]{new a.b("urlKey", "TEXT"), new a.b("ETag", "TEXT"), new a.b("lastModify", "INTEGER"), new a.b("cacheTime", "INTEGER"), new a.b("response", "BLOB")};
        }

        @Override // com.tencent.open.component.cache.database.a.InterfaceC9275a
        public int version() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2, long j3, String str3, String str4) {
        this.f341011a = MD5Utils.encodeHexStr(str);
        this.f341012b = str2;
        this.f341013c = j3;
        this.f341014d = System.currentTimeMillis();
        this.f341015e = str3;
        this.f341016f = str4;
    }

    @Override // com.tencent.open.component.cache.database.a
    public void a(ContentValues contentValues) {
        contentValues.put("urlKey", this.f341011a);
        contentValues.put("ETag", this.f341012b);
        contentValues.put("lastModify", Long.valueOf(this.f341013c));
        contentValues.put("cacheTime", Long.valueOf(this.f341014d));
        Parcel obtain = Parcel.obtain();
        obtain.writeString(this.f341015e);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put("response", marshall);
    }

    protected b(String str, String str2, long j3, long j16, String str3) {
        this.f341011a = str;
        this.f341012b = str2;
        this.f341013c = j3;
        this.f341014d = j16;
        this.f341015e = str3;
    }
}
