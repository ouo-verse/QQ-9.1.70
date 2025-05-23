package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi.util.az;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ai;
import com.tencent.mobileqq.R;
import mqq.util.WeakReference;
import org.libpag.PAGImageView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSVerticalVideoOperationRightItemView extends com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b implements View.OnClickListener {
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> F;
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> G;
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> H;
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> I;
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> J;
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> K;
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> L;
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> M;
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> N;
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> P;
    private final Handler Q;
    private GestureDetector R;
    private com.tencent.biz.pubaccount.weishi.verticalvideo.data.j S;
    private int T;
    private boolean U;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements ai.c {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ai.c
        public void a() {
            com.tencent.biz.pubaccount.weishi.util.x.i("WSVerticalVideoOperationRightItemView", "onBigCardHide");
            WSVerticalVideoOperationRightItemView.this.b0(true);
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ai.c
        public void b() {
            com.tencent.biz.pubaccount.weishi.util.x.i("WSVerticalVideoOperationRightItemView", "onBigCardShow");
            WSVerticalVideoOperationRightItemView.this.b0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            com.tencent.biz.pubaccount.weishi.util.x.b("WSVerticalVideoOperationRightItemView", "itemView onDoubleTap");
            WSVerticalVideoOperationRightItemView.this.Z(motionEvent);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
            if (com.tencent.biz.pubaccount.weishi.verticalvideo.utils.b.i(motionEvent, WSVerticalVideoOperationRightItemView.this.S, WSVerticalVideoOperationRightItemView.this.D.getContext(), (WSVerticalBottomSpeedPlayController) WSVerticalVideoOperationRightItemView.this.L, (s) WSVerticalVideoOperationRightItemView.this.F, WSVerticalVideoOperationRightItemView.this.f82125i.getPresenter().hashCode())) {
                WSVerticalVideoOperationRightItemView.this.G();
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            com.tencent.biz.pubaccount.weishi.util.x.b("WSVerticalVideoOperationRightItemView", "itemView onSingleTapConfirmed");
            WSVerticalVideoOperationRightItemView.this.a0();
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            WSVerticalVideoOperationRightItemView.this.R.onTouchEvent(motionEvent);
            com.tencent.biz.pubaccount.weishi.verticalvideo.utils.b.k(motionEvent, (WSVerticalBottomSpeedPlayController) WSVerticalVideoOperationRightItemView.this.L, WSVerticalVideoOperationRightItemView.this.D.getContext(), WSVerticalVideoOperationRightItemView.this.f82125i.getPresenter().hashCode());
            return true;
        }
    }

    public WSVerticalVideoOperationRightItemView(Context context, au auVar) {
        super(context, auVar);
        this.Q = new Handler(Looper.getMainLooper());
    }

    private WSVerticalItemAtPopGuideController B() {
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.P;
        if (bVar instanceof WSVerticalItemAtPopGuideController) {
            return (WSVerticalItemAtPopGuideController) bVar;
        }
        return null;
    }

    private void F() {
        stSimpleMetaPerson stsimplemetaperson;
        stSimpleMetaFeed C = C();
        if (C == null || (stsimplemetaperson = C.poster) == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.G;
        if (bVar instanceof i) {
            ((i) bVar).w(stsimplemetaperson);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        WSVerticalItemAtPopGuideController B = B();
        if (B != null) {
            B.w();
        }
        m z16 = z();
        if (z16 != null) {
            z16.E();
        }
    }

    private void I() {
        if (this.D == null) {
            return;
        }
        this.R = new GestureDetector(this.D.getContext(), new b());
        this.D.setOnTouchListener(new c());
    }

    private void J() {
        int i3 = this.f82126m.i();
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.seb);
        ai aiVar = new ai(this.C, this.f82126m, i3);
        aiVar.r(viewStub);
        aiVar.J(new a());
        b(aiVar);
    }

    private void K() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f1181173_);
        aj ajVar = new aj(this.C, this.f82126m);
        this.N = ajVar;
        ajVar.r(viewStub);
        b(this.N);
    }

    private void L() {
        if (this.f82125i.getPresenter().t0() && this.P == null) {
            ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f11804733);
            WSVerticalItemAtPopGuideController wSVerticalItemAtPopGuideController = new WSVerticalItemAtPopGuideController(this.C, this);
            this.P = wSVerticalItemAtPopGuideController;
            wSVerticalItemAtPopGuideController.r(viewStub);
            b(this.P);
        }
    }

    private void M() {
        if (Y()) {
            ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f11805734);
            i iVar = new i(this.C, this.f82126m);
            this.G = iVar;
            iVar.r(viewStub);
            b(this.G);
        }
    }

    private void N() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f11806735);
        WSVerticalPageFragment wSVerticalPageFragment = this.f82125i;
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> a16 = ap.a(wSVerticalPageFragment, wSVerticalPageFragment.getFrom(), this.f82126m);
        this.H = a16;
        a16.r(viewStub);
        b(this.H);
    }

    private void O() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f11807736);
        n nVar = new n(this.C, this.f82126m);
        this.I = nVar;
        nVar.r(viewStub);
        b(this.I);
    }

    private void Q() {
        if (this.f82125i.getPresenter().t0()) {
            ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f11809738);
            m mVar = new m(this.C, this);
            this.K = mVar;
            mVar.r(viewStub);
            b(this.K);
        }
    }

    private void R() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f11810739);
        WSVerticalBottomSpeedPlayController wSVerticalBottomSpeedPlayController = new WSVerticalBottomSpeedPlayController(this.C);
        this.L = wSVerticalBottomSpeedPlayController;
        wSVerticalBottomSpeedPlayController.r(viewStub);
        b(this.L);
    }

    private void S() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f1182273k);
        WSVerticalItemSpeedPlayGuideController wSVerticalItemSpeedPlayGuideController = new WSVerticalItemSpeedPlayGuideController(this.C, this);
        this.M = wSVerticalItemSpeedPlayGuideController;
        wSVerticalItemSpeedPlayGuideController.r(viewStub);
        b(this.M);
    }

    private void T() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f1182073i);
        s sVar = new s(this.C, this.f82126m);
        this.F = sVar;
        sVar.r(viewStub);
        b(this.F);
    }

    private void U() {
        if (this.f82125i.getPresenter().U()) {
            ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f1182473m);
            ag agVar = new ag(this.C, this.f82126m);
            agVar.r(viewStub);
            b(agVar);
        }
    }

    private void V() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f1182373l);
        u uVar = new u(this.C, this.f82126m);
        uVar.r(viewStub);
        b(uVar);
    }

    private void W() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f1182773p);
        ak akVar = new ak(this.C, this.f82126m);
        akVar.r(viewStub);
        b(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(MotionEvent motionEvent) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = this.S;
        if (jVar == null || jVar.e() == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.F;
        if (bVar instanceof s) {
            ((s) bVar).P(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        if (i() instanceof ah) {
            ((ah) i()).F();
        }
    }

    private void f0() {
        stSimpleMetaFeed C = C();
        if (C == null || C.poster == null) {
            return;
        }
        ((i) this.G).h();
        com.tencent.biz.pubaccount.weishi.util.x.j("WSVerticalVideoOperationRightItemView", "[WSVerticalVideoOperationRightItemView.java][updateFollowBtnUI] title:" + C.feed_desc);
    }

    public com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> A() {
        return this.I;
    }

    public stSimpleMetaFeed C() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = this.S;
        if (jVar != null) {
            return jVar.e();
        }
        return null;
    }

    public com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> D() {
        return this.F;
    }

    public com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> E() {
        return this.H;
    }

    public void H(boolean z16) {
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.F;
        if (bVar instanceof s) {
            ((s) bVar).Z(z16);
        }
    }

    public void P() {
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f11808737);
        p pVar = new p(this.C, this.f82126m);
        this.J = pVar;
        pVar.r(viewStub);
        b(this.J);
    }

    public boolean X() {
        return this.U;
    }

    public boolean Y() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void a() {
        super.a();
        O();
        Q();
        R();
        T();
        W();
        K();
        V();
        M();
        P();
        N();
        U();
        J();
        I();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void c() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = this.S;
        if (jVar == null || jVar.e() == null) {
            return;
        }
        k00.e.e().g(this.S.e().f25129id);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void d() {
        j10.a aVar = new j10.a();
        aVar.f409063a = C();
        aVar.f409065c = 2;
        aVar.f409066d = this.T;
        aVar.f409067e = com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(this.f82125i.getFrom());
        aVar.f409068f = this.f82125i.getPlayScene();
        aVar.f409069g = "more_operations";
        aVar.b(this.f82125i);
        az.A(this.C, aVar);
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.N(this.f82125i.getFrom(), this.f82125i.getPlayScene(), C());
    }

    public void d0() {
        if (this.M == null) {
            S();
        }
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.M;
        if (bVar instanceof WSVerticalItemSpeedPlayGuideController) {
            ((WSVerticalItemSpeedPlayGuideController) bVar).v();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void f(int i3) {
        super.f(i3);
        G();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b
    public void o(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        this.S = jVar;
        p(jVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.p5a || id5 == R.id.f219502e) {
            G();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void onPageSelected(int i3) {
        super.onPageSelected(i3);
        this.U = false;
        F();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    /* renamed from: q */
    public void setData(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        super.setData(jVar);
        this.S = jVar;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void setPosition(int i3) {
        super.setPosition(i3);
        this.T = i3;
    }

    public m z() {
        return (m) this.K;
    }

    public void c0() {
        this.U = true;
        L();
        WSVerticalItemAtPopGuideController B = B();
        if (B != null) {
            this.Q.removeCallbacksAndMessages(null);
            B.z();
            m z16 = z();
            if (z16 != null) {
                z16.I(new WSPAGViewListener(this));
                o10.a.f421718a.l();
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void e(int i3) {
        if (i3 == 0) {
            com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.F;
            if (bVar instanceof s) {
                ((s) bVar).V();
                return;
            }
        }
        if (i3 == 1 && (this.G instanceof i)) {
            f0();
            return;
        }
        if (i3 == 2) {
            com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar2 = this.F;
            if (bVar2 instanceof s) {
                ((s) bVar2).U();
                return;
            }
        }
        if (i3 == 3) {
            ((s) this.F).f0();
            return;
        }
        if (i3 == 4) {
            com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar3 = this.J;
            if (bVar3 instanceof p) {
                ((p) bVar3).u(0);
                return;
            }
        }
        if (i3 == 5) {
            com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar4 = this.J;
            if (bVar4 instanceof p) {
                ((p) bVar4).u(8);
                return;
            }
        }
        if (i3 == 6 && (this.F instanceof s) && com.tencent.biz.pubaccount.weishi.verticalvideo.c.f81916a.f()) {
            ((s) this.F).Y();
        }
    }

    public void b0(boolean z16) {
        int i3 = z16 ? 0 : 8;
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.I;
        if (bVar != null) {
            bVar.l(i3);
        }
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar2 = this.J;
        if (bVar2 != null) {
            bVar2.l(i3);
        }
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar3 = this.N;
        if (bVar3 != null) {
            bVar3.l(i3);
        }
    }

    public void e0(boolean z16) {
        int i3 = z16 ? 8 : 0;
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.F;
        if (bVar instanceof s) {
            ((s) bVar).d0(z16);
        }
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar2 = this.G;
        if (bVar2 != null) {
            bVar2.l(i3);
        }
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar3 = this.I;
        if (bVar3 != null) {
            bVar3.l(i3);
        }
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar4 = this.J;
        if (bVar4 != null) {
            bVar4.l(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class WSPAGViewListener implements PAGImageView.PAGImageViewListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<WSVerticalVideoOperationRightItemView> f82096d;

        public WSPAGViewListener(WSVerticalVideoOperationRightItemView wSVerticalVideoOperationRightItemView) {
            this.f82096d = new WeakReference<>(wSVerticalVideoOperationRightItemView);
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationEnd(PAGImageView pAGImageView) {
            WSVerticalVideoOperationRightItemView wSVerticalVideoOperationRightItemView;
            if (o10.a.f421718a.b() >= 0 && (wSVerticalVideoOperationRightItemView = this.f82096d.get()) != null) {
                wSVerticalVideoOperationRightItemView.Q.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalVideoOperationRightItemView.WSPAGViewListener.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        WSVerticalVideoOperationRightItemView wSVerticalVideoOperationRightItemView2 = (WSVerticalVideoOperationRightItemView) WSPAGViewListener.this.f82096d.get();
                        if (wSVerticalVideoOperationRightItemView2 != null) {
                            wSVerticalVideoOperationRightItemView2.G();
                            com.tencent.biz.pubaccount.weishi.util.x.f("WSVerticalVideoOperationRightItemView", "[WSVerticalVideoOperationRightItemView.java][onAnimationEnd] hideAtGuideView!");
                        }
                    }
                }, r5 * 1000);
            }
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationCancel(PAGImageView pAGImageView) {
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationRepeat(PAGImageView pAGImageView) {
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationStart(PAGImageView pAGImageView) {
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationUpdate(PAGImageView pAGImageView) {
        }
    }
}
