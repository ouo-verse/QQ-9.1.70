package com.tencent.luggage.wxa.m8;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.z7.f;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.k8.c f134211a;

    /* renamed from: b, reason: collision with root package name */
    public Map f134212b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.z7.b f134213c;

    public boolean a(String str, com.tencent.luggage.wxa.z7.c cVar) {
        return true;
    }

    public final String b() {
        return String.format(Locale.US, "%s(%s)", "MicroMsg.SameLayer.DefaultExtendPluginClientProxy", Integer.valueOf(hashCode()));
    }

    @Override // com.tencent.luggage.wxa.m8.c
    public void onPluginDestroy(String str, int i3) {
        String a16 = f.a(str, i3);
        w.d(b(), "onPluginDestroy, key:%s", a16);
        com.tencent.luggage.wxa.k8.b a17 = a(str, i3, a16);
        if (a17 == null) {
            w.h(b(), "onPluginDestroy, key:%s, handler is null", a16);
        } else {
            a17.handlePluginDestroy();
        }
    }

    @Override // com.tencent.luggage.wxa.m8.c
    public void onPluginReady(String str, int i3, SurfaceTexture surfaceTexture) {
        String a16 = f.a(str, i3);
        w.d(b(), "onPluginReady, key:%s", a16);
        com.tencent.luggage.wxa.k8.b a17 = a(str, i3, a16);
        if (a17 == null) {
            w.h(b(), "onPluginReady, key:%s, handler is null", a16);
        } else {
            w.d(b(), "onPluginReady, key:%s, handler is ready", a16);
            a17.handlePluginReady(surfaceTexture);
        }
    }

    @Override // com.tencent.luggage.wxa.m8.c
    public void onPluginReadyForGPUProcess(String str, int i3, Surface surface) {
        String a16 = f.a(str, i3);
        w.d(b(), "onPluginReady, key:%s", a16);
        com.tencent.luggage.wxa.k8.b a17 = a(str, i3, a16);
        if (a17 == null) {
            w.h(b(), "onPluginReady, key:%s, handler is null", a16);
        } else {
            w.d(b(), "onPluginReady, key:%s, handler is ready", a16);
            a17.handlePluginReadyForGPUProcess(surface);
        }
    }

    @Override // com.tencent.luggage.wxa.m8.c
    public void onPluginScreenshotTaken(String str, int i3, Bitmap bitmap) {
        String a16 = f.a(str, i3);
        w.g(b(), "onPluginScreenshotTaken, key:%s", a16);
        com.tencent.luggage.wxa.k8.b a17 = a(str, i3, a16);
        if (a17 == null) {
            w.h(b(), "onPluginScreenshotTaken, key:%s, handler is null", a16);
        } else {
            a17.handlePluginScreenshotTaken(bitmap);
        }
    }

    @Override // com.tencent.luggage.wxa.m8.c
    public void onPluginTouch(String str, int i3, MotionEvent motionEvent) {
        String a16 = f.a(str, i3);
        w.g(b(), "onPluginTouch, key:%s", a16);
        com.tencent.luggage.wxa.k8.b a17 = a(str, i3, a16);
        if (a17 == null) {
            w.h(b(), "onPluginTouch, key:%s, handler is null", a16);
        } else {
            a17.handlePluginTouch(motionEvent);
        }
    }

    @Override // com.tencent.luggage.wxa.m8.c
    public com.tencent.luggage.wxa.z7.b a() {
        return this.f134213c;
    }

    public final com.tencent.luggage.wxa.k8.b b(String str, int i3, String str2, boolean z16) {
        com.tencent.luggage.wxa.k8.b bVar = (com.tencent.luggage.wxa.k8.b) this.f134212b.get(str2);
        if (bVar == null) {
            w.b(b(), "getPluginHandler, key:%s, current no handler for this key", str2);
            com.tencent.luggage.wxa.k8.c cVar = this.f134211a;
            if (cVar != null) {
                if (z16) {
                    bVar = cVar.f(str);
                    if (bVar != null) {
                        w.h(b(), "getPluginHandler, key:%s, created new plugin handler(%s)", str2, Integer.valueOf(bVar.hashCode()));
                        bVar.setId(i3);
                        bVar.setType(str);
                        bVar.setPluginClientProxy(this);
                        this.f134212b.put(str2, bVar);
                    } else {
                        w.b(b(), "getPluginHandler, key:%s, no handler for this key?", str2);
                    }
                } else {
                    w.d(b(), "getPluginHandler, key:%s, do not create handler", str2);
                }
            }
        }
        return bVar;
    }

    @Override // com.tencent.luggage.wxa.m8.c
    public void a(com.tencent.luggage.wxa.z7.b bVar) {
        this.f134213c = bVar;
    }

    @Override // com.tencent.luggage.wxa.m8.c
    public void a(com.tencent.luggage.wxa.k8.c cVar) {
        this.f134211a = cVar;
    }

    @Override // com.tencent.luggage.wxa.m8.c
    public String a(String str, int i3, com.tencent.luggage.wxa.z7.c cVar) {
        String a16 = f.a(str, i3);
        boolean a17 = a(str, cVar);
        w.d(b(), "handleJsApi, key:%s, jsapi:%s, createHandlerIfNeed: %b", a16, cVar.c(), Boolean.valueOf(a17));
        com.tencent.luggage.wxa.k8.b a18 = a(str, i3, a16, a17);
        if (a18 == null) {
            w.h(b(), "handleJsApi, key:%s, handler is null", a16);
            if (cVar.b()) {
                return cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
            }
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
            return "";
        }
        if (a18.isPluginReady(cVar)) {
            if (cVar.b()) {
                return a18.handleJsApi(cVar);
            }
            a18.handleJsApi(cVar);
            return "";
        }
        if (cVar.b()) {
            return cVar.a(com.tencent.luggage.wxa.af.e.f121305a);
        }
        cVar.a(com.tencent.luggage.wxa.af.e.f121305a);
        return "";
    }

    public final synchronized com.tencent.luggage.wxa.k8.b a(String str, int i3, String str2) {
        return b(str, i3, str2, true);
    }

    public final synchronized com.tencent.luggage.wxa.k8.b a(String str, int i3, String str2, boolean z16) {
        return b(str, i3, str2, z16);
    }

    @Override // com.tencent.luggage.wxa.m8.c
    public synchronized void a(String str, int i3) {
        String a16 = f.a(str, i3);
        w.d(b(), "removePlugin, key:%s", a16);
        this.f134212b.remove(a16);
    }
}
