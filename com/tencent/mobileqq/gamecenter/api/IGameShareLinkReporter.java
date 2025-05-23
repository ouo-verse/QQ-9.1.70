package com.tencent.mobileqq.gamecenter.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameShareLinkReporter extends QRouteApi {
    void reportGameShareLink(String str);
}
