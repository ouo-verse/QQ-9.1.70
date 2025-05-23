package com.tencent.mobileqq.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SelectTouchBarView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private Context f316231d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f316232e;

    /* renamed from: f, reason: collision with root package name */
    protected MutliSeletedBottomLine f316233f;

    /* renamed from: h, reason: collision with root package name */
    protected MutliSeletedBottomLine f316234h;

    /* renamed from: i, reason: collision with root package name */
    private int f316235i;

    public SelectTouchBarView(Context context) {
        super(context);
        this.f316235i = -1;
        this.f316231d = context;
        LayoutInflater.from(context).inflate(R.layout.c6l, this);
        this.f316232e = (TextView) findViewById(R.id.l9j);
        a((RelativeLayout) findViewById(R.id.l9i));
    }

    protected void a(RelativeLayout relativeLayout) {
        int N = (int) com.tencent.mobileqq.utils.ah.N(true);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f316232e.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredWidth = ((N - this.f316232e.getMeasuredWidth()) - com.tencent.mobileqq.util.x.c(this.f316231d, 16.0f)) / 2;
        if (measuredWidth < 0) {
            measuredWidth = 0;
        }
        this.f316233f = new MutliSeletedBottomLine(this.f316231d, measuredWidth, false);
        this.f316234h = new MutliSeletedBottomLine(this.f316231d, measuredWidth, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(measuredWidth, -2);
        layoutParams.addRule(9);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(measuredWidth, -2);
        layoutParams2.addRule(11);
        relativeLayout.addView(this.f316233f, layoutParams);
        relativeLayout.addView(this.f316234h, layoutParams2);
    }

    public void b() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.l9i);
        relativeLayout.removeView(this.f316233f);
        relativeLayout.removeView(this.f316234h);
        a(relativeLayout);
        invalidate();
    }

    public void setCheckedNum(int i3) {
        StringBuilder sb5 = new StringBuilder();
        if (i3 == 0) {
            sb5.append("\u9009\u62e9\u5230\u8fd9\u91cc");
        } else {
            sb5.append("\u9009\u62e9\u5230\u8fd9\u91cc(\u5df2\u9009" + i3 + "\u6761)");
        }
        this.f316232e.setText(sb5.toString());
        this.f316232e.setContentDescription(sb5.toString());
        b();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f316232e.setOnClickListener(onClickListener);
    }
}
