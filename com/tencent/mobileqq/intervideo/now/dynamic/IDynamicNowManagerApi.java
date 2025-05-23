package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IDynamicNowManagerApi extends QRouteApi {
    void addJumpCallback();

    int getFirstByFrom(String str);

    AppInterface getQQAppInterface();
}
