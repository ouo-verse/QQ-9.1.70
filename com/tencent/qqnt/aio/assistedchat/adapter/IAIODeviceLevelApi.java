package com.tencent.qqnt.aio.assistedchat.adapter;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/adapter/IAIODeviceLevelApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "levelHigh", "", "getLevelHigh", "()I", "levelLow", "getLevelLow", "levelMedium", "getLevelMedium", "getDeviceLevel", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIODeviceLevelApi extends QRouteApi {
    int getDeviceLevel();

    int getLevelHigh();

    int getLevelLow();

    int getLevelMedium();
}
