package com.tencent.mobileqq.transfile.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IQuicSoLoadApi extends QRouteApi {
    boolean loadQuicSo();
}
