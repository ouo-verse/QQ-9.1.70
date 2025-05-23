package com.tencent.mobileqq.qqnt.videoplay.api.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public RelativeLayout f274179a;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f274180b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f274181c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f274182d;

    public a() {
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
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f274180b = relativeLayout;
        this.f274179a = relativeLayout;
        relativeLayout.setId(R.id.fys);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        LinearLayout linearLayout = new LinearLayout(context, null);
        linearLayout.setOrientation(1);
        this.f274180b.addView(linearLayout, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        ImageView imageView = new ImageView(context, null);
        this.f274181c = imageView;
        imageView.setBackground(context.getResources().getDrawable(R.drawable.gnj));
        this.f274181c.setId(R.id.byb);
        linearLayout.addView(this.f274181c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        layoutParams3.topMargin = (int) TypedValue.applyDimension(1, 10.0f, displayMetrics);
        TextView textView = new TextView(context, null);
        this.f274182d = textView;
        textView.setId(R.id.uwy);
        this.f274182d.setText(R.string.yi5);
        this.f274182d.setTextSize(0, (int) TypedValue.applyDimension(2, 16.0f, displayMetrics));
        this.f274182d.setTextColor(resources.getColor(R.color.qui_common_text_secondary_02));
        linearLayout.addView(this.f274182d, layoutParams3);
        return this.f274180b;
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
