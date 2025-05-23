package com.tencent.mobileqq.guild.nt.perf.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IPerfApi extends QRouteApi {
    void startMonitorDropFrame(@NonNull String str);

    void stopMonitorDropFrame(@NonNull String str);
}
