package com.tencent.biz.pubaccount.weishi.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ad extends b {
    public ad(Context context, View view, com.tencent.biz.pubaccount.weishi.t tVar) {
        super(context, view, tVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void a() {
        super.a();
        g(R.id.xtl, new d10.l(this.f80416f));
        g(R.id.xtj, new d10.j(this.f80416f));
        g(R.id.xtk, new d10.h(this.f80416f));
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.holder.b
    protected int i() {
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.holder.b
    protected int j() {
        return R.drawable.k7x;
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.holder.b
    protected boolean k() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.holder.b
    protected boolean l() {
        if (TextUtils.isEmpty(this.E.feed_desc)) {
            stSimpleMetaFeed stsimplemetafeed = this.E;
            if (stsimplemetafeed.playNum == 0 && stsimplemetafeed.ding_count == 0) {
                return false;
            }
        }
        return true;
    }
}
