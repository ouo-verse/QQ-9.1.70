package com.tencent.luggage.wxa.tn;

import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.tencent.luggage.wxa.tn.w;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static int f141730a = 6;

    /* renamed from: b, reason: collision with root package name */
    public static e f141731b;

    /* renamed from: c, reason: collision with root package name */
    public static b f141732c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f141733d;

    /* renamed from: e, reason: collision with root package name */
    public static Map f141734e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        int a(long j3);

        void a(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4);

        void a(long j3, boolean z16);

        void a(String str);

        void appenderClose();

        void b(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4);

        void c(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4);

        void d(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4);

        void e(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4);

        void f(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ long a(c cVar, long j3) {
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e implements b {

        /* renamed from: a, reason: collision with root package name */
        public volatile ArrayList f141741a;

        /* renamed from: b, reason: collision with root package name */
        public volatile b f141742b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f141743c;

        public e() {
            this.f141741a = new ArrayList(200);
            this.f141743c = new byte[0];
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void a(long j3, boolean z16) {
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void b(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
            if (w.f141730a <= 3) {
                Log.w(str, str4);
                a(3, j3, str, str2, str3, i3, i16, j16, j17, str4);
            }
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void c(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
            if (w.f141730a > 5) {
                return;
            }
            Log.e(str, str4);
            a(4, j3, str, str2, str3, i3, i16, j16, j17, str4);
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void d(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
            if (w.f141730a <= 0) {
                Log.v(str, str4);
            }
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void e(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
            if (w.f141730a <= 4) {
                Log.e(str, str4);
                a(4, j3, str, str2, str3, i3, i16, j16, j17, str4);
            }
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void f(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
            if (w.f141730a <= 1) {
                Log.d(str, str4);
            }
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void a(String str) {
        }

        public ArrayList a(b bVar) {
            ArrayList arrayList;
            synchronized (this.f141743c) {
                if (bVar != null) {
                    if (!(bVar instanceof e)) {
                        this.f141742b = bVar;
                    }
                }
                arrayList = this.f141741a;
                this.f141741a = null;
            }
            return arrayList;
        }

        public final void a(int i3, long j3, String str, String str2, String str3, int i16, int i17, long j16, long j17, String str4) {
            d dVar = new d();
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.f141743c) {
                if (this.f141741a != null) {
                    this.f141741a.add(dVar.a(i3, str, currentTimeMillis, j16, str4));
                    return;
                }
                if (this.f141742b != null) {
                    if (i3 == 2) {
                        this.f141742b.a(j3, str, str2, str3, i16, i17, j16, j17, str4);
                        return;
                    }
                    if (i3 == 3) {
                        this.f141742b.b(j3, str, str2, str3, i16, i17, j16, j17, str4);
                    } else if (i3 == 4) {
                        this.f141742b.e(j3, str, str2, str3, i16, i17, j16, j17, str4);
                    } else {
                        if (i3 != 5) {
                            return;
                        }
                        this.f141742b.c(j3, str, str2, str3, i16, i17, j16, j17, str4);
                    }
                }
            }
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void a(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
            if (w.f141730a <= 2) {
                Log.i(str, str4);
                a(2, j3, str, str2, str3, i3, i16, j16, j17, str4);
            }
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void appenderClose() {
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public int a(long j3) {
            return w.f141730a;
        }
    }

    static {
        e eVar = new e();
        f141731b = eVar;
        f141732c = eVar;
        f141733d = false;
        f141734e = new HashMap();
    }

    public static void b() {
        b bVar = f141732c;
        if (bVar != null) {
            bVar.appenderClose();
            f141734e.size();
            ArrayList arrayList = new ArrayList();
            Iterator it = f141734e.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add((String) ((Map.Entry) it.next()).getKey());
            }
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                a((String) listIterator.next());
            }
        }
    }

    public static void c() {
        b bVar = f141732c;
        if (bVar != null) {
            bVar.a(0L, true);
        }
    }

    public static int d() {
        b bVar = f141732c;
        if (bVar != null) {
            return bVar.a(0L);
        }
        return 6;
    }

    public static void e(String str, String str2) {
        g(str, str2, null);
    }

    public static void f(String str, String str2) {
        h(str, str2, null);
    }

    public static void g(String str, String str2, Object... objArr) {
        b bVar = f141732c;
        if (bVar != null && bVar.a(0L) <= 0) {
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(Locale.CHINA, str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            f141732c.d(0L, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        b bVar = f141732c;
        if (bVar != null && bVar.a(0L) <= 3) {
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(Locale.CHINA, str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            f141732c.b(0L, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static b a(b bVar) {
        b bVar2 = f141732c;
        f141732c = bVar;
        f141731b = null;
        a(bVar2, bVar);
        return bVar2;
    }

    public static void e(String str, String str2, Object... objArr) {
        b bVar = f141732c;
        if (bVar == null || bVar.a(0L) > 1) {
            return;
        }
        if (objArr != null && objArr.length != 0) {
            str2 = String.format(Locale.CHINA, str2, objArr);
        }
        if (str2 == null) {
            str2 = "";
        }
        f141732c.a(0L, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2 + "  " + w0.b());
    }

    public static void f(String str, String str2, Object... objArr) {
        b bVar = f141732c;
        if (bVar == null || bVar.a(0L) > 2) {
            return;
        }
        if (objArr != null && objArr.length != 0) {
            str2 = String.format(Locale.CHINA, str2, objArr);
        }
        if (str2 == null) {
            str2 = "";
        }
        f141732c.a(0L, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2 + "  " + w0.b());
    }

    public static void c(String str, String str2) {
        c(str, str2, null);
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void c(String str, String str2, Object... objArr) {
        b bVar = f141732c;
        if (bVar == null || bVar.a(0L) > 5) {
            return;
        }
        if (objArr != null && objArr.length != 0) {
            str2 = String.format(Locale.CHINA, str2, objArr);
        }
        f141732c.c(0L, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
    }

    public static void d(String str, String str2, Object... objArr) {
        b bVar = f141732c;
        if (bVar == null || bVar.a(0L) > 2) {
            return;
        }
        if (objArr != null && objArr.length != 0) {
            str2 = String.format(Locale.CHINA, str2, objArr);
        }
        if (str2 == null) {
            str2 = "";
        }
        f141732c.a(0L, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: f, reason: collision with root package name */
        public static DateFormat f141735f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);

        /* renamed from: a, reason: collision with root package name */
        public int f141736a;

        /* renamed from: b, reason: collision with root package name */
        public String f141737b;

        /* renamed from: c, reason: collision with root package name */
        public long f141738c;

        /* renamed from: d, reason: collision with root package name */
        public long f141739d;

        /* renamed from: e, reason: collision with root package name */
        public String f141740e;

        public d a(int i3, String str, long j3, long j16, String str2) {
            this.f141736a = i3;
            this.f141737b = str;
            this.f141738c = j3;
            this.f141739d = j16;
            this.f141740e = str2;
            return this;
        }

        public String a() {
            int i3 = this.f141736a;
            return String.format(Locale.ENGLISH, "[%s][%s][%s] [:%s]%s", i3 == 2 ? "I" : i3 == 4 ? "W" : i3 == 4 ? "E" : "D", f141735f.format(new Date(this.f141738c)), this.f141737b, Long.valueOf(this.f141739d), this.f141740e);
        }
    }

    public static void a(b bVar, b bVar2) {
        final ArrayList a16;
        if (!(bVar instanceof e) || (a16 = ((e) bVar).a(bVar2)) == null) {
            return;
        }
        com.tencent.luggage.wxa.zp.h.f146825d.d(new Runnable() { // from class: f41.c
            @Override // java.lang.Runnable
            public final void run() {
                w.a(a16);
            }
        });
    }

    public static /* synthetic */ void a(ArrayList arrayList) {
        com.tencent.luggage.wxa.so.h.a("Flush pending logs");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d("PendingLogs", ((d) it.next()).a());
        }
        com.tencent.luggage.wxa.so.h.a();
    }

    public static void b(String str, String str2) {
        b(str, str2, null);
    }

    public static void b(String str, String str2, Object... objArr) {
        b bVar = f141732c;
        if (bVar == null || bVar.a(0L) > 4) {
            return;
        }
        if (objArr != null && objArr.length != 0) {
            str2 = String.format(Locale.CHINA, str2, objArr);
        }
        if (str2 == null) {
            str2 = "";
        }
        f141732c.e(0L, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
    }

    public static void a(String str, String str2) {
        a(str, str2, null);
    }

    public static void a(String str, String str2, Object... objArr) {
        b bVar = f141732c;
        if (bVar == null || bVar.a(0L) > 1) {
            return;
        }
        if (objArr != null && objArr.length != 0) {
            str2 = String.format(Locale.CHINA, str2, objArr);
        }
        if (str2 == null) {
            str2 = "";
        }
        f141732c.f(0L, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
    }

    public static void a(String str, Throwable th5, String str2, Object... objArr) {
        b bVar = f141732c;
        if (bVar == null || bVar.a(0L) > 4) {
            return;
        }
        String format = (objArr == null || objArr.length == 0) ? str2 : String.format(Locale.CHINA, str2, objArr);
        if (format == null) {
            format = "";
        }
        f141732c.e(0L, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format + "  " + Log.getStackTraceString(th5));
    }

    public static void a(String str) {
        synchronized (f141734e) {
            if (f141732c != null && f141734e.containsKey(str)) {
                com.tencent.luggage.wxa.k0.d.a(f141734e.remove(str));
                f141732c.a(str);
                c.a(null, 0L);
            }
        }
    }
}
