package com.tencent.mobileqq.dt.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IO3NotifyBannerApi extends QRouteApi {
    public static final int AFTER_CLICK_STATE_CLOSE = 3;
    public static final int AFTER_CLICK_STATE_JUMP = 1;

    void onNotifyBannerClick(String str, String str2, int i3, int i16);

    void onNotifyBannerCreate(String str, String str2, int i3);
}
