package com.tencent.mobileqq.guild.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

@TargetApi(14)
/* loaded from: classes14.dex */
public class PressDarkUrlImageView extends URLImageView {
    public PressDarkUrlImageView(Context context) {
        this(context, null, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (isPressed()) {
            setColorFilter(R.color.f156942fw);
        } else {
            clearColorFilter();
        }
    }

    public PressDarkUrlImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PressDarkUrlImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
