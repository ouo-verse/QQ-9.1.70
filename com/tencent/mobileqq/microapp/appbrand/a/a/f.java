package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.appbrand.page.WebViewEventListener;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class f implements Handler.Callback, WebViewEventListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.mobileqq.microapp.appbrand.a f245924a;

    /* renamed from: b, reason: collision with root package name */
    com.tencent.mobileqq.microapp.app.a f245925b;

    /* renamed from: c, reason: collision with root package name */
    com.tencent.mobileqq.microapp.widget.d f245926c;

    /* renamed from: d, reason: collision with root package name */
    DialogInterface.OnDismissListener f245927d;

    /* renamed from: e, reason: collision with root package name */
    DialogInterface.OnDismissListener f245928e;

    /* renamed from: f, reason: collision with root package name */
    private BaseActivity f245929f;

    /* renamed from: g, reason: collision with root package name */
    private List f245930g;

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentLinkedQueue f245931h;

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentLinkedQueue f245932i;

    /* renamed from: j, reason: collision with root package name */
    private Handler f245933j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f245934k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f245935l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements Serializable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f245936a;

        /* renamed from: b, reason: collision with root package name */
        public String f245937b;

        /* renamed from: c, reason: collision with root package name */
        public WeakReference f245938c;

        /* renamed from: d, reason: collision with root package name */
        public int f245939d;

        public a(f fVar, String str, String str2, BaseAppBrandWebview baseAppBrandWebview, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, fVar, str, str2, baseAppBrandWebview, Integer.valueOf(i3));
                return;
            }
            this.f245936a = str;
            this.f245937b = str2;
            this.f245938c = new WeakReference(baseAppBrandWebview);
            this.f245939d = i3;
        }
    }

    public f(BaseActivity baseActivity, com.tencent.mobileqq.microapp.appbrand.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseActivity, (Object) aVar);
            return;
        }
        this.f245927d = new h(this);
        this.f245928e = new i(this);
        this.f245929f = baseActivity;
        this.f245924a = aVar;
        this.f245930g = new ArrayList();
        this.f245925b = aVar.f245900e.getAuthorizeCenter(aVar.f245896a);
        this.f245931h = new ConcurrentLinkedQueue();
        this.f245932i = new ConcurrentLinkedQueue();
        this.f245933j = new Handler(Looper.getMainLooper(), this);
    }

    private void g() {
        this.f245933j.removeMessages(1);
        this.f245933j.removeMessages(2);
        this.f245933j.removeMessages(3);
        this.f245933j.removeMessages(4);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f245935l = false;
        this.f245934k = false;
        Iterator it = this.f245930g.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.microapp.appbrand.a.a.a) it.next()).a(this);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f245935l = false;
        Iterator it = this.f245930g.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.f245933j.obtainMessage(1).sendToTarget();
        this.f245933j.obtainMessage(4).sendToTarget();
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f245935l = true;
        Iterator it = this.f245930g.iterator();
        while (it.hasNext()) {
            it.next();
        }
        g();
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f245935l = true;
        this.f245934k = true;
        Iterator it = this.f245930g.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.f245930g.clear();
        this.f245931h.clear();
        g();
        com.tencent.mobileqq.microapp.widget.d dVar = this.f245926c;
        if (dVar != null) {
            dVar.setOnDismissListener(null);
            this.f245926c.dismiss();
            this.f245926c = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) message)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("JsPluginEngine", 2, "handleMessage what=" + message.what + ",isDestory=" + this.f245934k);
        }
        if (!this.f245934k && !this.f245935l) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            Iterator it = this.f245932i.iterator();
                            int i16 = message.arg1;
                            if (i16 != 3 && i16 != 2) {
                                a aVar = (a) this.f245932i.peek();
                                if (aVar != null) {
                                    this.f245931h.remove(aVar);
                                    a(aVar.f245936a, aVar.f245937b, (BaseAppBrandWebview) aVar.f245938c.get(), aVar.f245939d);
                                }
                            } else {
                                String str = (String) message.obj;
                                if (!TextUtils.isEmpty(str)) {
                                    if (str.equals(QQPermissionConstants.Permission.CAMERA)) {
                                        a(this.f245924a.f245904i, com.tencent.luggage.wxa.re.h.NAME, null);
                                    }
                                    while (it.hasNext()) {
                                        a aVar2 = (a) it.next();
                                        if (str.equals(com.tencent.mobileqq.microapp.app.a.f245878c.get(aVar2.f245936a))) {
                                            it.remove();
                                            b((BaseAppBrandWebview) aVar2.f245938c.get(), aVar2.f245936a, (JSONObject) null, aVar2.f245939d);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (this.f245926c == null) {
                            com.tencent.mobileqq.microapp.widget.d dVar = new com.tencent.mobileqq.microapp.widget.d(this.f245929f);
                            this.f245926c = dVar;
                            dVar.setOnDismissListener(this.f245927d);
                        }
                        this.f245926c.a(message.getData());
                        this.f245926c.a("\u6743\u9650\u8bbe\u7f6e", (String) com.tencent.mobileqq.microapp.app.a.f245879d.get(com.tencent.mobileqq.microapp.app.a.d(message.getData().getString("key_event_name", ""), message.getData().getString("key_params", ""))), "\u62d2\u7edd", "#FF000000", "\u53bb\u8bbe\u7f6e", "#FF000000", true, null);
                    }
                } else {
                    if (this.f245926c == null) {
                        com.tencent.mobileqq.microapp.widget.d dVar2 = new com.tencent.mobileqq.microapp.widget.d(this.f245929f);
                        this.f245926c = dVar2;
                        dVar2.setOnDismissListener(this.f245928e);
                    }
                    Bundle data = message.getData();
                    this.f245926c.a(data);
                    String c16 = com.tencent.mobileqq.microapp.app.a.c(data.getString("key_event_name", ""), data.getString("key_params", ""));
                    if (c16 != null) {
                        HashMap hashMap = com.tencent.mobileqq.microapp.app.a.f245877b;
                        if (hashMap.containsKey(c16)) {
                            c16 = (String) hashMap.get(c16);
                        }
                    }
                    com.tencent.mobileqq.microapp.widget.d dVar3 = this.f245926c;
                    dVar3.a(this.f245924a.f245898c.f245822c + "\u7533\u8bf7\u4ee5\u4e0b\u6743\u9650", c16, "\u62d2\u7edd", "#FF000000", "\u5141\u8bb8", "#FF000000", true, null);
                }
            } else {
                Iterator it5 = this.f245931h.iterator();
                int i17 = message.arg1;
                if (i17 == 3 || i17 == 2) {
                    String str2 = (String) message.obj;
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.equals(AuthorizeCenter.SCOPE_CAMERA)) {
                            a(this.f245924a.f245904i, com.tencent.luggage.wxa.re.h.NAME, null);
                        }
                        while (it5.hasNext()) {
                            a aVar3 = (a) it5.next();
                            if (str2.equals(com.tencent.mobileqq.microapp.app.a.c(aVar3.f245936a, aVar3.f245937b))) {
                                it5.remove();
                                b((BaseAppBrandWebview) aVar3.f245938c.get(), aVar3.f245936a, (JSONObject) null, aVar3.f245939d);
                            }
                        }
                    }
                }
                a aVar4 = (a) this.f245931h.peek();
                if (aVar4 != null) {
                    this.f245931h.remove(aVar4);
                    a(aVar4.f245936a, aVar4.f245937b, (BaseAppBrandWebview) aVar4.f245938c.get(), aVar4.f245939d);
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.WebViewEventListener
    public void onWebViewEvent(String str, String str2, String str3, String str4, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, str2, str3, str4, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("JsPluginEngine", 4, "onWebViewEvent eventName=" + str + ",jsonParams=" + str2 + ",webviewIds=" + str3 + ",appId=" + str4 + ",pageWebviewId=" + i3);
        }
        this.f245924a.a(str, str2, i3);
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.WebViewEventListener
    public String onWebViewNativeRequest(String str, String str2, BaseAppBrandWebview baseAppBrandWebview, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, this, str, str2, baseAppBrandWebview, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("JsPluginEngine", 4, "onWebViewNativeRequest eventName=" + str + ",jsonParams=" + str2 + ",callbackId=" + i3);
        }
        return a(str, str2, baseAppBrandWebview, i3);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f245930g.add(new b());
            this.f245930g.add(new j());
        }
    }

    public BaseActivity b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f245929f : (BaseActivity) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    private String b(String str, String str2, BaseAppBrandWebview baseAppBrandWebview, int i3) {
        int a16 = this.f245925b.a(str, str2);
        if (QLog.isColorLevel()) {
            QLog.d("JsPluginEngine", 2, "handleNativeRequest authFlag=" + a16 + ",eventName=" + str + "\uff0cjsonParams=" + str2 + ",webview=" + baseAppBrandWebview + ",callbackId=" + i3);
        }
        if (a16 == 2) {
            String c16 = c(str, str2, baseAppBrandWebview, i3);
            if (com.tencent.mobileqq.microapp.app.a.b(str, str2) && this.f245931h.size() > 0) {
                this.f245933j.obtainMessage(1).sendToTarget();
            }
            return c16;
        }
        d(str, str2, baseAppBrandWebview, i3);
        return "";
    }

    public String a(String str, String str2, BaseAppBrandWebview baseAppBrandWebview, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, str, str2, baseAppBrandWebview, Integer.valueOf(i3));
        }
        if (!TextUtils.isEmpty(str) && baseAppBrandWebview != null && !this.f245934k) {
            BaseActivity baseActivity = this.f245924a.f245899d;
            if (baseActivity != null) {
                String d16 = com.tencent.mobileqq.microapp.app.a.d(str, str2);
                if (!StringUtil.isEmpty(d16)) {
                    if (!(baseActivity.checkSelfPermission(d16) == 0)) {
                        baseActivity.requestPermissions(new g(this, str, str2, baseAppBrandWebview, i3), 1, d16);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("JsPluginEngine", 2, d16 + " has granted permission!!!");
                        }
                        return b(str, str2, baseAppBrandWebview, i3);
                    }
                } else {
                    return b(str, str2, baseAppBrandWebview, i3);
                }
            }
            return "";
        }
        if (QLog.isColorLevel()) {
            QLog.w("JsPluginEngine", 2, "handleNativeRequest fail eventName=" + str + "\uff0cjsonParams=" + str2 + ",webview=" + baseAppBrandWebview + ",callbackId=" + i3 + ",isDestory=" + this.f245934k);
        }
        return "";
    }

    private String c(String str, String str2, BaseAppBrandWebview baseAppBrandWebview, int i3) {
        for (com.tencent.mobileqq.microapp.appbrand.a.a.a aVar : this.f245930g) {
            if (aVar.a(str)) {
                return aVar.a(str, str2, baseAppBrandWebview, i3);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("JsPluginEngine", 2, "handleNativeRequest fail,event not support! eventName=" + str + "\uff0cjsonParams=" + str2 + ",webview=" + baseAppBrandWebview + ",callbackId=" + i3);
        }
        b(baseAppBrandWebview, str, (JSONObject) null, i3);
        return "";
    }

    private void d(String str, String str2, BaseAppBrandWebview baseAppBrandWebview, int i3) {
        boolean z16 = ((long) this.f245925b.a(str, str2)) <= System.currentTimeMillis() / 1000;
        if (QLog.isColorLevel()) {
            QLog.d("JsPluginEngine", 2, "handleNativeRequest bAuth=" + z16 + ",isPause=" + this.f245935l);
        }
        if (z16) {
            this.f245931h.offer(new a(this, str, str2, baseAppBrandWebview, i3));
            if (this.f245935l) {
                return;
            }
            com.tencent.mobileqq.microapp.widget.d dVar = this.f245926c;
            if (dVar == null || !dVar.isShowing()) {
                Message obtainMessage = this.f245933j.obtainMessage(2);
                Bundle bundle = new Bundle();
                bundle.putString("key_event_name", str);
                bundle.putString("key_params", str2);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("JsPluginEngine", 2, "handleNativeRequest callbackJsEventFail");
        }
        b(baseAppBrandWebview, str, (JSONObject) null, i3);
        this.f245933j.obtainMessage(1).sendToTarget();
    }

    public void b(BaseAppBrandWebview baseAppBrandWebview, String str, JSONObject jSONObject, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            a(baseAppBrandWebview, str, jSONObject, null, i3);
        } else {
            iPatchRedirector.redirect((short) 10, this, baseAppBrandWebview, str, jSONObject, Integer.valueOf(i3));
        }
    }

    public void a(BaseAppBrandWebview baseAppBrandWebview, String str, JSONObject jSONObject, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, baseAppBrandWebview, str, jSONObject, Integer.valueOf(i3));
        } else if (baseAppBrandWebview != null) {
            JSONObject a16 = com.tencent.mobileqq.microapp.a.c.a(str, jSONObject);
            baseAppBrandWebview.evaluateCallbackJs(i3, a16 != null ? a16.toString() : "");
        }
    }

    public void a(BaseAppBrandWebview baseAppBrandWebview, String str, JSONObject jSONObject, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, baseAppBrandWebview, str, jSONObject, str2, Integer.valueOf(i3));
        } else if (baseAppBrandWebview != null) {
            JSONObject a16 = com.tencent.mobileqq.microapp.a.c.a(str, jSONObject, str2);
            baseAppBrandWebview.evaluateCallbackJs(i3, a16 != null ? a16.toString() : "");
        }
    }

    public void a(BaseAppBrandWebview baseAppBrandWebview, String str, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, baseAppBrandWebview, str, jSONObject);
            return;
        }
        if (baseAppBrandWebview == null) {
            return;
        }
        String str2 = "WeixinJSBridge.subscribeHandler(\"" + str + "\", " + jSONObject + "," + baseAppBrandWebview.pageWebviewId + ")";
        if (QLog.isColorLevel()) {
            QLog.d("JsPluginEngine", 2, "callJs jsStr=" + str2);
        }
        baseAppBrandWebview.evaluteJs(str2);
    }
}
