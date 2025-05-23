package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IServerTimeApi extends QRouteApi {
    long getServerTime();
}
