package com.tencent.mobileqq.profilecard.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes35.dex */
public class PersonalityLabelUtil {
    private static final String TAG = "PersonalityLabelUtil";

    private static boolean isConfigDisable(AppInterface appInterface) {
        IProfileConfig createProfileConfig = ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).createProfileConfig(appInterface);
        return (createProfileConfig == null || createProfileConfig.isSwitchEnable(3)) ? false : true;
    }

    public static boolean isNeedShowPersonalityLabel(AllInOne allInOne, ProfilePersonalityLabelInfo profilePersonalityLabelInfo, AppInterface appInterface) {
        if (allInOne != null) {
            if (ProfilePAUtils.isPaTypeStrangerInContact(allInOne)) {
                QLog.i(TAG, 2, "is strange in contact");
                return false;
            }
            if (Utils.G(allInOne.uin)) {
                QLog.i(TAG, 2, "is BabyQ");
                return false;
            }
        }
        if (profilePersonalityLabelInfo != null && profilePersonalityLabelInfo.isCloseByUser == 1) {
            QLog.i(TAG, 2, "close by user");
            return false;
        }
        if (appInterface == null || !isConfigDisable(appInterface)) {
            return true;
        }
        QLog.i(TAG, 2, "config disable");
        return false;
    }
}
