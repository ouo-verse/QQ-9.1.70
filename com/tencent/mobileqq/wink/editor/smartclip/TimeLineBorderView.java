package com.tencent.mobileqq.wink.editor.smartclip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;

/* compiled from: P */
/* loaded from: classes21.dex */
public class TimeLineBorderView extends RelativeLayout {

    /* renamed from: f, reason: collision with root package name */
    public static float f321470f = 226.0f;

    /* renamed from: d, reason: collision with root package name */
    private TextView f321471d;

    /* renamed from: e, reason: collision with root package name */
    private long f321472e;

    public TimeLineBorderView(Context context) {
        super(context);
        this.f321472e = 0L;
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hcz, this);
        this.f321471d = (TextView) findViewById(R.id.f111036k5);
        b();
    }

    public void b() {
        String str = String.format("%.1f", Float.valueOf(((float) this.f321472e) / 1000000.0f)) + ReportConstant.COSTREPORT_PREFIX;
        this.f321471d.setBackgroundResource(R.drawable.m36);
        this.f321471d.setText(str);
    }

    public TimeLineBorderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f321472e = 0L;
        a(context);
    }
}
