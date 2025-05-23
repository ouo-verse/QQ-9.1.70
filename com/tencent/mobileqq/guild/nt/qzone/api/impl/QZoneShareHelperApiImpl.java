package com.tencent.mobileqq.guild.nt.qzone.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.guild.nt.qzone.api.IQZoneShareHelperApi;
import cooperation.qzone.QZoneHelper;
import hv1.a;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QZoneShareHelperApiImpl implements IQZoneShareHelperApi {
    @Override // com.tencent.mobileqq.guild.nt.qzone.api.IQZoneShareHelperApi
    public void forwardToZone(Activity activity, a aVar) {
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = aVar.a();
        userInfo.nickname = aVar.d();
        QZoneHelper.forwardToPublishMood(activity, userInfo, aVar.c(), aVar.f(), aVar.b(), aVar.e());
    }
}
