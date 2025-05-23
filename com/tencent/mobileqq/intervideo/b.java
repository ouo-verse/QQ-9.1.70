package com.tencent.mobileqq.intervideo;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b implements PluginManagerUpdater {

    /* renamed from: a, reason: collision with root package name */
    private final String f238130a;

    /* renamed from: b, reason: collision with root package name */
    private final File f238131b;

    /* renamed from: c, reason: collision with root package name */
    private final String f238132c;

    /* renamed from: d, reason: collision with root package name */
    private final String f238133d;

    /* renamed from: e, reason: collision with root package name */
    private final String f238134e;

    /* renamed from: f, reason: collision with root package name */
    private final File f238135f;

    /* renamed from: g, reason: collision with root package name */
    private final SharedPreferences f238136g = BaseApplication.getContext().getSharedPreferences("IVShadowCdnPmUpdater", 0);

    /* renamed from: h, reason: collision with root package name */
    private final AtomicLong f238137h = new AtomicLong(System.currentTimeMillis() - 180000);

    /* renamed from: i, reason: collision with root package name */
    private final IVPluginDataReporter f238138i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f238139j;

    /* renamed from: k, reason: collision with root package name */
    private String f238140k;

    /* renamed from: l, reason: collision with root package name */
    private Future<File> f238141l;

    /* renamed from: m, reason: collision with root package name */
    com.tencent.mobileqq.intervideo.a f238142m;

    /* renamed from: n, reason: collision with root package name */
    private e f238143n;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Callable<File> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public File call() throws Exception {
            File h16;
            try {
                boolean j3 = b.this.j();
                if (QLog.isColorLevel()) {
                    QLog.i("shadow::CdnPmUpdater", 2, "isNeedDownload:" + j3);
                }
                if (!j3) {
                    h16 = b.this.getLatest();
                } else {
                    h16 = b.this.h();
                    if (b.this.f238143n != null) {
                        b.this.f238143n.a();
                    }
                }
                return h16;
            } finally {
                b.this.m(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.intervideo.b$b, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public class C7941b implements com.tencent.mobileqq.intervideo.now.DownloadEngine.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f238145a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Exception[] f238146b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f238147c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f238148d;

        C7941b(File file, Exception[] excArr, long j3, CountDownLatch countDownLatch) {
            this.f238145a = file;
            this.f238146b = excArr;
            this.f238147c = j3;
            this.f238148d = countDownLatch;
        }

        @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.a
        public void onDownloadFailed(int i3, int i16, String str) {
            String str2;
            this.f238146b[0] = new Exception("\u4e0b\u8f7d\u5931\u8d25 retcode:" + i3 + " httpCode:" + i16 + " err:" + str);
            if (QLog.isColorLevel()) {
                QLog.d("shadow::CdnPmUpdater", 2, " onDownloadFailed retCode =  " + i3);
            }
            if (b.this.f238139j) {
                str2 = "33669798";
            } else {
                str2 = "33669803";
            }
            Monitor.b(str2);
            b.this.f238138i.opType("onDownloadFailed").opResult((int) (System.currentTimeMillis() - this.f238147c)).report();
            this.f238148d.countDown();
        }

        @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.a
        public void onDownloadComplete() {
            String str;
            QLog.d("shadow::CdnPmUpdater", 1, " download cdn success");
            if (!b.this.f238131b.renameTo(this.f238145a)) {
                this.f238146b[0] = new RuntimeException(HardCodeUtil.qqStr(R.string.k_t) + this.f238145a.getAbsolutePath());
            }
            if (b.this.f238139j) {
                str = "33669797";
            } else {
                str = "33669802";
            }
            Monitor.b(str);
            b.this.f238138i.opType("onDownloadComplete").opResult((int) (System.currentTimeMillis() - this.f238147c)).report();
            this.f238148d.countDown();
        }

        @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.a
        public void onDownloadProgress(long j3, long j16, int i3) {
        }
    }

    public b(Context context, String str, String str2, String str3) {
        String str4;
        String str5;
        IVPluginDataReporter iVPluginDataReporter = new IVPluginDataReporter();
        this.f238138i = iVPluginDataReporter;
        this.f238140k = str3;
        File file = new File(new File(context.getFilesDir(), "IVShadowCdnPmUpdater"), str);
        this.f238135f = file;
        file.mkdirs();
        this.f238131b = new File(file, str + this.f238140k + "_pm.temp");
        this.f238132c = str;
        this.f238134e = "wasUpdate_" + str + "_" + this.f238140k;
        boolean equals = "Now".equals(str);
        this.f238139j = equals;
        this.f238142m = new com.tencent.mobileqq.intervideo.a(context, str, str3);
        if (equals) {
            this.f238133d = "pm_name_" + str + "_" + str2 + "_" + this.f238140k;
            if (!StringUtil.isEmpty(str2)) {
                str5 = str2.substring(str2.length() - 1);
            } else {
                str5 = "9";
            }
            this.f238130a = "https://dlied5sdk.myapp.com/now/pluginmanager/" + this.f238140k + "/ShadowPluginManager_nowPlugin_" + str5;
        } else {
            this.f238133d = "pm_name_" + str + "_" + str2 + "_" + this.f238140k;
            if (str2 != null && str2.endsWith("0")) {
                str4 = "_A";
            } else {
                str4 = "_B";
            }
            this.f238130a = "https://dldir1v6.qq.com/huayang/GVideo/ShadowPluginManager2_1_" + str + str4;
        }
        iVPluginDataReporter.opDepartment("shadow").opName(str);
        if (QLog.isColorLevel()) {
            QLog.i("shadow::CdnPmUpdater", 2, "use cdnupdater url = " + this.f238130a);
        }
    }

    private boolean i() {
        return this.f238136g.getBoolean(this.f238134e, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() throws IOException {
        File latest = getLatest();
        if (latest == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f238137h.get();
        if (currentTimeMillis <= 180000) {
            if (QLog.isColorLevel()) {
                QLog.i("shadow::CdnPmUpdater", 2, "\u77ed\u65f6\u95f4\u5185\u4e0d\u91cd\u590d\u68c0\u6d4binterval==" + currentTimeMillis);
            }
            return false;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            URLConnection openConnection = new URL(this.f238130a).openConnection();
            if (openConnection instanceof HttpURLConnection) {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
                try {
                    if (httpURLConnection2.getResponseCode() == 200) {
                        long length = latest.length();
                        int contentLength = httpURLConnection2.getContentLength();
                        this.f238137h.set(System.currentTimeMillis());
                        boolean z16 = length != ((long) contentLength);
                        httpURLConnection2.disconnect();
                        return z16;
                    }
                    throw new Error(HardCodeUtil.qqStr(R.string.k_w) + 200 + HardCodeUtil.qqStr(R.string.k_x) + httpURLConnection2.getResponseCode());
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            throw new Error(this.f238130a + HardCodeUtil.qqStr(R.string.k_u));
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private void k(File file) {
        this.f238136g.edit().putString(this.f238133d, file.getAbsolutePath()).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z16) {
        this.f238136g.edit().putBoolean(this.f238134e, z16).commit();
        if (QLog.isColorLevel()) {
            QLog.i("shadow::CdnPmUpdater", 2, "setWasUpdating:" + z16);
        }
    }

    public void g() {
        File latest = getLatest();
        if (latest != null) {
            latest.delete();
        }
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public File getLatest() {
        String string = this.f238136g.getString(this.f238133d, null);
        QLog.i("shadow::CdnPmUpdater", 2, "getLatest==" + string);
        if (!TextUtils.isEmpty(string)) {
            File file = new File(string);
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    public File h() throws Exception {
        if (QLog.isColorLevel()) {
            QLog.d("shadow::CdnPmUpdater", 2, "start download ");
        }
        File file = this.f238135f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f238132c);
        sb5.append("_");
        sb5.append(Long.valueOf(System.currentTimeMillis() + "", 36));
        sb5.append(".apk");
        File file2 = new File(file, sb5.toString());
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Exception[] excArr = new Exception[1];
        long currentTimeMillis = System.currentTimeMillis();
        INowDownloadManager createObject = ((INowDownloadManager) QRoute.api(INowDownloadManager.class)).createObject(false);
        createObject.init(BaseApplication.getContext());
        createObject.addDownloadListener(this.f238130a, new C7941b(file2, excArr, currentTimeMillis, countDownLatch));
        String str = this.f238130a;
        createObject.startDownload(f52.a.a(str, str, this.f238131b.getAbsolutePath()));
        countDownLatch.await();
        Exception exc = excArr[0];
        if (exc == null) {
            file2.setLastModified(file2.lastModified() + 1000);
            k(file2);
            return file2;
        }
        throw exc;
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public Future<Boolean> isAvailable(File file) {
        throw new UnsupportedOperationException(HardCodeUtil.qqStr(R.string.k_v));
    }

    public void l(e eVar) {
        this.f238143n = eVar;
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public boolean wasUpdating() {
        return i();
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public Future<File> update() {
        String str;
        m(true);
        if (QLog.isColorLevel()) {
            QLog.i("shadow::CdnPmUpdater", 2, "update");
        }
        if (this.f238139j) {
            str = "33669796";
        } else {
            str = "33669801";
        }
        Monitor.b(str);
        this.f238138i.opType("update").report();
        Future<File> future = this.f238141l;
        if (future != null && !future.isDone()) {
            if (QLog.isColorLevel()) {
                QLog.i("shadow::CdnPmUpdater", 2, "\u4e0a\u4e00\u6b21update\u8fd8\u6ca1\u7ed3\u675f\uff0c\u8fd4\u56de\u76f8\u540cFuture");
            }
            return this.f238141l;
        }
        Future<File> submit = ThreadManagerExecutor.getExecutorService(192).submit(new a());
        this.f238141l = submit;
        return submit;
    }
}
