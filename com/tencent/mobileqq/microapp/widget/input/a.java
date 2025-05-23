package com.tencent.mobileqq.microapp.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.microapp.appbrand.a.a.f;
import com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.InputJsPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static a f246152b;

    /* renamed from: a, reason: collision with root package name */
    List f246153a;

    /* renamed from: c, reason: collision with root package name */
    private AtomicInteger f246154c;

    /* renamed from: d, reason: collision with root package name */
    private Object f246155d;

    /* renamed from: e, reason: collision with root package name */
    private WebEditText f246156e;

    /* renamed from: f, reason: collision with root package name */
    private AbsAppBrandPage f246157f;

    /* renamed from: g, reason: collision with root package name */
    private Map f246158g;

    /* renamed from: h, reason: collision with root package name */
    private int f246159h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.microapp.widget.input.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C8033a implements Observer {
        static IPatchRedirector $redirector_;

        public C8033a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) observable, obj);
                return;
            }
            try {
                if (obj instanceof String) {
                    if (!"hideKeyboard".equals((String) obj) && "hideInput".equals((String) obj)) {
                        a.this.a(false);
                        return;
                    }
                    return;
                }
                if (!(obj instanceof Integer) || a.this.f246157f == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("inputId", a.this.f246159h);
                jSONObject.put("height", obj);
                a.this.f246157f.getCurrentPageWebview().evaluateSubcribeJS("onKeyboardShow", jSONObject.toString(), a.this.f246157f.getCurrentPageWebview().pageWebviewId);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f246154c = new AtomicInteger(0);
        this.f246155d = new Object();
        this.f246153a = new ArrayList();
        this.f246158g = new HashMap();
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f246152b == null) {
                f246152b = new a();
            }
            aVar = f246152b;
        }
        return aVar;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f246156e != null : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
    }

    public synchronized void b(f fVar, BaseAppBrandWebview baseAppBrandWebview, String str, int i3) {
        com.tencent.mobileqq.microapp.appbrand.a aVar;
        Context context;
        int optInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, fVar, baseAppBrandWebview, str, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebInputHandler", 2, "[hideKeyboard] jsPluginEngine=" + fVar + ", webview=" + baseAppBrandWebview + ", webParams=" + str + ", callbackId=" + i3);
        }
        synchronized (this.f246155d) {
            if (baseAppBrandWebview != null) {
                if (baseAppBrandWebview instanceof PageWebview) {
                    if (fVar != null && (aVar = fVar.f245924a) != null && aVar.f245902g != null) {
                        if (TextUtils.isEmpty(str)) {
                            if (QLog.isColorLevel()) {
                                QLog.e("WebInputHandler", 2, "[hideKeyboard] no web input params");
                            }
                            baseAppBrandWebview.evaluateCallbackJs(i3, com.tencent.mobileqq.microapp.a.c.b("hideKeyboard", (JSONObject) null).toString());
                            return;
                        }
                        if (((AbsAppBrandPage) fVar.f245924a.f245902g.pageLinkedList.peek()) == null) {
                            baseAppBrandWebview.evaluateCallbackJs(i3, com.tencent.mobileqq.microapp.a.c.b("hideKeyboard", (JSONObject) null).toString());
                            return;
                        }
                        try {
                            context = baseAppBrandWebview.getContext();
                            optInt = new JSONObject(str).optInt("inputId");
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e("WebInputHandler", 2, "hideKeyboard, exception", e16);
                            }
                        }
                        if (!this.f246158g.containsKey(Integer.valueOf(optInt))) {
                            baseAppBrandWebview.evaluateCallbackJs(i3, com.tencent.mobileqq.microapp.a.c.a("hideKeyboard", (JSONObject) null).toString());
                            return;
                        }
                        WebEditText webEditText = (WebEditText) this.f246158g.remove(Integer.valueOf(optInt));
                        baseAppBrandWebview.evaluateCallbackJs(i3, com.tencent.mobileqq.microapp.a.c.a("hideKeyboard", (JSONObject) null).toString());
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("inputId", optInt);
                        jSONObject.put("value", webEditText.getText().toString());
                        jSONObject.put("cursor", webEditText.getText().toString().length());
                        this.f246153a.add(webEditText);
                        webEditText.setFocusable(false);
                        webEditText.setFocusableInTouchMode(false);
                        webEditText.clearFocus();
                        ((InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(webEditText.getWindowToken(), 0);
                        webEditText.c();
                        PageWebview pageWebview = (PageWebview) baseAppBrandWebview;
                        pageWebview.evaluateSubcribeJS(InputJsPlugin.ON_KEYBOARD_COMPLETE_CALLBACK, jSONObject.toString(), pageWebview.pageWebviewId);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("WebInputHandler", 2, "[hideKeyboard] runtime error");
                    }
                    baseAppBrandWebview.evaluateCallbackJs(i3, com.tencent.mobileqq.microapp.a.c.b("hideKeyboard", (JSONObject) null).toString());
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("WebInputHandler", 2, "[hideKeyboard] invalid webview");
            }
        }
    }

    public boolean a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
        }
        WebEditText webEditText = this.f246156e;
        return webEditText != null && webEditText.a() == i3;
    }

    public void a(f fVar, BaseAppBrandWebview baseAppBrandWebview, String str, int i3) {
        com.tencent.mobileqq.microapp.appbrand.a aVar;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, fVar, baseAppBrandWebview, str, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebInputHandler", 2, "[showKeyboard] jsPluginEngine=" + fVar + ", webview=" + baseAppBrandWebview + ", webParams=" + str + ", callbackId=" + i3);
        }
        synchronized (this.f246155d) {
            if (QLog.isColorLevel()) {
                QLog.d("WebInputHandler", 2, "[showKeyboard] mCurrentFocusInput=" + this.f246156e);
            }
            if (baseAppBrandWebview != null && (baseAppBrandWebview instanceof PageWebview)) {
                if (fVar != null && (aVar = fVar.f245924a) != null && aVar.f245902g != null) {
                    if (TextUtils.isEmpty(str)) {
                        if (QLog.isColorLevel()) {
                            QLog.e("WebInputHandler", 2, "[showKeyboard] no web input params");
                        }
                        baseAppBrandWebview.evaluateCallbackJs(i3, com.tencent.mobileqq.microapp.a.c.b("showKeyboard", (JSONObject) null).toString());
                        return;
                    }
                    AbsAppBrandPage absAppBrandPage = (AbsAppBrandPage) fVar.f245924a.f245902g.pageLinkedList.peek();
                    this.f246157f = absAppBrandPage;
                    if (absAppBrandPage == null) {
                        baseAppBrandWebview.evaluateCallbackJs(i3, com.tencent.mobileqq.microapp.a.c.b("showKeyboard", (JSONObject) null).toString());
                        return;
                    }
                    WebEditText webEditText = new WebEditText(baseAppBrandWebview.getContext());
                    try {
                        z16 = webEditText.a(fVar, this.f246157f, str);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("WebInputHandler", 2, "[showKeyboard] initWithWebParams exception:", e16);
                        }
                        z16 = false;
                    }
                    this.f246159h = this.f246154c.incrementAndGet();
                    PageWebview currentPageWebview = this.f246157f.getCurrentPageWebview();
                    currentPageWebview.onWebviewScrollListener = new b(this, currentPageWebview);
                    try {
                        if (z16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("WebInputHandler", 2, "[showKeyboard] makeLayoutParams scrollY:", Integer.valueOf(currentPageWebview.scrollY));
                            }
                            this.f246156e = webEditText;
                            webEditText.a(this.f246159h);
                            webEditText.a(currentPageWebview);
                            this.f246158g.put(Integer.valueOf(this.f246159h), webEditText);
                            webEditText.d();
                            webEditText.addTextChangedListener(new c(this, str, fVar, currentPageWebview));
                            webEditText.setOnEditorActionListener(new d(this, webEditText, currentPageWebview));
                            JSONObject a16 = com.tencent.mobileqq.microapp.a.c.a("showKeyboard", (JSONObject) null);
                            a16.put("inputId", this.f246159h);
                            baseAppBrandWebview.evaluteJs("WeixinJSBridge.invokeCallbackHandler(" + i3 + ", " + a16 + ")");
                        } else {
                            baseAppBrandWebview.evaluteJs("WeixinJSBridge.invokeCallbackHandler(" + i3 + ", " + com.tencent.mobileqq.microapp.a.c.b("showKeyboard", (JSONObject) null) + ")");
                        }
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e("WebInputHandler", 2, "[showKeyboard] exception:", e17);
                        }
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("WebInputHandler", 2, "[showKeyboard] runtime error");
                }
                baseAppBrandWebview.evaluateCallbackJs(i3, com.tencent.mobileqq.microapp.a.c.b("showKeyboard", (JSONObject) null).toString());
                return;
            }
            Log.e("WebInputHandler", "[showKeyboard] invalid webview");
        }
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WebInputHandler", 2, "[hideCurrentInput] hideSoftInput=" + z16);
        }
        if (this.f246158g.size() > 0) {
            Iterator it = this.f246158g.entrySet().iterator();
            while (it.hasNext()) {
                WebEditText webEditText = (WebEditText) ((Map.Entry) it.next()).getValue();
                if (QLog.isColorLevel()) {
                    QLog.d("WebInputHandler", 2, "[hideCurrentInput] webEditText=" + webEditText);
                }
                int a16 = webEditText.a();
                String obj = webEditText.getText().toString();
                PageWebview b16 = webEditText.b();
                WebEditText webEditText2 = this.f246156e;
                if (webEditText2 != null && webEditText2.a() == webEditText.a() && z16) {
                    ((InputMethodManager) webEditText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(webEditText.getWindowToken(), 0);
                }
                webEditText.clearFocus();
                webEditText.c();
                this.f246153a.add(webEditText);
                if (b16 != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("inputId", a16);
                        jSONObject.put("value", obj);
                        jSONObject.put("cursor", obj.length());
                        b16.evaluateSubcribeJS(InputJsPlugin.ON_KEYBOARD_COMPLETE_CALLBACK, jSONObject.toString(), b16.pageWebviewId);
                    } catch (Exception e16) {
                        Log.e("WebInputHandler", "[hideCurrentInput] exception:", e16);
                    }
                }
            }
        }
        this.f246156e = null;
    }

    public synchronized boolean a(f fVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) fVar, (Object) str)).booleanValue();
        }
        if (this.f246158g == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            WebEditText webEditText = (WebEditText) this.f246158g.get(Integer.valueOf(jSONObject.optInt("inputId")));
            if (webEditText == null) {
                return false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("style");
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("left");
                int optInt2 = optJSONObject.optInt("top");
                int optInt3 = optJSONObject.optInt("width");
                int optInt4 = optJSONObject.optInt("height");
                float density = DisplayUtil.getDensity(webEditText.getContext());
                int i3 = (int) ((optInt3 * density) + 0.5f);
                int i16 = (int) ((optInt4 * density) + 0.5f);
                int i17 = (int) ((optInt * density) + 0.5f);
                int i18 = ((int) ((density * optInt2) + 0.5f)) - this.f246157f.getCurrentPageWebview().scrollY;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) webEditText.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i16;
                layoutParams.leftMargin = i17;
                layoutParams.topMargin = i18;
                webEditText.requestLayout();
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
