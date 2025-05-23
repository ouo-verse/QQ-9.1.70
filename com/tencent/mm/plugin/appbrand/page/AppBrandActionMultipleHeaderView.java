package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AppBrandActionMultipleHeaderView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public ImageView f152228a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f152229b;

    /* renamed from: c, reason: collision with root package name */
    public int f152230c;

    /* renamed from: d, reason: collision with root package name */
    public String f152231d;

    /* renamed from: e, reason: collision with root package name */
    public String f152232e;

    /* renamed from: f, reason: collision with root package name */
    public String f152233f;

    public AppBrandActionMultipleHeaderView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dyy, this);
        this.f152228a = (ImageView) findViewById(R.id.sud);
        this.f152229b = (TextView) findViewById(R.id.sue);
    }

    public String getH5Url() {
        return this.f152231d;
    }

    public ImageView getImageView() {
        return this.f152228a;
    }

    public String getPath() {
        return this.f152233f;
    }

    public int getType() {
        return this.f152230c;
    }

    public String getUsername() {
        return this.f152232e;
    }

    public void setImageDrawable(Drawable drawable) {
        this.f152228a.setImageDrawable(drawable);
    }

    public void setImageResource(int i3) {
        this.f152228a.setImageResource(i3);
    }

    public void setTextViewText(String str) {
        this.f152229b.setText(str);
    }

    public void setTextViewTextColor(int i3) {
        this.f152229b.setTextColor(i3);
    }

    public AppBrandActionMultipleHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    @TargetApi(11)
    public AppBrandActionMultipleHeaderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context);
    }
}
