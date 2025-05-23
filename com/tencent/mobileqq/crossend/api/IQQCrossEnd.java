package com.tencent.mobileqq.crossend.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.zplan.luabridge.LuaBasePlugin;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IQQCrossEnd extends QRouteApi {
    HippyAPIProvider getQQCrossHippyAPIProvider();

    LuaBasePlugin getQQCrossLuaPlugin();

    String getQQCrossMiniEntryKey();

    Class getQQCrossMiniPluginClazz();
}
