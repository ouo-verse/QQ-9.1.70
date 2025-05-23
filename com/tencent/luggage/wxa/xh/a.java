package com.tencent.luggage.wxa.xh;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.luggage.wxa.a8.p;
import com.tencent.luggage.wxa.a8.x;
import com.tencent.luggage.wxa.a8.y;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.g8.a;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.lj.a;
import com.tencent.luggage.wxa.lj.j;
import com.tencent.luggage.wxa.rc.l;
import com.tencent.luggage.wxa.th.b;
import com.tencent.luggage.wxa.tk.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a implements com.tencent.luggage.wxa.g8.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f144954a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f144955b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f144956c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f144957d = false;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f144958e = false;

    /* renamed from: f, reason: collision with root package name */
    public g f144959f = null;

    /* renamed from: g, reason: collision with root package name */
    public j.b f144960g = null;

    /* renamed from: h, reason: collision with root package name */
    public e.c f144961h = null;

    /* renamed from: i, reason: collision with root package name */
    public x f144962i = null;

    /* renamed from: j, reason: collision with root package name */
    public int f144963j = -1;

    /* renamed from: k, reason: collision with root package name */
    public boolean f144964k = false;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xh.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C6909a extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f144965a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LivePusherPluginHandler f144966b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.z7.c f144967c;

        public C6909a(String str, LivePusherPluginHandler livePusherPluginHandler, com.tencent.luggage.wxa.z7.c cVar) {
            this.f144965a = str;
            this.f144966b = livePusherPluginHandler;
            this.f144967c = cVar;
        }

        public final boolean a() {
            boolean z16;
            com.tencent.luggage.wxa.z7.c cVar = this.f144967c;
            if (cVar != null && cVar.e() != null && a.this.f144959f != null && a.this.f144959f.Y() != null && a.this.f144959f.Y().getCurrentPage() != null && a.this.f144959f.Y().getCurrentPage().getCurrentPageView() != null) {
                int componentId = this.f144967c.e().getComponentId();
                int c06 = a.this.f144959f.Y().getCurrentPage().getCurrentPageView().c0();
                if (componentId == c06) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "isLivePusherPageTheCurrentPage livePusherPageId:%d, livePusherPageId:%d", Integer.valueOf(componentId), Integer.valueOf(c06));
                return z16;
            }
            w.f("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "isLivePusherPageTheCurrentPage sth npe");
            return true;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            super.onPause(dVar);
            w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "onPause mIsVoip:%b isVoipPageBackgroundRuntimeForegroundState:%b", Boolean.valueOf(a.this.f144956c), Boolean.valueOf(a.this.f144957d));
            if (a.this.f144956c && a.this.f144957d) {
                if (this.f144966b.getAdapter() == null) {
                    w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "onPause livePusherPluginHandler.getAdapter() null");
                } else if (!a()) {
                    this.f144966b.getAdapter().enterBackground(false);
                    w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "onPause enterBackground");
                }
            }
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onReconnected() {
            w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushBegin, onReconnected");
            super.onReconnected();
            if (a.this.f144958e) {
                com.tencent.luggage.wxa.de.c.f124198b.a(com.tencent.luggage.wxa.de.b.AppBrandLivePusher, true, this.f144965a);
            }
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onResume() {
            super.onResume();
            w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "onResume mIsVoip:%b isVoipPageBackgroundRuntimeForegroundState:%b", Boolean.valueOf(a.this.f144956c), Boolean.valueOf(a.this.f144957d));
            if (a.this.f144956c && a.this.f144957d) {
                if (this.f144966b.getAdapter() == null) {
                    w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "onResume livePusherPluginHandler.getAdapter() null");
                } else if (!a()) {
                    this.f144966b.getAdapter().enterForeground();
                    w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "onPause enterForeground");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements b.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.b f144969a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f144970b;

        public b(a.b bVar, String str) {
            this.f144969a = bVar;
            this.f144970b = str;
        }

        @Override // com.tencent.luggage.wxa.th.b.d
        public void onLoad(String str) {
            a.b bVar = this.f144969a;
            if (bVar != null) {
                bVar.onLoad(this.f144970b, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements b.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.b f144972a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f144973b;

        public c(a.b bVar, String str) {
            this.f144972a = bVar;
            this.f144973b = str;
        }

        @Override // com.tencent.luggage.wxa.th.b.d
        public void onLoad(String str) {
            a.b bVar = this.f144972a;
            if (bVar != null) {
                bVar.onLoad(this.f144973b, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements b.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC6237a f144975a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.z7.c f144976b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f144977c;

        public d(a.InterfaceC6237a interfaceC6237a, com.tencent.luggage.wxa.z7.c cVar, String str) {
            this.f144975a = interfaceC6237a;
            this.f144976b = cVar;
            this.f144977c = str;
        }

        @Override // com.tencent.luggage.wxa.th.b.d
        public void onLoad(String str) {
            a.InterfaceC6237a interfaceC6237a = this.f144975a;
            if (interfaceC6237a != null) {
                if (str == null) {
                    this.f144976b.a(com.tencent.luggage.wxa.af.g.f121349r);
                    this.f144975a.onLoadFailure(this.f144977c);
                } else {
                    interfaceC6237a.onLoad(this.f144977c, com.tencent.luggage.wxa.cp.x.b(str, false));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements b.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.b f144979a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f144980b;

        public e(a.b bVar, String str) {
            this.f144979a = bVar;
            this.f144980b = str;
        }

        @Override // com.tencent.luggage.wxa.th.b.d
        public void onLoad(String str) {
            a.b bVar = this.f144979a;
            if (bVar != null) {
                bVar.onLoad(this.f144980b, com.tencent.luggage.wxa.cp.x.b(str, false));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements com.tencent.luggage.wxa.de.f {

        /* renamed from: a, reason: collision with root package name */
        public boolean f144982a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f144983b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ p f144984c;

        public f(LifecycleOwner lifecycleOwner, p pVar) {
            this.f144983b = lifecycleOwner;
            this.f144984c = pVar;
        }
    }

    public final void e() {
        w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "blinkCapsuleBarOrDismiss");
        if (this.f144958e && this.f144954a) {
            d();
        } else {
            f();
        }
    }

    public final void f() {
        if (this.f144960g != null) {
            w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "dismissBlink");
            this.f144960g.c();
            this.f144960g = null;
        }
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public com.tencent.luggage.wxa.g8.c a() {
        return new com.tencent.luggage.wxa.th.c();
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public com.tencent.luggage.wxa.g8.b b() {
        return new com.tencent.luggage.wxa.xh.b();
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public void c(LivePusherPluginHandler livePusherPluginHandler, com.tencent.luggage.wxa.z7.c cVar) {
        this.f144958e = true;
        this.f144959f = com.tencent.luggage.wxa.ph.b.a(cVar);
        e();
        String key = livePusherPluginHandler.getKey();
        com.tencent.luggage.wxa.de.c.f124198b.a(com.tencent.luggage.wxa.de.b.AppBrandLivePusher, true, key);
        String appId = cVar.getAppId();
        C6909a c6909a = new C6909a(key, livePusherPluginHandler, cVar);
        this.f144961h = c6909a;
        com.tencent.luggage.wxa.ic.e.a(appId, c6909a);
        if (this.f144956c) {
            com.tencent.luggage.wxa.th.e a16 = a(cVar);
            if (a16 != null) {
                a16.a(com.tencent.luggage.wxa.ph.b.a(cVar), livePusherPluginHandler);
            } else {
                w.a("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushBegin, no state manager");
            }
        } else {
            w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushBegin, not voip mode");
        }
        x xVar = this.f144962i;
        if (xVar != null) {
            xVar.b();
            this.f144962i.a(this.f144964k);
        } else {
            this.f144963j = this.f144964k ? 2 : 3;
        }
    }

    public final void d() {
        if (this.f144960g != null) {
            w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "blinkCapsuleBar, already blink");
        } else if (this.f144959f != null) {
            w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "blinkCapsuleBar");
            this.f144960g = a.b.a(this.f144959f).a(this.f144955b ? a.c.CAMERA : a.c.VOICE);
        }
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public void a(LivePusherPluginHandler livePusherPluginHandler, com.tencent.luggage.wxa.z7.c cVar, Bundle bundle) {
        this.f144954a = bundle.getBoolean("enableMic", this.f144954a);
        this.f144955b = bundle.getBoolean("enableCamera", this.f144955b);
        boolean z16 = false;
        w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed enableMic:%b, enableCamera:%b", Boolean.valueOf(this.f144954a), Boolean.valueOf(this.f144955b));
        e();
        boolean z17 = bundle.getBoolean(V2TXJSAdapterConstants.IS_VOIP, this.f144956c);
        this.f144956c = z17;
        if (z17) {
            com.tencent.luggage.wxa.th.e a16 = a(cVar);
            g a17 = com.tencent.luggage.wxa.ph.b.a(cVar);
            if (a16 == null) {
                w.a("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
                a16 = new com.tencent.luggage.wxa.th.e(a17);
                a17.a((m) a16);
                z16 = true;
            }
            a16.b(livePusherPluginHandler);
            a16.a(com.tencent.luggage.wxa.ph.b.a(cVar), this.f144954a);
            if (z16 && this.f144958e) {
                w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, is pushing");
                a16.a(com.tencent.luggage.wxa.ph.b.a(cVar), livePusherPluginHandler);
                return;
            }
            return;
        }
        w.a("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, not voip");
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public void b(LivePusherPluginHandler livePusherPluginHandler, com.tencent.luggage.wxa.z7.c cVar, Bundle bundle) {
        this.f144954a = bundle.getBoolean("enableMic", this.f144954a);
        this.f144955b = bundle.getBoolean("enableCamera", this.f144955b);
        w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "updateForBackgroundVOIPIfNeed enableMic:%b, enableCamera:%b", Boolean.valueOf(this.f144954a), Boolean.valueOf(this.f144955b));
        e();
        com.tencent.luggage.wxa.th.e a16 = a(cVar);
        if (a16 != null) {
            a16.a(com.tencent.luggage.wxa.ph.b.a(cVar), this.f144954a);
        } else {
            w.a("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "updateForBackgroundVOIPIfNeed, no state manager");
        }
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public void b(LivePusherPluginHandler livePusherPluginHandler, com.tencent.luggage.wxa.z7.c cVar) {
        this.f144958e = false;
        e();
        com.tencent.luggage.wxa.de.c.f124198b.a(com.tencent.luggage.wxa.de.b.AppBrandLivePusher, false, livePusherPluginHandler.getKey());
        if (cVar != null) {
            com.tencent.luggage.wxa.ic.e.b(cVar.getAppId(), this.f144961h);
        }
        this.f144961h = null;
        com.tencent.luggage.wxa.th.e a16 = a(cVar);
        if (a16 != null) {
            g a17 = com.tencent.luggage.wxa.ph.b.a(cVar);
            if (a17 != null) {
                a16.b(a17, livePusherPluginHandler);
                a17.b((m) a16);
            }
        } else {
            w.a("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushEnd, no state manager");
        }
        x xVar = this.f144962i;
        if (xVar != null) {
            xVar.onStop();
        } else {
            this.f144963j = 6;
        }
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public void c() {
        w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "clearVoipPageBackgroundButNotPipState");
        this.f144957d = false;
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public void a(LivePusherPluginHandler livePusherPluginHandler, com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.th.e a16 = a(cVar);
        if (a16 != null) {
            a16.d(livePusherPluginHandler);
        } else {
            w.a("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
        }
        c();
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public boolean a(LivePusherPluginHandler livePusherPluginHandler, com.tencent.luggage.wxa.z7.c cVar, int i3) {
        boolean z16;
        boolean b16 = b(livePusherPluginHandler, cVar, i3);
        g a16 = com.tencent.luggage.wxa.ph.b.a(cVar);
        if (a16 != null) {
            if (a16.c0().b() == com.tencent.luggage.wxa.qc.b.FOREGROUND) {
                z16 = true;
                boolean z17 = (b16 || livePusherPluginHandler.amIPipPlayer() || !livePusherPluginHandler.isIsWebViewInBackground()) ? false : true;
                this.f144957d = z17;
                boolean z18 = !z17 && z16;
                w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "shouldPusherPauseWhenEnterBackground shouldNotPause:%b isRuntimeForeground:%s isIsVoipInterceptScene:%b isVoipPageBackgroundButNotPipState:%b", Boolean.valueOf(z18), Boolean.valueOf(z16), Boolean.valueOf(b16), Boolean.valueOf(this.f144957d));
                return z18;
            }
        } else {
            w.b("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "shouldPusherNotPauseWhenEnterBackground runtime null");
        }
        z16 = false;
        if (b16) {
        }
        this.f144957d = z17;
        if (z17) {
        }
        w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "shouldPusherPauseWhenEnterBackground shouldNotPause:%b isRuntimeForeground:%s isIsVoipInterceptScene:%b isVoipPageBackgroundButNotPipState:%b", Boolean.valueOf(z18), Boolean.valueOf(z16), Boolean.valueOf(b16), Boolean.valueOf(this.f144957d));
        return z18;
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public boolean b(LivePusherPluginHandler livePusherPluginHandler, com.tencent.luggage.wxa.z7.c cVar, int i3) {
        com.tencent.luggage.wxa.th.e a16 = a(cVar);
        if (a16 != null) {
            return a16.a(livePusherPluginHandler, i3);
        }
        w.a("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "shouldInterceptEnterBackground, no state manager");
        return false;
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public void b(com.tencent.luggage.wxa.z7.c cVar, a.b bVar) {
        if (cVar instanceof AppBrandInvokeContext) {
            AppBrandInvokeContext appBrandInvokeContext = (AppBrandInvokeContext) cVar;
            JSONObject a16 = appBrandInvokeContext.a();
            String optString = a16.has("url") ? a16.optString("url") : null;
            if (w0.c(optString)) {
                w.f("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operatePlayBgm, url is nil");
                cVar.a("fail:url is nil", com.tencent.luggage.wxa.af.e.f121315k);
            } else {
                com.tencent.luggage.wxa.th.b.e(appBrandInvokeContext.e(), optString, null, new e(bVar, optString));
            }
        }
    }

    public final com.tencent.luggage.wxa.th.e a(com.tencent.luggage.wxa.z7.c cVar) {
        g a16 = com.tencent.luggage.wxa.ph.b.a(cVar);
        if (a16 != null) {
            return (com.tencent.luggage.wxa.th.e) a16.c(com.tencent.luggage.wxa.th.e.class);
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public void a(com.tencent.luggage.wxa.z7.c cVar, a.b bVar) {
        if (cVar instanceof AppBrandInvokeContext) {
            AppBrandInvokeContext appBrandInvokeContext = (AppBrandInvokeContext) cVar;
            JSONObject a16 = appBrandInvokeContext.a();
            String optString = a16.has("backgroundImage") ? a16.optString("backgroundImage") : null;
            String optString2 = a16.optString("backgroundMD5");
            if (w0.c(optString)) {
                w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertBackgroundImageToLocalPath, url is null");
                bVar.onLoad(optString, "");
            } else {
                com.tencent.luggage.wxa.th.b.e(appBrandInvokeContext.e(), optString, optString2, new b(bVar, optString));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public void a(com.tencent.luggage.wxa.z7.c cVar, String str, String str2, a.b bVar) {
        if (cVar instanceof AppBrandInvokeContext) {
            AppBrandInvokeContext appBrandInvokeContext = (AppBrandInvokeContext) cVar;
            if (w0.c(str)) {
                w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertFilterImageToLocalPath, url is null");
            } else {
                com.tencent.luggage.wxa.th.b.e(appBrandInvokeContext.e(), str, str2, new c(bVar, str));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public void a(com.tencent.luggage.wxa.z7.c cVar, String str, String str2, boolean z16, a.InterfaceC6237a interfaceC6237a) {
        if (!(cVar instanceof AppBrandInvokeContext)) {
            w.f("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, invokeContext is not AppBrandInvokeContext");
            if (cVar != null) {
                cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
            }
            if (interfaceC6237a != null) {
                interfaceC6237a.onLoadFailure(str);
                return;
            }
            return;
        }
        if (w0.c(str)) {
            w.f("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, resourcePath is null");
            cVar.a("fail:resource path is empty", com.tencent.luggage.wxa.af.e.f121315k);
            if (interfaceC6237a != null) {
                interfaceC6237a.onLoadFailure(str);
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.xd.d e16 = cVar.e();
        if (e16 == null) {
            w.f("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, component is null");
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
            if (interfaceC6237a != null) {
                interfaceC6237a.onLoadFailure(str);
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.th.b.d(e16, str, z16, str2, new d(interfaceC6237a, cVar, str));
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public String a(com.tencent.luggage.wxa.z7.c cVar, Bundle bundle, LifecycleOwner lifecycleOwner, p pVar) {
        w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, status: %s", com.tencent.luggage.wxa.de.c.f124198b.a(com.tencent.luggage.wxa.de.b.AppBrandLivePusher, new f(lifecycleOwner, pVar)));
        return null;
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public void a(com.tencent.luggage.wxa.z7.c cVar, Bitmap bitmap) {
        if (cVar instanceof AppBrandInvokeContext) {
            if (bitmap != null && !bitmap.isRecycled()) {
                com.tencent.luggage.wxa.xd.d e16 = cVar.e();
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                i iVar = new i();
                if (e16.getFileSystem() != null) {
                    v allocTempFile = e16.getFileSystem().allocTempFile("liveplayer_" + System.currentTimeMillis() + ".jpg");
                    if (allocTempFile == null) {
                        w.b("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, tempFile is null");
                        a(bitmap);
                        cVar.a(com.tencent.luggage.wxa.af.g.f121343l);
                        return;
                    }
                    try {
                        com.tencent.luggage.wxa.tn.d.a(bitmap, 90, Bitmap.CompressFormat.JPEG, allocTempFile.g(), true);
                        if (e16.getFileSystem().createTempFileFrom(allocTempFile, "jpg", true, iVar) != l.OK) {
                            w.b("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save snapshot failed");
                            a(bitmap);
                            cVar.a(com.tencent.luggage.wxa.af.g.f121343l);
                            return;
                        }
                        v absoluteFile = e16.getFileSystem().getAbsoluteFile((String) iVar.f141499a);
                        w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, realPath: %s, path:%s", (absoluteFile == null || !absoluteFile.e()) ? "" : com.tencent.luggage.wxa.cp.x.b(absoluteFile.g(), false), iVar.f141499a);
                        a(bitmap);
                        HashMap hashMap = new HashMap();
                        hashMap.put("tempImagePath", iVar.f141499a);
                        hashMap.put("width", Integer.valueOf(width));
                        hashMap.put("height", Integer.valueOf(height));
                        cVar.a(com.tencent.luggage.wxa.af.e.f121305a, hashMap);
                        return;
                    } catch (IOException e17) {
                        w.b("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save bitmap exception", e17);
                        a(bitmap);
                        cVar.a(com.tencent.luggage.wxa.af.g.f121343l);
                        return;
                    }
                }
                w.b("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, file system is null");
                a(bitmap);
                cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
                return;
            }
            w.b("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, bitmap is null");
            cVar.a(com.tencent.luggage.wxa.af.g.f121341j);
        }
    }

    public final void a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        w.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "bitmap recycle " + bitmap.toString());
        bitmap.recycle();
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public void a(x xVar) {
        this.f144962i = xVar;
        if (xVar != null) {
            y.a(this.f144963j, xVar);
        }
    }

    @Override // com.tencent.luggage.wxa.g8.a
    public void a(boolean z16) {
        this.f144964k = z16;
    }
}
