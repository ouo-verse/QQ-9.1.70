package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ah extends com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> {
    private FrameLayout C;
    private KandianUrlImageView D;
    private ProgressBar E;
    private TextView F;
    private View G;
    private View H;
    private au I;
    private WSVerticalPageFragment J;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ah.this.J();
            ah.this.D();
            ah.this.B();
        }
    }

    public ah(Context context, au auVar) {
        super(context);
        this.I = auVar;
        if (auVar != null) {
            this.J = auVar.f82128e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        au auVar;
        WSPlayerManager y16 = y();
        if (y16 == null || (auVar = this.I) == null) {
            return;
        }
        y16.L0(auVar.f82114h, false);
    }

    private boolean E() {
        com.tencent.biz.pubaccount.weishi.player.e eVar;
        WSPlayerWrapper wSPlayerWrapper;
        au auVar = this.I;
        return (auVar == null || (eVar = auVar.f82114h) == null || (wSPlayerWrapper = eVar.f81129e) == null || !wSPlayerWrapper.b0()) ? false : true;
    }

    private void G(boolean z16) {
        WSVerticalPageFragment wSVerticalPageFragment = this.J;
        if (wSVerticalPageFragment == null || wSVerticalPageFragment.getPresenter() == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.e0(this.J.getFrom(), this.J.getPlayScene(), this.f80411f, this.J.Th(), z16, this.J.getPresenter().h0());
    }

    private void H() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.f adapter;
        au z16;
        WSVerticalPageFragment wSVerticalPageFragment = this.J;
        if (wSVerticalPageFragment == null || (adapter = wSVerticalPageFragment.getAdapter()) == null || (z16 = adapter.z()) == null || !(this.J.getPresenter() instanceof AbsWSVerticalPagePresenter)) {
            return;
        }
        AbsWSVerticalPagePresenter absWSVerticalPagePresenter = (AbsWSVerticalPagePresenter) this.J.getPresenter();
        if (absWSVerticalPagePresenter.G) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.i0(this.J.getFrom(), this.J.getPlayScene(), z16.f82114h, z16.getAdapterPosition() - 1, com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.k(this.J.getPresenter().h0(), z16));
        absWSVerticalPagePresenter.G = true;
    }

    private void L(stSimpleMetaFeed stsimplemetafeed) {
        if (E()) {
            this.D.setVisibility(8);
        } else {
            this.D.setVisibility(0);
        }
        WSPicLoader.g().m(this.D, stsimplemetafeed, false, WSPublicAccReport.SOP_NAME_VIDEO_PLAY, d());
    }

    private void v() {
        WSVerticalPageFragment wSVerticalPageFragment = this.J;
        if (wSVerticalPageFragment == null || wSVerticalPageFragment.getPresenter().t0()) {
            return;
        }
        this.f80410e.setPadding(0, 0, 0, 0);
    }

    private stSimpleMetaFeed x() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 == null || c16.e() == null) {
            return null;
        }
        return c16.e();
    }

    private WSPlayerManager y() {
        WSVerticalPageFragment wSVerticalPageFragment = this.J;
        if (wSVerticalPageFragment == null || wSVerticalPageFragment.getAdapter() == null) {
            return null;
        }
        return this.J.getAdapter().y();
    }

    public View A() {
        return this.D;
    }

    public void C() {
        this.E.setVisibility(8);
    }

    public void D() {
        this.G.setVisibility(8);
        this.F.setVisibility(8);
    }

    public void F() {
        WSPlayerManager y16 = y();
        if (y16 != null) {
            if (y16.E0()) {
                y16.K0();
                G(false);
            } else {
                y16.O0();
                G(true);
                H();
            }
        }
    }

    public void I(int i3) {
        View view = this.H;
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    public void J() {
        this.E.setVisibility(0);
    }

    public void K(String str) {
        this.G.setVisibility(0);
        this.F.setVisibility(0);
        this.F.setText(str);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        stSimpleMetaFeed x16 = x();
        if (x16 == null) {
            return;
        }
        L(x16);
        this.H.setVisibility(8);
        D();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fwy;
    }

    public void w(int i3, int i16) {
        KandianUrlImageView kandianUrlImageView = this.D;
        if (kandianUrlImageView == null || i3 == kandianUrlImageView.getVisibility()) {
            return;
        }
        bb.a(this.D, i3, i16);
    }

    public FrameLayout z() {
        return this.C;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (FrameLayout) p(R.id.f116846zu);
        this.D = (KandianUrlImageView) p(R.id.f116856zv);
        this.H = p(R.id.f116896zz);
        this.E = (ProgressBar) p(R.id.f116826zs);
        this.F = (TextView) p(R.id.f116876zx);
        View p16 = p(R.id.f116866zw);
        this.G = p16;
        p16.setOnClickListener(new a());
        v();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }
}
