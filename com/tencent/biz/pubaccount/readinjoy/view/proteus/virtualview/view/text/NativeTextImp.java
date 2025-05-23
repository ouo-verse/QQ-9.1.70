package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.RichTextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.TruncateAttr;

/* compiled from: P */
/* loaded from: classes4.dex */
public class NativeTextImp extends TextView implements IView {
    private static final String TAG = "NativeTextImp";
    private boolean hyperLinkClick;
    protected int mBackgroundColor;
    protected Paint mBackgroundPaint;
    protected int mBorderBottomLeftRadius;
    protected int mBorderBottomRightRadius;
    protected int mBorderColor;
    protected Paint mBorderPaint;
    protected int mBorderTopLeftRadius;
    protected int mBorderTopRightRadius;
    protected int mBorderWidth;
    protected Boolean mEnableMarquee;
    protected int mFlags;
    private TruncateAttr truncateAttr;

    public NativeTextImp(Context context) {
        super(context);
        this.mBackgroundColor = 0;
        this.mBorderTopLeftRadius = 0;
        this.mBorderTopRightRadius = 0;
        this.mBorderBottomLeftRadius = 0;
        this.mBorderBottomRightRadius = 0;
        this.mBorderWidth = 0;
        this.mBorderColor = -16777216;
        this.mFlags = 1;
        this.hyperLinkClick = false;
        getPaint().setAntiAlias(true);
    }

    private void handleException(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
            MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spanned.getSpans(0, spanned.length(), MetricAffectingSpan.class);
            if (metricAffectingSpanArr != null && metricAffectingSpanArr.length > 0) {
                for (MetricAffectingSpan metricAffectingSpan : metricAffectingSpanArr) {
                    int spanStart = spannableStringBuilder.getSpanStart(metricAffectingSpan);
                    if (isNotSpace(spannableStringBuilder, spanStart - 1)) {
                        spannableStringBuilder.insert(spanStart, (CharSequence) " ");
                    }
                    int spanEnd = spannableStringBuilder.getSpanEnd(metricAffectingSpan);
                    if (isNotSpace(spannableStringBuilder, spanEnd)) {
                        spannableStringBuilder.insert(spanEnd, (CharSequence) " ");
                    }
                }
            }
            super.setText(spannableStringBuilder, bufferType);
        }
    }

    private boolean isNotSpace(CharSequence charSequence, int i3) {
        if (i3 >= 0 && i3 < charSequence.length() && charSequence.charAt(i3) == ' ') {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView
    public void comLayout(int i3, int i16, int i17, int i18) {
        onComLayout(true, i3, i16, i17, i18);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    @Override // android.view.View
    public boolean isFocused() {
        Boolean bool = this.mEnableMarquee;
        if (bool != null) {
            return bool.booleanValue();
        }
        return super.isFocused();
    }

    public boolean isHyperLinkClick() {
        return this.hyperLinkClick;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView
    public void measureComponent(int i3, int i16) {
        onComMeasure(i3, i16);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComLayout(boolean z16, int i3, int i16, int i17, int i18) {
        layout(i3, i16, i17, i18);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComMeasure(int i3, int i16) {
        measure(i3, i16);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mBackgroundColor != 0) {
            if (this.mBackgroundPaint == null) {
                Paint paint = new Paint();
                this.mBackgroundPaint = paint;
                paint.setAntiAlias(true);
            }
            this.mBackgroundPaint.setColor(this.mBackgroundColor);
            VirtualViewUtils.drawBackground(canvas, this.mBackgroundPaint, getWidth(), getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
        }
        super.onDraw(canvas);
        if (this.mBorderWidth > 0 && !TextUtils.isEmpty(getText())) {
            if (this.mBorderPaint == null) {
                Paint paint2 = new Paint();
                this.mBorderPaint = paint2;
                paint2.setStyle(Paint.Style.STROKE);
                this.mBorderPaint.setAntiAlias(true);
            }
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(this.mBorderColor);
            VirtualViewUtils.drawBorder(canvas, this.mBorderPaint, getWidth(), getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z16, int i3, Rect rect) {
        Boolean bool = this.mEnableMarquee;
        if (bool != null) {
            super.onFocusChanged(bool.booleanValue(), i3, rect);
        } else {
            super.onFocusChanged(z16, i3, rect);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        TruncateAttr truncateAttr = this.truncateAttr;
        if (truncateAttr != null) {
            RichTextUtils.addEllipsis2Text(this, truncateAttr);
            RichTextUtils.adjustImageSpan(this, this.truncateAttr);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z16) {
        Boolean bool = this.mEnableMarquee;
        if (bool != null) {
            super.onWindowFocusChanged(bool.booleanValue());
        } else {
            super.onWindowFocusChanged(z16);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        this.mBackgroundColor = i3;
    }

    public void setBorderBottomLeftRadius(int i3) {
        this.mBorderBottomLeftRadius = i3;
    }

    public void setBorderBottomRightRadius(int i3) {
        this.mBorderBottomRightRadius = i3;
    }

    public void setBorderColor(int i3) {
        this.mBorderColor = i3;
    }

    public void setBorderTopLeftRadius(int i3) {
        this.mBorderTopLeftRadius = i3;
    }

    public void setBorderTopRightRadius(int i3) {
        this.mBorderTopRightRadius = i3;
    }

    public void setBorderWidth(int i3) {
        this.mBorderWidth = i3;
    }

    public void setEnableMarquee(boolean z16) {
        Boolean valueOf = Boolean.valueOf(z16);
        this.mEnableMarquee = valueOf;
        if (valueOf.booleanValue()) {
            setSingleLine();
            setMarqueeRepeatLimit(-1);
            setFocusable(true);
            setHorizontallyScrolling(true);
            setEllipsize(TextUtils.TruncateAt.MARQUEE);
        }
    }

    public void setHyperLinkClick(boolean z16) {
        this.hyperLinkClick = z16;
    }

    @Override // android.widget.TextView
    public void setPaintFlags(int i3) {
        if (this.mFlags == i3) {
            return;
        }
        super.setPaintFlags(i3);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        try {
            super.setText(charSequence, bufferType);
        } catch (IndexOutOfBoundsException e16) {
            LogUtil.QLog.e(TAG, 1, "handleException error! msg=" + e16);
        }
    }

    public void setTruncateAttr(TruncateAttr truncateAttr) {
        this.truncateAttr = truncateAttr;
    }
}
