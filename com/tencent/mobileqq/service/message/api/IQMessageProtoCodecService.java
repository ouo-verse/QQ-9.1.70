package com.tencent.mobileqq.service.message.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.service.message.w;

@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IQMessageProtoCodecService extends QRouteApi {
    boolean needProcessEmotion(String str, int i3);

    void processEmotion(w.b bVar);

    void recordCookie(AppInterface appInterface, byte[] bArr);
}
