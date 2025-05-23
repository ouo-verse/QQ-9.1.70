package com.tencent.mobileqq.tvideo.webview;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.tencent.biz.common.util.k;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.z;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends WebViewWrapper {
    public e(z zVar, Intent intent, Context context, boolean z16) {
        super(zVar, intent, context, z16);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewWrapper
    public TouchWebView h(Context context, boolean z16) {
        TouchWebView tVideoChannelWebView;
        k.a(AbsBaseWebViewActivity.WEBVIEW_BROWSER_INIT_WEBVIEW);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z17 = true;
        if (z16) {
            if (SwiftReuseTouchWebView.I != 0) {
                z17 = false;
            }
            tVideoChannelWebView = SwiftReuseTouchWebView.q(context);
        } else {
            tVideoChannelWebView = new TVideoChannelWebView(context);
        }
        DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        ViewGroup.LayoutParams layoutParams = tVideoChannelWebView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            layoutParams.width = displayMetrics.widthPixels;
            layoutParams.height = displayMetrics.heightPixels;
        }
        tVideoChannelWebView.setLayoutParams(layoutParams);
        if (z17) {
            this.f314159f = System.currentTimeMillis() - currentTimeMillis;
        }
        return tVideoChannelWebView;
    }
}
