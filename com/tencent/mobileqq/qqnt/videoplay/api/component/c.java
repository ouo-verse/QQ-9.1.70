package com.tencent.mobileqq.qqnt.videoplay.api.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public RelativeLayout f274185a;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f274186b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f274187c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f274188d;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @SuppressLint({"NewApi"})
    public View a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f274186b = relativeLayout;
        this.f274185a = relativeLayout;
        relativeLayout.setId(R.id.alq);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14, -1);
        TextView textView = new TextView(context, null);
        this.f274187c = textView;
        textView.setId(R.id.hvh);
        this.f274187c.setText("0KB/s");
        this.f274187c.setTextSize(0, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics));
        this.f274187c.setVisibility(8);
        this.f274187c.setTextColor(Color.parseColor("#FFFFFF"));
        this.f274186b.addView(this.f274187c, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, R.id.hvh);
        layoutParams2.addRule(14, -1);
        TextView textView2 = new TextView(context, null);
        this.f274188d = textView2;
        textView2.setId(R.id.jmx);
        this.f274188d.setText(R.string.f169973yi4);
        this.f274188d.setTextSize(0, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics));
        this.f274188d.setTextColor(Color.parseColor("#80FFFFFF"));
        this.f274186b.addView(this.f274188d, layoutParams2);
        return this.f274186b;
    }

    public View b(Context context, ViewGroup viewGroup) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) viewGroup);
        }
        if (viewGroup != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        return c(context, viewGroup, z16);
    }

    public View c(Context context, ViewGroup viewGroup, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, viewGroup, Boolean.valueOf(z16));
        }
        return a(context);
    }
}
