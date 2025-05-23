package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSAdvBigCardAnimHelper;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ai extends com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c implements View.OnClickListener {
    private ImageView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private RoundCornerImageView G;
    private WSVerticalPageFragment H;
    private ez.b I;
    private c J;
    private WSAdvBigCardAnimHelper K;
    private boolean L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ez.b bVar = ai.this.I;
            if (bVar == null) {
                return;
            }
            ai.this.G(bVar.g());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ((AbsWsUI) ai.this).f80410e.setVisibility(0);
            if (ai.this.J != null) {
                ai.this.J.b();
            }
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.W(ai.this.H.getFrom(), ai.this.H.getPlayScene(), "videotag_rich", ai.this.c(), true, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        private boolean f82108d = false;

        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.tencent.biz.pubaccount.weishi.util.x.i("WSAdvBigCardController", "onAnimationEnd() isCancel = " + this.f82108d);
            if (!this.f82108d) {
                ai.this.I();
                if (ai.this.J != null) {
                    ai.this.J.a();
                    return;
                }
                return;
            }
            this.f82108d = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f82108d = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void a();

        void b();
    }

    public ai(Context context, au auVar, int i3) {
        super(context);
        WSAdvBigCardAnimHelper wSAdvBigCardAnimHelper = new WSAdvBigCardAnimHelper();
        this.K = wSAdvBigCardAnimHelper;
        this.L = false;
        wSAdvBigCardAnimHelper.e(i3);
        this.H = auVar != null ? auVar.f82128e : null;
    }

    private void C() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.utils.d.k(this.H, c(), true);
    }

    private void D() {
        if (bb.E()) {
            return;
        }
        G(0);
    }

    private void F() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        String str = (c16 == null || c16.e() == null) ? null : c16.e().feed_desc;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("feedDesc:");
        sb5.append(str);
        if (this.I != null) {
            sb5.append(", wsCommercialInfo:[");
            sb5.append("bigCardIcon:");
            sb5.append(this.I.h());
            sb5.append(",bigCardTitle:");
            sb5.append(this.I.j());
            sb5.append(",bigCardBtnText:");
            sb5.append(this.I.k());
            sb5.append(",smallCardText:");
            sb5.append(this.I.c());
            sb5.append(",smallCardIcon:");
            sb5.append(this.I.a());
            sb5.append("]");
        } else {
            sb5.append(", wsCommercialInfo empty");
        }
        com.tencent.biz.pubaccount.weishi.util.x.i("WSAdvBigCardController", sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i3) {
        com.tencent.biz.pubaccount.weishi.util.x.i("WSAdvBigCardController", "planToHideCard delayTime:" + i3);
        this.K.g(this.f80410e, i3, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        View view = this.f80410e;
        if (view == null) {
            com.tencent.biz.pubaccount.weishi.util.x.i("WSAdvBigCardController", "resetCardStatus view null");
        } else {
            view.setTranslationY(this.K.d());
            this.f80410e.setVisibility(8);
        }
    }

    private void K(View view, int i3) {
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            background.mutate();
            ((GradientDrawable) background).setCornerRadius(i3);
        }
    }

    public void J(c cVar) {
        this.J = cVar;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
        com.tencent.biz.pubaccount.weishi.util.x.b("WSAdvBigCardController", "onRecycle");
        this.K.a();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16.f() instanceof ez.b) {
            this.I = (ez.b) c16.f();
            F();
        } else {
            this.I = null;
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        if (E(this.I)) {
            l(8);
            return;
        }
        com.tencent.biz.pubaccount.weishi.util.x.b("WSAdvBigCardController", "onUpdateUI");
        this.D.setText(this.I.j());
        this.E.setText(this.I.f());
        this.F.setText(this.I.k());
        WSPicLoader.g().w(this.G, this.I.h(), null);
        I();
        if (this.L) {
            H();
        }
        if (this.I.d() == 5) {
            this.C.setImageResource(R.drawable.od6);
        } else {
            this.C.setImageResource(R.drawable.f159767gh0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.C) {
            D();
        } else if (view == this.f80410e) {
            C();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d1p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void u(int i3) {
        com.tencent.biz.pubaccount.weishi.util.x.b("WSAdvBigCardController", "onPageSelected\uff0c position:" + i3);
        if (E(this.I)) {
            this.L = true;
        } else {
            H();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void v(int i3) {
        com.tencent.biz.pubaccount.weishi.util.x.b("WSAdvBigCardController", "onPageUnselected\uff0c position:" + i3);
        if (E(this.I)) {
            return;
        }
        G(0);
    }

    private void H() {
        this.L = false;
        this.K.f(this.f80410e, this.I.i(), new a());
    }

    private boolean E(ez.b bVar) {
        return bVar == null || !bVar.o() || TextUtils.isEmpty(bVar.h()) || TextUtils.isEmpty(bVar.j()) || TextUtils.isEmpty(bVar.k());
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (ImageView) p(R.id.p3_);
        this.D = (TextView) p(R.id.p3c);
        this.E = (TextView) p(R.id.p3b);
        this.F = (TextView) p(R.id.p39);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) p(R.id.p3e);
        this.G = roundCornerImageView;
        roundCornerImageView.setCorner(ba.f81729d);
        this.C.setOnClickListener(this);
        this.f80410e.setOnClickListener(this);
        K(this.f80410e, ba.f81731f);
    }
}
