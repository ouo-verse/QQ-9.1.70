package com.tencent.mobileqq.filemanager.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.LocalMultiProcConfig;
import java.net.URLEncoder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class UniformDownloadActivity extends BaseActivity {
    public static String A0 = "isqbdownload";
    public static String B0 = "fileMimeType";
    public static String C0 = "refer_url";

    /* renamed from: t0, reason: collision with root package name */
    public static String f206356t0 = "UniformDownloadActivity<FileAssistant>";

    /* renamed from: u0, reason: collision with root package name */
    public static String f206357u0 = "URL";

    /* renamed from: v0, reason: collision with root package name */
    public static String f206358v0 = "buttonType";

    /* renamed from: w0, reason: collision with root package name */
    public static String f206359w0 = "filename";

    /* renamed from: x0, reason: collision with root package name */
    public static String f206360x0 = "filesize";

    /* renamed from: y0, reason: collision with root package name */
    public static String f206361y0 = "iconpath";

    /* renamed from: z0, reason: collision with root package name */
    public static String f206362z0 = "filememo";

    /* renamed from: f0, reason: collision with root package name */
    public QQAppInterface f206368f0;

    /* renamed from: j0, reason: collision with root package name */
    protected ActionSheet f206372j0;

    /* renamed from: k0, reason: collision with root package name */
    private RelativeLayout f206373k0;

    /* renamed from: l0, reason: collision with root package name */
    private ProgressBar f206374l0;

    /* renamed from: m0, reason: collision with root package name */
    private TextView f206375m0;

    /* renamed from: n0, reason: collision with root package name */
    private TextView f206376n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f206377o0;

    /* renamed from: a0, reason: collision with root package name */
    public final String f206363a0 = "application/vnd.android.package-archive";

    /* renamed from: b0, reason: collision with root package name */
    private String f206364b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    private String f206365c0 = null;

    /* renamed from: d0, reason: collision with root package name */
    private long f206366d0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    private RelativeLayout f206367e0 = null;

    /* renamed from: g0, reason: collision with root package name */
    private String f206369g0 = null;

    /* renamed from: h0, reason: collision with root package name */
    private String f206370h0 = null;

    /* renamed from: i0, reason: collision with root package name */
    private String f206371i0 = "";

    /* renamed from: p0, reason: collision with root package name */
    private View.OnClickListener f206378p0 = new f();

    /* renamed from: q0, reason: collision with root package name */
    private ActionSheet.OnButtonClickListener f206379q0 = new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.7
        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            ActionSheet actionSheet = UniformDownloadActivity.this.f206372j0;
            if (actionSheet == null) {
                return;
            }
            if (view != null) {
                String content = actionSheet.getContent(i3);
                if (!TextUtils.isEmpty(content)) {
                    if (!content.equals(UniformDownloadActivity.this.getResources().getString(R.string.f170865av3)) && !content.equals(UniformDownloadActivity.this.getResources().getString(R.string.f170866av4))) {
                        if (content.equals(UniformDownloadActivity.this.getResources().getString(R.string.f170864av2)) || content.equals(UniformDownloadActivity.this.getResources().getString(R.string.f170380p8)) || content.equals(UniformDownloadActivity.this.getResources().getString(R.string.f170379p7))) {
                            UniformDownloadActivity.this.g3();
                        }
                    } else {
                        ReportController.o(null, "dc00898", "", "", "0X8008F87", "0X8008F87", 1, 0, "", "", "", "");
                        if (UniformDownloadActivity.this.d3()) {
                            if (!com.tencent.open.downloadnew.d.d()) {
                                UniformDownloadActivity.this.g3();
                            } else {
                                com.tencent.open.business.viareport.c.a().e(UniformDownloadActivity.this.f206369g0, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3007", false);
                                OuterCallReportModel Y2 = UniformDownloadActivity.this.Y2();
                                UniformDownloadActivity.this.e3(Y2);
                                String Z2 = UniformDownloadActivity.this.Z2(Y2);
                                if (QLog.isColorLevel()) {
                                    QLog.d(UniformDownloadActivity.f206356t0, 2, "tmastUrl=" + Z2);
                                }
                                UniformDownloadActivity.this.i3(Z2);
                                UniformDownloadActivity.this.f3();
                                UniformDownloadActivity.this.finish();
                                UniformDownloadActivity.this.overridePendingTransition(0, 0);
                            }
                        } else {
                            UniformDownloadActivity.this.f206373k0.setVisibility(0);
                            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DownloadManager.C().Y(UniformDownloadActivity.this.f206380r0);
                                    MyAppApi.z().l0(UniformDownloadActivity.this, "https://a.app.qq.com/o/myapp-down?g_f=1001647", "ANDROIDQQ.WIFIDLYYB.GAME", 2, "", true);
                                    com.tencent.open.business.viareport.c.a().e(UniformDownloadActivity.this.f206369g0, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3004", false);
                                }
                            });
                        }
                    }
                }
            }
            UniformDownloadActivity.this.f206372j0.dismiss();
        }
    };

    /* renamed from: r0, reason: collision with root package name */
    private DownloadListener f206380r0 = new DownloadListener() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10
        @Override // com.tencent.open.downloadnew.DownloadListener
        public void installSucceed(String str, String str2) {
            if ("1101070898".equals(str)) {
                OuterCallReportModel Y2 = UniformDownloadActivity.this.Y2();
                UniformDownloadActivity.this.e3(Y2);
                String Z2 = UniformDownloadActivity.this.Z2(Y2);
                if (QLog.isColorLevel()) {
                    QLog.d(UniformDownloadActivity.f206356t0, 2, "tmastUrl=" + Z2);
                }
                UniformDownloadActivity.this.i3(Z2);
                UniformDownloadActivity.this.finish();
                UniformDownloadActivity.this.overridePendingTransition(0, 0);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadCancel(DownloadInfo downloadInfo) {
            if (QLog.isColorLevel() && downloadInfo != null) {
                QLog.d(UniformDownloadActivity.f206356t0, 2, "onDownloadCancel " + downloadInfo.f341189h);
            }
            if (downloadInfo != null && downloadInfo.f341184e.equals("1101070898")) {
                UniformDownloadActivity.this.finish();
                UniformDownloadActivity.this.overridePendingTransition(0, 0);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16) {
            if (downloadInfo != null && downloadInfo.f341184e.equals("1101070898")) {
                if (QLog.isColorLevel()) {
                    QLog.d(UniformDownloadActivity.f206356t0, 2, "onDownloadError " + downloadInfo.f341189h);
                }
                UniformDownloadActivity.this.finish();
                UniformDownloadActivity.this.overridePendingTransition(0, 0);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadFinish(DownloadInfo downloadInfo) {
            if (QLog.isColorLevel()) {
                QLog.d(UniformDownloadActivity.f206356t0, 2, "onDownloadFinish " + downloadInfo.f341189h);
            }
            ReportController.o(null, "dc00898", "", "", "0X8008F88", "0X8008F88", 1, 0, "", "", "", "");
            UniformDownloadActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.4
                @Override // java.lang.Runnable
                public void run() {
                    UniformDownloadActivity.this.f206373k0.setVisibility(4);
                }
            });
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadPause(DownloadInfo downloadInfo) {
            if (downloadInfo != null && downloadInfo.f341184e.equals("1101070898")) {
                if (QLog.isColorLevel()) {
                    QLog.d(UniformDownloadActivity.f206356t0, 2, "onDownloadPause " + downloadInfo.f341189h);
                }
                UniformDownloadActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.3
                    @Override // java.lang.Runnable
                    public void run() {
                        UniformDownloadActivity.this.f206373k0.setVisibility(4);
                    }
                });
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadUpdate(List<DownloadInfo> list) {
            for (final DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.f341184e.equals("1101070898")) {
                    if (QLog.isColorLevel()) {
                        QLog.d(UniformDownloadActivity.f206356t0, 2, "onDownloadUpdate " + downloadInfo.f341189h);
                    }
                    UniformDownloadActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.2
                        @Override // java.lang.Runnable
                        public void run() {
                            UniformDownloadActivity.this.f206373k0.setVisibility(0);
                            UniformDownloadActivity.this.f206376n0.setVisibility(0);
                            UniformDownloadActivity.this.f206375m0.setText(UniformDownloadActivity.this.getString(R.string.avi, downloadInfo.Q + "%"));
                        }
                    });
                }
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadWait(DownloadInfo downloadInfo) {
            UniformDownloadActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    UniformDownloadActivity.this.f206373k0.setVisibility(0);
                    UniformDownloadActivity.this.f206376n0.setVisibility(0);
                    UniformDownloadActivity.this.f206375m0.setText(UniformDownloadActivity.this.getString(R.string.avi, "0%"));
                }
            });
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void packageReplaced(String str, String str2) {
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void uninstallSucceed(String str, String str2) {
        }
    };

    /* renamed from: s0, reason: collision with root package name */
    private com.tencent.mobileqq.uniformdownload.util.d f206381s0 = new com.tencent.mobileqq.uniformdownload.util.d() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11
        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void R0(int i3, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d(UniformDownloadActivity.f206356t0, 2, "UniformDownloader onDownloadPause progress = " + i3);
            }
            UniformDownloadActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11.5
                @Override // java.lang.Runnable
                public void run() {
                    UniformDownloadActivity.this.f206373k0.setVisibility(4);
                }
            });
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void a(final int i3, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d(UniformDownloadActivity.f206356t0, 2, "UniformDownloader onDownloadProgress progress = " + i3);
            }
            UniformDownloadActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11.4
                @Override // java.lang.Runnable
                public void run() {
                    UniformDownloadActivity.this.f206373k0.setVisibility(0);
                    UniformDownloadActivity.this.f206375m0.setText(UniformDownloadActivity.this.getString(R.string.avh, i3 + "%"));
                }
            });
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void c(int i3, String str, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d(UniformDownloadActivity.f206356t0, 2, "UniformDownloader onDownloadFailed errCode = " + i3);
            }
            UniformDownloadActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11.6
                @Override // java.lang.Runnable
                public void run() {
                    UniformDownloadActivity.this.f206373k0.setVisibility(4);
                    UniformDownloadActivity.this.finish();
                }
            });
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void c2(int i3, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d(UniformDownloadActivity.f206356t0, 2, "UniformDownloader onDownloadResume progress = " + i3);
            }
            UniformDownloadActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11.3
                @Override // java.lang.Runnable
                public void run() {
                    UniformDownloadActivity.this.f206373k0.setVisibility(0);
                    UniformDownloadActivity.this.f206376n0.setVisibility(4);
                }
            });
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void g0(int i3, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d(UniformDownloadActivity.f206356t0, 2, "UniformDownloader onDownloadStart progress = " + i3);
            }
            UniformDownloadActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11.2
                @Override // java.lang.Runnable
                public void run() {
                    UniformDownloadActivity.this.f206373k0.setVisibility(0);
                    UniformDownloadActivity.this.f206376n0.setVisibility(4);
                }
            });
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void h(String str, long j3, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d(UniformDownloadActivity.f206356t0, 2, "UniformDownloader onDownloadSucess ");
            }
            UniformDownloadActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    UniformDownloadActivity.this.f206373k0.setVisibility(4);
                    UniformDownloadActivity.this.finish();
                }
            });
            ReportController.o(null, "dc00898", "", "", "0X8008FFA", "0X8008FFA", 1, 0, "", "", "", "");
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7526a implements FMDialogUtil.c {
            C7526a() {
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
                UniformDownloadActivity.this.finish();
                UniformDownloadActivity.this.overridePendingTransition(0, 0);
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                UniformDownloadActivity.this.W2();
                UniformDownloadActivity.this.finish();
                UniformDownloadActivity.this.overridePendingTransition(0, 0);
            }
        }

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (NetworkUtil.isNetSupport(UniformDownloadActivity.this.getActivity())) {
                UniformDownloadActivity.this.f206367e0.setVisibility(8);
                if (!FileManagerUtil.is2GOr3G()) {
                    UniformDownloadActivity.this.W2();
                    UniformDownloadActivity.this.finish();
                    UniformDownloadActivity.this.overridePendingTransition(0, 0);
                } else {
                    FMDialogUtil.a(UniformDownloadActivity.this.getActivity(), R.string.b_v, R.string.i_3, new C7526a());
                }
            } else {
                com.tencent.mobileqq.filemanager.util.d.e(R.string.b_o);
                UniformDownloadActivity.this.finish();
                UniformDownloadActivity.this.overridePendingTransition(0, 0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            UniformDownloadActivity.this.finish();
            UniformDownloadActivity.this.overridePendingTransition(0, 0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements ActionSheet.OnDismissListener {
        d() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            UniformDownloadActivity.this.finish();
            UniformDownloadActivity.this.overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements DialogInterface.OnKeyListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            if (i3 != 4) {
                return false;
            }
            ActionSheet actionSheet = UniformDownloadActivity.this.f206372j0;
            if (actionSheet != null) {
                actionSheet.dismiss();
                UniformDownloadActivity.this.f206372j0 = null;
            }
            UniformDownloadActivity.this.finish();
            UniformDownloadActivity.this.overridePendingTransition(0, 0);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ActionSheet actionSheet = UniformDownloadActivity.this.f206372j0;
            if (actionSheet != null) {
                actionSheet.dismiss();
                UniformDownloadActivity.this.f206372j0 = null;
            }
            if (UniformDownloadActivity.this.d3()) {
                com.tencent.open.business.viareport.c.a().e(UniformDownloadActivity.this.f206369g0, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3009", false);
            } else {
                com.tencent.open.business.viareport.c.a().e(UniformDownloadActivity.this.f206369g0, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3006", false);
            }
            UniformDownloadActivity.this.finish();
            UniformDownloadActivity.this.overridePendingTransition(0, 0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g implements FMDialogUtil.c {
        g() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
            UniformDownloadActivity.this.finish();
            UniformDownloadActivity.this.overridePendingTransition(0, 0);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            UniformDownloadActivity.this.W2();
        }
    }

    private View V2() {
        this.f206373k0 = new RelativeLayout(this);
        ProgressBar progressBar = new ProgressBar(this);
        this.f206374l0 = progressBar;
        progressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.common_loading6));
        this.f206374l0.setId(241);
        TextView textView = new TextView(this);
        this.f206375m0 = textView;
        textView.setId(242);
        this.f206375m0.setTextColor(-1);
        this.f206375m0.setTextSize(14.0f);
        TextView textView2 = new TextView(this);
        this.f206376n0 = textView2;
        textView2.setText(R.string.avj);
        this.f206376n0.setVisibility(4);
        this.f206376n0.setTextColor(getResources().getColor(R.color.ab8));
        this.f206376n0.setTextSize(14.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, dip2px(30.0f));
        layoutParams.addRule(13);
        this.f206373k0.addView(this.f206374l0, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 241);
        layoutParams2.addRule(13);
        layoutParams2.topMargin = dip2px(5.0f);
        this.f206373k0.addView(this.f206375m0, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, 242);
        layoutParams3.addRule(13);
        layoutParams3.topMargin = dip2px(5.0f);
        this.f206373k0.addView(this.f206376n0, layoutParams3);
        this.f206373k0.setVisibility(4);
        return this.f206373k0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W2() {
        ReportController.n(null, "P_CliOper", "webview", "", "webview_apk_download", "download_click", 0, 1, 0, "", "", "", "");
        Bundle bundle = new Bundle();
        bundle.putString(IUniformDownloadMgr.FILENAME_FROM_DIALOG, this.f206365c0);
        bundle.putLong(IUniformDownloadMgr.FILESIZE_FROM_DIALOG, this.f206366d0);
        bundle.putString(IUniformDownloadMgr.DOWNLOAD_BIG_BROTHER_SOURCE, "biz_src_WEBVIEW");
        bundle.putString(IUniformDownloadMgr.FILE_MIME_TYPE, this.f206370h0);
        bundle.putString("param_refer_url", this.f206371i0);
        b3().startDownload(this.f206364b0, bundle, this.f206381s0);
        f3();
        com.tencent.open.business.viareport.c.a().e(this.f206369g0, "", "ANDROIDQQ.POPUP.SDKDOWNAPP", ThemeReporter.FROM_NIGHT, false);
        ReportController.o(null, "dc00898", "", "", "0X8008FF9", "0X8008FF9", 1, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
            QLog.i(f206356t0, 2, "[UniformDL]. >>> downloadFile. url:" + this.f206364b0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public OuterCallReportModel Y2() {
        OuterCallReportModel defaultModel = OuterCallReportModel.getDefaultModel();
        defaultModel.mOuterCallMode = 1;
        defaultModel.mOuterCallType = 1;
        defaultModel.mOuterCallTime = System.currentTimeMillis();
        defaultModel.mVia = "ANDROIDQQ.POPUP.YYBDOWNAPP";
        defaultModel.mComponentName = "SplashActivity";
        return defaultModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public String Z2(OuterCallReportModel outerCallReportModel) {
        return "tmast://download?downl_biz_id=ANDROIDQQ&down_ticket=" + System.currentTimeMillis() + "&downl_url=" + URLEncoder.encode(this.f206364b0) + "&via=ANDROIDQQ.POPUP.YYBDOWNAPP&hostpname=com.tencent.mobileqq&outerCallTime=" + outerCallReportModel.mOuterCallTime + "&outerCallType=" + outerCallReportModel.mOuterCallType + "&outerCallMode=" + outerCallReportModel.mOuterCallMode + "&hostversion=" + GlobalUtil.getAppVersionCode(this);
    }

    private void c3() {
        super.setContentView(R.layout.qfile_file_ufdownload);
        TextView textView = (TextView) findViewById(R.id.kho);
        TextView textView2 = (TextView) findViewById(R.id.khp);
        this.f206367e0 = (RelativeLayout) findViewById(R.id.khn);
        if (textView2 != null) {
            if (getIntent().getLongExtra(f206358v0, 0L) == 1) {
                textView2.setText(R.string.f170582ur);
            }
            textView2.setOnClickListener(new a());
        }
        if (textView != null) {
            textView.setOnClickListener(new b());
        }
        Intent intent = getIntent();
        TextView textView3 = (TextView) findViewById(R.id.kht);
        TextView textView4 = (TextView) findViewById(R.id.khu);
        ImageView imageView = (ImageView) findViewById(R.id.khs);
        String stringExtra = intent.getStringExtra(f206362z0);
        if (stringExtra == null) {
            stringExtra = this.f206365c0;
        }
        textView3.setText(stringExtra);
        textView4.setText(q.g(this.f206366d0));
        int fileIconResId = FileManagerUtil.getFileIconResId(this.f206365c0);
        String stringExtra2 = intent.getStringExtra(f206361y0);
        if (fileIconResId != 0) {
            imageView.setImageResource(fileIconResId);
        } else {
            imageView.setImageResource(R.drawable.bsd);
        }
        if (stringExtra2 != null) {
            URLDrawable drawable = URLDrawable.getDrawable(stringExtra2);
            drawable.setURLDrawableListener(new c(imageView));
            imageView.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d3() {
        if (com.tencent.open.business.base.a.g(SDKConst.SELF_PACKAGENAME) >= 5202129) {
            return true;
        }
        return false;
    }

    private int dip2px(float f16) {
        return (int) ((f16 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3(OuterCallReportModel outerCallReportModel) {
        GlobalUtil.getInstance().setContext(getApplicationContext());
        SDKReportManager2.getInstance().postReport(15, outerCallReportModel.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f3() {
        if (!TextUtils.isEmpty(this.f206365c0) && this.f206365c0.startsWith("qzone")) {
            LocalMultiProcConfig.putLong("qzonedownloadtime", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g3() {
        if (d3()) {
            com.tencent.open.business.viareport.c.a().e(this.f206369g0, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3008", false);
        } else {
            com.tencent.open.business.viareport.c.a().e(this.f206369g0, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3005", false);
        }
        if (NetworkUtil.isNetSupport(getActivity())) {
            if (FileManagerUtil.is2GOr3G()) {
                FMDialogUtil.a(getActivity(), R.string.b_v, R.string.i_3, new g());
                return;
            } else {
                W2();
                return;
            }
        }
        com.tencent.mobileqq.filemanager.util.d.e(R.string.b_o);
        finish();
        overridePendingTransition(0, 0);
    }

    private boolean h3() {
        if (!"application/vnd.android.package-archive".equals(this.f206370h0) && !this.f206365c0.toLowerCase().endsWith(".apk")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3(String str) {
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
        intent.setFlags(268435456);
        try {
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public void U2() {
        boolean z16;
        this.f206372j0 = (ActionSheet) ActionSheetHelper.createDialog(getActivity(), null);
        String e16 = ea.e1(this, "noSafeDown");
        Log.d(f206356t0, this.f206364b0);
        if (e16.equals("true")) {
            this.f206372j0.addButton(R.string.f170379p7);
        } else {
            if (h3()) {
                DownloadSDKConfigManager.isDownloadUrlBlocked(this, this.f206364b0);
                Log.d(f206356t0, "url is blocked!! show only normal download");
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.f206372j0.addButton(R.string.f170379p7);
            } else {
                this.f206372j0.addButton(R.string.f170864av2);
            }
        }
        this.f206372j0.setOnButtonClickListener(this.f206379q0);
        this.f206372j0.setOnDismissListener(new d());
        this.f206372j0.show();
        this.f206372j0.setOnKeyListener(new e());
        View inflate = LayoutInflater.from(this).inflate(R.layout.action_sheet_cancel_button, (ViewGroup) null);
        Button button = (Button) inflate.findViewById(R.id.action_sheet_btnCancel);
        button.setOnClickListener(this.f206378p0);
        button.setText(R.string.f170863av1);
        button.setTextColor(getResources().getColor(R.color.f156708u));
        this.f206372j0.addView(inflate);
        com.tencent.open.business.viareport.c.a().e(this.f206369g0, "", "ANDROIDQQ.POPUP", "100", false);
        ReportController.o(null, "dc00898", "", "", "0X8008FF8", "0X8008FF8", 1, 0, "", "", "", "");
    }

    protected IUniformDownloadMgr b3() {
        return (IUniformDownloadMgr) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "");
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        this.f206364b0 = intent.getStringExtra(f206357u0);
        this.f206365c0 = intent.getStringExtra(f206359w0);
        this.f206366d0 = intent.getLongExtra(f206360x0, 0L);
        this.f206370h0 = intent.getStringExtra(B0);
        this.f206371i0 = intent.getStringExtra(C0);
        this.f206377o0 = intent.getBooleanExtra("fromArkAppDownload", false);
        QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
        this.f206368f0 = qQAppInterface;
        this.f206369g0 = qQAppInterface.getCurrentAccountUin();
        if (intent.getBooleanExtra(A0, false)) {
            c3();
        } else {
            setContentView(V2(), new FrameLayout.LayoutParams(-1, -1));
            U2();
        }
        if (this.f206371i0 == null) {
            this.f206371i0 = "";
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.9
            @Override // java.lang.Runnable
            public void run() {
                DownloadManager.C().j0(UniformDownloadActivity.this.f206380r0);
            }
        });
        b3().removeOuterListenner(this.f206364b0);
        this.f206368f0 = null;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f206401d;

        c(ImageView imageView) {
            this.f206401d = imageView;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            this.f206401d.setImageDrawable(null);
            this.f206401d.setImageDrawable(uRLDrawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
