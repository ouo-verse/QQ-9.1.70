package com.tencent.mobileqq.profilecard.utils;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.widget.TabContainer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes35.dex */
public class ProfileTabUtils {
    public static List<TabContainer.Tab> getBaseAccountTab(ProfileCardInfo profileCardInfo) {
        ArrayList arrayList = new ArrayList();
        addArrayList(arrayList, getGenderAndAge(profileCardInfo));
        addArrayList(arrayList, getBirthdayAndConstellation(profileCardInfo));
        addArrayList(arrayList, getSchool(profileCardInfo));
        addArrayList(arrayList, getLocation(profileCardInfo));
        addArrayList(arrayList, getHometown(profileCardInfo));
        addArrayList(arrayList, getProfessionAndCompany(profileCardInfo));
        addArrayList(arrayList, getEmail(profileCardInfo));
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TabContainer.Tab getBirthdayAndConstellation(ProfileCardInfo profileCardInfo) {
        String str;
        String strcat;
        String constellationWithPrivacy = ProfileAccountInfoUtils.getConstellationWithPrivacy(profileCardInfo);
        long birthdayWithPrivacy = ProfileAccountInfoUtils.getBirthdayWithPrivacy(profileCardInfo);
        if (birthdayWithPrivacy > 0) {
            int i3 = ((int) (65280 & birthdayWithPrivacy)) >> 8;
            int i16 = (int) (birthdayWithPrivacy & 255);
            if (i3 > 0 && i16 > 0) {
                str = i3 + "\u6708" + i16 + "\u65e5";
                strcat = strcat(str, constellationWithPrivacy);
                if (TextUtils.isEmpty(strcat)) {
                    return TabContainer.Tab.create(strcat);
                }
                return null;
            }
        }
        str = null;
        strcat = strcat(str, constellationWithPrivacy);
        if (TextUtils.isEmpty(strcat)) {
        }
    }

    private static TabContainer.Tab getEmail(ProfileCardInfo profileCardInfo) {
        String emailWithPrivacy = ProfileAccountInfoUtils.getEmailWithPrivacy(profileCardInfo);
        if (TextUtils.isEmpty(emailWithPrivacy)) {
            return null;
        }
        return TabContainer.Tab.create(emailWithPrivacy);
    }

    private static TabContainer.Tab getGenderAndAge(ProfileCardInfo profileCardInfo) {
        String str;
        short genderWithPrivacy = ProfileAccountInfoUtils.getGenderWithPrivacy(profileCardInfo);
        short ageWithPrivacy = ProfileAccountInfoUtils.getAgeWithPrivacy(profileCardInfo);
        if (genderWithPrivacy != 0 && genderWithPrivacy != 1) {
            str = null;
        } else if (genderWithPrivacy == 0) {
            str = TabContainer.Tab.MALE;
        } else {
            str = TabContainer.Tab.FEMALE;
        }
        String valueOf = ageWithPrivacy > 0 ? String.valueOf((int) ageWithPrivacy) : null;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(valueOf)) {
            return null;
        }
        return TabContainer.Tab.createSex(valueOf, str);
    }

    private static TabContainer.Tab getHometown(ProfileCardInfo profileCardInfo) {
        String hometownProvinceWithPrivacy = ProfileAccountInfoUtils.getHometownProvinceWithPrivacy(profileCardInfo);
        String hometownCityWithPrivacy = ProfileAccountInfoUtils.getHometownCityWithPrivacy(profileCardInfo);
        if (TextUtils.isEmpty(hometownProvinceWithPrivacy) && TextUtils.isEmpty(hometownCityWithPrivacy)) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u6765\u81ea");
        if (!TextUtils.isEmpty(hometownProvinceWithPrivacy)) {
            sb5.append(hometownProvinceWithPrivacy);
        }
        if (!TextUtils.isEmpty(hometownCityWithPrivacy)) {
            sb5.append(hometownCityWithPrivacy);
        }
        return TabContainer.Tab.create(sb5.toString());
    }

