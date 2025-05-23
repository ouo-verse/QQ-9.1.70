package com.tencent.mtt.hippy.views.webview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

/* compiled from: P */
@HippyController(name = "WebView")
/* loaded from: classes20.dex */
public class HippyWebViewController extends HippyViewController<HippyWebView> {
    public static final String CLASS_NAME = "WebView";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyWebView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public boolean handleGestureBySelf() {
        return true;
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "url")
    public void loadUrl(HippyWebView hippyWebView, String str) {
        if (!TextUtils.isEmpty(str)) {
            hippyWebView.mWebView.loadUrl(str);
        }
    }

    @HippyControllerProps(defaultType = "map", name = "source")
    public void source(HippyWebView hippyWebView, HippyMap hippyMap) {
        byte[] bytes;
        if (hippyMap != null) {
            String string = hippyMap.getString("userAgent");
            if (!TextUtils.isEmpty(string)) {
                hippyWebView.mWebView.getSettings().setUserAgentString(string);
            }
            String string2 = hippyMap.getString(LayoutAttrDefine.CLICK_URI);
            if (!TextUtils.isEmpty(string2)) {
                if ("POST".equalsIgnoreCase(hippyMap.getString("method"))) {
                    String string3 = hippyMap.getString("body");
                    HippyWebViewInner hippyWebViewInner = hippyWebView.mWebView;
                    if (string3 == null) {
                        bytes = null;
                    } else {
                        bytes = string3.getBytes();
                    }
                    hippyWebViewInner.postUrl(string2, bytes);
                    return;
                }
                hippyWebView.mWebView.loadUrl(string2);
                return;
            }
            String string4 = hippyMap.getString(TextComponent.SpanType.HTML);
            if (!TextUtils.isEmpty(string4)) {
                String string5 = hippyMap.getString("baseUrl");
                if (!TextUtils.isEmpty(string5)) {
                    hippyWebView.mWebView.loadDataWithBaseURL(string5, string4, "text/html; charset=utf-8", "UTF-8", null);
                } else {
                    hippyWebView.mWebView.loadData(string4, "text/html; charset=utf-8", "UTF-8");
                }
            }
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyWebView hippyWebView, String str, HippyArray hippyArray) {
        super.dispatchFunction((HippyWebViewController) hippyWebView, str, hippyArray);
        if (!DKWebViewController.DKHippyWebviewFunction.LOAD_URL.equals(str) || hippyArray == null) {
            return;
        }
        loadUrl(hippyWebView, hippyArray.getString(0));
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(HippyWebView hippyWebView) {
        hippyWebView.mWebView.destroy();
    }
}
