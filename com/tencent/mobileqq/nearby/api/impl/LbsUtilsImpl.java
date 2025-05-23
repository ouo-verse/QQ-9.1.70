package com.tencent.mobileqq.nearby.api.impl;

import NearbyGroup.LBSInfo;
import com.tencent.mobileqq.nearby.api.ILbsUtils;
import com.tencent.mobileqq.nearby.api.c;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public class LbsUtilsImpl implements ILbsUtils {
    @Override // com.tencent.mobileqq.nearby.api.ILbsUtils
    public LBSInfo createLbsInfo(boolean z16, SosoLbsInfo sosoLbsInfo) {
        return c.a(z16, sosoLbsInfo);
    }

    @Override // com.tencent.mobileqq.nearby.api.ILbsUtils
    public Object getLbsInfo(String str) {
        return c.b(str);
    }

    @Override // com.tencent.mobileqq.nearby.api.ILbsUtils
    public LBSInfo getRawLbsInfo() {
        return c.c();
    }
}
