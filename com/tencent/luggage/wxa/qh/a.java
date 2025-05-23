package com.tencent.luggage.wxa.qh;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.rh.b;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.l0;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.luggage.wxa.z7.c;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.k8.a {

    /* renamed from: f, reason: collision with root package name */
    public static f f138795f;

    /* renamed from: a, reason: collision with root package name */
    public Surface f138796a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.re.f f138797b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f138798c;

    /* renamed from: d, reason: collision with root package name */
    public List f138799d = new Vector();

    /* renamed from: e, reason: collision with root package name */
    public int f138800e;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.qh.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6645a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f138801a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f138802b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.z7.c f138803c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f138804d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f138805e;

        public RunnableC6645a(com.tencent.luggage.wxa.xd.d dVar, o oVar, com.tencent.luggage.wxa.z7.c cVar, JSONObject jSONObject, int i3) {
            this.f138801a = dVar;
            this.f138802b = oVar;
            this.f138803c = cVar;
            this.f138804d = jSONObject;
            this.f138805e = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!l0.a()) {
                this.f138801a.a(this);
                return;
            }
            a.this.f138798c = this.f138801a;
            o oVar = this.f138802b;
            if (oVar instanceof com.tencent.luggage.wxa.rh.b) {
                w.d("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "insert xweb camera");
                a.this.a(this.f138801a, this.f138803c, this.f138804d, this.f138802b, this.f138805e);
            } else if (oVar instanceof com.tencent.luggage.wxa.rh.d) {
                w.d("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "update xweb camera");
                a.this.b(this.f138801a, this.f138804d, this.f138802b, this.f138805e);
            } else if (oVar instanceof com.tencent.luggage.wxa.rh.c) {
                w.d("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "remove xweb camera");
                a.this.a(this.f138801a, this.f138804d, this.f138802b, this.f138805e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f138807a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f138808b;

        public b(o oVar, Runnable runnable) {
            this.f138807a = oVar;
            this.f138808b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f138796a == null) {
                o oVar = this.f138807a;
                if ((oVar instanceof com.tencent.luggage.wxa.rh.b) || (oVar instanceof com.tencent.luggage.wxa.rh.d)) {
                    a.this.f138799d.add(this.f138808b);
                    return;
                }
            }
            this.f138808b.run();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements b.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f138810a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f138811b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f138812c;

        public c(com.tencent.luggage.wxa.xd.d dVar, int i3, o oVar) {
            this.f138810a = dVar;
            this.f138811b = i3;
            this.f138812c = oVar;
        }

        @Override // com.tencent.luggage.wxa.rh.b.e
        public void a() {
            this.f138810a.a(this.f138811b, this.f138812c.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f138814a;

        public d(com.tencent.luggage.wxa.xd.f fVar) {
            this.f138814a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f138814a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements c.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.f f138816a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f138817b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.z7.c f138818c;

        public e(com.tencent.luggage.wxa.xd.f fVar, com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.z7.c cVar) {
            this.f138816a = fVar;
            this.f138817b = dVar;
            this.f138818c = cVar;
        }

        @Override // com.tencent.luggage.wxa.z7.c.a
        public void onBackground(int i3) {
            ViewGroup viewGroup;
            com.tencent.luggage.wxa.xd.f fVar = (com.tencent.luggage.wxa.xd.f) this.f138817b;
            View view = a.this.f138797b.getView();
            f.a customViewContainer = fVar.getCustomViewContainer();
            if (customViewContainer != null) {
                viewGroup = customViewContainer.a();
            } else {
                viewGroup = null;
            }
            if (viewGroup == null) {
                w.b("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "onBackground(%d), removeCameraNativeView failed null topLevelContainer, appId:%s", fVar.getAppId());
            } else {
                viewGroup.removeView(view);
            }
        }

        @Override // com.tencent.luggage.wxa.z7.c.a
        public void onDestroy() {
            this.f138818c.d();
            a.this.f138797b = null;
        }

        @Override // com.tencent.luggage.wxa.z7.c.a
        public void onForeground() {
            a.this.a(this.f138816a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface f {
        com.tencent.luggage.wxa.re.e a(Context context);
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public String handleJsApi(com.tencent.luggage.wxa.z7.c cVar) {
        if (cVar instanceof AppBrandInvokeContext) {
            AppBrandInvokeContext appBrandInvokeContext = (AppBrandInvokeContext) cVar;
            com.tencent.luggage.wxa.xd.d e16 = appBrandInvokeContext.e();
            o h16 = appBrandInvokeContext.h();
            JSONObject g16 = appBrandInvokeContext.g();
            int f16 = appBrandInvokeContext.f();
            w.d("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", key(), h16.getName(), g16.toString());
            e16.a(new b(h16, new RunnableC6645a(e16, h16, cVar, g16, f16)));
            return null;
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginDestroy() {
        super.handlePluginDestroy();
        release();
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public void handlePluginReady(SurfaceTexture surfaceTexture) {
        handlePluginReadyForGPUProcess(new Surface(surfaceTexture));
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginReadyForGPUProcess(Surface surface) {
        super.handlePluginReadyForGPUProcess(surface);
        this.f138796a = surface;
        w.d("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "preTask size: %d", Integer.valueOf(this.f138799d.size()));
        Iterator it = this.f138799d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginTouch(MotionEvent motionEvent) {
        com.tencent.luggage.wxa.re.f fVar = this.f138797b;
        if (fVar != null) {
            fVar.handlePluginTouch(motionEvent);
        }
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public boolean isPluginReady(com.tencent.luggage.wxa.z7.c cVar) {
        return true;
    }

    public final void release() {
        Surface surface = this.f138796a;
        if (surface != null) {
            surface.release();
            this.f138796a = null;
        }
        com.tencent.luggage.wxa.re.f fVar = this.f138797b;
        if (fVar == null) {
            w.f("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "the camera view is null");
            return;
        }
        com.tencent.luggage.wxa.xd.d dVar = this.f138798c;
        if (dVar instanceof com.tencent.luggage.wxa.xd.f) {
            com.tencent.luggage.wxa.xd.f fVar2 = (com.tencent.luggage.wxa.xd.f) dVar;
            fVar2.a((g.d) fVar);
            fVar2.b((g.b) this.f138797b);
            fVar2.b((g.c) this.f138797b);
        }
        if (l0.a()) {
            this.f138797b.release();
        } else {
            c0.a(new Runnable() { // from class: y31.a
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.luggage.wxa.qh.a.this.a();
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:9:0x0019, B:11:0x0024, B:15:0x002f), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:9:0x0019, B:11:0x0024, B:15:0x002f), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void b(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, o oVar, int i3) {
        Surface surface;
        Surface surface2 = this.f138796a;
        if (surface2 != null) {
            int hashCode = surface2.hashCode();
            int i16 = this.f138800e;
            if (hashCode != i16 && i16 != 0) {
                surface = this.f138796a;
                this.f138800e = surface.hashCode();
                if (!((com.tencent.luggage.wxa.rh.d) oVar).a(dVar, surface, this.f138797b, jSONObject)) {
                    dVar.a(i3, oVar.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                } else {
                    w.b("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "update fail");
                    dVar.a(i3, oVar.makeReturnJson("fail:internal error"));
                }
            }
        }
        surface = null;
        if (!((com.tencent.luggage.wxa.rh.d) oVar).a(dVar, surface, this.f138797b, jSONObject)) {
        }
    }

    public static void a(f fVar) {
        f138795f = fVar;
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.z7.c cVar, JSONObject jSONObject, o oVar, int i3) {
        if (this.f138796a == null) {
            w.b("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "insert mSurfaceTexture is null, err");
            return;
        }
        com.tencent.luggage.wxa.re.f fVar = (com.tencent.luggage.wxa.re.f) f138795f.a(dVar.getContext());
        this.f138797b = fVar;
        if (dVar instanceof com.tencent.luggage.wxa.xd.f) {
            com.tencent.luggage.wxa.xd.f fVar2 = (com.tencent.luggage.wxa.xd.f) dVar;
            com.tencent.luggage.wxa.rh.b bVar = (com.tencent.luggage.wxa.rh.b) oVar;
            bVar.a(fVar2, fVar, jSONObject, this.f138796a);
            Surface surface = this.f138796a;
            if (surface != null) {
                this.f138800e = surface.hashCode();
            }
            bVar.a(fVar2, (com.tencent.luggage.wxa.re.e) this.f138797b, (b.e) new c(dVar, i3, oVar));
            dVar.a(new d(fVar2));
            cVar.a(new e(fVar2, dVar, cVar));
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, o oVar, int i3) {
        if (((com.tencent.luggage.wxa.rh.c) oVar).a(dVar, this.f138797b, jSONObject)) {
            dVar.a(i3, oVar.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        } else {
            w.b("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "remove fail");
            dVar.a(i3, oVar.makeReturnJson("fail:internal error"));
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.f fVar) {
        View view = this.f138797b.getView();
        f.a customViewContainer = fVar.getCustomViewContainer();
        ViewGroup a16 = customViewContainer != null ? customViewContainer.a() : null;
        if (a16 == null) {
            w.b("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "addCameraNativeView failed null topLevelContainer, appId:%s", fVar.getAppId());
            return;
        }
        view.setId(view.hashCode());
        if (a16.findViewById(view.getId()) == null) {
            a16.addView(view, new ViewGroup.LayoutParams(1, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.f138797b.release();
    }
}
