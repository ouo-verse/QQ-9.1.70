package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildArkStrokeApi extends QRouteApi {
    int getRoundRadius();

    String getStrokeColor();

    int getStrokeWidth();

    boolean isNeedStroke(String str);
}
