package com.tencent.luggage.wxa.z7;

import android.view.KeyEvent;
import com.tencent.luggage.wxa.kj.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebExtendInterface;
import com.tencent.xweb.XWebSdk;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class f {
    public static String a(String str, int i3) {
        return String.format(Locale.US, "%s#%d", str, Integer.valueOf(i3));
    }

    public static int b() {
        return 300;
    }

    public static boolean a() {
        return XWebSdk.isCurrentVersionSupportExtendPluginForAppbrand();
    }

    public static com.tencent.luggage.wxa.m8.c a(WebView webView, com.tencent.luggage.wxa.m8.d dVar, com.tencent.luggage.wxa.k8.c cVar, h0 h0Var) {
        if (!a()) {
            w.f("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current version not support extend plugin");
            return null;
        }
        if (webView != null && webView.isXWalkKernel()) {
            KeyEvent.Callback webViewUI = webView.getWebViewUI();
            if ((webViewUI instanceof XWebExtendInterface) && dVar != null) {
                XWebExtendInterface xWebExtendInterface = (XWebExtendInterface) webViewUI;
                com.tencent.luggage.wxa.m8.c createClientProxy = dVar.createClientProxy();
                e eVar = new e(xWebExtendInterface);
                eVar.a(createClientProxy);
                createClientProxy.a(eVar);
                xWebExtendInterface.setExtendPluginClient(eVar);
                if (h0Var != null) {
                    com.tencent.luggage.wxa.n8.a aVar = new com.tencent.luggage.wxa.n8.a(xWebExtendInterface);
                    aVar.a(h0Var);
                    xWebExtendInterface.setExtendTextAreaClient(aVar);
                    com.tencent.luggage.wxa.l8.d dVar2 = new com.tencent.luggage.wxa.l8.d(xWebExtendInterface);
                    dVar2.a(h0Var);
                    xWebExtendInterface.setExtendInputClient(dVar2);
                }
                if (cVar != null) {
                    createClientProxy.a(cVar);
                }
                w.d("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client success");
                return createClientProxy;
            }
            w.d("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client fail");
        } else {
            w.d("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current webview is not xweb kernel");
        }
        return null;
    }

    public static void a(com.tencent.luggage.wxa.m8.c cVar, String str, int i3, float f16, float f17) {
        if (cVar == null || cVar.a() == null) {
            return;
        }
        w.d("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginTextureScale, %s#%d, scale:[%s,%s]", str, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17));
        cVar.a().setPluginTextureScale(str, i3, f16, f17);
    }

    public static void a(com.tencent.luggage.wxa.m8.c cVar, String str, int i3) {
        if (cVar == null || cVar.a() == null) {
            return;
        }
        w.d("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginScreenshot, %s#%d", str, Integer.valueOf(i3));
        cVar.a().takePluginScreenshot(str, i3);
    }
}
