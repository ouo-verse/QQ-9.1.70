package com.tencent.smtt.sdk.core.dynamicinstall;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.sdk.TbsFramework;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f369302a;

    /* renamed from: b, reason: collision with root package name */
    private File f369303b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f369304c = false;

    /* renamed from: d, reason: collision with root package name */
    private d f369305d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.smtt.sdk.core.dynamicinstall.b.c f369306e;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f369302a == null) {
                f369302a = new a();
            }
            aVar = f369302a;
        }
        return aVar;
    }

    private synchronized void d() {
        if (this.f369304c) {
            return;
        }
        byte[] b16 = b(this.f369303b);
        if (b16 == null && (b16 = a(TbsFramework.getAppContext())) == null) {
            a(-1000, "read config failed");
            return;
        }
        c a16 = b.a(b16);
        if (a16 == null) {
            a(-1001, "config data broken");
            return;
        }
        try {
            if (!b.a(a16)) {
                a(-1003, "config file illegal");
                return;
            }
            try {
                try {
                    d f16 = d.f(b.b(a16));
                    if (f16 == null) {
                        a(-1004, "configDataStr is null");
                        return;
                    }
                    com.tencent.smtt.sdk.core.dynamicinstall.b.c a17 = d.a(f16, TbsFramework.getAppContext());
                    if (a17 != null) {
                        a(a17.f369317a, a17.f369318b);
                        f16 = null;
                    }
                    this.f369305d = f16;
                    this.f369304c = true;
                } catch (JSONException unused) {
                    a(-1004, "config data broken");
                }
            } catch (Exception unused2) {
                a(-1003, "config data illegal");
            }
        } catch (Exception unused3) {
            a(-1002, "config file illegal");
        }
    }

    public d b() {
        d();
        return this.f369305d;
    }

    public com.tencent.smtt.sdk.core.dynamicinstall.b.c c() {
        return this.f369306e;
    }

    private byte[] b(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            return a(new FileInputStream(file));
        } catch (Exception e16) {
            TbsLog.w("DynamicInstall", "Read Config Exception: " + Log.getStackTraceString(e16));
            return null;
        }
    }

    public void a(File file) {
        this.f369303b = file;
        d();
    }

    private byte[] a(Context context) {
        try {
            return a(context.getAssets().open("tbs/config.tbs"));
        } catch (Exception e16) {
            TbsLog.w("DynamicInstall", "Read Config Exception: " + Log.getStackTraceString(e16));
            return null;
        }
    }

    private byte[] a(InputStream inputStream) {
        try {
            try {
                byte[] bArr = new byte[2048];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        return byteArrayOutputStream.toByteArray();
                    }
                }
            } catch (Exception e16) {
                TbsLog.w("DynamicInstall", "Read Config Exception: " + Log.getStackTraceString(e16));
                FileUtil.a(inputStream);
                return null;
            }
        } finally {
            FileUtil.a(inputStream);
        }
    }

    private void a(int i3, String str) {
        this.f369304c = true;
        this.f369306e = new com.tencent.smtt.sdk.core.dynamicinstall.b.c(i3, str);
    }
}
