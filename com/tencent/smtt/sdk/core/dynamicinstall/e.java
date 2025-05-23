package com.tencent.smtt.sdk.core.dynamicinstall;

import android.content.Context;
import com.tencent.smtt.export.external.interfaces.IAuthRequestCallback;
import com.tencent.smtt.sdk.ProgressListener;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsFramework;
import com.tencent.smtt.sdk.X5Downloader;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.p;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/* compiled from: P */
/* loaded from: classes23.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private ProgressListener f369333a;

    /* renamed from: b, reason: collision with root package name */
    private final File f369334b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f369335c;

    /* renamed from: d, reason: collision with root package name */
    private String f369336d;

    /* renamed from: e, reason: collision with root package name */
    private X5Downloader f369337e;

    /* renamed from: f, reason: collision with root package name */
    private FileLock f369338f;

    /* renamed from: g, reason: collision with root package name */
    private FileOutputStream f369339g;

    public e(Context context, File file, String str) {
        this.f369335c = context;
        this.f369334b = file;
        this.f369336d = str;
        TbsLog.initIfNeed(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TbsLog.i("DynamicInstall", "install success and finish");
        TbsLog.writeLogToDisk();
        ProgressListener progressListener = this.f369333a;
        if (progressListener != null) {
            progressListener.onFinished();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        TbsLog.i("DynamicFeatureManager", "[stage] start authenticateX5...");
        TbsFramework.authenticateX5(true, new IAuthRequestCallback() { // from class: com.tencent.smtt.sdk.core.dynamicinstall.e.2
            @Override // com.tencent.smtt.export.external.interfaces.IAuthRequestCallback
            public void onFailed(int i3, String str) {
                TbsLog.i("DynamicFeatureManager", "[stage] failed finish authenticateX5: " + i3 + "; " + str);
                e.this.a(i3, str);
            }

            @Override // com.tencent.smtt.export.external.interfaces.IAuthRequestCallback
            public void onResponse(String str) {
                TbsLog.i("DynamicFeatureManager", "[stage] success finish authenticateX5");
                e.this.e();
            }
        });
    }

    private boolean g() {
        FileOutputStream b16 = FileUtil.b(this.f369335c, true, "x5dynamicInstall.lock");
        this.f369339g = b16;
        if (b16 != null) {
            FileLock a16 = FileUtil.a(this.f369335c, b16);
            this.f369338f = a16;
            if (a16 != null) {
                return true;
            }
            a(-2, "Other Process Downloading");
            return false;
        }
        a(-1, "DynamicInstall lock fos is null");
        return false;
    }

    private void h() {
        FileUtil.a(this.f369338f, this.f369339g);
    }

    public boolean d() {
        d b16 = a.a().b();
        if (b16 == null || !b(b16.c())) {
            return false;
        }
        return QbSdk.needUpdateLicense(this.f369335c);
    }

    public void b() {
        this.f369337e.stopDownload();
    }

    public void c() {
        this.f369337e.resetDownloadCache();
    }

    private boolean b(String str) {
        if (str == null) {
            return false;
        }
        return str.equals(this.f369335c.getSharedPreferences("tbs_download_config", 0).getString("dynamic_install_fin", "nil"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (!g()) {
            a(-2, "another process installing");
            return;
        }
        TbsLog.i("DynamicFeatureManager", "[stage] start dynamic install");
        d b16 = a.a().b();
        if (b16 == null) {
            com.tencent.smtt.sdk.core.dynamicinstall.b.c c16 = a.a().c();
            if (c16 != null) {
                a(c16.f369317a, c16.f369318b);
                return;
            } else {
                a(-1004, "config file broken");
                return;
            }
        }
        final String c17 = b16.c();
        if (b(c17)) {
            if (QbSdk.needUpdateLicense(this.f369335c)) {
                TbsLog.i("DynamicFeatureManager", "[stage] need update license, start authenticate");
                f();
                return;
            } else {
                e();
                return;
            }
        }
        String a16 = com.tencent.smtt.sdk.core.dynamicinstall.a.a.a(this.f369335c, b16);
        if (a16 == null) {
            a(-1005, "json format error");
            return;
        }
        String a17 = com.tencent.smtt.sdk.core.dynamicinstall.a.c.a(p.a(this.f369335c).f(), a16);
        if (a17 != null && !a17.isEmpty() && !a17.startsWith("Error")) {
            com.tencent.smtt.sdk.core.dynamicinstall.a.b e16 = com.tencent.smtt.sdk.core.dynamicinstall.a.b.e(a17);
            if (e16 == null) {
                a(-1007, "" + a17);
                return;
            }
            if (e16.d() != 0) {
                a(-1008, "code: " + e16.d() + " msg: " + e16.f());
                return;
            }
            h();
            X5Downloader x5Downloader = new X5Downloader(this.f369335c, QbSdk.PrivateCDNMode.STANDARD_IMPL) { // from class: com.tencent.smtt.sdk.core.dynamicinstall.e.1
                @Override // com.tencent.smtt.sdk.ProgressListener
                public void onFailed(int i3, String str) {
                    e.this.a(i3, str);
                }

                @Override // com.tencent.smtt.sdk.ProgressListener
                public void onFinished() {
                    e.this.a(c17);
                    e.this.f();
                }

                @Override // com.tencent.smtt.sdk.X5Downloader, com.tencent.smtt.sdk.ProgressListener
                public void onProgress(int i3) {
                    if (e.this.f369333a != null) {
                        e.this.f369333a.onProgress(i3);
                    }
                }
            };
            this.f369337e = x5Downloader;
            x5Downloader.setTargetX5Version(e16.e()).setTargetSize(e16.c()).setTargetMD5(e16.b()).setDownloadUrl(e16.a());
            this.f369337e.startDownload();
            return;
        }
        a(-1006, "network error: " + a17);
    }

    public void a(ProgressListener progressListener) {
        this.f369333a = progressListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, String str) {
        TbsLog.i("DynamicInstall", "install failed. code: " + i3 + "; msg: " + str);
        TbsLog.writeLogToDisk();
        ProgressListener progressListener = this.f369333a;
        if (progressListener != null) {
            progressListener.onFailed(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (str == null) {
            return;
        }
        this.f369335c.getSharedPreferences("tbs_download_config", 0).edit().putString("dynamic_install_fin", str).apply();
    }
}
