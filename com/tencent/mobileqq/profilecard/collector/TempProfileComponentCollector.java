package com.tencent.mobileqq.profilecard.collector;

import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardYuanMengApi;
import com.tencent.mobileqq.profilecard.api.IProfileGameCardApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileComponentConst;
import com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileHeaderContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileLogicContainer;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelComponent;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelHeaderComponent;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;
import com.tencent.mobileqq.profilecard.bussiness.diamondwall.ProfileDiamondWallComponent;
import com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent;
import com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMediaWallComponent;
import com.tencent.mobileqq.profilecard.bussiness.miniapp.ProfileMiniAppComponent;
import com.tencent.mobileqq.profilecard.bussiness.musicbox.ProfileMusicBoxComponent;
import com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.OldProfileContentSignComponent;
import com.tencent.mobileqq.profilecard.bussiness.presentwall.ProfilePresentWallComponent;
import com.tencent.mobileqq.profilecard.bussiness.qqcard.BaseProfileQQCardComponent;
import com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent;
import com.tencent.mobileqq.profilecard.bussiness.thirdapp.ProfileThirdAppComponent;
import com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent;
import com.tencent.mobileqq.profilecard.vas.component.baseinfo.ProfileBaseInfoComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.profilecard.colorscreen.IVasColorScreenKuikly;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class TempProfileComponentCollector implements IProfileComponentCollector, IProfileComponentConst {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TempProfileComponentCollector";

    public TempProfileComponentCollector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.collector.IProfileComponentCollector
    public SparseArray<Class<? extends AbsProfileComponent>> collect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SparseArray) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        SparseArray<Class<? extends AbsProfileComponent>> sparseArray = new SparseArray<>();
        sparseArray.put(102, ProfileHeaderContainer.class);
        sparseArray.put(106, ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).getElegantProfileTitleContainerClazz());
        sparseArray.put(107, ProfileBottomContainer.class);
        sparseArray.put(108, ProfileLogicContainer.class);
        if (ar.b("rizzhuang", "2024-12-26", "vas_simple_mode_colorscreen_fix").isEnable(true) && SimpleUIUtil.getSimpleUISwitch()) {
            QLog.i(TAG, 1, "Now in SimpleUIMode, skip register colorScreenComponent.");
        } else if (((IVasColorScreenKuikly) QRoute.api(IVasColorScreenKuikly.class)).getEnable()) {
            sparseArray.put(1004, ((IVasColorScreenKuikly) QRoute.api(IVasColorScreenKuikly.class)).getClazz());
        } else {
            sparseArray.put(1004, ProfileColorScreenComponent.class);
        }
        sparseArray.put(1010, ProfilePersonalityLabelComponent.class);
        sparseArray.put(1011, OldProfileContentSignComponent.class);
        sparseArray.put(1012, ProfileQZoneComponent.class);
        sparseArray.put(1013, ProfileTroopMemInfoComponent.class);
        sparseArray.put(1014, ProfileMiniAppComponent.class);
        sparseArray.put(1017, ProfileMusicBoxComponent.class);
        sparseArray.put(1018, ProfilePresentWallComponent.class);
        sparseArray.put(1019, ProfileDiamondWallComponent.class);
        sparseArray.put(1021, ProfileAccountLevelComponent.class);
        sparseArray.put(1022, ProfileAccountLevelHeaderComponent.class);
        sparseArray.put(1025, ProfileMediaWallComponent.class);
        sparseArray.put(1027, ProfileTroopFansInfoComponent.class);
        sparseArray.put(1028, ((IProfileCardYuanMengApi) QRoute.api(IProfileCardYuanMengApi.class)).getWangZheProfileCardComponentClazz());
        sparseArray.put(1047, ((IProfileCardYuanMengApi) QRoute.api(IProfileCardYuanMengApi.class)).getYuanMengProfileCardComponentClazz());
        sparseArray.put(1049, ((IProfileGameCardApi) QRoute.api(IProfileGameCardApi.class)).getGameCardComponentClazz());
        sparseArray.put(1031, ProfileThirdAppComponent.class);
        sparseArray.put(1035, ProfileBaseInfoComponent.class);
        sparseArray.put(1043, BaseProfileDressUpComponent.class);
        sparseArray.put(1044, BaseProfileQQCardComponent.class);
        return sparseArray;
    }
}
