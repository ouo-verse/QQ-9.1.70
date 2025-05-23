package com.tencent.qqnt.emotion.stickerrecommended.zplan.api.impl;

import com.tencent.aio.api.runtime.a;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\"\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/zplan/api/impl/NTZPlanAdapterApiNtImpl;", "Lcom/tencent/qqnt/emotion/stickerrecommended/zplan/api/INTZPlanAdapterApi;", "", "isCmShowKeywordAssociationEnabled", "", "scene", "uin", "isZPlanAccessible", "", "portraitId", "", "selfUin", "Lorg/json/JSONObject;", "emoticonJson", "isEmoticonPicRecorded", "", "recordEmoticonFromRecommend", "hasCustomDressUp", "getZPlanVersion", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "isContrast", "experimentGrpId", "isExperiment", "reportExpExposure", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "showZPlanEmoticonGrayTips", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NTZPlanAdapterApiNtImpl implements INTZPlanAdapterApi {
    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    @NotNull
    public String getZPlanVersion() {
        return "0";
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public boolean hasCustomDressUp(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public boolean isCmShowKeywordAssociationEnabled() {
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public boolean isContrast(@NotNull String expName) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public boolean isEmoticonPicRecorded(int portraitId, @NotNull String selfUin, @Nullable JSONObject emoticonJson) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public boolean isExperiment(@NotNull String expName, @NotNull String experimentGrpId) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        Intrinsics.checkNotNullParameter(experimentGrpId, "experimentGrpId");
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public boolean isZPlanAccessible(long scene, long uin) {
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public void recordEmoticonFromRecommend(int portraitId, @NotNull String selfUin, @Nullable JSONObject emoticonJson) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public void reportExpExposure(@NotNull String expName) {
        Intrinsics.checkNotNullParameter(expName, "expName");
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public void showZPlanEmoticonGrayTips(@NotNull a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
    }
}
