package hynb.t;

import android.content.Context;
import com.google.gson.Gson;
import com.huya.statistics.bean.SDKReport;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import hynb.p.g;
import hynb.u.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d {

    /* renamed from: g, reason: collision with root package name */
    public static final long f406856g = System.currentTimeMillis() - 1;

    /* renamed from: a, reason: collision with root package name */
    public final hynb.s.b f406857a;

    /* renamed from: b, reason: collision with root package name */
    public final String f406858b;

    /* renamed from: c, reason: collision with root package name */
    public int f406859c = 0;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f406860d = false;

    /* renamed from: e, reason: collision with root package name */
    public final Gson f406861e = new Gson();

    /* renamed from: f, reason: collision with root package name */
    public Runnable f406862f = new a();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Collection<hynb.s.a> a16;
            if (g.f406801c.a()) {
                int i3 = 0;
                while (true) {
                    if (i3 > 5 || (a16 = d.this.f406857a.a(400)) == null || a16.size() <= 0) {
                        break;
                    }
                    if (!d.this.a(a16, false)) {
                        d.c(d.this);
                        break;
                    } else {
                        hynb.t.a.b();
                        d.this.f406859c = 0;
                        i3++;
                    }
                }
            }
            hynb.u.c.a(d.this.f406862f, (d.this.f406859c + 1) * 5000);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hynb.t.a f406864a;

        public b(hynb.t.a aVar) {
            this.f406864a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            hynb.s.a aVar = new hynb.s.a();
            aVar.f406838a = d.this.f406861e.toJson(new SDKReport.DataInfo(this.f406864a.f406848a)).getBytes();
            aVar.f406840c = hynb.u.d.a(this.f406864a.f406849b);
            aVar.f406839b = System.currentTimeMillis();
            d.this.f406857a.a(aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<hynb.s.a> a16;
            try {
                LockMethodProxy.sleep(2000L);
                d.this.f406857a.a();
                while (!d.this.f406860d && (a16 = d.this.f406857a.a(400, d.f406856g)) != null && a16.size() != 0) {
                    if (!d.this.a((Collection<hynb.s.a>) a16, true)) {
                        LockMethodProxy.sleep(5000L);
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public d(Context context, String str) {
        this.f406857a = new hynb.s.b(context);
        this.f406858b = str;
        hynb.u.c.a(this.f406862f, 5000L);
        b();
    }

    public static /* synthetic */ int c(d dVar) {
        int i3 = dVar.f406859c;
        dVar.f406859c = i3 + 1;
        return i3;
    }

    public final void b() {
        hynb.u.c.a(new c());
    }

    public void a(hynb.t.a aVar) {
        hynb.u.c.a(new b(aVar));
    }

    public final synchronized boolean a(Collection<hynb.s.a> collection, boolean z16) {
        if (collection != null) {
            if (collection.size() != 0) {
                Iterator<hynb.s.a> it = collection.iterator();
                ArrayList arrayList = new ArrayList();
                int size = collection.size();
                Object[] objArr = new Object[size];
                for (int i3 = 0; i3 < size; i3++) {
                    hynb.s.a next = it.next();
                    byte[] bArr = next.f406838a;
                    if (bArr != null) {
                        arrayList.add((SDKReport.DataInfo) this.f406861e.fromJson(new String(bArr), SDKReport.DataInfo.class));
                        objArr[i3] = next.f406840c;
                    }
                }
                SDKReport sDKReport = new SDKReport();
                sDKReport.vBody = arrayList;
                sDKReport.tHeader = new SDKReport.DataInfo();
                String json = this.f406861e.toJson(sDKReport);
                byte[] bytes = json.getBytes();
                a.b a16 = new a.b().a(true);
                Map<String, String> b16 = hynb.u.d.b();
                int nextInt = new Random().nextInt();
                String a17 = hynb.u.d.a(nextInt);
                if (a17 != null && a17.length() == 16) {
                    a16.a(a17);
                    b16.put("Huya-Salt", String.valueOf(nextInt));
                }
                byte[] a18 = hynb.u.b.a(this.f406858b, b16, bytes, a16.a());
                g.f406799a.a("StatsCompat", "report schedule body content: " + json);
                this.f406860d = this.f406857a.a(objArr, a18 != null);
                if (a18 == null) {
                    return false;
                }
                if (!z16) {
                    this.f406857a.b(size);
                }
                return true;
            }
        }
        return false;
    }
}
