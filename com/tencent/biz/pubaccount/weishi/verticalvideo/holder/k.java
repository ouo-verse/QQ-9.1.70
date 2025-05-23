package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.view.WSRoundedImageView;
import com.tencent.mobileqq.R;
import com.tencent.open.base.ToastUtil;
import l00.b;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k extends com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> implements View.OnClickListener {
    private static final int I = com.tencent.biz.pubaccount.weishi.util.ah.b(2.5f);
    private static final int J = com.tencent.biz.pubaccount.weishi.util.ah.b(150.0f);
    private static final int K = com.tencent.biz.pubaccount.weishi.util.ah.b(1.0f);
    private static final int L = Color.parseColor("#5CFFFFFF");
    private static final int M = com.tencent.biz.pubaccount.weishi.util.ah.b(60.0f);
    private WSVerticalPageFragment C;
    private WSRoundedImageView D;
    private LottieAnimationView E;
    private TextView F;
    private TextView G;
    private stSimpleMetaFeed H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements WSPicLoader.d {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.image.WSPicLoader.d
        public void a(Drawable drawable) {
            ba.A(k.this.D, drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements b.InterfaceC10696b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaPerson f82137a;

        b(stSimpleMetaPerson stsimplemetaperson) {
            this.f82137a = stsimplemetaperson;
        }

        @Override // l00.b.InterfaceC10696b
        public void onFailure() {
            k.this.y(this.f82137a);
        }
    }

    public k(Context context, au auVar) {
        super(context);
        if (auVar != null) {
            this.C = auVar.f82128e;
        }
    }

    private void A() {
        stSimpleMetaFeed stsimplemetafeed;
        if (!com.tencent.biz.common.util.g.b(b())) {
            ToastUtil.a().b(R.string.f242037th);
            return;
        }
        if (this.C == null || (stsimplemetafeed = this.H) == null || stsimplemetafeed.poster == null) {
            return;
        }
        this.G.setVisibility(8);
        jz.g.e().c(this.H.poster.f25130id, 1);
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.H(this.C.getFrom(), this.C.getPlayScene(), this.H, this.C.getPresenter().h0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void B() {
        this.C.getPresenter().X("nickname", this.C, (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i);
    }

    private int w() {
        if (this.G.getVisibility() != 0) {
            return 0;
        }
        int width = this.G.getWidth();
        return width != 0 ? width : M;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(stSimpleMetaPerson stsimplemetaperson) {
        this.E.setVisibility(8);
        this.D.setVisibility(0);
        WSPicLoader.g().k(this.f80409d, this.D, stsimplemetaperson.avatar, new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z() {
        this.C.getPresenter().X("profile", this.C, (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 != null && (c16.e() instanceof stSimpleMetaFeed)) {
            this.H = c16.e();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 != null && (c16.e() instanceof stSimpleMetaFeed)) {
            stSimpleMetaPerson stsimplemetaperson = c16.e().poster;
            D(stsimplemetaperson);
            E(stsimplemetaperson);
            C(stsimplemetaperson);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.f116696zf /* 2131392344 */:
            case R.id.f116706zg /* 2131392345 */:
                z();
                return;
            case R.id.f116716zh /* 2131392346 */:
            case R.id.f116726zi /* 2131392347 */:
            case R.id.f116736zj /* 2131392348 */:
            default:
                return;
            case R.id.f116746zk /* 2131392349 */:
                A();
                return;
            case R.id.f116756zl /* 2131392350 */:
                B();
                return;
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fwn;
    }

    public void x(stSimpleMetaPerson stsimplemetaperson) {
        if (com.tencent.biz.pubaccount.weishi.util.r.u(this.H.poster)) {
            l00.b.c().f(this.E, stsimplemetaperson.avatar, new b(stsimplemetaperson));
        } else {
            l00.b.c().b(this.E);
        }
    }

    private void E(stSimpleMetaPerson stsimplemetaperson) {
        if (stsimplemetaperson == null) {
            this.F.setVisibility(8);
            return;
        }
        int w3 = w();
        int o16 = ba.o();
        this.F.setVisibility(0);
        this.F.setMaxWidth((o16 - w3) - J);
        this.F.setText(stsimplemetaperson.nick);
        int l3 = com.tencent.biz.pubaccount.weishi.util.r.l(stsimplemetaperson.medal);
        this.F.setCompoundDrawablePadding(K);
        if (l3 != -1) {
            this.F.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.tencent.biz.pubaccount.weishi.util.ag.b(l3), (Drawable) null);
        } else {
            this.F.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.D = (WSRoundedImageView) p(R.id.f116696zf);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) p(R.id.f116706zg);
        this.E = lottieAnimationView;
        lottieAnimationView.setOnClickListener(this);
        this.D.setStrokeWidth(I);
        this.D.setStrokeColor(L);
        this.D.setOnClickListener(this);
        TextView textView = (TextView) p(R.id.f116756zl);
        this.F = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) p(R.id.f116746zk);
        this.G = textView2;
        textView2.setOnClickListener(this);
    }

    private void C(stSimpleMetaPerson stsimplemetaperson) {
        if (stsimplemetaperson == null) {
            this.D.setVisibility(8);
        } else {
            if (com.tencent.biz.pubaccount.weishi.util.r.u(stsimplemetaperson)) {
                x(stsimplemetaperson);
                this.E.setVisibility(0);
                this.D.setVisibility(8);
                return;
            }
            y(stsimplemetaperson);
        }
    }

    public void D(stSimpleMetaPerson stsimplemetaperson) {
        if (stsimplemetaperson == null) {
            this.G.setVisibility(8);
        } else if (TextUtils.equals(bb.q(), stsimplemetaperson.f25130id)) {
            this.G.setVisibility(8);
        } else {
            this.G.setVisibility(com.tencent.biz.pubaccount.weishi.util.r.r(stsimplemetaperson.followStatus) ? 8 : 0);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
