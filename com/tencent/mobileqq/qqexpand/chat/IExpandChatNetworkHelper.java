package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/IExpandChatNetworkHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "", "matchUin", "Lcom/tencent/mobileqq/qqexpand/network/d;", "callback", "", "requestAbleToGreet", "reportGreet", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IExpandChatNetworkHelper extends QRouteApi {
    void reportGreet(@NotNull BaseQQAppInterface app, long matchUin, @NotNull com.tencent.mobileqq.qqexpand.network.d callback);

    void requestAbleToGreet(@NotNull BaseQQAppInterface app, long matchUin, @NotNull com.tencent.mobileqq.qqexpand.network.d callback);
}
