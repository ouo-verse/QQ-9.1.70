package cooperation.groupvideo;

import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class GVideoTranslucentBrowerActivity extends QQTranslucentBrowserActivity {

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class GVideoBrowserFragment extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment {
        private boolean C;

        /* compiled from: P */
        /* loaded from: classes38.dex */
        class a extends com.tencent.mobileqq.webview.swift.proxy.a {
            a(t tVar) {
                super(tVar);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onFinalState(Bundle bundle) {
                GVideoBrowserFragment.this.onFinalState(bundle, this.webViewKernelCallBack);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onInitUIContent(Bundle bundle) {
                GVideoBrowserFragment.this.onInitUIContent(bundle, this.webViewKernelCallBack);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public void onReceivedError(WebView webView, int i3, String str, String str2) {
                super.onReceivedError(webView, i3, str, str2);
                if (QLog.isColorLevel()) {
                    QLog.d(WebViewFragment.TAG, 2, "GVideoBrowserFragment onReceivedError = ");
                }
                GVideoBrowserFragment.this.C = true;
                if (GVideoBrowserFragment.this.getActivity() != null) {
                    GVideoBrowserFragment.this.getActivity().finish();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public boolean doOnCreate(Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d(WebViewFragment.TAG, 2, "GVideoBrowserFragment doOnCreate = ");
            }
            boolean doOnCreate = super.doOnCreate(bundle);
            TouchWebView touchWebView = this.webView;
            if (touchWebView != null && touchWebView.getPluginEngine() != null) {
                this.webView.getPluginEngine().D(new String[]{"groupVideo"});
            }
            return doOnCreate;
        }

        @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public t getWebViewKernelCallBack() {
            return new a(this.webViewSurface);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
        public void onDestroy() {
            super.onDestroy();
            Monitor.d("2729128");
            if (this.C) {
                return;
            }
            Monitor.d("2489207");
            ReportController.o(null, "dc00899", "Huayang_video", "", "group_video", "loadHideWeb", 1, 0, "", AppSetting.f99551k, "", "");
        }

        @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
        public void onFinalState(Bundle bundle, t tVar) {
            super.onFinalState(bundle, tVar);
            getSwiftTitleUI().X(false);
            getUIStyleHandler().T.setVisibility(8);
        }

        @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
        public void onInitUIContent(Bundle bundle, t tVar) {
            getUIStyle().f314622e = 0L;
            super.onInitUIContent(bundle, tVar);
        }
    }

    public GVideoTranslucentBrowerActivity() {
        this.mFragmentClass = GVideoBrowserFragment.class;
    }
}
