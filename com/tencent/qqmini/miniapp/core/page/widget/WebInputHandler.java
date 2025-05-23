package com.tencent.qqmini.miniapp.core.page.widget;

import android.animation.ObjectAnimator;
import android.app.Activity;
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
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebview;
import com.tencent.qqmini.miniapp.core.page.c;
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
public class WebInputHandler {
    private static final String TAG = "WebInputHandler";
    private int inputId;
    private WebEditText mCurrentFocusInput;
    private NativeViewContainer mNativeContainer;
    private int navbarHeight;
    private int screenHeight;
    public c.a scrollListener;
    private final AtomicInteger mInputIdGenerator = new AtomicInteger(0);
    private final Object mInputLock = new Object();
    private Map<Integer, WebEditText> mShowingInput = new ConcurrentHashMap();
    private Map<Integer, SoftKeyboardStateHelper.SoftKeyboardStateListener> mInputKeyboardListener = new ConcurrentHashMap();
    private Map<Integer, String> mSetValue = new HashMap();
    private boolean adjustPosition = false;
    private int showKeyboardHeight = 0;
    private boolean isKeyboardShow = false;
    private int offset = 0;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class KeyboardHiddenObserver implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
        public KeyboardHiddenObserver() {
        }

        @Override // com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            WebInputHandler.this.isKeyboardShow = false;
            QMLog.i(WebInputHandler.TAG, "onSoftKeyboardClosed");
            InputMethodManager inputMethodManager = (InputMethodManager) WebInputHandler.this.mNativeContainer.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(WebInputHandler.this.mNativeContainer.getWindowToken(), 0);
            if (WebInputHandler.this.mNativeContainer != null && WebInputHandler.this.mNativeContainer.getPageWebviewContainer() != null) {
                WebInputHandler webInputHandler = WebInputHandler.this;
                webInputHandler.animatorTranslateY(webInputHandler.mNativeContainer.getPageWebviewContainer().getTranslationY(), 0.0f);
            }
            WebInputHandler.this.hideCurrentInput();
        }

        @Override // com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardOpened(int i3) {
            Activity activity;
            boolean z16;
            try {
                WebInputHandler.this.showKeyboardHeight = i3;
                boolean z17 = true;
                WebInputHandler.this.isKeyboardShow = true;
                if (WebInputHandler.this.mNativeContainer != null && WebInputHandler.this.mNativeContainer.getPageWebviewContainer() != null) {
                    activity = WebInputHandler.this.mNativeContainer.getPageWebviewContainer().getAttachActivity();
                } else {
                    activity = null;
                }
                if (activity != null) {
                    if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                        z16 = DisplayUtil.checkNavigationBarShow(activity);
                    } else {
                        if ((!DisplayUtil.hasNavBar(activity) || !DisplayUtil.isNavigationBarExist(activity)) && !DisplayUtil.isFlymeOS7NavBarShow()) {
                            z17 = false;
                        }
                        z16 = z17;
                    }
                    QMLog.d(WebInputHandler.TAG, " hasNavBar : " + z16 + "; " + Build.BRAND);
                    if (z16) {
                        WebInputHandler.this.showKeyboardHeight += DisplayUtil.getNavigationBarHeight(WebInputHandler.this.mNativeContainer.getPageWebviewContainer().getAttachActivity());
                    }
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("inputId", WebInputHandler.this.inputId);
                if (WebInputHandler.this.mNativeContainer != null) {
                    jSONObject.put("height", (int) (i3 / DisplayUtil.getDensity(WebInputHandler.this.mNativeContainer.getContext())));
                }
                if (WebInputHandler.this.mNativeContainer != null && WebInputHandler.this.mNativeContainer.getPageWebviewContainer() != null) {
                    WebInputHandler.this.mNativeContainer.getPageWebviewContainer().evaluateSubscribeJS("onKeyboardShow", jSONObject.toString());
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class MyOnEditorActionListener implements TextView.OnEditorActionListener {
        private NativeViewRequestEvent req;
        private WebEditText webEditText;

        public MyOnEditorActionListener(WebEditText webEditText, NativeViewRequestEvent nativeViewRequestEvent) {
            this.webEditText = webEditText;
            this.req = nativeViewRequestEvent;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            boolean z16 = false;
            if (i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("inputId", WebInputHandler.this.inputId);
                    jSONObject.put("value", this.webEditText.getText().toString());
                    this.req.jsService.evaluateSubscribeJS(InputJsPlugin.ON_KEYBOARD_CONFIRM_CALLBACK, jSONObject.toString(), 0);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                if (!this.webEditText.isConfirmHold()) {
                    WebInputHandler.this.hideCurrentInput();
                }
                if (WebInputHandler.this.mNativeContainer != null && WebInputHandler.this.mNativeContainer.getPageWebviewContainer() != null) {
                    WebInputHandler webInputHandler = WebInputHandler.this;
                    webInputHandler.animatorTranslateY(webInputHandler.mNativeContainer.getPageWebviewContainer().getTranslationY(), 0.0f);
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
    public class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private final WebEditText webEditText;

        public MyOnGlobalLayoutListener(WebEditText webEditText) {
            this.webEditText = webEditText;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] iArr = new int[2];
            this.webEditText.getLocationOnScreen(iArr);
            int realHeight = (DisplayUtil.getRealHeight(this.webEditText.getContext()) - (iArr[1] + this.webEditText.getHeight())) - this.webEditText.getMarginBottom();
            if (this.webEditText.isFocused() && this.webEditText.isAdjustPosition() && WebInputHandler.this.isKeyboardShow && WebInputHandler.this.showKeyboardHeight > realHeight && WebInputHandler.this.mNativeContainer != null && WebInputHandler.this.mNativeContainer.getPageWebviewContainer() != null) {
                WebInputHandler.this.animatorTranslateY(0.0f, -(r1.showKeyboardHeight - realHeight));
            } else if (!WebInputHandler.this.isKeyboardShow && WebInputHandler.this.mNativeContainer != null && WebInputHandler.this.mNativeContainer.getPageWebviewContainer() != null) {
                WebInputHandler webInputHandler = WebInputHandler.this;
                webInputHandler.animatorTranslateY(webInputHandler.mNativeContainer.getPageWebviewContainer().getTranslationY(), 0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class MyOnWebviewScrollListener implements c.a {
        private final c pageWebview;

        public MyOnWebviewScrollListener(c cVar) {
            this.pageWebview = cVar;
        }

        @Override // com.tencent.qqmini.miniapp.core.page.c.a
        public void onVerticalScroll(int i3) {
            this.pageWebview.saveScrollY(i3);
        }
    }

    public WebInputHandler(NativeViewContainer nativeViewContainer) {
        this.mNativeContainer = nativeViewContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animatorTranslateY(float... fArr) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mNativeContainer.getPageWebviewContainer(), "translationY", fArr);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
    }

    public Map<Integer, WebEditText> getShowingInput() {
        return this.mShowingInput;
    }

    public WebEditText getWebEditText() {
        return new WebEditText(this.mNativeContainer.getContext(), this);
    }

    public boolean hasFocusInput() {
        if (this.mCurrentFocusInput != null) {
            return true;
        }
        return false;
    }

    public void hideCurrentInput() {
        NativeViewContainer nativeViewContainer;
        if (this.mCurrentFocusInput != null && (nativeViewContainer = this.mNativeContainer) != null && nativeViewContainer.getPageWebviewContainer() != null) {
            if (this.mShowingInput.size() > 0) {
                try {
                    Iterator<Map.Entry<Integer, WebEditText>> it = this.mShowingInput.entrySet().iterator();
                    while (it.hasNext()) {
                        WebEditText value = it.next().getValue();
                        QMLog.d(TAG, "[hideCurrentInput] webEditText=" + value);
                        int inputId = value.getInputId();
                        c pageWebview = value.getPageWebview();
                        WebEditText webEditText = this.mCurrentFocusInput;
                        if (webEditText != null && webEditText.getInputId() == value.getInputId()) {
                            ((InputMethodManager) value.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(value.getWindowToken(), 0);
                            this.isKeyboardShow = false;
                        }
                        value.clearFocus();
                        value.detach();
                        value.setHasMoveParent(false);
                        this.mShowingInput.remove(Integer.valueOf(inputId));
                        if (this.mNativeContainer != null) {
                            this.mNativeContainer.removeSoftKeyboardStateListener(this.mInputKeyboardListener.remove(Integer.valueOf(inputId)));
                        }
                        if (pageWebview != null) {
                            String obj = value.getText().toString();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("inputId", inputId);
                            jSONObject.put("value", obj);
                            jSONObject.put("cursor", obj.length());
                            this.mNativeContainer.getPageWebviewContainer().evaluateSubscribeJS(InputJsPlugin.ON_KEYBOARD_COMPLETE_CALLBACK, jSONObject.toString());
                            c.a aVar = this.scrollListener;
                            if (aVar != null) {
                                pageWebview.removeWebviewScrollListener(aVar);
                            }
                        }
                    }
                } catch (Throwable th5) {
                    QMLog.e(TAG, "hideCurrentInput error, ", th5);
                }
            }
            this.mCurrentFocusInput = null;
            NativeViewContainer nativeViewContainer2 = this.mNativeContainer;
            if (nativeViewContainer2 != null && nativeViewContainer2.getPageWebviewContainer() != null) {
                animatorTranslateY(this.mNativeContainer.getPageWebviewContainer().getTranslationY(), 0.0f);
                return;
            }
            return;
        }
        QMLog.e(TAG, "mCurrentFocusInput is null, return.");
    }

    public synchronized void hideKeyboard(NativeViewRequestEvent nativeViewRequestEvent) {
        QMLog.d(TAG, ", webParams=" + nativeViewRequestEvent.jsonParams + ", callbackId=" + nativeViewRequestEvent.callbackId);
        synchronized (this.mInputLock) {
            if (!(nativeViewRequestEvent.jsService instanceof PageWebview)) {
                hideCurrentInput();
                nativeViewRequestEvent.ok();
            }
        }
    }

    public boolean isFocus(int i3) {
        WebEditText webEditText = this.mCurrentFocusInput;
        if (webEditText != null && webEditText.getInputId() == i3) {
            return true;
        }
        return false;
    }

    public boolean parseParams(NativeViewRequestEvent nativeViewRequestEvent, WebEditText webEditText) {
        try {
            return webEditText.initWithWebParams(this.mNativeContainer, nativeViewRequestEvent.jsonParams);
        } catch (Exception e16) {
            QMLog.e(TAG, "[showKeyboard] initWithWebParams exception:", e16);
            return false;
        }
    }

    public synchronized void setKeyboardValue(NativeViewRequestEvent nativeViewRequestEvent) {
        JSONObject jSONObject;
        int optInt;
        WebEditText webEditText;
        int i3;
        QMLog.d(TAG, ", webParams=" + nativeViewRequestEvent.jsonParams + ", callbackId=" + nativeViewRequestEvent.callbackId);
        try {
            jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            optInt = jSONObject.optInt("inputId");
            webEditText = this.mShowingInput.get(Integer.valueOf(optInt));
        } catch (Exception e16) {
            QMLog.e(TAG, "setKeyboardValue error.", e16);
        }
        if (webEditText == null) {
            nativeViewRequestEvent.fail();
            return;
        }
        String optString = jSONObject.optString("value");
        this.mSetValue.put(Integer.valueOf(optInt), optString);
        webEditText.setText(optString);
        if (optString != null) {
            i3 = optString.length();
        } else {
            i3 = 0;
        }
        webEditText.setSelection(i3);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("inputId", optInt);
        nativeViewRequestEvent.ok(jSONObject2);
    }

    public void showKeyboard(NativeViewRequestEvent nativeViewRequestEvent) {
        QMLog.d(TAG, "showKeyboard , webParams=" + nativeViewRequestEvent.jsonParams + ", callbackId=" + nativeViewRequestEvent.callbackId);
        synchronized (this.mInputLock) {
            QMLog.d(TAG, "[showKeyboard] mCurrentFocusInput=" + this.mCurrentFocusInput);
            if (TextUtils.isEmpty(nativeViewRequestEvent.jsonParams)) {
                QMLog.e(TAG, "[showKeyboard] no web input params");
                nativeViewRequestEvent.fail();
                return;
            }
            NativeViewContainer nativeViewContainer = this.mNativeContainer;
            if (nativeViewContainer == null) {
                nativeViewRequestEvent.fail();
                return;
            }
            this.screenHeight = DisplayUtil.getRealHeight(nativeViewContainer.getContext());
            this.navbarHeight = this.mNativeContainer.getNaviBarHeight();
            WebEditText webEditText = getWebEditText();
            int incrementAndGet = this.mInputIdGenerator.incrementAndGet();
            this.inputId = incrementAndGet;
            this.mNativeContainer.setCurInputId(incrementAndGet);
            if (this.mNativeContainer != null) {
                KeyboardHiddenObserver keyboardHiddenObserver = new KeyboardHiddenObserver();
                this.mNativeContainer.setSoftKeyboardStateListener(keyboardHiddenObserver);
                this.mInputKeyboardListener.put(Integer.valueOf(this.inputId), keyboardHiddenObserver);
            }
            c currentPageWebview = this.mNativeContainer.getCurrentPageWebview();
            MyOnWebviewScrollListener myOnWebviewScrollListener = new MyOnWebviewScrollListener(currentPageWebview);
            this.scrollListener = myOnWebviewScrollListener;
            if (currentPageWebview != null) {
                currentPageWebview.setOnWebviewScrollListener(myOnWebviewScrollListener);
            }
            try {
                if (parseParams(nativeViewRequestEvent, webEditText)) {
                    NativeViewContainer nativeViewContainer2 = this.mNativeContainer;
                    if (nativeViewContainer2 != null && nativeViewContainer2.getNativeViewRoot() != null) {
                        this.mNativeContainer.getNativeViewRoot().addView(webEditText, webEditText.makeLayoutParams());
                    }
                    this.mCurrentFocusInput = webEditText;
                    webEditText.setInputId(this.inputId);
                    webEditText.setPageWebview(currentPageWebview);
                    this.mShowingInput.put(Integer.valueOf(this.inputId), webEditText);
                    webEditText.showSoftInput();
                    webEditText.addTextChangedListener(new MyTextWatcher(nativeViewRequestEvent));
                    webEditText.setOnEditorActionListener(new MyOnEditorActionListener(webEditText, nativeViewRequestEvent));
                    webEditText.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener(webEditText));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("inputId", this.inputId);
                    nativeViewRequestEvent.ok(jSONObject);
                } else {
                    nativeViewRequestEvent.fail();
                }
            } catch (Exception e16) {
                QMLog.e(TAG, "[showKeyboard] exception:", e16);
            }
        }
    }

    public synchronized boolean updateInput(String str) {
        if (this.mShowingInput == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            WebEditText webEditText = this.mShowingInput.get(Integer.valueOf(jSONObject.optInt("inputId")));
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
                this.mNativeContainer.getNaviBarHeight();
                this.navbarHeight = 0;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) webEditText.getLayoutParams();
                layoutParams.width = max;
                layoutParams.height = max2;
                int optInt6 = (int) ((optJSONObject.optInt("left") * density) + 0.5f);
                int optInt7 = (((int) ((density * optJSONObject.optInt("top")) + 0.5f)) - this.mNativeContainer.getWebScrollY()) + this.navbarHeight;
                layoutParams.leftMargin = optInt6;
                layoutParams.topMargin = optInt7;
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
    public class MyTextWatcher implements TextWatcher {
        private final NativeViewRequestEvent req;

        public MyTextWatcher(NativeViewRequestEvent nativeViewRequestEvent) {
            this.req = nativeViewRequestEvent;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (WebInputHandler.this.mSetValue.containsKey(Integer.valueOf(WebInputHandler.this.inputId)) && charSequence.toString().equals(WebInputHandler.this.mSetValue.get(Integer.valueOf(WebInputHandler.this.inputId)))) {
                return;
            }
            WebInputHandler.this.mSetValue.remove(Integer.valueOf(WebInputHandler.this.inputId));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("inputId", WebInputHandler.this.inputId);
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
                jSONObject.put("data", new JSONObject(this.req.jsonParams).optString("data"));
                this.req.sendSubscribeJs(h.g.NAME, jSONObject.toString(), WebInputHandler.this.mNativeContainer.getWebviewId());
            } catch (Exception e16) {
                QMLog.e(WebInputHandler.TAG, "onTextChanged error", e16);
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
