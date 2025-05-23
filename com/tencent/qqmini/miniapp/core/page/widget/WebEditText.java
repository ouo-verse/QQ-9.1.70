package com.tencent.qqmini.miniapp.core.page.widget;

import android.annotation.TargetApi;
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
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.c;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WebEditText extends EditText implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final String TAG = "WebEditText";
    private boolean adjustPosition;
    private String backgroundColor;
    private boolean confirmHold;
    private String fontWeight;
    private boolean hasMoveParent;
    private WebInputHandler mInputHandler;
    private int mInputId;
    private WeakReference<c> mPageWebviewRef;
    private int mWebInputHeight;
    private int mWebInputLeft;
    private int mWebInputTop;
    private int mWebInputWidth;
    private int marginBottom;
    private String textAlign;
    private String textColor;

    public WebEditText(Context context) {
        super(context);
        this.adjustPosition = false;
        this.hasMoveParent = false;
        this.fontWeight = "normal";
        this.textColor = "#FFFFFFFF";
        this.backgroundColor = "#FFFFFFFF";
        this.marginBottom = 0;
        this.textAlign = "left";
        this.confirmHold = false;
    }

    private int getImeAction(String str) {
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

    private int getInputType(String str, boolean z16) {
        if (!"number".equals(str) && !"digit".equals(str) && !"idcard".equals(str)) {
            if (z16) {
                return 129;
            }
            return 1;
        }
        return 2;
    }

    private void parseEditStyle(Context context, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            float density = DisplayUtil.getDensity(context);
            this.mWebInputWidth = (int) (optJSONObject.optInt("width") * density);
            this.mWebInputHeight = (int) (optJSONObject.optInt("height") * density);
            this.mWebInputLeft = (int) (optJSONObject.optInt("left") * density);
            this.mWebInputTop = (int) (optJSONObject.optInt("top") * density);
            super.setTextSize(optJSONObject.optInt("fontSize", 16));
            this.fontWeight = optJSONObject.optString("fontWeight", "normal");
            this.textColor = optJSONObject.optString("color", "#FFFFFFFF");
            this.backgroundColor = optJSONObject.optString("backgroundColor", "#FFFFFFFF");
            this.marginBottom = (int) ((DisplayUtil.getDensity(getContext()) * optJSONObject.optInt(NodeProps.MARGIN_BOTTOM)) + 0.5f);
            this.textAlign = optJSONObject.optString("textAlign", "left");
        }
    }

    private void setGravity() {
        if ("left".equals(this.textAlign)) {
            setGravity(19);
        } else if ("center".equals(this.textAlign)) {
            setGravity(17);
        } else if ("right".equals(this.textAlign)) {
            setGravity(21);
        }
    }

    private void setKeyListener(String str) {
        if ("idcard".equals(str)) {
            super.setKeyListener(DigitsKeyListener.getInstance("1234567890Xx"));
        } else if ("digit".equals(str)) {
            super.setKeyListener(DigitsKeyListener.getInstance("1234567890."));
        }
    }

    @TargetApi(16)
    public void detach() {
        if (super.getParent() != null) {
            ((ViewGroup) super.getParent()).removeView(this);
        }
        super.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.mPageWebviewRef.clear();
    }

    public int getInputHeight() {
        return this.mWebInputHeight;
    }

    public int getInputId() {
        return this.mInputId;
    }

    public int getMarginBottom() {
        return this.marginBottom;
    }

    public c getPageWebview() {
        WeakReference<c> weakReference = this.mPageWebviewRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean hasMoveParent() {
        return this.hasMoveParent;
    }

    public boolean initWithWebParams(NativeViewContainer nativeViewContainer, String str) throws Exception {
        if (TextUtils.isEmpty(str) || nativeViewContainer == null) {
            return false;
        }
        Context context = super.getContext();
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("type");
        super.setInputType(getInputType(optString, jSONObject.optBoolean(NotificationActivity.PASSWORD)));
        setImeOptions(getImeAction(jSONObject.optString("confirmType")));
        int optInt = jSONObject.optInt("maxLength", -1);
        if (optInt != -1) {
            super.setFilters(new InputFilter[]{new InputFilter.LengthFilter(optInt)});
        }
        parseEditStyle(context, jSONObject);
        String optString2 = jSONObject.optString("placeholder");
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            super.setHintTextColor(ColorUtils.parseColor(optJSONObject.optString("color", "#FFFFFFFF")));
        }
        this.adjustPosition = jSONObject.optBoolean("adjustPosition");
        this.confirmHold = jSONObject.optBoolean("confirmHold", false);
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
        super.setTextColor(ColorUtils.parseColor(this.textColor));
        super.setBackgroundColor(ColorUtils.parseColor(this.backgroundColor));
        super.setHint(optString2);
        setGravity();
        setKeyListener(optString);
        return true;
    }

    public boolean isAdjustPosition() {
        return this.adjustPosition;
    }

    public boolean isConfirmHold() {
        return this.confirmHold;
    }

    public FrameLayout.LayoutParams makeLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mWebInputWidth, this.mWebInputHeight);
        layoutParams.leftMargin = this.mWebInputLeft;
        layoutParams.topMargin = this.mWebInputTop;
        return layoutParams;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        WebInputHandler webInputHandler = this.mInputHandler;
        if (webInputHandler != null && webInputHandler.isFocus(this.mInputId)) {
            super.requestFocus();
            QMLog.d(TAG, "showSoftInput for inputId=" + this.mInputId);
            InputMethodManager inputMethodManager = (InputMethodManager) super.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this, 0);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
        WebInputHandler webInputHandler;
        if (i3 == 4 && keyEvent.getAction() == 1 && (webInputHandler = this.mInputHandler) != null && webInputHandler.hasFocusInput()) {
            this.mInputHandler.hideCurrentInput();
            return true;
        }
        return super.onKeyPreIme(i3, keyEvent);
    }

    public void setHasMoveParent(boolean z16) {
        this.hasMoveParent = z16;
    }

    public void setInputHeight(int i3) {
        this.mWebInputHeight = i3;
    }

    public void setInputId(int i3) {
        this.mInputId = i3;
    }

    public void setPageWebview(c cVar) {
        this.mPageWebviewRef = new WeakReference<>(cVar);
    }

    @TargetApi(16)
    public void showSoftInput() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) super.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this, 0);
        }
    }

    @Override // android.view.View
    public String toString() {
        return "WebEditText{mWebInputWidth=" + this.mWebInputWidth + ", mWebInputHeight=" + this.mWebInputHeight + ", mWebInputTop=" + this.mWebInputTop + ", mWebInputLeft=" + this.mWebInputLeft + ", mInputId=" + this.mInputId + '}';
    }

    public WebEditText(Context context, WebInputHandler webInputHandler) {
        super(context);
        this.adjustPosition = false;
        this.hasMoveParent = false;
        this.fontWeight = "normal";
        this.textColor = "#FFFFFFFF";
        this.backgroundColor = "#FFFFFFFF";
        this.marginBottom = 0;
        this.textAlign = "left";
        this.confirmHold = false;
        super.setBackgroundDrawable(null);
        super.setIncludeFontPadding(false);
        super.setSingleLine(true);
        super.setTextIsSelectable(true);
        super.setLineSpacing(0.0f, 1.0f);
        super.setPadding(0, 0, 0, 0);
        this.mInputHandler = webInputHandler;
    }
}
