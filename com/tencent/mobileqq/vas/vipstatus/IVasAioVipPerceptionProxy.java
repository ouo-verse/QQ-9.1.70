package com.tencent.mobileqq.vas.vipstatus;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/vipstatus/IVasAioVipPerceptionProxy;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "longClickVoiceMsg", "", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "voiceMsg30s", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasAioVipPerceptionProxy extends QRouteApi {
    void longClickVoiceMsg(@NotNull AIOMsgItem msgItem);

    void voiceMsg30s(@NotNull AIOMsgItem msgItem);
}
