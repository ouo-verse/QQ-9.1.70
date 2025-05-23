package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

/* loaded from: classes20.dex */
public abstract class VasBasePlugin extends WebViewPlugin {
    protected long business;
    public long startOpenPageTime;
    public long onPageStartedTime = -1;
    public long onPageFinishedTime = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent getInfoIntent() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.a() != null) {
            return this.mRuntime.a().getIntent();
        }
        return new Intent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getPluginBusiness() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        this.startOpenPageTime = getInfoIntent().getLongExtra("startOpenPageTime", System.currentTimeMillis());
        this.business = getInfoIntent().getLongExtra("business", 0L);
    }
}
