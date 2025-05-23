package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.fu;
import com.xiaomi.push.fv;
import com.xiaomi.push.gj;
import com.xiaomi.push.in;
import com.xiaomi.push.ip;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ba {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f389692a = new Object();

    public static void a(final Context context, final gj gjVar) {
        if (!af.f(gjVar.e())) {
            return;
        }
        com.xiaomi.push.ae.b(context).g(new Runnable() { // from class: com.xiaomi.push.service.ba.1
            @Override // java.lang.Runnable
            public void run() {
                RandomAccessFile randomAccessFile;
                synchronized (ba.f389692a) {
                    FileLock fileLock = null;
                    try {
                        try {
                            File file = new File(context.getFilesDir(), "tiny_data.lock");
                            in.f(file);
                            randomAccessFile = new RandomAccessFile(file, "rw");
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
                                ba.e(context, gjVar);
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e18) {
                                        jz4.c.q(e18);
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
                                    jz4.c.q(e26);
                                }
                            }
                            in.b(randomAccessFile);
                        }
                        in.b(randomAccessFile);
                    } catch (Throwable th7) {
                        throw th7;
                    }
                }
            }
        });
    }

    public static byte[] b(Context context) {
        String d16 = com.xiaomi.push.o.b(context).d("mipush", "td_key", "");
        if (TextUtils.isEmpty(d16)) {
            d16 = com.xiaomi.push.ag.a(20);
            com.xiaomi.push.o.b(context).e("mipush", "td_key", d16);
        }
        return c(d16);
    }

    private static byte[] c(String str) {
        byte[] copyOf = Arrays.copyOf(com.xiaomi.push.aa.b(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    public static void e(Context context, gj gjVar) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        ?? b16 = b(context);
        try {
            try {
                byte[] c16 = fu.c(b16, fv.e(gjVar));
                if (c16 != null && c16.length >= 1) {
                    if (c16.length > 30720) {
                        jz4.c.m("TinyData write to cache file failed case too much data content item:" + gjVar.d() + "  ts:" + System.currentTimeMillis());
                        in.b(null);
                        in.b(null);
                    }
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        bufferedOutputStream3.write(ip.b(c16.length));
                        bufferedOutputStream3.write(c16);
                        bufferedOutputStream3.flush();
                        in.b(null);
                        in.b(bufferedOutputStream3);
                        return;
                    } catch (IOException e16) {
                        bufferedOutputStream2 = bufferedOutputStream3;
                        e = e16;
                        jz4.c.o("TinyData write to cache file failed cause io exception item:" + gjVar.d(), e);
                        b16 = bufferedOutputStream2;
                        in.b(null);
                        in.b(b16);
                        return;
                    } catch (Exception e17) {
                        bufferedOutputStream = bufferedOutputStream3;
                        e = e17;
                        jz4.c.o("TinyData write to cache file  failed item:" + gjVar.d(), e);
                        b16 = bufferedOutputStream;
                        in.b(null);
                        in.b(b16);
                        return;
                    } catch (Throwable th5) {
                        b16 = bufferedOutputStream3;
                        th = th5;
                        in.b(null);
                        in.b(b16);
                        throw th;
                    }
                }
                jz4.c.m("TinyData write to cache file failed case encryption fail item:" + gjVar.d() + "  ts:" + System.currentTimeMillis());
                in.b(null);
                in.b(null);
            } catch (IOException e18) {
                e = e18;
                bufferedOutputStream2 = null;
            } catch (Exception e19) {
                e = e19;
                bufferedOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                b16 = 0;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }
}
