package com.tencent.mobileqq.filemanager.activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.j;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.n;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.ag;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.u;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportX5CoreWebChromeClient;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@SuppressLint({"NewApi"})
/* loaded from: classes12.dex */
public class FilePreviewActivity extends BaseFileViewerActivity {
    private TeamWorkFileImportInfo H0;
    private QQProgressDialog I0;
    n S0;

    /* renamed from: c0, reason: collision with root package name */
    RelativeLayout f206236c0;

    /* renamed from: d0, reason: collision with root package name */
    FileWebView f206237d0;

    /* renamed from: e0, reason: collision with root package name */
    String f206238e0;

    /* renamed from: f0, reason: collision with root package name */
    String f206239f0;

    /* renamed from: m0, reason: collision with root package name */
    String f206246m0;

    /* renamed from: n0, reason: collision with root package name */
    String f206247n0;

    /* renamed from: p0, reason: collision with root package name */
    String f206249p0;

    /* renamed from: q0, reason: collision with root package name */
    String f206250q0;

    /* renamed from: t0, reason: collision with root package name */
    String f206253t0;

    /* renamed from: a0, reason: collision with root package name */
    com.tencent.mobileqq.filemanager.core.f f206234a0 = null;

    /* renamed from: b0, reason: collision with root package name */
    com.tencent.mobileqq.filemanager.core.b f206235b0 = null;

    /* renamed from: g0, reason: collision with root package name */
    String f206240g0 = null;

    /* renamed from: h0, reason: collision with root package name */
    String f206241h0 = null;

    /* renamed from: i0, reason: collision with root package name */
    int f206242i0 = -1;

    /* renamed from: j0, reason: collision with root package name */
    int f206243j0 = -1;

    /* renamed from: k0, reason: collision with root package name */
    int f206244k0 = -1;

    /* renamed from: l0, reason: collision with root package name */
    boolean f206245l0 = false;

    /* renamed from: o0, reason: collision with root package name */
    ViewGroup f206248o0 = null;

    /* renamed from: r0, reason: collision with root package name */
    boolean f206251r0 = false;

    /* renamed from: s0, reason: collision with root package name */
    long f206252s0 = -1;

    /* renamed from: u0, reason: collision with root package name */
    LinearLayout f206254u0 = null;

    /* renamed from: v0, reason: collision with root package name */
    TextView f206255v0 = null;

    /* renamed from: w0, reason: collision with root package name */
    ImageView f206256w0 = null;

    /* renamed from: x0, reason: collision with root package name */
    TextView f206257x0 = null;

    /* renamed from: y0, reason: collision with root package name */
    ProgressBar f206258y0 = null;

    /* renamed from: z0, reason: collision with root package name */
    TextView f206259z0 = null;
    LinearLayout A0 = null;
    View.OnClickListener B0 = null;
    j C0 = null;
    FileWebView.a D0 = null;
    String E0 = null;
    String F0 = null;
    boolean G0 = false;
    private ag J0 = new a();
    boolean K0 = false;
    boolean L0 = false;
    boolean M0 = false;
    long N0 = 0;
    long O0 = 0;
    boolean P0 = false;
    n Q0 = null;
    n R0 = null;

