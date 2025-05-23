package com.tencent.qqnt.chats.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0006\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chats/api/IChatPartConvertProcessor;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createSummaryConvertProcessor", "T", "()Ljava/lang/Object;", "createTimeConvertProcessor", "createTitleConvertProcessor", "createUnreadConvertProcessor", "chats_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IChatPartConvertProcessor extends QRouteApi {
    <T> T createSummaryConvertProcessor();

    <T> T createTimeConvertProcessor();

    <T> T createTitleConvertProcessor();

    <T> T createUnreadConvertProcessor();
}
