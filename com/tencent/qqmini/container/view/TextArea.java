package com.tencent.qqmini.container.view;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.luggage.wxa.df.h;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.container.core.NativeContainer;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.plugins.InputJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes23.dex */
public class TextArea extends EditText {
    private String C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private JSONObject H;
    private String I;
    private int J;
    private volatile boolean K;
    private int L;
    private ViewTreeObserver.OnGlobalLayoutListener M;
    private boolean N;
    private final b P;
    private final SoftKeyboardStateHelper Q;
    private int R;
    private final Runnable S;
    private int T;
    private boolean U;
    private int V;

    /* renamed from: d, reason: collision with root package name */
    private final NativeContainer f346152d;

    /* renamed from: e, reason: collision with root package name */
    private final int f346153e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f346154f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f346155h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f346156i;

    /* renamed from: m, reason: collision with root package name */
    private int f346157m;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f346158a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f346159b;

        public int a() {
            return this.f346158a;
        }

        public int b() {
            return this.f346159b;
        }

        public void c(int i3) {
            this.f346158a = i3;
        }

        public void d(int i3) {
            this.f346159b = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
        public b() {
        }

        @Override // com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            QMLog.i("MiniAppTextArea", "onSoftKeyboardClosed false");
            TextArea.this.f346155h = false;
            TextArea.this.J();
        }

