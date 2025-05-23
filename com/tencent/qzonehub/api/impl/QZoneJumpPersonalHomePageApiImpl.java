package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import com.qzone.reborn.route.QZoneUserHomeBean;
import com.tencent.qzonehub.api.IQZoneJumpPersonalHomePageApi;
import ho.i;

/* loaded from: classes34.dex */
public class QZoneJumpPersonalHomePageApiImpl implements IQZoneJumpPersonalHomePageApi {
    @Override // com.tencent.qzonehub.api.IQZoneJumpPersonalHomePageApi
    public void qavJumpToPersonalHomePage(Activity activity, long j3) {
        QZoneUserHomeBean qZoneUserHomeBean = new QZoneUserHomeBean();
        qZoneUserHomeBean.setUin(j3);
        qZoneUserHomeBean.setFromQAV(true);
        i.z().t(activity, qZoneUserHomeBean);
    }
}
