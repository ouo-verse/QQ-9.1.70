package com.tencent.relation.common.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.relation.common.servlet.b;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRelationCmdHandler extends QRouteApi {
    String getRelationRequestHandlerName();

    void sendRequest(AppInterface appInterface, String str, byte[] bArr, b bVar);
}
