package com.tencent.open.filedownload.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.upgrade.YybUpgradeDialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.File;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ApkFileDownloadButton extends RelativeLayout implements View.OnClickListener {
    protected com.tencent.open.filedownload.b C;
    private int D;
    private Context E;
    private String F;
    private DownloadListener G;
    private c H;

    /* renamed from: d, reason: collision with root package name */
    protected RelativeLayout f341573d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f341574e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f341575f;

    /* renamed from: h, reason: collision with root package name */
    private ProgressBar f341576h;

    /* renamed from: i, reason: collision with root package name */
    private Button f341577i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f341578m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ApkFileDownloadButton.this.A(false, true);
            dialogInterface.dismiss();
            AppCenterReporter.o(com.tencent.open.appstore.report.b.u().v(ThemeReporter.FROM_WEEKLOOP).n(ApkFileDownloadButton.this.C.f341562a).l("5").o(ApkFileDownloadButton.this.C.f341564c).t(ApkFileDownloadButton.this.C.f341565d).i(ApkFileDownloadButton.this.C.f341570i).m(ApkFileDownloadButton.this.C.f341567f).r(ApkFileDownloadButton.this.C.f341566e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DownloadInfo f341590d;

        b(DownloadInfo downloadInfo) {
            this.f341590d = downloadInfo;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ApkFileDownloadButton.this.y();
            ApkFileDownloadButton.this.s(this.f341590d);
            AppCenterReporter.o(com.tencent.open.appstore.report.b.u().v(IndividuationPlugin.Business_Pendant).n(ApkFileDownloadButton.this.C.f341562a).l("5").o(ApkFileDownloadButton.this.C.f341564c).t(ApkFileDownloadButton.this.C.f341565d).i(ApkFileDownloadButton.this.C.f341570i).m(ApkFileDownloadButton.this.C.f341567f).r(ApkFileDownloadButton.this.C.f341566e));
        }
    }

    public ApkFileDownloadButton(Context context) {
        this(context, null);
    }

    private void B(DownloadInfo downloadInfo) {
        if (AppNetConnInfo.isMobileConn()) {
            a aVar = new a();
            DialogUtil.createCustomDialog(this.E, 230, HardCodeUtil.qqStr(R.string.jeg), HardCodeUtil.qqStr(R.string.jee), R.string.cancel, R.string.ans, new b(downloadInfo), aVar).show();
            AppCenterReporter.n(com.tencent.open.appstore.report.a.u().n(this.C.f341562a).l("5").o("0").t(this.C.f341565d).i(this.C.f341570i).m(this.C.f341567f).r(this.C.f341566e));
            return;
        }
        y();
        s(downloadInfo);
    }

    private void k(Context context) {
        this.E = context;
        LayoutInflater.from(context).inflate(R.layout.f168445wc, this);
        l();
        DownloadManagerV2.V().t0(this.G);
    }

    private void l() {
        setClickable(true);
        this.f341573d = (RelativeLayout) findViewById(R.id.id9);
        this.f341575f = (TextView) findViewById(R.id.kfe);
        this.f341576h = (ProgressBar) findViewById(R.id.g1o);
        Button button = (Button) findViewById(R.id.aiv);
        this.f341577i = button;
        button.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.kf6);
        this.f341574e = textView;
        textView.setText(f(1));
        this.f341574e.setOnClickListener(this);
        this.f341578m = (TextView) findViewById(R.id.kf7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            downloadInfo = new DownloadInfo();
            com.tencent.open.filedownload.b bVar = this.C;
            downloadInfo.f341193j0 = bVar.f341562a;
            downloadInfo.f341194k0 = bVar.f341563b;
            downloadInfo.f341195l0 = bVar.f341564c;
            downloadInfo.C = bVar.f341565d;
            downloadInfo.f341186f = bVar.f341566e;
            downloadInfo.f341189h = bVar.f341567f;
            downloadInfo.f341191i = bVar.f341570i;
            downloadInfo.f341196m = "_" + GlobalUtil.calcMD5AsString(this.C.f341566e);
            downloadInfo.U = true;
            downloadInfo.M = this.F;
            downloadInfo.m();
        } else {
            downloadInfo.f341189h = this.C.f341567f;
            downloadInfo.U = true;
            if (downloadInfo.f() == 4 && new File(downloadInfo.L).exists()) {
                com.tencent.open.filedownload.b bVar2 = this.C;
                bVar2.f341572k = 4;
                bVar2.f341571j = 100;
                D();
            }
            if (TextUtils.isEmpty(downloadInfo.M)) {
                downloadInfo.M = this.F;
            }
        }
        DownloadManagerV2.V().z0(downloadInfo);
        c cVar = this.H;
        if (cVar != null) {
            cVar.a();
        }
    }

    private void u(float f16) {
        if (f16 < 0.0f) {
            f16 = 0.0f;
        }
        if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        this.f341576h.setProgress((int) (f16 * 100.0f));
    }

    private void v(int i3) {
        u((i3 * 1.0f) / 100.0f);
    }

    public void A(boolean z16, boolean z17) {
        c cVar;
        if (z17 && (cVar = this.H) != null) {
            cVar.d();
        }
        q(z16);
    }

    protected boolean C(DownloadInfo downloadInfo, com.tencent.open.filedownload.b bVar) {
        if (downloadInfo != null && bVar != null) {
            return TextUtils.equals(downloadInfo.f341186f, bVar.f341566e);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D() {
        int i3;
        w(i());
        com.tencent.open.filedownload.b bVar = this.C;
        int i16 = bVar.f341572k;
        if (i16 == 4) {
            bVar.f341571j = 100;
        }
        this.f341574e.setText(f(i16));
        v(this.C.f341571j);
        if (this.C.f341572k == 4) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        if (this.f341573d.getVisibility() == 0) {
            i3 = 2;
        }
        this.f341578m.setText(g(i3));
    }

    public void d() {
        r();
        DownloadManagerV2.V().D0(this.G);
    }

    public void destroy() {
        DownloadManagerV2.V().D0(this.G);
        this.G = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        x();
        c cVar = this.H;
        if (cVar != null) {
            cVar.b();
        }
    }

    protected String f(int i3) {
        if (i3 == 4) {
            return HardCodeUtil.qqStr(R.string.jek);
        }
        return HardCodeUtil.qqStr(R.string.jem);
    }

    protected String g(int i3) {
        return "default";
    }

    protected String h() {
        return HardCodeUtil.qqStr(R.string.jeh);
    }

    protected String i() {
        int i3;
        com.tencent.open.filedownload.b bVar = this.C;
        if (bVar.f341572k != 4 && (i3 = bVar.f341571j) != 100) {
            long j3 = bVar.f341569h;
            if (j3 == 0) {
                return h();
            }
            return h() + "(" + YybUpgradeDialog.g0((float) ((j3 * i3) / 100), true, 2) + "/" + YybUpgradeDialog.g0((float) this.C.f341569h, true, 2) + ")";
        }
        return f(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        this.f341578m.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(DownloadInfo downloadInfo) {
        DownloadManagerV2.V().a0(downloadInfo);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f341577i) {
            c cVar = this.H;
            if (cVar != null) {
                cVar.d();
            }
            q(true);
        } else if (view == this.f341574e) {
            c cVar2 = this.H;
            if (cVar2 != null) {
                cVar2.c();
            }
            p(true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(boolean z16) {
        if (this.C == null) {
            f.e("ApkFileDownloadButton_", "[onClick] mApkInfo == null!");
            return;
        }
        f.e("ApkFileDownloadButton_", "[onClick] state=" + this.C.f341572k);
        DownloadManagerV2.V().t0(this.G);
        DownloadInfo S = DownloadManagerV2.V().S(this.C.f341566e);
        if (S != null) {
            this.C.f341572k = S.f();
            if (TextUtils.isEmpty(S.M)) {
                S.M = this.F;
            }
        }
        int i3 = this.C.f341572k;
        String str = IndividuationPlugin.Business_Pendant;
        if (i3 != 4) {
            if (S == null || (S.f() == 4 && !new File(S.L).exists())) {
                str = "900";
            }
            B(S);
        } else if (S != null && S.f() == 4 && new File(S.L).exists()) {
            this.C.f341572k = 4;
            D();
            x();
            m(S);
            str = "305";
        } else {
            if (S == null || (S.f() == 4 && !new File(S.L).exists())) {
                str = "900";
            }
            B(S);
        }
        if (z16) {
            AppCenterReporter.o(com.tencent.open.appstore.report.b.u().v(str).n(this.C.f341562a).l(this.C.f341563b).o(this.C.f341564c).t(this.C.f341565d).i(this.C.f341570i).m(this.C.f341567f).r(this.C.f341566e));
        }
        o(str, z16);
    }

    protected void q(boolean z16) {
        d();
        x();
        if (z16) {
            AppCenterReporter.o(com.tencent.open.appstore.report.b.u().v(ThemeReporter.FROM_NIGHT).n(this.C.f341562a).l(this.C.f341563b).o(this.C.f341564c).t(this.C.f341565d).i(this.C.f341570i).m(this.C.f341567f).r(this.C.f341566e));
        }
    }

    public void r() {
        if (this.C.f341572k != 4) {
            DownloadManagerV2.V().o0(this.C.f341566e);
        }
    }

    public void setApkInfo(com.tencent.open.filedownload.b bVar) {
        this.C = com.tencent.open.filedownload.b.a(bVar);
        D();
    }

    public void setEventCallback(c cVar) {
        this.H = cVar;
    }

    public void setSource(String str) {
        this.F = str;
    }

    public void t() {
        this.C.f341572k = 1;
        D();
        x();
    }

    protected void w(String str) {
        this.f341575f.setText(str);
    }

    protected void x() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.filedownload.ui.ApkFileDownloadButton.3
            @Override // java.lang.Runnable
            public void run() {
                ApkFileDownloadButton.this.f341574e.setVisibility(0);
                ApkFileDownloadButton.this.f341573d.setVisibility(4);
            }
        });
    }

    protected void y() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.filedownload.ui.ApkFileDownloadButton.2
            @Override // java.lang.Runnable
            public void run() {
                ApkFileDownloadButton.this.f341573d.setVisibility(0);
                ApkFileDownloadButton.this.f341574e.setVisibility(4);
            }
        });
    }

    public void z(boolean z16, boolean z17) {
        c cVar;
        if (z17 && (cVar = this.H) != null) {
            cVar.c();
        }
        p(z16);
    }

    public ApkFileDownloadButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ApkFileDownloadButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = 1;
        this.F = "";
        this.G = new DownloadListener() { // from class: com.tencent.open.filedownload.ui.ApkFileDownloadButton.1
            @Override // com.tencent.open.downloadnew.DownloadListener
            public void installSucceed(String str, final String str2) {
                f.e("ApkFileDownloadButton_", "[installSucceed] packageName=" + str2 + ",mApkInfo=" + ApkFileDownloadButton.this.C);
                com.tencent.open.filedownload.b bVar = ApkFileDownloadButton.this.C;
                if (bVar != null && TextUtils.equals(str2, bVar.f341567f)) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.8
                        @Override // java.lang.Runnable
                        public void run() {
                            ApkFileDownloadButton.this.n(str2);
                        }
                    }, 16, null, true);
                }
            }

            @Override // com.tencent.open.downloadnew.DownloadListener
            public void onDownloadCancel(DownloadInfo downloadInfo) {
                ApkFileDownloadButton apkFileDownloadButton = ApkFileDownloadButton.this;
                if (apkFileDownloadButton.C(downloadInfo, apkFileDownloadButton.C)) {
                    f.e("ApkFileDownloadButton_", "onDownloadCancel info.progress=" + downloadInfo.Q);
                    com.tencent.open.filedownload.b bVar = ApkFileDownloadButton.this.C;
                    bVar.f341572k = 1;
                    bVar.f341571j = downloadInfo.Q;
                    com.tencent.open.filedownload.b bVar2 = ApkFileDownloadButton.this.C;
                    if (bVar2.f341569h == 0) {
                        bVar2.f341569h = downloadInfo.f341180b0;
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            ApkFileDownloadButton.this.D();
                        }
                    });
                }
            }

            @Override // com.tencent.open.downloadnew.DownloadListener
            public void onDownloadError(DownloadInfo downloadInfo, int i16, String str, int i17) {
                ApkFileDownloadButton apkFileDownloadButton = ApkFileDownloadButton.this;
                if (apkFileDownloadButton.C(downloadInfo, apkFileDownloadButton.C)) {
                    f.e("ApkFileDownloadButton_", "onDownloadError errorCode=" + i16);
                    if (i16 == 6 && ApkFileDownloadButton.this.D > 0) {
                        ApkFileDownloadButton.this.s(downloadInfo);
                        ApkFileDownloadButton apkFileDownloadButton2 = ApkFileDownloadButton.this;
                        apkFileDownloadButton2.D--;
                    } else {
                        ApkFileDownloadButton.this.C.f341572k = 30;
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.7
                            @Override // java.lang.Runnable
                            public void run() {
                                ApkFileDownloadButton.this.D();
                            }
                        });
                    }
                }
            }

            @Override // com.tencent.open.downloadnew.DownloadListener
            public void onDownloadFinish(DownloadInfo downloadInfo) {
                ApkFileDownloadButton apkFileDownloadButton = ApkFileDownloadButton.this;
                if (apkFileDownloadButton.C(downloadInfo, apkFileDownloadButton.C)) {
                    f.e("ApkFileDownloadButton_", "onDownloadFinish info.progress=" + downloadInfo.Q);
                    com.tencent.open.filedownload.b bVar = ApkFileDownloadButton.this.C;
                    bVar.f341572k = 4;
                    bVar.f341571j = downloadInfo.Q;
                    com.tencent.open.filedownload.b bVar2 = ApkFileDownloadButton.this.C;
                    if (bVar2.f341569h == 0) {
                        bVar2.f341569h = downloadInfo.f341180b0;
                    }
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ApkFileDownloadButton.this.e();
                        }
                    }, 16, null, true);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            ApkFileDownloadButton.this.D();
                        }
                    });
                }
            }

            @Override // com.tencent.open.downloadnew.DownloadListener
            public void onDownloadPause(DownloadInfo downloadInfo) {
                ApkFileDownloadButton apkFileDownloadButton = ApkFileDownloadButton.this;
                if (apkFileDownloadButton.C(downloadInfo, apkFileDownloadButton.C)) {
                    f.e("ApkFileDownloadButton_", "onDownloadPause info.progress=" + downloadInfo.Q);
                    com.tencent.open.filedownload.b bVar = ApkFileDownloadButton.this.C;
                    bVar.f341572k = 3;
                    bVar.f341571j = downloadInfo.Q;
                    com.tencent.open.filedownload.b bVar2 = ApkFileDownloadButton.this.C;
                    if (bVar2.f341569h == 0) {
                        bVar2.f341569h = downloadInfo.f341180b0;
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ApkFileDownloadButton.this.D();
                        }
                    });
                }
            }

            @Override // com.tencent.open.downloadnew.DownloadListener
            public void onDownloadUpdate(List<DownloadInfo> list) {
                if (list == null) {
                    return;
                }
                for (DownloadInfo downloadInfo : list) {
                    ApkFileDownloadButton apkFileDownloadButton = ApkFileDownloadButton.this;
                    if (apkFileDownloadButton.C(downloadInfo, apkFileDownloadButton.C)) {
                        ApkFileDownloadButton.this.D = 1;
                        f.e("ApkFileDownloadButton_", "onDownloadUpdate info.progress=" + downloadInfo.Q);
                        com.tencent.open.filedownload.b bVar = ApkFileDownloadButton.this.C;
                        bVar.f341572k = 2;
                        bVar.f341571j = downloadInfo.Q;
                        com.tencent.open.filedownload.b bVar2 = ApkFileDownloadButton.this.C;
                        if (bVar2.f341569h == 0) {
                            bVar2.f341569h = downloadInfo.f341180b0;
                        }
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.6
                            @Override // java.lang.Runnable
                            public void run() {
                                ApkFileDownloadButton.this.D();
                            }
                        });
                        return;
                    }
                }
            }

            @Override // com.tencent.open.downloadnew.DownloadListener
            public void onDownloadWait(DownloadInfo downloadInfo) {
                ApkFileDownloadButton apkFileDownloadButton = ApkFileDownloadButton.this;
                if (apkFileDownloadButton.C(downloadInfo, apkFileDownloadButton.C)) {
                    f.e("ApkFileDownloadButton_", "onDownloadWait info.progress=" + downloadInfo.Q);
                    com.tencent.open.filedownload.b bVar = ApkFileDownloadButton.this.C;
                    bVar.f341572k = 20;
                    if (bVar.f341569h == 0) {
                        bVar.f341569h = downloadInfo.f341180b0;
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ApkFileDownloadButton.this.D();
                        }
                    });
                }
            }

            @Override // com.tencent.open.downloadnew.DownloadListener
            public void packageReplaced(String str, String str2) {
            }

            @Override // com.tencent.open.downloadnew.DownloadListener
            public void uninstallSucceed(String str, String str2) {
            }
        };
        k(context);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class c {
        public abstract void d();

        public void a() {
        }

        public void b() {
        }

        public void c() {
        }
    }

    protected void n(String str) {
    }

    protected void o(String str, boolean z16) {
    }
}
