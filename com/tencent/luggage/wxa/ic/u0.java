package com.tencent.luggage.wxa.ic;

import android.util.Log;
import com.tencent.map.geolocation.TencentLocation;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/luggage/wxa/ic/u0;", "", "<init>", "()V", "a", "b", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public static final u0 f130001a = new u0();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R?\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR,\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/luggage/wxa/ic/u0$b;", "", "Lkotlin/Function1;", "Lcom/tencent/luggage/wxa/wj/c;", "Lkotlin/ParameterName;", "name", "windowAndroid", "Lcom/tencent/luggage/wxa/p5/f;", "b", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "setRuntimeCreator", "(Lkotlin/jvm/functions/Function1;)V", "RuntimeCreator", "Lkotlin/Function0;", "Landroid/content/Context;", "c", "Lkotlin/jvm/functions/Function0;", "a", "()Lkotlin/jvm/functions/Function0;", "setPreRenderContextCreator", "(Lkotlin/jvm/functions/Function0;)V", "PreRenderContextCreator", "<init>", "()V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f130007a = new b();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static Function1 RuntimeCreator;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public static Function0 PreRenderContextCreator;

        b() {
        }

        public final Function0 a() {
            return PreRenderContextCreator;
        }

        public final Function1 b() {
            return RuntimeCreator;
        }
    }

    u0() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u0005\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0002R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/luggage/wxa/ic/u0$a;", "", "Lcom/tencent/luggage/wxa/fd/i;", "cfg", "Lcom/tencent/luggage/wxa/p5/f;", "a", "", "appId", "", "versionType", "b", "rt", "Lcom/tencent/luggage/wxa/d6/b;", "action", "", "processIndex", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "runtimeMap", "<init>", "()V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f130002a = new a();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final ConcurrentHashMap runtimeMap = new ConcurrentHashMap();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.luggage.wxa.ic.u0$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6299a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f130004a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f130005b;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/luggage/wxa/ic/j0;", "kotlin.jvm.PlatformType", "data", "Lcom/tencent/luggage/wxa/va/e;", "a", "(Lcom/tencent/luggage/wxa/ic/j0;)Lcom/tencent/luggage/wxa/va/e;"}, k = 3, mv = {1, 7, 1})
            /* renamed from: com.tencent.luggage.wxa.ic.u0$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6300a<InputType, ResultType> implements com.tencent.luggage.wxa.ka.r {

                /* renamed from: a, reason: collision with root package name */
                public static final C6300a f130006a = new C6300a();

                @Override // com.tencent.luggage.wxa.ka.r
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final com.tencent.luggage.wxa.va.e invoke(j0 j0Var) {
                    if (j0Var != null) {
                        com.tencent.luggage.wxa.z4.f.f146283b.a().g(j0Var.a(), j0Var.b());
                    }
                    return com.tencent.luggage.wxa.va.e.f143316a;
                }
            }

            public RunnableC6299a(String str, int i3) {
                this.f130004a = str;
                this.f130005b = i3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.tencent.luggage.wxa.ka.o.a(com.tencent.luggage.wxa.tn.z.g(), new j0(this.f130004a, this.f130005b), C6300a.f130006a.getClass());
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPreRenderColdStartService", "PreRenderedRuntimeStore.remove appId:" + this.f130004a + ", ipc notify get exception " + e16);
                }
            }
        }

        a() {
        }

        public static final com.tencent.luggage.wxa.p5.f b(String appId, int versionType) {
            if (appId == null) {
                return null;
            }
            ConcurrentHashMap concurrentHashMap = runtimeMap;
            synchronized (concurrentHashMap) {
                com.tencent.luggage.wxa.p5.f fVar = (com.tencent.luggage.wxa.p5.f) concurrentHashMap.get(appId);
                if (fVar != null) {
                    if (versionType == fVar.l0()) {
                        return fVar;
                    }
                    Unit unit = Unit.INSTANCE;
                }
                return null;
            }
        }

        public final void a(com.tencent.luggage.wxa.p5.f rt5, com.tencent.luggage.wxa.d6.b action) {
            Intrinsics.checkNotNullParameter(action, "action");
            if (rt5 == null) {
                return;
            }
            ConcurrentHashMap concurrentHashMap = runtimeMap;
            synchronized (concurrentHashMap) {
                concurrentHashMap.remove(rt5.getAppId());
                String appId = rt5.getAppId();
                Intrinsics.checkNotNullExpressionValue(appId, "rt.appId");
                concurrentHashMap.put(appId, rt5);
                Unit unit = Unit.INSTANCE;
            }
            try {
                String g16 = com.tencent.luggage.wxa.tn.z.g();
                String appId2 = rt5.getAppId();
                Intrinsics.checkNotNullExpressionValue(appId2, "rt.appId");
                String i3 = com.tencent.luggage.wxa.tn.z.i();
                Intrinsics.checkNotNullExpressionValue(i3, "getProcessName()");
                int i16 = rt5.S().f130794f0;
                boolean Q1 = rt5.Q1();
                int l06 = rt5.l0();
                com.tencent.luggage.wxa.bk.e L1 = rt5.L1();
                com.tencent.luggage.wxa.fd.n nVar = rt5.S().N;
                com.tencent.luggage.wxa.r5.a S = rt5.S();
                Intrinsics.checkNotNullExpressionValue(S, "rt.initConfig");
                com.tencent.luggage.wxa.ka.o.a(g16, new com.tencent.luggage.wxa.l3.c(appId2, i3, i16, Q1, l06, L1, nVar, S), h0.class);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPreRenderColdStartService", "PreRenderedRuntimeStore.push appId:" + rt5.getAppId() + ", ipc notify get exception " + e16.getMessage() + TokenParser.SP + Log.getStackTraceString(e16));
            }
        }

        public static final com.tencent.luggage.wxa.p5.f a(com.tencent.luggage.wxa.fd.i cfg) {
            com.tencent.luggage.wxa.p5.f fVar;
            Intrinsics.checkNotNullParameter(cfg, "cfg");
            if (cfg.f125808a == null) {
                return null;
            }
            com.tencent.luggage.wxa.j4.d dVar = (com.tencent.luggage.wxa.j4.d) cfg;
            ConcurrentHashMap concurrentHashMap = runtimeMap;
            synchronized (concurrentHashMap) {
                fVar = (com.tencent.luggage.wxa.p5.f) concurrentHashMap.remove(cfg.f125808a);
            }
            if (fVar == null) {
                return null;
            }
            a aVar = f130002a;
            String str = cfg.f125808a;
            Intrinsics.checkNotNullExpressionValue(str, "cfg.appId");
            aVar.a(str, dVar.f130794f0);
            return fVar;
        }

        public final void a(String appId, int processIndex) {
            RunnableC6299a runnableC6299a = new RunnableC6299a(appId, processIndex);
            if (com.tencent.luggage.wxa.uk.l0.a()) {
                com.tencent.luggage.wxa.zp.h.f146825d.c(runnableC6299a);
            } else {
                runnableC6299a.run();
            }
        }
    }
}
