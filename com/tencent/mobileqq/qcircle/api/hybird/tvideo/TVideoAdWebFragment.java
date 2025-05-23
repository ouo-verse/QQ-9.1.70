package com.tencent.mobileqq.qcircle.api.hybird.tvideo;

import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADLandingPageInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.QAdH5ReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.VideoReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import pw2.w;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TVideoAdWebFragment extends WebViewFragment {
    private xd2.a C;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        a(t tVar) {
            super(tVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onDataInit(Bundle bundle) {
            TVideoAdWebFragment.this.sh();
            super.onDataInit(bundle);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle bundle) {
            super.onFinalState(bundle);
            TVideoAdWebFragment.this.getActivity().setRequestedOrientation(1);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onProgressChanged(WebView webView, int i3) {
            super.onProgressChanged(webView, i3);
            if (TVideoAdWebFragment.this.C != null) {
                TVideoAdWebFragment.this.C.g(i3);
            }
        }
    }

    private VideoReportInfo rh() {
        QAdH5ReportInfo qAdH5ReportInfo;
        QADLandingPageInfo qADLandingPageInfo = (QADLandingPageInfo) getIntent().getSerializableExtra("ad_land_page_info");
        if (qADLandingPageInfo == null || (qAdH5ReportInfo = qADLandingPageInfo.getQAdH5ReportInfo()) == null) {
            return null;
        }
        return qAdH5ReportInfo.videoReportInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh() {
        VideoReport.addToDetectionWhitelist(getHostActivity());
        VideoReport.setPageId(getView(), "page_ad_landing");
        VideoReportInfo rh5 = rh();
        if (rh5 != null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put(QAdVrReportParams.ParamKey.REF_ELE, rh5.getClickReportInfo());
            w.o(getView(), hashMap);
        }
        QLog.i("TVideoAdWebFragment", 1, "reportDaTongRegister  subPage: TVideoAdWebFragment");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new a(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.C = new xd2.a(getActivity());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void setWebView(TouchWebView touchWebView) {
        super.setWebView(touchWebView);
        xd2.a aVar = this.C;
        if (aVar != null) {
            aVar.c(touchWebView);
        }
    }
}
