package com.tencent.mobileqq.simpleui;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.NormalNightModeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f288518a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75147);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f288518a = false;
        }
    }

    public static int a() {
        int simpleUIExpLebaFrameMode = SimpleUIUtil.getSimpleUIExpLebaFrameMode();
        boolean z16 = true;
        QLog.d("SimpleUIProtocolUtil", 1, "getSimpleUIExpLebaFrameMode = " + simpleUIExpLebaFrameMode);
        if (MobileQQ.sProcessId != 1) {
            z16 = false;
        }
        if (z16 && simpleUIExpLebaFrameMode != Integer.MIN_VALUE) {
            return simpleUIExpLebaFrameMode;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            simpleUIExpLebaFrameMode = ThemeUtil.getUinThemePreferences(runtime).getInt(ThemeConstants.KEY_SIMPLE_UI_EXP_LEBA_FRAME_MODE, Integer.MIN_VALUE);
            SimpleUIUtil.setSimpleUIExpLebaFrameMode(simpleUIExpLebaFrameMode);
        }
        return j(simpleUIExpLebaFrameMode);
    }

    public static int b() {
        int simpleUILebaFeedsAvatarJumpType = SimpleUIUtil.getSimpleUILebaFeedsAvatarJumpType();
        boolean z16 = true;
        QLog.d("SimpleUIProtocolUtil", 1, "getSimpleUILebaFeedsAvatarJumpType = " + simpleUILebaFeedsAvatarJumpType);
        if (MobileQQ.sProcessId != 1) {
            z16 = false;
        }
        if (z16 && simpleUILebaFeedsAvatarJumpType != Integer.MIN_VALUE) {
            return simpleUILebaFeedsAvatarJumpType;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            simpleUILebaFeedsAvatarJumpType = ThemeUtil.getUinThemePreferences(runtime).getInt("key_simple_ui_leba_feeds_avatar_jump_type", Integer.MIN_VALUE);
            SimpleUIUtil.setSimpleUILebaFeedsAvatarJumpType(simpleUILebaFeedsAvatarJumpType);
        }
        return k(simpleUILebaFeedsAvatarJumpType);
    }

    public static void c(AppInterface appInterface, boolean z16, String str) {
        SimpleUIUtil.setSimpleNightIndex(SimpleUIUtil.getThemeIndex("2920"));
        int themeIndex = SimpleUIUtil.getThemeIndex(str);
        g(appInterface.getCurrentAccountUin(), z16, 1);
        f(appInterface.getCurrentAccountUin(), themeIndex, 1);
    }

    public static final void d(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("SimpleUIProtocolUtil", 1, "onGetSimpleUIExpLebaFrameMode lebaMode=" + i3);
        }
        SimpleUIUtil.setSimpleUIExpLebaFrameMode(i3);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && str.equals(runtime.getCurrentAccountUin())) {
            ThemeUtil.getUinThemePreferences(runtime).edit().putInt(ThemeConstants.KEY_SIMPLE_UI_EXP_LEBA_FRAME_MODE, i3).commit();
        }
    }

    public static void e(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("SimpleUIProtocolUtil", 1, "onGetSimpleUILebaFeedsAvatarJumpType targetType = " + i3);
        }
        SimpleUIUtil.setSimpleUILebaFeedsAvatarJumpType(i3);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && str.equals(runtime.getCurrentAccountUin())) {
            ThemeUtil.getUinThemePreferences(runtime).edit().putInt("key_simple_ui_leba_feeds_avatar_jump_type", i3).commit();
        }
    }

    public static final void f(String str, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("SimpleUIProtocolUtil", 1, String.format("onGetSimpleUIPref type=%d bPref=%d uin=%s", Integer.valueOf(i16), Integer.valueOf(i3), str));
        }
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface != null && str.equals(qQAppInterface.getCurrentAccountUin())) {
            i(qQAppInterface, i3);
            if (i16 == 1) {
                h(str);
            }
        }
    }

    public static final void g(String str, boolean z16, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("SimpleUIProtocolUtil", 1, String.format("onGetSimpleUISwitch type=%d bSwitch=%b uin=%s", Integer.valueOf(i3), Boolean.valueOf(z16), str));
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null && str.equals(qQAppInterface.getCurrentAccountUin())) {
            SimpleUIUtil.setSimpleUISwitchInt(z16 ? 1 : 0);
            ThemeUtil.getUinThemePreferences(qQAppInterface).edit().putBoolean(ThemeConstants.KEY_SIMPLE_UI_SWITCH, z16).commit();
            if (!NormalNightModeUtil.getNormalNightModeFeatureSwitch() && i3 == 1) {
                h(str);
            }
        }
    }

    private static final void h(String str) {
        boolean z16;
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface != null && SimpleUIUtil.getSimpleUISwitchInt() != Integer.MIN_VALUE && SimpleUIUtil.getSimpleUIPrefInt() != Integer.MIN_VALUE && SimpleUIUtil.isValidSimplePref(SimpleUIUtil.getSimpleUIPrefInt())) {
            SimpleUIHandler simpleUIHandler = (SimpleUIHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
            if (SimpleUIUtil.getSimpleUISwitchInt() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            int simpleUIPrefInt = SimpleUIUtil.getSimpleUIPrefInt();
            simpleUIHandler.X2(z16, simpleUIPrefInt);
            simpleUIHandler.notifyUI(4, true, new Object[]{Boolean.valueOf(z16), Integer.valueOf(simpleUIPrefInt), str});
            if (QLog.isColorLevel()) {
                QLog.i("SimpleUIProtocolUtil", 1, String.format(Locale.getDefault(), "onGetSimpleUISwitchOnLogin [%b,%b]", Boolean.valueOf(z16), Integer.valueOf(simpleUIPrefInt)));
            }
        }
    }

    public static void i(QQAppInterface qQAppInterface, int i3) {
        if (!SimpleUIUtil.isValidSimplePref(i3)) {
            i3 = 0;
        }
        SimpleUIUtil.setSimpleUIPrefInt(i3);
        SharedPreferences uinThemePreferences = ThemeUtil.getUinThemePreferences(qQAppInterface);
        uinThemePreferences.edit().putInt(ThemeConstants.KEY_SIMPLE_UI_PREF_828, i3).apply();
        if (i3 != SimpleUIUtil.INDEX_OF_SIMPLE_UI_NIGHT) {
            SimpleUIUtil.setSimpleNoNightPrefInt(i3);
            uinThemePreferences.edit().putInt(ThemeConstants.KEY_SIMPLE_NO_NIGHT_UI_828, i3).apply();
        }
    }

    private static int j(int i3) {
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            QLog.e("SimpleUIProtocolUtil", 1, "transToValidConciseMode mode= " + i3);
            return 0;
        }
        return i3;
    }

    private static int k(int i3) {
        if (i3 != 0 && i3 != 1) {
            QLog.e("SimpleUIProtocolUtil", 1, "transToValidConciseMode targetType = " + i3);
            return 0;
        }
        return i3;
    }
}
