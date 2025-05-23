package com.tencent.mobileqq.filemanageraux.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.jsp.am;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil;
import com.tencent.mobileqq.webdownload.DownloadURLCheck$ReqDownloadUrlCheckRecmd;
import com.tencent.mobileqq.webdownload.DownloadURLCheck$RspDownloadUrlCheckRecmd;
import com.tencent.open.filedownload.ApkFileDownloadFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.util.MqqWeakReferenceHandler;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class UniformDownload {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f209541b;

    /* renamed from: a, reason: collision with root package name */
    Activity f209542a;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a implements DownloadListener, Handler.Callback, DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;
        private boolean C;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<AppRuntime> f209551d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<Activity> f209552e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference<TouchWebView> f209553f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f209554h;

        /* renamed from: i, reason: collision with root package name */
        private Dialog f209555i;

        /* renamed from: m, reason: collision with root package name */
        final MqqHandler f209556m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanageraux.app.UniformDownload$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class C7588a implements BusinessObserver {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f209557d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f209558e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f209559f;

            C7588a(String str, long j3, boolean z16) {
                this.f209557d = str;
                this.f209558e = j3;
                this.f209559f = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, str, Long.valueOf(j3), Boolean.valueOf(z16));
                }
            }

            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                byte[] byteArray;
                boolean z17;
                boolean z18;
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("UniformDownloadMgr<FileAssistant>", 2, "handleCheck, success: " + z16 + ", canceled: " + a.this.C);
                }
                Activity activity = (Activity) a.this.f209552e.get();
                if (!a.this.C && activity != null && !activity.isFinishing()) {
                    Intent intent = new Intent();
                    intent.putExtra("param_url", this.f209557d);
                    intent.putExtra("_filesize", this.f209558e);
                    intent.putExtra("big_brother_source_key", activity.getIntent().getStringExtra("big_brother_source_key"));
                    if (z16 && (byteArray = bundle.getByteArray("extra_data")) != null) {
                        DownloadURLCheck$RspDownloadUrlCheckRecmd downloadURLCheck$RspDownloadUrlCheckRecmd = new DownloadURLCheck$RspDownloadUrlCheckRecmd();
                        try {
                            downloadURLCheck$RspDownloadUrlCheckRecmd.mergeFrom(byteArray);
                            if (downloadURLCheck$RspDownloadUrlCheckRecmd.err_code.has()) {
                                if (downloadURLCheck$RspDownloadUrlCheckRecmd.err_code.get() == 0) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("UniformDownloadMgr<FileAssistant>", 2, "handleCheck, code: " + downloadURLCheck$RspDownloadUrlCheckRecmd.err_code.get());
                                }
                                if (z17) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UniformDownloadMgr<FileAssistant>", 2, "start download from yyb");
                                    }
                                    if (downloadURLCheck$RspDownloadUrlCheckRecmd.is_white_url.has() && downloadURLCheck$RspDownloadUrlCheckRecmd.is_white_url.get()) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    intent.putExtra("param_in_white_list", z18);
                                    String str2 = null;
                                    if (downloadURLCheck$RspDownloadUrlCheckRecmd.pkg_name.has()) {
                                        str = downloadURLCheck$RspDownloadUrlCheckRecmd.pkg_name.get();
                                    } else {
                                        str = null;
                                    }
                                    intent.putExtra("param_pkg_name", str);
                                    if (downloadURLCheck$RspDownloadUrlCheckRecmd.extra_info.has()) {
                                        str2 = downloadURLCheck$RspDownloadUrlCheckRecmd.extra_info.get();
                                    }
                                    intent.putExtra("param_ext_info", str2);
                                }
                            }
                        } catch (InvalidProtocolBufferMicroException e16) {
                            QLog.e("UniformDownloadMgr<FileAssistant>", 1, e16, new Object[0]);
                        }
                    }
                    PublicFragmentActivity.b.a(activity, intent, PublicFragmentActivity.class, ApkFileDownloadFragment.class);
                    if (this.f209559f) {
                        activity.finish();
                    } else {
                        a.this.f209556m.sendEmptyMessage(2);
                    }
                }
            }
        }

        public a(AppRuntime appRuntime, Activity activity, TouchWebView touchWebView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, appRuntime, activity, touchWebView);
                return;
            }
            this.f209556m = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
            this.f209551d = new WeakReference<>(appRuntime);
            this.f209552e = new WeakReference<>(activity);
            this.f209553f = new WeakReference<>(touchWebView);
            if (touchWebView == null) {
                QLog.e("UniformDownloadMgr<FileAssistant>", 1, "constructor: webview is null");
            }
        }

        private void c(String str, String str2, long j3, Activity activity, AppRuntime appRuntime, boolean z16) {
            if (!z16) {
                this.f209556m.sendEmptyMessage(1);
            }
            DownloadURLCheck$ReqDownloadUrlCheckRecmd downloadURLCheck$ReqDownloadUrlCheckRecmd = new DownloadURLCheck$ReqDownloadUrlCheckRecmd();
            downloadURLCheck$ReqDownloadUrlCheckRecmd.download_url.set(str);
            downloadURLCheck$ReqDownloadUrlCheckRecmd.mime_type.set(str2);
            try {
                downloadURLCheck$ReqDownloadUrlCheckRecmd.uin.set(Long.parseLong(appRuntime.getCurrentAccountUin()));
            } catch (NumberFormatException e16) {
                QLog.e("UniformDownloadMgr<FileAssistant>", 1, e16, new Object[0]);
            }
            NewIntent newIntent = new NewIntent(activity.getApplicationContext(), am.class);
            newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, "QQApkSvc.check_download_url");
            newIntent.putExtra("extra_data", downloadURLCheck$ReqDownloadUrlCheckRecmd.toByteArray());
            newIntent.setObserver(new C7588a(str, j3, z16));
            appRuntime.startServlet(newIntent);
        }

        public void d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                this.f209554h = z16;
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Dialog dialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2 && (dialog = this.f209555i) != null && dialog.isShowing()) {
                    this.f209555i.dismiss();
                }
            } else {
                Activity activity = this.f209552e.get();
                if (activity != null && !activity.isFinishing()) {
                    if (this.f209555i == null) {
                        ReportDialog reportDialog = new ReportDialog(activity);
                        this.f209555i = reportDialog;
                        reportDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        this.f209555i.setCanceledOnTouchOutside(false);
                        this.f209555i.requestWindowFeature(1);
                        this.f209555i.setOnDismissListener(this);
                        this.f209555i.setContentView(R.layout.baj);
                        this.f209555i.findViewById(R.id.f164600a83).setBackgroundColor(0);
                        ((TextView) this.f209555i.findViewById(R.id.jfb)).setText(HardCodeUtil.qqStr(R.string.utw));
                    }
                    this.f209555i.show();
                }
            }
            return true;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) dialogInterface);
            } else {
                this.C = true;
            }
        }

        @Override // com.tencent.smtt.sdk.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j3) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, Long.valueOf(j3));
                return;
            }
            TouchWebView touchWebView = this.f209553f.get();
            Activity activity = this.f209552e.get();
            AppRuntime appRuntime = this.f209551d.get();
            if (touchWebView != null && activity != null && appRuntime != null && !activity.isFinishing()) {
                this.C = false;
                if (touchWebView.getUrl() != null && touchWebView.getUrl().equals(str)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("UniformDownloadMgr<FileAssistant>", 2, "start UniformDownloadActivity: " + str4);
                }
                if ("application/vnd.android.package-archive".equals(str4)) {
                    c(str, str4, j3, activity, appRuntime, z16);
                    return;
                }
                String url = touchWebView.getUrl();
                Bundle bundle = new Bundle();
                bundle.putLong("_filesize", j3);
                bundle.putString("param_user_agent", str2);
                bundle.putString("param_content_des", str3);
                bundle.putString("param_mime_type", str4);
                bundle.putString("param_refer_url", url);
                bundle.putBoolean("fromArkAppDownload", this.f209554h);
                if (UniformDownload.b(activity, str, bundle) && z16) {
                    activity.finish();
                    return;
                }
                return;
            }
            QLog.e("UniformDownloadMgr<FileAssistant>", 1, "download failed, webview=" + touchWebView + ", act=" + activity + ", app=" + appRuntime);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71908);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f209541b = true;
        }
    }

    UniformDownload(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        } else {
            this.f209542a = activity;
        }
    }

    public static boolean b(Activity activity, String str, Bundle bundle) {
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. >>>gotoDownload. url:" + str);
        if (activity != null && str != null && bundle != null) {
            new UniformDownload(activity).a(str, bundle);
            return true;
        }
        QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. gotoDownload. param error:");
        return false;
    }

    public void a(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle);
            return;
        }
        ((IUniformDownloadUtil) QRoute.api(IUniformDownloadUtil.class)).getFileInfoOfUrlAsync(str, new com.tencent.mobileqq.uniformdownload.util.a(bundle, str, bundle.getLong("_filesize"), bundle.getLong("_buttontype", 0L)) { // from class: com.tencent.mobileqq.filemanageraux.app.UniformDownload.1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bundle f209543a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f209544b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f209545c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f209546d;

            {
                this.f209543a = bundle;
                this.f209544b = str;
                this.f209545c = r8;
                this.f209546d = r10;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, UniformDownload.this, bundle, str, Long.valueOf(r8), Long.valueOf(r10));
                }
            }

            @Override // com.tencent.mobileqq.uniformdownload.util.a
            public void a(String str2, long j3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, str2, Long.valueOf(j3));
                    return;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = IUniformDownloadMgr.FILENAME_DEFAULT;
                }
                UniformDownload.this.f209542a.runOnUiThread(new Runnable(str2, j3) { // from class: com.tencent.mobileqq.filemanageraux.app.UniformDownload.1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f209548d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ long f209549e;

                    {
                        this.f209548d = str2;
                        this.f209549e = j3;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, str2, Long.valueOf(j3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        Intent intent = new Intent(UniformDownload.this.f209542a, (Class<?>) UniformDownloadActivity.class);
                        String string = AnonymousClass1.this.f209543a.getString("param_content_memo");
                        String string2 = AnonymousClass1.this.f209543a.getString("param_icon_path");
                        String string3 = AnonymousClass1.this.f209543a.getString("param_mime_type");
                        if (string != null) {
                            intent.putExtra(UniformDownloadActivity.f206362z0, string);
                        }
                        if (string2 != null) {
                            intent.putExtra(UniformDownloadActivity.f206361y0, string2);
                        }
                        intent.putExtra(UniformDownloadActivity.A0, AnonymousClass1.this.f209543a.getBoolean("param_isqbdownload", false));
                        intent.putExtra(UniformDownloadActivity.f206357u0, AnonymousClass1.this.f209544b);
                        intent.putExtra(UniformDownloadActivity.f206359w0, this.f209548d);
                        intent.setFlags(536870912);
                        long j16 = AnonymousClass1.this.f209545c;
                        if (j16 == 0) {
                            j16 = this.f209549e;
                        }
                        intent.putExtra(UniformDownloadActivity.f206360x0, j16);
                        intent.putExtra(UniformDownloadActivity.B0, string3);
                        long j17 = AnonymousClass1.this.f209546d;
                        if (j17 == 1) {
                            intent.putExtra(UniformDownloadActivity.f206358v0, j17);
                        }
                        intent.putExtra("fromArkAppDownload", AnonymousClass1.this.f209543a.getBoolean("fromArkAppDownload", false));
                        intent.putExtra(UniformDownloadActivity.C0, AnonymousClass1.this.f209543a.getString("param_refer_url", ""));
                        Intent intent2 = UniformDownload.this.f209542a.getIntent();
                        if (intent2 != null) {
                            intent.putExtra("big_brother_source_key", intent2.getStringExtra("big_brother_source_key"));
                            intent.putExtra(LaunchParam.KEY_REF_ID, intent2.getStringExtra(LaunchParam.KEY_REF_ID));
                        }
                        UniformDownload.this.f209542a.startActivity(intent);
                        UniformDownload.this.f209542a.overridePendingTransition(0, 0);
                    }
                });
            }
        });
    }
}
