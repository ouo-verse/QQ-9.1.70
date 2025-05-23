package com.tencent.biz.qqcircle.comment.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes4.dex */
public class q implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private View f84063d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f84064e;

    /* renamed from: f, reason: collision with root package name */
    private View f84065f;

    /* renamed from: h, reason: collision with root package name */
    private View.OnClickListener f84066h;

    public q(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.g8y, (ViewGroup) null);
        this.f84063d = inflate;
        this.f84064e = (TextView) inflate.findViewById(R.id.f56622l4);
        this.f84065f = this.f84063d.findViewById(R.id.f57322n0);
        this.f84063d.setOnClickListener(this);
    }

    public View a() {
        return this.f84063d;
    }

    public void b(int i3) {
        this.f84065f.setVisibility(i3);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f84066h = onClickListener;
    }

    public void d(boolean z16) {
        int i3;
        View view = this.f84065f;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        view.setVisibility(i3);
        this.f84064e.setSelected(z16);
        this.f84064e.getPaint().setFakeBoldText(z16);
    }

    public void e(String str) {
        this.f84064e.setText(str);
    }

    public void f(@ColorInt int i3) {
        this.f84064e.setTextColor(i3);
    }

    public void g(ColorStateList colorStateList) {
        this.f84064e.setTextColor(colorStateList);
    }

    public void h(Typeface typeface) {
        this.f84064e.setTypeface(typeface);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        View.OnClickListener onClickListener = this.f84066h;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
