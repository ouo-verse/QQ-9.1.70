package com.tencent.luggage.wxa.cp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.OperationCanceledException;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.Process;
import android.util.Pair;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.luggage.wxa.cp.c0;
import com.tencent.luggage.wxa.cp.k;
import com.tencent.luggage.wxa.cp.s;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements Handler.Callback {
    public static volatile Context M = null;
    public static volatile boolean N = true;
    public static volatile int O;
    public static volatile d P;
    public final Handler C;
    public Message[] D;
    public volatile long E;
    public volatile long F;
    public volatile boolean G;
    public final AtomicReference H;
    public final BroadcastReceiver I;
    public volatile HashMap J;
    public volatile boolean K;
    public volatile BroadcastReceiver L;

    /* renamed from: a, reason: collision with root package name */
    public final Context f123773a;

    /* renamed from: b, reason: collision with root package name */
    public final int f123774b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f123775c;

    /* renamed from: d, reason: collision with root package name */
    public r f123776d;

    /* renamed from: e, reason: collision with root package name */
    public int f123777e;

    /* renamed from: f, reason: collision with root package name */
    public h f123778f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f123779g;

    /* renamed from: h, reason: collision with root package name */
    public q f123780h;

    /* renamed from: i, reason: collision with root package name */
    public q f123781i;

    /* renamed from: j, reason: collision with root package name */
    public q f123782j;

    /* renamed from: k, reason: collision with root package name */
    public final File f123783k;

    /* renamed from: l, reason: collision with root package name */
    public final HandlerThread f123784l;

    /* renamed from: m, reason: collision with root package name */
    public final f f123785m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            l.this.C.sendMessageAtFrontOfQueue(Message.obtain(l.this.C, 1, intent));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            l.this.C.sendEmptyMessage(3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        public q f123788a = new q();

        /* renamed from: b, reason: collision with root package name */
        public boolean f123789b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f123790c = false;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f123791d;

        public c(boolean z16) {
            this.f123791d = z16;
        }

        public c a(String str, s sVar) {
            this.f123788a.f123820a.put(str, sVar == null ? null : new u(sVar));
            return this;
        }

        public c a(String str, k kVar) {
            this.f123788a.f123821b.put(str, kVar == null ? null : new u(kVar));
            return this;
        }

        public c a(String str, String str2) {
            this.f123788a.f123823d.put(new com.tencent.luggage.wxa.cp.g(c0.a(str, true, false)), str2);
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void a(c cVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class f extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public boolean f123793a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f123794b;

        /* renamed from: c, reason: collision with root package name */
        public CancellationSignal f123795c;

        public f() {
        }

        public final void a() {
            com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "Idle status changed: charging = " + this.f123793a + ", interactive = " + this.f123794b);
            boolean z16 = this.f123793a;
            if (z16 && !this.f123794b && this.f123795c == null) {
                long j3 = l.this.E;
                if (j3 < 0) {
                    return;
                }
                this.f123795c = new CancellationSignal();
                l.this.C.sendMessageDelayed(Message.obtain(l.this.C, 2, this.f123795c), j3);
                com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "System idle, trigger maintenance timer for " + (j3 / 1000) + " seconds.");
                return;
            }
            if ((!z16 || this.f123794b) && this.f123795c != null) {
                l.this.C.removeMessages(2);
                this.f123795c.cancel();
                this.f123795c = null;
                com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "Exit idle state, maintenance cancelled.");
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            char c16 = '\uffff';
            switch (action.hashCode()) {
                case -2128145023:
                    if (action.equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -1886648615:
                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -1454123155:
                    if (action.equals(IECScreenReceiver.ACTION_SCREEN_ON)) {
                        c16 = 2;
                        break;
                    }
                    break;
                case 1019184907:
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        c16 = 3;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    this.f123794b = false;
                    break;
                case 1:
                    this.f123793a = false;
                    break;
                case 2:
                    this.f123794b = true;
                    break;
                case 3:
                    this.f123793a = true;
                    break;
            }
            a();
        }

        public /* synthetic */ f(l lVar, a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final int f123797a = Process.myTid();

        /* renamed from: b, reason: collision with root package name */
        public final long f123798b = System.nanoTime();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final k.a f123799a;

        /* renamed from: b, reason: collision with root package name */
        public final String f123800b;

        /* renamed from: c, reason: collision with root package name */
        public final int f123801c;

        public /* synthetic */ h(k.a aVar, String str, int i3, a aVar2) {
            this(aVar, str, i3);
        }

        public boolean a() {
            if (this.f123799a != null) {
                return true;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (a() != hVar.a()) {
                return false;
            }
            if (c0.a(this.f123799a, hVar.f123799a) && c0.a(this.f123800b, hVar.f123800b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            if (!a()) {
                return 0;
            }
            return c0.a(this.f123799a, this.f123800b);
        }

        public String toString() {
            if (!a()) {
                return "[INVALID]";
            }
            return this.f123800b + " -> " + this.f123799a;
        }

        public h(k.a aVar, String str, int i3) {
            this.f123799a = aVar;
            this.f123800b = str;
            this.f123801c = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i {

        /* renamed from: a, reason: collision with root package name */
        public static final l f123802a;

        static {
            l lVar = new l(null);
            f123802a = lVar;
            lVar.c();
        }
    }

    public /* synthetic */ l(a aVar) {
        this();
    }

    public static void a(e eVar) {
    }

    public static l d() {
        return i.f123802a;
    }

    public final Bundle e() {
        DataInputStream dataInputStream;
        File file = new File(this.f123783k, "fs.bin");
        long length = file.length();
        if (length <= VasBusiness.CHAT_FONT_SWITCH && length > 8) {
            Parcel obtain = Parcel.obtain();
            DataInputStream dataInputStream2 = null;
            try {
                dataInputStream = new DataInputStream(new FileInputStream(file));
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                int readInt = dataInputStream.readInt();
                if (readInt == 5) {
                    int readInt2 = dataInputStream.readInt();
                    if (readInt2 == this.f123774b) {
                        int i3 = ((int) length) - 8;
                        byte[] bArr = new byte[i3];
                        int i16 = 0;
                        while (i16 < i3) {
                            i16 += dataInputStream.read(bArr, i16, i3 - i16);
                        }
                        obtain.unmarshall(bArr, 0, i16);
                        obtain.setDataPosition(0);
                        Bundle readBundle = obtain.readBundle(k.class.getClassLoader());
                        c0.a(dataInputStream);
                        OaidMonitor.parcelRecycle(obtain);
                        return readBundle;
                    }
                    throw new c0.c(l.class, readInt2, this.f123774b);
                }
                throw new c0.c(l.class, readInt, 5);
            } catch (Throwable th6) {
                th = th6;
                dataInputStream2 = dataInputStream;
                c0.a(dataInputStream2);
                OaidMonitor.parcelRecycle(obtain);
                throw th;
            }
        }
        throw new IOException("Invalid parcel file size: " + length);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Bundle extras;
        Message[] messageArr = this.D;
        if (messageArr != null) {
            int i3 = message.what;
            if (i3 > 0 && i3 <= 3) {
                Message message2 = messageArr[i3 - 1];
                if (message2 != null) {
                    message2.recycle();
                }
                messageArr[message.what - 1] = Message.obtain(message);
            } else {
                this.D = null;
                for (Message message3 : messageArr) {
                    if (message3 != null) {
                        message3.sendToTarget();
                    }
                }
            }
            return true;
        }
        int i16 = message.what;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    return false;
                }
                HashMap hashMap = this.J;
                HashMap b16 = b(this.f123773a);
                if (!b16.equals(hashMap)) {
                    this.J = b16;
                    synchronized (this.f123779g) {
                        q.a(this.f123782j.f123824e, b16);
                        a(true);
                    }
                    com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "Storage envVars from initial layer updated:");
                    q.a(new com.tencent.luggage.wxa.yp.c(4, "VFS.FileSystemManager"), b16);
                }
                return true;
            }
            a((CancellationSignal) message.obj);
            return true;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(k.class.getClassLoader());
        if (intent.getIntExtra("pid", 0) == Process.myPid()) {
            com.tencent.luggage.wxa.yp.b.d("VFS.FileSystemManager", "Ignore filesystem change broadcast from the same process.");
            return true;
        }
        int intExtra = intent.getIntExtra("uid", -1);
        if (intExtra != -1 && intExtra != Process.myUid()) {
            com.tencent.luggage.wxa.yp.b.d("VFS.FileSystemManager", "Ignore filesystem change broadcast from other users.");
            return true;
        }
        boolean booleanExtra = intent.getBooleanExtra("fromFile", false);
        com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "Refresh file system from broadcast, fromFile: " + booleanExtra);
        try {
            if (booleanExtra) {
                extras = e();
            } else {
                extras = intent.getExtras();
            }
            if (extras != null) {
                q a16 = q.a(extras);
                synchronized (this.f123779g) {
                    this.f123781i = a16;
                    a(true);
                }
                com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "Loaded public layer from bundle:");
                a16.a(new com.tencent.luggage.wxa.yp.c(4, "VFS.FileSystemManager"));
            }
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.yp.b.a("VFS.FileSystemManager", th5, "Failed to refresh file system from broadcast.");
        }
        return true;
    }

    public l() {
        this.f123775c = new Object();
        this.f123779g = new Object();
        this.H = new AtomicReference();
        Context context = M;
        this.f123773a = context;
        this.f123774b = O;
        if (context != null) {
            File parentFile = context.getFilesDir().getParentFile();
            this.f123783k = new File(parentFile == null ? context.getCacheDir() : parentFile, ".vfs_wxa");
            this.D = new Message[3];
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("VFS.Maintenance", 1);
            this.f123784l = baseHandlerThread;
            baseHandlerThread.start();
            this.C = new Handler(baseHandlerThread.getLooper(), this);
            this.f123785m = new f(this, null);
            this.E = -1L;
            this.F = Long.MAX_VALUE;
            this.K = true;
            this.I = new b();
            this.J = b(context);
            q a16 = a(context);
            this.f123782j = a16;
            q.a(a16.f123824e, this.J);
            this.f123780h = new q();
            this.f123781i = new q();
            this.f123776d = new r(this.f123782j);
            this.f123777e = 0;
            this.f123778f = new h(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0, 0 == true ? 1 : 0);
            return;
        }
        throw new IllegalStateException("Call FileSystemManager.setContext(Context) before calling instance()");
    }

    public static HashMap b(Context context) {
        HashMap hashMap = new HashMap();
        File externalCacheDir = context.getExternalCacheDir();
        hashMap.put("extData", externalCacheDir == null ? null : externalCacheDir.getParent());
        hashMap.put("extCache", externalCacheDir == null ? null : externalCacheDir.getPath());
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        hashMap.put(QQPermissionConstants.Permission.STORAGE_GROUP, externalStorageDirectory != null ? externalStorageDirectory.getPath() : null);
        return hashMap;
    }

    public static void c(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        M = context;
    }

    public static void a(d dVar) {
        P = dVar;
    }

    public static q a(Context context) {
        q qVar = new q();
        qVar.f123820a.put(null, j.a());
        qVar.f123820a.put("", j.a());
        qVar.f123820a.put("file", j.a());
        qVar.f123820a.put("wcf", d0.a());
        qVar.f123821b.put("null", n.c());
        qVar.f123824e.put("data", context.getCacheDir().getParent());
        qVar.f123824e.put("dataCache", context.getCacheDir().getPath());
        return qVar;
    }

    public static void c(boolean z16) {
        N = z16;
    }

    public final void c() {
        q qVar;
        d dVar = P;
        boolean z16 = N;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addAction("android.intent.action.MEDIA_SHARED");
        if (Build.VERSION.SDK_INT >= 33 && this.f123773a.getApplicationInfo().targetSdkVersion >= 33) {
            this.f123773a.registerReceiver(this.I, intentFilter, 4);
        } else {
            this.f123773a.registerReceiver(this.I, intentFilter);
        }
        b(z16);
        this.f123783k.mkdir();
        q qVar2 = null;
        if (dVar != null) {
            c cVar = new c(true);
            dVar.a(cVar);
            qVar = cVar.f123788a;
        } else {
            qVar = null;
        }
        if (z16) {
            try {
                Bundle e16 = e();
                if (e16 != null) {
                    qVar2 = q.a(e16);
                }
            } catch (c0.c e17) {
                com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", e17.getMessage());
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.yp.b.a("VFS.FileSystemManager", th5, "Cannot load file systems from parcel.");
            }
        }
        synchronized (this.f123779g) {
            if (qVar != null) {
                try {
                    this.f123780h = qVar;
                } catch (Throwable th6) {
                    throw th6;
                }
            }
            if (qVar2 != null) {
                this.f123781i = qVar2;
            }
            a(true);
        }
        if (qVar != null) {
            com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "Initialized private layer:");
            qVar.a(new com.tencent.luggage.wxa.yp.c(4, "VFS.FileSystemManager"));
        }
        if (qVar2 != null) {
            com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "Loaded public layer from bundle:");
            qVar2.a(new com.tencent.luggage.wxa.yp.c(4, "VFS.FileSystemManager"));
        }
        this.C.sendEmptyMessage(Integer.MAX_VALUE);
    }

    public void b(boolean z16) {
        BroadcastReceiver broadcastReceiver = this.L;
        if (broadcastReceiver != null || !z16) {
            if (broadcastReceiver == null || z16) {
                return;
            }
            this.f123773a.unregisterReceiver(broadcastReceiver);
            this.L = null;
            com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "Broadcast receiving disabled.");
            return;
        }
        a aVar = new a();
        this.L = aVar;
        String packageName = this.f123773a.getPackageName();
        if (Build.VERSION.SDK_INT >= 33 && this.f123773a.getApplicationInfo().targetSdkVersion >= 33) {
            this.f123773a.registerReceiver(aVar, new IntentFilter(packageName + ".REFRESH_VFS"), this.f123773a.getPackageName() + ".vfs.broadcast", null, 4);
        } else {
            this.f123773a.registerReceiver(aVar, new IntentFilter(packageName + ".REFRESH_VFS"), this.f123773a.getPackageName() + ".vfs.broadcast", null);
        }
        com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "Broadcast receiving enabled.");
    }

    public h a(b0 b0Var, h hVar) {
        Pair a16;
        synchronized (this.f123775c) {
            if (hVar != null) {
                if (hVar.f123801c == this.f123777e) {
                    return hVar;
                }
            }
            r rVar = this.f123776d;
            int i3 = this.f123777e;
            h hVar2 = this.f123778f;
            s.a d16 = rVar.d(b0Var.f123725a);
            return (d16 == null || (a16 = d16.a(rVar, b0Var)) == null) ? hVar2 : new h((k.a) a16.first, (String) a16.second, i3, null);
        }
    }

    public Context b() {
        return this.f123773a;
    }

    public h a(b0 b0Var) {
        return a(b0Var, null);
    }

    public void b(CancellationSignal cancellationSignal) {
        r rVar;
        synchronized (this.f123775c) {
            rVar = this.f123776d;
        }
        try {
            if (androidx.lifecycle.c.a(this.H, null, new g())) {
                try {
                    for (String str : rVar.e()) {
                        s.a d16 = rVar.d(str);
                        com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "[Maintenance] " + str + " => " + d16);
                        cancellationSignal.throwIfCanceled();
                        d16.a(cancellationSignal);
                    }
                    for (String str2 : rVar.b()) {
                        k.a b16 = rVar.b(str2);
                        com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "[Maintenance] " + str2 + " => " + b16);
                        cancellationSignal.throwIfCanceled();
                        b16.a(cancellationSignal);
                    }
                    for (String str3 : rVar.c()) {
                        k.a c16 = rVar.c(str3);
                        com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "[Maintenance] " + str3 + " => " + c16);
                        cancellationSignal.throwIfCanceled();
                        c16.a(cancellationSignal);
                    }
                    c0.e("maintain");
                    com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "Maintenance finished.");
                    return;
                } catch (RuntimeException e16) {
                    if (e16 instanceof OperationCanceledException) {
                        com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "Maintenance cancelled.");
                    } else {
                        com.tencent.luggage.wxa.yp.b.a("VFS.FileSystemManager", e16, "Maintenance failed.");
                    }
                    throw e16;
                }
            }
            com.tencent.luggage.wxa.yp.b.e("VFS.FileSystemManager", "Another thread is running maintenance, skipped");
            throw new OperationCanceledException();
        } finally {
            this.H.set(null);
        }
    }

    public final void a(boolean z16) {
        if (z16) {
            this.f123782j = this.f123782j.a();
            this.f123781i = this.f123781i.a();
            this.f123780h = this.f123780h.a();
        }
        r rVar = new r(new q(this.f123782j).a(this.f123781i).a(this.f123780h));
        synchronized (this.f123775c) {
            this.f123776d = rVar;
            int i3 = this.f123777e + 1;
            this.f123777e = i3;
            this.f123778f = new h(null, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
        }
    }

    public final void a(CancellationSignal cancellationSignal) {
        long j3 = this.F;
        long d16 = c0.d("maintain");
        boolean z16 = false;
        if (d16 < j3) {
            com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "Maintenance interval not match, skip maintenance. %d / %d", Long.valueOf(d16), Long.valueOf(j3));
            return;
        }
        boolean z17 = this.G;
        if (!z17) {
            z16 = z17;
        } else if (this.f123773a.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
            z16 = true;
        }
        PowerManager.WakeLock newWakeLock = z16 ? ((PowerManager) this.f123773a.getSystemService("power")).newWakeLock(1, "VFS:Maintenance") : null;
        try {
            com.tencent.luggage.wxa.yp.b.c("VFS.FileSystemManager", "Maintenance started. WakeLock: " + z16);
            if (newWakeLock != null) {
                newWakeLock.acquire(ShortVideoConstants.VIDEO_MAX_DURATION);
            }
            b(cancellationSignal);
            if (newWakeLock == null || !newWakeLock.isHeld()) {
                return;
            }
        } catch (Exception unused) {
            if (newWakeLock == null || !newWakeLock.isHeld()) {
                return;
            }
        } catch (Throwable th5) {
            if (newWakeLock != null && newWakeLock.isHeld()) {
                newWakeLock.release();
            }
            throw th5;
        }
        newWakeLock.release();
    }

    public File a() {
        return this.f123783k;
    }
}
