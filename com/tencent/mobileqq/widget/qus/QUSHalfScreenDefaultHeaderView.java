package com.tencent.mobileqq.widget.qus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUSHalfScreenDefaultHeaderView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private QUSBaseHalfScreenFloatingView f317247d;

    public QUSHalfScreenDefaultHeaderView(Context context) {
        this(context, null);
    }

    private void b() {
        QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView = this.f317247d;
        if (qUSBaseHalfScreenFloatingView != null) {
            qUSBaseHalfScreenFloatingView.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        b();
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setFloatingView(QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView) {
        this.f317247d = qUSBaseHalfScreenFloatingView;
    }

    public QUSHalfScreenDefaultHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public QUSHalfScreenDefaultHeaderView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(getContext().getDrawable(R.drawable.qui_halfscreen_default_header_drag_icon));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(imageView, layoutParams);
        setLayoutParams(new FrameLayout.LayoutParams(-1, ViewUtils.dpToPx(14.0f)));
        if (AccessibilityUtil.j(context)) {
            AccessibilityUtil.p(imageView, HardCodeUtil.qqStr(R.string.f170202in));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.widget.qus.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QUSHalfScreenDefaultHeaderView.this.c(view);
                }
            });
        }
    }
}
