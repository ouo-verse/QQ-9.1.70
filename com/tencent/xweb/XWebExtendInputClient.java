package com.tencent.xweb;

import android.os.ResultReceiver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import com.tencent.xweb.compatible.PinusAdaptClient;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebExtendInputClient extends PinusAdaptClient {
    public XWebExtendInputClient(XWebExtendInterface xWebExtendInterface) {
        super.init(xWebExtendInterface);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.xwebType == 1) {
            this.psWebview.evaluateJavascript(str, valueCallback);
        }
    }

    public int getToolBarHeight(int i3) {
        return 0;
    }

    @Override // com.tencent.xweb.compatible.PinusAdaptClient
    public void initPSWebView(com.tencent.xweb.pinus.sdk.WebView webView) {
        super.initPSWebView(webView);
    }

    public boolean onHideKeyboard(String str, InputConnection inputConnection) {
        return false;
    }

    public void onKeyboardHeightChanged(boolean z16, int i3, boolean z17) {
        if (this.xwebType == 1) {
            this.psWebview.onExtendInputKeyboardHeightChanged(z16, i3, z17);
        }
    }

    public boolean onShowKeyboard(String str, String str2, InputConnection inputConnection, ResultReceiver resultReceiver) {
        return false;
    }

    public boolean onShowKeyboardConfig(String str, int i3, int i16, String str2, int i17, int i18, EditorInfo editorInfo) {
        return false;
    }

    public boolean performEditorAction(int i3) {
        return true;
    }

    public void onExtraInfoChanged(String str) {
    }
}
