package com.huawei.hms.framework.network.grs.g;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.network.grs.h.d;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f37015a = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, com.huawei.hms.framework.network.grs.g.k.b> f37016b = new ConcurrentHashMap(16);

    /* renamed from: c, reason: collision with root package name */
    private final Object f37017c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f37018d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements Callable<d> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.g.k.c f37019a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f37020b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f37021c;

        a(com.huawei.hms.framework.network.grs.g.k.c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
            this.f37019a = cVar;
            this.f37020b = str;
            this.f37021c = cVar2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public d call() {
            return new c(this.f37019a, h.this.f37018d).a(h.this.f37015a, this.f37020b, this.f37021c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.g.k.c f37023a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f37024b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f37025c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.b f37026d;

        b(com.huawei.hms.framework.network.grs.g.k.c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2, com.huawei.hms.framework.network.grs.b bVar) {
            this.f37023a = cVar;
            this.f37024b = str;
            this.f37025c = cVar2;
            this.f37026d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.a(hVar.a(this.f37023a, this.f37024b, this.f37025c), this.f37026d);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        if (r2.a() != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0071, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d a(com.huawei.hms.framework.network.grs.g.k.c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
        Future<d> submit;
        String str2;
        String str3;
        Logger.d("RequestController", "request to server with service name is: " + str);
        String grsParasKey = cVar.b().getGrsParasKey(true, true, cVar.a());
        Logger.v("RequestController", "request spUrlKey: " + grsParasKey);
        synchronized (this.f37017c) {
            if (!NetworkUtil.isNetworkAvailable(cVar.a())) {
                return null;
            }
            d.a a16 = com.huawei.hms.framework.network.grs.h.d.a(grsParasKey);
            com.huawei.hms.framework.network.grs.g.k.b bVar = this.f37016b.get(grsParasKey);
            try {
                if (bVar != null && bVar.b()) {
                    submit = bVar.a();
                    return submit.get();
                }
                return submit.get();
            } catch (InterruptedException e16) {
                e = e16;
                str2 = "RequestController";
                str3 = "when check result, find InterruptedException, check others";
                Logger.w(str2, str3, e);
                return null;
            } catch (CancellationException e17) {
                e = e17;
                str2 = "RequestController";
                str3 = "when check result, find CancellationException, check others";
                Logger.w(str2, str3, e);
                return null;
            } catch (ExecutionException e18) {
                e = e18;
                str2 = "RequestController";
                str3 = "when check result, find ExecutionException, check others";
                Logger.w(str2, str3, e);
                return null;
            }
            Logger.d("RequestController", "hitGrsRequestBean == null or request block is released.");
            submit = this.f37015a.submit(new a(cVar, str, cVar2));
            this.f37016b.put(grsParasKey, new com.huawei.hms.framework.network.grs.g.k.b(submit));
        }
    }

    public void a(com.huawei.hms.framework.network.grs.e.a aVar) {
        this.f37018d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, com.huawei.hms.framework.network.grs.b bVar) {
        if (bVar != null) {
            if (dVar == null) {
                Logger.v("RequestController", "GrsResponse is null");
                bVar.a();
            } else {
                Logger.v("RequestController", "GrsResponse is not null");
                bVar.a(dVar);
            }
        }
    }

    public void a(com.huawei.hms.framework.network.grs.g.k.c cVar, com.huawei.hms.framework.network.grs.b bVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
        this.f37015a.execute(new b(cVar, str, cVar2, bVar));
    }

    public void a(String str) {
        synchronized (this.f37017c) {
            this.f37016b.remove(str);
        }
    }
}
