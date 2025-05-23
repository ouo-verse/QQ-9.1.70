package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import android.util.Pair;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class dd implements jz4.a {

    /* renamed from: d, reason: collision with root package name */
    private static final SimpleDateFormat f388574d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* renamed from: e, reason: collision with root package name */
    public static String f388575e = "/MiPushLog";

    /* renamed from: f, reason: collision with root package name */
    private static List<Pair<String, Throwable>> f388576f = Collections.synchronizedList(new ArrayList());

    /* renamed from: g, reason: collision with root package name */
    private static volatile dd f388577g;

    /* renamed from: a, reason: collision with root package name */
    private String f388578a;

    /* renamed from: b, reason: collision with root package name */
    private Context f388579b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f388580c;

    dd(Context context) {
        this.f388579b = context;
        if (context.getApplicationContext() != null) {
            this.f388579b = context.getApplicationContext();
        }
        this.f388578a = this.f388579b.getPackageName() + "-" + Process.myPid();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Log2FileHandlerThread");
        baseHandlerThread.start();
        this.f388580c = new Handler(baseHandlerThread.getLooper());
    }

    public static dd a(Context context) {
        if (f388577g == null) {
            synchronized (dd.class) {
                if (f388577g == null) {
                    f388577g = new dd(context);
                }
            }
        }
        return f388577g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0163 -> B:48:0x0168). Please report as a decompilation issue!!! */
    public void e() {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        File file;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                file = new File(this.f388579b.getFilesDir(), f388575e);
            } catch (Exception e16) {
                e = e16;
                fileLock = null;
                randomAccessFile = null;
            } catch (Throwable th5) {
                th = th5;
                fileLock = null;
                randomAccessFile = null;
            }
        } catch (IOException e17) {
            Log.e(this.f388578a, "", e17);
        }
        if (!im.b(file)) {
            Log.w(this.f388578a, "Cannot wirte internal file: " + file);
            return;
        }
        if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
            Log.w(this.f388578a, "Create mipushlog directory fail.");
            return;
        }
        File file2 = new File(file, "log.lock");
        if (!file2.exists() || file2.isDirectory()) {
            file2.createNewFile();
        }
        randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            fileLock = randomAccessFile.getChannel().lock();
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                    while (!f388576f.isEmpty()) {
                        try {
                            Pair<String, Throwable> remove = f388576f.remove(0);
                            String str = (String) remove.first;
                            if (remove.second != null) {
                                str = (str + "\n") + Log.getStackTraceString((Throwable) remove.second);
                            }
                            bufferedWriter2.write(str + "\n");
                        } catch (Exception e18) {
                            e = e18;
                            bufferedWriter = bufferedWriter2;
                            Log.e(this.f388578a, "", e);
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e19) {
                                    Log.e(this.f388578a, "", e19);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e26) {
                                    Log.e(this.f388578a, "", e26);
                                }
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            return;
                        } catch (Throwable th6) {
                            th = th6;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e27) {
                                    Log.e(this.f388578a, "", e27);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e28) {
                                    Log.e(this.f388578a, "", e28);
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    throw th;
                                } catch (IOException e29) {
                                    Log.e(this.f388578a, "", e29);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    File file3 = new File(file, "log1.txt");
                    if (file3.length() >= 1048576) {
                        File file4 = new File(file, "log0.txt");
                        if (file4.exists() && file4.isFile()) {
                            file4.delete();
                        }
                        file3.renameTo(file4);
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e36) {
                            Log.e(this.f388578a, "", e36);
                        }
                    }
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Exception e37) {
                e = e37;
            }
        } catch (Exception e38) {
            e = e38;
            fileLock = null;
        } catch (Throwable th8) {
            th = th8;
            fileLock = null;
        }
    }

    @Override // jz4.a
    public final void log(String str) {
        log(str, null);
    }

    @Override // jz4.a
    public final void log(final String str, final Throwable th5) {
        this.f388580c.post(new Runnable() { // from class: com.xiaomi.push.dd.1
            @Override // java.lang.Runnable
            public void run() {
                dd.f388576f.add(new Pair(String.format("%1$s %2$s %3$s ", dd.f388574d.format(new Date()), dd.this.f388578a, str), th5));
                if (dd.f388576f.size() > 20000) {
                    int size = (dd.f388576f.size() - 20000) + 50;
                    for (int i3 = 0; i3 < size; i3++) {
                        try {
                            if (dd.f388576f.size() > 0) {
                                dd.f388576f.remove(0);
                            }
                        } catch (IndexOutOfBoundsException unused) {
                        }
                    }
                    dd.f388576f.add(new Pair(String.format("%1$s %2$s %3$s ", dd.f388574d.format(new Date()), dd.this.f388578a, "flush " + size + " lines logs."), null));
                }
                try {
                    dd.this.e();
                } catch (Exception e16) {
                    Log.e(dd.this.f388578a, "", e16);
                }
            }
        });
    }
}
