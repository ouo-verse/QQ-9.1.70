package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmoticonMainPanelAppService extends QRouteApi {
    IEmoticonMainPanelApp createEmoticonMainPanelApp(AppRuntime appRuntime);
}
