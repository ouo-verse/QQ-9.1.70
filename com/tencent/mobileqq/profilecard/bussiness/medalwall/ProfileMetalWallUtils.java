package com.tencent.mobileqq.profilecard.bussiness.medalwall;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ea;

/* loaded from: classes16.dex */
public class ProfileMetalWallUtils {
    static IPatchRedirector $redirector_;

    public ProfileMetalWallUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ProfileMedalWallEntryInfo getProfileMetalWallEntryInfo(QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo) {
        boolean z16;
        Card card;
        if (qQAppInterface != null && profileCardInfo != null) {
            ProfileMedalWallEntryInfo profileMedalWallEntryInfo = new ProfileMedalWallEntryInfo();
            profileMedalWallEntryInfo.showMetalWall = showMedalWall(qQAppInterface, profileCardInfo);
            if (profileCardInfo.allInOne.f260789pa == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && (card = profileCardInfo.card) != null) {
                int i3 = card.iNewCount;
                if (i3 > 0) {
                    profileMedalWallEntryInfo.hasRedPoint = true;
                    profileMedalWallEntryInfo.redPointCount = i3;
                    return profileMedalWallEntryInfo;
                }
                LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) qQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
                boolean d16 = localRedTouchManager.d(localRedTouchManager.j(10016), false);
                if (card.iUpgradeCount > 0 || d16) {
                    profileMedalWallEntryInfo.hasRedPoint = true;
                    profileMedalWallEntryInfo.redPointCount = 0;
                    return profileMedalWallEntryInfo;
                }
                return profileMedalWallEntryInfo;
            }
            return profileMedalWallEntryInfo;
        }
        return null;
    }

    private static boolean showMedalWall(QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo) {
        if (qQAppInterface != null && profileCardInfo != null && profileCardInfo.card != null) {
            AllInOne allInOne = profileCardInfo.allInOne;
            if (allInOne.f260789pa == 0 || ProfilePAUtils.isPaTypeFriend(allInOne)) {
                TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                if ((profileCardInfo.isTroopMemberCard && troopManager.V(profileCardInfo.troopUin)) || ea.x0(qQAppInterface.getApplication(), qQAppInterface.getCurrentAccountUin()) != 1 || profileCardInfo.card.medalSwitchDisable || Utils.G(profileCardInfo.allInOne.uin)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
