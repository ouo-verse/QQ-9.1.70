package com.tencent.luggage.wxa.c6;

import android.content.ContentValues;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.wcdb.SQLException;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.e;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements com.tencent.luggage.wxa.xn.b {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f123335a;

    public a(SQLiteDatabase sQLiteDatabase) {
        this.f123335a = sQLiteDatabase;
        sQLiteDatabase.enableWriteAheadLogging();
    }

    @Override // com.tencent.luggage.wxa.xn.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return this.f123335a.G(str, strArr, str2, strArr2, str3, str4, str5);
    }

    @Override // com.tencent.luggage.wxa.xn.b
    public void close() {
        this.f123335a.close();
    }

    @Override // com.tencent.luggage.wxa.xn.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e a(String str, String[] strArr) {
        return this.f123335a.V(str, strArr);
    }

    @Override // com.tencent.luggage.wxa.xn.b
    public long b(String str, String str2, ContentValues contentValues) {
        return this.f123335a.b0(str, str2, contentValues);
    }

    @Override // com.tencent.luggage.wxa.xn.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i3) {
        return this.f123335a.G(str, strArr, str2, strArr2, str3, str4, str5);
    }

    @Override // com.tencent.luggage.wxa.xn.b
    public boolean a() {
        return !this.f123335a.isOpen();
    }

    @Override // com.tencent.luggage.wxa.xn.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e a(String str, String[] strArr, int i3) {
        return this.f123335a.V(str, strArr);
    }

    @Override // com.tencent.luggage.wxa.xn.b
    public boolean a(String str, String str2) {
        try {
            this.f123335a.execSQL(str2);
            return true;
        } catch (SQLException unused) {
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.xn.b
    public synchronized long b(long j3) {
        this.f123335a.beginTransaction();
        return j3;
    }

    @Override // com.tencent.luggage.wxa.xn.b
    public long a(String str, String str2, ContentValues contentValues) {
        return this.f123335a.u(str, str2, contentValues);
    }

    @Override // com.tencent.luggage.wxa.xn.b
    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        return this.f123335a.d0(str, contentValues, str2, strArr);
    }

    @Override // com.tencent.luggage.wxa.xn.b
    public int a(String str, String str2, String[] strArr) {
        return this.f123335a.m(str, str2, strArr);
    }

    @Override // com.tencent.luggage.wxa.xn.b
    public synchronized int a(long j3) {
        try {
            this.f123335a.setTransactionSuccessful();
            this.f123335a.endTransaction();
        } catch (Exception e16) {
            w.a("Luggage.WCDBSQLiteDatabase", e16, "endTransaction(%d)", Long.valueOf(j3));
            return -3;
        }
        return 0;
    }
}
