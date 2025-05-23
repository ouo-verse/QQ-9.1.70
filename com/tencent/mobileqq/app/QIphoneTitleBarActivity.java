package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QIphoneTitleBarActivity extends QBaseActivity {
    static IPatchRedirector $redirector_ = null;
    public static final String HIDE_TITLE_LEFT_ARROW = "hide_title_left_arrow";
    public static final String INDIVIDUATION_URL_SOURCE_TYPE = "individuation_url_type";
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int REPORT_FROM_AIO = 40300;
    public static final int REPORT_FROM_AIO_EMOTICON_MANAGER = 40313;
    protected static final String TAG = "IphoneTitleBarActivity";

    /* renamed from: ad, reason: collision with root package name */
    private Drawable f194961ad;

    @Deprecated
    public TextView centerView;
    private boolean isRightHighlightButton;

    @Deprecated
    public TextView leftView;

    @Deprecated
    public TextView leftViewNotBack;
    protected View mContentView;
    protected int mContentViewID;
    protected float mDensity;

    @Deprecated
    protected ImageView mLeftBackIcon;

    @Deprecated
    protected TextView mLeftBackText;
    private RelativeLayout mLoadingParent;
    private ImageView mLoadingView;
    public boolean mNeedTitleBarTrans;
    private boolean mNotShowLeftText;
    private Drawable[] mOldDrawables;
    private int mOldPadding;

    @Deprecated
    public View mTitleContainer;
    protected boolean mUseOptimizMode;
    protected View.OnClickListener onBackListeger;
    public QUISecNavBar quiSecNavBar;

    @Deprecated
    public TextView rightHighLView;

    @Deprecated
    public ImageView rightViewImg;

    @Deprecated
    public TextView rightViewText;

    @Deprecated
    public RelativeLayout titleRoot;

    /* renamed from: vg, reason: collision with root package name */
    protected ViewGroup f194962vg;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QIphoneTitleBarActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QIphoneTitleBarActivity.this.onBackEvent();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b extends QBaseActivity.ActivityPropertyProvider {
        static IPatchRedirector $redirector_;

        b() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QIphoneTitleBarActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.QBaseActivity.ActivityPropertyProvider, com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
        public boolean hasTitleBar() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f194965a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44252);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BaseAction.values().length];
            f194965a = iArr;
            try {
                iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public QIphoneTitleBarActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mTitleContainer = null;
        this.mContentViewID = -1;
        this.mNeedTitleBarTrans = false;
        this.mNotShowLeftText = true;
        this.onBackListeger = new a();
        this.mUseOptimizMode = false;
    }

    private void initContentAndTitle(int i3, View view, boolean z16) {
        if (view == null) {
            try {
                view = com.tencent.mobileqq.utils.dp.d(this, i3, this.titleRoot);
            } catch (RuntimeException e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
                super.setContentView(i3);
                this.mContentViewID = i3;
                getWindow().setFeatureInt(7, R.layout.f167828is);
                return;
            }
        }
        if (z16) {
            com.tencent.mobileqq.utils.dp.b(this.titleRoot, view);
            com.tencent.mobileqq.utils.dp.c(this.titleRoot, this.quiSecNavBar);
        } else {
            com.tencent.mobileqq.utils.dp.c(this.titleRoot, this.quiSecNavBar);
            com.tencent.mobileqq.utils.dp.a(this.titleRoot, view, this.quiSecNavBar.getId());
        }
        this.mContentView = view;
        initSecNavBarClick();
        super.setContentView(this.titleRoot);
    }

    private void initQUISecNavBar(int i3, View view) {
        this.titleRoot = com.tencent.mobileqq.utils.dp.h(this);
        this.quiSecNavBar = com.tencent.mobileqq.utils.dp.f(this, Boolean.valueOf(secNavBarNeedImmersive()), this);
        initContentAndTitle(i3, view, needBlur());
    }

    private void initSecNavBarClick() {
        this.quiSecNavBar.setOnBaseTitleBarClickListener(new Function2() { // from class: com.tencent.mobileqq.app.cg
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit lambda$initSecNavBarClick$0;
                lambda$initSecNavBarClick$0 = QIphoneTitleBarActivity.this.lambda$initSecNavBarClick$0((View) obj, (BaseAction) obj2);
                return lambda$initSecNavBarClick$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$initSecNavBarClick$0(View view, BaseAction baseAction) {
        if (c.f194965a[baseAction.ordinal()] == 1) {
            onBackEvent();
            return null;
        }
        return null;
    }

    private void setContentViewNoTitleInner(View view) {
        this.mDensity = getResources().getDisplayMetrics().density;
        super.setContentView(view);
        getWindow().setFeatureInt(7, R.layout.f167870k4);
        try {
            View view2 = (View) findViewById(R.id.cbw).getParent();
            this.mTitleContainer = view2;
            view2.setVisibility(8);
        } catch (Throwable unused) {
        }
    }

    public static void setLayerType(View view) {
        if (view == null) {
            return;
        }
        view.setLayerType(0, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public void enableLeftBtn(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
            return;
        }
        TextView textView = this.leftViewNotBack;
        if (textView != null) {
            textView.setEnabled(z16);
        }
    }

    protected void enableRightHighlight(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
            return;
        }
        if (this.rightHighLView != null && this.isRightHighlightButton) {
            if (z16) {
                this.rightViewText.setVisibility(8);
                this.rightHighLView.setVisibility(0);
            } else {
                this.rightViewText.setVisibility(0);
                this.rightHighLView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public QBaseActivity.ActivityPropertyProvider getActivityPropertyProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (QBaseActivity.ActivityPropertyProvider) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return new b();
    }

    public View getRightTextView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (View) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnRightText);
        this.rightViewText = textView;
        setLayerType(textView);
        return this.rightViewText;
    }

    public String getTextTitle() {
        CharSequence text;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        TextView textView = this.centerView;
        if (textView != null && (textView instanceof TextView) && (text = textView.getText()) != null) {
            return text.toString();
        }
        return null;
    }

    public View getTitleBarView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (View) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return findViewById(R.id.rlCommenTitle);
    }

    public void hideTitleBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        try {
            View findViewById = findViewById(R.id.rlCommenTitle);
            this.mTitleContainer = findViewById;
            findViewById.setVisibility(8);
        } catch (Throwable unused) {
        }
    }

    public void init(Intent intent) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) intent);
            return;
        }
        ((FrameLayout) findViewById(android.R.id.content)).setForeground(getResources().getDrawable(R.drawable.skin_header_bar_shadow));
        if (this.leftView == null) {
            this.f194962vg = (ViewGroup) findViewById(R.id.rlCommenTitle);
            onCreateLeftView();
            try {
                if (intent.getBooleanExtra("hide_title_left_arrow", false) && (textView = this.leftView) != null) {
                    textView.setBackgroundDrawable(null);
                }
                onCreateCenterView();
                onCreateRightView();
                setLeftViewName(intent);
            } catch (Exception e16) {
                QLog.d(TAG, 1, "", e16);
            }
        }
    }

    public boolean isTitleProgressShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        if (this.mUseOptimizMode && this.mLoadingParent != null) {
            ImageView imageView = this.mLoadingView;
            if (imageView != null && imageView.getVisibility() != 8) {
                return true;
            }
        } else if (this.f194961ad != null) {
            return true;
        }
        return false;
    }

    public boolean needBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        finish();
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    protected View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        TextView textView = (TextView) findViewById(R.id.ivTitleName);
        this.centerView = textView;
        return textView;
    }

    protected View onCreateLeftView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (View) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.leftView = textView;
        textView.setOnClickListener(this.onBackListeger);
        this.mLeftBackText = (TextView) findViewById(R.id.k4f);
        ImageView imageView = (ImageView) findViewById(R.id.f165972dz1);
        this.mLeftBackIcon = imageView;
        TextView textView2 = this.mLeftBackText;
        if (textView2 != null && imageView != null) {
            textView2.setOnClickListener(this.onBackListeger);
            this.mLeftBackIcon.setOnClickListener(this.onBackListeger);
        }
        return this.leftView;
    }

    protected View onCreateRightView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (View) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        this.rightViewText = (TextView) findViewById(R.id.ivTitleBtnRightText);
        this.rightViewImg = (ImageView) findViewById(R.id.ivTitleBtnRightImage);
        return this.rightViewText;
    }

    @TargetApi(11)
    public void removeWebViewLayerType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(7);
        }
    }

    public boolean secNavBarNeedImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    public void setClickableTitle(CharSequence charSequence, View.OnClickListener onClickListener) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) charSequence, (Object) onClickListener);
            return;
        }
        setTitle(charSequence);
        TextView textView = this.centerView;
        if (textView != null && (textView instanceof TextView)) {
            if (onClickListener != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            textView.setClickable(z16);
            this.centerView.setOnClickListener(onClickListener);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    @TargetApi(14)
    public void setContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        this.mDensity = getResources().getDisplayMetrics().density;
        if (useQUISecNavBar()) {
            initQUISecNavBar(i3, null);
            return;
        }
        com.tencent.mobileqq.utils.dp.i(getActivityName());
        if (!this.mNeedStatusTrans) {
            super.setContentView(i3);
            this.mContentViewID = i3;
            getWindow().setFeatureInt(7, R.layout.f167828is);
        } else {
            LayoutInflater from = LayoutInflater.from(this);
            View inflate = from.inflate(R.layout.f167829iw, (ViewGroup) null);
            boolean z16 = true;
            try {
                View inflate2 = from.inflate(i3, (ViewGroup) inflate, false);
                this.titleRoot = (RelativeLayout) inflate.findViewById(R.id.jqh);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(3, R.id.rlCommenTitle);
                this.titleRoot.addView(inflate2, layoutParams);
                this.mContentView = inflate2;
                super.setContentView(this.titleRoot);
                z16 = false;
            } catch (InflateException e16) {
                e16.printStackTrace();
            } catch (RuntimeException e17) {
                e17.printStackTrace();
            }
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "layout with merge ,use framelayout to immersive" + getComponentName());
                }
                super.setContentView(i3);
                this.mContentViewID = i3;
                getWindow().setFeatureInt(7, R.layout.f167828is);
                View view = this.mTitleContainer;
                if (view != null) {
                    view.setVisibility(0);
                }
                this.mDensity = getResources().getDisplayMetrics().density;
                init(getIntent());
                return;
            }
        }
        View view2 = this.mTitleContainer;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        init(getIntent());
    }

    public void setContentViewC(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.mContentViewID = i3;
            super.setContentView(i3);
        }
    }

    @TargetApi(14)
    public void setContentViewNoTitle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mContentViewID = i3;
            setContentViewNoTitleInner(LayoutInflater.from(this).inflate(i3, (ViewGroup) null, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String setLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        TextView textView = this.centerView;
        if (textView != null && textView.getText() != null && this.centerView.getText().length() != 0) {
            return this.centerView.getText().toString();
        }
        return getString(R.string.button_back);
    }

    public void setLeftButton(int i3, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3, (Object) onClickListener);
            return;
        }
        this.leftView.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeftButton);
        this.leftViewNotBack = textView;
        setLayerType(textView);
        this.leftViewNotBack.setVisibility(0);
        this.leftViewNotBack.setText(i3);
        if (onClickListener == null) {
            this.leftViewNotBack.setOnClickListener(this.onBackListeger);
        } else {
            this.leftViewNotBack.setOnClickListener(onClickListener);
        }
    }

    public void setLeftViewName(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) intent);
            return;
        }
        TextView textView = this.leftView;
        if (textView == null || !(textView instanceof TextView) || intent == null || intent.getExtras() == null) {
            return;
        }
        TextView textView2 = this.leftViewNotBack;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        try {
            TextView textView3 = this.leftView;
            String string = intent.getExtras().getString(AppStatusCallbackSingleton.getInstance().getCallback().getKeyOfLeftViewText());
            int i3 = intent.getExtras().getInt("individuation_url_type");
            if (i3 >= 40300 && i3 <= 40313 && !TextUtils.isEmpty(string) && string.contains(getString(R.string.f172115nh0))) {
                string = getString(R.string.button_back);
            }
            if (string == null) {
                string = getString(R.string.button_back);
            }
            if (this.mNotShowLeftText) {
                textView3.setText("  ");
            } else {
                textView3.setText(string);
            }
            textView3.setVisibility(0);
            if (AppStatusCallbackSingleton.getInstance().getCallback().isTalkBackOn()) {
                if (!string.contains(getString(R.string.button_back))) {
                    string = getString(R.string.button_back) + string;
                }
                this.leftView.setContentDescription(string);
            }
        } catch (Exception unused) {
        }
    }

    public void setRightButton(int i3, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3, (Object) onClickListener);
            return;
        }
        this.isRightHighlightButton = false;
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(i3);
        this.rightViewText.setEnabled(true);
        if (onClickListener != null) {
            this.rightViewText.setOnClickListener(onClickListener);
        }
        if (AppStatusCallbackSingleton.getInstance().getCallback().isTalkBackOn()) {
            this.rightViewText.setContentDescription(((Object) this.rightViewText.getText()) + getString(R.string.f172116nh1));
        }
    }

    protected void setRightHighlightButton(int i3, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3, (Object) onClickListener);
            return;
        }
        this.isRightHighlightButton = true;
        TextView textView = this.rightViewText;
        if (textView != null) {
            textView.setVisibility(0);
            this.rightViewText.setText(i3);
            this.rightViewText.setEnabled(false);
            TextView textView2 = (TextView) getLayoutInflater().inflate(R.layout.custom_commen_title_rightview_highlight, (ViewGroup) null);
            this.rightHighLView = textView2;
            setLayerType(textView2);
            this.rightHighLView.setText(i3);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11, 1);
            layoutParams.addRule(15, 1);
            layoutParams.rightMargin = (int) (this.mDensity * 8.0f);
            this.f194962vg.addView(this.rightHighLView, layoutParams);
            this.rightHighLView.setVisibility(8);
            if (onClickListener != null) {
                this.rightHighLView.setOnClickListener(onClickListener);
            }
        }
    }

    @TargetApi(11)
    public void setRightViewTextDisable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, i3);
        } else if (i3 == 0) {
            this.rightViewText.setEnabled(false);
            this.rightViewText.setAlpha(0.5f);
        } else {
            this.rightViewText.setEnabled(true);
            this.rightViewText.setAlpha(1.0f);
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        QUISecNavBar qUISecNavBar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) charSequence);
            return;
        }
        if (useQUISecNavBar() && (qUISecNavBar = this.quiSecNavBar) != null) {
            qUISecNavBar.setCenterText(charSequence);
            super.setTitle(charSequence);
            return;
        }
        TextView textView = this.centerView;
        if (textView == null || !(textView instanceof TextView)) {
            return;
        }
        textView.setText(charSequence);
        super.setTitle(charSequence);
    }

    public void showContentViewTitle(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        try {
            View view = (View) findViewById(R.id.rlCommenTitle).getParent();
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean startTitleProgress() {
        ViewParent viewParent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        if (this.centerView == null) {
            return false;
        }
        View view = null;
        if (this.mUseOptimizMode) {
            View view2 = (RelativeLayout) findViewById(R.id.jp7);
            if (this.centerView.getVisibility() == 0) {
                view2 = this.centerView;
                viewParent = view2.getParent();
            } else if (view2 != null && view2.getVisibility() == 0) {
                viewParent = view2.getParent();
            } else {
                view2 = null;
                viewParent = null;
            }
            RelativeLayout relativeLayout = this.mLoadingParent;
            if (relativeLayout != null && relativeLayout != viewParent) {
                ImageView imageView = this.mLoadingView;
                if (imageView != null) {
                    ViewParent parent = imageView.getParent();
                    RelativeLayout relativeLayout2 = this.mLoadingParent;
                    if (parent == relativeLayout2) {
                        relativeLayout2.removeView(this.mLoadingView);
                        this.mLoadingView = null;
                    }
                }
                this.mLoadingParent = null;
            }
            if (this.mLoadingParent == null && (viewParent instanceof RelativeLayout)) {
                this.mLoadingParent = (RelativeLayout) viewParent;
            }
            if (view2 != null && this.mLoadingView != null) {
                int id5 = view2.getId();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLoadingView.getLayoutParams();
                if (layoutParams.getRules()[0] != id5) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    view2.setLayoutParams(layoutParams2);
                    layoutParams.addRule(0, id5);
                    this.mLoadingView.setLayoutParams(layoutParams);
                }
            }
            view = view2;
        }
        if (this.mUseOptimizMode && this.mLoadingParent != null) {
            ImageView imageView2 = this.mLoadingView;
            if (imageView2 == null || imageView2.getVisibility() != 0) {
                if (view != null && this.mLoadingView == null) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams3.rightMargin = 0;
                    layoutParams3.leftMargin = 0;
                    view.setLayoutParams(layoutParams3);
                    ImageView imageView3 = new ImageView(this);
                    this.mLoadingView = imageView3;
                    imageView3.setId(R.id.ef8);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams4.addRule(0, view.getId());
                    layoutParams4.addRule(15);
                    layoutParams4.rightMargin = (int) (getDensity() * 7.0f);
                    this.mLoadingParent.addView(this.mLoadingView, layoutParams4);
                    Drawable drawable = getActivity().getResources().getDrawable(R.drawable.common_loading5);
                    this.mLoadingView.setImageDrawable(drawable);
                    if (drawable instanceof Animatable) {
                        ((Animatable) drawable).start();
                    }
                }
                ImageView imageView4 = this.mLoadingView;
                if (imageView4 != null && imageView4.getVisibility() != 0) {
                    this.mLoadingView.setVisibility(0);
                }
                return true;
            }
        } else if (this.f194961ad == null) {
            this.f194961ad = getResources().getDrawable(R.drawable.common_loading5);
            this.mOldDrawables = this.centerView.getCompoundDrawables();
            this.mOldPadding = this.centerView.getCompoundDrawablePadding();
            this.centerView.setCompoundDrawablePadding(10);
            TextView textView = this.centerView;
            Drawable drawable2 = this.f194961ad;
            Drawable[] drawableArr = this.mOldDrawables;
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawableArr[1], drawableArr[2], drawableArr[3]);
            ((Animatable) this.f194961ad).start();
            return true;
        }
        return false;
    }

    public boolean stopTitleProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        if (this.mUseOptimizMode && this.mLoadingParent != null) {
            ImageView imageView = this.mLoadingView;
            if (imageView != null && imageView.getVisibility() != 8) {
                this.mLoadingView.setVisibility(8);
                return true;
            }
        } else {
            Object obj = this.f194961ad;
            if (obj != null) {
                ((Animatable) obj).stop();
                this.f194961ad = null;
                this.centerView.setCompoundDrawablePadding(this.mOldPadding);
                TextView textView = this.centerView;
                Drawable[] drawableArr = this.mOldDrawables;
                textView.setCompoundDrawablesWithIntrinsicBounds(drawableArr[0], drawableArr[1], drawableArr[2], drawableArr[3]);
                return true;
            }
        }
        return false;
    }

    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    public void setContentViewNoTitle(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            if (view == null) {
                return;
            }
            setContentViewNoTitleInner(view);
        }
    }

    public void setTitle(CharSequence charSequence, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) charSequence, (Object) str);
            return;
        }
        TextView textView = this.centerView;
        if (textView == null || !(textView instanceof TextView)) {
            return;
        }
        textView.setText(charSequence);
        if (AppStatusCallbackSingleton.getInstance().getCallback().isTalkBackOn()) {
            textView.setContentDescription(str);
        }
        super.setTitle(str);
    }

    public void setLeftButton(String str, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str, (Object) onClickListener);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setLeftButton() called with: text = [" + str + "], l = [" + onClickListener + "]");
        }
        this.leftView.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeftButton);
        this.leftViewNotBack = textView;
        setLayerType(textView);
        this.leftViewNotBack.setVisibility(0);
        this.leftViewNotBack.setText(str);
        if (onClickListener == null) {
            this.leftViewNotBack.setOnClickListener(this.onBackListeger);
        } else {
            this.leftViewNotBack.setOnClickListener(onClickListener);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            setTitle(getString(i3));
        } else {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        }
    }

    public void setLeftViewName(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        TextView textView = this.leftView;
        if (textView == null || !(textView instanceof TextView)) {
            return;
        }
        TextView textView2 = this.leftViewNotBack;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        String string = getString(i3);
        TextView textView3 = this.leftView;
        if (string == null || "".equals(string)) {
            string = getString(R.string.button_back);
        }
        if (this.mNotShowLeftText) {
            textView3.setText("  ");
        } else {
            textView3.setText(string);
        }
        textView3.setVisibility(0);
        if (AppStatusCallbackSingleton.getInstance().getCallback().isTalkBackOn()) {
            if (!string.contains(getString(R.string.button_back))) {
                string = getString(R.string.button_back) + string;
            }
            this.leftView.setContentDescription(string);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    @TargetApi(14)
    public void setContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        this.mContentView = view;
        this.mDensity = getResources().getDisplayMetrics().density;
        if (useQUISecNavBar()) {
            initQUISecNavBar(0, view);
            return;
        }
        com.tencent.mobileqq.utils.dp.i(getActivityName());
        if (!this.mNeedStatusTrans) {
            super.setContentView(view);
            getWindow().setFeatureInt(7, R.layout.f167828is);
        } else {
            this.titleRoot = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.f167829iw, (ViewGroup) null).findViewById(R.id.jqh);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.rlCommenTitle);
            this.titleRoot.addView(view, layoutParams);
            super.setContentView(this.titleRoot);
        }
        View view2 = this.mTitleContainer;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        init(getIntent());
    }
}
