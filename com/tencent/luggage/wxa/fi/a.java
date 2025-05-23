package com.tencent.luggage.wxa.fi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.p;
import com.tencent.luggage.wxa.kj.c0;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.luggage.wxa.qc.b;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.luggage.wxa.xd.g1;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.xd.l;
import com.tencent.luggage.wxa.xd.m;
import com.tencent.luggage.wxa.xd.o;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends LinearLayout implements f {

    /* renamed from: e, reason: collision with root package name */
    public static volatile int f126187e;

    /* renamed from: a, reason: collision with root package name */
    public final v f126188a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f126189b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f126190c;

    /* renamed from: d, reason: collision with root package name */
    public c0 f126191d;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.fi.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6218a implements Runnable {
        public RunnableC6218a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("MicroMsg.AppBrandKeyBoardComponentView", "clear all views runnable");
            if (a.this.f126191d != null) {
                a.this.f126191d.d();
            }
            if (a.this.f126189b != null) {
                a.this.f126189b.removeAllViews();
            }
        }
    }

    public a(Context context, v vVar) {
        super(context);
        this.f126190c = new RunnableC6218a();
        this.f126188a = vVar;
        this.f126189b = this;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public l a(Class cls) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void b(g.b bVar) {
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public m c(Class cls) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.f
    public boolean d() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public String getAppId() {
        return this.f126188a.getAppId();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public b getAppState() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public /* synthetic */ com.tencent.luggage.wxa.dq.a getAsyncHandler() {
        return q41.a.c(this);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public int getComponentId() {
        return hashCode();
    }

    @Override // com.tencent.luggage.wxa.xd.f
    public View getContentView() {
        return this.f126189b;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    @Nullable
    public r getDialogContainer() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    @Nullable
    public com.tencent.luggage.wxa.rc.r getFileSystem() {
        return null;
    }

    public f.a getGlobalCustomViewContainer() {
        if (getRuntime().R() != null) {
            return getRuntime().R();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    @Nullable
    public d.c getInterceptor() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public /* synthetic */ g1 getInvokeCostManager() {
        return q41.a.d(this);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public j getJsRuntime() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public /* synthetic */ LifecycleOwner getLifecycleOwner() {
        return q41.a.e(this);
    }

    public FrameLayout getPageArea() {
        return null;
    }

    public int getRootContainerViewId() {
        return f126187e;
    }

    public com.tencent.luggage.wxa.ic.g getRuntime() {
        return this.f126188a.getRuntime();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public boolean isRunning() {
        if (getRuntime() != null && !getRuntime().t0()) {
            return true;
        }
        return false;
    }

    public void setRootContainerViewId(int i3) {
        f126187e = i3;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public /* synthetic */ o a(String str) {
        return q41.a.a(this, str);
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void b(g.c cVar) {
    }

    public void c() {
        w.d("MicroMsg.AppBrandKeyBoardComponentView", "destroy view containers");
        b();
        this.f126191d = null;
        this.f126189b = null;
    }

    @Override // com.tencent.luggage.wxa.xd.f
    public c0 getCustomViewContainer() {
        if (this.f126191d != null) {
            w.a("MicroMsg.AppBrandKeyBoardComponentView", "getCustomViewContainer, existed ViewContainer");
            return this.f126191d;
        }
        if (!(getContentView() instanceof ViewGroup)) {
            return null;
        }
        this.f126191d = new c0((ViewGroup) getContentView());
        w.a("MicroMsg.AppBrandKeyBoardComponentView", "getCustomViewContainer, create customViewContainer");
        return this.f126191d;
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void a(g.b bVar) {
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void b(g.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void a(g.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public /* synthetic */ void b(Runnable runnable) {
        q41.a.b(this, runnable);
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void a(g.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public boolean a(m mVar) {
        return false;
    }

    public void b() {
        w.d("MicroMsg.AppBrandKeyBoardComponentView", "clear views");
        com.tencent.luggage.wxa.tk.l.a(this.f126190c);
    }

    @Override // com.tencent.luggage.wxa.xd.f
    public f.a a(boolean z16) {
        if (z16) {
            return getGlobalCustomViewContainer();
        }
        return getCustomViewContainer();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.h1.b b(Class cls) {
        return this.f126188a.b(cls);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(String str, String str2, int[] iArr) {
        w.a("MicroMsg.AppBrandKeyBoardComponentView", "publish String event, String data, int[] dst");
        this.f126188a.a(str, str2);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(k0 k0Var, int[] iArr) {
        w.a("MicroMsg.AppBrandKeyBoardComponentView", "publish JsApiEvent event, int[] dst");
        k0Var.setContext(this.f126188a, getComponentId()).dispatch();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(int i3, String str) {
        this.f126188a.a(i3, str);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public boolean a(String str, p pVar) {
        return this.f126188a.a(str, pVar);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(k0 k0Var) {
        this.f126188a.a(k0Var.getName(), k0Var.getData());
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(String str, String str2) {
        this.f126188a.a(str, str2);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(String str, String str2, int i3) {
        this.f126188a.a(str, str2, i3);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(Runnable runnable) {
        this.f126188a.a(runnable);
    }

    public void setEvalInterceptor(d.a aVar) {
    }

    public void setInterceptor(d.c cVar) {
    }
}
