package com.tencent.mobileqq.relation.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes17.dex */
public interface IIceBreakingMsg extends QRouteApi {
    void handleGetIceBreakHotPicResponse(AppRuntime appRuntime, byte[] bArr, String str);
}
