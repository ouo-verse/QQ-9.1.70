package com.tencent.mobileqq.qwallet.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQWalletTransferBubbleView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    int f279303d;

    /* renamed from: e, reason: collision with root package name */
    boolean f279304e;

    /* renamed from: f, reason: collision with root package name */
    int f279305f;

    /* renamed from: h, reason: collision with root package name */
    LightingColorFilter f279306h;

    public QQWalletTransferBubbleView(Context context) {
        super(context);
        this.f279305f = 255;
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f279306h == null) {
            return;
        }
        Drawable drawable = getResources().getDrawable(this.f279303d);
        drawable.setBounds(0, 0, getWidth(), getHeight());
        drawable.setColorFilter(this.f279306h);
        drawable.setAlpha(this.f279305f);
        if (this.f279304e) {
            drawable.draw(canvas);
            return;
        }
        canvas.save();
        canvas.scale(-1.0f, 1.0f, getWidth() / 2, getHeight() / 2);
        drawable.draw(canvas);
        canvas.restore();
    }

    public void setBubbleBackground(int i3, int i16, boolean z16) {
        this.f279303d = i3;
        this.f279304e = z16;
        this.f279306h = new LightingColorFilter(Color.argb(255, 0, 0, 0), i16);
        this.f279305f = 255;
    }

    public void setBubbleNightBackground(int i3, int i16, boolean z16) {
        this.f279303d = i3;
        this.f279304e = z16;
        this.f279306h = new LightingColorFilter(Color.argb(255, 0, 0, 0), i16);
        this.f279305f = 178;
    }

    public QQWalletTransferBubbleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f279305f = 255;
        setWillNotDraw(false);
    }

    public QQWalletTransferBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f279305f = 255;
        setWillNotDraw(false);
    }
}
