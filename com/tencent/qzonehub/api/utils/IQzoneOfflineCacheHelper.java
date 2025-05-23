package com.tencent.qzonehub.api.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneOfflineCacheHelper extends QRouteApi {
    void clearQZoneAppCache();

    long getSmallGameLastCacheTime(long j3);

    void updataSmallGameLastCacheFinishTime(long j3, long j16);
}
