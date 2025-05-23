package com.tencent.mobileqq.qwallet.impl;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.sp.QWalletSpFactory;
import com.tencent.qphone.base.util.BaseApplication;

/* loaded from: classes16.dex */
public class QWalletPreferenceApiImpl implements IQWalletPreferenceApi {
    public static final String KEY_DRAW_LAST_SUCC_MODEL = "key_draw_hb_last_succ_model";
    public static final String KEY_IDIOM_MATCH_IN_PHONE = "idiom_match_in_phone";
    public static final String KEY_PREFIX_LAST_SUCC = "key_last_succ_";
    public static final String KEY_PRIVACY_HAS_CLICK_AGREE = "privacy_has_click_agree";
    public static final String KEY_QWALLET_LAST_CLEAR_NOTIFY_TIME = "qwallet_last_clear_notify_time_";
    public static final String KEY_REDPACK_POPWND_BEGIN_TIME = "redpack_popwnd_begin_time_";
    public static final String KEY_REDPACK_POPWND_CURRENT = "redpack_popwnd_current_";
    public static final String KEY_REDPACK_POPWND_END_TIME = "redpack_popwnd_end_time_";
    public static final String KEY_REDPACK_POPWND_FREQ = "redpack_popwnd_freq_";
    public static final String KEY_REDPACK_POPWND_GROUP_TYPE = "redpack_popwnd_group_type_";
    public static final String KEY_REDPACK_POPWND_ID = "redpack_popwnd_id";
    public static final String KEY_REDPACK_POPWND_LAST_SHOW_TIME = "redpack_popwnd_last_show_time_";
    public static final String KEY_REDPACK_POPWND_NETWORK = "redpack_popwnd_network_";
    public static final String KEY_REDPACK_POPWND_STATE = "redpack_popwnd_state_";
    public static final String KEY_REDPACK_POPWND_TOTAL = "redpack_popwnd_total_";
    public static final String KEY_REDPACK_POPWND_URL = "redpack_popwnd_url_";
    public static final String KEY_REPORT_RANDOM = "download_report_random";
    public static final String KEY_SKIN_ENRTY_ERROR_TIPS = "skin_entry_error_tips";
    public static final String KEY_SPECIAL_SKIN_MAP = "skin_map";
    public static final String KEY_STRANGER_CHAT_EXT = "strangerchat_ext";
    public static final String KEY_VOICE_RECOGNIZE_IN_PHONE = "voice_recognieze_in_phone";
    public static final String KEY_VOICE_RECOGNIZE_IN_PHONE_TIPS = "voice_recognieze_in_phone_tips";
    public static final String PREF_KEY_CUR_SKIN_ID = "skin_id";
    public static final String PREF_KEY_SKIN_MD5 = "skin_md5";
    public static final String PREF_KEY_SKIN_RES_NUM = "skin_res_num";
    public static final String PREF_KEY_ZIP_URL = "zip_url";
    public static final String PREF_NAME_FOR_BIRTHDAY_REMINDER = "birthday_reminder_setting";
    public static final String PREF_NAME_QWALLET_SETTING_CLEAR_BEFORE_PULL = "qwallet_setting_clear_before_pull";
    public static final String PREF_NAME_QWALLET_SKIN = "qwallet_skin";
    public static final String PREF_NAME_SETTING = "qwallet_setting";

    private String getPrefName(String str) {
        return "qwallet_setting_clear_before_pull_" + str;
    }

