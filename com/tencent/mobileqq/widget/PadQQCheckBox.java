package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes20.dex */
public class PadQQCheckBox extends LinearLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f315949d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f315950e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f315951f;

    /* renamed from: h, reason: collision with root package name */
    private CharSequence f315952h;

    public PadQQCheckBox(Context context) {
        super(context);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        setChecked(!this.f315951f);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i3;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.f315951f) {
            i3 = R.string.f172272oz2;
        } else {
            i3 = R.string.f172271oz1;
        }
        accessibilityNodeInfo.setContentDescription(((Object) this.f315952h) + HardCodeUtil.qqStr(i3));
    }

    public void setChecked(boolean z16) {
        this.f315951f = z16;
        if (z16) {
            this.f315949d.setImageResource(R.drawable.bqn);
        } else {
            this.f315949d.setImageResource(R.drawable.bqm);
        }
        refreshDrawableState();
    }

    public void setText(CharSequence charSequence) {
        if (this.f315950e != null && !TextUtils.isEmpty(charSequence)) {
            this.f315952h = charSequence;
            this.f315950e.setText(charSequence);
        }
    }

    public PadQQCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.M4);
        this.f315951f = obtainStyledAttributes.getBoolean(jj2.b.N4, true);
        this.f315952h = obtainStyledAttributes.getString(jj2.b.O4);
        LayoutInflater.from(context).inflate(R.layout.f168355tp, (ViewGroup) this, true);
        this.f315949d = (ImageView) findViewById(R.id.f164792ax1);
        this.f315950e = (TextView) findViewById(R.id.ax_);
        setChecked(this.f315951f);
        this.f315950e.setText(this.f315952h);
        obtainStyledAttributes.recycle();
        setOnClickListener(this);
    }
}
