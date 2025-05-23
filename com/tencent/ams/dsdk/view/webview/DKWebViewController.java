package com.tencent.ams.dsdk.view.webview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

/* compiled from: P */
@HippyController(name = "DKWebView")
/* loaded from: classes3.dex */
public class DKWebViewController extends HippyViewController<DKHippyWebViewContainer> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKWebViewController";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private @interface DKHippyWebviewFunction {
        public static final String CAN_GO_BACK = "canGoBack";
        public static final String CAN_GO_FORWARD = "canGoForward";
        public static final String EVALUATE_JAVASCRIPT = "evaluateJavaScript";
        public static final String GET_USER_AGENT = "getUserAgent";
        public static final String GO_BAC = "goBack";
        public static final String GO_FORWARD = "goForward";
        public static final String LOAD_URL = "loadUrl";
        public static final String RELOAD = "reload";
        public static final String SET_LAUNCH_MODE = "setLaunchMode";
        public static final String SET_USER_AGENT = "setUserAgent";
        public static final String STOP_LOADING = "stopLoading";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private @interface ErrorCode {
        public static final int FUNCTION_EMPTY = 1;
        public static final int FUNCTION_EXCEPTION = 3;
        public static final int FUNCTION_INVALID_PARAMS = 5;
        public static final int FUNCTION_NOT_SUPPORTED = 2;
        public static final int FUNCTION_VIEW_NULL = 4;
    }

    public DKWebViewController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00bb, code lost:
    
        if (r12.equals(com.tencent.ams.dsdk.view.webview.DKWebViewController.DKHippyWebviewFunction.CAN_GO_FORWARD) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleDispatchFunction(DKHippyWebViewContainer dKHippyWebViewContainer, String str, HippyArray hippyArray, Promise promise) {
        HippyMap map;
        String string;
        String string2;
        char c16 = 1;
        if (TextUtils.isEmpty(str)) {
            DLog.w(TAG, "handleDispatchFunction, function name is empty.");
            reject(promise, 1, "function name is empty.");
            return;
        }
        if (dKHippyWebViewContainer == null) {
            DLog.w(TAG, "handleDispatchFunction, webview is null");
            reject(promise, 4, "webview is null.");
            return;
        }
        String str2 = null;
        if (hippyArray == null) {
            map = null;
        } else {
            map = hippyArray.getMap(0);
        }
        str.hashCode();
        switch (str.hashCode()) {
            case -1241591313:
                if (str.equals(DKHippyWebviewFunction.GO_BAC)) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1067273523:
                break;
            case -948122918:
                if (str.equals(DKHippyWebviewFunction.STOP_LOADING)) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case -934641255:
                if (str.equals(DKHippyWebviewFunction.RELOAD)) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case -318289731:
                if (str.equals(DKHippyWebviewFunction.GO_FORWARD)) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case -317054497:
                if (str.equals(DKHippyWebviewFunction.CAN_GO_BACK)) {
                    c16 = 5;
                    break;
                }
                c16 = '\uffff';
                break;
            case 301825860:
                if (str.equals(DKHippyWebviewFunction.GET_USER_AGENT)) {
                    c16 = 6;
                    break;
                }
                c16 = '\uffff';
                break;
            case 336631465:
                if (str.equals(DKHippyWebviewFunction.LOAD_URL)) {
                    c16 = 7;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1021780742:
                if (str.equals(DKHippyWebviewFunction.EVALUATE_JAVASCRIPT)) {
                    c16 = '\b';
                    break;
                }
                c16 = '\uffff';
                break;
            case 1022608888:
                if (str.equals(DKHippyWebviewFunction.SET_LAUNCH_MODE)) {
                    c16 = '\t';
                    break;
                }
                c16 = '\uffff';
                break;
            case 1850818488:
                if (str.equals(DKHippyWebviewFunction.SET_USER_AGENT)) {
                    c16 = '\n';
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                dKHippyWebViewContainer.goBack();
                resolve(promise, null);
                return;
            case 1:
                resolve(promise, Boolean.valueOf(dKHippyWebViewContainer.canGoForward()));
                return;
            case 2:
                dKHippyWebViewContainer.stopLoading();
                resolve(promise, null);
                return;
            case 3:
                dKHippyWebViewContainer.reload();
                resolve(promise, null);
                return;
            case 4:
                dKHippyWebViewContainer.goForward();
                resolve(promise, null);
                return;
            case 5:
                resolve(promise, Boolean.valueOf(dKHippyWebViewContainer.canGoBack()));
                return;
            case 6:
                resolve(promise, dKHippyWebViewContainer.getUserAgent());
                return;
            case 7:
                if (map == null) {
                    string = null;
                } else {
                    string = map.getString("url");
                }
                dKHippyWebViewContainer.loadUrl(string);
                resolve(promise, null);
                return;
            case '\b':
                if (map != null) {
                    str2 = map.getString("scriptString");
                }
                dKHippyWebViewContainer.evaluateJavaScript(str2, new ValueCallback<String>(promise) { // from class: com.tencent.ams.dsdk.view.webview.DKWebViewController.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Promise val$promise;

                    {
                        this.val$promise = promise;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKWebViewController.this, (Object) promise);
                        }
                    }

                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            DKWebViewController.this.resolve(this.val$promise, str3);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str3);
                        }
                    }
                });
                return;
            case '\t':
                if (map != null && map.containsKey("mode")) {
                    try {
                        dKHippyWebViewContainer.setLaunchMode(map.getInt("mode"));
                        resolve(promise, null);
                        return;
                    } catch (Throwable th5) {
                        DLog.e(TAG, "handleDispatchFunction function:" + str, th5);
                        reject(promise, 3, th5.getMessage());
                        return;
                    }
                }
                reject(promise, 5, "invalid params");
                return;
            case '\n':
                if (map == null) {
                    string2 = null;
                } else {
                    string2 = map.getString("userAgent");
                }
                dKHippyWebViewContainer.setUserAgent(string2);
                resolve(promise, null);
                return;
            default:
                DLog.w(TAG, "unsupported function: " + str);
                reject(promise, 2, "unsupported function.");
                return;
        }
    }

    private void reject(Promise promise, int i3, String str) {
        if (promise != null) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("code", i3);
            hippyMap.pushString("message", str);
            promise.reject(hippyMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resolve(Promise promise, Object obj) {
        if (promise != null) {
            promise.resolve(obj);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        return new DKHippyWebViewContainer(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public boolean handleGestureBySelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }

    @HippyControllerProps(defaultType = "map", name = "source")
    public void setSource(DKHippyWebViewContainer dKHippyWebViewContainer, HippyMap hippyMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dKHippyWebViewContainer, (Object) hippyMap);
            return;
        }
        DLog.i(TAG, "setSource, source: " + hippyMap);
        if (dKHippyWebViewContainer != null) {
            dKHippyWebViewContainer.setSource(hippyMap);
        }
    }

    @HippyControllerProps(defaultString = "", defaultType = HippyControllerProps.STRING, name = "url")
    public void setUrl(DKHippyWebViewContainer dKHippyWebViewContainer, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dKHippyWebViewContainer, (Object) str);
            return;
        }
        DLog.i(TAG, "setUrl, url: " + str);
        if (dKHippyWebViewContainer != null) {
            dKHippyWebViewContainer.loadUrl(str);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(DKHippyWebViewContainer dKHippyWebViewContainer, String str, HippyArray hippyArray, Promise promise) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, dKHippyWebViewContainer, str, hippyArray, promise);
            return;
        }
        super.dispatchFunction((DKWebViewController) dKHippyWebViewContainer, str, hippyArray, promise);
        DLog.i(TAG, "dispatchFunction, functionName: " + str + ", view: " + dKHippyWebViewContainer + ", params: " + hippyArray);
        try {
            handleDispatchFunction(dKHippyWebViewContainer, str, hippyArray, promise);
        } catch (Throwable th5) {
            DLog.e(TAG, "handle " + str + " error.", th5);
            reject(promise, 3, th5.getMessage());
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(DKHippyWebViewContainer dKHippyWebViewContainer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dKHippyWebViewContainer);
            return;
        }
        DLog.i(TAG, "onViewDestroy, webview: " + dKHippyWebViewContainer);
        if (dKHippyWebViewContainer != null) {
            dKHippyWebViewContainer.destroy();
        }
    }
}
