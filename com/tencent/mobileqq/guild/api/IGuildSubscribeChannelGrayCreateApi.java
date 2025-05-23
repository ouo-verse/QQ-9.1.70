package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildSubscribeChannelGrayCreateApi extends QRouteApi {
    boolean isOverAlreadyAddedThreshold(AppRuntime appRuntime);

    boolean isOverGrayShowCycle(String str);

    boolean isOverOpensThreshold(String str, String str2);

    boolean isOverSpeakingThreshold(String str, String str2);

    void setChannelSubscribeGrayShowTime(String str);
}
