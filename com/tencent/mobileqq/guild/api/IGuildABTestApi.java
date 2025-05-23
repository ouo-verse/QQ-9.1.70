package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
@Deprecated
/* loaded from: classes12.dex */
public interface IGuildABTestApi extends QRouteApi {
    boolean isExpHit(String str, String str2);

    void reportExposure(String str);

    void setGuildTabGrayRedPointShowTime(long j3, String str);
}
