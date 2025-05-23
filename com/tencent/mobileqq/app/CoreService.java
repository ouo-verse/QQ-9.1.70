package com.tencent.mobileqq.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.IBinder;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class CoreService extends Service {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_START_MODE = "k_start_mode";
    static final int NOTIFICATION_ID;
    private static final String S_VIVO_FILE_PATH;
    private static final String TAG = "GuardManager";
    static CoreService sCore;
    static boolean sDisableForeground;
    private static boolean sEnableKernerServiceInVivo;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class KernelService extends Service {
        static IPatchRedirector $redirector_;

        public KernelService() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (IBinder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            }
            return null;
        }

        @Override // android.app.Service
        public void onCreate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(CoreService.KEY_START_MODE, 2);
            MobileQQ.sMobileQQ.onActivityCreate(this, intent);
            super.onCreate();
            if (QLog.isColorLevel()) {
                QLog.d("GuardManager", 2, "TempService.onCreate");
            }
        }

        @Override // android.app.Service
        public void onDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GuardManager", 2, "TempService.onDestroy");
            }
            try {
                super.stopForeground(true);
            } catch (Exception unused) {
            }
            super.onDestroy();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, this, intent, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
            }
            if (intent != null && CoreService.sCore != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuardManager", 2, "onStartCommand:");
                }
                try {
                    CoreService coreService = CoreService.sCore;
                    int i17 = CoreService.NOTIFICATION_ID;
                    coreService.startForeground(i17, new Notification());
                    super.startForeground(i17, new Notification());
                    CoreService.sCore.stopForeground(true);
                } catch (Exception e16) {
                    QLog.d("GuardManager", 1, "", e16);
                }
            }
            return 2;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36902);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        NOTIFICATION_ID = AppSetting.f();
        sCore = null;
        String str = BaseApplication.getContext().getFilesDir() + File.separator + "enableKernelServiceInVivo";
        S_VIVO_FILE_PATH = str;
        sEnableKernerServiceInVivo = new File(str).exists();
    }

    public CoreService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Notification fakeNotification(boolean z16) {
        if (z16) {
            Notification notification = new Notification();
            notification.icon = R.drawable.icon;
            notification.contentView = new RemoteViews(MobileQQ.sMobileQQ.getPackageName(), R.layout.qapp_center_notification);
            return notification;
        }
        Intent intent = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
        intent.addFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(MobileQQ.sMobileQQ, 0, intent, 436207616);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MobileQQ.sMobileQQ);
        builder.setContentTitle("QQ").setContentText("QQ\u6b63\u5728\u540e\u53f0\u8fd0\u884c").setWhen(System.currentTimeMillis()).setSmallIcon(R.drawable.icon);
        builder.setContentIntent(activity);
        return builder.build();
    }

    private static boolean isVivoPhoneAndSDK22() {
        return false;
    }

    public static synchronized void startCoreService(boolean z16) {
        synchronized (CoreService.class) {
            QLog.i("GuardManager", 1, "start CoreService");
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            Intent intent = new Intent(mobileQQ, (Class<?>) CoreService.class);
            sDisableForeground = z16;
            try {
                mobileQQ.startService(intent);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuardManager", 2, "", th5);
                }
            }
        }
    }

    public static void startTempService() {
        if (Build.VERSION.SDK_INT >= 25 || isVivoPhoneAndSDK22()) {
            return;
        }
        try {
            BaseApplication.getContext().startService(new Intent(MobileQQ.sMobileQQ, (Class<?>) KernelService.class));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("GuardManager", 2, "", th5);
            }
        }
    }

    public static synchronized void stopCoreService() {
        synchronized (CoreService.class) {
            try {
                BaseApplication.getContext().stopService(new Intent(MobileQQ.sMobileQQ, (Class<?>) CoreService.class));
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuardManager", 2, "", th5);
                }
            }
        }
    }

    public static void stopTempService() {
        if (Build.VERSION.SDK_INT >= 25 || isVivoPhoneAndSDK22()) {
            return;
        }
        try {
            BaseApplication.getContext().stopService(new Intent(MobileQQ.sMobileQQ, (Class<?>) KernelService.class));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("GuardManager", 2, "", th5);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IBinder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        sCore = this;
        if (QLog.isColorLevel()) {
            QLog.d("GuardManager", 2, "CoreService.onCreate " + Build.VERSION.SDK_INT);
        }
        super.onCreate();
        MobileQQ.sMobileQQ.onActivityCreate(this, null);
        stopTempService();
        if (!sDisableForeground && Build.VERSION.SDK_INT < 25) {
            startTempService();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuardManager", 2, "CoreService.onDestroy");
        }
        stopTempService();
        super.onDestroy();
        sCore = null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, intent, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        SharedPreferences a16 = com.tencent.qqperf.monitor.crash.e.a(BaseApplication.getContext(), "crashcontrol", 0);
        if (a16.getBoolean("crashFrequentLast", false)) {
            QLog.d("GuardManager", 1, "crashFrequentLast,return START_NOT_STICKY");
            a16.edit().putBoolean("crashFrequentLast", false).commit();
            return 2;
        }
        return super.onStartCommand(intent, i3, i16);
    }
}
