package com.tencent.timi.game.profile.impl.view.forbidden;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import yn4.d;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ForbiddenDurationItemView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f379004d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f379005e;

    /* renamed from: f, reason: collision with root package name */
    private int f379006f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f379007h;

    public ForbiddenDurationItemView(Context context) {
        super(context);
        b();
    }

    private void b() {
        f();
    }

    private void c() {
        TextView textView = new TextView(getContext());
        this.f379005e = textView;
        textView.setTextSize(16.0f);
        this.f379005e.setTextColor(-16777216);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15, -1);
        layoutParams.addRule(1, R.id.vdo);
        layoutParams.leftMargin = ViewUtils.dip2px(14.0f);
        this.f379005e.setLayoutParams(layoutParams);
        addView(this.f379005e);
    }

    private void d() {
        TextView textView = new TextView(getContext());
        this.f379004d = textView;
        textView.setId(R.id.vdo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f));
        layoutParams.addRule(15, -1);
        this.f379004d.setLayoutParams(layoutParams);
        addView(this.f379004d);
    }

    private void e() {
        View view = new View(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(0.5f));
        layoutParams.addRule(12, -1);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(-1513240);
        addView(view);
    }

    private void f() {
        d();
        c();
        e();
    }

    public int a() {
        return this.f379006f;
    }

    public boolean g() {
        return this.f379007h;
    }

    public void setItemSelect(boolean z16) {
        this.f379007h = z16;
        if (z16) {
            this.f379004d.setBackgroundResource(R.drawable.oap);
        } else {
            this.f379004d.setBackgroundResource(R.drawable.lrn);
        }
    }

    public void setSecondData(int i3) {
        this.f379006f = i3;
        if (i3 == 0) {
            this.f379005e.setText("\u89e3\u9664\u7981\u8a00");
        } else {
            this.f379005e.setText(d.e(i3));
        }
    }

    public ForbiddenDurationItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public ForbiddenDurationItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b();
    }
}