    /* loaded from: classes12.dex */
    class a extends ag {
        a() {
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void a(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            super.a(teamWorkFileImportInfo);
            if (FilePreviewActivity.this.I0 != null && FilePreviewActivity.this.I0.isShowing()) {
                FilePreviewActivity.this.I0.dismiss();
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void e(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            super.e(str, teamWorkFileImportInfo);
            if (FilePreviewActivity.this.I0 != null && FilePreviewActivity.this.I0.isShowing()) {
                FilePreviewActivity.this.I0.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FilePreviewActivity.this.setResult(0, new Intent());
            FilePreviewActivity.this.finish();
            FilePreviewActivity.this.overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.o(FilePreviewActivity.this.app, "dc00898", "", "", "0X8009065", "0X8009065", 0, 0, "", "", "", "");
            FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
            QQAppInterface qQAppInterface = filePreviewActivity.app;
            TeamWorkFileImportInfo teamWorkFileImportInfo = filePreviewActivity.H0;
            FilePreviewActivity filePreviewActivity2 = FilePreviewActivity.this;
            filePreviewActivity.I0 = u.s(qQAppInterface, teamWorkFileImportInfo, filePreviewActivity2, "<FileAssistant>FilePreviewActivity", filePreviewActivity2.getString(R.string.hyg), true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.o(FilePreviewActivity.this.app, "dc00898", "", "", "0X8008A32", "0X8008A32", 0, 0, "", "", "", "");
            FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
            QQAppInterface qQAppInterface = filePreviewActivity.app;
            TeamWorkFileImportInfo teamWorkFileImportInfo = filePreviewActivity.H0;
            FilePreviewActivity filePreviewActivity2 = FilePreviewActivity.this;
            filePreviewActivity.I0 = u.s(qQAppInterface, teamWorkFileImportInfo, filePreviewActivity2, "<FileAssistant>FilePreviewActivity", filePreviewActivity2.getString(R.string.hyh), false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class f implements com.tencent.mobileqq.filemanager.core.b {
        f() {
        }

        @Override // com.tencent.mobileqq.filemanager.core.b
        public void a(boolean z16, String str, String str2, long j3, String str3, String str4, String str5, String str6, Bundle bundle) {
            String str7;
            FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
            if (filePreviewActivity.K0) {
                return;
            }
            j jVar = filePreviewActivity.C0;
            if (jVar != null) {
                jVar.f207811t = System.currentTimeMillis();
            }
            FilePreviewActivity.this.K0 = true;
            boolean z17 = false;
            if (!z16) {
                if (str3 != null && str3.length() > 0) {
                    FilePreviewActivity.this.f206257x0.setText(str3);
                } else {
                    FilePreviewActivity.this.f206257x0.setText(HardCodeUtil.qqStr(R.string.mju));
                }
                FilePreviewActivity.this.A0.setVisibility(0);
                FilePreviewActivity.this.A0.setOnClickListener(null);
                FilePreviewActivity.this.f206256w0.setVisibility(0);
                FilePreviewActivity.this.f206257x0.setVisibility(0);
                FilePreviewActivity filePreviewActivity2 = FilePreviewActivity.this;
                filePreviewActivity2.P0 = true;
                filePreviewActivity2.stopTitleProgress();
                j jVar2 = FilePreviewActivity.this.C0;
                if (jVar2 != null) {
                    jVar2.f207808q = false;
                    jVar2.f207806o = jVar2.f207811t - jVar2.f207810s;
                    jVar2.f207796e = String.valueOf(j3);
                    j jVar3 = FilePreviewActivity.this.C0;
                    jVar3.f207802k = str3;
                    jVar3.f207795d = str6;
                    long currentTimeMillis = System.currentTimeMillis();
                    j jVar4 = FilePreviewActivity.this.C0;
                    jVar3.f207807p = currentTimeMillis - jVar4.f207793b;
                    jVar4.b();
                }
                if (QLog.isColorLevel()) {
                    QLog.e("<FileAssistant>FilePreviewActivity", 2, "OnCSReplay[false],retMsg[" + str3 + "]");
                    return;
                }
                return;
            }
            if (bundle != null) {
                boolean z18 = bundle.getBoolean("ishttps", false);
                if (z18) {
                    str7 = bundle.getString("httpsdomain", null);
                    FilePreviewActivity.this.f206250q0 = ((int) bundle.getShort("httpsport", (short) 0)) + "";
                } else {
                    str7 = str;
                }
                z17 = z18;
            } else {
                str7 = str;
            }
            FilePreviewActivity filePreviewActivity3 = FilePreviewActivity.this;
            filePreviewActivity3.f206249p0 = str7;
            filePreviewActivity3.f206250q0 = str2;
            filePreviewActivity3.f206251r0 = z17;
            filePreviewActivity3.f206246m0 = str4;
            filePreviewActivity3.f206247n0 = str5;
            if (z17) {
                filePreviewActivity3.f206238e0 = "https://" + str7 + ":" + str2 + "/ftn_doc_previewer/" + FilePreviewActivity.this.f206253t0;
            } else {
                filePreviewActivity3.f206238e0 = "http://" + str7 + ":" + str2 + "/ftn_doc_previewer/" + FilePreviewActivity.this.f206253t0;
            }
            FilePreviewActivity filePreviewActivity4 = FilePreviewActivity.this;
            filePreviewActivity4.E0 = str6;
            j jVar5 = filePreviewActivity4.C0;
            if (jVar5 != null) {
                jVar5.f207808q = true;
                jVar5.f207799h = str4;
                jVar5.f207802k = "";
                jVar5.f207811t = System.currentTimeMillis();
                FilePreviewActivity filePreviewActivity5 = FilePreviewActivity.this;
                j jVar6 = filePreviewActivity5.C0;
                jVar6.f207806o = jVar6.f207811t - jVar6.f207810s;
                jVar6.f207794c = str7;
                jVar6.f207798g = filePreviewActivity5.f206238e0;
                jVar6.f207795d = str6;
                long currentTimeMillis2 = System.currentTimeMillis();
                j jVar7 = FilePreviewActivity.this.C0;
                jVar6.f207807p = currentTimeMillis2 - jVar7.f207793b;
                jVar7.b();
            }
            FilePreviewActivity filePreviewActivity6 = FilePreviewActivity.this;
            String str8 = filePreviewActivity6.f206238e0;
            if (str8 == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("<FileAssistant>FilePreviewActivity", 2, "mPreviewUrl is null ,threadid[" + Thread.currentThread().getId() + "], mainId[" + Looper.getMainLooper().getThread().getId() + "]");
                }
                FilePreviewActivity.this.finish();
                return;
            }
            filePreviewActivity6.f206237d0.loadUrl(str8);
            if (QLog.isColorLevel()) {
                QLog.i("<FileAssistant>FilePreviewActivity", 2, "time[" + System.currentTimeMillis() + "]OnCSReplay mWebView.loadUrl(" + FilePreviewActivity.this.f206238e0 + ")");
            }
            j jVar8 = FilePreviewActivity.this.C0;
            if (jVar8 != null) {
                jVar8.f207810s = System.currentTimeMillis();
                FilePreviewActivity.this.C0.f207805n = "2";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class g extends WebViewClient {

        /* renamed from: b, reason: collision with root package name */
        long f206293b = 0;

        g() {
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            String str2;
            String str3;
            FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
            if (filePreviewActivity.M0) {
                super.onPageFinished(webView, str);
                return;
            }
            boolean z16 = filePreviewActivity.f206245l0;
            if (z16) {
                filePreviewActivity.M0 = true;
            }
            if (z16) {
                int i3 = filePreviewActivity.f206242i0;
                if (i3 == 0) {
                    String str4 = filePreviewActivity.f206249p0;
                    int i16 = filePreviewActivity.f206243j0;
                    int parseInt = Integer.parseInt(filePreviewActivity.f206250q0);
                    FilePreviewActivity filePreviewActivity2 = FilePreviewActivity.this;
                    str3 = filePreviewActivity.getInitString(str4, i16, parseInt, filePreviewActivity2.f206246m0, filePreviewActivity2.f206247n0, null);
                } else if (i3 == 1) {
                    String str5 = filePreviewActivity.f206249p0;
                    int i17 = filePreviewActivity.f206243j0;
                    int parseInt2 = Integer.parseInt(filePreviewActivity.f206250q0);
                    FilePreviewActivity filePreviewActivity3 = FilePreviewActivity.this;
                    str3 = filePreviewActivity.getInitString(str5, i17, parseInt2, filePreviewActivity3.f206246m0, filePreviewActivity3.f206247n0, filePreviewActivity3.f206240g0);
                } else if (!QLog.isDevelopLevel()) {
                    str3 = null;
                } else {
                    throw new NullPointerException(HardCodeUtil.qqStr(R.string.mjv));
                }
                QLog.i("<FileAssistant>FilePreviewActivity", 1, "finish load run javascript![" + str3 + "]");
                FilePreviewActivity.this.f206237d0.loadUrl(str3);
                str2 = "javascript:qpreview.onClientResponse('showFileList', {})";
                QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('showFileList', {})");
            } else {
                String str6 = filePreviewActivity.f206249p0;
                int i18 = filePreviewActivity.f206243j0;
                int parseInt3 = Integer.parseInt(filePreviewActivity.f206250q0);
                FilePreviewActivity filePreviewActivity4 = FilePreviewActivity.this;
                String initString = filePreviewActivity.getInitString(str6, i18, parseInt3, filePreviewActivity4.f206246m0, filePreviewActivity4.f206247n0, null);
                QLog.i("<FileAssistant>FilePreviewActivity", 1, "finish load run javascript![" + initString + "]");
                FilePreviewActivity.this.f206237d0.loadUrl(initString);
                str2 = "javascript:qpreview.onClientResponse('addMorePage',{})";
                QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('addMorePage',{})");
            }
            QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + str2 + ")");
            FilePreviewActivity.this.f206237d0.loadUrl(str2);
            FilePreviewActivity.this.M0 = true;
            super.onPageFinished(webView, str);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (Exception unused) {
            }
            try {
                if (QLog.isColorLevel()) {
                    QLog.i("<FileAssistant>FilePreviewActivity", 1, "URLDecoder.decode, url:" + str);
                }
                FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                if (filePreviewActivity.f206237d0.p(webView, str, filePreviewActivity.D0)) {
                    return true;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("<FileAssistant>FilePreviewActivity", 2, "parseUrl error,exception:" + e16.toString());
                }
            }
            if (str != null && !"".equals(str) && !"about:blank;".equals(str) && !"about:blank".equals(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f206293b < 1500) {
                    return true;
                }
                this.f206293b = currentTimeMillis;
                QLog.i("<FileAssistant>FilePreviewActivity", 1, "start load new[" + str + "]");
                try {
                    URLDecoder.decode(FilePreviewActivity.this.U2(str), "UTF-8");
                } catch (UnsupportedEncodingException e17) {
                    e17.printStackTrace();
                }
                return true;
            }
            QLog.e("<FileAssistant>FilePreviewActivity", 1, "request url is null,or about:blank! return");
            return true;
        }
    }

    private void M2(boolean z16, boolean z17) {
        if (!this.G0) {
            return;
        }
        View inflate = ((ViewStub) findViewById(R.id.ba8)).inflate();
        inflate.setPadding(0, 0, 70, 120);
        View findViewById = inflate.findViewById(R.id.kbn);
        View findViewById2 = inflate.findViewById(R.id.kbo);
        this.app.addObserver(this.J0);
        if (!z16) {
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        } else {
            ReportController.o(this.app, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
        }
        if (!z17) {
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else {
            ReportController.o(this.app, "dc00898", "", "", "0X8008A30", "0X8008A30", 0, 0, "", "", "", "");
        }
        if (findViewById != null && z16) {
            findViewById.setOnClickListener(new d());
        }
        if (findViewById2 != null && z17) {
            findViewById2.setOnClickListener(new e());
        }
    }

    private FileWebView.b N2() {
        final Handler handler = new Handler();
        return new FileWebView.b() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.9

            /* renamed from: a, reason: collision with root package name */
            long f206280a = 0;

            @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
            public void a() {
                FilePreviewActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.9.3
                    @Override // java.lang.Runnable
                    public void run() {
                        String str = null;
                        handler.removeCallbacksAndMessages(null);
                        try {
                            str = (String) FilePreviewActivity.this.f206255v0.getText();
                        } catch (Exception unused) {
                        }
                        if (str != null && str.length() != 0) {
                            FilePreviewActivity.this.f206255v0.clearAnimation();
                            FilePreviewActivity.this.f206255v0.setVisibility(0);
                        }
                    }
                });
            }

            @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
            public void b(boolean z16) {
                FilePreviewActivity.this.f3();
            }

            @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
            public void c() {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f206280a < 1000) {
                    return;
                }
                this.f206280a = currentTimeMillis;
                FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                if (filePreviewActivity.f206245l0) {
                    return;
                }
                if (filePreviewActivity.P0) {
                    filePreviewActivity.f3();
                    return;
                }
                j jVar = filePreviewActivity.C0;
                if (jVar != null) {
                    jVar.f207805n = "3";
                    jVar.f207810s = System.currentTimeMillis();
                }
                if (!NetworkUtil.isNetSupport(FilePreviewActivity.this.getActivity())) {
                    FilePreviewActivity.this.f206258y0.setVisibility(8);
                    FilePreviewActivity.this.f206259z0.setText(R.string.c5o);
                    FilePreviewActivity.this.f206259z0.setVisibility(0);
                    FilePreviewActivity.this.f206254u0.setVisibility(0);
                    j jVar2 = FilePreviewActivity.this.C0;
                    if (jVar2 != null) {
                        jVar2.f207811t = System.currentTimeMillis();
                        j jVar3 = FilePreviewActivity.this.C0;
                        jVar3.f207806o = jVar3.f207811t - jVar3.f207810s;
                        jVar3.f207808q = false;
                        jVar3.f207796e = "2";
                        long currentTimeMillis2 = System.currentTimeMillis();
                        j jVar4 = FilePreviewActivity.this.C0;
                        jVar3.f207807p = currentTimeMillis2 - jVar4.f207793b;
                        jVar4.b();
                    }
                    FilePreviewActivity.this.V2(5000);
                    return;
                }
                FilePreviewActivity.this.e3();
                new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            FilePreviewActivity.this.f206237d0.loadUrl("javascript:qpreview.onClientResponse('addMorePage',{})");
                        } catch (Exception e16) {
                            QLog.e("<FileAssistant>FilePreviewActivity", 1, e16.toString());
                        }
                    }
                }, 1500L);
            }

            @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
            public void d() {
                FilePreviewActivity.this.V2(1000);
            }

            @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
            public void e() {
                FilePreviewActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.9.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FilePreviewActivity.this.f206248o0.getVisibility() == 0) {
                            FilePreviewActivity.this.Y2();
                        } else {
                            FilePreviewActivity.this.f3();
                        }
                    }
                });
            }

