package com.qzone.album.business.downloader;

import android.os.Handler;
import android.os.Message;
import com.qzone.util.al;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DownloadQueue implements Handler.Callback, NetworkState.NetworkStateListener {

    /* renamed from: i, reason: collision with root package name */
    private static final al<DownloadQueue, Void> f42399i = new a();

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<WeakReference<b>> f42401e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private Runnable f42402f = new Runnable() { // from class: com.qzone.album.business.downloader.DownloadQueue.2
        @Override // java.lang.Runnable
        public void run() {
            DownloadQueue.this.E();
        }
    };

    /* renamed from: h, reason: collision with root package name */
    private Runnable f42403h = new Runnable() { // from class: com.qzone.album.business.downloader.DownloadQueue.3
        @Override // java.lang.Runnable
        public void run() {
            if (NetworkState.isWifiConn()) {
                return;
            }
            DownloadQueue.this.A();
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private Handler f42400d = new Handler(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getLooper(), this);

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<DownloadQueue, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DownloadQueue a(Void r16) {
            return new DownloadQueue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void a();
    }

    DownloadQueue() {
        NetworkState.addListener(this);
    }

    private boolean F() {
        return DownloadTaskManager.i().y();
    }

    private List<b> c() {
        ArrayList arrayList;
        synchronized (this.f42401e) {
            arrayList = null;
            if (this.f42401e.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<WeakReference<b>> it = this.f42401e.iterator();
                while (it.hasNext()) {
                    WeakReference<b> next = it.next();
                    b bVar = next == null ? null : next.get();
                    if (bVar != null) {
                        arrayList2.add(bVar);
                    }
                }
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    public static DownloadQueue j() {
        return f42399i.get(null);
    }

    private void o(Message message) {
        IDownloadQueueTask iDownloadQueueTask = (IDownloadQueueTask) message.obj;
        if (iDownloadQueueTask == null) {
            return;
        }
        iDownloadQueueTask.setTaskId(System.currentTimeMillis());
        DownloadTaskManager.i().a(iDownloadQueueTask);
        F();
        n();
    }

    private void p(Message message) {
        IDownloadQueueTask iDownloadQueueTask = (IDownloadQueueTask) message.obj;
        if (iDownloadQueueTask == null) {
            return;
        }
        DownloadTaskManager.i().c(iDownloadQueueTask, message.arg1 == 1);
        F();
        n();
    }

    private void q() {
        DownloadTaskManager.i().d();
        F();
        n();
    }

    private void r() {
        DownloadTaskManager.i().e();
        F();
        n();
    }

    private void s() {
        DownloadTaskManager.i().p();
        n();
    }

    private void t() {
        DownloadTaskManager.i().q();
        n();
    }

    private void u(Message message) {
        IDownloadQueueTask iDownloadQueueTask = (IDownloadQueueTask) message.obj;
        if (iDownloadQueueTask == null) {
            return;
        }
        DownloadTaskManager.i().r(iDownloadQueueTask);
        n();
    }

    private void v() {
        DownloadTaskManager.i().s();
        n();
    }

    private void w(Message message) {
        IDownloadQueueTask iDownloadQueueTask = (IDownloadQueueTask) message.obj;
        if (iDownloadQueueTask == null) {
            return;
        }
        DownloadTaskManager.i().t(iDownloadQueueTask);
        F();
        n();
    }

    private void x() {
        if (DownloadTaskManager.i().v()) {
            this.f42400d.removeCallbacks(this.f42402f);
            this.f42400d.postDelayed(this.f42402f, 3000L);
        }
        QZLog.i("[DownloadQueue]", 1, "onRestore taskList size:" + k());
        n();
    }

    private void y() {
        DownloadTaskManager.i().w();
        F();
        n();
    }

    private void z(Message message) {
        IDownloadQueueTask iDownloadQueueTask = (IDownloadQueueTask) message.obj;
        if (iDownloadQueueTask == null) {
            return;
        }
        DownloadTaskManager.i().x(iDownloadQueueTask);
        F();
        n();
    }

    public void A() {
        Message obtain = Message.obtain();
        obtain.what = 8;
        this.f42400d.sendMessage(obtain);
    }

    public void B() {
        Message obtain = Message.obtain();
        obtain.what = 12;
        this.f42400d.sendMessage(obtain);
    }

    public void C() {
        Message obtain = Message.obtain();
        obtain.what = 7;
        this.f42400d.sendMessage(obtain);
    }

    public void D() {
        Message obtain = Message.obtain();
        obtain.what = 5;
        this.f42400d.sendMessage(obtain);
    }

    public void E() {
        Message obtain = Message.obtain();
        obtain.what = 9;
        this.f42400d.sendMessage(obtain);
    }

    public void e() {
        Message obtain = Message.obtain();
        obtain.what = 10;
        this.f42400d.sendMessage(obtain);
    }

    public void f() {
        Message obtain = Message.obtain();
        obtain.what = 11;
        this.f42400d.sendMessage(obtain);
    }

    public int g() {
        return DownloadTaskManager.i().f();
    }

    public int h() {
        return DownloadTaskManager.i().g();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                o(message);
                return false;
            case 2:
                u(message);
                return false;
            case 3:
                z(message);
                return false;
            case 4:
                w(message);
                return false;
            case 5:
                x();
                return false;
            case 6:
                p(message);
                return false;
            case 7:
                v();
                return false;
            case 8:
                s();
                return false;
            case 9:
                y();
                return false;
            case 10:
                q();
                return false;
            case 11:
                r();
                return false;
            case 12:
                t();
                return false;
            default:
                return false;
        }
    }

    public int i() {
        return DownloadTaskManager.i().h();
    }

    public int k() {
        return DownloadTaskManager.i().k();
    }

    public boolean l() {
        return DownloadTaskManager.i().l();
    }

    public boolean m() {
        return DownloadTaskManager.i().m();
    }

    public void n() {
        List<b> c16 = c();
        if (c16 != null) {
            for (b bVar : c16) {
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.f42401e) {
            Iterator<WeakReference<b>> it = this.f42401e.iterator();
            while (it.hasNext()) {
                b bVar2 = it.next().get();
                if (bVar2 == null) {
                    it.remove();
                } else if (bVar2 == bVar) {
                    return;
                }
            }
            this.f42401e.add(new WeakReference<>(bVar));
        }
    }

    public void b(IDownloadQueueTask iDownloadQueueTask) {
        if (iDownloadQueueTask == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = iDownloadQueueTask;
        this.f42400d.sendMessage(obtain);
    }

    public void d(IDownloadQueueTask iDownloadQueueTask, boolean z16) {
        if (iDownloadQueueTask == null) {
            QZLog.i("[DownloadQueue]", 1, "completeTask null");
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.arg1 = z16 ? 1 : 0;
        obtain.obj = iDownloadQueueTask;
        this.f42400d.sendMessage(obtain);
    }

    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean z16) {
        if (z16 && NetworkState.isWifiConn()) {
            this.f42400d.removeCallbacks(this.f42402f);
            this.f42400d.postDelayed(this.f42402f, 2000L);
        }
        if (z16 && !NetworkState.isWifiConn()) {
            this.f42400d.removeCallbacks(this.f42403h);
            this.f42400d.postDelayed(this.f42403h, 2000L);
        }
        if (z16) {
            return;
        }
        this.f42400d.removeCallbacks(this.f42403h);
        this.f42400d.postDelayed(this.f42403h, 2000L);
    }
}
