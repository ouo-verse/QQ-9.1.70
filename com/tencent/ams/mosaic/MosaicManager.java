package com.tencent.ams.mosaic;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.QuickJSEngine;
import com.tencent.ams.mosaic.jsengine.a;
import com.tencent.ams.mosaic.jsengine.common.Env;
import com.tencent.ams.mosaic.jsengine.common.Http;
import com.tencent.ams.mosaic.jsengine.common.thread.MosaicThread;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.ams.mosaic.load.QuickJSSoLoader;
import com.tencent.ams.mosaic.utils.DebugUtils;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MosaicManager {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final MosaicManager f70586e;

    /* renamed from: a, reason: collision with root package name */
    private Context f70587a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f70588b;

    /* renamed from: c, reason: collision with root package name */
    private List<com.tencent.ams.mosaic.a> f70589c;

    /* renamed from: d, reason: collision with root package name */
    private f f70590d;

    /* compiled from: P */
    /* renamed from: com.tencent.ams.mosaic.MosaicManager$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f70591d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f70592e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.ams.mosaic.d f70593f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ g f70594h;

        /* compiled from: P */
        /* renamed from: com.tencent.ams.mosaic.MosaicManager$4$a */
        /* loaded from: classes3.dex */
        class a implements DebugUtils.a {
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.ams.mosaic.MosaicManager$4$a$a, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            class C0684a implements com.tencent.ams.mosaic.d {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ k f70596a;

                C0684a(k kVar) {
                    this.f70596a = kVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) kVar);
                    }
                }

                @Override // com.tencent.ams.mosaic.d
                public com.tencent.ams.mosaic.jsengine.a getJSEngine() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        return (com.tencent.ams.mosaic.jsengine.a) iPatchRedirector.redirect((short) 5, (Object) this);
                    }
                    return AnonymousClass4.this.f70593f.getJSEngine();
                }

                @Override // com.tencent.ams.mosaic.d
                public int getRootViewHeight() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                    }
                    return AnonymousClass4.this.f70593f.getRootViewHeight();
                }

                @Override // com.tencent.ams.mosaic.d
                public int getRootViewWidth() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                    }
                    return AnonymousClass4.this.f70593f.getRootViewWidth();
                }

                @Override // com.tencent.ams.mosaic.d
                public k getTemplate() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        return (k) iPatchRedirector.redirect((short) 4, (Object) this);
                    }
                    return this.f70596a;
                }

                @Override // com.tencent.ams.mosaic.d
                public /* synthetic */ boolean isRequiredTemplate() {
                    return com.tencent.ams.mosaic.c.a(this);
                }
            }

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                }
            }

            @Override // com.tencent.ams.mosaic.utils.DebugUtils.a
            public void a(String str) {
                String b16;
                List<j> c16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                    return;
                }
                k kVar = AnonymousClass4.this.f70592e;
                List<j> list = null;
                if (kVar == null) {
                    b16 = null;
                } else {
                    b16 = kVar.b();
                }
                k kVar2 = AnonymousClass4.this.f70592e;
                if (kVar2 == null) {
                    c16 = null;
                } else {
                    c16 = kVar2.c();
                }
                k kVar3 = AnonymousClass4.this.f70592e;
                if (kVar3 != null) {
                    list = kVar3.e();
                }
                k kVar4 = new k(str, b16, c16, list);
                C0684a c0684a = new C0684a(kVar4);
                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                MosaicManager.this.e(anonymousClass4.f70591d, kVar4, c0684a, anonymousClass4.f70594h);
            }
        }

        AnonymousClass4(Context context, k kVar, com.tencent.ams.mosaic.d dVar, g gVar) {
            this.f70591d = context;
            this.f70592e = kVar;
            this.f70593f = dVar;
            this.f70594h = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MosaicManager.this, context, kVar, dVar, gVar);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (MosaicManager.this.f70590d != null) {
                MosaicManager.this.f70590d.a("createMosaicViewRun", null);
            }
            if (!com.tencent.ams.mosaic.f.k().v()) {
                MosaicManager.this.e(this.f70591d, this.f70592e, this.f70593f, this.f70594h);
            } else {
                DebugUtils.d().i(this.f70591d, new a());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements QuickJSSoLoader.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f70598a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f70599b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f70600c;

        a(d dVar, Context context, List list) {
            this.f70598a = dVar;
            this.f70599b = context;
            this.f70600c = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MosaicManager.this, dVar, context, list);
            }
        }

        @Override // com.tencent.ams.mosaic.load.QuickJSSoLoader.a
        public void onSoLoadFailed(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            d dVar = this.f70598a;
            if (dVar != null) {
                dVar.onSoLoadFail(i3);
                this.f70598a.onEngineCreateFail(1009);
            }
        }

        @Override // com.tencent.ams.mosaic.load.QuickJSSoLoader.a
        public void onSoLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            d dVar = this.f70598a;
            if (dVar != null) {
                dVar.onSoLoadStart();
            }
        }

        @Override // com.tencent.ams.mosaic.load.QuickJSSoLoader.a
        public void onSoLoadSuccess(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            d dVar = this.f70598a;
            if (dVar != null) {
                dVar.onSoLoadSuccess(i3);
            }
            MosaicManager.this.h(this.f70599b, this.f70600c, this.f70598a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b extends e {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f70602c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QuickJSEngine f70603d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i3, d dVar, QuickJSEngine quickJSEngine) {
            super(i3);
            this.f70602c = dVar;
            this.f70603d = quickJSEngine;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MosaicManager.this, Integer.valueOf(i3), dVar, quickJSEngine);
            }
        }

        @Override // com.tencent.ams.mosaic.MosaicManager.e
        void a(String str) {
            d dVar = this.f70602c;
            if (dVar != null) {
                dVar.onEngineCreateFail(1003);
            }
        }

        @Override // com.tencent.ams.mosaic.MosaicManager.e
        void b() {
            d dVar = this.f70602c;
            if (dVar != null) {
                dVar.onEngineCreated(this.f70603d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c extends e {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        boolean f70605c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f70606d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.ams.mosaic.d f70607e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f70608f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ MosaicView f70609g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i3, long j3, com.tencent.ams.mosaic.d dVar, g gVar, MosaicView mosaicView) {
            super(i3);
            this.f70606d = j3;
            this.f70607e = dVar;
            this.f70608f = gVar;
            this.f70609g = mosaicView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MosaicManager.this, Integer.valueOf(i3), Long.valueOf(j3), dVar, gVar, mosaicView);
            } else {
                this.f70605c = false;
            }
        }

        @Override // com.tencent.ams.mosaic.MosaicManager.e
        void a(String str) {
            g gVar;
            if (!this.f70605c && (gVar = this.f70608f) != null) {
                this.f70605c = true;
                gVar.onViewCreateFail(1004);
                if (MosaicManager.this.f70590d != null) {
                    MosaicManager.this.f70590d.a("initMosaicViewJsEvaluateFail", str);
                }
            }
        }

        @Override // com.tencent.ams.mosaic.MosaicManager.e
        void b() {
            long j3;
            if (MosaicManager.this.f70590d != null) {
                MosaicManager.this.f70590d.a("initMosaicViewJsEvaluateFinish", null);
            }
            if (MosaicManager.this.l()) {
                j3 = SystemClock.elapsedRealtime();
                com.tencent.ams.mosaic.utils.f.h("MosaicManager", "mosaic_performance evaluate bundle.js end, coast:" + (j3 - this.f70606d) + "ms");
            } else {
                j3 = 0;
            }
            try {
                k template = this.f70607e.getTemplate();
                if (template == null) {
                    g gVar = this.f70608f;
                    if (gVar != null) {
                        gVar.onViewCreateFail(1005);
                        return;
                    }
                    return;
                }
                if (MosaicManager.this.f70590d != null) {
                    MosaicManager.this.f70590d.a("initMosaicViewJsEvaluateFinishCallJs", null);
                }
                this.f70609g.registerActivityCallback();
                this.f70609g.callJsOnSizeChanged(this.f70607e.getRootViewWidth(), this.f70607e.getRootViewHeight(), true);
                this.f70609g.updateAdData(template.b(), null, true);
                this.f70609g.updateTemplate(template, this.f70608f, true);
                if (MosaicManager.this.l()) {
                    com.tencent.ams.mosaic.utils.f.e("MosaicManager", "mosaic_performance java call render template end, coast:" + (SystemClock.elapsedRealtime() - j3) + "ms");
                }
            } catch (Throwable th5) {
                if (MosaicManager.this.f70590d != null) {
                    MosaicManager.this.f70590d.a("initMosaicViewJsEvaluateFinishCallJsCatch", th5.getMessage());
                }
                com.tencent.ams.mosaic.utils.f.i("MosaicManager", "mosaicView updateTemplate failed", th5);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface d {
        void onEngineCreateFail(int i3);

        void onEngineCreateStart();

        void onEngineCreated(com.tencent.ams.mosaic.jsengine.a aVar);

        void onEngineInjectStart(com.tencent.ams.mosaic.jsengine.a aVar);

        void onSoLoadFail(int i3);

        void onSoLoadStart();

        void onSoLoadSuccess(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private abstract class e implements a.InterfaceC0686a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f70611a;

        e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MosaicManager.this, i3);
            } else {
                this.f70611a = i3;
            }
        }

        abstract void a(String str);

        abstract void b();

        @Override // com.tencent.ams.mosaic.jsengine.a.InterfaceC0686a
        public void onFail(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            com.tencent.ams.mosaic.utils.f.h("MosaicManager", "evaluate '" + str + "' success");
            a(str);
        }

        @Override // com.tencent.ams.mosaic.jsengine.a.InterfaceC0686a
        public void onSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            com.tencent.ams.mosaic.utils.f.e("MosaicManager", "evaluate '" + str + "' success");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("createJSEngine MosaicJsEvaluateListener onSuccess before finish: ");
            sb5.append(this.f70611a);
            com.tencent.ams.mosaic.utils.f.e("MosaicManager", sb5.toString());
            int i3 = this.f70611a - 1;
            this.f70611a = i3;
            if (i3 == 0) {
                b();
            }
            com.tencent.ams.mosaic.utils.f.e("MosaicManager", "createJSEngine MosaicJsEvaluateListener onSuccess after finish: " + this.f70611a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface f {
        void a(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface g {
        void onViewCreateFail(int i3);

        void onViewCreateStart();

        void onViewCreated(MosaicView mosaicView);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15584);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f70586e = new MosaicManager();
        }
    }

    MosaicManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f70589c = new CopyOnWriteArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, k kVar, com.tencent.ams.mosaic.d dVar, g gVar) {
        f fVar = this.f70590d;
        if (fVar != null) {
            fVar.a("buildMosaicView", null);
        }
        if (dVar == null) {
            if (gVar != null) {
                gVar.onViewCreateFail(1007);
                return;
            }
            return;
        }
        if (kVar != null && (!dVar.isRequiredTemplate() || !TextUtils.isEmpty(kVar.d()))) {
            com.tencent.ams.mosaic.jsengine.a jSEngine = dVar.getJSEngine();
            if (jSEngine == null) {
                com.tencent.ams.mosaic.utils.f.a("MosaicManager", "buildMosaicView, no engine.");
                if (gVar != null) {
                    gVar.onViewCreateFail(1008);
                    return;
                }
                return;
            }
            k(context, jSEngine, dVar, gVar);
            return;
        }
        com.tencent.ams.mosaic.utils.f.h("MosaicManager", "buildMosaicView failed: invalid template, please check");
        if (gVar != null) {
            gVar.onViewCreateFail(1005);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(@NonNull Context context, List<j> list, d dVar) {
        this.f70587a = context.getApplicationContext();
        if (!QuickJSSoLoader.getInstance().isSupportQuickJS()) {
            if (dVar != null) {
                dVar.onEngineCreateFail(1010);
                return;
            }
            return;
        }
        if (com.tencent.ams.mosaic.f.k().u()) {
            list = DebugUtils.d().f();
            com.tencent.ams.mosaic.utils.f.e("MosaicManager", "createJSEngine DebugUtils.getInstance().readCommonJs :" + list);
        }
        if (list != null && !list.isEmpty()) {
            QuickJSEngine quickJSEngine = new QuickJSEngine(context);
            com.tencent.ams.mosaic.utils.f.e("MosaicManager", "createJSEngine commonJsList.size(): " + list.size());
            b bVar = new b(list.size(), dVar, quickJSEngine);
            if (dVar != null) {
                dVar.onEngineInjectStart(quickJSEngine);
            }
            if (com.tencent.ams.mosaic.f.k().w()) {
                quickJSEngine.Q(context);
            }
            for (j jVar : list) {
                if (jVar != null) {
                    quickJSEngine.r(jVar.f70653a, jVar.f70654b, bVar);
                }
            }
            return;
        }
        com.tencent.ams.mosaic.utils.f.h("MosaicManager", "createJSEngine failed: jsContentList is empty");
        if (dVar != null) {
            dVar.onEngineCreateFail(1002);
        }
    }

    public static MosaicManager j() {
        return f70586e;
    }

    private void k(Context context, com.tencent.ams.mosaic.jsengine.a aVar, com.tencent.ams.mosaic.d dVar, g gVar) {
        long j3;
        boolean z16;
        a.InterfaceC0686a interfaceC0686a;
        f fVar = this.f70590d;
        if (fVar != null) {
            fVar.a("initMosaicView", null);
        }
        com.tencent.ams.mosaic.utils.f.a("MosaicManager", "initMosaicView start");
        if (aVar == null) {
            com.tencent.ams.mosaic.utils.f.h("MosaicManager", "createMosaicView failed: js engine create failed");
            if (gVar != null) {
                gVar.onViewCreateFail(1006);
                return;
            }
            return;
        }
        if (dVar == null) {
            com.tencent.ams.mosaic.utils.f.h("MosaicManager", "createMosaicView failed: paramsGetter is null");
            if (gVar != null) {
                gVar.onViewCreateFail(1007);
                return;
            }
            return;
        }
        k template = dVar.getTemplate();
        if (template == null) {
            com.tencent.ams.mosaic.utils.f.h("MosaicManager", "createMosaicView failed: template is null");
            if (gVar != null) {
                gVar.onViewCreateFail(1005);
                return;
            }
            return;
        }
        List<j> e16 = template.e();
        if (com.tencent.ams.mosaic.f.k().u()) {
            e16 = DebugUtils.d().j();
        }
        List<j> list = e16;
        if (l()) {
            j3 = SystemClock.elapsedRealtime();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        if (list != null) {
            f fVar2 = this.f70590d;
            if (fVar2 != null) {
                fVar2.a("initMosaicViewJsListNotNull", null);
            }
            MosaicView mosaicView = new MosaicView(context, "", -1, -1);
            mosaicView.setEngine(aVar);
            aVar.d().a(mosaicView);
            a.InterfaceC0686a interfaceC0686a2 = r7;
            a.InterfaceC0686a cVar = new c(list.size(), j16, dVar, gVar, mosaicView);
            try {
                aVar.h(MosaicConstants$JsProperty.PROP_COMPONENT_FACTORY, new ComponentFactory(context, aVar));
                aVar.h(MosaicConstants$JsProperty.PROP_ANIMATION_FACTORY, new com.tencent.ams.mosaic.jsengine.animation.a(context, aVar));
                aVar.h(MosaicConstants$JsProperty.PROP_ROOT_VIEW, mosaicView);
                Env env = new Env(context, aVar, mosaicView);
                mosaicView.setEnv(env);
                aVar.h(MosaicConstants$JsProperty.PROP_ENV, env);
                aVar.h(MosaicConstants$JsProperty.PROP_NATIVE_BRIDGE, new com.tencent.ams.mosaic.jsengine.common.c(aVar));
                aVar.h(MosaicConstants$JsProperty.PROP_THREAD, new MosaicThread(context, aVar));
                aVar.h("http", new Http(context, aVar));
                aVar.h(MosaicConstants$JsProperty.PROP_CONTROLS, new com.tencent.ams.mosaic.jsengine.common.controls.j(context, aVar, mosaicView));
                if (l()) {
                    com.tencent.ams.mosaic.utils.f.e("MosaicManager", "mosaic_performance inject js property end, coast:" + (SystemClock.elapsedRealtime() - j16) + "ms");
                }
                z16 = true;
            } catch (Throwable th5) {
                com.tencent.ams.mosaic.utils.f.i("MosaicManager", "initMosaicView failed", th5);
                z16 = false;
            }
            if (z16) {
                f fVar3 = this.f70590d;
                if (fVar3 != null) {
                    fVar3.a("initMosaicViewInjectEnvSuccess", null);
                }
                for (j jVar : list) {
                    if (jVar != null) {
                        interfaceC0686a = interfaceC0686a2;
                        aVar.r(jVar.f70653a, jVar.f70654b, interfaceC0686a);
                    } else {
                        interfaceC0686a = interfaceC0686a2;
                    }
                    interfaceC0686a2 = interfaceC0686a;
                }
                return;
            }
            f fVar4 = this.f70590d;
            if (fVar4 != null) {
                fVar4.a("initMosaicViewInjectEnvFail", null);
            }
            if (gVar != null) {
                gVar.onViewCreateFail(1004);
                return;
            }
            return;
        }
        f fVar5 = this.f70590d;
        if (fVar5 != null) {
            fVar5.a("initMosaicViewJsListNull", null);
        }
    }

    public void d(com.tencent.ams.mosaic.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar);
        } else if (aVar != null) {
            this.f70589c.add(aVar);
        }
    }

    public synchronized void f(Context context, List<j> list, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, list, dVar);
            return;
        }
        if (dVar != null) {
            dVar.onEngineCreateStart();
        }
        if (context == null) {
            com.tencent.ams.mosaic.utils.f.h("MosaicManager", "createJSEngine failed: null context");
            if (dVar != null) {
                dVar.onEngineCreateFail(1001);
            }
            return;
        }
        QuickJSSoLoader.getInstance().loadSo(context, new a(dVar, context, list));
    }

    public void g(Context context, com.tencent.ams.mosaic.d dVar, g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, dVar, gVar);
            return;
        }
        if (gVar != null) {
            gVar.onViewCreateStart();
        }
        if (context == null) {
            com.tencent.ams.mosaic.utils.f.h("MosaicManager", "createMosaicView failed: context must be not null");
            if (gVar != null) {
                gVar.onViewCreateFail(1001);
                return;
            }
            return;
        }
        if (dVar == null) {
            if (gVar != null) {
                gVar.onViewCreateFail(1007);
            }
        } else {
            k template = dVar.getTemplate();
            f fVar = this.f70590d;
            if (fVar != null) {
                fVar.a("createMosaicView", null);
            }
            MosaicUtils.G(new AnonymousClass4(context, template, dVar, gVar), true);
        }
    }

    public Context i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70587a;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f70588b;
    }

    public void m(com.tencent.ams.mosaic.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else if (aVar != null) {
            this.f70589c.remove(aVar);
        }
    }

    public void n(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fVar);
        } else {
            this.f70590d = fVar;
        }
    }
}
