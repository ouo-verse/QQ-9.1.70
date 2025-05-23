package com.tencent.biz.pubaccount.weishi.operationh5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi.ipc.WSIPCClientHelper;
import com.tencent.biz.pubaccount.weishi.operationh5.OperationTitleBarView;
import com.tencent.biz.pubaccount.weishi.q;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.z;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.an;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.tuxmeterqui.config.TuxDialogBundleKey;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSOperationWebViewFragment extends WebViewFragment {
    OperationTitleBarView C;
    r00.a D;
    boolean E = false;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        a(t tVar) {
            super(tVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle bundle) {
            super.onFinalState(bundle);
            WSOperationWebViewFragment.this.sh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements OperationTitleBarView.d {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.operationh5.OperationTitleBarView.d
        public void a() {
            WSOperationWebViewFragment wSOperationWebViewFragment = WSOperationWebViewFragment.this;
            wSOperationWebViewFragment.E = true;
            wSOperationWebViewFragment.D.g();
            WSOperationWebViewFragment.this.D.j();
            z.l(WSOperationWebViewFragment.this.requireActivity(), new q("from_operation_h5", 0, false).i(WSOperationWebViewFragment.this.getUrl()));
        }

        @Override // com.tencent.biz.pubaccount.weishi.operationh5.OperationTitleBarView.d
        public void b() {
            WSOperationWebViewFragment.this.requireActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements TouchWebView.OnScrollChangedListener {
        c() {
        }

        @Override // com.tencent.biz.ui.TouchWebView.OnScrollChangedListener
        public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
            WSOperationWebViewFragment.this.C.a(i16);
        }
    }

    private void qh() {
        if (getActivity() == null || getActivity().getIntent() == null) {
            return;
        }
        getActivity().getWindow().setFlags(1024, 1024);
        getUIStyleHandler().T.setVisibility(8);
        getUIStyle().f314618a = true;
        an.e(super.getActivity());
        getWebTitleBarInterface().u5(false);
    }

    private void rh() {
        String stringExtra = this.intent.getStringExtra("spid");
        String stringExtra2 = this.intent.getStringExtra("web_test_id");
        String stringExtra3 = this.intent.getStringExtra(TuxDialogBundleKey.WEB_URL);
        String stringExtra4 = this.intent.getStringExtra("share_scenes_from");
        this.D = new r00.a(new r00.b(stringExtra, stringExtra2, stringExtra3, stringExtra4));
        Bundle bundle = new Bundle();
        bundle.putString(TuxDialogBundleKey.WEB_URL, stringExtra3);
        bundle.putString("spid", stringExtra);
        bundle.putString("web_test_id", stringExtra2);
        bundle.putString("scenes_channel_from", stringExtra4);
        WSPublicAccReport.getInstance().enterPublicAccReport(null, 1, "from_operation_h5", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh() {
        qh();
        th();
    }

    private void th() {
        this.C = new OperationTitleBarView(requireActivity());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        getUIStyleHandler().S.addView(this.C, layoutParams);
        getUIStyleHandler().f314505f = false;
        this.C.setOperationTitleClickListener(new b());
        this.webView.addScrollChangedListener(new c());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new a(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        rh();
        this.D.h();
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.D.f();
        this.D.j();
        WSPublicAccReport.getInstance().closePublicAccReport(1);
        xz.b.f449122a.e(false);
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WSIPCClientHelper.e().c("action_write_back_feed");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.E) {
            this.D.h();
            this.E = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.D.i();
        WSIPCClientHelper.e().c("action_req_aio_list_operation_feed");
    }
}
