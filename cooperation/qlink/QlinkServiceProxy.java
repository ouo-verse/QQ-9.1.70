package cooperation.qlink;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qlink.a;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

/* loaded from: classes28.dex */
public class QlinkServiceProxy {

    /* renamed from: a, reason: collision with root package name */
    private AppRuntime f390446a;

    /* renamed from: c, reason: collision with root package name */
    private volatile cooperation.qlink.a f390448c;

    /* renamed from: b, reason: collision with root package name */
    private Object f390447b = new Object();

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentLinkedQueue<SendMsg> f390449d = new ConcurrentLinkedQueue<>();

    /* renamed from: e, reason: collision with root package name */
    private volatile long f390450e = -1;

    /* renamed from: f, reason: collision with root package name */
    private boolean f390451f = false;

    /* renamed from: g, reason: collision with root package name */
    private ServiceConnection f390452g = new a();

    /* loaded from: classes28.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            QLog.d("QlinkServiceProxy", 1, "onServiceConnected service:" + componentName);
            QlinkServiceProxy.this.f390448c = a.AbstractBinderC10106a.j(iBinder);
            QlinkServiceProxy.this.f390451f = false;
            QlinkServiceProxy.this.j();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            QLog.d("QlinkServiceProxy", 1, "onServiceDisconnected " + componentName);
            try {
                QlinkServiceProxy.this.f390446a.getApplication().unbindService(QlinkServiceProxy.this.f390452g);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            QlinkServiceProxy.this.f390448c = null;
            QlinkServiceProxy.this.f390451f = false;
        }
    }

    public QlinkServiceProxy(AppRuntime appRuntime) {
        this.f390446a = appRuntime;
    }

    private void h(SendMsg sendMsg) {
        this.f390449d.add(sendMsg);
    }

    private boolean i() {
        if (this.f390448c != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        BaseThread baseThread = new BaseThread() { // from class: cooperation.qlink.QlinkServiceProxy.2
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                while (!QlinkServiceProxy.this.f390449d.isEmpty()) {
                    SendMsg sendMsg = (SendMsg) QlinkServiceProxy.this.f390449d.poll();
                    if (sendMsg != null) {
                        try {
                            QlinkServiceProxy.this.l(sendMsg);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            }
        };
        baseThread.setName("handleWaitSendProxyMsgThread");
        baseThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(SendMsg sendMsg) throws RemoteException {
        this.f390448c.U(sendMsg);
    }

    public void k(SendMsg sendMsg) {
        try {
            synchronized (this.f390447b) {
                if (i()) {
                    l(sendMsg);
                } else if (this.f390451f) {
                    h(sendMsg);
                } else {
                    this.f390451f = true;
                    h(sendMsg);
                    m();
                }
            }
        } catch (DeadObjectException unused) {
            h(sendMsg);
        } catch (Exception e16) {
            if (this.f390448c == null) {
                h(sendMsg);
            } else {
                e16.printStackTrace();
            }
        }
    }

    public void m() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f390450e != -1 && currentTimeMillis - this.f390450e <= 10000) {
            QLog.d("QlinkServiceProxy", 1, "wait start qlink service result, skiped...");
        } else {
            this.f390450e = currentTimeMillis;
            QlinkPluginProxyService.a(this.f390446a, this.f390452g);
        }
    }
}
