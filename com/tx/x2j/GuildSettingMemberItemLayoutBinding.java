package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
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
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildSettingMemberItemLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public GuildUserAvatarView f387432a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f387433b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387434c;

    /* renamed from: d, reason: collision with root package name */
    public View f387435d;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        Log.e("X2J", "invalid root attr \uff1aLinearLayout {parent=ViewGroup.LayoutParams, key=android:layout_gravity, value=center}");
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        Log.e("X2J", "invalid root attr \uff1aLinearLayout {parent=AbsListView.LayoutParams, key=android:layout_gravity, value=center}");
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        layoutParams.gravity = 17;
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        layoutParams.gravity = 17;
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        layoutParams.gravity = 17;
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        Log.e("X2J", "invalid root attr \uff1aLinearLayout {parent=RelativeLayout.LayoutParams, key=android:layout_gravity, value=center}");
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        Log.e("X2J", "invalid root attr \uff1aLinearLayout {parent=ConstraintLayout.LayoutParams, key=android:layout_gravity, value=center}");
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (TypedValue.applyDimension(1, 79.0f, displayMetrics) + 0.5f);
        Log.e("X2J", "invalid root attr \uff1aLinearLayout {parent=RecyclerView.LayoutParams, key=android:layout_gravity, value=center}");
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387435d = linearLayout;
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) (TypedValue.applyDimension(1, 36.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 36.0f, displayMetrics) + 0.5f);
        GuildUserAvatarView guildUserAvatarView = new GuildUserAvatarView(context, null);
        this.f387432a = guildUserAvatarView;
        guildUserAvatarView.setId(R.id.f165880xy3);
        this.f387432a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        linearLayout.addView(this.f387432a, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) (TypedValue.applyDimension(1, 36.0f, displayMetrics) + 0.5f);
        layoutParams2.height = (int) (TypedValue.applyDimension(1, 36.0f, displayMetrics) + 0.5f);
        ImageView imageView = new ImageView(context, null);
        this.f387433b = imageView;
        imageView.setId(R.id.xwg);
        this.f387433b.setVisibility(8);
        linearLayout.addView(this.f387433b, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = (int) (TypedValue.applyDimension(1, 60.0f, displayMetrics) + 0.5f);
        layoutParams3.topMargin = (int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f);
        TextView textView = new TextView(context, null);
        this.f387434c = textView;
        textView.setId(R.id.xy6);
        this.f387434c.setTextSize(0, (int) (TypedValue.applyDimension(1, 13.0f, displayMetrics) + 0.5f));
        this.f387434c.setEllipsize(TextUtils.TruncateAt.END);
        this.f387434c.setMaxLines(1);
        this.f387434c.setGravity(1);
        this.f387434c.setTextColor(resources.getColor(R.color.qui_common_text_primary));
        linearLayout.addView(this.f387434c, layoutParams3);
        return linearLayout;
    }

    public View u() {
        return this.f387435d;
    }
}
