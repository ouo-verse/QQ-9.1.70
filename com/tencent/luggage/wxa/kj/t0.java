package com.tencent.luggage.wxa.kj;

import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface t0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f132415a = a.f132416a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f132416a = new a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.kj.t0$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6392a implements t0 {

            /* renamed from: b, reason: collision with root package name */
            public final com.tencent.luggage.wxa.kj.a f132417b;

            /* renamed from: c, reason: collision with root package name */
            public final com.tencent.luggage.wxa.mc.q0 f132418c;

            /* renamed from: d, reason: collision with root package name */
            public final String f132419d;

            /* renamed from: e, reason: collision with root package name */
            public final Lazy f132420e;

            /* renamed from: f, reason: collision with root package name */
            public final HashSet f132421f;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.kj.t0$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6393a extends Lambda implements Function0 {
                public C6393a() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final com.tencent.luggage.wxa.mc.m invoke() {
                    com.tencent.luggage.wxa.xd.d t16 = C6392a.this.f132417b.t();
                    Intrinsics.checkNotNull(t16);
                    com.tencent.luggage.wxa.mc.n b16 = com.tencent.luggage.wxa.mc.k0.b(((com.tencent.luggage.wxa.m4.b) t16).getRuntime());
                    Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.IWxaPkgRuntimeReader");
                    return b16;
                }
            }

            public C6392a(com.tencent.luggage.wxa.kj.a renderer, com.tencent.luggage.wxa.mc.q0 separatedPluginsMap) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(renderer, "renderer");
                Intrinsics.checkNotNullParameter(separatedPluginsMap, "separatedPluginsMap");
                this.f132417b = renderer;
                this.f132418c = separatedPluginsMap;
                this.f132419d = "Luggage.FULL.IWxaPageSeparatedPluginsInjectHelper.IMPL";
                lazy = LazyKt__LazyJVMKt.lazy(new C6393a());
                this.f132420e = lazy;
                this.f132421f = new HashSet();
            }

            public final com.tencent.luggage.wxa.mc.m b() {
                return (com.tencent.luggage.wxa.mc.m) this.f132420e.getValue();
            }

            public final void a(com.tencent.luggage.wxa.kj.a aVar, String str) {
                if (this.f132421f.contains(str)) {
                    return;
                }
                com.tencent.luggage.wxa.tn.w.d(this.f132419d, "inner evaluateScriptFile fileName(" + str + ") hash(" + hashCode() + ')');
                aVar.a(str, aVar.E().a(str));
                this.f132421f.add(str);
            }

            @Override // com.tencent.luggage.wxa.kj.t0
            public void a(String moduleName, boolean z16) {
                Intrinsics.checkNotNullParameter(moduleName, "moduleName");
                com.tencent.luggage.wxa.tn.w.d(this.f132419d, "injectPlugins moduleName(" + moduleName + ") useLazyCodeLoading(" + z16 + ") hash(" + hashCode() + ')');
                List b16 = this.f132418c.b(moduleName);
                if (b16 == null) {
                    String fixedName = com.tencent.luggage.wxa.ki.a.b(moduleName);
                    if (Intrinsics.areEqual(fixedName, moduleName)) {
                        b16 = null;
                    } else {
                        com.tencent.luggage.wxa.mc.q0 q0Var = this.f132418c;
                        Intrinsics.checkNotNullExpressionValue(fixedName, "fixedName");
                        b16 = q0Var.b(fixedName);
                    }
                }
                if (b16 != null && !b16.isEmpty()) {
                    Iterator it = b16.iterator();
                    while (it.hasNext()) {
                        String a16 = com.tencent.luggage.wxa.mc.t0.f134367k.a(moduleName, (WxaPluginPkgInfo) it.next());
                        if (z16) {
                            if (b().d(a16 + "/common.app.js")) {
                                a(this.f132417b, a16 + "/common.app.js");
                                a(this.f132417b, a16 + "/webview.app.js");
                            }
                        }
                        a(this.f132417b, a16 + "/pageframe.js");
                    }
                    return;
                }
                com.tencent.luggage.wxa.tn.w.d(this.f132419d, "injectPlugins, try with module(" + moduleName + "), get empty pluginList");
            }

            @Override // com.tencent.luggage.wxa.kj.t0
            public void a() {
                this.f132421f.clear();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements t0 {
            @Override // com.tencent.luggage.wxa.kj.t0
            public void a() {
            }

            @Override // com.tencent.luggage.wxa.kj.t0
            public void a(String moduleName, boolean z16) {
                Intrinsics.checkNotNullParameter(moduleName, "moduleName");
            }
        }

        public final t0 a(com.tencent.luggage.wxa.kj.a renderer) {
            int i3;
            com.tencent.luggage.wxa.mc.q0 q0Var;
            Intrinsics.checkNotNullParameter(renderer, "renderer");
            com.tencent.luggage.wxa.xd.d t16 = renderer.t();
            Intrinsics.checkNotNull(t16);
            com.tencent.mm.plugin.appbrand.appcache.a aVar = ((com.tencent.luggage.wxa.j4.g) ((com.tencent.luggage.wxa.m4.b) t16).a(com.tencent.luggage.wxa.j4.g.class)).f125966l;
            if (aVar != null && (q0Var = aVar.f151866f) != null) {
                i3 = q0Var.a();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                com.tencent.luggage.wxa.mc.q0 q0Var2 = aVar.f151866f;
                Intrinsics.checkNotNull(q0Var2);
                return new C6392a(renderer, q0Var2);
            }
            return new b();
        }
    }

    void a();

    void a(String str, boolean z16);
}
