package com.tencent.qqnt.aio.audiopanel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.audiopanel.CircleProgressView;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateSquareView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ab {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ImageView f349674a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f349675b;

    /* renamed from: c, reason: collision with root package name */
    public CircleProgressView f349676c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f349677d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f349678e;

    /* renamed from: f, reason: collision with root package name */
    public VolumeIndicateSquareView f349679f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f349680g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f349681h;

    /* renamed from: i, reason: collision with root package name */
    public ChangeVoiceView f349682i;

    public ab() {
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
        ChangeVoiceView changeVoiceView = new ChangeVoiceView(context, null);
        this.f349682i = changeVoiceView;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) resources.getDimension(R.dimen.acr);
        layoutParams.height = (int) resources.getDimension(R.dimen.acr);
        layoutParams.addRule(10, -1);
        layoutParams.addRule(14, -1);
        layoutParams.topMargin = (int) TypedValue.applyDimension(1, 4.0f, displayMetrics);
        ImageView imageView = new ImageView(context, null);
        this.f349674a = imageView;
        imageView.setId(R.id.atc);
        this.f349674a.setScaleType(ImageView.ScaleType.FIT_XY);
        changeVoiceView.addView(this.f349674a, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) resources.getDimension(R.dimen.acr);
        layoutParams2.height = (int) resources.getDimension(R.dimen.acr);
        layoutParams2.addRule(6, R.id.atc);
        layoutParams2.addRule(5, R.id.atc);
        ImageView imageView2 = new ImageView(context, null);
        this.f349675b = imageView2;
        imageView2.setId(R.id.cco);
        this.f349675b.setScaleType(ImageView.ScaleType.FIT_XY);
        changeVoiceView.addView(this.f349675b, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = (int) resources.getDimension(R.dimen.acr);
        layoutParams3.height = (int) resources.getDimension(R.dimen.acr);
        layoutParams3.addRule(6, R.id.atc);
        layoutParams3.addRule(5, R.id.atc);
        CircleProgressView circleProgressView = new CircleProgressView(context, null);
        this.f349676c = circleProgressView;
        circleProgressView.setId(R.id.atd);
        this.f349676c.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f349676c.setVisibility(8);
        c(this.f349676c);
        this.f349676c.setBackground(context.getResources().getDrawable(R.drawable.aa5));
        changeVoiceView.addView(this.f349676c, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(6, R.id.atc);
        layoutParams4.addRule(14, -1);
        layoutParams4.topMargin = (int) TypedValue.applyDimension(1, 15.0f, displayMetrics);
        ImageView imageView3 = new ImageView(context, null);
        this.f349677d = imageView3;
        imageView3.setId(R.id.atg);
        this.f349677d.setVisibility(4);
        this.f349677d.setImageDrawable(context.getResources().getDrawable(R.drawable.c4f));
        changeVoiceView.addView(this.f349677d, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(3, R.id.atg);
        layoutParams5.addRule(14, -1);
        layoutParams5.topMargin = (int) TypedValue.applyDimension(1, -6.0f, displayMetrics);
        TextView textView = new TextView(context, null);
        this.f349678e = textView;
        textView.setId(R.id.ath);
        this.f349678e.setTextSize(0, (int) resources.getDimension(R.dimen.f159427acs));
        this.f349678e.setText("0.00");
        this.f349678e.setVisibility(4);
        this.f349678e.setTextColor(resources.getColor(R.color.f158017al3));
        changeVoiceView.addView(this.f349678e, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(2, R.id.ath);
        layoutParams6.addRule(14, -1);
        layoutParams6.bottomMargin = (int) TypedValue.applyDimension(1, 8.0f, displayMetrics);
        VolumeIndicateSquareView volumeIndicateSquareView = new VolumeIndicateSquareView(context, null);
        this.f349679f = volumeIndicateSquareView;
        volumeIndicateSquareView.setId(R.id.ati);
        this.f349679f.setVisibility(8);
        this.f349679f.setCount(6);
        this.f349679f.setSquareWidth((int) TypedValue.applyDimension(1, 2.0f, displayMetrics));
        this.f349679f.setColor(resources.getColor(R.color.f158017al3));
        changeVoiceView.addView(this.f349679f, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(3, R.id.atc);
        layoutParams7.addRule(14, -1);
        layoutParams7.topMargin = (int) TypedValue.applyDimension(1, 2.0f, displayMetrics);
        TextView textView2 = new TextView(context, null);
        this.f349680g = textView2;
        textView2.setId(R.id.ate);
        this.f349680g.setTextSize(0, (int) resources.getDimension(R.dimen.f159427acs));
        this.f349680g.setText(resources.getString(R.string.qlk));
        this.f349680g.setGravity(17);
        this.f349680g.setTextColor(resources.getColor(R.color.qui_common_text_primary));
        changeVoiceView.addView(this.f349680g, layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(5, R.id.atc);
        layoutParams8.leftMargin = (int) TypedValue.applyDimension(1, -5.0f, displayMetrics);
        ImageView imageView4 = new ImageView(context, null);
        this.f349681h = imageView4;
        imageView4.setId(R.id.flag_new);
        this.f349681h.setVisibility(8);
        this.f349681h.setImageDrawable(context.getResources().getDrawable(R.drawable.frx));
        changeVoiceView.addView(this.f349681h, layoutParams8);
        return changeVoiceView;
    }

    public View b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        try {
            return a(context);
        } catch (Exception unused) {
            LayoutInflater.from(context).inflate(R.layout.aqr, (ViewGroup) null);
            return null;
        }
    }

    public void c(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        Drawable background = view.getBackground();
        if (background != null && background.getPadding(new Rect())) {
            view.setPadding(0, 0, 0, 0);
        }
    }
}
