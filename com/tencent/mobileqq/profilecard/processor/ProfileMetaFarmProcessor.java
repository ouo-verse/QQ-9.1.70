package com.tencent.mobileqq.profilecard.processor;

import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.minigame.metafarm.data.MetaFarmConstants;
import com.tencent.mobileqq.minigame.proto.MiniGameMetaFarmProfile;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.data.ProfileMetaFarmBean;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J@\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016JB\u0010\u0012\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0014j\b\u0012\u0004\u0012\u00020\u0018`\u0016H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/profilecard/processor/ProfileMetaFarmProcessor;", "Lcom/tencent/mobileqq/profilecard/processor/AbsProfileBusinessProcessor;", "appRuntime", "Lmqq/app/AppRuntime;", "(Lmqq/app/AppRuntime;)V", "onProcessProfileService", "", "params", "Landroid/os/Bundle;", IndividuationUrlHelper.UrlId.CARD_HOME, "Lcom/tencent/mobileqq/data/Card;", "respHead", "LSummaryCard/RespHead;", "respSummeryCard", "LSummaryCard/RespSummaryCard;", "businessServices", "Landroid/util/SparseArray;", "Lcom/tencent/mobileqq/profilecard/entity/BusinessRespBuffer;", "onRequestProfileCard", IProfileProtocolConst.PARAM_REQ_SERVICES, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/profilecard/entity/BusinessReqBuffer;", "Lkotlin/collections/ArrayList;", IProfileProtocolConst.PARAM_REQ_0X5EB, "", "Companion", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ProfileMetaFarmProcessor extends AbsProfileBusinessProcessor {
    private static final String TAG = "ProfileMetaFarmProcessor";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMetaFarmProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onRequestProfileCard(Bundle params, ArrayList<BusinessReqBuffer> reqServiceList, ArrayList<Integer> req0x5ebList) {
        Intrinsics.checkNotNullParameter(reqServiceList, "reqServiceList");
        Intrinsics.checkNotNullParameter(req0x5ebList, "req0x5ebList");
        super.onRequestProfileCard(params, reqServiceList, req0x5ebList);
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(MetaFarmConstants.SWITCH_CONFIG_ID, false)) {
            QLog.d(TAG, 1, "onRequestProfileCard config off");
            return;
        }
        MiniGameMetaFarmProfile.GetFarmCardReq getFarmCardReq = new MiniGameMetaFarmProfile.GetFarmCardReq();
        getFarmCardReq.plat.set(1);
        reqServiceList.add(new BusinessReqBuffer(27, getFarmCardReq.toByteArray()));
        req0x5ebList.add(Integer.valueOf(ProfileContants.FIELD_META_FARM_SWITCH));
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onProcessProfileService(Bundle params, Card card, RespHead respHead, RespSummaryCard respSummeryCard, SparseArray<BusinessRespBuffer> businessServices) {
        super.onProcessProfileService(params, card, respHead, respSummeryCard, businessServices);
        if (businessServices == null) {
            return;
        }
        BusinessRespBuffer businessRespBuffer = businessServices.get(27);
        if ((businessRespBuffer != null ? businessRespBuffer.buffer : null) != null) {
            MiniGameMetaFarmProfile.GetFarmCardRsp getFarmCardRsp = new MiniGameMetaFarmProfile.GetFarmCardRsp();
            try {
                getFarmCardRsp.mergeFrom(businessRespBuffer.buffer);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "onProcessProfileService merge rsp fail", th5);
            }
            MiniGameMetaFarmProfile.FarmCard farmCard = getFarmCardRsp.card.get();
            ProfileMetaFarmBean profileMetaFarmBean = new ProfileMetaFarmBean(farmCard.gender.get(), farmCard.uid.get(), farmCard.farm_level.get(), farmCard.status.get(), farmCard.farm_level_icon.get(), farmCard.status_icon.get(), farmCard.status_desc.get(), farmCard.crop_status.get(), farmCard.animal_status.get(), farmCard.fish_status.get(), farmCard.machine_status.get(), farmCard.crop_icon.get(), farmCard.animal_icon.get(), farmCard.fish_icon.get(), farmCard.machine_icon.get());
            if (card != null) {
                card.putBusinessInfo(profileMetaFarmBean);
            }
        }
    }
}
