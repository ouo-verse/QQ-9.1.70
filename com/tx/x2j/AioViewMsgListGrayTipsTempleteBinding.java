package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.holder.template.BubbleLayoutCompatPress;
import com.tencent.qqnt.aio.holder.template.TemplateLayout;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AioViewMsgListGrayTipsTempleteBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public TemplateLayout f387194a;

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f387195b;

    /* renamed from: c, reason: collision with root package name */
    public BubbleLayoutCompatPress f387196c;

    /* renamed from: d, reason: collision with root package name */
    public View f387197d;

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
        TemplateLayout templateLayout = new TemplateLayout(context, null);
        this.f387194a = templateLayout;
        this.f387197d = templateLayout;
        templateLayout.setId(R.id.vsd);
        this.f387194a.setPadding(0, (int) resources.getDimension(R.dimen.f158700mp), 0, (int) resources.getDimension(R.dimen.f158700mp));
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.validate();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387195b = frameLayout;
        frameLayout.setId(R.id.f166336f24);
        this.f387194a.addView(this.f387195b, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = -1;
        layoutParams2.topToBottom = R.id.f166336f24;
        layoutParams2.startToStart = 0;
        layoutParams2.validate();
        BubbleLayoutCompatPress bubbleLayoutCompatPress = new BubbleLayoutCompatPress(context, null);
        this.f387196c = bubbleLayoutCompatPress;
        bubbleLayoutCompatPress.setId(R.id.zfv);
        this.f387196c.setFocusable(true);
        this.f387196c.setClickable(true);
        this.f387196c.setGravity(17);
        this.f387196c.setOrientation(1);
        this.f387194a.addView(this.f387196c, layoutParams2);
        return this.f387194a;
    }

    public View u() {
        return this.f387197d;
    }
}
