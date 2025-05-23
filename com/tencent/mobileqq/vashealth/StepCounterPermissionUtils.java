package com.tencent.mobileqq.vashealth;

import android.app.Activity;
import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.vashealth.huaweistep.DeviceStepRequestAuthDialog;
import com.tencent.mobileqq.vashealth.huaweistep.HuaweiStepHelper;
import com.tencent.mobileqq.vashealth.step.SportEventManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* loaded from: classes20.dex */
public class StepCounterPermissionUtils {

    /* loaded from: classes20.dex */
    class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f312204a;

        a(WeakReference weakReference) {
            this.f312204a = weakReference;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            WeakReference weakReference = this.f312204a;
            if (weakReference != null && weakReference.get() != null) {
                ((t) this.f312204a.get()).b();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            WeakReference weakReference = this.f312204a;
            if (weakReference != null && weakReference.get() != null) {
                ((t) this.f312204a.get()).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f312205a;

        b(t tVar) {
            this.f312205a = tVar;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f312205a.b();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            this.f312205a.a();
        }
    }

    public static void A(boolean z16) {
        Activity j3 = j();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (j3 != null && peekAppRuntime != null) {
            NewIntent newIntent = new NewIntent(j3, u.class);
            newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_HEALTH_SWITCH);
            newIntent.putExtra(com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, z16);
            peekAppRuntime.startServlet(newIntent);
            QLog.d("StepCounterPermissionUtils", 1, "setStepCounterPermissionToMSF permission:" + z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void B() {
        final Activity j3 = j();
        if (j3 == null) {
            return;
        }
        j3.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vashealth.StepCounterPermissionUtils.2
            @Override // java.lang.Runnable
            public void run() {
                if (!j3.isFinishing() && !j3.isDestroyed()) {
                    new DeviceStepRequestAuthDialog(j3).showDialog();
                    QLog.d("StepCounterPermissionUtils", 1, "request showDeviceStepReqAuthDialog");
                }
            }
        });
    }

    private static boolean b() {
        float decodeLong = (float) QMMKV.from(j(), "common_mmkv_configurations").decodeLong("recent_request_health_permission_time", 0L);
        QLog.d("StepCounterPermissionUtils", 1, "canReadDeviceStep " + g() + " now " + System.currentTimeMillis() + "last " + decodeLong);
        if (g() && ((float) System.currentTimeMillis()) - decodeLong > 0.0f) {
            return true;
        }
        return false;
    }

    public static boolean c() {
        if (!m()) {
            return true;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.getApplicationContext().checkSelfPermission(QQPermissionConstants.Permission.ACTIVITY_RECOGNITION) == 0) {
            return true;
        }
        return false;
    }

    public static boolean d() {
        boolean decodeBool = QMMKV.from(j(), "common_mmkv_configurations").decodeBool("request_honor_health_permission", false);
        QLog.d("StepCounterPermissionUtils", 1, "checkHonorStepPermission: " + decodeBool);
        return decodeBool;
    }

    public static boolean e() {
        boolean decodeBool = QMMKV.from(j(), "common_mmkv_configurations").decodeBool("request_huawei_health_permission", false);
        QLog.d("StepCounterPermissionUtils", 1, "checkHuaweiStepPermission: " + decodeBool);
        return decodeBool;
    }

    public static boolean f() {
        boolean decodeBool = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").decodeBool("request_step_counter_permission", true);
        QLog.d("StepCounterPermissionUtils", 1, "checkStepCounterPermission: " + decodeBool);
        if (!decodeBool && com.tencent.mobileqq.vashealth.step.k.f312340a.j()) {
            SportEventManager.f312326a.e();
        }
        return decodeBool;
    }

    public static boolean g() {
        if (f() && c()) {
            return true;
        }
        return false;
    }

    public static boolean h() {
        Activity j3 = j();
        boolean z16 = false;
        if (j3 == null) {
            return false;
        }
        if (1 == new vy4.b(j3).e(j3, 1)) {
            z16 = true;
        }
        QLog.d("StepCounterPermissionUtils", 1, "checkVivoPermission: " + z16);
        return z16;
    }

    public static boolean i() {
        if (cu.g() && SSOHttpUtils.e()[1] > 0) {
            return true;
        }
        return false;
    }

    private static Activity j() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            return Foreground.getTopActivity();
        }
        return qBaseActivity;
    }

    public static boolean k() {
        boolean decodeBool = QMMKV.from(j(), "common_mmkv_configurations").decodeBool("request_huawei_health_alive", true);
        QLog.d("StepCounterPermissionUtils", 1, "getHuaweiStepKitAlive: " + decodeBool);
        return decodeBool;
    }

