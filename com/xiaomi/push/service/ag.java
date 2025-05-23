package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.in;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ag {

    /* renamed from: j, reason: collision with root package name */
    private static volatile ag f389579j;

    /* renamed from: a, reason: collision with root package name */
    private final Object f389580a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Object f389581b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private final String f389582c = "mipush_region";

    /* renamed from: d, reason: collision with root package name */
    private final String f389583d = "mipush_country_code";

    /* renamed from: e, reason: collision with root package name */
    private final String f389584e = "mipush_region.lock";

    /* renamed from: f, reason: collision with root package name */
    private final String f389585f = "mipush_country_code.lock";

    /* renamed from: g, reason: collision with root package name */
    private volatile String f389586g;

    /* renamed from: h, reason: collision with root package name */
    private volatile String f389587h;

    /* renamed from: i, reason: collision with root package name */
    private Context f389588i;

    public ag(Context context) {
        this.f389588i = context;
    }

    public static ag a(Context context) {
        if (f389579j == null) {
            synchronized (ag.class) {
                if (f389579j == null) {
                    f389579j = new ag(context);
                }
            }
        }
        return f389579j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.RandomAccessFile, java.io.Closeable] */
    private String c(Context context, String str, String str2, Object obj) {
        FileLock fileLock;
        File file = new File(context.getFilesDir(), str);
        ?? r26 = 0;
        r26 = 0;
        if (!file.exists()) {
            jz4.c.m("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                try {
                    File file2 = new File(context.getFilesDir(), str2);
                    in.f(file2);
                    context = new RandomAccessFile(file2, "rw");
                } catch (Exception e16) {
                    e = e16;
                    context = 0;
                    fileLock = null;
                } catch (Throwable th5) {
                    th = th5;
                    context = 0;
                }
                try {
                    fileLock = context.getChannel().lock();
                } catch (Exception e17) {
                    e = e17;
                    fileLock = null;
                } catch (Throwable th6) {
                    th = th6;
                    if (r26 != 0 && r26.isValid()) {
                        try {
                            r26.release();
                        } catch (IOException e18) {
                            jz4.c.q(e18);
                        }
                    }
                    in.b(context);
                    throw th;
                }
                try {
                    String a16 = in.a(file);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e19) {
                            jz4.c.q(e19);
                        }
                    }
                    in.b(context);
                    return a16;
                } catch (Exception e26) {
                    e = e26;
                    jz4.c.q(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e27) {
                            jz4.c.q(e27);
                        }
                    }
                    in.b(context);
                    return null;
                }
            } catch (Throwable th7) {
                th = th7;
                r26 = str;
            }
        }
    }

    private void d(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        synchronized (obj) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(context.getFilesDir(), str3);
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
                        in.d(new File(context.getFilesDir(), str2), str);
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

    public String b() {
        if (TextUtils.isEmpty(this.f389586g)) {
            this.f389586g = c(this.f389588i, "mipush_region", "mipush_region.lock", this.f389580a);
        }
        return this.f389586g;
    }

    public void e(String str, boolean z16) {
        if (!TextUtils.equals(str, this.f389586g)) {
            this.f389586g = str;
        }
        if (z16) {
            d(this.f389588i, str, "mipush_region", "mipush_region.lock", this.f389580a);
        }
    }

    public String f() {
        if (TextUtils.isEmpty(this.f389587h)) {
            this.f389587h = c(this.f389588i, "mipush_country_code", "mipush_country_code.lock", this.f389581b);
        }
        return this.f389587h;
    }

    public void g(String str, boolean z16) {
        if (!TextUtils.equals(str, this.f389587h)) {
            this.f389587h = str;
        }
        if (z16) {
            d(this.f389588i, str, "mipush_country_code", "mipush_region.lock", this.f389580a);
        }
    }
}
