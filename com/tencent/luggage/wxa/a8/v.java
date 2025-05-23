package com.tencent.luggage.wxa.a8;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Message;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class v {

    /* renamed from: c, reason: collision with root package name */
    public static final Field f120954c;

    /* renamed from: a, reason: collision with root package name */
    public final SurfaceTexture f120955a;

    /* renamed from: b, reason: collision with root package name */
    public final List f120956b = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f120957a;

        public a(c cVar) {
            this.f120957a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f120957a.f120961a.onFrameAvailable(v.this.f120955a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final v f120959a;

        /* renamed from: b, reason: collision with root package name */
        public final Handler f120960b;

        public b(Handler handler, v vVar) {
            super(handler.getLooper());
            this.f120960b = handler;
            this.f120959a = vVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f120960b.handleMessage(message);
            this.f120959a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final SurfaceTexture.OnFrameAvailableListener f120961a;

        /* renamed from: b, reason: collision with root package name */
        public final Handler f120962b;

        public c(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
            this.f120961a = onFrameAvailableListener;
            this.f120962b = handler;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return this.f120961a.equals(((c) obj).f120961a);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.f120961a);
        }
    }

    static {
        Field field = null;
        try {
            field = SurfaceTexture.class.getDeclaredField("mOnFrameAvailableHandler");
            field.setAccessible(true);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.SurfaceTextureWrapper", "get mOnFrameAvailableHandler fail since " + e16.toString());
        }
        f120954c = field;
    }

    public v(SurfaceTexture surfaceTexture) {
        this.f120955a = surfaceTexture;
    }

    public static v a(SurfaceTexture surfaceTexture) {
        synchronized (surfaceTexture) {
            Field field = f120954c;
            if (field == null) {
                return null;
            }
            try {
                Handler handler = (Handler) field.get(surfaceTexture);
                if (handler == null) {
                    com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.SurfaceTextureWrapper", "wrap, hookSurfaceTexture, originOnFrameAvailableHandler is null");
                    return null;
                }
                if (handler instanceof b) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.SurfaceTextureWrapper", "wrap, hookSurfaceTexture, already hook");
                    return ((b) handler).f120959a;
                }
                v vVar = new v(surfaceTexture);
                field.set(surfaceTexture, new b(handler, vVar));
                return vVar;
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.SurfaceTextureWrapper", "wrap, hookSurfaceTexture fail since " + e16.toString());
                return null;
            }
        }
    }

    public synchronized void a(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        c cVar = new c(onFrameAvailableListener, handler);
        this.f120956b.remove(cVar);
        this.f120956b.add(cVar);
    }

    public synchronized void a(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        this.f120956b.remove(new c(onFrameAvailableListener, null));
    }

    public final synchronized void a() {
        for (c cVar : this.f120956b) {
            Handler handler = cVar.f120962b;
            if (handler == null) {
                cVar.f120961a.onFrameAvailable(this.f120955a);
            } else {
                handler.post(new a(cVar));
            }
        }
    }
}
