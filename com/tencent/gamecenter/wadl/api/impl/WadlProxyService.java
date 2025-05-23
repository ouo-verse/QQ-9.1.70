package com.tencent.gamecenter.wadl.api.impl;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.sdk.app.WadlServiceReceiver;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask;
import com.tencent.gamecenter.wadl.sdk.ipc.WadlRemoteHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import jl0.b;
import mqq.app.MobileQQ;

/* loaded from: classes6.dex */
public class WadlProxyService extends Service implements Handler.Callback {

    /* renamed from: m, reason: collision with root package name */
    private static WadlProxyService f106644m;

    /* renamed from: h, reason: collision with root package name */
    private boolean f106648h;

    /* renamed from: d, reason: collision with root package name */
    private final long f106645d = 20000;

    /* renamed from: i, reason: collision with root package name */
    private b.a f106649i = new a();

    /* renamed from: f, reason: collision with root package name */
    private RemoteCallbackList<jl0.c> f106647f = new RemoteCallbackList<>();

    /* renamed from: e, reason: collision with root package name */
    protected Handler f106646e = new Handler(ThreadManagerV2.getQQCommonThreadLooper(), this);

    /* loaded from: classes6.dex */
    class a extends b.a {
        a() {
        }

        @Override // jl0.b
        public void L(jl0.c cVar) throws RemoteException {
            QLog.d("Wadl_WadlProxyService", 1, "unregisterCallback:" + cVar);
            WadlProxyService.this.f106647f.unregister(cVar);
        }

        @Override // jl0.b
        public void e2(WadlRequest wadlRequest) throws RemoteException {
            QLog.d("Wadl_WadlProxyService", 1, "receive action from client request=" + wadlRequest);
            Bundle bundle = wadlRequest.f106596h;
            if (bundle != null) {
                bundle.setClassLoader(getClass().getClassLoader());
            }
            Message obtainMessage = WadlProxyService.this.f106646e.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = wadlRequest;
            WadlProxyService.this.f106646e.sendMessage(obtainMessage);
        }

        @Override // jl0.b
        public void s3(jl0.c cVar) throws RemoteException {
            QLog.d("Wadl_WadlProxyService", 1, "registerCallback:" + cVar);
            WadlProxyService.this.f106647f.register(cVar);
        }
    }

    public WadlProxyService() {
        f106644m = this;
        QLog.d("Wadl_WadlProxyService", 1, "WadlRemoteService newInstance");
    }

    public static void b(ServiceConnection serviceConnection) {
        QLog.i("Wadl_WadlProxyService", 1, "bindWadlService connection=" + serviceConnection + ",processName=" + MobileQQ.processName);
        try {
            MobileQQ.sMobileQQ.bindService(new Intent(MobileQQ.sMobileQQ, (Class<?>) WadlProxyService.class), serviceConnection, 1);
        } catch (Exception e16) {
            QLog.e("Wadl_WadlProxyService", 1, "bindWadlService unbindService exception", e16);
        }
    }

    public static WadlProxyService c() {
        if (f106644m == null) {
            QLog.w("Wadl_WadlProxyService", 1, "getInstance, currService is null");
        }
        return f106644m;
    }

    private void e() {
        QLog.d("Wadl_WadlProxyService", 1, "notifyProcessCloseService...");
        i(WadlProxyConsts.REVERSE_STOP_MONITOR_CMD, null);
    }

    private void g() {
        i(WadlProxyConsts.REVERSE_HEART_CMD, null);
    }

