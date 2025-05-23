package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class BatteryBroadcastReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_BATTERY = "KEY_BATTERY";
    public static final String KEY_CHANGE_IN_CHARGING = "KEY_CHANGE_IN_CHARGING";
    private static final String TAG = "BatteryBroadcastReceiver";
    public static final int TYPE_BUSINESS_BATTERY = 1;
    private final WeakReference<AppRuntime> app;
    private int lastLevel;

    public BatteryBroadcastReceiver(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.lastLevel = -1;
            this.app = new WeakReference<>(appRuntime);
        }
    }

    private void toggleChangeInCharging() {
        AppRuntime appRuntime = this.app.get();
        if (appRuntime != null) {
            IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "");
            if (iOnlineStatusService.getOnlineStatus() == AppRuntime.Status.online && iOnlineStatusService.getExtOnlineStatus() == 1000) {
                iOnlineStatusService.syncBusinessInfo(1, ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).buildSyncBatteryData(appRuntime));
                int batteryCapacity = iOnlineStatusService.getBatteryCapacity();
                int powerConnect = iOnlineStatusService.getPowerConnect();
                Bundle bundle = new Bundle(2);
                bundle.putInt(KEY_BATTERY, batteryCapacity);
                bundle.putBoolean(KEY_CHANGE_IN_CHARGING, true);
                appRuntime.notifyObservers(com.tencent.mobileqq.onlinestatus.ac.class, 26364, true, bundle);
                QLog.d(TAG, 1, "toggleChangeInCharging battery: " + batteryCapacity + " connectState: " + powerConnect);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent != null) {
            String action = intent.getAction();
            AppRuntime appRuntime = this.app.get();
            if (TextUtils.equals(action, "android.intent.action.ACTION_POWER_CONNECTED")) {
                if (appRuntime != null) {
                    ((IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "")).setPowerConnect(1);
                }
                toggleChangeInCharging();
                return;
            }
            if (TextUtils.equals(action, "android.intent.action.ACTION_POWER_DISCONNECTED")) {
                if (appRuntime != null) {
                    ((IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "")).setPowerConnect(0);
                }
                toggleChangeInCharging();
                return;
            }
            if (TextUtils.equals(action, "android.intent.action.BATTERY_CHANGED")) {
                int intExtra = intent.getIntExtra("level", 0);
                int intExtra2 = intent.getIntExtra("scale", 100);
                if (intExtra2 != 0) {
                    intExtra = (intExtra * 100) / intExtra2;
                }
                if (appRuntime != null) {
                    IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "");
                    AppRuntime.Status onlineStatus = iOnlineStatusService.getOnlineStatus();
                    long extOnlineStatus = iOnlineStatusService.getExtOnlineStatus();
                    if (onlineStatus == AppRuntime.Status.online && extOnlineStatus == 1000) {
                        if (QLog.isColorLevel() && this.lastLevel != intExtra) {
                            QLog.d(TAG, 2, "onBatteryChanged curLevel == " + intExtra + ", lastLevel == " + this.lastLevel);
                        }
                        if (this.lastLevel != intExtra) {
                            this.lastLevel = intExtra;
                            Bundle bundle = new Bundle();
                            bundle.putInt(KEY_BATTERY, intExtra);
                            appRuntime.notifyObservers(com.tencent.mobileqq.onlinestatus.ac.class, 26364, true, bundle);
                        }
                    }
                    ((IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "")).setBatteryCapacity(intExtra);
                }
            }
        }
    }
}
