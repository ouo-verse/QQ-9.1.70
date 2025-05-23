package com.tencent.mobileqq.perf.api;

import android.os.Debug;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IMemoryUtilApi extends QRouteApi {
    Debug.MemoryInfo getThrottledMemoryInfo(int i3);

    long getThrottledMemoryTime();
}
