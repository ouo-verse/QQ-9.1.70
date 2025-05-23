package com.tencent.luggage.wxa.eb;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Process;
import com.tencent.luggage.wxa.tn.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.io.Closeable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public static final C6160a f124596f = new C6160a(null);

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f124597a;

    /* renamed from: b, reason: collision with root package name */
    public int f124598b;

    /* renamed from: c, reason: collision with root package name */
    public long f124599c;

    /* renamed from: d, reason: collision with root package name */
    public int f124600d;

    /* renamed from: e, reason: collision with root package name */
    public final long f124601e;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.eb.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6160a {
        public C6160a() {
        }

        public /* synthetic */ C6160a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(long j3) {
        this.f124598b = -1;
        this.f124600d = -1;
        this.f124599c = j3;
        b.f124602a.a();
        this.f124600d = Process.myTid();
        long nativeHandle = EGL14.eglGetCurrentContext().getNativeHandle();
        this.f124601e = nativeHandle;
        this.f124598b = com.tencent.luggage.wxa.jb.a.f130928a.b();
        w.d("MicroMsg.GLFrameBufferObject", "create frameBuffer:" + this.f124598b + " tid:" + this.f124600d + ", context: " + nativeHandle + ", stackTrace: " + w0.b());
    }

    public final void a() {
        GLES20.glBindFramebuffer(36160, d());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f124597a) {
            w.d("MicroMsg.GLFrameBufferObject", hashCode() + " close already close");
            return;
        }
        int myTid = Process.myTid();
        if (this.f124600d != myTid) {
            w.b("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked by different thread!!!  scene\uff1a" + this.f124599c + "  created in:" + this.f124600d + " release in:" + myTid + ", stackTrace:\t" + w0.b());
            b.f124602a.c();
            return;
        }
        this.f124597a = true;
        com.tencent.luggage.wxa.jb.a.f130928a.a(this.f124598b);
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        if (eglGetCurrentContext.getNativeHandle() == 0) {
            String str = "context is destroyed, framebuffer leaked! framebufferId: " + this.f124598b;
            w.b("MicroMsg.GLFrameBufferObject", str);
            if (e.f141559a) {
                throw new IllegalStateException(str);
            }
        }
        if (eglGetCurrentContext.getNativeHandle() != this.f124601e) {
            String str2 = "release framebuffer(" + this.f124598b + ") with current context(" + eglGetCurrentContext.getNativeHandle() + ") which NOT equals to the origin context (" + this.f124601e + "). something wrong and causes leak!";
            w.b("MicroMsg.GLFrameBufferObject", str2);
            if (e.f141559a) {
                throw new IllegalStateException(str2);
            }
        }
        w.d("MicroMsg.GLFrameBufferObject", hashCode() + " close framebufferId:" + this.f124598b + " context: " + eglGetCurrentContext.getNativeHandle() + ", stacks:" + w0.b());
    }

    public final int d() {
        return this.f124598b;
    }

    public final void finalize() {
        if (!this.f124597a) {
            b bVar = b.f124602a;
            bVar.a(this.f124599c);
            bVar.b();
            w.b("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked !!!  scene\uff1a" + this.f124599c);
            return;
        }
        w.d("MicroMsg.GLFrameBufferObject", hashCode() + " release success!");
    }

    public String toString() {
        return "hashcode:" + hashCode() + " frameBufferId:" + this.f124598b + " memRelease:" + this.f124597a + " scene:" + this.f124599c + " create-tid:" + this.f124600d;
    }
}
