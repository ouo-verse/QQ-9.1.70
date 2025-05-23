package da0;

import androidx.annotation.MainThread;
import com.tencent.biz.qqcircle.manager.diffres.QCircleActionType;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b<T extends QCircleBaseResPackage> {
    protected final fa0.d<T> C;
    protected fa0.d<T> F;

    /* renamed from: d, reason: collision with root package name */
    protected final String f393297d;

    /* renamed from: e, reason: collision with root package name */
    private final T f393298e;

    /* renamed from: f, reason: collision with root package name */
    private int f393299f = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f393300h = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f393301i = 0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f393302m = false;
    protected fa0.d<T> D = null;
    private final List<c<C10168b>> E = new CopyOnWriteArrayList();
    private final Map<a, WeakReference<a>> G = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(fa0.d dVar);
    }

    /* compiled from: P */
    /* renamed from: da0.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C10168b {

        /* renamed from: a, reason: collision with root package name */
        fa0.d f393303a;
    }

    public b(T t16) {
        if (t16 != null) {
            this.f393298e = t16;
            this.f393297d = t16.getClass().getSimpleName();
            t16.isDefaultRes = true;
            fa0.d<T> dVar = new fa0.d<>(t16);
            this.C = dVar;
            q(dVar);
            return;
        }
        throw new RuntimeException("please set defaultRes");
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, da0.b$b] */
    private c<C10168b> b(a aVar) {
        c<C10168b> cVar = new c<>(aVar);
        cVar.f393305b = new C10168b();
        this.E.add(cVar);
        return cVar;
    }

    private void c() {
        for (int i3 = 0; i3 < this.E.size(); i3++) {
            c<C10168b> cVar = this.E.get(i3);
            if (cVar.f393304a.get() == null) {
                QLog.d(this.f393297d, 1, "remove cache view:" + cVar);
                this.E.remove(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        a aVar;
        QLog.d(this.f393297d, 1, "notifyResChange call refresh view");
        fa0.d<T> dVar = this.F;
        for (Map.Entry<a, WeakReference<a>> entry : this.G.entrySet()) {
            if (entry.getValue() != null && (aVar = entry.getValue().get()) != null) {
                C10168b g16 = g(aVar);
                if (g16 != null) {
                    g16.f393303a = dVar;
                }
                aVar.a(dVar);
            }
        }
    }

    private void k() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: da0.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.j();
            }
        });
    }

    private void q(fa0.d<T> dVar) {
        this.F = dVar;
        k();
    }

    public T d() {
        return e().o();
    }

    public fa0.d<T> e() {
        return this.F;
    }

    public List<QCircleActionType> f() {
        List<QCircleActionType> resRefreshActionTypeList = this.C.o().getResRefreshActionTypeList();
        if (resRefreshActionTypeList == null) {
            return new ArrayList();
        }
        return resRefreshActionTypeList;
    }

    public C10168b g(a aVar) {
        for (int i3 = 0; i3 < this.E.size(); i3++) {
            c<C10168b> cVar = this.E.get(i3);
            a aVar2 = cVar.f393304a.get();
            if (aVar2 != null && aVar2 == aVar) {
                return cVar.f393305b;
            }
        }
        return null;
    }

    public synchronized void h() {
        if (this.f393298e.isAutoPreloadRes) {
            this.C.v();
        }
    }

    public boolean i() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= this.f393300h && currentTimeMillis <= this.f393301i) {
            return true;
        }
        return false;
    }

    @MainThread
    public void l(a aVar) {
        this.G.put(aVar, new WeakReference<>(aVar));
        fa0.d<T> dVar = this.F;
        C10168b g16 = g(aVar);
        if (g16 == null) {
            QLog.e(this.f393297d, 1, "please call registerView when view init !!!!");
            aVar.a(dVar);
        } else if (g16.f393303a != dVar) {
            g16.f393303a = dVar;
            QLog.d(this.f393297d, 4, "refresh view when registerResChangeCallBack " + aVar);
            aVar.a(dVar);
        }
    }

    @MainThread
    public void m(a aVar) {
        this.G.remove(aVar);
    }

    public boolean n() {
        QLog.d(this.f393297d, 4, "resetCurrentRes");
        boolean z16 = this.f393302m;
        boolean i3 = i();
        if (z16 != i3) {
            this.f393302m = i3;
            fa0.d<T> dVar = this.D;
            if (i3 && dVar != null) {
                q(dVar);
            } else {
                q(this.C);
            }
        }
        return i3;
    }

    @MainThread
    public void o(a aVar) {
        b(aVar);
        QLog.d(this.f393297d, 4, "add cache view " + aVar + ", size is :" + this.E.size());
        int i3 = this.f393299f + 1;
        this.f393299f = i3;
        if (i3 > 5) {
            this.f393299f = 0;
            c();
        }
    }

    public synchronized void p() {
        QLog.d(this.f393297d, 1, "reset");
        this.f393300h = 0L;
        this.f393301i = 0L;
        this.D = null;
        this.E.clear();
        this.F = this.C;
    }

    public synchronized void r(T t16) {
        QLog.d(this.f393297d, 1, "setDiffRes diffRes :" + t16);
        if (t16 == null) {
            return;
        }
        fa0.d<T> dVar = new fa0.d<>(t16);
        if (t16.isAutoPreloadRes) {
            QLog.d(this.f393297d, 1, "setDiffRes diffRes isAutoPreloadRes:" + t16.isAutoPreloadRes);
            dVar.v();
        }
        if (i()) {
            QLog.d(this.f393297d, 1, "setDiffRes diffRes to current use");
            q(dVar);
        }
        this.D = dVar;
    }

    public void s(long j3, long j16) {
        QLog.d(this.f393297d, 1, "set time startTime= " + j3 + ",endTime:" + j16);
        this.f393300h = j3;
        this.f393301i = j16;
        fa0.d<T> dVar = this.D;
        if (i() && dVar != null) {
            QLog.d(this.f393297d, 1, "setDiffRes diffRes to current use");
            q(dVar);
        }
    }
}
