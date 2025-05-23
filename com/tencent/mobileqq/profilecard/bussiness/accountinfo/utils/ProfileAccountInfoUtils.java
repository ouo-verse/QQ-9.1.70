package com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes16.dex */
public class ProfileAccountInfoUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String COUNTRY_NO_LIMIT = "\u4e0d\u9650";
    private static final String TAG = "ProfileAccountInfoUtils";

    public ProfileAccountInfoUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void appendBirthdayAndConstellation(List<String> list, ProfileCardInfo profileCardInfo, Resources resources) {
        String str;
        String constellationWithPrivacy = getConstellationWithPrivacy(profileCardInfo);
        long birthdayWithPrivacy = getBirthdayWithPrivacy(profileCardInfo);
        if (birthdayWithPrivacy > 0) {
            int i3 = ((int) (65280 & birthdayWithPrivacy)) >> 8;
            int i16 = (int) (birthdayWithPrivacy & 255);
            if (i3 > 0 && i16 > 0) {
                str = i3 + resources.getString(R.string.cae) + i16 + resources.getString(R.string.aiu);
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(constellationWithPrivacy)) {
                    list.add(str + " " + constellationWithPrivacy);
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    list.add(str);
                    return;
                } else {
                    if (!TextUtils.isEmpty(constellationWithPrivacy)) {
                        list.add(constellationWithPrivacy);
                        return;
                    }
                    return;
                }
            }
        }
        str = null;
        if (TextUtils.isEmpty(str)) {
        }
        if (TextUtils.isEmpty(str)) {
        }
    }

    private static void appendCompany(List<String> list, ProfileCardInfo profileCardInfo, Resources resources) {
        String companyWithPrivacy = getCompanyWithPrivacy(profileCardInfo);
        if (!TextUtils.isEmpty(companyWithPrivacy)) {
            list.add(companyWithPrivacy);
        }
    }

    private static void appendElegantAge(List<String> list, ProfileCardInfo profileCardInfo, Resources resources) {
        String str;
        short ageWithPrivacy = getAgeWithPrivacy(profileCardInfo);
        if (ageWithPrivacy > 0) {
            str = ((int) ageWithPrivacy) + resources.getString(R.string.htz);
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            list.add(str);
        }
    }

    private static void appendElegantGender(List<String> list, ProfileCardInfo profileCardInfo, Resources resources) {
        String str;
        short genderWithPrivacy = getGenderWithPrivacy(profileCardInfo);
        if (genderWithPrivacy == 0) {
            str = resources.getString(R.string.c7_);
        } else if (genderWithPrivacy == 1) {
            str = resources.getString(R.string.b5e);
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            list.add(str + " " + str);
        }
    }

    private static void appendEmail(List<String> list, ProfileCardInfo profileCardInfo, Resources resources) {
        String emailWithPrivacy = getEmailWithPrivacy(profileCardInfo);
        if (!TextUtils.isEmpty(emailWithPrivacy)) {
            list.add(emailWithPrivacy);
        }
    }

    private static void appendGenderAndAge(List<String> list, ProfileCardInfo profileCardInfo, Resources resources) {
        String str;
        short genderWithPrivacy = getGenderWithPrivacy(profileCardInfo);
        String str2 = null;
        if (genderWithPrivacy == 0) {
            str = resources.getString(R.string.c7_);
        } else if (genderWithPrivacy == 1) {
            str = resources.getString(R.string.b5e);
        } else {
            str = null;
        }
        short ageWithPrivacy = getAgeWithPrivacy(profileCardInfo);
        if (ageWithPrivacy > 0) {
            str2 = ((int) ageWithPrivacy) + resources.getString(R.string.htz);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            list.add(str + " " + str2);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            list.add(str);
        } else if (!TextUtils.isEmpty(str2)) {
            list.add(str2);
        }
    }

    private static void appendHometown(List<String> list, ProfileCardInfo profileCardInfo, Resources resources) {
        String hometownCountryWithPrivacy = getHometownCountryWithPrivacy(profileCardInfo);
        String hometownProvinceWithPrivacy = getHometownProvinceWithPrivacy(profileCardInfo);
        String hometownCityWithPrivacy = getHometownCityWithPrivacy(profileCardInfo);
        if (TextUtils.isEmpty(hometownProvinceWithPrivacy) && TextUtils.isEmpty(hometownCityWithPrivacy)) {
            if (!TextUtils.isEmpty(hometownCountryWithPrivacy) && !"\u4e0d\u9650".equals(hometownCountryWithPrivacy)) {
                list.add(resources.getString(R.string.f203314zv) + hometownCountryWithPrivacy);
                return;
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(resources.getString(R.string.f203314zv));
        if (!TextUtils.isEmpty(hometownProvinceWithPrivacy)) {
            sb5.append(hometownProvinceWithPrivacy);
        }
        if (!TextUtils.isEmpty(hometownCityWithPrivacy)) {
            sb5.append(hometownCityWithPrivacy);
        }
        list.add(sb5.toString());
    }

    private static void appendLocation(List<String> list, ProfileCardInfo profileCardInfo, Resources resources) {
        String locationCountryWithPrivacy = getLocationCountryWithPrivacy(profileCardInfo);
        String locationProvinceWithPrivacy = getLocationProvinceWithPrivacy(profileCardInfo);
        String locationCityWithPrivacy = getLocationCityWithPrivacy(profileCardInfo);
        if (TextUtils.isEmpty(locationProvinceWithPrivacy) && TextUtils.isEmpty(locationCityWithPrivacy)) {
            if (!TextUtils.isEmpty(locationCountryWithPrivacy) && !"\u4e0d\u9650".equals(locationCountryWithPrivacy)) {
                list.add(resources.getString(R.string.f203324zw) + locationCountryWithPrivacy);
                return;
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(resources.getString(R.string.f203324zw));
        if (!TextUtils.isEmpty(locationProvinceWithPrivacy)) {
            sb5.append(locationProvinceWithPrivacy);
        }
        if (!TextUtils.isEmpty(locationCityWithPrivacy)) {
            sb5.append(locationCityWithPrivacy);
        }
        list.add(sb5.toString());
    }

    private static void appendProfession(List<String> list, ProfileCardInfo profileCardInfo, Resources resources) {
        String professionTagWithPrivacy = getProfessionTagWithPrivacy(profileCardInfo);
        if (!TextUtils.isEmpty(professionTagWithPrivacy)) {
            list.add(professionTagWithPrivacy);
        }
    }

    private static void appendSchool(List<String> list, ProfileCardInfo profileCardInfo, Resources resources) {
        String schoolWithPrivacy = getSchoolWithPrivacy(profileCardInfo);
        if (!TextUtils.isEmpty(schoolWithPrivacy)) {
            list.add(schoolWithPrivacy);
        }
    }

    public static short getAge(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            return card.age;
        }
        return (short) 0;
    }

    public static short getAgeWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && isFieldVisible(41610, profileCardInfo)) {
            return profileCardInfo.card.age;
        }
        return (short) 0;
    }

    public static long getBirthday(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            return card.lBirthday;
        }
        return 0L;
    }

    public static long getBirthdayWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && isFieldVisible(41607, profileCardInfo)) {
            return profileCardInfo.card.lBirthday;
        }
        return 0L;
    }

    public static String getCompany(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            return getStringTrim(card.strCompany);
        }
        return null;
    }

    public static String getCompanyWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && isFieldVisible(40272, profileCardInfo)) {
            return getStringTrim(profileCardInfo.card.strCompany);
        }
        return null;
    }

    public static String getConstellation(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null) {
            return ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).getConstellation(profileCardInfo.card.constellation);
        }
        return null;
    }

    public static String getConstellationWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && isFieldVisible(IProfileSettingApi.FIELD_PRIVACY_CONSTELLATION, profileCardInfo)) {
            return ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).getConstellation(profileCardInfo.card.constellation);
        }
        return null;
    }

    public static String getEmail(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            return getStringTrim(card.strEmail);
        }
        return null;
    }

    public static String getEmailWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && isFieldVisible(41622, profileCardInfo)) {
            return getStringTrim(profileCardInfo.card.strEmail);
        }
        return null;
    }

    public static short getGender(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            return card.shGender;
        }
        return (short) -1;
    }

    public static short getGenderWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && isFieldVisible(41611, profileCardInfo)) {
            return profileCardInfo.card.shGender;
        }
        return (short) -1;
    }

    public static String getHometown(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            return getStringTrim(card.strHometownDesc);
        }
        return null;
    }

    public static String getHometownCity(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            return getStringTrim(card.strHometownCity);
        }
        return null;
    }

    public static String getHometownCityWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && isFieldVisible(41613, profileCardInfo)) {
            return getStringTrim(profileCardInfo.card.strHometownCity);
        }
        return null;
    }

    public static String getHometownCountryWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && isFieldVisible(41613, profileCardInfo)) {
            return getStringTrim(profileCardInfo.card.strHometownCountry);
        }
        return null;
    }

    public static String getHometownProvince(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            return getStringTrim(card.strHometownProvince);
        }
        return null;
    }

    public static String getHometownProvinceWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && isFieldVisible(41613, profileCardInfo)) {
            return getStringTrim(profileCardInfo.card.strHometownProvince);
        }
        return null;
    }

    public static String getHometownWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && isFieldVisible(41613, profileCardInfo)) {
            return getStringTrim(profileCardInfo.card.strHometownDesc);
        }
        return null;
    }

    public static String getLocationCity(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            return getStringTrim(card.strCity);
        }
        return null;
    }

    public static String getLocationCityWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && isFieldVisible(41614, profileCardInfo)) {
            return getStringTrim(profileCardInfo.card.strCity);
        }
        return null;
    }

    public static String getLocationCountry(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            return getStringTrim(card.strCountry);
        }
        return null;
    }

    public static String getLocationCountryWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && isFieldVisible(41614, profileCardInfo)) {
            return getStringTrim(profileCardInfo.card.strCountry);
        }
        return null;
    }

    public static String getLocationProvince(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            return getStringTrim(card.strProvince);
        }
        return null;
    }

    public static String getLocationProvinceWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && isFieldVisible(41614, profileCardInfo)) {
            return getStringTrim(profileCardInfo.card.strProvince);
        }
        return null;
    }

    public static String getProfession(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).checkProfessionShow(profileCardInfo.card.iProfession)) {
            return ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).getJob(profileCardInfo.card.iProfession);
        }
        return null;
    }

    public static String getProfessionTag(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).checkProfessionShow(profileCardInfo.card.iProfession)) {
            return ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).getJobTag(profileCardInfo.card.iProfession);
        }
        return null;
    }

    public static String getProfessionTagWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).checkProfessionShow(profileCardInfo.card.iProfession) && isFieldVisible(41618, profileCardInfo)) {
            return ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).getJobTag(profileCardInfo.card.iProfession);
        }
        return null;
    }

    public static String getProfessionWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).checkProfessionShow(profileCardInfo.card.iProfession) && isFieldVisible(41618, profileCardInfo)) {
            return ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).getJob(profileCardInfo.card.iProfession);
        }
        return null;
    }

    public static String getSchool(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            return getStringTrim(card.strSchool);
        }
        return null;
    }

    public static String getSchoolWithPrivacy(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null && isFieldVisible(41619, profileCardInfo)) {
            return getStringTrim(profileCardInfo.card.strSchool);
        }
        return null;
    }

    public static String getStringTrim(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    public static boolean isFieldVisible(int i3, ProfileCardInfo profileCardInfo) {
        boolean z16;
        boolean z17 = false;
        if (profileCardInfo.allInOne.f260789pa == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return true;
        }
        if (((IProfileSettingApi) QRoute.api(IProfileSettingApi.class)).getProfileDisplaySettingStateFromCard(i3, profileCardInfo.card, null) != 2) {
            z17 = true;
        }
        return z17;
    }

    public static List<String> makeAccountElegantInfo(ProfileCardInfo profileCardInfo) {
        Resources resources = BaseApplication.getContext().getResources();
        ArrayList arrayList = new ArrayList();
        if (resources == null) {
            QLog.e(TAG, 1, "[makeAccountInfo]resources is null");
            return arrayList;
        }
        if (profileCardInfo != null) {
            appendElegantGender(arrayList, profileCardInfo, resources);
            appendElegantAge(arrayList, profileCardInfo, resources);
            appendBirthdayAndConstellation(arrayList, profileCardInfo, resources);
            appendSchool(arrayList, profileCardInfo, resources);
            appendLocation(arrayList, profileCardInfo, resources);
            appendHometown(arrayList, profileCardInfo, resources);
            appendCompany(arrayList, profileCardInfo, resources);
            appendProfession(arrayList, profileCardInfo, resources);
            appendEmail(arrayList, profileCardInfo, resources);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, String.format("makeAccountInfo list=%s", Arrays.toString(arrayList.toArray())));
        }
        return arrayList;
    }

    public static List<String> makeAccountInfo(ProfileCardInfo profileCardInfo) {
        Resources resources = BaseApplication.getContext().getResources();
        ArrayList arrayList = new ArrayList();
        if (resources == null) {
            QLog.e(TAG, 1, "[makeAccountInfo]resources is null");
            return arrayList;
        }
        if (profileCardInfo != null) {
            appendGenderAndAge(arrayList, profileCardInfo, resources);
            appendBirthdayAndConstellation(arrayList, profileCardInfo, resources);
            appendSchool(arrayList, profileCardInfo, resources);
            appendLocation(arrayList, profileCardInfo, resources);
            appendHometown(arrayList, profileCardInfo, resources);
            appendCompany(arrayList, profileCardInfo, resources);
            appendProfession(arrayList, profileCardInfo, resources);
            appendEmail(arrayList, profileCardInfo, resources);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, String.format("makeAccountInfo list=%s", Arrays.toString(arrayList.toArray())));
        }
        return arrayList;
    }
}
