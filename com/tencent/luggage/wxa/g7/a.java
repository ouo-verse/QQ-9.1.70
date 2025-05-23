package com.tencent.luggage.wxa.g7;

import com.tencent.luggage.wxa.q5.a;
import com.tencent.luggage.wxa.q5.b;
import com.tencent.luggage.wxa.s6.h;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.updater.IXWebBroadcastListener;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.q5.b {

    /* renamed from: i, reason: collision with root package name */
    public static final a f126576i = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.g7.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6233a implements b.f {

        /* renamed from: a, reason: collision with root package name */
        public static final C6233a f126577a = new C6233a();

        @Override // com.tencent.luggage.wxa.q5.b.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.h7.b create() {
            return com.tencent.luggage.wxa.h7.b.INSTANCE.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements b.f {

        /* renamed from: a, reason: collision with root package name */
        public static final b f126578a = new b();

        @Override // com.tencent.luggage.wxa.q5.b.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h create() {
            return h.INSTANCE.a();
        }
    }

    public a() {
        super(C6233a.f126577a, b.f126578a);
    }

    @Override // com.tencent.luggage.wxa.q5.b
    public void d() {
        super.d();
        w.d("Luggage.WxaAppProcessSharedPreloader", "done(), webview type:" + WebView.getCurrentModuleWebCoreType());
        if (XWebSdk.isSysWebView()) {
            XWebSdk.registerBroadcastListener(z.c(), new c());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements IXWebBroadcastListener {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.g7.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6234a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public static final RunnableC6234a f126579a = new RunnableC6234a();

            @Override // java.lang.Runnable
            public final void run() {
                if (com.tencent.luggage.wxa.p6.h.f137365a.b() && com.tencent.luggage.wxa.q5.e.f()) {
                    w.d("Luggage.WxaAppProcessSharedPreloader", "xweb onUpdateFinished, force preload when no active runtimes");
                    a.f126576i.a((a.InterfaceC6617a) null, true, true);
                }
            }
        }

        @Override // com.tencent.xweb.updater.IXWebBroadcastListener
        public void onUpdateFinished(int i3, int i16) {
            if (i3 == 0) {
                com.tencent.luggage.wxa.zp.h.f146825d.c(RunnableC6234a.f126579a, 0L);
            }
        }

        @Override // com.tencent.xweb.updater.IXWebBroadcastListener
        public void onMainCfgUpdated() {
        }

        @Override // com.tencent.xweb.updater.IXWebBroadcastListener
        public void onPluginCfgUpdated() {
        }

        @Override // com.tencent.xweb.updater.IXWebBroadcastListener
        public void onUpdateProgressed(int i3) {
        }

        @Override // com.tencent.xweb.updater.IXWebBroadcastListener
        public void onUpdateStart(int i3) {
        }
    }
}
