package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class a extends c {
    private View C;
    private TextView D;
    protected TextView E;
    protected WSVerticalPageFragment F;
    protected stSimpleMetaFeed G;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class ViewOnClickListenerC0835a implements View.OnClickListener {
        ViewOnClickListenerC0835a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.z();
        }
    }

    public a(Context context, au auVar) {
        super(context);
        if (auVar != null) {
            this.F = auVar.f82128e;
        }
    }

    private GradientDrawable x() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(ba.f81735j);
        gradientDrawable.setColor(Color.parseColor("#2F2F2F"));
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.F.De().show();
    }

    protected abstract boolean A();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    public void g() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 != null) {
            this.G = c16.e();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        if (A()) {
            this.C.setVisibility(0);
            this.D.setText(y());
        } else {
            this.C.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fwo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void u(int i3) {
        if (A()) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.x(this.F.getFrom(), this.F.getPlayScene(), this.G, this.F.getPresenter().h0());
        }
    }

    protected abstract String y();

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        View p16 = p(R.id.f116716zh);
        this.C = p16;
        p16.setOnClickListener(new ViewOnClickListenerC0835a());
        this.D = (TextView) p(R.id.f116736zj);
        this.E = (TextView) p(R.id.f116726zi);
        FrameLayout frameLayout = (FrameLayout) p(R.id.v7o);
        this.E.setRotation(270.0f);
        frameLayout.setBackgroundDrawable(x());
        this.C.setBackgroundColor(com.tencent.biz.pubaccount.weishi.util.r.g(R.color.f156808bw));
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.c
    public void v(int i3) {
    }
}
