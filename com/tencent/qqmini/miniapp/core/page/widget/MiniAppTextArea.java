package com.tencent.qqmini.miniapp.core.page.widget;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
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
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.qqmini.sdk.plugins.InputJsPlugin;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppTextArea extends EditText implements NativeViewContainer.IConfirmListerner {
    private static final String TAG = "MiniAppTextArea";
    private boolean adjustPosition;
    private boolean autoSize;
    private int confirmHeight;
    private String curValue;
    private int cursorPositation;
    private String data;
    private boolean disable;
    private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private boolean hasConfirm;
    private boolean hasSendKeyboardShowToJs;
    private boolean isFixed;
    private volatile boolean isFocused;
    private boolean isKeyboardShow;
    private int lastLines;
    private int lastTranslateY;
    private int mCurInputId;
    private Handler mHandler;
    private Map<Integer, SoftKeyboardStateHelper.SoftKeyboardStateListener> mInputKeyboardListner;
    private NativeViewContainer mNativeContainer;
    private int marginBootom;
    private int parentId;
    private JSONObject placeholderStyle;
    private int screenHeight;
    private int showKeyboardHeight;
    private JSONObject style;
    private int textAreaHeight;
    private int textAreaMaxHeight;
    private int textAreaMinHeight;
    private Runnable translateRunable;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class EditInfo {
        public int curLine = 0;
        public int height;

        public int getCurLine() {
            return this.curLine;
        }

        public int getHeight() {
            return this.height;
        }

        public void setCurLine(int i3) {
            this.curLine = i3;
        }

        public void setHeight(int i3) {
            this.height = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class KeyboardHiddenObserver implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
        public KeyboardHiddenObserver() {
        }

        @Override // com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            QMLog.i(MiniAppTextArea.TAG, "onSoftKeyboardClosed false");
            MiniAppTextArea.this.isKeyboardShow = false;
            MiniAppTextArea.this.hideSoftKeyboard(false);
        }

        @Override // com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardOpened(int i3) {
            PageWebviewContainer pageWebviewContainer;
            int i16;
            boolean checkHasNavBar;
            QMLog.i(MiniAppTextArea.TAG, "onSoftKeyboardOpened true");
            MiniAppTextArea.this.isKeyboardShow = true;
            try {
                if (MiniAppTextArea.this.mNativeContainer != null) {
                    pageWebviewContainer = MiniAppTextArea.this.mNativeContainer.getPageWebviewContainer();
                } else {
                    pageWebviewContainer = null;
                }
                if (MiniAppTextArea.this.mNativeContainer != null) {
                    MiniAppTextArea.this.mNativeContainer.setCurInputId(MiniAppTextArea.this.mCurInputId);
                }
                MiniAppTextArea.this.showKeyboardHeight = i3;
                Activity currentActivity = MiniAppTextArea.this.getCurrentActivity();
                if (currentActivity != null) {
                    if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                        checkHasNavBar = MiniAppTextArea.this.checkHasNavBar(currentActivity);
                    } else {
                        checkHasNavBar = DisplayUtil.checkNavigationBarShow(currentActivity);
                    }
                    QMLog.d(MiniAppTextArea.TAG, " hasNavBar : " + checkHasNavBar + "; " + Build.BRAND);
                    if (checkHasNavBar) {
                        MiniAppTextArea.this.showKeyboardHeight += DisplayUtil.getNavigationBarHeight(MiniAppTextArea.this.mNativeContainer.getPageWebviewContainer().getAttachActivity());
                    }
                }
                if (MiniAppTextArea.this.isFocused()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("inputId", MiniAppTextArea.this.mCurInputId);
                    int i17 = MiniAppTextArea.this.showKeyboardHeight;
                    if (MiniAppTextArea.this.hasConfirm) {
                        i16 = MiniAppTextArea.this.confirmHeight;
                    } else {
                        i16 = 0;
                    }
                    jSONObject.put("height", (int) (((i17 + i16) / DisplayUtil.getDensity(MiniAppTextArea.this.getContext())) + 0.5f));
                    if (pageWebviewContainer != null) {
                        pageWebviewContainer.evaluateSubscribeJS("onKeyboardShow", jSONObject.toString());
                    }
                    if (MiniAppTextArea.this.hasConfirm) {
                        MiniAppTextArea.this.showKeyBoardConfirmView((MiniAppTextArea.this.screenHeight - MiniAppTextArea.this.showKeyboardHeight) - MiniAppTextArea.this.confirmHeight);
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private class MyOnFocusChangeListener implements View.OnFocusChangeListener {
        MyOnFocusChangeListener() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            PageWebviewContainer pageWebviewContainer;
            int i3;
            if (MiniAppTextArea.this.mNativeContainer != null) {
                pageWebviewContainer = MiniAppTextArea.this.mNativeContainer.getPageWebviewContainer();
            } else {
                pageWebviewContainer = null;
            }
            if (!MiniAppTextArea.this.disable) {
                if (z16) {
                    MiniAppTextArea.this.isFocused = true;
                    InputMethodManager inputMethodManager = (InputMethodManager) MiniAppTextArea.this.mNativeContainer.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                    if (inputMethodManager != null) {
                        inputMethodManager.showSoftInput(view, 0);
                    }
                    if (!MiniAppTextArea.this.hasConfirm) {
                        MiniAppTextArea.this.hideKeyBoardConfirmView();
                    } else {
                        int i16 = (MiniAppTextArea.this.screenHeight - MiniAppTextArea.this.showKeyboardHeight) - MiniAppTextArea.this.confirmHeight;
                        QMLog.d(MiniAppTextArea.TAG, "screenHeight : " + MiniAppTextArea.this.screenHeight);
                        QMLog.d(MiniAppTextArea.TAG, "showKeyboardHeight : " + MiniAppTextArea.this.showKeyboardHeight);
                        QMLog.d(MiniAppTextArea.TAG, "confirmHeight : " + MiniAppTextArea.this.confirmHeight);
                        MiniAppTextArea.this.showKeyBoardConfirmView(i16);
                    }
                } else {
                    MiniAppTextArea.this.hideKeyBoardConfirmView();
                }
            }
            if (!MiniAppTextArea.this.hasSendKeyboardShowToJs && MiniAppTextArea.this.isKeyboardShow && z16 && MiniAppTextArea.this.mNativeContainer != null) {
                MiniAppTextArea.this.hasSendKeyboardShowToJs = true;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("inputId", MiniAppTextArea.this.mCurInputId);
                    int i17 = MiniAppTextArea.this.showKeyboardHeight;
                    if (MiniAppTextArea.this.hasConfirm) {
                        i3 = MiniAppTextArea.this.confirmHeight;
                    } else {
                        i3 = 0;
                    }
                    jSONObject.put("height", (int) (((i17 + i3) / DisplayUtil.getDensity(MiniAppTextArea.this.getContext())) + 0.5f));
                    QMLog.d(MiniAppTextArea.TAG, "onKeyboardShow : " + jSONObject.toString());
                    if (pageWebviewContainer != null) {
                        pageWebviewContainer.evaluateSubscribeJS("onKeyboardShow", jSONObject.toString());
                    }
                } catch (Throwable th5) {
                    QMLog.e(MiniAppTextArea.TAG, "onFocusChange error", th5);
                }
            }
            if (!z16 && MiniAppTextArea.this.mNativeContainer != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("inputId", MiniAppTextArea.this.mCurInputId);
                    jSONObject2.put("value", MiniAppTextArea.this.getText().toString());
                    jSONObject2.put("cursor", MiniAppTextArea.this.getText().toString().length());
                    QMLog.d(MiniAppTextArea.TAG, "onKeyboardComplete : " + jSONObject2.toString());
                    if (pageWebviewContainer != null) {
                        pageWebviewContainer.evaluateSubscribeJS(InputJsPlugin.ON_KEYBOARD_COMPLETE_CALLBACK, jSONObject2.toString());
                    }
                } catch (Exception e16) {
                    QMLog.e(MiniAppTextArea.TAG, "onFocusChange error", e16);
                }
                MiniAppTextArea.this.hasSendKeyboardShowToJs = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        MyOnGlobalLayoutListener() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            MiniAppTextArea.this.updateTextareaAnimator();
        }
    }

    public MiniAppTextArea(@NonNull Context context, int i3, NativeViewContainer nativeViewContainer) {
        super(context);
        this.mNativeContainer = null;
        this.mCurInputId = -1;
        this.disable = false;
        this.isKeyboardShow = false;
        this.adjustPosition = false;
        this.hasConfirm = false;
        this.marginBootom = 0;
        this.autoSize = false;
        this.textAreaHeight = 0;
        this.textAreaMaxHeight = 0;
        this.textAreaMinHeight = 0;
        this.placeholderStyle = new JSONObject();
        this.style = new JSONObject();
        this.data = null;
        this.showKeyboardHeight = 0;
        this.confirmHeight = DisplayUtil.dip2px(getContext(), 50.0f);
        this.isFocused = false;
        this.cursorPositation = -1;
        this.hasSendKeyboardShowToJs = false;
        this.mInputKeyboardListner = new ConcurrentHashMap();
        this.lastTranslateY = 0;
        this.translateRunable = new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea.1
            @Override // java.lang.Runnable
            public void run() {
                int naviBarHeight;
                if (MiniAppTextArea.this.isFocused() && MiniAppTextArea.this.isKeyboardShow && MiniAppTextArea.this.mNativeContainer != null && MiniAppTextArea.this.mNativeContainer.getPageWebviewContainer() != null) {
                    if (MiniAppTextArea.this.mNativeContainer.isCustomNavibar()) {
                        naviBarHeight = 0;
                    } else {
                        naviBarHeight = MiniAppTextArea.this.mNativeContainer.getNaviBarHeight();
                    }
                    int realHeight = DisplayUtil.getRealHeight(MiniAppTextArea.this.getContext()) - (((MiniAppTextArea.this.getTop() - MiniAppTextArea.this.mNativeContainer.getPageWebviewContainer().getNativeViewScrollY()) + naviBarHeight) + MiniAppTextArea.this.getSelectionPosition());
                    if (MiniAppTextArea.this.showKeyboardHeight > realHeight && MiniAppTextArea.this.adjustPosition && MiniAppTextArea.this.isKeyboardShow) {
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(MiniAppTextArea.this.mNativeContainer.getPageWebviewContainer(), "translationY", MiniAppTextArea.this.lastTranslateY, -(MiniAppTextArea.this.showKeyboardHeight - realHeight));
                        ofFloat.setDuration(200L);
                        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                        ofFloat.start();
                        MiniAppTextArea miniAppTextArea = MiniAppTextArea.this;
                        miniAppTextArea.lastTranslateY = -(miniAppTextArea.showKeyboardHeight - realHeight);
                        if (!FastClickUtils.isFastDoubleClick(MiniAppTextArea.TAG, 200L)) {
                            QMLog.i(MiniAppTextArea.TAG, "move up!");
                            return;
                        }
                        return;
                    }
                    if (!FastClickUtils.isFastDoubleClick(MiniAppTextArea.TAG, 200L)) {
                        QMLog.i(MiniAppTextArea.TAG, "keep state!");
                        return;
                    }
                    return;
                }
                if (!MiniAppTextArea.this.isKeyboardShow && MiniAppTextArea.this.mNativeContainer != null && MiniAppTextArea.this.mNativeContainer.getPageWebviewContainer() != null) {
                    MiniAppTextArea.this.lastTranslateY = 0;
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(MiniAppTextArea.this.mNativeContainer.getPageWebviewContainer(), "translationY", MiniAppTextArea.this.mNativeContainer.getPageWebviewContainer().getTranslationY(), 0.0f);
                    ofFloat2.setDuration(200L);
                    ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                    ofFloat2.start();
                    if (!FastClickUtils.isFastDoubleClick(MiniAppTextArea.TAG, 200L)) {
                        QMLog.i(MiniAppTextArea.TAG, "move down!");
                    }
                }
            }
        };
        this.lastLines = -1;
        this.isFixed = false;
        this.parentId = 0;
        this.mNativeContainer = nativeViewContainer;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mCurInputId = i3;
        setPadding(0, 0, 0, 0);
        this.screenHeight = DisplayUtil.getRealHeight(getContext());
        addKeyboardListener();
        addConfirmListener();
        setBackgroundDrawable(null);
        setHorizontallyScrolling(false);
        setVerticalScrollBarEnabled(false);
        setSingleLine(false);
        setInputType(IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_TCP_OPEN);
        setFocusable(true);
        setOnFocusChangeListener(new MyOnFocusChangeListener());
        setGlobalLayoutListener();
    }

    private void addConfirmListener() {
        NativeViewContainer nativeViewContainer = this.mNativeContainer;
        if (nativeViewContainer != null) {
            nativeViewContainer.addConfirmListener(this);
        }
    }

    private void addKeyboardListener() {
        KeyboardHiddenObserver keyboardHiddenObserver = new KeyboardHiddenObserver();
        this.mInputKeyboardListner.put(Integer.valueOf(this.mCurInputId), keyboardHiddenObserver);
        this.mNativeContainer.setSoftKeyboardStateListener(keyboardHiddenObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkHasNavBar(Activity activity) {
        if ((DisplayUtil.hasNavBar(activity) && DisplayUtil.isNavigationBarExist(activity)) || DisplayUtil.isFlymeOS7NavBarShow()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evaluateTextAreaHeightChange() {
        if (this.mNativeContainer != null) {
            try {
                EditInfo curEditInfo = getCurEditInfo();
                if (curEditInfo.getCurLine() != this.lastLines) {
                    this.lastLines = curEditInfo.getCurLine();
                    JSONObject jSONObject = new JSONObject();
                    int height = curEditInfo.getHeight();
                    int i3 = this.textAreaMinHeight;
                    if (i3 != 0) {
                        height = Math.max(i3, height);
                    }
                    int i16 = this.textAreaMaxHeight;
                    if (i16 != 0) {
                        height = Math.min(i16, height);
                    }
                    jSONObject.put("height", height / DisplayUtil.getDensity(getContext()));
                    jSONObject.put("lineCount", curEditInfo.getCurLine());
                    jSONObject.put("inputId", this.mCurInputId);
                    this.mNativeContainer.getPageWebviewContainer().evaluateSubscribeJS("onTextAreaHeightChange", jSONObject.toString());
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getCurrentActivity() {
        NativeViewContainer nativeViewContainer = this.mNativeContainer;
        if (nativeViewContainer != null && nativeViewContainer.getPageWebviewContainer() != null) {
            return this.mNativeContainer.getPageWebviewContainer().getAttachActivity();
        }
        return null;
    }

    private int getDefaultHeight(float f16) {
        Paint paint = new Paint();
        paint.setTextSize(f16 * DisplayUtil.getDensity(getContext()));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) (fontMetrics.descent - fontMetrics.ascent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSelectionPosition() {
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
        int i16 = this.textAreaMaxHeight;
        if (i16 != 0) {
            lineHeight = Math.min(lineHeight, i16);
        } else {
            int i17 = this.textAreaHeight;
            if (i17 != 0) {
                lineHeight = Math.min(lineHeight, i17);
            }
        }
        return lineHeight + this.marginBootom + this.confirmHeight;
    }

    private void hideCurrentInput(boolean z16) {
        PageWebviewContainer pageWebviewContainer;
        QMLog.d(TAG, "hideCurrentInput : " + isFocused());
        NativeViewContainer nativeViewContainer = this.mNativeContainer;
        if (nativeViewContainer != null) {
            pageWebviewContainer = nativeViewContainer.getPageWebviewContainer();
        } else {
            pageWebviewContainer = null;
        }
        if (pageWebviewContainer != null && isFocused()) {
            clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) pageWebviewContainer.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(pageWebviewContainer.getWindowToken(), 0);
            if (this.hasConfirm) {
                hideKeyBoardConfirmView();
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("inputId", this.mCurInputId);
                jSONObject.put("value", getText().toString());
                jSONObject.put("cursor", getText().toString().length());
                if (z16) {
                    pageWebviewContainer.evaluateSubscribeJS(InputJsPlugin.ON_KEYBOARD_CONFIRM_CALLBACK, jSONObject.toString());
                }
            } catch (Exception e16) {
                QMLog.e(TAG, "hideCurrentInput error", e16);
            }
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea.2
            @Override // java.lang.Runnable
            public void run() {
                QMLog.e(MiniAppTextArea.TAG, "hideCurrentInput set isFocused false");
                MiniAppTextArea.this.isFocused = false;
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideKeyBoardConfirmView() {
        NativeViewContainer nativeViewContainer = this.mNativeContainer;
        if (nativeViewContainer != null) {
            nativeViewContainer.hideKeyBoardConfirmView();
            removeConfirmListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideSoftKeyboard(boolean z16) {
        NativeViewContainer nativeViewContainer = this.mNativeContainer;
        if (nativeViewContainer != null) {
            nativeViewContainer.getPageWebviewContainer();
        }
        this.isKeyboardShow = false;
        hideKeyBoardConfirmView();
        hideCurrentInput(z16);
    }

    private boolean needUpdateLayoutParams(JSONObject jSONObject) {
        if (!jSONObject.has("width") && !jSONObject.has("height") && !jSONObject.has("left") && !jSONObject.has("top")) {
            return false;
        }
        return true;
    }

    private void removeConfirmListener() {
        NativeViewContainer nativeViewContainer = this.mNativeContainer;
        if (nativeViewContainer != null) {
            nativeViewContainer.removeConfirmListener(this);
        }
    }

    private void setGlobalLayoutListener() {
        this.globalLayoutListener = new MyOnGlobalLayoutListener();
        if (getViewTreeObserver() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showKeyBoardConfirmView(int i3) {
        NativeViewContainer nativeViewContainer = this.mNativeContainer;
        if (nativeViewContainer != null) {
            nativeViewContainer.showKeyBoardConfirmView(i3);
            addConfirmListener();
        }
    }

    private void updateCursor(JSONObject jSONObject) {
        int optInt;
        if (jSONObject.has("cursor") && (optInt = jSONObject.optInt("cursor", -1)) > 0) {
            setSelection(optInt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCursorPosition(int i3, int i16, int i17) {
        if (i3 > 0) {
            if (i16 > 0) {
                this.cursorPositation = i3;
            } else if (i17 > 0) {
                this.cursorPositation = i3 + i17;
            }
        }
    }

    private void updateFontWeight(JSONObject jSONObject) {
        if (jSONObject.has("fontWeight")) {
            if ("bold".equals(jSONObject.optString("fontWeight"))) {
                setTypeface(Typeface.defaultFromStyle(1));
            } else {
                setTypeface(Typeface.defaultFromStyle(0));
            }
        }
    }

    private void updateLayoutParams(JSONObject jSONObject, boolean z16) {
        int i3;
        if (needUpdateLayoutParams(jSONObject)) {
            int max = (int) Math.max((DisplayUtil.getDensity(getContext()) * jSONObject.optInt("width")) + 0.5f, 0.0f);
            int max2 = (int) Math.max((DisplayUtil.getDensity(getContext()) * jSONObject.optInt("height")) + 0.5f, 0.0f);
            this.textAreaHeight = max2;
            if (max2 == 0 && this.autoSize) {
                if (this.textAreaMinHeight == 0) {
                    if (jSONObject.has("fontSize")) {
                        i3 = jSONObject.optInt("fontSize");
                    } else {
                        i3 = 16;
                    }
                    this.textAreaMinHeight = getDefaultHeight(i3);
                }
                max2 = this.textAreaMinHeight;
                if (z16 && getLayout() != null && getLayout().getHeight() > this.textAreaMinHeight) {
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

    private void updateLength(JSONObject jSONObject) {
        int optInt;
        if (jSONObject.has("maxLength") && (optInt = jSONObject.optInt("maxLength")) > 0) {
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(optInt)});
        }
    }

    private void updatePlaceHolder(JSONObject jSONObject) {
        if (jSONObject.has("placeholder")) {
            String optString = jSONObject.optString("placeholder");
            if (!StringUtil.isEmpty(optString)) {
                setHint(optString);
            }
        }
        if (jSONObject.has("placeholderStyle")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
            this.placeholderStyle = optJSONObject;
            if (optJSONObject != null && optJSONObject.has("color")) {
                String optString2 = this.placeholderStyle.optString("color");
                if (!TextUtils.isEmpty(optString2)) {
                    setHintTextColor(ColorUtils.parseColor(optString2));
                }
            }
        }
    }

    private void updateSelection(JSONObject jSONObject) {
        if (jSONObject.has("selectionStart") || jSONObject.has("selectionEnd")) {
            int optInt = jSONObject.optInt("selectionStart", -1);
            int optInt2 = jSONObject.optInt("selectionEnd", -1);
            if (optInt != -1 && optInt2 != -1 && optInt2 > optInt) {
                setSelection(optInt, optInt2);
            }
        }
    }

    private void updateStyle(JSONObject jSONObject, boolean z16) {
        if (jSONObject.has(NodeProps.MARGIN_BOTTOM)) {
            this.marginBootom = (int) ((DisplayUtil.getDensity(getContext()) * jSONObject.optInt(NodeProps.MARGIN_BOTTOM)) + 0.5f);
        }
        if (jSONObject.has(NodeProps.MAX_HEIGHT)) {
            this.textAreaMaxHeight = (int) ((DisplayUtil.getDensity(getContext()) * jSONObject.optInt(NodeProps.MAX_HEIGHT)) + 0.5f);
        }
        if (jSONObject.has(NodeProps.MIN_HEIGHT)) {
            this.textAreaMinHeight = (int) ((DisplayUtil.getDensity(getContext()) * jSONObject.optInt(NodeProps.MIN_HEIGHT)) + 0.5f);
        }
        int i3 = this.textAreaMaxHeight;
        if (i3 != 0) {
            setMaxHeight(i3);
        }
        int i16 = this.textAreaMinHeight;
        if (i16 != 0) {
            setMinHeight(i16);
            setMinimumHeight(this.textAreaMinHeight);
            setMinimumWidth(0);
        }
        updateLayoutParams(jSONObject, z16);
        updateTextAlign(jSONObject);
        updateFontWeight(jSONObject);
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

    private void updateTextAlign(JSONObject jSONObject) {
        if (jSONObject.has("textAlign")) {
            String optString = jSONObject.optString("textAlign");
            if ("left".equals(optString)) {
                setGravity(3);
            } else if ("center".equals(optString)) {
                setGravity(1);
            } else if ("right".equals(optString)) {
                setGravity(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTextareaAnimator() {
        this.mHandler.removeCallbacks(this.translateRunable);
        this.mHandler.postDelayed(this.translateRunable, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTextareaHeight() {
        if (this.autoSize && getLayout() != null && getLayout().getHeight() > this.textAreaMinHeight) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            if (this.textAreaMaxHeight == 0 || getLayout().getHeight() <= this.textAreaMaxHeight) {
                layoutParams.height = getLayout().getHeight();
            }
            setLayoutParams(layoutParams);
        }
    }

    private void updateValue(JSONObject jSONObject) {
        if (jSONObject.has("value")) {
            String optString = jSONObject.optString("value");
            this.curValue = optString;
            setText(optString);
            if (!TextUtils.isEmpty(optString)) {
                int i3 = this.cursorPositation;
                if (i3 == -1) {
                    i3 = optString.length();
                }
                QMLog.d("miniapp-textarea", "updatevalue set cursor : " + i3);
                setSelection(i3);
            }
            this.cursorPositation = -1;
        }
    }

    public void callbackLineChange() {
        PageWebviewContainer pageWebviewContainer;
        NativeViewContainer nativeViewContainer = this.mNativeContainer;
        if (nativeViewContainer != null) {
            pageWebviewContainer = nativeViewContainer.getPageWebviewContainer();
        } else {
            pageWebviewContainer = null;
        }
        try {
            this.lastLines = 1;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("height", getLineHeight() / DisplayUtil.getDensity(getContext()));
            jSONObject.put("lineCount", 1);
            jSONObject.put("inputId", this.mCurInputId);
            if (pageWebviewContainer != null) {
                pageWebviewContainer.evaluateSubscribeJS("onTextAreaHeightChange", jSONObject.toString());
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "callbackLineChange error.", th5);
        }
    }

    public EditInfo getCurEditInfo() {
        EditInfo editInfo = new EditInfo();
        Layout layout = getLayout();
        if (layout != null) {
            editInfo.setCurLine(layout.getLineCount());
            editInfo.setHeight(layout.getHeight());
        }
        return editInfo;
    }

    public int getParentId() {
        return this.parentId;
    }

    public boolean isFixed() {
        return this.isFixed;
    }

    public boolean isTextAreaFocused() {
        return this.isFocused;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.NativeViewContainer.IConfirmListerner
    public void onConfirm() {
        hideSoftKeyboard(true);
    }

    public void removeGlobalLayoutListener() {
        if (getViewTreeObserver() != null && this.globalLayoutListener != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        }
    }

    public void removeKeyboardListener() {
        SoftKeyboardStateHelper.SoftKeyboardStateListener softKeyboardStateListener = this.mInputKeyboardListner.get(Integer.valueOf(this.mCurInputId));
        if (softKeyboardStateListener != null) {
            this.mNativeContainer.removeSoftKeyboardStateListener(softKeyboardStateListener);
        }
    }

    public void setAttributes(JSONObject jSONObject, boolean z16, NativeViewRequestEvent nativeViewRequestEvent) {
        if (jSONObject.has("data")) {
            this.data = jSONObject.optString("data");
        }
        int i3 = 0;
        if (jSONObject.has("autoSize")) {
            this.autoSize = jSONObject.optBoolean("autoSize", false);
        }
        if (jSONObject.has("adjustPosition")) {
            this.adjustPosition = jSONObject.optBoolean("adjustPosition", false);
        }
        if (jSONObject.has(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM)) {
            this.hasConfirm = jSONObject.optBoolean(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, true);
        }
        if (jSONObject.has("disabled")) {
            boolean optBoolean = jSONObject.optBoolean("disabled", false);
            this.disable = optBoolean;
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
        updateValue(jSONObject);
        updateLength(jSONObject);
        updatePlaceHolder(jSONObject);
        updateSelection(jSONObject);
        updateCursor(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            this.style = optJSONObject;
            updateStyle(optJSONObject, z16);
        }
        addTextChangedListener(new MyTextWatcher(optJSONObject, nativeViewRequestEvent));
    }

    public void setFixed(boolean z16) {
        this.isFixed = z16;
    }

    public void setParentId(int i3) {
        this.parentId = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class MyTextWatcher implements TextWatcher {
        private final NativeViewRequestEvent req;
        private final JSONObject style;

        public MyTextWatcher(JSONObject jSONObject, NativeViewRequestEvent nativeViewRequestEvent) {
            this.style = jSONObject;
            this.req = nativeViewRequestEvent;
        }

        private void updateStyle(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() == 0) {
                if (MiniAppTextArea.this.placeholderStyle != null) {
                    MiniAppTextArea.this.setTextSize(2, r5.placeholderStyle.optInt("fontSize"));
                    MiniAppTextArea miniAppTextArea = MiniAppTextArea.this;
                    miniAppTextArea.setTextColor(ColorUtils.parseColor(miniAppTextArea.placeholderStyle.optString("color")));
                    return;
                }
                return;
            }
            if (this.style != null) {
                MiniAppTextArea.this.setTextSize(2, r5.optInt("fontSize"));
                MiniAppTextArea.this.setTextColor(ColorUtils.parseColor(this.style.optString("color")));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            MiniAppTextArea.this.updateCursorPosition(i3, i16, i17);
            updateStyle(charSequence);
            MiniAppTextArea.this.updateTextareaAnimator();
            MiniAppTextArea.this.updateTextareaHeight();
            MiniAppTextArea.this.evaluateTextAreaHeightChange();
            if (charSequence != null && !charSequence.toString().equals(MiniAppTextArea.this.curValue)) {
                JSONObject jSONObject = new JSONObject();
                MiniAppTextArea.this.curValue = charSequence.toString();
                try {
                    jSONObject.put("inputId", MiniAppTextArea.this.mCurInputId);
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
                    jSONObject.put("value", MiniAppTextArea.this.curValue);
                    if (i16 != 0 && i17 == 0) {
                        jSONObject.put("keyCode", 8);
                    } else {
                        jSONObject.put("keyCode", (int) charSequence.charAt((i3 + i17) - 1));
                    }
                    jSONObject.put("data", MiniAppTextArea.this.data);
                    this.req.sendSubscribeJs(h.g.NAME, jSONObject.toString(), MiniAppTextArea.this.mNativeContainer.getWebviewId());
                } catch (Exception e16) {
                    QMLog.e(MiniAppTextArea.TAG, "onTextChanged error", e16);
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
