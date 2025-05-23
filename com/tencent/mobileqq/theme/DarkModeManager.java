package com.tencent.mobileqq.theme;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.i;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.settings.message.ao;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DarkModeManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f292785a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f292786b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f292794d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f292795e;

        a(boolean z16, boolean z17) {
            this.f292794d = z16;
            this.f292795e = z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            DarkModeManager.n("0X800A5B5");
            if (QLog.isColorLevel()) {
                QLog.d("DarkModeManager", 2, "showDarkModeTips systemDarMode  = " + this.f292794d);
            }
            DarkModeManager.v(true);
            DarkModeManager.s(this.f292794d, this.f292795e, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f292796d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f292797e;

        b(String str, String str2) {
            this.f292796d = str;
            this.f292797e = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QQAppInterface a16 = DarkModeManager.a();
            if (a16 != null) {
                ((ThemeHandler) a16.getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER)).M2(this.f292796d, this.f292797e);
            }
            DarkModeManager.n("0X800A5B6");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f292798d;

        c(e eVar) {
            this.f292798d = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            DarkModeManager.n("0X800A5CB");
            if (QLog.isColorLevel()) {
                QLog.d("DarkModeManager", 2, "showThemeDarkModeTips");
            }
            DarkModeManager.v(false);
            e eVar = this.f292798d;
            if (eVar != null) {
                eVar.onConfirm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f292799d;

        d(e eVar) {
            this.f292799d = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            DarkModeManager.n("0X800A5CA");
            e eVar = this.f292799d;
            if (eVar != null) {
                eVar.onCancel();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface e {
        void onCancel();

        void onConfirm();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75885);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f292785a = false;
            f292786b = false;
        }
    }

    static /* bridge */ /* synthetic */ QQAppInterface a() {
        return g();
    }

    public static boolean c(String str, String str2) {
        boolean z16;
        if (k()) {
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            if (baseActivity == null || baseActivity.isFinishing()) {
                return false;
            }
            if ((baseActivity.getResources().getConfiguration().uiMode & 48) == 32) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, null);
            if (QLog.isColorLevel()) {
                QLog.d("DarkModeManager", 2, "afterDownloadRoamTheme isNightMode  = " + isNowThemeIsNight + ", isDarkMode = " + z16 + ", isCurrentVersionFirstLaunch = " + com.tencent.mobileqq.automator.a.f199911b);
            }
            if (z16 == isNowThemeIsNight) {
                return false;
            }
            if (!i() && i.a()) {
                if (QLog.isColorLevel()) {
                    QLog.d("DarkModeManager", 2, "afterDownloadRoamTheme dialog will show!");
                }
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    d(z16, isNowThemeIsNight, str, str2);
                } else {
                    ThreadManager.getUIHandler().post(new Runnable(z16, isNowThemeIsNight, str, str2) { // from class: com.tencent.mobileqq.theme.DarkModeManager.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f292787d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ boolean f292788e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ String f292789f;

                        /* renamed from: h, reason: collision with root package name */
                        final /* synthetic */ String f292790h;

                        {
                            this.f292787d = z16;
                            this.f292788e = isNowThemeIsNight;
                            this.f292789f = str;
                            this.f292790h = str2;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(isNowThemeIsNight), str, str2);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                DarkModeManager.d(this.f292787d, this.f292788e, this.f292789f, this.f292790h);
                            }
                        }
                    });
                }
                return true;
            }
            if (m()) {
                s(z16, isNowThemeIsNight, null);
                if (QLog.isColorLevel()) {
                    QLog.d("DarkModeManager", 2, "afterDownloadRoamTheme iscalled! switch is opened, so switch theme!");
                }
                return true;
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("DarkModeManager", 2, "afterDownloadRoamTheme iscalled! the system version is lower 29! so do not dialog!");
        }
        return false;
    }

    protected static void d(boolean z16, boolean z17, String str, String str2) {
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null && !baseActivity.isFinishing()) {
            String string = baseActivity.getString(R.string.vr9);
            if (!z16) {
                string = baseActivity.getString(R.string.vr5);
            }
            QQCustomDialog createCenterTextDialog = DialogUtil.createCenterTextDialog(baseActivity, 0, null, string, baseActivity.getString(R.string.cancel), baseActivity.getString(R.string.a8j), new a(z16, z17), new b(str, str2));
            createCenterTextDialog.show();
            createCenterTextDialog.setCancelable(false);
            o();
            n("0X800A5B4");
            return;
        }
        QLog.e("DarkModeManager", 2, "showDarkModeTips error!: ");
    }

    private static void e(IThemeSwitchCallback iThemeSwitchCallback) {
        String string;
        int i3;
        if (SimpleUIUtil.getSimpleUISwitch()) {
            int simpleNoNightUIPref = SimpleUIUtil.getSimpleNoNightUIPref();
            string = SimpleUIUtil.getThemeId(simpleNoNightUIPref);
            try {
                QQAppInterface g16 = g();
                if (g16 != null) {
                    l lVar = (l) g16.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
                    if (ElderModeManager.j()) {
                        i3 = 3;
                    } else {
                        i3 = 1;
                    }
                    lVar.l(simpleNoNightUIPref, i3);
                }
            } catch (NullPointerException unused) {
            }
        } else {
            QQAppInterface g17 = g();
            if (g17 == null) {
                return;
            }
            Bundle previousThemeIdVersion = ThemeSwitchUtil.getPreviousThemeIdVersion(g17);
            string = previousThemeIdVersion.getString("themeID");
            QLog.d("DarkModeManager", 1, "closedNightMode, pre themeID=" + string + MttLoader.QQBROWSER_PARAMS_VERSION + previousThemeIdVersion.getString("version"));
            if (TextUtils.isEmpty(string)) {
                string = "1000";
            }
        }
        QLog.d("DarkModeManager", 1, "closedNightMode is called, will set themeID=" + string);
        ThemeSwitcher.startSwitch(string, ThemeReporter.FROM_NIGHT, iThemeSwitchCallback);
    }

    public static boolean f() {
        j();
        if (QLog.isColorLevel()) {
            QLog.d("DarkModeManager", 2, "getDarkModeSwitch isOpened  = " + f292785a);
        }
        return f292785a;
    }

    @Nullable
    private static QQAppInterface g() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            AppRuntime runtime = application.getRuntime();
            if (runtime instanceof QQAppInterface) {
                return (QQAppInterface) runtime;
            }
        }
        return null;
    }

    private static SharedPreferences h() {
        AppRuntime runtime;
        try {
            BaseApplicationImpl application = BaseApplicationImpl.getApplication();
            if (application == null || (runtime = application.getRuntime()) == null) {
                return null;
            }
            return runtime.getApplication().getSharedPreferences("DarkModeManagerdark_mode_ui", 4);
        } catch (Throwable th5) {
            QLog.e("DarkModeManager", 2, "getSharedPreferences error!: ", th5);
            return null;
        }
    }

    private static boolean i() {
        SharedPreferences h16 = h();
        if (h16 == null) {
            return false;
        }
        return h16.getBoolean("dialog_has_shown_key", false);
    }

    private static void j() {
        SharedPreferences h16 = h();
        if (h16 != null) {
            f292785a = h16.getBoolean("dark_switch_key", false);
        } else {
            f292785a = true;
        }
    }

    public static boolean k() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    public static boolean l(String str) {
        boolean z16;
        if (!m()) {
            return true;
        }
        if ((BaseApplicationImpl.getApplication().getApplicationContext().getResources().getConfiguration().uiMode & 48) == 32) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, str);
        if (QLog.isColorLevel()) {
            QLog.d("DarkModeManager", 2, "updateDarkModeStatus isNightMode  = " + isNowThemeIsNight + ", isDarkMode = " + z16);
        }
        if (z16 == isNowThemeIsNight) {
            return true;
        }
        return false;
    }

    public static boolean m() {
        if (MobileQQ.sProcessId != 1 || !k() || !f()) {
            return false;
        }
        return true;
    }

    public static void n(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("DarkModeManager", 2, "report() called with: key = [" + str + "]");
        }
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }

    private static void o() {
        SharedPreferences h16 = h();
        if (h16 == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DarkModeManager", 2, "setShownPromtFlag is called!");
        }
        h16.edit().putBoolean("dialog_has_shown_key", true).apply();
    }

    public static void p(boolean z16) {
        f292786b = z16;
    }

    private static void q() {
        c("1000", ThemeReporter.FROM_AUTH);
    }

    protected static void r(Activity activity, String str, e eVar) {
        if (activity != null && !activity.isFinishing()) {
            QQCustomDialog createCenterTextDialog = DialogUtil.createCenterTextDialog(activity, 0, null, activity.getString(R.string.vr6), activity.getString(R.string.cancel), activity.getString(R.string.a8j), new c(eVar), new d(eVar));
            createCenterTextDialog.show();
            createCenterTextDialog.setCancelable(false);
            n("0X800A5C9");
            return;
        }
        QLog.e("DarkModeManager", 2, "showThemeDarkModeTips error!: ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(boolean z16, boolean z17, IThemeSwitchCallback iThemeSwitchCallback) {
        if (z16 && !z17) {
            t();
        } else if (!z16 && z17) {
            e(iThemeSwitchCallback);
        }
    }

    private static void t() {
        String str;
        if (SimpleUIUtil.getSimpleUISwitch()) {
            str = "2920";
        } else {
            str = "1103";
        }
        QLog.d("DarkModeManager", 1, "switchToNightMode themeID=" + str);
        ThemeSwitcher.startSwitch(str, ThemeReporter.FROM_NIGHT, null);
    }

    public static void u(IThemeSwitchCallback iThemeSwitchCallback) {
        boolean z16;
        if (m()) {
            if ((BaseApplicationImpl.getApplication().getApplicationContext().getResources().getConfiguration().uiMode & 48) == 32) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, null);
            if (QLog.isColorLevel()) {
                QLog.d("DarkModeManager", 2, "updateDarkModeStatus isNightMode  = " + isNowThemeIsNight + ", isDarkMode = " + z16);
            }
            s(z16, isNowThemeIsNight, iThemeSwitchCallback);
            return;
        }
        if (f292786b && !com.tencent.mobileqq.automator.a.f199911b) {
            q();
        }
    }

    public static void v(boolean z16) {
        ao.a(g(), "0X800B86E", z16);
        f292785a = z16;
        SharedPreferences h16 = h();
        if (h16 == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DarkModeManager", 2, "updateModeStatus isOpened  = " + f292785a);
        }
        h16.edit().putBoolean("dark_switch_key", f292785a).apply();
    }

    public static boolean w(Activity activity, String str, e eVar) {
        boolean z16;
        if (activity == null || activity.isFinishing() || !m()) {
            return false;
        }
        if ((activity.getResources().getConfiguration().uiMode & 48) == 32) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, str);
        if (TextUtils.isEmpty(str)) {
            isNowThemeIsNight = !ThemeUtil.isNowThemeIsNight(null, false, null);
        }
        if (z16 == isNowThemeIsNight) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DarkModeManager", 2, "userSetThemeAction isNightMode  = " + isNowThemeIsNight + ", isDarkMode = " + z16);
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            r(activity, str, eVar);
        } else {
            ThreadManager.getUIHandler().post(new Runnable(activity, str, eVar) { // from class: com.tencent.mobileqq.theme.DarkModeManager.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f292791d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f292792e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ e f292793f;

                {
                    this.f292791d = activity;
                    this.f292792e = str;
                    this.f292793f = eVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, activity, str, eVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        DarkModeManager.r(this.f292791d, this.f292792e, this.f292793f);
                    }
                }
            });
        }
        return true;
    }
}