    private void i(String str, Bundle bundle) {
        jl0.c cVar;
        RemoteException e16;
        if (this.f106648h) {
            return;
        }
        try {
            synchronized ("Wadl_WadlProxyService") {
                int beginBroadcast = this.f106647f.beginBroadcast();
                if (!WadlProxyConsts.REVERSE_HEART_CMD.equals(str)) {
                    QLog.d("Wadl_WadlProxyService", 1, "sendRemoteCommand cmd=" + str + ",mCallbackList size=" + beginBroadcast);
                }
                jl0.c cVar2 = null;
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    try {
                        cVar = this.f106647f.getBroadcastItem(i3);
                        try {
                            cVar.a(str, bundle);
                        } catch (RemoteException e17) {
                            e16 = e17;
                            QLog.e("Wadl_WadlProxyService", 1, "sendAsyncCommand RemoteException:" + e16 + ":" + cVar);
                            cVar2 = cVar;
                        }
                    } catch (RemoteException e18) {
                        cVar = cVar2;
                        e16 = e18;
                    }
                    cVar2 = cVar;
                }
                this.f106647f.finishBroadcast();
            }
        } catch (Throwable th5) {
            QLog.e("Wadl_WadlProxyService", 1, "sendAsyncCommand exception ", th5);
        }
    }

    public static void j(ServiceConnection serviceConnection) {
        QLog.i("Wadl_WadlProxyService", 1, "unbindWadlService connection=" + serviceConnection + ",processName=" + MobileQQ.processName);
        try {
            MobileQQ.sMobileQQ.unbindService(serviceConnection);
        } catch (Exception e16) {
            QLog.e("Wadl_WadlProxyService", 1, "unbindWadlService exception", e16);
        }
    }

    public void d() {
        QLog.d("Wadl_WadlProxyService", 1, "notifyProcessStartMonitor");
        i(WadlProxyConsts.REVERSE_START_MONITOR_CMD, null);
    }

    public void f(String str, Bundle bundle) {
        if (this.f106648h) {
            return;
        }
        bundle.putString(WadlProxyConsts.KEY_REMOTE_CMD, WadlProxyConsts.REVERSE_ACTION_CMD);
        bundle.putString(WadlProxyConsts.REVERSE_ACTION_CMD_NAME, str);
        Message obtainMessage = this.f106646e.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.setData(bundle);
        this.f106646e.sendMessage(obtainMessage);
    }

    public void h(int i3, WadlTask wadlTask) {
        int i16;
        if (wadlTask != null) {
            WadlParams wadlParams = wadlTask.mWadlParams;
            if (!wadlTask.bCallback()) {
                if (wadlParams != null) {
                    i16 = wadlParams.flags;
                } else {
                    i16 = -1;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Wadl_WadlProxyService", 4, "sendMessageToProxyService passed, appId=" + wadlTask.appId + ",flags=" + i16 + ",status=" + wadlTask.taskStatus);
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(WadlProxyConsts.PARAM_DOWNLOAD_RESULT, wadlTask.getWadlResult(i3));
            f(WadlProxyConsts.REMOTE_REVERSE_STATE_CHANGED, bundle);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    boolean isAnyTaskActive = WadlRemoteHandler.getInstance().isAnyTaskActive(false);
                    if (QLog.isColorLevel()) {
                        QLog.d("Wadl_WadlProxyService", 1, "handleMessage localHeart isAnyTaskActive=" + isAnyTaskActive);
                    }
                    if (!isAnyTaskActive) {
                        this.f106646e.removeMessages(3);
                        e();
                    } else {
                        g();
                        if (!this.f106646e.hasMessages(3)) {
                            this.f106646e.sendEmptyMessageDelayed(3, 20000L);
                        }
                    }
                }
            } else {
                WadlRequest wadlRequest = (WadlRequest) message.obj;
                if (wadlRequest != null) {
                    try {
                        WadlRemoteHandler.getInstance().handleRemoteActionNotify(wadlRequest);
                        d();
                        this.f106646e.sendEmptyMessageDelayed(3, 20000L);
                    } catch (Throwable th5) {
                        QLog.e("Wadl_WadlProxyService", 1, "handleMessage exception", th5);
                    }
                }
            }
        } else {
            Bundle data = message.getData();
            if (data != null) {
                i(data.getString(WadlProxyConsts.KEY_REMOTE_CMD), data);
            }
        }
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        QLog.i("Wadl_WadlProxyService", 1, "onBind...");
        return this.f106649i;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        QLog.i("Wadl_WadlProxyService", 1, "onCreate...");
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.WadlProxyService.2
                @Override // java.lang.Runnable
                public void run() {
                    WadlRemoteHandler.getInstance().onCreate();
                }
            }, 32, null, true);
        } else {
            WadlRemoteHandler.getInstance().onCreate();
        }
        WadlServiceReceiver.getInstance().registerReceiver();
    }

    @Override // android.app.Service
    public void onDestroy() {
        QLog.d("Wadl_WadlProxyService", 1, "onDestroy...");
        this.f106648h = true;
        this.f106647f.kill();
        this.f106646e.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        QLog.i("Wadl_WadlProxyService", 1, "onStartCommand...");
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        QLog.d("Wadl_WadlProxyService", 1, "onTaskRemoved...");
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        QLog.i("Wadl_WadlProxyService", 1, "onUnbind...");
        return super.onUnbind(intent);
    }
}
