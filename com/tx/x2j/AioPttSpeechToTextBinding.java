package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.qqnt.aio.widget.SelectableTextView;
import ty4.c;

/* loaded from: classes27.dex */
public class AioPttSpeechToTextBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public SelectableLinearLayout f387098a;

    /* renamed from: b, reason: collision with root package name */
    public SelectableTextView f387099b;

    /* renamed from: c, reason: collision with root package name */
    public View f387100c;

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        layoutParams.validate();
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387100c = frameLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        SelectableLinearLayout selectableLinearLayout = new SelectableLinearLayout(context, null);
        this.f387098a = selectableLinearLayout;
        selectableLinearLayout.setId(R.id.f28840k1);
        this.f387098a.setVisibility(8);
        this.f387098a.setPadding((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 9.5f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 9.5f, displayMetrics) + 0.5f));
        frameLayout.addView(this.f387098a, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        SelectableTextView selectableTextView = new SelectableTextView(context, null);
        this.f387099b = selectableTextView;
        selectableTextView.setId(R.id.f28850k2);
        this.f387099b.setTextSize(0, (int) (TypedValue.applyDimension(2, 17.0f, displayMetrics) + 0.5f));
        this.f387098a.addView(this.f387099b, layoutParams2);
        return frameLayout;
    }
}
