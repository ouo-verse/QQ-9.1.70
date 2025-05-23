package com.tencent.biz.pubaccount.weishi.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends a<stSimpleMetaFeed> {
    @Override // com.tencent.biz.pubaccount.weishi.recommend.holder.a
    public com.tencent.biz.pubaccount.weishi.baseui.c<stSimpleMetaFeed> b(int i3) {
        return new WSGridAdItemView(getContext(), this.itemView, this.f81437f, this);
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    public void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        com.tencent.biz.pubaccount.weishi.baseui.c<T> cVar = this.f81435d;
        if (cVar != 0) {
            cVar.c();
        }
    }

    public d(ViewGroup viewGroup, int i3, com.tencent.biz.pubaccount.weishi.t tVar) {
        super(viewGroup, R.layout.d1f, i3, tVar);
    }
}
