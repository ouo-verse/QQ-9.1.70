package com.tencent.qqmini.container.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.luggage.wxa.df.h;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.container.core.NativeContainer;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.plugins.InputJsPlugin;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private NativeContainer f346176e;

    /* renamed from: f, reason: collision with root package name */
    private WebEditText f346177f;

    /* renamed from: i, reason: collision with root package name */
    private int f346180i;

    /* renamed from: l, reason: collision with root package name */
    private int f346183l;

    /* renamed from: a, reason: collision with root package name */
    private final Object f346172a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f346173b = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    private final Map<Integer, WebEditText> f346174c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<Integer, SoftKeyboardStateHelper.SoftKeyboardStateListener> f346175d = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    private final Map<Integer, String> f346178g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private boolean f346179h = false;

    /* renamed from: j, reason: collision with root package name */
    private int f346181j = 0;

    /* renamed from: k, reason: collision with root package name */
    private boolean f346182k = false;

    /* compiled from: P */
    /* renamed from: com.tencent.qqmini.container.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C9376a implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
        public C9376a() {
        }

        @Override // com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            a.this.f346182k = false;
            QMLog.i("InputHandler", "onSoftKeyboardClosed");
            InputMethodManager inputMethodManager = (InputMethodManager) a.this.f346176e.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(a.this.f346176e.getWindowToken(), 0);
            if (a.this.f346176e != null) {
                a aVar = a.this;
                aVar.i(aVar.f346176e.getTranslationY(), 0.0f);
            }
            a.this.m();
        }

        @Override // com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardOpened(int i3) {
            boolean z16;
            try {
                a.this.f346181j = i3;
                boolean z17 = true;
                a.this.f346182k = true;
                Context context = a.this.f346176e.getContext();
                if (context != null) {
                    if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                        z16 = DisplayUtil.checkNavigationBarShow(context);
                    } else {
                        if ((!DisplayUtil.hasNavBar(context) || !(context instanceof Activity) || !DisplayUtil.isNavigationBarExist((Activity) context)) && !DisplayUtil.isFlymeOS7NavBarShow()) {
                            z17 = false;
                        }
                        z16 = z17;
                    }
                    QMLog.d("InputHandler", " hasNavBar : " + z16 + "; " + Build.BRAND);
                    if (z16) {
                        a.this.f346181j += DisplayUtil.getNavigationBarHeight(a.this.f346176e.getContext());
                    }
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("inputId", a.this.f346183l);
                jSONObject.put("height", (int) (i3 / DisplayUtil.getDensity(a.this.f346176e.getContext())));
                if (a.this.f346176e != null) {
                    a.this.f346176e.c0("onKeyboardShow", jSONObject.toString());
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements TextView.OnEditorActionListener {

        /* renamed from: d, reason: collision with root package name */
        private WebEditText f346185d;

        /* renamed from: e, reason: collision with root package name */
        private NativeViewRequestEvent f346186e;

        public b(WebEditText webEditText, NativeViewRequestEvent nativeViewRequestEvent) {
            this.f346185d = webEditText;
            this.f346186e = nativeViewRequestEvent;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            boolean z16 = false;
            if (i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("inputId", a.this.f346183l);
                    jSONObject.put("value", this.f346185d.getText().toString());
                    this.f346186e.jsService.evaluateSubscribeJS(InputJsPlugin.ON_KEYBOARD_CONFIRM_CALLBACK, jSONObject.toString(), 0);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                if (!this.f346185d.h()) {
                    a.this.m();
                }
                if (a.this.f346176e != null) {
                    a aVar = a.this;
                    aVar.i(aVar.f346176e.getTranslationY(), 0.0f);
                }
                z16 = true;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        private final WebEditText f346188d;

        public c(WebEditText webEditText) {
            this.f346188d = webEditText;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] iArr = new int[2];
            this.f346188d.getLocationOnScreen(iArr);
            int realHeight = (DisplayUtil.getRealHeight(this.f346188d.getContext()) - (iArr[1] + this.f346188d.getHeight())) - this.f346188d.e();
            if (this.f346188d.isFocused() && this.f346188d.g() && a.this.f346182k && a.this.f346181j > realHeight && a.this.f346176e != null) {
                a.this.i(0.0f, -(r1.f346181j - realHeight));
            } else if (!a.this.f346182k && a.this.f346176e != null) {
                a aVar = a.this;
                aVar.i(aVar.f346176e.getTranslationY(), 0.0f);
            }
        }
    }

    public a(NativeContainer nativeContainer) {
        this.f346176e = nativeContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(float... fArr) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f346176e, "translationY", fArr);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
    }

    public Map<Integer, WebEditText> j() {
        return this.f346174c;
    }

    public WebEditText k() {
        return new WebEditText(this.f346176e.getContext(), this);
    }

    public boolean l() {
        if (this.f346177f != null) {
            return true;
        }
        return false;
    }

    public void m() {
        if (this.f346177f != null && this.f346176e != null) {
            if (this.f346174c.size() > 0) {
                try {
                    Iterator<Map.Entry<Integer, WebEditText>> it = this.f346174c.entrySet().iterator();
                    while (it.hasNext()) {
                        WebEditText value = it.next().getValue();
                        QMLog.d("InputHandler", "[hideCurrentInput] webEditText=" + value);
                        int c16 = value.c();
                        WebEditText webEditText = this.f346177f;
                        if (webEditText != null && webEditText.c() == value.c()) {
                            ((InputMethodManager) value.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(value.getWindowToken(), 0);
                            this.f346182k = false;
                        }
                        value.clearFocus();
                        value.a();
                        value.setHasMoveParent(false);
                        this.f346174c.remove(Integer.valueOf(c16));
                        if (this.f346176e != null) {
                            this.f346176e.u().removeSoftKeyboardStateListener(this.f346175d.remove(Integer.valueOf(c16)));
                        }
                        String obj = value.getText().toString();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("inputId", c16);
                        jSONObject.put("value", obj);
                        jSONObject.put("cursor", obj.length());
                        this.f346176e.c0(InputJsPlugin.ON_KEYBOARD_COMPLETE_CALLBACK, jSONObject.toString());
                    }
                } catch (Throwable th5) {
                    QMLog.e("InputHandler", "hideCurrentInput error, ", th5);
                }
            }
            this.f346177f = null;
            NativeContainer nativeContainer = this.f346176e;
            if (nativeContainer != null) {
                i(nativeContainer.getTranslationY(), 0.0f);
                return;
            }
            return;
        }
        QMLog.e("InputHandler", "mCurrentFocusInput is null, return.");
    }

    public synchronized void n(NativeViewRequestEvent nativeViewRequestEvent) {
        QMLog.d("InputHandler", ", webParams=" + nativeViewRequestEvent.jsonParams + ", callbackId=" + nativeViewRequestEvent.callbackId);
        synchronized (this.f346172a) {
            m();
            nativeViewRequestEvent.ok();
        }
    }

    public boolean o(int i3) {
        WebEditText webEditText = this.f346177f;
        if (webEditText != null && webEditText.c() == i3) {
            return true;
        }
        return false;
    }

    public boolean p(NativeViewRequestEvent nativeViewRequestEvent, WebEditText webEditText) {
        try {
            return webEditText.f(nativeViewRequestEvent.jsonParams);
        } catch (Exception e16) {
            QMLog.e("InputHandler", "[showKeyboard] initWithWebParams exception:", e16);
            return false;
        }
    }

    public synchronized void q(NativeViewRequestEvent nativeViewRequestEvent) {
        JSONObject jSONObject;
        int optInt;
        WebEditText webEditText;
        QMLog.d("InputHandler", ", webParams=" + nativeViewRequestEvent.jsonParams + ", callbackId=" + nativeViewRequestEvent.callbackId);
        try {
            jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            optInt = jSONObject.optInt("inputId");
            webEditText = this.f346174c.get(Integer.valueOf(optInt));
        } catch (Exception e16) {
            QMLog.e("InputHandler", "setKeyboardValue error.", e16);
        }
        if (webEditText == null) {
            nativeViewRequestEvent.fail();
            return;
        }
        String optString = jSONObject.optString("value");
        this.f346178g.put(Integer.valueOf(optInt), optString);
        webEditText.setText(optString);
        webEditText.setSelection(optString.length());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("inputId", optInt);
        nativeViewRequestEvent.ok(jSONObject2);
    }

    public void r(NativeViewRequestEvent nativeViewRequestEvent) {
        QMLog.d("InputHandler", "showKeyboard , webParams=" + nativeViewRequestEvent.jsonParams + ", callbackId=" + nativeViewRequestEvent.callbackId);
        synchronized (this.f346172a) {
            QMLog.d("InputHandler", "[showKeyboard] mCurrentFocusInput=" + this.f346177f);
            if (TextUtils.isEmpty(nativeViewRequestEvent.jsonParams)) {
                QMLog.e("InputHandler", "[showKeyboard] no web input params");
                nativeViewRequestEvent.fail();
                return;
            }
            NativeContainer nativeContainer = this.f346176e;
            if (nativeContainer == null) {
                nativeViewRequestEvent.fail();
                return;
            }
            this.f346180i = DisplayUtil.getRealHeight(nativeContainer.getContext());
            WebEditText k3 = k();
            int incrementAndGet = this.f346173b.incrementAndGet();
            this.f346183l = incrementAndGet;
            this.f346176e.setCurrentInputId(incrementAndGet);
            if (this.f346176e != null) {
                C9376a c9376a = new C9376a();
                this.f346176e.u().addSoftKeyboardStateListener(c9376a);
                this.f346175d.put(Integer.valueOf(this.f346183l), c9376a);
            }
            try {
                if (p(nativeViewRequestEvent, k3)) {
                    NativeContainer nativeContainer2 = this.f346176e;
                    if (nativeContainer2 != null) {
                        nativeContainer2.addView(k3, k3.i());
                    }
                    this.f346177f = k3;
                    k3.setInputId(this.f346183l);
                    this.f346174c.put(Integer.valueOf(this.f346183l), k3);
                    k3.m();
                    k3.addTextChangedListener(new d(nativeViewRequestEvent));
                    k3.setOnEditorActionListener(new b(k3, nativeViewRequestEvent));
                    k3.getViewTreeObserver().addOnGlobalLayoutListener(new c(k3));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("inputId", this.f346183l);
                    nativeViewRequestEvent.ok(jSONObject);
                } else {
                    nativeViewRequestEvent.fail();
                }
            } catch (Exception e16) {
                QMLog.e("InputHandler", "[showKeyboard] exception:", e16);
            }
        }
    }

    public synchronized boolean s(String str) {
        if (this.f346174c == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            WebEditText webEditText = this.f346174c.get(Integer.valueOf(jSONObject.optInt("inputId")));
            if (webEditText == null) {
                return false;
            }
            if (jSONObject.has("value")) {
                String optString = jSONObject.optString("value");
                webEditText.setText(optString);
                webEditText.setSelection(optString.length());
            }
            int optInt = jSONObject.optInt("selectionStart", -1);
            int optInt2 = jSONObject.optInt("selectionEnd", -1);
            if (optInt != -1 && optInt2 != -1 && optInt2 > optInt) {
                webEditText.setSelection(optInt, optInt2);
            }
            int optInt3 = jSONObject.optInt("cursor", -1);
            if (optInt3 > 0) {
                webEditText.setSelection(optInt3);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("style");
            if (optJSONObject != null) {
                int optInt4 = optJSONObject.optInt("width");
                int optInt5 = optJSONObject.optInt("height");
                float density = DisplayUtil.getDensity(webEditText.getContext());
                int max = (int) Math.max((optInt4 * density) + 0.5f, 0.0f);
                int max2 = (int) Math.max((optInt5 * density) + 0.5f, 0.0f);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) webEditText.getLayoutParams();
                layoutParams.width = max;
                layoutParams.height = max2;
                int optInt6 = (int) ((optJSONObject.optInt("left") * density) + 0.5f);
                layoutParams.leftMargin = optInt6;
                layoutParams.topMargin = (int) ((density * optJSONObject.optInt("top")) + 0.5f);
                webEditText.requestLayout();
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class d implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private final NativeViewRequestEvent f346190d;

        public d(NativeViewRequestEvent nativeViewRequestEvent) {
            this.f346190d = nativeViewRequestEvent;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (a.this.f346178g.containsKey(Integer.valueOf(a.this.f346183l)) && charSequence.toString().equals(a.this.f346178g.get(Integer.valueOf(a.this.f346183l)))) {
                return;
            }
            a.this.f346178g.remove(Integer.valueOf(a.this.f346183l));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("inputId", a.this.f346183l);
                if (i17 == 0) {
                    jSONObject.put("cursor", i3);
                } else {
                    if (i16 != 0) {
                        i16--;
                    } else {
                        i16 = 0;
                    }
                    jSONObject.put("cursor", (i3 + i17) - i16);
                }
                jSONObject.put("value", charSequence.toString());
                if (i16 != 0 && i17 == 0) {
                    jSONObject.put("keyCode", 8);
                } else {
                    jSONObject.put("keyCode", (int) charSequence.charAt((i3 + i17) - 1));
                }
                jSONObject.put("data", new JSONObject(this.f346190d.jsonParams).optString("data"));
                this.f346190d.sendSubscribeJs(h.g.NAME, jSONObject.toString(), a.this.f346176e.w());
            } catch (Exception e16) {
                QMLog.e("InputHandler", "onTextChanged error", e16);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
