package com.tencent.mobileqq.troop.topicrecommend.api;

import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.topicrecommend.b;
import com.tencent.qqnt.kernel.nativeinterface.ITopicRecallCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H&J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0006H&J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0006H&J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/topicrecommend/api/ITroopTopicRecommendApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "isPushAIO", "", "groupCode", "recallId", "Lcom/tencent/qqnt/kernel/nativeinterface/ITopicRecallCallback;", "callback", "", "getTopicRecall", "Lcom/tencent/mobileqq/troop/topicrecommend/a;", "data", "topicFeedback", "troopUin", "isSwitchOn", "Lcom/tencent/mobileqq/troop/topicrecommend/b;", "getTroopExpandInfo", "onClickNavigation", "isTroopAIVoiceChatActive", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopTopicRecommendApi extends QRouteApi {
    void getTopicRecall(@NotNull String groupCode, @Nullable String recallId, @NotNull ITopicRecallCallback callback);

    @NotNull
    b getTroopExpandInfo(@NotNull String troopUin);

    boolean isPushAIO(@NotNull a aioContext);

    boolean isSwitchOn(@NotNull String troopUin);

    boolean isTroopAIVoiceChatActive(@Nullable a aioContext);

    void onClickNavigation(@NotNull String troopUin);

    void topicFeedback(@NotNull com.tencent.mobileqq.troop.topicrecommend.a data);
}
