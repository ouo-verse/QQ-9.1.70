package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.launch.MiniAppMainServiceApiManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.X5UpdateGuard;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes34.dex */
public class X5UpdateGuard implements TbsListener {

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f347684f = new byte[0];

    /* renamed from: g, reason: collision with root package name */
    private static X5UpdateGuard f347685g;

    /* renamed from: b, reason: collision with root package name */
    private IMiniAppContext f347687b;

    /* renamed from: c, reason: collision with root package name */
    private e f347688c;

    /* renamed from: d, reason: collision with root package name */
    private f f347689d;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f347686a = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f347690e = new AnonymousClass1();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqmini.proxyimpl.X5UpdateGuard$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            X5UpdateGuard.this.s();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            X5UpdateGuard.this.t();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(boolean z16, int i3) {
            if (X5UpdateGuard.this.f347687b != null) {
                X5UpdateGuard x5UpdateGuard = X5UpdateGuard.this;
                x5UpdateGuard.u(x5UpdateGuard.f347687b.getContext(), z16, i3);
            }
            if (z16) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.cl
                    @Override // java.lang.Runnable
                    public final void run() {
                        X5UpdateGuard.AnonymousClass1.this.e();
                    }
                });
            } else {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.cm
                    @Override // java.lang.Runnable
                    public final void run() {
                        X5UpdateGuard.AnonymousClass1.this.f();
                    }
                });
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            QLog.e("minisdk_X5UpdateGuard", 1, "timeout!");
            TbsDownloader.needDownload(X5UpdateGuard.this.f347687b.getContext(), false, true, true, new TbsDownloader.TbsDownloaderCallback() { // from class: com.tencent.qqmini.proxyimpl.ck
                @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
                public final void onNeedDownloadFinish(boolean z16, int i3) {
                    X5UpdateGuard.AnonymousClass1.this.g(z16, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.e("minisdk_X5UpdateGuard", 2, "cancel");
            X5UpdateGuard.this.f347687b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMiniAppContext f347695d;

        b(IMiniAppContext iMiniAppContext) {
            this.f347695d = iMiniAppContext;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(IMiniAppContext iMiniAppContext) {
            X5UpdateGuard.this.w(iMiniAppContext.getAttachActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            X5UpdateGuard.this.t();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(final IMiniAppContext iMiniAppContext, boolean z16, int i3) {
            X5UpdateGuard.this.u(iMiniAppContext.getContext(), z16, i3);
            if (z16) {
                X5UpdateGuard.this.f347686a.postDelayed(X5UpdateGuard.this.f347690e, 15000L);
                QbSdk.setTbsListener(X5UpdateGuard.this);
                TbsDownloader.startDownload(iMiniAppContext.getContext(), true);
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.co
                    @Override // java.lang.Runnable
                    public final void run() {
                        X5UpdateGuard.b.this.d(iMiniAppContext);
                    }
                });
                X5UpdateGuard.this.m();
                return;
            }
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.cp
                @Override // java.lang.Runnable
                public final void run() {
                    X5UpdateGuard.b.this.e();
                }
            });
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.e("minisdk_X5UpdateGuard", 2, MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
            Context context = this.f347695d.getContext();
            final IMiniAppContext iMiniAppContext = this.f347695d;
            TbsDownloader.needDownload(context, false, true, true, new TbsDownloader.TbsDownloaderCallback() { // from class: com.tencent.qqmini.proxyimpl.cn
                @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
                public final void onNeedDownloadFinish(boolean z16, int i16) {
                    X5UpdateGuard.b.this.f(iMiniAppContext, z16, i16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.i("minisdk_X5UpdateGuard", 1, "cancel");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.i("minisdk_X5UpdateGuard", 1, MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
            MiniAppMainServiceApiManager.INSTANCE.sendCmd("cmd_exit_qq", new Bundle(), null);
            AppLoaderFactory.getMiniAppInterface().exitProcess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        SharedPreferences preference = StorageUtil.getPreference();
        preference.edit().putInt("sp_key_x5_download_count", preference.getInt("sp_key_x5_download_count", 0) + 1).apply();
        preference.edit().putLong("sp_key_x5_last_download_time", o()).apply();
    }

    public static X5UpdateGuard n() {
        if (f347685g == null) {
            synchronized (f347684f) {
                if (f347685g == null) {
                    f347685g = new X5UpdateGuard();
                }
            }
        }
        return f347685g;
    }

    private long o() {
        return (((System.currentTimeMillis() / 1000) / 60) / 60) / 24;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        v(this.f347687b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(boolean z16, int i3) {
        u(this.f347687b.getContext(), z16, i3);
        if (z16) {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.cj
                @Override // java.lang.Runnable
                public final void run() {
                    X5UpdateGuard.this.p();
                }
            });
        }
    }

    private boolean r() {
        long j3 = StorageUtil.getPreference().getLong("sp_key_x5_last_download_time", 0L);
        long o16 = o();
        int config = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppDownloadX5LimitTimeCacheDuration", 30);
        SharedPreferences preference = StorageUtil.getPreference();
        int i3 = preference.getInt("sp_key_x5_download_count", 0);
        if (j3 > 0 && o16 - j3 > config) {
            preference.edit().remove("sp_key_x5_download_count").apply();
            i3 = 0;
        }
        return i3 < QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppDownloadX5LimitTime", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        try {
            QLog.e("minisdk_X5UpdateGuard", 1, "Tbs onX5Failed");
            e eVar = this.f347688c;
            if (eVar != null && eVar.isShowing()) {
                this.f347688c.dismiss();
            }
            IMiniAppContext iMiniAppContext = this.f347687b;
            if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null) {
                QQToast.makeText(this.f347687b.getAttachActivity(), HardCodeUtil.qqStr(R.string.nil), 0).show();
                this.f347687b = null;
                return;
            }
            QLog.e("minisdk_X5UpdateGuard", 1, "Tbs onX5Failed, currMiniAppContext or activity is null!");
        } catch (Throwable th5) {
            QLog.e("minisdk_X5UpdateGuard", 1, "", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        try {
            QLog.i("minisdk_X5UpdateGuard", 1, "Tbs onX5Succeed");
            e eVar = this.f347688c;
            if (eVar != null && eVar.isShowing()) {
                this.f347688c.dismiss();
            }
            if (this.f347689d == null) {
                IMiniAppContext iMiniAppContext = this.f347687b;
                if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null) {
                    Activity attachActivity = this.f347687b.getAttachActivity();
                    String config = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppDownloadX5RestartQQTitle", "\u5347\u7ea7\u5b8c\u6210");
                    String config2 = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppDownloadX5RestartQQContent", "\u5c0f\u7a0b\u5e8f\u5347\u7ea7\u5b8c\u6210\uff0c\u91cd\u542f\u624b\u673aQQ\u540e\u7acb\u5373\u751f\u6548");
                    f fVar = new f(attachActivity, R.style.qZoneInputDialog);
                    this.f347689d = fVar;
                    fVar.setTitle(config);
                    this.f347689d.setMessage(config2);
                    this.f347689d.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), new c());
                    this.f347689d.setPositiveButton(HardCodeUtil.qqStr(R.string.ket), new d());
                    this.f347689d.setCanceledOnTouchOutside(false);
                }
                QLog.e("minisdk_X5UpdateGuard", 1, "Tbs onX5Succeed, activity null");
                return;
            }
            if (!this.f347689d.isShowing()) {
                this.f347689d.show();
            }
            this.f347687b = null;
        } catch (Throwable th5) {
            QLog.e("minisdk_X5UpdateGuard", 1, "onX5Succeed exception: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Context context, boolean z16, int i3) {
        QLog.i("minisdk_X5UpdateGuard", 1, "tbsServerVersion=" + i3 + " getTbsVersion=" + QbSdk.getTbsVersion(context) + " getTmpDirTbsVersion=" + QbSdk.getTmpDirTbsVersion(context) + " needDownload=" + z16);
    }

    @Override // com.tencent.smtt.sdk.TbsListener
    public void onDownloadFinish(final int i3) {
        this.f347686a.removeCallbacks(this.f347690e);
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.X5UpdateGuard.4
            @Override // java.lang.Runnable
            public void run() {
                int i16 = i3;
                if (i16 == 0) {
                    QLog.e("minisdk_X5UpdateGuard", 1, "Tbs onDownloadFinish unknown result=" + i3);
                    return;
                }
                if (i16 == 100) {
                    QLog.i("minisdk_X5UpdateGuard", 1, "Tbs onDownloadFinish result=" + i3);
                    return;
                }
                QLog.e("minisdk_X5UpdateGuard", 1, "Tbs onDownloadFinish fail, result=" + i3);
                X5UpdateGuard.this.s();
            }
        });
    }

    @Override // com.tencent.smtt.sdk.TbsListener
    public void onDownloadProgress(final int i3) {
        QLog.i("minisdk_X5UpdateGuard", 1, "Tbs install onDownloadProgress=" + i3);
        this.f347686a.removeCallbacks(this.f347690e);
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.X5UpdateGuard.6
            @Override // java.lang.Runnable
            public void run() {
                if (X5UpdateGuard.this.f347688c == null || !X5UpdateGuard.this.f347688c.isShowing()) {
                    return;
                }
                X5UpdateGuard.this.f347688c.a(HardCodeUtil.qqStr(R.string.nig) + i3 + "%");
            }
        });
    }

    @Override // com.tencent.smtt.sdk.TbsListener
    public void onInstallFinish(final int i3) {
        this.f347686a.removeCallbacks(this.f347690e);
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.X5UpdateGuard.5
            @Override // java.lang.Runnable
            public void run() {
                int i16 = i3;
                if (i16 != 200 && i16 != 220) {
                    QLog.e("minisdk_X5UpdateGuard", 1, "Tbs onInstallFinish fail, result=" + i3);
                    X5UpdateGuard.this.s();
                    return;
                }
                QLog.i("minisdk_X5UpdateGuard", 1, "Tbs onInstallFinish result=" + i3);
                X5UpdateGuard.this.t();
            }
        });
    }

    public void x(IMiniAppContext iMiniAppContext) {
        if (iMiniAppContext == null) {
            QLog.e("minisdk_X5UpdateGuard", 1, "showX5Guide miniAppContext == null");
            return;
        }
        if (iMiniAppContext.getAttachActivity() == null) {
            QLog.e("minisdk_X5UpdateGuard", 1, "showX5Guide miniAppContext.getAttachedActivity() == null");
        } else if (!r()) {
            QLog.e("minisdk_X5UpdateGuard", 1, "showX5Guide needShowDialog==false");
        } else {
            this.f347687b = iMiniAppContext;
            TbsDownloader.needDownload(iMiniAppContext.getContext(), false, true, true, new TbsDownloader.TbsDownloaderCallback() { // from class: com.tencent.qqmini.proxyimpl.ci
                @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
                public final void onNeedDownloadFinish(boolean z16, int i3) {
                    X5UpdateGuard.this.q(z16, i3);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class e extends Dialog {
        @Override // android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            try {
                super.dismiss();
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }

        @Override // android.app.Dialog
        public void show() {
            try {
                super.show();
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }

        e(Context context) {
            super(context, R.style.f174063on);
            setContentView(R.layout.f169003bk1);
            getWindow().setFlags(1024, 2048);
        }

        public void a(String str) {
            ((TextView) findViewById(R.id.title)).setText(str);
        }

        @Override // android.app.Dialog
        public void setTitle(int i3) {
            a(i3 == 0 ? null : getContext().getResources().getString(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class f extends QQCustomDialog {
        private Activity C;

        public f(Activity activity, int i3) {
            super(activity, i3);
            this.C = activity;
            initUI();
        }

        public void initUI() {
            setContentView(R.layout.f167845je);
            findViewById(R.id.e2z).setVisibility(8);
        }
    }

    private void v(IMiniAppContext iMiniAppContext) {
        if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null) {
            Activity attachActivity = iMiniAppContext.getAttachActivity();
            String config = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppDownloadX5DialogTitle", "\u66f4\u65b0\u63d0\u9192");
            String config2 = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppDownloadX5DialogContent", "\u5c0f\u7a0b\u5e8f\u5347\u7ea7\uff0c\u5347\u7ea7\u540e\u53ef\u6b63\u5e38\u8fd0\u884c");
            f fVar = new f(attachActivity, R.style.qZoneInputDialog);
            fVar.setTitle(config);
            fVar.setMessage(config2);
            fVar.setNegativeButton("\u53d6\u6d88", new a());
            fVar.setPositiveButton("\u786e\u5b9a", new b(iMiniAppContext));
            fVar.setCanceledOnTouchOutside(true);
            fVar.show();
            return;
        }
        QLog.e("minisdk_X5UpdateGuard", 1, "showDownloadDialog activity null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Context context) {
        if (context == null) {
            QLog.e("minisdk_X5UpdateGuard", 1, "showLoadingDialog, activity null");
            return;
        }
        if (this.f347688c == null) {
            this.f347688c = new e(context);
        }
        this.f347688c.a(HardCodeUtil.qqStr(R.string.nik));
        if (this.f347688c.isShowing()) {
            return;
        }
        this.f347688c.show();
    }
}