    private SharedPreferences getPreference(String str) {
        return QWalletSpFactory.a(str, 4);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public void clearSp(String str) {
        SharedPreferences preference = getPreference(getPrefName(str));
        if (preference != null) {
            preference.edit().clear().apply();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public boolean getBoolean(String str, String str2, boolean z16) {
        SharedPreferences preference = getPreference(PREF_NAME_SETTING);
        if (preference == null) {
            return z16;
        }
        return preference.getBoolean(str2 + str, z16);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public boolean getBooleanFromSp(String str, String str2, boolean z16) {
        SharedPreferences preference = getPreference(getPrefName(str));
        if (preference != null) {
            return preference.getBoolean(str2, z16);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public int getInt(String str, String str2, int i3) {
        SharedPreferences preference = getPreference(PREF_NAME_SETTING);
        if (preference == null) {
            return i3;
        }
        return preference.getInt(str2 + str, i3);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public int getIntFromSp(String str, String str2, int i3) {
        SharedPreferences preference = getPreference(getPrefName(str));
        if (preference != null) {
            return preference.getInt(str2, i3);
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public long getLong(String str, String str2, long j3) {
        SharedPreferences preference = getPreference(PREF_NAME_SETTING);
        if (preference != null) {
            return preference.getLong(str2 + str, j3);
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public long getLongFromSp(String str, String str2, long j3) {
        SharedPreferences preference = getPreference(getPrefName(str));
        if (preference != null) {
            return preference.getLong(str2, j3);
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public String getString(String str, String str2, String str3) {
        SharedPreferences preference = getPreference(PREF_NAME_SETTING);
        if (preference != null) {
            return preference.getString(str2 + str, str3);
        }
        return str3;
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public String getStringFromSp(String str, String str2, String str3) {
        SharedPreferences preference = getPreference(getPrefName(str));
        if (preference != null) {
            return preference.getString(str2, str3);
        }
        return str3;
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public boolean isShowF2FRedpackEntryColor(String str) {
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public void putBoolean(String str, String str2, boolean z16) {
        SharedPreferences preference = getPreference(PREF_NAME_SETTING);
        if (preference != null) {
            preference.edit().putBoolean(str2 + str, z16).commit();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public void putBooleanToSp(String str, String str2, boolean z16) {
        SharedPreferences preference = getPreference(getPrefName(str));
        if (preference != null) {
            preference.edit().putBoolean(str2, z16).commit();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public void putInt(String str, String str2, int i3) {
        SharedPreferences preference = getPreference(PREF_NAME_SETTING);
        if (preference != null) {
            preference.edit().putInt(str2 + str, i3).commit();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public void putIntToSp(String str, String str2, int i3) {
        SharedPreferences preference = getPreference(getPrefName(str));
        if (preference != null) {
            preference.edit().putInt(str2, i3).commit();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public void putLong(String str, String str2, long j3) {
        SharedPreferences preference = getPreference(PREF_NAME_SETTING);
        if (preference != null) {
            preference.edit().putLong(str2 + str, j3).commit();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public void putLongToSp(String str, String str2, long j3) {
        SharedPreferences preference = getPreference(getPrefName(str));
        if (preference != null) {
            preference.edit().putLong(str2, j3).commit();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public void putString(String str, String str2, String str3) {
        SharedPreferences preference = getPreference(PREF_NAME_SETTING);
        if (preference != null) {
            preference.edit().putString(str2 + str, str3).apply();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public void putStringToSp(String str, String str2, String str3) {
        SharedPreferences preference = getPreference(getPrefName(str));
        if (preference != null) {
            preference.edit().putString(str2, str3).apply();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public void removeSp(String str, String str2) {
        SharedPreferences preference = getPreference(PREF_NAME_SETTING);
        if (preference != null) {
            preference.edit().remove(str2 + str).apply();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public boolean getBoolean(String str, String str2, String str3, boolean z16) {
        SharedPreferences sharedPreferences;
        if (BaseApplication.getContext() == null || (sharedPreferences = BaseApplication.getContext().getSharedPreferences(PREF_NAME_FOR_BIRTHDAY_REMINDER, 4)) == null) {
            return z16;
        }
        return sharedPreferences.getBoolean(str + "_" + str2 + "_" + str3, z16);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public int getInt(String str, int i3) {
        SharedPreferences sharedPreferences;
        if (BaseApplication.getContext() == null || (sharedPreferences = BaseApplication.getContext().getSharedPreferences(PREF_NAME_FOR_BIRTHDAY_REMINDER, 4)) == null) {
            return i3;
        }
        return sharedPreferences.getInt(str + "_pack_count", i3);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public void putBoolean(String str, String str2, String str3, boolean z16) {
        SharedPreferences sharedPreferences;
        if (BaseApplication.getContext() == null || (sharedPreferences = BaseApplication.getContext().getSharedPreferences(PREF_NAME_FOR_BIRTHDAY_REMINDER, 4)) == null) {
            return;
        }
        sharedPreferences.edit().putBoolean(str + "_" + str2 + "_" + str3, z16).commit();
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
    public void putInt(String str, int i3) {
        SharedPreferences sharedPreferences;
        if (BaseApplication.getContext() == null || (sharedPreferences = BaseApplication.getContext().getSharedPreferences(PREF_NAME_FOR_BIRTHDAY_REMINDER, 4)) == null) {
            return;
        }
        sharedPreferences.edit().putInt(str + "_pack_count", i3).commit();
    }
}
