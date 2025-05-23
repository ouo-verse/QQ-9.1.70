package com.tencent.mobileqq.listentogether.player;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class g implements e {

    /* renamed from: a, reason: collision with root package name */
    private Messenger f241109a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<com.tencent.mobileqq.listentogether.player.b> f241110b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<c> f241111c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<f> f241112d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<d> f241113e;

    /* renamed from: f, reason: collision with root package name */
    private Messenger f241114f;

    /* renamed from: g, reason: collision with root package name */
    private Context f241115g;

    /* renamed from: h, reason: collision with root package name */
    private AppRuntime f241116h;

    /* renamed from: i, reason: collision with root package name */
    private b f241117i;

    /* renamed from: j, reason: collision with root package name */
    private final AtomicInteger f241118j = new AtomicInteger(-1);

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f241119k = false;

    /* renamed from: l, reason: collision with root package name */
    private ServiceConnection f241120l = new a();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (QLog.isColorLevel()) {
                QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format(" --->onServiceConnected %s", componentName));
            }
            if (g.this.f241109a != null) {
                g.this.f241114f = new Messenger(iBinder);
                Message obtain = Message.obtain((Handler) null, 1);
                obtain.setData(new Bundle());
                obtain.replyTo = g.this.f241109a;
                try {
                    g.this.f241114f.send(obtain);
                } catch (RemoteException e16) {
                    QLog.i("QQMusicPlay.QQMusicPlayClient", 1, "onServiceConnected sendToService exception===>", e16);
                } catch (Throwable th5) {
                    QLog.i("QQMusicPlay.QQMusicPlayClient", 1, "onServiceConnected sendToService Throwable===>", th5);
                }
                synchronized (g.this) {
                    g.this.f241118j.set(1);
                }
                g gVar = g.this;
                gVar.t(gVar.f241118j.get());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (g.this) {
                g.this.f241118j.set(-1);
            }
            g.this.f241114f = null;
            g gVar = g.this;
            gVar.t(gVar.f241118j.get());
            if (QLog.isColorLevel()) {
                QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->onServiceDisconnected %s", componentName));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<g> f241122a;

        b(g gVar, Looper looper) {
            super(looper);
            this.f241122a = new WeakReference<>(gVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            g gVar = this.f241122a.get();
            if (gVar == null) {
                super.handleMessage(message);
                return;
            }
            int i3 = message.what;
            if (i3 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->handleMessage[MSG_FROM_SERVICE]");
                    return;
                }
                return;
            }
            if (i3 == 15) {
                Bundle data = message.getData();
                int i16 = data.getInt("key_position", -1);
                int i17 = data.getInt("key_duration", -1);
                String string = data.getString("key_id");
                if ((i16 <= 0 || i17 <= 0) && QLog.isColorLevel()) {
                    QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_PROGRESS_CHANGE] [%d/%d] %s", Integer.valueOf(i16), Integer.valueOf(i17), string));
                }
                gVar.y(string, i16, i17);
                return;
            }
            if (i3 == 2) {
                Bundle data2 = message.getData();
                String string2 = data2.getString("key_id");
                int i18 = data2.getInt("key_play_state", -1);
                if (QLog.isColorLevel()) {
                    QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_PLAY_STATE_CHANGE] %s %s", string2, com.tencent.mobileqq.listentogether.player.a.a(i18)));
                }
                gVar.x(string2, i18);
                if (i18 == 4 && gVar.f241119k) {
                    gVar.s();
                    return;
                }
                return;
            }
            if (i3 == 3) {
                boolean z16 = message.getData().getBoolean("key_net_state", false);
                if (QLog.isColorLevel()) {
                    QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_NET_STATE_CHANGE] %b", Boolean.valueOf(z16)));
                }
                gVar.v(z16);
                return;
            }
            if (i3 == 4) {
                Bundle data3 = message.getData();
                boolean z17 = data3.getBoolean("key_focus_state", false);
                boolean z18 = data3.getBoolean("key_focus_transient", false);
                if (QLog.isColorLevel()) {
                    QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_FOCUS_STATE_CHANGE] %b_%b", Boolean.valueOf(z17), Boolean.valueOf(z18)));
                }
                gVar.u(z17, z18);
                return;
            }
            if (i3 != 5) {
                super.handleMessage(message);
                return;
            }
            Bundle data4 = message.getData();
            data4.setClassLoader(ISong.class.getClassLoader());
            ISong iSong = (ISong) data4.getParcelable("key_song");
            if (QLog.isColorLevel()) {
                QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_PLAY_SONG_CHANGE] %s", iSong.getId()));
            }
            gVar.w(iSong);
        }
    }

    public g(Context context, AppRuntime appRuntime) {
        this.f241115g = context;
        this.f241116h = appRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s() {
        int i3;
        if (this.f241119k) {
            if (QLog.isColorLevel()) {
                QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->doDestroy");
            }
            b bVar = this.f241117i;
            if (bVar != null) {
                bVar.getLooper().quit();
                this.f241117i = null;
            }
            this.f241109a = null;
            try {
                try {
                    this.f241115g.unbindService(this.f241120l);
                    this.f241118j.set(-1);
                    this.f241114f = null;
                    i3 = this.f241118j.get();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "unbindService exception===>", e16);
                    }
                    this.f241118j.set(-1);
                    this.f241114f = null;
                    i3 = this.f241118j.get();
                }
                t(i3);
            } catch (Throwable th5) {
                this.f241118j.set(-1);
                this.f241114f = null;
                t(this.f241118j.get());
                throw th5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3) {
        com.tencent.mobileqq.listentogether.player.b bVar;
        WeakReference<com.tencent.mobileqq.listentogether.player.b> weakReference = this.f241110b;
        if (weakReference == null || (bVar = weakReference.get()) == null) {
            return;
        }
        bVar.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z16, boolean z17) {
        f fVar;
        WeakReference<f> weakReference = this.f241112d;
        if (weakReference == null || (fVar = weakReference.get()) == null) {
            return;
        }
        fVar.c(z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z16) {
        f fVar;
        WeakReference<f> weakReference = this.f241112d;
        if (weakReference == null || (fVar = weakReference.get()) == null) {
            return;
        }
        fVar.b(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(ISong iSong) {
        c cVar;
        WeakReference<c> weakReference = this.f241111c;
        if (weakReference == null || (cVar = weakReference.get()) == null) {
            return;
        }
        cVar.a(iSong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, int i3) {
        f fVar;
        WeakReference<f> weakReference = this.f241112d;
        if (weakReference == null || (fVar = weakReference.get()) == null) {
            return;
        }
        fVar.a(str, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, int i3, int i16) {
        d dVar;
        WeakReference<d> weakReference = this.f241113e;
        if (weakReference == null || (dVar = weakReference.get()) == null) {
            return;
        }
        dVar.a(str, i3, i16);
    }

    private void z(Message message) {
        Intent intent = new Intent(this.f241115g, (Class<?>) QQMusicPlayService.class);
        intent.putExtra("key_message", message);
        try {
            this.f241115g.startService(intent);
        } catch (Throwable th5) {
            QLog.e("QQMusicPlay.QQMusicPlayClient", 1, "sendMessage exception===>", th5);
        }
    }

    @Override // com.tencent.mobileqq.listentogether.player.e
    public synchronized boolean b(ISong iSong) {
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = iSong;
            objArr[1] = Boolean.valueOf(this.f241114f != null);
            QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->startPlay song=[%s] connected=%b", objArr));
        }
        Message obtain = Message.obtain((Handler) null, 6);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_song", iSong);
        obtain.setData(bundle);
        z(obtain);
        return true;
    }

    @Override // com.tencent.mobileqq.listentogether.player.e
    public int e() {
        return QQMusicPlayService.E();
    }

    @Override // com.tencent.mobileqq.listentogether.player.e
    public int getPlayState() {
        return QQMusicPlayService.F();
    }

    @Override // com.tencent.mobileqq.listentogether.player.e
    public synchronized void init() {
        int i3;
        this.f241119k = false;
        if (this.f241118j.get() >= 0) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->init");
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("QQMusicPlayClient");
        baseHandlerThread.start();
        this.f241117i = new b(this, baseHandlerThread.getLooper());
        this.f241109a = new Messenger(this.f241117i);
        try {
            try {
                this.f241115g.bindService(new Intent(this.f241115g, (Class<?>) QQMusicPlayService.class), this.f241120l, 1);
                this.f241118j.set(0);
                i3 = this.f241118j.get();
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.i("QQMusicPlay.QQMusicPlayClient", 1, "init exception===>", e16);
                i3 = this.f241118j.get();
            }
            t(i3);
        } catch (Throwable th5) {
            t(this.f241118j.get());
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.listentogether.player.e
    public synchronized boolean isConnected() {
        return this.f241118j.get() == 1;
    }

    @Override // com.tencent.mobileqq.listentogether.player.e
    public synchronized boolean pausePlay() {
        if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->pausePlay");
        }
        z(Message.obtain((Handler) null, 7));
        return true;
    }

    @Override // com.tencent.mobileqq.listentogether.player.e
    public synchronized boolean resumePlay() {
        if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->resumePlay");
        }
        z(Message.obtain((Handler) null, 8));
        return true;
    }

    @Override // com.tencent.mobileqq.listentogether.player.e
    public synchronized boolean stopPlay() {
        if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->stopPlay");
        }
        this.f241119k = true;
        z(Message.obtain((Handler) null, 10));
        return true;
    }

    @Override // com.tencent.mobileqq.listentogether.player.e
    public void a(c cVar) {
        if (cVar != null) {
            this.f241111c = new WeakReference<>(cVar);
        } else {
            this.f241111c = null;
        }
    }

    @Override // com.tencent.mobileqq.listentogether.player.e
    public void c(d dVar) {
        if (dVar != null) {
            this.f241113e = new WeakReference<>(dVar);
        } else {
            this.f241113e = null;
        }
    }

    @Override // com.tencent.mobileqq.listentogether.player.e
    public void d(com.tencent.mobileqq.listentogether.player.b bVar) {
        if (bVar != null) {
            this.f241110b = new WeakReference<>(bVar);
        } else {
            this.f241110b = null;
        }
    }

    @Override // com.tencent.mobileqq.listentogether.player.e
    public void f(f fVar) {
        if (fVar != null) {
            this.f241112d = new WeakReference<>(fVar);
        } else {
            this.f241112d = null;
        }
    }
}