            @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
            public void f() {
                handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.9.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FilePreviewActivity.this.W2();
                    }
                }, 3000L);
                QLog.i("<FileAssistant>FilePreviewActivity", 1, "postDelayed(newRunnable, 3000)");
            }

            @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
            public void g() {
                FilePreviewActivity.this.Y2();
            }

            @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
            public void h() {
                if (FilePreviewActivity.this.P0) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f206280a < 1000) {
                    return;
                }
                this.f206280a = currentTimeMillis;
                FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                if (filePreviewActivity.f206245l0) {
                    return;
                }
                filePreviewActivity.f206237d0.loadUrl("javascript:qpreview.onClientResponse('addMorePage',{})");
            }
        };
    }

    private FileWebView.b P2() {
        return new AnonymousClass10();
    }

    private WebViewClient Q2() {
        return new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean T2() {
        if (QLog.isColorLevel()) {
            QLog.i("<FileAssistant>FilePreviewActivity", 2, "call controller.sendCS()");
        }
        this.N0 = System.currentTimeMillis();
        j jVar = new j(this.app.getCurrentAccountUin());
        this.C0 = jVar;
        long currentTimeMillis = System.currentTimeMillis();
        jVar.f207793b = currentTimeMillis;
        jVar.f207810s = currentTimeMillis;
        this.C0.f207804m = String.valueOf(this.F0);
        j jVar2 = this.C0;
        jVar2.f207805n = "1";
        String str = this.f206239f0;
        jVar2.f207801j = str;
        jVar2.f207803l = q.j(str).replace(".", "").toLowerCase();
        this.C0.f207797f = this.f206252s0;
        return this.f206234a0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String U2(String str) {
        int lastIndexOf = str.lastIndexOf("/") + 1;
        int lastIndexOf2 = str.lastIndexOf(ContainerUtils.FIELD_DELIMITER);
        if (lastIndexOf2 < lastIndexOf) {
            lastIndexOf2 = str.length();
        }
        return str.substring(lastIndexOf, lastIndexOf2);
    }

    private synchronized void Z2() {
        this.f206235b0 = new f();
    }

    private boolean c3(Intent intent) {
        int intExtra = intent.getIntExtra("offline_file_type", -1);
        this.f206242i0 = intExtra;
        if (intExtra == -1) {
            return false;
        }
        this.f206239f0 = intent.getStringExtra("offline_file_name");
        if (this.f206242i0 == 1) {
            this.f206240g0 = intent.getStringExtra("OfflinePreZipPath");
        }
        this.f206239f0 = intent.getStringExtra("offline_file_name");
        String previewConfig = ((IFMConfig) QRoute.api(IFMConfig.class)).getPreviewConfig(this, this.f206239f0, "FileType");
        this.f206253t0 = ((IFMConfig) QRoute.api(IFMConfig.class)).getPreviewConfig(this, this.f206239f0, "InterfacePage");
        String previewConfig2 = ((IFMConfig) QRoute.api(IFMConfig.class)).getPreviewConfig(this, this.f206239f0, "PreviewMode");
        this.f206249p0 = intent.getStringExtra("offline_file_domain");
        this.f206250q0 = intent.getStringExtra("offline_file_port");
        this.f206246m0 = intent.getStringExtra("offline_file_domain_key");
        this.f206243j0 = intent.getIntExtra("offline_file_type_key", -1);
        this.f206247n0 = intent.getStringExtra("COOKIE");
        this.G0 = intent.getBooleanExtra("offline_file_show_team_work_menu", false);
        TeamWorkFileImportInfo teamWorkFileImportInfo = (TeamWorkFileImportInfo) intent.getParcelableExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO);
        this.H0 = teamWorkFileImportInfo;
        if (teamWorkFileImportInfo != null) {
            teamWorkFileImportInfo.J = 3;
        }
        if (previewConfig != null && previewConfig.length() > 0) {
            this.f206243j0 = Integer.parseInt(previewConfig);
        }
        if (previewConfig2 != null && previewConfig2.length() > 0) {
            this.f206244k0 = Integer.parseInt(previewConfig2);
        }
        if (this.f206242i0 != 0) {
            this.f206245l0 = intent.getBooleanExtra("offline_file_bZip", false);
        } else {
            this.f206245l0 = FileManagerUtil.bZip(this.f206244k0);
        }
        if (L2()) {
            setContentViewForImage(R.layout.amd);
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.iep);
                relativeLayout.setFitsSystemWindows(true);
                relativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
            }
        } else {
            setContentView(R.layout.amd);
        }
        initWebView();
        if (this.f206242i0 == 0) {
            com.tencent.mobileqq.filemanager.core.f l3 = this.app.getFileManagerDataCenter().l();
            this.f206234a0 = l3;
            if (l3 == null) {
                QLog.e("<FileAssistant>FilePreviewActivity", 1, "controller is null, should finish it!");
                finish();
                return false;
            }
            this.F0 = String.valueOf(l3.b());
            if (this.f206235b0 == null) {
                Z2();
            }
            this.f206234a0.d(this.f206235b0);
            this.leftView.setVisibility(8);
            this.f206252s0 = intent.getLongExtra("offline_file_size", 0L);
            startTitleProgress();
        } else {
            this.f206238e0 = intent.getStringExtra("offline_file_url");
            this.leftView.setVisibility(0);
            this.leftView.setText(R.string.f170549u3);
            String str = this.f206238e0;
            if (str != null) {
                this.f206237d0.loadUrl(str);
            }
            QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + this.f206238e0 + ")");
            this.E0 = intent.getStringExtra("OfflinePreZipUUID");
        }
        if (this.f206245l0) {
            this.P0 = true;
        } else {
            String configValue = ((IFMConfig) QRoute.api(IFMConfig.class)).getConfigValue(this, "OnlinePreView", "RotateScreen", "FunctionalSwitch");
            if (configValue == null || Integer.parseInt(configValue) == 0) {
                return true;
            }
            setRequestedOrientation(-1);
        }
        return true;
    }

    private void d3() {
        if (this.B0 != null) {
            return;
        }
        this.B0 = new View.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FilePreviewActivity.this.startTitleProgress();
                FilePreviewActivity.this.f206256w0.setVisibility(8);
                FilePreviewActivity.this.f206257x0.setText(R.string.cuy);
                FilePreviewActivity.this.A0.setOnClickListener(null);
                j jVar = FilePreviewActivity.this.C0;
                if (jVar != null) {
                    jVar.f207800i++;
                }
                new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        String str2 = FilePreviewActivity.this.f206249p0;
                        if (str2 != null && str2.length() != 0) {
                            if (FilePreviewActivity.this.f206245l0) {
                                str = "javascript:qpreview.onClientResponse('showFileList', {})";
                                QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('showFileList', {})");
                            } else {
                                str = "javascript:qpreview.onClientResponse('addMorePage',{})";
                                QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('addMorePage',{})");
                            }
                            QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + str + ")");
                            FileManagerReporter.a aVar = new FileManagerReporter.a();
                            aVar.f209157b = "sf_preview_again";
                            aVar.f209159d = q.j(FilePreviewActivity.this.f206239f0);
                            FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                            aVar.f209160e = filePreviewActivity.f206252s0;
                            FileManagerReporter.addData(filePreviewActivity.app.getCurrentAccountUin(), aVar);
                            try {
                                FilePreviewActivity.this.f206237d0.loadUrl(str);
                                return;
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                return;
                            }
                        }
                        FilePreviewActivity filePreviewActivity2 = FilePreviewActivity.this;
                        filePreviewActivity2.K0 = false;
                        filePreviewActivity2.T2();
                    }
                }, (new Random(System.currentTimeMillis()).nextInt(1500) % 1001) + 500);
                EventCollector.getInstance().onViewClicked(view);
            }
        };
    }

    boolean L2() {
        int i3 = this.f206244k0;
        if (i3 != com.tencent.mobileqq.filemanager.data.e.f207745d && !FileManagerUtil.bZip(i3) && !this.f206245l0) {
            return true;
        }
        return false;
    }

    void R2(boolean z16, long j3, String str) {
        j jVar = this.C0;
        if (jVar != null) {
            jVar.f207811t = System.currentTimeMillis();
        }
        stopTitleProgress();
        if (z16) {
            j jVar2 = this.C0;
            if (jVar2 != null) {
                jVar2.f207806o = jVar2.f207811t - jVar2.f207810s;
                jVar2.f207808q = true;
                jVar2.f207802k = "";
                long currentTimeMillis = System.currentTimeMillis();
                j jVar3 = this.C0;
                jVar2.f207807p = currentTimeMillis - jVar3.f207793b;
                jVar3.b();
            }
            this.f206256w0.setVisibility(8);
            this.f206257x0.setVisibility(4);
            this.A0.setVisibility(4);
            this.A0.setOnClickListener(null);
            try {
                this.f206237d0.setVisibility(0);
            } catch (NullPointerException unused) {
                this.f206237d0.setOverrideOnCheckIsTextEditor(false);
                this.f206237d0.setVisibility(0);
            }
        } else {
            j jVar4 = this.C0;
            if (jVar4 != null) {
                jVar4.f207806o = jVar4.f207811t - jVar4.f207810s;
                jVar4.f207808q = false;
                jVar4.f207796e = String.valueOf(j3);
                j jVar5 = this.C0;
                jVar5.f207802k = str;
                long currentTimeMillis2 = System.currentTimeMillis();
                j jVar6 = this.C0;
                jVar5.f207807p = currentTimeMillis2 - jVar6.f207793b;
                jVar6.b();
            }
            this.f206256w0.setVisibility(0);
            if (str == null || str.length() == 0) {
                str = getString(R.string.b8o);
            }
            this.f206257x0.setText(str + getString(R.string.b8m));
            this.f206257x0.setVisibility(0);
            this.A0.setOnClickListener(this.B0);
            this.A0.setVisibility(0);
            this.f206237d0.setVisibility(4);
        }
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFnish suc[" + z16 + "] retCode[" + j3 + "]");
        long currentTimeMillis3 = System.currentTimeMillis() - this.N0;
        FileManagerReporter.a aVar = new FileManagerReporter.a();
        aVar.f209157b = "file_preview_time_first";
        aVar.f209164i = currentTimeMillis3;
        aVar.f209165j = z16;
        aVar.f209159d = q.j(this.f206239f0);
        aVar.f209160e = this.f206252s0;
        FileManagerReporter.addData(this.app.getCurrentAccountUin(), aVar);
    }

    void S2(boolean z16, long j3, String str) {
        j jVar = this.C0;
        if (jVar != null) {
            jVar.f207811t = System.currentTimeMillis();
        }
        stopTitleProgress();
        if (z16) {
            j jVar2 = this.C0;
            if (jVar2 != null) {
                jVar2.f207806o = jVar2.f207811t - jVar2.f207810s;
                jVar2.f207808q = true;
                jVar2.f207802k = "";
                long currentTimeMillis = System.currentTimeMillis();
                j jVar3 = this.C0;
                jVar2.f207807p = currentTimeMillis - jVar3.f207793b;
                jVar3.b();
            }
            this.f206256w0.setVisibility(8);
            this.f206257x0.setVisibility(4);
            this.A0.setVisibility(4);
            this.A0.setOnClickListener(null);
            V2(1000);
            try {
                this.f206237d0.setVisibility(0);
            } catch (NullPointerException unused) {
                this.f206237d0.setOverrideOnCheckIsTextEditor(false);
                this.f206237d0.setVisibility(0);
            }
        } else {
            j jVar4 = this.C0;
            if (jVar4 != null) {
                jVar4.f207806o = jVar4.f207811t - jVar4.f207810s;
                jVar4.f207808q = false;
                jVar4.f207796e = String.valueOf(j3);
                j jVar5 = this.C0;
                jVar5.f207802k = str;
                long currentTimeMillis2 = System.currentTimeMillis();
                j jVar6 = this.C0;
                jVar5.f207807p = currentTimeMillis2 - jVar6.f207793b;
                jVar6.b();
            }
            this.f206258y0.setVisibility(8);
            this.f206259z0.setText(R.string.c5o);
            this.f206259z0.setVisibility(0);
            V2(5000);
        }
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call reportGetmoreTimeV2[" + z16 + "],retCode[" + j3 + "]");
        stopTitleProgress();
        setTitle(BaseApplication.getContext().getString(R.string.beu));
        long currentTimeMillis3 = System.currentTimeMillis() - this.N0;
        FileManagerReporter.a aVar = new FileManagerReporter.a();
        aVar.f209157b = "file_preview_time_more";
        aVar.f209164i = currentTimeMillis3;
        aVar.f209165j = z16;
        aVar.f209159d = q.j(this.f206239f0);
        aVar.f209160e = this.f206252s0;
        FileManagerReporter.addData(this.app.getCurrentAccountUin(), aVar);
    }

    void V2(final int i3) {
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.15
            @Override // java.lang.Runnable
            public void run() {
                FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                if (filePreviewActivity.S0 == null) {
                    filePreviewActivity.S0 = new n(filePreviewActivity.f206254u0);
                }
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setFillAfter(true);
                n.a aVar = new n.a();
                aVar.f209396a = alphaAnimation;
                aVar.f209398c = false;
                aVar.f209397b = n.f209390m;
                aVar.f209399d = i3;
                FilePreviewActivity.this.S0.a(aVar);
                FilePreviewActivity.this.S0.d();
                if (QLog.isColorLevel()) {
                    QLog.i("<FileAssistant>FilePreviewActivity", 2, "hideGetMore(" + i3 + ")");
                }
            }
        });
    }

    void W2() {
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.11
            @Override // java.lang.Runnable
            public void run() {
                FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                if (filePreviewActivity.R0 == null) {
                    filePreviewActivity.R0 = new n(filePreviewActivity.f206255v0);
                }
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setFillAfter(true);
                n.a aVar = new n.a();
                aVar.f209396a = alphaAnimation;
                aVar.f209398c = false;
                aVar.f209397b = n.f209390m;
                aVar.f209399d = 1500;
                FilePreviewActivity.this.R0.a(aVar);
                FilePreviewActivity.this.R0.d();
            }
        });
    }

    void Y2() {
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.12
            @Override // java.lang.Runnable
            public void run() {
                if (FilePreviewActivity.this.L0) {
                    return;
                }
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, 0 - FilePreviewActivity.this.f206248o0.getHeight());
                FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                if (filePreviewActivity.Q0 == null) {
                    filePreviewActivity.Q0 = new n(filePreviewActivity.f206248o0);
                }
                n.a aVar = new n.a();
                aVar.f209396a = translateAnimation;
                aVar.f209398c = false;
                aVar.f209397b = n.C;
                aVar.f209399d = 250;
                FilePreviewActivity.this.Q0.a(aVar);
                FilePreviewActivity.this.Q0.d();
                FilePreviewActivity.this.L0 = true;
            }
        });
    }

    void b3() {
        if (this.D0 != null) {
            return;
        }
        this.D0 = new FileWebView.a() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16

            /* renamed from: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity$16$a */
            /* loaded from: classes12.dex */
            class a implements DialogInterface.OnClickListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f206273d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ IUniformDownloadMgr f206274e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bundle f206275f;

                a(String str, IUniformDownloadMgr iUniformDownloadMgr, Bundle bundle) {
                    this.f206273d = str;
                    this.f206274e = iUniformDownloadMgr;
                    this.f206275f = bundle;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    String str;
                    StringBuilder sb5 = new StringBuilder();
                    if (FilePreviewActivity.this.f206251r0) {
                        str = "https://";
                    } else {
                        str = "http://";
                    }
                    sb5.append(str);
                    sb5.append(FilePreviewActivity.this.f206249p0);
                    sb5.append(":");
                    sb5.append(FilePreviewActivity.this.f206250q0);
                    sb5.append("/ftn_compress_getfile/rkey=");
                    sb5.append(FilePreviewActivity.this.f206246m0);
                    sb5.append("&filetype=");
                    sb5.append(FilePreviewActivity.this.f206243j0);
                    sb5.append("&path=");
                    String sb6 = sb5.toString();
                    if (QLog.isColorLevel()) {
                        QLog.i("<FileAssistant>FilePreviewActivity", 1, sb6);
                    }
                    String str2 = this.f206273d;
                    try {
                        str2 = URLEncoder.encode(str2, "utf8");
                    } catch (UnsupportedEncodingException e16) {
                        e16.printStackTrace();
                    }
                    this.f206274e.startDownload(sb6 + str2 + ContainerUtils.FIELD_DELIMITER, this.f206275f);
                    FileManagerReporter.addData("0X80052CE");
                }
            }

            /* renamed from: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity$16$b */
            /* loaded from: classes12.dex */
            class b implements DialogInterface.OnClickListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    FileManagerReporter.addData("0X80052CF");
                }
            }

            @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.a
            public void loadFinish(final int i3, boolean z16, final int i16, final String str) {
                final boolean z17 = i16 == 0;
                FilePreviewActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int i17 = i3;
                        if (i17 == 0) {
                            FilePreviewActivity.this.R2(z17, i16, str);
                        } else if (i17 == 1) {
                            FilePreviewActivity.this.S2(z17, i16, str);
                        }
                        QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFinish  process Over");
                    }
                });
                FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                filePreviewActivity.P0 = !z16;
                filePreviewActivity.V2(1000);
            }

            @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.a
            public void openFile(String str, String str2, long j3, boolean z16) {
                String md5;
                if (z16) {
                    Intent intent = new Intent(FilePreviewActivity.this, (Class<?>) FilePreviewActivity.class);
                    intent.putExtra("offline_file_type", 1);
                    intent.putExtra("offline_file_name", FilePreviewActivity.this.f206239f0);
                    intent.putExtra("offline_file_url", FilePreviewActivity.this.f206238e0);
                    intent.putExtra("offline_file_bZip", FilePreviewActivity.this.f206245l0);
                    intent.putExtra("offline_file_domain", FilePreviewActivity.this.f206249p0);
                    intent.putExtra("offline_file_port", FilePreviewActivity.this.f206250q0);
                    intent.putExtra("offline_file_domain_key", FilePreviewActivity.this.f206246m0);
                    intent.putExtra("offline_file_type_key", FilePreviewActivity.this.f206243j0);
                    intent.putExtra("OfflinePreZipPath", str2);
                    intent.putExtra("OfflinePreZipDirName", str);
                    intent.putExtra("OfflinePreZipUUID", FilePreviewActivity.this.E0);
                    if (!TextUtils.isEmpty(FilePreviewActivity.this.f206247n0)) {
                        intent.putExtra("COOKIE", FilePreviewActivity.this.f206247n0);
                    }
                    QLog.i("<FileAssistant>FilePreviewActivity", 1, "open zip dic,open new activity");
                    FilePreviewActivity.this.startActivityForResult(intent, 0);
                    return;
                }
                if (TextUtils.isEmpty(FilePreviewActivity.this.E0)) {
                    md5 = null;
                } else {
                    md5 = MD5.toMD5(FilePreviewActivity.this.E0 + str2 + str);
                    FileManagerEntity L = FilePreviewActivity.this.app.getFileManagerDataCenter().L(md5);
                    if (L != null && q.f(L.getFilePath())) {
                        FileManagerReporter.a aVar = new FileManagerReporter.a();
                        aVar.f209157b = "file_viewer_in";
                        aVar.f209158c = 73;
                        aVar.f209159d = q.j(L.fileName);
                        aVar.f209160e = L.fileSize;
                        FileManagerReporter.addData(FilePreviewActivity.this.app.getCurrentAccountUin(), aVar);
                        FileManagerReporter.addData("0X8004AE4");
                        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
                        forwardFileInfo.w(L.getCloudType());
                        forwardFileInfo.N(10000);
                        forwardFileInfo.E(L.nSessionId);
                        forwardFileInfo.V(L.uniseq);
                        forwardFileInfo.y(L.fileName);
                        forwardFileInfo.z(L.fileSize);
                        forwardFileInfo.Z(L.Uuid);
                        forwardFileInfo.C(L.getFilePath());
                        ArrayList<FileInfo> arrayList = new ArrayList<>();
                        try {
                            arrayList.add(new FileInfo(L.getFilePath()));
                        } catch (FileNotFoundException e16) {
                            e16.printStackTrace();
                        }
                        int i3 = L.nFileType;
                        if (i3 == 0 || i3 == 1) {
                            ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).addFileViewerLocalFiles(arrayList);
                        }
                        Intent intent2 = new Intent(FilePreviewActivity.this.getActivity(), (Class<?>) FileBrowserActivity.class);
                        intent2.putExtra("fileinfo", forwardFileInfo);
                        FilePreviewActivity.this.getActivity().startActivityForResult(intent2, 102);
                        FileManagerReporter.addData("0X80052CD");
                        return;
                    }
                }
                IUniformDownloadMgr iUniformDownloadMgr = (IUniformDownloadMgr) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "");
                Bundle bundle = new Bundle();
                bundle.putString(IUniformDownloadMgr.FILENAME_FROM_DIALOG, str);
                bundle.putLong(IUniformDownloadMgr.FILESIZE_FROM_DIALOG, j3);
                bundle.putString(IUniformDownloadMgr.DOWNLOAD_BIG_BROTHER_SOURCE, "biz_src_file_preview");
                bundle.putString("big_brother_source_key", "biz_src_file_preview");
                Bundle bundle2 = new Bundle();
                bundle2.putString("FILE_TMP_SERVER_PATH", md5);
                bundle2.putInt("FILE_FROM", 190);
                if (!TextUtils.isEmpty(FilePreviewActivity.this.f206247n0)) {
                    bundle2.putString("COOKIE", FilePreviewActivity.this.f206247n0);
                }
                if (QLog.isColorLevel()) {
                    QLog.i("<FileAssistant>FilePreviewActivity", 1, "set cookies:" + FilePreviewActivity.this.f206247n0);
                }
                bundle.putBundle(IUniformDownloadMgr.FILE_BUNDLE_USERDATA, bundle2);
                FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                DialogUtil.createCustomDialog(filePreviewActivity, 233, filePreviewActivity.getString(R.string.h5c), "\u662f\u5426\u4e0b\u8f7d\u6587\u4ef6:\n" + str + "(" + q.g(j3) + ")", new a(str2, iUniformDownloadMgr, bundle), new b()).show();
            }

            @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.a
            public void updatePage(final int i3, final int i16) {
                FilePreviewActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!FilePreviewActivity.this.L2()) {
                            return;
                        }
                        FilePreviewActivity.this.f206255v0.setText(String.valueOf(i3) + "/" + String.valueOf(i16));
                    }
                });
            }

            @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.a
            public void webLog(String str) {
                if (QLog.isColorLevel()) {
                    QLog.i("<FileAssistant>FilePreviewActivity_interfacePage", 2, str);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.a
            public void loadFinish(int i3, int i16, String str) {
                boolean z16 = i16 == 0;
                if (i3 == 0) {
                    FilePreviewActivity.this.R2(z16, i16, str);
                } else if (i3 == 1) {
                    FilePreviewActivity.this.S2(z16, i16, str);
                }
                QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFinish process Over");
                FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                filePreviewActivity.P0 = true;
                filePreviewActivity.V2(1000);
            }
        };
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileViewerActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        if (intent != null) {
            if ((intent.getExtras() != null && (intent.getBooleanExtra("foward_editbar", false) || intent.getBooleanExtra("destroy_last_activity", false))) || i16 == 4) {
                if (intent.getExtras() != null) {
                    Bundle extras = intent.getExtras();
                    Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
                    m3.putExtras(new Bundle(extras));
                    startActivity(m3);
                }
                setResult(4, intent);
                return;
            }
            setResult(0, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        if (!c3(intent)) {
            finish();
            return false;
        }
        setRightButton(R.string.close, new b());
        this.f206248o0 = (ViewGroup) findViewById(R.id.rlCommenTitle);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.cuf);
        this.f206254u0 = linearLayout;
        linearLayout.setVisibility(4);
        TextView textView = (TextView) findViewById(R.id.fht);
        this.f206255v0 = textView;
        textView.setVisibility(4);
        ta1.f a16 = TencentDocConvertConfigProcessor.a();
        boolean r16 = a16.r();
        boolean q16 = a16.q();
        if (!q16 && ((ITencentDocConvertABTestUtil) QRoute.api(ITencentDocConvertABTestUtil.class)).hasConfig(this.H0)) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.j5b);
            if (this.G0 && r16) {
                View inflate = viewStub.inflate();
                this.app.addObserver(this.J0);
                ReportController.o(this.app, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
                ((ITencentDocConvertABTestUtil) QRoute.api(ITencentDocConvertABTestUtil.class)).configureABTest(this.app, this, inflate, this.H0, new c());
            }
        } else {
            M2(r16, q16);
        }
        this.f206256w0 = (ImageView) findViewById(R.id.by5);
        this.f206257x0 = (TextView) findViewById(R.id.i98);
        this.f206256w0.setVisibility(8);
        this.f206258y0 = (ProgressBar) findViewById(R.id.cug);
        this.f206259z0 = (TextView) findViewById(R.id.cue);
        this.A0 = (LinearLayout) findViewById(R.id.i9i);
        setTitle(BaseApplication.getContext().getString(R.string.beu));
        if (this.f206242i0 == 0) {
            T2();
        } else {
            this.f206241h0 = intent.getStringExtra("OfflinePreZipDirName");
            setTitle(BaseApplication.getContext().getString(R.string.beu));
        }
        this.f206237d0.setVisibility(4);
        d3();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        QQProgressDialog qQProgressDialog = this.I0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.I0.dismiss();
        }
        this.app.removeObserver(this.J0);
        com.tencent.mobileqq.filemanager.core.f fVar = this.f206234a0;
        if (fVar != null) {
            fVar.a();
        }
        n nVar = this.S0;
        if (nVar != null) {
            nVar.c();
        }
        n nVar2 = this.Q0;
        if (nVar2 != null) {
            nVar2.c();
        }
        n nVar3 = this.R0;
        if (nVar3 != null) {
            nVar3.c();
        }
        FileManagerReporter.a aVar = new FileManagerReporter.a();
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.N0;
        aVar.f209157b = "file_preview_time_stay";
        aVar.f209164i = j3;
        aVar.f209165j = true;
        aVar.f209159d = q.j(this.f206239f0);
        aVar.f209160e = this.f206252s0;
        FileManagerReporter.addData(this.app.getCurrentAccountUin(), aVar);
        j jVar = this.C0;
        if (jVar != null && (!this.K0 || jVar.f207811t < jVar.f207810s)) {
            jVar.f207807p = j3;
            jVar.f207811t = currentTimeMillis;
            jVar.f207806o = currentTimeMillis - jVar.f207810s;
            jVar.f207796e = String.valueOf(AppConstants.RichMediaErrorCode.ERROR_USER_CANCEL);
            this.C0.f207802k = "LoadInterface[" + this.M0 + "]";
            j jVar2 = this.C0;
            jVar2.f207808q = false;
            jVar2.b();
        }
        this.C0 = null;
        try {
            FileWebView fileWebView = this.f206237d0;
            if (fileWebView != null) {
                fileWebView.setOnCustomScroolChangeListener(null);
                this.f206237d0.clearCache(false);
                this.f206237d0.setVisibility(4);
                this.f206236c0.removeView(this.f206237d0);
                this.f206237d0.destroy();
                this.f206236c0.removeAllViews();
            }
        } catch (NullPointerException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        if (this.f206237d0 != null) {
            if (QLog.isColorLevel()) {
                QLog.i("<FileAssistant>FilePreviewActivity", 2, "doOnPause");
            }
            this.f206237d0.onPause();
        }
        super.doOnPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        if (this.f206237d0 != null) {
            if (QLog.isColorLevel()) {
                QLog.i("<FileAssistant>FilePreviewActivity", 2, "doOnResume");
            }
            this.f206237d0.onResume();
        }
        super.doOnResume();
    }

    void e3() {
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.14
            @Override // java.lang.Runnable
            public void run() {
                FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                if (filePreviewActivity.S0 == null) {
                    filePreviewActivity.S0 = new n(filePreviewActivity.f206254u0);
                }
                FilePreviewActivity.this.f206258y0.setVisibility(0);
                FilePreviewActivity.this.f206259z0.setText(R.string.cmf);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                alphaAnimation.setFillAfter(true);
                n.a aVar = new n.a();
                aVar.f209396a = alphaAnimation;
                aVar.f209398c = true;
                aVar.f209397b = n.f209390m;
                aVar.f209399d = 1000;
                FilePreviewActivity.this.S0.a(aVar);
                FilePreviewActivity.this.S0.d();
                if (QLog.isColorLevel()) {
                    QLog.i("<FileAssistant>FilePreviewActivity", 2, "showGetmore(1000)");
                }
            }
        });
    }

    void f3() {
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (!FilePreviewActivity.this.L0) {
                    return;
                }
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0 - FilePreviewActivity.this.f206248o0.getHeight(), 0.0f);
                FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                if (filePreviewActivity.Q0 == null) {
                    filePreviewActivity.Q0 = new n(filePreviewActivity.f206248o0);
                }
                n.a aVar = new n.a();
                aVar.f209396a = translateAnimation;
                aVar.f209398c = true;
                aVar.f209397b = n.C;
                aVar.f209399d = 250;
                FilePreviewActivity.this.Q0.a(aVar);
                FilePreviewActivity.this.Q0.d();
                FilePreviewActivity.this.L0 = false;
            }
        });
    }

    public String getInitString(String str, int i3, int i16, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("domain", str);
        hashMap.put(TagName.FILE_TYPE, Integer.valueOf(i3));
        hashMap.put("port", Integer.valueOf(i16));
        hashMap.put("downloadkey", str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("cookie", str3);
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        hashMap.put("path", str4);
        String str5 = "javascript:qpreview.onClientResponse('init'," + FileManagerUtil.mapToJson(hashMap) + ")";
        if (QLog.isColorLevel()) {
            QLog.i("<FileAssistant>FilePreviewActivity", 2, "getInitString:" + str5);
        }
        return str5;
    }

    void initWebView() {
        this.f206236c0 = (RelativeLayout) findViewById(R.id.l1m);
        HashMap hashMap = new HashMap();
        hashMap.put("data_directory_suffix", "qfile");
        hashMap.put(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER, Boolean.TRUE);
        QbSdk.initTbsSettings(hashMap);
        FileWebView fileWebView = new FileWebView(getApplicationContext());
        this.f206237d0 = fileWebView;
        this.f206236c0.addView(fileWebView);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f206237d0.getLayoutParams();
        layoutParams.height = i16;
        layoutParams.width = i3;
        this.f206237d0.setLayoutParams(layoutParams);
        removeWebViewLayerType();
        b3();
        this.f206237d0.setWebViewClient(Q2());
        if (L2()) {
            this.f206237d0.setOnCustomScroolChangeListener(N2());
        } else {
            this.f206237d0.setOnCustomScroolChangeListener(P2());
        }
        this.f206237d0.setWebChromeClient(new ReportX5CoreWebChromeClient());
        this.f206237d0.setScrollBarStyle(0);
        this.f206237d0.requestFocus();
        this.f206237d0.setFocusableInTouchMode(false);
        WebSettings settings = this.f206237d0.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        if (this.f206245l0) {
            settings.setCacheMode(2);
        }
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        if (this.f206237d0.canGoBack()) {
            this.f206237d0.goBack();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileViewerActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity$10, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass10 implements FileWebView.b {
        AnonymousClass10() {
        }

        @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
        public void c() {
            FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
            if (!filePreviewActivity.f206245l0 && !filePreviewActivity.P0) {
                j jVar = filePreviewActivity.C0;
                if (jVar != null) {
                    jVar.f207805n = "3";
                    jVar.f207810s = System.currentTimeMillis();
                }
                FilePreviewActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FilePreviewActivity filePreviewActivity2 = FilePreviewActivity.this;
                        if (filePreviewActivity2.P0) {
                            filePreviewActivity2.f3();
                            return;
                        }
                        filePreviewActivity2.e3();
                        FilePreviewActivity.this.f3();
                        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.10.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FilePreviewActivity.this.O0 = System.currentTimeMillis();
                                try {
                                    FilePreviewActivity.this.f206237d0.loadUrl("javascript:qpreview.onClientResponse('addMorePage',{})");
                                    QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('addMorePage',{})");
                                } catch (Exception e16) {
                                    QLog.e("<FileAssistant>FilePreviewActivity", 1, e16.toString());
                                }
                            }
                        }, 1500L);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
        public void a() {
        }

        @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
        public void d() {
        }

        @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
        public void e() {
        }

        @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
        public void f() {
        }

        @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
        public void g() {
        }

        @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
        public void h() {
        }

        @Override // com.tencent.mobileqq.filemanager.widget.FileWebView.b
        public void b(boolean z16) {
        }
    }

    /* loaded from: classes12.dex */
    class c implements ITencentDocConvertABTestUtil.a {
        c() {
        }

        @Override // com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil.a
        public void a(int i3) {
            if (i3 != 1) {
                if (i3 == 2) {
                    FilePreviewActivity filePreviewActivity = FilePreviewActivity.this;
                    u.j(filePreviewActivity.app, filePreviewActivity, "<FileAssistant>FilePreviewActivity", filePreviewActivity.H0);
                    return;
                }
                return;
            }
            FilePreviewActivity filePreviewActivity2 = FilePreviewActivity.this;
            QQAppInterface qQAppInterface = filePreviewActivity2.app;
            TeamWorkFileImportInfo teamWorkFileImportInfo = filePreviewActivity2.H0;
            FilePreviewActivity filePreviewActivity3 = FilePreviewActivity.this;
            filePreviewActivity2.I0 = u.s(qQAppInterface, teamWorkFileImportInfo, filePreviewActivity3, "<FileAssistant>FilePreviewActivity", filePreviewActivity3.getString(R.string.hyh), false);
        }

        @Override // com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil.a
        public void b(ImageView imageView) {
        }
    }
}
