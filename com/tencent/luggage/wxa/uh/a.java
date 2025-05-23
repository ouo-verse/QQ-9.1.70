package com.tencent.luggage.wxa.uh;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.luggage.wxa.a8.p;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.de.f;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.th.e;
import com.tencent.luggage.wxa.tk.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements com.tencent.luggage.wxa.e8.a {

    /* renamed from: a, reason: collision with root package name */
    public LivePlayerPluginHandler f142383a;

    /* renamed from: b, reason: collision with root package name */
    public AppBrandInvokeContext f142384b;

    /* renamed from: c, reason: collision with root package name */
    public String f142385c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f142386d = false;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f142387e = false;

    /* renamed from: f, reason: collision with root package name */
    public c.InterfaceC6640c f142388f = new d();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.uh.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6800a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f142389a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f142390b;

        public RunnableC6800a(v vVar, int i3) {
            this.f142389a = vVar;
            this.f142390b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f142389a.isRunning() && this.f142389a.D0() != null) {
                com.tencent.luggage.wxa.wj.d fullscreenImpl = this.f142389a.D0().getFullscreenImpl();
                View wrapperView = this.f142389a.D0().getWrapperView();
                if (fullscreenImpl != null && wrapperView != null) {
                    fullscreenImpl.a(wrapperView, this.f142390b);
                    w.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, target orientation:%s", Integer.valueOf(this.f142390b));
                    return;
                } else {
                    w.b("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", fullscreenImpl, wrapperView);
                    return;
                }
            }
            w.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, invalid state");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f142392a;

        public b(v vVar) {
            this.f142392a = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f142392a.isRunning() && this.f142392a.D0() != null) {
                com.tencent.luggage.wxa.wj.d fullscreenImpl = this.f142392a.D0().getFullscreenImpl();
                if (fullscreenImpl != null) {
                    fullscreenImpl.c();
                    w.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen");
                    return;
                } else {
                    w.b("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, state error");
                    return;
                }
            }
            w.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, invalid state");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements f {

        /* renamed from: a, reason: collision with root package name */
        public boolean f142394a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f142395b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ p f142396c;

        public c(LifecycleOwner lifecycleOwner, p pVar) {
            this.f142395b = lifecycleOwner;
            this.f142396c = pVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements c.InterfaceC6640c {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
        public void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
            if (str.equalsIgnoreCase(a.this.f142385c)) {
                if (bVar == com.tencent.luggage.wxa.qc.b.BACKGROUND) {
                    if (a.this.f142383a != null) {
                        a.this.f142383a.onRuntimeEnterBackground(com.tencent.luggage.wxa.ph.b.a(str));
                    }
                } else if (bVar == com.tencent.luggage.wxa.qc.b.FOREGROUND && a.this.f142383a != null) {
                    a.this.f142383a.onRuntimeEnterForeground();
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.e8.a
    public boolean c(com.tencent.luggage.wxa.z7.c cVar) {
        v J;
        if (!(cVar instanceof AppBrandInvokeContext)) {
            return false;
        }
        com.tencent.luggage.wxa.xd.d e16 = ((AppBrandInvokeContext) cVar).e();
        if (e16 instanceof v) {
            J = (v) e16;
        } else {
            J = e16 instanceof l ? ((l) e16).J() : null;
        }
        if (J == null) {
            w.f("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, page view is null");
            return false;
        }
        J.a(new b(J));
        return true;
    }

    @Override // com.tencent.luggage.wxa.e8.a
    public void d(com.tencent.luggage.wxa.z7.c cVar) {
        g a16 = com.tencent.luggage.wxa.ph.b.a(cVar);
        if (a16 != null) {
            a16.c0().b(this.f142388f);
            b(a16);
            a(a16);
        }
        this.f142387e = true;
    }

    public final e e(com.tencent.luggage.wxa.z7.c cVar) {
        g a16 = com.tencent.luggage.wxa.ph.b.a(cVar);
        if (a16 != null) {
            return (e) a16.c(e.class);
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.e8.a
    public com.tencent.luggage.wxa.e8.c a() {
        return new com.tencent.luggage.wxa.th.c();
    }

    @Override // com.tencent.luggage.wxa.e8.a
    public com.tencent.luggage.wxa.e8.b b() {
        return new com.tencent.luggage.wxa.uh.b();
    }

    @Override // com.tencent.luggage.wxa.e8.a
    public void a(LivePlayerPluginHandler livePlayerPluginHandler) {
        this.f142383a = livePlayerPluginHandler;
    }

    @Override // com.tencent.luggage.wxa.e8.a
    public boolean b(com.tencent.luggage.wxa.z7.c cVar) {
        v J;
        int i3 = 0;
        if (!(cVar instanceof AppBrandInvokeContext)) {
            return false;
        }
        JSONObject a16 = cVar.a();
        com.tencent.luggage.wxa.xd.d e16 = ((AppBrandInvokeContext) cVar).e();
        if (e16 instanceof v) {
            J = (v) e16;
        } else {
            J = e16 instanceof l ? ((l) e16).J() : null;
        }
        if (J == null) {
            w.f("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, page view is null");
            return false;
        }
        if (a16 != null && a16.has("data")) {
            JSONArray optJSONArray = a16.optJSONArray("data");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                int optInt = optJSONArray.optInt(0, 0);
                if (optInt == -90) {
                    i3 = -90;
                } else if (optInt != 0) {
                    i3 = 90;
                }
                J.a(new RunnableC6800a(J, i3));
                return true;
            }
            w.f("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, data array is null");
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.e8.a
    public void a(com.tencent.luggage.wxa.z7.c cVar) {
        if (cVar instanceof AppBrandInvokeContext) {
            this.f142384b = (AppBrandInvokeContext) cVar;
        }
    }

    @Override // com.tencent.luggage.wxa.e8.a
    public boolean a(LivePlayerPluginHandler livePlayerPluginHandler, com.tencent.luggage.wxa.z7.c cVar, int i3) {
        e e16 = e(cVar);
        if (e16 != null) {
            return e16.a(livePlayerPluginHandler, i3);
        }
        w.a("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "shouldInterceptEnterBackground, no state manager");
        return false;
    }

    public final void d() {
        AppBrandInvokeContext appBrandInvokeContext;
        w.a("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart");
        if (this.f142386d) {
            w.f("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, is voip mode");
            return;
        }
        if (this.f142383a != null && (appBrandInvokeContext = this.f142384b) != null) {
            com.tencent.luggage.wxa.ph.a a16 = com.tencent.luggage.wxa.a8.e.a(appBrandInvokeContext);
            if (a16 == null) {
                w.f("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
                return;
            } else {
                a16.d(this.f142383a);
                return;
            }
        }
        w.f("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
    }

    @Override // com.tencent.luggage.wxa.e8.a
    public void a(com.tencent.luggage.wxa.z7.c cVar, Bitmap bitmap) {
        if (cVar instanceof AppBrandInvokeContext) {
            if (bitmap != null && !bitmap.isRecycled()) {
                com.tencent.luggage.wxa.xd.d e16 = cVar.e();
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                i iVar = new i();
                if (e16.getFileSystem() != null) {
                    com.tencent.luggage.wxa.cp.v allocTempFile = e16.getFileSystem().allocTempFile("liveplayer_" + System.currentTimeMillis() + ".jpg");
                    if (allocTempFile == null) {
                        w.b("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, tempFile is null");
                        a(bitmap);
                        cVar.a(com.tencent.luggage.wxa.af.g.f121343l);
                        return;
                    }
                    try {
                        com.tencent.luggage.wxa.tn.d.a(bitmap, 90, Bitmap.CompressFormat.JPEG, allocTempFile.g(), true);
                        if (e16.getFileSystem().createTempFileFrom(allocTempFile, "jpg", true, iVar) != com.tencent.luggage.wxa.rc.l.OK) {
                            w.b("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save snapshot failed");
                            a(bitmap);
                            cVar.a(com.tencent.luggage.wxa.af.g.f121343l);
                            return;
                        }
                        com.tencent.luggage.wxa.cp.v absoluteFile = e16.getFileSystem().getAbsoluteFile((String) iVar.f141499a);
                        w.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, realPath: %s, path:%s", (absoluteFile == null || !absoluteFile.e()) ? "" : x.b(absoluteFile.g(), false), iVar.f141499a);
                        a(bitmap);
                        HashMap hashMap = new HashMap();
                        hashMap.put("tempImagePath", iVar.f141499a);
                        hashMap.put("width", Integer.valueOf(width));
                        hashMap.put("height", Integer.valueOf(height));
                        cVar.a(com.tencent.luggage.wxa.af.e.f121305a, hashMap);
                        return;
                    } catch (IOException e17) {
                        w.b("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save bitmap exception", e17);
                        a(bitmap);
                        cVar.a(com.tencent.luggage.wxa.af.g.f121343l);
                        return;
                    }
                }
                w.b("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, file system is null");
                a(bitmap);
                cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
                return;
            }
            w.b("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, bitmap is null");
            cVar.a(com.tencent.luggage.wxa.af.g.f121341j);
        }
    }

    public final void c() {
        AppBrandInvokeContext appBrandInvokeContext;
        w.a("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop");
        if (this.f142386d) {
            w.f("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, is voip mode");
            return;
        }
        if (this.f142383a != null && (appBrandInvokeContext = this.f142384b) != null) {
            com.tencent.luggage.wxa.ph.a a16 = com.tencent.luggage.wxa.a8.e.a(appBrandInvokeContext);
            if (a16 == null) {
                w.f("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
                return;
            } else {
                a16.b(this.f142383a, true);
                return;
            }
        }
        w.f("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
    }

    public void b(g gVar) {
        if (gVar != null) {
            e eVar = (e) gVar.c(e.class);
            if (eVar != null) {
                eVar.c(this.f142383a);
            } else {
                w.a("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
            }
        }
    }

    @Override // com.tencent.luggage.wxa.e8.a
    public void a(com.tencent.luggage.wxa.z7.c cVar, Bundle bundle) {
        g a16 = com.tencent.luggage.wxa.ph.b.a(cVar);
        if (a16 != null) {
            this.f142385c = a16.getAppId();
            a16.c0().a(this.f142388f);
            a(a16, bundle);
        }
    }

    public void a(g gVar, Bundle bundle) {
        boolean z16 = bundle.getBoolean(V2TXJSAdapterConstants.IS_VOIP, this.f142386d);
        this.f142386d = z16;
        if (!z16) {
            w.a("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, not voip mode");
            return;
        }
        if (gVar != null) {
            e eVar = (e) gVar.c(e.class);
            if (eVar == null) {
                w.a("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
                e eVar2 = new e(gVar);
                gVar.a((m) eVar2);
                eVar2.a(this.f142383a);
                return;
            }
            eVar.a(this.f142383a);
        }
    }

    @Override // com.tencent.luggage.wxa.e8.a
    public void a(int i3, int i16, Bundle bundle) {
        w.a("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, errCode: " + i16);
        if (this.f142387e) {
            w.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, released");
            return;
        }
        if (i16 != -2301) {
            if (i16 == 2004) {
                d();
                return;
            } else if (i16 != 2006) {
                return;
            }
        }
        c();
    }

    @Override // com.tencent.luggage.wxa.e8.a
    public String a(LifecycleOwner lifecycleOwner, p pVar) {
        w.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "checkCanInsertLivePlayer, status: %s", com.tencent.luggage.wxa.de.c.f124198b.a(com.tencent.luggage.wxa.de.b.AppBrandLivePlayer, new c(lifecycleOwner, pVar)));
        return null;
    }

    public final void a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        w.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "bitmap recycle " + bitmap.toString());
        bitmap.recycle();
    }

    public final void a(g gVar) {
        w.a("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease");
        if (this.f142386d) {
            w.f("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, is voip mode");
            return;
        }
        if (this.f142383a == null) {
            w.f("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
            return;
        }
        com.tencent.luggage.wxa.ph.a aVar = (com.tencent.luggage.wxa.ph.a) gVar.c(com.tencent.luggage.wxa.ph.a.class);
        if (aVar == null) {
            w.f("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
        } else {
            aVar.e(this.f142383a);
        }
    }
}
