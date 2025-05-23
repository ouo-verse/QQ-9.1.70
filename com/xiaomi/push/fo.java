package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.open.business.base.MobileInfoUtil;
import com.xiaomi.push.af;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fo {

    /* renamed from: a, reason: collision with root package name */
    private static af f388892a = new af(true);

    /* renamed from: b, reason: collision with root package name */
    private static volatile int f388893b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static long f388894c = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name */
    private static final Object f388895d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static List<b> f388896e = Collections.synchronizedList(new ArrayList());

    /* renamed from: f, reason: collision with root package name */
    private static String f388897f = "";

    /* renamed from: g, reason: collision with root package name */
    private static mz4.a f388898g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a extends af.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f388899a;

        a(Context context) {
            this.f388899a = context;
        }

        @Override // com.xiaomi.push.af.c
        public void b() {
            ArrayList arrayList;
            synchronized (fo.f388895d) {
                arrayList = new ArrayList(fo.f388896e);
                fo.f388896e.clear();
            }
            fo.o(this.f388899a, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f388900a;

        /* renamed from: b, reason: collision with root package name */
        public long f388901b;

        /* renamed from: c, reason: collision with root package name */
        public int f388902c;

        /* renamed from: d, reason: collision with root package name */
        public int f388903d;

        /* renamed from: e, reason: collision with root package name */
        public String f388904e;

        /* renamed from: f, reason: collision with root package name */
        public long f388905f;

        public b(String str, long j3, int i3, int i16, String str2, long j16) {
            this.f388900a = str;
            this.f388901b = j3;
            this.f388902c = i3;
            this.f388903d = i16;
            this.f388904e = str2;
            this.f388905f = j16;
        }

        public boolean a(b bVar) {
            if (TextUtils.equals(bVar.f388900a, this.f388900a) && TextUtils.equals(bVar.f388904e, this.f388904e) && bVar.f388902c == this.f388902c && bVar.f388903d == this.f388903d && Math.abs(bVar.f388901b - this.f388901b) <= 5000) {
                return true;
            }
            return false;
        }
    }

    public static int a(Context context) {
        if (f388893b == -1) {
            f388893b = n(context);
        }
        return f388893b;
    }

    public static int b(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    private static long c(int i3, long j3, boolean z16, long j16, boolean z17) {
        int i16;
        if (z16 && z17) {
            long j17 = f388894c;
            f388894c = j16;
            if (j16 - j17 > 30000 && j3 > 1024) {
                return j3 * 2;
            }
        }
        if (i3 == 0) {
            i16 = 13;
        } else {
            i16 = 11;
        }
        return (j3 * i16) / 10;
    }

    private static synchronized String e(Context context) {
        synchronized (fo.class) {
            if (!TextUtils.isEmpty(f388897f)) {
                return f388897f;
            }
            return "";
        }
    }

    private static mz4.a g(Context context) {
        mz4.a aVar = f388898g;
        if (aVar != null) {
            return aVar;
        }
        mz4.a aVar2 = new mz4.a(context);
        f388898g = aVar2;
        return aVar2;
    }

    public static void h(Context context) {
        f388893b = n(context);
    }

    private static void i(Context context, String str, long j3, boolean z16, long j16) {
        int a16;
        boolean isEmpty;
        String str2;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a16 = a(context))) {
            return;
        }
        synchronized (f388895d) {
            isEmpty = f388896e.isEmpty();
            if (a16 == 0) {
                str2 = e(context);
            } else {
                str2 = "";
            }
            l(new b(str, j16, a16, z16 ? 1 : 0, str2, j3));
        }
        if (isEmpty) {
            f388892a.f(new a(context), 5000L);
        }
    }

    public static void j(Context context, String str, long j3, boolean z16, boolean z17, long j16) {
        i(context, str, c(a(context), j3, z16, j16, z17), z16, j16);
    }

    private static void l(b bVar) {
        for (b bVar2 : f388896e) {
            if (bVar2.a(bVar)) {
                bVar2.f388905f += bVar.f388905f;
                return;
            }
        }
        f388896e.add(bVar);
    }

    public static synchronized void m(String str) {
        synchronized (fo.class) {
            if (!hz.t() && !TextUtils.isEmpty(str)) {
                f388897f = str;
            }
        }
    }

    private static int n(Context context) {
        x e16 = au.e();
        if (e16 == null) {
            return -1;
        }
        return e16.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(Context context, List<b> list) {
        try {
            synchronized (mz4.a.f417906e) {
                SQLiteDatabase writableDatabase = g(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (b bVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", bVar.f388900a);
                        contentValues.put("message_ts", Long.valueOf(bVar.f388901b));
                        contentValues.put("network_type", Integer.valueOf(bVar.f388902c));
                        contentValues.put("bytes", Long.valueOf(bVar.f388905f));
                        contentValues.put("rcv", Integer.valueOf(bVar.f388903d));
                        contentValues.put(MobileInfoUtil.IMSI, bVar.f388904e);
                        writableDatabase.insert(BuglyMonitorName.TRAFFIC, null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable th5) {
            jz4.c.q(th5);
        }
    }
}
