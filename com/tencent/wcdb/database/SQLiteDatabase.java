package com.tencent.wcdb.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.wcdb.SQLException;
import com.tencent.wcdb.support.Log;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class SQLiteDatabase extends com.tencent.wcdb.database.a {
    static IPatchRedirector $redirector_;
    private static final WeakHashMap<SQLiteDatabase, Object> E;
    private static final String[] F;
    static final /* synthetic */ boolean G;
    private SQLiteConnectionPool C;
    private boolean D;

    /* renamed from: e, reason: collision with root package name */
    private final ThreadLocal<i> f384382e;

    /* renamed from: f, reason: collision with root package name */
    private final b f384383f;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.wcdb.f f384384h;

    /* renamed from: i, reason: collision with root package name */
    private final Object f384385i;

    /* renamed from: m, reason: collision with root package name */
    private final d f384386m;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface CustomFunction {
        void a(String[] strArr);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a extends ThreadLocal<i> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SQLiteDatabase.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i initialValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (i) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return SQLiteDatabase.this.l();
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface b {
        com.tencent.wcdb.e a(SQLiteDatabase sQLiteDatabase, c cVar, String str, f fVar);

        f b(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, com.tencent.wcdb.support.a aVar);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20070);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 79)) {
            redirector.redirect((short) 79);
            return;
        }
        G = true;
        SQLiteGlobal.a();
        E = new WeakHashMap<>();
        F = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    }

    SQLiteDatabase(String str, int i3, b bVar, com.tencent.wcdb.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), bVar, fVar);
            return;
        }
        this.f384382e = new a();
        this.f384385i = new Object();
        this.f384383f = bVar;
        this.f384384h = fVar == null ? new com.tencent.wcdb.h(true) : fVar;
        this.f384386m = new d(str, i3);
    }

    private void A(byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i3) {
        try {
            try {
                C(bArr, sQLiteCipherSpec, i3);
            } catch (SQLiteDatabaseCorruptException unused) {
                z();
                C(bArr, sQLiteCipherSpec, i3);
            }
        } catch (SQLiteException e16) {
            Log.b("WCDB.SQLiteDatabase", "Failed to open database '" + q() + "'.", e16);
            close();
            throw e16;
        }
    }

    public static SQLiteDatabase B(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, b bVar, int i3, com.tencent.wcdb.f fVar, int i16) {
        SQLiteDatabase sQLiteDatabase = new SQLiteDatabase(str, i3, bVar, fVar);
        sQLiteDatabase.A(bArr, sQLiteCipherSpec, i16);
        return sQLiteDatabase;
    }

    private void C(byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i3) {
        synchronized (this.f384385i) {
            if (!G && this.C != null) {
                throw new AssertionError();
            }
            this.C = SQLiteConnectionPool.t(this, this.f384386m, bArr, sQLiteCipherSpec, i3);
        }
        WeakHashMap<SQLiteDatabase, Object> weakHashMap = E;
        synchronized (weakHashMap) {
            weakHashMap.put(this, null);
        }
    }

    public static SQLiteDatabase D(File file, b bVar) {
        return E(file.getPath(), bVar);
    }

    public static SQLiteDatabase E(String str, b bVar) {
        return B(str, null, null, bVar, 268435456, null, 0);
    }

    public static SQLiteDatabase F(String str, b bVar, int i3) {
        return B(str, null, null, bVar, 268435456, null, i3);
    }

    private void c0() {
        if (this.C != null) {
            return;
        }
        throw new IllegalStateException("The database '" + this.f384386m.f384393b + "' is not open.");
    }

    private void k(SQLiteTransactionListener sQLiteTransactionListener, boolean z16) {
        int i3;
        a();
        try {
            i s16 = s();
            if (z16) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            s16.d(i3, sQLiteTransactionListener, r(false), null);
        } finally {
            g();
        }
    }

    private void n(boolean z16) {
        SQLiteConnectionPool sQLiteConnectionPool;
        synchronized (this.f384385i) {
            sQLiteConnectionPool = this.C;
            this.C = null;
        }
        if (!z16) {
            WeakHashMap<SQLiteDatabase, Object> weakHashMap = E;
            synchronized (weakHashMap) {
                weakHashMap.remove(this);
            }
            if (sQLiteConnectionPool != null) {
                sQLiteConnectionPool.close();
            }
        }
    }

    private int o(String str, Object[] objArr, com.tencent.wcdb.support.a aVar) throws SQLException {
        boolean z16;
        a();
        try {
            if (com.tencent.wcdb.g.d(str) == 3) {
                synchronized (this.f384385i) {
                    if (!this.D) {
                        z16 = true;
                        this.D = true;
                    } else {
                        z16 = false;
                    }
                }
                if (z16) {
                    disableWriteAheadLogging();
                }
            }
            j jVar = new j(this, str, objArr);
            try {
                return jVar.u(aVar);
            } finally {
                jVar.close();
            }
        } finally {
            g();
        }
    }

    public static String p(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(32);
            int indexOf2 = str.indexOf(44);
            if (indexOf > 0 && (indexOf < indexOf2 || indexOf2 < 0)) {
                return str.substring(0, indexOf);
            }
            if (indexOf2 > 0) {
                if (indexOf2 < indexOf || indexOf < 0) {
                    return str.substring(0, indexOf2);
                }
                return str;
            }
            return str;
        }
        throw new IllegalStateException("Invalid tables");
    }

    private static boolean w() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && myLooper == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    private boolean x() {
        if ((this.f384386m.f384395d & 1) == 1) {
            return true;
        }
        return false;
    }

    private Set<String> y(ContentValues contentValues) {
        return contentValues.keySet();
    }

    public com.tencent.wcdb.e G(String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (com.tencent.wcdb.e) iPatchRedirector.redirect((short) 33, this, str, strArr, str2, objArr, str3, str4, str5);
        }
        return M(false, str, strArr, str2, objArr, str3, str4, str5, null);
    }

    public com.tencent.wcdb.e M(boolean z16, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (com.tencent.wcdb.e) iPatchRedirector.redirect((short) 29, this, Boolean.valueOf(z16), str, strArr, str2, objArr, str3, str4, str5, str6);
        }
        return N(null, z16, str, strArr, str2, objArr, str3, str4, str5, str6, null);
    }

    public com.tencent.wcdb.e N(b bVar, boolean z16, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6, com.tencent.wcdb.support.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (com.tencent.wcdb.e) iPatchRedirector.redirect((short) 32, this, bVar, Boolean.valueOf(z16), str, strArr, str2, objArr, str3, str4, str5, str6, aVar);
        }
        a();
        try {
            return Z(bVar, h.c(z16, str, strArr, str2, str3, str4, str5, str6), objArr, p(str), aVar);
        } finally {
            g();
        }
    }

    public com.tencent.wcdb.e V(String str, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (com.tencent.wcdb.e) iPatchRedirector.redirect((short) 35, (Object) this, (Object) str, (Object) objArr);
        }
        return Z(null, str, objArr, null, null);
    }

    public com.tencent.wcdb.e Z(b bVar, String str, Object[] objArr, String str2, com.tencent.wcdb.support.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (com.tencent.wcdb.e) iPatchRedirector.redirect((short) 38, this, bVar, str, objArr, str2, aVar);
        }
        a();
        try {
            e eVar = new e(this, str, str2, aVar);
            if (bVar == null) {
                bVar = this.f384383f;
            }
            return eVar.b(bVar, objArr);
        } finally {
            g();
        }
    }

    public void a0(long j3, Exception exc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, this, Long.valueOf(j3), exc);
        } else {
            s().p(exc);
        }
    }

    public long b0(String str, String str2, ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Long) iPatchRedirector.redirect((short) 41, this, str, str2, contentValues)).longValue();
        }
        try {
            return v(str, str2, contentValues, 5);
        } catch (SQLiteDatabaseCorruptException e16) {
            throw e16;
        } catch (SQLException e17) {
            Log.b("WCDB.SQLiteDatabase", "Error inserting " + contentValues, e17);
            return -1L;
        }
    }

    public void beginTransaction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            k(null, true);
        }
    }

    public int d0(String str, ContentValues contentValues, String str2, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, this, str, contentValues, str2, strArr)).intValue();
        }
        return e0(str, contentValues, str2, strArr, 0);
    }

    public void disableWriteAheadLogging() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this);
            return;
        }
        synchronized (this.f384385i) {
            c0();
            d dVar = this.f384386m;
            int i3 = dVar.f384395d;
            if ((i3 & 536870912) == 0) {
                return;
            }
            dVar.f384395d = i3 & (-536870913);
            try {
                this.C.v(dVar);
            } catch (RuntimeException e16) {
                d dVar2 = this.f384386m;
                dVar2.f384395d = 536870912 | dVar2.f384395d;
                throw e16;
            }
        }
    }

    @Override // com.tencent.wcdb.database.a
    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            n(false);
        }
    }

    public int e0(String str, ContentValues contentValues, String str2, String[] strArr, int i3) {
        int length;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Integer) iPatchRedirector.redirect((short) 46, this, str, contentValues, str2, strArr, Integer.valueOf(i3))).intValue();
        }
        if (contentValues != null && contentValues.size() != 0) {
            a();
            try {
                StringBuilder sb5 = new StringBuilder(120);
                sb5.append("UPDATE ");
                sb5.append(F[i3]);
                sb5.append(str);
                sb5.append(" SET ");
                int size = contentValues.size();
                if (strArr == null) {
                    length = size;
                } else {
                    length = strArr.length + size;
                }
                Object[] objArr = new Object[length];
                for (String str4 : y(contentValues)) {
                    if (i16 > 0) {
                        str3 = ",";
                    } else {
                        str3 = "";
                    }
                    sb5.append(str3);
                    sb5.append(str4);
                    objArr[i16] = contentValues.get(str4);
                    sb5.append("=?");
                    i16++;
                }
                if (strArr != null) {
                    for (int i17 = size; i17 < length; i17++) {
                        objArr[i17] = strArr[i17 - size];
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    sb5.append(" WHERE ");
                    sb5.append(str2);
                }
                j jVar = new j(this, sb5.toString(), objArr);
                try {
                    return jVar.executeUpdateDelete();
                } finally {
                    jVar.close();
                }
            } finally {
                g();
            }
        }
        throw new IllegalArgumentException("Empty values");
    }

    public boolean enableWriteAheadLogging() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Boolean) iPatchRedirector.redirect((short) 63, (Object) this)).booleanValue();
        }
        synchronized (this.f384385i) {
            c0();
            if ((this.f384386m.f384395d & 536870912) != 0) {
                return true;
            }
            if (x()) {
                return false;
            }
            if (this.f384386m.a()) {
                Log.c("WCDB.SQLiteDatabase", "can't enable WAL for memory databases.");
                return false;
            }
            if (this.D) {
                Log.c("WCDB.SQLiteDatabase", "this database: " + this.f384386m.f384393b + " has attached databases. can't  enable WAL.");
                return false;
            }
            d dVar = this.f384386m;
            dVar.f384395d = 536870912 | dVar.f384395d;
            try {
                this.C.v(dVar);
                return true;
            } catch (RuntimeException e16) {
                this.f384386m.f384395d &= -536870913;
                throw e16;
            }
        }
    }

    public void endTransaction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        a();
        try {
            s().f(null);
        } finally {
            g();
        }
    }

    public void execSQL(String str) throws SQLException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) str);
        } else {
            o(str, null, null);
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            n(true);
        } finally {
            super.finalize();
        }
    }

    public List<Pair<String, String>> getAttachedDbs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return (List) iPatchRedirector.redirect((short) 74, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.f384385i) {
            com.tencent.wcdb.e eVar = null;
            if (this.C == null) {
                return null;
            }
            if (!this.D) {
                arrayList.add(new Pair("main", this.f384386m.f384392a));
                return arrayList;
            }
            a();
            try {
                try {
                    eVar = V("pragma database_list;", null);
                    while (eVar.moveToNext()) {
                        arrayList.add(new Pair(eVar.getString(1), eVar.getString(2)));
                    }
                    eVar.close();
                    return arrayList;
                } catch (Throwable th5) {
                    if (eVar != null) {
                        eVar.close();
                    }
                    throw th5;
                }
            } finally {
                g();
            }
        }
    }

    public final String getPath() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (String) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        synchronized (this.f384385i) {
            str = this.f384386m.f384392a;
        }
        return str;
    }

    public boolean isOpen() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, (Object) this)).booleanValue();
        }
        synchronized (this.f384385i) {
            if (this.C != null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public long j(String str, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return ((Long) iPatchRedirector.redirect((short) 76, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17))).longValue();
        }
        if (str == null) {
            str = "unnamedNative";
        }
        if (z16) {
            i3 = 1;
        }
        if (z17) {
            i3 |= 4;
        }
        long z18 = s().b(i3).z(str);
        if (z18 != 0) {
            return z18;
        }
        throw new IllegalStateException("SQLiteConnection native handle not initialized.");
    }

    i l() {
        SQLiteConnectionPool sQLiteConnectionPool;
        synchronized (this.f384385i) {
            c0();
            sQLiteConnectionPool = this.C;
        }
        return new i(sQLiteConnectionPool);
    }

    public int m(String str, String str2, String[] strArr) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Integer) iPatchRedirector.redirect((short) 44, this, str, str2, strArr)).intValue();
        }
        a();
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("DELETE FROM ");
            sb5.append(str);
            if (!TextUtils.isEmpty(str2)) {
                str3 = " WHERE " + str2;
            } else {
                str3 = "";
            }
            sb5.append(str3);
            j jVar = new j(this, sb5.toString(), strArr);
            try {
                return jVar.executeUpdateDelete();
            } finally {
                jVar.close();
            }
        } finally {
            g();
        }
    }

    String q() {
        String str;
        synchronized (this.f384385i) {
            str = this.f384386m.f384393b;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r(boolean z16) {
        int i3;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        if (w()) {
            return i3 | 4;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i s() {
        return this.f384382e.get();
    }

    public void setTransactionSuccessful() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        a();
        try {
            s().r();
        } finally {
            g();
        }
    }

    public l t() {
        l m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (l) iPatchRedirector.redirect((short) 70, (Object) this);
        }
        synchronized (this.f384385i) {
            c0();
            m3 = this.C.m();
        }
        return m3;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return (String) iPatchRedirector.redirect((short) 78, (Object) this);
        }
        return "SQLiteDatabase: " + getPath();
    }

    public long u(String str, String str2, ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Long) iPatchRedirector.redirect((short) 39, this, str, str2, contentValues)).longValue();
        }
        try {
            return v(str, str2, contentValues, 0);
        } catch (SQLiteDatabaseCorruptException e16) {
            throw e16;
        } catch (SQLException e17) {
            Log.b("WCDB.SQLiteDatabase", "Error inserting %s: %s", contentValues, e17);
            return -1L;
        }
    }

    public long v(String str, String str2, ContentValues contentValues, int i3) {
        int i16;
        Object[] objArr;
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Long) iPatchRedirector.redirect((short) 43, this, str, str2, contentValues, Integer.valueOf(i3))).longValue();
        }
        a();
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("INSERT");
            sb5.append(F[i3]);
            sb5.append(" INTO ");
            sb5.append(str);
            sb5.append('(');
            if (contentValues != null && contentValues.size() > 0) {
                i16 = contentValues.size();
            } else {
                i16 = 0;
            }
            if (i16 > 0) {
                objArr = new Object[i16];
                int i17 = 0;
                for (String str5 : y(contentValues)) {
                    if (i17 > 0) {
                        str4 = ",";
                    } else {
                        str4 = "";
                    }
                    sb5.append(str4);
                    sb5.append(str5);
                    objArr[i17] = contentValues.get(str5);
                    i17++;
                }
                sb5.append(')');
                sb5.append(" VALUES (");
                for (int i18 = 0; i18 < i16; i18++) {
                    if (i18 > 0) {
                        str3 = ",?";
                    } else {
                        str3 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                    }
                    sb5.append(str3);
                }
            } else {
                sb5.append(str2 + ") VALUES (NULL");
                objArr = null;
            }
            sb5.append(')');
            j jVar = new j(this, sb5.toString(), objArr);
            try {
                return jVar.executeInsert();
            } finally {
                jVar.close();
            }
        } finally {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        this.f384384h.a(this);
    }
}
