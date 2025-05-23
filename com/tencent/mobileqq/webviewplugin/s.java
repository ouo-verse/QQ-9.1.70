package com.tencent.mobileqq.webviewplugin;

import android.view.View;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.y;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface s extends y {
    WebViewWrapper createWebViewWrapper(boolean z16);

    View.OnClickListener getOnclickListener();

    n getWebShareInterface();

    q getWebTitleBarInterface();

    com.tencent.mobileqq.webview.swift.utils.t getWebViewKernelCallBack();
}
