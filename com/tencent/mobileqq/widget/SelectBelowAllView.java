package com.tencent.mobileqq.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SelectBelowAllView extends RelativeLayout {
    private View C;

    /* renamed from: d, reason: collision with root package name */
    private Context f316225d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f316226e;

    /* renamed from: f, reason: collision with root package name */
    protected int f316227f;

    /* renamed from: h, reason: collision with root package name */
    protected MutliSeletedBottomLine f316228h;

    /* renamed from: i, reason: collision with root package name */
    protected MutliSeletedBottomLine f316229i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f316230m;

    public SelectBelowAllView(Context context) {
        super(context);
        this.f316225d = context;
        this.f316227f = ViewUtils.dpToPx(44.0f);
        LayoutInflater.from(context).inflate(R.layout.dwb, this);
        this.f316226e = (TextView) findViewById(R.id.f82134g2);
        this.f316230m = (RelativeLayout) findViewById(R.id.sjx);
        this.C = findViewById(R.id.sjw);
        a(this.f316230m);
    }

    private void a(RelativeLayout relativeLayout) {
        int N = (int) com.tencent.mobileqq.utils.ah.N(true);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f316226e.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredWidth = ((N - this.f316226e.getMeasuredWidth()) - com.tencent.mobileqq.util.x.c(this.f316225d, 16.0f)) / 2;
        if (measuredWidth < 0) {
            measuredWidth = 0;
        }
        this.f316228h = new MutliSeletedBottomLine(this.f316225d, measuredWidth, this.f316227f, false);
        this.f316229i = new MutliSeletedBottomLine(this.f316225d, measuredWidth, this.f316227f, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(measuredWidth, -1);
        layoutParams.addRule(9);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(measuredWidth, -1);
        layoutParams2.addRule(11);
        relativeLayout.addView(this.f316228h, layoutParams);
        relativeLayout.addView(this.f316229i, layoutParams2);
    }

    public void b() {
        RelativeLayout relativeLayout = this.f316230m;
        if (relativeLayout != null) {
            relativeLayout.removeView(this.f316228h);
            this.f316230m.removeView(this.f316229i);
            a(this.f316230m);
            invalidate();
        }
    }

    public void setCheckedNum(int i3) {
        StringBuilder sb5 = new StringBuilder();
        if (i3 == 0) {
            sb5.append("\u9009\u62e9\u4ee5\u4e0b\u6d88\u606f");
        } else {
            sb5.append("\u9009\u62e9\u4ee5\u4e0b\u6d88\u606f(\u5df2\u9009" + i3 + "\u6761)");
        }
        this.f316226e.setText(sb5.toString());
        this.f316226e.setContentDescription(sb5.toString());
        b();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.C.setOnClickListener(onClickListener);
    }
}
