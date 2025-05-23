package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FormMultiLineSwitchItem extends FormSwitchItem {

    /* renamed from: d, reason: collision with root package name */
    TextView f315654d;

    /* renamed from: e, reason: collision with root package name */
    TextView f315655e;

    /* renamed from: f, reason: collision with root package name */
    String f315656f;

    public FormMultiLineSwitchItem(Context context) {
        this(context, null);
    }

    private void initViews() {
        TextView textView = getTextView();
        this.f315654d = textView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.addRule(15, 0);
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.f158557iv);
        this.f315654d.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.f315655e = new TextView(getContext());
        if (!TextUtils.isEmpty(this.f315656f)) {
            this.f315655e.setText(this.f315656f);
        }
        if (AppSetting.f99565y) {
            AccessibilityUtil.n(this.f315655e, false);
            setContentDescription(((Object) this.f315654d.getText()) + " " + this.f315656f);
        }
        this.f315655e.setSingleLine(false);
        this.f315655e.setDuplicateParentStateEnabled(true);
        this.f315655e.setMaxWidth(ViewUtils.getScreenWidth() - ViewUtils.dip2px(96.0f));
        layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.f158548il);
        layoutParams2.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.f158554ir);
        layoutParams2.leftMargin = getResources().getDimensionPixelSize(R.dimen.aes);
        layoutParams2.addRule(3, R.id.cjp);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158570j9);
        this.f315655e.setTextColor(getResources().getColorStateList(R.color.skin_gray2));
        this.f315655e.setTextSize(0, dimensionPixelSize);
        this.f315655e.setGravity(19);
        addView(this.f315655e, layoutParams2);
    }

    public void setSecendLineClick(View.OnClickListener onClickListener) {
        this.f315655e.setOnClickListener(onClickListener);
    }

    public void setSecendLineText(String str) {
        this.f315655e.setText(str);
        if (AppSetting.f99565y) {
            setContentDescription(((Object) this.f315654d.getText()) + " " + this.f315656f);
        }
    }

    public void setSecondLineTextViewVisibility(int i3) {
        TextView textView = this.f315655e;
        if (textView != null) {
            textView.setVisibility(i3);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f315654d.getLayoutParams();
            if (i3 == 8) {
                setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.f158564j2));
                layoutParams.addRule(15, -1);
            } else {
                layoutParams.addRule(15, 0);
            }
        }
    }

    public FormMultiLineSwitchItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNeedSetHeight = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FormItem);
        this.f315656f = obtainStyledAttributes.getString(R.styleable.FormItem_switchSubText);
        obtainStyledAttributes.recycle();
        initViews();
    }

    public void setSecendLineText(Spanned spanned) {
        this.f315655e.setText(spanned);
        if (AppSetting.f99565y) {
            setContentDescription(((Object) this.f315654d.getText()) + " " + this.f315656f);
        }
    }
}
