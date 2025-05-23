package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.vas.theme.ThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class SwitchSimpleModeResult extends g {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class SimpleThemeSwitchCallback extends ThemeSwitchCallback {
        static IPatchRedirector $redirector_;

        SimpleThemeSwitchCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
        public boolean postSwitch(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
            }
            return false;
        }
    }

    public SwitchSimpleModeResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, String str, int i3) {
        if (!SimpleUIUtil.isValidSimplePref(i3)) {
            return;
        }
        com.tencent.mobileqq.simpleui.g.i(qQAppInterface, i3);
        com.tencent.mobileqq.simpleui.g.g(str, true, 1);
        com.tencent.mobileqq.simpleui.g.f(str, i3, 1);
        QLog.i("SwitchSimpleUILoginSucUtils", 1, "uin: " + str + ", simpleModeType: " + i3);
    }

    private static void g(QQAppInterface qQAppInterface, String str) {
        ((IThemeSwitcher) QRoute.api(IThemeSwitcher.class)).startSwitch("2971", ThemeSwitchUtil.FROM_LOGIN_RESULT, new SimpleThemeSwitchCallback());
        com.tencent.mobileqq.simpleui.g.i(qQAppInterface, 0);
        com.tencent.mobileqq.simpleui.g.g(str, true, 1);
        com.tencent.mobileqq.simpleui.g.f(str, 0, 1);
    }

    private static void h(SharedPreferences sharedPreferences, int i3) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("currentThemeId_6.3.5", "2971");
        edit.putBoolean(ThemeConstants.KEY_SIMPLE_SHOULD_SHOW_SWITCH_DIALOG, false);
        if (i3 == 2) {
            edit.putBoolean("key_simple_show_welcome_back_dialog", true);
        }
        edit.putInt("key_use_simple_mode_directly_user_type", 0);
        edit.putInt("key_use_simple_mode_directly", -1);
        edit.apply();
    }

    protected static boolean i(AppRuntime appRuntime) {
        return ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("normal_user_switch_to_simple_mode_directly");
    }

    public static void j(AppRuntime appRuntime, String str, int i3, int i16, int i17) {
        boolean z16;
        SharedPreferences uinThemePreferences = ThemeUtil.getUinThemePreferences(appRuntime);
        boolean z17 = false;
        if (i3 != 1 && i3 != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (i3 == 3) {
            z17 = true;
        }
        if (z16 && i16 != -1) {
            if (appRuntime instanceof QQAppInterface) {
                g((QQAppInterface) appRuntime, str);
            }
            h(uinThemePreferences, i3);
        } else if (z17 && i17 != -1 && i(appRuntime) && (appRuntime instanceof QQAppInterface)) {
            b((QQAppInterface) appRuntime, str, i17);
        }
        QLog.d("SwitchSimpleUILoginSucUtils", 1, "switchSimpleUILoginSuccess::: uin: " + str + ", userType: " + i3 + ", newOrBackUserDoSwitch: " + i16 + ", normalUserSimpleModeType: " + i17);
    }

    @Override // com.tencent.mobileqq.loginregister.g, com.tencent.mobileqq.loginregister.t
    public boolean a(AppRuntime appRuntime, Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, appRuntime, activity, str)).booleanValue();
        }
        return true;
    }
}
