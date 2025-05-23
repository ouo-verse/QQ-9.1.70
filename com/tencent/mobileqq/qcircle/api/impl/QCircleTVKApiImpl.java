package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.mobileqq.qcircle.api.IQCircleTVKApi;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleTVKApiImpl implements IQCircleTVKApi {
    @Override // com.tencent.mobileqq.qcircle.api.IQCircleTVKApi
    public String getPlayerCookie() {
        return HostStaticInvokeHelper.getPlayerCookie();
    }
}
