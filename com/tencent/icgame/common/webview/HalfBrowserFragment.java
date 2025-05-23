package com.tencent.icgame.common.webview;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.ui.RefreshView;
import com.tencent.icgame.common.widget.RCFrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.an;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HalfBrowserFragment extends WebViewFragment {

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        a(t tVar) {
            super(tVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle bundle) {
            HalfBrowserFragment.this.onFinalState(bundle, this.webViewKernelCallBack);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(Bundle bundle) {
            HalfBrowserFragment.this.onInitUIContent(bundle, this.webViewKernelCallBack);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new a(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (onCreateView != null) {
            onCreateView.setBackgroundColor(0);
        }
        if (getContext() != null) {
            RCFrameLayout rCFrameLayout = new RCFrameLayout(getContext());
            rCFrameLayout.setBackgroundColor(0);
            rCFrameLayout.addView(onCreateView, -1, -1);
            onCreateView = rCFrameLayout;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public void onFinalState(Bundle bundle, t tVar) {
        tVar.onFinalState(bundle);
        if (getActivity() != null && getActivity().getIntent() != null && this.intent.getIntExtra("key_dialog_type", -1) != -1) {
            getActivity().getWindow().setFlags(1024, 1024);
            getUIStyleHandler().T.setVisibility(8);
            getUIStyle().f314618a = true;
            an.e(super.getActivity());
            getWebTitleBarInterface().u5(false);
        }
    }

    @TargetApi(11)
    public void onInitUIContent(Bundle bundle, t tVar) {
        getUIStyle().f314622e = 0L;
        getUIStyleHandler().f314499a0 = true;
        getUIStyle().A = true;
        tVar.onInitUIContent(bundle);
        super.getActivity().getWindow().setBackgroundDrawableResource(R.color.ajr);
        if (getUIStyleHandler().S instanceof RefreshView) {
            ((RefreshView) getUIStyleHandler().S).a(false);
        }
        if (getUIStyleHandler().f314500b0 != null) {
            getUIStyleHandler().f314500b0.setVisibility(8);
        }
        if (this.webView.getX5WebViewExtension() != null) {
            try {
                this.webView.getView().setBackgroundColor(0);
                this.webView.setBackgroundColor(0);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else {
            this.webView.setBackgroundColor(0);
        }
        this.contentView.setBackgroundColor(0);
    }
}
