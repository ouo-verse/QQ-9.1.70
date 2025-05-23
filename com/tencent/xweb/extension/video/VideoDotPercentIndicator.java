package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;

/* loaded from: classes27.dex */
public class VideoDotPercentIndicator extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public LayoutInflater f385130a;

    /* renamed from: b, reason: collision with root package name */
    public int f385131b;

    public VideoDotPercentIndicator(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f385130a = LayoutInflater.from(context);
        setDotsNum(0);
    }

    public void setDotsNum(int i3) {
        if (i3 <= 1) {
            i3 = 8;
        }
        this.f385131b = i3;
        removeAllViews();
        for (int i16 = 0; i16 < this.f385131b; i16++) {
            addView((ImageView) this.f385130a.inflate(R.layout.i8o, (ViewGroup) this, false));
        }
    }

    public void setProgress(float f16) {
        int rint = (int) Math.rint(Math.min(Math.max(f16 / 100.0f, 0.0f), 1.0f) * this.f385131b);
        int i3 = 0;
        while (i3 < rint && i3 < getChildCount()) {
            ((ImageView) getChildAt(i3)).setImageResource(R.drawable.m7h);
            i3++;
        }
        while (i3 < getChildCount()) {
            ((ImageView) getChildAt(i3)).setImageResource(R.drawable.m7g);
            i3++;
        }
    }

    public VideoDotPercentIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public VideoDotPercentIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context);
    }
}
