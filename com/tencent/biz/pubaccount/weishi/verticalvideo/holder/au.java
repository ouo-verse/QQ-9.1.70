package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi.player.i;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class au extends e<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> {

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.biz.pubaccount.weishi.player.e f82114h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.biz.pubaccount.weishi.player.a f82115i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements i.c {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.i.c
        public void a(int i3, int i16, int i17) {
            au.this.v(i17);
        }
    }

    public au(ViewGroup viewGroup, int i3, int i16, WSVerticalPageFragment wSVerticalPageFragment) {
        super(viewGroup, i3, i16, wSVerticalPageFragment);
    }

    private int h(stSimpleMetaFeed stsimplemetafeed) {
        FrameLayout c16 = c();
        View l3 = l();
        stMetaUgcVideoSeg stmetaugcvideoseg = stsimplemetafeed.video;
        i.d dVar = new i.d(c16, l3, stmetaugcvideoseg.width, stmetaugcvideoseg.height, k(), i());
        int m3 = m(stsimplemetafeed);
        com.tencent.biz.pubaccount.weishi.util.x.j("WSVerticalVideoHolder", "[WSVerticalVideoHolder.java][calculatePlayerLayoutRatio] videoScaleType:" + m3 + ", " + dVar.toString());
        if (m3 == -1) {
            return com.tencent.biz.pubaccount.weishi.player.i.f(dVar);
        }
        if (m3 == 1) {
            return com.tencent.biz.pubaccount.weishi.player.i.g(this.f82128e.getBaseActivity(), dVar);
        }
        if (m3 != 2) {
            return com.tencent.biz.pubaccount.weishi.player.i.g(this.f82128e.getBaseActivity(), dVar);
        }
        return com.tencent.biz.pubaccount.weishi.player.i.h(this.f82128e.getBaseActivity(), dVar, new a());
    }

    private View j() {
        Object obj = this.f82127d;
        if (obj instanceof b) {
            return ((b) obj).g();
        }
        return null;
    }

    private View l() {
        Object obj = this.f82127d;
        if (obj instanceof b) {
            return ((b) obj).j();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i3) {
        View j3 = j();
        if (j3 == null) {
            return;
        }
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            j3.setVisibility(8);
        } else {
            j3.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e
    public void d(int i3) {
        WSVerticalPageFragment wSVerticalPageFragment = this.f82128e;
        if (wSVerticalPageFragment != null && wSVerticalPageFragment.U0() != null) {
            this.f82128e.U0().R0(o());
            this.f82128e.U0().Q0(o());
        }
        WSVerticalPageFragment wSVerticalPageFragment2 = this.f82128e;
        if (wSVerticalPageFragment2 != null) {
            wSVerticalPageFragment2.Fi(q());
            this.f82128e.Ei(p());
            this.f82128e.wi(i3 + 1);
        }
        com.tencent.biz.pubaccount.weishi.baseui.c<T> cVar = this.f82127d;
        if (cVar != 0) {
            cVar.onPageSelected(i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e
    public void e(int i3) {
        com.tencent.biz.pubaccount.weishi.baseui.c<T> cVar = this.f82127d;
        if (cVar != 0) {
            cVar.f(i3);
            this.f82128e.oi();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e, com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void bindData(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        super.bindData(jVar);
        com.tencent.biz.pubaccount.weishi.baseui.c<T> cVar = this.f82127d;
        if (cVar != 0) {
            cVar.setData(jVar);
        }
    }

    public int i() {
        return this.f82128e.getPresenter().k0();
    }

    public int k() {
        return this.f82128e.getPresenter().c0();
    }

    public int m(stSimpleMetaFeed stsimplemetafeed) {
        return com.tencent.biz.pubaccount.weishi.config.experiment.b.h().B();
    }

    public int n(stSimpleMetaFeed stsimplemetafeed) {
        return h(stsimplemetafeed);
    }

    protected boolean o() {
        return false;
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    public void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        com.tencent.biz.pubaccount.weishi.baseui.c<T> cVar = this.f82127d;
        if (cVar != 0) {
            cVar.c();
        }
    }

    protected boolean p() {
        return true;
    }

    protected boolean q() {
        return true;
    }

    public abstract void r();

    public abstract void s();

    public abstract void t();

    public void u() {
        com.tencent.biz.pubaccount.weishi.baseui.c<T> cVar = this.f82127d;
        if (cVar != 0) {
            cVar.d();
        }
    }
}
