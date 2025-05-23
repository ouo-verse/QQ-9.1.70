package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;

/* compiled from: P */
@RemoteViews.RemoteView
/* loaded from: classes10.dex */
public class BreathAnimationLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private boolean f179325d;

    /* renamed from: e, reason: collision with root package name */
    private long f179326e;

    public BreathAnimationLayout(Context context) {
        super(context);
        this.f179325d = false;
        this.f179326e = -1L;
    }

    @Override // android.view.View
    @TargetApi(21)
    public void draw(Canvas canvas) {
        if (this.f179325d) {
            Drawable background = getBackground();
            if (background != null) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                if (this.f179326e == -1) {
                    this.f179326e = currentAnimationTimeMillis;
                }
                int min = Math.min(255, (int) ((((Math.sin((((currentAnimationTimeMillis - this.f179326e) % 1600) / 1600.0d) * 6.283185307179586d) + 1.0d) / 2.0d) * 255.0d) + 0.5d));
                background.setBounds(0, 0, getWidth(), getHeight());
                background.setState(View.PRESSED_ENABLED_STATE_SET);
                background.draw(canvas);
                int saveLayerAlpha = canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), min);
                background.setState(View.EMPTY_STATE_SET);
                background.draw(canvas);
                canvas.restoreToCount(saveLayerAlpha);
                return;
            }
            return;
        }
        super.draw(canvas);
    }

    public void setAnimating(boolean z16) {
        if (this.f179325d != z16) {
            this.f179325d = z16;
            this.f179326e = -1L;
            if (!z16) {
                refreshDrawableState();
            }
            invalidate();
        }
    }

    public BreathAnimationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f179325d = false;
        this.f179326e = -1L;
    }

    public BreathAnimationLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f179325d = false;
        this.f179326e = -1L;
    }
}
