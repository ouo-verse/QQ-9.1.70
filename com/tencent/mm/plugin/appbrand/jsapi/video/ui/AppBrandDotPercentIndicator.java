package com.tencent.mm.plugin.appbrand.jsapi.video.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;

/* loaded from: classes9.dex */
public class AppBrandDotPercentIndicator extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public LayoutInflater f152190a;

    /* renamed from: b, reason: collision with root package name */
    public int f152191b;

    public AppBrandDotPercentIndicator(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f152190a = LayoutInflater.from(context);
    }

    public void setDotsNum(int i3) {
        if (i3 <= 1) {
            i3 = 8;
        }
        this.f152191b = i3;
        removeAllViews();
        for (int i16 = 0; i16 < this.f152191b; i16++) {
            addView((ImageView) this.f152190a.inflate(R.layout.dxw, (ViewGroup) this, false));
        }
    }

    public void setPercent(float f16) {
        if (f16 < 0.0f) {
            f16 = 0.0f;
        }
        if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        int rint = (int) Math.rint(this.f152191b * f16);
        int i3 = 0;
        w.g("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:%s dotsOnNum:%d", Float.valueOf(f16), Integer.valueOf(rint));
        while (i3 < rint && i3 < getChildCount()) {
            ((ImageView) getChildAt(i3)).setImageResource(R.drawable.j_e);
            i3++;
        }
        while (i3 < getChildCount()) {
            ((ImageView) getChildAt(i3)).setImageResource(R.drawable.j_d);
            i3++;
        }
    }

    public AppBrandDotPercentIndicator(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AppBrandDotPercentIndicator(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context);
    }
}
