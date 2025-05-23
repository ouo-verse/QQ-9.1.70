package com.tencent.mobileqq.qqlive.api.config;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQLiveEntranceConfigApi extends QRouteApi {
    boolean isEntranceOpen();

    boolean showQCircleEntrance();
}
