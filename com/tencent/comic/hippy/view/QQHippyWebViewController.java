package com.tencent.comic.hippy.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@HippyController(name = "WebView")
/* loaded from: classes32.dex */
public class QQHippyWebViewController extends HippyViewController<QQHippyWebView> {
    private static final String TAG = "QQHippyWebViewController";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new QQHippyWebView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public boolean handleGestureBySelf() {
        return true;
    }

    @HippyControllerProps(defaultString = "", defaultType = HippyControllerProps.STRING, name = "url")
    public void loadUrl(QQHippyWebView qQHippyWebView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        qQHippyWebView.loadUrl(str);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT)
    public void setBackgroundTransparent(QQHippyWebView qQHippyWebView, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setBackgroundTransparent ", Boolean.valueOf(z16));
        }
        qQHippyWebView.setBackgroundTransparent(z16);
    }

    @HippyControllerProps(defaultType = "map", name = "source")
    public void source(QQHippyWebView qQHippyWebView, HippyMap hippyMap) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "source info:", hippyMap);
        }
        if (hippyMap != null) {
            qQHippyWebView.initSource(hippyMap);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(QQHippyWebView qQHippyWebView, String str, HippyArray hippyArray) {
        super.dispatchFunction((QQHippyWebViewController) qQHippyWebView, str, hippyArray);
        if (!DKWebViewController.DKHippyWebviewFunction.LOAD_URL.equals(str) || hippyArray == null) {
            return;
        }
        loadUrl(qQHippyWebView, hippyArray.getString(0));
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(QQHippyWebView qQHippyWebView) {
        qQHippyWebView.onDestroy();
    }
}
