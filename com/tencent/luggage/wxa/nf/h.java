package com.tencent.luggage.wxa.nf;

import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.yi.a0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 529;
    public static final String NAME = "operateLocalServicesScan";

    /* renamed from: a, reason: collision with root package name */
    public final Map f135793a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public WifiManager.MulticastLock f135794b = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f135795a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f135796b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f135797c;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.nf.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6512a implements Runnable {
            public RunnableC6512a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (h.this.f135793a) {
                    Map map = h.this.f135793a;
                    a aVar = a.this;
                    if (!map.containsKey(h.this.a(aVar.f135795a, aVar.f135796b))) {
                        w.d("MicroMsg.JsApiOperateLocalServicesScan", "scan task not exist, cancel auto stop");
                        return;
                    }
                    a0.INSTANCE.a(a.this.f135797c);
                    Map map2 = h.this.f135793a;
                    a aVar2 = a.this;
                    map2.remove(h.this.a(aVar2.f135795a, aVar2.f135796b));
                    h hVar = h.this;
                    hVar.a(hVar.f135794b);
                }
            }
        }

        public a(com.tencent.luggage.wxa.xd.d dVar, String str, b bVar) {
            this.f135795a = dVar;
            this.f135796b = str;
            this.f135797c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.co.a.a(new RunnableC6512a(), "stopScanServices");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements a0.d {

        /* renamed from: a, reason: collision with root package name */
        public com.tencent.luggage.wxa.xd.d f135800a;

        /* renamed from: b, reason: collision with root package name */
        public AtomicInteger f135801b = new AtomicInteger();

        /* renamed from: c, reason: collision with root package name */
        public AtomicInteger f135802c = new AtomicInteger();

        public b(com.tencent.luggage.wxa.xd.d dVar) {
            this.f135800a = dVar;
        }

        public void a(int i3) {
            this.f135801b.set(i3);
        }

        public void b(int i3) {
            this.f135802c.set(i3);
        }

        @Override // com.tencent.luggage.wxa.yi.a0.d
        public void onDiscoveryStarted(String str) {
            this.f135800a.a(this.f135801b.get(), h.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            w.d("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStarted");
        }

        @Override // com.tencent.luggage.wxa.yi.a0.d
        public void onDiscoveryStopped(String str) {
            w.d("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStopped");
            this.f135800a.a(this.f135802c.get(), h.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            com.tencent.luggage.wxa.nf.a.b(this.f135800a);
        }

        @Override // com.tencent.luggage.wxa.yi.a0.d
        public void onStartDiscoveryFailed(String str, int i3) {
            this.f135800a.a(this.f135801b.get(), h.this.makeReturnJson("fail"));
            w.d("MicroMsg.JsApiOperateLocalServicesScan", "onStartDiscoveryFailed");
        }

        @Override // com.tencent.luggage.wxa.yi.a0.d
        public void onStopDiscoveryFailed(String str, int i3) {
            this.f135800a.a(this.f135802c.get(), h.this.makeReturnJson("fail"));
            w.d("MicroMsg.JsApiOperateLocalServicesScan", "onStopDiscoveryFailed");
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements a0.c {
            public a() {
            }

            @Override // com.tencent.luggage.wxa.yi.a0.c
            public void a(a0.e eVar, int i3) {
                w.d("MicroMsg.JsApiOperateLocalServicesScan", "onResolveFailed");
                com.tencent.luggage.wxa.nf.a.a(b.this.f135800a, eVar, i3);
            }

            @Override // com.tencent.luggage.wxa.yi.a0.c
            public void a(a0.e eVar) {
                w.d("MicroMsg.JsApiOperateLocalServicesScan", "onServiceResolved");
                com.tencent.luggage.wxa.nf.a.a(b.this.f135800a, eVar);
            }
        }

        @Override // com.tencent.luggage.wxa.yi.a0.d
        public void a(a0.e eVar) {
            com.tencent.luggage.wxa.nf.a.b(this.f135800a, eVar);
        }

        @Override // com.tencent.luggage.wxa.yi.a0.d
        public void b(a0.e eVar) {
            w.d("MicroMsg.JsApiOperateLocalServicesScan", "onServiceFound");
            a0.INSTANCE.a(eVar, new a());
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString("action");
        w.d("MicroMsg.JsApiOperateLocalServicesScan", "action = " + optString);
        if (TextUtils.equals("start", optString)) {
            String optString2 = jSONObject.optString("serviceType");
            if (TextUtils.isEmpty(optString2)) {
                dVar.a(i3, makeReturnJson("fail:invalid param"));
                return;
            } else {
                a(dVar, optString2, i3);
                return;
            }
        }
        if (TextUtils.equals("stop", optString)) {
            a(dVar, i3);
        } else {
            dVar.a(i3, makeReturnJson("fail:invalid param"));
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
        synchronized (this.f135793a) {
            boolean z16 = true;
            for (b bVar : this.f135793a.values()) {
                bVar.b(i3);
                a0.INSTANCE.a(bVar);
                z16 = false;
            }
            if (z16) {
                dVar.a(i3, makeReturnJson("fail:task not found"));
            }
            a(this.f135794b);
            this.f135793a.clear();
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, String str, int i3) {
        synchronized (this.f135793a) {
            Iterator it = this.f135793a.keySet().iterator();
            while (it.hasNext()) {
                if (((String) it.next()).contains(dVar.getAppId())) {
                    dVar.a(i3, makeReturnJson("fail:scan task already exist"));
                    return;
                }
            }
            WifiManager.MulticastLock createMulticastLock = ((WifiManager) dVar.getContext().getApplicationContext().getSystemService("wifi")).createMulticastLock("MicroMsg.JsApiOperateLocalServicesScan");
            this.f135794b = createMulticastLock;
            if (createMulticastLock != null) {
                createMulticastLock.acquire();
            }
            b bVar = new b(dVar);
            bVar.a(i3);
            this.f135793a.put(a(dVar, str), bVar);
            a0.INSTANCE.a(str, bVar);
            c0.a(new a(dVar, str, bVar), 30000L);
        }
    }

    public final void a(WifiManager.MulticastLock multicastLock) {
        if (multicastLock != null) {
            try {
                if (multicastLock.isHeld()) {
                    multicastLock.release();
                }
            } catch (Exception e16) {
                w.f("MicroMsg.JsApiOperateLocalServicesScan", e16.getMessage());
            }
        }
    }

    public final String a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        return dVar.getAppId() + "#" + str;
    }
}
