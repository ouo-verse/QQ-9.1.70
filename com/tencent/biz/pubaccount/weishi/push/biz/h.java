package com.tencent.biz.pubaccount.weishi.push.biz;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi.l;
import com.tencent.biz.pubaccount.weishi.push.WSPushStrategyInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h extends a<com.tencent.biz.pubaccount.weishi.push.a, WSPushStrategyInfo> {
    public h(com.tencent.biz.pubaccount.weishi.push.a aVar) {
        super(aVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.push.biz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(Context context, WSPushStrategyInfo wSPushStrategyInfo) {
        WSHomeFragment.di(new l(context, 1, "from_home_page"));
        return true;
    }
}
