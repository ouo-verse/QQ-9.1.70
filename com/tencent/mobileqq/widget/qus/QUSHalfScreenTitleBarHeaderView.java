package com.tencent.mobileqq.widget.qus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQUIAppSetting;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUSHalfScreenTitleBarHeaderView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    public ImageView f317250d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f317251e;

    /* renamed from: f, reason: collision with root package name */
    public QUSHalfScreenFloatingView f317252f;

    /* renamed from: h, reason: collision with root package name */
    private final float f317253h;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView = QUSHalfScreenTitleBarHeaderView.this.f317252f;
            if (qUSHalfScreenFloatingView != null) {
                qUSHalfScreenFloatingView.t();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QUSHalfScreenTitleBarHeaderView(Context context) {
        this(context, null);
    }

    protected int a(int i3) {
        return (int) ((i3 * this.f317253h) + 0.5f);
    }

    public void setHalfScreenView(QUSHalfScreenFloatingView qUSHalfScreenFloatingView) {
        this.f317252f = qUSHalfScreenFloatingView;
    }

    public void setThemeId(int i3) {
        this.f317251e.setTextColor(ie0.a.f().h(getContext(), R.color.qui_common_text_primary, i3));
    }

    public void setTitle(String str) {
        this.f317251e.setText(str);
        if (QQUIAppSetting.enableTalkBack()) {
            AccessibilityUtil.m(this.f317251e);
        }
    }

    public QUSHalfScreenTitleBarHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public QUSHalfScreenTitleBarHeaderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f317253h = getContext().getResources().getDisplayMetrics().density;
        TextView textView = new TextView(getContext());
        this.f317251e = textView;
        textView.setTextSize(17.0f);
        this.f317251e.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
        this.f317251e.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(13);
        addView(this.f317251e, layoutParams);
        ImageView imageView = new ImageView(getContext());
        this.f317250d = imageView;
        imageView.setImageDrawable(getContext().getDrawable(R.drawable.qui_close_selector));
        this.f317250d.setContentDescription(HardCodeUtil.qqStr(R.string.f170202in));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a(24), a(24));
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        layoutParams2.setMargins(0, 0, a(10), 0);
        addView(this.f317250d, layoutParams2);
        this.f317250d.setOnClickListener(new a());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, a(44));
        layoutParams3.topMargin = a(8);
        setLayoutParams(layoutParams3);
    }
}
