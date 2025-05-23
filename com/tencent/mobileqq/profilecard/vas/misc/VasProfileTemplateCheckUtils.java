package com.tencent.mobileqq.profilecard.vas.misc;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.profile.view.ProfileTemplateException;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes16.dex */
public class VasProfileTemplateCheckUtils {
    private static final String TAG = "ProfileTemplateCheckUtils";

    private static boolean attrIsNotEmpty(String str, Object obj, String str2) {
        if (obj != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        return false;
    }

    public static void checkCurrentUseTemplate(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        long j3 = ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID;
        long j16 = profileCardInfo.card.lCurrentStyleId;
        QLog.d(TAG, 2, "checkCurrentUseTemplate curStyleId=" + j16);
        long j17 = 0;
        ProfileCardTemplate profileCardTemplate = null;
        if (SimpleUIUtil.getSimpleUISwitch()) {
            QLog.d(TAG, 2, "checkCurrentUseTemplate simple mode");
        } else {
            if (checkTemplateValid(j16, profileCardInfo)) {
                profileCardTemplate = profileCardInfo.currentTemplate;
            } else if (j16 == ProfileCardTemplate.PROFILE_CARD_STYLE_SHOPPING) {
                j3 = ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID;
            } else if (ProfileTemplateApi.isDiyTemplateStyleID(j16) && VasProfileTemplatePreloadHelper.INSTANCE.initDiyData(profileCardInfo)) {
                j17 = ProfileTemplateApi.getTemplateManager(iComponentCenter).getDiyTemplateVersion(profileCardInfo.card);
            }
            j3 = j16;
        }
        QLog.d(TAG, 2, "checkCurrentUseTemplate useStyleId=" + j3 + " useTemplateVersion=" + j17);
        profileCardInfo.curUseStyleId = j3;
        profileCardInfo.curUseTemplateVersion = j17;
        profileCardInfo.currentTemplate = profileCardTemplate;
    }

    private static boolean checkGameTemplateValid(ProfileCardInfo profileCardInfo) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkGameTemplateValid");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("commonFaceBackground", "drawable");
        hashMap.put("gameHeadInfoBackground", "color");
        hashMap.put("gameNickNameColor", "color");
        hashMap.put("gameAddressColor", "color");
        hashMap.put("gameSignColor", "color");
        hashMap.put("gamePlayNowColor", "color");
        hashMap.put("gameMoreColor", "color");
        hashMap.put("gameMoreGameDrawableRight", "drawable");
        hashMap.put("gamePlayTitleColor", "color");
        hashMap.put("gameIconBorder", "drawable");
        return checkTemplateValidWithResult(profileCardInfo, hashMap);
    }

