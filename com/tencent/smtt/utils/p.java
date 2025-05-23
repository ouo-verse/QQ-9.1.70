package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes25.dex */
public class p {

    /* renamed from: c, reason: collision with root package name */
    private static p f369783c;

    /* renamed from: a, reason: collision with root package name */
    private Context f369784a;

    /* renamed from: b, reason: collision with root package name */
    private File f369785b = null;

    /* renamed from: d, reason: collision with root package name */
    private String f369786d = "https://log.tbs.qq.com/ajax?c=pu&v=2&k=";

    /* renamed from: e, reason: collision with root package name */
    private String f369787e = "https://log.tbs.qq.com/ajax?c=pu&tk=";

    /* renamed from: f, reason: collision with root package name */
    private String f369788f = "https://log.tbs.qq.com/ajax?c=dl&k=";

    /* renamed from: g, reason: collision with root package name */
    private String f369789g = "https://cfg.imtt.qq.com/tbs?v=2&mk=";

    /* renamed from: h, reason: collision with root package name */
    private String f369790h = "https://log.tbs.qq.com/ajax?c=ul&v=2&k=";

    /* renamed from: i, reason: collision with root package name */
    private String f369791i = "https://tbsfile.imtt.qq.com/tbs/x5sdk/getcomponentinfo";

    @TargetApi(11)
    p(Context context) {
        this.f369784a = null;
        TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.f369784a = context.getApplicationContext();
        g();
    }

    public static synchronized p a(Context context) {
        p pVar;
        synchronized (p.class) {
            if (f369783c == null) {
                f369783c = new p(context);
            }
            pVar = f369783c;
        }
        return pVar;
    }

    @SuppressLint({"SuspiciousIndentation"})
    private synchronized void g() {
        File h16;
        BufferedInputStream bufferedInputStream = null;
        try {
            h16 = h();
        } catch (Throwable th5) {
            th = th5;
        }
        if (h16 == null) {
            TbsLog.e("TbsCommonConfig", "Config file is null, default values will be applied");
            return;
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(h16));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream2);
            String property = properties.getProperty("pv_post_url", "");
            if (!"".equals(property)) {
                this.f369786d = property;
            }
            String property2 = properties.getProperty("tbs_download_stat_post_url", "");
            if (!"".equals(property2)) {
                this.f369788f = property2;
            }
            String property3 = properties.getProperty("tbs_downloader_post_url", "");
            TbsLog.i("TbsCommonConfig", "KEY_TBS_DOWNLOADER_POST_URL is " + property3);
            if (!"".equals(property3)) {
                this.f369789g = property3;
            }
            String property4 = properties.getProperty("tbs_log_post_url", "");
            if (!"".equals(property4)) {
                this.f369790h = property4;
            }
            String property5 = properties.getProperty("pv_post_url_tk", "");
            if (!"".equals(property5)) {
                this.f369787e = property5;
            }
            String property6 = properties.getProperty("component_info_url", "");
            if (!"".equals(property6)) {
                this.f369791i = property6;
            }
            try {
                bufferedInputStream2.close();
            } catch (IOException e16) {
                e = e16;
                e.printStackTrace();
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = bufferedInputStream2;
            try {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                TbsLog.e("TbsCommonConfig", "exceptions occurred1:" + stringWriter.toString());
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e17) {
                        e = e17;
                        e.printStackTrace();
                    }
                }
            } finally {
            }
        }
    }

    private File h() {
        File file = null;
        try {
            if (this.f369785b == null) {
                if (!TextUtils.isEmpty(this.f369784a.getApplicationContext().getApplicationInfo().packageName)) {
                    this.f369785b = new File(FileUtil.a(this.f369784a, 8));
                }
                File file2 = this.f369785b;
                if (file2 == null || !file2.isDirectory()) {
                    return null;
                }
            }
            TbsLog.i("TbsCommonConfig", "mTbsConfigDir is " + this.f369785b.getAbsolutePath());
            File file3 = new File(this.f369785b, "tbsnet.conf");
            if (!file3.exists()) {
                TbsLog.i("TbsCommonConfig", "Get file(" + file3.getCanonicalPath() + ") failed!");
                return null;
            }
            try {
                TbsLog.i("TbsCommonConfig", "pathc:" + file3.getCanonicalPath());
                return file3;
            } catch (Throwable th5) {
                th = th5;
                file = file3;
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
                return file;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public String b() {
        return this.f369786d;
    }

    public String c() {
        return this.f369788f;
    }

    public String d() {
        return this.f369789g;
    }

    public String e() {
        return this.f369787e;
    }

    public String f() {
        return this.f369791i;
    }

    public static synchronized p a() {
        p pVar;
        synchronized (p.class) {
            pVar = f369783c;
        }
        return pVar;
    }
}
