package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ag extends com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> {
    private WSVerticalPageFragment C;
    private TextView D;
    private TextView E;

    public ag(Context context, au auVar) {
        super(context);
        if (auVar != null) {
            this.C = auVar.f82128e;
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.g d16;
        com.tencent.biz.pubaccount.weishi.util.x.i("WSVerticalItemTopTextController", "onUpdateUI hashcode******************************" + hashCode() + ",position:" + d());
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 == null || (d16 = c16.d()) == null) {
            return;
        }
        this.D.setText(d16.c());
        this.E.setText(this.f80409d.getString(R.string.f169720x80, Integer.valueOf(d16.d())));
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fwx;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.r(this.C.getBaseActivity(), (ViewGroup) this.f80410e);
        ViewGroup.LayoutParams layoutParams = this.f80410e.getLayoutParams();
        layoutParams.width = -1;
        this.f80410e.setLayoutParams(layoutParams);
        this.D = (TextView) p(R.id.f116776zn);
        this.E = (TextView) p(R.id.f116766zm);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }
}
