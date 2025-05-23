package com.tencent.biz.pubaccount.weishi.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class l extends a<stSimpleMetaFeed> {
    @Override // com.tencent.biz.pubaccount.weishi.recommend.holder.a
    public com.tencent.biz.pubaccount.weishi.baseui.c<stSimpleMetaFeed> b(int i3) {
        return new m(getContext(), this.itemView);
    }

    public l(ViewGroup viewGroup, int i3, com.tencent.biz.pubaccount.weishi.t tVar) {
        super(viewGroup, R.layout.fxg, i3, tVar);
        ((m) this.f81435d).i(tVar);
    }
}
