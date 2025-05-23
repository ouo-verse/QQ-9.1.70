package com.tencent.aelight.camera.aebase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMCameraCountTimeLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private View f66065d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f66066e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f66067f;

    public QIMCameraCountTimeLayout(Context context) {
        super(context);
        a();
    }

    public void setDotView(int i3) {
        this.f66065d.setBackgroundResource(i3);
    }

    public void setIsCircleStyle(boolean z16) {
        this.f66067f = z16;
    }

    public void setText(String str) {
        this.f66066e.setText(str);
    }

    public void setTextColor(int i3) {
        this.f66066e.setTextColor(i3);
    }

    public void setTextShadow(boolean z16) {
        TextView textView = this.f66066e;
        if (textView == null) {
            return;
        }
        if (z16) {
            textView.setShadowLayer(2.0f, 0.0f, 0.0f, R.color.by);
        } else {
            textView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (i3 == 0 && this.f66067f) {
            this.f66065d.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154394kg));
        }
    }

    private void a() {
        setOrientation(0);
        View view = new View(getContext());
        this.f66065d = view;
        view.setBackgroundResource(R.drawable.iul);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(6.0f), ViewUtils.dip2px(6.0f));
        layoutParams.gravity = 16;
        TextView textView = new TextView(getContext());
        this.f66066e = textView;
        if (this.f66067f) {
            addView(this.f66065d, layoutParams);
            this.f66066e.setText("0\u79d2");
            this.f66066e.setTextSize(14.0f);
            this.f66066e.setShadowLayer(2.0f, 0.0f, 0.0f, R.color.by);
            this.f66066e.setTextColor(getResources().getColor(R.color.f158017al3));
        } else {
            textView.setText(QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT);
            this.f66066e.setTextSize(18.0f);
            this.f66066e.setShadowLayer(2.0f, 0.0f, 0.0f, R.color.by);
            this.f66066e.setTextColor(getResources().getColor(R.color.f158017al3));
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = ViewUtils.dip2px(4.0f);
        addView(this.f66066e, layoutParams2);
    }

    public QIMCameraCountTimeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public QIMCameraCountTimeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
