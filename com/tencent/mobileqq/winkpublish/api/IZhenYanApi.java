package com.tencent.mobileqq.winkpublish.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZhenYanApi extends QRouteApi {
    void recordLeftCache();

    void setUp();
}
