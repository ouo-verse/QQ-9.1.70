package com.tencent.ad.tangram.widget.bubble;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
final class GdtBubbleDanmakuItemView extends TextView {
    private static final int BACKGROUND_ALPHA = 76;
    private static final String BACKGROUND_COLOR = "#000000";
    private static final int CORNER_RADIUS = 60;
    private static final float INIT_ALPHA = 1.0f;
    private static final int PADDING_BOTTOM = 4;
    private static final int PADDING_LEFT = 12;
    private static final int PADDING_RIGHT = 12;
    private static final int PADDING_TOP = 4;
    private static final String TAG = "GdtBubbleDanmakuItemView";
    private static final String TEXT_COLOR = "#FFFFFFFF";
    private static final int TEXT_SIZE = 12;
    public int status;

    public GdtBubbleDanmakuItemView(Context context) {
        super(context);
        this.status = 0;
        initItemViewStyle();
    }

    private void initItemViewStyle() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(GdtDisplayUtil.dpToPx(getContext(), 60));
        gradientDrawable.setColor(Color.parseColor(BACKGROUND_COLOR));
        setPadding(GdtDisplayUtil.dpToPx(getContext(), 12), GdtDisplayUtil.dpToPx(getContext(), 4), GdtDisplayUtil.dpToPx(getContext(), 12), GdtDisplayUtil.dpToPx(getContext(), 4));
        gradientDrawable.setAlpha(76);
        setBackground(gradientDrawable);
        setTextColor(Color.parseColor(TEXT_COLOR));
        setAlpha(1.0f);
        setSingleLine(true);
        setTextSize(12.0f);
    }
}
