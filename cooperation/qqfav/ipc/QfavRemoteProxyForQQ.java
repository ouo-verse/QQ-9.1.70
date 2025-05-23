package cooperation.qqfav.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qqfav.QfavPluginProxyService;
import cooperation.qqfav.ipc.c;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

/* loaded from: classes28.dex */
public class QfavRemoteProxyForQQ {

    /* renamed from: c, reason: collision with root package name */
    protected WeakReference<AppRuntime> f390643c;

    /* renamed from: a, reason: collision with root package name */
    public final String f390641a = "QfavRemoteProxyForQQ";

    /* renamed from: b, reason: collision with root package name */
    protected boolean f390642b = false;

    /* renamed from: d, reason: collision with root package name */
    protected c f390644d = null;

    /* renamed from: e, reason: collision with root package name */
    protected ConcurrentLinkedQueue<a> f390645e = new ConcurrentLinkedQueue<>();

    /* renamed from: f, reason: collision with root package name */
    protected HashSet<String> f390646f = new HashSet<>();

    /* renamed from: g, reason: collision with root package name */
    private ServiceConnection f390647g = new ServiceConnection() { // from class: cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            QfavRemoteProxyForQQ.this.f390644d = c.a.j(iBinder);
            if (QfavRemoteProxyForQQ.this.f390644d != null) {
                BaseThread baseThread = new BaseThread() { // from class: cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2.1
                    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                    public void run() {
                        while (!QfavRemoteProxyForQQ.this.f390645e.isEmpty()) {
                            a poll = QfavRemoteProxyForQQ.this.f390645e.poll();
                            if (poll != null) {
                                QfavRemoteProxyForQQ.this.f(poll);
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
            QfavRemoteProxyForQQ qfavRemoteProxyForQQ = QfavRemoteProxyForQQ.this;
            qfavRemoteProxyForQQ.f390644d = null;
            qfavRemoteProxyForQQ.f390642b = false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes28.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f390650a;

        /* renamed from: b, reason: collision with root package name */
        public Bundle f390651b;

        a(int i3, Bundle bundle) {
            this.f390650a = i3;
            this.f390651b = bundle;
        }
    }

    public QfavRemoteProxyForQQ(AppRuntime appRuntime) {
        this.f390643c = null;
        this.f390643c = new WeakReference<>(appRuntime);
        b("com.tencent.qqfav");
    }

    private boolean c(a aVar) {
        return this.f390645e.add(aVar);
    }

    private boolean e() {
        WeakReference<AppRuntime> weakReference;
        AppRuntime appRuntime;
        if (this.f390644d == null && !this.f390642b && (weakReference = this.f390643c) != null && (appRuntime = weakReference.get()) != null) {
            QfavPluginProxyService.a(appRuntime, this.f390647g, "com.qqfav.ipc.QfavRemoteProxyService");
            this.f390642b = true;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final a aVar) {
        if (this.f390644d != null && aVar != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (Thread.currentThread() != mainLooper.getThread()) {
                new Handler(mainLooper).post(new Runnable() { // from class: cooperation.qqfav.ipc.QfavRemoteProxyForQQ.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QfavRemoteProxyForQQ.this.f(aVar);
                    }
                });
            } else {
                try {
                    this.f390644d.c(aVar.f390650a, aVar.f390651b);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public boolean b(String str) {
        if (!this.f390646f.contains(str)) {
            this.f390646f.add(str);
            e();
            return true;
        }
        return false;
    }

    public boolean d(String str, int i3, Bundle bundle) {
        if (this.f390646f.contains(str)) {
            a aVar = new a(i3, bundle);
            if (this.f390644d != null) {
                f(aVar);
                return true;
            }
            c(aVar);
            e();
            return true;
        }
        return false;
    }
}
