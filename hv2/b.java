package hv2;

import android.app.Activity;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class b extends j {

    /* renamed from: a, reason: collision with root package name */
    private boolean f406396a;

    /* renamed from: b, reason: collision with root package name */
    private ListenerMgr<gv2.c> f406397b = new ListenerMgr<>();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements ListenerMgr.a<gv2.c> {
        a() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNotify(gv2.c cVar) {
            cVar.a();
        }
    }

    /* compiled from: P */
    /* renamed from: hv2.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C10477b implements ListenerMgr.a<gv2.c> {
        C10477b() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNotify(gv2.c cVar) {
            cVar.b();
        }
    }

    public abstract Activity a();

    public final void b() {
        this.f406396a = false;
        this.f406397b.b(new C10477b());
    }

    public final void c() {
        this.f406396a = true;
        this.f406397b.b(new a());
    }

    public final void d(gv2.c cVar) {
        this.f406397b.a(cVar);
    }

    public final void e(gv2.c cVar) {
        this.f406397b.c(cVar);
    }
}
