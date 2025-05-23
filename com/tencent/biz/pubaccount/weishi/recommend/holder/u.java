package com.tencent.biz.pubaccount.weishi.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes32.dex */
public class u extends k {
    public u(ViewGroup viewGroup, int i3, com.tencent.biz.pubaccount.weishi.t tVar) {
        super(viewGroup, i3, tVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.holder.a
    public com.tencent.biz.pubaccount.weishi.baseui.c<stSimpleMetaFeed> b(int i3) {
        return new v(getContext(), this.itemView, a());
    }
}
