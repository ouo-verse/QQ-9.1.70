package com.tencent.luggage.wxa.ai;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.mg.o;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.zg.j;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements com.tencent.luggage.wxa.j8.b {

    /* renamed from: f, reason: collision with root package name */
    public static final String f121464f = "MicroMsg.SameLayer.AppBrandVideoCustomHandler";

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private com.tencent.luggage.wxa.wj.b f121465a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.luggage.wxa.i8.e f121466b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    protected final com.tencent.luggage.wxa.di.a f121467c;

    /* renamed from: d, reason: collision with root package name */
    private String f121468d;

    /* renamed from: e, reason: collision with root package name */
    private c.InterfaceC6640c f121469e = new d();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f121470a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f121471b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f121472c;

        public a(v vVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f121470a = vVar;
            this.f121471b = dVar;
            this.f121472c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f121470a.isRunning() && this.f121470a.D0() != null) {
                c.this.a(this.f121471b);
                com.tencent.luggage.wxa.wj.d fullscreenImpl = this.f121470a.D0().getFullscreenImpl();
                View wrapperView = this.f121470a.D0().getWrapperView();
                if (fullscreenImpl != null && wrapperView != null) {
                    fullscreenImpl.a(wrapperView, this.f121472c);
                    if (c.this.f121465a != null) {
                        fullscreenImpl.a(c.this.f121465a);
                    }
                    w.d(c.f121464f, "requestFullscreen, target orientation:%s", Integer.valueOf(this.f121472c));
                    return;
                }
                w.b(c.f121464f, "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", fullscreenImpl, wrapperView);
                return;
            }
            w.d(c.f121464f, "requestFullscreen, invalid state");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f121474a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f121475b;

        public b(v vVar, com.tencent.luggage.wxa.xd.d dVar) {
            this.f121474a = vVar;
            this.f121475b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f121474a.isRunning() && this.f121474a.D0() != null) {
                com.tencent.luggage.wxa.wj.d fullscreenImpl = this.f121474a.D0().getFullscreenImpl();
                if (fullscreenImpl != null) {
                    c.this.b(this.f121475b);
                    fullscreenImpl.c();
                    w.d(c.f121464f, "exitFullscreen");
                    return;
                }
                w.b(c.f121464f, "exitFullscreen, state error");
                return;
            }
            w.d(c.f121464f, "exitFullscreen, invalid state");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ai.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6015c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f121477a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f121478b;

        public RunnableC6015c(Activity activity, float f16) {
            this.f121477a = activity;
            this.f121478b = f16;
        }

        @Override // java.lang.Runnable
        public void run() {
            WindowManager.LayoutParams attributes = this.f121477a.getWindow().getAttributes();
            float f16 = this.f121478b;
            if (f16 < 0.01f) {
                f16 = 0.01f;
            }
            attributes.screenBrightness = f16;
            this.f121477a.getWindow().setAttributes(attributes);
            w.h(c.f121464f, "setScreenBrightness, brightness:%s", Float.valueOf(attributes.screenBrightness));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements c.InterfaceC6640c {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
        public void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
            if (str.equalsIgnoreCase(c.this.f121468d)) {
                w.d(c.f121464f, "onRunningStateChanged, state: " + bVar);
                if (bVar == com.tencent.luggage.wxa.qc.b.BACKGROUND) {
                    if (c.this.f121466b != null) {
                        c.this.f121466b.B();
                    }
                } else if (bVar == com.tencent.luggage.wxa.qc.b.FOREGROUND && c.this.f121466b != null) {
                    c.this.f121466b.onRuntimeEnterForeground();
                }
            }
        }
    }

    public c() {
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.bi.c.class));
        this.f121467c = f();
    }

    private com.tencent.luggage.wxa.j8.e g() {
        com.tencent.luggage.wxa.i8.e eVar = this.f121466b;
        if (eVar != null) {
            return eVar.r();
        }
        return null;
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar) {
    }

    public void b(com.tencent.luggage.wxa.xd.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public com.tencent.luggage.wxa.j8.d d() {
        return new e();
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public com.tencent.luggage.wxa.j8.f e() {
        return new g();
    }

    @NonNull
    public com.tencent.luggage.wxa.di.a f() {
        return new com.tencent.luggage.wxa.di.a();
    }

    public boolean a(com.tencent.luggage.wxa.xg.g gVar) {
        return true;
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public com.tencent.luggage.wxa.j8.c c() {
        return new com.tencent.luggage.wxa.ai.d();
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public void d(com.tencent.luggage.wxa.z7.c cVar, com.tencent.luggage.wxa.xg.g gVar) {
        this.f121467c.a(g(), cVar, gVar);
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public boolean e(com.tencent.luggage.wxa.z7.c cVar) {
        v J;
        if (!(cVar instanceof AppBrandInvokeContext)) {
            return false;
        }
        JSONObject a16 = cVar.a();
        com.tencent.luggage.wxa.xd.d e16 = ((AppBrandInvokeContext) cVar).e();
        if (e16 instanceof v) {
            J = (v) e16;
        } else {
            J = e16 instanceof com.tencent.luggage.wxa.ic.l ? ((com.tencent.luggage.wxa.ic.l) e16).J() : null;
        }
        if (J == null) {
            w.f(f121464f, "setScreenBrightness, page view is null");
            return false;
        }
        if (a16 != null && a16.has("data")) {
            JSONArray optJSONArray = a16.optJSONArray("data");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                float optDouble = (float) optJSONArray.optDouble(0, -1.0d);
                if (!Float.isNaN(optDouble) && optDouble >= 0.0f && optDouble <= 1.0f && (J.getContext() instanceof Activity)) {
                    c0.a(new RunnableC6015c((Activity) J.getContext(), optDouble));
                    return true;
                }
            } else {
                w.f(f121464f, "setScreenBrightness, data array is null");
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public void f(com.tencent.luggage.wxa.z7.c cVar, com.tencent.luggage.wxa.xg.g gVar) {
        this.f121467c.d(g(), cVar, gVar);
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public com.tencent.luggage.wxa.j8.e b() {
        return new f();
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public boolean c(com.tencent.luggage.wxa.z7.c cVar) {
        v J;
        if (!(cVar instanceof AppBrandInvokeContext)) {
            return false;
        }
        com.tencent.luggage.wxa.xd.d e16 = ((AppBrandInvokeContext) cVar).e();
        if (e16 instanceof v) {
            J = (v) e16;
        } else {
            J = e16 instanceof com.tencent.luggage.wxa.ic.l ? ((com.tencent.luggage.wxa.ic.l) e16).J() : null;
        }
        if (J == null) {
            w.f(f121464f, "exitFullscreen, page view is null");
            return false;
        }
        J.a(new b(J, e16));
        return true;
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public void d(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.ic.g runtime;
        if (cVar instanceof AppBrandInvokeContext) {
            com.tencent.luggage.wxa.xd.d e16 = cVar.e();
            if (e16 instanceof com.tencent.luggage.wxa.ic.l) {
                runtime = ((com.tencent.luggage.wxa.ic.l) e16).getRuntime();
            } else {
                runtime = e16 instanceof v ? ((v) e16).getRuntime() : null;
            }
            if (runtime != null) {
                if (!o.a(runtime.getAppId())) {
                    w.d(f121464f, "removeOnRunningStateChangedListener");
                    runtime.c0().b(this.f121469e);
                }
                a(runtime);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public void a(com.tencent.luggage.wxa.i8.e eVar) {
        this.f121466b = eVar;
    }

    @Override // com.tencent.luggage.wxa.j8.b
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
            J = e16 instanceof com.tencent.luggage.wxa.ic.l ? ((com.tencent.luggage.wxa.ic.l) e16).J() : null;
        }
        if (J == null) {
            w.f(f121464f, "requestFullscreen, page view is null");
            return false;
        }
        if (a16 != null && a16.has("data")) {
            JSONArray optJSONArray = a16.optJSONArray("data");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                int optInt = optJSONArray.optInt(0, 90);
                if (optInt == -90) {
                    i3 = -90;
                } else if (optInt != 0) {
                    i3 = 90;
                }
                J.a(new a(J, e16, i3));
                return true;
            }
            w.f(f121464f, "requestFullscreen, data array is null");
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public com.tencent.luggage.wxa.ai.b a(com.tencent.luggage.wxa.j8.a aVar, com.tencent.luggage.wxa.z7.c cVar) {
        return new com.tencent.luggage.wxa.ai.b(aVar, cVar);
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public com.tencent.luggage.wxa.xg.g a(com.tencent.luggage.wxa.z7.c cVar, @NonNull Handler handler) {
        com.tencent.luggage.wxa.xg.g a16;
        if (!(cVar instanceof AppBrandInvokeContext)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        i iVar = (i) com.tencent.luggage.wxa.eo.g.a(i.class);
        if (iVar == null) {
            a16 = new com.tencent.luggage.wxa.xg.j();
        } else {
            a16 = iVar.a(cVar, handler);
        }
        this.f121467c.a(g(), cVar, a16, System.currentTimeMillis() - currentTimeMillis);
        return a16;
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public void c(com.tencent.luggage.wxa.z7.c cVar, com.tencent.luggage.wxa.xg.g gVar) {
        this.f121467c.b(g(), cVar, gVar);
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public String a(com.tencent.luggage.wxa.z7.c cVar, String str) {
        com.tencent.luggage.wxa.mg.i iVar;
        if (!(cVar instanceof AppBrandInvokeContext)) {
            return str;
        }
        if (!w0.c(str) && str.startsWith("cloud://")) {
            return null;
        }
        com.tencent.luggage.wxa.xd.d e16 = cVar.e();
        if (w0.c(str) || e16 == null || e16.getFileSystem() == null || !e16.getFileSystem().accept(str)) {
            return (w0.c(str) || (iVar = (com.tencent.luggage.wxa.mg.i) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.mg.i.class)) == null) ? str : iVar.j(str);
        }
        com.tencent.luggage.wxa.cp.v absoluteFile = e16.getFileSystem().getAbsoluteFile(str);
        if (absoluteFile != null) {
            str = "file://" + absoluteFile.g();
        }
        w.d(f121464f, "convertVideoPath, videoPath:%s", str);
        return str;
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public void b(com.tencent.luggage.wxa.z7.c cVar, com.tencent.luggage.wxa.xg.g gVar) {
        this.f121467c.c(g(), cVar, gVar);
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public void e(com.tencent.luggage.wxa.z7.c cVar, com.tencent.luggage.wxa.xg.g gVar) {
        if (cVar == null || !o.a(cVar.getAppId())) {
            return;
        }
        w.d(f121464f, "onMediaPlayerVideoFirstFrame, send play event");
        new com.tencent.luggage.wxa.vg.a().c();
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public void a(com.tencent.luggage.wxa.z7.c cVar, com.tencent.luggage.wxa.xg.g gVar, String str) {
        com.tencent.luggage.wxa.i8.e eVar;
        com.tencent.luggage.wxa.mg.i iVar;
        boolean a16 = a(gVar);
        long a17 = (!a16 || (iVar = (com.tencent.luggage.wxa.mg.i) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.mg.i.class)) == null) ? 0L : iVar.a(str, 0L, Long.MAX_VALUE);
        if (a17 < 0) {
            a17 = 0;
        }
        w.d(f121464f, "onVideoPathChanged, videoPath:%s, cachedSize:%s, isSupportGetCachedBytes: %b", str, Long.valueOf(a17), Boolean.valueOf(a16));
        if (a16 && (eVar = this.f121466b) != null && eVar.o() != null) {
            this.f121466b.o().a(a17);
        }
        this.f121467c.a(g(), cVar, gVar, a17, str);
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public void a(com.tencent.luggage.wxa.z7.c cVar, @NonNull Bitmap bitmap) {
        if (cVar instanceof AppBrandInvokeContext) {
            if (bitmap.isRecycled()) {
                w.b(f121464f, "operateSnapshot, bitmap is null");
                cVar.a("fail:snapshot error");
                return;
            }
            com.tencent.luggage.wxa.xd.d e16 = cVar.e();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
            if (e16.getFileSystem() != null) {
                com.tencent.luggage.wxa.cp.v allocTempFile = e16.getFileSystem().allocTempFile("video_" + System.currentTimeMillis() + ".jpg");
                if (allocTempFile == null) {
                    w.b(f121464f, "operateSnapshot, tempFile is null");
                    a(bitmap);
                    cVar.a("fail:snapshot error");
                    return;
                }
                try {
                    com.tencent.luggage.wxa.tn.d.a(bitmap, 90, Bitmap.CompressFormat.JPEG, allocTempFile.g(), true);
                    if (e16.getFileSystem().createTempFileFrom(allocTempFile, "jpg", true, iVar) != com.tencent.luggage.wxa.rc.l.OK) {
                        w.b(f121464f, "operateSnapshot, save snapshot failed");
                        a(bitmap);
                        cVar.a("fail:snapshot error");
                        return;
                    }
                    com.tencent.luggage.wxa.cp.v absoluteFile = e16.getFileSystem().getAbsoluteFile((String) iVar.f141499a);
                    w.d(f121464f, "operateSnapshot, realPath: %s, path:%s", (absoluteFile == null || !absoluteFile.e()) ? "" : x.b(absoluteFile.g(), false), iVar.f141499a);
                    a(bitmap);
                    HashMap hashMap = new HashMap();
                    hashMap.put("tempImagePath", iVar.f141499a);
                    hashMap.put("width", Integer.valueOf(width));
                    hashMap.put("height", Integer.valueOf(height));
                    cVar.a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
                    return;
                } catch (IOException e17) {
                    w.b(f121464f, "operateSnapshot, save bitmap exception", e17);
                    a(bitmap);
                    cVar.a("fail:snapshot error");
                    return;
                }
            }
            w.b(f121464f, "operateSnapshot, file system is null");
            a(bitmap);
            cVar.a("fail");
        }
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public void a(com.tencent.luggage.wxa.z7.c cVar, com.tencent.luggage.wxa.xg.g gVar, long j3) {
        this.f121467c.b(g(), cVar, gVar, j3);
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public void a(com.tencent.luggage.wxa.z7.c cVar, com.tencent.luggage.wxa.xg.g gVar, int i3, int i16, String str) {
        this.f121467c.a(g(), cVar, gVar, i3, i16, str);
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public void a(@NonNull j.d dVar) {
        this.f121467c.a(g(), dVar);
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public void a(com.tencent.luggage.wxa.z7.c cVar, com.tencent.luggage.wxa.xg.g gVar) {
        this.f121467c.e(g(), cVar, gVar);
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public com.tencent.luggage.wxa.j8.a a() {
        return new com.tencent.luggage.wxa.ai.a();
    }

    @Override // com.tencent.luggage.wxa.j8.b
    public void a(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.ic.g runtime;
        if (cVar instanceof AppBrandInvokeContext) {
            com.tencent.luggage.wxa.xd.d e16 = cVar.e();
            this.f121468d = e16.getAppId();
            if (e16 instanceof com.tencent.luggage.wxa.ic.l) {
                runtime = ((com.tencent.luggage.wxa.ic.l) e16).getRuntime();
            } else {
                runtime = e16 instanceof v ? ((v) e16).getRuntime() : null;
            }
            if (runtime == null || o.a(runtime.getAppId())) {
                return;
            }
            w.d(f121464f, "addOnRunningStateChangedListener");
            runtime.c0().a(this.f121469e);
        }
    }

    private void a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        w.d(f121464f, "bitmap recycle " + bitmap.toString());
        bitmap.recycle();
    }

    private void a(@NonNull com.tencent.luggage.wxa.ic.g gVar) {
        w.a(f121464f, "markVideoPlayerRelease");
        if (this.f121466b == null) {
            w.f(f121464f, "markVideoPlayerRelease, pluginHandler is null");
            return;
        }
        com.tencent.luggage.wxa.ph.a aVar = (com.tencent.luggage.wxa.ph.a) gVar.c(com.tencent.luggage.wxa.ph.a.class);
        if (aVar == null) {
            w.f(f121464f, "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
        } else {
            aVar.e(this.f121466b);
        }
    }
}
