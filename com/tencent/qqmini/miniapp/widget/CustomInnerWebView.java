package com.tencent.qqmini.miniapp.widget;

import android.app.Activity;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.miniapp.core.page.AppBrandPage;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CustomInnerWebView extends InnerWebView {
    public CustomInnerWebView(Activity activity, boolean z16) {
        super(activity);
        if (z16) {
            setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    @Override // com.tencent.qqmini.miniapp.widget.InnerWebView
    protected void handleReceivedTitle(String str) {
    }

    @Override // com.tencent.qqmini.miniapp.widget.InnerWebView
    protected void updateProgressBar(AppBrandPage appBrandPage) {
    }
}
