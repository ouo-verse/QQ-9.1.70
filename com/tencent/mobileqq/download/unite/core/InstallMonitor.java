package com.tencent.mobileqq.download.unite.core;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil;
import com.tencent.open.base.g;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class InstallMonitor {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final InstallMonitor f203585a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71526);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f203585a = new InstallMonitor();
            }
        }
    }

    InstallMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean c(String str, List<UniteDownloadEntity> list) {
        boolean z16;
        Iterator<UniteDownloadEntity> it = list.iterator();
        do {
            z16 = false;
            if (!it.hasNext()) {
                return false;
            }
            String str2 = it.next().apkMd5;
            QLog.d("[UniteDownload] InstallMonitor", 2, "[check] containsValidEntity: invoked. ", " expectedApkMd5: ", str2, " actualMd5: ", str);
            if (str != null && str.equals(str2)) {
                z16 = true;
            }
        } while (!z16);
        return true;
    }

    private static String d(Uri uri) {
        String path;
        if (uri == null || (path = uri.getPath()) == null || !path.startsWith("/external_files")) {
            return "";
        }
        String replaceFirst = path.replaceFirst("/external_files", "");
        QLog.d("[UniteDownload] InstallMonitor", 2, "[path] getFilePathFromUri: invoked. ", " realPath: ", replaceFirst);
        return replaceFirst;
    }

    public static InstallMonitor e() {
        return a.f203585a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z16) {
        if (!TextUtils.isEmpty(str)) {
            bv.d("0X800B53F", 0, "", str);
            if (!z16) {
                bv.d("0X800B540", 0, "", str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(String str, String str2, String str3) {
        if (!str3.endsWith(".apk")) {
            return false;
        }
        String b16 = g.b(new File(str3));
        QLog.d("[UniteDownload] InstallMonitor", 2, "[check] validApkMd5: invoked. ", " actualMd5: ", b16, " source: ", str2, " apkPath: ", str3);
        List<UniteDownloadEntity> f16 = UniteDownloadDbOperator.e().f(str, str2);
        if (f16 == null) {
            return false;
        }
        return c(b16, f16);
    }

    public void f(String str, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) intent);
            return;
        }
        String type = intent.getType();
        String stringExtra = intent.getStringExtra("big_brother_source_key");
        Uri data = intent.getData();
        if (QLog.isColorLevel()) {
            QLog.d("[UniteDownload] InstallMonitor", 2, "[check] monitorInstallIntent: invoked. ", " intentType: ", type, " source: ", stringExtra, " uriData: ", data);
        }
        if ("application/vnd.android.package-archive".equals(type)) {
            String d16 = d(data);
            String apkName = ((IUniformDownloadUtil) QRoute.api(IUniformDownloadUtil.class)).getApkName(d16);
            QLog.d("[UniteDownload] InstallMonitor", 2, "[path] monitorInstallIntent: invoked. ", " currentInstallApkPath: ", d16);
            if (d16.endsWith(".apk")) {
                ThreadManagerV2.excute(new Runnable(str, stringExtra, d16, apkName) { // from class: com.tencent.mobileqq.download.unite.core.InstallMonitor.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f203581d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f203582e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f203583f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ String f203584h;

                    {
                        this.f203581d = str;
                        this.f203582e = stringExtra;
                        this.f203583f = d16;
                        this.f203584h = apkName;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, InstallMonitor.this, str, stringExtra, d16, apkName);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            boolean h16 = InstallMonitor.this.h(this.f203581d, this.f203582e, this.f203583f);
                            QLog.d("[UniteDownload] InstallMonitor", 2, "[check] monitorInstallIntent: invoked. ", " validApkMd5: ", Boolean.valueOf(h16));
                            InstallMonitor.this.g(this.f203584h, h16);
                            return;
                        }
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }, 32, null, false);
            }
        }
    }
}
