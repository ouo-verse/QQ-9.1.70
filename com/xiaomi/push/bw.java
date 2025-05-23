package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.xiaomi.push.ae;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bw {

    /* renamed from: e, reason: collision with root package name */
    private static volatile bw f388325e;

    /* renamed from: a, reason: collision with root package name */
    private Context f388326a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, ar> f388327b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private ThreadPoolExecutor f388328c = new BaseThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<a> f388329d = new ArrayList<>();

    /* compiled from: P */
    /* renamed from: com.xiaomi.push.bw$1, reason: invalid class name */
    /* loaded from: classes28.dex */
    class AnonymousClass1 extends ae.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ bw f388330d;

        @Override // com.xiaomi.push.ae.a
        public String e() {
            return "100957";
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f388330d.f388329d) {
                if (this.f388330d.f388329d.size() > 0) {
                    if (this.f388330d.f388329d.size() > 1) {
                        bw bwVar = this.f388330d;
                        bwVar.g(bwVar.f388329d);
                    } else {
                        bw bwVar2 = this.f388330d;
                        bwVar2.h((a) bwVar2.f388329d.get(0));
                    }
                    this.f388330d.f388329d.clear();
                    System.gc();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class b<T> extends a {
        private List<String> D;
        private String E;
        private String[] F;
        private String G;
        private String H;
        private String I;
        private int J;
        private List<T> K;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i3) {
            super(str);
            this.K = new ArrayList();
            this.D = list;
            this.E = str2;
            this.F = strArr;
            this.G = str3;
            this.H = str4;
            this.I = str5;
            this.J = i3;
        }

        @Override // com.xiaomi.push.bw.a
        public SQLiteDatabase e() {
            return this.f388332e.getReadableDatabase();
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
        
            if (r14.moveToFirst() != false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
        
            r0 = m(r13, r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
        
            if (r0 == null) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
        
            r12.K.add(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
        
            if (r14.moveToNext() != false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        
            r14.close();
         */
        @Override // com.xiaomi.push.bw.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void i(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.K.clear();
            List<String> list = this.D;
            String str = null;
            if (list != null && list.size() > 0) {
                String[] strArr2 = new String[this.D.size()];
                this.D.toArray(strArr2);
                strArr = strArr2;
            } else {
                strArr = null;
            }
            int i3 = this.J;
            if (i3 > 0) {
                str = String.valueOf(i3);
            }
            Cursor query = sQLiteDatabase.query(this.f388331d, strArr, this.E, this.F, this.G, this.H, this.I, str);
            if (query != null) {
            }
            n(context, this.K);
        }

        public abstract T m(Context context, Cursor cursor);

        public abstract void n(Context context, List<T> list);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class c extends a {
        private ArrayList<a> D;

        @Override // com.xiaomi.push.bw.a
        public final void h(Context context) {
            super.h(context);
            Iterator<a> it = this.D.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.h(context);
                }
            }
        }

        @Override // com.xiaomi.push.bw.a
        public void i(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.D.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.i(context, sQLiteDatabase);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class d extends a {
        private String D;
        protected String[] E;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.D = str2;
            this.E = strArr;
        }

        @Override // com.xiaomi.push.bw.a
        public void i(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f388331d, this.D, this.E);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class e extends a {
        private ContentValues D;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.D = contentValues;
        }

        @Override // com.xiaomi.push.bw.a
        public void i(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f388331d, null, this.D);
        }
    }

    bw(Context context) {
        this.f388326a = context;
    }

    private ar a(String str) {
        ar arVar = this.f388327b.get(str);
        if (arVar == null) {
            synchronized (this.f388327b) {
                try {
                    if (arVar == null) {
                        throw null;
                    }
                } finally {
                }
            }
        }
        return arVar;
    }

    public static bw b(Context context) {
        if (f388325e == null) {
            synchronized (bw.class) {
                if (f388325e == null) {
                    f388325e = new bw(context);
                }
            }
        }
        return f388325e;
    }

    public String c(String str) {
        return a(str).a();
    }

    public void e(a aVar) {
        if (aVar == null) {
        } else {
            throw new IllegalStateException("should exec init method first!");
        }
    }

    public void f(Runnable runnable) {
        if (!this.f388328c.isShutdown()) {
            this.f388328c.execute(runnable);
        }
    }

    public void g(ArrayList<a> arrayList) {
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    public void h(a aVar) {
        if (aVar == null) {
        } else {
            throw new IllegalStateException("should exec init method first!");
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class a implements Runnable {
        private a C;

        /* renamed from: d, reason: collision with root package name */
        protected String f388331d;

        /* renamed from: f, reason: collision with root package name */
        private String f388333f;

        /* renamed from: h, reason: collision with root package name */
        private WeakReference<Context> f388334h;

        /* renamed from: e, reason: collision with root package name */
        protected ar f388332e = null;

        /* renamed from: i, reason: collision with root package name */
        private Random f388335i = new Random();

        /* renamed from: m, reason: collision with root package name */
        private int f388336m = 0;

        public a(String str) {
            this.f388333f = str;
        }

        public SQLiteDatabase e() {
            return this.f388332e.getWritableDatabase();
        }

        public Object f() {
            return null;
        }

        public String g() {
            return this.f388333f;
        }

        void h(Context context) {
            a aVar = this.C;
            if (aVar != null) {
                aVar.j(context, f());
            }
            l(context);
        }

        public abstract void i(Context context, SQLiteDatabase sQLiteDatabase);

        public void j(Context context, Object obj) {
            bw.b(context).e(this);
        }

        public void k(a aVar) {
            this.C = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            final Context context;
            WeakReference<Context> weakReference = this.f388334h;
            if (weakReference != null && (context = weakReference.get()) != null && context.getFilesDir() != null && this.f388332e != null && !TextUtils.isEmpty(this.f388333f)) {
                File file = new File(this.f388333f);
                u.b(context, new File(file.getParentFile(), ad.d(file.getAbsolutePath())), new Runnable() { // from class: com.xiaomi.push.bw.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SQLiteDatabase sQLiteDatabase = null;
                        try {
                            try {
                                sQLiteDatabase = a.this.e();
                                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                    sQLiteDatabase.beginTransaction();
                                    a.this.i(context, sQLiteDatabase);
                                    sQLiteDatabase.setTransactionSuccessful();
                                }
                                if (sQLiteDatabase != null) {
                                    try {
                                        sQLiteDatabase.endTransaction();
                                    } catch (Exception e16) {
                                        e = e16;
                                        jz4.c.q(e);
                                        a.this.h(context);
                                    }
                                }
                                ar arVar = a.this.f388332e;
                                if (arVar != null) {
                                    arVar.close();
                                }
                            } catch (Throwable th5) {
                                if (sQLiteDatabase != null) {
                                    try {
                                        sQLiteDatabase.endTransaction();
                                    } catch (Exception e17) {
                                        jz4.c.q(e17);
                                        a.this.h(context);
                                        throw th5;
                                    }
                                }
                                ar arVar2 = a.this.f388332e;
                                if (arVar2 != null) {
                                    arVar2.close();
                                }
                                a.this.h(context);
                                throw th5;
                            }
                        } catch (Exception e18) {
                            jz4.c.q(e18);
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Exception e19) {
                                    e = e19;
                                    jz4.c.q(e);
                                    a.this.h(context);
                                }
                            }
                            ar arVar3 = a.this.f388332e;
                            if (arVar3 != null) {
                                arVar3.close();
                            }
                        }
                        a.this.h(context);
                    }
                });
            }
        }

        public void l(Context context) {
        }
    }
}
