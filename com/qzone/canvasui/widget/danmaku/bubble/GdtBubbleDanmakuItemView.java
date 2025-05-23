package com.qzone.canvasui.widget.danmaku.bubble;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.util.g;

/* compiled from: P */
/* loaded from: classes39.dex */
class GdtBubbleDanmakuItemView extends TextView {
    private static final String BACKGROUND_COLOR = "#993C3C3C";
    private static final float INIT_ALPHA = 1.0f;
    private static final String TAG = "GDTBubbleDanmakuItemView";
    private static final String TEXT_COLOR = "#FFFFFFFF";
    private static final int TEXT_SIZE = 14;
    protected int mStatus;

    public GdtBubbleDanmakuItemView(Context context) {
        super(context);
        this.mStatus = 0;
        initItemViewStyle();
    }

    private void initItemViewStyle() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(g.a(11.0f));
        gradientDrawable.setColor(Color.parseColor(BACKGROUND_COLOR));
        setPadding(g.a(10.0f), g.a(3.0f), g.a(10.0f), g.a(3.0f));
        setBackground(gradientDrawable);
        setTextColor(Color.parseColor(TEXT_COLOR));
        setAlpha(1.0f);
        setSingleLine(true);
        setTextSize(14.0f);
    }
}
