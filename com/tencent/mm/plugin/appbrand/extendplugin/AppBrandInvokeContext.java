package com.tencent.mm.plugin.appbrand.extendplugin;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.luggage.wxa.xd.v;
import com.tencent.luggage.wxa.z7.c;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AppBrandInvokeContext implements com.tencent.luggage.wxa.z7.c {

    /* renamed from: i, reason: collision with root package name */
    private static final String f151955i = "MicroMsg.AppBrand.AppBrandInvokeContext";

    /* renamed from: a, reason: collision with root package name */
    private final int f151956a;

    /* renamed from: b, reason: collision with root package name */
    private final JSONObject f151957b;

    /* renamed from: c, reason: collision with root package name */
    private final o f151958c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<d> f151959d;

    /* renamed from: e, reason: collision with root package name */
    private final String f151960e;

    /* renamed from: f, reason: collision with root package name */
    private g.d f151961f;

    /* renamed from: g, reason: collision with root package name */
    private g.b f151962g;

    /* renamed from: h, reason: collision with root package name */
    private g.c f151963h;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements g.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.a f151967a;

        public a(c.a aVar) {
            this.f151967a = aVar;
        }

        @Override // com.tencent.luggage.wxa.xd.g.d
        public void onForeground() {
            w.d(AppBrandInvokeContext.f151955i, "onForeground");
            c.a aVar = this.f151967a;
            if (aVar != null) {
                aVar.onForeground();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements g.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.a f151969a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f151970b;

        public b(c.a aVar, d dVar) {
            this.f151969a = aVar;
            this.f151970b = dVar;
        }

        @Override // com.tencent.luggage.wxa.xd.g.b
        public void onBackground() {
            w.d(AppBrandInvokeContext.f151955i, "onBackground");
            c.a aVar = this.f151969a;
            if (aVar != null) {
                aVar.onBackground(com.tencent.luggage.wxa.ph.b.a(this.f151970b.getAppId()));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements g.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.a f151972a;

        public c(c.a aVar) {
            this.f151972a = aVar;
        }

        @Override // com.tencent.luggage.wxa.xd.g.c
        public void onDestroy() {
            c.a aVar = this.f151972a;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public AppBrandInvokeContext(int i3, JSONObject jSONObject, d dVar, o oVar) {
        this.f151956a = i3;
        this.f151957b = jSONObject;
        this.f151959d = new WeakReference<>(dVar);
        this.f151958c = oVar;
        this.f151960e = dVar.getAppId();
    }

    public void b(c.a aVar) {
    }

    @Override // com.tencent.luggage.wxa.z7.c
    public String c() {
        o oVar = this.f151958c;
        if (oVar != null) {
            return oVar.getName();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.z7.c
    public void d() {
        d dVar = this.f151959d.get();
        if (dVar instanceof f) {
            w.d(f151955i, "removeLifecycleListener");
            f fVar = (f) dVar;
            g.d dVar2 = this.f151961f;
            if (dVar2 != null) {
                fVar.a(dVar2);
                this.f151961f = null;
            }
            g.b bVar = this.f151962g;
            if (bVar != null) {
                fVar.b(bVar);
                this.f151962g = null;
            }
            g.c cVar = this.f151963h;
            if (cVar != null) {
                fVar.b(cVar);
                this.f151963h = null;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.z7.c
    @Nullable
    public d e() {
        return this.f151959d.get();
    }

    public int f() {
        return this.f151956a;
    }

    public JSONObject g() {
        return this.f151957b;
    }

    @Override // com.tencent.luggage.wxa.z7.c
    public String getAppId() {
        return this.f151960e;
    }

    @Override // com.tencent.luggage.wxa.z7.c
    public Context getContext() {
        d dVar = this.f151959d.get();
        if (dVar != null) {
            return dVar.getContext();
        }
        return null;
    }

    public o h() {
        return this.f151958c;
    }

    public boolean i() {
        return this.f151958c instanceof com.tencent.luggage.wxa.ph.d;
    }

    @Override // com.tencent.luggage.wxa.z7.c
    public JSONObject a() {
        JSONObject jSONObject = this.f151957b;
        return jSONObject != null ? jSONObject : new JSONObject();
    }

    @Override // com.tencent.luggage.wxa.z7.c
    public boolean b() {
        return this.f151958c instanceof v;
    }

    @Override // com.tencent.luggage.wxa.z7.c
    public String a(String str) {
        o oVar;
        d dVar = this.f151959d.get();
        if (dVar == null || (oVar = this.f151958c) == null) {
            return null;
        }
        dVar.a(this.f151956a, oVar.makeReturnJson(str));
        return null;
    }

    @Override // com.tencent.luggage.wxa.z7.c
    public String a(@NonNull com.tencent.luggage.wxa.af.c cVar) {
        o oVar;
        d dVar = this.f151959d.get();
        if (dVar == null || (oVar = this.f151958c) == null) {
            return null;
        }
        dVar.a(this.f151956a, oVar.makeReturnJson(cVar));
        return null;
    }

    @Override // com.tencent.luggage.wxa.z7.c
    public String a(String str, @NonNull com.tencent.luggage.wxa.af.c cVar) {
        o oVar;
        d dVar = this.f151959d.get();
        if (dVar == null || (oVar = this.f151958c) == null) {
            return null;
        }
        dVar.a(this.f151956a, oVar.makeReturnJson(str, cVar));
        return null;
    }

    @Override // com.tencent.luggage.wxa.z7.c
    public String a(String str, Map<String, ? extends Object> map) {
        o oVar;
        d dVar = this.f151959d.get();
        if (dVar == null || (oVar = this.f151958c) == null) {
            return null;
        }
        dVar.a(this.f151956a, oVar.makeReturnJson(str, map));
        return null;
    }

    @Override // com.tencent.luggage.wxa.z7.c
    public String a(@NonNull com.tencent.luggage.wxa.af.c cVar, Map<String, ?> map) {
        o oVar;
        d dVar = this.f151959d.get();
        if (dVar == null || (oVar = this.f151958c) == null) {
            return null;
        }
        dVar.a(this.f151956a, oVar.makeReturnJson(cVar, (Map<String, ? extends Object>) map));
        return null;
    }

    public String a(String str, @NonNull com.tencent.luggage.wxa.af.c cVar, Map<String, ?> map) {
        o oVar;
        d dVar = this.f151959d.get();
        if (dVar == null || (oVar = this.f151958c) == null) {
            return null;
        }
        dVar.a(this.f151956a, oVar.makeReturnJson(str, cVar, (Map<String, ? extends Object>) map));
        return null;
    }

    @Override // com.tencent.luggage.wxa.z7.c
    public void a(final c.a aVar) {
        final d dVar = this.f151959d.get();
        if (dVar instanceof f) {
            w.d(f151955i, "addLifecycleListener");
            f fVar = (f) dVar;
            this.f151961f = new a(aVar);
            this.f151962g = new b(aVar, dVar);
            this.f151963h = new c(aVar);
            fVar.b(this.f151961f);
            fVar.a(this.f151962g);
            fVar.a(this.f151963h);
            return;
        }
        final LifecycleOwner lifecycleOwner = dVar.getLifecycleOwner();
        if (lifecycleOwner != null) {
            Runnable runnable = new Runnable() { // from class: com.tencent.mm.plugin.appbrand.extendplugin.a
                @Override // java.lang.Runnable
                public final void run() {
                    AppBrandInvokeContext.this.a(lifecycleOwner, aVar, dVar);
                }
            };
            if (c0.b()) {
                runnable.run();
            } else {
                c0.a(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LifecycleOwner lifecycleOwner, final c.a aVar, final d dVar) {
        lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext.4
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroyed() {
                c.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onDestroy();
                }
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            public void onPaused() {
                c.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onBackground(com.tencent.luggage.wxa.ph.b.a(dVar.getAppId()));
                }
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public void onResumed() {
                c.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onForeground();
                }
            }
        });
    }
}
