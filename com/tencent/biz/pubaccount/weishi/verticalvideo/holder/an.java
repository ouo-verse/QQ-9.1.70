package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

/* compiled from: P */
/* loaded from: classes32.dex */
public class an extends f {
    private static final int C = ScreenUtil.dip2px(45.0f);

    public an(ViewGroup viewGroup, int i3, WSVerticalPageFragment wSVerticalPageFragment) {
        super(viewGroup, i3, wSVerticalPageFragment);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e
    public void d(int i3) {
        super.d(i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public int i() {
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public int k() {
        return C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public boolean o() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public boolean q() {
        WSVerticalPageFragment wSVerticalPageFragment = this.f82128e;
        if (wSVerticalPageFragment == null || !TextUtils.equals(wSVerticalPageFragment.getFrom(), "aio_home_page")) {
            return super.q();
        }
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public b b(int i3) {
        return new ax(getContext(), this);
    }
}
