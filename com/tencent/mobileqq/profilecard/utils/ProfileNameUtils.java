package com.tencent.mobileqq.profilecard.utils;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class ProfileNameUtils {
    static IPatchRedirector $redirector_ = null;
    private static final int[] HANDLE_UPDATE_PROFILE_NAME_TYPE;
    private static final String TAG = "ProfileNameUtils";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class ProfileTypeParam {
        static IPatchRedirector $redirector_;
        int fromType;
        int idType;

        ProfileTypeParam() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.fromType = 1;
                this.idType = 1;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "ProfileTypeParam{fromType=" + this.fromType + ", idType=" + this.idType + '}';
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41960);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            HANDLE_UPDATE_PROFILE_NAME_TYPE = new int[]{0, 60, 1, 20, 21, 58, 22, 46, 47, 30, 31, 32, 33, 34, 36, 29, 53, 40, 41, 42, 86, 50, 51, 52, 4, 77, 82, 81, 83, 84, 101, 103, 102, 107, 110, 25, 28, 108, 26, 27, 72, 71};
        }
    }

    public ProfileNameUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getCurCardName(ProfileCardInfo profileCardInfo) {
        String str;
        String[] strArr;
        String[] strArr2 = profileCardInfo.nameArray;
        if (strArr2 != null && strArr2.length > 4) {
            str = strArr2[4];
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str) && (strArr = profileCardInfo.nameArray) != null && strArr.length > 0) {
            str = strArr[0];
        }
        if (TextUtils.isEmpty(str)) {
            return profileCardInfo.allInOne.uin;
        }
        return str;
    }

    public static void initNameArray(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).initNameArray(appInterface, profileCardInfo);
    }

    private static boolean isNeedHandleUpdateProfileNameDefault(int i3) {
        for (int i16 : HANDLE_UPDATE_PROFILE_NAME_TYPE) {
            if (i3 == i16) {
                return true;
            }
        }
        return false;
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

    private static void setProfileTypeParamValue1(ProfileCardInfo profileCardInfo, ProfileTypeParam profileTypeParam) {
        int i3 = profileCardInfo.allInOne.f260789pa;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 60) {
                    profileTypeParam.idType = 2;
                    profileTypeParam.fromType = 2;
                    return;
                }
                return;
            }
            if (profileCardInfo.isTroopMemberCard) {
                profileTypeParam.idType = 2;
                profileTypeParam.fromType = 3;
                return;
            } else {
                profileTypeParam.idType = 2;
                profileTypeParam.fromType = 2;
                return;
            }
        }
        if (profileCardInfo.isTroopMemberCard) {
            profileTypeParam.idType = 2;
            profileTypeParam.fromType = 3;
        } else {
            profileTypeParam.idType = 2;
            profileTypeParam.fromType = 1;
        }
    }

    private static void setProfileTypeParamValue2(ProfileCardInfo profileCardInfo, ProfileTypeParam profileTypeParam) {
        int i3 = profileCardInfo.allInOne.f260789pa;
        if (i3 != 30) {
            if (i3 != 58) {
                if (i3 != 46 && i3 != 47) {
                    switch (i3) {
                        case 20:
                            profileTypeParam.idType = 2;
                            profileTypeParam.fromType = 3;
                            return;
                        case 21:
                        case 22:
                            break;
                        default:
                            return;
                    }
                } else {
                    profileTypeParam.idType = 1;
                    profileTypeParam.fromType = 4;
                    return;
                }
            }
            profileTypeParam.idType = 1;
            profileTypeParam.fromType = 3;
            return;
        }
        profileTypeParam.idType = 2;
        profileTypeParam.fromType = 6;
    }

    private static void setProfileTypeParamValue3(ProfileCardInfo profileCardInfo, ProfileTypeParam profileTypeParam) {
        int i3 = profileCardInfo.allInOne.f260789pa;
        if (i3 != 29 && i3 != 36) {
            if (i3 != 53) {
                if (i3 != 86) {
                    switch (i3) {
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                            break;
                        default:
                            switch (i3) {
                                case 40:
                                    profileTypeParam.idType = 2;
                                    profileTypeParam.fromType = 7;
                                    return;
                                case 41:
                                case 42:
                                    break;
                                default:
                                    return;
                            }
                    }
                }
                profileTypeParam.idType = 1;
                profileTypeParam.fromType = 7;
                return;
            }
            profileTypeParam.idType = 1;
            profileTypeParam.fromType = 6;
            ContactCard contactCard = profileCardInfo.contactCard;
            if (contactCard != null && !TextUtils.isEmpty(contactCard.uin)) {
                profileTypeParam.idType = 3;
                return;
            }
            return;
        }
        profileTypeParam.idType = 1;
        profileTypeParam.fromType = 6;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0017. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0014. Please report as an issue. */
    private static void setProfileTypeParamValue4(ProfileCardInfo profileCardInfo, ProfileTypeParam profileTypeParam) {
        int i3 = profileCardInfo.allInOne.f260789pa;
        if (i3 != 4 && i3 != 77 && i3 != 107 && i3 != 110) {
            switch (i3) {
                case 50:
                case 51:
                    profileTypeParam.idType = 1;
                    profileTypeParam.fromType = 8;
                    return;
                case 52:
                    profileTypeParam.idType = 1;
                    profileTypeParam.fromType = 9;
                    return;
                default:
                    switch (i3) {
                        default:
                            switch (i3) {
                                case 101:
                                case 102:
                                case 103:
                                    break;
                                default:
                                    return;
                            }
                        case 81:
                        case 82:
                        case 83:
                        case 84:
                            profileTypeParam.idType = 1;
                            profileTypeParam.fromType = 11;
                    }
            }
        }
        profileTypeParam.idType = 1;
        profileTypeParam.fromType = 11;
    }

    private static void setProfileTypeParamValue5(ProfileCardInfo profileCardInfo, ProfileTypeParam profileTypeParam) {
        int i3 = profileCardInfo.allInOne.f260789pa;
        if (i3 != 71 && i3 != 72) {
            if (i3 != 108) {
                switch (i3) {
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        break;
                    default:
                        return;
                }
            }
            profileTypeParam.idType = 1;
            return;
        }
        profileTypeParam.idType = 1;
        profileTypeParam.fromType = 5;
    }

    public static void updateNameArray(ProfileCardInfo profileCardInfo, int i3, String str) {
        String[] strArr;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("updateNameArray profileCardInfo=%s type=%s value=%s", profileCardInfo, Integer.valueOf(i3), str));
        }
        if (profileCardInfo != null && (strArr = profileCardInfo.nameArray) != null && i3 >= 0 && i3 < strArr.length) {
            strArr[i3] = str;
        }
    }

    public static void updateProfileName(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo.profileName == null) {
            profileCardInfo.profileName = new com.tencent.mobileqq.unifiedname.b();
        }
        ProfileTypeParam profileTypeParam = new ProfileTypeParam();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateProfileName begin ProfileTypeParam: " + profileTypeParam);
        }
        setProfileTypeParamValue1(profileCardInfo, profileTypeParam);
        setProfileTypeParamValue2(profileCardInfo, profileTypeParam);
        setProfileTypeParamValue3(profileCardInfo, profileTypeParam);
        setProfileTypeParamValue4(profileCardInfo, profileTypeParam);
        setProfileTypeParamValue5(profileCardInfo, profileTypeParam);
        if (!isNeedHandleUpdateProfileNameDefault(profileCardInfo.allInOne.f260789pa)) {
            profileTypeParam.idType = 1;
            profileTypeParam.fromType = 0;
        }
        com.tencent.mobileqq.unifiedname.c.a(profileTypeParam.fromType, profileTypeParam.idType, profileCardInfo.nameArray, profileCardInfo.profileName);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateProfileName end ProfileTypeParam: " + profileTypeParam);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("updateProfileName profileName: %s", profileCardInfo.profileName.toString()));
        }
    }
}
