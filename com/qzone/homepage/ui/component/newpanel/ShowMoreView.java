package com.qzone.homepage.ui.component.newpanel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ShowMoreView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f47749d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f47750e;

    /* renamed from: f, reason: collision with root package name */
    private View f47751f;

    /* renamed from: h, reason: collision with root package name */
    private View f47752h;

    public ShowMoreView(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        this.f47752h = LayoutInflater.from(context).inflate(R.layout.bvd, this);
        this.f47750e = (TextView) findViewById(R.id.f0n);
        this.f47749d = (TextView) findViewById(R.id.f0q);
        this.f47751f = findViewById(R.id.f06);
        this.f47749d.setTextColor(getResources().getColor(R.color.qzone_skin_homepanel_text_second_color));
    }

    public void a() {
        TextView textView = this.f47750e;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void c(int i3) {
        int i16;
        String str;
        TextView textView = this.f47749d;
        if (textView != null) {
            i16 = getResources().getString(R.string.cau).equals(textView.getText().toString()) ? 7 : 8;
        } else {
            i16 = 0;
        }
        TextView textView2 = this.f47750e;
        if (textView2 != null && textView2.getVisibility() == 0) {
            str = "1";
        } else {
            str = "0";
        }
        LpReportInfo_pf00064.allReport(126, i16, i3, str);
    }

    public void d() {
        TextView textView = this.f47750e;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void e(Drawable drawable) {
        View view = this.f47751f;
        if (view != null) {
            view.setBackground(drawable);
        }
    }

    public void f(String str) {
        TextView textView = this.f47749d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setBackgroundStyle(Drawable drawable, int i3) {
        View view = this.f47752h;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
        }
        TextView textView = this.f47749d;
        if (textView != null) {
            textView.setTextColor(i3);
        }
    }

    public ShowMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public ShowMoreView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b(context);
    }
}
