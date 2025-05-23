package com.tencent.matrix.backtrace;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.tencent.matrix.backtrace.c;
import com.tencent.matrix.xlog.XLogNative;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WarmUpService extends Service {
    private static final AtomicInteger C = new AtomicInteger(0);
    private static final byte[] D = new byte[0];

    /* renamed from: f, reason: collision with root package name */
    private static volatile boolean f151410f = false;

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f151411h = false;

    /* renamed from: i, reason: collision with root package name */
    private static HandlerThread f151412i;

    /* renamed from: m, reason: collision with root package name */
    private static Handler f151413m;

    /* renamed from: d, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    private final Messenger f151414d = new Messenger(new a(g51.a.a().getLooper()));

    /* renamed from: e, reason: collision with root package name */
    private final WarmUpDelegate f151415e = new WarmUpDelegate();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                Bundle bundle2 = bundle.getBundle("invoke-args");
                IBinder binder = bundle.getBinder("invoke-resp");
                Bundle b16 = WarmUpService.this.b(message.what, bundle2);
                try {
                    new Messenger(binder).send(Message.obtain(null, message.what, b16));
                } catch (RemoteException e16) {
                    g51.b.d("Matrix.WarmUpService", e16, "", new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements Handler.Callback {
        b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                g51.b.c("Matrix.WarmUpService", "Suicide.", new Object[0]);
                SystemMethodProxy.killProcess(Process.myPid());
                System.exit(0);
            }
            return false;
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        volatile Messenger f151417a;

        /* renamed from: b, reason: collision with root package name */
        volatile Messenger f151418b;

        /* renamed from: c, reason: collision with root package name */
        final Bundle[] f151419c = {null};

        /* renamed from: d, reason: collision with root package name */
        final HandlerThread[] f151420d = {null};

        /* renamed from: e, reason: collision with root package name */
        ServiceConnection f151421e = new a();

        /* renamed from: f, reason: collision with root package name */
        private final boolean[] f151422f = {false};

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements ServiceConnection {
            a() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                c.this.f151418b = new Messenger(iBinder);
                synchronized (c.this.f151422f) {
                    c.this.f151422f[0] = true;
                    c.this.f151422f.notifyAll();
                }
                g51.b.c("Matrix.WarmUpInvoker", "This remote invoker(%s) connected.", this);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                c.this.f151418b = null;
                synchronized (c.this.f151422f) {
                    c.this.f151422f[0] = false;
                    c.this.f151422f.notifyAll();
                }
                g51.b.c("Matrix.WarmUpInvoker", "This remote invoker(%s) disconnected.", this);
                synchronized (c.this.f151419c) {
                    Bundle[] bundleArr = c.this.f151419c;
                    bundleArr[0] = null;
                    bundleArr.notifyAll();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class b extends Handler {
            b(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    synchronized (c.this.f151419c) {
                        Bundle[] bundleArr = c.this.f151419c;
                        bundleArr[0] = bundle;
                        bundleArr.notifyAll();
                    }
                }
            }
        }

        private void c() {
            if (Looper.getMainLooper() != Looper.myLooper()) {
            } else {
                throw new RuntimeException("Should not call this from main thread!");
            }
        }

        public Bundle b(int i3, Bundle bundle) {
            Bundle bundle2;
            try {
                Messenger messenger = this.f151418b;
                if (messenger != null) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putBundle("invoke-args", bundle);
                    bundle3.putBinder("invoke-resp", this.f151417a.getBinder());
                    messenger.send(Message.obtain(null, i3, bundle3));
                    synchronized (this.f151419c) {
                        Bundle[] bundleArr = this.f151419c;
                        bundleArr[0] = null;
                        bundleArr.wait(MiniBoxNoticeInfo.MIN_5);
                        bundle2 = this.f151419c[0];
                    }
                    return bundle2;
                }
            } catch (RemoteException | InterruptedException e16) {
                g51.b.d("Matrix.WarmUpInvoker", e16, "", new Object[0]);
            }
            return null;
        }

        public boolean d(Context context, Bundle bundle) {
            c();
            if (this.f151422f[0]) {
                return true;
            }
            g51.b.c("Matrix.WarmUpInvoker", "Start connecting to remote. (%s)", Integer.valueOf(hashCode()));
            synchronized (this.f151420d) {
                HandlerThread handlerThread = this.f151420d[0];
                if (handlerThread != null) {
                    handlerThread.quitSafely();
                    this.f151420d[0] = null;
                }
                this.f151420d[0] = new BaseHandlerThread("warm-up-remote-invoker-" + hashCode());
                this.f151420d[0].start();
                this.f151417a = new Messenger(new b(this.f151420d[0].getLooper()));
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context, (Class<?>) WarmUpService.class));
            intent.putExtra("enable-logger", bundle.getBoolean("enable-logger", false));
            intent.putExtra("path-of-xlog-so", bundle.getString("path-of-xlog-so", null));
            context.bindService(intent, this.f151421e, 1);
            try {
                synchronized (this.f151422f) {
                    boolean[] zArr = this.f151422f;
                    if (!zArr[0]) {
                        zArr.wait(60000L);
                    }
                }
            } catch (InterruptedException e16) {
                g51.b.d("Matrix.WarmUpInvoker", e16, "", new Object[0]);
            }
            if (!this.f151422f[0]) {
                e(context);
            }
            return this.f151422f[0];
        }

        public void e(Context context) {
            try {
                context.unbindService(this.f151421e);
            } catch (Throwable th5) {
                g51.b.d("Matrix.WarmUpInvoker", th5, "", new Object[0]);
            }
            g51.b.c("Matrix.WarmUpInvoker", "Start disconnecting to remote. (%s)", Integer.valueOf(hashCode()));
            synchronized (this.f151420d) {
                HandlerThread handlerThread = this.f151420d[0];
                if (handlerThread != null) {
                    handlerThread.quitSafely();
                    this.f151420d[0] = null;
                }
            }
            synchronized (this.f151419c) {
                Bundle[] bundleArr = this.f151419c;
                bundleArr[0] = null;
                bundleArr.notifyAll();
            }
        }

        public boolean f() {
            return this.f151422f[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Bundle b(int i3, Bundle bundle) {
        int i16;
        f();
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("warm-up-result", -1);
            if (bundle == null) {
                g51.b.c("Matrix.WarmUpService", "Args is null.", new Object[0]);
                return bundle2;
            }
            String string = bundle.getString("saving-path", null);
            g51.b.c("Matrix.WarmUpService", "Invoke from client with savingPath: %s.", string);
            if (d(string)) {
                g51.b.c("Matrix.WarmUpService", "Saving path is empty.", new Object[0]);
                return bundle2;
            }
            this.f151415e.s(string);
            if (i3 == 100) {
                String string2 = bundle.getString("path-of-elf", null);
                if (d(string2)) {
                    g51.b.c("Matrix.WarmUpService", "Warm-up so path is empty.", new Object[0]);
                    return bundle2;
                }
                int i17 = bundle.getInt("elf-start-offset", 0);
                g51.b.c("Matrix.WarmUpService", "Warm up so path %s offset %s.", string2, Integer.valueOf(i17));
                if (!c.a.b(this, string2, i17)) {
                    i16 = -3;
                } else {
                    boolean n3 = WarmUpDelegate.n(string2, i17, true);
                    if (!WeChatBacktraceNative.testLoadQut(string2, i17)) {
                        g51.b.e("Matrix.WarmUpService", "Warm up elf %s:%s success, but test load qut failed!", string2, Integer.valueOf(i17));
                        n3 = false;
                    }
                    c.a.c(this, string2, i17, n3);
                    if (n3) {
                        i16 = 0;
                    } else {
                        i16 = -2;
                    }
                }
                bundle2.putInt("warm-up-result", i16);
            } else {
                g51.b.e("Matrix.WarmUpService", "Unknown cmd: %s", Integer.valueOf(i3));
            }
            return bundle2;
        } finally {
            g(false);
        }
    }

    private static synchronized void c() {
        synchronized (WarmUpService.class) {
            if (f151410f) {
                return;
            }
            synchronized (D) {
                if (f151412i == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("backtrace-recycler");
                    f151412i = baseHandlerThread;
                    baseHandlerThread.start();
                    f151413m = new Handler(f151412i.getLooper(), new b(null));
                }
            }
            g(true);
            f151410f = true;
        }
    }

    private boolean d(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    private static synchronized void e(Intent intent) {
        synchronized (WarmUpService.class) {
            if (f151411h) {
                return;
            }
            g51.b.c("Matrix.WarmUpService", "Init called.", new Object[0]);
            WeChatBacktrace.m();
            boolean booleanExtra = intent.getBooleanExtra("enable-logger", false);
            String stringExtra = intent.getStringExtra("path-of-xlog-so");
            g51.b.c("Matrix.WarmUpService", "Enable logger: %s", Boolean.valueOf(booleanExtra));
            g51.b.c("Matrix.WarmUpService", "Path of XLog: %s", stringExtra);
            XLogNative.a(stringExtra);
            WeChatBacktrace.h(booleanExtra);
            f151411h = true;
        }
    }

    private void f() {
        g51.b.c("Matrix.WarmUpService", "Remove scheduled suicide", new Object[0]);
        synchronized (D) {
            f151413m.removeMessages(1);
            C.getAndIncrement();
        }
    }

    private static void g(boolean z16) {
        g51.b.c("Matrix.WarmUpService", "Schedule suicide", new Object[0]);
        synchronized (D) {
            if (z16) {
                f151413m.sendEmptyMessageDelayed(1, 60000L);
            } else if (C.decrementAndGet() == 0) {
                f151413m.sendEmptyMessageDelayed(1, 60000L);
            }
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        if (!f151411h) {
            e(intent);
        }
        return this.f151414d.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (!f151410f) {
            c();
        }
    }
}
