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
public class AppBrandActionSingleHeaderView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public ImageView f152234a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f152235b;

    public AppBrandActionSingleHeaderView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dyz, this);
        this.f152234a = (ImageView) findViewById(R.id.suj);
        this.f152235b = (TextView) findViewById(R.id.suk);
    }

    public ImageView getImageView() {
        return this.f152234a;
    }

    public void setImageDrawable(Drawable drawable) {
        this.f152234a.setImageDrawable(drawable);
    }

    public void setImageResource(int i3) {
        this.f152234a.setImageResource(i3);
    }

    public void setTextViewText(String str) {
        this.f152235b.setText(str);
    }

    public void setTextViewTextColor(int i3) {
        this.f152235b.setTextColor(i3);
    }

    public AppBrandActionSingleHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    @TargetApi(11)
    public AppBrandActionSingleHeaderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context);
    }
}
