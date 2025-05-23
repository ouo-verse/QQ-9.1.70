package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import com.tencent.comic.api.IQQComicWebViewApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IJsApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ae {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final com.tencent.mobileqq.webview.swift.a f314190a;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends com.tencent.mobileqq.webview.swift.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.a
        public List<WebViewPlugin> getCommonJsPlugin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getWebSecurityPluginV2Plugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getEventApiPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getUIApiPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getTogetherBusinessForWebPlugin());
            return arrayList;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77317);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f314190a = new a();
        }
    }

    public static com.tencent.mobileqq.webview.swift.a a(Intent intent) {
        int intExtra = intent.getIntExtra("web_view_module_from", -1);
        if (intExtra != 1) {
            if (intExtra == 2) {
                Object commonJsPluginFactory = ((IQQComicWebViewApi) QRoute.api(IQQComicWebViewApi.class)).getCommonJsPluginFactory();
                if (commonJsPluginFactory instanceof com.tencent.mobileqq.webview.swift.a) {
                    return (com.tencent.mobileqq.webview.swift.a) commonJsPluginFactory;
                }
                QLog.e("WebViewModulePluginBuilder", 1, "comicFactory not CommonJsPluginFactory");
            }
            return null;
        }
        return f314190a;
    }
}
