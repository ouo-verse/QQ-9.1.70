package com.tencent.mobileqq.eldermode;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.simpleui.f;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.p;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ElderModeManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f204061a;

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f204062b;

    /* renamed from: c, reason: collision with root package name */
    private static final f f204063c;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f204064d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f204065e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.eldermode.ElderModeManager$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class DialogInterfaceOnClickListenerC7494a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f204066d;

            DialogInterfaceOnClickListenerC7494a(boolean z16) {
                this.f204066d = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, Boolean.valueOf(z16));
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    a.this.f204065e = true;
                    QLog.d("ElderModeManager", 1, "showConfirmDialog ok");
                    a.this.i(this.f204066d);
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes6.dex */
        public class b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f204068d;

            b(boolean z16) {
                this.f204068d = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, Boolean.valueOf(z16));
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                QLog.d("ElderModeManager", 1, "showConfirmDialog cancel");
                a.this.i(this.f204068d);
                ElderModeManager.n((AppInterface) BaseApplicationImpl.getApplication().getRuntime());
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f204064d = false;
                this.f204065e = false;
            }
        }

        private void h(boolean z16, boolean z17) {
            int i3;
            if (com.tencent.common.config.pad.f.o()) {
                return;
            }
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            String qqStr = HardCodeUtil.qqStr(R.string.bbh);
            if (z16) {
                i3 = R.string.f230076y6;
            } else {
                i3 = R.string.f230066y5;
            }
            DialogUtil.createCustomDialog(baseActivity, 230, qqStr, HardCodeUtil.qqStr(i3), new DialogInterfaceOnClickListenerC7494a(z16), new b(z17)).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(boolean z16) {
            int i3;
            ElderModeManager.q(z16);
            AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
            if (appInterface == null) {
                QLog.e("ElderModeManager", 1, "syncModeByServer appRuntime == null");
                return;
            }
            l lVar = (l) appInterface.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
            if (z16) {
                i3 = 3;
            } else {
                i3 = 0;
            }
            lVar.i(BaseActivity.sTopActivity, i3, 0, true);
        }

        @Override // com.tencent.mobileqq.simpleui.f
        protected void c(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (!this.f204064d) {
                return;
            }
            Object[] objArr = (Object[]) obj;
            if (objArr.length != 5) {
                return;
            }
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
            boolean booleanValue3 = ((Boolean) objArr[4]).booleanValue();
            boolean j3 = ElderModeManager.j();
            QLog.d("ElderModeManager", 1, "onUpdate sSimpleOpen:", Boolean.valueOf(booleanValue), ", sStudySwitch:", Boolean.valueOf(booleanValue2), ", bElderSwitch:", Boolean.valueOf(booleanValue3), ", oldSwitch:", Boolean.valueOf(j3));
            if (!booleanValue && !booleanValue2) {
                if (j3 == booleanValue3) {
                    ElderModeManager.q(booleanValue3);
                    ElderModeManager.n((AppInterface) BaseApplicationImpl.getApplication().getRuntime());
                    return;
                } else if (ElderModeManager.k()) {
                    h(booleanValue3, j3);
                    return;
                } else {
                    i(booleanValue3);
                    return;
                }
            }
            ElderModeManager.q(false);
            ElderModeManager.n((AppInterface) BaseApplicationImpl.getApplication().getRuntime());
        }

        @Override // com.tencent.mobileqq.simpleui.f
        protected void e(boolean z16, boolean z17, boolean z18, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3));
                return;
            }
            if (!this.f204064d) {
                return;
            }
            ElderModeManager.n((AppInterface) BaseApplicationImpl.getApplication().getRuntime());
            l lVar = (l) ((AppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
            if (lVar == null) {
                QLog.d("ElderModeManager", 1, "onSwitchSimpleUICallback manager == null");
                return;
            }
            int m3 = lVar.m();
            QLog.d("ElderModeManager", 1, "onSwitchSimpleUICallback isSuc:", Boolean.valueOf(z16), ", bChangeTheme:", Boolean.valueOf(z17), ", bSwitchElsePref:", Boolean.valueOf(z18), ", statusCode:", Integer.valueOf(i3), ", targetType=", Integer.valueOf(m3));
            if ((m3 == 3 || m3 == 0) && z16 && 5 == i3 && this.f204065e) {
                if (m3 != 3) {
                    i16 = 3;
                }
                ElderModeManager.m(true, m3, i16, BaseActivity.sTopActivity);
            }
        }

        @Override // com.tencent.mobileqq.simpleui.f, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 3;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                return;
            }
            boolean b16 = ElderModeManager.b();
            this.f204064d = b16;
            if (b16) {
                super.onUpdate(i3, z16, obj);
                return;
            }
            if (i3 != 1) {
                return;
            }
            Object[] objArr = (Object[]) obj;
            if (objArr.length != 5) {
                return;
            }
            ElderModeManager.n((AppInterface) BaseApplicationImpl.getApplication().getRuntime());
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
            boolean booleanValue3 = ((Boolean) objArr[4]).booleanValue();
            boolean j3 = ElderModeManager.j();
            QLog.d("ElderModeManager", 1, "onUpdate sSimpleOpen:", Boolean.valueOf(booleanValue), ", sStudySwitch:", Boolean.valueOf(booleanValue2), ", bElderSwitch:", Boolean.valueOf(booleanValue3), ", oldSwitch:", Boolean.valueOf(j3));
            if (!booleanValue && !booleanValue2) {
                ElderModeManager.q(booleanValue3);
                if (j3 != booleanValue3) {
                    AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
                    if (appInterface == null) {
                        QLog.e("ElderModeManager", 1, "onUpdate appRuntime == null");
                        return;
                    }
                    l lVar = (l) appInterface.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
                    if (booleanValue3) {
                        i16 = 0;
                    }
                    lVar.i(BaseActivity.sTopActivity, i16, 0, true);
                    return;
                }
                return;
            }
            ElderModeManager.q(false);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71623);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f204062b = new AtomicBoolean();
            f204063c = new a();
        }
    }

    public static void a(AppInterface appInterface) {
        appInterface.addObserver(f204063c);
    }

    public static boolean b() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d("ElderModeManager", 1, "enableElderRoman=false, appRuntime==null");
            return false;
        }
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("elder_moder_roman_switch");
        QLog.d("ElderModeManager", 1, "enableElderRoman=" + isFeatureSwitchEnable);
        return isFeatureSwitchEnable;
    }

    public static float c() {
        float scale = GlobalDisplayMetricsManager.getScale();
        float f16 = 18.0f / scale;
        QLog.i("ElderModeManager", 1, "getElderModeSize size=18.0,scale=" + scale + ",newSize=" + f16);
        if (f16 <= 18.0f || f16 >= 27.0f) {
            return 18.0f;
        }
        return f16;
    }

    public static float d() {
        QLog.d("ElderModeManager", 1, "getLastFontSize");
        if (!i()) {
            return 16.0f;
        }
        return g().getFloat("elder_mode_key_last_font_size", 16.0f);
    }

    public static int e(String str) {
        if (QQTheme.isThemeSimpleUI(str)) {
            return 1;
        }
        return 0;
    }

    public static String f(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return "";
        }
        String str = (String) p.b(BaseApplication.getContext(), appRuntime.getCurrentAccountUin(), "elder_last_themeId", "");
        if (QLog.isColorLevel()) {
            QLog.i("ElderModeManager", 2, "getLastThemeId id is " + str);
        }
        return str;
    }

    private static SharedPreferences g() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            QLog.e("ElderModeManager", 1, "getSp appRuntime == null");
            runtime = MobileQQ.sMobileQQ.peekAppRuntime();
        }
        return QQTheme.getUinThemePreferences(runtime.getAccount());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x000b, code lost:
    
        if (com.tencent.mobileqq.eldermode.ElderModeManager.f204062b.get() == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void h(boolean z16) {
        synchronized (ElderModeManager.class) {
            if (!z16) {
            }
            if (i()) {
                int i3 = 0;
                boolean z17 = g().getBoolean(ThemeConstants.KEY_ELDER_UI_SWITCH, false);
                f204061a = z17;
                if (z17) {
                    i3 = 1;
                }
                SimpleUIUtil.setElderUISwitchInt(i3);
                f204062b.set(true);
                QLog.d("ElderModeManager", 1, "init sElderModeSwitch=" + f204061a);
            }
        }
    }

    private static boolean i() {
        boolean z16;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && !TextUtils.isEmpty(runtime.getCurrentAccountUin())) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("ElderModeManager", 1, "isAppRuntimeValid : " + z16);
        return z16;
    }

    public static boolean j() {
        h(false);
        if (com.tencent.common.config.pad.f.o()) {
            return false;
        }
        return f204061a;
    }

    public static boolean k() {
        if (j()) {
            if (d() != c()) {
                return true;
            }
            return false;
        }
        if (FontSettingManager.getFontLevel() != c()) {
            return true;
        }
        return false;
    }

    public static boolean l() {
        if (j()) {
            if (FontSettingManager.getFontLevel() != c()) {
                return true;
            }
            return false;
        }
        if (d() != c()) {
            return true;
        }
        return false;
    }

    public static Boolean m(boolean z16, int i3, int i16, Activity activity) {
        float d16;
        QLog.d("ElderModeManager", 1, "onModeChangeComplete isSuccess=" + z16 + ", targetType=" + i3 + ", oldType=" + i16);
        if (!z16) {
            return Boolean.FALSE;
        }
        boolean z17 = false;
        if (i16 == 3 && i3 != 3) {
            if (d() != c()) {
                z17 = true;
            }
            if (z17) {
                float d17 = d();
                o(FontSettingManager.getFontLevel());
                FontSettingManager.setCustomDensity(activity, d17, true);
            }
        } else if (i16 != 3 && i3 == 3 && (z17 = l())) {
            if (j()) {
                d16 = c();
            } else {
                d16 = d();
            }
            o(FontSettingManager.getFontLevel());
            FontSettingManager.setCustomDensity(activity, d16, true);
        }
        QLog.d("ElderModeManager", 1, "needUpdateFont? " + z17);
        if (z17) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.eldermode.ElderModeManager.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QLog.d("ElderModeManager", 1, "onModeChangeComplete killProcess");
                        FontSettingManager.killProcess();
                    }
                }
            }, 1000L);
        }
        return Boolean.valueOf(z17);
    }

    public static void n(AppInterface appInterface) {
        appInterface.removeObserver(f204063c);
    }

    public static void o(float f16) {
        QLog.d("ElderModeManager", 1, "saveLastFontSize fontLevel=" + f16);
        if (i()) {
            g().edit().putFloat("elder_mode_key_last_font_size", f16).commit();
        }
    }

    public static void p(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return;
        }
        p.g(BaseApplication.getContext(), appRuntime.getCurrentAccountUin(), true, "elder_last_themeId", QQTheme.getCurrentThemeId());
    }

    public static synchronized void q(boolean z16) {
        synchronized (ElderModeManager.class) {
            int i3 = 1;
            QLog.d("ElderModeManager", 1, "setUserSwitch sElderModeSwitch=" + f204061a + ", isOpen=" + z16);
            h(false);
            if (f204061a != z16 && i()) {
                g().edit().putBoolean(ThemeConstants.KEY_ELDER_UI_SWITCH, z16).commit();
                f204061a = z16;
                if (!z16) {
                    i3 = 0;
                }
                SimpleUIUtil.setElderUISwitchInt(i3);
            }
        }
    }
}
