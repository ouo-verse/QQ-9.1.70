package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.r;

/* loaded from: classes39.dex */
public class DrawPicArea extends SubArea implements r {
    private Drawable mDrawable;

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        Drawable drawable = this.mDrawable;
        if (drawable == null) {
            return true;
        }
        drawable.setBounds(0, 0, this.mWidth, this.mHeight);
        this.mDrawable.draw(canvas);
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getHeight() {
        return this.mWidth;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getWidth() {
        return this.mHeight;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean onTouchEvent(MotionEvent motionEvent, SubAreaShell subAreaShell, boolean z16) {
        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
            if (motionEvent.getAction() == 1) {
                if (subAreaShell != null) {
                    subAreaShell.onAreaClicked(this, null);
                }
            } else if (motionEvent.getAction() != 3) {
                motionEvent.getAction();
            }
        }
        return true;
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.mDrawable = null;
    }

    public boolean setData(Drawable drawable, int i3, int i16) {
        if (drawable == null) {
            return false;
        }
        this.mDrawable = drawable;
        this.mWidth = i3;
        this.mHeight = i16;
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void clearTouchingEvent() {
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
    }
}
