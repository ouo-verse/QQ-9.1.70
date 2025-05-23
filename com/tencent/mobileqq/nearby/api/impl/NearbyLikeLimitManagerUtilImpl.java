package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil;
import com.tencent.mobileqq.nearby.api.d;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyLikeLimitManagerUtilImpl implements INearbyLikeLimitManagerUtil {
    @Override // com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil
    public boolean isNeedNewLimitCheck(long j3) {
        return d.a(j3);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil
    public void report(Object obj, String str, String str2) {
        d.b((QQAppInterface) obj, str, str2);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil
    public void report(Object obj, String str, String str2, String str3, String str4, String str5, String str6) {
        d.c((QQAppInterface) obj, str, str2, str3, str4, str5, str6);
    }
}
