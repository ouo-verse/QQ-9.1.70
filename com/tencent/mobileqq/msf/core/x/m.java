package com.tencent.mobileqq.msf.core.x;

import android.content.SharedPreferences;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes15.dex */
public class m {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f250332a = "MSFSwitchUtils";

    /* renamed from: b, reason: collision with root package name */
    public static final String f250333b = "msf_switch_config";

    /* renamed from: c, reason: collision with root package name */
    public static final String f250334c = "default_use_new_dispatch_method";

    /* renamed from: d, reason: collision with root package name */
    private static final String f250335d = "100470";

    /* renamed from: e, reason: collision with root package name */
    private static final String f250336e = "msf_nt_login_merge_switch";

    /* renamed from: f, reason: collision with root package name */
    private static final String f250337f = "101651";

    /* renamed from: g, reason: collision with root package name */
    private static final String f250338g = "101857";

    /* renamed from: h, reason: collision with root package name */
    private static final String f250339h = "101868";

    /* renamed from: i, reason: collision with root package name */
    private static final String f250340i = "msf_network_service_switch_new";

    /* renamed from: j, reason: collision with root package name */
    private static final String f250341j = "msf_conn_open_renotify";

    /* renamed from: k, reason: collision with root package name */
    private static final String f250342k = "102942";

    /* renamed from: l, reason: collision with root package name */
    private static final String f250343l = "msf_quality_test_support_quic";

    /* renamed from: m, reason: collision with root package name */
    private static final String f250344m = "msf_wait_send_queue_bugfix_switch";

    /* renamed from: n, reason: collision with root package name */
    private static final String f250345n = "msf_init_optimize";

    /* renamed from: o, reason: collision with root package name */
    public static final String f250346o = "msf_use_new_dispatch_method_switch";

    /* renamed from: p, reason: collision with root package name */
    private static final Boolean f250347p;

    /* renamed from: q, reason: collision with root package name */
    private static final Boolean f250348q;

    /* renamed from: r, reason: collision with root package name */
    private static final Boolean f250349r;

    /* renamed from: s, reason: collision with root package name */
    private static final Boolean f250350s;

    /* renamed from: t, reason: collision with root package name */
    private static final Boolean f250351t;

    /* renamed from: u, reason: collision with root package name */
    private static final Boolean f250352u;

    /* renamed from: v, reason: collision with root package name */
    private static final Boolean f250353v;

    /* renamed from: w, reason: collision with root package name */
    private static final Boolean f250354w;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24038);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        Boolean bool = Boolean.TRUE;
        f250347p = bool;
        Boolean bool2 = Boolean.FALSE;
        f250348q = bool2;
        f250349r = bool2;
        f250350s = bool;
        f250351t = bool2;
        f250352u = bool;
        f250353v = bool2;
        f250354w = bool;
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a() {
        boolean isSwitchOn = BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(f250335d, f250347p.booleanValue());
        QLog.d(f250332a, 1, "isExceptionBroadCastEnable = " + isSwitchOn);
        return isSwitchOn;
    }

    public static boolean b() {
        boolean isSwitchOn = BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(f250339h, f250351t.booleanValue());
        QLog.d(f250332a, 1, "isGetStackStringEnable = " + isSwitchOn);
        return isSwitchOn;
    }

    public static boolean c() {
        boolean isSwitchOn = BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(f250341j, f250352u.booleanValue());
        QLog.d(f250332a, 1, "isMSFConnOpenRenotifyEnable = " + isSwitchOn);
        return isSwitchOn;
    }

    public static boolean d() {
        boolean isSwitchOn = BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(f250345n, !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion());
        QLog.d(f250332a, 1, "isMSFInitOptimizeEnable = " + isSwitchOn);
        return isSwitchOn;
    }

    public static boolean e() {
        boolean isSwitchOn = BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(f250340i, true);
        QLog.d(f250332a, 1, "isMSFNetworkServiceNewSwitchEnable = " + isSwitchOn);
        return isSwitchOn;
    }

    public static boolean f() {
        boolean isSwitchOn = BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(f250344m, f250354w.booleanValue());
        QLog.d(f250332a, 1, "isMSFWaitSendQueueBugfixEnable = " + isSwitchOn);
        return isSwitchOn;
    }

    public static boolean g() {
        boolean isSwitchOn = BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(f250336e, f250348q.booleanValue());
        QLog.d(f250332a, 1, "isNTLoginMergeEnable = " + isSwitchOn);
        return isSwitchOn;
    }

    public static boolean h() {
        boolean isSwitchOn = BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(f250338g, f250350s.booleanValue());
        QLog.d(f250332a, 1, "isNoLoginWithNoAccountInfo = " + isSwitchOn);
        return isSwitchOn;
    }

    public static boolean i() {
        boolean isSwitchOn = BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(f250343l, !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion());
        QLog.d(f250332a, 1, "isQualityTestSupportQuic = " + isSwitchOn);
        return isSwitchOn;
    }

    public static boolean j() {
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            return true;
        }
        boolean isSwitchOn = BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(f250337f, f250349r.booleanValue());
        QLog.d(f250332a, 1, "isQuitConnForDualCloseConnFail = " + isSwitchOn);
        return isSwitchOn;
    }

    public static boolean k() {
        boolean z16 = !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion();
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            SharedPreferences sharedPreferences = MsfService.getCore().getSharedPreferences(f250333b, 4);
            if (sharedPreferences.contains(f250334c)) {
                z16 = sharedPreferences.getBoolean(f250334c, !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion());
            } else {
                boolean nextBoolean = new Random().nextBoolean();
                sharedPreferences.edit().putBoolean(f250334c, nextBoolean).apply();
                z16 = nextBoolean;
            }
        }
        return BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(f250346o, z16);
    }

    public static boolean l() {
        boolean isSwitchOn = BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(f250342k, f250353v.booleanValue());
        QLog.d(f250332a, 1, "isWtloginSupportConnectTicket = " + isSwitchOn);
        return isSwitchOn;
    }
}
