package com.tencent.mobileqq.guild.nt.misc.api.impl;

import com.tencent.mobileqq.guild.nt.misc.api.IAppInfoApi;
import com.tencent.mobileqq.utils.ah;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class AppInfoApiImpl implements IAppInfoApi {
    @Override // com.tencent.mobileqq.guild.nt.misc.api.IAppInfoApi
    public String getDeviceName() {
        return PlatformInfor.getDeviceName();
    }

    @Override // com.tencent.mobileqq.guild.nt.misc.api.IAppInfoApi
    public String getQua() {
        return QUA.getQUA3();
    }

    @Override // com.tencent.mobileqq.guild.nt.misc.api.IAppInfoApi
    public String getVersionName() {
        return ah.Q(MobileQQ.sMobileQQ);
    }
}
