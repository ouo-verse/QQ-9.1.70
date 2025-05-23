package com.tencent.mobileqq.widget.search;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.view.AutoHintLayout;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.search.SearchController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableView;
import com.tencent.util.InputMethodUtil;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUISearchBar extends ConstraintLayout implements View.OnClickListener, f, SearchController.ISupportAction, SkinnableView {
    private static final String TAG = "QUISearchBar";
    private ActionCallback mActionCallback;
    private boolean mAutoFocusable;
    private int mChainKey;
    private SearchController mController;
    private int mCurColorType;
    private int mCurStyle;
    private int mCurThemeId;
    private QUISearchBarResource mCustomResource;
    private AbsQUISearchBarStyler mDefStyler;
    QuickPinyinEditText mEtInput;
    FrameLayout mFlSearchExt;
    private boolean mIsDown;
    private boolean mIsFinishLayout;
    ImageView mIvBack;
    ImageView mIvClear;
    private e mKeyboardStateHelper;
    AutoHintLayout mLlAutoHint;
    private View.OnClickListener mOnClickListener;
    private BaseSearchBarLayoutExt mSearchExt;
    private int mSearchMode;
    private SparseArray<AbsQUISearchBarStyler> mStylerSArray;
    TextView mTvCancel;
    View mVInputBg;

    /* compiled from: P */
    @UiThread
    /* loaded from: classes20.dex */
    public interface ActionCallback {
        boolean onBack();

        int onCancel();

        boolean onClear();

        void onSearch();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements TextView.OnEditorActionListener {
        b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            boolean z16 = true;
            if (!QUISearchBar.this.mSearchExt.onEditorAction(textView, i3, keyEvent)) {
                if (QUISearchBar.this.mSearchMode == 0 && (i3 == 3 || (keyEvent != null && keyEvent.getKeyCode() == 66))) {
                    if (keyEvent == null || keyEvent.getAction() == 1) {
                        QUISearchBar.this.doSearchAction();
                    }
                } else {
                    z16 = false;
                }
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c extends View.AccessibilityDelegate {
        c() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setVisibleToUser(view.isFocusable());
            accessibilityNodeInfo.setContentDescription(view.getContentDescription());
        }
    }

    public QUISearchBar(@NonNull Context context) {
        this(context, null);
    }

    private void checkRunOnMain(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    private void doClearAction() {
        ActionCallback actionCallback = this.mActionCallback;
        if (actionCallback != null && actionCallback.onClear()) {
            return;
        }
        this.mEtInput.setText("");
        this.mEtInput.requestFocus();
        InputMethodUtil.show(this.mEtInput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSearchAction() {
        ActionCallback actionCallback = this.mActionCallback;
        if (actionCallback != null) {
            if (this.mSearchMode == 0) {
                InputMethodUtil.hide(this.mEtInput);
            }
            actionCallback.onSearch();
        }
    }

    private void handleAccessibility() {
        AccessibilityUtil.c(this.mIvBack, getContext().getString(R.string.f170549u3), Button.class.getName());
        setAccessibilityFocusable(this.mTvCancel, true);
        TextView textView = this.mTvCancel;
        AccessibilityUtil.c(textView, textView.getText(), Button.class.getName());
        AccessibilityUtil.c(this.mIvClear, getContext().getString(R.string.a3k), Button.class.getName());
        String string = getContext().getString(R.string.h_a);
        setContentDescription(string);
        this.mEtInput.setContentDescription(string);
        updateAccessibility();
    }

    private void handleListener() {
        this.mIvBack.setOnClickListener(this);
        this.mIvClear.setOnClickListener(this);
        this.mTvCancel.setOnClickListener(this);
        this.mEtInput.addTextChangedListener(new a());
        this.mEtInput.setImeOptions(MessageStruct.MSG_RECORD_BEGIN_SUCCESS_CALLBACK);
        this.mEtInput.setOnEditorActionListener(new b());
        setClickable(true);
    }

    private void initAttrs(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.Z5);
        this.mCurStyle = obtainStyledAttributes.getInteger(jj2.b.f410013c6, 3);
        this.mCurThemeId = obtainStyledAttributes.getInteger(jj2.b.f410025d6, 1000);
        this.mCurColorType = obtainStyledAttributes.getInteger(jj2.b.f410001b6, 0);
        this.mAutoFocusable = obtainStyledAttributes.getBoolean(jj2.b.f409989a6, true);
        obtainStyledAttributes.recycle();
    }

    private void initStyler() {
        this.mStylerSArray = new SparseArray<>(5);
        this.mDefStyler = new QUISearchBarStyler03(this);
        this.mStylerSArray.append(1, new QUISearchBarStyler01(this));
        this.mStylerSArray.append(2, new QUISearchBarStyler02(this));
        this.mStylerSArray.append(3, this.mDefStyler);
        this.mStylerSArray.append(4, new QUISearchBarStyler04(this));
        this.mStylerSArray.append(5, new com.tencent.mobileqq.widget.search.b(this));
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hg7, (ViewGroup) this, true);
        this.mIvBack = (ImageView) findViewById(R.id.f657839v);
        this.mIvClear = (ImageView) findViewById(R.id.f65943_a);
        this.mTvCancel = (TextView) findViewById(R.id.f658039x);
        this.mLlAutoHint = (AutoHintLayout) findViewById(R.id.f66013_h);
        this.mEtInput = (QuickPinyinEditText) findViewById(R.id.f66003_g);
        this.mVInputBg = findViewById(R.id.f65993_f);
        this.mFlSearchExt = (FrameLayout) findViewById(R.id.f66423al);
        QuickPinyinEditText quickPinyinEditText = this.mEtInput;
        quickPinyinEditText.mMaxTextLen = 50;
        quickPinyinEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        int dpToPx = ViewUtils.dpToPx(60.0f);
        setMinHeight(dpToPx);
        setMaxHeight(dpToPx);
        handleListener();
        handleAccessibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fixedKeyboardBugOnAndroid678$0(View view, MotionEvent motionEvent) {
        if (!this.mEtInput.isFocusable()) {
            this.mEtInput.setFocusable(true);
            this.mEtInput.setFocusableInTouchMode(true);
            InputMethodUtil.show(this.mEtInput);
            return false;
        }
        return false;
    }

    public static void setAccessibilityFocusable(View view, boolean z16) {
        view.setFocusable(z16);
        if (z16) {
            ViewCompat.setImportantForAccessibility(view, 1);
        } else {
            ViewCompat.setImportantForAccessibility(view, 2);
        }
        view.setAccessibilityDelegate(new c());
    }

    private void updateAccessibility() {
        boolean z16;
        if (this.mOnClickListener != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        setAccessibilityFocusable(this, z16);
        setAccessibilityFocusable(this.mEtInput, !z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateColorByTheme() {
        findQUISearchBarStyler().updateTheme(this.mCurThemeId, this.mCurColorType);
        this.mSearchExt.onUpdateTheme(this.mCurThemeId, this.mCurColorType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateColorByThemeAndColorType() {
        findQUISearchBarStyler().updateOnlyThemeWithColorType(this.mCurThemeId, this.mCurColorType);
        this.mSearchExt.onUpdateColorType(this.mCurThemeId, this.mCurColorType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUIDetailByStyleAndState() {
        findQUISearchBarStyler().updateLayout();
        this.mSearchExt.onUpdateLayout(this.mCurStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewVisibility(View view, int i3) {
        if (view.getVisibility() == i3) {
            return;
        }
        view.setVisibility(i3);
    }

    public void bindSearchChain(final int i3, final boolean z16) {
        this.mChainKey = i3;
        checkRunOnMain(new Runnable() { // from class: com.tencent.mobileqq.widget.search.QUISearchBar.8
            @Override // java.lang.Runnable
            public void run() {
                QUISearchBar.this.mController = SearchController.getInstance(i3);
                if (z16) {
                    QUISearchBar.this.mController.setAnchorView(QUISearchBar.this);
                } else {
                    QUISearchBar.this.mController.addNodeView(QUISearchBar.this);
                }
            }
        });
    }

    public void disableAutoFill() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        try {
            View.class.getMethod("setImportantForAutofill", Integer.TYPE).invoke(this.mEtInput, 8);
        } catch (Exception e16) {
            QLog.w(TAG, 2, "disable auto fill error", e16);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!super.dispatchHoverEvent(motionEvent) && this.mOnClickListener == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.widget.search.SearchController.ISupportAction
    public void doBackAction() {
        ActionCallback actionCallback = this.mActionCallback;
        if (actionCallback != null && actionCallback.onBack()) {
            return;
        }
        InputMethodUtil.hide(this.mEtInput);
        SearchController.defaultBackAction(this, this.mController);
    }

    @Override // com.tencent.mobileqq.widget.search.SearchController.ISupportAction
    public void doCancelAction() {
        int i3;
        ActionCallback actionCallback = this.mActionCallback;
        boolean z16 = false;
        if (actionCallback != null) {
            i3 = actionCallback.onCancel();
        } else {
            i3 = 0;
        }
        if (i3 == 2) {
            return;
        }
        InputMethodUtil.hide(this.mEtInput);
        SearchController searchController = this.mController;
        if (i3 == 1) {
            z16 = true;
        }
        SearchController.defaultCancelAction(this, searchController, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public AbsQUISearchBarStyler findQUISearchBarStyler() {
        return findQUISearchBarStyler(this.mCurStyle);
    }

    public void fixedKeyboardBugOnAndroid678() {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        this.mEtInput.setFocusable(false);
        this.mEtInput.setFocusableInTouchMode(false);
        this.mEtInput.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.widget.search.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean lambda$fixedKeyboardBugOnAndroid678$0;
                lambda$fixedKeyboardBugOnAndroid678$0 = QUISearchBar.this.lambda$fixedKeyboardBugOnAndroid678$0(view, motionEvent);
                return lambda$fixedKeyboardBugOnAndroid678$0;
            }
        });
    }

    @Override // com.tencent.mobileqq.widget.search.SearchController.ISupportAction
    public Context getAttachContext() {
        return getContext();
    }

    public AutoHintLayout getAutoHintLayout() {
        return this.mLlAutoHint;
    }

    public ImageView getBackView() {
        return this.mIvBack;
    }

    public TextView getCancelView() {
        return this.mTvCancel;
    }

    public ImageView getClearView() {
        return this.mIvClear;
    }

    public int getCurColorType() {
        return this.mCurColorType;
    }

    public int getCurStyle() {
        return this.mCurStyle;
    }

    public int getCurThemeId() {
        return this.mCurThemeId;
    }

    @NonNull
    public QUISearchBarResource getCustomResource() {
        QUISearchBarResource qUISearchBarResource = this.mCustomResource;
        if (qUISearchBarResource == null) {
            return QUISearchBarResource.DEFAULT_RES;
        }
        return qUISearchBarResource;
    }

    public int getExtWidth() {
        return this.mSearchExt.getLayoutWidthInPx(this.mCurStyle);
    }

    public FrameLayout getFlSearchExt() {
        return this.mFlSearchExt;
    }

    public View getInputBg() {
        return this.mVInputBg;
    }

    public QuickPinyinEditText getInputWidget() {
        return this.mEtInput;
    }

    public SearchController getSearchController() {
        return this.mController;
    }

    public boolean hasOnClickListener() {
        if (this.mOnClickListener != null) {
            return true;
        }
        return false;
    }

    public boolean isAutoFocusable() {
        return this.mAutoFocusable;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        boolean z16;
        super.onAttachedToWindow();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onAttachedToWindow(");
        sb5.append(hashCode());
        sb5.append(")   mController == null:");
        if (this.mController == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append("   mChainKey:");
        sb5.append(this.mChainKey);
        QLog.i(TAG, 4, sb5.toString());
        if (this.mKeyboardStateHelper == null) {
            e eVar = new e(this, false);
            this.mKeyboardStateHelper = eVar;
            eVar.c(this);
        }
        if (!this.mIsFinishLayout) {
            onFinishInflate();
        }
        int i3 = this.mChainKey;
        if (i3 != -1 && this.mController == null) {
            SearchController searchController = SearchController.getInstance(i3);
            this.mController = searchController;
            searchController.addNodeView(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f657839v) {
            doBackAction();
        } else if (id5 == R.id.f65943_a) {
            doClearAction();
        } else if (id5 == R.id.f658039x) {
            doCancelAction();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        boolean z16;
        super.onDetachedFromWindow();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onDetachedFromWindow(");
        sb5.append(hashCode());
        sb5.append(")   mController == null:");
        if (this.mController == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append("   mChainKey:");
        sb5.append(this.mChainKey);
        QLog.i(TAG, 4, sb5.toString());
        this.mSearchExt.onDetachView();
        e eVar = this.mKeyboardStateHelper;
        if (eVar != null) {
            eVar.k();
            this.mKeyboardStateHelper = null;
        }
        SearchController searchController = this.mController;
        if (searchController != null) {
            searchController.removeNodeView(this);
            this.mController = null;
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mIsFinishLayout = true;
        updateUIDetailByStyleAndState();
        updateColorByTheme();
        this.mSearchExt.onInitLeftView(this.mFlSearchExt, this.mCurStyle, this.mCurThemeId, this.mCurColorType);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!super.onInterceptTouchEvent(motionEvent) && this.mOnClickListener == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.widget.search.f
    public void onSoftKeyboardClosed() {
        this.mEtInput.setCursorVisible(false);
        this.mLlAutoHint.onSoftKeyboardClosed();
    }

    @Override // com.tencent.mobileqq.widget.search.f
    public void onSoftKeyboardOpened(int i3) {
        this.mEtInput.setCursorVisible(true);
        this.mLlAutoHint.onSoftKeyboardOpened(i3);
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        QLog.i(TAG, 1, "onThemeChanged, mCurThemeId:" + this.mCurThemeId);
        if (this.mCurThemeId == 1000) {
            updateColorByTheme();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        if (r3 != 3) goto L17;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener == null) {
            QLog.d(TAG, 1, "avoid passing touch event through when click listener is null");
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (this.mIsDown) {
                    onClickListener.onClick(this);
                }
            }
            this.mIsDown = false;
        } else {
            this.mIsDown = true;
        }
        return true;
    }

    public void setActionCallback(ActionCallback actionCallback) {
        this.mActionCallback = actionCallback;
    }

    public void setColorType(int i3) {
        if (this.mCurColorType == i3) {
            return;
        }
        this.mCurColorType = i3;
        checkRunOnMain(new Runnable() { // from class: com.tencent.mobileqq.widget.search.QUISearchBar.7
            @Override // java.lang.Runnable
            public void run() {
                QUISearchBar.this.updateColorByThemeAndColorType();
            }
        });
    }

    public void setCustomResource(@Nullable QUISearchBarResource qUISearchBarResource) {
        setCustomResource(qUISearchBarResource, true);
    }

    public void setEtInputHint(String str) {
        QuickPinyinEditText quickPinyinEditText = this.mEtInput;
        if (quickPinyinEditText != null) {
            quickPinyinEditText.setHint(str);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
        QLog.d(TAG, 1, "setOnClickListener : l = " + onClickListener);
        updateAccessibility();
    }

    public void setSearchBarLayoutExt(@NonNull BaseSearchBarLayoutExt baseSearchBarLayoutExt) {
        final BaseSearchBarLayoutExt baseSearchBarLayoutExt2 = this.mSearchExt;
        if (baseSearchBarLayoutExt == baseSearchBarLayoutExt2) {
            return;
        }
        this.mSearchExt = baseSearchBarLayoutExt;
        checkRunOnMain(new Runnable() { // from class: com.tencent.mobileqq.widget.search.QUISearchBar.4
            @Override // java.lang.Runnable
            public void run() {
                baseSearchBarLayoutExt2.onDetachView();
                QUISearchBar.this.mFlSearchExt.removeAllViews();
                BaseSearchBarLayoutExt baseSearchBarLayoutExt3 = QUISearchBar.this.mSearchExt;
                QUISearchBar qUISearchBar = QUISearchBar.this;
                baseSearchBarLayoutExt3.onInitLeftView(qUISearchBar.mFlSearchExt, qUISearchBar.mCurStyle, QUISearchBar.this.mCurThemeId, QUISearchBar.this.mCurColorType);
            }
        });
    }

    public void setSearchMode(int i3) {
        this.mSearchMode = i3;
    }

    public void setThemeId(int i3) {
        if (this.mCurThemeId == i3) {
            return;
        }
        this.mCurThemeId = i3;
        checkRunOnMain(new Runnable() { // from class: com.tencent.mobileqq.widget.search.QUISearchBar.6
            @Override // java.lang.Runnable
            public void run() {
                QUISearchBar.this.updateColorByTheme();
            }
        });
    }

    public void unbindSearchChain(final boolean z16) {
        if (this.mController == null) {
            return;
        }
        checkRunOnMain(new Runnable() { // from class: com.tencent.mobileqq.widget.search.QUISearchBar.9
            @Override // java.lang.Runnable
            public void run() {
                if (QUISearchBar.this.mController == null) {
                    return;
                }
                if (z16) {
                    QUISearchBar.this.mController.clearNodeView();
                } else {
                    QUISearchBar.this.mController.removeNodeView(QUISearchBar.this);
                }
                QUISearchBar.this.mController = null;
                QUISearchBar.this.mChainKey = -1;
            }
        });
    }

    public void updateStyle(int i3) {
        if (this.mCurStyle == i3) {
            return;
        }
        if (this.mStylerSArray.get(i3) == null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "updateStyle call fail, please input valid qui-style value.");
            }
        } else {
            this.mCurStyle = i3;
            checkRunOnMain(new Runnable() { // from class: com.tencent.mobileqq.widget.search.QUISearchBar.5
                @Override // java.lang.Runnable
                public void run() {
                    QUISearchBar.this.updateUIDetailByStyleAndState();
                }
            });
        }
    }

    public QUISearchBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public AbsQUISearchBarStyler findQUISearchBarStyler(int i3) {
        return this.mStylerSArray.get(i3, this.mDefStyler);
    }

    public void setCustomResource(@Nullable QUISearchBarResource qUISearchBarResource, boolean z16) {
        if (this.mCustomResource == qUISearchBarResource) {
            return;
        }
        this.mCustomResource = qUISearchBarResource;
        if (z16) {
            updateColorByTheme();
        }
    }

    public QUISearchBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public void bindSearchChain(boolean z16) {
        bindSearchChain(1000, z16);
    }

    public QUISearchBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mSearchExt = new DefaultSearchLayoutExt(this);
        this.mChainKey = -1;
        this.mSearchMode = 0;
        this.mAutoFocusable = true;
        initAttrs(context, attributeSet);
        initView();
        initStyler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (QUISearchBar.this.mSearchMode == 1) {
                QUISearchBar.this.doSearchAction();
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (TextUtils.isEmpty(charSequence)) {
                QUISearchBar qUISearchBar = QUISearchBar.this;
                qUISearchBar.updateViewVisibility(qUISearchBar.mIvClear, 8);
            } else {
                QUISearchBar qUISearchBar2 = QUISearchBar.this;
                qUISearchBar2.updateViewVisibility(qUISearchBar2.mIvClear, 0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
