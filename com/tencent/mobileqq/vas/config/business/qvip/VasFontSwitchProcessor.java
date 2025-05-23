package com.tencent.mobileqq.vas.config.business.qvip;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes20.dex */
public class VasFontSwitchProcessor extends BaseQVipConfigProcessor<VasFontSwitchConfig> {
    public static final int CMD = 359;
    public static final String TAG = "VasFontSwitchProcessor";

    public static void updateConfigContentForTag(Context context, String str, String str2, String str3) {
        String format = String.format(Locale.getDefault(), "%s_%s_config_content", str, str2);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(format, str3);
        edit.apply();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<VasFontSwitchConfig> clazz() {
        return VasFontSwitchConfig.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 359;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public VasFontSwitchConfig migrateDefaultContent() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        FontManagerConstants.resetFontSwitch();
        updateConfigContentForTag(waitAppRuntime.getApp(), waitAppRuntime.getCurrentUin(), AppConstants.Preferences.VAS_FONT_SWITCH_CONFIG, "reset");
        return new VasFontSwitchConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public VasFontSwitchConfig migrateOldContent() {
        return new VasFontSwitchConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public VasFontSwitchConfig parsed(ai[] aiVarArr) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        FontManagerConstants.updateFontSwitch(aiVarArr[0].f202268b);
        updateConfigContentForTag(waitAppRuntime.getApp(), waitAppRuntime.getCurrentUin(), AppConstants.Preferences.VAS_FONT_SWITCH_CONFIG, aiVarArr[0].f202268b);
        return new VasFontSwitchConfig();
    }
}
