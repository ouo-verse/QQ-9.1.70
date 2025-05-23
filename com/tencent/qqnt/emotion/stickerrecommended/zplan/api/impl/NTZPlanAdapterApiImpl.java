package com.tencent.qqnt.emotion.stickerrecommended.zplan.api.impl;

import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.emoticon.grayTip.ZPlanEmoticonGrayTipNTHelper;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi;
import com.tencent.shadow.dynamic.host.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\"\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0016J\"\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/zplan/api/impl/NTZPlanAdapterApiImpl;", "Lcom/tencent/qqnt/emotion/stickerrecommended/zplan/api/INTZPlanAdapterApi;", "", "getZPlanVersion", "uin", "", "hasCustomDressUp", "isCmShowKeywordAssociationEnabled", "", "portraitId", "selfUin", "Lorg/json/JSONObject;", "emoticonJson", "isEmoticonPicRecorded", "", "scene", "isZPlanAccessible", "", "recordEmoticonFromRecommend", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "isContrast", "experimentGrpId", "isExperiment", "reportExpExposure", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "showZPlanEmoticonGrayTips", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class NTZPlanAdapterApiImpl implements INTZPlanAdapterApi {
    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public String getZPlanVersion() {
        return ((IZPlanApi) QRoute.api(IZPlanApi.class)).getZPlanVersion();
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public boolean hasCustomDressUp(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(uin).hasCustomDressUp();
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public boolean isCmShowKeywordAssociationEnabled() {
        return ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).isCmShowKeywordAssociationEnabled();
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public boolean isContrast(String expName) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        return ABTestController.getInstance().getExpEntity(expName).isContrast();
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public boolean isEmoticonPicRecorded(int portraitId, String selfUin, JSONObject emoticonJson) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        return ((IZPlanApi) QRoute.api(IZPlanApi.class)).isEmoticonPicRecorded(portraitId, selfUin, emoticonJson);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public boolean isExperiment(String expName, String experimentGrpId) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        Intrinsics.checkNotNullParameter(experimentGrpId, "experimentGrpId");
        return ABTestController.getInstance().getExpEntity(expName).isExperiment(experimentGrpId);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public boolean isZPlanAccessible(long scene, long uin) {
        return ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(Constant.FROM_ID_START_ACTIVITY, uin);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public void recordEmoticonFromRecommend(int portraitId, String selfUin, JSONObject emoticonJson) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).recordEmoticonFromRecommend(portraitId, selfUin, emoticonJson);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public void reportExpExposure(String expName) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        ABTestController.getInstance().getExpEntity(expName).reportExpExposure();
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi
    public void showZPlanEmoticonGrayTips(a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        ZPlanEmoticonGrayTipNTHelper.f333115a.j(aioContext);
    }
}
