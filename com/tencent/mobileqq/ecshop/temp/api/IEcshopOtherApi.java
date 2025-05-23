package com.tencent.mobileqq.ecshop.temp.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IEcshopOtherApi extends QRouteApi {
    public static final int REPORT_TYPE_CLICK = 1;
    public static final int REPORT_TYPE_SHOW = 0;

    void gdtC2SReport(qq_ad_get.QQAdGetRsp.AdInfo adInfo, int i3);

    void updateRecentList(AppInterface appInterface);
}
