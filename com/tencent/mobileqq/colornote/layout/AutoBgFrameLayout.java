package com.tencent.mobileqq.colornote.layout;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AutoBgFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    public static ColorFilter f201407d = new PorterDuffColorFilter(QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_SUPERFAST_AVAIL_RAM, PorterDuff.Mode.SRC_ATOP);

    public AutoBgFrameLayout(Context context) {
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
                background2.setColorFilter(f201407d);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public AutoBgFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoBgFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
