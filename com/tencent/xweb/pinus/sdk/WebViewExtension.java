package com.tencent.xweb.pinus.sdk;

import com.tencent.xweb.CalledByRuntime;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.util.WebViewExtensionListener;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebViewExtension {
    private static final String TAG = "WebViewExtension";

    @CalledByRuntime
    public static int getHostByName(String str, List<String> list) {
        WebViewExtensionListener webViewExtensionListener = XWalkEnvironment.getWebViewExtensionListener();
        if (webViewExtensionListener != null) {
            Object onMiscCallBack = webViewExtensionListener.onMiscCallBack(ConstValue.EXTENSION_GET_HOST_NAME_FROM_NEW, str, list);
            if (onMiscCallBack instanceof Integer) {
                return ((Integer) onMiscCallBack).intValue();
            }
        }
        return 0;
    }

    @CalledByRuntime
    public static int getHostByNameFromHttp(String str, List<String> list) {
        WebViewExtensionListener webViewExtensionListener = XWalkEnvironment.getWebViewExtensionListener();
        if (webViewExtensionListener != null) {
            Object onMiscCallBack = webViewExtensionListener.onMiscCallBack(ConstValue.EXTENSION_GET_HOST_NAME_FROM_HTTP, str, list);
            if (onMiscCallBack instanceof Integer) {
                return ((Integer) onMiscCallBack).intValue();
            }
        }
        return 0;
    }

    @CalledByRuntime
    public static Object onMiscCallBack(String str, Object... objArr) {
        WebViewExtensionListener webViewExtensionListener = XWalkEnvironment.getWebViewExtensionListener();
        if (webViewExtensionListener != null) {
            return webViewExtensionListener.onMiscCallBack(str, objArr);
        }
        return null;
    }
}
