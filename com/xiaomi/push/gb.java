package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class gb {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f388943a = false;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static class a implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private Context f388944d;

        /* renamed from: e, reason: collision with root package name */
        private ft f388945e;

        public a(Context context, ft ftVar) {
            this.f388945e = ftVar;
            this.f388944d = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            gb.f(this.f388944d, this.f388945e);
        }
    }

    private static void a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void b(Context context, ft ftVar) {
        ae.b(context).g(new a(context, ftVar));
    }

    private static void c(Context context, ft ftVar, File file, byte[] bArr) {
        int a16;
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[4];
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                loop0: while (true) {
                    int i3 = 0;
                    int i16 = 0;
                    while (true) {
                        try {
                            int read = bufferedInputStream2.read(bArr2);
                            if (read == -1) {
                                break loop0;
                            }
                            if (read != 4) {
                                jz4.c.B("TinyData read from cache file failed cause lengthBuffer error. size:" + read);
                                break loop0;
                            }
                            a16 = ip.a(bArr2);
                            if (a16 < 1 || a16 > 30720) {
                                break loop0;
                            }
                            byte[] bArr3 = new byte[a16];
                            int read2 = bufferedInputStream2.read(bArr3);
                            if (read2 != a16) {
                                jz4.c.B("TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + a16);
                                break loop0;
                            }
                            byte[] b16 = fu.b(bArr, bArr3);
                            if (b16 != null && b16.length != 0) {
                                gj gjVar = new gj();
                                fv.d(gjVar, b16);
                                gjVar.a("item_size", String.valueOf(b16.length));
                                arrayList.add(gjVar);
                                i3++;
                                i16 += b16.length;
                                if (i3 >= 8 || i16 >= 30720) {
                                }
                            }
                            jz4.c.B("TinyData read from cache file failed cause decrypt fail");
                        } catch (Exception e16) {
                            e = e16;
                            bufferedInputStream = bufferedInputStream2;
                            jz4.c.q(e);
                            in.b(bufferedInputStream);
                            return;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedInputStream = bufferedInputStream2;
                            in.b(bufferedInputStream);
                            throw th;
                        }
                    }
                    fr.c(context, ftVar, arrayList);
                    arrayList.clear();
                }
                jz4.c.B("TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + a16);
                fr.c(context, ftVar, arrayList);
                if (file != null && file.exists() && !file.delete()) {
                    jz4.c.m("TinyData delete reading temp file failed");
                }
                in.b(bufferedInputStream2);
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private static void d(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
        edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(Context context, ft ftVar) {
        RandomAccessFile randomAccessFile;
        File file;
        if (!f388943a) {
            f388943a = true;
            File file2 = new File(context.getFilesDir(), "tiny_data.data");
            if (!file2.exists()) {
                jz4.c.m("TinyData no ready file to get data.");
                return;
            }
            a(context);
            byte[] b16 = com.xiaomi.push.service.ba.b(context);
            FileLock fileLock = null;
            try {
                File file3 = new File(context.getFilesDir(), "tiny_data.lock");
                in.f(file3);
                randomAccessFile = new RandomAccessFile(file3, "rw");
            } catch (Exception e16) {
                e = e16;
                randomAccessFile = null;
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = null;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException e17) {
                        jz4.c.q(e17);
                    }
                }
                in.b(randomAccessFile);
                throw th;
            }
            try {
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    file2.renameTo(new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data"));
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e18) {
                            e = e18;
                            jz4.c.q(e);
                            in.b(randomAccessFile);
                            file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                            if (file.exists()) {
                            }
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (fileLock != null && fileLock.isValid()) {
                        fileLock.release();
                    }
                    in.b(randomAccessFile);
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                jz4.c.q(e);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e26) {
                        e = e26;
                        jz4.c.q(e);
                        in.b(randomAccessFile);
                        file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                        if (file.exists()) {
                        }
                    }
                }
                in.b(randomAccessFile);
                file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                if (file.exists()) {
                }
            }
            in.b(randomAccessFile);
            file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
            if (file.exists()) {
                jz4.c.m("TinyData no ready file to get data.");
                return;
            }
            c(context, ftVar, file, b16);
            fp.c(false);
            d(context);
            f388943a = false;
            return;
        }
        jz4.c.m("TinyData extractTinyData is running");
    }
}
