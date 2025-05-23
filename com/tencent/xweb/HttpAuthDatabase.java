package com.tencent.xweb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HttpAuthDatabase {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f384951d = {"_id"};

    /* renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f384952a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f384953b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f384954c = new Object();

    public static HttpAuthDatabase newInstance(final Context context, final String str) {
        HttpAuthDatabase httpAuthDatabase = new HttpAuthDatabase();
        new BaseThread() { // from class: com.tencent.xweb.HttpAuthDatabase.1
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                HttpAuthDatabase.this.b(context, str);
            }
        }.start();
        return httpAuthDatabase;
    }

    public final void b(Context context, String str) {
        synchronized (this.f384954c) {
            if (this.f384953b) {
                return;
            }
            a(context, str);
            this.f384953b = true;
            this.f384954c.notifyAll();
        }
    }

    public void clearHttpAuthUsernamePassword() {
        if (!b()) {
            return;
        }
        this.f384952a.delete("httpauth", null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
    
        if (r15 == null) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        Cursor cursor;
        Cursor cursor2 = null;
        r0 = null;
        r0 = null;
        String[] strArr = null;
        if (str == null || str2 == 0 || !b()) {
            return null;
        }
        try {
            try {
                cursor = this.f384952a.query("httpauth", new String[]{"username", NotificationActivity.PASSWORD}, "(host == ?) AND (realm == ?)", new String[]{str, str2}, null, null, null);
            } catch (IllegalStateException e16) {
                e = e16;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (cursor2 != null) {
                }
                throw th;
            }
            try {
                boolean moveToFirst = cursor.moveToFirst();
                str2 = cursor;
                if (moveToFirst) {
                    strArr = new String[]{cursor.getString(cursor.getColumnIndex("username")), cursor.getString(cursor.getColumnIndex(NotificationActivity.PASSWORD))};
                    str2 = cursor;
                }
            } catch (IllegalStateException e17) {
                e = e17;
                x0.a("HttpAuthDatabase", "getHttpAuthUsernamePassword", e);
                str2 = cursor;
            }
            str2.close();
            return strArr;
        } catch (Throwable th6) {
            th = th6;
            cursor2 = str2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public boolean hasHttpAuthUsernamePassword() {
        boolean z16 = false;
        if (!b()) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = this.f384952a.query("httpauth", f384951d, null, null, null, null, null);
                z16 = cursor.moveToFirst();
                cursor.close();
            } catch (IllegalStateException e16) {
                x0.a("HttpAuthDatabase", "hasEntries", e16);
                if (cursor != null) {
                    cursor.close();
                }
            }
            return z16;
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (str != null && str2 != null && b()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("host", str);
            contentValues.put("realm", str2);
            contentValues.put("username", str3);
            contentValues.put(NotificationActivity.PASSWORD, str4);
            this.f384952a.insert("httpauth", "host", contentValues);
        }
    }

    public final void a(Context context, String str) {
        try {
            this.f384952a = context.openOrCreateDatabase(str, 0, null);
        } catch (SQLiteException unused) {
            if (context.deleteDatabase(str)) {
                this.f384952a = context.openOrCreateDatabase(str, 0, null);
            }
        }
        SQLiteDatabase sQLiteDatabase = this.f384952a;
        if (sQLiteDatabase == null) {
            x0.c("HttpAuthDatabase", "Unable to open or create " + str);
            return;
        }
        if (sQLiteDatabase.getVersion() != 1) {
            this.f384952a.beginTransactionNonExclusive();
            try {
                a();
                this.f384952a.setTransactionSuccessful();
            } finally {
                this.f384952a.endTransaction();
            }
        }
    }

    public final boolean b() {
        synchronized (this.f384954c) {
            while (!this.f384953b) {
                try {
                    LockMethodProxy.wait(this.f384954c);
                } catch (InterruptedException e16) {
                    x0.a("HttpAuthDatabase", "Caught exception while checking initialization", e16);
                }
            }
        }
        return this.f384952a != null;
    }

    public final void a() {
        this.f384952a.execSQL("CREATE TABLE httpauth (_id INTEGER PRIMARY KEY, host TEXT, realm TEXT, username TEXT, password TEXT, UNIQUE (host, realm) ON CONFLICT REPLACE);");
        this.f384952a.setVersion(1);
    }
}
