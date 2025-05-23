package com.tencent.mm.plugin.appbrand.jsapi.xwebplugin.map;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.s0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class AppBrandMapPluginHandler extends com.tencent.luggage.wxa.k8.a {

    /* renamed from: a, reason: collision with root package name */
    public b0 f152192a = new b0(String.format(Locale.ENGLISH, "MapThread_%d", Integer.valueOf(getId())));

    /* renamed from: b, reason: collision with root package name */
    public b0 f152193b = new b0(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public volatile Surface f152194c;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBrandMapPluginHandler.a(AppBrandMapPluginHandler.this);
            w.b("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "mSameLayerMapView is null, may be not insert");
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f152196a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f152197b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f152198c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f152199d;

        /* loaded from: classes9.dex */
        public class a extends s0 {
            public a() {
            }

            @Override // com.tencent.luggage.wxa.tn.s0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Boolean a() {
                b bVar = b.this;
                AppBrandMapPluginHandler appBrandMapPluginHandler = AppBrandMapPluginHandler.this;
                ((com.tencent.luggage.wxa.zh.b) bVar.f152196a).a(bVar.f152197b, bVar.f152198c, appBrandMapPluginHandler.f152194c);
                AppBrandMapPluginHandler.a(appBrandMapPluginHandler, null);
                return Boolean.FALSE;
            }
        }

        public b(o oVar, com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
            this.f152196a = oVar;
            this.f152197b = dVar;
            this.f152198c = jSONObject;
            this.f152199d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            o oVar = this.f152196a;
            if (oVar instanceof com.tencent.luggage.wxa.zh.b) {
                AppBrandMapPluginHandler.a(AppBrandMapPluginHandler.this);
                com.tencent.luggage.wxa.hf.c.a(9);
                new a().a(AppBrandMapPluginHandler.this.f152193b);
                AppBrandMapPluginHandler.this.a(this.f152197b, this.f152198c, this.f152196a, this.f152199d);
                return;
            }
            if (oVar instanceof com.tencent.luggage.wxa.zh.d) {
                w.d("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy update");
                com.tencent.luggage.wxa.hf.c.a(12);
                AppBrandMapPluginHandler.this.c(this.f152197b, this.f152198c, this.f152196a, this.f152199d);
            } else if (oVar instanceof com.tencent.luggage.wxa.zh.c) {
                com.tencent.luggage.wxa.hf.c.a(15);
                AppBrandMapPluginHandler.this.b(this.f152197b, this.f152198c, this.f152196a, this.f152199d);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements g.b {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.xd.g.b
        public void onBackground() {
            w.d("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onBackground");
            AppBrandMapPluginHandler.a(AppBrandMapPluginHandler.this);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements g.d {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.xd.g.d
        public void onForeground() {
            w.d("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onForeground");
            AppBrandMapPluginHandler.a(AppBrandMapPluginHandler.this);
        }
    }

    /* loaded from: classes9.dex */
    public class e implements g.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f152204a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f152205b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f152206c;

        public e(f fVar, com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
            this.f152204a = fVar;
            this.f152205b = dVar;
            this.f152206c = jSONObject;
        }

        @Override // com.tencent.luggage.wxa.xd.g.c
        public void onDestroy() {
            w.d("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            this.f152204a.b(this);
            AppBrandMapPluginHandler.a(AppBrandMapPluginHandler.this, null);
            com.tencent.luggage.wxa.hf.e.a(this.f152205b.getAppId(), com.tencent.luggage.wxa.hf.d.a(this.f152205b, this.f152206c));
            AppBrandMapPluginHandler.this.release();
        }
    }

    public static /* synthetic */ com.tencent.luggage.wxa.hf.a a(AppBrandMapPluginHandler appBrandMapPluginHandler) {
        appBrandMapPluginHandler.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.f152192a.c();
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public String handleJsApi(com.tencent.luggage.wxa.z7.c cVar) {
        if (cVar instanceof AppBrandInvokeContext) {
            AppBrandInvokeContext appBrandInvokeContext = (AppBrandInvokeContext) cVar;
            com.tencent.luggage.wxa.xd.d e16 = appBrandInvokeContext.e();
            o h16 = appBrandInvokeContext.h();
            JSONObject g16 = appBrandInvokeContext.g();
            int f16 = appBrandInvokeContext.f();
            w.d("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", key(), h16.getName(), g16.toString());
            a(new b(h16, e16, g16, f16));
            return null;
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginDestroy() {
        w.d("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "handlePluginDestroy %d", Integer.valueOf(getId()));
        super.handlePluginDestroy();
        a();
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public void handlePluginReady(SurfaceTexture surfaceTexture) {
        handlePluginReadyForGPUProcess(new Surface(surfaceTexture));
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginReadyForGPUProcess(Surface surface) {
        super.handlePluginReadyForGPUProcess(surface);
        w.d("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "handlePluginReady %d", Integer.valueOf(getId()));
        this.f152194c = surface;
        d();
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public boolean isPluginReady(com.tencent.luggage.wxa.z7.c cVar) {
        return true;
    }

    public static /* synthetic */ com.tencent.luggage.wxa.hf.a a(AppBrandMapPluginHandler appBrandMapPluginHandler, com.tencent.luggage.wxa.hf.a aVar) {
        appBrandMapPluginHandler.getClass();
        return aVar;
    }

    private void d() {
        this.f152192a.a((Runnable) new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, o oVar, int i3) {
        if (((com.tencent.luggage.wxa.zh.c) oVar).a(dVar, jSONObject)) {
            dVar.a(i3, oVar.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            com.tencent.luggage.wxa.hf.c.a(16);
        } else {
            w.b("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "remove fail");
            com.tencent.luggage.wxa.hf.c.a(17);
            dVar.a(i3, oVar.makeReturnJson("fail:internal error"));
        }
        release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, o oVar, int i3) {
        w.b("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "update fail");
        com.tencent.luggage.wxa.hf.c.a(14);
        dVar.a(i3, oVar.makeReturnJson("fail:internal error"));
    }

    private void a(Runnable runnable) {
        if (this.f152192a.a() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f152192a.a(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, o oVar, int i3) {
        dVar.a(i3, oVar.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        com.tencent.luggage.wxa.hf.c.a(10);
        if (dVar instanceof f) {
            f fVar = (f) dVar;
            fVar.a(new c());
            fVar.b(new d());
            fVar.a(new e(fVar, dVar, jSONObject));
        }
    }

    private void a() {
        if (this.f152194c != null) {
            this.f152194c.release();
            this.f152194c = null;
        }
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginTouch(MotionEvent motionEvent) {
    }
}
