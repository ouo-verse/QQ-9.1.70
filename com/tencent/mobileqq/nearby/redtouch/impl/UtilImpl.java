package com.tencent.mobileqq.nearby.redtouch.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.IUtil;
import com.tencent.mobileqq.nearby.redtouch.i;

/* compiled from: P */
/* loaded from: classes33.dex */
public class UtilImpl implements IUtil {
    @Override // com.tencent.mobileqq.nearby.redtouch.IUtil
    public boolean checkLikeRankListRedPointConfig(Object obj) {
        return i.a((QQAppInterface) obj);
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.IUtil
    public boolean checkMedalRedPointConfig(Object obj) {
        return i.b((QQAppInterface) obj);
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.IUtil
    public void onLikeRankListConfigChanged(Object obj, boolean z16) {
        i.c((QQAppInterface) obj, z16);
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.IUtil
    public void onMedalConfigChanged(Object obj, boolean z16) {
        i.d((QQAppInterface) obj, z16);
    }
}
