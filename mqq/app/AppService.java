package mqq.app;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AppService extends Service {
    protected static final int CONFIG_NEED_RUNTIME = 0;
    protected static final int CONFIG_NO_NEED_RUNTIME = 1;
    protected AppRuntime app;

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i3) {
        ThirdAppReportHelper.reportThirdAppOpen(this, intent, 2);
        return super.bindService(intent, serviceConnection, i3);
    }

    public String getModuleId() {
        return null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int onConfigRuntime() {
        return 0;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent();
        onConfigStartMode(intent);
        MobileQQ.sMobileQQ.onActivityCreate(this, intent);
        if (onConfigRuntime() == 0) {
            this.app = MobileQQ.sMobileQQ.waitAppRuntime().getAppRuntime(getModuleId());
        }
        MobileQQ.sMobileQQ.appServices.add(new WeakReference<>(this));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        super.sendBroadcast(intent);
        MobileQQ.sMobileQQ.onSendBroadcast(this, intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        super.sendOrderedBroadcast(intent, str);
        MobileQQ.sMobileQQ.onSendBroadcast(this, intent);
    }

    public void setAppRuntime(AppRuntime appRuntime) {
        this.app = appRuntime.getAppRuntime(getModuleId());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            FileProvider7Helper.intentCompatForN(this, intent);
        } catch (Exception e16) {
            QLog.e("AppService", 1, "startActivity", e16);
        }
        ThirdAppReportHelper.reportThirdAppOpen(this, intent, 0);
        super.startActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        ThirdAppReportHelper.reportThirdAppOpen(this, intent, 1);
        return super.startService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        super.sendBroadcast(intent, str);
        MobileQQ.sMobileQQ.onSendBroadcast(this, intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle) {
        super.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i3, str2, bundle);
        MobileQQ.sMobileQQ.onSendBroadcast(this, intent);
    }

    public void onAccountChanged() {
    }

    public void onAccoutChangeFailed() {
    }

    public void onConfigStartMode(Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLogout(Constants.LogoutReason logoutReason) {
    }
}
