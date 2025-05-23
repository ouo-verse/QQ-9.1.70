package com.tencent.relation.common.servlet;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRelationSSORequestHandler extends QRouteApi {
    void request(AppRuntime appRuntime, String str, byte[] bArr, c cVar);
}
