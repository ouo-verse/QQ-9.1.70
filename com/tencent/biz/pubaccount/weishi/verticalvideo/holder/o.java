package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class o extends a {
    public o(Context context, au auVar) {
        super(context, auVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.a
    protected boolean A() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        return (c16 == null || c16.d() == null || c16.d().b() == null || TextUtils.isEmpty(c16.d().b().barText)) ? false : true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.a
    protected String y() {
        return c().d().b().barText;
    }
}
