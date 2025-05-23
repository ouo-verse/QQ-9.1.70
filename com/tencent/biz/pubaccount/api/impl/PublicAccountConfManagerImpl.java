package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountConfManager;
import com.tencent.luggage.wxa.gf.n0;
import com.tencent.mobileqq.config.am;

/* loaded from: classes32.dex */
public class PublicAccountConfManagerImpl implements IPublicAccountConfManager {
    @Override // com.tencent.biz.pubaccount.api.IPublicAccountConfManager
    public boolean isInLongClickUnsubscribeWhiteList(String str) {
        gy.d dVar = (gy.d) am.s().x(n0.CTRL_INDEX);
        if (dVar == null) {
            return false;
        }
        return dVar.a().contains(str);
    }
}
