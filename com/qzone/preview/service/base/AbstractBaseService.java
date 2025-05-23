package com.qzone.preview.service.base;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.qzone.app.QZoneAppInterface;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.remote.IServiceHandler;
import cooperation.qzone.remote.SendMsg;
import cooperation.qzone.util.QZLog;
import java.util.List;
import mqq.app.AppService;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class AbstractBaseService extends AppService {
    protected static final String TAG = "AbstractBaseService";
    IServiceHandler.Stub mBinder = new a();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends IServiceHandler.Stub {
        a() {
        }

        @Override // cooperation.qzone.remote.IServiceHandler
        public void sendMsg(SendMsg sendMsg) throws RemoteException {
            AbstractBaseService.this.handleRequest(sendMsg);
        }
    }

    private boolean isForeground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses == null) {
            QLog.e(TAG, 1, "[isForeground] error: ", new NullPointerException());
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                if (runningAppProcessInfo.importance != 100) {
                    QLog.d(TAG, 1, "\u5904\u4e8e\u540e\u53f0\uff0c\u4e0d\u5f00\u542f\u9884\u626b\u63cf");
                    return false;
                }
                QLog.d(TAG, 1, "\u5904\u4e8e\u524d\u53f0\uff0c\u5f00\u542f\u9884\u626b\u63cf");
                return true;
            }
        }
        return false;
    }

    private boolean needPreload(String str) {
        return QZoneHelper.ACTION_PRELOAD_FRIEND_FEEDS.equals(str) || QZoneHelper.ACTION_PRELOAD_USER_HOME.equals(str) || "com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS".equals(str) || QZoneHelper.ACTION_PRELOAD_QCIRCLE_PUBLISH.equals(str);
    }

    public abstract void handleRequest(SendMsg sendMsg);

    @Override // mqq.app.AppService, android.app.Service
    public IBinder onBind(Intent intent) {
        if (QZLog.isDevelopLevel()) {
            QZLog.d(TAG, 4, "onBind");
        }
        return this.mBinder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppService
    public int onConfigRuntime() {
        return 1;
    }

    @Override // mqq.app.AppService, android.app.Service
    public final void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (QZLog.isDevelopLevel()) {
            QZLog.d(TAG, 4, "onUnbind");
        }
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        if (intent != null) {
            String action = intent.getAction();
            QLog.d(TAG, 1, "\u7a7a\u95f4\u5f00\u59cb\u5c1d\u8bd5\u9884\u626b\u63cf");
            if (QZLog.isColorLevel()) {
                QZLog.d(TAG, 2, "onStartCommand--action:" + action);
            }
            if (QZoneHelper.ACTION_CANCEL_QZONE_ALVIE.equals(action)) {
                QZoneAppInterface.keepAlive = false;
            }
        }
        return 2;
    }
}
