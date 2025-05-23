package com.tencent.mobileqq.nearby.redtouch.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.INearbyOfficalReportHelper;
import com.tencent.mobileqq.nearby.redtouch.NearbyOfficalReportHelper;
import tencent.im.oidb.cmd0x791.oidb_0x791$RedDotInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyOfficalReportHelperImpl implements INearbyOfficalReportHelper {
    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyOfficalReportHelper
    public void reportLebaRedDotEvent(Object obj, String str, String str2) {
        NearbyOfficalReportHelper.a().b((QQAppInterface) obj, str, str2);
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyOfficalReportHelper
    public void reportRedDotReceive(Object obj, Object obj2) {
        NearbyOfficalReportHelper.a().c((QQAppInterface) obj, (oidb_0x791$RedDotInfo) obj2);
    }
}
