package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ae;
import common.config.service.QzoneConfig;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class dl extends ae.a {

    /* renamed from: d, reason: collision with root package name */
    protected int f388612d;

    /* renamed from: e, reason: collision with root package name */
    protected Context f388613e;

    public dl(Context context, int i3) {
        this.f388612d = i3;
        this.f388613e = context;
    }

    public static void g(Context context, gn gnVar) {
        String a16;
        ci a17 = cj.b().a();
        if (a17 == null) {
            a16 = "";
        } else {
            a16 = a17.a();
        }
        if (TextUtils.isEmpty(a16) || TextUtils.isEmpty(gnVar.a())) {
            return;
        }
        h(context, gnVar, a16);
    }

    private static void h(Context context, gn gnVar, String str) {
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        byte[] d16 = cl.d(str, fv.e(gnVar));
        if (d16 != null && d16.length != 0) {
            synchronized (cm.f388415a) {
                FileLock fileLock = null;
                BufferedOutputStream bufferedOutputStream2 = null;
                fileLock = null;
                fileLock = null;
                fileLock = null;
                try {
                    try {
                        File file = new File(context.getFilesDir(), "push_cdata.lock");
                        in.f(file);
                        randomAccessFile = new RandomAccessFile(file, "rw");
                        try {
                            FileLock lock = randomAccessFile.getChannel().lock();
                            try {
                                File file2 = new File(context.getFilesDir(), "push_cdata.data");
                                if (im.b(file2)) {
                                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, true));
                                    try {
                                        bufferedOutputStream.write(ip.b(d16.length));
                                        bufferedOutputStream.write(d16);
                                        bufferedOutputStream.flush();
                                        file2.setLastModified(0L);
                                        bufferedOutputStream2 = bufferedOutputStream;
                                    } catch (IOException e16) {
                                        e = e16;
                                        fileLock = lock;
                                        try {
                                            e.printStackTrace();
                                            if (fileLock != null && fileLock.isValid()) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException unused) {
                                                }
                                            }
                                            in.b(bufferedOutputStream);
                                            in.b(randomAccessFile);
                                        } catch (Throwable th5) {
                                            th = th5;
                                            if (fileLock != null && fileLock.isValid()) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException unused2) {
                                                }
                                            }
                                            in.b(bufferedOutputStream);
                                            in.b(randomAccessFile);
                                            throw th;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        fileLock = lock;
                                        if (fileLock != null) {
                                            fileLock.release();
                                        }
                                        in.b(bufferedOutputStream);
                                        in.b(randomAccessFile);
                                        throw th;
                                    }
                                }
                                if (lock != null && lock.isValid()) {
                                    try {
                                        lock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                in.b(bufferedOutputStream2);
                            } catch (IOException e17) {
                                e = e17;
                                bufferedOutputStream = null;
                            } catch (Throwable th7) {
                                th = th7;
                                bufferedOutputStream = null;
                            }
                        } catch (IOException e18) {
                            e = e18;
                            bufferedOutputStream = null;
                        } catch (Throwable th8) {
                            th = th8;
                            bufferedOutputStream = null;
                        }
                    } catch (IOException e19) {
                        e = e19;
                        bufferedOutputStream = null;
                        randomAccessFile = null;
                    } catch (Throwable th9) {
                        th = th9;
                        bufferedOutputStream = null;
                        randomAccessFile = null;
                    }
                    in.b(randomAccessFile);
                } catch (Throwable th10) {
                    throw th10;
                }
            }
        }
    }

    private String k() {
        return "dc_job_result_time_" + e();
    }

    private String l() {
        return "dc_job_result_" + e();
    }

    protected boolean b() {
        return true;
    }

    protected boolean c() {
        return false;
    }

    public abstract gh f();

    protected boolean i() {
        return cl.b(this.f388613e, String.valueOf(e()), this.f388612d);
    }

    public abstract String j();

    @Override // java.lang.Runnable
    public void run() {
        String a16;
        String j3 = j();
        if (TextUtils.isEmpty(j3)) {
            return;
        }
        if (i()) {
            jz4.c.m("DC run job mutual: " + e());
            return;
        }
        ci a17 = cj.b().a();
        if (a17 == null) {
            a16 = "";
        } else {
            a16 = a17.a();
        }
        if (TextUtils.isEmpty(a16) || !b()) {
            return;
        }
        if (c()) {
            SharedPreferences sharedPreferences = this.f388613e.getSharedPreferences("mipush_extra", 0);
            if (ag.b(j3).equals(sharedPreferences.getString(l(), null))) {
                long j16 = sharedPreferences.getLong(k(), 0L);
                int a18 = com.xiaomi.push.service.ah.d(this.f388613e).a(gk.DCJobUploadRepeatedInterval.a(), QzoneConfig.DefaultValue.QZONESETTINGS_AIO_FEEDS_MIN_REFRESH_TIME);
                if ((System.currentTimeMillis() - j16) / 1000 < this.f388612d) {
                    return;
                }
                if ((System.currentTimeMillis() - j16) / 1000 < a18) {
                    j3 = "same_" + j16;
                }
            }
        }
        gn gnVar = new gn();
        gnVar.a(j3);
        gnVar.a(System.currentTimeMillis());
        gnVar.a(f());
        h(this.f388613e, gnVar, a16);
    }
}
