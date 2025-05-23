package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stCollection;
import android.content.Context;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class q extends a {
    private stCollection H;

    public q(Context context, au auVar) {
        super(context, auVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.a
    protected boolean A() {
        stCollection stcollection = this.H;
        return (stcollection == null || TextUtils.isEmpty(stcollection.barText)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.a, com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    public void g() {
        super.g();
        if (c() != null) {
            this.H = c().b();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.a
    protected String y() {
        return this.H.barText;
    }
}
