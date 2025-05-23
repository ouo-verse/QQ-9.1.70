package com.tencent.thumbplayer.core.datatransport.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;

/* loaded from: classes26.dex */
public class TPDataTransportRemoteService extends Service {
    private final ITPDataTransportLog mLogger = TPDataTransportLogFactory.getInstance().getLogger("TPDataTransportRemoteService");
    private ITPDataTransportRemoteBridge mRemoteBridge = null;
    private int pid = -1;

    private boolean isExistMainProcess() {
        int i3;
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                String str = runningAppProcessInfo.processName;
                if (!TextUtils.isEmpty(str) && str.equals(getPackageName())) {
                    int i16 = this.pid;
                    if (i16 != -1 && i16 != (i3 = runningAppProcessInfo.pid)) {
                        this.pid = i3;
                        return false;
                    }
                    this.pid = runningAppProcessInfo.pid;
                    this.mLogger.i("app main exist!");
                    return true;
                }
            }
        } catch (Throwable th5) {
            this.mLogger.e("isExistMainProcess failed, error:" + th5);
        }
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.mRemoteBridge = new TPDataTransportRemoteBridgeImpl();
        this.mLogger.i("on bind");
        return this.mRemoteBridge.asBinder();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        this.mLogger.i("on rebind");
        isExistMainProcess();
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        this.mLogger.i("on start command");
        super.onStartCommand(intent, i3, i16);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        this.mLogger.i("on unbind");
        super.onUnbind(intent);
        if (!isExistMainProcess()) {
            try {
                TPDownloadProxyNative.getInstance().stopAllDownload(3);
                TPDataTransportTaskListenerMgr.getInstance().removeAllTaskListener();
                return true;
            } catch (Throwable th5) {
                this.mLogger.i("on unbind failed, error:" + th5);
                return true;
            }
        }
        return true;
    }
}
