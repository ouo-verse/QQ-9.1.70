package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.view.WSRoundedImageView;
import com.tencent.mobileqq.R;
import com.tencent.open.base.ToastUtil;
import l00.b;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i extends com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> implements View.OnClickListener {
    private WSRoundedImageView C;
    private LottieAnimationView D;
    private LottieAnimationView E;
    private WSVerticalPageFragment F;
    private stSimpleMetaFeed G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements b.InterfaceC10696b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaPerson f82132a;

        a(stSimpleMetaPerson stsimplemetaperson) {
            this.f82132a = stsimplemetaperson;
        }

        @Override // l00.b.InterfaceC10696b
        public void onFailure() {
            i.this.x(this.f82132a);
        }
    }

    public i(Context context, au auVar) {
        super(context);
        if (auVar != null) {
            this.F = auVar.f82128e;
        }
    }

    private void A() {
        if (!com.tencent.biz.common.util.g.b(b())) {
            ToastUtil.a().b(R.string.f242037th);
            return;
        }
        stSimpleMetaFeed stsimplemetafeed = this.G;
        if (stsimplemetafeed == null || stsimplemetafeed.poster == null || this.E.isAnimating()) {
            return;
        }
        y();
        jz.g.e().c(this.G.poster.f25130id, 1);
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.H(this.F.getFrom(), this.F.getPlayScene(), this.G, this.F.getPresenter().h0());
        com.tencent.biz.pubaccount.weishi.report.dc898.d.g();
    }

    private void B(stSimpleMetaPerson stsimplemetaperson) {
        if (com.tencent.biz.pubaccount.weishi.util.r.u(stsimplemetaperson)) {
            w(stsimplemetaperson);
            this.D.setVisibility(0);
            this.C.setVisibility(8);
            return;
        }
        x(stsimplemetaperson);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(stSimpleMetaPerson stsimplemetaperson) {
        this.D.setVisibility(8);
        this.C.setVisibility(0);
        WSPicLoader.g().j(this.f80409d, this.C, stsimplemetaperson.avatar);
    }

    private void y() {
        this.E.addAnimatorListener(new b());
        this.E.playAnimation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z() {
        this.F.getPresenter().X("profile", this.F, (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 != null && (c16.e() instanceof stSimpleMetaFeed)) {
            this.G = c16.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    public void h() {
        stSimpleMetaPerson stsimplemetaperson;
        stSimpleMetaFeed stsimplemetafeed = this.G;
        if (stsimplemetafeed == null || (stsimplemetaperson = stsimplemetafeed.poster) == null) {
            return;
        }
        B(stsimplemetaperson);
        C(stsimplemetaperson);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.f165912y10 /* 2131373976 */:
                A();
                return;
            case R.id.f116696zf /* 2131392344 */:
            case R.id.f116706zg /* 2131392345 */:
                z();
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fwm;
    }

    public void w(stSimpleMetaPerson stsimplemetaperson) {
        if (com.tencent.biz.pubaccount.weishi.util.r.u(this.G.poster)) {
            l00.b.c().f(this.D, stsimplemetaperson.avatar, new a(stsimplemetaperson));
        } else {
            l00.b.c().b(this.D);
        }
    }

    private void C(stSimpleMetaPerson stsimplemetaperson) {
        if (stsimplemetaperson == null) {
            return;
        }
        if (TextUtils.equals(bb.q(), stsimplemetaperson.f25130id)) {
            this.E.setVisibility(8);
            return;
        }
        if (com.tencent.biz.pubaccount.weishi.util.r.r(stsimplemetaperson.followStatus)) {
            if (this.E.isAnimating()) {
                return;
            }
            this.E.setVisibility(8);
        } else {
            this.E.setFrame(1);
            this.E.setVisibility(com.tencent.biz.pubaccount.weishi.util.r.u(stsimplemetaperson) ? 8 : 0);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        WSRoundedImageView wSRoundedImageView = (WSRoundedImageView) p(R.id.f116696zf);
        this.C = wSRoundedImageView;
        wSRoundedImageView.setOnClickListener(this);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) p(R.id.f116706zg);
        this.D = lottieAnimationView;
        lottieAnimationView.setOnClickListener(this);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) p(R.id.f165912y10);
        this.E = lottieAnimationView2;
        lottieAnimationView2.setOnClickListener(this);
        this.E.setAnimation("wsfollow/followbtn.json");
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends com.tencent.mobileqq.widget.f {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            i.this.E.removeAnimatorListener(this);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.this.E.setVisibility(8);
            i.this.E.removeAnimatorListener(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
