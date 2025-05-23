package com.tencent.mobileqq.nearby.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface;
import com.tencent.mobileqq.intervideo.huayang.IHuayangDowanloadHelper;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.MobileQQ;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IFactoryApi extends QRouteApi {
    IHuayangDowanloadHelper getHuaYangDownLoadHelper(AppInterface appInterface, String str, String str2);

    IVPluginReportInterface getIVPluginReportInterface();

    INearbyAppInterface getNearbyAppInterface(MobileQQ mobileQQ, String str);

    com.tencent.mobileqq.nearby.ipc.b getNearbyProcManager(AppInterface appInterface);

    a getNearbyProxy(Object obj);

    void monitorReport(String str);

    void monitorTrigger(String str);
}