    private static boolean checkPhotoTemplateValid(ProfileCardInfo profileCardInfo) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkPhotoTemplateValid");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("commonFaceBackground", "drawable");
        hashMap.put("photoNickNameColor", "color");
        hashMap.put("photoAddressColor", "color");
        hashMap.put("photoAddSrc", "drawable");
        return checkTemplateValidWithResult(profileCardInfo, hashMap);
    }

    private static boolean checkQVipV5TemplateValid(ProfileCardInfo profileCardInfo) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkQVipV5TemplateValid");
        }
        return checkTemplateValidWithResult(profileCardInfo, new HashMap());
    }

    private static boolean checkSimpleTemplateValid(ProfileCardInfo profileCardInfo) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkSimpleTemplateValid");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("commonFaceBackground", "drawable");
        hashMap.put("simpleQQNumColor", "color");
        hashMap.put("simpleNickNameColor", "color");
        hashMap.put("simpleAddressColor", "color");
        hashMap.put("simpleGridAddBackground", "color");
        hashMap.put("simpleAddressBackground", "drawable");
        hashMap.put("simpleAddSrc", "drawable");
        hashMap.put("simpleGridAddSrc", "drawable");
        return checkTemplateValidWithResult(profileCardInfo, hashMap);
    }

    private static boolean checkTagTemplateValid(ProfileCardInfo profileCardInfo) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkTagTemplateValid");
        }
        return checkTemplateValidWithResult(profileCardInfo, new HashMap());
    }

    private static boolean checkTemplateValid(long j3, ProfileCardInfo profileCardInfo) {
        return isValidGameTemplate(j3, profileCardInfo) || isValidPhotoTemplate(j3, profileCardInfo) || isValidTagTemplate(j3, profileCardInfo) || isValidSimpleTemplate(j3, profileCardInfo) || isValidWZRYTemplate(j3, profileCardInfo) || isValidQVipV5Template(j3, profileCardInfo);
    }

    private static boolean checkTemplateValidWithResult(ProfileCardInfo profileCardInfo, HashMap<String, String> hashMap) {
        boolean z16;
        try {
            checkTemplateValid(profileCardInfo, hashMap);
            z16 = true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "checkShopTemplateValid fail.", e16);
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("checkTemplateValidWithResult valid=%s", Boolean.valueOf(z16)));
        }
        return z16;
    }

    private static boolean checkVaildAttr(String str, Object obj, String[] strArr, boolean z16) {
        for (String str2 : strArr) {
            if (attrIsNotEmpty(str, obj, str2) && (isAttrValidColor(obj, str2) || isAttrValidDrawable(obj, str2) || isAttrValidString(obj, str2))) {
                return true;
            }
        }
        return z16;
    }

    private static boolean checkWZRYTemplateValid(ProfileCardInfo profileCardInfo) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkWZRYTemplateValid");
        }
        return checkTemplateValidWithResult(profileCardInfo, new HashMap());
    }

    private static boolean isAttrValidColor(Object obj, String str) {
        if (str.equalsIgnoreCase("color") && ((obj instanceof ColorStateList) || (obj instanceof String))) {
            return true;
        }
        return false;
    }

    private static boolean isAttrValidDrawable(Object obj, String str) {
        if (str.equalsIgnoreCase("drawable") && (obj instanceof Drawable)) {
            return true;
        }
        return false;
    }

    private static boolean isAttrValidString(Object obj, String str) {
        if (str.equalsIgnoreCase(HippyControllerProps.STRING) && (obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
            return true;
        }
        return false;
    }

    private static boolean isValidGameTemplate(long j3, ProfileCardInfo profileCardInfo) {
        if ((j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_FRESH || j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_JANYUE || j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_GAME) && checkGameTemplateValid(profileCardInfo)) {
            return true;
        }
        return false;
    }

    private static boolean isValidPhotoTemplate(long j3, ProfileCardInfo profileCardInfo) {
        if (j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_SOCIAL && checkPhotoTemplateValid(profileCardInfo)) {
            return true;
        }
        return false;
    }

    private static boolean isValidQVipV5Template(long j3, ProfileCardInfo profileCardInfo) {
        if (j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_NEW_V800 && checkQVipV5TemplateValid(profileCardInfo)) {
            return true;
        }
        return false;
    }

    private static boolean isValidSimpleTemplate(long j3, ProfileCardInfo profileCardInfo) {
        if (j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE && checkSimpleTemplateValid(profileCardInfo)) {
            return true;
        }
        return false;
    }

    private static boolean isValidTagTemplate(long j3, ProfileCardInfo profileCardInfo) {
        if (j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_TAG && checkTagTemplateValid(profileCardInfo)) {
            return true;
        }
        return false;
    }

    private static boolean isValidWZRYTemplate(long j3, ProfileCardInfo profileCardInfo) {
        if ((j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC || j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) && checkWZRYTemplateValid(profileCardInfo)) {
            return true;
        }
        return false;
    }

    private static void checkTemplateValid(ProfileCardInfo profileCardInfo, HashMap<String, String> hashMap) throws ProfileTemplateException {
        ConcurrentHashMap<String, Object> concurrentHashMap = profileCardInfo.currentTemplate.templateAttr;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            hashMap.put("commonItemContentColor", "color");
            hashMap.put("commonItemMoreSrc", "drawable");
            hashMap.put("commonMaskBackground", "color");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!checkVaildAttr(key, concurrentHashMap.get(key), value.split(","), false)) {
                    throw new ProfileTemplateException("template attr " + key + " type is not " + value);
                }
            }
            return;
        }
        throw new ProfileTemplateException("template templateAttr is null");
    }
}
