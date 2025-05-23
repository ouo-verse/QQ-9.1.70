package com.tencent.mobileqq.vas.profilecard.api.impl;

import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileComponentConst;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.component.accountinfo.VasProfileAccountInfoComponent;
import com.tencent.mobileqq.profilecard.vas.component.background.VasProfileBackgroundComponent;
import com.tencent.mobileqq.profilecard.vas.component.background.VasProfileDiyBackgroundComponent;
import com.tencent.mobileqq.profilecard.vas.component.background.VasProfileSimpleBackgroundComponent;
import com.tencent.mobileqq.profilecard.vas.component.background.VasProfileWzBackgroundComponent;
import com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderDiyComponent;
import com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderGameComponent;
import com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderPhotoComponent;
import com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderSimpleComponent;
import com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderTagComponent;
import com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderV5Component;
import com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderWZRYComponent;
import com.tencent.mobileqq.profilecard.vas.component.taglabel.VasProfileTagLabelComponent;
import com.tencent.mobileqq.profilecard.vas.component.template.VasProfileTemplateComponent;
import com.tencent.mobileqq.vas.profilecard.api.IVasProfileComponentFactory;

/* loaded from: classes20.dex */
public class VasProfileComponentFactoryImpl implements IVasProfileComponentFactory, IProfileComponentConst {
    private static final String TAG = "ProfileVasComponentFactory";

    private static AbsProfileComponent createProfileBgComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        long j3 = profileCardInfo.curUseStyleId;
        if (ProfileTemplateApi.isDiyTemplateStyleID(j3)) {
            return new VasProfileDiyBackgroundComponent(iComponentCenter, profileCardInfo);
        }
        if (j3 != ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC && j3 != ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) {
            if (j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE) {
                return new VasProfileSimpleBackgroundComponent(iComponentCenter, profileCardInfo);
            }
            return new VasProfileBackgroundComponent(iComponentCenter, profileCardInfo);
        }
        return new VasProfileWzBackgroundComponent(iComponentCenter, profileCardInfo);
    }

    private static AbsProfileComponent createProfileHeaderComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        long j3 = profileCardInfo.curUseStyleId;
        if (j3 != ProfileCardTemplate.PROFILE_CARD_STYLE_FRESH && j3 != ProfileCardTemplate.PROFILE_CARD_STYLE_JANYUE && j3 != ProfileCardTemplate.PROFILE_CARD_STYLE_GAME) {
            if (j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_SOCIAL) {
                return new VasProfileHeaderPhotoComponent(iComponentCenter, profileCardInfo);
            }
            if (j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_TAG) {
                return new VasProfileHeaderTagComponent(iComponentCenter, profileCardInfo);
            }
            if (j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE) {
                return new VasProfileHeaderSimpleComponent(iComponentCenter, profileCardInfo);
            }
            if (j3 != ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC && j3 != ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) {
                if (j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_NEW_V800) {
                    return new VasProfileHeaderV5Component(iComponentCenter, profileCardInfo);
                }
                if (ProfileTemplateApi.isDiyTemplateStyleID(j3)) {
                    return new VasProfileHeaderDiyComponent(iComponentCenter, profileCardInfo);
                }
                return null;
            }
            return new VasProfileHeaderWZRYComponent(iComponentCenter, profileCardInfo);
        }
        return new VasProfileHeaderGameComponent(iComponentCenter, profileCardInfo);
    }

    @Override // com.tencent.mobileqq.vas.profilecard.api.IVasProfileComponentFactory
    public AbsProfileComponent create(int i3, IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        if (i3 != 1002) {
            if (i3 != 1003) {
                switch (i3) {
                    case 1032:
                        return new VasProfileAccountInfoComponent(iComponentCenter, profileCardInfo);
                    case 1033:
                        return new VasProfileTagLabelComponent(iComponentCenter, profileCardInfo);
                    case 1034:
                        return new VasProfileTemplateComponent(iComponentCenter, profileCardInfo);
                    default:
                        return null;
                }
            }
            return createProfileBgComponent(iComponentCenter, profileCardInfo);
        }
        return createProfileHeaderComponent(iComponentCenter, profileCardInfo);
    }
}
