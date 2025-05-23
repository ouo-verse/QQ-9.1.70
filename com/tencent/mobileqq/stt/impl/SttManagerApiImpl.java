package com.tencent.mobileqq.stt.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.m;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.vas.qqmc.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SttManagerApiImpl implements ISttManagerApi {
    static IPatchRedirector $redirector_ = null;
    public static final int ABILITY_ENABLE = 1;
    private static final String KEY_ABILITY = "k_ability_";
    private static final String KEY_CONFIG_VERSION = "k_c_v";
    private static final String PREF_STT = "rich_status";
    public static final String PTT_TAG = "vip_ptt.";
    public static final String TAG = "SttManagerApiImpl.";
    private static int sAbility;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22208);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            sAbility = -1;
        }
    }

    public SttManagerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private SharedPreferences getSPFromMMKV(AppRuntime appRuntime, String str) {
        if (appRuntime == null) {
            return null;
        }
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(appRuntime.getApp().getBaseContext(), "rich_status", "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("_migrate_flag_", false)) {
            QMMKV.migrateToSpAdapter(appRuntime.getApp().getBaseContext(), "rich_status", "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean("_migrate_flag_", true).apply();
        }
        return fromSpAdapter;
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerApi
    public int getConfigVersion(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime)).intValue();
        }
        SharedPreferences sPFromMMKV = getSPFromMMKV(appRuntime, "rich_status" + appRuntime.getCurrentUin());
        if (sPFromMMKV == null) {
            return 0;
        }
        return sPFromMMKV.getInt(KEY_CONFIG_VERSION, 0);
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerApi
    public boolean getSttAbility(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime)).booleanValue();
        }
        if (sAbility < 0) {
            SharedPreferences sPFromMMKV = getSPFromMMKV(appRuntime, "rich_status");
            if (sPFromMMKV == null) {
                sAbility = 0;
                return true;
            }
            sAbility = sPFromMMKV.getInt(KEY_ABILITY + appRuntime.getAccount(), 0);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerApi
    public void initAutoToTextSwitch(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
            return;
        }
        if (appRuntime == null) {
            return;
        }
        String currentUin = appRuntime.getCurrentUin();
        if (!TextUtils.equals(m.f179511a, currentUin)) {
            m.f179511a = currentUin;
            m.f179520j = false;
            QLog.e("vip_ptt.SttManagerApiImpl.", 1, "it have change the account so init ptt state value");
        }
        if (!m.f179520j) {
            String str = "businessinfo_ptt_auto_change_text_" + appRuntime.getCurrentAccountUin();
            String str2 = "businessinfo_ptt_auto_change_time_" + appRuntime.getCurrentAccountUin();
            String str3 = "businessinfo_ptt_auto_change_guide_has_show_" + appRuntime.getCurrentAccountUin();
            SharedPreferences sharedPreferences = appRuntime.getApplication().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0);
            QLog.e("vip_ptt.SttManagerApiImpl.", 1, "ignore initAutoToTextSwitch is svip=" + VasUtil.getSignedService(appRuntime).getVipStatus().isSVip() + " stage=" + QVipAutoPttConfig.INSTANCE.getStage());
            m.f179515e = sharedPreferences.getBoolean(str, false);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initAutoToTextSwitch enable=");
            sb5.append(m.f179515e);
            QLog.e("vip_ptt.SttManagerApiImpl.", 1, sb5.toString());
            m.f179516f = sharedPreferences.getLong(str2, Long.MAX_VALUE);
            m.f179517g = sharedPreferences.getBoolean(str3, false);
            m.f179520j = true;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "initAutoToTextSwitch switch:" + m.f179515e + ", time:" + m.f179516f + ", hasAddTips:" + m.f179517g);
            }
        }
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerApi
    public boolean isSttSession(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        if (i3 == 0 || i3 == 1 || i3 == 3000) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerApi
    public void resetSttAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            sAbility = -1;
        }
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerApi
    public void saveConfigVersion(AppRuntime appRuntime, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime, i3);
            return;
        }
        SharedPreferences sPFromMMKV = getSPFromMMKV(appRuntime, "rich_status" + appRuntime.getCurrentUin());
        if (sPFromMMKV == null) {
            return;
        }
        sPFromMMKV.edit().putInt(KEY_CONFIG_VERSION, i3).commit();
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerApi
    public boolean setSttAbility(AppRuntime appRuntime, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, appRuntime, Boolean.valueOf(z16))).booleanValue();
        }
        if (getSttAbility(appRuntime) == z16) {
            return false;
        }
        sAbility = z16 ? 1 : 0;
        SharedPreferences sPFromMMKV = getSPFromMMKV(appRuntime, "rich_status");
        if (sPFromMMKV == null) {
            return false;
        }
        sPFromMMKV.edit().putInt(KEY_ABILITY + appRuntime.getAccount(), sAbility).commit();
        return true;
    }
}
