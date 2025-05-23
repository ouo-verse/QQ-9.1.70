package com.tencent.mtt.hippy.views.textinput;

import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.common.CommonBackgroundDrawable;
import com.tencent.mtt.hippy.views.common.CommonBorder;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyTextInput extends EditText implements View.OnFocusChangeListener, TextView.OnEditorActionListener, HippyViewBase, CommonBorder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public boolean bUserSetValue;
    final ViewTreeObserver.OnGlobalLayoutListener globaListener;
    private final int mDefaultGravityHorizontal;
    private final int mDefaultGravityVertical;
    boolean mHasAddWatcher;
    boolean mHasSetOnSelectListener;
    final HippyEngineContext mHippyContext;
    private boolean mIsKeyBoardShow;
    private int mLastRootViewVisibleHeight;
    private String mPreviousText;
    private CommonBackgroundDrawable mReactBackgroundDrawable;
    private ReactContentSizeWatcher mReactContentSizeWatcher;
    private final Rect mRect;
    private boolean mTextInputed;
    TextWatcher mTextWatcher;
    private String mValidator;
    private String sRegrexValidBefore;
    private String sRegrexValidRepeat;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class ReactContentSizeWatcher {
        private final EditText mEditText;
        final HippyEngineContext mHippyContext;
        private int mPreviousContentWidth = 0;
        private int mPreviousContentHeight = 0;

        public ReactContentSizeWatcher(EditText editText, HippyEngineContext hippyEngineContext) {
            this.mEditText = editText;
            this.mHippyContext = hippyEngineContext;
        }

        public void onLayout() {
            int width = this.mEditText.getWidth();
            int height = this.mEditText.getHeight();
            if (this.mEditText.getLayout() != null) {
                height = 0;
                if (this.mEditText.getCompoundPaddingLeft() + this.mEditText.getLayout().getWidth() < 0) {
                    width = 0;
                } else {
                    width = this.mEditText.getLayout().getWidth() + this.mEditText.getCompoundPaddingRight();
                }
                if (this.mEditText.getCompoundPaddingTop() + this.mEditText.getLayout().getHeight() >= 0) {
                    height = this.mEditText.getLayout().getHeight() + this.mEditText.getCompoundPaddingBottom();
                }
            }
            if (width != this.mPreviousContentWidth || height != this.mPreviousContentHeight) {
                this.mPreviousContentHeight = height;
                this.mPreviousContentWidth = width;
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushDouble("width", this.mPreviousContentWidth);
                hippyMap.pushDouble("height", this.mPreviousContentWidth);
                HippyMap hippyMap2 = new HippyMap();
                hippyMap2.pushMap("contentSize", hippyMap);
                ((EventDispatcher) this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(HippyTextInput.this.getId(), "onContentSizeChange", hippyMap2);
            }
        }
    }

    public HippyTextInput(Context context) {
        super(context);
        this.mHasAddWatcher = false;
        this.mTextWatcher = null;
        this.mHasSetOnSelectListener = false;
        this.mRect = new Rect();
        this.mLastRootViewVisibleHeight = -1;
        this.mIsKeyBoardShow = false;
        this.mReactContentSizeWatcher = null;
        this.globaListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mtt.hippy.views.textinput.HippyTextInput.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int rootViewHeight = HippyTextInput.this.getRootViewHeight();
                int screenHeight = HippyTextInput.this.getScreenHeight();
                if (rootViewHeight != -1 && screenHeight != -1) {
                    if (HippyTextInput.this.mLastRootViewVisibleHeight == -1) {
                        if (rootViewHeight <= screenHeight * 0.8f) {
                            if (!HippyTextInput.this.mIsKeyBoardShow) {
                                HippyMap hippyMap = new HippyMap();
                                hippyMap.pushInt("keyboardHeight", Math.abs(screenHeight - rootViewHeight));
                                ((EventDispatcher) HippyTextInput.this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(HippyTextInput.this.getId(), "onKeyboardWillShow", hippyMap);
                            }
                            HippyTextInput.this.mIsKeyBoardShow = true;
                        }
                        HippyTextInput.this.mIsKeyBoardShow = false;
                    } else if (rootViewHeight > screenHeight * 0.8f) {
                        if (HippyTextInput.this.mIsKeyBoardShow) {
                            ((EventDispatcher) HippyTextInput.this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(HippyTextInput.this.getId(), "onKeyboardWillHide", new HippyMap());
                        }
                        HippyTextInput.this.mIsKeyBoardShow = false;
                    } else {
                        if (!HippyTextInput.this.mIsKeyBoardShow) {
                            HippyMap hippyMap2 = new HippyMap();
                            hippyMap2.pushInt("keyboardHeight", Math.abs(HippyTextInput.this.mLastRootViewVisibleHeight - rootViewHeight));
                            ((EventDispatcher) HippyTextInput.this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(HippyTextInput.this.getId(), "onKeyboardWillShow", hippyMap2);
                        }
                        HippyTextInput.this.mIsKeyBoardShow = true;
                    }
                }
                HippyTextInput.this.mLastRootViewVisibleHeight = rootViewHeight;
            }
        };
        this.mValidator = "";
        this.sRegrexValidBefore = "";
        this.sRegrexValidRepeat = "";
        this.mTextInputed = false;
        this.bUserSetValue = false;
        this.mHippyContext = ((HippyInstanceContext) context).getEngineContext();
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOverScrollMode(1);
        this.mDefaultGravityHorizontal = getGravity() & 8388615;
        this.mDefaultGravityVertical = getGravity() & 112;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setPadding(0, 0, 0, 0);
    }

    private CommonBackgroundDrawable getOrCreateReactViewBackground() {
        if (this.mReactBackgroundDrawable == null) {
            this.mReactBackgroundDrawable = new CommonBackgroundDrawable();
            Drawable background = getBackground();
            super.setBackgroundDrawable(null);
            if (background == null) {
                super.setBackgroundDrawable(this.mReactBackgroundDrawable);
            } else {
                super.setBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, background}));
            }
        }
        return this.mReactBackgroundDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRootViewHeight() {
        View rootView = getRootView();
        if (rootView == null) {
            return -1;
        }
        try {
            rootView.getWindowVisibleDisplayFrame(this.mRect);
        } catch (Throwable th5) {
            LogUtils.d("InputMethodStatusMonitor:", "getWindowVisibleDisplayFrame failed !" + th5);
            th5.printStackTrace();
        }
        Rect rect = this.mRect;
        int i3 = rect.bottom - rect.top;
        if (i3 < 0) {
            return -1;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getScreenHeight() {
        try {
            WindowManager windowManager = (WindowManager) ContextHolder.getAppContext().getSystemService("window");
            if (windowManager.getDefaultDisplay() != null) {
                return Math.max(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
            }
            return -1;
        } catch (SecurityException e16) {
            LogUtils.d("HippyTextInput", "getScreenHeight: " + e16.getMessage());
            return -1;
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
    }

    public InputMethodManager getInputMethodManager() {
        return (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
    }

    public void hideInputMethod() {
        InputMethodManager inputMethodManager = getInputMethodManager();
        if (inputMethodManager != null && inputMethodManager.isActive(this)) {
            try {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public HippyMap jsGetValue() {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("text", getText().toString());
        return hippyMap;
    }

    public HippyMap jsIsFocused() {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushBoolean("value", hasFocus());
        return hippyMap;
    }

    public void jsSetValue(String str, int i3) {
        this.bUserSetValue = true;
        setText(str);
        if (str != null) {
            if (i3 < 0) {
                i3 = str.length();
            }
            if (i3 >= str.length()) {
                i3 = str.length();
            }
            setSelection(i3);
        }
        this.bUserSetValue = false;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getRootView() != null) {
            getRootView().getViewTreeObserver().addOnGlobalLayoutListener(this.globaListener);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getRootView() != null) {
            getRootView().getViewTreeObserver().removeOnGlobalLayoutListener(this.globaListener);
        }
    }

    @Override // android.widget.TextView
    public void onEditorAction(int i3) {
        String str;
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("actionCode", i3);
        hippyMap.pushString("text", getText().toString());
        switch (i3) {
            case 1:
                str = "none";
                break;
            case 2:
                str = ResourceAttributes.TelemetrySdkLanguageValues.GO;
                break;
            case 3:
                str = "search";
                break;
            case 4:
                str = "send";
                break;
            case 5:
                str = "next";
                break;
            case 6:
                str = "done";
                break;
            case 7:
                str = "previous";
                break;
            default:
                str = "unknown";
                break;
        }
        hippyMap.pushString("actionName", str);
        ((EventDispatcher) this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), "onEditorAction", hippyMap);
        super.onEditorAction(i3);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z16) {
        EventDispatcher eventDispatcher;
        int id5;
        String str;
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("text", getText().toString());
        if (z16) {
            eventDispatcher = (EventDispatcher) this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class);
            id5 = getId();
            str = "onFocus";
        } else {
            eventDispatcher = (EventDispatcher) this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class);
            id5 = getId();
            str = "onBlur";
        }
        eventDispatcher.receiveUIComponentEvent(id5, str, hippyMap);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        ReactContentSizeWatcher reactContentSizeWatcher = this.mReactContentSizeWatcher;
        if (reactContentSizeWatcher != null) {
            reactContentSizeWatcher.onLayout();
        }
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i3, int i16) {
        super.onSelectionChanged(i3, i16);
        if (this.mHasSetOnSelectListener) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("start", i3);
            hippyMap.pushInt("end", i16);
            HippyMap hippyMap2 = new HippyMap();
            hippyMap2.pushMap("selection", hippyMap);
            ((EventDispatcher) this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), "onSelectionChange", hippyMap2);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        super.onTextChanged(charSequence, i3, i16, i17);
        ReactContentSizeWatcher reactContentSizeWatcher = this.mReactContentSizeWatcher;
        if (reactContentSizeWatcher != null) {
            reactContentSizeWatcher.onLayout();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (i3 == 0 && this.mReactBackgroundDrawable == null) {
            LogUtils.d("HippyTextInput", "don't do anything, no need to allocate ReactBackgroundDrawable for transparent background");
        } else {
            getOrCreateReactViewBackground().setBackgroundColor(i3);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public void setBlurOrOnFocus(boolean z16) {
        if (z16) {
            setOnFocusChangeListener(this);
        } else {
            setOnFocusChangeListener(null);
        }
    }

    @Override // com.tencent.mtt.supportui.views.IBorder
    public void setBorderColor(int i3, int i16) {
        getOrCreateReactViewBackground().setBorderColor(i3, i16);
    }

    @Override // com.tencent.mtt.supportui.views.IBorder
    public void setBorderRadius(float f16, int i3) {
        getOrCreateReactViewBackground().setBorderRadius(f16, i3);
    }

    @Override // com.tencent.mtt.supportui.views.IBorder
    public void setBorderWidth(float f16, int i3) {
        getOrCreateReactViewBackground().setBorderWidth(f16, i3);
    }

    public void setCursorColor(int i3) {
        BlendMode blendMode;
        int i16 = Build.VERSION.SDK_INT;
        if (i16 == 28) {
            return;
        }
        if (i16 >= 29) {
            Drawable textCursorDrawable = getTextCursorDrawable();
            if (textCursorDrawable != null) {
                blendMode = BlendMode.SRC_IN;
                textCursorDrawable.setColorFilter(new BlendModeColorFilter(i3, blendMode));
                setTextCursorDrawable(textCursorDrawable);
                return;
            }
            return;
        }
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i17 = declaredField.getInt(this);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(this);
            Drawable drawable = getContext().getDrawable(i17);
            if (drawable == null) {
                return;
            }
            drawable.setColorFilter(i3, PorterDuff.Mode.SRC_IN);
            for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                try {
                    if (i16 >= 28) {
                        Field declaredField3 = cls.getDeclaredField("mDrawableForCursor");
                        declaredField3.setAccessible(true);
                        declaredField3.set(obj, drawable);
                    } else {
                        Field declaredField4 = cls.getDeclaredField("mCursorDrawable");
                        declaredField4.setAccessible(true);
                        declaredField4.set(obj, new Drawable[]{drawable, drawable});
                    }
                    return;
                } catch (Throwable th5) {
                    LogUtils.d("HippyTextInput", "setCursorColor: " + th5.getMessage());
                }
            }
        } catch (Throwable th6) {
            LogUtils.d("HippyTextInput", "setCursorColor: " + th6.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGravityHorizontal(int i3) {
        if (i3 == 0) {
            i3 = this.mDefaultGravityHorizontal;
        }
        setGravity(i3 | (getGravity() & (-8) & (-8388616)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGravityVertical(int i3) {
        if (i3 == 0) {
            i3 = this.mDefaultGravityVertical;
        }
        setGravity(i3 | (getGravity() & (-113)));
    }

    public void setOnChangeListener(boolean z16) {
        if (z16) {
            if (this.mHasAddWatcher) {
                return;
            }
            TextWatcher textWatcher = new TextWatcher() { // from class: com.tencent.mtt.hippy.views.textinput.HippyTextInput.2
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    HippyTextInput hippyTextInput = HippyTextInput.this;
                    hippyTextInput.layout(hippyTextInput.getLeft(), HippyTextInput.this.getTop(), HippyTextInput.this.getRight(), HippyTextInput.this.getBottom());
                    if (TextUtils.isEmpty(HippyTextInput.this.mValidator)) {
                        if (HippyTextInput.this.mTextInputed && TextUtils.equals(editable.toString(), HippyTextInput.this.mPreviousText)) {
                            return;
                        }
                        HippyTextInput.this.mPreviousText = editable.toString();
                        HippyTextInput.this.mTextInputed = true;
                        if (!HippyTextInput.this.bUserSetValue) {
                            HippyMap hippyMap = new HippyMap();
                            hippyMap.pushString("text", editable.toString());
                            ((EventDispatcher) HippyTextInput.this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(HippyTextInput.this.getId(), "onChangeText", hippyMap);
                            LogUtils.d("robinsli", "afterTextChanged \u901a\u77e5\u524d\u7aef\u6587\u672c\u53d8\u5316=" + editable.toString());
                            return;
                        }
                        return;
                    }
                    try {
                        if (!editable.toString().matches(HippyTextInput.this.mValidator) && !"".equals(editable.toString())) {
                            LogUtils.d("robinsli", "afterTextChanged \u4e0d\u7b26\u5408\u6b63\u5219\u8868\u8fbe\u5f0f,\u9700\u8981\u8bbe\u7f6e\u56de\u53bb=" + editable.toString());
                            HippyTextInput hippyTextInput2 = HippyTextInput.this;
                            hippyTextInput2.setText(hippyTextInput2.sRegrexValidBefore);
                            HippyTextInput hippyTextInput3 = HippyTextInput.this;
                            hippyTextInput3.sRegrexValidRepeat = hippyTextInput3.sRegrexValidBefore;
                            HippyTextInput hippyTextInput4 = HippyTextInput.this;
                            hippyTextInput4.setSelection(hippyTextInput4.getText().toString().length());
                            HippyTextInput.this.mTextInputed = true;
                            return;
                        }
                        if (!HippyTextInput.this.mTextInputed || !TextUtils.equals(editable.toString(), HippyTextInput.this.mPreviousText)) {
                            HippyTextInput.this.mTextInputed = true;
                            HippyTextInput.this.mPreviousText = editable.toString();
                            HippyTextInput hippyTextInput5 = HippyTextInput.this;
                            if (!hippyTextInput5.bUserSetValue) {
                                if (TextUtils.isEmpty(hippyTextInput5.sRegrexValidRepeat) || !TextUtils.equals(HippyTextInput.this.sRegrexValidRepeat, HippyTextInput.this.mPreviousText)) {
                                    HippyMap hippyMap2 = new HippyMap();
                                    hippyMap2.pushString("text", editable.toString());
                                    ((EventDispatcher) HippyTextInput.this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(HippyTextInput.this.getId(), "onChangeText", hippyMap2);
                                    LogUtils.d("robinsli", "afterTextChanged \u901a\u77e5\u524d\u7aef\u6587\u672c\u53d8\u5316=" + editable.toString());
                                    HippyTextInput.this.sRegrexValidRepeat = "";
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                    HippyTextInput.this.sRegrexValidBefore = charSequence.toString();
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                }
            };
            this.mTextWatcher = textWatcher;
            this.mHasAddWatcher = true;
            addTextChangedListener(textWatcher);
            return;
        }
        this.mHasAddWatcher = false;
        removeTextChangedListener(this.mTextWatcher);
    }

    public void setOnContentSizeChange(boolean z16) {
        ReactContentSizeWatcher reactContentSizeWatcher;
        if (z16) {
            reactContentSizeWatcher = new ReactContentSizeWatcher(this, this.mHippyContext);
        } else {
            reactContentSizeWatcher = null;
        }
        this.mReactContentSizeWatcher = reactContentSizeWatcher;
    }

    public void setOnEndEditingListener(boolean z16) {
        if (z16) {
            setOnEditorActionListener(this);
        } else {
            setOnEditorActionListener(null);
        }
    }

    public void setOnSelectListener(boolean z16) {
        this.mHasSetOnSelectListener = z16;
    }

    public void setValidator(String str) {
        this.mValidator = str;
    }

    public void showInputMethodManager() {
        try {
            getInputMethodManager().showSoftInput(this, 0, null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        if ((i3 & 255) > 0 || i3 == 0) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString("text", getText().toString());
            ((EventDispatcher) this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), "onEndEditing", hippyMap);
        }
        EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
        return false;
    }

    @Override // com.tencent.mtt.supportui.views.IBorder
    public void setBorderStyle(int i3) {
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
    }
}
