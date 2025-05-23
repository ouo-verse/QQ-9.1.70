package com.tencent.mobileqq.app.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IMemoryManagerApi extends QRouteApi {
    long getAvailClassSize();
}
