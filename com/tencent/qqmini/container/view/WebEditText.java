package com.tencent.qqmini.container.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WebEditText extends EditText implements ViewTreeObserver.OnGlobalLayoutListener {
    private boolean C;
    private String D;
    private String E;
    private String F;
    private int G;
    private String H;
    private boolean I;
    private a J;

    /* renamed from: d, reason: collision with root package name */
    private int f346166d;

    /* renamed from: e, reason: collision with root package name */
    private int f346167e;

    /* renamed from: f, reason: collision with root package name */
    private int f346168f;

    /* renamed from: h, reason: collision with root package name */
    private int f346169h;

    /* renamed from: i, reason: collision with root package name */
    private int f346170i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f346171m;

    public WebEditText(Context context) {
        super(context);
        this.f346171m = false;
        this.C = false;
        this.D = "normal";
        this.E = "#FFFFFFFF";
        this.F = "#FFFFFFFF";
        this.G = 0;
        this.H = "left";
        this.I = false;
    }

    private int b(String str) {
        if ("send".equals(str)) {
            return 4;
        }
        if ("search".equals(str)) {
            return 3;
        }
        if ("next".equals(str)) {
            return 5;
        }
        if (ResourceAttributes.TelemetrySdkLanguageValues.GO.equals(str)) {
            return 2;
        }
        return 6;
    }

    private int d(String str, boolean z16) {
        if (!"number".equals(str) && !"digit".equals(str) && !"idcard".equals(str)) {
            if (z16) {
                return 129;
            }
            return 1;
        }
        return 2;
    }

    private void j(Context context, JSONObject jSONObject) {
        float density;
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            if (miniAppProxy != null) {
                density = miniAppProxy.getQQDensity(context);
            } else {
                density = DisplayUtil.getDensity(context);
            }
            this.f346166d = (int) (optJSONObject.optInt("width") * density);
            this.f346167e = (int) (optJSONObject.optInt("height") * density);
            this.f346169h = (int) (optJSONObject.optInt("left") * density);
            this.f346168f = (int) (optJSONObject.optInt("top") * density);
            super.setTextSize(optJSONObject.optInt("fontSize", 16));
            this.D = optJSONObject.optString("fontWeight", "normal");
            this.E = optJSONObject.optString("color", "#FFFFFFFF");
            this.F = optJSONObject.optString("backgroundColor", "#FFFFFFFF");
            this.G = (int) ((DisplayUtil.getDensity(getContext()) * optJSONObject.optInt(NodeProps.MARGIN_BOTTOM)) + 0.5f);
            this.H = optJSONObject.optString("textAlign", "left");
        }
    }

    private void k() {
        if ("left".equals(this.H)) {
            setGravity(19);
        } else if ("center".equals(this.H)) {
            setGravity(17);
        } else if ("right".equals(this.H)) {
            setGravity(21);
        }
    }

    private void l(String str) {
        if ("idcard".equals(str)) {
            super.setKeyListener(DigitsKeyListener.getInstance("1234567890Xx"));
        } else if ("digit".equals(str)) {
            super.setKeyListener(DigitsKeyListener.getInstance("1234567890."));
        }
    }

    public void a() {
        if (super.getParent() != null) {
            ((ViewGroup) super.getParent()).removeView(this);
        }
        super.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public int c() {
        return this.f346170i;
    }

    public int e() {
        return this.G;
    }

    public boolean f(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Context context = super.getContext();
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("type");
        super.setInputType(d(optString, jSONObject.optBoolean(NotificationActivity.PASSWORD)));
        setImeOptions(b(jSONObject.optString("confirmType")));
        int optInt = jSONObject.optInt("maxLength", -1);
        if (optInt != -1) {
            super.setFilters(new InputFilter[]{new InputFilter.LengthFilter(optInt)});
        }
        j(context, jSONObject);
        String optString2 = jSONObject.optString("placeholder");
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            super.setHintTextColor(ColorUtils.parseColor(optJSONObject.optString("color", "#FFFFFFFF")));
        }
        this.f346171m = jSONObject.optBoolean("adjustPosition");
        this.I = jSONObject.optBoolean("confirmHold", false);
        String optString3 = jSONObject.optString(RemoteHandleConst.PARAM_DEFAULT_VALUE);
        if (!TextUtils.isEmpty(optString3)) {
            super.setText(optString3);
        } else {
            super.setText("");
        }
        int optInt2 = jSONObject.optInt("selectionStart", -1);
        int optInt3 = jSONObject.optInt("selectionEnd", -1);
        if (optInt2 != -1 && optInt3 != -1 && optInt3 > optInt2) {
            setSelection(optInt2, optInt3);
        }
        int optInt4 = jSONObject.optInt("cursor", -1);
        if (optInt4 > 0) {
            setSelection(optInt4);
        }
        super.setTextColor(ColorUtils.parseColor(this.E));
        super.setBackgroundColor(ColorUtils.parseColor(this.F));
        super.setHint(optString2);
        k();
        l(optString);
        return true;
    }

    public boolean g() {
        return this.f346171m;
    }

    public boolean h() {
        return this.I;
    }

    public FrameLayout.LayoutParams i() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f346166d, this.f346167e);
        layoutParams.leftMargin = this.f346169h;
        layoutParams.topMargin = this.f346168f;
        return layoutParams;
    }

    public void m() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) super.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this, 0);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        a aVar = this.J;
        if (aVar != null && aVar.o(this.f346170i)) {
            super.requestFocus();
            QMLog.d("WebEditText", "showSoftInput for inputId=" + this.f346170i);
            InputMethodManager inputMethodManager = (InputMethodManager) super.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this, 0);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
        a aVar;
        if (i3 == 4 && keyEvent.getAction() == 1 && (aVar = this.J) != null && aVar.l()) {
            this.J.m();
            return true;
        }
        return super.onKeyPreIme(i3, keyEvent);
    }

    public void setHasMoveParent(boolean z16) {
        this.C = z16;
    }

    public void setInputHeight(int i3) {
        this.f346167e = i3;
    }

    public void setInputId(int i3) {
        this.f346170i = i3;
    }

    @Override // android.view.View
    public String toString() {
        return "WebEditText{mWebInputWidth=" + this.f346166d + ", mWebInputHeight=" + this.f346167e + ", mWebInputTop=" + this.f346168f + ", mWebInputLeft=" + this.f346169h + ", mInputId=" + this.f346170i + '}';
    }

    public WebEditText(Context context, a aVar) {
        super(context);
        this.f346171m = false;
        this.C = false;
        this.D = "normal";
        this.E = "#FFFFFFFF";
        this.F = "#FFFFFFFF";
        this.G = 0;
        this.H = "left";
        this.I = false;
        super.setBackgroundDrawable(null);
        super.setIncludeFontPadding(false);
        super.setSingleLine(true);
        super.setTextIsSelectable(true);
        super.setLineSpacing(0.0f, 1.0f);
        super.setPadding(0, 0, 0, 0);
        this.J = aVar;
    }
}