        @Override // com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardOpened(int i3) {
            boolean B;
            QMLog.i("MiniAppTextArea", "onSoftKeyboardOpened true");
            TextArea.this.f346155h = true;
            try {
                TextArea.this.f346152d.setCurrentInputId(TextArea.this.f346153e);
                TextArea.this.J = i3;
                Context context = TextArea.this.getContext();
                if (context != null) {
                    if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                        B = TextArea.this.B(context);
                    } else {
                        B = DisplayUtil.checkNavigationBarShow(context);
                    }
                    QMLog.d("MiniAppTextArea", " hasNavBar : " + B + "; " + Build.BRAND);
                    if (B) {
                        TextArea.this.J += DisplayUtil.getNavigationBarHeight(context);
                    }
                }
                if (TextArea.this.isFocused()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("inputId", TextArea.this.f346153e);
                    jSONObject.put("height", (int) ((TextArea.this.J / DisplayUtil.getDensity(TextArea.this.getContext())) + 0.5f));
                    TextArea.this.f346152d.c0("onKeyboardShow", jSONObject.toString());
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private class c implements View.OnFocusChangeListener {
        c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (!TextArea.this.f346154f && z16) {
                TextArea.this.K = true;
                InputMethodManager inputMethodManager = (InputMethodManager) TextArea.this.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(view, 0);
                }
            }
            if (!TextArea.this.N && TextArea.this.f346155h && z16 && TextArea.this.f346152d != null) {
                TextArea.this.N = true;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("inputId", TextArea.this.f346153e);
                    jSONObject.put("height", (int) ((TextArea.this.J / DisplayUtil.getDensity(TextArea.this.getContext())) + 0.5f));
                    QMLog.d("MiniAppTextArea", "onKeyboardShow : " + jSONObject.toString());
                    TextArea.this.f346152d.c0("onKeyboardShow", jSONObject.toString());
                } catch (Throwable th5) {
                    QMLog.e("MiniAppTextArea", "onFocusChange error", th5);
                }
            }
            if (!z16 && TextArea.this.f346152d != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("inputId", TextArea.this.f346153e);
                    jSONObject2.put("value", TextArea.this.getText().toString());
                    jSONObject2.put("cursor", TextArea.this.getText().toString().length());
                    QMLog.d("MiniAppTextArea", "onKeyboardComplete : " + jSONObject2.toString());
                    TextArea.this.f346152d.c0(InputJsPlugin.ON_KEYBOARD_COMPLETE_CALLBACK, jSONObject2.toString());
                } catch (Exception e16) {
                    QMLog.e("MiniAppTextArea", "onFocusChange error", e16);
                }
                TextArea.this.N = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            TextArea.this.X();
        }
    }

    public TextArea(@NonNull Context context, int i3, NativeContainer nativeContainer) {
        super(context);
        this.f346154f = false;
        this.f346155h = false;
        this.f346156i = false;
        this.f346157m = 0;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = new JSONObject();
        this.I = null;
        this.J = 0;
        this.K = false;
        this.L = -1;
        this.N = false;
        this.P = new b();
        this.R = 0;
        this.S = new Runnable() { // from class: com.tencent.qqmini.container.view.TextArea.1
            @Override // java.lang.Runnable
            public void run() {
                QMLog.i("MiniAppTextArea", "translateRunnable isKeyboardShow :  " + TextArea.this.f346155h);
                if (TextArea.this.isFocused() && TextArea.this.f346155h) {
                    int realHeight = DisplayUtil.getRealHeight(TextArea.this.getContext()) - ((TextArea.this.getTop() - TextArea.this.f346152d.getScrollY()) + TextArea.this.H());
                    if (TextArea.this.J > realHeight && TextArea.this.f346156i && TextArea.this.f346155h) {
                        QMLog.i("MiniAppTextArea", "up !!! ");
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(TextArea.this.f346152d, "translationY", TextArea.this.R, -(TextArea.this.J - realHeight));
                        ofFloat.setDuration(200L);
                        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                        ofFloat.start();
                        TextArea textArea = TextArea.this;
                        textArea.R = -(textArea.J - realHeight);
                        return;
                    }
                    QMLog.i("MiniAppTextArea", "keep !!! ");
                    return;
                }
                if (!TextArea.this.f346155h) {
                    QMLog.i("MiniAppTextArea", "down !!! ");
                    TextArea.this.R = 0;
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(TextArea.this.f346152d, "translationY", TextArea.this.f346152d.getTranslationY(), 0.0f);
                    ofFloat2.setDuration(200L);
                    ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                    ofFloat2.start();
                }
            }
        };
        this.T = -1;
        this.U = false;
        this.V = 0;
        this.f346152d = nativeContainer;
        this.f346153e = i3;
        this.Q = nativeContainer.u();
        setPadding(0, 0, 0, 0);
        z();
        setBackgroundDrawable(null);
        setHorizontallyScrolling(false);
        setVerticalScrollBarEnabled(false);
        setSingleLine(false);
        setInputType(IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_TCP_OPEN);
        setFocusable(true);
        setOnFocusChangeListener(new c());
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B(Context context) {
        if (!DisplayUtil.hasNavBar(context) && !DisplayUtil.isFlymeOS7NavBarShow()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        try {
            a E = E();
            if (E.a() != this.T) {
                this.T = E.a();
                JSONObject jSONObject = new JSONObject();
                int b16 = E.b();
                int i3 = this.G;
                if (i3 != 0) {
                    b16 = Math.max(i3, b16);
                }
                int i16 = this.F;
                if (i16 != 0) {
                    b16 = Math.min(i16, b16);
                }
                jSONObject.put("height", b16 / DisplayUtil.getDensity(getContext()));
                jSONObject.put("lineCount", E.a());
                jSONObject.put("inputId", this.f346153e);
                this.f346152d.c0("onTextAreaHeightChange", jSONObject.toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private int F(float f16) {
        Paint paint = new Paint();
        paint.setTextSize(f16 * DisplayUtil.getDensity(getContext()));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) (fontMetrics.descent - fontMetrics.ascent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int H() {
        Layout layout = getLayout();
        int i3 = 0;
        if (layout == null) {
            return 0;
        }
        int selectionStart = Selection.getSelectionStart(getText());
        if (selectionStart != -1) {
            i3 = layout.getLineForOffset(selectionStart) + 1;
        }
        int lineHeight = (int) ((getLineHeight() * i3) + 0.5d);
        int i16 = this.F;
        if (i16 != 0) {
            lineHeight = Math.min(lineHeight, i16);
        } else {
            int i17 = this.E;
            if (i17 != 0) {
                lineHeight = Math.min(lineHeight, i17);
            }
        }
        return lineHeight + this.f346157m;
    }

    private void I() {
        QMLog.d("MiniAppTextArea", "hideCurrentInput : " + isFocused());
        if (isFocused()) {
            clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("inputId", this.f346153e);
                jSONObject.put("value", getText().toString());
                jSONObject.put("cursor", getText().toString().length());
            } catch (Exception e16) {
                QMLog.e("MiniAppTextArea", "hideCurrentInput error", e16);
            }
        }
        postDelayed(new Runnable() { // from class: com.tencent.qqmini.container.view.b
            @Override // java.lang.Runnable
            public final void run() {
                TextArea.this.L();
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.f346155h = false;
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        QMLog.e("MiniAppTextArea", "hideCurrentInput set isFocused false");
        this.K = false;
    }

    private boolean M(JSONObject jSONObject) {
        if (!jSONObject.has("width") && !jSONObject.has("height") && !jSONObject.has("left") && !jSONObject.has("top")) {
            return false;
        }
        return true;
    }

    private void N() {
        this.M = new d();
        if (getViewTreeObserver() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.M);
        }
    }

    private void O(JSONObject jSONObject) {
        int optInt;
        if (jSONObject.has("cursor") && (optInt = jSONObject.optInt("cursor", -1)) > 0) {
            setSelection(optInt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i3, int i16, int i17) {
        if (i3 > 0) {
            if (i16 > 0) {
                this.L = i3;
            } else if (i17 > 0) {
                this.L = i3 + i17;
            }
        }
    }

    private void Q(JSONObject jSONObject) {
        if (jSONObject.has("fontWeight")) {
            if ("bold".equals(jSONObject.optString("fontWeight"))) {
                setTypeface(Typeface.defaultFromStyle(1));
            } else {
                setTypeface(Typeface.defaultFromStyle(0));
            }
        }
    }

    private void R(JSONObject jSONObject, boolean z16) {
        int i3;
        if (M(jSONObject)) {
            int max = (int) Math.max((DisplayUtil.getDensity(getContext()) * jSONObject.optInt("width")) + 0.5f, 0.0f);
            int max2 = (int) Math.max((DisplayUtil.getDensity(getContext()) * jSONObject.optInt("height")) + 0.5f, 0.0f);
            this.E = max2;
            if (max2 == 0 && this.D) {
                if (this.G == 0) {
                    if (jSONObject.has("fontSize")) {
                        i3 = jSONObject.optInt("fontSize");
                    } else {
                        i3 = 16;
                    }
                    this.G = F(i3);
                }
                max2 = this.G;
                if (z16 && getLayout() != null && getLayout().getHeight() > this.G) {
                    max2 = getLayout().getHeight();
                }
            }
            int density = (int) ((DisplayUtil.getDensity(getContext()) * jSONObject.optInt("left")) + 0.5f);
            int density2 = (int) ((DisplayUtil.getDensity(getContext()) * jSONObject.optInt("top")) + 0.5f);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(max, max2, 3);
            }
            layoutParams.width = max;
            layoutParams.height = max2;
            layoutParams.leftMargin = density;
            layoutParams.topMargin = density2;
            setLayoutParams(layoutParams);
        }
    }

    private void S(JSONObject jSONObject) {
        int optInt;
        if (jSONObject.has("maxLength") && (optInt = jSONObject.optInt("maxLength")) > 0) {
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(optInt)});
        }
    }

    private void T(JSONObject jSONObject) {
        if (jSONObject.has("placeholder")) {
            String optString = jSONObject.optString("placeholder");
            if (!StringUtil.isEmpty(optString)) {
                setHint(optString);
            }
        }
        if (jSONObject.has("placeholderStyle")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
            this.H = optJSONObject;
            if (optJSONObject != null && optJSONObject.has("color")) {
                String optString2 = this.H.optString("color");
                if (!TextUtils.isEmpty(optString2)) {
                    setHintTextColor(ColorUtils.parseColor(optString2));
                }
            }
        }
    }

    private void U(JSONObject jSONObject) {
        if (jSONObject.has("selectionStart") || jSONObject.has("selectionEnd")) {
            int optInt = jSONObject.optInt("selectionStart", -1);
            int optInt2 = jSONObject.optInt("selectionEnd", -1);
            if (optInt != -1 && optInt2 != -1 && optInt2 > optInt) {
                setSelection(optInt, optInt2);
            }
        }
    }

    private void V(JSONObject jSONObject, boolean z16) {
        if (jSONObject.has(NodeProps.MARGIN_BOTTOM)) {
            this.f346157m = (int) ((DisplayUtil.getDensity(getContext()) * jSONObject.optInt(NodeProps.MARGIN_BOTTOM)) + 0.5f);
        }
        if (jSONObject.has(NodeProps.MAX_HEIGHT)) {
            this.F = (int) ((DisplayUtil.getDensity(getContext()) * jSONObject.optInt(NodeProps.MAX_HEIGHT)) + 0.5f);
        }
        if (jSONObject.has(NodeProps.MIN_HEIGHT)) {
            this.G = (int) ((DisplayUtil.getDensity(getContext()) * jSONObject.optInt(NodeProps.MIN_HEIGHT)) + 0.5f);
        }
        int i3 = this.F;
        if (i3 != 0) {
            setMaxHeight(i3);
        }
        int i16 = this.G;
        if (i16 != 0) {
            setMinHeight(i16);
            setMinimumHeight(this.G);
            setMinimumWidth(0);
        }
        R(jSONObject, z16);
        W(jSONObject);
        Q(jSONObject);
        if (jSONObject.has("fontSize")) {
            setTextSize(jSONObject.optInt("fontSize"));
        }
        if (jSONObject.has("lineSpace")) {
            setLineSpacing(DisplayUtil.dip2px(getContext(), jSONObject.optInt("lineSpace")), 1.0f);
        }
        if (jSONObject.has("color")) {
            setTextColor(ColorUtils.parseColor(jSONObject.optString("color")));
        }
    }

    private void W(JSONObject jSONObject) {
        if (jSONObject.has("textAlign")) {
            String optString = jSONObject.optString("textAlign");
            optString.hashCode();
            char c16 = '\uffff';
            switch (optString.hashCode()) {
                case -1364013995:
                    if (optString.equals("center")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case 3317767:
                    if (optString.equals("left")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 108511772:
                    if (optString.equals("right")) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    setGravity(1);
                    return;
                case 1:
                    setGravity(3);
                    return;
                case 2:
                    setGravity(5);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        removeCallbacks(this.S);
        postDelayed(this.S, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        if (this.D && getLayout() != null && getLayout().getHeight() > this.G) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            if (this.F == 0 || getLayout().getHeight() <= this.F) {
                layoutParams.height = getLayout().getHeight();
            }
            setLayoutParams(layoutParams);
        }
    }

    private void Z(JSONObject jSONObject) {
        if (jSONObject.has("value")) {
            String optString = jSONObject.optString("value");
            this.C = optString;
            setText(optString);
            if (!TextUtils.isEmpty(optString)) {
                int i3 = this.L;
                if (i3 == -1) {
                    i3 = optString.length();
                }
                QMLog.d("miniapp-textarea", "updatevalue set cursor : " + i3);
                setSelection(i3);
            }
            this.L = -1;
        }
    }

    private void z() {
        SoftKeyboardStateHelper softKeyboardStateHelper = this.Q;
        if (softKeyboardStateHelper != null) {
            softKeyboardStateHelper.addSoftKeyboardStateListener(this.P);
        }
    }

    public void A() {
        try {
            this.T = 1;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("height", getLineHeight() / DisplayUtil.getDensity(getContext()));
            jSONObject.put("lineCount", 1);
            jSONObject.put("inputId", this.f346153e);
            this.f346152d.c0("onTextAreaHeightChange", jSONObject.toString());
        } catch (Throwable th5) {
            QMLog.e("MiniAppTextArea", "callbackLineChange error.", th5);
        }
    }

    public void C() {
        SoftKeyboardStateHelper softKeyboardStateHelper = this.Q;
        if (softKeyboardStateHelper != null) {
            softKeyboardStateHelper.removeSoftKeyboardStateListener(this.P);
        }
        if (getViewTreeObserver() != null && this.M != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.M);
        }
    }

    public a E() {
        a aVar = new a();
        Layout layout = getLayout();
        if (layout != null) {
            aVar.c(layout.getLineCount());
            aVar.d(layout.getHeight());
        }
        return aVar;
    }

    public int G() {
        return this.V;
    }

    public boolean K() {
        return this.U;
    }

    public void setAttributes(JSONObject jSONObject, boolean z16, NativeViewRequestEvent nativeViewRequestEvent) {
        if (jSONObject.has("data")) {
            this.I = jSONObject.optString("data");
        }
        int i3 = 0;
        if (jSONObject.has("autoSize")) {
            this.D = jSONObject.optBoolean("autoSize", false);
        }
        if (jSONObject.has("adjustPosition")) {
            this.f346156i = jSONObject.optBoolean("adjustPosition", false);
        }
        if (jSONObject.has("disabled")) {
            boolean optBoolean = jSONObject.optBoolean("disabled", false);
            this.f346154f = optBoolean;
            if (optBoolean) {
                setInputType(0);
            }
        }
        if (jSONObject.has("hidden")) {
            if (jSONObject.optBoolean("hidden")) {
                i3 = 8;
            }
            setVisibility(i3);
        }
        Z(jSONObject);
        S(jSONObject);
        T(jSONObject);
        U(jSONObject);
        O(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            V(optJSONObject, z16);
        }
        addTextChangedListener(new e(optJSONObject, nativeViewRequestEvent));
    }

    public void setFixed(boolean z16) {
        this.U = z16;
    }

    public void setParentId(int i3) {
        this.V = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class e implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private final JSONObject f346163d;

        /* renamed from: e, reason: collision with root package name */
        private final NativeViewRequestEvent f346164e;

        public e(JSONObject jSONObject, NativeViewRequestEvent nativeViewRequestEvent) {
            this.f346163d = jSONObject;
            this.f346164e = nativeViewRequestEvent;
        }

        private void a(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() == 0) {
                if (TextArea.this.H != null) {
                    TextArea.this.setTextSize(2, r5.H.optInt("fontSize"));
                    TextArea textArea = TextArea.this;
                    textArea.setTextColor(ColorUtils.parseColor(textArea.H.optString("color")));
                    return;
                }
                return;
            }
            if (this.f346163d != null) {
                TextArea.this.setTextSize(2, r5.optInt("fontSize"));
                TextArea.this.setTextColor(ColorUtils.parseColor(this.f346163d.optString("color")));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            TextArea.this.P(i3, i16, i17);
            a(charSequence);
            TextArea.this.X();
            TextArea.this.Y();
            TextArea.this.D();
            if (charSequence != null && !charSequence.toString().equals(TextArea.this.C)) {
                JSONObject jSONObject = new JSONObject();
                TextArea.this.C = charSequence.toString();
                try {
                    jSONObject.put("inputId", TextArea.this.f346153e);
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
                    jSONObject.put("value", TextArea.this.C);
                    if (i16 != 0 && i17 == 0) {
                        jSONObject.put("keyCode", 8);
                    } else {
                        jSONObject.put("keyCode", (int) charSequence.charAt((i3 + i17) - 1));
                    }
                    jSONObject.put("data", TextArea.this.I);
                    this.f346164e.sendSubscribeJs(h.g.NAME, jSONObject.toString(), TextArea.this.f346152d.w());
                } catch (Exception e16) {
                    QMLog.e("MiniAppTextArea", "onTextChanged error", e16);
                }
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
