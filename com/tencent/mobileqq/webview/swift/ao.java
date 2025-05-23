package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ao {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Multi-variable type inference failed */
    public static int a(WebViewPlugin webViewPlugin) {
        if (webViewPlugin == 0) {
            return -1;
        }
        HashMap<Class<? extends WebViewPlugin>, Integer> hashMap = ag.f314194d;
        if (hashMap.containsKey(webViewPlugin.getClass())) {
            return hashMap.get(webViewPlugin.getClass()).intValue();
        }
        if (webViewPlugin instanceof l) {
            String[] multiNameSpace = ((l) webViewPlugin).getMultiNameSpace();
            if (multiNameSpace != null && multiNameSpace.length > 0) {
                for (String str : multiNameSpace) {
                    if (!TextUtils.isEmpty(str) && ag.f314191a.containsKey(str)) {
                        return ag.f314194d.get(ag.f314191a.get(str)).intValue();
                    }
                }
            }
        } else if (!TextUtils.isEmpty(webViewPlugin.getNameSpace())) {
            if (ag.f314191a.containsKey(webViewPlugin.getNameSpace())) {
                return hashMap.get(ag.f314191a.get(webViewPlugin.getNameSpace())).intValue();
            }
        } else {
            e(webViewPlugin.toString() + " have no namespace error");
            return -1;
        }
        return -1;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            e("have no namespace error");
            return -1;
        }
        if (ag.f314191a.containsKey(str)) {
            return ag.f314194d.get(ag.f314191a.get(str)).intValue();
        }
        e("have no namespace error");
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r4 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(WebViewPlugin webViewPlugin, Intent intent, byte b16, WebViewProvider webViewProvider) {
        int i3;
        if (webViewProvider != null) {
            i3 = webViewProvider.switchRequestCode(webViewPlugin, b16);
        }
        intent.putExtra("keyAction", "actionSelectPicture");
        intent.putExtra("requestCode", i3);
        if (webViewProvider != null) {
            webViewProvider.getHostActivity().startActivity(intent);
            return;
        }
        WebViewPlugin.b bVar = webViewPlugin.mRuntime;
        if (bVar != null && bVar.a() != null) {
            webViewPlugin.mRuntime.a().startActivity(intent);
        }
    }

    public static void d(WebViewPlugin webViewPlugin, ActivityURIRequest activityURIRequest, byte b16, WebViewProvider webViewProvider) {
        int switchRequestCode = webViewProvider.switchRequestCode(webViewPlugin, b16);
        activityURIRequest.extra().putString("keyAction", "actionSelectPicture");
        activityURIRequest.extra().putInt("requestCode", switchRequestCode);
        QRoute.startUri(activityURIRequest);
    }

    private static void e(String str) {
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
            QLog.e("WebViewUtil", 1, str);
            return;
        }
        throw new RuntimeException(String.format("fix me: %s", str));
    }
}
