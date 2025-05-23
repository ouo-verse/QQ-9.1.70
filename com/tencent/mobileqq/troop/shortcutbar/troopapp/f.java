package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f298804a;

    /* renamed from: b, reason: collision with root package name */
    public URLImageView f298805b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f298806c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f298807d;

    /* renamed from: e, reason: collision with root package name */
    public View f298808e;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @SuppressLint({"NewApi"})
    public View a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f298808e = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.height = (int) TypedValue.applyDimension(1, 26.0f, displayMetrics);
        layoutParams.topMargin = (int) TypedValue.applyDimension(1, 5.0f, displayMetrics);
        layoutParams.bottomMargin = (int) TypedValue.applyDimension(1, 5.0f, displayMetrics);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f298804a = linearLayout2;
        linearLayout2.setId(R.id.ir7);
        this.f298804a.setOrientation(0);
        linearLayout.addView(this.f298804a, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) TypedValue.applyDimension(1, 16.0f, displayMetrics);
        layoutParams2.height = (int) TypedValue.applyDimension(1, 16.0f, displayMetrics);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = (int) TypedValue.applyDimension(1, 10.0f, displayMetrics);
        layoutParams2.rightMargin = (int) TypedValue.applyDimension(1, 2.0f, displayMetrics);
        URLImageView uRLImageView = new URLImageView(context, null);
        this.f298805b = uRLImageView;
        uRLImageView.setId(R.id.ir8);
        this.f298804a.addView(this.f298805b, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        layoutParams3.rightMargin = (int) TypedValue.applyDimension(1, 10.0f, displayMetrics);
        TextView textView = new TextView(context, null);
        this.f298806c = textView;
        textView.setId(R.id.iru);
        this.f298806c.setTextSize(0, (int) TypedValue.applyDimension(1, 13.0f, displayMetrics));
        this.f298806c.setSingleLine(true);
        this.f298806c.setTextColor(resources.getColor(R.color.qui_common_text_primary));
        this.f298804a.addView(this.f298806c, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = (int) TypedValue.applyDimension(1, -12.0f, displayMetrics);
        layoutParams4.rightMargin = (int) TypedValue.applyDimension(1, 4.0f, displayMetrics);
        layoutParams4.bottomMargin = (int) TypedValue.applyDimension(1, 8.0f, displayMetrics);
        TextView textView2 = new TextView(context, null);
        this.f298807d = textView2;
        textView2.setId(R.id.irt);
        this.f298807d.setTextSize(0, (int) TypedValue.applyDimension(1, 8.0f, displayMetrics));
        this.f298807d.setIncludeFontPadding(false);
        this.f298807d.setTextColor(resources.getColor(R.color.f158017al3));
        this.f298804a.addView(this.f298807d, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) TypedValue.applyDimension(1, 8.0f, displayMetrics);
        layoutParams5.height = (int) TypedValue.applyDimension(1, 26.0f, displayMetrics);
        linearLayout.addView(new View(context, null), layoutParams5);
        return linearLayout;
    }

    public View b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        try {
            return a(context);
        } catch (Exception unused) {
            LayoutInflater.from(context).inflate(R.layout.bvm, (ViewGroup) null);
            return null;
        }
    }
}
