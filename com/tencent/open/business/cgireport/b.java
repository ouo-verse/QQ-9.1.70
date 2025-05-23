package com.tencent.open.business.cgireport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.ThreadLooperPrinter2;
import com.tencent.open.base.f;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    protected static final String f341076c = "com.tencent.open.business.cgireport.b";

    /* renamed from: a, reason: collision with root package name */
    protected SQLiteDatabase f341077a;

    /* renamed from: b, reason: collision with root package name */
    protected a f341078b = new a(com.tencent.open.adapter.a.f().e(), "agent_cgi_report.db", null, 4);

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a extends SQLiteOpenHelper {
        public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3) {
            super(context, str, cursorFactory, i3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                f.e("cgi_report_debug", "ReportDataModal onCreate sql1 = create table if not exists newdata_report(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,touin text,deviceinfo text,detail text,appid text)");
                sQLiteDatabase.execSQL("create table if not exists newdata_report(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,touin text,deviceinfo text,detail text,appid text)");
                f.e("cgi_report_debug", "ReportDataModal onCreate sql2 = create table if not exists olddata_report(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,touin text,deviceinfo text,detail text,appid text)");
                sQLiteDatabase.execSQL("create table if not exists olddata_report(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,touin text,deviceinfo text,detail text,appid text)");
            } catch (Exception unused) {
                f.c("cgi_report_debug", "ReportDataModal onCreate failed");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
            try {
                sQLiteDatabase.execSQL("drop table if exists newdata_report");
                sQLiteDatabase.execSQL("drop table if exists olddata_report");
                onCreate(sQLiteDatabase);
                f.e("cgi_report_debug", "ReportDataModal onUpgrade success");
            } catch (Exception unused) {
                f.c("cgi_report_debug", "ReportDataModal onUpgrade failed");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
            f.e("cgi_report_debug", "ReportDataModal onUpgrade oldVersion=" + i3 + "  newVersion=" + i16 + "");
            if (i3 != i16) {
                try {
                    sQLiteDatabase.execSQL("drop table if exists newdata_report");
                    sQLiteDatabase.execSQL("drop table if exists olddata_report");
                    onCreate(sQLiteDatabase);
                    f.e("cgi_report_debug", "ReportDataModal onUpgrade success");
                } catch (Exception unused) {
                    f.c("cgi_report_debug", "ReportDataModal onUpgrade failed");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00fc, code lost:
    
        r20.f341077a.close();
        com.tencent.open.base.f.e("cgi_report_debug", "getItem from " + r21 + ">> end, count = " + r3.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00f9, code lost:
    
        if (r4 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized ArrayList<c> f(String str, String str2) {
        ArrayList<c> arrayList;
        f.e("cgi_report_debug", "ReportDataModal getOldItems start");
        arrayList = new ArrayList<>();
        try {
            SQLiteDatabase readableDatabase = this.f341078b.getReadableDatabase();
            this.f341077a = readableDatabase;
            Cursor cursor = null;
            try {
                try {
                    cursor = readableDatabase.rawQuery("select * from " + str + " where appid=?", new String[]{str2});
                    if (cursor != null) {
                        cursor.moveToFirst();
                        while (!cursor.isAfterLast()) {
                            arrayList.add(new c(cursor.getString(cursor.getColumnIndex("apn")), cursor.getString(cursor.getColumnIndex("frequency")), cursor.getString(cursor.getColumnIndex("commandid")), cursor.getString(cursor.getColumnIndex("resultcode")), cursor.getString(cursor.getColumnIndex("tmcost")), cursor.getString(cursor.getColumnIndex("reqsize")), cursor.getString(cursor.getColumnIndex("rspsize")), cursor.getString(cursor.getColumnIndex("touin")), cursor.getString(cursor.getColumnIndex("deviceinfo")), cursor.getString(cursor.getColumnIndex("detail")), str2));
                            cursor.moveToNext();
                        }
                    }
                } catch (Exception e16) {
                    f.b(f341076c, "getItem from " + str + ThreadLooperPrinter2.START_PREFIX, e16);
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Exception e17) {
            f.b(f341076c, "getOldItems>>>", e17);
            return arrayList;
        }
        return arrayList;
    }

    public synchronized boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        int i3;
        if (str3.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str3 = str3.split("\\?")[0];
        }
        f.e("cgi_report_debug", "ReportDataModal addNewItem apn=" + str + ",frequency=" + str2 + ",commandid=" + str3 + ",resultCode=" + str4 + ",costTime=" + str5 + ",reqSzie=" + str6 + ",rspSize=" + str7);
        ContentValues contentValues = new ContentValues();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("");
        contentValues.put("apn", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(str2);
        sb6.append("");
        contentValues.put("frequency", sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append(str3);
        sb7.append("");
        contentValues.put("commandid", sb7.toString());
        contentValues.put("resultcode", str4 + "");
        contentValues.put("tmcost", str5 + "");
        contentValues.put("reqsize", str6 + "");
        contentValues.put("rspsize", str7 + "");
        contentValues.put("touin", str8 + "");
        contentValues.put("appid", str10 + "");
        StringBuilder sb8 = new StringBuilder();
        sb8.append("network=");
        sb8.append(str);
        sb8.append(Typography.amp);
        sb8.append("sdcard=");
        if (Environment.getExternalStorageState().equals("mounted")) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        sb8.append(i3);
        sb8.append(Typography.amp);
        sb8.append("wifi=");
        sb8.append(com.tencent.open.base.a.h(com.tencent.open.adapter.a.f().e()));
        contentValues.put("deviceinfo", sb8.toString());
        String str11 = "current login uin=" + com.tencent.open.adapter.a.f().l() + "";
        if (str9 != null) {
            str11 = str11 + ContainerUtils.FIELD_DELIMITER + str9 + "";
        }
        contentValues.put("detail", str11);
        try {
            SQLiteDatabase writableDatabase = this.f341078b.getWritableDatabase();
            this.f341077a = writableDatabase;
            writableDatabase.insertOrThrow("newdata_report", null, contentValues);
            this.f341077a.close();
            f.e("cgi_report_debug", "ReportDataModal addNewItem success");
        } catch (Exception unused) {
            f.c("cgi_report_debug", "ReportDataModal addNewItem failed");
            return false;
        }
        return true;
    }

    public synchronized int b(ArrayList<c> arrayList) {
        int i3;
        f.e("cgi_report_debug", "ReportDataModal backupOldItems count = " + arrayList.size());
        Iterator it = new ArrayList(arrayList).iterator();
        i3 = 0;
        while (it.hasNext()) {
            c cVar = (c) it.next();
            ContentValues contentValues = new ContentValues();
            contentValues.put("apn", cVar.f341080a);
            contentValues.put("frequency", cVar.f341081b);
            contentValues.put("commandid", cVar.f341082c);
            contentValues.put("resultcode", cVar.f341083d);
            contentValues.put("tmcost", cVar.f341084e);
            contentValues.put("reqsize", cVar.f341085f);
            contentValues.put("rspsize", cVar.f341086g);
            contentValues.put("touin", cVar.f341087h);
            contentValues.put("deviceinfo", cVar.f341088i);
            contentValues.put("detail", cVar.f341089j);
            contentValues.put("appid", cVar.f341090k);
            try {
                SQLiteDatabase writableDatabase = this.f341078b.getWritableDatabase();
                this.f341077a = writableDatabase;
                writableDatabase.insertOrThrow("olddata_report", null, contentValues);
                this.f341077a.close();
            } catch (Exception e16) {
                f.d(f341076c, "update>>>", e16);
            }
            i3++;
        }
        f.e("cgi_report_debug", "ReportDataModal backupOldItems succ_count = " + i3);
        return i3;
    }

    public synchronized boolean c(String str) {
        f.e("cgi_report_debug", "ReportDataModal deleteNewItems start");
        try {
            this.f341077a = this.f341078b.getWritableDatabase();
            try {
                this.f341077a.execSQL("delete from newdata_report where appid=" + str + ";");
                this.f341077a.close();
                f.e("cgi_report_debug", "ReportDataModal deleteNewItems success");
            } catch (Exception e16) {
                f.b(f341076c, "deleteNewItems>>>", e16);
                this.f341077a.close();
                return false;
            }
        } catch (Exception e17) {
            f.b(f341076c, "deleteNewItems>>>", e17);
            return false;
        }
        return true;
    }

    public synchronized boolean d(String str) {
        f.e("cgi_report_debug", "ReportDataModal deleteOldItems start");
        try {
            this.f341077a = this.f341078b.getWritableDatabase();
            try {
                this.f341077a.execSQL("delete from olddata_report where appid=" + str + ";");
                this.f341077a.close();
                f.e("cgi_report_debug", "ReportDataModal deleteOldItems success");
            } catch (Exception e16) {
                f.b(f341076c, "deleteOldItems>>>", e16);
                this.f341077a.close();
                return false;
            }
        } catch (Exception e17) {
            f.b(f341076c, "deleteOldItems>>>", e17);
            return false;
        }
        return true;
    }

    public synchronized int e(String str, String str2) {
        String str3;
        int count;
        String[] strArr = null;
        if (TextUtils.isEmpty(str2)) {
            str3 = null;
        } else {
            str3 = "appid=?";
        }
        if (!TextUtils.isEmpty(str2)) {
            strArr = new String[]{str2};
        }
        String[] strArr2 = strArr;
        try {
            SQLiteDatabase readableDatabase = this.f341078b.getReadableDatabase();
            this.f341077a = readableDatabase;
            try {
                Cursor query = readableDatabase.query(str, null, str3, strArr2, null, null, null);
                count = query.getCount();
                query.close();
            } catch (Exception e16) {
                f.d(f341076c, e16.getLocalizedMessage(), e16);
                return 0;
            }
        } catch (Exception e17) {
            f.b(f341076c, "getOldItems>>>", e17);
            return 0;
        }
        return count;
    }

    public synchronized ArrayList<c> g(String str) {
        return f("newdata_report", str);
    }

    public synchronized ArrayList<c> h(String str) {
        return f("olddata_report", str);
    }

    public synchronized int i(String str) {
        int e16;
        int e17 = e("newdata_report", str) + 0;
        String str2 = f341076c;
        f.e(str2, "new_table>>count=" + e17);
        e16 = e17 + e("olddata_report", str);
        f.e(str2, "all_table>>>count=" + e16);
        return e16;
    }
}
