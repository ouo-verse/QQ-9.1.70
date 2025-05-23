package com.qzone.proxy.covercomponent.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.qzone.misc.web.webview.QzoneWebViewPluginManager;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.webview.m;
import cooperation.qzone.CloseGuard;
import cooperation.qzone.webviewwrapper.IWebviewListener;
import s7.a;
import s7.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AdvWebviewWrapper extends WebviewWrapper {
    private final CloseGuard guard;

    public AdvWebviewWrapper(Context context) {
        super(context);
        this.guard = CloseGuard.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.proxy.covercomponent.adapter.WebviewWrapper
    public void finalize() throws Throwable {
        try {
            CloseGuard closeGuard = this.guard;
            if (closeGuard != null) {
                closeGuard.warnIfOpen();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.qzone.proxy.covercomponent.adapter.WebviewWrapper, cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void onDestroy() {
        this.guard.close();
        super.onDestroy();
    }

    @Override // com.qzone.proxy.covercomponent.adapter.WebviewWrapper, cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void onInit(Activity activity, Intent intent, String str, final IWebviewListener iWebviewListener) {
        this.guard.open(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.mWebViewBuilder = new b(this.mContext, activity, intent, QzoneWebViewPluginManager.getInstance().getRuntime(), false);
        this.mWebview.setVisibility(4);
        this.mWebViewBuilder.setWebView(this.mWebview);
        this.mWebViewBuilder.a(new b.InterfaceC11212b() { // from class: com.qzone.proxy.covercomponent.adapter.AdvWebviewWrapper.1
            @Override // s7.b.InterfaceC11212b
            public void onPageFinished() {
                if (AdvWebviewWrapper.this.mWebview.getVisibility() != 0) {
                    AdvWebviewWrapper.this.mWebview.setVisibility(0);
                    IWebviewListener iWebviewListener2 = iWebviewListener;
                    if (iWebviewListener2 != null) {
                        iWebviewListener2.onPageFinished();
                    }
                }
                a aVar = AdvWebviewWrapper.this.qzoneShowJSPlugin;
                if (aVar != null) {
                    long j3 = aVar.f433404h;
                    if (j3 <= 0 || j3 < aVar.f433401d) {
                        aVar.f433404h = System.currentTimeMillis();
                    }
                }
            }
        });
        new m(this.mWebViewBuilder).a(null, QzoneWebViewPluginManager.getInstance().getRuntime(), null);
    }
}
