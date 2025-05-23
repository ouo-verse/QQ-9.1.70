package com.tencent.luggage.wxa.yi;

import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.oskplayer.proxy.VideoProxy;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b implements i {

    /* renamed from: k, reason: collision with root package name */
    public static int f145819k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static int f145820l = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f145821b;

    /* renamed from: c, reason: collision with root package name */
    public String f145822c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f145823d;

    /* renamed from: e, reason: collision with root package name */
    public SSLContext f145824e;

    /* renamed from: f, reason: collision with root package name */
    public final String f145825f;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f145827h;

    /* renamed from: i, reason: collision with root package name */
    public final Map f145828i;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f145826g = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f145829j = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements com.tencent.luggage.wxa.zi.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f145830a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f145831b;

        public a(String str, c cVar) {
            this.f145830a = str;
            this.f145831b = cVar;
        }

        @Override // com.tencent.luggage.wxa.zi.a
        public void a(String str, String str2) {
        }

        @Override // com.tencent.luggage.wxa.zi.a
        public void a(String str, String str2, String str3, int i3, long j3, Map map) {
            b.this.d(this.f145830a);
            this.f145831b.a(b.f145819k, str2, str, i3, j3, map);
        }

        @Override // com.tencent.luggage.wxa.zi.a
        public void a(JSONObject jSONObject) {
            this.f145831b.a(jSONObject);
        }

        @Override // com.tencent.luggage.wxa.zi.a
        public void a(String str, String str2, int i3, long j3, long j16) {
            this.f145831b.a(i3, j3, j16);
        }

        @Override // com.tencent.luggage.wxa.zi.a
        public void a(String str, String str2, String str3, int i3) {
            b.this.d(this.f145830a);
            this.f145831b.a(b.f145820l, str3, i3);
        }

        @Override // com.tencent.luggage.wxa.zi.a
        public void a(String str) {
            b.this.f145826g.remove(str);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.yi.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC6957b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f145833a;

        public RunnableC6957b(String str) {
            this.f145833a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConcurrentLinkedQueue concurrentLinkedQueue;
            Runnable runnable;
            synchronized (b.this.f145828i) {
                concurrentLinkedQueue = (ConcurrentLinkedQueue) b.this.f145828i.get(this.f145833a);
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkDownload", "hy: url %s queue size %d", this.f145833a, Integer.valueOf(concurrentLinkedQueue.size()));
                runnable = (Runnable) concurrentLinkedQueue.peek();
            }
            if (runnable != null) {
                runnable.run();
                concurrentLinkedQueue.poll();
                if (concurrentLinkedQueue.size() > 0) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkDownload", "hy: need execute more");
                    b.this.a(this.f145833a);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void a(int i3, long j3, long j16);

        void a(int i3, String str, int i16);

        void a(int i3, String str, String str2, int i16, long j3, Map map);

        void a(JSONObject jSONObject);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
        boolean a(String str);
    }

    public b(com.tencent.luggage.wxa.xd.d dVar, boolean z16) {
        this.f145823d = false;
        this.f145827h = dVar;
        com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class);
        this.f145821b = aVar.f145800j;
        this.f145825f = aVar.K;
        this.f145824e = q.a(aVar);
        this.f145828i = new Hashtable(10);
        this.f145823d = z16;
        String e16 = com.tencent.luggage.wxa.db.a.e();
        if (!e16.endsWith("/")) {
            e16 = e16 + "/";
        }
        this.f145822c = e16 + "networkfiles/";
    }

    public boolean c(String str) {
        return this.f145826g.contains(str);
    }

    public final void d(String str) {
        if (str == null) {
            return;
        }
        synchronized (this.f145829j) {
            Iterator it = this.f145829j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.luggage.wxa.zi.b bVar = (com.tencent.luggage.wxa.zi.b) it.next();
                if (str.equals(bVar.f())) {
                    this.f145829j.remove(bVar);
                    break;
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.yi.i
    public void release() {
        synchronized (this.f145829j) {
            Iterator it = this.f145829j.iterator();
            while (it.hasNext()) {
                ((com.tencent.luggage.wxa.zi.b) it.next()).b(false);
            }
            this.f145829j.clear();
        }
    }

    public com.tencent.luggage.wxa.zi.b b(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.f145829j) {
            Iterator it = this.f145829j.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.zi.b bVar = (com.tencent.luggage.wxa.zi.b) it.next();
                if (str.equals(bVar.f())) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public void a(JSONObject jSONObject, int i3, Map map, ArrayList arrayList, int i16, c cVar, String str, String str2) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        String a16 = q.a(jSONObject.optString("url"));
        synchronized (this.f145829j) {
            if (this.f145829j.size() >= this.f145821b) {
                int i17 = f145820l;
                com.tencent.luggage.wxa.af.c cVar2 = com.tencent.luggage.wxa.af.i.f121362h;
                cVar.a(i17, cVar2.f121278b, cVar2.f121277a);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkDownload", "exceed max task count mDownloadTaskList.size():%d,mMaxConnected:%d", Integer.valueOf(this.f145829j.size()), Integer.valueOf(this.f145821b));
                return;
            }
            String optString = jSONObject.optString("filePath");
            String str3 = this.f145822c + com.tencent.luggage.wxa.tn.y.a(a16) + FaceUtil.IMG_TEMP + System.currentTimeMillis() + "task" + str;
            boolean optBoolean = jSONObject.optBoolean("enableHttp2", false);
            boolean optBoolean2 = jSONObject.optBoolean("enableQuic", false);
            boolean optBoolean3 = jSONObject.optBoolean(VideoProxy.PARAM_ENABLE_CACHE, false);
            boolean optBoolean4 = jSONObject.optBoolean("enableProfile", true);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkDownload", "download taskId %s,useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b", str, Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean3), Boolean.valueOf(optBoolean4));
            com.tencent.luggage.wxa.zi.b bVar = new com.tencent.luggage.wxa.zi.b(this.f145827h, a16, str3, optString, this.f145825f, this.f145823d, optBoolean, optBoolean2, optBoolean3, optBoolean4, new a(str, cVar));
            bVar.a(map);
            bVar.d(i3);
            bVar.b(true);
            bVar.a(arrayList);
            bVar.c(i16);
            bVar.a(this.f145824e);
            bVar.b(str);
            bVar.a(str2);
            synchronized (this.f145829j) {
                this.f145829j.add(bVar);
            }
            synchronized (this.f145828i) {
                if (!this.f145828i.containsKey(a16)) {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue();
                    this.f145828i.put(a16, concurrentLinkedQueue);
                } else {
                    concurrentLinkedQueue = (ConcurrentLinkedQueue) this.f145828i.get(a16);
                }
                concurrentLinkedQueue.offer(bVar);
            }
            if (this.f145828i.get(a16) != null && ((ConcurrentLinkedQueue) this.f145828i.get(a16)).size() > 1) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkDownload", "hy: more than one same url in the queue, just add and wait");
            } else {
                a(a16);
            }
        }
    }

    public final void a(String str) {
        com.tencent.luggage.wxa.co.a.a(new RunnableC6957b(str), "appbrand_download_thread");
    }

    public void a(com.tencent.luggage.wxa.zi.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f145826g.add(bVar.f());
        d(bVar.f());
        bVar.a();
    }
}
