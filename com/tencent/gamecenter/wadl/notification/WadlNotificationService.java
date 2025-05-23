package com.tencent.gamecenter.wadl.notification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlNotificationService extends Service {
    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        Log.i("WadlNotificationService", "onBind...intent=" + intent);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        QLog.i("WadlNotificationService", 1, "onCreate");
        WadlNotificationController.b().l(true);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        WadlNotificationController.b().l(false);
        QLog.i("WadlNotificationService", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        WadlCustomNotificationBuilder c16 = WadlNotificationController.b().c();
        QLog.i("WadlNotificationService", 1, "onStartCommand processName=" + MobileQQ.sMobileQQ.getQQProcessName() + ", intent=" + intent + ",flags=" + i3 + ",startId=" + i16 + ",notification=" + c16);
        if (c16 != null) {
            startForeground(NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN, c16.build());
            return 1;
        }
        QLog.w("WadlNotificationService", 1, "onStartCommand notification is null, stop service");
        stopForeground(true);
        WadlNotificationController.b().n();
        return 2;
    }
}
