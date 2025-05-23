package com.tencent.matrix.backtrace;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.OperationCanceledException;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import android.util.Pair;
import com.tencent.matrix.backtrace.WarmUpScheduler;
import com.tencent.matrix.backtrace.WarmUpService;
import com.tencent.matrix.backtrace.WeChatBacktrace;
import com.tencent.matrix.backtrace.c;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.patch.QZonePatchService;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CancellationException;

/* compiled from: P */
/* loaded from: classes9.dex */
class WarmUpDelegate {

    /* renamed from: b, reason: collision with root package name */
    String f151368b;

    /* renamed from: c, reason: collision with root package name */
    private c f151369c;

    /* renamed from: d, reason: collision with root package name */
    private ThreadTaskExecutor f151370d;

    /* renamed from: e, reason: collision with root package name */
    private WarmUpScheduler f151371e;

    /* renamed from: f, reason: collision with root package name */
    private WeChatBacktrace.b f151372f;

    /* renamed from: a, reason: collision with root package name */
    private boolean f151367a = false;

    /* renamed from: g, reason: collision with root package name */
    private final boolean[] f151373g = {false};

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static final class ThreadTaskExecutor implements Runnable, Handler.Callback {

        /* renamed from: d, reason: collision with root package name */
        private String f151384d;

        /* renamed from: e, reason: collision with root package name */
        private Thread f151385e;

        /* renamed from: f, reason: collision with root package name */
        private HashMap<String, Runnable> f151386f = new HashMap<>();

        /* renamed from: h, reason: collision with root package name */
        private Queue<String> f151387h = new LinkedList();

        /* renamed from: i, reason: collision with root package name */
        private Handler f151388i = new Handler(Looper.getMainLooper(), this);

        /* renamed from: m, reason: collision with root package name */
        private boolean f151389m = false;
        long[] C = {0};

        ThreadTaskExecutor(String str) {
            this.f151384d = str;
        }

        void a(Runnable runnable, String str) {
            synchronized (this.f151387h) {
                if (this.f151387h.contains(str)) {
                    return;
                }
                this.f151387h.add(str);
                this.f151386f.put(str, runnable);
                synchronized (this) {
                    Thread thread = this.f151385e;
                    if (thread == null || !thread.isAlive()) {
                        BaseThread baseThread = new BaseThread(this, this.f151384d);
                        this.f151385e = baseThread;
                        baseThread.start();
                        this.f151388i.removeMessages(1);
                        this.f151388i.sendEmptyMessageDelayed(1, MiniBoxNoticeInfo.MIN_5);
                    }
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                synchronized (this.C) {
                    if (this.C[0] == 0) {
                        return false;
                    }
                    this.f151389m = true;
                }
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f151389m = false;
            synchronized (this.C) {
                this.C[0] = System.currentTimeMillis();
            }
            Runnable runnable = null;
            String str = null;
            while (true) {
                if (runnable != null) {
                    try {
                        System.currentTimeMillis();
                        g51.b.c("Matrix.WarmUpDelegate", "Before '%s' task execution..", str);
                        runnable.run();
                        g51.b.c("Matrix.WarmUpDelegate", "After '%s' task execution..", str);
                        System.currentTimeMillis();
                    } catch (Throwable th5) {
                        synchronized (this.C) {
                            this.C[0] = 0;
                            this.f151388i.removeMessages(1);
                            throw th5;
                        }
                    }
                }
                synchronized (this.f151387h) {
                    str = this.f151387h.poll();
                    if (str == null) {
                        synchronized (this.C) {
                            this.C[0] = 0;
                        }
                        this.f151388i.removeMessages(1);
                        return;
                    }
                    Runnable remove = this.f151386f.remove(str);
                    if (remove == null) {
                        synchronized (this.C) {
                            this.C[0] = 0;
                        }
                        this.f151388i.removeMessages(1);
                        return;
                    }
                    runnable = remove;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements com.tencent.matrix.backtrace.b {
        a() {
        }

        @Override // com.tencent.matrix.backtrace.b
        public boolean warmUp(String str, int i3) {
            return WarmUpDelegate.n(str, i3, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements com.tencent.matrix.backtrace.b {

        /* renamed from: a, reason: collision with root package name */
        WarmUpService.c f151390a = new WarmUpService.c();

        /* renamed from: b, reason: collision with root package name */
        private final String f151391b;

        /* renamed from: c, reason: collision with root package name */
        private Context f151392c;

        /* renamed from: d, reason: collision with root package name */
        private Bundle f151393d;

        b(String str) {
            this.f151391b = str;
        }

        public boolean a(Context context, Bundle bundle) {
            this.f151392c = context;
            this.f151393d = bundle;
            return this.f151390a.d(context, bundle);
        }

        public void b(Context context) {
            this.f151390a.e(context);
        }

        public boolean c() {
            return this.f151390a.f();
        }

        @Override // com.tencent.matrix.backtrace.b
        public boolean warmUp(String str, int i3) {
            int i16;
            boolean z16;
            if (!c() && !a(this.f151392c, this.f151393d)) {
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("saving-path", this.f151391b);
            bundle.putString("path-of-elf", str);
            bundle.putInt("elf-start-offset", i3);
            Bundle b16 = this.f151390a.b(100, bundle);
            if (b16 != null) {
                i16 = b16.getInt("warm-up-result");
            } else {
                i16 = -100;
            }
            if (i16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                WeChatBacktraceNative.notifyWarmedUp(str, i3);
            }
            g51.b.c("Matrix.WarmUpDelegate", "Warm-up %s:%s - retCode %s", str, Integer.valueOf(i3), Integer.valueOf(i16));
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static final class c extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private WeChatBacktrace.Mode f151394a;

        c(WeChatBacktrace.Mode mode) {
            this.f151394a = mode;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            g51.b.c("Matrix.WarmUpDelegate", "Warm-up received.", new Object[0]);
            String action = intent.getAction();
            if (action != null && action.equals("action.backtrace.warmed-up")) {
                WeChatBacktraceNative.setWarmedUp(true);
                WarmUpDelegate.t(this.f151394a);
                try {
                    context.unregisterReceiver(this);
                } catch (Throwable th5) {
                    g51.b.d("Matrix.WarmUpDelegate", th5, "Unregister receiver twice.", new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.matrix.backtrace.b i() {
        if (this.f151367a) {
            b bVar = new b(this.f151368b);
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable-logger", this.f151372f.f151445m);
            bundle.putString("path-of-xlog-so", this.f151372f.f151446n);
            if (!bVar.a(this.f151372f.f151433a, bundle)) {
                return null;
            }
            return bVar;
        }
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Context context) {
        try {
            File q16 = com.tencent.matrix.backtrace.c.q(context);
            q16.createNewFile();
            com.tencent.matrix.backtrace.c.r(q16, context.getApplicationInfo().nativeLibraryDir);
        } catch (IOException e16) {
            g51.b.d("Matrix.WarmUpDelegate", e16, "", new Object[0]);
        }
        WeChatBacktraceNative.setWarmedUp(true);
        t(this.f151372f.f151436d);
        g51.b.c("Matrix.WarmUpDelegate", "Broadcast warmed up message to other processes.", new Object[0]);
        Intent intent = new Intent("action.backtrace.warmed-up");
        intent.putExtra("pid", Process.myPid());
        context.sendBroadcast(intent, context.getPackageName() + ".backtrace.warmed_up");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean n(String str, int i3, boolean z16) {
        return WeChatBacktraceNative.warmUp(str, i3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(com.tencent.matrix.backtrace.b bVar) {
        if (this.f151367a) {
            ((b) bVar).b(this.f151372f.f151433a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(WeChatBacktrace.Mode mode) {
        if (mode == WeChatBacktrace.Mode.FpUntilQuickenWarmedUp || mode == WeChatBacktrace.Mode.DwarfUntilQuickenWarmedUp) {
            WeChatBacktraceNative.setBacktraceMode(WeChatBacktrace.Mode.Quicken.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(String str, int i3) {
        boolean z16 = !c.a.a(this.f151372f.f151433a, str, i3);
        if (z16) {
            g51.b.e("Matrix.WarmUpDelegate", "Elf file %s:%s has blocked and will not do warm-up.", str, Integer.valueOf(i3));
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final CancellationSignal cancellationSignal) {
        this.f151370d.a(new Runnable() { // from class: com.tencent.matrix.backtrace.WarmUpDelegate.2

            /* compiled from: P */
            /* renamed from: com.tencent.matrix.backtrace.WarmUpDelegate$2$a */
            /* loaded from: classes9.dex */
            class a implements FileFilter {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ HashMap f151378d;

                a(HashMap hashMap) {
                    this.f151378d = hashMap;
                }

                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    String name;
                    String absolutePath;
                    try {
                        name = file.getName();
                        absolutePath = file.getAbsolutePath();
                    } catch (Throwable th5) {
                        g51.b.d("Matrix.WarmUpDelegate", th5, "", new Object[0]);
                    }
                    if (!name.contains("_malformed_") && !name.contains("_temp_")) {
                        StructStat lstat = Os.lstat(absolutePath);
                        long max = Math.max(lstat.st_atime, lstat.st_mtime) * 1000;
                        g51.b.c("Matrix.WarmUpDelegate", "File(%s) last access time %s", absolutePath, Long.valueOf(max));
                        if (System.currentTimeMillis() - max > 259200000) {
                            file.delete();
                            g51.b.c("Matrix.WarmUpDelegate", "Delete long time no access file(%s)", absolutePath);
                        } else if (max >= System.currentTimeMillis()) {
                            if (max - System.currentTimeMillis() >= 604800000) {
                                file.delete();
                                g51.b.c("Matrix.WarmUpDelegate", "Delete future file(%s)", absolutePath);
                            }
                        } else {
                            int lastIndexOf = name.lastIndexOf(46);
                            if (lastIndexOf == -1) {
                                return false;
                            }
                            String substring = name.substring(0, lastIndexOf);
                            if (name.endsWith(".hash")) {
                                return false;
                            }
                            Pair pair = (Pair) this.f151378d.get(substring);
                            if (pair != null) {
                                if (max > ((Long) pair.second).longValue()) {
                                    if (System.currentTimeMillis() - ((Long) pair.second).longValue() >= 172800000) {
                                        ((File) pair.first).delete();
                                        g51.b.c("Matrix.WarmUpDelegate", "Delete file(%s) cause %s is newer(%s vs %s).", ((File) pair.first).getName(), name, pair.second, Long.valueOf(max));
                                    }
                                    this.f151378d.put(substring, new Pair(file, Long.valueOf(max)));
                                } else if (System.currentTimeMillis() - max >= 172800000) {
                                    file.delete();
                                    g51.b.c("Matrix.WarmUpDelegate", "Delete file(%s) cause %s is newer(%s vs %s).", name, ((File) pair.first).getName(), Long.valueOf(max), pair.second);
                                }
                            } else {
                                this.f151378d.put(substring, new Pair(file, Long.valueOf(max)));
                            }
                        }
                        return false;
                    }
                    if (System.currentTimeMillis() - file.lastModified() >= 172800000) {
                        g51.b.c("Matrix.WarmUpDelegate", "Delete malformed and temp file %s", absolutePath);
                        file.delete();
                    }
                    return false;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                File file = new File(com.tencent.matrix.backtrace.c.p(WarmUpDelegate.this.f151372f));
                g51.b.c("Matrix.WarmUpDelegate", "Going to clean up saving path(%s)..", file.getAbsoluteFile());
                if (!file.isDirectory()) {
                    WarmUpDelegate.this.f151371e.f(WarmUpScheduler.TaskType.CleanUp);
                    return;
                }
                try {
                    com.tencent.matrix.backtrace.c.f(file, cancellationSignal, new a(new HashMap()));
                } catch (OperationCanceledException unused) {
                    z16 = true;
                } catch (Throwable th5) {
                    g51.b.d("Matrix.WarmUpDelegate", th5, "", new Object[0]);
                }
                z16 = false;
                if (!z16) {
                    com.tencent.matrix.backtrace.c.g(WarmUpDelegate.this.f151372f.f151433a);
                    WarmUpDelegate.this.f151371e.f(WarmUpScheduler.TaskType.CleanUp);
                    g51.b.c("Matrix.WarmUpDelegate", "Clean up saving path(%s) done.", file.getAbsoluteFile());
                    return;
                }
                g51.b.c("Matrix.WarmUpDelegate", "Clean up saving path(%s) cancelled.", file.getAbsoluteFile());
            }
        }, "clean-up");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(final CancellationSignal cancellationSignal) {
        this.f151370d.a(new Runnable() { // from class: com.tencent.matrix.backtrace.WarmUpDelegate.4

            /* compiled from: P */
            /* renamed from: com.tencent.matrix.backtrace.WarmUpDelegate$4$a */
            /* loaded from: classes9.dex */
            class a implements FileFilter {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long[] f151382d;

                a(long[] jArr) {
                    this.f151382d = jArr;
                }

                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    try {
                        StructStat lstat = Os.lstat(file.getAbsolutePath());
                        long[] jArr = this.f151382d;
                        jArr[0] = jArr[0] + 1;
                        long j3 = jArr[1];
                        long j16 = lstat.st_blocks;
                        long j17 = lstat.st_blksize;
                        Long.signum(j16);
                        jArr[1] = j3 + (j16 * j17);
                    } catch (ErrnoException e16) {
                        g51.b.d("Matrix.WarmUpDelegate", e16, "", new Object[0]);
                    }
                    return false;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                File file = new File(WarmUpDelegate.this.f151368b);
                if (!file.isDirectory()) {
                    WarmUpDelegate.this.f151371e.f(WarmUpScheduler.TaskType.DiskUsage);
                    return;
                }
                long[] jArr = new long[2];
                try {
                    com.tencent.matrix.backtrace.c.f(file, cancellationSignal, new a(jArr));
                    WarmUpDelegate.this.f151371e.f(WarmUpScheduler.TaskType.DiskUsage);
                    com.tencent.matrix.backtrace.c.h(WarmUpDelegate.this.f151372f.f151433a);
                    g51.b.c("Matrix.WarmUpDelegate", "Compute disk usage, file count(%s), disk usage(%s)", Long.valueOf(jArr[0]), Long.valueOf(jArr[1]));
                } catch (OperationCanceledException | CancellationException unused) {
                    WarmUpDelegate.this.f151371e.f(WarmUpScheduler.TaskType.DiskUsage);
                    com.tencent.matrix.backtrace.c.h(WarmUpDelegate.this.f151372f.f151433a);
                    g51.b.c("Matrix.WarmUpDelegate", "Compute disk usage, file count(%s), disk usage(%s)", Long.valueOf(jArr[0]), Long.valueOf(jArr[1]));
                } catch (Throwable th5) {
                    WarmUpDelegate.this.f151371e.f(WarmUpScheduler.TaskType.DiskUsage);
                    com.tencent.matrix.backtrace.c.h(WarmUpDelegate.this.f151372f.f151433a);
                    g51.b.c("Matrix.WarmUpDelegate", "Compute disk usage, file count(%s), disk usage(%s)", Long.valueOf(jArr[0]), Long.valueOf(jArr[1]));
                    throw th5;
                }
            }
        }, "compute-disk-usage");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(final CancellationSignal cancellationSignal) {
        this.f151370d.a(new Runnable() { // from class: com.tencent.matrix.backtrace.WarmUpDelegate.3
            /* JADX WARN: Removed duplicated region for block: B:15:0x005b A[Catch: all -> 0x00a9, TryCatch #0 {all -> 0x00a9, blocks: (B:7:0x002c, B:9:0x0030, B:13:0x0053, B:15:0x005b, B:17:0x0061, B:18:0x0068, B:20:0x007e, B:23:0x0084, B:29:0x008d, B:24:0x0090), top: B:6:0x002c }] */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str;
                int i3;
                boolean z16;
                CancellationSignal cancellationSignal2;
                g51.b.c("Matrix.WarmUpDelegate", "Going to consume requested QUT.", new Object[0]);
                String[] consumeRequestedQut = WeChatBacktraceNative.consumeRequestedQut();
                com.tencent.matrix.backtrace.b i16 = WarmUpDelegate.this.i();
                if (i16 == null) {
                    WarmUpDelegate.this.f151371e.f(WarmUpScheduler.TaskType.RequestConsuming);
                    g51.b.e("Matrix.WarmUpDelegate", "Failed to acquire warm-up invoker.", new Object[0]);
                    return;
                }
                try {
                    int length = consumeRequestedQut.length;
                    int i17 = 0;
                    while (true) {
                        if (i17 >= length) {
                            break;
                        }
                        String str2 = consumeRequestedQut[i17];
                        int lastIndexOf = str2.lastIndexOf(58);
                        if (lastIndexOf != -1) {
                            try {
                                str = str2.substring(0, lastIndexOf);
                                try {
                                    i3 = Integer.valueOf(str2.substring(lastIndexOf + 1)).intValue();
                                } catch (Throwable unused) {
                                    i3 = 0;
                                    if (WarmUpDelegate.this.u(str, i3)) {
                                    }
                                    g51.b.c("Matrix.WarmUpDelegate", "Consumed requested QUT -> %s, ret = %s.", str2, Boolean.valueOf(z16));
                                    cancellationSignal2 = cancellationSignal;
                                    if (cancellationSignal2 == null) {
                                    }
                                    i17++;
                                }
                            } catch (Throwable unused2) {
                                str = str2;
                            }
                        } else {
                            i3 = 0;
                            str = str2;
                        }
                        if (WarmUpDelegate.this.u(str, i3)) {
                            z16 = i16.warmUp(str, i3);
                            if (!z16) {
                                WarmUpDelegate.this.v(str, i3);
                            }
                        } else {
                            z16 = false;
                        }
                        g51.b.c("Matrix.WarmUpDelegate", "Consumed requested QUT -> %s, ret = %s.", str2, Boolean.valueOf(z16));
                        cancellationSignal2 = cancellationSignal;
                        if (cancellationSignal2 == null && cancellationSignal2.isCanceled()) {
                            g51.b.c("Matrix.WarmUpDelegate", "Consume requested QUT canceled.", new Object[0]);
                            break;
                        }
                        i17++;
                    }
                    g51.b.c("Matrix.WarmUpDelegate", "Consume requested QUT done.", new Object[0]);
                } finally {
                    WarmUpDelegate.this.q(i16);
                    WarmUpDelegate.this.f151371e.f(WarmUpScheduler.TaskType.RequestConsuming);
                }
            }
        }, "consuming-up");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(WeChatBacktrace.b bVar) {
        synchronized (this.f151373g) {
            boolean[] zArr = this.f151373g;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            this.f151372f = bVar;
            this.f151367a = bVar.f151441i;
            this.f151370d = new ThreadTaskExecutor("WeChatBacktraceTask");
            this.f151371e = new WarmUpScheduler(this, bVar.f151433a, bVar.f151442j, bVar.f151443k);
            if (bVar.f151440h) {
                Context context = bVar.f151433a;
                if (!com.tencent.matrix.backtrace.c.e(context)) {
                    g51.b.c("Matrix.WarmUpDelegate", "Has not been warmed up", new Object[0]);
                    this.f151371e.d(WarmUpScheduler.TaskType.WarmUp);
                }
                if (com.tencent.matrix.backtrace.c.i(context)) {
                    g51.b.c("Matrix.WarmUpDelegate", "Need clean up", new Object[0]);
                    this.f151371e.d(WarmUpScheduler.TaskType.CleanUp);
                }
                if (com.tencent.matrix.backtrace.c.m(context)) {
                    g51.b.c("Matrix.WarmUpDelegate", "Should schedule disk usage task.", new Object[0]);
                    this.f151371e.d(WarmUpScheduler.TaskType.DiskUsage);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void p(WeChatBacktrace.b bVar, WeChatBacktrace.Mode mode) {
        if (com.tencent.matrix.backtrace.c.e(bVar.f151433a)) {
            return;
        }
        if (this.f151369c == null) {
            this.f151369c = new c(mode);
            g51.b.c("Matrix.WarmUpDelegate", "Register warm-up receiver.", new Object[0]);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action.backtrace.warmed-up");
            bVar.f151433a.registerReceiver(this.f151369c, intentFilter, bVar.f151433a.getPackageName() + ".backtrace.warmed_up", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        if (!com.tencent.matrix.backtrace.c.e(this.f151372f.f151433a)) {
            return;
        }
        this.f151371e.d(WarmUpScheduler.TaskType.RequestConsuming);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(String str) {
        this.f151368b = str;
        WeChatBacktraceNative.setSavingPath(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(final CancellationSignal cancellationSignal) {
        this.f151370d.a(new Runnable() { // from class: com.tencent.matrix.backtrace.WarmUpDelegate.1

            /* compiled from: P */
            /* renamed from: com.tencent.matrix.backtrace.WarmUpDelegate$1$a */
            /* loaded from: classes9.dex */
            class a implements FileFilter {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.matrix.backtrace.b f151375d;

                a(com.tencent.matrix.backtrace.b bVar) {
                    this.f151375d = bVar;
                }

                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    String absolutePath = file.getAbsolutePath();
                    if (file.exists() && !WarmUpDelegate.this.u(absolutePath, 0) && (absolutePath.endsWith(".so") || absolutePath.endsWith(".odex") || absolutePath.endsWith(".oat") || absolutePath.endsWith(QZonePatchService.PATCH_SUFFIX_DEX))) {
                        g51.b.c("Matrix.WarmUpDelegate", "Warming up so %s", absolutePath);
                        if (!this.f151375d.warmUp(absolutePath, 0)) {
                            WarmUpDelegate.this.v(absolutePath, 0);
                        }
                    }
                    return false;
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
            
                if (0 == 0) goto L22;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean z16;
                g51.b.c("Matrix.WarmUpDelegate", "Going to warm up.", new Object[0]);
                com.tencent.matrix.backtrace.b bVar = null;
                try {
                } catch (OperationCanceledException unused) {
                    if (0 != 0) {
                        WarmUpDelegate.this.q(null);
                    }
                    z16 = true;
                } catch (Throwable th5) {
                    try {
                        g51.b.d("Matrix.WarmUpDelegate", th5, "", new Object[0]);
                    } finally {
                        if (0 != 0) {
                            WarmUpDelegate.this.q(null);
                        }
                    }
                }
                if (new File(com.tencent.matrix.backtrace.c.p(WarmUpDelegate.this.f151372f)).isDirectory()) {
                    bVar = WarmUpDelegate.this.i();
                    if (bVar == null) {
                        g51.b.e("Matrix.WarmUpDelegate", "Failed to acquire warm-up invoker", new Object[0]);
                        if (bVar != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                    Iterator<String> it = WarmUpDelegate.this.f151372f.f151435c.iterator();
                    while (it.hasNext()) {
                        com.tencent.matrix.backtrace.c.f(new File(it.next()), cancellationSignal, new a(bVar));
                    }
                    WarmUpDelegate.this.q(bVar);
                    z16 = false;
                    if (!z16) {
                        WarmUpDelegate.this.f151371e.f(WarmUpScheduler.TaskType.WarmUp);
                        WarmUpDelegate warmUpDelegate = WarmUpDelegate.this;
                        warmUpDelegate.j(warmUpDelegate.f151372f.f151433a);
                        g51.b.c("Matrix.WarmUpDelegate", "Warm-up done.", new Object[0]);
                        return;
                    }
                    g51.b.c("Matrix.WarmUpDelegate", "Warm-up cancelled.", new Object[0]);
                    return;
                }
                g51.b.e("Matrix.WarmUpDelegate", "Saving path is not a directory.", new Object[0]);
                WarmUpDelegate.this.f151371e.f(WarmUpScheduler.TaskType.WarmUp);
            }
        }, "warm-up");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, int i3) {
    }
}
