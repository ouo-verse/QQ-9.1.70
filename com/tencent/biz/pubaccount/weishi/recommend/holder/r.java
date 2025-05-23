package com.tencent.biz.pubaccount.weishi.recommend.holder;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class r extends b {
    public r(Context context, View view, com.tencent.biz.pubaccount.weishi.t tVar) {
        super(context, view, tVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void a() {
        super.a();
        g(R.id.xtu, new d10.q(this.f80416f));
        g(R.id.xts, new d10.m(this.f80416f));
        g(R.id.xtt, new d10.o(this.f80416f));
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.holder.b
    protected int i() {
        return 1;
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.holder.b
    protected boolean k() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.holder.b
    protected boolean l() {
        return false;
    }
}
