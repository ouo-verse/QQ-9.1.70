package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqui.widget.AutoBgImageView;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AioRevokeGrayTipsBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public TextView f387137a;

    /* renamed from: b, reason: collision with root package name */
    public AutoBgImageView f387138b;

    /* renamed from: c, reason: collision with root package name */
    public View f387139c;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=ViewGroup.LayoutParams, key=android:layout_gravity, value=center_horizontal}");
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=AbsListView.LayoutParams, key=android:layout_gravity, value=center_horizontal}");
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.gravity = 1;
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.gravity = 1;
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.gravity = 1;
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=RelativeLayout.LayoutParams, key=android:layout_gravity, value=center_horizontal}");
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=ConstraintLayout.LayoutParams, key=android:layout_gravity, value=center_horizontal}");
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=RecyclerView.LayoutParams, key=android:layout_gravity, value=center_horizontal}");
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f387139c = constraintLayout;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.startToStart = 0;
        layoutParams.topToTop = 0;
        layoutParams.endToStart = R.id.vs8;
        layoutParams.setMarginStart((int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f));
        layoutParams.validate();
        TextView textView = new TextView(context, null);
        this.f387137a = textView;
        textView.setLinkTextColor(ColorStateList.valueOf(resources.getColor(R.color.qui_common_text_link)));
        this.f387137a.setTextSize(0, (int) (TypedValue.applyDimension(2, 12.0f, displayMetrics) + 0.5f));
        this.f387137a.setMaxWidth((int) (TypedValue.applyDimension(1, 200.0f, displayMetrics) + 0.5f));
        this.f387137a.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387137a.setId(R.id.vsi);
        TextView textView2 = this.f387137a;
        textView2.setLineSpacing(textView2.getLineSpacingExtra(), 1.0f);
        this.f387137a.setVisibility(0);
        this.f387137a.setPadding((int) (TypedValue.applyDimension(1, 9.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 9.0f, displayMetrics) + 0.5f), 0);
        constraintLayout.addView(this.f387137a, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams2.bottomToBottom = 0;
        layoutParams2.leftToRight = R.id.vsi;
        layoutParams2.topToTop = 0;
        layoutParams2.endToEnd = 0;
        layoutParams2.setMarginEnd((int) resources.getDimension(R.dimen.f158228ax));
        layoutParams2.validate();
        AutoBgImageView autoBgImageView = new AutoBgImageView(context, null);
        this.f387138b = autoBgImageView;
        autoBgImageView.setId(R.id.vs8);
        this.f387138b.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_close_filled_icon_secondary_01));
        constraintLayout.addView(this.f387138b, layoutParams2);
        return constraintLayout;
    }

    public View u() {
        return this.f387139c;
    }
}
