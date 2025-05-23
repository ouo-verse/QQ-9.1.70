package com.tencent.gdtad.views.canvas.components.danmaku;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.ad.tangram.util.AdUIUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes6.dex */
public final class GdtDanmakuItemView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private ObjectAnimator f109603d;

    public GdtDanmakuItemView(Context context) {
        this(context, null);
    }

    public void a() {
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        setTextColor(Color.parseColor("#FFFFFFFF"));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(AdUIUtils.dp2px(11.0f, getResources()));
        gradientDrawable.setColor(Color.parseColor("#993C3C3C"));
        setBackground(gradientDrawable);
        setLayoutParams(layoutParams);
        setPadding(AdUIUtils.dp2px(10.0f, getResources()), AdUIUtils.dp2px(2.0f, getResources()), AdUIUtils.dp2px(10.0f, getResources()), AdUIUtils.dp2px(2.0f, getResources()));
        setClickable(true);
    }

    @NonNull
    public GdtDanmakuItemView b(ObjectAnimator objectAnimator) {
        this.f109603d = objectAnimator;
        return this;
    }

    public boolean c() {
        ObjectAnimator objectAnimator = this.f109603d;
        if (objectAnimator == null) {
            return false;
        }
        objectAnimator.start();
        return true;
    }

    public GdtDanmakuItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
