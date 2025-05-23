package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FormSwitchSimpleItem extends FormSwitchItem {

    /* renamed from: d, reason: collision with root package name */
    private TextView f315673d;

    public FormSwitchSimpleItem(Context context) {
        this(context, null);
    }

    private void b() {
        if (this.f315673d == null) {
            TextView textView = new TextView(getContext());
            this.f315673d = textView;
            textView.setTextSize(2, 14.0f);
            this.f315673d.setTextColor(getResources().getColorStateList(R.color.skin_gray_group_item));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.f159079vr);
            layoutParams.addRule(0, this.mSwitch.getId());
            layoutParams.addRule(15);
            addView(this.f315673d, layoutParams);
        }
    }

    public TextView a() {
        return this.f315673d;
    }

    public FormSwitchSimpleItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