    public static boolean l() {
        if (!DeviceInfoMonitor.getModel().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO) && !Build.MANUFACTURER.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
            return false;
        }
        return true;
    }

    public static boolean m() {
        QLog.d("StepCounterPermissionUtils", 1, "needDeviceStepCounterPermission target is : " + AppSetting.m());
        if (AppSetting.m() > 28 && Build.VERSION.SDK_INT > 28) {
            return true;
        }
        return false;
    }

    public static void n(boolean z16) {
        QMMKV.from(j(), "common_mmkv_configurations").encodeBool("request_honor_health_permission", z16);
        QLog.d("StepCounterPermissionUtils", 1, "recordHonorStepPermission: " + z16);
    }

    public static void o(boolean z16) {
        QMMKV.from(j(), "common_mmkv_configurations").encodeBool("request_huawei_health_alive", z16);
        QLog.d("StepCounterPermissionUtils", 1, "recordHuaweiStepKitAlive: " + z16);
    }

    public static void p(boolean z16) {
        QMMKV.from(j(), "common_mmkv_configurations").encodeBool("request_huawei_health_permission", z16);
        QLog.d("StepCounterPermissionUtils", 1, "recordHuaweiStepPermission: " + z16);
    }

    public static void q() {
        if (!b()) {
            return;
        }
        QMMKV.from(j(), "common_mmkv_configurations").encodeLong("recent_request_health_permission_time", System.currentTimeMillis());
        if (l() && !h()) {
            y();
            QLog.d("StepCounterPermissionUtils", 1, "requestDeviceHealthPermission requestVivoHealthPermission");
        }
        if (HuaweiStepHelper.isInHuaWeiSystemWhiteList() && g() && !e()) {
            u();
            QLog.d("StepCounterPermissionUtils", 1, "requestDeviceHealthPermission requestHuaweiStepPermission");
        }
        if (com.tencent.mobileqq.vashealth.honorstep.g.f312292a.n() && g() && !d()) {
            t();
            QLog.d("StepCounterPermissionUtils", 1, "requestDeviceHealthPermission requestHonorStepPermission");
        }
        m43.c cVar = m43.c.f416147a;
        if (cVar.c() && g() && !cVar.b()) {
            w();
            QLog.d("StepCounterPermissionUtils", 1, "requestDeviceHealthPermission requestOppoStepPermission");
        }
    }

    public static void r(t tVar) {
        QQPermission qQPermission;
        Activity j3 = j();
        if (j3 != null && (qQPermission = QQPermissionFactory.getQQPermission(j3, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_HEALTH, QQPermissionConstants.Business.SCENE.HEALTH_RUN))) != null && qQPermission.hasPermission(QQPermissionConstants.Business.ID.QQ_HEALTH, QQPermissionConstants.Permission.ACTIVITY_RECOGNITION) != 0) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.ACTIVITY_RECOGNITION}, 2, new b(tVar));
        }
    }

    public static void s(WeakReference<t> weakReference, Activity activity) {
        QQPermission qQPermission;
        if (activity == null) {
            activity = j();
        }
        if (activity != null && (qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_HEALTH, QQPermissionConstants.Business.SCENE.HEALTH_RUN))) != null && qQPermission.hasPermission(QQPermissionConstants.Business.ID.QQ_HEALTH, QQPermissionConstants.Permission.ACTIVITY_RECOGNITION) != 0) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.ACTIVITY_RECOGNITION}, 2, new a(weakReference));
        }
    }

    public static void t() {
        if (j() == null) {
            return;
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vashealth.StepCounterPermissionUtils.3
            @Override // java.lang.Runnable
            public void run() {
                StepCounterPermissionUtils.B();
            }
        }, 16, null, false, 2000L);
    }

    public static void u() {
        if (j() == null) {
            return;
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vashealth.StepCounterPermissionUtils.1
            @Override // java.lang.Runnable
            public void run() {
                StepCounterPermissionUtils.B();
            }
        }, 16, null, false, 2000L);
    }

    public static void v(final t tVar) {
        final Activity j3 = j();
        if (j3 == null) {
            return;
        }
        j3.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vashealth.StepCounterPermissionUtils.7
            @Override // java.lang.Runnable
            public void run() {
                if (!j3.isFinishing() && !j3.isDestroyed()) {
                    StepCounterPermissionDialog stepCounterPermissionDialog = new StepCounterPermissionDialog(j3);
                    stepCounterPermissionDialog.P(tVar);
                    stepCounterPermissionDialog.showDialog();
                    QLog.d("StepCounterPermissionUtils", 1, "request showStepCounterDialog");
                }
            }
        });
    }

    public static void w() {
        if (j() == null) {
            return;
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vashealth.StepCounterPermissionUtils.4
            @Override // java.lang.Runnable
            public void run() {
                StepCounterPermissionUtils.B();
            }
        }, 16, null, false, 2000L);
    }

    public static void x(t tVar) {
        if (j() == null) {
            return;
        }
        if (m()) {
            if (c()) {
                tVar.b();
                return;
            } else {
                r(tVar);
                return;
            }
        }
        v(tVar);
    }

    private static void y() {
        Activity j3 = j();
        if (j3 == null || !new com.vivo.datashare.sport.query.c(j3).b()) {
            return;
        }
        new vy4.b(j3).g(j3, 1);
    }

    public static void z(boolean z16) {
        QMMKV.from(j(), "common_mmkv_configurations").encodeBool("request_step_counter_permission", z16);
        A(z16);
    }
}
