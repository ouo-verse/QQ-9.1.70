package com.tencent.qqlive.tvkplayer.qqliveasset.subtitle;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSubtitleImageView extends AppCompatImageView {
    public TVKSubtitleImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(i3, i16);
    }
}
