package com.tencent.mobileqq.profilecard.utils;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.multyple.ProfileCardVersion;
import com.tencent.mobileqq.profilecard.version.ProfileCardVersionController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ITroopMemberTempApi;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ProfileCardUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileCardUtil";

    public ProfileCardUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ProfileCardInfo fillProfileCardInfo(ContactCard contactCard) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "fillProfileCardInfo.currentThread:" + Thread.currentThread().getName());
        }
        ProfileCardInfo profileCardInfo = new ProfileCardInfo();
        if (ProfileCardVersionController.getVersion().equals(ProfileCardVersion.V_ELEGANT)) {
            Card card = new Card();
            card.shGender = contactCard.bSex;
            card.age = contactCard.bAge;
            card.strProvince = contactCard.strProvince;
            card.strCity = contactCard.strCity;
            card.strCountry = contactCard.strCountry;
            card.strNick = contactCard.nickName;
            card.vRichSign = contactCard.vRichSign;
            card.isForbidAccount = contactCard.isForbidAccount;
            card.forbidCode = contactCard.forbidCode;
            if (!((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isContactProfileElegantVersion()) {
                card.vCoverInfo = contactCard.vCoverInfo;
            }
            profileCardInfo.card = card;
        }
        profileCardInfo.contactCard = contactCard;
        return profileCardInfo;
    }

    public static void initNameArray(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        ProfileContactInfo cardContactInfo;
        TroopMemberInfo troopMemberInfo;
        AllInOne allInOne = profileCardInfo.allInOne;
        String str = allInOne.nickname;
        String str2 = allInOne.remark;
        String str3 = allInOne.troopNickName;
        String str4 = allInOne.recommendName;
        String str5 = allInOne.contactName;
        String str6 = allInOne.alias;
        String str7 = allInOne.circleName;
        try {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(profileCardInfo.allInOne.uin);
            if (ProfilePAUtils.isPaTypeFriend(profileCardInfo.allInOne)) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, TAG);
                if (friendsSimpleInfoWithUid != null) {
                    if (!TextUtils.isEmpty(friendsSimpleInfoWithUid.p())) {
                        str = friendsSimpleInfoWithUid.p();
                    }
                    if (!TextUtils.isEmpty(friendsSimpleInfoWithUid.r())) {
                        str2 = friendsSimpleInfoWithUid.r();
                    }
                }
            } else if (profileCardInfo.allInOne.f260789pa == 0) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid2 = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, TAG);
                if (friendsSimpleInfoWithUid2 != null) {
                    str = !TextUtils.isEmpty(friendsSimpleInfoWithUid2.p()) ? friendsSimpleInfoWithUid2.p() : profileCardInfo.allInOne.uin;
                }
            } else if (TextUtils.isEmpty(str) && ProfilePAUtils.isPaTypeHasUin(profileCardInfo.allInOne)) {
                com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                aVar.d(uidFromUin);
                str = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
                if (Utils.p(str, profileCardInfo.allInOne.uin)) {
                    str = null;
                }
            }
            if (!TextUtils.isEmpty(profileCardInfo.troopUin) && (troopMemberInfo = (TroopMemberInfo) ((ITroopMemberTempApi) QRoute.api(ITroopMemberTempApi.class)).getTroopMemberInfoSync(profileCardInfo.troopUin, profileCardInfo.allInOne.uin, TAG)) != null) {
                str3 = troopMemberInfo.troopColorNick;
            }
            if (TextUtils.isEmpty(str5) && (cardContactInfo = ProfileUtils.getCardContactInfo(profileCardInfo.allInOne)) != null) {
                str5 = cardContactInfo.phoneName;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "initNameList fail.", e16);
        }
        String str8 = str5;
        synchronized (profileCardInfo.nameArray) {
            setCardInfoNameArray(profileCardInfo, str, str2, str3, str4, str8, str6, str7);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initNameList(), strNick = " + Utils.U(str) + ", strRemark = " + Utils.U(str2) + ", strContactName = " + Utils.U(str8) + ", strRecommendName = " + Utils.U(str4) + ", strTroopNickName = " + Utils.U(str3) + ", strCircleName = " + Utils.U(str7) + ", strAutoRemark = " + Utils.U(str4));
        }
    }

    public static boolean isContactNicknameValid(String str) {
        if (!TextUtils.isEmpty(str) && !"isNull".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean isFriend(String str) {
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), TAG);
    }

    private static void setCardInfoNameArray(ProfileCardInfo profileCardInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (TextUtils.isEmpty(profileCardInfo.nameArray[0])) {
            profileCardInfo.nameArray[0] = str;
        }
        if (TextUtils.isEmpty(profileCardInfo.nameArray[4])) {
            profileCardInfo.nameArray[4] = str2;
        }
        if (TextUtils.isEmpty(profileCardInfo.nameArray[3])) {
            profileCardInfo.nameArray[3] = str5;
        }
        if (TextUtils.isEmpty(profileCardInfo.nameArray[5])) {
            profileCardInfo.nameArray[5] = str4;
        }
        if (TextUtils.isEmpty(profileCardInfo.nameArray[1])) {
            profileCardInfo.nameArray[1] = str3;
        }
        if (TextUtils.isEmpty(profileCardInfo.nameArray[6])) {
            profileCardInfo.nameArray[6] = str6;
        }
        if (TextUtils.isEmpty(profileCardInfo.nameArray[2])) {
            profileCardInfo.nameArray[2] = str7;
        }
    }

    public static boolean shouldNotifyUpdateCardOnFail(ProfileCardInfo profileCardInfo) {
        AllInOne allInOne;
        AppRuntime peekAppRuntime;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("profile_card_account_forbid_8975_switch", true) || profileCardInfo == null || (allInOne = profileCardInfo.allInOne) == null || TextUtils.isEmpty(allInOne.uin) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        Card profileCard = ((IProfileDataService) peekAppRuntime.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(profileCardInfo.allInOne.uin, true);
        if (profileCard == null) {
            return false;
        }
        QLog.i(TAG, 1, "shouldNotifyUpdateCardOnFail:" + profileCard.isForbidAccount);
        return profileCard.isForbidAccount;
    }
}
