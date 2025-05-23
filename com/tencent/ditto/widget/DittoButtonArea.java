package com.tencent.ditto.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ditto.annoations.SourceCode.DittoJsonElement;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoLog;
import com.tencent.ditto.utils.DittoResourcesUtil;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoButtonArea extends DittoArea {

    @DittoJsonElement("\u70b9\u51fb\u6001\u989c\u8272")
    public static final String PressBgColor = "press_bg_color";

    @DittoJsonElement
    public static final String Text = "text";

    @DittoJsonElement
    public static final String TextColor = "text_color";

    @DittoJsonElement
    public static final String TextSize = "text_size";
    private CharSequence mText;
    private int mTextColor;
    private TextPaint mTextPaint;
    private int mTextSize;
    private Drawable normalStateDrawable;
    private int pressBgColor;
    private GradientDrawable pressedDrawable;
    private Drawable pressedStateDrawable;
    private boolean showClickState;

    public DittoButtonArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.showClickState = false;
        this.pressBgColor = 0;
        this.mTextColor = -16777216;
        this.mTextSize = 15;
        this.mText = "";
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setAntiAlias(true);
        setBorderColor(-13750738);
        setBorderWidth(1);
        setAttr(layoutAttrSet);
    }

    private GradientDrawable getPressedDrawable() {
        if (this.pressedDrawable == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.pressedDrawable = gradientDrawable;
            gradientDrawable.setColor(this.pressBgColor);
        }
        return this.pressedDrawable;
    }

    private Drawable getPressedStateDrawable() {
        Drawable drawable = this.pressedStateDrawable;
        if (drawable != null) {
            return drawable;
        }
        if (this.pressedDrawable == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.pressedDrawable = gradientDrawable;
            gradientDrawable.setColor(this.pressBgColor);
        }
        return this.pressedDrawable;
    }

    private void setAttr(LayoutAttrSet layoutAttrSet) {
        if (layoutAttrSet != null) {
            if (layoutAttrSet.getAttr(PressBgColor, (String) null) != null) {
                String attr = layoutAttrSet.getAttr(PressBgColor, (String) null);
                try {
                    setPressBgColor(DittoResourcesUtil.parseColor(attr));
                    this.showClickState = true;
                } catch (Throwable th5) {
                    DittoLog.e(DittoLog.defaultTag, "the text " + attr + " can't be parsed as color string", th5);
                }
            }
            if (layoutAttrSet.getAttr("text_color", (String) null) != null) {
                String attr2 = layoutAttrSet.getAttr("text_color", (String) null);
                if (!TextUtils.isEmpty(attr2)) {
                    try {
                        int parseColor = DittoResourcesUtil.parseColor(attr2);
                        this.mTextColor = parseColor;
                        this.mTextPaint.setColor(parseColor);
                    } catch (Throwable th6) {
                        DittoLog.e(DittoLog.defaultTag, "the text " + attr2 + " can't be parsed as color string", th6);
                    }
                }
            }
            if (layoutAttrSet.hasAttr("text_size")) {
                int attr3 = layoutAttrSet.getAttr("text_size", 15);
                this.mTextSize = attr3;
                setTextSize(attr3);
            }
            if (layoutAttrSet.getAttr("text", (String) null) != null) {
                String attr4 = layoutAttrSet.getAttr("text", (String) null);
                if (!TextUtils.isEmpty(attr4)) {
                    this.mText = attr4;
                }
            }
        }
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Drawable normalBackgroundDrawable;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (this.showClickState) {
            if (this.isPressed) {
                normalBackgroundDrawable = getPressedStateDrawable();
            } else {
                normalBackgroundDrawable = getNormalBackgroundDrawable();
            }
            setBackgroundDrawable(normalBackgroundDrawable);
            invalidate();
        }
        return dispatchTouchEvent;
    }

    public Drawable getNormalBackgroundDrawable() {
        return this.normalStateDrawable;
    }

    public int getPressBgColor() {
        return this.pressBgColor;
    }

    public String getText() {
        CharSequence charSequence = this.mText;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return "";
    }

    public boolean getTextBold(boolean z16) {
        return this.mTextPaint.isFakeBoldText();
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        int paddingTop = (this.height - getPaddingTop()) - getPaddingBottom();
        int paddingLeft = (this.width - getPaddingLeft()) - getPaddingRight();
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        float f16 = fontMetrics.bottom;
        float f17 = paddingTop;
        canvas.drawText(this.mText.toString(), paddingLeft / 2, (f17 - ((f17 - (f16 - fontMetrics.top)) / 2.0f)) - f16, this.mTextPaint);
        super.onDraw(canvas);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onLayout(int i3, int i16, int i17, int i18) {
        super.onLayout(i3, i16, i17, i18);
        if (this.pressBgColor != 0) {
            getPressedDrawable().setBounds(new Rect(0, 0, this.width, this.height));
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        getPaddingLeft();
        getPaddingRight();
        if (mode != 1073741824) {
            int desiredWidth = (int) Layout.getDesiredWidth(this.mText, this.mTextPaint);
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(size, desiredWidth);
            } else {
                size = desiredWidth;
            }
        }
        if (mode2 != 1073741824) {
            Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
            int i17 = fontMetricsInt.bottom - fontMetricsInt.top;
            if (mode2 == Integer.MIN_VALUE) {
                size2 = Math.min(size2, i17);
            } else {
                size2 = i17;
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void setBorderColor(int i3) {
        getPressedDrawable().setStroke(this.borderWidth, i3);
        super.setBorderColor(i3);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void setBorderRadius(int i3) {
        getPressedDrawable().setCornerRadius(i3);
        super.setBorderRadius(i3);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void setBorderWidth(int i3) {
        getPressedDrawable().setStroke(i3, this.borderColor);
        super.setBorderWidth(i3);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void setLayoutAttr(LayoutAttrSet layoutAttrSet) {
        super.setLayoutAttr(layoutAttrSet);
        setAttr(layoutAttrSet);
    }

    public void setNormalBackgroundDrawable(Drawable drawable) {
        this.normalStateDrawable = drawable;
        setBackgroundDrawable(drawable);
    }

    public void setPressBgColor(int i3) {
        this.pressBgColor = i3;
        if (i3 == -1) {
            this.pressedDrawable = null;
            this.showClickState = false;
        } else {
            getPressedDrawable().setColor(i3);
        }
    }

    public void setPressedDrawable(Drawable drawable) {
        boolean z16;
        this.pressedStateDrawable = drawable;
        if (drawable != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.showClickState = z16;
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.mText = charSequence;
        requestLayout();
    }

    public void setTextBold(boolean z16) {
        this.mTextPaint.setFakeBoldText(z16);
    }

    public void setTextColor(int i3) {
        this.mTextColor = i3;
        this.mTextPaint.setColor(i3);
    }

    public void setTextSize(float f16) {
        setTextSize(2, f16);
    }

    public void setTextSize(int i3, float f16) {
        float applyDimension = TypedValue.applyDimension(i3, f16, getContext().getResources().getDisplayMetrics());
        if (this.mTextPaint.getTextSize() == applyDimension) {
            return;
        }
        this.mTextPaint.setTextSize(applyDimension);
        requestLayout();
    }
}
