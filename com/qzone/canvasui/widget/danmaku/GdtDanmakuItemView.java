package com.qzone.canvasui.widget.danmaku;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.util.g;
import com.tencent.ad.tangram.util.AdUIUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes39.dex */
public class GdtDanmakuItemView extends TextView {
    private static final String DEFAULT_BACKGROUND_COLOR = "#993C3C3C";
    private static final String DEFAULT_TEXT_COLOR = "#FFFFFFFF";
    private ObjectAnimator mAnimator;

    public GdtDanmakuItemView(Context context) {
        this(context, null);
    }

    public void initStyle() {
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        setTextColor(Color.parseColor(DEFAULT_TEXT_COLOR));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(AdUIUtils.dp2px(11.0f, getResources()));
        gradientDrawable.setColor(Color.parseColor(DEFAULT_BACKGROUND_COLOR));
        setBackground(gradientDrawable);
        setLayoutParams(layoutParams);
        setPadding(g.a(10.0f), g.a(3.0f), g.a(10.0f), g.a(3.0f));
        setClickable(true);
    }

    public GdtDanmakuItemView setAnimator(ObjectAnimator objectAnimator) {
        this.mAnimator = objectAnimator;
        return this;
    }

    public boolean start() {
        ObjectAnimator objectAnimator = this.mAnimator;
        if (objectAnimator == null) {
            return false;
        }
        objectAnimator.start();
        return true;
    }

    public GdtDanmakuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initStyle();
    }
}
