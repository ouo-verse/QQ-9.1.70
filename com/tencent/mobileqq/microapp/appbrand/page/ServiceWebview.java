package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ServiceWebview extends BaseAppBrandWebview {
    static IPatchRedirector $redirector_;
    public AppBrandServiceEventInterface appBrandEventInterface;
    private HashMap appServiceJsLoadFlagMap;

    public ServiceWebview(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.appServiceJsLoadFlagMap = new HashMap();
            addJavascriptInterface(this, "WeixinJSCore");
        }
    }

    public void clearUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            removeJavascriptInterface("WeixinJSCore");
        }
    }

    public void initService$cfb2ece(c cVar, a.InterfaceC8030a interfaceC8030a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) interfaceC8030a);
            return;
        }
        initJSGlobalConfig();
        if (QLog.isColorLevel()) {
            QLog.i("PageWebview111", 2, "---start getWAServiceJSStr----");
        }
        evaluteJs(cVar.f(), new ValueCallback(interfaceC8030a, cVar) { // from class: com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ c val$apkgInfo$5475ea27;
            final /* synthetic */ a.InterfaceC8030a val$listener;

            {
                this.val$listener = interfaceC8030a;
                this.val$apkgInfo$5475ea27 = cVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ServiceWebview.this, interfaceC8030a, cVar);
                }
            }

            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            public void onReceiveValue(Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, obj);
                    return;
                }
                a.InterfaceC8030a interfaceC8030a2 = this.val$listener;
                if (interfaceC8030a2 != null) {
                    interfaceC8030a2.a();
                }
                c.a(ServiceWebview.this, this.val$apkgInfo$5475ea27.a());
                if (QLog.isColorLevel()) {
                    QLog.i("PageWebview111", 2, "---end getWAServiceJSStr----");
                }
            }
        });
    }

    @JavascriptInterface
    public String invokeHandler(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3));
        }
        QLog.d("AppBrandServiceEventInterface", 2, "invokeHandler|service: " + str + " |data: " + str2 + " |id:" + i3);
        AppBrandServiceEventInterface appBrandServiceEventInterface = this.appBrandEventInterface;
        if (appBrandServiceEventInterface != null) {
            return appBrandServiceEventInterface.onServiceNativeRequest(str, str2, i3);
        }
        return "";
    }

    public void loadAppServiceJs(String str) {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str) || (cVar = this.apkgInfo$5475ea27) == null) {
            return;
        }
        String d16 = cVar.d(str);
        if (TextUtils.isEmpty(d16)) {
            return;
        }
        if (this.appServiceJsLoadFlagMap.get(d16) != null && ((Boolean) this.appServiceJsLoadFlagMap.get(d16)).booleanValue()) {
            return;
        }
        String f16 = this.apkgInfo$5475ea27.f(d16);
        if (TextUtils.isEmpty(f16)) {
            return;
        }
        evaluteJs(f16, new ValueCallback(d16) { // from class: com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$subPkgRoot;

            {
                this.val$subPkgRoot = d16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ServiceWebview.this, (Object) d16);
                }
            }

            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            public void onReceiveValue(Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, obj);
                } else {
                    ServiceWebview.this.appServiceJsLoadFlagMap.put(this.val$subPkgRoot, Boolean.TRUE);
                }
            }
        });
    }

    @JavascriptInterface
    public void publishHandler(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3);
            return;
        }
        QLog.d("AppBrandServiceEventInterface", 2, "publishHandler|service: " + str + " |str2: " + str2 + " |str3:" + str3);
        AppBrandServiceEventInterface appBrandServiceEventInterface = this.appBrandEventInterface;
        if (appBrandServiceEventInterface != null) {
            appBrandServiceEventInterface.onServiceEvent(str, str2, c.o(str3));
        }
    }
}