    private static TabContainer.Tab getLocation(ProfileCardInfo profileCardInfo) {
        String locationProvinceWithPrivacy = ProfileAccountInfoUtils.getLocationProvinceWithPrivacy(profileCardInfo);
        String locationCityWithPrivacy = ProfileAccountInfoUtils.getLocationCityWithPrivacy(profileCardInfo);
        if (TextUtils.isEmpty(locationProvinceWithPrivacy) && TextUtils.isEmpty(locationCityWithPrivacy)) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u73b0\u5c45");
        if (!TextUtils.isEmpty(locationProvinceWithPrivacy)) {
            sb5.append(locationProvinceWithPrivacy);
        }
        if (!TextUtils.isEmpty(locationCityWithPrivacy)) {
            sb5.append(locationCityWithPrivacy);
        }
        return TabContainer.Tab.create(sb5.toString());
    }

    private static TabContainer.Tab getMedal(ProfileCardInfo profileCardInfo) {
        int i3;
        Card card = profileCardInfo.card;
        if (!(!card.medalSwitchDisable) || (i3 = card.iMedalCount) <= 0) {
            return null;
        }
        return TabContainer.Tab.create(String.format("\u83b7\u5f97%d\u4e2a\u52cb\u7ae0", Integer.valueOf(i3)));
    }

    public static List<TabContainer.Tab> getMergedTab(List<TabContainer.Tab> list, List<TabContainer.Tab> list2) {
        ArrayList arrayList = new ArrayList();
        int size = list2.size();
        int i3 = (size <= 0 || size >= 3) ? 4 < size ? 4 : -1 : 5;
        if (i3 < 0) {
            arrayList.addAll(list);
        } else {
            int min = Math.min(i3, list.size());
            for (int i16 = 0; i16 < min; i16++) {
                arrayList.add(list.get(i16));
            }
        }
        arrayList.addAll(list2);
        return arrayList;
    }

    public static List<TabContainer.Tab> getPersonalityLabelTab(ProfileCardInfo profileCardInfo, AppInterface appInterface) {
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo;
        List<PersonalityLabelInfo> list;
        ArrayList arrayList = new ArrayList();
        if (getPersonalityLabelSwitch(profileCardInfo, appInterface) && (profilePersonalityLabelInfo = (ProfilePersonalityLabelInfo) profileCardInfo.getBusinessInfo(ProfilePersonalityLabelInfo.class)) != null && (list = profilePersonalityLabelInfo.personalityLabelInfos) != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                arrayList.add(TabContainer.Tab.create(list.get(i3).text));
            }
        }
        return arrayList;
    }

    private static TabContainer.Tab getPresent(ProfileCardInfo profileCardInfo) {
        int i3 = profileCardInfo.card.presentNum;
        if (i3 > 0) {
            return TabContainer.Tab.create(String.format("\u6536\u5230%d\u4e2a\u793c\u7269", Integer.valueOf(i3)));
        }
        return null;
    }

    public static List<TabContainer.Tab> getPresentAndMedalList(ProfileCardInfo profileCardInfo) {
        ArrayList arrayList = new ArrayList();
        addArrayList(arrayList, getPresent(profileCardInfo));
        if (arrayList.size() > 0) {
            addArrayList(arrayList, getMedal(profileCardInfo));
        }
        return arrayList;
    }

    private static TabContainer.Tab getProfessionAndCompany(ProfileCardInfo profileCardInfo) {
        String strcat = strcat(ProfileAccountInfoUtils.getProfessionTagWithPrivacy(profileCardInfo), ProfileAccountInfoUtils.getCompanyWithPrivacy(profileCardInfo));
        if (TextUtils.isEmpty(strcat)) {
            return null;
        }
        return TabContainer.Tab.create(strcat);
    }

    private static TabContainer.Tab getSchool(ProfileCardInfo profileCardInfo) {
        String schoolWithPrivacy = ProfileAccountInfoUtils.getSchoolWithPrivacy(profileCardInfo);
        if (TextUtils.isEmpty(schoolWithPrivacy)) {
            return null;
        }
        return TabContainer.Tab.create(schoolWithPrivacy);
    }

    private static String strcat(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return str + " " + str2;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    private static void addArrayList(List<TabContainer.Tab> list, TabContainer.Tab tab) {
        if (tab != null) {
            list.add(tab);
        }
    }

    private static boolean getPersonalityLabelSwitch(ProfileCardInfo profileCardInfo, AppInterface appInterface) {
        if (profileCardInfo == null) {
            return false;
        }
        return PersonalityLabelUtil.isNeedShowPersonalityLabel(profileCardInfo.allInOne, (ProfilePersonalityLabelInfo) profileCardInfo.getBusinessInfo(ProfilePersonalityLabelInfo.class), appInterface);
    }
}
