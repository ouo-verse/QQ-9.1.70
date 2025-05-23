package com.tencent.mobileqq.uniformdownload.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.util.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.List;

/* loaded from: classes17.dex */
public class UniformDownloadPkgInstallReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static UniformDownloadPkgInstallReceiver f305834a;

    /* renamed from: b, reason: collision with root package name */
    private static IntentFilter f305835b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19300);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f305834a = new UniformDownloadPkgInstallReceiver();
        }
    }

    public UniformDownloadPkgInstallReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void b(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        f305835b = intentFilter;
        intentFilter.addDataScheme("package");
        f305835b.addAction("android.intent.action.PACKAGE_ADDED");
        f305835b.addAction("android.intent.action.PACKAGE_REPLACED");
        if (context != null) {
            try {
                context.registerReceiver(f305834a, f305835b);
            } catch (Exception e16) {
                e16.printStackTrace();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public void a(Context context, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) eVar);
            return;
        }
        if (eVar == null) {
            return;
        }
        if (q.f(eVar.f306007c)) {
            QbSdk.openFileWithQB(context, eVar.f306007c, "biz_src_jc_file");
            if (QLog.isDevelopLevel()) {
                QLog.i("UniformDownloadPkgInstallReceiver", 1, "\u6d4f\u89c8\u5668\u5b89\u88c5\u6210\u529f\uff0c\u51c6\u5907\u6253\u5f00\u6587\u4ef6:" + eVar.f306007c);
            }
        }
        if (eVar.f306008d.containsKey(IUniformDownloadMgr.PARAMS_OPEN_WITH_YYB)) {
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).startAppStoreByTmast(eVar.f306008d.getString(IUniformDownloadMgr.PARAMS_OPEN_WITH_YYB, ""), 2);
        }
        if (eVar.f306008d.getBoolean("tbs_new_report", false)) {
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).reportQQBrowserDownloadEvent("stat_download_installed_success");
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).reportQQBrowserDownloadEvent("stat_open_qb_success");
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String action = intent.getAction();
        String dataString = intent.getDataString();
        if (QLog.isColorLevel()) {
            QLog.i("UniformDownloadPkgInstallReceiver", 1, "[UniformDL] package operate broadcast. action:" + action + " pkgName:" + dataString);
        }
        ThreadManagerV2.executeOnSubThread(new Runnable(action, dataString, context) { // from class: com.tencent.mobileqq.uniformdownload.core.UniformDownloadPkgInstallReceiver.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f305836d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f305837e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Context f305838f;

            {
                this.f305836d = action;
                this.f305837e = dataString;
                this.f305838f = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, UniformDownloadPkgInstallReceiver.this, action, dataString, context);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                List<e> c16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (("android.intent.action.PACKAGE_ADDED".equalsIgnoreCase(this.f305836d) || "android.intent.action.PACKAGE_REPLACED".equalsIgnoreCase(this.f305836d)) && (c16 = UniformDownloadMgr.m().o().c(this.f305837e, true)) != null && c16.size() > 0) {
                    for (e eVar : c16) {
                        if (eVar != null) {
                            QLog.i("UniformDownloadPkgInstallReceiver", 1, "[UniformDL] send cancel notification.pkgName:" + this.f305837e + " notificationId:" + eVar.f306006b);
                            b.h().q(eVar.f306006b, null);
                            UniformDownloadPkgInstallReceiver.this.a(this.f305838f, eVar);
                        }
                    }
                }
            }
        });
    }
}
