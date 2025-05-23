package com.tencent.beacon.event.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.NonNull;
import com.tencent.beacon.a.b.i;
import com.tencent.beacon.a.d.c;
import com.tencent.beacon.a.d.d;
import com.tencent.beacon.event.EventBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements d<EventBean> {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f77880a;

    /* renamed from: b, reason: collision with root package name */
    private final SQLiteStatement f77881b;

    /* renamed from: c, reason: collision with root package name */
    private final SQLiteStatement f77882c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f77883d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private final Object f77884e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.beacon.event.c.b f77885f = com.tencent.beacon.event.c.b.a();

    /* renamed from: g, reason: collision with root package name */
    private SQLiteDatabase f77886g;

    /* renamed from: h, reason: collision with root package name */
    private SQLiteDatabase f77887h;

    /* renamed from: i, reason: collision with root package name */
    private long f77888i;

    /* renamed from: j, reason: collision with root package name */
    private long f77889j;

    a() {
        c cVar = new c(com.tencent.beacon.a.c.b.c(com.tencent.beacon.a.c.c.c().b()));
        this.f77886g = cVar.getWritableDatabase();
        SQLiteDatabase readableDatabase = cVar.getReadableDatabase();
        this.f77887h = readableDatabase;
        this.f77881b = readableDatabase.compileStatement("INSERT INTO t_r_e (_appKey,_time,_length,_data )VALUES(?,?,?,?)");
        this.f77882c = this.f77887h.compileStatement("INSERT INTO t_n_e (_appKey,_time,_length,_data )VALUES(?,?,?,?)");
        this.f77888i = a("t_r_e");
        long a16 = a("t_n_e");
        this.f77889j = a16;
        if (this.f77888i != 0 || a16 != 0) {
            String str = " realtime: " + this.f77888i + ", normal: " + this.f77889j;
            com.tencent.beacon.base.util.c.a("[EventDAO]", str, new Object[0]);
            i.e().a("607", "[EventDAO]" + str);
        }
    }

    public static a a() {
        if (f77880a == null) {
            synchronized (a.class) {
                if (f77880a == null) {
                    f77880a = new a();
                }
            }
        }
        return f77880a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        if (r1.moveToFirst() != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        r0.put(r1.getString(0), java.lang.Integer.valueOf(r1.getInt(1)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
    
        if (r1.moveToNext() != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        if (r1.isClosed() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008b, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, Integer> b(String str) {
        HashMap hashMap = new HashMap();
        Cursor cursor = null;
        try {
            try {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("SELECT _appKey,count(_appKey) FROM ");
                sb5.append(str);
                sb5.append(" GROUP BY ");
                sb5.append("_appKey");
                cursor = this.f77887h.rawQuery(sb5.toString(), null);
            } catch (Exception e16) {
                i e17 = i.e();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("type: ");
                sb6.append(str);
                sb6.append(" query err: ");
                sb6.append(e16.getMessage());
                e17.a("605", sb6.toString(), e16);
                com.tencent.beacon.base.util.c.a(e16);
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        } catch (Throwable th5) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0081, code lost:
    
        if (r12.f77882c.executeInsert() >= 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(EventBean eventBean) {
        boolean z16;
        if (eventBean == null) {
            return false;
        }
        b a16 = this.f77885f.b().a(eventBean);
        boolean a17 = com.tencent.beacon.event.c.d.a(eventBean.getEventType());
        try {
            try {
                this.f77886g.beginTransactionNonExclusive();
                this.f77881b.clearBindings();
                if (a17) {
                    this.f77881b.bindString(1, a16.f77893d);
                    this.f77881b.bindLong(2, a16.f77891b);
                    this.f77881b.bindLong(3, a16.f77892c);
                    this.f77881b.bindBlob(4, a16.f77894e);
                } else {
                    this.f77882c.bindString(1, a16.f77893d);
                    this.f77882c.bindLong(2, a16.f77891b);
                    this.f77882c.bindLong(3, a16.f77892c);
                    this.f77882c.bindBlob(4, a16.f77894e);
                }
                if (a17) {
                    if (this.f77881b.executeInsert() >= 0) {
                        z16 = true;
                    }
                    z16 = false;
                }
                try {
                    this.f77886g.setTransactionSuccessful();
                    this.f77886g.endTransaction();
                } catch (Exception e16) {
                    i.e().a("603", "type: " + a17 + " insert err: " + e16.getMessage(), e16);
                    com.tencent.beacon.base.util.c.a(e16);
                }
            } catch (Exception e17) {
                i.e().a("603", "type: " + a17 + " insert err: " + e17.getMessage(), e17);
                com.tencent.beacon.base.util.c.a(e17);
                try {
                    this.f77886g.setTransactionSuccessful();
                    this.f77886g.endTransaction();
                } catch (Exception e18) {
                    i.e().a("603", "type: " + a17 + " insert err: " + e18.getMessage(), e18);
                    com.tencent.beacon.base.util.c.a(e18);
                }
                z16 = false;
            }
            if (z16) {
                a(a17, true, 1L);
            } else {
                i.e().a("603", "type: " + a17 + " insert result: false");
            }
            return z16;
        } catch (Throwable th5) {
            try {
                this.f77886g.setTransactionSuccessful();
                this.f77886g.endTransaction();
            } catch (Exception e19) {
                i.e().a("603", "type: " + a17 + " insert err: " + e19.getMessage(), e19);
                com.tencent.beacon.base.util.c.a(e19);
            }
            throw th5;
        }
    }

    public List<EventBean> a(@NonNull String str, String str2, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        List<EventBean> list = null;
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" SELECT * FROM ");
            sb5.append(str);
            sb5.append(" WHERE ");
            sb5.append("_id");
            sb5.append(" NOT IN (");
            sb5.append(str2);
            sb5.append(") ORDER BY ");
            sb5.append("_time");
            sb5.append(" DESC LIMIT ");
            sb5.append(i3);
            list = a(str, this.f77887h.rawQuery(sb5.toString(), null));
        } catch (Exception e16) {
            com.tencent.beacon.base.util.c.a(e16);
            i.e().a("605", "type: " + str + " query err: " + e16.getMessage(), e16);
        }
        com.tencent.beacon.base.util.c.a("[EventDAO]", "query tableName: %s, args: %s", str, str2);
        com.tencent.beacon.base.util.c.a("[EventDAO]", "query cost time: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return list;
    }

    public long a(String str) {
        long j3;
        Cursor cursor = null;
        try {
            try {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("SELECT count(?) FROM ");
                sb5.append(str);
                String sb6 = sb5.toString();
                cursor = this.f77887h.rawQuery(sb6, new String[]{"_id"});
                cursor.moveToFirst();
                j3 = cursor.getLong(0);
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception e16) {
                i e17 = i.e();
                StringBuilder sb7 = new StringBuilder();
                sb7.append("type: ");
                sb7.append(str);
                sb7.append(" query err: ");
                sb7.append(e16.getMessage());
                e17.a("605", sb7.toString(), e16);
                com.tencent.beacon.base.util.c.a(e16);
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                j3 = -1;
            }
            return j3;
        } catch (Throwable th5) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th5;
        }
    }

    public boolean a(@NonNull String str, String str2) {
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("_id IN (");
            sb5.append(str2);
            sb5.append(")");
            int delete = this.f77886g.delete(str, sb5.toString(), null);
            a(str.equals("t_r_e"), false, delete);
            return delete >= 0;
        } catch (Exception e16) {
            i.e().a("606", "type: " + str + " delete err: " + e16.getMessage() + " target: " + str2, e16);
            com.tencent.beacon.base.util.c.a(e16);
            return false;
        }
    }

    private List<EventBean> a(String str, Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            b bVar = new b();
            bVar.f77890a = cursor.getLong(0);
            bVar.f77893d = cursor.getString(1);
            bVar.f77891b = cursor.getInt(2);
            bVar.f77892c = cursor.getLong(3);
            bVar.f77894e = cursor.getBlob(4);
            EventBean a16 = this.f77885f.c().a(bVar);
            if (a16 == null) {
                a(str, String.valueOf(bVar.f77890a));
                com.tencent.beacon.base.util.c.b("transformEventBean error, eventBean is null! delete this event.", new Object[0]);
            } else {
                arrayList.add(a16);
            }
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
        return arrayList;
    }

    private void a(boolean z16, boolean z17, long j3) {
        if (z16) {
            synchronized (this.f77883d) {
                if (z17) {
                    this.f77888i += j3;
                } else {
                    this.f77888i -= j3;
                }
                com.tencent.beacon.base.util.c.a("[EventDAO]", "current db realtime:%s", Long.valueOf(this.f77888i));
            }
            return;
        }
        synchronized (this.f77884e) {
            if (z17) {
                this.f77889j += j3;
            } else {
                this.f77889j -= j3;
            }
            com.tencent.beacon.base.util.c.a("[EventDAO]", "current db normal:%s", Long.valueOf(this.f77889j));
        }
    }

    public boolean a(int i3) {
        boolean z16;
        if (i3 == 1) {
            synchronized (this.f77883d) {
                z16 = this.f77888i >= ((long) com.tencent.beacon.d.b.a().b());
            }
            return z16;
        }
        synchronized (this.f77884e) {
            z16 = this.f77889j >= ((long) com.tencent.beacon.d.b.a().b());
        }
        return z16;
    }
}
