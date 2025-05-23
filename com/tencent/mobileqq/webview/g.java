package com.tencent.mobileqq.webview;

import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class g extends WebViewPlugin {
    private boolean p(String str) {
        if (AuthorizeConfig.y().J(str)) {
            return !r0.I(str);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "forceHttps";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        String str3;
        if (AuthorizeConfig.y().q() && "http".equals(str2) && p(str)) {
            SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) getBrowserComponent(-2);
            if (swiftBrowserStatistics != null) {
                swiftBrowserStatistics.Q0 = true;
            }
            String str4 = "https" + str.substring(4);
            CustomWebView e16 = this.mRuntime.e();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("need switch url=");
                sb5.append(com.tencent.biz.common.util.k.f(str, new String[0]));
                if (e16 == null) {
                    str3 = ", view==null";
                } else {
                    str3 = "";
                }
                sb5.append(str3);
                QLog.i("forceHttps", 2, sb5.toString());
            }
            if (e16 != null) {
                e16.loadUrl(str4);
                return true;
            }
        }
        return false;
    }
}
