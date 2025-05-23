package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.view.WSRoundedImageView;
import com.tencent.mobileqq.R;
import com.tencent.open.base.ToastUtil;
import com.tencent.widget.ActionSheet;

/* compiled from: P */
/* loaded from: classes32.dex */
public class af extends com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> implements View.OnClickListener {
    private com.tencent.biz.pubaccount.weishi.verticalvideo.h C;
    private com.tencent.biz.pubaccount.weishi.verticalvideo.g D;
    private WSRoundedImageView E;
    private TextView F;
    private TextView G;
    private jz.g H;
    private stSimpleMetaFeed I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaPerson f82104d;

        a(stSimpleMetaPerson stsimplemetaperson) {
            this.f82104d = stsimplemetaperson;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (!com.tencent.biz.common.util.g.b(af.this.b())) {
                ToastUtil.a().b(R.string.f242037th);
                return;
            }
            af.this.H.c(this.f82104d.f25130id, 2);
            this.f82104d.followStatus = 2;
            af.this.G.setText("\u5173\u6ce8");
            af.this.G.setVisibility(0);
        }
    }

    public af(Context context) {
        super(context);
    }

    private void A(stSimpleMetaPerson stsimplemetaperson) {
        if (TextUtils.equals(bb.q(), stsimplemetaperson.f25130id)) {
            this.G.setVisibility(8);
            return;
        }
        com.tencent.biz.pubaccount.weishi.util.x.f("WSVerticalItemTopController", "followStatus:" + stsimplemetaperson.followStatus + ",personInfo hashCode:" + stsimplemetaperson.hashCode());
        if (com.tencent.biz.pubaccount.weishi.util.r.r(stsimplemetaperson.followStatus)) {
            this.G.setVisibility(8);
        } else {
            this.G.setText("\u5173\u6ce8");
            this.G.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void x() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar = this.C;
        if (hVar instanceof WSVerticalPageFragment) {
            this.D.X("profile", (WSVerticalPageFragment) hVar, (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f80413i);
        }
        y(1000001);
        com.tencent.biz.pubaccount.weishi.util.x.b("WSVerticalItemTopController", "Jump to personal page.");
    }

    private void y(int i3) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.o(this.C.getFrom(), this.C.getPlayScene(), i3, this.I, this.D.h0());
    }

    private void z() {
        stSimpleMetaPerson stsimplemetaperson;
        if (!com.tencent.biz.common.util.g.b(b())) {
            ToastUtil.a().b(R.string.f242037th);
            return;
        }
        if (this.H == null) {
            this.H = jz.g.e();
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.util.x.b("WSVerticalItemTopController", "Follow user.");
        if (!(c16.e() instanceof stSimpleMetaFeed) || (stsimplemetaperson = c16.e().poster) == null) {
            return;
        }
        if (com.tencent.biz.pubaccount.weishi.util.r.r(stsimplemetaperson.followStatus)) {
            com.tencent.biz.pubaccount.weishi.util.r.G(b(), new a(stsimplemetaperson), null);
            return;
        }
        this.H.c(stsimplemetaperson.f25130id, 1);
        stsimplemetaperson.followStatus = 1;
        this.G.setText("\u5df2\u5173\u6ce8");
        com.tencent.biz.pubaccount.weishi.util.x.i("WSVerticalItemTopController", "---> followStatus:" + stsimplemetaperson.followStatus + ",personInfo hashCode:" + stsimplemetaperson.hashCode());
        this.G.setVisibility(8);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 != null && (c16.e() instanceof stSimpleMetaFeed)) {
            this.I = c16.e();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        stSimpleMetaPerson stsimplemetaperson;
        com.tencent.biz.pubaccount.weishi.util.x.i("WSVerticalItemTopController", "onUpdateUI hashcode******************************" + hashCode() + ",position:" + d());
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 == null || !(c16.e() instanceof stSimpleMetaFeed) || (stsimplemetaperson = c16.e().poster) == null) {
            return;
        }
        this.F.setText(stsimplemetaperson.nick);
        WSPicLoader.g().j(this.f80409d, this.E, stsimplemetaperson.avatar);
        A(stsimplemetaperson);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.f116696zf /* 2131392344 */:
            case R.id.f116756zl /* 2131392350 */:
                x();
                return;
            case R.id.f116746zk /* 2131392349 */:
                z();
                com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.H(this.C.getFrom(), this.C.getPlayScene(), this.I, this.D.h0());
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fww;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f80410e.getLayoutParams();
        layoutParams.height = ba.r();
        layoutParams.width = -2;
        layoutParams.topMargin = ba.t((Activity) this.f80409d);
        layoutParams.leftMargin = ba.s();
        this.f80410e.setLayoutParams(layoutParams);
        WSRoundedImageView wSRoundedImageView = (WSRoundedImageView) p(R.id.f116696zf);
        this.E = wSRoundedImageView;
        wSRoundedImageView.setOnClickListener(this);
        TextView textView = (TextView) p(R.id.f116756zl);
        this.F = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) p(R.id.f116746zk);
        this.G = textView2;
        textView2.setOnClickListener(this);
    }

    public af(Context context, com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar, com.tencent.biz.pubaccount.weishi.verticalvideo.g gVar) {
        this(context);
        this.C = hVar;
        this.D = gVar;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
