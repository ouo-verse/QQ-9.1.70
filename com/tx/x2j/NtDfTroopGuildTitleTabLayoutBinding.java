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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.widget.AioTopGuildTab;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NtDfTroopGuildTitleTabLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public RelativeLayout f387448a;

    /* renamed from: b, reason: collision with root package name */
    public AioTopGuildTab f387449b;

    /* renamed from: c, reason: collision with root package name */
    public AioTopGuildTab f387450c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f387451d;

    /* renamed from: e, reason: collision with root package name */
    public View f387452e;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=ViewGroup.LayoutParams, key=android:layout_toStartOf, value=@+id/right1_iv}");
        layoutParams.height = -1;
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=ViewGroup.LayoutParams, key=android:layout_centerVertical, value=true}");
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=AbsListView.LayoutParams, key=android:layout_toStartOf, value=@+id/right1_iv}");
        layoutParams.height = -1;
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=AbsListView.LayoutParams, key=android:layout_centerVertical, value=true}");
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=FrameLayout.LayoutParams, key=android:layout_toStartOf, value=@+id/right1_iv}");
        layoutParams.height = -1;
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=FrameLayout.LayoutParams, key=android:layout_centerVertical, value=true}");
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=LinearLayout.LayoutParams, key=android:layout_toStartOf, value=@+id/right1_iv}");
        layoutParams.height = -1;
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=LinearLayout.LayoutParams, key=android:layout_centerVertical, value=true}");
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=RadioGroup.LayoutParams, key=android:layout_toStartOf, value=@+id/right1_iv}");
        layoutParams.height = -1;
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=RadioGroup.LayoutParams, key=android:layout_centerVertical, value=true}");
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.addRule(16, R.id.f74333vz);
        layoutParams.height = -1;
        layoutParams.addRule(15, -1);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=ConstraintLayout.LayoutParams, key=android:layout_toStartOf, value=@+id/right1_iv}");
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=ConstraintLayout.LayoutParams, key=android:layout_centerVertical, value=true}");
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=RecyclerView.LayoutParams, key=android:layout_toStartOf, value=@+id/right1_iv}");
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
        Log.e("X2J", "invalid root attr \uff1aRelativeLayout {parent=RecyclerView.LayoutParams, key=android:layout_centerVertical, value=true}");
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387448a = relativeLayout;
        this.f387452e = relativeLayout;
        relativeLayout.setId(R.id.x2r);
        this.f387448a.setClipChildren(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.height = -1;
        layoutParams.addRule(15, -1);
        layoutParams.setMarginStart((int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f));
        layoutParams.setMarginEnd((int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        AioTopGuildTab aioTopGuildTab = new AioTopGuildTab(context, null);
        this.f387449b = aioTopGuildTab;
        aioTopGuildTab.setId(R.id.zgr);
        this.f387449b.setContentDescription(resources.getString(R.string.yu6));
        this.f387448a.addView(this.f387449b, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.height = -1;
        layoutParams2.addRule(17, R.id.zgr);
        layoutParams2.addRule(15, -1);
        layoutParams2.setMarginEnd((int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        AioTopGuildTab aioTopGuildTab2 = new AioTopGuildTab(context, null);
        this.f387450c = aioTopGuildTab2;
        aioTopGuildTab2.setId(R.id.v3k);
        this.f387450c.setContentDescription(resources.getString(R.string.yu5));
        this.f387450c.setClipChildren(false);
        this.f387448a.addView(this.f387450c, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        layoutParams3.height = (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f);
        layoutParams3.addRule(12, -1);
        layoutParams3.setMarginStart((int) (TypedValue.applyDimension(1, 16.5f, displayMetrics) + 0.5f));
        ImageView imageView = new ImageView(context, null);
        this.f387451d = imageView;
        imageView.setId(R.id.f101935wj);
        this.f387451d.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f387451d.setImageDrawable(context.getResources().getDrawable(R.drawable.j7z));
        this.f387451d.setPadding(0, 0, 0, (int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f));
        this.f387448a.addView(this.f387451d, layoutParams3);
        return this.f387448a;
    }
}
