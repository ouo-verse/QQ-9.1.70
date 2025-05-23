package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends f {
    public d(ViewGroup viewGroup, int i3, WSVerticalPageFragment wSVerticalPageFragment) {
        super(viewGroup, i3, wSVerticalPageFragment);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public boolean p() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public boolean q() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f
    public void w(boolean z16) {
        ((WSVerticalVideoOperationRightItemView) this.f82127d).H(z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f
    public void x(boolean z16) {
        ((WSVerticalVideoOperationRightItemView) this.f82127d).e0(z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public b b(int i3) {
        return new at(getContext(), this);
    }
}
