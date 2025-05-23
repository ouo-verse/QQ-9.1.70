package com.tencent.ams.monitor.metric;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.ams.monitor.metric.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class AdMetricService implements k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected l f70544a;

    /* renamed from: b, reason: collision with root package name */
    protected d f70545b;

    /* renamed from: c, reason: collision with root package name */
    protected AdMetricThreadManager f70546c;

    /* renamed from: d, reason: collision with root package name */
    private f f70547d;

    /* renamed from: e, reason: collision with root package name */
    private h f70548e;

    /* renamed from: f, reason: collision with root package name */
    protected PriorityQueue<i> f70549f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f70550g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f70551h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f70552i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f70553j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f70554k;

    public AdMetricService(l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lVar);
            return;
        }
        this.f70550g = false;
        this.f70551h = false;
        this.f70552i = false;
        this.f70553j = false;
        this.f70554k = false;
        this.f70544a = lVar;
        this.f70545b = new d(lVar.getWeakLogAdapter());
        WeakReference<m> weakThreadManagerAdapter = lVar.getWeakThreadManagerAdapter();
        if (weakThreadManagerAdapter == null) {
            this.f70547d = new f(lVar.getWeakLogAdapter());
            weakThreadManagerAdapter = new WeakReference<>(this.f70547d);
        }
        this.f70546c = new AdMetricThreadManager(lVar.getWeakLogAdapter(), weakThreadManagerAdapter);
        this.f70548e = new h(lVar.getWeakLogAdapter());
        this.f70549f = f();
    }

    private boolean e(i iVar) {
        if (iVar == null) {
            this.f70545b.c("AdMetricService", "[addMetricOnCommonThread] error, metric is null");
            return false;
        }
        if (!this.f70548e.b(iVar, this.f70544a.getCommonTagSets())) {
            this.f70545b.c("AdMetricService", "[addMetricOnCommonThread] error, metric is not valid, id:" + iVar.getId());
            return false;
        }
        return this.f70549f.offer(iVar);
    }

    private static PriorityQueue<i> f() {
        if (Build.VERSION.SDK_INT >= 24) {
            return new PriorityQueue<>(new a());
        }
        return new PriorityQueue<>(11, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(WeakReference<Context> weakReference, CopyOnWriteArrayList<i> copyOnWriteArrayList) {
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<i> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next == null) {
                    this.f70545b.c("AdMetricService", "[handleOnCommonThread] error, metric is null");
                } else if (!e(next)) {
                    this.f70545b.c("AdMetricService", "[handleOnCommonThread] error, addMetricOnCommonThread failed, id:" + next.getId());
                } else {
                    int size = this.f70549f.size() - this.f70544a.getMaxCount();
                    if (size > 0) {
                        i(size);
                    }
                    arrayList.add(Long.valueOf(next.getId()));
                }
            }
            this.f70545b.e("AdMetricService", "[handleOnCommonThread] size:" + copyOnWriteArrayList.size() + " idList:" + arrayList);
            if (!arrayList.isEmpty()) {
                j(weakReference, false);
                return;
            }
            return;
        }
        this.f70545b.c("AdMetricService", "[handleOnCommonThread] error, metrics is null or empty");
    }

    private Collection<i> h(long j3) {
        PriorityQueue<i> f16 = f();
        while (!this.f70549f.isEmpty()) {
            i peek = this.f70549f.peek();
            if (peek == null) {
                this.f70545b.c("AdMetricService", "[removeMetricBeforeOnCommonThread] error, metric is null");
            } else {
                if (peek.getTimeMillis() > j3) {
                    break;
                }
                f16.offer(this.f70549f.poll());
            }
        }
        if (f16.isEmpty()) {
            return null;
        }
        return f16;
    }

    private Collection<i> i(int i3) {
        if (i3 > 0 && this.f70549f.size() >= i3) {
            PriorityQueue<i> f16 = f();
            for (int i16 = 0; i16 < i3; i16++) {
                f16.offer(this.f70549f.poll());
            }
            if (f16.isEmpty()) {
                return null;
            }
            return f16;
        }
        this.f70545b.c("AdMetricService", "[removeMetricOnCommonThread] error, count:" + i3 + " mMetricQueue.size():" + this.f70549f.size());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(WeakReference<Context> weakReference, boolean z16) {
        Collection<i> h16;
        boolean z17 = false;
        if (this.f70552i) {
            this.f70545b.a("AdMetricService", "[reportOnCommonThread] do nothing, mReportEnabled:" + this.f70551h + " mReporting:" + this.f70552i + " mReportPending:" + this.f70553j + " mReportPendingForced:" + this.f70554k);
            this.f70553j = true;
            if (this.f70554k || z16) {
                z17 = true;
            }
            this.f70554k = z17;
            return;
        }
        this.f70553j = false;
        this.f70554k = false;
        if (!this.f70551h) {
            this.f70545b.a("AdMetricService", "[reportOnCommonThread] do nothing, not enabled, mReportEnabled:" + this.f70551h + " mReporting:" + this.f70552i + " mReportPending:" + this.f70553j + " mReportPendingForced:" + this.f70554k);
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (this.f70549f.size() >= this.f70544a.getCountThreshold()) {
            Collection<i> i3 = i(this.f70544a.getCountThreshold());
            if (i3 != null && !i3.isEmpty()) {
                arrayList.add(i3);
            }
        }
        if (!this.f70549f.isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis() - this.f70544a.getIntervalMillisThreshold();
            if (z16) {
                h16 = i(this.f70549f.size());
            } else {
                h16 = h(currentTimeMillis);
            }
            if (h16 != null && !h16.isEmpty()) {
                arrayList.add(h16);
            }
        }
        if (arrayList.isEmpty()) {
            this.f70545b.a("AdMetricService", "[reportOnCommonThread] do nothing, mMetricQueue.size():" + this.f70549f.size());
            return;
        }
        k(weakReference, arrayList);
    }

    private void k(WeakReference<Context> weakReference, Collection<Collection<i>> collection) {
        if (collection != null && !collection.isEmpty()) {
            this.f70552i = true;
            this.f70546c.c(new Runnable(collection, weakReference) { // from class: com.tencent.ams.monitor.metric.AdMetricService.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Collection f70561d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ WeakReference f70562e;

                {
                    this.f70561d = collection;
                    this.f70562e = weakReference;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AdMetricService.this, collection, weakReference);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Iterator it = this.f70561d.iterator();
                    while (it.hasNext()) {
                        AdMetricService.this.l((Collection) it.next());
                    }
                    AdMetricService.this.f70546c.c(new Runnable() { // from class: com.tencent.ams.monitor.metric.AdMetricService.5.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            AdMetricService adMetricService = AdMetricService.this;
                            adMetricService.f70552i = false;
                            if (adMetricService.f70553j) {
                                adMetricService.j(anonymousClass5.f70562e, adMetricService.f70554k);
                            }
                        }
                    }, 1);
                }
            }, 10);
        } else {
            this.f70545b.a("AdMetricService", "[sendOnCommonThread] do nothing, metricsCollection is null or empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Collection<i> collection) {
        String str;
        byte[] bArr;
        if (collection != null && !collection.isEmpty()) {
            JSONObject e16 = new c(this.f70544a.getWeakLogAdapter()).e(this.f70544a.getBusinessType(), this.f70544a.getCommonTagSets(), collection);
            if (e16 != null && !JSONObject.NULL.equals(e16)) {
                try {
                    String jSONObject = e16.toString();
                    if (TextUtils.isEmpty(jSONObject)) {
                        this.f70545b.c("AdMetricService", "[sendOnNetworkThread] error, requestString is empty");
                        return;
                    }
                    try {
                        byte[] bytes = jSONObject.getBytes("UTF-8");
                        if (bytes == null) {
                            this.f70545b.c("AdMetricService", "[sendOnNetworkThread] error, requestData is null");
                            return;
                        }
                        String b16 = new g(this.f70544a.getWeakLogAdapter()).b(this.f70544a.getUrl());
                        b.a aVar = new b.a(this.f70544a.getWeakLogAdapter());
                        aVar.f(b16);
                        aVar.f70568c = "POST";
                        aVar.f70569d = "application/json";
                        aVar.f70573h = bytes;
                        aVar.f70571f = 3000;
                        aVar.f70572g = 3000;
                        if (!aVar.c()) {
                            this.f70545b.c("AdMetricService", "[sendOnNetworkThread] error, params not valid");
                            return;
                        }
                        b.b(aVar);
                        if (aVar.e() && (bArr = aVar.f70574i) != null) {
                            try {
                                str = new String(bArr, "UTF-8");
                            } catch (Throwable th5) {
                                this.f70545b.d("AdMetricService", "[sendOnNetworkThread]", th5);
                            }
                            this.f70545b.e("AdMetricService", "[sendOnNetworkThread] url:" + b16 + " success:" + aVar.e() + " responseCode:" + aVar.f70575j + " requestString:" + jSONObject + " responseString:" + str);
                            return;
                        }
                        str = null;
                        this.f70545b.e("AdMetricService", "[sendOnNetworkThread] url:" + b16 + " success:" + aVar.e() + " responseCode:" + aVar.f70575j + " requestString:" + jSONObject + " responseString:" + str);
                        return;
                    } catch (Throwable th6) {
                        this.f70545b.d("AdMetricService", "[sendOnNetworkThread]", th6);
                        return;
                    }
                } catch (Throwable th7) {
                    this.f70545b.d("AdMetricService", "[sendOnNetworkThread] error", th7);
                    return;
                }
            }
            this.f70545b.c("AdMetricService", "[sendOnNetworkThread] error, requestJSONObject is null");
            return;
        }
        this.f70545b.a("AdMetricService", "[sendOnNetworkThread] do nothing, metrics is null");
    }

    @Override // com.tencent.ams.monitor.metric.k
    public void a(WeakReference<Context> weakReference) {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) weakReference);
            return;
        }
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        this.f70546c.c(new Runnable(new WeakReference(context)) { // from class: com.tencent.ams.monitor.metric.AdMetricService.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ WeakReference f70560d;

            {
                this.f70560d = r5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AdMetricService.this, (Object) r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                AdMetricService adMetricService = AdMetricService.this;
                if (adMetricService.f70550g) {
                    adMetricService.f70545b.e("AdMetricService", "[shutdownSafely] do nothing, mShutDownSafely:" + AdMetricService.this.f70550g);
                    return;
                }
                adMetricService.f70545b.e("AdMetricService", "[shutdownSafely]");
                AdMetricService.this.j(this.f70560d, true);
                AdMetricService adMetricService2 = AdMetricService.this;
                adMetricService2.f70550g = true;
                adMetricService2.f70546c.e();
            }
        }, 1);
    }

    @Override // com.tencent.ams.monitor.metric.k
    public void flush(WeakReference<Context> weakReference) {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) weakReference);
            return;
        }
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        this.f70546c.c(new Runnable(new WeakReference(context)) { // from class: com.tencent.ams.monitor.metric.AdMetricService.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ WeakReference f70559d;

            {
                this.f70559d = r5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AdMetricService.this, (Object) r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                AdMetricService adMetricService = AdMetricService.this;
                if (adMetricService.f70550g) {
                    adMetricService.f70545b.e("AdMetricService", "[flush] do nothing, mShutDownSafely:" + AdMetricService.this.f70550g);
                    return;
                }
                adMetricService.f70545b.e("AdMetricService", "[flush]");
                AdMetricService.this.j(this.f70559d, true);
            }
        }, 1);
    }

    @Override // com.tencent.ams.monitor.metric.k
    public void handle(WeakReference<Context> weakReference, CopyOnWriteArrayList<i> copyOnWriteArrayList) {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) weakReference, (Object) copyOnWriteArrayList);
            return;
        }
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        this.f70546c.c(new Runnable(new WeakReference(context), copyOnWriteArrayList) { // from class: com.tencent.ams.monitor.metric.AdMetricService.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ WeakReference f70557d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ CopyOnWriteArrayList f70558e;

            {
                this.f70557d = r8;
                this.f70558e = copyOnWriteArrayList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, AdMetricService.this, r8, copyOnWriteArrayList);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                AdMetricService adMetricService = AdMetricService.this;
                if (!adMetricService.f70550g) {
                    adMetricService.g(this.f70557d, this.f70558e);
                    return;
                }
                adMetricService.f70545b.e("AdMetricService", "[handle] do nothing, mShutDownSafely:" + AdMetricService.this.f70550g);
            }
        }, 1);
    }

    @Override // com.tencent.ams.monitor.metric.k
    public void setReportEnabled(WeakReference<Context> weakReference, boolean z16) {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, weakReference, Boolean.valueOf(z16));
            return;
        }
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        this.f70546c.c(new Runnable(z16, new WeakReference(context)) { // from class: com.tencent.ams.monitor.metric.AdMetricService.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f70555d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ WeakReference f70556e;

            {
                this.f70555d = z16;
                this.f70556e = r7;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, AdMetricService.this, Boolean.valueOf(z16), r7);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                AdMetricService adMetricService = AdMetricService.this;
                if (adMetricService.f70550g) {
                    adMetricService.f70545b.e("AdMetricService", "[setReportEnabled] do nothing, mShutDownSafely:" + AdMetricService.this.f70550g);
                    return;
                }
                adMetricService.f70545b.e("AdMetricService", "[setReportEnabled] enabled:" + this.f70555d);
                AdMetricService adMetricService2 = AdMetricService.this;
                boolean z17 = this.f70555d;
                adMetricService2.f70551h = z17;
                if (z17) {
                    adMetricService2.j(this.f70556e, false);
                }
            }
        }, 1);
    }
}
