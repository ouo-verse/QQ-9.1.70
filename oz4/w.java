package oz4;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class w {

    /* renamed from: e, reason: collision with root package name */
    public static final DecimalFormat f424810e = new DecimalFormat("0.00");

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f424811a;

    /* renamed from: b, reason: collision with root package name */
    public uz4.c<List<byte[]>> f424812b;

    /* renamed from: c, reason: collision with root package name */
    public final s f424813c;

    /* renamed from: d, reason: collision with root package name */
    public final com.xingin.xhssharesdk.b.r f424814d;

    public w(final com.xingin.xhssharesdk.b.r rVar, s sVar) {
        d();
        this.f424813c = sVar;
        this.f424814d = rVar;
        this.f424811a = ProxyExecutors.newSingleThreadExecutor(new ThreadFactory() { // from class: oz4.t
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return w.c(com.xingin.xhssharesdk.b.r.this, runnable);
            }
        });
        f();
    }

    public static Thread c(com.xingin.xhssharesdk.b.r rVar, Runnable runnable) {
        return new BaseThread(runnable, "TrackerUpload-" + rVar.f389974a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(sz4.f fVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(fVar.f435071c);
        arrayList2.add(fVar);
        q.a("uploadData() count=%s length=%s \nresult=%s", 1, f424810e.format(fVar.f435071c.length / 1024.0d) + "KB", this.f424812b.a(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ArrayList<sz4.f> f16 = this.f424813c.f424804a.f();
        if (f16 != null && !f16.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            long j3 = 0;
            for (sz4.f fVar : f16) {
                byte[] bArr = fVar.f435071c;
                if (bArr.length >= 1048576) {
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    arrayList3.add(fVar.f435071c);
                    arrayList4.add(fVar);
                    uz4.f a16 = this.f424812b.a(arrayList3);
                    q.a("%s, uploadData() count=%s length=%s \nresult=%s", this.f424814d, 1, f424810e.format(fVar.f435071c.length / 1024.0d) + "KB", a16);
                    if (a16.f440699a) {
                        this.f424813c.f424804a.c(arrayList4);
                    }
                } else {
                    if (bArr.length + j3 > 1048576) {
                        uz4.f a17 = this.f424812b.a(arrayList);
                        q.a("%s, uploadData() count=%s length=%s \nresult=%s", this.f424814d, Integer.valueOf(arrayList2.size()), f424810e.format(j3 / 1024.0d) + "KB", a17);
                        if (a17.f440699a) {
                            this.f424813c.f424804a.c(arrayList2);
                        }
                        arrayList = new ArrayList();
                        arrayList2 = new ArrayList();
                        j3 = 0;
                    }
                    j3 += r4.length;
                    arrayList.add(fVar.f435071c);
                    arrayList2.add(fVar);
                }
            }
            if (j3 > 0) {
                uz4.f a18 = this.f424812b.a(arrayList);
                q.a("%s, uploadData() count=%s length=%s \nresult=%s", this.f424814d, Integer.valueOf(arrayList2.size()), f424810e.format(j3 / 1024.0d) + "KB", a18);
                if (a18.f440699a) {
                    this.f424813c.f424804a.c(arrayList2);
                }
            }
        }
    }

    public final void d() {
        uz4.d dVar;
        try {
            dVar = new uz4.d(new tz4.a());
        } catch (Throwable unused) {
            dVar = null;
        }
        this.f424812b = dVar;
        if (dVar == null) {
            this.f424812b = new uz4.e(new tz4.a());
            q.a("use OriginalHTTPTransport ", new Object[0]);
        } else {
            q.a("use OKHTTPTransport ", new Object[0]);
        }
    }

    public final void f() {
        s sVar = this.f424813c;
        long a16 = sVar.f424804a.a();
        sVar.f424804a.getClass();
        sVar.f424804a.getClass();
        long j3 = (a16 + 99) / 100;
        for (long j16 = 0; j16 < j3; j16++) {
            i();
        }
    }

    public final void g(final sz4.f fVar) {
        this.f424811a.execute(new Runnable() { // from class: oz4.v
            @Override // java.lang.Runnable
            public final void run() {
                w.this.e(fVar);
            }
        });
    }

    public final void i() {
        this.f424811a.execute(new Runnable() { // from class: oz4.u
            @Override // java.lang.Runnable
            public final void run() {
                w.this.h();
            }
        });
    }
}
