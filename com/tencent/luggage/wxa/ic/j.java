package com.tencent.luggage.wxa.ic;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.joor.Reflect;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j extends WindowAndroidActivityImpl implements v {
    public com.tencent.luggage.wxa.kk.a C;
    public Class D;
    public com.tencent.luggage.wxa.ol.q G;
    public Application.ActivityLifecycleCallbacks H;

    /* renamed from: k, reason: collision with root package name */
    public FrameLayout f129867k;

    /* renamed from: l, reason: collision with root package name */
    public final LinkedList f129868l;

    /* renamed from: m, reason: collision with root package name */
    public final HashMap f129869m;
    public boolean E = false;
    public boolean F = false;
    public final z I = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f129870a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f129871b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f129872c;

        public a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.ic.g gVar2, Runnable runnable) {
            this.f129870a = gVar;
            this.f129871b = gVar2;
            this.f129872c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            String appId;
            com.tencent.luggage.wxa.ic.g gVar;
            if (!j.this.h(this.f129870a) && !j.this.g(this.f129870a)) {
                z16 = false;
            } else {
                z16 = true;
            }
            com.tencent.luggage.wxa.ic.g gVar2 = this.f129871b;
            if (gVar2 != null) {
                gVar2.b(this.f129870a.S(), (Object) null);
            } else {
                this.f129870a.b((Object) null);
            }
            this.f129872c.run();
            if (z16 && (gVar = this.f129871b) != null) {
                gVar.z();
                if (j.this.E) {
                    this.f129871b.A();
                }
            }
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(z16);
            com.tencent.luggage.wxa.ic.g gVar3 = this.f129871b;
            if (gVar3 == null) {
                appId = "null";
            } else {
                appId = gVar3.getAppId();
            }
            objArr[1] = appId;
            objArr[2] = Boolean.valueOf(j.this.E);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "removeImpl closeTask.run(), outIsTopOfStackBefore[%b], below.appId[%s], mIsActivityResumed[%b]", objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends z {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.ic.z
        public boolean a(KeyEvent keyEvent) {
            if (j.this.G != null) {
                return j.this.G.a(keyEvent);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements View.OnSystemUiVisibilityChangeListener {
        public c() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i3) {
            Activity a16;
            if (j.this.f129867k.isShown() && ViewCompat.isAttachedToWindow(j.this.f129867k) && Build.VERSION.SDK_INT >= 26 && (j.this.f129867k.getWindowSystemUiVisibility() & 2) == 0 && (a16 = com.tencent.luggage.wxa.bo.a.a(j.this.getContext())) != null && a16.getWindow() != null) {
                com.tencent.luggage.wxa.lo.f.a(a16.getWindow(), !com.tencent.luggage.wxa.lo.m.a(a16.getWindow().getNavigationBarColor()));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends com.tencent.luggage.wxa.tk.a {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.tk.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (j.this.j() == activity) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "onActivityDestroyed %s", activity.getLocalClassName());
                j.this.E();
            }
        }

        @Override // com.tencent.luggage.wxa.tk.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (j.this.j() == activity) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "onActivityPaused %s", activity.getLocalClassName());
                j.this.E = false;
                j.this.F = true;
                j.this.getOrientationHandler().onPause();
            }
        }

        @Override // com.tencent.luggage.wxa.tk.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (j.this.j() == activity) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "onActivityResumed %s", activity.getLocalClassName());
                j.this.E = true;
                j.this.F = false;
                j.this.getOrientationHandler().onResume();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f129877a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.fd.i f129878b;

        public e(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.fd.i iVar) {
            this.f129877a = gVar;
            this.f129878b = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.ol.q.a(j.this.j());
            if (this.f129877a == null) {
                j.this.m(this.f129878b.f125808a);
            }
            com.tencent.luggage.wxa.ic.g n3 = j.this.n(this.f129878b.f125808a);
            if (n3 == null) {
                j.this.b(this.f129877a, j.this.a(this.f129878b), this.f129878b);
            } else {
                j.this.a(this.f129877a, n3, this.f129878b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f129880a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f129881b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f129882c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ic.g f129884a;

            public a(com.tencent.luggage.wxa.ic.g gVar) {
                this.f129884a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                String appId;
                com.tencent.luggage.wxa.ic.g gVar;
                f.this.f129880a.K().setVisibility(8);
                j.this.f129868l.remove(f.this.f129880a);
                j.this.f129869m.put(f.this.f129880a.getAppId(), f.this.f129880a);
                com.tencent.luggage.wxa.ic.g gVar2 = this.f129884a;
                if (gVar2 != null) {
                    j.this.l(gVar2);
                    j.this.m(this.f129884a);
                }
                f.this.f129880a.y();
                if (j.this.E && (gVar = this.f129884a) != null) {
                    gVar.A();
                }
                Object[] objArr = new Object[3];
                objArr[0] = f.this.f129880a.getAppId();
                com.tencent.luggage.wxa.ic.g gVar3 = this.f129884a;
                if (gVar3 == null) {
                    appId = "null";
                } else {
                    appId = gVar3.getAppId();
                }
                objArr[1] = appId;
                objArr[2] = Boolean.valueOf(j.this.E);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "close run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", objArr);
                Runnable runnable = f.this.f129882c;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        public f(com.tencent.luggage.wxa.ic.g gVar, Object obj, Runnable runnable) {
            this.f129880a = gVar;
            this.f129881b = obj;
            this.f129882c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            String appId;
            if (!j.this.h(this.f129880a) && !j.this.g(this.f129880a)) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandRuntimeContainer", "close with appId(%s), not top of stack, ignore", this.f129880a.getAppId());
                return;
            }
            com.tencent.luggage.wxa.ic.g a16 = j.this.a(this.f129880a);
            if (a16 != null) {
                a16.b(this.f129880a.S(), this.f129881b);
            } else {
                this.f129880a.b(this.f129881b);
            }
            Object[] objArr = new Object[3];
            objArr[0] = this.f129880a.getAppId();
            if (a16 == null) {
                appId = "null";
            } else {
                appId = a16.getAppId();
            }
            objArr[1] = appId;
            objArr[2] = Boolean.valueOf(j.this.E);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "close before run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", objArr);
            j.this.a(a16, this.f129880a, (Runnable) new a(a16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.ic.g f16 = j.this.f();
            if (f16 != null) {
                f16.y();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.tencent.luggage.wxa.ic.g f16 = j.this.f();
                if (f16 != null) {
                    j.this.a(f16, true);
                    j.this.m(f16);
                    f16.A();
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandRuntimeContainer", e16, "doOnResume e=%s", e16);
                j.this.a(e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Exception f129888a;

        public i(Exception exc) {
            this.f129888a = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw this.f129888a;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ic.j$j, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6298j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f129890a;

        public RunnableC6298j(com.tencent.luggage.wxa.ic.g gVar) {
            this.f129890a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.h6.h.a(j.this.getContext());
            j.this.j(this.f129890a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f129892a;

        public k(com.tencent.luggage.wxa.ic.g gVar) {
            this.f129892a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "dl: removeImpl, cleanupOut.run(), appId[%s]", this.f129892a.getAppId());
            this.f129892a.a(j.this.I);
            this.f129892a.x();
            j.this.f129867k.removeView(this.f129892a.K());
            j.this.f129869m.remove(this.f129892a.getAppId());
            j.this.f129868l.remove(this.f129892a);
        }
    }

    public j(com.tencent.luggage.wxa.kk.a aVar, Class cls) {
        super.a(aVar.getContext());
        this.f129868l = new LinkedList();
        this.f129869m = new HashMap();
        FrameLayout container = aVar.getContainer();
        this.f129867k = container;
        this.C = aVar;
        this.D = cls;
        container.setOnSystemUiVisibilityChangeListener(new c());
        com.tencent.luggage.wxa.xj.g.a(j()).d();
        Application application = (Application) getContext().getApplicationContext();
        d dVar = new d();
        this.H = dVar;
        application.registerActivityLifecycleCallbacks(dVar);
    }

    public final boolean A() {
        if (this.G != null) {
            return true;
        }
        return false;
    }

    public final boolean B() {
        return this.E;
    }

    public void C() {
        com.tencent.luggage.wxa.ic.g f16 = f();
        if (f16 != null) {
            try {
                f16.I0();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandRuntimeContainer", "onBackPressed e = %s", e16);
                com.tencent.luggage.wxa.tn.c0.a(new i(e16));
            }
        }
    }

    public final void E() {
        if (this.H != null) {
            ((Application) getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.H);
            this.H = null;
        }
        getOrientationHandler().release();
        this.C = null;
    }

    public final Iterator F() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.f129868l);
        linkedList.addAll(this.f129869m.values());
        return linkedList.iterator();
    }

    public final Iterator G() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.f129868l);
        return linkedList.iterator();
    }

    public void a(Exception exc) {
    }

    public boolean g(com.tencent.luggage.wxa.ic.g gVar) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl, com.tencent.luggage.wxa.wj.c
    public final DisplayMetrics getVDisplayMetrics() {
        if (this.f129867k.isLaidOut()) {
            return super.a(this.f129867k.getMeasuredWidth(), this.f129867k.getMeasuredHeight());
        }
        return super.getVDisplayMetrics();
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl
    public boolean i() {
        return true;
    }

    public final void j(com.tencent.luggage.wxa.ic.g gVar) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "removeImpl entered appId[%s]", gVar.getAppId());
        k kVar = new k(gVar);
        if (!b(gVar)) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "removeImpl appId[%s], not in runtime stack, just cleanup", gVar.getAppId());
            kVar.run();
        } else {
            com.tencent.luggage.wxa.ic.g a16 = a(gVar);
            a(a16, gVar, (Runnable) new a(gVar, a16, kVar));
        }
    }

    public final void k(com.tencent.luggage.wxa.ic.g gVar) {
        if (gVar == null) {
            return;
        }
        gVar.a(this.I);
        this.f129868l.remove(gVar);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f129869m.remove(gVar.getAppId(), gVar);
        } else {
            this.f129869m.remove(gVar.getAppId());
        }
    }

    public final void l(com.tencent.luggage.wxa.ic.g gVar) {
        a(gVar, false);
    }

    public final void m(com.tencent.luggage.wxa.ic.g gVar) {
        this.f129868l.remove(gVar);
        this.f129868l.push(gVar);
        gVar.K().setVisibility(0);
        a((ViewGroup) gVar.K());
    }

    public com.tencent.luggage.wxa.ic.g n(String str) {
        Iterator it = this.f129868l.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.ic.g gVar = (com.tencent.luggage.wxa.ic.g) it.next();
            if (gVar.getAppId().equals(str)) {
                return gVar;
            }
        }
        return (com.tencent.luggage.wxa.ic.g) this.f129869m.get(str);
    }

    public void onPause() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "onPause tid = %d", Long.valueOf(Thread.currentThread().getId()));
        runOnUiThread(new g());
    }

    public void onResume() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "onResume tid = %d", Long.valueOf(Thread.currentThread().getId()));
        runOnUiThread(new h());
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl
    public final boolean q() {
        return this.F;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl, com.tencent.luggage.wxa.wj.c
    public boolean runInStandaloneTask() {
        return this.C.runInStandaloneTask();
    }

    public final void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else if (j() != null) {
            j().runOnUiThread(runnable);
        } else {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandRuntimeContainer", "runOnUiThread getActivity()==null");
            new com.tencent.luggage.wxa.tn.b0(Looper.getMainLooper()).a(runnable);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl, com.tencent.luggage.wxa.wj.c
    public void setWindowBackgroundColor(int i3, com.tencent.luggage.wxa.ic.g gVar) {
        super.setWindowBackgroundColor(i3, gVar);
        View view = (View) gVar.K().getParent();
        if (view != null) {
            view.setBackgroundColor(i3);
        }
    }

    public void t() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.f129868l);
        linkedList.addAll(this.f129869m.values());
        u();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.ic.g gVar = (com.tencent.luggage.wxa.ic.g) it.next();
            gVar.e(false);
            c(gVar);
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "cleanup");
        E();
    }

    public final void u() {
        m((String) null);
    }

    public final FrameLayout v() {
        return this.f129867k;
    }

    public final LinkedList w() {
        return new LinkedList(this.f129868l);
    }

    public final com.tencent.luggage.wxa.kk.a x() {
        return this.C;
    }

    public final boolean z() {
        int childCount = this.f129867k.getChildCount();
        if (childCount > 1) {
            return true;
        }
        if (childCount == 1 && this.G != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(com.tencent.luggage.wxa.ic.g gVar) {
        if (gVar.e0() == this && gVar == f() && !gVar.o0()) {
            if (q() || r()) {
                gVar.y();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ic.v
    public void e(final com.tencent.luggage.wxa.ic.g gVar) {
        gVar.c(new Runnable() { // from class: com.tencent.luggage.wxa.ic.aq
            @Override // java.lang.Runnable
            public final void run() {
                j.this.i(gVar);
            }
        });
    }

    @Override // com.tencent.luggage.wxa.ic.v
    public com.tencent.luggage.wxa.ic.g f() {
        return (com.tencent.luggage.wxa.ic.g) this.f129868l.peek();
    }

    public final boolean h(com.tencent.luggage.wxa.ic.g gVar) {
        return this.f129868l.peekFirst() == gVar;
    }

    @Override // com.tencent.luggage.wxa.ic.v
    public final void c(com.tencent.luggage.wxa.ic.g gVar) {
        if (gVar == null) {
            return;
        }
        runOnUiThread(new RunnableC6298j(gVar));
    }

    @Override // com.tencent.luggage.wxa.ic.v
    public final void d(com.tencent.luggage.wxa.ic.g gVar) {
        if (gVar == null) {
            return;
        }
        this.f129868l.remove(gVar);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f129869m.remove(gVar.getAppId(), gVar);
        } else {
            this.f129869m.remove(gVar.getAppId());
        }
        ViewParent parent = gVar.K().getParent();
        FrameLayout frameLayout = this.f129867k;
        if (parent == frameLayout) {
            frameLayout.removeView(gVar.K());
        }
    }

    public void f(com.tencent.luggage.wxa.ic.g gVar) {
        gVar.y();
    }

    public void b(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.ic.g gVar2, com.tencent.luggage.wxa.fd.i iVar) {
        gVar2.s(gVar);
        gVar2.b(iVar);
        this.f129868l.push(gVar2);
        a(gVar2.K());
        if (gVar != null) {
            gVar.y();
        }
        gVar2.F0();
    }

    public final void m(String str) {
        Iterator it = this.f129868l.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.ic.g gVar = (com.tencent.luggage.wxa.ic.g) it.next();
            if (str != null && str.equals(gVar.getAppId())) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, exclude appId(%s)", str);
            } else {
                it.remove();
                gVar.K().setVisibility(8);
                this.f129869m.put(gVar.getAppId(), gVar);
                gVar.L0();
                if (!gVar.s0()) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, rt(%s).initialized()=false, just destroy", gVar.getAppId());
                    j(gVar);
                } else if (gVar.B0()) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, rt(%s).isResumed()=true, make it pause", gVar.getAppId());
                    gVar.y();
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ic.v
    public void a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.fd.i iVar) {
        if (iVar == null) {
            return;
        }
        j().runOnUiThread(new e(gVar, iVar));
    }

    public com.tencent.luggage.wxa.ic.g a(com.tencent.luggage.wxa.fd.i iVar) {
        return (com.tencent.luggage.wxa.ic.g) Reflect.on((Class<?>) this.D).create(this).get();
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.ic.g gVar2, com.tencent.luggage.wxa.fd.i iVar) {
        l(gVar2);
        m(gVar2);
        gVar2.z();
        gVar2.s(gVar);
        gVar2.a(iVar);
        if (gVar != null) {
            gVar.y();
            gVar2.A();
        }
    }

    @Override // com.tencent.luggage.wxa.ic.v
    public boolean b(com.tencent.luggage.wxa.ic.g gVar) {
        return gVar != null && this.f129868l.contains(gVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl
    public void b(Configuration configuration) {
        LinkedList linkedList = this.f129868l;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((com.tencent.luggage.wxa.ic.g) it.next()).b(configuration);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ic.v
    public void a(com.tencent.luggage.wxa.ic.g gVar, Object obj, Runnable runnable) {
        Activity j3;
        if (gVar == null || (j3 = j()) == null) {
            return;
        }
        j3.runOnUiThread(new f(gVar, obj, runnable));
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.ic.g gVar2, Runnable runnable) {
        Object[] objArr = new Object[2];
        objArr[0] = gVar == null ? "null" : gVar.getAppId();
        objArr[1] = gVar2.getAppId();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "onRuntimeClose entered, in.appId[%s], out.appId[%s]", objArr);
        runnable.run();
    }

    @Override // com.tencent.luggage.wxa.ic.v
    public com.tencent.luggage.wxa.ic.g a(com.tencent.luggage.wxa.ic.g gVar) {
        if (gVar != null) {
            ListIterator listIterator = this.f129868l.listIterator();
            boolean z16 = false;
            while (listIterator.hasNext()) {
                com.tencent.luggage.wxa.ic.g gVar2 = (com.tencent.luggage.wxa.ic.g) listIterator.next();
                if (gVar2 == gVar) {
                    z16 = true;
                } else if (z16) {
                    return gVar2;
                }
            }
            if (z16) {
                return null;
            }
            throw new IllegalAccessError(String.format("Runtime not in stack %s", gVar.getAppId()));
        }
        throw new NullPointerException("Null runtime");
    }

    @Override // com.tencent.luggage.wxa.ic.v
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public final WindowAndroidActivityImpl h() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.ic.v
    public int a() {
        return this.f129868l.size();
    }

    public void a(int i3, String[] strArr, int[] iArr) {
        Iterator it = this.f129868l.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.rj.q.a(((com.tencent.luggage.wxa.ic.g) it.next()).getAppId(), i3, strArr, iArr, false);
        }
    }

    public final void a(com.tencent.luggage.wxa.ic.g gVar, boolean z16) {
        if (!this.f129868l.contains(gVar) || z16) {
            this.f129868l.remove(gVar);
            this.f129868l.push(gVar);
            if (this.f129867k.indexOfChild(gVar.K()) == -1) {
                a(gVar.K());
            }
            this.f129869m.remove(gVar.getAppId());
        }
    }

    public void a(com.tencent.luggage.wxa.ol.q qVar) {
        this.f129867k.removeView(qVar);
        this.f129867k.addView(qVar, this.f129867k.getChildCount(), new ViewGroup.LayoutParams(-1, -1));
        this.G = qVar;
        this.f129867k.requestChildFocus(qVar, qVar);
    }

    public final void a(com.tencent.luggage.wxa.il.g gVar) {
        int childCount = (A() && z()) ? this.f129867k.getChildCount() - 1 : 0;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntimeContainer", "attachRtViewToTree: name = [%s], index = [%d]", (String) gVar.getTag(), Integer.valueOf(childCount));
        if (gVar.getParent() != null) {
            if (!com.tencent.luggage.wxa.tn.e.f141559a) {
                ((ViewGroup) gVar.getParent()).removeAllViews();
            } else {
                throw new IllegalArgumentException("runtimeLayout's parent should be null");
            }
        }
        this.f129867k.addView(gVar, childCount);
        com.tencent.luggage.wxa.ol.q qVar = this.G;
        if (qVar != null) {
            if (qVar.getParent() == null) {
                this.f129867k.addView(this.G);
            }
            if (this.f129867k == this.G.getParent() && this.f129867k.indexOfChild(this.G) != this.f129867k.getChildCount() - 1) {
                this.f129867k.bringChildToFront(this.G);
            }
        }
        f().a(4, 1, this.I);
    }

    public final void a(ViewGroup viewGroup) {
        if (this.f129867k.indexOfChild(viewGroup) == -1) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandRuntimeContainer", "bringRtViewToTop: such runtime view does not exist");
            return;
        }
        this.f129867k.bringChildToFront(viewGroup);
        if (A()) {
            this.f129867k.bringChildToFront(this.G);
        }
    }
}
