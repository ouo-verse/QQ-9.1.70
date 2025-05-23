package cooperation.qqindividuality.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qqindividuality.ipc.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

/* loaded from: classes28.dex */
public class QQIndividualityRemoteProxy {

    /* renamed from: d, reason: collision with root package name */
    protected WeakReference<AppRuntime> f390748d;

    /* renamed from: a, reason: collision with root package name */
    public final String f390745a = "QQIndividualityRemoteProxy";

    /* renamed from: b, reason: collision with root package name */
    public final String f390746b = "com.qqindividuality.ipc.QQIndividualityRemoteProxyService";

    /* renamed from: c, reason: collision with root package name */
    protected boolean f390747c = false;

    /* renamed from: e, reason: collision with root package name */
    protected cooperation.qqindividuality.ipc.a f390749e = null;

    /* renamed from: f, reason: collision with root package name */
    protected ConcurrentLinkedQueue<a> f390750f = new ConcurrentLinkedQueue<>();

    /* renamed from: g, reason: collision with root package name */
    protected HashSet<String> f390751g = new HashSet<>();

    /* renamed from: h, reason: collision with root package name */
    private ServiceConnection f390752h = new ServiceConnection() { // from class: cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            QQIndividualityRemoteProxy.this.f390749e = a.AbstractBinderC10117a.j(iBinder);
            if (QQIndividualityRemoteProxy.this.f390749e != null) {
                BaseThread baseThread = new BaseThread() { // from class: cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2.1
                    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                    public void run() {
                        while (!QQIndividualityRemoteProxy.this.f390750f.isEmpty()) {
                            a poll = QQIndividualityRemoteProxy.this.f390750f.poll();
                            if (poll != null) {
                                QQIndividualityRemoteProxy.this.f(poll);
                            }
                        }
                    }
                };
                baseThread.setName("QfavRemoteProxyForQQ.remoteProxyCallThread");
                baseThread.start();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            QQIndividualityRemoteProxy qQIndividualityRemoteProxy = QQIndividualityRemoteProxy.this;
            qQIndividualityRemoteProxy.f390749e = null;
            qQIndividualityRemoteProxy.f390747c = false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes28.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f390755a;

        /* renamed from: b, reason: collision with root package name */
        public Bundle f390756b;

        a(int i3, Bundle bundle) {
            this.f390755a = i3;
            this.f390756b = bundle;
        }
    }

    public QQIndividualityRemoteProxy(AppRuntime appRuntime) {
        this.f390748d = null;
        this.f390748d = new WeakReference<>(appRuntime);
        a("qqindividuality_signature");
    }

    private boolean b(a aVar) {
        return this.f390750f.add(aVar);
    }

    private boolean d() {
        WeakReference<AppRuntime> weakReference;
        AppRuntime appRuntime;
        if (this.f390749e == null && !this.f390747c && (weakReference = this.f390748d) != null && (appRuntime = weakReference.get()) != null) {
            QQIndividualityPluginProxyService.a(appRuntime, this.f390752h, "com.qqindividuality.ipc.QQIndividualityRemoteProxyService");
            this.f390747c = true;
            return true;
        }
        return false;
    }

    private boolean e() {
        WeakReference<AppRuntime> weakReference;
        AppRuntime appRuntime;
        if (this.f390749e != null && (weakReference = this.f390748d) != null && (appRuntime = weakReference.get()) != null) {
            QQIndividualityPluginProxyService.f(appRuntime, this.f390752h);
            this.f390749e = null;
            this.f390747c = false;
            return true;
        }
        return true;
    }

    public boolean a(String str) {
        if (!this.f390751g.contains(str)) {
            this.f390751g.add(str);
            return true;
        }
        return false;
    }

    public boolean c(String str, int i3, Bundle bundle) {
        if (this.f390751g.contains(str)) {
            a aVar = new a(i3, bundle);
            if (this.f390749e != null) {
                f(aVar);
                return true;
            }
            b(aVar);
            d();
            return true;
        }
        return false;
    }

    public void f(final a aVar) {
        if (this.f390749e != null && aVar != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (Thread.currentThread() != mainLooper.getThread()) {
                new Handler(mainLooper).post(new Runnable() { // from class: cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQIndividualityRemoteProxy.this.f(aVar);
                    }
                });
            } else {
                try {
                    this.f390749e.c(aVar.f390755a, aVar.f390756b);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public boolean g(String str) {
        if (this.f390751g.contains(str)) {
            this.f390751g.remove(str);
            if (this.f390751g.isEmpty()) {
                e();
                return false;
            }
            return false;
        }
        return false;
    }
}
