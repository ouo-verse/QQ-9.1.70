package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.module.feedcomponent.ui.ViewArea;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.text.EmoCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedTextAreaEx extends FeedTextArea {
    public static final int IMG_SPACE = (int) (FeedGlobalEnv.g().getDensity() * 3.0f);
    public static final int dp16 = (int) (FeedGlobalEnv.g().getDensity() * 16.0f);
    int imgSpace;
    int mExtImgSpace;
    protected Drawable mLeftDrawable;
    protected int mLeftDrawableGravity;
    protected Object obj;
    public int oldHeightMeasureSpec;
    public int oldWidthMeasureSpec;

    public FeedTextAreaEx(int i3) {
        super(i3);
        this.mLeftDrawableGravity = 17;
        this.imgSpace = IMG_SPACE;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        if (this.mLeftDrawable != null) {
            if (this.mType != 23) {
                int i3 = AreaConst.LEFT_THUMB_TITLE_DEFAULT_MAX_LINE;
            }
            canvas.save();
            int i16 = this.mLeftDrawableGravity;
            if (i16 == 80) {
                canvas.translate(0.0f, this.mHeight - this.mLeftDrawable.getIntrinsicHeight());
            } else if (i16 == 17) {
                canvas.translate(0.0f, (this.mHeight - this.mLeftDrawable.getIntrinsicHeight()) / 2);
            }
            this.mLeftDrawable.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.translate(this.mLeftDrawable.getBounds().right + this.imgSpace + this.mExtImgSpace, 0.0f);
            super.draw(canvas, paint);
            canvas.restore();
            return true;
        }
        return super.draw(canvas, paint);
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea, com.qzone.module.feedcomponent.ui.ViewArea
    public Object getData() {
        return this.obj;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea
    public int getMeasuredWidth() {
        if (this.mLeftDrawable != null) {
            return this.mWidth;
        }
        return this.textLayout.getMeausredWidth();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        Drawable drawable = this.mLeftDrawable;
        int i17 = drawable == null ? 0 : drawable.getBounds().right;
        int i18 = this.mLeftDrawable != null ? this.imgSpace : 0;
        super.measure((mode == 1073741824 || (mode == 0 && size > 0)) ? ((size - i18) - this.mExtImgSpace) - i17 : i3, i16);
        this.mWidth = this.mWidth + i18 + this.mExtImgSpace + i17;
        this.oldWidthMeasureSpec = i3;
        this.oldHeightMeasureSpec = i16;
    }

    public void onStateIdle() {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.onStateIdle();
        }
    }

    public void onStateScrolling() {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.onStateScrolling();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.SubArea
    public boolean onTouchEvent(MotionEvent motionEvent, SubAreaShell subAreaShell, boolean z16) {
        if (this.mLeftDrawable != null) {
            motionEvent.offsetLocation(-(r0.getBounds().right + this.imgSpace + this.mExtImgSpace), 0.0f);
        }
        return super.onTouchEvent(motionEvent, subAreaShell, z16);
    }

    public void reset() {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.reset();
        }
    }

    public void setData(String str, int i3, Drawable drawable) {
        this.mLeftDrawable = drawable;
        if (drawable != null) {
            int max = Math.max(this.mFontHeight, dp16);
            int i16 = AreaConst.f48747dp2;
            drawable.setBounds(0, i16, max, max + i16);
        }
        super.setData(str, i3);
    }

    public void setExtImgSpace(int i3) {
        this.mExtImgSpace = i3;
    }

    public void setImageSpace(int i3) {
        this.imgSpace = i3;
    }

    public void setLeftDrawable(int i3) {
        Drawable drawable = FeedGlobalEnv.getContext().getResources().getDrawable(i3);
        this.mLeftDrawable = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mLeftDrawable.getIntrinsicHeight());
    }

    public void setLeftDrawableGravity(int i3) {
        this.mLeftDrawableGravity = i3;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.SubArea, com.qzone.module.feedcomponent.ui.ViewArea
    public void setMaxWidth(int i3) {
        Drawable drawable = this.mLeftDrawable;
        if (drawable != null) {
            i3 -= drawable.getBounds().width();
        }
        super.setMaxWidth(i3);
    }

    public void setText(String str) {
        setRichText(str);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.SubArea, com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void invalidate() {
        this.oldHeightMeasureSpec = 0;
        this.oldWidthMeasureSpec = 0;
        super.invalidate();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.SubArea, com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void requestLayout() {
        this.oldHeightMeasureSpec = 0;
        this.oldWidthMeasureSpec = 0;
        super.requestLayout();
    }

    public void setLeftDrawable(Drawable drawable) {
        this.mLeftDrawable = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mLeftDrawable.getIntrinsicHeight());
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea
    public boolean onTouchEvent(MotionEvent motionEvent, ViewArea.OnAreaClickedListener onAreaClickedListener, boolean z16) {
        if (this.mLeftDrawable != null) {
            motionEvent.offsetLocation(-(r0.getBounds().right + this.imgSpace + this.mExtImgSpace), 0.0f);
        }
        return super.onTouchEvent(motionEvent, onAreaClickedListener, z16);
    }

    public void setDataExtra(String str, String str2, Drawable drawable, int i3) {
        if (drawable != null) {
            drawable.setBounds(0, 0, i3, i3);
        }
        super.setData(str, (TextCell) new EmoCell(str2, drawable), false);
    }

    public void setData(String str, int i3, Drawable drawable, boolean z16) {
        this.mLeftDrawable = drawable;
        if (drawable != null) {
            int max = Math.max(this.mFontHeight, com.qzone.proxy.feedcomponent.text.h.f50745a);
            drawable.setBounds(0, 0, max, max);
        }
        super.setData(str, i3, z16);
    }

    public void setData(Object obj) {
        this.obj = obj;
    }
}
