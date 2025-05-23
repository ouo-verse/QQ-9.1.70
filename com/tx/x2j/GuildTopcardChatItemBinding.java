package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
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
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildTopcardChatItemBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f387440a;

    /* renamed from: b, reason: collision with root package name */
    public GuildUserAvatarView f387441b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387442c;

    /* renamed from: d, reason: collision with root package name */
    public View f387443d;

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
        resources.getDisplayMetrics();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387443d = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.height = (int) resources.getDimension(R.dimen.f158714n4);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f387440a = linearLayout2;
        linearLayout2.setId(R.id.f100155rq);
        this.f387440a.setOrientation(0);
        linearLayout.addView(this.f387440a, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) resources.getDimension(R.dimen.f158711n0);
        layoutParams2.height = (int) resources.getDimension(R.dimen.f158711n0);
        layoutParams2.gravity = 16;
        layoutParams2.topMargin = (int) resources.getDimension(R.dimen.f158716n6);
        layoutParams2.bottomMargin = (int) resources.getDimension(R.dimen.f158716n6);
        layoutParams2.setMarginStart((int) resources.getDimension(R.dimen.f158720na));
        layoutParams2.setMarginEnd((int) resources.getDimension(R.dimen.f158723nd));
        GuildUserAvatarView guildUserAvatarView = new GuildUserAvatarView(context, null);
        this.f387441b = guildUserAvatarView;
        guildUserAvatarView.setId(R.id.f100145rp);
        this.f387440a.addView(this.f387441b, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        layoutParams3.topMargin = (int) resources.getDimension(R.dimen.f158726ng);
        layoutParams3.bottomMargin = (int) resources.getDimension(R.dimen.f158726ng);
        layoutParams3.setMarginEnd((int) resources.getDimension(R.dimen.f158723nd));
        TextView textView = new TextView(context, null);
        this.f387442c = textView;
        textView.setTextSize(0, (int) resources.getDimension(R.dimen.f158702mr));
        this.f387442c.setSingleLine(true);
        this.f387442c.setTextColor(resources.getColor(R.color.bts));
        this.f387442c.setId(R.id.f100165rr);
        this.f387442c.setEllipsize(TextUtils.TruncateAt.END);
        this.f387442c.setGravity(16);
        this.f387442c.setIncludeFontPadding(false);
        this.f387440a.addView(this.f387442c, layoutParams3);
        return linearLayout;
    }

    public View u() {
        return this.f387443d;
    }
}
