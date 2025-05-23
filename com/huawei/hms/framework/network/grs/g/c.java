package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.h.d;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: n, reason: collision with root package name */
    private static final String f36977n = "c";

    /* renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f36978a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f36979b;

    /* renamed from: c, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.a f36980c;

    /* renamed from: d, reason: collision with root package name */
    private d f36981d;

    /* renamed from: j, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.g.k.c f36987j;

    /* renamed from: k, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.g.k.d f36988k;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, Future<d>> f36982e = new ConcurrentHashMap(16);

    /* renamed from: f, reason: collision with root package name */
    private final List<d> f36983f = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final JSONArray f36984g = new JSONArray();

    /* renamed from: h, reason: collision with root package name */
    private final List<String> f36985h = new CopyOnWriteArrayList();

    /* renamed from: i, reason: collision with root package name */
    private final List<String> f36986i = new CopyOnWriteArrayList();

    /* renamed from: l, reason: collision with root package name */
    private String f36989l = "";

    /* renamed from: m, reason: collision with root package name */
    private long f36990m = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements Callable<d> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExecutorService f36991a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f36992b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f36993c;

        a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
            this.f36991a = executorService;
            this.f36992b = str;
            this.f36993c = cVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public d call() {
            return c.this.b(this.f36991a, this.f36992b, this.f36993c);
        }
    }

    public c(com.huawei.hms.framework.network.grs.g.k.c cVar, com.huawei.hms.framework.network.grs.e.a aVar) {
        this.f36987j = cVar;
        this.f36978a = cVar.b();
        this.f36979b = cVar.a();
        this.f36980c = aVar;
        c();
        d();
    }

    private d b(d dVar) {
        String str;
        String str2;
        for (Map.Entry<String, Future<d>> entry : this.f36982e.entrySet()) {
            if (dVar != null && (dVar.o() || dVar.m())) {
                break;
            }
            try {
                dVar = entry.getValue().get(40000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e16) {
                e = e16;
                str = f36977n;
                str2 = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str, str2, e);
            } catch (CancellationException unused) {
                Logger.i(f36977n, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e17) {
                e = e17;
                str = f36977n;
                str2 = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str, str2, e);
            } catch (TimeoutException unused2) {
                Logger.w(f36977n, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!entry.getValue().isCancelled()) {
                    entry.getValue().cancel(true);
                }
            }
        }
        return dVar;
    }

    private void c() {
        com.huawei.hms.framework.network.grs.g.k.d a16 = com.huawei.hms.framework.network.grs.g.j.a.a(this.f36979b);
        if (a16 == null) {
            Logger.w(f36977n, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        a(a16);
        List<String> a17 = a16.a();
        if (a17 != null && a17.size() > 0) {
            if (a17.size() <= 10) {
                String c16 = a16.c();
                String b16 = a16.b();
                if (a17.size() > 0) {
                    for (String str : a17) {
                        if (!str.startsWith("https://")) {
                            Logger.w(f36977n, "grs server just support https scheme url,please check.");
                        } else {
                            b(c16, str);
                            a(b16, str);
                        }
                    }
                }
                Logger.v(f36977n, "request to GRS server url is{%s} and {%s}", this.f36985h, this.f36986i);
                return;
            }
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
        Logger.v(f36977n, "maybe grs_base_url config with [],please check.");
    }

    private void d() {
        String grsParasKey = this.f36978a.getGrsParasKey(true, true, this.f36979b);
        this.f36989l = this.f36980c.a().a(grsParasKey + "ETag", "");
    }

    private String e() {
        com.huawei.hms.framework.network.grs.local.model.a aVar;
        com.huawei.hms.framework.network.grs.f.b a16 = com.huawei.hms.framework.network.grs.f.b.a(this.f36979b.getPackageName(), this.f36978a);
        if (a16 != null) {
            aVar = a16.a();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            String b16 = aVar.b();
            Logger.v(f36977n, "get appName from local assets is{%s}", b16);
            return b16;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d b(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        d a16 = a(executorService, this.f36986i, str, cVar);
        int b16 = a16 == null ? 0 : a16.b();
        String str2 = f36977n;
        Logger.v(str2, "use 2.0 interface return http's code is\uff1a{%s}", Integer.valueOf(b16));
        if (b16 == 404 || b16 == 401) {
            if (TextUtils.isEmpty(e()) && TextUtils.isEmpty(this.f36978a.getAppName())) {
                Logger.i(str2, "request grs server use 1.0 API must set appName,please check.");
                return null;
            }
            this.f36982e.clear();
            Logger.i(str2, "this env has not deploy new interface,so use old interface.");
            a16 = a(executorService, this.f36985h, str, cVar);
        }
        e.a(new ArrayList(this.f36983f), SystemClock.elapsedRealtime() - elapsedRealtime, this.f36984g, this.f36979b);
        this.f36983f.clear();
        return a16;
    }

    public d a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        String str2;
        String str3;
        if (this.f36985h.isEmpty() && this.f36986i.isEmpty()) {
            return null;
        }
        try {
            return (d) executorService.submit(new a(executorService, str, cVar)).get(b() != null ? r0.d() : 10, TimeUnit.SECONDS);
        } catch (InterruptedException e16) {
            e = e16;
            str2 = f36977n;
            str3 = "{submitExcutorTaskWithTimeout} the current thread was interrupted while waiting";
            Logger.w(str2, str3, e);
            return null;
        } catch (CancellationException unused) {
            Logger.i(f36977n, "{submitExcutorTaskWithTimeout} the computation was cancelled");
            return null;
        } catch (ExecutionException e17) {
            e = e17;
            str2 = f36977n;
            str3 = "{submitExcutorTaskWithTimeout} the computation threw an ExecutionException";
            Logger.w(str2, str3, e);
            return null;
        } catch (TimeoutException unused2) {
            Logger.w(f36977n, "{submitExcutorTaskWithTimeout} the wait timed out");
            return null;
        } catch (Exception e18) {
            e = e18;
            str2 = f36977n;
            str3 = "{submitExcutorTaskWithTimeout} catch Exception";
            Logger.w(str2, str3, e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009d A[LOOP:0: B:2:0x0005->B:13:0x009d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0094 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private d a(ExecutorService executorService, List<String> list, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        boolean z16;
        d dVar;
        d dVar2 = null;
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                break;
            }
            String str2 = list.get(i3);
            if (!TextUtils.isEmpty(str2)) {
                Future<d> submit = executorService.submit(new com.huawei.hms.framework.network.grs.g.a(str2, i3, this, this.f36979b, str, this.f36978a, cVar).g());
                this.f36982e.put(str2, submit);
                z16 = true;
                try {
                    dVar = submit.get(this.f36990m, TimeUnit.SECONDS);
                } catch (InterruptedException e16) {
                    e = e16;
                } catch (CancellationException unused) {
                } catch (ExecutionException e17) {
                    e = e17;
                } catch (TimeoutException unused2) {
                }
                if (dVar != null) {
                    try {
                    } catch (InterruptedException e18) {
                        e = e18;
                        dVar2 = dVar;
                        Logger.w(f36977n, "the current thread was interrupted while waiting", e);
                        if (!z16) {
                        }
                    } catch (CancellationException unused3) {
                        dVar2 = dVar;
                        Logger.i(f36977n, "{requestServer} the computation was cancelled");
                        if (!z16) {
                        }
                    } catch (ExecutionException e19) {
                        e = e19;
                        dVar2 = dVar;
                        Logger.w(f36977n, "the computation threw an ExecutionException", e);
                        z16 = false;
                        if (!z16) {
                        }
                    } catch (TimeoutException unused4) {
                        dVar2 = dVar;
                        Logger.w(f36977n, "the wait timed out");
                        z16 = false;
                        if (!z16) {
                        }
                    }
                    if (dVar.o() || dVar.m()) {
                        Logger.i(f36977n, "grs request return body is not null and is OK.");
                        dVar2 = dVar;
                        if (!z16) {
                            Logger.v(f36977n, "needBreak is true so need break current circulation");
                            break;
                        }
                        i3++;
                    }
                }
                dVar2 = dVar;
            }
            z16 = false;
            if (!z16) {
            }
        }
        return b(dVar2);
    }

    public com.huawei.hms.framework.network.grs.g.k.d b() {
        return this.f36988k;
    }

    private void b(String str, String str2) {
        if (TextUtils.isEmpty(this.f36978a.getAppName()) && TextUtils.isEmpty(e())) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(e()) ? this.f36978a.getAppName() : e();
        sb5.append(String.format(locale, str, objArr));
        String grsReqParamJoint = this.f36978a.getGrsReqParamJoint(false, false, "1.0", this.f36979b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            sb5.append(grsReqParamJoint);
        }
        this.f36985h.add(sb5.toString());
    }

    public String a() {
        return this.f36989l;
    }

    public synchronized void a(d dVar) {
        this.f36983f.add(dVar);
        d dVar2 = this.f36981d;
        if (dVar2 != null && (dVar2.o() || this.f36981d.m())) {
            Logger.v(f36977n, "grsResponseResult is ok");
            return;
        }
        if (dVar.n()) {
            Logger.i(f36977n, "GRS server open 503 limiting strategy.");
            com.huawei.hms.framework.network.grs.h.d.a(this.f36978a.getGrsParasKey(true, true, this.f36979b), new d.a(dVar.k(), SystemClock.elapsedRealtime()));
            return;
        }
        if (dVar.m()) {
            Logger.i(f36977n, "GRS server open 304 Not Modified.");
        }
        if (!dVar.o() && !dVar.m()) {
            Logger.v(f36977n, "grsResponseResult has exception so need return");
            return;
        }
        this.f36981d = dVar;
        this.f36980c.a(this.f36978a, dVar, this.f36979b, this.f36987j);
        com.huawei.hms.framework.network.grs.f.b.a(this.f36979b, this.f36978a);
        for (Map.Entry<String, Future<d>> entry : this.f36982e.entrySet()) {
            if (!entry.getKey().equals(dVar.l()) && !entry.getValue().isCancelled()) {
                Logger.i(f36977n, "future cancel");
                entry.getValue().cancel(true);
            }
        }
    }

    public void a(com.huawei.hms.framework.network.grs.g.k.d dVar) {
        this.f36988k = dVar;
    }

    private void a(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        sb5.append(str);
        String grsReqParamJoint = this.f36978a.getGrsReqParamJoint(false, false, e(), this.f36979b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            sb5.append(grsReqParamJoint);
        }
        this.f36986i.add(sb5.toString());
    }
}
