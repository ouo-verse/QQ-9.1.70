package com.tencent.mobileqq.intervideo;

import com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;

@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IPluginEnterManager extends QRouteApi {
    String getLastBizType();

    void switchBiz(String str, PluginProcessKiller pluginProcessKiller);

    void switchBiz(String str, DynamicPluginManager dynamicPluginManager);
}
