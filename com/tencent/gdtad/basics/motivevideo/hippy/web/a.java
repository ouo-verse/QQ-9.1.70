package com.tencent.gdtad.basics.motivevideo.hippy.web;

import com.tencent.gdtad.web.k;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
final class a extends com.tencent.mobileqq.webview.swift.a {
    @Override // com.tencent.mobileqq.webview.swift.a
    public List<WebViewPlugin> getCommonJsPlugin() {
        WebViewPlugin webViewPlugin;
        List<WebViewPlugin> commonJsPlugin = super.getCommonJsPlugin();
        if (commonJsPlugin != null && !commonJsPlugin.isEmpty()) {
            Iterator<WebViewPlugin> it = commonJsPlugin.iterator();
            while (true) {
                if (it.hasNext()) {
                    webViewPlugin = it.next();
                    if (webViewPlugin instanceof k) {
                        break;
                    }
                } else {
                    webViewPlugin = null;
                    break;
                }
            }
            if (webViewPlugin == null) {
                QLog.e("GdtMotiveHippyWebViewCommonJsPluginFactory", 1, "[GdtMotiveHippyWebViewCommonJsPluginFactory][getCommonJsPlugin] error, reportPlugin is null");
                return commonJsPlugin;
            }
            try {
                commonJsPlugin.remove(webViewPlugin);
            } catch (Throwable th5) {
                QLog.e("GdtMotiveHippyWebViewCommonJsPluginFactory", 1, "[GdtMotiveHippyWebViewCommonJsPluginFactory][getCommonJsPlugin]", th5);
            }
            return commonJsPlugin;
        }
        QLog.e("GdtMotiveHippyWebViewCommonJsPluginFactory", 1, "[GdtMotiveHippyWebViewCommonJsPluginFactory][getCommonJsPlugin] error, result is empty");
        return commonJsPlugin;
    }
}
