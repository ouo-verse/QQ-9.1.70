package com.tencent.mobileqq.onlinestatus.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.aio.api.f;
import com.tencent.qqnt.aio.api.g;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IOnlineStatusLikeStatusApi extends QRouteApi {
    void clearOnlineStatusCallback();

    void getLikeStatusUserReq(AppInterface appInterface, ArrayList<String> arrayList, g gVar, int i3);

    String getOnlineStatusAggregationHandlerName();

    void sendLikeStatusReq(AppInterface appInterface, String str, int i3, int i16, int i17, f fVar, byte[] bArr);
}
