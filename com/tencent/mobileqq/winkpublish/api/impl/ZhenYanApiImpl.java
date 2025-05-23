package com.tencent.mobileqq.winkpublish.api.impl;

import com.tencent.mobileqq.winkpublish.api.IZhenYanApi;
import com.tencent.mobileqq.winkpublish.hook.ZhenYanUtil;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ZhenYanApiImpl implements IZhenYanApi {
    @Override // com.tencent.mobileqq.winkpublish.api.IZhenYanApi
    public void recordLeftCache() {
        ZhenYanUtil.c();
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IZhenYanApi
    public void setUp() {
        ZhenYanUtil.d();
    }
}
