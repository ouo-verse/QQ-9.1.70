package com.tencent.comic.hippy.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.comic.api.a;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsShareManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQHippyWebView extends FrameLayout implements HippyViewBase, a {
    private static final String TAG = "QQHippyWebView";
    private HippyViewEvent mEventOnMessage;
    private boolean mIsBackgroundTransparent;
    private HippyMap mSourceMap;
    private HippyWebViewModule mWebViewModule;
    private com.tencent.share.a shareHelper;

    public QQHippyWebView(Context context) {
        super(context);
        Intent intent = new Intent();
        intent.putExtra("web_view_module_from", 2);
        Activity activity = getActivity(context);
        context = activity != null ? activity : context;
        TbsShareManager.isThirdPartyApp(context);
        initWebViewModuleSafety(intent, context);
        this.shareHelper = new com.tencent.share.a(context);
    }

    private Activity getActivity(Context context) {
        HippyQQEngine hippyQQEngine = getHippyQQEngine(context);
        if (hippyQQEngine != null) {
            return hippyQQEngine.getActivity();
        }
        return null;
    }

    private HippyQQEngine getHippyQQEngine(Context context) {
        HippyEngineContext engineContext;
        if ((context instanceof HippyInstanceContext) && (engineContext = ((HippyInstanceContext) context).getEngineContext()) != null) {
            return HippyQQEngine.getEngineInstance(engineContext.getEngineId());
        }
        return null;
    }

    private void initWebViewModuleSafety(Intent intent, Context context) {
        try {
            HippyWebViewModule hippyWebViewModule = new HippyWebViewModule(intent, context, this);
            this.mWebViewModule = hippyWebViewModule;
            hippyWebViewModule.onCreate();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void reSizeWebView(TouchWebView touchWebView) {
        ViewGroup.LayoutParams layoutParams = touchWebView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        } else {
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        touchWebView.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
    }

    @Override // com.tencent.comic.api.a
    public Object getShareHelper() {
        return this.shareHelper;
    }

    public void initSource(HippyMap hippyMap) {
        this.mSourceMap = hippyMap;
        HippyWebViewModule hippyWebViewModule = this.mWebViewModule;
        if (hippyWebViewModule != null) {
            checkInit(hippyWebViewModule.webView, hippyMap);
        }
    }

    public boolean isBackgroundTransparent() {
        return this.mIsBackgroundTransparent;
    }

    public void loadUrl(String str) {
        TouchWebView touchWebView;
        HippyWebViewModule hippyWebViewModule = this.mWebViewModule;
        if (hippyWebViewModule != null && (touchWebView = hippyWebViewModule.webView) != null) {
            touchWebView.loadUrl(str);
        } else {
            QLog.e(TAG, 1, "loadUrl webview is null");
        }
    }

    public void onDestroy() {
        HippyWebViewModule hippyWebViewModule = this.mWebViewModule;
        if (hippyWebViewModule != null) {
            hippyWebViewModule.onPause();
            this.mWebViewModule.onDestroy();
        }
    }

    public void onWebViewInited(TouchWebView touchWebView) {
        new FrameLayout.LayoutParams(-1, -1);
        addView(touchWebView);
        reSizeWebView(touchWebView);
        touchWebView.onResume();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onWebViewInited webView");
        }
        checkInit(this.mWebViewModule.webView, this.mSourceMap);
    }

    public void postMessage(String str) {
        if (this.mEventOnMessage == null) {
            this.mEventOnMessage = new HippyViewEvent("onMessage");
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("data", str);
        this.mEventOnMessage.send(this, hippyMap);
    }

    public void setBackgroundTransparent(boolean z16) {
        TouchWebView touchWebView;
        this.mIsBackgroundTransparent = z16;
        if (!z16 || (touchWebView = this.mWebViewModule.webView) == null) {
            return;
        }
        touchWebView.setBackgroundColor(0);
    }

    private void checkInit(TouchWebView touchWebView, HippyMap hippyMap) {
        if (touchWebView == null || hippyMap == null) {
            return;
        }
        String string = hippyMap.getString("userAgent");
        if (!TextUtils.isEmpty(string)) {
            touchWebView.getSettings().setUserAgentString(string);
        }
        String string2 = hippyMap.getString(LayoutAttrDefine.CLICK_URI);
        if (!TextUtils.isEmpty(string2)) {
            if ("POST".equalsIgnoreCase(hippyMap.getString("method"))) {
                String string3 = hippyMap.getString("body");
                touchWebView.postUrl(string2, string3 == null ? null : string3.getBytes());
                return;
            } else {
                touchWebView.loadUrl(string2);
                return;
            }
        }
        String string4 = hippyMap.getString(TextComponent.SpanType.HTML);
        if (TextUtils.isEmpty(string4)) {
            return;
        }
        String string5 = hippyMap.getString("baseUrl");
        if (!TextUtils.isEmpty(string5)) {
            touchWebView.loadDataWithBaseURL(string5, string4, "text/html; charset=utf-8", "UTF-8", null);
        } else {
            touchWebView.loadData(string4, "text/html; charset=utf-8", "UTF-8");
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
    }
}
