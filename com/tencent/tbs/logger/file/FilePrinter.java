package com.tencent.tbs.logger.file;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tbs.logger.c;
import com.tencent.tbs.logger.d;
import com.tencent.tbs.logger.e;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes26.dex */
public class FilePrinter implements d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f374494a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f374495b;

    /* renamed from: c, reason: collision with root package name */
    private b f374496c;

    /* renamed from: d, reason: collision with root package name */
    private volatile Worker f374497d;

    /* renamed from: e, reason: collision with root package name */
    private pe4.b f374498e;

    /* renamed from: f, reason: collision with root package name */
    private oe4.a f374499f;

    /* renamed from: g, reason: collision with root package name */
    private ne4.a f374500g;

    /* renamed from: h, reason: collision with root package name */
    private Context f374501h;

    /* loaded from: classes26.dex */
    private class Worker implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private BlockingQueue<c> f374502d;

        /* renamed from: e, reason: collision with root package name */
        private volatile boolean f374503e;

        Worker() {
            this.f374502d = new LinkedBlockingQueue();
        }

        void a(c cVar) {
            try {
                this.f374502d.put(cVar);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }

        boolean e() {
            boolean z16;
            synchronized (this) {
                z16 = this.f374503e;
            }
            return z16;
        }

        void f() {
            synchronized (this) {
                try {
                    new BaseThread(this).start();
                    this.f374503e = true;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    c take = this.f374502d.take();
                    if (take != null) {
                        FilePrinter.this.e(take);
                    } else {
                        return;
                    }
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                    synchronized (this) {
                        this.f374503e = false;
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private File f374504a;

        /* renamed from: b, reason: collision with root package name */
        private OutputStream f374505b;

        /* renamed from: c, reason: collision with root package name */
        private String f374506c;

        b() {
        }

        void a(String str) {
            byte[] e16;
            try {
                try {
                    if (this.f374505b != null) {
                        try {
                            if (FilePrinter.this.f374495b) {
                                String a16 = com.tencent.tbs.logger.file.a.a();
                                byte[] d16 = com.tencent.tbs.logger.file.a.d("tbslog.txt", a16);
                                if (d16 != null && (e16 = com.tencent.tbs.logger.file.a.e(a16, str, d16)) != null) {
                                    this.f374505b.write(e16);
                                }
                            } else if (!TextUtils.isEmpty(str)) {
                                System.out.println(Log.getStackTraceString(new Throwable()));
                                this.f374505b.write(str.getBytes());
                            }
                            OutputStream outputStream = this.f374505b;
                            if (outputStream != null) {
                                outputStream.flush();
                            }
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            OutputStream outputStream2 = this.f374505b;
                            if (outputStream2 != null) {
                                outputStream2.flush();
                            }
                        }
                    }
                } catch (Throwable th5) {
                    OutputStream outputStream3 = this.f374505b;
                    if (outputStream3 != null) {
                        try {
                            outputStream3.flush();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th5;
                }
            } catch (IOException e19) {
                e19.printStackTrace();
            }
        }

        boolean b() {
            OutputStream outputStream = this.f374505b;
            if (outputStream != null) {
                try {
                    try {
                        outputStream.close();
                        return true;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        this.f374505b = null;
                        this.f374504a = null;
                        return false;
                    }
                } finally {
                    this.f374505b = null;
                    this.f374504a = null;
                }
            }
            return true;
        }

        File c() {
            return this.f374504a;
        }

        String d() {
            return this.f374506c;
        }

        boolean e() {
            if (this.f374505b != null) {
                return true;
            }
            return false;
        }

        boolean f(String str) {
            this.f374506c = str;
            File file = new File(FilePrinter.this.f(), str);
            this.f374504a = file;
            if (!file.exists()) {
                try {
                    File parentFile = this.f374504a.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    this.f374504a.createNewFile();
                } catch (IOException e16) {
                    e16.printStackTrace();
                    this.f374504a = null;
                    return false;
                }
            }
            try {
                this.f374505b = new BufferedOutputStream(new FileOutputStream(this.f374504a, true));
                return true;
            } catch (Exception e17) {
                e17.printStackTrace();
                this.f374504a = null;
                return false;
            }
        }
    }

    public FilePrinter(Context context, boolean z16, boolean z17, pe4.b bVar, oe4.a aVar, ne4.a aVar2) {
        this.f374496c = new b();
        this.f374497d = new Worker();
        this.f374494a = z16;
        this.f374495b = z17;
        this.f374498e = bVar;
        this.f374499f = aVar;
        this.f374500g = aVar2;
        this.f374501h = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(c cVar) {
        if (!g(cVar)) {
            new Throwable("log file open failed!").printStackTrace();
        } else {
            this.f374496c.a(com.tencent.tbs.logger.b.a(cVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        String valueOf;
        String a16 = qe4.a.a(this.f374501h);
        if (!TextUtils.isEmpty(a16)) {
            valueOf = a16.toLowerCase().replace(".", "_");
        } else {
            valueOf = String.valueOf(Process.myPid());
        }
        File file = new File(e.h(), valueOf);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private boolean g(c cVar) {
        try {
            String d16 = this.f374496c.d();
            if (d16 == null || this.f374498e.a()) {
                String b16 = this.f374498e.b(cVar);
                if (b16 != null && b16.trim().length() != 0) {
                    if (!b16.equals(d16)) {
                        if (this.f374496c.e()) {
                            this.f374496c.b();
                        }
                        File[] listFiles = new File(f()).listFiles();
                        if (listFiles != null) {
                            for (File file : listFiles) {
                                if (this.f374499f.a(file)) {
                                    file.delete();
                                }
                            }
                        }
                        if (!this.f374496c.f(b16)) {
                            return false;
                        }
                    }
                    d16 = b16;
                } else {
                    throw new IllegalArgumentException("File name should not be empty.");
                }
            }
            File c16 = this.f374496c.c();
            if (c16 != null && this.f374500g.a(c16)) {
                this.f374496c.b();
                File file2 = new File(f(), d16 + "-" + (System.currentTimeMillis() % 86400000));
                if (file2.exists()) {
                    file2.delete();
                }
                c16.renameTo(file2);
                return this.f374496c.f(d16);
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.tbs.logger.d
    public void a(c cVar) {
        if (this.f374494a) {
            if (!this.f374497d.e()) {
                this.f374497d.f();
            }
            this.f374497d.a(cVar);
            return;
        }
        e(cVar);
    }
}
