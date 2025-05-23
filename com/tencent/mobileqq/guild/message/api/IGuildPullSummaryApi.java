package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import st1.f;

@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildPullSummaryApi extends QRouteApi {
    f getGuildPullSummaryAdapter();
}
