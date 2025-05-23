package com.tencent.luggage.wxa.c2;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.magicbrush.MBRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: n, reason: collision with root package name */
    public static final SparseArray f123209n = new SparseArray();

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.o8.b f123215f;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f123218i;

    /* renamed from: a, reason: collision with root package name */
    public int f123210a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f123211b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f123212c = 0;

    /* renamed from: d, reason: collision with root package name */
    public String f123213d = "";

    /* renamed from: e, reason: collision with root package name */
    public boolean f123214e = false;

    /* renamed from: g, reason: collision with root package name */
    public int f123216g = -1;

    /* renamed from: h, reason: collision with root package name */
    public float f123217h = -1.0f;

    /* renamed from: j, reason: collision with root package name */
    public int f123219j = 1004;

    /* renamed from: k, reason: collision with root package name */
    public CopyOnWriteArrayList f123220k = new CopyOnWriteArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final e f123221l = new e(null);

    /* renamed from: m, reason: collision with root package name */
    public e.c f123222m = new c();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.c2.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6089a implements Runnable {
        public RunnableC6089a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.f123210a = aVar.f123220k.size();
            w.d("MicroMsg.MBNiReporter", "hy: onFirstFrameRendered picnum:%d", Integer.valueOf(a.this.f123210a));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.o8.b bVar = a.this.f123215f;
            if (bVar != null) {
                a aVar = a.this;
                aVar.f123217h = bVar.a(aVar.f123216g);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends e.c {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onCreate() {
            w.d("MicroMsg.MBNiReporter", "hy: onCreate");
            a.this.a();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            w.d("MicroMsg.MBNiReporter", "hy: onDestroy");
            a.this.b();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            w.d("MicroMsg.MBNiReporter", "hy: onPause");
            a.this.d();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onResume() {
            w.d("MicroMsg.MBNiReporter", "hy: onResume");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public d() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0100  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            float f16;
            double d16;
            g gVar;
            long j3 = a.this.f123212c - a.this.f123211b;
            long a16 = (w0.a() - a.this.f123212c) / 1000;
            if (a16 <= 0 || a16 >= 10) {
                f16 = a.this.f123217h;
            } else if (a.this.f123215f != null) {
                f16 = a.this.f123215f.a(a.this.f123216g);
            } else {
                d16 = -1.0d;
                gVar = new g();
                if (a.this.f123220k.size() > 0 && a.this.f123210a > 0) {
                    a aVar = a.this;
                    aVar.a(gVar, aVar.f123220k);
                }
                f fVar = new f();
                if (a.this.f123220k.size() > 0) {
                    a aVar2 = a.this;
                    aVar2.a(fVar, aVar2.f123220k);
                }
                a.this.f123210a = 0;
                a.this.f123220k.clear();
                a.this.c();
                w.d("MicroMsg.MBNiReporter", "hy: decode performance appid:%s,inject2firstDraw:%d,firstFps:%f,PreDecodeNum:%d,PreDecodeTotalTime:%d,preDecodeAvgTime:%f,totalDecodeNum:%d,totalDecodeTime:%d,totalDecodeAvgTime:%f", a.this.f123213d, Long.valueOf(j3), Double.valueOf(d16), Integer.valueOf(gVar.f123231a), Long.valueOf(gVar.f123232b), Double.valueOf(gVar.f123233c), Integer.valueOf(fVar.f123227a), Long.valueOf(fVar.f123228b), Double.valueOf(fVar.f123229c));
                if (j3 > 0) {
                    ((com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class)).a(16136, a.this.f123213d, Long.valueOf(j3), Double.valueOf(d16), Integer.valueOf(gVar.f123231a), Long.valueOf(gVar.f123232b), Double.valueOf(gVar.f123233c), Integer.valueOf(fVar.f123227a), Long.valueOf(fVar.f123228b), Double.valueOf(fVar.f123229c));
                }
                a.this.f123214e = true;
            }
            d16 = f16;
            gVar = new g();
            if (a.this.f123220k.size() > 0) {
                a aVar3 = a.this;
                aVar3.a(gVar, aVar3.f123220k);
            }
            f fVar2 = new f();
            if (a.this.f123220k.size() > 0) {
            }
            a.this.f123210a = 0;
            a.this.f123220k.clear();
            a.this.c();
            w.d("MicroMsg.MBNiReporter", "hy: decode performance appid:%s,inject2firstDraw:%d,firstFps:%f,PreDecodeNum:%d,PreDecodeTotalTime:%d,preDecodeAvgTime:%f,totalDecodeNum:%d,totalDecodeTime:%d,totalDecodeAvgTime:%f", a.this.f123213d, Long.valueOf(j3), Double.valueOf(d16), Integer.valueOf(gVar.f123231a), Long.valueOf(gVar.f123232b), Double.valueOf(gVar.f123233c), Integer.valueOf(fVar2.f123227a), Long.valueOf(fVar2.f123228b), Double.valueOf(fVar2.f123229c));
            if (j3 > 0) {
            }
            a.this.f123214e = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends SparseIntArray {
        public e() {
        }

        public /* synthetic */ e(RunnableC6089a runnableC6089a) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        public int f123227a;

        /* renamed from: b, reason: collision with root package name */
        public long f123228b;

        /* renamed from: c, reason: collision with root package name */
        public double f123229c;

        public f() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        public int f123231a;

        /* renamed from: b, reason: collision with root package name */
        public long f123232b;

        /* renamed from: c, reason: collision with root package name */
        public double f123233c;

        public g() {
        }
    }

    public static void b(String str) {
        a aVar;
        int hashCode = str.hashCode();
        SparseArray sparseArray = f123209n;
        synchronized (sparseArray) {
            int indexOfKey = sparseArray.indexOfKey(hashCode);
            if (indexOfKey >= 0) {
                aVar = (a) sparseArray.valueAt(indexOfKey);
                sparseArray.removeAt(indexOfKey);
            } else {
                aVar = null;
            }
        }
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void c() {
        synchronized (this.f123221l) {
            for (int i3 = 0; i3 < this.f123221l.size(); i3++) {
                int keyAt = this.f123221l.keyAt(i3);
                int valueAt = this.f123221l.valueAt(i3);
                w.d("MicroMsg.MBNiReporter", "hy: picSize level:%d,num:%d", Integer.valueOf(keyAt), Integer.valueOf(valueAt));
                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(936L, keyAt, valueAt, false);
            }
        }
    }

    public void d() {
        if (this.f123214e) {
            w.d("MicroMsg.MBNiReporter", "hy: hasReported!");
        } else {
            h.f146825d.execute(new d());
        }
    }

    public static a a(String str) {
        a aVar;
        int hashCode = str.hashCode();
        SparseArray sparseArray = f123209n;
        synchronized (sparseArray) {
            aVar = (a) sparseArray.get(hashCode);
            if (aVar == null) {
                aVar = new a();
                sparseArray.put(hashCode, aVar);
            }
        }
        return aVar;
    }

    public void b() {
        w.d("MicroMsg.MBNiReporter", "hy: release!");
        com.tencent.luggage.wxa.ic.e.b(this.f123213d, this.f123222m);
    }

    public void a(String str, boolean z16) {
        this.f123213d = str;
        w.d("MicroMsg.MBNiReporter", "hy: appId:%s,isGame:%s", str, Boolean.valueOf(z16));
        if (z16) {
            com.tencent.luggage.wxa.ic.e.a(str, this.f123222m);
        }
        this.f123218i = new ArrayList();
        if (z16) {
            this.f123219j = 1004;
        } else {
            this.f123219j = 1000;
        }
    }

    public void a(MBRuntime mBRuntime) {
        this.f123212c = w0.a();
        try {
            this.f123215f = mBRuntime.g();
        } catch (NullPointerException e16) {
            w.a("MicroMsg.MBNiReporter", e16, "inspector null pointer!", new Object[0]);
        }
        com.tencent.luggage.wxa.o8.b bVar = this.f123215f;
        if (bVar != null) {
            this.f123216g = bVar.k();
        }
        h.f146825d.execute(new RunnableC6089a());
        h.f146825d.a(new b(), 10L);
    }

    public final void a() {
        w.d("MicroMsg.MBNiReporter", "hy: initStatis!");
        CopyOnWriteArrayList copyOnWriteArrayList = this.f123220k;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            this.f123220k.clear();
        }
        synchronized (this.f123221l) {
            if (this.f123221l.size() > 0) {
                this.f123221l.clear();
            }
        }
        this.f123214e = false;
        this.f123210a = 0;
        this.f123211b = 0L;
        this.f123212c = 0L;
    }

    public final void a(g gVar, CopyOnWriteArrayList copyOnWriteArrayList) {
        if (copyOnWriteArrayList.size() < this.f123210a) {
            return;
        }
        Long[] lArr = (Long[]) Arrays.copyOf((Long[]) copyOnWriteArrayList.toArray(new Long[0]), this.f123210a);
        if (lArr == null || lArr.length <= 0) {
            return;
        }
        int length = lArr.length;
        double d16 = 0.0d;
        for (Long l3 : lArr) {
            d16 += l3.longValue();
        }
        gVar.f123231a = lArr.length;
        gVar.f123232b = (long) d16;
        gVar.f123233c = d16 / length;
    }

    public final void a(f fVar, CopyOnWriteArrayList copyOnWriteArrayList) {
        int size = copyOnWriteArrayList.size();
        w.d("MicroMsg.MBNiReporter", "hy: calculateAverageCost size:%d", Integer.valueOf(size));
        Long[] lArr = (Long[]) Arrays.copyOf((Long[]) copyOnWriteArrayList.toArray(new Long[0]), size);
        if (lArr == null || lArr.length <= 0) {
            return;
        }
        int length = lArr.length;
        double d16 = 0.0d;
        for (int i3 = 0; i3 < length; i3++) {
            if (lArr[i3] == null) {
                w.f("MicroMsg.MBNiReporter", "calculateAverageCost tempArray[%d] null!", Integer.valueOf(i3));
            } else {
                d16 += r7.longValue();
            }
        }
        fVar.f123227a = lArr.length;
        fVar.f123228b = (long) d16;
        fVar.f123229c = d16 / length;
    }
}
