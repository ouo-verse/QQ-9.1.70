package com.tencent.mobileqq.qmethodmonitor.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArraySet;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.QQPermissionBusinessManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.monitor.base.PMonitorInitParam;
import com.tencent.qmethod.monitor.config.CacheTime;
import com.tencent.qmethod.monitor.config.GeneralRule;
import com.tencent.qmethod.monitor.config.GlobalConfigType;
import com.tencent.qmethod.monitor.config.HighFrequency;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kd2.e;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f261913a = "unknown";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals(NewIntent.ACTION_ACCOUNT_CHANGED)) {
                b.x();
            }
        }
    }

    public static void b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        i();
        PMonitorInitParam.a c16 = new PMonitorInitParam.a(e.a(), e.b(), BaseApplication.getContext()).e(PrivacyProtectionManager.f261909c).f(PrivacyProtectionManager.f261910d).g(100000).d(true).c(PrivacyProtectionManager.f261911e);
        t();
        e();
        l();
        com.tencent.qmethod.monitor.a.i(c16.a());
        r();
        com.tencent.qmethod.monitor.a.r(PMonitorInitParam.Property.APP_VERSION, AppSetting.f99551k + "." + com.tencent.mobileqq.cooperation.a.a(BaseApplication.getContext()));
        if (PrivacyPolicyHelper.isUserAllow()) {
            c();
            com.tencent.qmethod.monitor.a.r(PMonitorInitParam.Property.SYS_VERSION_INT, Integer.toString(Build.VERSION.SDK_INT));
        }
        QLog.d("PMonitorManager", 1, "initPMonitor cost:" + Math.abs(SystemClock.uptimeMillis() - uptimeMillis));
    }

    public static void c() {
        x();
        d();
    }

    private static void d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        MobileQQ.sMobileQQ.registerReceiver(new a(), intentFilter);
    }

    private static void e() {
        com.tencent.qmethod.monitor.a.f().o("func_invoke_api", 0.002d, 10).o("func_invoke_user", 1.0E-4d, 10);
        com.tencent.qmethod.monitor.a.f().l("BU#MODEL", 0.005d).l("SE#G_AID", 0.1d).l("TM#G_IM", 0.1d).l("TM#G_SID", 0.5d).l("TM#G_MID", 0.5d).l("TM#G_SIM_OP", 0.5d).l("NI#G_TYPE", 0.01d).l("IA#GET_H_A", 0.01d).l("NI#G_TY_NAME", 0.05d).l("TM#G_NET_TYPE", 0.05d).l("WI#G_SSID", 0.05d).l("WI#G_BSSID", 0.05d).l("NC#HAS_TRANS", 0.005d).l("NI#G_NET_INT", 0.05d).l("NI#G_SUB_TYPE", 0.05d).l("WM#G_CON_INFO", 0.1d).l("CM#G_PRI_DESC", 0.005d).l("CM#HAS_PRI_CLIP", 0.005d).l("CM#G_PRI_CLIP_DESC", 0.01d);
    }

    private static void f() {
        fr3.b n3 = com.tencent.qmethod.monitor.a.f().n("appinfo", new String[0]);
        GeneralRule generalRule = GeneralRule.BACK_NORMAL_AND_FRONT_NORMAL;
        n3.p(generalRule).k();
        com.tencent.qmethod.monitor.a.f().n("appinfo", "PM#G_PKG_INFO_N", "PM#G_PKG_INFO_VP").p(generalRule).k();
    }

    private static void g() {
        com.tencent.qmethod.monitor.a.f().n("recorder", new String[0]).p(GeneralRule.BACK_NORMAL_AND_FRONT_NORMAL).k();
    }

    private static void h() {
        com.tencent.qmethod.monitor.a.f().n("camera", new String[0]).p(GeneralRule.BACK_NORMAL_AND_FRONT_NORMAL).k();
    }

    private static void i() {
        com.tencent.qmethod.monitor.a.f().a(GlobalConfigType.COMPLIANCE_TEST);
        g();
        h();
        m();
        q();
        f();
        o();
        n();
        j();
        p();
        s();
    }

    private static void j() {
        GeneralRule generalRule = GeneralRule.BACK_BAN_AND_FRONT_BAN;
        if (Build.VERSION.SDK_INT < 29) {
            generalRule = GeneralRule.BACK_CACHE_ONLY_AND_FRONT_CACHE_ONLY;
        }
        fr3.b p16 = com.tencent.qmethod.monitor.a.f().n("device", "TM#G_IM", "TM#G_IM#I", "TM#G_MID", "TM#G_MID#I", "TM#G_DID", "TM#G_DID#I", "TM#G_LI_NUM", "TM#G_SIM_SE_NUM", "TM#G_SID", "TM#G_UICC_INFO").p(generalRule);
        HighFrequency highFrequency = HighFrequency.HIGHER;
        p16.o(highFrequency).k();
        com.tencent.qmethod.monitor.a.f().n("network", "TM#G_DA_NET_TYPE").p(generalRule).o(highFrequency).k();
        com.tencent.qmethod.monitor.a.f().n("device", "OAID#XIAOMI").p(GeneralRule.BACK_STORAGE_AND_FRONT_STORAGE).k();
        com.tencent.qmethod.monitor.a.f().n("device", "TM#G_NWK_OP").p(GeneralRule.BACK_NORMAL_AND_FRONT_NORMAL).k();
    }

    private static void k(GeneralRule generalRule) {
        com.tencent.qmethod.monitor.a.f().n("network", "NI#GET_EXT_INFO").p(generalRule).o(HighFrequency.HIGHER).k();
    }

    private static void m() {
        com.tencent.qmethod.monitor.a.f().n("location", new String[0]).p(GeneralRule.BACK_CACHE_ONLY_AND_FRONT_NORMAL).k();
        com.tencent.qmethod.monitor.a.f().n("location", "TM#REQ_NW_SC#REC", "BLS#STRT_SC#S", "BLS#STRT_SC#LSS", "BLS#STRT_SC#LSP", "BA#STRT_DIS_COV", "BA#STRT_LE_SC#L", "BA#STRT_LE_SC#UL", "TM#G_SER_STATE", "TM#LIS#PI").p(GeneralRule.BACK_NORMAL_AND_FRONT_NORMAL).k();
    }

    private static void n() {
        com.tencent.qmethod.monitor.a.f().n("mediaFile", new String[0]).p(GeneralRule.BACK_NORMAL_AND_FRONT_NORMAL).k();
    }

    private static void o() {
        com.tencent.qmethod.monitor.a.f().n("device", "BU#MODEL").p(GeneralRule.BACK_CACHE_ONLY_AND_FRONT_STORAGE).l(CacheTime.ONE_DAY).o(HighFrequency.HIGHER).k();
    }

    private static void p() {
        String[] businessPermissionList;
        for (String str : QQPermissionConstants.Module.f274294a.keySet()) {
            ArraySet<String> arraySet = new ArraySet();
            for (Map.Entry<String, String> entry : QQPermissionConstants.BUSINESS_MODULE_MAP.entrySet()) {
                if (str.equals(entry.getValue()) && (businessPermissionList = QQPermissionBusinessManager.getBusinessPermissionList(entry.getKey())) != null) {
                    for (String str2 : businessPermissionList) {
                        arraySet.add(QQPermissionConstants.Permission.PERMISSION_GROUP.get(str2));
                    }
                }
            }
            fr3.e b16 = com.tencent.qmethod.monitor.a.f().b(str);
            for (String str3 : arraySet) {
                Map<String, String> map = QQPermissionConstants.Permission.PMONITOR_PERMISSION_GROUP;
                if (map.get(str3) != null) {
                    b16.b(map.get(str3));
                }
            }
            b16.a();
        }
    }

    private static void q() {
        fr3.b n3 = com.tencent.qmethod.monitor.a.f().n("network", new String[0]);
        GeneralRule generalRule = GeneralRule.BACK_NORMAL_AND_FRONT_NORMAL;
        n3.p(generalRule).k();
        com.tencent.qmethod.monitor.a.f().n("network", "NI#G_TYPE", "TM#G_NET_TYPE", "NI#G_TY_NAME").p(generalRule).o(HighFrequency.HIGHER).k();
        com.tencent.qmethod.monitor.a.f().n("network", "WI#G_MA_ADDR", "NI#G_HW_ADDR").p(GeneralRule.BACK_BAN_AND_FRONT_BAN).k();
        com.tencent.qmethod.monitor.a.f().n("network", "NI#G_IF_ADDR", "NI#G_INET_ADDR").p(generalRule).k();
        v();
    }

    private static void r() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100406", false) && MobileQQ.sProcessId == 1) {
            QLog.d("PMonitorManager", 1, "setNetWorkListener isSucceed :" + q.t());
        }
    }

    private static void s() {
        for (String str : QQPermissionConstants.Permission.PMONITOR_PERMISSION_GROUP.values()) {
            com.tencent.qmethod.monitor.a.f().c(str).a(0).b();
            QLog.d("PMonitorManager", 1, "setPermissionRule add permissionPMonitor: " + str);
        }
    }

    private static void t() {
        com.tencent.qmethod.monitor.a.f().m(1.0E-4d, 50).o("before", 0.05d, 10).o("illegal_scene", 0.005d, 10).o("back", 0.005d, 20).o("high_freq", 0.005d, 20);
    }

    public static void u(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("PMonitorManager", 1, "uin is empty");
        } else {
            f261913a = str;
            com.tencent.qmethod.monitor.a.r(PMonitorInitParam.Property.APP_USER_ID, f261913a);
        }
    }

    private static void v() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100406", false)) {
            GeneralRule generalRule = GeneralRule.BACK_CACHE_ONLY_AND_FRONT_STORAGE;
            w(generalRule);
            k(generalRule);
        } else {
            GeneralRule generalRule2 = GeneralRule.BACK_CACHE_ONLY_AND_FRONT_NORMAL;
            w(generalRule2);
            k(generalRule2);
        }
    }

    private static void w(GeneralRule generalRule) {
        com.tencent.qmethod.monitor.a.f().n("network", "WI#G_BSSID", "WI#G_SSID").p(generalRule).o(HighFrequency.HIGHER).k();
        com.tencent.qmethod.monitor.a.f().n("location", "WM#G_CON_INFO").p(generalRule).k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x() {
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            try {
                u(firstSimpleAccount.getUin());
            } catch (NumberFormatException e16) {
                QLog.e("PMonitorManager", 1, "setUin error", e16);
            }
        }
    }

    private static void l() {
    }
}
