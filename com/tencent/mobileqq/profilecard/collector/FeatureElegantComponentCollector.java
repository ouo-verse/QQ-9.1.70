package com.tencent.mobileqq.profilecard.collector;

import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileComponentConst;
import com.tencent.mobileqq.profilecard.base.container.ProfileHeaderContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileLogicContainer;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.ElegantNewProfileAccountLevelComponent;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelHeaderComponent;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;
import com.tencent.mobileqq.profilecard.bussiness.cub.ProfileQCubComponent;
import com.tencent.mobileqq.profilecard.bussiness.diamondwall.ElegantProfileDiamondWallComponent;
import com.tencent.mobileqq.profilecard.bussiness.dressup.ProfileDressUpComponent;
import com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMediaWallComponent;
import com.tencent.mobileqq.profilecard.bussiness.miniapp.ElegantProfileMiniAppComponent;
import com.tencent.mobileqq.profilecard.bussiness.musicbox.ElegantProfileMusicBoxComponent;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.ElegantProfileContentSignComponent;
import com.tencent.mobileqq.profilecard.bussiness.presentwall.ElegantProfilePresentWallComponent;
import com.tencent.mobileqq.profilecard.bussiness.qqcard.ProfileQQCardComponent;
import com.tencent.mobileqq.profilecard.bussiness.qzone.ElegantProfileQZoneComponent;
import com.tencent.mobileqq.profilecard.bussiness.thirdapp.ProfileThirdAppComponent;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent;
import com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileGameCardComponent;
import com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileTroopMemGameInfoComponent;
import com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileTroopYuanMengComponent;
import com.tencent.mobileqq.profilecard.component.ElegantProfileFavorComponent;
import com.tencent.mobileqq.profilecard.component.ProfileInStepComponent;
import com.tencent.mobileqq.profilecard.component.ProfileIntimateComponent;
import com.tencent.mobileqq.profilecard.component.ProfileMetaFarmComponent;
import com.tencent.mobileqq.profilecard.component.ProfileMusicDataComponent;
import com.tencent.mobileqq.profilecard.component.content.ElegantProfileAddProfileComponent;
import com.tencent.mobileqq.profilecard.component.content.photowall.ElegantPhotoWallComponent;
import com.tencent.mobileqq.profilecard.component.head.ElegantProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.component.personalitylabel.ElegantProfilePersonalityLabelComponent;
import com.tencent.mobileqq.profilecard.component.pymk.ProfileRecReasonComponent;
import com.tencent.mobileqq.profilecard.component.troop.ElegantProfileTroopMemInfoComponent;
import com.tencent.mobileqq.profilecard.container.ElegantBgContainer;
import com.tencent.mobileqq.profilecard.container.ElegantContentContainer;
import com.tencent.mobileqq.profilecard.container.bottomcontainer.ElegantProfileBottomContainer;
import com.tencent.mobileqq.profilecard.container.titlecontainer.ElegantProfileTitleContainer;
import com.tencent.mobileqq.profilecard.vas.component.baseinfo.ProfileBaseInfoComponent;
import com.tencent.mobileqq.profilecard.vas.component.template.VasProfileTemplateComponent;
import com.tencent.mobileqq.profilecard.view.vas.VasBaseBGComponent;
import com.tencent.mobileqq.profilecard.view.vas.svipPrivilege.VasSvipPrivilegeComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.profilecard.colorscreen.IVasColorScreenKuikly;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class FeatureElegantComponentCollector implements IProfileComponentCollector, IProfileComponentConst {
    private static final String TAG = "FeatureElegantComponentCollector";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.collector.IProfileComponentCollector
    public SparseArray<Class<? extends AbsProfileComponent>> collect() {
        SparseArray<Class<? extends AbsProfileComponent>> sparseArray = new SparseArray<>();
        sparseArray.put(102, ProfileHeaderContainer.class);
        sparseArray.put(106, ElegantProfileTitleContainer.class);
        sparseArray.put(103, ElegantContentContainer.class);
        sparseArray.put(107, ElegantProfileBottomContainer.class);
        sparseArray.put(104, ElegantBgContainer.class);
        sparseArray.put(108, ProfileLogicContainer.class);
        sparseArray.put(1002, ElegantProfileHeaderComponent.class);
        if (SimpleUIUtil.getSimpleUISwitch()) {
            QLog.i(TAG, 1, "Now in SimpleUIMode, skip register colorScreenComponent.");
        } else {
            IVasColorScreenKuikly iVasColorScreenKuikly = (IVasColorScreenKuikly) QRoute.api(IVasColorScreenKuikly.class);
            if (iVasColorScreenKuikly.getEnable()) {
                sparseArray.put(1004, iVasColorScreenKuikly.getClazz());
            } else {
                sparseArray.put(1004, ProfileColorScreenComponent.class);
            }
        }
        sparseArray.put(1010, ElegantProfilePersonalityLabelComponent.class);
        sparseArray.put(1011, ElegantProfileContentSignComponent.class);
        sparseArray.put(1012, ElegantProfileQZoneComponent.class);
        sparseArray.put(1013, ElegantProfileTroopMemInfoComponent.class);
        sparseArray.put(1014, ElegantProfileMiniAppComponent.class);
        sparseArray.put(1017, ElegantProfileMusicBoxComponent.class);
        sparseArray.put(1018, ElegantProfilePresentWallComponent.class);
        sparseArray.put(1019, ElegantProfileDiamondWallComponent.class);
        sparseArray.put(1021, ElegantNewProfileAccountLevelComponent.class);
        sparseArray.put(1022, ProfileAccountLevelHeaderComponent.class);
        sparseArray.put(1025, ProfileMediaWallComponent.class);
        sparseArray.put(1027, ProfileTroopFansInfoComponent.class);
        sparseArray.put(1028, ElegantProfileTroopMemGameInfoComponent.class);
        sparseArray.put(1047, ElegantProfileTroopYuanMengComponent.class);
        sparseArray.put(1049, ElegantProfileGameCardComponent.class);
        sparseArray.put(1031, ProfileThirdAppComponent.class);
        sparseArray.put(1035, ProfileBaseInfoComponent.class);
        sparseArray.put(1006, ElegantProfileFavorComponent.class);
        sparseArray.put(1009, ElegantPhotoWallComponent.class);
        sparseArray.put(1038, ElegantProfileAddProfileComponent.class);
        sparseArray.put(1034, VasProfileTemplateComponent.class);
        sparseArray.put(1041, ProfileInStepComponent.class);
        sparseArray.put(1042, ProfileIntimateComponent.class);
        sparseArray.put(1003, VasBaseBGComponent.class);
        sparseArray.put(1043, ProfileDressUpComponent.class);
        sparseArray.put(1044, ProfileQQCardComponent.class);
        sparseArray.put(1045, VasSvipPrivilegeComponent.class);
        sparseArray.put(1046, ProfileQCubComponent.class);
        sparseArray.put(1048, ProfileMusicDataComponent.class);
        sparseArray.put(1050, ProfileMetaFarmComponent.class);
        sparseArray.put(1051, ProfileRecReasonComponent.class);
        return sparseArray;
    }
}
