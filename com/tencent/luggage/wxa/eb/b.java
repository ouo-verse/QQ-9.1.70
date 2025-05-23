package com.tencent.luggage.wxa.eb;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f124602a = new b();

    public final void a() {
        w.d("MicroMsg.GLLeakIDKeyReport", "markGLFBOCreated");
        com.tencent.luggage.wxa.xm.b.INSTANCE.a(1184L, 100L, 1L);
    }

    public final void b(long j3) {
        w.d("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeakedScene key:" + j3);
        com.tencent.luggage.wxa.xm.b.INSTANCE.a(1184L, j3, 1L);
    }

    public final void c() {
        w.d("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeakedInErrorTid");
        com.tencent.luggage.wxa.xm.b.INSTANCE.a(1184L, 201L, 1L);
    }

    public final void d() {
        w.d("MicroMsg.GLLeakIDKeyReport", "markGLTextureCreated");
        com.tencent.luggage.wxa.xm.b.INSTANCE.a(1184L, 0L, 1L);
    }

    public final void e() {
        w.d("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeaked");
        com.tencent.luggage.wxa.xm.b.INSTANCE.a(1184L, 1L, 1L);
    }

    public final void f() {
        w.d("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeakedInErrorTid");
        com.tencent.luggage.wxa.xm.b.INSTANCE.a(1184L, 200L, 1L);
    }

    public final void a(long j3) {
        w.d("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeakedScene key:" + j3);
        com.tencent.luggage.wxa.xm.b.INSTANCE.a(1184L, j3 + ((long) 100), 1L);
    }

    public final void b() {
        w.d("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeaked");
        com.tencent.luggage.wxa.xm.b.INSTANCE.a(1184L, 101L, 1L);
    }
}
