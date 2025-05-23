package com.tencent.qq.minibox.api.metadream;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cs3.b;
import cs3.c;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IMetaDreamServiceApi extends QRouteApi {
    public static final String PACKAGE_NAME = "com.tencent.letsgo";

    void getExtraInfo(c cVar);

    Bundle getLaunchExtendBundle();

    boolean isMetaDreamEnvDebug();

    void pauseDownloadRes();

    void registerDownloadCallback(b bVar);

    void startDownloadRes();

    void stopDownloadRes();

    void unregisterDownloadCallback(b bVar);
}
