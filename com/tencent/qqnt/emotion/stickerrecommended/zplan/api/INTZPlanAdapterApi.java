package com.tencent.qqnt.emotion.stickerrecommended.zplan.api;

import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J\"\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\nH&J\b\u0010\u0012\u001a\u00020\nH&J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\nH&J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH&J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\nH&J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/zplan/api/INTZPlanAdapterApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isCmShowKeywordAssociationEnabled", "", "scene", "uin", "isZPlanAccessible", "", "portraitId", "", "selfUin", "Lorg/json/JSONObject;", "emoticonJson", "isEmoticonPicRecorded", "", "recordEmoticonFromRecommend", "hasCustomDressUp", "getZPlanVersion", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "isContrast", "experimentGrpId", "isExperiment", "reportExpExposure", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "showZPlanEmoticonGrayTips", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface INTZPlanAdapterApi extends QRouteApi {
    @NotNull
    String getZPlanVersion();

    boolean hasCustomDressUp(@NotNull String uin);

    boolean isCmShowKeywordAssociationEnabled();

    boolean isContrast(@NotNull String expName);

    boolean isEmoticonPicRecorded(int portraitId, @NotNull String selfUin, @Nullable JSONObject emoticonJson);

    boolean isExperiment(@NotNull String expName, @NotNull String experimentGrpId);

    boolean isZPlanAccessible(long scene, long uin);

    void recordEmoticonFromRecommend(int portraitId, @NotNull String selfUin, @Nullable JSONObject emoticonJson);

    void reportExpExposure(@NotNull String expName);

    void showZPlanEmoticonGrayTips(@NotNull a aioContext);
}
