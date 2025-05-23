package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* loaded from: classes20.dex */
public final class ProgressView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f316013d;

    public ProgressView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.baj, this);
        this.f316013d = (TextView) findViewById(R.id.jfb);
        findViewById(R.id.f164600a83).setBackgroundColor(Color.parseColor("#1c1c1d"));
    }

    public void setProgressText(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            this.f316013d.setVisibility(0);
            this.f316013d.setText(charSequence);
        } else {
            this.f316013d.setVisibility(8);
        }
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
