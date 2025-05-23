package com.tencent.mobileqq.leba;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILebaHandler extends QRouteApi {
    String getCommPluginHandlerClassName();

    String getLebaSettingHandlerClassName();
}
