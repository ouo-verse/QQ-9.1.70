package com.tencent.mobileqq.tvideo.base;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoWebFragment extends WebViewFragment {
    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public WebViewWrapper createWebViewWrapper(boolean z16) {
        return new com.tencent.mobileqq.tvideo.webview.e(getWebViewKernelCallBack(), this.intent, getActivity(), z16);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
