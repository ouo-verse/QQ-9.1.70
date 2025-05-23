package com.tencent.mobileqq.vas.theme.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface INormalNightModeHandler extends QRouteApi {
    void reqGetNormalNightModeSwitch(BaseQQAppInterface baseQQAppInterface, String str);

    void reqSetNormalNightModeSwitch(AppRuntime appRuntime, boolean z16);
}
