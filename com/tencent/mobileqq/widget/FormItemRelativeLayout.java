package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.utils.QQTheme;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FormItemRelativeLayout extends RelativeLayout {
    static boolean mNeedFocusBg = true;
    private int mBgType;
    private final Paint mPaint;
    private final Rect mRect;
    private boolean mUseCardUI;

    public FormItemRelativeLayout(Context context) {
        this(context, null);
    }

    private boolean isDefTheme() {
        return QQTheme.isDefaultOrDIYTheme();
    }

    protected Drawable getSelectorByTypeInternal(Resources resources, int i3) {
        return o.h(resources, i3, mNeedFocusBg, this.mUseCardUI);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (o.l() && this.mUseCardUI) {
            return;
        }
        int i3 = this.mBgType;
        if (i3 == 1 || i3 == 2) {
            if (isDefTheme()) {
                this.mPaint.setColor(FormItemConstants.COLOR_DEFAULT_BG_DIVIDER);
            } else {
                this.mPaint.setColor(0);
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.mRect.set(FormItemConstants.PADDING_DEFAULT_BG_DIVIDER, measuredHeight - FormItemConstants.HEIGHT_DEFAULT_BG_DIVIDER, measuredWidth, measuredHeight);
            canvas.drawRect(this.mRect, this.mPaint);
        }
    }

    public void setBGType(int i3) {
        this.mBgType = i3;
        setBackgroundDrawable(getSelectorByTypeInternal(getResources(), this.mBgType));
    }

    public void setNeedFocusBg(boolean z16) {
        mNeedFocusBg = z16;
    }

    public void setUseCardUI(boolean z16) {
        this.mUseCardUI = z16;
    }

    public FormItemRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRect = new Rect();
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mBgType = 0;
        this.mUseCardUI = true;
        paint.setAntiAlias(true);
        paint.setColor(FormItemConstants.COLOR_DEFAULT_BG_DIVIDER);
        setBackgroundDrawable(getSelectorByTypeInternal(getResources(), this.mBgType));
    }
}
