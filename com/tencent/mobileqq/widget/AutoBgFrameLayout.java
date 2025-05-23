package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AutoBgFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    public static ColorFilter f315438d = new PorterDuffColorFilter(QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_SUPERFAST_AVAIL_RAM, PorterDuff.Mode.SRC_ATOP);

    public AutoBgFrameLayout(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable background;
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && (background = getBackground()) != null) {
                background.setColorFilter(null);
                background.invalidateSelf();
            }
        } else {
            Drawable background2 = getBackground();
            if (background2 != null) {
                background2.setColorFilter(f315438d);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public AutoBgFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoBgFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
