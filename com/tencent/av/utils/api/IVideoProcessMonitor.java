package com.tencent.av.utils.api;

import android.os.IBinder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = true)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IVideoProcessMonitor extends QRouteApi {
    void clearMonitorBinder();

    boolean isVideoProcessAlive();

    void setMonitorBinder(IBinder iBinder);
}
