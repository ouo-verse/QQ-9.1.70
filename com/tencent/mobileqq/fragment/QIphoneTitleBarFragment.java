package com.tencent.mobileqq.fragment;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.dp;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class QIphoneTitleBarFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_ = null;
    public static final String HIDE_TITLE_LEFT_ARROW = "hide_title_left_arrow";
    public static final int LAYER_TYPE_SOFTWARE = 1;
    protected static final String TAG = "IphoneTitleBarFragment";

    /* renamed from: ad, reason: collision with root package name */
    private Drawable f211173ad;

    @Deprecated
    public TextView centerView;
    private boolean isRightHighlightButton;

    @Deprecated
    public TextView leftView;

    @Deprecated
    public TextView leftViewNotBack;
    protected View mContentView;
    protected float mDensity;

    @Deprecated
    protected ImageView mLeftBackIcon;

    @Deprecated
    protected TextView mLeftBackText;
    private RelativeLayout mLoadingParent;
    private ImageView mLoadingView;
    private Drawable[] mOldDrawables;
    private int mOldPadding;
    public View mTitleContainer;
    protected boolean mUseOptimizMode;
    protected View.OnClickListener onBackListener;
    public QUISecNavBar quiSecNavBar;

    @Deprecated
    public TextView rightHighLView;

    @Deprecated
    public ImageView rightViewImg;

    @Deprecated
    public TextView rightViewText;
    public RelativeLayout titleRoot;

    /* renamed from: vg, reason: collision with root package name */
    @Deprecated
    protected NavBarCommon f211174vg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Function2<View, BaseAction, Unit> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QIphoneTitleBarFragment.this);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
            }
            if (c.f211177a[baseAction.ordinal()] == 1) {
                QIphoneTitleBarFragment.this.onBackEvent();
                return null;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QIphoneTitleBarFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QIphoneTitleBarFragment.this.onBackEvent();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f211177a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43430);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BaseAction.values().length];
            f211177a = iArr;
            try {
                iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public QIphoneTitleBarFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mTitleContainer = null;
        this.mUseOptimizMode = false;
        this.onBackListener = new b();
    }

    private View initContentAndTitle(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, boolean z16) {
        try {
            View inflate = layoutInflater.inflate(getContentLayoutId(), (ViewGroup) this.titleRoot, false);
            if (z16) {
                dp.b(this.titleRoot, inflate);
                dp.c(this.titleRoot, this.quiSecNavBar);
            } else {
                dp.c(this.titleRoot, this.quiSecNavBar);
                dp.a(this.titleRoot, inflate, this.quiSecNavBar.getId());
            }
            this.mContentView = inflate;
            initSecNavBarClick();
        } catch (RuntimeException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        doOnCreateView(layoutInflater, viewGroup, bundle);
        return this.titleRoot;
    }

    private View initQUISecNavBar(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.titleRoot = dp.h(getContext());
        this.quiSecNavBar = dp.g(getContext(), Boolean.valueOf(secNavBarNeedImmersive()), this);
        return initContentAndTitle(layoutInflater, viewGroup, bundle, needBlur());
    }

    private void initSecNavBarClick() {
        this.quiSecNavBar.setOnBaseTitleBarClickListener(new a());
    }

    public static void setLayerType(View view) {
        if (view == null) {
            return;
        }
        view.setLayerType(0, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void enableRightHighlight(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, z16);
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
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public abstract int getContentLayoutId();

    public View getRightTextView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (View) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        TextView textView = (TextView) this.titleRoot.findViewById(R.id.ivTitleBtnRightText);
        this.rightViewText = textView;
        setLayerType(textView);
        return this.rightViewText;
    }

    public View getTitleBarView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (View) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.titleRoot.findViewById(R.id.rlCommenTitle);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public void hideTitleBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        try {
            View findViewById = this.titleRoot.findViewById(R.id.rlCommenTitle);
            this.mTitleContainer = findViewById;
            findViewById.setVisibility(8);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, th5, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(Bundle bundle) {
        TextView textView;
        ViewParent parent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle);
            return;
        }
        if (getActivity() == null) {
            return;
        }
        ((FrameLayout) getActivity().findViewById(android.R.id.content)).setForeground(getResources().getDrawable(R.drawable.skin_header_bar_shadow));
        if (isTransparent() && needImmersive() && needStatusTrans() && (parent = getActivity().findViewById(android.R.id.title).getParent()) != null && (parent instanceof FrameLayout)) {
            ((FrameLayout) parent).setVisibility(8);
        }
        if (this.leftView == null) {
            this.f211174vg = (NavBarCommon) this.titleRoot.findViewById(R.id.rlCommenTitle);
            onCreateLeftView();
            try {
                if (bundle.getBoolean("hide_title_left_arrow", false) && (textView = this.leftView) != null) {
                    textView.setBackgroundDrawable(null);
                }
                onCreateCenterView();
                onCreateRightView();
                setLeftViewName(bundle);
            } catch (Exception e16) {
                QLog.d(TAG, 1, "", e16);
            }
        }
    }

    public boolean isTitleProgressShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (this.mUseOptimizMode && this.mLoadingParent != null) {
            ImageView imageView = this.mLoadingView;
            if (imageView != null && imageView.getVisibility() != 8) {
                return true;
            }
        } else if (this.f211173ad != null) {
            return true;
        }
        return false;
    }

    protected boolean isTransparent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean needBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (getActivity() != null) {
            getActivity().finish();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        TextView textView = (TextView) this.titleRoot.findViewById(R.id.ivTitleName);
        this.centerView = textView;
        return textView;
    }

    protected View onCreateLeftView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        TextView textView = (TextView) this.titleRoot.findViewById(R.id.ivTitleBtnLeft);
        this.leftView = textView;
        textView.setOnClickListener(this.onBackListener);
        this.mLeftBackText = (TextView) this.titleRoot.findViewById(R.id.k4f);
        ImageView imageView = (ImageView) this.titleRoot.findViewById(R.id.f165972dz1);
        this.mLeftBackIcon = imageView;
        TextView textView2 = this.mLeftBackText;
        if (textView2 != null && imageView != null) {
            textView2.setOnClickListener(this.onBackListener);
            this.mLeftBackIcon.setOnClickListener(this.onBackListener);
        }
        return this.leftView;
    }

    protected View onCreateRightView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (View) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        this.rightViewText = (TextView) this.titleRoot.findViewById(R.id.ivTitleBtnRightText);
        this.rightViewImg = (ImageView) this.titleRoot.findViewById(R.id.ivTitleBtnRightImage);
        setLayerType(this.rightViewText);
        setLayerType(this.rightViewImg);
        return this.rightViewText;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @TargetApi(14)
    @Nullable
    public final View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view2 = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            this.mDensity = getResources().getDisplayMetrics().density;
            if (useQUISecNavBar()) {
                view2 = initQUISecNavBar(layoutInflater, viewGroup, bundle);
            } else {
                dp.i(getClass().getSimpleName());
                View inflate = layoutInflater.inflate(R.layout.f167829iw, viewGroup, false);
                try {
                    view = layoutInflater.inflate(getContentLayoutId(), (ViewGroup) inflate, false);
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, th5, new Object[0]);
                    view = null;
                }
                try {
                    this.titleRoot = (RelativeLayout) inflate.findViewById(R.id.jqh);
                    if (ImmersiveUtils.isSupporImmersive() == 1) {
                        this.titleRoot.setFitsSystemWindows(true);
                        this.titleRoot.setPadding(0, ImmersiveUtils.getStatusBarHeight(layoutInflater.getContext()), 0, 0);
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(3, R.id.rlCommenTitle);
                    this.titleRoot.addView(view, layoutParams);
                    this.mContentView = view;
                } catch (InflateException e16) {
                    QLog.e(TAG, 1, e16, new Object[0]);
                } catch (RuntimeException e17) {
                    QLog.e(TAG, 1, e17, new Object[0]);
                }
                View view3 = this.mTitleContainer;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                init(getArguments());
                doOnCreateView(layoutInflater, viewGroup, bundle);
                view2 = inflate;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view2);
        return view2;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @TargetApi(11)
    public void removeWebViewLayerType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    public void resetLeftButton() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        TextView textView = this.leftViewNotBack;
        if (textView != null) {
            textView.setVisibility(8);
        }
        setLayerType(this.leftView);
        this.leftView.setVisibility(0);
    }

    public boolean secNavBarNeedImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    public View setBottomTitleLayoutIdAndInflateIt(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (View) iPatchRedirector.redirect((short) 37, (Object) this, (Object) str, i3);
        }
        return this.f211174vg.setBottomTitleLayoutIdAndInflateIt(str, i3);
    }

    public void setLeftButton(int i3, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3, (Object) onClickListener);
            return;
        }
        this.leftView.setVisibility(8);
        TextView textView = (TextView) this.titleRoot.findViewById(R.id.ivTitleBtnLeftButton);
        this.leftViewNotBack = textView;
        setLayerType(textView);
        this.leftViewNotBack.setVisibility(0);
        this.leftViewNotBack.setText(i3);
        if (onClickListener == null) {
            this.leftViewNotBack.setOnClickListener(this.onBackListener);
        } else {
            this.leftViewNotBack.setOnClickListener(onClickListener);
        }
    }

    public void setLeftViewName(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            this.f211174vg.setLeftViewName(bundle);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle);
        }
    }

    public void setRightButton(int i3, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3, (Object) onClickListener);
            return;
        }
        this.isRightHighlightButton = false;
        this.rightViewText.setVisibility(0);
        setTextWithTalk(this.rightViewText, i3);
        this.rightViewText.setEnabled(true);
        if (onClickListener != null) {
            this.rightViewText.setOnClickListener(onClickListener);
        }
    }

    public void setRightButtonEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.rightViewText.setEnabled(z16);
        }
    }

    public void setRightButtonText(String str, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str, (Object) onClickListener);
            return;
        }
        this.isRightHighlightButton = false;
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(str);
        this.rightViewText.setEnabled(true);
        if (onClickListener != null) {
            this.rightViewText.setOnClickListener(onClickListener);
        }
    }

    protected void setRightHighlightButton(int i3, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3, (Object) onClickListener);
            return;
        }
        this.isRightHighlightButton = true;
        TextView textView = this.rightViewText;
        if (textView != null) {
            textView.setVisibility(0);
            this.rightViewText.setText(i3);
            this.rightViewText.setEnabled(false);
            TextView textView2 = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_commen_title_rightview_highlight, (ViewGroup) null);
            this.rightHighLView = textView2;
            setLayerType(textView2);
            this.rightHighLView.setText(i3);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11, 1);
            layoutParams.addRule(15, 1);
            layoutParams.rightMargin = (int) (this.mDensity * 8.0f);
            this.f211174vg.addView(this.rightHighLView, layoutParams);
            this.rightHighLView.setVisibility(8);
            if (onClickListener != null) {
                this.rightHighLView.setOnClickListener(onClickListener);
            }
        }
    }

    @TargetApi(11)
    public void setRightViewTextDisable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else if (i3 == 0) {
            this.rightViewText.setEnabled(false);
            this.rightViewText.setAlpha(0.5f);
        } else {
            this.rightViewText.setEnabled(true);
            this.rightViewText.setAlpha(1.0f);
        }
    }

    protected void setTextWithTalk(TextView textView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) textView, i3);
            return;
        }
        textView.setText(i3);
        if (AppSetting.f99565y) {
            textView.setContentDescription(((Object) textView.getText()) + HardCodeUtil.qqStr(R.string.ngz));
        }
    }

    public void setTitle(CharSequence charSequence) {
        QUISecNavBar qUISecNavBar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) charSequence);
        } else if (useQUISecNavBar() && (qUISecNavBar = this.quiSecNavBar) != null) {
            qUISecNavBar.setCenterText(charSequence);
        } else {
            this.f211174vg.setTitle(charSequence);
        }
    }

    public void showTitleBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        try {
            View findViewById = this.titleRoot.findViewById(R.id.rlCommenTitle);
            this.mTitleContainer = findViewById;
            findViewById.setVisibility(0);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, th5, new Object[0]);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean startTitleProgress() {
        ViewParent viewParent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (this.centerView != null && getActivity() != null) {
            View view = null;
            if (this.mUseOptimizMode) {
                View view2 = (RelativeLayout) this.titleRoot.findViewById(R.id.jp7);
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
                    if (this.mLoadingView == null && view != null) {
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        layoutParams3.rightMargin = 0;
                        layoutParams3.leftMargin = 0;
                        view.setLayoutParams(layoutParams3);
                        ImageView imageView3 = new ImageView(getActivity());
                        this.mLoadingView = imageView3;
                        imageView3.setId(R.id.ef8);
                        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams4.addRule(0, view.getId());
                        layoutParams4.addRule(15);
                        layoutParams4.rightMargin = (int) (com.tencent.mobileqq.utils.ah.q() * 7.0f);
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
            } else if (this.f211173ad == null) {
                this.f211173ad = getResources().getDrawable(R.drawable.common_loading5);
                this.mOldDrawables = this.centerView.getCompoundDrawables();
                this.mOldPadding = this.centerView.getCompoundDrawablePadding();
                this.centerView.setCompoundDrawablePadding(10);
                TextView textView = this.centerView;
                Drawable drawable2 = this.f211173ad;
                Drawable[] drawableArr = this.mOldDrawables;
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawableArr[1], drawableArr[2], drawableArr[3]);
                ((Animatable) this.f211173ad).start();
                return true;
            }
        }
        return false;
    }

    public boolean stopTitleProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (this.mUseOptimizMode && this.mLoadingParent != null) {
            ImageView imageView = this.mLoadingView;
            if (imageView != null && imageView.getVisibility() != 8) {
                this.mLoadingView.setVisibility(8);
                return true;
            }
        } else {
            Object obj = this.f211173ad;
            if (obj != null) {
                ((Animatable) obj).stop();
                this.f211173ad = null;
                this.centerView.setCompoundDrawablePadding(this.mOldPadding);
                TextView textView = this.centerView;
                Drawable[] drawableArr = this.mOldDrawables;
                textView.setCompoundDrawablesWithIntrinsicBounds(drawableArr[0], drawableArr[1], drawableArr[2], drawableArr[3]);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRightTvTextColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        ColorStateList colorStateList = getResources().getColorStateList(R.color.qui_common_text_nav_secondary_selector);
        TextView textView = this.rightViewText;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
        TextView textView2 = this.rightHighLView;
        if (textView2 != null) {
            textView2.setTextColor(colorStateList);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    public void setLeftViewName(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            this.f211174vg.setLeftViewName(i3);
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
    }

    public void setTitle(CharSequence charSequence, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) {
            this.f211174vg.setTitle(charSequence, str);
        } else {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) charSequence, (Object) str);
        }
    }

    public void setTitle(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            this.f211174vg.setTitle(charSequence, charSequence2, charSequence3, charSequence4);
        } else {
            iPatchRedirector.redirect((short) 36, this, charSequence, charSequence2, charSequence3, charSequence4);
        }
    }

    public void setLeftButton(String str, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str, (Object) onClickListener);
            return;
        }
        this.leftView.setVisibility(8);
        this.leftViewNotBack = (TextView) this.titleRoot.findViewById(R.id.ivTitleBtnLeftButton);
        if (TextUtils.isEmpty(str)) {
            this.leftViewNotBack.setVisibility(8);
            return;
        }
        setLayerType(this.leftViewNotBack);
        this.leftViewNotBack.setVisibility(0);
        this.leftViewNotBack.setText(str);
        if (onClickListener == null) {
            this.leftViewNotBack.setOnClickListener(this.onBackListener);
        } else {
            this.leftViewNotBack.setOnClickListener(onClickListener);
        }
    }
}
