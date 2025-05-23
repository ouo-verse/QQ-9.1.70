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
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayoutV2;
import com.tencent.mobileqq.colornote.smallscreen.NoteFlowerView;
import ty4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ColorNoteSmallscreenNewBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public View f387206a;

    /* renamed from: b, reason: collision with root package name */
    public NoteFlowerView f387207b;

    /* renamed from: c, reason: collision with root package name */
    public View f387208c;

    /* renamed from: d, reason: collision with root package name */
    public View f387209d;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = (int) resources.getDimension(R.dimen.c75);
        layoutParams.height = (int) resources.getDimension(R.dimen.f158506c74);
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = (int) resources.getDimension(R.dimen.c75);
        layoutParams.height = (int) resources.getDimension(R.dimen.f158506c74);
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = (int) resources.getDimension(R.dimen.c75);
        layoutParams.height = (int) resources.getDimension(R.dimen.f158506c74);
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = (int) resources.getDimension(R.dimen.c75);
        layoutParams.height = (int) resources.getDimension(R.dimen.f158506c74);
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = (int) resources.getDimension(R.dimen.c75);
        layoutParams.height = (int) resources.getDimension(R.dimen.f158506c74);
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = (int) resources.getDimension(R.dimen.c75);
        layoutParams.height = (int) resources.getDimension(R.dimen.f158506c74);
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) resources.getDimension(R.dimen.c75);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) resources.getDimension(R.dimen.f158506c74);
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) resources.getDimension(R.dimen.c75);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) resources.getDimension(R.dimen.f158506c74);
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ColorNoteSmallScreenRelativeLayoutV2 colorNoteSmallScreenRelativeLayoutV2 = new ColorNoteSmallScreenRelativeLayoutV2(context, null);
        this.f387209d = colorNoteSmallScreenRelativeLayoutV2;
        colorNoteSmallScreenRelativeLayoutV2.setElevation((int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) resources.getDimension(R.dimen.f158504c72);
        layoutParams.height = (int) resources.getDimension(R.dimen.f158504c72);
        View view = new View(context, null);
        this.f387206a = view;
        view.setId(R.id.f164842u11);
        this.f387206a.setVisibility(8);
        colorNoteSmallScreenRelativeLayoutV2.addView(this.f387206a, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) resources.getDimension(R.dimen.f158505c73);
        layoutParams2.height = (int) resources.getDimension(R.dimen.f158505c73);
        NoteFlowerView noteFlowerView = new NoteFlowerView(context, null);
        this.f387207b = noteFlowerView;
        noteFlowerView.setId(R.id.u0z);
        colorNoteSmallScreenRelativeLayoutV2.addView(this.f387207b, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
        layoutParams3.height = (int) (TypedValue.applyDimension(1, 50.0f, displayMetrics) + 0.5f);
        layoutParams3.addRule(13, -1);
        View view2 = new View(context, null);
        this.f387208c = view2;
        view2.setId(R.id.cgl);
        this.f387208c.setFocusable(true);
        colorNoteSmallScreenRelativeLayoutV2.addView(this.f387208c, layoutParams3);
        return colorNoteSmallScreenRelativeLayoutV2;
    }
}
