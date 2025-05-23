package com.tencent.mobileqq.widget.navbar;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQUIAppSetting;
import com.tencent.util.TokenResUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NavBarCommon extends RelativeLayout implements View.OnClickListener {
    private static final int CUSTOM_VIEW_MARGIN = 24;
    public static final String INDIVIDUATION_URL_SOURCE_TYPE = "individuation_url_type";
    public static final int REPORT_FROM_AIO = 40300;
    public static final int REPORT_FROM_AIO_EMOTICON_MANAGER = 40313;

    /* renamed from: ad, reason: collision with root package name */
    private Drawable f317120ad;
    private View animView;
    private TextView bottomTitle;
    private TextView centerView;
    private TextView leftView;
    private TextView leftViewNotBack;
    private a listener;
    private ViewStub mBottomTitleStub;
    private ImageView mLeftBackIcon;
    private TextView mLeftBackText;
    private RelativeLayout mLoadingParent;
    private ImageView mLoadingView;
    private boolean mNotShowLeftText;
    private Drawable[] mOldDrawables;
    private int mOldPadding;
    protected boolean mUseOptimizMode;
    private ImageView rightViewImg;
    private ImageView rightViewImg1;
    private TextView rightViewText;
    private TextView rightViewText2;
    private RelativeLayout titleContainer;
    private TextView topTitle;

    public NavBarCommon(Context context) {
        super(context);
        this.mNotShowLeftText = true;
        this.mUseOptimizMode = false;
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.f167830ix, this);
        setBackgroundResource(R.drawable.qui_bg_nav_secondary);
        this.leftView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.mLeftBackText = (TextView) findViewById(R.id.k4f);
        this.mLeftBackIcon = (ImageView) findViewById(R.id.f165972dz1);
        this.leftViewNotBack = (TextView) findViewById(R.id.ivTitleBtnLeftButton);
        this.centerView = (TextView) findViewById(R.id.ivTitleName);
        this.titleContainer = (RelativeLayout) findViewById(R.id.jp7);
        this.topTitle = (TextView) findViewById(R.id.jq5);
        this.bottomTitle = (TextView) findViewById(R.id.joi);
        this.rightViewText = (TextView) findViewById(R.id.ivTitleBtnRightText);
        this.rightViewImg1 = (ImageView) findViewById(R.id.dsr);
        this.rightViewText2 = (TextView) findViewById(R.id.f165893dt0);
        this.rightViewImg = (ImageView) findViewById(R.id.ivTitleBtnRightImage);
        this.mBottomTitleStub = (ViewStub) findViewById(R.id.f98365mw);
        if (QQUIAppSetting.enableTalkBack()) {
            AccessibilityUtil.d(this.leftView, Button.class.getName());
            TextView textView = this.mLeftBackText;
            if (textView != null) {
                AccessibilityUtil.d(textView, Button.class.getName());
            }
            ImageView imageView = this.mLeftBackIcon;
            if (imageView != null) {
                AccessibilityUtil.d(imageView, Button.class.getName());
            }
        }
    }

    public static void setLayerType(View view) {
        if (view == null) {
            return;
        }
        view.setLayerType(0, null);
    }

    public void changeBg(boolean z16) {
        changeBg(z16, false);
    }

    public void clearBackDrawableLeft() {
        this.leftView.setCompoundDrawables(null, null, null, null);
    }

    public TextView getLeftBackIcon() {
        return this.leftView;
    }

    public ImageView getLeftBackIconImgView() {
        return this.mLeftBackIcon;
    }

    public TextView getRightViewText2() {
        return this.rightViewText2;
    }

    public void hideLeft() {
        this.leftView.setVisibility(8);
        this.mLeftBackText.setVisibility(8);
        this.mLeftBackIcon.setVisibility(8);
        this.leftViewNotBack.setVisibility(8);
    }

    public void hideLeftText() {
        ViewUtils.setVisible(this.leftViewNotBack, 8);
    }

    public boolean isTitleProgressShowing() {
        if (this.mUseOptimizMode && this.mLoadingParent != null) {
            ImageView imageView = this.mLoadingView;
            if (imageView != null && imageView.getVisibility() != 8) {
                return true;
            }
        } else if (this.f317120ad != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.listener != null) {
            int id5 = view.getId();
            if (id5 != R.id.ivTitleBtnLeft && id5 != R.id.k4f && id5 != R.id.f165972dz1) {
                if (id5 == R.id.ivTitleBtnRightText) {
                    i3 = 2;
                } else if (id5 == R.id.ivTitleBtnRightImage) {
                    i3 = 4;
                } else if (id5 == R.id.f165893dt0) {
                    i3 = 3;
                } else if (id5 == R.id.dsr) {
                    i3 = 5;
                } else if (id5 != R.id.ivTitleName && id5 != R.id.jp7) {
                    if (id5 == R.id.ivTitleBtnLeftButton) {
                        i3 = 8;
                    } else {
                        i3 = 0;
                    }
                } else {
                    i3 = 7;
                }
            } else {
                i3 = 1;
            }
            if (i3 != 0) {
                this.listener.onItemSelect(view, i3);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public View setBottomTitleLayoutIdAndInflateIt(String str, int i3) {
        this.centerView.setVisibility(8);
        this.titleContainer.setVisibility(0);
        this.topTitle.setText(str);
        this.topTitle.setContentDescription(str);
        this.mBottomTitleStub.setLayoutResource(i3);
        return this.mBottomTitleStub.inflate().findViewById(R.id.f98375mx);
    }

    public void setCustomView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, ViewUtils.dip2px(29.0f));
        this.centerView.setVisibility(8);
        layoutParams.addRule(13, -1);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.titleContainer.getLayoutParams();
        int dip2px = ViewUtils.dip2px(24.0f);
        layoutParams2.leftMargin = dip2px;
        layoutParams2.rightMargin = dip2px;
        this.titleContainer.setLayoutParams(layoutParams2);
        this.titleContainer.addView(view, layoutParams);
        this.titleContainer.setVisibility(0);
    }

    public void setLeftBackVisible(int i3) {
        ViewUtils.setVisible(this.leftView, i3);
    }

    public void setLeftButton(int i3) {
        this.leftView.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeftButton);
        this.leftViewNotBack = textView;
        setLayerType(textView);
        this.leftViewNotBack.setVisibility(0);
        this.leftViewNotBack.setText(i3);
    }

    public void setLeftViewName(Bundle bundle) {
        if (this.leftView == null || bundle == null) {
            return;
        }
        TextView textView = this.leftViewNotBack;
        if (textView != null) {
            textView.setVisibility(8);
        }
        try {
            TextView textView2 = this.leftView;
            String string = bundle.getString(AppConstants.LeftViewText.LEFTVIEWTEXT);
            int i3 = bundle.getInt("individuation_url_type");
            if (i3 >= 40300 && i3 <= 40313 && !TextUtils.isEmpty(string) && string.contains(HardCodeUtil.qqStr(R.string.odu))) {
                string = getContext().getString(R.string.button_back);
            }
            if (string == null) {
                string = getContext().getString(R.string.button_back);
            }
            if (this.mNotShowLeftText) {
                textView2.setText("  ");
            } else {
                textView2.setText(string);
            }
            textView2.setVisibility(0);
            if (QQUIAppSetting.enableTalkBack()) {
                if (!string.contains(getContext().getString(R.string.button_back))) {
                    string = getContext().getString(R.string.button_back) + string;
                }
                this.leftView.setContentDescription(string);
            }
        } catch (Exception unused) {
        }
    }

    public void setNotShowLeftText(boolean z16) {
        this.mNotShowLeftText = z16;
    }

    public void setOnItemSelectListener(a aVar) {
        this.listener = aVar;
        this.leftView.setOnClickListener(this);
        TextView textView = this.mLeftBackText;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        ImageView imageView = this.mLeftBackIcon;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        TextView textView2 = this.leftViewNotBack;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        this.rightViewText.setOnClickListener(this);
        this.rightViewImg1.setOnClickListener(this);
        this.rightViewText2.setOnClickListener(this);
        this.rightViewImg.setOnClickListener(this);
        this.centerView.setOnClickListener(this);
        this.titleContainer.setOnClickListener(this);
    }

    public void setRightButton(int i3) {
        this.rightViewText.setVisibility(0);
        this.rightViewImg1.setVisibility(8);
        this.rightViewText.setText(i3);
        this.rightViewText.setEnabled(true);
        if (QQUIAppSetting.enableTalkBack()) {
            this.rightViewText.setContentDescription(((Object) this.rightViewText.getText()) + HardCodeUtil.qqStr(R.string.odv));
        }
    }

    public void setRightButton2(int i3) {
        this.rightViewText2.setVisibility(0);
        this.rightViewImg.setVisibility(8);
        this.rightViewText2.setText(i3);
        this.rightViewText2.setEnabled(true);
        if (QQUIAppSetting.enableTalkBack()) {
            this.rightViewText.setContentDescription(((Object) this.rightViewText.getText()) + HardCodeUtil.qqStr(R.string.odv));
        }
    }

    public void setRightImage(Drawable drawable) {
        this.rightViewImg1.setVisibility(0);
        this.rightViewText.setVisibility(8);
        this.rightViewImg1.setImageDrawable(drawable);
    }

    public void setRightImage2(Drawable drawable) {
        this.rightViewImg.setImageDrawable(drawable);
        this.rightViewImg.setVisibility(0);
        this.rightViewText2.setVisibility(8);
    }

    public void setRightImage2Desc(String str) {
        this.rightViewImg.setContentDescription(str);
    }

    public void setRightImageDesc(String str) {
        this.rightViewImg1.setContentDescription(str);
    }

    public void setRightViewTextVisible(int i3) {
        ViewUtils.setVisible(this.rightViewText, i3);
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.centerView;
        if (textView != null) {
            textView.setText(charSequence);
            this.centerView.setVisibility(0);
        }
        RelativeLayout relativeLayout = this.titleContainer;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public void setTitleColor(int i3) {
        TextView textView = this.centerView;
        if (textView != null) {
            textView.setTextColor(i3);
            this.centerView.setVisibility(0);
        }
    }

    public void showLeftText() {
        ViewUtils.setVisible(this.leftViewNotBack, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean startTitleProgress() {
        ViewParent viewParent;
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
                if (this.mLoadingView == null) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams3.rightMargin = 0;
                    layoutParams3.leftMargin = 0;
                    view.setLayoutParams(layoutParams3);
                    ImageView imageView3 = new ImageView(getContext());
                    this.mLoadingView = imageView3;
                    imageView3.setId(R.id.ef8);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams4.addRule(0, view.getId());
                    layoutParams4.addRule(15);
                    layoutParams4.rightMargin = ViewUtils.dip2px(7.0f);
                    this.mLoadingParent.addView(this.mLoadingView, layoutParams4);
                    Drawable drawable = getResources().getDrawable(R.drawable.common_loading5);
                    this.mLoadingView.setImageDrawable(drawable);
                    if (drawable instanceof Animatable) {
                        ((Animatable) drawable).start();
                    }
                }
                if (this.mLoadingView.getVisibility() != 0) {
                    this.mLoadingView.setVisibility(0);
                }
                return true;
            }
        } else if (this.f317120ad == null) {
            this.f317120ad = getResources().getDrawable(R.drawable.common_loading5);
            this.mOldDrawables = this.centerView.getCompoundDrawables();
            this.mOldPadding = this.centerView.getCompoundDrawablePadding();
            this.centerView.setCompoundDrawablePadding(10);
            TextView textView = this.centerView;
            Drawable drawable2 = this.f317120ad;
            Drawable[] drawableArr = this.mOldDrawables;
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawableArr[1], drawableArr[2], drawableArr[3]);
            ((Animatable) this.f317120ad).start();
            return true;
        }
        return false;
    }

    public boolean stopTitleProgress() {
        if (this.mUseOptimizMode && this.mLoadingParent != null) {
            ImageView imageView = this.mLoadingView;
            if (imageView != null && imageView.getVisibility() != 8) {
                this.mLoadingView.setVisibility(8);
                return true;
            }
        } else {
            Object obj = this.f317120ad;
            if (obj != null) {
                ((Animatable) obj).stop();
                this.f317120ad = null;
                this.centerView.setCompoundDrawablePadding(this.mOldPadding);
                TextView textView = this.centerView;
                Drawable[] drawableArr = this.mOldDrawables;
                textView.setCompoundDrawablesWithIntrinsicBounds(drawableArr[0], drawableArr[1], drawableArr[2], drawableArr[3]);
                return true;
            }
        }
        return false;
    }

    public void toggleAnim(boolean z16, Animator.AnimatorListener animatorListener) {
        if (this.animView == null) {
            if (!z16) {
                return;
            }
            View view = new View(getContext());
            this.animView = view;
            view.setBackgroundResource(R.drawable.qui_bg_nav_secondary);
            addView(this.animView, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (z16) {
            this.animView.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator()).setListener(animatorListener);
        } else {
            this.animView.animate().alpha(0.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator()).setListener(animatorListener);
        }
    }

    public void updateRedDot(int i3, boolean z16) {
        View findViewById;
        int i16;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        findViewById = null;
                    } else {
                        findViewById = findViewById(R.id.dsl);
                    }
                } else {
                    findViewById = findViewById(R.id.dsq);
                }
            } else {
                findViewById = findViewById(R.id.f165895dt2);
            }
        } else {
            findViewById = findViewById(R.id.f165894dt1);
        }
        if (findViewById != null) {
            if (z16) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            findViewById.setVisibility(i16);
        }
    }

    public void changeBg(boolean z16, boolean z17) {
        ColorStateList colorStateList = getResources().getColorStateList(R.color.qui_common_text_nav_secondary);
        int tokenRes = TokenResUtils.getTokenRes(R.drawable.top_back_left_selector, R.drawable.qui_chevron_left_icon_navigation_01_selector);
        setBackgroundResource(R.drawable.qui_bg_nav_secondary);
        this.leftView.setTextColor(colorStateList);
        if (TokenResUtils.useTokenIcon()) {
            Drawable drawable = getResources().getDrawable(tokenRes);
            int f16 = BaseAIOUtils.f(24.0f, getResources());
            drawable.setBounds(0, 0, f16, f16);
            this.leftView.setBackgroundDrawable(null);
            this.leftView.setCompoundDrawables(drawable, null, null, null);
        } else {
            this.leftView.setBackgroundResource(tokenRes);
            clearBackDrawableLeft();
        }
        this.leftViewNotBack.setTextColor(colorStateList);
        this.mLeftBackText.setTextColor(colorStateList);
        this.centerView.setTextColor(colorStateList);
        this.rightViewText.setTextColor(colorStateList);
        this.rightViewText2.setTextColor(colorStateList);
    }

    public void setRightImage(Drawable drawable, Drawable drawable2) {
        this.rightViewImg1.setVisibility(0);
        this.rightViewText.setVisibility(8);
        this.rightViewImg1.setImageDrawable(drawable);
        this.rightViewImg1.setBackgroundDrawable(drawable2);
    }

    public NavBarCommon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNotShowLeftText = true;
        this.mUseOptimizMode = false;
        init(context);
    }

    public void setLeftButton(String str) {
        this.leftView.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeftButton);
        this.leftViewNotBack = textView;
        setLayerType(textView);
        this.leftViewNotBack.setVisibility(0);
        this.leftViewNotBack.setText(str);
    }

    public void setTitle(CharSequence charSequence, String str) {
        TextView textView = this.centerView;
        if (textView != null) {
            if (textView.getVisibility() != 0) {
                this.centerView.setVisibility(0);
            }
            if (!TextUtils.equals(charSequence, this.centerView.getText())) {
                this.centerView.setText(charSequence);
            }
            if (!TextUtils.equals(str, this.centerView.getContentDescription()) && QQUIAppSetting.enableTalkBack()) {
                this.centerView.setContentDescription(str);
            }
        }
        RelativeLayout relativeLayout = this.titleContainer;
        if (relativeLayout == null || relativeLayout.getVisibility() == 8) {
            return;
        }
        this.titleContainer.setVisibility(8);
    }

    public void setRightButton(String str) {
        this.rightViewText.setVisibility(0);
        this.rightViewImg1.setVisibility(8);
        this.rightViewText.setText(str);
        this.rightViewText.setEnabled(true);
        if (QQUIAppSetting.enableTalkBack()) {
            this.rightViewText.setContentDescription(((Object) this.rightViewText.getText()) + HardCodeUtil.qqStr(R.string.odv));
        }
    }

    public NavBarCommon(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mNotShowLeftText = true;
        this.mUseOptimizMode = false;
        init(context);
    }

    public void setTitle(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        if (this.centerView.getVisibility() != 8) {
            this.centerView.setVisibility(8);
        }
        if (this.titleContainer.getVisibility() != 0) {
            this.titleContainer.setVisibility(0);
        }
        if (!TextUtils.equals(charSequence, this.topTitle.getText())) {
            this.topTitle.setText(charSequence);
            this.topTitle.setContentDescription(charSequence2);
        }
        if (!TextUtils.equals(charSequence3, this.bottomTitle.getText())) {
            this.bottomTitle.setText(charSequence3);
            this.bottomTitle.setContentDescription(charSequence4);
        }
        this.topTitle.setTextSize(1, TextUtils.isEmpty(this.bottomTitle.getText()) ? 17.0f : 16.0f);
    }

    public void setLeftViewName(int i3) {
        if (this.leftView != null) {
            TextView textView = this.leftViewNotBack;
            if (textView != null) {
                textView.setVisibility(8);
            }
            String string = getContext().getString(i3);
            TextView textView2 = this.leftView;
            if ("".equals(string)) {
                string = getContext().getString(R.string.button_back);
            }
            if (this.mNotShowLeftText) {
                textView2.setText("  ");
            } else {
                textView2.setText(string);
            }
            textView2.setVisibility(0);
            if (QQUIAppSetting.enableTalkBack()) {
                if (!string.contains(getContext().getString(R.string.button_back))) {
                    string = getContext().getString(R.string.button_back) + string;
                }
                this.leftView.setContentDescription(string);
            }
        }
    }
}
