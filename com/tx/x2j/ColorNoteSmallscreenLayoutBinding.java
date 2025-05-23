package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.anim.MusicDanceImageView;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ColorNoteSmallscreenLayoutBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public ColorNoteSmallScreenRelativeLayout f387198a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f387199b;

    /* renamed from: c, reason: collision with root package name */
    public MusicDanceImageView f387200c;

    /* renamed from: d, reason: collision with root package name */
    public LinearLayout f387201d;

    /* renamed from: e, reason: collision with root package name */
    public MusicDanceImageView f387202e;

    /* renamed from: f, reason: collision with root package name */
    public View f387203f;

    /* renamed from: g, reason: collision with root package name */
    public RelativeLayout f387204g;

    /* renamed from: h, reason: collision with root package name */
    public View f387205h;

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        layoutParams.validate();
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        ColorNoteSmallScreenRelativeLayout colorNoteSmallScreenRelativeLayout = new ColorNoteSmallScreenRelativeLayout(context, null);
        this.f387198a = colorNoteSmallScreenRelativeLayout;
        this.f387205h = colorNoteSmallScreenRelativeLayout;
        colorNoteSmallScreenRelativeLayout.setId(R.id.ldr);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15, -1);
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f387199b = linearLayout;
        linearLayout.setId(R.id.f166889m90);
        this.f387199b.setOrientation(0);
        this.f387198a.addView(this.f387199b, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams2.gravity = 16;
        MusicDanceImageView musicDanceImageView = new MusicDanceImageView(context, null);
        this.f387200c = musicDanceImageView;
        musicDanceImageView.setId(R.id.lo9);
        this.f387199b.addView(this.f387200c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f387201d = linearLayout2;
        linearLayout2.setId(R.id.f166890m91);
        this.f387201d.setOrientation(1);
        this.f387199b.addView(this.f387201d, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.width = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams4.gravity = 16;
        MusicDanceImageView musicDanceImageView2 = new MusicDanceImageView(context, null);
        this.f387202e = musicDanceImageView2;
        musicDanceImageView2.setId(R.id.lo_);
        this.f387199b.addView(this.f387202e, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
        layoutParams5.height = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
        layoutParams5.addRule(13, -1);
        View view = new View(context, null);
        this.f387203f = view;
        view.setId(R.id.cgl);
        this.f387203f.setFocusable(true);
        this.f387198a.addView(this.f387203f, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.width = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
        layoutParams6.height = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
        layoutParams6.addRule(13, -1);
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387204g = relativeLayout;
        relativeLayout.setId(R.id.lfv);
        this.f387204g.setVisibility(8);
        d.e(this.f387204g);
        this.f387204g.setBackground(context.getResources().getDrawable(R.drawable.hbj));
        this.f387198a.addView(this.f387204g, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.width = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        layoutParams7.height = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        layoutParams7.addRule(13, -1);
        View view2 = new View(context, null);
        d.e(view2);
        view2.setBackground(context.getResources().getDrawable(R.drawable.cfw));
        this.f387204g.addView(view2, layoutParams7);
        return this.f387198a;
    }
}
