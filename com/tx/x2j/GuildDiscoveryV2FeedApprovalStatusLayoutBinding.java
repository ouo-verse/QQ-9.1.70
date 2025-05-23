package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.mobileqq.R;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GuildDiscoveryV2FeedApprovalStatusLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public QUITagView f387263a;

    /* renamed from: b, reason: collision with root package name */
    public View f387264b;

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        layoutParams.validate();
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        context.getResources().getDisplayMetrics();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387264b = frameLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        QUITagView qUITagView = new QUITagView(context, null);
        this.f387263a = qUITagView;
        qUITagView.setId(R.id.vyp);
        frameLayout.addView(this.f387263a, layoutParams);
        return frameLayout;
    }
}
