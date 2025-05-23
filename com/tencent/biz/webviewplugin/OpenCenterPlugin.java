package com.tencent.biz.webviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.open.appcommon.js.AppInterface;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.appcommon.js.HttpInterface;
import com.tencent.open.appcommon.now.download.js.DownloadWebInterface;
import com.tencent.open.appstore.js.DINewForCommonWebView;
import com.tencent.open.appstore.js.YybTreasureCardJsPlugin;
import com.tencent.open.export.js.VipDownloadInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;

/* loaded from: classes32.dex */
public class OpenCenterPlugin extends com.tencent.mobileqq.webview.swift.k implements com.tencent.mobileqq.webview.swift.l {

    /* renamed from: d, reason: collision with root package name */
    private Map<String, BaseInterface> f97376d = null;

    private void p() {
        this.f97376d = new HashMap();
        Activity a16 = this.mRuntime.a();
        BaseJsCallBack baseJsCallBack = new BaseJsCallBack(a16);
        VipDownloadInterface vipDownloadInterface = new VipDownloadInterface(a16, this.mRuntime.e());
        HttpInterface httpInterface = new HttpInterface(a16, this.mRuntime.e());
        AppInterface appInterface = new AppInterface(a16, this.mRuntime.e());
        DownloadInterface downloadInterface = new DownloadInterface(a16, this.mRuntime.e());
        DINewForCommonWebView dINewForCommonWebView = new DINewForCommonWebView(a16, this.mRuntime.e());
        YybTreasureCardJsPlugin yybTreasureCardJsPlugin = new YybTreasureCardJsPlugin(a16, this.mRuntime.e());
        DownloadWebInterface downloadWebInterface = new DownloadWebInterface(a16, this.mRuntime.e());
        this.f97376d.put(baseJsCallBack.getInterfaceName(), baseJsCallBack);
        this.f97376d.put(vipDownloadInterface.getInterfaceName(), vipDownloadInterface);
        this.f97376d.put(httpInterface.getInterfaceName(), httpInterface);
        this.f97376d.put(appInterface.getInterfaceName(), appInterface);
        this.f97376d.put(downloadInterface.getInterfaceName(), downloadInterface);
        this.f97376d.put(dINewForCommonWebView.getInterfaceName(), dINewForCommonWebView);
        this.f97376d.put(yybTreasureCardJsPlugin.getInterfaceName(), yybTreasureCardJsPlugin);
        this.f97376d.put(downloadWebInterface.getInterfaceName(), downloadWebInterface);
    }

    @Override // com.tencent.mobileqq.webview.swift.k
    protected Method getJsMethod(String str, String str2, int i3) {
        BaseInterface baseInterface = this.f97376d.get(str);
        if (baseInterface == null) {
            return null;
        }
        for (Method method : baseInterface.getClass().getDeclaredMethods()) {
            if (method.getName().equals(str2) && method.getParameterTypes().length == i3) {
                return method;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.l
    public String[] getMultiNameSpace() {
        return new String[]{"opencenter", BaseJsCallBack.PLUGIN_NAMESPACE, "q_download_vip", HttpInterface.PLUGIN_NAMESPACE, AppInterface.PLUGIN_NAMESPACE, DownloadInterface.PLUGIN_NAMESPACE, DownloadWebInterface.PLUGIN_NAMESPACE, "q_download_v2", "yyb_treasureCard"};
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "opencenter";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        r10.c(null);
     */
    @Override // com.tencent.mobileqq.webview.swift.k, com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        Method method;
        Object invoke;
        if (this.f97376d == null) {
            p();
        }
        BaseInterface baseInterface = this.f97376d.get(str2);
        if (baseInterface != null) {
            method = null;
            for (Method method2 : baseInterface.getClass().getDeclaredMethods()) {
                if (method2.getName().equals(str3) && method2.getParameterTypes().length == strArr.length) {
                    method = method2;
                }
            }
        } else {
            method = null;
        }
        if (method != null) {
            try {
                if (strArr.length == 0) {
                    invoke = method.invoke(baseInterface, new Object[0]);
                } else {
                    invoke = method.invoke(baseInterface, strArr);
                }
                Class<?> returnType = method.getReturnType();
                if (returnType != Void.TYPE && returnType != Void.class) {
                    if (jsBridgeListener != null) {
                        jsBridgeListener.c(invoke);
                    }
                    return true;
                }
                return true;
            } catch (Exception e16) {
                QLog.e("opencenter", 1, "handleJsRequest exception " + str2 + "#" + str3 + ", " + e16.getMessage(), e16);
            }
        } else if (QLog.isDevelopLevel()) {
            QLog.i("opencenter", 2, "handleJsRequest method not found: " + str2 + "#" + str3 + "(" + strArr + ")");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        Map<String, BaseInterface> map = this.f97376d;
        if (map == null) {
            return;
        }
        Iterator<Map.Entry<String, BaseInterface>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            try {
                it.next().getValue().destroy();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onAppRuntimeReady(AppRuntime appRuntime) {
    }
}
