package com.tencent.mobileqq.microapp.widget.input;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.microapp.appbrand.a.a.f;
import com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class WebEditText extends EditText implements ViewTreeObserver.OnGlobalLayoutListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    String f246144a;

    /* renamed from: b, reason: collision with root package name */
    String f246145b;

    /* renamed from: c, reason: collision with root package name */
    private int f246146c;

    /* renamed from: d, reason: collision with root package name */
    private int f246147d;

    /* renamed from: e, reason: collision with root package name */
    private int f246148e;

    /* renamed from: f, reason: collision with root package name */
    private int f246149f;

    /* renamed from: g, reason: collision with root package name */
    private int f246150g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference f246151h;

    public WebEditText(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f246144a = "#FFFFFFFF";
        this.f246145b = "#FFFFFFFF";
        super.setBackgroundDrawable(null);
        super.setIncludeFontPadding(false);
        super.setSingleLine(true);
        super.setTextIsSelectable(true);
        super.setLineSpacing(0.0f, 1.0f);
        super.setPadding(0, 0, 0, 0);
    }

    public boolean a(f fVar, AbsAppBrandPage absAppBrandPage, String str) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, fVar, absAppBrandPage, str)).booleanValue();
        }
        if (TextUtils.isEmpty(str) || absAppBrandPage == null) {
            return false;
        }
        Context context = super.getContext();
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("type");
        super.setInputType(("number".equals(optString) || "digit".equals(optString) || "idcard".equals(optString)) ? 2 : jSONObject.optBoolean("isPassword") ? 129 : 1);
        String optString2 = jSONObject.optString("confirmType");
        if ("send".equals(optString2)) {
            i3 = 4;
        } else if ("search".equals(optString2)) {
            i3 = 3;
        } else if ("next".equals(optString2)) {
            i3 = 5;
        } else if (!ResourceAttributes.TelemetrySdkLanguageValues.GO.equals(optString2)) {
            i3 = 6;
        }
        setImeOptions(i3);
        int optInt = jSONObject.optInt("maxLength", -1);
        if (optInt != -1) {
            super.setFilters(new InputFilter[]{new InputFilter.LengthFilter(optInt)});
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            float density = DisplayUtil.getDensity(context);
            this.f246146c = (int) (optJSONObject.optInt("width") * density);
            this.f246147d = (int) (optJSONObject.optInt("height") * density);
            this.f246149f = (int) (optJSONObject.optInt("left") * density);
            super.setTextSize(optJSONObject.optInt("fontSize", 16));
            optJSONObject.optString("fontWeight", "normal");
            this.f246144a = optJSONObject.optString("color", "#FFFFFFFF");
            this.f246145b = optJSONObject.optString("backgroundColor", "#FFFFFFFF");
            optJSONObject.optInt(NodeProps.MARGIN_BOTTOM);
            optJSONObject.optString("textAlign", "left");
        }
        String optString3 = jSONObject.optString("placeholder");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject2 != null) {
            super.setHintTextColor(Color.parseColor(optJSONObject2.optString("color", "#FFFFFFFF")));
        }
        if (jSONObject.optBoolean("adjustPosition")) {
            fVar.b().getWindow().setSoftInputMode(32);
        }
        String optString4 = jSONObject.optString(RemoteHandleConst.PARAM_DEFAULT_VALUE);
        if (!TextUtils.isEmpty(optString4)) {
            super.setText(optString4);
        } else {
            super.setText("");
        }
        super.setTextColor(com.tencent.mobileqq.microapp.a.c.p(this.f246144a));
        super.setBackgroundColor(com.tencent.mobileqq.microapp.a.c.p(this.f246145b));
        super.setGravity(19);
        super.setHint(optString3);
        return true;
    }

    public PageWebview b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (PageWebview) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        WeakReference weakReference = this.f246151h;
        if (weakReference != null) {
            return (PageWebview) weakReference.get();
        }
        return null;
    }

    @TargetApi(16)
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (super.getParent() != null) {
            ((ViewGroup) super.getParent()).removeView(this);
        }
        super.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f246151h.clear();
    }

    @TargetApi(16)
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        ViewTreeObserver viewTreeObserver = super.getViewTreeObserver();
        viewTreeObserver.removeOnGlobalLayoutListener(this);
        viewTreeObserver.addOnGlobalLayoutListener(this);
        InputMethodManager inputMethodManager = (InputMethodManager) super.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this, 2);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (a.a().a(this.f246150g)) {
            super.requestFocus();
            if (QLog.isColorLevel()) {
                QLog.d("WebEditText", 2, "showSoftInput for inputId=" + this.f246150g);
            }
            InputMethodManager inputMethodManager = (InputMethodManager) super.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this, 2);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4 && keyEvent.getAction() == 1 && a.a().b()) {
            a.a().a(true);
            return true;
        }
        return super.onKeyPreIme(i3, keyEvent);
    }

    @Override // android.view.View
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "WebEditText{mWebInputWidth=" + this.f246146c + ", mWebInputHeight=" + this.f246147d + ", mWebInputTop=" + this.f246148e + ", mWebInputLeft=" + this.f246149f + ", mInputId=" + this.f246150g + '}';
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f246150g : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f246150g = i3;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
    }

    public void a(PageWebview pageWebview) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f246151h = new WeakReference(pageWebview);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) pageWebview);
        }
    }
}
