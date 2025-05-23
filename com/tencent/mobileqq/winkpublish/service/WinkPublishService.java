package com.tencent.mobileqq.winkpublish.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.winkpublish.api.IWinkPublishService;
import com.tencent.mobileqq.winkpublish.service.WinkPublishService;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes35.dex */
public class WinkPublishService extends Service {

    /* renamed from: d, reason: collision with root package name */
    private final IWinkPublishService.Stub f327397d = new b();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b() {
        try {
            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).initialize();
        } catch (Exception e16) {
            QLog.e("WinkPublishService", 1, "[initialize] error: " + e16.getMessage(), e16);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QLog.i("WinkPublishService", 1, "[onConfigurationChanged]");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        QLog.i("WinkPublishService", 1, "[onCreate]");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        QLog.i("WinkPublishService", 1, "[onDestroy]");
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        QLog.i("WinkPublishService", 1, "[onLowMemory]");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i3) {
        super.onStart(intent, i3);
        QLog.i("WinkPublishService", 1, "[onStart]");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        QLog.i("WinkPublishService", 1, "[onStartCommand] flags=" + i3 + ", startId=" + i16);
        return super.onStartCommand(intent, i3, i16);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
        if (i3 == 80) {
            QLog.i("WinkPublishService", 1, "[onTrimMemory]");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        QLog.i("WinkPublishService", 1, "[onBind]");
        ThreadManagerV2.excute(new Runnable() { // from class: xa3.a
            @Override // java.lang.Runnable
            public final void run() {
                WinkPublishService.b();
            }
        }, 16, null, false);
        return this.f327397d;
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        QLog.i("WinkPublishService", 1, "[onRebind]");
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        QLog.i("WinkPublishService", 1, "[onTaskRemoved]");
        super.onTaskRemoved(intent);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        QLog.i("WinkPublishService", 1, "[onUnbind]");
        return super.onUnbind(intent);
    }
}
