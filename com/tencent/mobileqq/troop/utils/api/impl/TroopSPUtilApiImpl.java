package com.tencent.mobileqq.troop.utils.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes19.dex */
public class TroopSPUtilApiImpl implements ITroopSPUtilApi {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_AIO_TROOP_MINI_APP_ENTRANCE = "AIO_TROOP_MINI_APP_ENTRANCE";
    private static final String KEY_SWITCH_SOURCE_USABILITY = "key_switch_source_usability";
    private static final String KEY_TROOP_APP_HAS_NEW = "key_troop_app_has_new";
    public static final String KEY_TROOP_GAME_CARD_RED_POINT = "troop_game_card_red_point";
    public static final String KEY_TROOP_GAME_CARD_RED_POINT_HAS_SHOWED = "troop_game_card_red_point_has_showed";
    private static final String TAG = "TroopSPUtilApiImpl";
    private static int isReturnGameCardRedPoint;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65161);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            isReturnGameCardRedPoint = -1;
        }
    }

    public TroopSPUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public boolean getAIOTroopMiniAppEntranceRedPoint(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
        }
        if (appRuntime == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return appRuntime.getApp().getSharedPreferences(appRuntime.getCurrentAccountUin() + "_" + KEY_AIO_TROOP_MINI_APP_ENTRANCE, 0).getBoolean(str, false);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public boolean getGroupTIMFileNewsInfo(String str, String str2, String str3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, str, str2, str3, Boolean.valueOf(z16))).booleanValue();
        }
        return BaseApplication.getContext().getSharedPreferences(str, 0).getBoolean(str + str2 + str3, z16);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public Object[] getKeyTroopLuckyCharacterStatus(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Object[]) iPatchRedirector.redirect((short) 5, this, str, str2, str3);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(str, 0);
            long j3 = sharedPreferences.getLong(str + ITroopSPUtilApi.KEY_TROOP_LUCKY_CHARACTER_STATUS + str2 + "time", 0L);
            String string = sharedPreferences.getString(str + ITroopSPUtilApi.KEY_TROOP_LUCKY_CHARACTER_STATUS + str2 + "wording", str3);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getKeyTroopLuckyCharacterStatus troopUin = " + str2 + ", lastFetchTime = " + j3 + ",wording" + string);
            }
            return new Object[]{Long.valueOf(j3), string};
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public int getTroopAioKeyWordVersion(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) context, (Object) str)).intValue();
        }
        int decodeInt = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt(str + "_" + AppConstants.Preferences.TROOP_AIO_KEYWORD_VERSION, 0);
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, "getTroopAioKeyWordVersion, version=" + decodeInt);
        }
        return decodeInt;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public boolean getTroopHasNewApp(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
        }
        if (appRuntime == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return appRuntime.getApp().getSharedPreferences(appRuntime.getCurrentAccountUin() + "_" + KEY_TROOP_APP_HAS_NEW, 0).getBoolean(str, false);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public int groupGroupNewsInfo(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, str, str2, str3)).intValue();
        }
        return BaseApplication.getContext().getSharedPreferences(ITroopSPUtilApi.TROOP_NEWS_NOTIFY, 4).getInt(str + str2 + str3, 0);
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public boolean hasShowTroopGameCardRedPoint(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        boolean z16 = BaseApplication.getContext().getSharedPreferences(str, 0).getBoolean(str + KEY_TROOP_GAME_CARD_RED_POINT_HAS_SHOWED + str2, false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "hasShowTroopGameCardRedPoint troopUin = " + str2 + ", isShow = " + z16);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public boolean isShowTroopGameCardRedPoint(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, str2, Boolean.valueOf(z16))).booleanValue();
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public void removeGroupTIMFileNewsInfo(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, str2, str3);
            return;
        }
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(str, 0).edit();
        edit.remove(str + ITroopSPUtilApi.KEY_GROUP_FILE_INNER_REDDOT_TIM + str3);
        edit.remove(str + ITroopSPUtilApi.KEY_GROUP_FILE_REDDOT_TIM + str3);
        edit.remove(str + str2 + str3);
        edit.apply();
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public void setAIOTroopMiniAppEntranceRedPoint(AppRuntime appRuntime, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, appRuntime, str, Boolean.valueOf(z16));
            return;
        }
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            appRuntime.getApplication().getSharedPreferences(appRuntime.getCurrentAccountUin() + "_" + KEY_AIO_TROOP_MINI_APP_ENTRANCE, 0).edit().putBoolean(str, z16).apply();
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public void setGroupGroupNewsInfo(String str, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, str2, str3, Integer.valueOf(i3));
            return;
        }
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(ITroopSPUtilApi.TROOP_NEWS_NOTIFY, 4).edit();
        edit.putInt(str + str2 + str3, i3);
        edit.commit();
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public void setGroupPadTemplateNewsInfoTips(String str, String str2, String str3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, str3, Boolean.valueOf(z16));
            return;
        }
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(str, 0).edit();
        edit.putBoolean(str + str2 + str3, z16);
        edit.commit();
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public void setGroupTIMFileNewsInfo(String str, String str2, String str3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, str2, str3, Boolean.valueOf(z16));
            return;
        }
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(str, 0).edit();
        if (z16) {
            edit.putBoolean(str + ITroopSPUtilApi.KEY_GROUP_FILE_INNER_REDDOT_TIM + str3, true);
            edit.putBoolean(str + ITroopSPUtilApi.KEY_GROUP_FILE_REDDOT_TIM + str3, true);
        } else {
            edit.putBoolean(str + ITroopSPUtilApi.KEY_GROUP_FILE_INNER_REDDOT_TIM + str3, false);
            edit.putBoolean(str + ITroopSPUtilApi.KEY_GROUP_FILE_REDDOT_TIM + str3, false);
        }
        edit.putBoolean(str + str2 + str3, z16);
        edit.apply();
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public void setTroopGameCardRedPoint(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16));
            return;
        }
        if (isReturnGameCardRedPoint == -1) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106010", true)) {
                isReturnGameCardRedPoint = 1;
            } else {
                isReturnGameCardRedPoint = 0;
            }
        }
        if (isReturnGameCardRedPoint == 1) {
            return;
        }
        if (QLog.isColorLevel() && z16) {
            QLog.d(TAG, 2, "setTroopGameCardRedPoint troopUin = " + str2 + ", isShowRedPoint = true");
        }
        BaseApplication.getContext().getSharedPreferences(str, 0).edit().putBoolean(str + KEY_TROOP_GAME_CARD_RED_POINT + str2, z16).apply();
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public void setTroopGameCardRedPointHasShowed(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setTroopGameCardRedPointHasShowed troopUin = " + str2 + ", isShowRedPoint = " + z16);
        }
        BaseApplication.getContext().getSharedPreferences(str, 0).edit().putBoolean(str + KEY_TROOP_GAME_CARD_RED_POINT_HAS_SHOWED + str2, z16).commit();
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public void setTroopHasNewApp(AppRuntime appRuntime, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, appRuntime, str, Boolean.valueOf(z16));
            return;
        }
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            appRuntime.getApp().getSharedPreferences(appRuntime.getCurrentAccountUin() + "_" + KEY_TROOP_APP_HAS_NEW, 0).edit().putBoolean(str, z16).apply();
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
    public void updateTroopAioKeyWordVersion(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, context, str, Integer.valueOf(i3));
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        from.encodeInt(str + "_" + AppConstants.Preferences.TROOP_AIO_KEYWORD_VERSION, i3);
        from.commitAsync();
    }
}
