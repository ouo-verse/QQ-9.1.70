package com.tencent.mobileqq.colornote.anim;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MusicDanceImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f201354d;

    public MusicDanceImageView(Context context) {
        super(context);
        this.f201354d = true;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.f201354d) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.f201354d) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (!this.f201354d) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
        } else {
            super.onMeasure(i3, i16);
        }
    }

    public void setShouldDraw(boolean z16) {
        this.f201354d = z16;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (i3 == 0) {
            setShouldDraw(true);
        } else if (i3 == 8 || i3 == 4) {
            setShouldDraw(false);
        }
    }

    public MusicDanceImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f201354d = true;
    }

    public MusicDanceImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f201354d = true;
    }
}
