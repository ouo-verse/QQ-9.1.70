package cooperation.qappcenter.remote;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.plugin.IPluginManager;
import cooperation.qappcenter.QAppCenterPluginProxyService;
import cooperation.qappcenter.remote.b;
import cooperation.qzone.remote.ServiceConst;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes28.dex */
public class RemoteServiceProxy {

    /* renamed from: i, reason: collision with root package name */
    protected static ConcurrentHashMap<String, RemoteServiceProxy> f390379i = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    protected volatile b f390380a;

    /* renamed from: e, reason: collision with root package name */
    private String f390384e;

    /* renamed from: f, reason: collision with root package name */
    private cooperation.qappcenter.remote.a f390385f;

    /* renamed from: g, reason: collision with root package name */
    private String f390386g;

    /* renamed from: b, reason: collision with root package name */
    protected Object f390381b = new Object();

    /* renamed from: c, reason: collision with root package name */
    protected ConcurrentLinkedQueue<SendMsg> f390382c = new ConcurrentLinkedQueue<>();

    /* renamed from: d, reason: collision with root package name */
    protected volatile long f390383d = -1;

    /* renamed from: h, reason: collision with root package name */
    protected ServiceConnection f390387h = new a();

    /* loaded from: classes28.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (QLog.isColorLevel()) {
                QLog.d("RemoteServiceProxy", 2, " onServiceConnected service:" + componentName + ",mActionListener:" + RemoteServiceProxy.this.f390385f);
            }
            RemoteServiceProxy.this.f390380a = b.a.j(iBinder);
            if (RemoteServiceProxy.this.f390385f != null) {
                SendMsg sendMsg = new SendMsg(ServiceConst.CMD_REGISTER_LISTENER);
                sendMsg.f390395m = RemoteServiceProxy.this.f390385f;
                RemoteServiceProxy.this.h(sendMsg);
            }
            RemoteServiceProxy.this.f();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (QLog.isColorLevel()) {
                QLog.d("RemoteServiceProxy", 2, " onServiceDisconnected " + componentName + ",mActionListener:" + RemoteServiceProxy.this.f390385f);
            }
            RemoteServiceProxy.this.f390380a = null;
        }
    }

    public RemoteServiceProxy(String str, String str2) {
        this.f390384e = str;
        this.f390386g = str2;
    }

    public static synchronized RemoteServiceProxy e(String str) {
        RemoteServiceProxy remoteServiceProxy;
        synchronized (RemoteServiceProxy.class) {
            if (f390379i.get(str) == null) {
                f390379i.put(str, new RemoteServiceProxy(null, str));
            }
            remoteServiceProxy = f390379i.get(str);
        }
        return remoteServiceProxy;
    }

    protected void b(SendMsg sendMsg) {
        this.f390382c.add(sendMsg);
    }

    protected RecvMsg c(SendMsg sendMsg, String str) {
        RecvMsg recvMsg = new RecvMsg(sendMsg.b(), sendMsg.c());
        recvMsg.c(1002, str);
        return recvMsg;
    }

    protected boolean d() {
        if (this.f390380a != null) {
            return true;
        }
        return false;
    }

    protected void f() {
        BaseThread baseThread = new BaseThread() { // from class: cooperation.qappcenter.remote.RemoteServiceProxy.2
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                while (!RemoteServiceProxy.this.f390382c.isEmpty()) {
                    SendMsg poll = RemoteServiceProxy.this.f390382c.poll();
                    if (poll != null) {
                        try {
                            RemoteServiceProxy.this.i(poll);
                        } catch (Exception e16) {
                            RemoteServiceProxy.this.g(poll, RemoteServiceProxy.this.c(poll, "sendMsgToServiceFailed\uff0c" + e16.toString()));
                        }
                    }
                }
            }
        };
        baseThread.setName("handleWaitSendProxyMsgThread");
        baseThread.start();
    }

    protected void g(SendMsg sendMsg, RecvMsg recvMsg) {
        try {
            if (sendMsg.a() != null) {
                sendMsg.a().X4(recvMsg);
            } else {
                cooperation.qappcenter.remote.a aVar = this.f390385f;
                if (aVar != null) {
                    aVar.X4(recvMsg);
                }
            }
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public void h(SendMsg sendMsg) {
        try {
            synchronized (this.f390381b) {
                if (d()) {
                    i(sendMsg);
                } else {
                    b(sendMsg);
                    k();
                }
            }
        } catch (DeadObjectException unused) {
            b(sendMsg);
        } catch (Exception e16) {
            if (this.f390380a == null) {
                b(sendMsg);
            } else {
                e16.printStackTrace();
            }
        }
    }

    protected void i(final SendMsg sendMsg) throws RemoteException {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            ThreadManagerV2.post(new Runnable() { // from class: cooperation.qappcenter.remote.RemoteServiceProxy.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (RemoteServiceProxy.this.f390380a != null) {
                            RemoteServiceProxy.this.f390380a.F4(sendMsg);
                        } else {
                            try {
                                RemoteServiceProxy.this.g(sendMsg, RemoteServiceProxy.this.c(sendMsg, "main thread sendMsgToServiceFailed. serviceHandler is null."));
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                    }
                }
            }, 10, null, false);
        } else {
            this.f390380a.F4(sendMsg);
        }
    }

    void j() {
        try {
            Intent intent = new Intent(BaseApplicationImpl.getApplication(), (Class<?>) QAppCenterPluginProxyService.class);
            IPluginManager.i iVar = new IPluginManager.i(1);
            iVar.f390198d = "qappcenter_plugin.apk";
            iVar.f390201g = HardCodeUtil.qqStr(R.string.t0b);
            iVar.f390197c = this.f390386g;
            if (TextUtils.isEmpty(this.f390384e)) {
                iVar.f390202h = "com.tencent.plugin.qappcenter.remote.RemoteService";
            } else {
                iVar.f390202h = this.f390384e;
            }
            iVar.f390204j = intent;
            iVar.f390209o = this.f390387h;
            IPluginManager.A5(BaseApplicationImpl.getApplication(), iVar);
            if (QLog.isColorLevel()) {
                QLog.d("RemoteServiceProxy", 2, " start service finish");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void k() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f390383d != -1 && currentTimeMillis - this.f390383d <= 1000) {
            if (QLog.isColorLevel()) {
                QLog.d("RemoteServiceProxy", 2, "wait start " + this.f390384e + " service result, skiped...");
                return;
            }
            return;
        }
        this.f390383d = currentTimeMillis;
        j();
    }
}
