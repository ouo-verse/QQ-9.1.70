package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class ae {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f97953a = false;

    /* renamed from: b, reason: collision with root package name */
    private static ae f97954b;

    /* renamed from: c, reason: collision with root package name */
    private static af f97955c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends BaseThread {

        /* renamed from: b, reason: collision with root package name */
        private int f97957b = 4;

        /* renamed from: c, reason: collision with root package name */
        private ad f97958c = null;

        /* renamed from: d, reason: collision with root package name */
        private String f97959d;

        /* renamed from: e, reason: collision with root package name */
        private ContentValues f97960e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f97961f;

        /* renamed from: g, reason: collision with root package name */
        private String[] f97962g;

        /* renamed from: h, reason: collision with root package name */
        private String f97963h;

        /* renamed from: i, reason: collision with root package name */
        private String[] f97964i;

        /* renamed from: j, reason: collision with root package name */
        private String f97965j;

        /* renamed from: k, reason: collision with root package name */
        private String f97966k;

        /* renamed from: l, reason: collision with root package name */
        private String f97967l;

        /* renamed from: m, reason: collision with root package name */
        private String f97968m;

        /* renamed from: n, reason: collision with root package name */
        private String f97969n;

        /* renamed from: o, reason: collision with root package name */
        private String[] f97970o;

        /* renamed from: p, reason: collision with root package name */
        private int f97971p;

        /* renamed from: q, reason: collision with root package name */
        private String f97972q;

        /* renamed from: r, reason: collision with root package name */
        private byte[] f97973r;

        public a() {
        }

        public final void a(int i3, String str, byte[] bArr) {
            this.f97971p = i3;
            this.f97972q = str;
            this.f97973r = bArr;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.f97957b) {
                case 1:
                    ae.this.a(this.f97959d, this.f97960e, this.f97958c);
                    return;
                case 2:
                    ae.this.a(this.f97959d, this.f97969n, this.f97970o, this.f97958c);
                    return;
                case 3:
                    Cursor a16 = ae.this.a(this.f97961f, this.f97959d, this.f97962g, this.f97963h, this.f97964i, this.f97965j, this.f97966k, this.f97967l, this.f97968m, this.f97958c);
                    if (a16 != null) {
                        a16.close();
                        return;
                    }
                    return;
                case 4:
                    ae.this.a(this.f97971p, this.f97972q, this.f97973r, this.f97958c);
                    return;
                case 5:
                    ae.this.a(this.f97971p, this.f97958c);
                    return;
                case 6:
                    ae.this.a(this.f97971p, this.f97972q, this.f97958c);
                    return;
                default:
                    return;
            }
        }
    }

    ae(Context context, List<o> list) {
        f97955c = new af(context, list);
    }

    private synchronized boolean b(ag agVar) {
        ContentValues d16;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f97955c.getWritableDatabase();
            if (sQLiteDatabase == null || (d16 = d(agVar)) == null) {
                return false;
            }
            long replace = sQLiteDatabase.replace("t_pf", "_id", d16);
            if (replace >= 0) {
                av.c("[Database] insert %s success.", "t_pf");
                agVar.f97978a = replace;
                if (f97953a) {
                    sQLiteDatabase.close();
                }
                return true;
            }
            if (f97953a) {
                sQLiteDatabase.close();
            }
            return false;
        } catch (Throwable th5) {
            try {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
                if (f97953a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return false;
            } finally {
                if (f97953a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    private static ContentValues c(ag agVar) {
        if (agVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j3 = agVar.f97978a;
            if (j3 > 0) {
                contentValues.put("_id", Long.valueOf(j3));
            }
            contentValues.put("_tp", Integer.valueOf(agVar.f97979b));
            contentValues.put("_pc", agVar.f97980c);
            contentValues.put("_th", agVar.f97981d);
            contentValues.put("_tm", Long.valueOf(agVar.f97982e));
            byte[] bArr = agVar.f97984g;
            if (bArr != null) {
                contentValues.put("_dt", bArr);
            }
            return contentValues;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return null;
        }
    }

    private static ContentValues d(ag agVar) {
        if (agVar != null && !ba.b(agVar.f97983f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j3 = agVar.f97978a;
                if (j3 > 0) {
                    contentValues.put("_id", Long.valueOf(j3));
                }
                contentValues.put("_tp", agVar.f97983f);
                contentValues.put("_tm", Long.valueOf(agVar.f97982e));
                byte[] bArr = agVar.f97984g;
                if (bArr != null) {
                    contentValues.put("_dt", bArr);
                }
                return contentValues;
            } catch (Throwable th5) {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
            }
        }
        return null;
    }

    public static synchronized ae a(Context context, List<o> list) {
        ae aeVar;
        synchronized (ae.class) {
            if (f97954b == null) {
                f97954b = new ae(context, list);
            }
            aeVar = f97954b;
        }
        return aeVar;
    }

    public static synchronized ae a() {
        ae aeVar;
        synchronized (ae.class) {
            aeVar = f97954b;
        }
        return aeVar;
    }

    public final Cursor a(String str, String[] strArr, String str2) {
        return a(false, str, strArr, str2, null, null, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ce, code lost:
    
        if (r1 != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00b1, code lost:
    
        if (r1 != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00b3, code lost:
    
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<ag> c(int i3) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        try {
            sQLiteDatabase = f97955c.getWritableDatabase();
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabase = null;
            cursor = null;
        }
        if (sQLiteDatabase != null) {
            try {
                String concat = "_id = ".concat(String.valueOf(i3));
                cursor = sQLiteDatabase.query("t_pf", null, concat, null, null, null, null);
                if (cursor == null) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (f97953a) {
                        sQLiteDatabase.close();
                    }
                    return null;
                }
                try {
                    StringBuilder sb5 = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        ag b16 = b(cursor);
                        if (b16 != null) {
                            arrayList.add(b16);
                        } else {
                            try {
                                String string = cursor.getString(cursor.getColumnIndex("_tp"));
                                sb5.append(" or _tp = ");
                                sb5.append(string);
                            } catch (Throwable unused) {
                                av.d("[Database] unknown id.", new Object[0]);
                            }
                        }
                    }
                    if (sb5.length() > 0) {
                        sb5.append(" and _id = ");
                        sb5.append(i3);
                        av.d("[Database] deleted %s illegal data %d.", "t_pf", Integer.valueOf(sQLiteDatabase.delete("t_pf", concat.substring(4), null)));
                    }
                    cursor.close();
                    if (f97953a) {
                        sQLiteDatabase.close();
                    }
                    return arrayList;
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        if (!av.a(th)) {
                            th.printStackTrace();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (f97953a) {
                        }
                        return null;
                    } catch (Throwable th7) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (f97953a && sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th7;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                cursor = null;
            }
        } else {
            if (f97953a) {
            }
            return null;
        }
    }

    public final Cursor a(boolean z16, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return a(z16, str, strArr, str2, strArr2, str3, null, str4, str5, null);
    }

    public final int a(String str, String str2, String[] strArr) {
        return a(str, str2, strArr, (ad) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
    
        if (0 != 0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized long a(String str, ContentValues contentValues, ad adVar) {
        long j3;
        j3 = -1;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f97955c.getWritableDatabase();
            if (sQLiteDatabase != null && contentValues != null) {
                long replace = sQLiteDatabase.replace(str, "_id", contentValues);
                if (replace >= 0) {
                    av.c("[Database] insert %s success.", str);
                } else {
                    av.d("[Database] replace %s error.", str);
                }
                j3 = replace;
            }
        } catch (Throwable th5) {
            try {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
                if (f97953a) {
                }
            } finally {
                if (f97953a && 0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        return j3;
    }

    public final synchronized void b(int i3) {
        String concat;
        SQLiteDatabase writableDatabase = f97955c.getWritableDatabase();
        if (writableDatabase != null) {
            if (i3 >= 0) {
                try {
                    concat = "_tp = ".concat(String.valueOf(i3));
                } catch (Throwable th5) {
                    try {
                        if (!av.a(th5)) {
                            th5.printStackTrace();
                        }
                        if (f97953a) {
                            writableDatabase.close();
                            return;
                        }
                    } finally {
                        if (f97953a) {
                            writableDatabase.close();
                        }
                    }
                }
            } else {
                concat = null;
            }
            av.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", concat, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Cursor a(boolean z16, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, ad adVar) {
        Cursor cursor;
        cursor = null;
        try {
            SQLiteDatabase writableDatabase = f97955c.getWritableDatabase();
            if (writableDatabase != null) {
                cursor = writableDatabase.query(z16, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } finally {
            try {
                return cursor;
            } finally {
            }
        }
        return cursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0029, code lost:
    
        if (r1 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int a(String str, String str2, String[] strArr, ad adVar) {
        int i3;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f97955c.getWritableDatabase();
            i3 = sQLiteDatabase != null ? sQLiteDatabase.delete(str, str2, strArr) : 0;
        } catch (Throwable th5) {
            try {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
                if (f97953a) {
                }
            } finally {
                if (f97953a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
        return i3;
    }

    private static ag b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ag agVar = new ag();
            agVar.f97978a = cursor.getLong(cursor.getColumnIndex("_id"));
            agVar.f97982e = cursor.getLong(cursor.getColumnIndex("_tm"));
            agVar.f97983f = cursor.getString(cursor.getColumnIndex("_tp"));
            agVar.f97984g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return agVar;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return null;
        }
    }

    public final boolean a(int i3, String str, byte[] bArr, boolean z16) {
        if (!z16) {
            a aVar = new a();
            aVar.a(i3, str, bArr);
            at.a().a(aVar);
            return true;
        }
        return a(i3, str, bArr, (ad) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i3, String str, byte[] bArr, ad adVar) {
        try {
            ag agVar = new ag();
            agVar.f97978a = i3;
            agVar.f97983f = str;
            agVar.f97982e = System.currentTimeMillis();
            agVar.f97984g = bArr;
            return b(agVar);
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return false;
        }
    }

    public final Map<String, byte[]> a(int i3, ad adVar) {
        HashMap hashMap = null;
        try {
            List<ag> c16 = c(i3);
            if (c16 == null) {
                return null;
            }
            HashMap hashMap2 = new HashMap();
            try {
                for (ag agVar : c16) {
                    byte[] bArr = agVar.f97984g;
                    if (bArr != null) {
                        hashMap2.put(agVar.f97983f, bArr);
                    }
                }
                return hashMap2;
            } catch (Throwable th5) {
                th = th5;
                hashMap = hashMap2;
                if (av.a(th)) {
                    return hashMap;
                }
                th.printStackTrace();
                return hashMap;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public final synchronized boolean a(ag agVar) {
        ContentValues c16;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f97955c.getWritableDatabase();
            if (sQLiteDatabase == null || (c16 = c(agVar)) == null) {
                return false;
            }
            long replace = sQLiteDatabase.replace("t_lr", "_id", c16);
            if (replace >= 0) {
                av.c("[Database] insert %s success.", "t_lr");
                agVar.f97978a = replace;
                if (f97953a) {
                    sQLiteDatabase.close();
                }
                return true;
            }
            if (f97953a) {
                sQLiteDatabase.close();
            }
            return false;
        } catch (Throwable th5) {
            try {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
                if (f97953a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return false;
            } finally {
                if (f97953a && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b5 A[Catch: all -> 0x00c5, TRY_LEAVE, TryCatch #0 {all -> 0x00c5, blocks: (B:47:0x00af, B:49:0x00b5), top: B:46:0x00af, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ba A[Catch: all -> 0x00d5, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:11:0x002f, B:12:0x0032, B:14:0x0036, B:39:0x009f, B:41:0x00a6, B:52:0x00ba, B:53:0x00bd, B:55:0x00c1, B:58:0x00c8, B:59:0x00cb, B:61:0x00cf, B:62:0x00d2, B:47:0x00af, B:49:0x00b5), top: B:2:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c1 A[Catch: all -> 0x00d5, TryCatch #1 {, blocks: (B:3:0x0001, B:11:0x002f, B:12:0x0032, B:14:0x0036, B:39:0x009f, B:41:0x00a6, B:52:0x00ba, B:53:0x00bd, B:55:0x00c1, B:58:0x00c8, B:59:0x00cb, B:61:0x00cf, B:62:0x00d2, B:47:0x00af, B:49:0x00b5), top: B:2:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized List<ag> a(int i3) {
        String concat;
        Cursor cursor;
        SQLiteDatabase writableDatabase = f97955c.getWritableDatabase();
        if (writableDatabase != null) {
            if (i3 >= 0) {
                try {
                    concat = "_tp = ".concat(String.valueOf(i3));
                } catch (Throwable th5) {
                    th = th5;
                    cursor = null;
                    try {
                        if (!av.a(th)) {
                            th.printStackTrace();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (f97953a) {
                            writableDatabase.close();
                        }
                        return null;
                    } catch (Throwable th6) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (f97953a) {
                            writableDatabase.close();
                        }
                        throw th6;
                    }
                }
            } else {
                concat = null;
            }
            Cursor query = writableDatabase.query("t_lr", null, concat, null, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                if (f97953a) {
                    writableDatabase.close();
                }
                return null;
            }
            try {
                StringBuilder sb5 = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (query.moveToNext()) {
                    ag a16 = a(query);
                    if (a16 != null) {
                        arrayList.add(a16);
                    } else {
                        try {
                            long j3 = query.getLong(query.getColumnIndex("_id"));
                            sb5.append(" or _id = ");
                            sb5.append(j3);
                        } catch (Throwable unused) {
                            av.d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String sb6 = sb5.toString();
                if (sb6.length() > 0) {
                    av.d("[Database] deleted %s illegal data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb6.substring(4), null)));
                }
                query.close();
                if (f97953a) {
                    writableDatabase.close();
                }
                return arrayList;
            } catch (Throwable th7) {
                cursor = query;
                th = th7;
                if (!av.a(th)) {
                }
                if (cursor != null) {
                }
                if (f97953a) {
                }
                return null;
            }
        }
        return null;
    }

    public final synchronized void a(List<ag> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = f97955c.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb5 = new StringBuilder();
                    for (ag agVar : list) {
                        sb5.append(" or _id = ");
                        sb5.append(agVar.f97978a);
                    }
                    String sb6 = sb5.toString();
                    if (sb6.length() > 0) {
                        sb6 = sb6.substring(4);
                    }
                    sb5.setLength(0);
                    try {
                        av.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb6, null)));
                    } catch (Throwable th5) {
                        try {
                            if (!av.a(th5)) {
                                th5.printStackTrace();
                            }
                            if (f97953a) {
                                writableDatabase.close();
                            }
                        } finally {
                            if (f97953a) {
                                writableDatabase.close();
                            }
                        }
                    }
                }
            }
        }
    }

    private static ag a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ag agVar = new ag();
            agVar.f97978a = cursor.getLong(cursor.getColumnIndex("_id"));
            agVar.f97979b = cursor.getInt(cursor.getColumnIndex("_tp"));
            agVar.f97980c = cursor.getString(cursor.getColumnIndex("_pc"));
            agVar.f97981d = cursor.getString(cursor.getColumnIndex("_th"));
            agVar.f97982e = cursor.getLong(cursor.getColumnIndex("_tm"));
            agVar.f97984g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return agVar;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(int i3, String str, ad adVar) {
        boolean z16;
        String str2;
        z16 = false;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = f97955c.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (ba.b(str)) {
                        str2 = "_id = ".concat(String.valueOf(i3));
                    } else {
                        str2 = "_id = " + i3 + " and _tp = \"" + str + "\"";
                    }
                    int delete = writableDatabase.delete("t_pf", str2, null);
                    av.c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(delete));
                    if (delete > 0) {
                        z16 = true;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = writableDatabase;
                    try {
                        if (!av.a(th)) {
                            th.printStackTrace();
                        }
                        return z16;
                    } finally {
                        if (f97953a && sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    }
                }
            }
            if (f97953a && writableDatabase != null) {
                writableDatabase.close();
            }
        } catch (Throwable th6) {
            th = th6;
        }
        return z16;
    }
}
