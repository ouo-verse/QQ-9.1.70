package com.tencent.biz.pubaccount.weishi.verticalvideo;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i extends com.tencent.biz.pubaccount.weishi.baseui.b {
    private WSVerticalPageFragment C;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.v();
        }
    }

    public i(Context context, WSVerticalPageFragment wSVerticalPageFragment) {
        super(context);
        this.C = wSVerticalPageFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        WSVerticalPageFragment wSVerticalPageFragment = this.C;
        if (wSVerticalPageFragment != null) {
            wSVerticalPageFragment.ki(false, true);
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
