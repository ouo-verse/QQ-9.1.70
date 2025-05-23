package com.tencent.mobileqq.pushnotice;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pushnotice.proxy.HonorPushProcessor;
import com.tencent.mobileqq.pushnotice.proxy.HuaWeiPushProcessor;
import com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl;
import com.tencent.mobileqq.pushnotice.proxy.VivoPushProcessor;
import com.tencent.mobileqq.pushnotice.proxy.XiaomiPushProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Objects;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ThirdPushManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ThirdPushManager";
    private static final boolean asyncCallRegisterPush;
    private static final boolean enableHonorPush;
    private static final boolean forceUseHuaWeiPush;
    private static final boolean preferHonorPushIfAvailable;
    private static volatile ThirdPushManager sInstance;
    private final com.tencent.mobileqq.pushnotice.proxy.c mThirdPushProcessor;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74315);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        enableHonorPush = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notification_enable_honor_push_8890", true);
        preferHonorPushIfAvailable = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notification_prefer_honor_push_8890", false);
        forceUseHuaWeiPush = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notification_force_use_huawei_push_8890", false);
        asyncCallRegisterPush = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notification_async_call_register_push_8896", true);
    }

    ThirdPushManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        com.tencent.mobileqq.pushnotice.proxy.c createPushProcessor = createPushProcessor();
        this.mThirdPushProcessor = createPushProcessor;
        QLog.d(TAG, 1, "ThirdPushManager init. manufacturer=" + Build.MANUFACTURER + " model=" + DeviceInfoMonitor.getModel() + " thirdPushType=" + createPushProcessor.c() + " thirdPushProcessor=" + createPushProcessor.getClass().getSimpleName());
        reportThirdPushType(createPushProcessor.c());
    }

    private static com.tencent.mobileqq.pushnotice.proxy.c createPushProcessor() {
        String str = Build.MANUFACTURER;
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        try {
            if (!"oppo".equalsIgnoreCase(str) && !"realme".equalsIgnoreCase(str) && !"oneplus".equalsIgnoreCase(str)) {
                if (ah.h0()) {
                    return new HuaWeiPushProcessor();
                }
                if (ah.g0()) {
                    if (preferHonorPushIfAvailable && supportHonorPush()) {
                        return new HonorPushProcessor();
                    }
                    if (!forceUseHuaWeiPush && !supportHuaWeiPush(applicationContext)) {
                        if (supportHonorPush()) {
                            return new HonorPushProcessor();
                        }
                        QLog.w(TAG, 1, "Not support neither HuaWei nor Honor push");
                        return new HuaWeiPushProcessor();
                    }
                    return new HuaWeiPushProcessor();
                }
                if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(str)) {
                    return new VivoPushProcessor();
                }
                if ("xiaomi".equalsIgnoreCase(str)) {
                    return new XiaomiPushProcessor();
                }
                return new ThirdPushProcessorImpl();
            }
            return new com.tencent.mobileqq.pushnotice.proxy.d();
        } catch (Throwable th5) {
            reportFailCreatePushProcessor(th5.toString());
            return new ThirdPushProcessorImpl();
        }
    }

    public static ThirdPushManager getInstance() {
        if (sInstance == null) {
            synchronized (ThirdPushManager.class) {
                if (sInstance == null) {
                    sInstance = new ThirdPushManager();
                }
            }
        }
        return sInstance;
    }

    private static void reportFailCreatePushProcessor(String str) {
        QLog.w(TAG, 1, "failed to create push processor, manufacturer=" + Build.MANUFACTURER + " brand=" + Build.BRAND + " model=" + DeviceInfoMonitor.getModel() + " api-level=" + Build.VERSION.SDK_INT + " error=" + str);
        QQBeaconReport.report("fail_create_third_push_processor");
    }

    private static void reportThirdPushType(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("param_push_type", String.valueOf(i3));
        QQBeaconReport.report("", "offline_notification_type", hashMap);
    }

    private static boolean supportHonorPush() {
        if (!enableHonorPush || !ah.g0()) {
            return false;
        }
        return HonorPushProcessor.b.c(MobileQQ.sMobileQQ.getApplicationContext());
    }

    private static boolean supportHuaWeiPush(Context context) {
        if (!ah.i0()) {
            return false;
        }
        try {
            if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context) != 0) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            QLog.w(TAG, 1, "supportHuaWeiPush, exception is " + th5);
            return false;
        }
    }

    public void clearNotifications(Context context, com.tencent.mobileqq.pushnotice.proxy.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) bVar);
        } else {
            this.mThirdPushProcessor.e(context, bVar);
        }
    }

    public void clearNotificationsBackground(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        } else {
            this.mThirdPushProcessor.b(context);
        }
    }

    public int getThirdPushType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        int c16 = this.mThirdPushProcessor.c();
        if (QLog.isColorLevel()) {
            QLog.d("", 2, "Push pushType : " + c16);
        }
        return c16;
    }

    public void onLogout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mThirdPushProcessor.onLogout();
        }
    }

    public void registerThirdPartyPush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "registerThirdPartyPush");
        if (!asyncCallRegisterPush) {
            this.mThirdPushProcessor.d();
        } else {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.mThirdPushProcessor.d();
                return;
            }
            final com.tencent.mobileqq.pushnotice.proxy.c cVar = this.mThirdPushProcessor;
            Objects.requireNonNull(cVar);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.pushnotice.d
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.mobileqq.pushnotice.proxy.c.this.d();
                }
            }, 16, null, false);
        }
    }

    public void setToken(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mThirdPushProcessor.a(str);
        }
    }
}
