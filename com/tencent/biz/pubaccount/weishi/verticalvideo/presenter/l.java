package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.event.WSItemExposeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ah;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import java.util.ArrayList;
import java.util.List;
import jz.f;

/* compiled from: P */
/* loaded from: classes32.dex */
public class l extends AbsWSVerticalPagePresenter {
    private Intent P;

    public l(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
    }

    private void T1(boolean z16, boolean z17, jz.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> cVar, long j3) {
        jz.f.d().c(z17, z16, "", 10, j3, new a(cVar, z16, z17));
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean A1() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean L() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> N(ArrayList arrayList) {
        return jz.f.d().e();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void T0(RecyclerView.ViewHolder viewHolder, int i3) {
        super.T0(viewHolder, i3);
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return;
        }
        if (this.P == null) {
            this.P = new Intent();
        }
        this.P.putExtra("key_feed_position", i3);
        this.P.putExtra("key_from", O0.getFrom());
        this.P.putExtra("key_play_scene", O0.getPlayScene());
        O0.qb(8193, this.P);
        wz.b.b().a(new WSItemExposeEvent(G0(i3)));
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean V() {
        WSPlayerManager U0;
        com.tencent.biz.pubaccount.weishi.player.e n06;
        boolean V = super.V();
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null || (U0 = O0.U0()) == null || (n06 = U0.n0()) == null) {
            return V;
        }
        n06.f81136l = null;
        n06.f81125a = null;
        jz.f.d().p(n06);
        WSVideoPlayEvent wSVideoPlayEvent = new WSVideoPlayEvent();
        wSVideoPlayEvent.mCurrentPosition = this.I;
        wz.b.b().a(wSVideoPlayEvent);
        return V;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void doOnPause() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (this.H && O0 != null) {
            x.b("WSVerticalForFollowPresenter", "onPause() back to follow page");
            au z16 = O0.getAdapter().z();
            if (z16 != null) {
                Object obj = z16.f82127d;
                if (obj instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) {
                    com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b bVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) obj;
                    if (bVar.i() instanceof ah) {
                        ((ah) bVar.i()).w(0, 100);
                    }
                }
            }
            com.tencent.biz.pubaccount.weishi.player.b.d().f(false);
            return;
        }
        super.doOnPause();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void l() {
        super.l();
        jz.f.d().p(null);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public int p(int i3) {
        return jz.f.d().f411219f.get(i3) + 1;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void s0() {
        super.s0();
        yz.i.f451583a.n(new yz.f());
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public com.tencent.biz.pubaccount.weishi.player.e w() {
        return jz.f.d().f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements f.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ jz.c f82269a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f82270b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f82271c;

        a(jz.c cVar, boolean z16, boolean z17) {
            this.f82269a = cVar;
            this.f82270b = z16;
            this.f82271c = z17;
        }

        @Override // jz.f.c
        public void a(boolean z16, List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z17) {
            jz.c cVar = this.f82269a;
            if (cVar != null) {
                cVar.d0(list, this.f82270b, this.f82271c, null);
            }
        }

        @Override // jz.f.c
        public void b(boolean z16, boolean z17, boolean z18, Object obj) {
            if (z18) {
                return;
            }
            jz.c cVar = this.f82269a;
            if (cVar != null) {
                cVar.i(-1, "task failed.", z16, z17);
            }
            l.this.i(-1, "task failed.", z16, z17);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean y0(boolean z16, boolean z17, String str) {
        if (z17) {
            return false;
        }
        T1(z16, false, this, System.currentTimeMillis());
        return true;
    }
}
