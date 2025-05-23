package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes25.dex */
public class q {

    /* renamed from: e, reason: collision with root package name */
    private static q f369792e;

    /* renamed from: b, reason: collision with root package name */
    private Context f369794b;

    /* renamed from: c, reason: collision with root package name */
    private File f369795c = null;

    /* renamed from: a, reason: collision with root package name */
    public boolean f369793a = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f369796d = false;

    /* renamed from: f, reason: collision with root package name */
    private File f369797f = null;

    q(Context context) {
        this.f369794b = null;
        this.f369794b = context.getApplicationContext();
        b();
    }

    public static synchronized q a(Context context) {
        q qVar;
        synchronized (q.class) {
            if (f369792e == null) {
                f369792e = new q(context);
            }
            qVar = f369792e;
        }
        return qVar;
    }

    private File d() {
        try {
            if (this.f369795c == null) {
                File file = new File(QbSdk.getTbsFolderDir(this.f369794b), "core_private");
                this.f369795c = file;
                if (!file.isDirectory()) {
                    return null;
                }
            }
            File file2 = new File(this.f369795c, "debug.conf");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public synchronized void b() {
        BufferedInputStream bufferedInputStream;
        Throwable th5;
        if (this.f369797f == null) {
            this.f369797f = d();
        }
        if (this.f369797f == null) {
            return;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(this.f369797f));
        } catch (Throwable th6) {
            bufferedInputStream = null;
            th5 = th6;
        }
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream);
            String property = properties.getProperty("setting_forceUseSystemWebview", "");
            if (!"".equals(property)) {
                this.f369793a = Boolean.parseBoolean(property);
            }
            try {
                bufferedInputStream.close();
            } catch (Exception e16) {
                e = e16;
                e.printStackTrace();
            }
        } catch (Throwable th7) {
            th5 = th7;
            try {
                th5.printStackTrace();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e17) {
                        e = e17;
                        e.printStackTrace();
                    }
                }
            } finally {
            }
        }
    }

    public void c() {
        BufferedInputStream bufferedInputStream;
        Throwable th5;
        BufferedOutputStream bufferedOutputStream;
        Properties properties;
        File d16 = d();
        if (d16 == null) {
            return;
        }
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(d16));
                try {
                    properties = new Properties();
                    properties.load(bufferedInputStream);
                    properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.f369793a));
                    properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.f369796d));
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(d16));
                } catch (Throwable th6) {
                    th5 = th6;
                    bufferedOutputStream = null;
                }
                try {
                    properties.store(bufferedOutputStream, (String) null);
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    bufferedOutputStream.close();
                } catch (Throwable th7) {
                    th5 = th7;
                    try {
                        th5.printStackTrace();
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e17) {
                            e17.printStackTrace();
                        }
                        bufferedOutputStream.close();
                    } finally {
                    }
                }
            } catch (Throwable th8) {
                bufferedInputStream = null;
                th5 = th8;
                bufferedOutputStream = null;
            }
        } catch (Exception e18) {
            e18.printStackTrace();
        }
    }

    public static synchronized q a() {
        q qVar;
        synchronized (q.class) {
            qVar = f369792e;
        }
        return qVar;
    }

    public void a(boolean z16) {
        this.f369796d = z16;
        c();
    }
}
