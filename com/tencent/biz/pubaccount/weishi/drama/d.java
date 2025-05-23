package com.tencent.biz.pubaccount.weishi.drama;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends com.tencent.biz.pubaccount.weishi.baseui.b<Object> {
    private final WSDramaPageFragment C;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.v();
        }
    }

    public d(Context context, WSDramaPageFragment wSDramaPageFragment) {
        super(context);
        this.C = wSDramaPageFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        WSDramaPageFragment wSDramaPageFragment = this.C;
        if (wSDramaPageFragment != null) {
            wSDramaPageFragment.Oh(false, true);
            this.C.r4();
            this.C.showLoading();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.f168554fw2;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        p(R.id.f116666zc).setOnClickListener(new a());
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
    }
}
