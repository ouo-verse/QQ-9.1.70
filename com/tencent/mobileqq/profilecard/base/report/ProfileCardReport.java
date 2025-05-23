package com.tencent.mobileqq.profilecard.base.report;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class ProfileCardReport {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileCardReport";

    public ProfileCardReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static int getFromType(ProfileCardInfo profileCardInfo, int i3, boolean z16) {
        if (z16) {
            if (i3 != 8) {
                if (i3 != 1) {
                    if (i3 != 107) {
                        if (profileCardInfo == null || !profileCardInfo.isTroopMemberCard) {
                            if (i3 != 106) {
                                if (i3 != 7) {
                                    if (i3 != 98 && i3 != 129) {
                                        return 15;
                                    }
                                    return 9;
                                }
                                return 6;
                            }
                            return 5;
                        }
                        return 4;
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        if (i3 != 61) {
            if (i3 != 1) {
                if (i3 != 107) {
                    if (profileCardInfo == null || !profileCardInfo.isTroopMemberCard) {
                        if (i3 != 106) {
                            if (i3 != 109) {
                                if (i3 == 59) {
                                    return 7;
                                }
                                if (i3 != 98 && i3 != 129) {
                                    if (i3 == 88) {
                                        return 10;
                                    }
                                    if (i3 != 7) {
                                        return 15;
                                    }
                                    return 11;
                                }
                                return 9;
                            }
                            return 6;
                        }
                        return 5;
                    }
                    return 4;
                }
                return 3;
            }
            return 2;
        }
        return 1;
    }

    public static void reportAddFriendClick(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        ReportController.o(appInterface, "dc00898", "", profileCardInfo.allInOne.uin, "0X800B0B2", "0X800B0B2", 0, 0, "", "", "", "");
    }

    public static void reportChatClick(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        String str;
        String str2 = profileCardInfo.allInOne.uin;
        if (ProfileUtils.isFriend(appInterface, str2)) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(appInterface, "dc00898", "", str2, "0X800B0B1", "0X800B0B1", 0, 0, str, "", "", "");
    }

    public static void reportGivePresentClick(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        String str;
        String str2 = profileCardInfo.allInOne.uin;
        if (ProfileUtils.isFriend(appInterface, str2)) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(appInterface, "dc00898", "", str2, "0X800A1C5", "0X800A1C5", 0, 0, str, "", "", "");
    }

    public static void reportMiniAppClick(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        boolean z16;
        String str;
        AllInOne allInOne = profileCardInfo.allInOne;
        String str2 = allInOne.uin;
        if (allInOne.f260789pa == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(appInterface, "dc00898", "", str2, "0X800B0B5", "0X800B0B5", 0, 0, str, "", "", "");
    }

    public static void reportPresentClick(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        boolean z16;
        String str;
        AllInOne allInOne = profileCardInfo.allInOne;
        String str2 = allInOne.uin;
        if (allInOne.f260789pa == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(appInterface, "dc00898", "", str2, "0X800B0BC", "0X800B0BC", 0, 0, str, "", "", "");
    }

    public static void reportProfileEditClick(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        ReportController.o(appInterface, "dc00898", "", profileCardInfo.allInOne.uin, "0X8007EB6", "0X8007EB6", 0, 0, "", "", "", "");
    }

    public static void reportProfileEntry(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        boolean z16;
        String str;
        String str2;
        String str3;
        if (profileCardInfo == null) {
            return;
        }
        AllInOne allInOne = profileCardInfo.allInOne;
        int i3 = allInOne.f260789pa;
        int i16 = allInOne.profileEntryType;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int fromType = getFromType(profileCardInfo, i16, z16);
        if (profileCardInfo.isTroopMemberCard && !TextUtils.isEmpty(profileCardInfo.troopUin)) {
            str = profileCardInfo.troopUin;
        } else {
            str = "";
        }
        String str4 = str;
        if (z16) {
            ReportController.o(appInterface, "dc00898", "", "", "0X8007EB3", "0X8007EB3", fromType, 0, "", str4, "", "");
            return;
        }
        String str5 = profileCardInfo.allInOne.uin;
        if (ProfileUtils.isFriend(appInterface, str5)) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        if (!ProfilePAUtils.isPaTypeFriend(profileCardInfo.allInOne)) {
            str3 = "1";
        } else {
            str3 = "2";
        }
        ReportController.o(appInterface, "dc00898", "", str5, "0X8007EB4", "0X8007EB4", fromType, 0, str2, str4, str3, "");
    }

    public static void reportQQCircleClick(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        boolean z16;
        String str;
        AllInOne allInOne = profileCardInfo.allInOne;
        String str2 = allInOne.uin;
        if (allInOne.f260789pa == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(appInterface, "dc00898", "", str2, "0X800B0B9", "0X800B0B9", 0, 0, str, "", "", "");
    }

    public static void reportTemplateClick(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        ReportController.o(appInterface, "dc00898", "", profileCardInfo.allInOne.uin, "0X800B0B3", "0X800B0B3", 0, 0, "", "", "", "");
    }

    public static void reportTroopLevelClick(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        boolean z16;
        String str;
        AllInOne allInOne = profileCardInfo.allInOne;
        String str2 = allInOne.uin;
        if (allInOne.f260789pa == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(appInterface, "dc00898", "", str2, "0X800B0B7", "0X800B0B7", 0, 0, str, "", "", "");
    }

    public static void reportTroopProfileCardGivePresentClick(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reportTroopProfileCardGivePresentClick");
        }
        String str2 = profileCardInfo.allInOne.uin;
        if (ProfileUtils.isFriend(appInterface, str2)) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(appInterface, "dc00898", "", str2, "0X800B102", "0X800B102", 0, 0, str, "", "", "");
    }

    public static void reportVideoCallClick(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        ReportController.o(appInterface, "dc00898", "", profileCardInfo.allInOne.uin, "0X8008404", "0X8008404", 0, 0, "", "", "", "");
    }

    public static void reportWeiShiClick(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        boolean z16;
        String str;
        AllInOne allInOne = profileCardInfo.allInOne;
        String str2 = allInOne.uin;
        if (allInOne.f260789pa == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(appInterface, "dc00898", "", str2, "0X800B0BB", "0X800B0BB", 0, 0, str, "", "", "");
    }
}
