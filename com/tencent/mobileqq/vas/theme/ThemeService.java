package com.tencent.mobileqq.vas.theme;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.k;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeService implements k {
    private static final String TAG = "ThemeService";
    private final HashMap<String, String> switchConfigCache = new HashMap<>();
    private static HashMap<String, Boolean> sSwitchCache = new HashMap<>();
    public static final IConfigProxy VAS_THEME_ENGINE_LOAD_SYNC = new UnitedProxy("vas_theme_engine_drawable_load_sync", true);
    public static final IConfigProxy VAS_THEME_ENGINE_LOCK_RELEASE = new UnitedProxy("vas_theme_engine_lock_release", true);
    public static final IConfigProxy VAS_THEME_ENGINE_DRAW_9_PATCH_ERROR = new UnitedProxy("vas_theme_engine_draw_9_patch_error", true);
    public static final IConfigProxy VAS_THEME_ENGINE_ENABLE_9_PATCH_REPORT = new UnitedProxy("vas_theme_engine_report_9_patch", true);

    private static boolean getToggleValue(String str, boolean z16) {
        if (str.equals("vas_theme_engine_bf_anr") || str.equals("vas_theme_engine_clean_resource_cache") || str.equals(VasToggle.THEME_ENGINE_CACHE_TASK.getName()) || str.equals("vas_theme_engine_anr_wait")) {
            return false;
        }
        if (str.equals("vas_theme_engine_new_thread_pool") || str.equals("vas_theme_engine_change_init_order")) {
            return true;
        }
        if (str.equals("vas_theme_engine_use_new_cache")) {
            return false;
        }
        if (str.equals("vas_theme_engine_resources_transform_new")) {
            return true;
        }
        if (str.equals("vas_theme_engine_feature_mutate")) {
            return false;
        }
        if (str.equals("vas_theme_engine_load_sync")) {
            return VAS_THEME_ENGINE_LOAD_SYNC.isEnable(false);
        }
        if (str.equals("vas_theme_engine_release_lock")) {
            return VAS_THEME_ENGINE_LOCK_RELEASE.isEnable(true);
        }
        if (str.equals("switch_update_failed_fixed")) {
            return true;
        }
        if (str.equals("vas_theme_engine_draw_9_patch_error")) {
            return VAS_THEME_ENGINE_DRAW_9_PATCH_ERROR.isEnable(false);
        }
        if (str.equals("vas_theme_engine_enable_color_first")) {
            return true;
        }
        return z16;
    }

    @Override // com.tencent.theme.k
    public void execute(Runnable runnable) {
        if (VasNormalToggle.VAS_THEME_ENGINE_THREAD_POOL.isEnable(true)) {
            BaseThread baseThread = new BaseThread(runnable);
            baseThread.setPriority(10);
            baseThread.start();
            return;
        }
        ThreadManagerV2.excute(runnable, 16, null, false);
    }

    @Override // com.tencent.theme.k
    public void reportError(Throwable th5, String str) {
        if (VasNormalToggle.VAS_THEME_ENGINE_BUG_LOG.isEnable(true)) {
            com.tencent.qqperf.monitor.crash.catchedexception.a.c(th5, str);
        } else {
            SkinEngine.BUG_LOCATE = false;
        }
    }

    @Override // com.tencent.theme.k
    public void reportLoadOverTime(final String str, final long j3, final int i3) {
        if (VasNormalToggle.VAS_THEME_ENGINE_OVER_TIME_REPORT.isEnable(true)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.ThemeService.1
                @Override // java.lang.Runnable
                public void run() {
                    VasCommonReporter.getThemeEngine().setNum1(0L).setNum2(j3).setNum3(i3).setValue1(str).setValue2(QQTheme.getCurrentThemeId()).report();
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.theme.k
    public void reportResInfo(final String str, final int i3, final String str2, String str3, String str4) {
        final int i16 = 2;
        if (i3 == 1 && VAS_THEME_ENGINE_ENABLE_9_PATCH_REPORT.isEnable(true)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.ThemeService.2
                @Override // java.lang.Runnable
                public void run() {
                    VasCommonReporter.getThemeEngine().setNum1(i16).setNum2(i3).setValue1(QQTheme.getCurrentThemeId()).setValue2(str).setValue3(str2).report();
                    QLog.e(ThemeService.TAG, 1, "theme report wrong 9-patch:" + str + ",themeId:" + QQTheme.getCurrentThemeId());
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.theme.k
    public void runOnUIThread(Runnable runnable) {
        ThreadManager.getUIHandler().post(runnable);
    }

    public String switchConfig(String str) {
        String str2 = "";
        try {
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getCause(), new Object[0]);
        }
        if (this.switchConfigCache.containsKey(str)) {
            return this.switchConfigCache.get(str);
        }
        str2 = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(str, new byte[0]), StandardCharsets.UTF_8).trim();
        this.switchConfigCache.put(str, str2);
        return str2;
    }

    @Override // com.tencent.theme.k
    public boolean switchOn(String str, boolean z16) {
        return switchOn(str, z16, QLog.isColorLevel());
    }

    public static boolean switchOn(String str, boolean z16, boolean z17) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Boolean bool = sSwitchCache.get(str);
        if (bool == null) {
            bool = Boolean.valueOf(getToggleValue(str, z16));
            sSwitchCache.put(str, bool);
            if (z17) {
                QLog.d(TAG, 1, "use cache k=" + str + ",v=" + bool);
            }
        }
        return Boolean.TRUE.equals(bool);
    }
}
