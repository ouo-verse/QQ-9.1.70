package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildSettingMemberLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f387436a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f387437b;

    /* renamed from: c, reason: collision with root package name */
    public RecyclerView f387438c;

    /* renamed from: d, reason: collision with root package name */
    public View f387439d;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387439d = linearLayout;
        linearLayout.setOrientation(1);
        d.e(linearLayout);
        linearLayout.setBackground(context.getResources().getDrawable(R.drawable.qui_common_fill_light_secondary_round_8_bg_selector));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.setMarginStart((int) resources.getDimension(R.dimen.da8));
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f387436a = linearLayout2;
        linearLayout2.setId(R.id.wqq);
        this.f387436a.setGravity(16);
        this.f387436a.setOrientation(0);
        this.f387436a.setPadding(0, (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f));
        linearLayout.addView(this.f387436a, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams2.weight = 1.0f;
        TextView textView = new TextView(context, null);
        textView.setText("\u9891\u9053\u6210\u5458");
        textView.setTextSize(0, (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        textView.setTextColor(resources.getColor(R.color.qui_common_text_primary));
        this.f387436a.addView(textView, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        TextView textView2 = new TextView(context, null);
        this.f387437b = textView2;
        textView2.setId(R.id.wqp);
        this.f387437b.setTextSize(0, (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f));
        this.f387437b.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387436a.addView(this.f387437b, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams4.height = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams4.gravity = 16;
        layoutParams4.setMarginStart((int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f));
        layoutParams4.setMarginEnd((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        ImageView imageView = new ImageView(context, null);
        d.e(imageView);
        imageView.setBackground(context.getResources().getDrawable(R.drawable.qui_chevron_right_icon_secondary_01));
        this.f387436a.addView(imageView, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.width = -1;
        RecyclerView recyclerView = new RecyclerView(context, null);
        this.f387438c = recyclerView;
        recyclerView.setId(R.id.wqw);
        this.f387438c.setPadding(0, 0, 0, (int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f));
        linearLayout.addView(this.f387438c, layoutParams5);
        return linearLayout;
    }

    public View u() {
        return this.f387439d;
    }
}
