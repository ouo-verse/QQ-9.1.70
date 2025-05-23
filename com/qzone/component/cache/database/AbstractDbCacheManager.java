package com.qzone.component.cache.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Log;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.util.SecurityUtil;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class AbstractDbCacheManager {

    /* renamed from: k, reason: collision with root package name */
    private static boolean f46640k = false;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f46641l = false;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f46642m = false;

    /* renamed from: a, reason: collision with root package name */
    protected IDBCacheDataWrapper.a f46643a;

    /* renamed from: b, reason: collision with root package name */
    private long f46644b;

    /* renamed from: c, reason: collision with root package name */
    private int f46645c;

    /* renamed from: d, reason: collision with root package name */
    protected String f46646d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f46647e;

    /* renamed from: h, reason: collision with root package name */
    private String f46650h;

    /* renamed from: j, reason: collision with root package name */
    private b f46652j;

    /* renamed from: f, reason: collision with root package name */
    private boolean f46648f = false;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f46649g = false;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<IDBCacheDataWrapper.c> f46651i = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class BadCacheDataException extends AndroidRuntimeException {
        public BadCacheDataException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDbCacheManager(Context context, Class<? extends IDBCacheDataWrapper> cls, long j3, int i3, int i16, String str, int i17) {
        this.f46650h = null;
        Context applicationContext = context.getApplicationContext();
        String k3 = k(j3, i3);
        this.f46650h = k3;
        b h16 = b.h(applicationContext, k3, i16, i17);
        this.f46652j = h16;
        h16.a(hashCode());
        this.f46644b = j3;
        this.f46645c = i3;
        this.f46646d = str;
        v(cls);
        R();
    }

    private void D(String str, String str2, String str3, String[] strArr, long j3) {
        if (f46641l || j3 > 50) {
            QLog.i("DbCacheDatabase.CacheManager.Database_Test", 1, "db:" + str + " table:" + str2 + " selection:" + str3 + " args:" + Arrays.toString(strArr));
            StringBuilder sb5 = new StringBuilder();
            sb5.append("timecost: ");
            sb5.append(j3);
            QLog.i("DbCacheDatabase.CacheManager.Database_Test", 1, sb5.toString());
        }
        if (f46642m || j3 > 50) {
            QLog.i("DbCacheDatabase.CacheManager.Database_Test_Stack", 1, Log.getStackTraceString(new Throwable()));
        }
    }

    private void G(SQLiteDatabase sQLiteDatabase) {
        String str = "ALTER TABLE " + this.f46646d + " RENAME TO " + (this.f46646d + "_temp");
        sQLiteDatabase.execSQL(str);
        this.f46647e = false;
        if (QZLog.isColorLevel()) {
            QZLog.w("DbCacheDatabase.CacheManager", "remaneTable sql:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String K(long j3, int i3, String str) {
        return String.valueOf(j3) + "_" + str + "_" + i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0108 A[Catch: Exception -> 0x0186, TRY_LEAVE, TryCatch #0 {Exception -> 0x0186, blocks: (B:15:0x008d, B:19:0x0099, B:21:0x009f, B:23:0x00a7, B:25:0x00aa, B:27:0x00b2, B:29:0x00bb, B:32:0x00c5, B:34:0x00ce, B:35:0x00dc, B:38:0x00e7, B:40:0x00ed, B:41:0x00fb, B:43:0x0108, B:46:0x0113, B:48:0x0120, B:49:0x0150, B:51:0x016a, B:55:0x00f0, B:58:0x00f8, B:59:0x0165), top: B:14:0x008d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void R() {
        IDBCacheDataWrapper.a aVar;
        if (x()) {
            int version = this.f46643a.version();
            int j3 = u5.c.j(this.f46650h + this.f46646d + "_cache_db_version", -1, this.f46644b);
            if (j3 == -1) {
                j3 = u5.c.j(this.f46646d + "_cache_db_version", -1, this.f46644b);
            }
            boolean z16 = false;
            if (QZLog.isColorLevel()) {
                QZLog.e("DbCacheDatabase.CacheManager", 1, "mDbName:", this.f46650h, " mTable:", this.f46646d, " preVersion:", Integer.valueOf(j3), " version:", Integer.valueOf(version));
            }
            SQLiteDatabase t16 = t(true);
            if (t16 == null) {
                return;
            }
            try {
                if (y(t16, this.f46646d)) {
                    if (j3 != -1 && j3 != version) {
                        IDBCacheDataWrapper.a aVar2 = this.f46643a;
                        if (aVar2 instanceof IDBCacheDataWrapper.d) {
                            String[] onUpdate = ((IDBCacheDataWrapper.d) aVar2).onUpdate(j3, version);
                            if (onUpdate != null && onUpdate.length > 0) {
                                String str = onUpdate[0];
                                if (!TextUtils.isEmpty(str)) {
                                    if (!str.startsWith("ALTER") && !str.startsWith("DELETE")) {
                                        if (str.startsWith("INSERT")) {
                                            G(t16);
                                            d(t16);
                                            z16 = S(t16, onUpdate);
                                            i(t16);
                                        } else if (str.startsWith("NOTHING")) {
                                            z16 = true;
                                        }
                                    }
                                    z16 = S(t16, onUpdate);
                                }
                            }
                            if (z16) {
                                this.f46647e = true;
                            } else {
                                h(t16);
                            }
                            d(t16);
                            long currentTimeMillis = System.currentTimeMillis();
                            aVar = this.f46643a;
                            if (aVar instanceof IDBCacheDataWrapper.d) {
                                if (((IDBCacheDataWrapper.d) aVar).needEncrypt(j3, version)) {
                                    ArrayList<ContentValues> E = E();
                                    Q(E);
                                    if (QZLog.isColorLevel()) {
                                        QZLog.i("DbCacheDatabase.CacheManager", "encrypt success mTableName:" + this.f46646d + " datasize:" + E.size() + " timecost:" + (System.currentTimeMillis() - currentTimeMillis));
                                    }
                                } else {
                                    QZLog.i("DbCacheDatabase.CacheManager", "encrypt success mTableName:" + this.f46646d);
                                }
                            }
                        }
                    }
                    if (j3 == -1 || j3 != version) {
                        h(t16);
                    }
                    d(t16);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    aVar = this.f46643a;
                    if (aVar instanceof IDBCacheDataWrapper.d) {
                    }
                } else {
                    d(t16);
                }
                if (j3 != version) {
                    u5.c.F(this.f46650h + this.f46646d + "_cache_db_version", version, this.f46644b);
                }
            } catch (Exception e16) {
                QZLog.e("DbCacheDatabase.CacheManager", "updateOrCreateTable error", e16);
                try {
                    h(t16);
                    i(t16);
                    d(t16);
                    if (j3 != version) {
                        u5.c.F(this.f46650h + this.f46646d + "_cache_db_version", version, this.f46644b);
                    }
                } catch (Exception e17) {
                    QZLog.e("DbCacheDatabase.CacheManager", "updateOrCreateTable error", e17);
                }
            }
        }
    }

    private boolean S(SQLiteDatabase sQLiteDatabase, String[] strArr) {
        try {
            b(sQLiteDatabase);
            for (String str : strArr) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                sQLiteDatabase.execSQL(str);
                if (QZLog.isColorLevel()) {
                    QZLog.w("DbCacheDatabase.CacheManager", "updateTable sql:" + str);
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            return true;
        } catch (Exception e16) {
            QZLog.e("DbCacheDatabase.CacheManager", "updateTable1 error", e16);
            return false;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void c() {
        if (isClosed()) {
            return;
        }
        synchronized (this) {
            if (isClosed()) {
                return;
            }
            this.f46652j.e(hashCode());
            this.f46648f = true;
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            QZLog.e("DbCacheDatabase.CacheManager", "db is null,create table fail.");
            return;
        }
        if (this.f46647e) {
            return;
        }
        try {
            String l3 = l();
            if (QZLog.isColorLevel()) {
                QZLog.d("DbCacheDatabase.CacheManager", 2, "create table sql:" + l3);
            }
            if (f46641l) {
                QZLog.i("DbCacheDatabase.CacheManager.Database_Test", 2, "create table sql:" + l3);
            }
            sQLiteDatabase.execSQL(l3);
            String n3 = n();
            if (!TextUtils.isEmpty(n3)) {
                for (String str : n3.split(";")) {
                    if (QZLog.isColorLevel()) {
                        QZLog.d("DbCacheDatabase.CacheManager", 2, "create index sql:" + str);
                    }
                    sQLiteDatabase.execSQL(str);
                }
            }
            this.f46647e = true;
        } catch (SQLException e16) {
            QZLog.e("DbCacheDatabase.CacheManager", "createTableIfNeeded error", e16);
        } catch (Exception e17) {
            QZLog.e("DbCacheDatabase.CacheManager", "createTableIfNeeded error", e17);
        }
    }

    private void h(SQLiteDatabase sQLiteDatabase) {
        String m3 = m();
        sQLiteDatabase.execSQL(m3);
        this.f46647e = false;
        if (QZLog.isColorLevel()) {
            QZLog.i("DbCacheDatabase.CacheManager", 2, "deleteTable sql:", m3);
        }
    }

    private void i(SQLiteDatabase sQLiteDatabase) {
        String str = "DROP TABLE IF EXISTS " + (this.f46646d + "_temp");
        sQLiteDatabase.execSQL(str);
        if (QZLog.isColorLevel()) {
            QZLog.w("DbCacheDatabase.CacheManager", "dropTable sql:" + str);
        }
    }

    public static String k(long j3, int i3) {
        if (i3 == c.f46667e) {
            if (MobileQQ.sMobileQQ != null) {
                return SecurityUtil.c(j3 + "_" + MobileQQ.sMobileQQ.getQQProcessName());
            }
            return SecurityUtil.c(String.valueOf(j3));
        }
        if (i3 == c.f46668f && j3 == -1) {
            return SecurityUtil.c(String.valueOf(j3));
        }
        if (i3 == c.f46669g) {
            return SecurityUtil.c(String.valueOf(-j3));
        }
        return SecurityUtil.c(String.valueOf(j3 + i3));
    }

    private String l() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CREATE TABLE IF NOT EXISTS " + this.f46646d + " (");
        sb5.append("_id INTEGER PRIMARY KEY");
        Iterator<IDBCacheDataWrapper.c> it = this.f46651i.iterator();
        while (it.hasNext()) {
            IDBCacheDataWrapper.c next = it.next();
            sb5.append(',');
            sb5.append(next.f48306a);
            sb5.append(TokenParser.SP);
            sb5.append(next.f48307b);
        }
        sb5.append(')');
        return sb5.toString();
    }

    private String m() {
        return "DROP TABLE IF EXISTS " + this.f46646d;
    }

    private String n() {
        IDBCacheDataWrapper.a aVar = this.f46643a;
        if (aVar != null && (aVar instanceof IDBCacheDataWrapper.b)) {
            try {
                return ((IDBCacheDataWrapper.b) aVar).indexRawSql(this.f46646d);
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }
        return null;
    }

    private SQLiteDatabase t(boolean z16) {
        if (isClosed()) {
            return null;
        }
        return this.f46652j.i(z16);
    }

    private void u(String str, Throwable th5) {
        QZLog.w("DbCacheDatabase.CacheManager", str, th5);
        try {
            DbCacheExceptionHandler.b().c(th5, this.f46650h);
        } catch (Throwable th6) {
            QZLog.w(th6);
        }
    }

    private void v(Class<? extends IDBCacheDataWrapper> cls) {
        String name = cls.getName();
        IDBCacheDataWrapper.a aVar = null;
        try {
            aVar = (IDBCacheDataWrapper.a) cls.getField("DB_CREATOR").get(null);
        } catch (Throwable th5) {
            QZLog.w(th5);
        }
        if (aVar == null) {
            return;
        }
        this.f46643a = aVar;
        IDBCacheDataWrapper.c[] structure = aVar.structure();
        if (structure != null) {
            for (IDBCacheDataWrapper.c cVar : structure) {
                if (cVar != null) {
                    this.f46651i.add(cVar);
                }
            }
        }
        if (this.f46651i.size() != 0) {
            return;
        }
        throw new BadCacheDataException("CacheData protocol requires a valid CacheData.Structure from CacheData.Creator object called  CREATOR on class " + name);
    }

    private boolean y(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z16 = false;
        Cursor cursor = null;
        try {
        } catch (Exception e16) {
            QZLog.e("DbCacheDatabase.CacheManager", "", e16);
        }
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='" + str + "'", null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    if (cursor.getInt(0) == 1) {
                        z16 = true;
                    }
                }
            } catch (Exception e17) {
                QZLog.e("DbCacheDatabase.CacheManager", "", e17);
                if (cursor != null) {
                    cursor.close();
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return z16;
        } catch (Throwable th5) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e18) {
                    QZLog.e("DbCacheDatabase.CacheManager", "", e18);
                }
            }
            throw th5;
        }
    }

    private void z() {
        A();
    }

    protected abstract void A();

    protected abstract void B();

    public ArrayList<ContentValues> E() {
        ArrayList<ContentValues> arrayList = new ArrayList<>();
        synchronized (this) {
            ArrayList<String> h16 = this.f46652j.g().h(this.f46646d);
            if (h16 != null && h16.size() != 0) {
                ArrayList arrayList2 = (ArrayList) h16.clone();
                arrayList2.add(0, "_id");
                String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                Cursor r16 = r(strArr, null, null, null, null);
                try {
                    if (r16 != null) {
                        try {
                            r16.moveToFirst();
                            while (!r16.isAfterLast()) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("_id", Integer.valueOf(r16.getInt(r16.getColumnIndex("_id"))));
                                for (int i3 = 1; i3 < strArr.length; i3++) {
                                    String str = strArr[i3];
                                    contentValues.put(str, r16.getString(r16.getColumnIndex(str)));
                                }
                                arrayList.add(contentValues);
                                r16.moveToNext();
                            }
                        } catch (Exception e16) {
                            QZLog.e("DbCacheDatabase.CacheManager", 1, e16, new Object[0]);
                            try {
                                r16.close();
                            } catch (Exception e17) {
                                QZLog.e("DbCacheDatabase.CacheManager", 1, e17, new Object[0]);
                            }
                        }
                    }
                    if (r16 != null) {
                        try {
                            r16.close();
                        } catch (Exception e18) {
                            QZLog.e("DbCacheDatabase.CacheManager", 1, e18, new Object[0]);
                        }
                    }
                    return arrayList;
                } catch (Throwable th5) {
                    try {
                        r16.close();
                    } catch (Exception e19) {
                        QZLog.e("DbCacheDatabase.CacheManager", 1, e19, new Object[0]);
                    }
                    throw th5;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Cursor F(String str, String[] strArr) {
        SQLiteDatabase t16;
        Cursor cursor;
        long currentTimeMillis;
        if (TextUtils.isEmpty(str) || isClosed() || (t16 = t(false)) == null) {
            return null;
        }
        if (f46640k) {
            QZLog.d("DbCacheDatabase.CacheManager", 4, "rawQuery--sql:" + str);
        }
        try {
            currentTimeMillis = System.currentTimeMillis();
            cursor = t16.rawQuery(str, strArr);
        } catch (Throwable th5) {
            th = th5;
            cursor = null;
        }
        try {
            D(this.f46650h, this.f46646d, str, strArr, System.currentTimeMillis() - currentTimeMillis);
        } catch (Throwable th6) {
            th = th6;
            u("fail to rawQuery obtain cursor for ", th);
            if (cursor == null) {
            }
        }
        if (cursor == null) {
            return new d(cursor, this.f46650h);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean H(int i3, String str, String[] strArr, Collection<? extends IDBCacheDataWrapper> collection) {
        SQLiteDatabase t16;
        if (isClosed() || collection == null || (t16 = t(true)) == null) {
            return false;
        }
        if (f46640k) {
            QZLog.d("DbCacheDatabase.CacheManager", 4, "save--table:" + this.f46646d + ",strategy:" + i3 + ",where:" + str);
        }
        try {
            com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
            b(t16);
            C(t16, i3, str, strArr);
            for (IDBCacheDataWrapper iDBCacheDataWrapper : collection) {
                if (iDBCacheDataWrapper != null && w(t16, iDBCacheDataWrapper) == -1) {
                    return false;
                }
            }
            t16.setTransactionSuccessful();
            try {
                t16.endTransaction();
                com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
            } catch (Throwable th5) {
                u("fail to end transaction", th5);
            }
            z();
            return true;
        } catch (Throwable th6) {
            try {
                u("fail to save data", th6);
                try {
                    t16.endTransaction();
                    com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
                } catch (Throwable th7) {
                    u("fail to end transaction", th7);
                }
                return false;
            } finally {
                try {
                    t16.endTransaction();
                    com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
                } catch (Throwable th8) {
                    u("fail to end transaction", th8);
                }
            }
        }
    }

    public boolean I(int i3, String str, String[] strArr, IDBCacheDataWrapper... iDBCacheDataWrapperArr) {
        SQLiteDatabase t16;
        if (isClosed() || iDBCacheDataWrapperArr == null || (t16 = t(true)) == null) {
            return false;
        }
        if (f46640k) {
            QZLog.d("DbCacheDatabase.CacheManager", 4, "save--table:" + this.f46646d + ",strategy:" + i3 + ",where:" + str);
        }
        try {
            com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
            b(t16);
            C(t16, i3, str, strArr);
            for (IDBCacheDataWrapper iDBCacheDataWrapper : iDBCacheDataWrapperArr) {
                if (iDBCacheDataWrapper != null && w(t16, iDBCacheDataWrapper) == -1) {
                    return false;
                }
            }
            t16.setTransactionSuccessful();
            try {
                t16.endTransaction();
                com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
            } catch (Throwable th5) {
                u("fail to end transaction", th5);
            }
            z();
            return true;
        } catch (Throwable th6) {
            try {
                u("fail to save data", th6);
                try {
                    t16.endTransaction();
                    com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
                } catch (Throwable th7) {
                    u("fail to end transaction", th7);
                }
                return false;
            } finally {
                try {
                    t16.endTransaction();
                    com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
                } catch (Throwable th8) {
                    u("fail to end transaction", th8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String J() {
        return K(this.f46644b, this.f46645c, this.f46646d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x002b -> B:14:0x003c). Please report as a decompilation issue!!! */
    public int L(ContentValues contentValues, String str, String[] strArr) {
        int i3 = 0;
        if (isClosed() || contentValues == null) {
            return 0;
        }
        SQLiteDatabase t16 = t(true);
        try {
        } catch (Throwable th5) {
            u("fail to end transaction", th5);
        }
        if (t16 == null) {
            return 0;
        }
        try {
            com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
            b(t16);
            i3 = M(t16, contentValues, str, strArr);
            t16.setTransactionSuccessful();
            t16.endTransaction();
            com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        } catch (Throwable th6) {
            try {
                u("fail to update data", th6);
                t16.endTransaction();
                com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
            } catch (Throwable th7) {
                try {
                    t16.endTransaction();
                    com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
                } catch (Throwable th8) {
                    u("fail to end transaction", th8);
                }
                throw th7;
            }
        }
        if (f46640k) {
            QZLog.d("DbCacheDatabase.CacheManager", 4, "update--table:" + this.f46646d + ",updated:" + i3 + ",where:" + str);
        }
        if (i3 > 0) {
            z();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x003f -> B:19:0x0050). Please report as a decompilation issue!!! */
    public int P(String[] strArr, String[] strArr2, String str, String[] strArr3) {
        SQLiteDatabase t16;
        int i3 = 0;
        if (isClosed() || strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return 0;
        }
        if ((strArr3 != null && strArr3.length != strArr.length) || (t16 = t(true)) == null) {
            return 0;
        }
        try {
            try {
                com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
                b(t16);
                i3 = N(t16, strArr, strArr2, str, strArr3);
                t16.setTransactionSuccessful();
                t16.endTransaction();
                com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
            } catch (Throwable th5) {
                u("fail to end transaction", th5);
            }
        } catch (Throwable th6) {
            try {
                u("fail to update data", th6);
                t16.endTransaction();
                com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
            } catch (Throwable th7) {
                try {
                    t16.endTransaction();
                    com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
                } catch (Throwable th8) {
                    u("fail to end transaction", th8);
                }
                throw th7;
            }
        }
        if (f46640k) {
            QZLog.d("DbCacheDatabase.CacheManager", 4, "update--table:" + this.f46646d + ",updated:" + i3 + ",where:" + str);
        }
        if (i3 > 0) {
            z();
        }
        return i3;
    }

    public int Q(ArrayList<ContentValues> arrayList) {
        SQLiteDatabase t16;
        int i3 = 0;
        if (isClosed() || arrayList == null || arrayList.size() == 0 || (t16 = t(true)) == null) {
            return 0;
        }
        try {
            com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
            b(t16);
            int i16 = 0;
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                i16 += M(t16, arrayList.get(i17), "_id=?", new String[]{arrayList.get(i17).getAsString("_id")});
            }
            t16.setTransactionSuccessful();
            try {
                t16.endTransaction();
                com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
            } catch (Throwable th5) {
                u("fail to end transaction", th5);
            }
            i3 = i16;
        } catch (Throwable th6) {
            try {
                u("fail to update data", th6);
            } finally {
                try {
                    t16.endTransaction();
                    com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
                } catch (Throwable th7) {
                    u("fail to end transaction", th7);
                }
            }
        }
        if (f46640k) {
            QZLog.d("DbCacheDatabase.CacheManager", 4, "update--table:" + this.f46646d + ",updated:" + i3 + ",where:");
        }
        return i3;
    }

    public void close() {
        c();
        B();
    }

    public int e(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        IDBCacheDataWrapper.a aVar = this.f46643a;
        if ((aVar instanceof IDBCacheDataWrapper.b) && strArr == null) {
            return ((IDBCacheDataWrapper.b) aVar).delRawSql(sQLiteDatabase, this.f46646d, str);
        }
        this.f46652j.g().e(this.f46650h, this.f46646d, str, strArr);
        long currentTimeMillis = System.currentTimeMillis();
        int delete = sQLiteDatabase.delete(this.f46646d, str, strArr);
        D(this.f46650h, this.f46646d, str, strArr, System.currentTimeMillis() - currentTimeMillis);
        return delete;
    }

    public int f(String str, String[] strArr) {
        SQLiteDatabase t16;
        int i3 = 0;
        if (isClosed() || (t16 = t(true)) == null) {
            return 0;
        }
        try {
            i3 = e(t16, str, strArr);
        } catch (Throwable th5) {
            u("fail to delete data", th5);
        }
        if (f46640k) {
            QZLog.d("DbCacheDatabase.CacheManager", 4, "delete--table:" + this.f46646d + ",deleted:" + i3 + ",where:" + str);
        }
        z();
        return i3;
    }

    public void finalize() throws Throwable {
        try {
            try {
                c();
            } catch (Exception e16) {
                QZLog.e("DbCacheDatabase.CacheManager", "close error", e16);
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public int g(Collection<String> collection) {
        int i3 = 0;
        if (isClosed()) {
            return 0;
        }
        SQLiteDatabase t16 = t(true);
        try {
        } catch (Throwable th5) {
            u("fail to end transaction", th5);
        }
        if (t16 == null) {
            return 0;
        }
        try {
            com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
            b(t16);
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                i3 += e(t16, it.next(), null);
            }
            t16.setTransactionSuccessful();
            t16.endTransaction();
            com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        } catch (Throwable th6) {
            try {
                u("fail to delete data", th6);
                t16.endTransaction();
                com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
            } catch (Throwable th7) {
                try {
                    t16.endTransaction();
                    com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
                } catch (Throwable th8) {
                    u("fail to end transaction", th8);
                }
                throw th7;
            }
        }
        if (f46640k) {
            QZLog.d("DbCacheDatabase.CacheManager", 4, "delete--table:" + this.f46646d + ",deleted:" + i3 + ",where:" + collection);
        }
        z();
        return i3;
    }

    public boolean isClosed() {
        return this.f46648f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(String str) {
        SQLiteDatabase t16;
        if (TextUtils.isEmpty(str) || isClosed() || (t16 = t(true)) == null) {
            return;
        }
        try {
            if (QZLog.isColorLevel()) {
                QZLog.d("DbCacheDatabase.CacheManager", 2, "execSQL--sql:" + str);
            }
            long currentTimeMillis = System.currentTimeMillis();
            t16.execSQL(str);
            D(this.f46650h, this.f46646d, str, null, System.currentTimeMillis() - currentTimeMillis);
        } catch (Throwable th5) {
            u("fail to execSQL for " + str, th5);
        }
        z();
    }

    public String s() {
        return this.f46650h;
    }

    final long w(SQLiteDatabase sQLiteDatabase, IDBCacheDataWrapper iDBCacheDataWrapper) {
        ContentValues contentValues = new ContentValues();
        iDBCacheDataWrapper.writeTo(contentValues);
        return sQLiteDatabase.replaceOrThrow(this.f46646d, null, this.f46652j.g().d(this.f46650h, this.f46646d, contentValues));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean x() {
        return this.f46643a != null;
    }

    public static void b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        if (b.E) {
            sQLiteDatabase.beginTransactionNonExclusive();
        } else {
            sQLiteDatabase.beginTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IDBCacheDataWrapper o(Cursor cursor, int i3) {
        if (cursor == null || cursor.isClosed() || i3 < 0 || i3 >= cursor.getCount() || !cursor.moveToPosition(i3) || !x()) {
            return null;
        }
        if (!(cursor instanceof d)) {
            cursor = new d(cursor, this.f46650h);
        }
        try {
            return this.f46643a.createFromCursor(cursor);
        } catch (OutOfMemoryError e16) {
            if (this.f46649g) {
                return null;
            }
            this.f46649g = true;
            SQLiteDatabase t16 = t(true);
            if (t16 != null) {
                try {
                    h(t16);
                    d(t16);
                } catch (Exception e17) {
                    QZLog.w(e17);
                }
            }
            QZLog.w(e16);
            return null;
        } catch (Throwable th5) {
            QZLog.e("DbCacheDatabase.CacheManager", "", th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cursor q(String str, String str2, String[] strArr, String str3, String str4) {
        return r(str != null ? new String[]{str} : null, str2, strArr, str3, str4);
    }

    protected void C(SQLiteDatabase sQLiteDatabase, int i3, String str, String[] strArr) {
        if (i3 != 2) {
            return;
        }
        e(sQLiteDatabase, str, strArr);
    }

    final int M(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f46652j.g().e(this.f46650h, this.f46646d, str, strArr);
        D(this.f46650h, this.f46646d, str, strArr, System.currentTimeMillis() - currentTimeMillis);
        return sQLiteDatabase.update(this.f46646d, this.f46652j.g().d(this.f46650h, this.f46646d, contentValues), str, strArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O(IDBCacheDataWrapper iDBCacheDataWrapper, String str, String[] strArr) {
        if (iDBCacheDataWrapper == null) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        iDBCacheDataWrapper.writeTo(contentValues);
        return L(contentValues, str, strArr);
    }

    final int N(SQLiteDatabase sQLiteDatabase, String[] strArr, String[] strArr2, String str, String[] strArr3) {
        ContentValues contentValues = new ContentValues();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            contentValues.put(strArr[i3], strArr2[i3]);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f46652j.g().e(this.f46650h, this.f46646d, str, strArr3);
        D(this.f46650h, this.f46646d, str, strArr3, System.currentTimeMillis() - currentTimeMillis);
        return sQLiteDatabase.update(this.f46646d, this.f46652j.g().d(this.f46650h, this.f46646d, contentValues), str, strArr3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cursor p(String str, String[] strArr, String str2, String str3) {
        return q(null, str, strArr, str2, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Cursor r(String[] strArr, String str, String[] strArr2, String str2, String str3) {
        SQLiteDatabase t16;
        Cursor cursor;
        String str4;
        Throwable th5;
        String str5 = str2;
        if (isClosed() || (t16 = t(false)) == null) {
            return null;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("DbCacheDatabase.CacheManager", 2, "query begin, table=" + this.f46646d + ", selection=" + str + ", sortOrder=" + str5 + ", limit=" + str3 + ", args: " + Arrays.toString(strArr2));
        }
        if (str5 == null) {
            try {
                if (x()) {
                    str5 = this.f46643a.sortOrder();
                }
            } catch (Throwable th6) {
                th5 = th6;
                str4 = str;
                cursor = null;
                u("fail to obtain cursor for " + str4, th5);
                if (cursor != null) {
                }
            }
        }
        String str6 = str5;
        this.f46652j.g().e(this.f46650h, this.f46646d, str, strArr2);
        long currentTimeMillis = System.currentTimeMillis();
        cursor = t16.query(this.f46646d, strArr, str, strArr2, null, null, str6, str3);
        try {
            str4 = str;
        } catch (Throwable th7) {
            th5 = th7;
            str4 = str;
        }
        try {
            D(this.f46650h, this.f46646d, str, strArr2, System.currentTimeMillis() - currentTimeMillis);
        } catch (Throwable th8) {
            th5 = th8;
            u("fail to obtain cursor for " + str4, th5);
            if (cursor != null) {
            }
        }
        if (cursor != null) {
            return new d(cursor, this.f46650h);
        }
        return null;
    }
}
