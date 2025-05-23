package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGuildDiscoverRecommendApi extends QRouteApi {
    JSONObject getBannerData();

    com.tencent.qqperf.monitor.crash.safemode.a getDiscoverSafeModeStartUpRunner();
}
