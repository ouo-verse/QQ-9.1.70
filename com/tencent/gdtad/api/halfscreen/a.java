package com.tencent.gdtad.api.halfscreen;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardDialog;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardViewConfig;
import com.tencent.ams.fusion.widget.downloadcard.DownloadInfo;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final i f108554a;

    /* renamed from: b, reason: collision with root package name */
    private final e f108555b;

    /* renamed from: c, reason: collision with root package name */
    private GdtHalfScreenDownloadHandler f108556c;

    /* renamed from: d, reason: collision with root package name */
    private DownloadCardDialog f108557d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.api.halfscreen.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1149a implements DownloadCardListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<a> f108558a;

        /* renamed from: b, reason: collision with root package name */
        private long f108559b = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

        C1149a(WeakReference<a> weakReference) {
            this.f108558a = weakReference;
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onAgreementWebViewDismiss() {
            GdtLog.i("GdtHalfScreenDownloadController", "[onAgreementWebViewDismiss]");
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onAgreementWebViewShow() {
            GdtLog.i("GdtHalfScreenDownloadController", "[onAgreementWebViewShow]");
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onCancelViewCancelButtonClick() {
            GdtLog.i("GdtHalfScreenDownloadController", "[onCancelViewCancelButtonClick]");
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onCancelViewConfirmButtonClick() {
            GdtLog.i("GdtHalfScreenDownloadController", "[onCancelViewConfirmButtonClick]");
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onCancelViewShow() {
            GdtLog.i("GdtHalfScreenDownloadController", "[onCancelViewShow]");
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onFeatureListWebViewDismiss() {
            GdtLog.i("GdtHalfScreenDownloadController", "[onFeatureListWebViewShow]");
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onFeatureListWebViewShow() {
            GdtLog.i("GdtHalfScreenDownloadController", "[onFeatureListWebViewShow]");
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onOpenAppClick() {
            GdtLog.i("GdtHalfScreenDownloadController", "[onOpenAppClick]");
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onPermissionWebViewDismiss() {
            GdtLog.i("GdtHalfScreenDownloadController", "[onPermissionWebViewDismiss]");
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onPermissionWebViewShow() {
            GdtLog.i("GdtHalfScreenDownloadController", "[onPermissionWebViewShow]");
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onResumeDownloadClick() {
            GdtLog.i("GdtHalfScreenDownloadController", "[onResumeDownloadClick]");
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onStartDownloadClick() {
            a aVar;
            GdtLog.i("GdtHalfScreenDownloadController", "[onStartDownloadClick]");
            WeakReference<a> weakReference = this.f108558a;
            if (weakReference != null) {
                aVar = weakReference.get();
            } else {
                aVar = null;
            }
            if (aVar != null && aVar.f108555b != null && aVar.f108555b.f108565b != null) {
                e eVar = aVar.f108555b;
                a.j(eVar.f108565b, 4001070, System.currentTimeMillis() - eVar.f108568e);
            }
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onStartInstallClick() {
            GdtLog.i("GdtHalfScreenDownloadController", "[onStartInstallClick]");
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onViewClick(int i3, float f16, float f17) {
            GdtLog.i("GdtHalfScreenDownloadController", "[onViewClick]");
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onViewDismiss() {
            a aVar;
            GdtLog.i("GdtHalfScreenDownloadController", "[onViewDismiss]");
            WeakReference<a> weakReference = this.f108558a;
            if (weakReference != null) {
                aVar = weakReference.get();
            } else {
                aVar = null;
            }
            if (aVar != null && aVar.f108555b != null && aVar.f108555b.f108565b != null) {
                e eVar = aVar.f108555b;
                long j3 = this.f108559b;
                long j16 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
                if (j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                    j16 = System.currentTimeMillis() - this.f108559b;
                }
                a.j(eVar.f108565b, 4001071, j16);
            }
        }

        @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
        public void onViewShow() {
            a aVar;
            GdtLog.i("GdtHalfScreenDownloadController", "[onViewShow]");
            WeakReference<a> weakReference = this.f108558a;
            if (weakReference != null) {
                aVar = weakReference.get();
            } else {
                aVar = null;
            }
            if (aVar != null && aVar.f108555b != null && aVar.f108555b.f108565b != null) {
                e eVar = aVar.f108555b;
                a.j(eVar.f108565b, 4001066, System.currentTimeMillis() - eVar.f108568e);
            }
            this.f108559b = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class b implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<a> f108560d;

        b(WeakReference<a> weakReference) {
            this.f108560d = weakReference;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a aVar;
            WeakReference<a> weakReference = this.f108560d;
            if (weakReference != null) {
                aVar = weakReference.get();
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    public a(e eVar, i iVar) {
        this.f108555b = eVar;
        this.f108554a = iVar;
        f();
        h(c());
    }

    private DownloadInfo c() {
        e eVar = this.f108555b;
        if (eVar != null && eVar.a()) {
            DownloadInfo downloadInfo = new DownloadInfo();
            downloadInfo.setAppIconUrl(this.f108555b.f108565b.getAppIconUrl());
            downloadInfo.setAppName(this.f108555b.f108565b.getAppChannelAppName());
            downloadInfo.setAppVersion(this.f108555b.f108565b.getAppChannelVersionName());
            downloadInfo.setAuthorName(this.f108555b.f108565b.getAppChannelAuthorName());
            downloadInfo.setPermissionsUrl(this.f108555b.f108565b.getAppChannelPermissionUrl());
            downloadInfo.setAgreementUrl(this.f108555b.f108565b.getAppChannelPrivacyUrl());
            downloadInfo.setFeatureListUrl(this.f108555b.f108565b.getAppChannelFeatureListUrl());
            downloadInfo.setAgeAppropriate(this.f108555b.f108565b.getAppChannelSuitableAge());
            String appChannelDeveloper = this.f108555b.f108565b.getAppChannelDeveloper();
            if (!TextUtils.isEmpty(appChannelDeveloper) && !appChannelDeveloper.equals(this.f108555b.f108565b.getAppChannelAuthorName())) {
                downloadInfo.setDeveloperName(appChannelDeveloper);
            }
            if (!TextUtils.isEmpty(this.f108555b.f108565b.getAppChannelICPNumber())) {
                downloadInfo.setICP("\u5907\u6848\u53f7\uff1a" + this.f108555b.f108565b.getAppChannelICPNumber());
            }
            if (this.f108555b.f108565b.getAppDownloadNum() <= 0) {
                downloadInfo.setShowCancelViewDownloadCountTv(false);
            } else {
                downloadInfo.setDownloadCount(this.f108555b.f108565b.getAppDownloadNum());
            }
            return downloadInfo;
        }
        GdtLog.e("GdtHalfScreenDownloadController", "[initData] mPageData is null");
        d();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        GdtLog.i("GdtHalfScreenDownloadController", "[close]");
        i iVar = this.f108554a;
        if (iVar != null) {
            iVar.a();
        }
    }

    private void f() {
        GdtLog.i("GdtHalfScreenDownloadController", "[initData] isNowThemeIsNight:" + QQTheme.isNowThemeIsNight());
        DownloadCardViewConfig.setDarkMode(QQTheme.isNowThemeIsNight());
    }

    private void h(DownloadInfo downloadInfo) {
        i iVar = this.f108554a;
        if (iVar != null && iVar.getActivity() != null) {
            this.f108556c = new GdtHalfScreenDownloadHandler(this.f108555b, downloadInfo);
            DownloadCardViewConfig.setFusionWebViewBuilder(new f());
            com.tencent.gdtad.api.halfscreen.b bVar = new com.tencent.gdtad.api.halfscreen.b(this.f108554a.getActivity());
            this.f108557d = bVar;
            bVar.setThemeColor(RichStatus.TOPIC_COLOR);
            this.f108557d.setCancelable(true);
            this.f108557d.setCanceledOnTouchOutside(true);
            this.f108557d.setDownloadHandler(this.f108556c);
            this.f108557d.setListener(new C1149a(new WeakReference(this)));
            this.f108557d.setOnDismissListener(new b(new WeakReference(this)));
            this.f108557d.setDownloadInfo(downloadInfo);
            return;
        }
        GdtLog.e("GdtHalfScreenDownloadController", "[initDialog] mHalfScreenView || activity is null");
    }

    public static void j(Ad ad5, int i3, long j3) {
        if (ad5 != null && ad5.isValid()) {
            link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
            if (j3 > 0) {
                reportBiz.cost_time = (int) j3;
            }
            AdReporterForLinkEvent.getInstance().reportAsync(BaseApplication.getContext(), i3, ad5, reportBiz, null);
            return;
        }
        GdtLog.e("GdtHalfScreenDownloadController", "reportLandingPageStart error");
    }

    public void e() {
        GdtLog.i("GdtHalfScreenDownloadController", "[destroy]");
        DownloadCardDialog downloadCardDialog = this.f108557d;
        if (downloadCardDialog != null) {
            downloadCardDialog.destroy();
        }
    }

    public View g() {
        return this.f108557d;
    }

    public void k() {
        GdtLog.i("GdtHalfScreenDownloadController", "[resume]");
        GdtHalfScreenDownloadHandler gdtHalfScreenDownloadHandler = this.f108556c;
        if (gdtHalfScreenDownloadHandler != null) {
            gdtHalfScreenDownloadHandler.p();
        }
    }

    public void l() {
        GdtLog.i("GdtHalfScreenDownloadController", "[show]");
        try {
            this.f108557d.show();
        } catch (Throwable th5) {
            GdtLog.e("GdtHalfScreenDownloadController", "[show]", th5);
            e eVar = this.f108555b;
            if (eVar != null && eVar.a()) {
                j(this.f108555b.f108565b, 4001067, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
            }
            d();
        }
    }

    public void i() {
    }
}
