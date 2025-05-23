package com.tencent.mobileqq.studymode;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.pad.f;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.minorsmode.MinorsModeKnowType;
import com.tencent.mobileqq.minorsmode.api.IMinorsModeApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.urlfilter.api.IStudyModeUrlFilter;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StudyModeManager {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f290948b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f290949c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f290950d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f290951e;

    /* renamed from: f, reason: collision with root package name */
    private static int f290952f;

    /* renamed from: g, reason: collision with root package name */
    private static int f290953g;

    /* renamed from: h, reason: collision with root package name */
    private static int f290954h;

    /* renamed from: i, reason: collision with root package name */
    private static String f290955i;

    /* renamed from: j, reason: collision with root package name */
    private static String f290956j;

    /* renamed from: k, reason: collision with root package name */
    private static String f290957k;

    /* renamed from: l, reason: collision with root package name */
    private static int f290958l;

    /* renamed from: m, reason: collision with root package name */
    private static AtomicBoolean f290959m;

    /* renamed from: n, reason: collision with root package name */
    private static CopyOnWriteArrayList<StudyModeChangeListener> f290960n;

    /* renamed from: o, reason: collision with root package name */
    private static ArrayList<Integer> f290961o;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f290962p;

    /* renamed from: q, reason: collision with root package name */
    private static w f290963q;

    /* renamed from: r, reason: collision with root package name */
    private static aa f290964r;

    /* renamed from: s, reason: collision with root package name */
    private static c f290965s;

    /* renamed from: a, reason: collision with root package name */
    private final f.e f290966a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements f.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StudyModeManager.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f290971a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f290972b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f290973c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f290974d;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f290971a = false;
            this.f290972b = false;
            this.f290973c = false;
            this.f290974d = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class c implements IGuardInterface {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                StudyModeManager.X("onApplicationForeground");
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75730);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f290948b = true;
        f290952f = -1;
        f290953g = -1;
        f290954h = 0;
        f290955i = "";
        f290958l = 0;
        f290959m = new AtomicBoolean();
        f290960n = new CopyOnWriteArrayList<>();
        f290961o = new ArrayList<>();
        f290962p = false;
        f290963q = new w();
        f290964r = new aa();
        f290965s = null;
    }

    public StudyModeManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f290966a = new a();
        }
    }

    public static boolean A() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String c16 = f290963q.c(AppConstants.Preferences.KID_MODE_ADVANCE_SETTING, "");
        if (QLog.isDevelopLevel()) {
            QLog.d("StudyModeManager", 4, "calendar in sp : ", c16);
        }
        if (!TextUtils.isEmpty(c16)) {
            try {
                Date parse = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINESE).parse(c16);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(parse);
                if (calendar2.get(0) == calendar.get(0) && calendar2.get(1) == calendar.get(1)) {
                    if (calendar2.get(6) == calendar.get(6)) {
                        return false;
                    }
                }
            } catch (ParseException e16) {
                QLog.e("StudyModeManager", 1, "simpleDateFormat parse error : ", e16.toString());
            }
        }
        return true;
    }

    public static void B() {
        C(t());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((IRedTouchServer) peekAppRuntime.getRuntimeService(IRedTouchServer.class, "")).sendRedpointReq(true, false, 7);
        }
    }

    public static synchronized void C(boolean z16) {
        synchronized (StudyModeManager.class) {
            if (Z()) {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    Iterator<StudyModeChangeListener> it = f290960n.iterator();
                    while (it.hasNext()) {
                        it.next().onChange(z16);
                    }
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable(z16) { // from class: com.tencent.mobileqq.studymode.StudyModeManager.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f290969d;

                        {
                            this.f290969d = z16;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, z16);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            Iterator it5 = StudyModeManager.f290960n.iterator();
                            while (it5.hasNext()) {
                                ((StudyModeChangeListener) it5.next()).onChange(this.f290969d);
                            }
                        }
                    });
                }
            } else {
                Iterator<StudyModeChangeListener> it5 = f290960n.iterator();
                while (it5.hasNext()) {
                    it5.next().onChange(z16);
                }
            }
        }
    }

    public static void D() {
        if (!com.tencent.common.config.pad.f.m()) {
            return;
        }
        com.tencent.common.config.pad.f.g().q();
        X("onAccountChange");
    }

    public static void E(StudyModeChangeListener studyModeChangeListener) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            if (!f290960n.contains(studyModeChangeListener)) {
                f290960n.add(studyModeChangeListener);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("StudyModeManager", 2, String.format("register studyModel subThread", new Object[0]));
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.studymode.StudyModeManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) StudyModeChangeListener.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (!StudyModeManager.f290960n.contains(StudyModeChangeListener.this)) {
                        StudyModeManager.f290960n.add(StudyModeChangeListener.this);
                    }
                }
            });
        }
    }

    public static void F(StudyModeChangeListener studyModeChangeListener) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            if (f290960n.contains(studyModeChangeListener)) {
                f290960n.remove(studyModeChangeListener);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("StudyModeManager", 2, String.format("unregister studyModel subThread", new Object[0]));
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.studymode.StudyModeManager.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) StudyModeChangeListener.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (StudyModeManager.f290960n.contains(StudyModeChangeListener.this)) {
                        StudyModeManager.f290960n.remove(StudyModeChangeListener.this);
                    }
                }
            });
        }
    }

    public static void G(Context context, Intent intent) {
        ((IStudyModeUrlFilter) QRoute.api(IStudyModeUrlFilter.class)).openUrlFilterMainFragment(context, intent);
    }

    public static synchronized void H(StudyModeChangeListener studyModeChangeListener) {
        synchronized (StudyModeManager.class) {
            if (!f290960n.contains(studyModeChangeListener)) {
                f290960n.add(studyModeChangeListener);
            }
        }
    }

    public static void I() {
        ((IStudyModeUrlFilter) QRoute.api(IStudyModeUrlFilter.class)).registerStudyModeSetting();
    }

    public static void J() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINESE);
        if (QLog.isDevelopLevel()) {
            QLog.d("StudyModeManager", 4, "needReportAdvanceSettingStatus : ", Boolean.valueOf(A()));
        }
        if (A()) {
            boolean f16 = f(16);
            f290964r.c(AppConstants.Preferences.KID_MODE_ADVANCE_SETTING, simpleDateFormat.format(new Date()));
            ReportController.o(null, "dc00898", "", "", "0X800B3D5", "0X800B3D5", 0, f16 ? 1 : 0, "", "", "", "");
            ReportController.o(null, "dc00898", "", "", "0X800B3D6", "0X800B3D6", 0, f(32) ? 1 : 0, "", "", "", "");
            ReportController.o(null, "dc00898", "", "", "0X800B3D7", "0X800B3D7", 0, f(8) ? 1 : 0, "", "", "", "");
        }
    }

    public static synchronized void K(int i3, String str, String str2) {
        synchronized (StudyModeManager.class) {
            if (QLog.isColorLevel()) {
                QLog.d("StudyModeManager", 1, "setIsBindPhone: ", Integer.valueOf(i3));
            }
            if (!f290959m.get()) {
                u();
            }
            f290953g = i3;
            f290956j = str;
            f290957k = str2;
        }
    }

    public static synchronized void L(int i3) {
        synchronized (StudyModeManager.class) {
            if (QLog.isColorLevel()) {
                QLog.d("StudyModeManager", 1, "setKidModeNeedVerify switch: ", Integer.valueOf(i3));
            }
            if (!f290959m.get()) {
                return;
            }
            if (f290952f != i3) {
                f290964r.b("kid_mode_key_need_verify_phone", i3);
                f290952f = i3;
            }
        }
    }

    public static synchronized void M(int i3) {
        synchronized (StudyModeManager.class) {
            if (!f290959m.get()) {
                return;
            }
            QLog.i("StudyModeManager", 1, "setKidModePasswordState, state=" + i3);
            f290954h = i3;
            f290964r.b("kid_mode_key_password_state", i3);
        }
    }

    public static synchronized void N(int i3, String str) {
        synchronized (StudyModeManager.class) {
            if (!f290959m.get()) {
                return;
            }
            QLog.i("StudyModeManager", 1, "setKidModePasswordState, state=" + i3);
            f290954h = i3;
            f290964r.b("kid_mode_key_password_state", i3);
            f290955i = str;
            f290964r.c("kid_mode_key_password_salt", str);
        }
    }

    public static synchronized void O(int i3) {
        synchronized (StudyModeManager.class) {
            if (QLog.isColorLevel()) {
                QLog.d("StudyModeManager", 2, "set SP_KEY_LAST_DIFF_STUDY_MODE: " + i3);
            }
            if (!f290959m.get()) {
                u();
            }
            f290958l = i3;
            f290964r.b("last_diff_study_mode", i3);
        }
    }

    public static void P(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("StudyModeManager", 2, String.format("setstudent mask = %b", Boolean.valueOf(z16)));
        }
        f290964r.a("study_mode_key_student_mask", z16);
    }

    public static void Q(boolean z16) {
        com.tencent.common.config.pad.f.t(Boolean.valueOf(z16));
        QLog.e("StudyModeManager", 1, "setUserCheckStudyModeAfterPSWCheck  userSetMinosDeviceSwitch " + z16);
        B();
    }

    public static synchronized void R(boolean z16, QQAppInterface qQAppInterface) {
        synchronized (StudyModeManager.class) {
            if (QLog.isColorLevel()) {
                QLog.d("StudyModeManager", 2, String.format("setUserSwitch switch = %b", Boolean.valueOf(z16)));
            }
            if (!f290959m.get()) {
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("init_on_set_user_switch", true)) {
                    u();
                } else {
                    return;
                }
            }
            if (f290949c != z16) {
                f290964r.a("study_mode_key_user_switch", z16);
                f290949c = z16;
                if (f290948b) {
                    C(z16);
                }
                if (qQAppInterface != null) {
                    ((IRedTouchServer) qQAppInterface.getRuntimeService(IRedTouchServer.class, "")).sendRedpointReq(true, false, 7);
                }
            }
        }
    }

    public static Boolean S() {
        boolean z16 = false;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105926", false) || com.tencent.common.config.pad.f.o()) {
            z16 = true;
        }
        return Boolean.valueOf(z16);
    }

    public static boolean T() {
        if (!f(80) && !com.tencent.common.config.pad.f.o()) {
            return false;
        }
        return true;
    }

    public static synchronized void U(StudyModeChangeListener studyModeChangeListener) {
        synchronized (StudyModeManager.class) {
            if (f290960n.contains(studyModeChangeListener)) {
                f290960n.remove(studyModeChangeListener);
            }
        }
    }

    public static void V(int i3) {
        f290964r.b("kid_mode_advanced_setting_child_birthday", i3);
    }

    public static void W(int i3, boolean z16) {
        String str;
        if (i3 != 8) {
            if (i3 != 16) {
                if (i3 != 32) {
                    if (i3 != 80) {
                        if (i3 != 96) {
                            if (i3 != 128) {
                                str = null;
                            } else {
                                str = "search_net";
                            }
                        } else {
                            str = "open_url_filter_default";
                        }
                    } else {
                        str = "open_url_filter";
                    }
                } else {
                    str = "invite_to_troop_by_stranger_flag";
                }
            } else {
                str = "search_by_stranger_flag";
            }
        } else {
            str = "search_friend_flag";
        }
        if (!TextUtils.isEmpty(str)) {
            f290964r.a(str, !z16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("StudyModeManager", 2, "updateAdvanceSettingSwitch, mask: " + i3 + ", isSupport: " + z16);
        }
    }

    public static void X(String str) {
        final MinorsModeKnowType m3;
        if (!com.tencent.common.config.pad.f.m()) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            v();
            int d16 = com.tencent.common.config.pad.f.d();
            QLog.i("StudyModeManager", 1, "updateStudyModeSynSys from: " + str + ", changeTypeOnBackGround: " + d16);
            if (d16 != 1) {
                if (d16 != 2) {
                    m3 = m(false, false);
                } else {
                    m3 = m(true, false);
                }
            } else {
                m3 = m(false, true);
            }
            QLog.i("StudyModeManager", 1, "updateStudyModeSynSys type: " + m3);
            if (m3 != MinorsModeKnowType.INVALID) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.studymode.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        StudyModeManager.y(MinorsModeKnowType.this);
                    }
                });
                return;
            }
            return;
        }
        QLog.i("StudyModeManager", 1, "updateStudyModeSynSys app is null or not login, return");
    }

    public static boolean Y(String str) {
        return ((IStudyModeUrlFilter) QRoute.api(IStudyModeUrlFilter.class)).urlFilterCheckedSupportOpen(str);
    }

    public static boolean Z() {
        return true;
    }

    private static QQAppInterface c() {
        return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    public static boolean d(QQAppInterface qQAppInterface, boolean z16, boolean z17) {
        if (!z16 || !z17) {
            return false;
        }
        ((SimpleUIHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).i3(false, 0, false, true);
        QLog.e("StudyModeManager", 1, "[KidMode]checkAbnormalFlag both true");
        return true;
    }

    public static int e() {
        return f290963q.b("kid_mode_advanced_setting_child_birthday", 0);
    }

    public static boolean f(int i3) {
        String str;
        if (i3 != 8) {
            if (i3 != 16) {
                if (i3 != 32) {
                    if (i3 != 80) {
                        if (i3 != 96) {
                            if (i3 != 128) {
                                str = null;
                            } else {
                                str = "search_net";
                            }
                        } else {
                            str = "open_url_filter_default";
                        }
                    } else {
                        str = "open_url_filter";
                    }
                } else {
                    str = "invite_to_troop_by_stranger_flag";
                }
            } else {
                str = "search_by_stranger_flag";
            }
        } else {
            str = "search_friend_flag";
        }
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i3 == 128) {
            z16 = true;
        }
        boolean a16 = f290963q.a(str, z16);
        if (QLog.isColorLevel()) {
            QLog.d("StudyModeManager", 2, "getAdvanceSettingSwitch, mask: " + i3 + ", isChecked: " + a16);
        }
        return a16;
    }

    public static int g() {
        return f290953g;
    }

    public static boolean h(AppRuntime appRuntime) {
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("android_children_mode_switch", false);
        QLog.i("StudyModeManager", 1, "is study mode entrance move to settings: " + isFeatureSwitchEnable);
        return isFeatureSwitchEnable;
    }

    public static boolean i() {
        return f290948b;
    }

    public static synchronized int j() {
        int i3;
        synchronized (StudyModeManager.class) {
            if (!f290959m.get()) {
                u();
            }
            i3 = f290952f;
        }
        return i3;
    }

    public static synchronized String k() {
        String str;
        synchronized (StudyModeManager.class) {
            if (!f290959m.get()) {
                u();
            }
            str = f290955i;
        }
        return str;
    }

    public static synchronized int l() {
        int i3;
        synchronized (StudyModeManager.class) {
            if (!f290959m.get()) {
                u();
            }
            i3 = f290954h;
        }
        return i3;
    }

    public static MinorsModeKnowType m(boolean z16, boolean z17) {
        QQAppInterface c16 = c();
        if (c16 != null) {
            MinorsModeKnowType q16 = q(c16, z16);
            MinorsModeKnowType p16 = p(c16, z17);
            MinorsModeKnowType minorsModeKnowType = MinorsModeKnowType.INVALID;
            if (q16 != minorsModeKnowType) {
                return q16;
            }
            if (p16 != minorsModeKnowType) {
                return p16;
            }
        }
        return MinorsModeKnowType.INVALID;
    }

    public static synchronized int n() {
        int i3;
        synchronized (StudyModeManager.class) {
            if (!f290959m.get()) {
                u();
            }
            i3 = f290958l;
        }
        return i3;
    }

    public static String o() {
        return f290957k;
    }

    private static MinorsModeKnowType p(QQAppInterface qQAppInterface, boolean z16) {
        MinorsModeKnowType minorsModeKnowType = MinorsModeKnowType.INVALID;
        int e16 = com.tencent.common.config.pad.f.e();
        int i3 = com.tencent.common.config.pad.f.i(qQAppInterface.getApplicationContext());
        if ((e16 != i3 || z16) && com.tencent.common.config.pad.f.o()) {
            minorsModeKnowType = MinorsModeKnowType.ONLY_CHANGE_AGE;
        }
        com.tencent.common.config.pad.f.r(i3);
        return minorsModeKnowType;
    }

    @Nullable
    private static MinorsModeKnowType q(QQAppInterface qQAppInterface, boolean z16) {
        MinorsModeKnowType minorsModeKnowType = MinorsModeKnowType.INVALID;
        boolean w3 = com.tencent.common.config.pad.f.w(qQAppInterface.getApplicationContext());
        boolean k3 = com.tencent.common.config.pad.f.k(qQAppInterface.getApplicationContext());
        boolean t16 = t();
        boolean f16 = com.tencent.common.config.pad.f.f();
        QLog.e("StudyModeManager", 1, "updateStudyModeSynSys supportMinorsMode " + w3 + " minorsModeState " + k3 + " qqStudy " + t16);
        if (k3 == f16 && !z16) {
            return minorsModeKnowType;
        }
        if (k3) {
            if (!SimpleUIUtil.isNowElderMode() && !ElderModeManager.j()) {
                minorsModeKnowType = MinorsModeKnowType.OPEN_BY_SYSTEM;
            } else {
                minorsModeKnowType = MinorsModeKnowType.OPEN_BY_SYSTEM_FROM_ELDER;
            }
        }
        boolean l3 = com.tencent.common.config.pad.f.l();
        com.tencent.common.config.pad.f.t(Boolean.TRUE);
        com.tencent.common.config.pad.f.s(Boolean.valueOf(k3));
        if (!k3 && l3) {
            if (!SimpleUIUtil.isNowElderMode() && !ElderModeManager.j()) {
                if (t()) {
                    return MinorsModeKnowType.CHECK_CLOSE_BY_SYSTEM;
                }
                return MinorsModeKnowType.CLOSE_BY_SYSTEM;
            }
            return MinorsModeKnowType.CLOSE_BY_SYSTEM_TO_ELDER;
        }
        return minorsModeKnowType;
    }

    public static String r() {
        return f290956j;
    }

    public static boolean s() {
        boolean a16 = StudyModeSwitchDialogConfigProcessor.INSTANCE.a();
        f290951e = a16;
        return a16;
    }

    public static boolean t() {
        if (com.tencent.common.config.pad.f.o()) {
            return true;
        }
        AppRuntime peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        if (peekAppRuntime == null || peekAppRuntime.getCurrentAccountUin() == null) {
            return false;
        }
        if (!f290959m.get()) {
            u();
        }
        if (!f290948b) {
            return false;
        }
        if (MobileQQ.PACKAGE_NAME.equals(MobileQQ.processName)) {
            return f290949c;
        }
        return f290963q.a("study_mode_key_user_switch", false);
    }

    public static synchronized void u() {
        synchronized (StudyModeManager.class) {
            f290948b = true;
            ArrayList<Integer> arrayList = StudyModePushConfigProcessor.d().f290976e;
            if (arrayList != null && arrayList.size() > 0) {
                f290961o.clear();
                f290961o.addAll(arrayList);
            }
            f290949c = f290963q.a("study_mode_key_user_switch", false);
            f290950d = f290963q.a("study_mode_key_student_mask", false);
            f290952f = f290963q.b("kid_mode_key_need_verify_phone", -1);
            f290954h = f290963q.b("kid_mode_key_password_state", 0);
            f290955i = f290963q.c("kid_mode_key_password_salt", "");
            f290958l = f290963q.b("last_diff_study_mode", 0);
            f290951e = StudyModeSwitchDialogConfigProcessor.INSTANCE.a();
            f290959m.set(true);
            if (QLog.isColorLevel()) {
                QLog.d("StudyModeManager", 2, String.format("init ,sStudyModeConfigSwitch = %b,sStudyModeSwitch = %b,sStudentMask = %b,sBlackIds = %s,configHas = %b,sShowStudyModeSwitchDialog = %b", Boolean.valueOf(f290948b), Boolean.valueOf(f290949c), Boolean.valueOf(f290950d), "sBlackIds.toString()", Boolean.TRUE, Boolean.valueOf(f290951e)));
            }
            ((IStudyModeUrlFilter) QRoute.api(IStudyModeUrlFilter.class)).registerThreadMessage();
        }
    }

    public static void v() {
        if (GuardManager.sInstance == null) {
            QLog.e("StudyModeManager", 1, "initGuardManager sInstance us null, return.");
        } else if (f290965s == null) {
            QLog.i("StudyModeManager", 1, "initGuardManager");
            f290965s = new c();
            GuardManager.sInstance.registerCallBack(f290965s);
        }
    }

    public static boolean w() {
        if (!t()) {
            if (QLog.isColorLevel()) {
                QLog.d("StudyModeManager", 2, "isBanSearchNet: it isn't in kid mode");
                return false;
            }
            return false;
        }
        boolean f16 = f(128);
        if (QLog.isColorLevel()) {
            QLog.d("StudyModeManager", 2, "isBanSearchNet: " + f16);
        }
        return f16;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean x(int i3) {
        boolean contains;
        if (!f290959m.get()) {
            return false;
        }
        if (t()) {
            try {
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("StudyModeManager", 2, th5, new Object[0]);
                }
            }
            if (f290961o.size() > 0) {
                contains = f290961o.contains(Integer.valueOf(i3));
                if (QLog.isColorLevel()) {
                    QLog.d("StudyModeManager", 2, String.format("init ,studyModeSwitch = %b,notifyID = %d,blackResult = %b,sBlackIds = %s", Boolean.valueOf(f290948b), Integer.valueOf(i3), Boolean.valueOf(contains), f290961o.toString()));
                }
                return contains;
            }
        }
        contains = false;
        if (QLog.isColorLevel()) {
        }
        return contains;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(MinorsModeKnowType minorsModeKnowType) {
        ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startMinorsModeKnowFragment(BaseApplication.getContext(), minorsModeKnowType, null);
    }

    public static boolean z(int i3, int i16) {
        if (i3 != 2 && (i16 == 2 || i16 == 4 || i3 != 3)) {
            return false;
        }
        return true;
    }
}
