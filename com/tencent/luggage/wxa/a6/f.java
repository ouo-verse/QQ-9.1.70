package com.tencent.luggage.wxa.a6;

import com.tencent.luggage.wxa.cb.a;
import com.tencent.luggage.wxa.gp.a;
import com.tencent.luggage.wxa.i1.a;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f120890a = new f();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements a.d {
        @Override // com.tencent.luggage.wxa.i1.a.d
        public void a(Class clazz, com.tencent.luggage.wxa.h1.b customize) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(customize, "customize");
        }

        @Override // com.tencent.luggage.wxa.i1.a.d
        public void a(Class clazz, com.tencent.luggage.wxa.h1.d profiler) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(profiler, "profiler");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f120891a = new b();

        @Override // com.tencent.luggage.wxa.gp.a.b
        public final void loadLibrary(String str) {
            com.tencent.luggage.wxa.aa.h.g(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public static final c f120892a = new c();

        @Override // com.tencent.luggage.wxa.cb.a.b
        public final void loadLibrary(String str) {
            com.tencent.luggage.wxa.aa.h.g(str);
        }
    }

    static {
        com.tencent.luggage.wxa.u5.a.f142121a.a(new a());
        com.tencent.luggage.wxa.gp.a.a(b.f120891a);
        try {
            com.tencent.luggage.wxa.cb.a.a(c.f120892a);
        } catch (Throwable th5) {
            w.b("Luggage.MPServiceNativeLibrariesLoadRegisterGuard", "WxAudioLoadDelegate.setInstance failed, maybe missing classes, " + th5);
        }
    }

    public static final void a() {
        w.d("MPServiceNativeLibrariesLoadRegisterGuard", "init");
    }
}
