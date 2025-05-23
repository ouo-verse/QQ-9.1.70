package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyService extends QRouteApi {
    Class getDynamicNowManagerClass();

    Class getGroupVideoManagerClass();

    String getHuayangPluginLauncherClassName();

    String getHuayangPluginNewDownloaderClassName();

    Class getLocalRedTouchManagerClass();

    Class getMiniCardManagerClass();

    String getNearbyCardHandlerClassName();

    Class getNearbyCardManagerClass();

    Class getNearbyGeneralManagerClass();

    Class getNearbyHandlerClass();

    Class getNearbyLikeLimitManagerClass();

    Class getNearbyMomentManagerClass();

    Class getNearbyProxyClass();

    Class getNearbyReceiverClass();

    String getNearbyRelevantHandlerClassName();

    String getNowChannerHandlerV2ClassName();

    int getQQNearbyFactoryCountManager();

    Class getSmallVideoFragmentClass();
}
