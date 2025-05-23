package com.tencent.mobileqq.kandian.biz.pts.api.impl;

import b62.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.pts.api.IProteusSupportUtil;
import com.tencent.mobileqq.kandian.biz.pts.util.c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/pts/api/impl/ProteusSupportUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/pts/api/IProteusSupportUtil;", "", "isPtsLiteSoReady", "Lb62/a;", "callback", "", "initPtsLite", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ProteusSupportUtilImpl implements IProteusSupportUtil {
    @Override // com.tencent.mobileqq.kandian.biz.pts.api.IProteusSupportUtil
    public void initPtsLite(a callback) {
        a62.a.a(BaseApplicationImpl.getApplication().getApplicationContext());
        c.a(callback);
    }

    @Override // com.tencent.mobileqq.kandian.biz.pts.api.IProteusSupportUtil
    public boolean isPtsLiteSoReady() {
        return c62.a.d().f();
    }
}
