package com.tencent.mobileqq.apollo.utils.api.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.urldrawable.b;
import com.tencent.mobileqq.utils.ff;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ApolloUtilImpl implements IApolloUtil {
    private static final int NEW_ICON_MAX_SHOW_TIMES = 3;
    public static final String TAG = "[cmshow]ApolloUtil";
    private static int sNewIconShowTimes;
    private static boolean sNewIconShowTimesLoaded;
    private static boolean sPopupGuideFlagLoaded;
    private static boolean sPopupGuideShown;
    private static int sShownNewEmoticonSize;

    private static String getNewIconShowFlagKey() {
        List<Integer> list;
        HashMap<String, List<Integer>> hashMap = SystemEmoticonInfo.sNewApolloEmoticonMap;
        String str = AppSetting.f99551k;
        if (!hashMap.containsKey(str) || (list = SystemEmoticonInfo.sNewApolloEmoticonMap.get(str)) == null || list.size() <= 0) {
            return null;
        }
        String currentAccountUin = ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("new_icon_show_times_");
        sb5.append(currentAccountUin);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            sb5.append("_");
            sb5.append(intValue);
        }
        return sb5.toString();
    }

    private static String getPopupShowFlagKey() {
        List<Integer> list;
        HashMap<String, List<Integer>> hashMap = SystemEmoticonInfo.sNewApolloEmoticonMap;
        String str = AppSetting.f99551k;
        if (!hashMap.containsKey(str) || (list = SystemEmoticonInfo.sNewApolloEmoticonMap.get(str)) == null || list.size() <= 0) {
            return null;
        }
        String currentAccountUin = ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("new_emoticon_popup_");
        sb5.append(currentAccountUin);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            sb5.append("_");
            sb5.append(intValue);
        }
        return sb5.toString();
    }

    public static boolean isNewApolloEmotion(int i3) {
        List<Integer> list;
        HashMap<String, List<Integer>> hashMap = SystemEmoticonInfo.sNewApolloEmoticonMap;
        String str = AppSetting.f99551k;
        if (hashMap.containsKey(str) && (list = SystemEmoticonInfo.sNewApolloEmoticonMap.get(str)) != null && list.size() > 0) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                if (i3 == it.next().intValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.apollo.utils.api.IApolloUtil
    public URLDrawable getDrawable(String str, URLDrawable.URLDrawableOptions uRLDrawableOptions, String str2) {
        return getDrawable(false, str, uRLDrawableOptions, str2);
    }

    @Override // com.tencent.mobileqq.apollo.utils.api.IApolloUtil
    public int getReportSessionType(int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 3000) {
            return 0;
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.apollo.utils.api.IApolloUtil
    public void onEmoticonNewIconShown(int i3) {
        List<Integer> list;
        if (isNewApolloEmotion(i3)) {
            HashMap<String, List<Integer>> hashMap = SystemEmoticonInfo.sNewApolloEmoticonMap;
            String str = AppSetting.f99551k;
            if (hashMap.containsKey(str) && (list = SystemEmoticonInfo.sNewApolloEmoticonMap.get(str)) != null && list.size() > 0) {
                int i16 = sShownNewEmoticonSize + 1;
                sShownNewEmoticonSize = i16;
                if (i16 >= list.size()) {
                    SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
                    String newIconShowFlagKey = getNewIconShowFlagKey();
                    if (!sNewIconShowTimesLoaded) {
                        if (!TextUtils.isEmpty(newIconShowFlagKey)) {
                            sNewIconShowTimes = sharedPreferences.getInt(newIconShowFlagKey, 0);
                        }
                        sNewIconShowTimesLoaded = true;
                    }
                    sNewIconShowTimes++;
                    if (!TextUtils.isEmpty(newIconShowFlagKey)) {
                        sharedPreferences.edit().putInt(newIconShowFlagKey, sNewIconShowTimes).apply();
                    }
                    sShownNewEmoticonSize = 0;
                }
            }
            ff.T((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), "cmshow", "Apollo", "expresstab_reddot_view", 0, 0, String.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.apollo.utils.api.IApolloUtil
    public void onNewEmoticonClick(int i3) {
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
        String newIconShowFlagKey = getNewIconShowFlagKey();
        if (!TextUtils.isEmpty(newIconShowFlagKey)) {
            sNewIconShowTimes = 3;
            sharedPreferences.edit().putInt(newIconShowFlagKey, sNewIconShowTimes).apply();
        }
        sShownNewEmoticonSize = 0;
        ff.T((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), "cmshow", "Apollo", "expresstab_reddot_click", 0, 0, String.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.apollo.utils.api.IApolloUtil
    public void onPopupGuideShown() {
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
        String popupShowFlagKey = getPopupShowFlagKey();
        if (!TextUtils.isEmpty(popupShowFlagKey)) {
            sharedPreferences.edit().putBoolean(popupShowFlagKey, true).apply();
        }
        sPopupGuideShown = true;
    }

    @Override // com.tencent.mobileqq.apollo.utils.api.IApolloUtil
    public boolean shouldShowNewIcon(int i3) {
        if (!isNewApolloEmotion(i3)) {
            return false;
        }
        if (!sNewIconShowTimesLoaded) {
            SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
            String newIconShowFlagKey = getNewIconShowFlagKey();
            if (!TextUtils.isEmpty(newIconShowFlagKey)) {
                sNewIconShowTimes = sharedPreferences.getInt(newIconShowFlagKey, 0);
            }
            sNewIconShowTimesLoaded = true;
        }
        return sNewIconShowTimes < 3;
    }

    @Override // com.tencent.mobileqq.apollo.utils.api.IApolloUtil
    public boolean shouldShowPopupGuide() {
        List<Integer> list;
        HashMap<String, List<Integer>> hashMap = SystemEmoticonInfo.sNewApolloEmoticonMap;
        String str = AppSetting.f99551k;
        if (!hashMap.containsKey(str) || (list = SystemEmoticonInfo.sNewApolloEmoticonMap.get(str)) == null || list.size() <= 0) {
            return false;
        }
        if (!sPopupGuideFlagLoaded) {
            sPopupGuideShown = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).getBoolean(getPopupShowFlagKey(), false);
            sPopupGuideFlagLoaded = true;
        }
        return !sPopupGuideShown;
    }

    private URLDrawable getDrawable(boolean z16, String str, URLDrawable.URLDrawableOptions uRLDrawableOptions, String str2) {
        return getDrawable(z16, str, uRLDrawableOptions, str2, false);
    }

    private URLDrawable getDrawable(boolean z16, String str, URLDrawable.URLDrawableOptions uRLDrawableOptions, String str2, boolean z17) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (z16) {
            str3 = str;
        } else {
            str3 = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/" + str;
        }
        if (uRLDrawableOptions == null) {
            uRLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            uRLDrawableOptions.mExtraInfo = null;
        }
        if (uRLDrawableOptions.mLoadingDrawable == null) {
            uRLDrawableOptions.mLoadingDrawable = b.f306350a;
        }
        if (uRLDrawableOptions.mFailedDrawable == null) {
            uRLDrawableOptions.mFailedDrawable = b.f306350a;
        }
        File file = new File(str3);
        if (!z17 && file.exists()) {
            URLDrawable drawable = URLDrawable.getDrawable(file, uRLDrawableOptions);
            if (!QLog.isColorLevel()) {
                return drawable;
            }
            QLog.d(TAG, 2, "getDrawable file exsit path->" + str3 + ",url:" + str2);
            return drawable;
        }
        try {
            return URLDrawable.getDrawable(new URL("apollo_image", "", str), uRLDrawableOptions);
        } catch (Exception e16) {
            QLog.d(TAG, 1, e16.getMessage());
            return null;
        }
    }

    @Override // com.tencent.mobileqq.apollo.utils.api.IApolloUtil
    public String getApolloMessageDesc(MessageRecord messageRecord) {
        String actionName;
        if (messageRecord == null || messageRecord.msgtype != -2039) {
            return null;
        }
        String str = "[" + HardCodeUtil.qqStr(R.string.jhw) + "]";
        byte[] bArr = messageRecord.msgData;
        if (bArr == null) {
            return str;
        }
        if (bArr.length > 0) {
            try {
                ApolloMessage apolloMessage = (ApolloMessage) MessagePkgUtils.getObjectFromBytes(bArr);
                if (apolloMessage == null) {
                    return str;
                }
                actionName = apolloMessage.getActionName();
                if (TextUtils.isEmpty(actionName)) {
                    return str;
                }
            } catch (Throwable unused) {
                return str;
            }
        }
        return str + actionName;
    }

    @Override // com.tencent.mobileqq.apollo.utils.api.IApolloUtil
    public void playShareMsgAction(AppRuntime appRuntime, Object obj, MessageRecord messageRecord, int i3, int i16) {
    }
}
