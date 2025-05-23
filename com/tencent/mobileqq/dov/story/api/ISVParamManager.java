package com.tencent.mobileqq.dov.story.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface ISVParamManager extends QRouteApi {
    int getBitRate(int i3);
}
