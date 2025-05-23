package h20;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f404105a = false;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f404106b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f404107c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f404108d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile int f404109e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile boolean f404110f;

    /* renamed from: g, reason: collision with root package name */
    private static volatile boolean f404111g;

    public static boolean a() {
        g();
        if (f404106b && f404109e == 3) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        g();
        if (f404106b && !f404110f) {
            return true;
        }
        return false;
    }

    public static boolean c() {
        g();
        if (f404106b && !f404111g) {
            return true;
        }
        return false;
    }

    public static boolean d() {
        return f404108d;
    }

    public static boolean e() {
        return f404107c;
    }

    public static boolean f() {
        return f404106b;
    }

    private static void g() {
        boolean z16;
        boolean z17;
        if (!f404105a) {
            synchronized (c.class) {
                if (!f404105a) {
                    boolean z18 = false;
                    if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_kadun_opt", false)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    f404106b = z16;
                    f404109e = QCircleDeviceInfoUtils.getQQPerfDeviceLevel();
                    f404110f = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_build_request_in_sub_thread", false);
                    f404111g = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_folder_application_lazy_load", false);
                    if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion() && !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("argus_qcircle_910_fabu_activity", false)) {
                        z17 = false;
                        f404107c = z17;
                        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion() || ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("argus_qcircle_915_fabu_folder_activity", false)) {
                            z18 = true;
                        }
                        f404108d = z18;
                        f404105a = true;
                        QLog.d("QCircleKaDunOptUtil", 1, "[initOptExp] isHitOptExp:" + f404106b + ", perf deviceLevel:" + f404109e + ", qcircle deviceLevel:" + QCircleDeviceInfoUtils.getLevel() + ", disableBuildRequestInSubThread:" + f404110f + ", disableLayerApplicationLazyLoad:" + f404111g + ", isFolderHitArgusExp:" + f404108d + ", isHitArgusExp:" + f404107c);
                    }
                    z17 = true;
                    f404107c = z17;
                    if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion()) {
                    }
                    z18 = true;
                    f404108d = z18;
                    f404105a = true;
                    QLog.d("QCircleKaDunOptUtil", 1, "[initOptExp] isHitOptExp:" + f404106b + ", perf deviceLevel:" + f404109e + ", qcircle deviceLevel:" + QCircleDeviceInfoUtils.getLevel() + ", disableBuildRequestInSubThread:" + f404110f + ", disableLayerApplicationLazyLoad:" + f404111g + ", isFolderHitArgusExp:" + f404108d + ", isHitArgusExp:" + f404107c);
                }
            }
        }
    }

    public static boolean h() {
        g();
        return f404106b;
    }

    public static void i() {
        f404105a = false;
        f404106b = false;
        f404109e = 0;
        f404110f = false;
        QLog.d("QCircleKaDunOptUtil", 1, "[resetExp]");
    }
}
