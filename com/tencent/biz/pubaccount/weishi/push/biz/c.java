package com.tencent.biz.pubaccount.weishi.push.biz;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi.l;
import com.tencent.biz.pubaccount.weishi.push.WSPushStrategyInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends a<com.tencent.biz.pubaccount.weishi.push.a, WSPushStrategyInfo> {
    public c(com.tencent.biz.pubaccount.weishi.push.a aVar) {
        super(aVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.push.biz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(Context context, WSPushStrategyInfo wSPushStrategyInfo) {
        WSHomeFragment.di(new l(context, 0, "from_home_page"));
        ty.g.f437886a.p(null);
        return true;
    }
}
