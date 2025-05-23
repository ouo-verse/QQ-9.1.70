package com.tencent.mobileqq.qcircle.api.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Log;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class AbstractDbCacheManager {

    /* renamed from: k, reason: collision with root package name */
    private static boolean f261621k = false;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f261622l = false;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f261623m = false;

    /* renamed from: a, reason: collision with root package name */
    protected IDBCacheDataWrapper.DbCreator f261624a;

    /* renamed from: b, reason: collision with root package name */
    private long f261625b;

    /* renamed from: c, reason: collision with root package name */
    private int f261626c;

    /* renamed from: d, reason: collision with root package name */
    protected String f261627d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f261628e;

    /* renamed from: h, reason: collision with root package name */
    private String f261631h;

    /* renamed from: j, reason: collision with root package name */
    private a f261633j;

    /* renamed from: f, reason: collision with root package name */
    private boolean f261629f = false;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f261630g = false;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<IDBCacheDataWrapper.Structure> f261632i = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class BadCacheDataException extends AndroidRuntimeException {
        public BadCacheDataException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDbCacheManager(Context context, Class<? extends IDBCacheDataWrapper> cls, long j3, int i3, int i16, String str, int i17) {
        this.f261631h = null;
        Context applicationContext = context.getApplicationContext();
        String j16 = j(j3, i3);
        this.f261631h = j16;
        a e16 = a.e(applicationContext, j16, i16, i17);
        this.f261633j = e16;
        e16.attach(hashCode());
        this.f261625b = j3;
        this.f261626c = i3;
        this.f261627d = str;
        v(cls);
        S();
    }

    private void D(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "mDbName:", this.f261631h, " mTable:", this.f261627d, " preVersion:", Integer.valueOf(i3), " version:", Integer.valueOf(i16));
        }
    }

    private void E(ArrayList<ContentValues> arrayList, long j3) {
        if (arrayList != null && QLog.isColorLevel()) {
            QLog.i("QCircleDbCacheDatabase.CacheManager", 1, "encrypt success mTableName:" + this.f261627d + " datasize:" + arrayList.size() + " timecost:" + (System.currentTimeMillis() - j3));
        }
    }

    private void F(String str, String str2, String str3, String[] strArr, long j3) {
        if (f261622l || j3 > 50) {
            QLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test", 1, "db:" + str + " table:" + str2 + " selection:" + str3 + " args:" + Arrays.toString(strArr));
            StringBuilder sb5 = new StringBuilder();
            sb5.append("timecost: ");
            sb5.append(j3);
            QLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test", 1, sb5.toString());
        }
        if (f261623m || j3 > 50) {
            QLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test_Stack", 1, Log.getStackTraceString(new Throwable()));
        }
    }

    private void I(SQLiteDatabase sQLiteDatabase) {
        String str = "ALTER TABLE " + this.f261627d + " RENAME TO " + (this.f261627d + "_temp");
        sQLiteDatabase.execSQL(str);
        this.f261628e = false;
        if (QLog.isColorLevel()) {
            QLog.w("QCircleDbCacheDatabase.CacheManager", 1, "remaneTable sql:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String M(long j3, int i3, String str) {
        return String.valueOf(j3) + "_" + str + "_" + i3;
    }

    private void R(int i3, int i16, SQLiteDatabase sQLiteDatabase) {
        if (i16 != -1 && i16 != i3 && (this.f261624a instanceof IDBCacheDataWrapper.UpdateDbCreator)) {
            if (g(i3, i16, sQLiteDatabase)) {
                this.f261628e = true;
            } else {
                f(sQLiteDatabase);
            }
        } else if (i16 == -1 || i16 != i3) {
            f(sQLiteDatabase);
        }
        c(sQLiteDatabase);
        i(i3, i16);
    }

    private void S() {
        if (!x()) {
            return;
        }
        int version = this.f261624a.version();
        int s16 = s();
        D(s16, version);
        SQLiteDatabase t16 = t(true);
        if (t16 == null) {
            return;
        }
        try {
            if (y(t16, this.f261627d)) {
                R(version, s16, t16);
            } else {
                c(t16);
            }
            U(version, s16);
        } catch (Exception e16) {
            QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "updateOrCreateTable error", e16);
            try {
                f(t16);
                h(t16);
                c(t16);
                U(version, s16);
            } catch (Exception e17) {
                QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "updateOrCreateTable error", e17);
            }
        }
    }

    private boolean T(SQLiteDatabase sQLiteDatabase, String[] strArr) {
        try {
            a(sQLiteDatabase);
            for (String str : strArr) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                sQLiteDatabase.execSQL(str);
                if (QLog.isColorLevel()) {
                    QLog.w("QCircleDbCacheDatabase.CacheManager", 1, "updateTable sql:" + str);
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            return true;
        } catch (Exception e16) {
            QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "updateTable1 error", e16);
            return false;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void U(int i3, int i16) {
        if (i16 != i3) {
            LocalMultiProcConfig.putInt4Uin(this.f261631h + this.f261627d + "_cache_db_version", i3, this.f261625b);
        }
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        if (a.E) {
            sQLiteDatabase.beginTransactionNonExclusive();
        } else {
            sQLiteDatabase.beginTransaction();
        }
    }

    private void b() {
        if (isClosed()) {
            return;
        }
        synchronized (this) {
            if (isClosed()) {
                return;
            }
            this.f261633j.detach(hashCode());
            this.f261629f = true;
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "db is null,create table fail.");
            return;
        }
        if (!this.f261628e) {
            try {
                String k3 = k();
                if (QLog.isColorLevel()) {
                    QLog.d("QCircleDbCacheDatabase.CacheManager", 2, "create table sql:" + k3);
                }
                if (f261622l) {
                    QLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test", 2, "create table sql:" + k3);
                }
                sQLiteDatabase.execSQL(k3);
                String m3 = m();
                if (!TextUtils.isEmpty(m3)) {
                    for (String str : m3.split(";")) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QCircleDbCacheDatabase.CacheManager", 2, "create index sql:" + str);
                        }
                        sQLiteDatabase.execSQL(str);
                    }
                }
                this.f261628e = true;
            } catch (SQLException e16) {
                QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "createTableIfNeeded error", e16);
            } catch (Exception e17) {
                QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "createTableIfNeeded error", e17);
            }
        }
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        String l3 = l();
        sQLiteDatabase.execSQL(l3);
        this.f261628e = false;
        if (QLog.isColorLevel()) {
            QLog.i("QCircleDbCacheDatabase.CacheManager", 2, "deleteTable sql:" + l3);
        }
    }

    private boolean g(int i3, int i16, SQLiteDatabase sQLiteDatabase) {
        String[] onUpdate;
        IDBCacheDataWrapper.DbCreator dbCreator = this.f261624a;
        if (dbCreator == null || (onUpdate = ((IDBCacheDataWrapper.UpdateDbCreator) dbCreator).onUpdate(i16, i3)) == null || onUpdate.length <= 0) {
            return false;
        }
        String str = onUpdate[0];
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("ALTER") && !str.startsWith("DELETE")) {
            if (str.startsWith("INSERT")) {
                I(sQLiteDatabase);
                c(sQLiteDatabase);
                boolean T = T(sQLiteDatabase, onUpdate);
                h(sQLiteDatabase);
                return T;
            }
            if (!str.startsWith("NOTHING")) {
                return false;
            }
            return true;
        }
        return T(sQLiteDatabase, onUpdate);
    }

    private void h(SQLiteDatabase sQLiteDatabase) {
        String str = "DROP TABLE IF EXISTS " + (this.f261627d + "_temp");
        sQLiteDatabase.execSQL(str);
        if (QLog.isColorLevel()) {
            QLog.w("QCircleDbCacheDatabase.CacheManager", 1, "dropTable sql:" + str);
        }
    }

    private void i(int i3, int i16) {
        long currentTimeMillis = System.currentTimeMillis();
        IDBCacheDataWrapper.DbCreator dbCreator = this.f261624a;
        if (!(dbCreator instanceof IDBCacheDataWrapper.UpdateDbCreator)) {
            return;
        }
        if (((IDBCacheDataWrapper.UpdateDbCreator) dbCreator).needEncrypt(i16, i3)) {
            ArrayList<ContentValues> G = G();
            Q(G);
            E(G, currentTimeMillis);
        } else {
            QLog.i("QCircleDbCacheDatabase.CacheManager", 1, "encrypt success mTableName:" + this.f261627d);
        }
    }

    public static String j(long j3, int i3) {
        if (i3 == b.f261648e) {
            if (!TextUtils.isEmpty(QCircleHostStubUtil.getQQProcessName())) {
                return wd2.b.b(j3 + "_qcircle_" + QCircleHostStubUtil.getQQProcessName());
            }
            return wd2.b.b(j3 + "_qcircle");
        }
        if (i3 == b.f261649f && j3 == -1) {
            return wd2.b.b(String.valueOf(j3));
        }
        if (i3 == b.f261650g) {
            return wd2.b.b(String.valueOf(-j3));
        }
        return wd2.b.b(String.valueOf(j3 + i3));
    }

    private String k() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CREATE TABLE IF NOT EXISTS " + this.f261627d + " (");
        sb5.append("_id INTEGER PRIMARY KEY");
        Iterator<IDBCacheDataWrapper.Structure> it = this.f261632i.iterator();
        while (it.hasNext()) {
            IDBCacheDataWrapper.Structure next = it.next();
            sb5.append(',');
            sb5.append(next.mName);
            sb5.append(TokenParser.SP);
            sb5.append(next.mType);
        }
        sb5.append(')');
        return sb5.toString();
    }

    private String l() {
        return "DROP TABLE IF EXISTS " + this.f261627d;
    }

    private String m() {
        IDBCacheDataWrapper.DbCreator dbCreator = this.f261624a;
        if (dbCreator != null && (dbCreator instanceof IDBCacheDataWrapper.RawDbCreator)) {
            try {
                return ((IDBCacheDataWrapper.RawDbCreator) dbCreator).indexRawSql(this.f261627d);
            } catch (Exception e16) {
                QLog.w("QCircleDbCacheDatabase.CacheManager", 1, e16.getMessage());
            }
        }
        return null;
    }

    private int s() {
        int int4Uin = LocalMultiProcConfig.getInt4Uin(this.f261631h + this.f261627d + "_cache_db_version", -1, this.f261625b);
        if (int4Uin == -1) {
            return LocalMultiProcConfig.getInt4Uin(this.f261627d + "_cache_db_version", -1, this.f261625b);
        }
        return int4Uin;
    }

    private SQLiteDatabase t(boolean z16) {
        if (isClosed()) {
            return null;
        }
        return this.f261633j.f(z16);
    }

    private void u(String str, Throwable th5) {
        QLog.w("QCircleDbCacheDatabase.CacheManager", 1, str + th5.getMessage());
        try {
            DbCacheExceptionHandler.b().c(th5, this.f261631h);
        } catch (Throwable th6) {
            QLog.w("QCircleDbCacheDatabase.CacheManager", 1, th6.getMessage());
        }
    }

    private void v(Class<? extends IDBCacheDataWrapper> cls) {
        String name = cls.getName();
        IDBCacheDataWrapper.DbCreator dbCreator = null;
        try {
            dbCreator = (IDBCacheDataWrapper.DbCreator) cls.getField("DB_CREATOR").get(null);
        } catch (Throwable th5) {
            QLog.w("QCircleDbCacheDatabase.CacheManager", 1, th5.getMessage());
        }
        if (dbCreator == null) {
            return;
        }
        this.f261624a = dbCreator;
        IDBCacheDataWrapper.Structure[] structure = dbCreator.structure();
        if (structure != null) {
            for (IDBCacheDataWrapper.Structure structure2 : structure) {
                if (structure2 != null) {
                    this.f261632i.add(structure2);
                }
            }
        }
        if (this.f261632i.size() != 0) {
            return;
        }
        throw new BadCacheDataException("CacheData protocol requires a valid CacheData.Structure from CacheData.Creator object called  CREATOR on class " + name);
    }

    private boolean y(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z16 = false;
        Cursor cursor = null;
        try {
        } catch (Exception e16) {
            QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "", e16);
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
                QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "", e17);
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
                    QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "", e18);
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

    protected void C(SQLiteDatabase sQLiteDatabase, int i3, String str, String[] strArr) {
        if (i3 != 2) {
            return;
        }
        d(sQLiteDatabase, str, strArr);
    }

    public ArrayList<ContentValues> G() {
        ArrayList<ContentValues> arrayList = new ArrayList<>();
        synchronized (this) {
            ArrayList<String> h16 = this.f261633j.d().h(this.f261627d);
            if (h16 != null && h16.size() != 0) {
                ArrayList arrayList2 = (ArrayList) h16.clone();
                arrayList2.add(0, "_id");
                String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                Cursor q16 = q(strArr, null, null, null, null);
                try {
                    if (q16 != null) {
                        try {
                            q16.moveToFirst();
                            while (!q16.isAfterLast()) {
                                ContentValues contentValues = new ContentValues();
                                int columnIndex = q16.getColumnIndex("_id");
                                if (columnIndex >= 0) {
                                    contentValues.put("_id", Integer.valueOf(q16.getInt(columnIndex)));
                                }
                                for (int i3 = 1; i3 < strArr.length; i3++) {
                                    int columnIndex2 = q16.getColumnIndex(strArr[i3]);
                                    if (columnIndex2 >= 0) {
                                        contentValues.put(strArr[i3], q16.getString(columnIndex2));
                                    }
                                }
                                arrayList.add(contentValues);
                                q16.moveToNext();
                            }
                        } catch (Exception e16) {
                            QLog.e("QCircleDbCacheDatabase.CacheManager", 1, e16, new Object[0]);
                            try {
                                q16.close();
                            } catch (Exception e17) {
                                QLog.e("QCircleDbCacheDatabase.CacheManager", 1, e17, new Object[0]);
                            }
                        }
                    }
                    if (q16 != null) {
                        try {
                            q16.close();
                        } catch (Exception e18) {
                            QLog.e("QCircleDbCacheDatabase.CacheManager", 1, e18, new Object[0]);
                        }
                    }
                    return arrayList;
                } catch (Throwable th5) {
                    try {
                        q16.close();
                    } catch (Exception e19) {
                        QLog.e("QCircleDbCacheDatabase.CacheManager", 1, e19, new Object[0]);
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
    public Cursor H(String str, String[] strArr) {
        SQLiteDatabase t16;
        Cursor cursor;
        long currentTimeMillis;
        if (TextUtils.isEmpty(str) || isClosed() || (t16 = t(false)) == null) {
            return null;
        }
        if (f261621k) {
            QLog.d("QCircleDbCacheDatabase.CacheManager", 4, "rawQuery--sql:" + str);
        }
        try {
            currentTimeMillis = System.currentTimeMillis();
            cursor = t16.rawQuery(str, strArr);
        } catch (Throwable th5) {
            th = th5;
            cursor = null;
        }
        try {
            F(this.f261631h, this.f261627d, str, strArr, System.currentTimeMillis() - currentTimeMillis);
        } catch (Throwable th6) {
            th = th6;
            u("fail to rawQuery obtain cursor for ", th);
            if (cursor != null) {
            }
        }
        if (cursor != null) {
            return null;
        }
        return new c(cursor, this.f261631h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean J(int i3, String str, String[] strArr, Collection<? extends IDBCacheDataWrapper> collection) {
        SQLiteDatabase t16;
        if (isClosed() || collection == null || (t16 = t(true)) == null) {
            return false;
        }
        if (f261621k) {
            QLog.d("QCircleDbCacheDatabase.CacheManager", 4, "save--table:" + this.f261627d + ",strategy:" + i3 + ",where:" + str);
        }
        try {
            com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
            a(t16);
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

    public boolean K(int i3, String str, String[] strArr, IDBCacheDataWrapper... iDBCacheDataWrapperArr) {
        SQLiteDatabase t16;
        if (isClosed() || iDBCacheDataWrapperArr == null || (t16 = t(true)) == null) {
            return false;
        }
        if (f261621k) {
            QLog.d("QCircleDbCacheDatabase.CacheManager", 4, "save--table:" + this.f261627d + ",strategy:" + i3 + ",where:" + str);
        }
        try {
            com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
            a(t16);
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
    public final String L() {
        return M(this.f261625b, this.f261626c, this.f261627d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x002b -> B:14:0x003c). Please report as a decompilation issue!!! */
    public int N(ContentValues contentValues, String str, String[] strArr) {
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
            a(t16);
            i3 = O(t16, contentValues, str, strArr);
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
        if (f261621k) {
            QLog.d("QCircleDbCacheDatabase.CacheManager", 4, "update--table:" + this.f261627d + ",updated:" + i3 + ",where:" + str);
        }
        if (i3 > 0) {
            z();
        }
        return i3;
    }

    final int O(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f261633j.d().e(this.f261631h, this.f261627d, str, strArr);
        F(this.f261631h, this.f261627d, str, strArr, System.currentTimeMillis() - currentTimeMillis);
        return sQLiteDatabase.update(this.f261627d, this.f261633j.d().d(this.f261631h, this.f261627d, contentValues), str, strArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int P(IDBCacheDataWrapper iDBCacheDataWrapper, String str, String[] strArr) {
        if (iDBCacheDataWrapper == null) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        iDBCacheDataWrapper.writeTo(contentValues);
        return N(contentValues, str, strArr);
    }

    public int Q(ArrayList<ContentValues> arrayList) {
        SQLiteDatabase t16;
        int i3 = 0;
        if (isClosed() || arrayList == null || arrayList.size() == 0 || (t16 = t(true)) == null) {
            return 0;
        }
        try {
            com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
            a(t16);
            int i16 = 0;
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                i16 += O(t16, arrayList.get(i17), "_id=?", new String[]{arrayList.get(i17).getAsString("_id")});
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
        if (f261621k) {
            QLog.d("QCircleDbCacheDatabase.CacheManager", 4, "update--table:" + this.f261627d + ",updated:" + i3 + ",where:");
        }
        return i3;
    }

    public void close() {
        b();
        B();
    }

    public int d(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        IDBCacheDataWrapper.DbCreator dbCreator = this.f261624a;
        if ((dbCreator instanceof IDBCacheDataWrapper.RawDbCreator) && strArr == null) {
            return ((IDBCacheDataWrapper.RawDbCreator) dbCreator).delRawSql(sQLiteDatabase, this.f261627d, str);
        }
        this.f261633j.d().e(this.f261631h, this.f261627d, str, strArr);
        long currentTimeMillis = System.currentTimeMillis();
        int delete = sQLiteDatabase.delete(this.f261627d, str, strArr);
        F(this.f261631h, this.f261627d, str, strArr, System.currentTimeMillis() - currentTimeMillis);
        return delete;
    }

    public int e(String str, String[] strArr) {
        SQLiteDatabase t16;
        int i3 = 0;
        if (isClosed() || (t16 = t(true)) == null) {
            return 0;
        }
        try {
            i3 = d(t16, str, strArr);
        } catch (Throwable th5) {
            u("fail to delete data", th5);
        }
        if (f261621k) {
            QLog.d("QCircleDbCacheDatabase.CacheManager", 4, "delete--table:" + this.f261627d + ",deleted:" + i3 + ",where:" + str);
        }
        z();
        return i3;
    }

    protected void finalize() throws Throwable {
        try {
            try {
                b();
            } catch (Exception e16) {
                QLog.e("QCircleDbCacheDatabase.CacheManager", 1, e16, new Object[0]);
            }
        } finally {
            super.finalize();
        }
    }

    public boolean isClosed() {
        return this.f261629f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IDBCacheDataWrapper n(Cursor cursor, int i3) {
        if (cursor == null || cursor.isClosed() || i3 < 0 || i3 >= cursor.getCount() || !cursor.moveToPosition(i3) || !x()) {
            return null;
        }
        if (!(cursor instanceof c)) {
            cursor = new c(cursor, this.f261631h);
        }
        try {
            return this.f261624a.createFromCursor(cursor);
        } catch (OutOfMemoryError e16) {
            if (this.f261630g) {
                return null;
            }
            this.f261630g = true;
            SQLiteDatabase t16 = t(true);
            if (t16 != null) {
                try {
                    f(t16);
                    c(t16);
                } catch (Exception e17) {
                    QLog.w("QCircleDbCacheDatabase.CacheManager", 1, e17.getMessage());
                }
            }
            QLog.w("QCircleDbCacheDatabase.CacheManager", 1, e16.getMessage());
            return null;
        } catch (Throwable th5) {
            QLog.w("QCircleDbCacheDatabase.CacheManager", 1, th5.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cursor o(String str, String[] strArr, String str2, String str3) {
        return p(null, str, strArr, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cursor p(String str, String str2, String[] strArr, String str3, String str4) {
        String[] strArr2;
        if (str != null) {
            strArr2 = new String[]{str};
        } else {
            strArr2 = null;
        }
        return q(strArr2, str2, strArr, str3, str4);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Cursor q(String[] strArr, String str, String[] strArr2, String str2, String str3) {
        SQLiteDatabase t16;
        Cursor cursor;
        String str4;
        Throwable th5;
        String str5 = str2;
        if (isClosed() || (t16 = t(false)) == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QCircleDbCacheDatabase.CacheManager", 2, "query begin, table=" + this.f261627d + ", selection=" + str + ", sortOrder=" + str5 + ", limit=" + str3 + ", args: " + Arrays.toString(strArr2));
        }
        if (str5 == null) {
            try {
                if (x()) {
                    str5 = this.f261624a.sortOrder();
                }
            } catch (Throwable th6) {
                th5 = th6;
                str4 = str;
                cursor = null;
                u("fail to obtain cursor for " + str4, th5);
                if (cursor == null) {
                }
            }
        }
        String str6 = str5;
        this.f261633j.d().e(this.f261631h, this.f261627d, str, strArr2);
        long currentTimeMillis = System.currentTimeMillis();
        cursor = t16.query(this.f261627d, strArr, str, strArr2, null, null, str6, str3);
        try {
            str4 = str;
        } catch (Throwable th7) {
            th5 = th7;
            str4 = str;
        }
        try {
            F(this.f261631h, this.f261627d, str, strArr2, System.currentTimeMillis() - currentTimeMillis);
        } catch (Throwable th8) {
            th5 = th8;
            u("fail to obtain cursor for " + str4, th5);
            if (cursor == null) {
            }
        }
        if (cursor == null) {
            return null;
        }
        return new c(cursor, this.f261631h);
    }

    public String r() {
        return this.f261631h;
    }

    final long w(SQLiteDatabase sQLiteDatabase, IDBCacheDataWrapper iDBCacheDataWrapper) {
        ContentValues contentValues = new ContentValues();
        iDBCacheDataWrapper.writeTo(contentValues);
        return sQLiteDatabase.replaceOrThrow(this.f261627d, null, this.f261633j.d().d(this.f261631h, this.f261627d, contentValues));
    }

    protected boolean x() {
        if (this.f261624a != null) {
            return true;
        }
        return false;
    }
}
