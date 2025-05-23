package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TextButtonArea extends SubArea {
    public static final int BTN_ICON_ID_NONE = -1;
    protected float mAscent;
    protected int mBtnHeight;
    protected int mBtnWidth;
    protected Drawable mCurDrawable;
    protected String mCurShowText;
    protected float mDescent;
    StateBtnInfo mDisableStateInfo;
    protected boolean mEnablePressState;
    protected boolean mIsEnable;
    StateBtnInfo mNormalStateInfo;
    StateBtnInfo mPressStateInfo;
    protected int mTextLeftOffset;
    protected Paint mTextPaint;
    protected float mTextSize;
    protected int mTextTopOffset;
    protected int mWordHeight;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class StateBtnInfo {
        public Drawable mDrawable;
        public int mDrawableAlpha;
        public int mTextAlpha;
        public int mTextColor;
        public String mTextContent;

        public void init(Drawable drawable, int i3, String str, int i16, int i17) {
            this.mDrawable = drawable;
            this.mDrawableAlpha = i3;
            this.mTextContent = str;
            this.mTextAlpha = i16;
            this.mTextColor = i17;
        }

        public boolean isHasDrawable() {
            return this.mDrawable != null;
        }

        public boolean isHasTextContent() {
            return !TextUtils.isEmpty(this.mTextContent);
        }
    }

    public TextButtonArea(int i3, float f16, int i16, int i17, Drawable drawable, String str, int i18) {
        this(i3, f16, i16, i17, drawable, null, null, str, str, i18, i18);
    }

    public void ReboundDrawable() {
        Drawable drawable = this.mNormalStateInfo.mDrawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, this.mBtnWidth, this.mBtnHeight);
        }
        Drawable drawable2 = this.mDisableStateInfo.mDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, this.mBtnWidth, this.mBtnHeight);
        }
        Drawable drawable3 = this.mPressStateInfo.mDrawable;
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, this.mBtnWidth, this.mBtnHeight);
        }
        postRequestLayout();
    }

    public void SetText(String str) {
        this.mNormalStateInfo.mTextContent = str;
        this.mPressStateInfo.mTextContent = str;
        this.mDisableStateInfo.mTextContent = str;
    }

    protected void calCulateMidOffset(String str) {
        this.mTextTopOffset = (this.mBtnHeight - this.mWordHeight) / 2;
        this.mTextLeftOffset = (int) ((this.mBtnWidth - this.mTextPaint.measureText(str)) / 2.0f);
    }

    void calcTextHeight() {
        Paint paint = this.mTextPaint;
        if (paint != null) {
            this.mDescent = paint.descent();
            this.mAscent = this.mTextPaint.ascent();
            this.mWordHeight = (int) Math.ceil(this.mDescent - r0);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        StateBtnInfo stateBtnInfo;
        StateBtnInfo stateBtnInfo2;
        if (!this.mIsEnable) {
            if (this.mDisableStateInfo.isHasDrawable()) {
                stateBtnInfo2 = this.mDisableStateInfo;
            } else {
                stateBtnInfo2 = this.mNormalStateInfo;
            }
            this.mCurDrawable = stateBtnInfo2.mDrawable;
            if (this.mDisableStateInfo.isHasTextContent()) {
                this.mCurShowText = this.mDisableStateInfo.mTextContent;
            } else {
                this.mCurShowText = this.mNormalStateInfo.mTextContent;
            }
            this.mTextPaint.setColor(this.mDisableStateInfo.mTextColor);
            Drawable drawable = this.mCurDrawable;
            if (drawable != null) {
                drawable.setAlpha(this.mDisableStateInfo.mDrawableAlpha);
            }
            this.mTextPaint.setAlpha(this.mDisableStateInfo.mTextAlpha);
        } else if (isPressed() && isEnablePressState()) {
            if (this.mPressStateInfo.isHasDrawable()) {
                stateBtnInfo = this.mPressStateInfo;
            } else {
                stateBtnInfo = this.mNormalStateInfo;
            }
            this.mCurDrawable = stateBtnInfo.mDrawable;
            this.mTextPaint.setColor(this.mNormalStateInfo.mTextColor);
            Drawable drawable2 = this.mCurDrawable;
            if (drawable2 != null) {
                drawable2.setAlpha(this.mPressStateInfo.mDrawableAlpha);
            }
            this.mTextPaint.setAlpha(this.mPressStateInfo.mTextAlpha);
            this.mCurShowText = this.mNormalStateInfo.mTextContent;
        } else {
            StateBtnInfo stateBtnInfo3 = this.mNormalStateInfo;
            this.mCurDrawable = stateBtnInfo3.mDrawable;
            this.mTextPaint.setColor(stateBtnInfo3.mTextColor);
            Drawable drawable3 = this.mCurDrawable;
            if (drawable3 != null) {
                drawable3.setAlpha(this.mNormalStateInfo.mDrawableAlpha);
            }
            this.mTextPaint.setAlpha(this.mNormalStateInfo.mTextAlpha);
            this.mCurShowText = this.mNormalStateInfo.mTextContent;
        }
        Drawable drawable4 = this.mCurDrawable;
        if (drawable4 != null) {
            drawable4.draw(canvas);
        }
        if (TextUtils.isEmpty(this.mCurShowText)) {
            return true;
        }
        this.mTextPaint.setTextSize(this.mTextSize);
        calCulateMidOffset(this.mCurShowText);
        canvas.drawText(this.mCurShowText, this.mTextLeftOffset, (this.mWordHeight - this.mDescent) + this.mTextTopOffset, this.mTextPaint);
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getWidth() {
        return this.mWidth;
    }

    public boolean isEnablePressState() {
        return this.mEnablePressState;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
        this.mHeight = this.mBtnHeight;
        this.mWidth = this.mBtnWidth;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean onTouchEvent(MotionEvent motionEvent, SubAreaShell subAreaShell, boolean z16) {
        if (motionEvent.getAction() == 0) {
            if (!this.mIsEnable) {
                return false;
            }
            setPressed(true);
        } else if (motionEvent.getAction() != 2) {
            if (motionEvent.getAction() == 1) {
                if (isPressed() && subAreaShell != null) {
                    subAreaShell.onAreaClicked(this, null);
                }
                setPressed(false);
            } else if (motionEvent.getAction() != 3 && motionEvent.getAction() != 4) {
                setPressed(false);
            } else {
                setPressed(false);
            }
        }
        return true;
    }

    public void setBtnAlpha(int i3) {
        this.mNormalStateInfo.mTextAlpha = i3;
        this.mPressStateInfo.mTextAlpha = i3;
        this.mDisableStateInfo.mTextAlpha = i3;
    }

    public void setBtnDisableAlpha(int i3) {
        this.mDisableStateInfo.mTextAlpha = i3;
    }

    public void setBtnDisableDrawable(int i3) {
        if (i3 != -1) {
            this.mDisableStateInfo.mDrawable = FeedGlobalEnv.getContext().getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(i3));
            this.mDisableStateInfo.mDrawable.setBounds(0, 0, this.mBtnWidth, this.mBtnHeight);
            return;
        }
        this.mDisableStateInfo.mDrawable = null;
    }

    public void setBtnHeight(int i3) {
        this.mBtnHeight = i3;
    }

    public void setBtnNormalAlpha(int i3) {
        this.mNormalStateInfo.mTextAlpha = i3;
    }

    public void setBtnNormalDrawable(int i3) {
        if (i3 != -1) {
            this.mNormalStateInfo.mDrawable = FeedGlobalEnv.getContext().getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(i3));
            this.mNormalStateInfo.mDrawable.setBounds(0, 0, this.mBtnWidth, this.mBtnHeight);
        }
    }

    public void setBtnPressAlpha(int i3) {
        this.mPressStateInfo.mTextAlpha = i3;
    }

    public void setBtnPressDrawable(int i3) {
        if (i3 != -1) {
            this.mPressStateInfo.mDrawable = FeedGlobalEnv.getContext().getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(i3));
            this.mPressStateInfo.mDrawable.setBounds(0, 0, this.mBtnWidth, this.mBtnHeight);
            return;
        }
        this.mPressStateInfo.mDrawable = null;
    }

    public void setBtnWidth(int i3) {
        this.mBtnWidth = i3;
    }

    public void setDisableText(String str) {
        this.mDisableStateInfo.mTextContent = str;
    }

    public void setDisableTextAlpha(int i3) {
        this.mDisableStateInfo.mTextAlpha = i3;
    }

    public void setDisableTextColor(int i3) {
        this.mDisableStateInfo.mTextColor = i3;
    }

    public void setEnable(boolean z16) {
        this.mIsEnable = z16;
    }

    public void setEnablePressState(boolean z16) {
        this.mEnablePressState = z16;
    }

    public void setNormalText(String str) {
        this.mNormalStateInfo.mTextContent = str;
    }

    public void setNormalTextAlpha(int i3) {
        this.mNormalStateInfo.mTextAlpha = i3;
    }

    public void setNormalTextColor(int i3) {
        this.mNormalStateInfo.mTextColor = i3;
    }

    public void setPressText(String str) {
        this.mPressStateInfo.mTextContent = str;
    }

    public void setPressTextAlpha(int i3) {
        this.mPressStateInfo.mTextAlpha = i3;
    }

    public void setPressTextColor(int i3) {
        this.mPressStateInfo.mTextColor = i3;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public void setPressed(boolean z16) {
        super.setPressed(z16);
        postInvalidate();
    }

    public void setTextAlpha(int i3) {
        this.mNormalStateInfo.mTextAlpha = i3;
        this.mPressStateInfo.mTextAlpha = i3;
        this.mDisableStateInfo.mTextAlpha = i3;
    }

    public void setTextColor(int i3) {
        this.mNormalStateInfo.mTextColor = i3;
        this.mPressStateInfo.mTextColor = i3;
        this.mDisableStateInfo.mTextColor = i3;
    }

    public void setTextSize(float f16) {
        float spValue = FeedGlobalEnv.g().getSpValue(f16);
        this.mTextSize = spValue;
        this.mTextPaint.setTextSize(spValue);
        calcTextHeight();
    }

    public TextButtonArea(int i3, float f16, int i16, int i17, Drawable drawable, Drawable drawable2, Drawable drawable3, String str, String str2, int i18, int i19) {
        this(i3, f16, i16, i17, drawable, drawable2, drawable3, 255, 128, 0, str, str2, i18, i19, 255, 128, 255);
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void clearTouchingEvent() {
        setPressed(false);
    }

    public TextButtonArea(int i3, float f16, int i16, int i17, Drawable drawable, Drawable drawable2, Drawable drawable3, int i18, int i19, int i26, String str, String str2, int i27, int i28, int i29, int i36, int i37) {
        this.mNormalStateInfo = new StateBtnInfo();
        this.mPressStateInfo = new StateBtnInfo();
        this.mDisableStateInfo = new StateBtnInfo();
        this.mIsEnable = true;
        this.mType = i3;
        this.mNormalStateInfo.init(drawable, i18, str, i29, i27);
        this.mPressStateInfo.init(drawable2, i19, null, i36, 0);
        this.mDisableStateInfo.init(drawable3, i26, str2, i37, i28);
        this.mBtnWidth = i16;
        this.mBtnHeight = i17;
        Drawable drawable4 = this.mNormalStateInfo.mDrawable;
        if (drawable4 != null) {
            drawable4.setBounds(0, 0, i16, i17);
        }
        Drawable drawable5 = this.mPressStateInfo.mDrawable;
        if (drawable5 != null) {
            drawable5.setBounds(0, 0, i16, i17);
        }
        Drawable drawable6 = this.mDisableStateInfo.mDrawable;
        if (drawable6 != null) {
            drawable6.setBounds(0, 0, i16, i17);
        }
        Paint paintForTextArea = AreaManager.getInstance().getPaintForTextArea(i3);
        this.mTextPaint = paintForTextArea;
        paintForTextArea.setColor(this.mNormalStateInfo.mTextColor);
        this.mTextPaint.setTypeface(Typeface.SANS_SERIF);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setDither(false);
        setTextSize(f16);
    }

    public void setBtnNormalDrawable(Drawable drawable) {
        if (drawable != null) {
            this.mNormalStateInfo.mDrawable = drawable;
            drawable.setBounds(0, 0, this.mBtnWidth, this.mBtnHeight);
        }
    }

    public void setBtnDisableDrawable(Drawable drawable) {
        this.mDisableStateInfo.mDrawable = drawable;
        drawable.setBounds(0, 0, this.mBtnWidth, this.mBtnHeight);
    }

    public void setBtnPressDrawable(Drawable drawable) {
        this.mPressStateInfo.mDrawable = drawable;
        drawable.setBounds(0, 0, this.mBtnWidth, this.mBtnHeight);
    }
}
