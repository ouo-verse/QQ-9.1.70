package com.tencent.biz.bmqq.api.impl;

import android.content.Context;
import com.tencent.biz.bmqq.api.IBmqqSegmentApi;
import nx.a;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BmqqSegmentApiImpl implements IBmqqSegmentApi {
    @Override // com.tencent.biz.bmqq.api.IBmqqSegmentApi
    public void initSegmentCache(Context context) {
        a.a(context);
    }

    @Override // com.tencent.biz.bmqq.api.IBmqqSegmentApi
    public boolean isBmqqUin(String str) {
        return a.c(str);
    }

    @Override // com.tencent.biz.bmqq.api.IBmqqSegmentApi
    public boolean isBmqqUinNoBlock(String str) {
        return a.d(str);
    }

    @Override // com.tencent.biz.bmqq.api.IBmqqSegmentApi
    public boolean isCrm3ExtUin(Context context, String str) {
        return a.e(context, str);
    }

    @Override // com.tencent.biz.bmqq.api.IBmqqSegmentApi
    public boolean isUin(String str) {
        return a.f(str);
    }

    @Override // com.tencent.biz.bmqq.api.IBmqqSegmentApi
    public boolean isWeixinUin(Context context, String str) {
        return a.g(context, str);
    }

    @Override // com.tencent.biz.bmqq.api.IBmqqSegmentApi
    public void updateEqqConfig(String str) {
        a.k(str);
    }

    @Override // com.tencent.biz.bmqq.api.IBmqqSegmentApi
    public boolean isBmqqUin(Context context, String str) {
        return a.b(context, str);
    }
}
