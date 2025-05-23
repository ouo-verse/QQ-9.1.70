package com.tencent.smtt.utils;

import android.os.Handler;
import android.util.Log;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static String f369774a = "TBSFileLock";

    /* renamed from: f, reason: collision with root package name */
    private static Object f369775f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static Object f369776g = new Object();

    /* renamed from: h, reason: collision with root package name */
    private static HashMap<n, Object> f369777h;

    /* renamed from: i, reason: collision with root package name */
    private static Handler f369778i;

    /* renamed from: b, reason: collision with root package name */
    File f369779b;

    /* renamed from: c, reason: collision with root package name */
    RandomAccessFile f369780c = null;

    /* renamed from: d, reason: collision with root package name */
    FileLock f369781d = null;

    /* renamed from: e, reason: collision with root package name */
    long f369782e = 0;

    public n(File file, String str) {
        this.f369779b = null;
        this.f369779b = new File(file, "." + str + ".lock");
    }

    Handler a() {
        if (f369778i == null) {
            synchronized (n.class) {
                if (f369778i == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("QBFileLock.Thread");
                    baseHandlerThread.start();
                    f369778i = new Handler(baseHandlerThread.getLooper());
                }
            }
        }
        return f369778i;
    }

    public synchronized void b() {
        FileChannel channel;
        try {
            this.f369780c = new RandomAccessFile(this.f369779b, "rw");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        RandomAccessFile randomAccessFile = this.f369780c;
        if (randomAccessFile != null && (channel = randomAccessFile.getChannel()) != null) {
            if (this.f369782e > 0) {
                a().postDelayed(this, this.f369782e);
            }
            long currentTimeMillis = System.currentTimeMillis();
            FileLock fileLock = null;
            while (true) {
                try {
                    fileLock = channel.lock();
                    if (fileLock != null) {
                        break;
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                    Log.d(f369774a, ">>> lock failed, sleep...");
                }
                try {
                    LockMethodProxy.sleep(50L);
                } catch (InterruptedException e18) {
                    e18.printStackTrace();
                }
                if (Math.abs(System.currentTimeMillis() - currentTimeMillis) >= 1000) {
                    Log.d(f369774a, ">>> lock timeout, quit...");
                    break;
                }
            }
            this.f369781d = fileLock;
            Log.d(f369774a, ">>> lock [" + this.f369779b.getName() + "] cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (this.f369781d != null) {
            c();
        }
    }

    void c() {
        synchronized (f369776g) {
            if (f369777h == null) {
                f369777h = new HashMap<>();
            }
            f369777h.put(this, f369775f);
        }
    }

    void d() {
        synchronized (f369776g) {
            HashMap<n, Object> hashMap = f369777h;
            if (hashMap == null) {
                return;
            }
            hashMap.remove(this);
        }
    }

    public void e() {
        a(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(f369774a, ">>> releaseLock on TimeOut");
        e();
    }

    public synchronized void a(boolean z16) {
        Log.d(f369774a, ">>> release lock: " + this.f369779b.getName());
        FileLock fileLock = this.f369781d;
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.f369781d = null;
        }
        RandomAccessFile randomAccessFile = this.f369780c;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            this.f369780c = null;
        }
        Handler handler = f369778i;
        if (handler != null && this.f369782e > 0) {
            handler.removeCallbacks(this);
        }
        if (z16) {
            d();
        }
    }
}
