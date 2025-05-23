package com.tencent.qqnt.doutu.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.doutu.api.IDoutuSPUtil;

/* loaded from: classes24.dex */
public class DoutuSPUtilImpl implements IDoutuSPUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String DOUTU_CACHE_SP_NAME = "DOUTU_CACHE_SP";

    public DoutuSPUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private SharedPreferences getDefaultSharedPreferences() {
        return QMMKV.fromSpAdapter(BaseApplication.context, DOUTU_CACHE_SP_NAME, "common_mmkv_configurations");
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public long getComboDuration(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Long) iPatchRedirector.redirect((short) 22, (Object) this, (Object) context, (Object) str)).longValue();
        }
        return getDefaultSharedPreferences().getLong("doutu_config_combo_duration_" + str, 0L);
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public long getComboKeep(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Long) iPatchRedirector.redirect((short) 25, (Object) this, (Object) context, (Object) str)).longValue();
        }
        return getDefaultSharedPreferences().getLong("doutu_config_combo_keep_" + str, 0L);
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public boolean getDoutuComboSwitch(Context context, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, context, str, Boolean.valueOf(z16))).booleanValue();
        }
        return getDefaultSharedPreferences().getBoolean("doutu_combo_config_switch_" + str, z16);
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public int getDoutuConfigAppId(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) str)).intValue();
        }
        return getDefaultSharedPreferences().getInt(str + "_" + AppConstants.Preferences.DOUTU_CONFIG_APPID, 0);
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public long getDoutuDuration(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this, (Object) context, (Object) str)).longValue();
        }
        return getDefaultSharedPreferences().getLong("doutu_config_duration_" + str, 0L);
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public boolean getDoutuResDamaged(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) context)).booleanValue();
        }
        return getDefaultSharedPreferences().getBoolean(AppConstants.Preferences.DOUTU_RES_DAMAGED, false);
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public String getDoutuResMd5(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this, (Object) context, (Object) str);
        }
        return getDefaultSharedPreferences().getString("doutu_res_md5_" + str, "");
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public String getDoutuResUrl(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this, (Object) context, (Object) str);
        }
        return getDefaultSharedPreferences().getString("doutu_res_url_" + str, "");
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public boolean getDoutuSettingSwitch(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) str)).booleanValue();
        }
        return getDefaultSharedPreferences().getBoolean("doutu_setting_switch_" + str, true);
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public boolean getDoutuSmartSwitchNew(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, (Object) str)).booleanValue();
        }
        return getDefaultSharedPreferences().getBoolean("doutu_recommend_switch_" + str, false);
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public boolean getDoutuSwitch(Context context, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, context, str, Boolean.valueOf(z16))).booleanValue();
        }
        return getDefaultSharedPreferences().getBoolean("doutu_config_switch_" + str, z16);
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public int getDuiTimes(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, (Object) context, (Object) str)).intValue();
        }
        return getDefaultSharedPreferences().getInt("doutu_config_duitimes_" + str, 0);
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public int getSmartPicCount(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this, (Object) context, (Object) str)).intValue();
        }
        return getDefaultSharedPreferences().getInt("doutu_smart_default_count_" + str, 0);
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void removeComboDuration(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) context, (Object) str);
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.remove("doutu_config_combo_duration_" + str);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void removeComboKeep(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) context, (Object) str);
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.remove("doutu_config_combo_keep_" + str);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void removeDoutuComboSwitch(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context, (Object) str);
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.remove("doutu_combo_config_switch_" + str);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void removeDoutuDuration(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) context, (Object) str);
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.remove("doutu_config_duration_" + str);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void removeDoutuResMd5(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) context, (Object) str);
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.remove("doutu_res_md5_" + str);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void removeDoutuResUrl(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) context, (Object) str);
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.remove("doutu_res_url_" + str);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void removeDoutuSmartSwitchNew(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) context, (Object) str);
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.remove("doutu_recommend_switch_" + str);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void removeDoutuSwitch(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) str);
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.remove("doutu_config_switch_" + str);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void removeDuiTimes(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) context, (Object) str);
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.remove("doutu_config_duitimes_" + str);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void removeSmartPicCount(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) context, (Object) str);
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.remove("doutu_smart_default_count_" + str);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void updateComboDuration(Context context, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, context, str, Long.valueOf(j3));
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.putLong("doutu_config_combo_duration_" + str, j3);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void updateComboKeep(Context context, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, context, str, Long.valueOf(j3));
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.putLong("doutu_config_combo_keep_" + str, j3);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void updateDoutuComboSwitch(Context context, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, context, str, Boolean.valueOf(z16));
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.putBoolean("doutu_combo_config_switch_" + str, z16);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void updateDoutuConfigAppId(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, str, Integer.valueOf(i3));
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.putInt(str + "_" + AppConstants.Preferences.DOUTU_CONFIG_APPID, i3);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void updateDoutuConfigVersion(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, Integer.valueOf(i3));
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.putInt("doutu_config_version_" + str, i3);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void updateDoutuDuration(Context context, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, context, str, Long.valueOf(j3));
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.putLong("doutu_config_duration_" + str, j3);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void updateDoutuResDamaged(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, context, Boolean.valueOf(z16));
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.putBoolean(AppConstants.Preferences.DOUTU_RES_DAMAGED, z16);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void updateDoutuResMd5(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, context, str, str2);
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.putString("doutu_res_md5_" + str, str2);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void updateDoutuResUrl(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, context, str, str2);
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.putString("doutu_res_url_" + str, str2);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void updateDoutuSettingSwitch(Context context, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, str, Boolean.valueOf(z16));
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.putBoolean("doutu_setting_switch_" + str, z16);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void updateDoutuSmartSwitchNew(Context context, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, context, str, Boolean.valueOf(z16));
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.putBoolean("doutu_recommend_switch_" + str, z16);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void updateDoutuSwitch(Context context, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, str, Boolean.valueOf(z16));
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.putBoolean("doutu_config_switch_" + str, z16);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void updateDuiTimes(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, context, str, Integer.valueOf(i3));
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.putInt("doutu_config_duitimes_" + str, i3);
        edit.commit();
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuSPUtil
    public void updateSmartPicCount(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, context, str, Integer.valueOf(i3));
            return;
        }
        SharedPreferences.Editor edit = getDefaultSharedPreferences().edit();
        edit.putInt("doutu_smart_default_count_" + str, i3);
        edit.commit();
    }
}
