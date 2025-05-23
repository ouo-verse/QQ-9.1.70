package eu3;

import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes23.dex */
public class h extends WebChromeClient {
    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage != null) {
            String message = consoleMessage.message();
            int lineNumber = consoleMessage.lineNumber();
            ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
            if (messageLevel == ConsoleMessage.MessageLevel.ERROR) {
                QMLog.e("Mini-WebChromeClient", message + " line:" + lineNumber);
            } else if (messageLevel == ConsoleMessage.MessageLevel.WARNING) {
                QMLog.w("Mini-WebChromeClient", message + " line:" + lineNumber);
            } else if (QMLog.isColorLevel()) {
                QMLog.w("Mini-WebChromeClient", message);
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onProgressChanged(WebView webView, int i3) {
        JsInjector.getInstance().onProgressChanged(webView, i3);
        super.onProgressChanged(webView, i3);
    }
}
